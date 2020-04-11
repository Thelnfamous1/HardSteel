package com.infamous.hard_steel.recipes;

import java.lang.reflect.Field;
import java.util.Map;
import java.util.function.Predicate;

import com.google.common.collect.ImmutableMap;
import com.infamous.hard_steel.HardSteel;

import com.infamous.hard_steel.config.GeneralModConfig;
import it.unimi.dsi.fastutil.objects.Object2IntMap;
import it.unimi.dsi.fastutil.objects.Object2IntOpenHashMap;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.IRecipeType;
import net.minecraft.item.crafting.RecipeManager;
import net.minecraft.resources.IReloadableResourceManager;
import net.minecraft.resources.IResourceManagerReloadListener;
import net.minecraft.tags.Tag;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.ObfuscationReflectionHelper;
import net.minecraftforge.fml.event.server.FMLServerStartedEvent;

/**
 * This code is written as a result to PlankRecipe#match() not catching plank crafting consistently due to it being the *wrong*
 * way to do it (via https://bit.ly/2Ns6Vkv)
 * <p>
 * Thanks to Choonster@github, this code is mostly theirs: https://bit.ly/2BLB9t3 (Code used under their MIT license)
 */

@SuppressWarnings("deprecation")
@Mod.EventBusSubscriber(modid = HardSteel.modid)
public class RecipeRemover
{
    private static final Field RECIPES = ObfuscationReflectionHelper.findField(RecipeManager.class,
            "field_199522_d" /* recipes */);

    @SubscribeEvent
    public static void onServerStart(final FMLServerStartedEvent event)
    {
        final RecipeManager mgr = event.getServer().getRecipeManager();
        IReloadableResourceManager resourceMgr = event.getServer().getResourceManager();
        remove(mgr);
        resourceMgr.addReloadListener((IResourceManagerReloadListener) resourceManager -> remove(mgr));
    }

    private static void remove(RecipeManager mgr)
    {
        // necessary to make the Anvil and Cementation Furnace using original vanilla recipes
        removeRecipes(mgr, new ItemStack(Items.ANVIL, 1));
        removeRecipes(mgr, new ItemStack(Items.BLAST_FURNACE, 1));

        if(GeneralModConfig.REMOVE_VANILLA_SHIELD_RECIPE.get()){
            removeRecipes(mgr, new ItemStack(Items.SHIELD, 1));
        }
        if(GeneralModConfig.REMOVE_WOODEN_TOOL_RECIPES.get()){
            removeRecipes(mgr, new ItemStack(Items.WOODEN_AXE, 1));
            removeRecipes(mgr, new ItemStack(Items.WOODEN_HOE, 1));
            removeRecipes(mgr, new ItemStack(Items.WOODEN_PICKAXE, 1));
            removeRecipes(mgr, new ItemStack(Items.WOODEN_SHOVEL, 1));
            removeRecipes(mgr, new ItemStack(Items.WOODEN_SWORD, 1));
        }
        if(GeneralModConfig.REMOVE_STONE_TOOL_RECIPES.get()){
            removeRecipes(mgr, new ItemStack(Items.STONE_AXE, 1));
            removeRecipes(mgr, new ItemStack(Items.STONE_HOE, 1));
            removeRecipes(mgr, new ItemStack(Items.STONE_PICKAXE, 1));
            removeRecipes(mgr, new ItemStack(Items.STONE_SHOVEL, 1));
            removeRecipes(mgr, new ItemStack(Items.STONE_SWORD, 1));
        }
        if(GeneralModConfig.REMOVE_IRON_GEAR_RECIPES.get()){
            removeRecipes(mgr, new ItemStack(Items.IRON_AXE, 1));
            removeRecipes(mgr, new ItemStack(Items.IRON_HOE, 1));
            removeRecipes(mgr, new ItemStack(Items.IRON_PICKAXE, 1));
            removeRecipes(mgr, new ItemStack(Items.IRON_SHOVEL, 1));
            removeRecipes(mgr, new ItemStack(Items.IRON_SWORD, 1));
            removeRecipes(mgr, new ItemStack(Items.IRON_HELMET, 1));
            removeRecipes(mgr, new ItemStack(Items.IRON_CHESTPLATE, 1));
            removeRecipes(mgr, new ItemStack(Items.IRON_LEGGINGS, 1));
            removeRecipes(mgr, new ItemStack(Items.IRON_BOOTS, 1));
        }
        if(GeneralModConfig.REMOVE_GOLDEN_GEAR_RECIPES.get()){
            removeRecipes(mgr, new ItemStack(Items.GOLDEN_AXE, 1));
            removeRecipes(mgr, new ItemStack(Items.GOLDEN_HOE, 1));
            removeRecipes(mgr, new ItemStack(Items.GOLDEN_PICKAXE, 1));
            removeRecipes(mgr, new ItemStack(Items.GOLDEN_SHOVEL, 1));
            removeRecipes(mgr, new ItemStack(Items.GOLDEN_SWORD, 1));
            removeRecipes(mgr, new ItemStack(Items.GOLDEN_HELMET, 1));
            removeRecipes(mgr, new ItemStack(Items.GOLDEN_CHESTPLATE, 1));
            removeRecipes(mgr, new ItemStack(Items.GOLDEN_LEGGINGS, 1));
            removeRecipes(mgr, new ItemStack(Items.GOLDEN_BOOTS, 1));
        }
        if(GeneralModConfig.REMOVE_DIAMOND_GEAR_RECIPES.get()){
            removeRecipes(mgr, new ItemStack(Items.DIAMOND_AXE, 1));
            removeRecipes(mgr, new ItemStack(Items.DIAMOND_HOE, 1));
            removeRecipes(mgr, new ItemStack(Items.DIAMOND_PICKAXE, 1));
            removeRecipes(mgr, new ItemStack(Items.DIAMOND_SHOVEL, 1));
            removeRecipes(mgr, new ItemStack(Items.DIAMOND_SWORD, 1));
            removeRecipes(mgr, new ItemStack(Items.DIAMOND_HELMET, 1));
            removeRecipes(mgr, new ItemStack(Items.DIAMOND_CHESTPLATE, 1));
            removeRecipes(mgr, new ItemStack(Items.DIAMOND_LEGGINGS, 1));
            removeRecipes(mgr, new ItemStack(Items.DIAMOND_BOOTS, 1));
        }
    }

