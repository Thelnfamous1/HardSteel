package com.infamous.hard_steel.finery_forge;

import com.infamous.hard_steel.proxy.IHardSteelRecipeType;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.AbstractCookingRecipe;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public class FiningRecipe extends AbstractCookingRecipe {

    public final ResourceLocation id;
    public final String group;
    public final Ingredient ingredient;
    public final ItemStack result;
    public final float experience;
    public final int cookTime;

    public FiningRecipe(ResourceLocation idIn, String groupIn, Ingredient ingredientIn, ItemStack resultIn, float experienceIn, int cookTimeIn) {
        super(IHardSteelRecipeType.FINING, idIn, groupIn, ingredientIn, resultIn, experienceIn, cookTimeIn);

        this.id = idIn;
        this.group = groupIn;
        this.ingredient = ingredientIn;
        this.result = resultIn;
        this.experience = experienceIn;
        this.cookTime = cookTimeIn;
    }

    @Override
    public boolean matches(IInventory inv, World worldIn) {
        return this.ingredient.test(inv.getStackInSlot(0));
    }

    @Override
    public ItemStack getCraftingResult(IInventory inv) {
        return this.result.copy();
    }

    @Override
    public boolean canFit(int width, int height) {
        return true;
    }

    @Override
    public NonNullList<Ingredient> getIngredients() {
        NonNullList<Ingredient> nonnulllist = NonNullList.create();
        nonnulllist.add(this.ingredient);
        return nonnulllist;
    }


    @Override
    public ItemStack getRecipeOutput() {
        return this.result;
    }

    @Override
    public String getGroup() {
        return this.group;
    }

    @Override
    public ResourceLocation getId() {
        return this.id;
    }

    @Override
    public IRecipeSerializer<?> getSerializer() {
        return FineryForgeRegistryEvents.fining;
    }

    public int getCookTime() {
        return this.cookTime;
    }

    public float getExperience() {
        return this.experience;
    }
}
