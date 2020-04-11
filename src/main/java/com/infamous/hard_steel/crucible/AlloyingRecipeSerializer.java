package com.infamous.hard_steel.crucible;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSyntaxException;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.JSONUtils;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.registries.ForgeRegistries;

public class AlloyingRecipeSerializer<T extends AlloyingRecipe> extends net.minecraftforge.registries.ForgeRegistryEntry<IRecipeSerializer<?>> implements IRecipeSerializer<T> {

    private final int cookingTime;
    private final AlloyingRecipeSerializer.IFactory<T> iBlastRecipeFactory;

    public AlloyingRecipeSerializer(AlloyingRecipeSerializer.IFactory<T> factoryIn, int cookingTimeIn) {
        this.cookingTime = cookingTimeIn;
        this.iBlastRecipeFactory = factoryIn;
        //setRegistryName(HardSteel.modid, "blasting_mk2");
    }

    public T read(ResourceLocation recipeId, JsonObject json) {
        String group = JSONUtils.getString(json, "group", "");
        JsonElement jsonelement = (JsonElement) (JSONUtils.isJsonArray(json, "ingredient") ? JSONUtils.getJsonArray(json, "ingredient") : JSONUtils.getJsonObject(json, "ingredient"));
        Ingredient ingredient = Ingredient.deserialize(jsonelement);
        ItemStack itemstack = getResult(json);

        float experience = JSONUtils.getFloat(json, "experience", 0.0F);
        int cookingTime = JSONUtils.getInt(json, "cookingTime", this.cookingTime);

        return this.iBlastRecipeFactory.create(recipeId, group, ingredient, itemstack, experience, cookingTime);
    }

    private ItemStack getResult(JsonObject json){
        String result = "result";
        ItemStack resultItem = ItemStack.EMPTY;
        if(json.has(result)) {
            JsonObject jsonobj = json.getAsJsonObject(result);
            if (!jsonobj.isJsonObject()) throw new JsonSyntaxException("Expected json object for " + result);

            ResourceLocation resourceLocation = new ResourceLocation(JSONUtils.getString(jsonobj, "item"));
            int count = JSONUtils.getInt(jsonobj, "count", 1);
            resultItem = new ItemStack(ForgeRegistries.ITEMS.getValue(resourceLocation), count);
        }
        return resultItem;
    }

    public T read(ResourceLocation recipeId, PacketBuffer buffer) {
        String s = buffer.readString(32767);
        Ingredient ingredient = Ingredient.read(buffer);
        ItemStack itemstack = buffer.readItemStack();
        float exp = buffer.readFloat();
        int cookingTime = buffer.readVarInt();
        return this.iBlastRecipeFactory.create(recipeId, s, ingredient, itemstack, exp, cookingTime);
    }

    public void write(PacketBuffer buffer, T recipe) {
        buffer.writeString(recipe.group);
        recipe.ingredient.write(buffer);
        buffer.writeItemStack(recipe.result);
        buffer.writeFloat(recipe.experience);
        buffer.writeVarInt(recipe.cookingTime);
    }

    public interface IFactory<T extends AlloyingRecipe> {
        T create(ResourceLocation resourceLocation, String group, Ingredient ingredient, ItemStack itemStack, float experience, int cookingTime);
    }
}
