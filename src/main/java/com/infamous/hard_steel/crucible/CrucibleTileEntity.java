package com.infamous.hard_steel.crucible;

import javax.annotation.Nullable;

import com.infamous.hard_steel.HardSteel;
import com.infamous.hard_steel.crucible.items.CrucibleUtilities;
import com.infamous.hard_steel.proxy.IHardSteelRecipeType;
import net.minecraft.block.BlockState;
import net.minecraft.entity.item.ExperienceOrbEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.IRecipeType;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.tileentity.*;
import net.minecraft.util.Direction;
import net.minecraft.util.IIntArray;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;

import static com.infamous.hard_steel.crucible.items.CrucibleUtilities.*;

public class CrucibleTileEntity extends TileEntity implements ITickableTileEntity, INamedContainerProvider, ISidedInventory {
    private NonNullList<ItemStack> items = NonNullList.withSize(SIZE, ItemStack.EMPTY);
    private static final int SIZE = 4;
    private static final int[] OUTPUT_SLOTS = {3};
    private static final int[] INPUT_SLOTS = {0, 1, 2};
    private String itemBeingSmelted = "empty";
    private int secondCounter = 0;
    private int hasBeenSmeltedFor = 0;
    private int fuelTimeLeft;
    private ResourceLocation recipeLocation;
    private final IRecipeType<? extends AlloyingRecipe> recipeType;
    private int smeltingTimeNeeded;
    private int itemBurnTime;
    private float totalExperience;

    protected final IIntArray data = new IIntArray() {
        public int get(int index) {
            switch(index) {
                case 0:
                    return CrucibleTileEntity.this.hasBeenSmeltedFor;
                case 1:
                    return CrucibleTileEntity.this.fuelTimeLeft;
                case 2:
                    return CrucibleTileEntity.this.secondCounter;
                case 3:
                    return CrucibleTileEntity.this.smeltingTimeNeeded;
                case 4:
                    return CrucibleTileEntity.this.itemBurnTime;
                default:
                    return 0;
            }
        }

        public void set(int index, int value) {
            switch(index) {
                case 0:
                    CrucibleTileEntity.this.hasBeenSmeltedFor = value;
                    break;
                case 1:
                    CrucibleTileEntity.this.fuelTimeLeft = value;
                    break;
                case 2:
                    CrucibleTileEntity.this.secondCounter = value;
                    break;
                case 3:
                    CrucibleTileEntity.this.smeltingTimeNeeded = value;
                    break;
                case 4:
                    CrucibleTileEntity.this.itemBurnTime = value;
                    break;
            }
        }

        public int size() {
            return 5;
        }
    };

    public CrucibleTileEntity() {
        super(CrucibleRegistryEvents.CRUCIBLE_TILEENTITY);
        this.recipeType = IHardSteelRecipeType.ALLOYING;
    }

    @Nullable
    @Override
    public Container createMenu(int i, PlayerInventory playerInv, PlayerEntity p_createMenu_3_) {
        return new CrucibleContainer(i, playerInv, this.data, this, this.pos);
    }

    @Override
    public int getSizeInventory() {
        return SIZE;
    }

    @Override
    public boolean isEmpty() {
        for(ItemStack itemstack : this.items) {
            if (!itemstack.isEmpty()) {
                return false;
            }
        }
        return true;
    }

    @Override
    public ItemStack getStackInSlot(int index) {
        return this.items.get(index);
    }

    @Override
    public ItemStack decrStackSize(int index, int count) {
        return ItemStackHelper.getAndSplit(this.items, index, count);
    }

    @Override
    public ItemStack removeStackFromSlot(int index) {
        return ItemStackHelper.getAndRemove(this.items, index);
    }

    @Override
    public void setInventorySlotContents(int index, ItemStack stack) {
        this.items.set(index, stack);
        if (stack.getCount() > this.getInventoryStackLimit()) {
            stack.setCount(this.getInventoryStackLimit());
        }
    }

    @Override
    public boolean isUsableByPlayer(PlayerEntity player) {
        if (this.world.getTileEntity(this.pos) != this) {
            return false;
        } else {
            return player.getDistanceSq((double)this.pos.getX() + 0.5D, (double)this.pos.getY() + 0.5D, (double)this.pos.getZ() + 0.5D) <= 64.0D;
        }
    }