    /**
     * Removes all crafting recipes with an output item contained in the specified tag.
     *
     * @param recipeManager The recipe manager
     * @param stack         The ItemStack output of the recipe to remove
     */
    private static void removeRecipes(final RecipeManager recipeManager, final ItemStack stack)
    {
        final int recipesRemoved = removeRecipes(recipeManager, recipe -> {
            final ItemStack recipeOutput = recipe.getRecipeOutput();
            return recipeOutput.equals(stack, false) && !(recipe.getSerializer() instanceof DamageItemRecipe.Serializer);
        });

        HardSteel.getInstance().logger.info("Removed {} recipe(s) for {}", recipesRemoved,
                stack.getDisplayName().getFormattedText());
    }

    /**
     * Removes all crafting recipes with an output item contained in the specified tag.
     *
     * @param recipeManager The recipe manager
     * @param tag           The tag
     */
    private static void removeRecipes(final RecipeManager recipeManager, final Tag<Item> tag)
    {
        final int recipesRemoved = removeRecipes(recipeManager, recipe -> {
            final ItemStack recipeOutput = recipe.getRecipeOutput();
            return !recipeOutput.isEmpty() && recipeOutput.getItem().isIn(tag) && !(recipe.getSerializer() instanceof DamageItemRecipe.Serializer);
        });

        HardSteel.getInstance().logger.info("Removed {} recipe(s) for tag {}", recipesRemoved, tag.getId());
    }

    /**
     * Remove all crafting recipes that match the specified predicate.
     *
     * @param recipeManager The recipe manager
     * @param predicate     The predicate
     * @return The number of recipes removed
     */
    private static int removeRecipes(final RecipeManager recipeManager, final Predicate<IRecipe<?>> predicate)
    {
        final Map<IRecipeType<?>, Map<ResourceLocation, IRecipe<?>>> existingRecipes;
        try
        {
            @SuppressWarnings("unchecked")
            final Map<IRecipeType<?>, Map<ResourceLocation, IRecipe<?>>> recipesMap = (Map<IRecipeType<?>, Map<ResourceLocation, IRecipe<?>>>) RECIPES
                    .get(recipeManager);
            existingRecipes = recipesMap;
        }
        catch (final IllegalAccessException e)
        {
            throw new RuntimeException("Couldn't get recipes map while removing recipes", e);
        }

        final Object2IntMap<IRecipeType<?>> removedCounts = new Object2IntOpenHashMap<>();
        final ImmutableMap.Builder<IRecipeType<?>, Map<ResourceLocation, IRecipe<?>>> newRecipes = ImmutableMap
                .builder();

        // For each recipe type, create a new map that doesn't contain the recipes to be removed
        existingRecipes.forEach((recipeType, existingRecipesForType) -> {
            // noinspection UnstableApiUsage

            final ImmutableMap<ResourceLocation, IRecipe<?>> newRecipesForType = existingRecipesForType.entrySet()
                    .stream().filter(entry -> !predicate.test(entry.getValue()))
                    .collect(ImmutableMap.toImmutableMap(Map.Entry::getKey, Map.Entry::getValue));

            removedCounts.put(recipeType, existingRecipesForType.size() - newRecipesForType.size());
            newRecipes.put(recipeType, newRecipesForType);
        });

        final int removedCount = removedCounts.values().stream().reduce(0, Integer::sum);

        try
        {
            RECIPES.set(recipeManager, newRecipes.build());
        }
        catch (final IllegalAccessException e)
        {
            throw new RuntimeException("Couldn't replace recipes map while removing recipes", e);
        }

        return removedCount;
    }
}