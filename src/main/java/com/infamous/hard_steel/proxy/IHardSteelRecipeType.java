package com.infamous.hard_steel.proxy;

import com.infamous.hard_steel.bloomery.BloomingRecipe;
import com.infamous.hard_steel.cementation_furnace.CementationRecipe;
import com.infamous.hard_steel.crucible.AlloyingRecipe;
import com.infamous.hard_steel.finery_forge.FiningRecipe;
import com.infamous.hard_steel.blast_furnace.HotBlastingRecipe;
import net.minecraft.item.crafting.IRecipeType;

public interface IHardSteelRecipeType  extends IRecipeType {
    IRecipeType<AlloyingRecipe> ALLOYING = IRecipeType.register("alloying");
    IRecipeType<BloomingRecipe> BLOOMING = IRecipeType.register("blooming");
    IRecipeType<CementationRecipe> CEMENTATION = IRecipeType.register("cementation");
    IRecipeType<FiningRecipe> FINING = IRecipeType.register("fining");
    IRecipeType<HotBlastingRecipe> HOT_BLASTING = IRecipeType.register("hot_blasting");
}