    @Override
    public void clear() {
        this.items.clear();
    }

    @Override
    public int[] getSlotsForFace(Direction side) {
        if(side == Direction.DOWN) {
            return OUTPUT_SLOTS;
        } else {
            return INPUT_SLOTS;
        }
    }

    public boolean isItemValidForSlot(int index, ItemStack stack) {
        if(index == 0 && AbstractFurnaceTileEntity.isFuel(stack)) {
            return true;
        } else if(index == 1 && isCast(stack)) {
            return true;
        } else if(index == 2) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean canInsertItem(int index, ItemStack itemStackIn, Direction direction) {
        return isItemValidForSlot(index, itemStackIn);
    }

    @Override
    public boolean canExtractItem(int index, ItemStack stack, Direction direction) {
        if((index > 2)) {
            return true;
        }
        return false;
    }

    @Override
    public ITextComponent getDisplayName() {
        return new TranslationTextComponent("Crucible");
    }

    @Override
    public void tick() {
        if(!world.isRemote) {
            if(!hasFuel()) {
                ItemStack fuelStack = items.get(0);
                // This only matters for fuel, so disregard for debugging casting system issues
                if(this.hasBeenSmeltedFor > 0) {
                    if(AbstractFurnaceTileEntity.isFuel(fuelStack)) {
                        this.fuelTimeLeft = getBurnTimes(fuelStack);
                        this.itemBurnTime = getBurnTimes(fuelStack);
                        if(fuelStack.hasContainerItem()) {
                            this.items.set(0, fuelStack.getContainerItem());
                        } else if(!fuelStack.isEmpty()) {
                            fuelStack.shrink(1);
                            if(fuelStack.isEmpty()) {
                                this.items.set(0, fuelStack.getContainerItem());
                            }
                        }
                    } else {
                        turnOff();
                    }
                }
                // this is where the crucible has to figure out whether to follow a JSON recipe or a casting system recipe
                else {
                    AlloyingRecipe recipe = this.world.getRecipeManager().getRecipe(IHardSteelRecipeType.ALLOYING, this, this.world).orElse(null);
                    // this first if statement will only be used for regular smelting-style recipes given by JSON
                    if(AbstractFurnaceTileEntity.isFuel(fuelStack) && canAlloy(recipe)) {
                        if(this.items.get(3).isEmpty() || (this.items.get(3).getItem() == recipe.getRecipeOutput(3).getItem() && this.items.get(3).getCount() != this.items.get(3).getMaxStackSize())){
                            //if(recipe.isCastingRecipe()) {
                            //if(this.secondCounter == 0) {
                            //this.items.get(1).shrink(1);
                            //this.secondCounter = 200; // 100 originally
                            //}
                            //}


                            //this.secondCounter = 0;
                            CrucibleUtilities.setLastSmeltedMetal(new ItemStack(Items.AIR));
                            CrucibleUtilities.setLastSmeltedCast(new ItemStack(Items.AIR));

                            this.fuelTimeLeft = getBurnTimes(fuelStack);
                            this.itemBurnTime = getBurnTimes(fuelStack);
                            this.recipeLocation = recipe.getId();
                            this.smeltingTimeNeeded = recipe.getCookingTime();
                            if(fuelStack.hasContainerItem()) {
                                this.items.set(0, fuelStack.getContainerItem());
                            } else if(!fuelStack.isEmpty()) {
                                fuelStack.shrink(1);
                                if(fuelStack.isEmpty()) {
                                    this.items.set(0, fuelStack.getContainerItem());
                                }
                            }
                            ItemStack itemBeingRefinedLocal = items.get(2);
                            if(!itemBeingRefinedLocal.isEmpty()) {
                                this.itemBeingSmelted = itemBeingRefinedLocal.getItem().getTranslationKey();
                                itemBeingRefinedLocal.shrink(1);
                            }
                            markDirty();
                        }
                    }
                    // check if you have supplied valid fuel, and the inputs have a valid casting system result
                    else if(AbstractFurnaceTileEntity.isFuel(fuelStack) &&
                            CrucibleUtilities.hasCastingResult(items.get(2), items.get(1).getItem())) {

                        if(this.items.get(3).isEmpty()){
                            //HardSteel.logger.info("Followed the casting system if statement for without fuel");
                            int castingCost = CrucibleUtilities.getCastingCost(this.items.get(1));
                            //if(recipe.isCastingRecipe()) {
                            if(this.secondCounter == 0) {
                                CrucibleUtilities.setLastSmeltedCast(this.items.get(1).copy());
                                this.items.get(1).shrink(1);
                                this.secondCounter = 200;
                                //* castingCost; // 100 originally
                            }
                            //}
                            this.fuelTimeLeft = getBurnTimes(fuelStack);
                            this.itemBurnTime = getBurnTimes(fuelStack);
                            this.recipeLocation = null;
                            this.smeltingTimeNeeded = 200;
                            //* castingCost;
                            if(fuelStack.hasContainerItem()) {
                                this.items.set(0, fuelStack.getContainerItem());
                            } else if(!fuelStack.isEmpty()) {
                                fuelStack.shrink(1);
                                if(fuelStack.isEmpty()) {
                                    this.items.set(0, fuelStack.getContainerItem());
                                }
                            }
                            ItemStack itemBeingRefinedLocal = items.get(2);
                            if(!itemBeingRefinedLocal.isEmpty()) {
                                this.itemBeingSmelted = itemBeingRefinedLocal.getItem().getTranslationKey();
                                CrucibleUtilities.setLastSmeltedMetal(itemBeingRefinedLocal.copy());
                                itemBeingRefinedLocal.shrink(castingCost);
                            }
                            markDirty();
                        }
                    }
                    else {
                        turnOff();
                    }
                }
            }
            if(hasFuel()) {
                if(!this.itemBeingSmelted.equals("empty")) {
                    BlockState blockState = world.getBlockState(pos);
                    world.setBlockState(pos, blockState.with(CrucibleBlock.LIT, true), 3);
                    this.fuelTimeLeft--;
                    this.hasBeenSmeltedFor++;

                    //if(this.recipeLocation != null){
                        // Without this if/else, gives NPE "Ticking block entity"
                        //if(this.recipeLocation.getPath().contains("casting")) this.secondCounter--;
                    //}
                    //else{
                        if(hasCastingResult(CrucibleUtilities.getLastSmeltedMetal(), CrucibleUtilities.getLastSmeltedCast().getItem())){
                            this.secondCounter--;
                        }
                    //}
                    //HardSteel.logger.info("Second counter is at " + this.secondCounter);

                    if(this.hasBeenSmeltedFor >= this.smeltingTimeNeeded) {
                        AlloyingRecipe r = (AlloyingRecipe) this.world.getRecipeManager().getRecipe(this.recipeLocation).orElse(null);
                        checkRecipeAndSpawnOutput(r);
                        checkCastingRecipeAndSpawnOutput(CrucibleUtilities.getLastSmeltedMetal(), CrucibleUtilities.getLastSmeltedCast().getItem());
                        //HardSteel.logger.info("Tried to spawn output for " + CrucibleUtilities.getLastSmeltedMetal().toString() + " and " + CrucibleUtilities.getLastSmeltedCast().getItem().toString());
                        //HardSteel.logger.info("Should have gotten " + getCastingResult(CrucibleUtilities.getLastSmeltedMetal(), CrucibleUtilities.getLastSmeltedCast().getItem()).toString());
                        this.hasBeenSmeltedFor = 0;
                        this.itemBeingSmelted = "empty";
                        markDirty();
                    }
                } else {
                    AlloyingRecipe recipe = this.world.getRecipeManager().getRecipe(IHardSteelRecipeType.ALLOYING, this, this.world).orElse(null);
                    if(canAlloy(recipe)) {
                        if(this.items.get(3).isEmpty() || (this.items.get(3).getItem() == recipe.getRecipeOutput(3).getItem() && this.items.get(3).getCount() != this.items.get(3).getMaxStackSize())){
                            //HardSteel.logger.info("Followed the normal JSON if statement for with fuel");

                            //if(recipe.isCastingRecipe()) {
                            //if(this.secondCounter == 0) {
                            //this.items.get(1).shrink(1);
                            //this.secondCounter = 200; // 100
                            //}
                            //}

                            //this.secondCounter = 0;
                            CrucibleUtilities.setLastSmeltedMetal(new ItemStack(Items.AIR));
                            CrucibleUtilities.setLastSmeltedCast(new ItemStack(Items.AIR));

                            this.recipeLocation = recipe.getId();
                            this.smeltingTimeNeeded = recipe.getCookingTime();
                            ItemStack itembeingRefinedLocal = items.get(2);
                            if(!itembeingRefinedLocal.isEmpty()) {
                                this.itemBeingSmelted = itembeingRefinedLocal.getItem().getTranslationKey();
                                itembeingRefinedLocal.shrink(1);
                            }
                        }
                    }
                    else if(CrucibleUtilities.hasCastingResult(items.get(2), items.get(1).getItem())) {

                        if(this.items.get(3).isEmpty()){
                            //HardSteel.logger.info("Followed the casting system if statement for with fuel");
                            int castingCost = CrucibleUtilities.getCastingCost(this.items.get(1));

                            //if(recipe.isCastingRecipe()) {
                            if(this.secondCounter == 0) {
                                CrucibleUtilities.setLastSmeltedCast(this.items.get(1).copy());
                                this.items.get(1).shrink(1);
                                this.secondCounter = 200;
                                //* castingCost; // 100
                            }
                            //}

                            this.recipeLocation = null;
                            this.smeltingTimeNeeded = 200;
                            //* castingCost;
                            ItemStack itembeingRefinedLocal = items.get(2);

                            if(!itembeingRefinedLocal.isEmpty()) {
                                this.itemBeingSmelted = itembeingRefinedLocal.getItem().getTranslationKey();
                                CrucibleUtilities.setLastSmeltedMetal(itembeingRefinedLocal.copy());
                                itembeingRefinedLocal.shrink(castingCost);
                            }
                        }
                    }
                    else {
                        turnOff();
                    }
                }
                markDirty();
            }
        }
    }

    private void turnOff() {
        BlockState blockState = world.getBlockState(this.pos);
        world.setBlockState(pos, blockState.with(CrucibleBlock.LIT, false), 3);
    }

    private boolean canAlloy(AlloyingRecipe recipe) {
        if(!this.items.get(2).isEmpty() && recipe != null) {
            //if(recipe.isCastingRecipe()) {
            //    if(this.secondCounter > 0) {
            //        return true;
            //    } else {
           //         return false;
           //     }
           // }
            if(recipe.hasRecipeOutput()) return true;
        }
        return false;
    }

    public void spawnExp(PlayerEntity player) {
        spawnExp(player, this.totalExperience);
        this.totalExperience = 0;
    }

    public static void spawnExp(PlayerEntity player, float totalXp) {
        int i = (int) totalXp;
        while(i > 0) {
            int j = ExperienceOrbEntity.getXPSplit(i);
            i -= j;
            player.world.addEntity(new ExperienceOrbEntity(player.world, player.posX, player.posY + 0.5D, player.posZ + 0.5D, j));
        }
    }

    private void checkRecipeAndSpawnOutput(AlloyingRecipe recipe) {
        //if(recipe == null){
            //HardSteel.logger.info("Did the null recipe check work?");
            //checkCastingRecipeAndSpawnOutput(workableMetalAmount, cast);
            //return;
        //}

        if(recipe == null) {
            return;
        }

        ItemStack recipeOutput;
        ItemStack itemstackInSlot;
        //Boolean refinerFull;
        for(int i = 3; i<4; i++) {
            //refinerFull = true;
            recipeOutput = recipe.getRecipeOutput(i);
            if(recipeOutput.isEmpty()) continue;

            this.totalExperience += recipe.getExperience();

            for(int j = 3; j<4; j++) {
                itemstackInSlot = this.items.get(j);
                if (itemstackInSlot.isEmpty()) {
                    this.items.set(j, recipeOutput);
                    j = 34;
                    //refinerFull = false;
                } else if (itemstackInSlot.isItemEqual(recipeOutput) && (itemstackInSlot.getCount() + recipeOutput.getCount() <= this.getInventoryStackLimit()) && (itemstackInSlot.getCount() + recipeOutput.getCount() <= itemstackInSlot.getMaxStackSize())) {
                    itemstackInSlot.grow(recipeOutput.getCount());
                    j = 34;
                    //refinerFull = false;
                }
            }
            //if(refinerFull) {
            //    Block.spawnAsEntity(world, this.pos, recipeOutput);
            //}
        }
    }

    private void checkCastingRecipeAndSpawnOutput(ItemStack workableMetalAmount, Item cast) {
        ItemStack castedItem;
        ItemStack itemstackInSlot;
        //Boolean refinerFull;
        for(int i = 3; i<4; i++) {
            //refinerFull = true;

            //HardSteel.logger.info("Tried to spawn output for " + workableMetalAmount.toString() + " and " + cast.toString());
            //HardSteel.logger.info("Should have gotten " + getCastingResult(workableMetalAmount, cast).toString());
            if(!hasCastingResult(workableMetalAmount,cast)) continue;

            castedItem = new ItemStack(getCastingResult(workableMetalAmount, cast), 1);
            //HardSteel.logger.info("Succesfully initialized casted item: " + castedItem.toString());

            //this.totalExperience += recipe.getExperience(); - Add experience reward for casting? Unsure since there is no reward for forging as it costs XP

            for(int j = 3; j<4; j++) {
                itemstackInSlot = this.items.get(j);
                if (itemstackInSlot.isEmpty()) {
                    this.items.set(j, castedItem);
                    j = 34;
                    //refinerFull = false;
                } else if (itemstackInSlot.isItemEqual(castedItem) && (itemstackInSlot.getCount() + castedItem.getCount() <= this.getInventoryStackLimit()) && (itemstackInSlot.getCount() + castedItem.getCount() <= itemstackInSlot.getMaxStackSize())) {
                    itemstackInSlot.grow(castedItem.getCount());
                    j = 34;
                    //refinerFull = false;
                }
            }
            //if(refinerFull) {
            //    Block.spawnAsEntity(world, this.pos, recipeOutput);
            //}
        }
    }

    private boolean hasFuel() {
        return this.fuelTimeLeft > 0;
    }

    public int getBurnTimes(ItemStack itemstack) {
        if (itemstack.isEmpty()) {
            return 0;
        } else {
            Item item = itemstack.getItem();
            return net.minecraftforge.common.ForgeHooks.getBurnTime(itemstack); // no blast furnace scaling for crucible
            //int ret = itemstack.getBurnTime(); // Does what the blast furnace does to scale fuel burn time for default cooking time of 100
            //return net.minecraftforge.event.ForgeEventFactory.getItemBurnTime(itemstack, ret == -1 ? AbstractFurnaceTileEntity.getBurnTimes().getOrDefault(item, 0) : ret);
        }
    }

    @Override
    public void read(CompoundNBT compound) {
        this.items = NonNullList.withSize(this.getSizeInventory(), ItemStack.EMPTY);
        ItemStackHelper.loadAllItems(compound, this.items);
        this.totalExperience = compound.getFloat("totalExperience");
        this.itemBurnTime = compound.getInt("itemBurnTime");
        this.smeltingTimeNeeded = compound.getInt("refineTime");
        this.fuelTimeLeft = compound.getInt("BurnTime");
        this.secondCounter = compound.getInt("secondCounter");
        this.hasBeenSmeltedFor = compound.getInt("hasBurntFor");
        this.itemBeingSmelted = compound.getString("itemBurning");
        if(!compound.getString("recipeLocation").equals("")) {
            this.recipeLocation = new ResourceLocation(compound.getString("recipeLocation"));
        }
        super.read(compound);
    }

    @Override
    public CompoundNBT write(CompoundNBT compound) {
        ItemStackHelper.saveAllItems(compound, this.items);
        compound.putFloat("totalExperience", this.totalExperience);
        compound.putInt("itemBurnTime", this.itemBurnTime);
        compound.putInt("refineTime", this.smeltingTimeNeeded);
        compound.putInt("BurnTime", this.fuelTimeLeft);
        compound.putInt("secondCounter", this.secondCounter);
        compound.putInt("hasBurntFor", this.hasBeenSmeltedFor);
        compound.putString("itemBurning", this.itemBeingSmelted);
        if(this.recipeLocation != null) {
            compound.putString("recipeLocation", this.recipeLocation.toString());
        } else {
            compound.putString("recipeLocation", "");
        }
        return super.write(compound);
    }

}
