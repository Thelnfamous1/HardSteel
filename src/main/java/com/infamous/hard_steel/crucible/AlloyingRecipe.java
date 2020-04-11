package com.infamous.hard_steel.crucible;

import com.infamous.hard_steel.proxy.IHardSteelRecipeType;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.*;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

import javax.annotation.Nonnull;

public class AlloyingRecipe implements IRecipe<IInventory> {
    protected final IRecipeType<?> type;
    public final ResourceLocation id;
    public final String group;
    public final Ingredient ingredient;
    public final ItemStack result;
    public final float experience;
    public final int cookingTime;

    public AlloyingRecipe(ResourceLocation idIn, String groupIn, Ingredient ingredientIn, ItemStack resultIn, float experienceIn, int cookTimeIn) {
        this.type = IHardSteelRecipeType.ALLOYING;
        this.id = idIn;
        this.group = groupIn;
        this.ingredient = ingredientIn;
        this.result = resultIn;
        this.experience = experienceIn;
        this.cookingTime = cookTimeIn;
    }

    @Override
    public boolean matches(IInventory inv, World worldIn) {
        return this.ingredient.test(inv.getStackInSlot(2));
    }

    @Deprecated
    @Override
    public ItemStack getCraftingResult(IInventory inv) {
        return null;
    }

    @Override
    public boolean canFit(int width, int height) {
        return true;
    }

    @Deprecated
    @Override
    public ItemStack getRecipeOutput() {
        return this.result.copy(); //Needed to avoid vanilla recipe book throwing a NPE...
    }

    public ItemStack getRecipeOutput(int slotIndex){
        switch(slotIndex) {
            case 3: return this.result.copy();
            default: return ItemStack.EMPTY;
        }
    }

    //public boolean isCastingRecipe() {
     //   if(this.id.getPath().contains("casting")) {
     //       return true;
     //   }
     //   return false;
    //}

    @Override
    public ResourceLocation getId() {
        return id;
    }

    @Override
    public IRecipeSerializer<?> getSerializer() {
        return CrucibleRegistryEvents.alloying;
    }

    @Override
    public IRecipeType<?> getType() {
        return type;
    }

    @Override
    @Nonnull
    public NonNullList<Ingredient> getIngredients() {
        NonNullList<Ingredient> nonnulllist = NonNullList.create();
        nonnulllist.add(this.ingredient);
        return nonnulllist;
    }

    public Ingredient getInput() {
        return this.ingredient;
    }

    @Override
    @Nonnull
    public ItemStack getIcon() {
        return new ItemStack(CrucibleRegistryEvents.CRUCIBLE);
    }

    public int getCookingTime() {
        return cookingTime;
    }

    public boolean hasRecipeOutput() {
        ItemStack output = ItemStack.EMPTY;
        for(int i=3; i<4; i++) {
            output = getRecipeOutput(i);
            if(!output.isEmpty()) {
                return true;
            }
        }
        return false;
    }

    public float getExperience() {
        return this.experience;
    }
}
