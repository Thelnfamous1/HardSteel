package com.infamous.hard_steel.anvil;

import com.infamous.hard_steel.anvil.items.AnvilUtilities;
import com.infamous.hard_steel.config.GeneralModConfig;
import com.infamous.hard_steel.smithingtable.SmithingTableContainer;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.CraftResultInventory;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.Slot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IWorldPosCallable;
import net.minecraft.util.IntReferenceHolder;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.AnvilUpdateEvent;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.SlotItemHandler;
import net.minecraftforge.items.wrapper.InvWrapper;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ForgingContainer extends Container {
  private static final Logger LOGGER = LogManager.getLogger();
  private final IInventory outputSlot = new CraftResultInventory();
  private final IInventory inputSlots = new Inventory(2) {
    /**
     * For tile entities, ensures the chunk containing the tile entity is saved to disk later - the game won't think
     * it hasn't changed and skip it.
     */
    public void markDirty() {
      super.markDirty();
      ForgingContainer.this.onCraftMatrixChanged(this);
    }
  };
  private final IntReferenceHolder maximumCost = IntReferenceHolder.single();
  private final IWorldPosCallable iWorldPosCallable;
  public int materialCost;
  private String repairedItemName;
  private final PlayerEntity player;

  public ForgingContainer(int p_i50101_1_, PlayerInventory playerInventory) {
    this(p_i50101_1_, playerInventory, IWorldPosCallable.DUMMY);
  }

  public ForgingContainer(int windowId, PlayerInventory playerInventory, final IWorldPosCallable iWorldPosCallable) {

    super(AnvilRegistryEvents.ANVIL_CONTAINER, windowId);
    this.iWorldPosCallable = iWorldPosCallable;
    this.player = playerInventory.player;
    this.trackInt(this.maximumCost);
    this.addSlot(new Slot(this.inputSlots, 0, 27, 47));
    this.addSlot(new Slot(this.inputSlots, 1, 76, 47));
    this.addSlot(new Slot(this.outputSlot, 2, 134, 47) {
      /**
       * Check if the stack is allowed to be placed in this slot, used for armor slots as well as furnace fuel.
       */
      @Override
      public boolean isItemValid(ItemStack stack) {
        return false;
      }

      /**
       * Return whether this slot's stack can be taken from this slot.
       */
      @Override
      public boolean canTakeStack(PlayerEntity playerIn) {
        return (playerIn.abilities.isCreativeMode || playerIn.experienceLevel >= ForgingContainer.this.maximumCost.get()) && ForgingContainer.this.maximumCost.get() > 0 && this.getHasStack();
      }

      @Override
      public ItemStack onTake(PlayerEntity thePlayer, ItemStack stack) {
        if (!thePlayer.abilities.isCreativeMode) {
          thePlayer.addExperienceLevel(-ForgingContainer.this.maximumCost.get());
        }

        //double breakChance = net.minecraftforge.common.ForgeHooks.onAnvilRepair(thePlayer, stack, tileEntity.handler.getStackInSlot(0), tileEntity.handler.getStackInSlot(1)) * (GeneralModConfig.anvil_damage_chance.get() / .12);

        //if (!GeneralModConfig.anvil_damageable.get()) breakChance = 0;

        ForgingContainer.this.inputSlots.setInventorySlotContents(0, ItemStack.EMPTY);

        ForgingContainer.this.maximumCost.set(0);
          //BlockState blockstate = world.getBlockState(readBlockPos);
          if (!thePlayer.abilities.isCreativeMode
                  //&& blockstate.isIn(BlockTags.ANVIL) && thePlayer.getRNG().nextFloat() < breakChance
          ) {
            //BlockState blockstate1 = AnvilBlockv2.damage(blockstate);
            //if (blockstate1 == null) {
             // world.removeBlock(readBlockPos, false);
             // world.playEvent(1029, readBlockPos, 0);
            //} else {
              //world.setBlockState(readBlockPos, blockstate1, 2);
              player.world.playEvent(1030, player.getPosition(), 0);
            //}
          } else {
            player.world.playEvent(1030, player.getPosition(), 0);
          }



        return stack;
      }
    });

    for (int i = 0; i < 3; ++i) {
      for (int j = 0; j < 9; ++j) {
        this.addSlot(new Slot(playerInventory, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
      }
    }

    for (int k = 0; k < 9; ++k) {
      this.addSlot(new Slot(playerInventory, k, 8 + k * 18, 142));
    }
   // updateRepairOutput();
  }



  /**
   * Callback for when the crafting matrix is changed.
   */
  @Override
  public void onCraftMatrixChanged(IInventory inventoryIn) {
    super.onCraftMatrixChanged(inventoryIn);
      this.updateForgingOutput();
  }

  /**
   * called when the Anvil Input Slot changes, calculates the new result and puts it in the output slot
   */
  public void updateForgingOutput() {
    ItemStack workableMetalAmount = this.inputSlots.getStackInSlot(0);
    ItemStack itemstack2 = this.inputSlots.getStackInSlot(1);
    this.maximumCost.set(0);
    int i = 0;
    int k = 0;
    if (workableMetalAmount.isEmpty()) {
      this.outputSlot.setInventorySlotContents(0, ItemStack.EMPTY);
      this.maximumCost.set(0);
    }

    Item blueprint = itemstack2.getItem();
    ItemStack result = new ItemStack(AnvilUtilities.getForgingResult(workableMetalAmount, blueprint), 1);
    // Setting Initial Forging Cost without Renaming
    this.maximumCost.set(this.maximumCost.get() + AnvilUtilities.getForgingCost(workableMetalAmount, blueprint));
    this.outputSlot.setInventorySlotContents(0, result);


    if (!result.isEmpty()){
      ItemStack renamedResult = result.copy();

      // Naming
      if (StringUtils.isBlank(this.repairedItemName)) {
        if (result.hasDisplayName()) {
          k = 1;
          i += k;
          renamedResult.clearCustomName();
        }
      } else if (!this.repairedItemName.equals(result.getDisplayName().getString())) {
        k = 1;
        i += k;
        // the display name can actually be set to "this.repairedItemName" by default instead of this.repairedItemName
        renamedResult.setDisplayName(new StringTextComponent(this.repairedItemName));
      }

      // Forging Cost with Renaming
      if (k == i && k > 0 && (this.maximumCost.get() >= GeneralModConfig.anvil_repair_cost_cap.get() || GeneralModConfig.anvil_cheap_renaming.get())) {
        this.maximumCost.set(this.maximumCost.get() + (GeneralModConfig.anvil_cheap_renaming.get() ? 1: GeneralModConfig.anvil_repair_cost_cap.get() - 1));
      }

      if (this.maximumCost.get() >= GeneralModConfig.anvil_repair_cost_cap.get() && !this.player.abilities.isCreativeMode) {
        renamedResult = ItemStack.EMPTY;
      }


      this.outputSlot.setInventorySlotContents(0, renamedResult);
    }


    this.detectAndSendChanges();
  }

  public static int getRepairCost(ItemStack stack){
    return GeneralModConfig.anvil_prior_work_penalty.get() ? stack.getRepairCost() : 0;
  }

  public static int func_216977_d(int p_216977_0_) {
    return p_216977_0_ * 2 + 1;
  }

  /**
   * Called when the container is closed.
   */
  @Override
  public void onContainerClosed(PlayerEntity playerIn) {
    super.onContainerClosed(playerIn);
    this.iWorldPosCallable.consume((p_216973_2_, p_216973_3_) -> {
      this.clearContainer(playerIn, p_216973_2_, this.inputSlots);
    });
  }

  /**
   * Determines whether supplied player can use this container
   */
  @Override
  public boolean canInteractWith(PlayerEntity playerIn) {
    //HardSteel.logger.info("Within Usable Distance? " + isWithinUsableDistance(this.iWorldPosCallable, playerIn, SmithingTableRegistryEvents.SMITHING_TABLE));
    return isWithinUsableDistance(this.iWorldPosCallable, playerIn, AnvilRegistryEvents.ANVIL);
  }

  /**
   * Handle when the stack in slot {@code index} is shift-clicked. Normally this moves the stack between the player
   * inventory and the other inventory(s).
   */
  @Override
  public ItemStack transferStackInSlot(PlayerEntity playerIn, int index) {
    ItemStack itemstack = ItemStack.EMPTY;
    Slot slot = this.inventorySlots.get(index);
    if (slot != null && slot.getHasStack()) {
      ItemStack itemstack1 = slot.getStack();
      itemstack = itemstack1.copy();
      if (index == 2) {
        if (!this.mergeItemStack(itemstack1, 3, 39, true)) {
          return ItemStack.EMPTY;
        }

        slot.onSlotChange(itemstack1, itemstack);
      } else if (index != 0 && index != 1) {
        if (index < 39 && !this.mergeItemStack(itemstack1, 0, 2, false)) {
          return ItemStack.EMPTY;
        }
      } else if (!this.mergeItemStack(itemstack1, 3, 39, false)) {
        return ItemStack.EMPTY;
      }

      if (itemstack1.isEmpty()) {
        slot.putStack(ItemStack.EMPTY);
      } else {
        slot.onSlotChanged();
      }

      if (itemstack1.getCount() == itemstack.getCount()) {
        return ItemStack.EMPTY;
      }

      slot.onTake(playerIn, itemstack1);
    }

    return itemstack;
  }

  /**
   * used by the Anvil GUI to update the Item Name being typed by the player
   */
  public void updateItemName(String newName) {
    this.repairedItemName = newName;
    if (this.getSlot(2).getHasStack()) {
      ItemStack itemstack = this.getSlot(2).getStack();
      if (StringUtils.isBlank(newName)) {
        itemstack.clearCustomName();
      } else {
        itemstack.setDisplayName(new StringTextComponent(this.repairedItemName));
      }
    }
    this.updateForgingOutput();
  }

  public int getMaxCost() {
    return this.maximumCost.get();
  }

  /** unused*/
  public void setMaximumCost(int value) {
    this.maximumCost.set(value);
  }

  public static boolean onAnvilChange(ForgingContainer container, ItemStack left, ItemStack right, IInventory outputSlot, String name, int baseCost) {
    AnvilUpdateEvent e = new AnvilUpdateEvent(left, right, name, baseCost);
    if (MinecraftForge.EVENT_BUS.post(e)) return false;
    if (e.getOutput().isEmpty()) return true;

    outputSlot.setInventorySlotContents(0, e.getOutput());
    container.maximumCost.set(e.getCost());
    container.materialCost = e.getMaterialCost();
    return false;
  }
}

