package com.infamous.hard_steel.crucible;

import com.infamous.hard_steel.crucible.items.CrucibleUtilities;
import com.infamous.hard_steel.proxy.IHardSteelRecipeType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipeType;
import net.minecraft.util.IIntArray;
import net.minecraft.util.IntArray;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;


public class CrucibleContainer extends Container {
    private final IInventory machineInventory;
    private IIntArray machineData;
    private BlockPos tePos;
    private final World world;

    public CrucibleContainer(int id, PlayerInventory playerInventoryIn) {
        this(id, playerInventoryIn, new IntArray(5), new Inventory(4), null);
    }

    public CrucibleContainer(int id, PlayerInventory playerInventoryIn, IIntArray machineData, IInventory machineInv, BlockPos tePos) {
        super(CrucibleRegistryEvents.CRUCIBLE_CONTAINER, id);
        this.tePos = tePos;
        this.machineInventory = machineInv;
        this.machineData = machineData;
        this.world = playerInventoryIn.player.world;

        addSlot(new Slot(machineInv, 0, 56, 53));
        addSlot(new Slot(machineInv, 1, 45, 17));
        addSlot(new Slot(machineInv, 2, 67, 17));
        addSlot(new CrucibleResultSlot(playerInventoryIn.player, machineInv, 3, 116, 35));
        layoutPlayerInventorySlots(playerInventoryIn, 8, 84);

        this.trackIntArray(machineData);
    }

    @Override
    public boolean canInteractWith(PlayerEntity playerIn) {
        return this.machineInventory.isUsableByPlayer(playerIn);
    }

    @Override
    public ItemStack transferStackInSlot(PlayerEntity playerIn, int index) {
        ItemStack itemstack = ItemStack.EMPTY;
        Slot slot = this.inventorySlots.get(index);
        if (slot != null && slot.getHasStack()) {
            ItemStack stack = slot.getStack();
            itemstack = stack.copy();


            if (index == 0 || index == 1 || index == 2 || index == 3) {
                if (!this.mergeItemStack(stack, 4, 40, true)) {
                    return ItemStack.EMPTY;
                }
                slot.onSlotChange(stack, itemstack);
            } else {
                //HardSteel.logger.info("Tried to transfer " + stack.toString());
                if (net.minecraft.tileentity.AbstractFurnaceTileEntity.isFuel(stack)) {
                    if (!this.mergeItemStack(stack, 0, 1, false)) {
                        return ItemStack.EMPTY;
                    }
                } else if(CrucibleUtilities.isCast(stack)) {
                    if (!this.mergeItemStack(stack, 1, 2, false)) {
                        return ItemStack.EMPTY;
                    }
                }
                // hasRecipe issue for bronze blend -> bronze ingot
                else if(this.hasRecipe(stack) || CrucibleUtilities.isCastable(stack)) {
                    if (!this.mergeItemStack(stack, 2, 3, false)) {
                        return ItemStack.EMPTY;
                    }
                } else if (index < 31) {
                    if (!this.mergeItemStack(stack, 31, 40, false)) {
                        return ItemStack.EMPTY;
                    }
                } else if (index < 40 && !this.mergeItemStack(stack, 4, 31, false)) {
                    return ItemStack.EMPTY;
                }
            }
            if (stack.isEmpty()) {
                slot.putStack(ItemStack.EMPTY);
            } else {
                slot.onSlotChanged();
            }
            if (stack.getCount() == itemstack.getCount()) {
                return ItemStack.EMPTY;
            }
            slot.onTake(playerIn, stack);
        }
        return itemstack;
    }

    // for some reason the json file for bronze blend -> bronze ingot recipes are not being recognized
    private boolean hasRecipe(ItemStack stack) {
        //boolean flag = false;
        //for(ItemStack s : this.getInventory()) {
        //    if(s.getItem() == ItemList.limestone) {
         //       flag = this.world.getRecipeManager().getRecipe((IRecipeType<CastingRecipe>)IHardSteelRecipeType.CASTING, new Inventory(ItemStack.EMPTY, new ItemStack(ItemList.limestone), stack), this.world).isPresent();
         //   }
        //}
        //HardSteel.logger.info("Does this item have a recipe? " + this.world.getRecipeManager().getRecipe((IRecipeType<CastingRecipe>)IHardSteelRecipeType.CASTING, new Inventory(ItemStack.EMPTY, ItemStack.EMPTY, stack), this.world).isPresent());
        return this.world.getRecipeManager().getRecipe((IRecipeType<AlloyingRecipe>)IHardSteelRecipeType.ALLOYING, new Inventory(ItemStack.EMPTY, ItemStack.EMPTY, stack), this.world).isPresent();
        //flag ||
    }

    private int addSlotRange(PlayerInventory playerInventory, int index, int x, int y, int amount, int dx) {
        for (int i = 0 ; i < amount ; i++) {
            this.addSlot(new Slot(playerInventory, index, x, y));
            x += dx;
            index++;
        }
        return index;
    }

    private int addSlotBox(PlayerInventory playerInventory, int index, int x, int y, int horAmount, int dx, int verAmount, int dy) {
        for (int j = 0 ; j < verAmount ; j++) {
            index = addSlotRange(playerInventory, index, x, y, horAmount, dx);
            y += dy;
        }
        return index;
    }

    private void layoutPlayerInventorySlots(PlayerInventory playerInventory, int leftCol, int topRow) {
        addSlotBox(playerInventory, 9, leftCol, topRow, 9, 18, 3, 18);
        topRow += 58;
        addSlotRange(playerInventory, 0, leftCol, topRow, 9, 18);
    }

    public int getArrowProgression() {
        int i = hasBeenProcessingFor();
        int j = this.machineData.get(3);

        return j != 0 && i != 0 ? i * 24 / j : 0;
    }

    public int getFireProgression() {
        int i = this.machineData.get(4);
        if(i == 0) i = 200;
        return getFuelLeft() * 13 / i;
    }

    public boolean isProcessingOre() {
        return this.hasBeenProcessingFor()>0;
    }

    public int hasBeenProcessingFor() {
        return this.machineData.get(0);
    }

    public int getSecondCounter() {
        return this.machineData.get(2);
    }

    public int getFuelLeft() {
        return this.machineData.get(1);
    }
}

