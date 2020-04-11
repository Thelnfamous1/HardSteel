package com.infamous.hard_steel.world;

import static net.minecraft.world.gen.feature.OreFeatureConfig.FillerBlockType.NATURAL_STONE;
import static net.minecraft.world.gen.feature.OreFeatureConfig.FillerBlockType.NETHERRACK;
import static net.minecraft.world.gen.placement.Placement.COUNT_DEPTH_AVERAGE;
import static net.minecraft.world.gen.placement.Placement.COUNT_RANGE;

import com.infamous.hard_steel.lists.BlockList;
import com.infamous.hard_steel.config.GeneralModConfig;

import net.minecraft.block.Blocks;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.feature.ReplaceBlockConfig;
import net.minecraft.world.gen.placement.CountRangeConfig;
import net.minecraft.world.gen.placement.DepthAverageConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraftforge.registries.ForgeRegistries;

public class OreGenerator
{
    public static void setupOregen()
    {

        for(Biome biome : ForgeRegistries.BIOMES)
        {
            if(GeneralModConfig.ANCIENT_DEBRIS_GENERATION.get() && biome == Biomes.NETHER){
                biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(Feature.ORE, new OreFeatureConfig(NETHERRACK, BlockList.ancient_debris.getDefaultState(), GeneralModConfig.ANCIENT_DEBRIS_SIZE.get()), COUNT_DEPTH_AVERAGE, new DepthAverageConfig(GeneralModConfig.ANCIENT_DEBRIS_CHANCE.get(), GeneralModConfig.ANCIENT_DEBRIS_BASELINE_HEIGHT.get(), GeneralModConfig.ANCIENT_DEBRIS_SPREAD.get())));
            }
            if(GeneralModConfig.SECONDARY_ANCIENT_DEBRIS_GENERATION.get() && biome == Biomes.NETHER){
                biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(Feature.ORE, new OreFeatureConfig(NETHERRACK, BlockList.ancient_debris.getDefaultState(), GeneralModConfig.SECONDARY_ANCIENT_DEBRIS_SIZE.get()), COUNT_RANGE, new CountRangeConfig(GeneralModConfig.SECONDARY_ANCIENT_DEBRIS_CHANCE.get(), GeneralModConfig.SECONDARY_ANCIENT_DEBRIS_MIN_HEIGHT.get(), GeneralModConfig.SECONDARY_ANCIENT_DEBRIS_MIN_HEIGHT.get(), GeneralModConfig.SECONDARY_ANCIENT_DEBRIS_MAX_HEIGHT.get())));
            }

            if(GeneralModConfig.ELDER_REMNANTS_GENERATION.get() && isEndBiome(biome)){
                biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(Feature.EMERALD_ORE, new ReplaceBlockConfig(Blocks.END_STONE.getDefaultState(), BlockList.elder_remnants.getDefaultState()), COUNT_DEPTH_AVERAGE, new DepthAverageConfig(GeneralModConfig.ELDER_REMNANTS_CHANCE.get(), GeneralModConfig.ELDER_REMNANTS_BASELINE_HEIGHT.get(), GeneralModConfig.ELDER_REMNANTS_SPREAD.get())));
            }
            if(GeneralModConfig.SECONDARY_ELDER_REMNANTS_GENERATION.get() && isEndBiome(biome)){
                biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(Feature.EMERALD_ORE, new ReplaceBlockConfig(Blocks.END_STONE.getDefaultState(), BlockList.elder_remnants.getDefaultState()), COUNT_RANGE, new CountRangeConfig(GeneralModConfig.SECONDARY_ELDER_REMNANTS_CHANCE.get(), GeneralModConfig.SECONDARY_ELDER_REMNANTS_MIN_HEIGHT.get(), GeneralModConfig.SECONDARY_ELDER_REMNANTS_MIN_HEIGHT.get(), GeneralModConfig.SECONDARY_ANCIENT_DEBRIS_MAX_HEIGHT.get())));
            }

            if(GeneralModConfig.COPPER_ORE_GENERATION.get())
                biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(Feature.ORE, new OreFeatureConfig(NATURAL_STONE, BlockList.copper_ore.getDefaultState(), GeneralModConfig.COPPER_ORE_SIZE.get()), COUNT_RANGE, new CountRangeConfig(GeneralModConfig.COPPER_ORE_CHANCE.get(), GeneralModConfig.COPPER_ORE_MIN_HEIGHT.get(), GeneralModConfig.COPPER_ORE_MIN_HEIGHT.get(), GeneralModConfig.COPPER_ORE_MAX_HEIGHT.get())));

            if(GeneralModConfig.TIN_ORE_GENERATION.get())
                biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(Feature.ORE, new OreFeatureConfig(NATURAL_STONE, BlockList.tin_ore.getDefaultState(), GeneralModConfig.TIN_ORE_SIZE.get()), COUNT_RANGE, new CountRangeConfig(GeneralModConfig.TIN_ORE_CHANCE.get(), GeneralModConfig.TIN_ORE_MIN_HEIGHT.get(), GeneralModConfig.TIN_ORE_MIN_HEIGHT.get(), GeneralModConfig.TIN_ORE_MAX_HEIGHT.get())));

            if(GeneralModConfig.MITHRIL_ORE_GENERATION.get()){
                biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(Feature.ORE, new OreFeatureConfig(NATURAL_STONE, BlockList.mithril_ore.getDefaultState(), GeneralModConfig.MITHRIL_ORE_SIZE.get()), COUNT_DEPTH_AVERAGE, new DepthAverageConfig(GeneralModConfig.MITHRIL_ORE_CHANCE.get(), GeneralModConfig.MITHRIL_ORE_BASELINE_HEIGHT.get(), GeneralModConfig.MITHRIL_ORE_SPREAD.get())));
            }

            if(GeneralModConfig.SECONDARY_MITHRIL_ORE_GENERATION.get() && biome.getCategory() == Biome.Category.EXTREME_HILLS)
                biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(Feature.ORE, new OreFeatureConfig(NATURAL_STONE, BlockList.mithril_ore.getDefaultState(), GeneralModConfig.SECONDARY_MITHRIL_ORE_SIZE.get()), COUNT_RANGE, new CountRangeConfig(GeneralModConfig.SECONDARY_MITHRIL_ORE_CHANCE.get(), GeneralModConfig.SECONDARY_MITHRIL_ORE_MIN_HEIGHT.get(), GeneralModConfig.SECONDARY_MITHRIL_ORE_MIN_HEIGHT.get(), GeneralModConfig.SECONDARY_MITHRIL_ORE_MAX_HEIGHT.get())));

            if(GeneralModConfig.LIMESTONE_GENERATION.get())
                biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(Feature.ORE, new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, BlockList.limestone.getDefaultState(), 33), Placement.COUNT_RANGE, new CountRangeConfig(GeneralModConfig.LIMESTONE_CHANCE.get(), GeneralModConfig.LIMESTONE_MIN_HEIGHT.get(), GeneralModConfig.LIMESTONE_MIN_HEIGHT.get(), GeneralModConfig.LIMESTONE_MAX_HEIGHT.get())));
        }
    }

    public static boolean isEndBiome(Biome biome){
        if (biome == Biomes.THE_END || biome == Biomes.END_BARRENS || biome == Biomes.END_HIGHLANDS || biome == Biomes.END_MIDLANDS || biome == Biomes.SMALL_END_ISLANDS){
            return true;
        }
        return false;
    }
}