package com.infamous.hard_steel.finery_forge;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.JSONUtils;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.registries.ForgeRegistries;

public class FiningRecipeSerializer<T extends FiningRecipe> extends net.minecraftforge.registries.ForgeRegistryEntry<IRecipeSerializer<?>> implements IRecipeSerializer<T> {

    private final int cookingTime;
    private final FiningRecipeSerializer.IFactory<T> iBlastRecipeFactory;

    public FiningRecipeSerializer(FiningRecipeSerializer.IFactory<T> factoryIn, int cookingTimeIn) {
        this.cookingTime = cookingTimeIn;
        this.iBlastRecipeFactory = factoryIn;
        //setRegistryName(HardSteel.modid, "blasting_mk2");
    }

    public T read(ResourceLocation recipeId, JsonObject json) {
        String group = JSONUtils.getString(json, "group", "");
        JsonElement jsonelement = (JsonElement) (JSONUtils.isJsonArray(json, "ingredient") ? JSONUtils.getJsonArray(json, "ingredient") : JSONUtils.getJsonObject(json, "ingredient"));
        Ingredient ingredient = Ingredient.deserialize(jsonelement);
        String result = JSONUtils.getString(json, "result");
        ResourceLocation resourcelocation = new ResourceLocation(result);
        ItemStack itemstack = new ItemStack(ForgeRegistries.ITEMS.getValue(resourcelocation));
        float experience = JSONUtils.getFloat(json, "experience", 0.0F);
        int cookingTime = JSONUtils.getInt(json, "cookingtime", this.cookingTime);

        return this.iBlastRecipeFactory.create(recipeId, group, ingredient, itemstack, experience, cookingTime);
    }

    public T read(ResourceLocation recipeId, PacketBuffer buffer) {
        String s = buffer.readString(32767);
        Ingredient ingredient = Ingredient.read(buffer);
        ItemStack itemstack = buffer.readItemStack();
        float f = buffer.readFloat();
        int i = buffer.readVarInt();
        return this.iBlastRecipeFactory.create(recipeId, s, ingredient, itemstack, f, i);
    }

    public void write(PacketBuffer buffer, T recipe) {
        buffer.writeString(recipe.group);
        recipe.ingredient.write(buffer);
        buffer.writeItemStack(recipe.result);
        buffer.writeFloat(recipe.experience);
        buffer.writeVarInt(recipe.cookTime);
    }

    public interface IFactory<T extends FiningRecipe> {
        T create(ResourceLocation resourceLocation, String s, Ingredient ingredient, ItemStack itemStack, float experience, int cookingTime);
    }
}
