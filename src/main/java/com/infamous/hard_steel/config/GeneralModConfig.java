package com.infamous.hard_steel.config;

import com.google.common.collect.Lists;
import net.minecraftforge.common.ForgeConfigSpec;

import java.util.List;


public class GeneralModConfig
{

    public static ForgeConfigSpec.BooleanValue ENABLE_BRONZE_AGE;
    public static ForgeConfigSpec.IntValue LEATHER_DROP_CHANCE;
    public static ForgeConfigSpec.IntValue LEATHER_DROP_AMOUNT;
    public static ForgeConfigSpec.ConfigValue<List<? extends String>> LEATHER_DROP_ENTITIES;

    public static ForgeConfigSpec.BooleanValue COPPER_ORE_GENERATION;
    public static ForgeConfigSpec.IntValue COPPER_ORE_CHANCE;
    public static ForgeConfigSpec.IntValue COPPER_ORE_SIZE;
    public static ForgeConfigSpec.IntValue COPPER_ORE_MIN_HEIGHT;
    public static ForgeConfigSpec.IntValue COPPER_ORE_MAX_HEIGHT;

    public static ForgeConfigSpec.BooleanValue TIN_ORE_GENERATION;
    public static ForgeConfigSpec.IntValue TIN_ORE_CHANCE;
    public static ForgeConfigSpec.IntValue TIN_ORE_SIZE;
    public static ForgeConfigSpec.IntValue TIN_ORE_MIN_HEIGHT;
    public static ForgeConfigSpec.IntValue TIN_ORE_MAX_HEIGHT;

    public static ForgeConfigSpec.BooleanValue MITHRIL_ORE_GENERATION;
    public static ForgeConfigSpec.IntValue MITHRIL_ORE_CHANCE;
    public static ForgeConfigSpec.IntValue MITHRIL_ORE_SIZE;
    public static ForgeConfigSpec.IntValue MITHRIL_ORE_BASELINE_HEIGHT;
    public static ForgeConfigSpec.IntValue MITHRIL_ORE_SPREAD;

    public static ForgeConfigSpec.BooleanValue SECONDARY_MITHRIL_ORE_GENERATION;
    public static ForgeConfigSpec.IntValue SECONDARY_MITHRIL_ORE_CHANCE;
    public static ForgeConfigSpec.IntValue SECONDARY_MITHRIL_ORE_SIZE;
    public static ForgeConfigSpec.IntValue SECONDARY_MITHRIL_ORE_MIN_HEIGHT;
    public static ForgeConfigSpec.IntValue SECONDARY_MITHRIL_ORE_MAX_HEIGHT;

    public static ForgeConfigSpec.BooleanValue LIMESTONE_GENERATION;
    public static ForgeConfigSpec.IntValue LIMESTONE_CHANCE;
    public static ForgeConfigSpec.IntValue LIMESTONE_SIZE;
    public static ForgeConfigSpec.IntValue LIMESTONE_MIN_HEIGHT;
    public static ForgeConfigSpec.IntValue LIMESTONE_MAX_HEIGHT;

    public static ForgeConfigSpec.BooleanValue ANCIENT_DEBRIS_GENERATION;
    public static ForgeConfigSpec.IntValue ANCIENT_DEBRIS_CHANCE;
    public static ForgeConfigSpec.IntValue ANCIENT_DEBRIS_SIZE;
    public static ForgeConfigSpec.IntValue ANCIENT_DEBRIS_BASELINE_HEIGHT;
    public static ForgeConfigSpec.IntValue ANCIENT_DEBRIS_SPREAD;

    public static ForgeConfigSpec.BooleanValue SECONDARY_ANCIENT_DEBRIS_GENERATION;
    public static ForgeConfigSpec.IntValue SECONDARY_ANCIENT_DEBRIS_CHANCE;
    public static ForgeConfigSpec.IntValue SECONDARY_ANCIENT_DEBRIS_SIZE;
    public static ForgeConfigSpec.IntValue SECONDARY_ANCIENT_DEBRIS_MIN_HEIGHT;
    public static ForgeConfigSpec.IntValue SECONDARY_ANCIENT_DEBRIS_MAX_HEIGHT;

    public static ForgeConfigSpec.BooleanValue ELDER_REMNANTS_GENERATION;
    public static ForgeConfigSpec.IntValue ELDER_REMNANTS_CHANCE;
    public static ForgeConfigSpec.IntValue ELDER_REMNANTS_SIZE;
    public static ForgeConfigSpec.IntValue ELDER_REMNANTS_BASELINE_HEIGHT;
    public static ForgeConfigSpec.IntValue ELDER_REMNANTS_SPREAD;

    public static ForgeConfigSpec.BooleanValue SECONDARY_ELDER_REMNANTS_GENERATION;
    public static ForgeConfigSpec.IntValue SECONDARY_ELDER_REMNANTS_CHANCE;
    public static ForgeConfigSpec.IntValue SECONDARY_ELDER_REMNANTS_SIZE;
    public static ForgeConfigSpec.IntValue SECONDARY_ELDER_REMNANTS_MIN_HEIGHT;
    public static ForgeConfigSpec.IntValue SECONDARY_ELDER_REMNANTS_MAX_HEIGHT;

    public static ForgeConfigSpec.IntValue COPPER_ARMOR_DURABILITY;
    public static ForgeConfigSpec.IntValue BRONZE_ARMOR_DURABILITY;
    public static ForgeConfigSpec.IntValue IRON_ARMOR_DURABILITY;
    public static ForgeConfigSpec.IntValue STEEL_ARMOR_DURABILITY;
    public static ForgeConfigSpec.IntValue MITHRIL_ARMOR_DURABILITY;
    public static ForgeConfigSpec.IntValue NETHERITE_ARMOR_DURABILITY;
    public static ForgeConfigSpec.IntValue ENDERITE_ARMOR_DURABILITY;

    public static ForgeConfigSpec.IntValue FLINT_TOOL_DURABILITY;
    public static ForgeConfigSpec.IntValue COPPER_TOOL_DURABILITY;
    public static ForgeConfigSpec.IntValue BRONZE_TOOL_DURABILITY;
    public static ForgeConfigSpec.IntValue IRON_TOOL_DURABILITY;
    public static ForgeConfigSpec.IntValue STEEL_TOOL_DURABILITY;
    public static ForgeConfigSpec.IntValue MITHRIL_TOOL_DURABILITY;
    public static ForgeConfigSpec.IntValue NETHERITE_TOOL_DURABILITY;
    public static ForgeConfigSpec.IntValue ENDERITE_TOOL_DURABILITY;

    public static ForgeConfigSpec.BooleanValue REMOVE_VANILLA_SHIELD_RECIPE;
    public static ForgeConfigSpec.BooleanValue REMOVE_WOODEN_TOOL_RECIPES;
    public static ForgeConfigSpec.BooleanValue REMOVE_STONE_TOOL_RECIPES;
    public static ForgeConfigSpec.BooleanValue REMOVE_IRON_GEAR_RECIPES;
    public static ForgeConfigSpec.BooleanValue REMOVE_GOLDEN_GEAR_RECIPES;
    public static ForgeConfigSpec.BooleanValue REMOVE_DIAMOND_GEAR_RECIPES;

    public static ForgeConfigSpec.IntValue repair_cost_cap;
    public static ForgeConfigSpec.BooleanValue prior_work_penalty;
    public static ForgeConfigSpec.BooleanValue damageable;
    public static ForgeConfigSpec.DoubleValue damage_chance;
    public static ForgeConfigSpec.BooleanValue cheap_renaming;

    public static ForgeConfigSpec.IntValue anvil_repair_cost_cap;
    public static ForgeConfigSpec.BooleanValue anvil_prior_work_penalty;
    public static ForgeConfigSpec.BooleanValue anvil_damageable;
    public static ForgeConfigSpec.DoubleValue anvil_damage_chance;
    public static ForgeConfigSpec.BooleanValue anvil_cheap_renaming;

    public static ForgeConfigSpec.BooleanValue MOBS_USE_HARD_STEEL_GEAR;

    public static ForgeConfigSpec.BooleanValue customShieldMaxReduction;
    public static ForgeConfigSpec.BooleanValue thornsOnShields;

    public static ForgeConfigSpec.ConfigValue<Integer> defaultDamageReduction;
    public static ForgeConfigSpec.ConfigValue<Integer> woodenDamageReduction;
    public static ForgeConfigSpec.ConfigValue<Integer> copperDamageReduction;
    public static ForgeConfigSpec.ConfigValue<Integer> bronzeDamageReduction;
    public static ForgeConfigSpec.ConfigValue<Integer> ironDamageReduction;
    public static ForgeConfigSpec.ConfigValue<Integer> steelDamageReduction;
    public static ForgeConfigSpec.ConfigValue<Integer> mithrilDamageReduction;
    public static ForgeConfigSpec.ConfigValue<Integer> netheriteDamageReduction;
    public static ForgeConfigSpec.ConfigValue<Integer> enderiteDamageReduction;

    public static ForgeConfigSpec.ConfigValue<Integer> woodenDurability;
    public static ForgeConfigSpec.ConfigValue<Integer> copperDurability;
    public static ForgeConfigSpec.ConfigValue<Integer> bronzeDurability;
    public static ForgeConfigSpec.ConfigValue<Integer> ironDurability;
    public static ForgeConfigSpec.ConfigValue<Integer> steelDurability;
    public static ForgeConfigSpec.ConfigValue<Integer> mithrilDurability;
    public static ForgeConfigSpec.ConfigValue<Integer> netheriteDurability;
    public static ForgeConfigSpec.ConfigValue<Integer> enderiteDurability;


    public static void init(ForgeConfigSpec.Builder SERVER_BUILDER)
    {
        //      biomeIn.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(Feature.ORE, new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Blocks.COAL_ORE.getDefaultState(), 17), Placement.COUNT_RANGE, new CountRangeConfig(20, 0, 0, 128)));
        //      biomeIn.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(Feature.ORE, new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Blocks.IRON_ORE.getDefaultState(), 9), Placement.COUNT_RANGE, new CountRangeConfig(20, 0, 0, 64)));
        //      biomeIn.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(Feature.ORE, new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Blocks.GOLD_ORE.getDefaultState(), 9), Placement.COUNT_RANGE, new CountRangeConfig(2, 0, 0, 32)));
        //      biomeIn.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(Feature.ORE, new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Blocks.REDSTONE_ORE.getDefaultState(), 8), Placement.COUNT_RANGE, new CountRangeConfig(8, 0, 0, 16)));
        //      biomeIn.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(Feature.ORE, new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Blocks.DIAMOND_ORE.getDefaultState(), 8), Placement.COUNT_RANGE, new CountRangeConfig(1, 0, 0, 16)));
        //      biomeIn.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(Feature.ORE, new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Blocks.LAPIS_ORE.getDefaultState(), 7), Placement.COUNT_DEPTH_AVERAGE, new DepthAverageConfig(1, 16, 16)));

        SERVER_BUILDER.comment("Bronze Age Condition").push("bronze_age_condition");

        ENABLE_BRONZE_AGE = SERVER_BUILDER.comment("Made for AATO Stone Age Compatibility [true / false]").define("enableBronzeAge", true);

        SERVER_BUILDER.pop();

        SERVER_BUILDER.comment("Mobs use Hard Steel Gear Instead of Vanilla").push("mobs_use_hard_steel_gear");

        MOBS_USE_HARD_STEEL_GEAR = SERVER_BUILDER.comment("Mobs use Hard Steel Gear Instead of Vanilla [true / false]").define("mobsUseHardSteelGear", true);

        SERVER_BUILDER.pop();

        SERVER_BUILDER.comment("Leather Drop Configuration").push("leather_drop_configuration");

        LEATHER_DROP_AMOUNT = SERVER_BUILDER.comment(
                "The amount of extra leather that can drop from the mobs in 'leatherDropMobs'.\nSetting this or leatherDropFromMobsChance to 0 disables the leather drop feature entirely")
                .defineInRange("leatherDropFromMobsAmount", 2, 0, 100);

        LEATHER_DROP_CHANCE = SERVER_BUILDER.comment(
                "The chance (out of 100) that the configured amount of extra leather can drop from the mobs in 'leatherDropMobs'.\nSetting this or leatherDropFromMobsAmount to 0 disables the leather drop feature entirely")
                .defineInRange("leatherDropFromMobsChance", 100, 0, 100);
        LEATHER_DROP_ENTITIES = SERVER_BUILDER
                .comment("Add mobs you want to drop an extra piece of leather when killed below.\n"
                        + "Use the name that appears when you type '/summon' in game and hit TAB, or more generally, modid:name.")
                .defineList("leatherDropMobs", Lists.newArrayList(new String[]
                        { "minecraft:cow", "minecraft:donkey",
                                "minecraft:horse", "minecraft:llama", "minecraft:mooshroom", "minecraft:mule",
                                "minecraft:trader_llama" }), (itemRaw) -> itemRaw instanceof String);

        SERVER_BUILDER.pop();

        SERVER_BUILDER.comment("Copper Ore Generation").push("copper_ore");

        COPPER_ORE_GENERATION = SERVER_BUILDER.comment("Generate Copper Ore in the world [true / false]").define("copperOreGeneration", true);
        COPPER_ORE_SIZE = SERVER_BUILDER.comment("Size of Copper Ore pockets [0-100, default: 9]").defineInRange("copperOreSize", 9, 0, 100);
        COPPER_ORE_CHANCE = SERVER_BUILDER.comment("Chances of Copper Ore pocket being generated [0-100, default: 20]").defineInRange("copperOreChance", 8, 0, 100);
        COPPER_ORE_MIN_HEIGHT = SERVER_BUILDER.comment("Minimal height for Copper Ore pocket generation, [0-255, default: 0]").defineInRange("copperOreMinHeight", 0, 0, 255);
        COPPER_ORE_MAX_HEIGHT = SERVER_BUILDER.comment("Maximal height for Copper Ore pocket generation [0-255, default: 128]").defineInRange("copperOreMaxHeight", 128, 0, 255);

        SERVER_BUILDER.pop();
                    
        SERVER_BUILDER.comment("Tin Ore Generation").push("tin_ore");

        TIN_ORE_GENERATION = SERVER_BUILDER.comment("Generate Tin Ore in the world [true / false]").define("tinOreGeneration", true);
        TIN_ORE_SIZE = SERVER_BUILDER.comment("Size of Tin Ore pockets [0-100, default: 9]").defineInRange("tinOreSize", 9, 0, 100);
        TIN_ORE_CHANCE = SERVER_BUILDER.comment("Chances of Tin Ore pocket being generated [0-100, default: 8]").defineInRange("tinOreChance", 2, 0, 100);
        TIN_ORE_MIN_HEIGHT = SERVER_BUILDER.comment("Minimal height for Tin Ore pocket generation, [0-255, default: 0]").defineInRange("tinOreMinHeight", 0, 0, 255);
        TIN_ORE_MAX_HEIGHT = SERVER_BUILDER.comment("Maximal height for Tin Ore pocket generation [0-255, default: 128]").defineInRange("tinOreMaxHeight", 128, 0, 255);

        SERVER_BUILDER.pop();

        SERVER_BUILDER.comment("Mithril Ore Generation").push("mithril_ore");

        MITHRIL_ORE_GENERATION = SERVER_BUILDER.comment("Generate Mithril Ore in the world [true / false]").define("mithrilOreGeneration", true);
        MITHRIL_ORE_SIZE = SERVER_BUILDER.comment("Size of Mithril Ore pockets [0-100, default: 3]").defineInRange("mithrilOreSize", 4, 0, 100);
        MITHRIL_ORE_CHANCE = SERVER_BUILDER.comment("Chances of Mithril Ore pocket being generated [0-100, default: 1]").defineInRange("mithrilOreChance", 1, 0, 100);
        MITHRIL_ORE_BASELINE_HEIGHT = SERVER_BUILDER.comment("Baseline height for Mithril Ore pocket generation, [0-255, default: 7]").defineInRange("mithrilOreBaseHeight", 8, 0, 255);
        MITHRIL_ORE_SPREAD = SERVER_BUILDER.comment("Spread from baseline for Mithril Ore pocket generation [0-255, default: 5]").defineInRange("mithrilOreSpread", 8, 0, 255);


        SECONDARY_MITHRIL_ORE_GENERATION = SERVER_BUILDER.comment("Generate secondary veins of  Mithril Ore in Extreme Hills biomes [true / false]").define("secondaryMithrilOreGeneration", true);
        SECONDARY_MITHRIL_ORE_SIZE = SERVER_BUILDER.comment("Size of secondary Mithril Ore pockets [0-100, default: 2]").defineInRange("secondaryMithrilOreSize", 6, 0, 100);
        SECONDARY_MITHRIL_ORE_CHANCE = SERVER_BUILDER.comment("Chances of secondary Mithril Ore pocket being generated [0-100, default: 1]").defineInRange("secondaryMithrilOreChance", 1, 0, 100);
        SECONDARY_MITHRIL_ORE_MIN_HEIGHT = SERVER_BUILDER.comment("Minimal height for secondary Mithril Ore pocket generation, [0-255, default: 0]").defineInRange("secondaryMithrilOreMinHeight", 0, 0, 255);
        SECONDARY_MITHRIL_ORE_MAX_HEIGHT = SERVER_BUILDER.comment("Maximal height for secondary Mithril Ore pocket generation [0-255, default: 32]").defineInRange("secondaryMithrilOreMaxHeight", 32, 0, 255);

        SERVER_BUILDER.pop();

        SERVER_BUILDER.comment("Limestone Generation").push("limestone");

        LIMESTONE_GENERATION = SERVER_BUILDER.comment("Generate Limestone in the world [true / false]").define("limestoneGeneration", true);
        LIMESTONE_SIZE = SERVER_BUILDER.comment("Size of Limestone pockets [0-100, default: 33]").defineInRange("limestoneSize", 33, 0, 100);
        LIMESTONE_CHANCE = SERVER_BUILDER.comment("Chances of Limestone pocket being generated [0-100, default: 10]").defineInRange("limestoneChance", 10, 0, 100);
        LIMESTONE_MIN_HEIGHT = SERVER_BUILDER.comment("Minimal height for Limestone pocket generation, [0-255, default: 0]").defineInRange("limestoneMinHeight", 0, 0, 255);
        LIMESTONE_MAX_HEIGHT = SERVER_BUILDER.comment("Maximal height for Limestone pocket generation [0-255, default: 255]").defineInRange("limestoneMaxHeight", 255, 0, 255);

        SERVER_BUILDER.pop();

        SERVER_BUILDER.comment("Ancient Debris Generation").push("ancient_debris");

        ANCIENT_DEBRIS_GENERATION = SERVER_BUILDER.comment("Generate Ancient Debris in the Nether [true / false]").define("ancientDebrisGeneration", true);
        ANCIENT_DEBRIS_SIZE = SERVER_BUILDER.comment("Size of Ancient Debris pockets [0-100, default: 3]").defineInRange("ancientDebrisSize", 3, 0, 100);
        ANCIENT_DEBRIS_CHANCE = SERVER_BUILDER.comment("Chances of Ancient Debris pocket being generated [0-100, default: 1]").defineInRange("ancientDebrisChance", 1, 0, 100);
        ANCIENT_DEBRIS_BASELINE_HEIGHT = SERVER_BUILDER.comment("Baseline height for Ancient Debris pocket generation, [0-255, default: 8]").defineInRange("ancientDebrisBaseHeight", 15, 0, 255);
        ANCIENT_DEBRIS_SPREAD = SERVER_BUILDER.comment("Spread from baseline for Ancient Debris pocket generation [0-255, default: 22]").defineInRange("ancientDebrisSpread", 7, 0, 255);

        SECONDARY_ANCIENT_DEBRIS_GENERATION = SERVER_BUILDER.comment("Generate secondary veins of Ancient Debris in the Nether [true / false]").define("secondaryAncientDebrisGeneration", true);
        SECONDARY_ANCIENT_DEBRIS_SIZE = SERVER_BUILDER.comment("Size of secondary Ancient Debris pockets [0-100, default: 2]").defineInRange("secondaryAncientDebrisSize", 2, 0, 100);
        SECONDARY_ANCIENT_DEBRIS_CHANCE = SERVER_BUILDER.comment("Chances of secondary Ancient Debris pocket being generated [0-100, default: 1]").defineInRange("secondaryAncientDebrisChance", 1, 0, 100);
        SECONDARY_ANCIENT_DEBRIS_MIN_HEIGHT = SERVER_BUILDER.comment("Minimal height for secondary Ancient Debris pocket generation, [0-255, default: 8]").defineInRange("secondaryAncientDebrisMinHeight", 8, 0, 255);
        SECONDARY_ANCIENT_DEBRIS_MAX_HEIGHT = SERVER_BUILDER.comment("Maximal height for secondary Ancient Debris pocket generation [0-255, default: 119]").defineInRange("secondaryAncientDebrisMaxHeight", 119, 0, 255);

        SERVER_BUILDER.pop();

        SERVER_BUILDER.comment("Elder Remnants Generation").push("elder_remnants");

        ELDER_REMNANTS_GENERATION = SERVER_BUILDER.comment("Generate Elder Remnants in The End [true / false]").define("elderRemnantsGeneration", true);
        ELDER_REMNANTS_SIZE = SERVER_BUILDER.comment("Size of Elder Remnants pockets [0-100, default: 3]").defineInRange("elderRemnantsSize", 3, 0, 100);
        ELDER_REMNANTS_CHANCE = SERVER_BUILDER.comment("Chances of Elder Remnants pocket being generated [0-100, default: 1]").defineInRange("elderRemnantsChance", 1, 0, 100);
        ELDER_REMNANTS_BASELINE_HEIGHT = SERVER_BUILDER.comment("Baseline height for Elder Remnants pocket generation, [0-255, default: 27]").defineInRange("elderRemnantsBaseHeight", 27, 0, 255);
        ELDER_REMNANTS_SPREAD = SERVER_BUILDER.comment("Spread from baseline for Elder Remnants pocket generation [0-255, default: 7]").defineInRange("elderRemnantsSpread", 7, 0, 255);

        SECONDARY_ELDER_REMNANTS_GENERATION = SERVER_BUILDER.comment("Generate Elder Remnants in The End [true / false]").define("secondaryElderRemnantsGeneration", true);
        //SECONDARY_ELDER_REMNANTS_SIZE = SERVER_BUILDER.comment("Size of Elder Remnants pockets [0-100, default: 3]").defineInRange("secondaryElderRemnantsSize", 3, 0, 100);
        SECONDARY_ELDER_REMNANTS_CHANCE = SERVER_BUILDER.comment("Chances of Elder Remnants pocket being generated [0-100, default: 1]").defineInRange("secondaryElderRemnantsChance", 1, 0, 100);
        SECONDARY_ELDER_REMNANTS_MIN_HEIGHT = SERVER_BUILDER.comment("Minimal height for Elder Remnants pocket generation, [0-255, default: 20]").defineInRange("secondaryElderRemnantsMinHeight", 20, 0, 255);
        SECONDARY_ELDER_REMNANTS_MAX_HEIGHT = SERVER_BUILDER.comment("Maximal height for Elder Remnants pocket generation [0-255, default: 70]").defineInRange("secondaryElderRemnantsMaxHeight", 70, 0, 255);

        SERVER_BUILDER.pop();

        SERVER_BUILDER.comment("Armor and Tool Configuration").push("armor_and_tool_configuration");

        COPPER_ARMOR_DURABILITY = SERVER_BUILDER.comment("Durability Multiplier of Copper Armor [1-100, default: 5]").defineInRange("copperArmorDurability", 7, 1, 100);
        BRONZE_ARMOR_DURABILITY = SERVER_BUILDER.comment("Durability Multiplier of Bronze Armor [1-100, default: 5]").defineInRange("bronzeArmorDurability", 14, 1, 100);
        IRON_ARMOR_DURABILITY = SERVER_BUILDER.comment("Durability Multiplier of Iron Armor [1-100, default: 5]").defineInRange("ironArmorDurability", 14, 1, 100);
        STEEL_ARMOR_DURABILITY = SERVER_BUILDER.comment("Durability Multiplier of Steel Armor [1-100, default: 5]").defineInRange("steelArmorDurability", 21, 1, 100);
        MITHRIL_ARMOR_DURABILITY = SERVER_BUILDER.comment("Durability of Mithril Armor [1-10000, default: 1000]").defineInRange("mithrilArmorDurability", 28, 1, 100);
        NETHERITE_ARMOR_DURABILITY = SERVER_BUILDER.comment("Durability Multiplier of Netherite Armor [1-100, default: 5]").defineInRange("netheriteArmorDurability", 35, 1, 100);
        ENDERITE_ARMOR_DURABILITY = SERVER_BUILDER.comment("Durability Multiplier of Enderite Armor [1-100, default: 5]").defineInRange("enderiteArmorDurability", 35, 1, 100);

        FLINT_TOOL_DURABILITY = SERVER_BUILDER.comment("Durability of Flint Tools [1-10000, default: 5]").defineInRange("flintToolDurability", 65, 1, 10000);
        COPPER_TOOL_DURABILITY = SERVER_BUILDER.comment("Durability of Copper Tools [1-10000, default: 5]").defineInRange("copperToolDurability", 125, 1, 10000);
        BRONZE_TOOL_DURABILITY = SERVER_BUILDER.comment("Durability of Bronze Tools [1-10000, default: 5]").defineInRange("bronzeToolDurability", 250, 1, 10000);
        IRON_TOOL_DURABILITY = SERVER_BUILDER.comment("Durability of Iron Tools [1-10000, default: 5]").defineInRange("ironToolDurability", 250, 1, 10000);
        STEEL_TOOL_DURABILITY = SERVER_BUILDER.comment("Durability of Steel Tools [1-10000, default: 5]").defineInRange("steelToolDurability", 500, 1, 10000);
        MITHRIL_TOOL_DURABILITY = SERVER_BUILDER.comment("Durability of Mithril Tools [1-10000, default: 1000]").defineInRange("mithrilToolDurability", 1000, 1, 10000);
        NETHERITE_TOOL_DURABILITY = SERVER_BUILDER.comment("Durability of Netherite Tools [1-10000, default: 5]").defineInRange("netheriteToolDurability", 2000, 1, 10000);
        ENDERITE_TOOL_DURABILITY = SERVER_BUILDER.comment("Durability of Enderite Tools [1-10000, default: 5]").defineInRange("enderiteToolDurability", 2000, 1, 10000);

        SERVER_BUILDER.pop();

        SERVER_BUILDER.comment("Remove Vanilla Gear Recipes").push("remove_vanilla_gear_recipes");

        REMOVE_VANILLA_SHIELD_RECIPE = SERVER_BUILDER.comment("Remove vanilla shield recipe [true / false]").define("removeVanillaShieldRecipes", true);
        REMOVE_WOODEN_TOOL_RECIPES = SERVER_BUILDER.comment("Remove wooden tool recipes [true / false]").define("removeWoodenToolRecipes", true);
        REMOVE_STONE_TOOL_RECIPES = SERVER_BUILDER.comment("Remove stone tool recipes [true / false]").define("removeStoneToolRecipes", true);
        REMOVE_IRON_GEAR_RECIPES = SERVER_BUILDER.comment("Remove iron armor and tool recipes [true / false]").define("removeIronGearRecipes", true);
        REMOVE_GOLDEN_GEAR_RECIPES = SERVER_BUILDER.comment("Remove golden armor and tool recipes [true / false]").define("removeGoldenGearRecipes", true);
        REMOVE_DIAMOND_GEAR_RECIPES = SERVER_BUILDER.comment("Remove iron armor and tool recipes [true / false]").define("removeDiamondGearRecipes", true);

        SERVER_BUILDER.pop();

        SERVER_BUILDER.comment("Smithing Table Configuration").push("smithing_table_configuration");
        repair_cost_cap = SERVER_BUILDER
                .comment("Repair Cost Cap")
                .defineInRange("repair_cost_cap",80,1,Integer.MAX_VALUE);
        prior_work_penalty = SERVER_BUILDER
                .comment("Prior Work Penalty")
                .define("prior_work_penalty",false);
        cheap_renaming = SERVER_BUILDER
                .comment("Smithing Table renaming always costs 1 level")
                .define("cheap_renaming",true);

        SERVER_BUILDER.pop();

        SERVER_BUILDER.comment("Anvil Configuration").push("anvil_configuration");
        anvil_repair_cost_cap = SERVER_BUILDER
                .comment("Repair cost cap")
                .defineInRange("repair_cost_cap",40,1,Integer.MAX_VALUE);
        anvil_prior_work_penalty = SERVER_BUILDER
                .comment("Prior Work Penalty")
                .define("prior_work_penalty",true);
        anvil_damageable = SERVER_BUILDER
                .comment("Does anvil take damage")
                .define("damageable",false);
        anvil_damage_chance = SERVER_BUILDER
                .comment("Damage chance")
                .defineInRange("damage_chance",.12,0,1);
        anvil_cheap_renaming = SERVER_BUILDER
                .comment("Anvil renaming always costs 1 level")
                .define("cheap_renaming",true);

        SERVER_BUILDER.pop();

        SERVER_BUILDER.comment("Shield Configuration").push("shield_configuration");
        customShieldMaxReduction = SERVER_BUILDER.comment("\"If set to true Shields added by other mods block 100% of the incoming damage, \"\n" +
                "                        + \"if set to false they will block the amount set in defaultDamageReduction [true /false]\"").define("customShieldMaxReduction", true);

        thornsOnShields = SERVER_BUILDER.comment("Allows the Thorns enchantment to by applied to Shields [true / false]").define("thornsOnShields", true);

        defaultDamageReduction = SERVER_BUILDER.comment("The portion of the incoming damage vanilla Shields block in percent [1-100, default: 70]").defineInRange("defaultDamageReduction", 70, 1, 100);

        woodenDamageReduction = SERVER_BUILDER.comment("The portion of the incoming damage Wooden Shields block in percent [1-100, default: 70]").defineInRange("woodenDamageReduction", 70, 1, 100);

        copperDamageReduction = SERVER_BUILDER.comment("The portion of the incoming damage Copper Shields block in percent [1-100, default: 80]").defineInRange("copperDamageReduction", 80, 1, 100);

        bronzeDamageReduction = SERVER_BUILDER.comment("The portion of the incoming damage Bronze Shields block in percent [1-100, default: 90]").defineInRange("bronzeDamageReduction", 90, 1, 100);

        ironDamageReduction = SERVER_BUILDER.comment("The portion of the incoming damage Iron Shields block in percent [1-100, default: 90]").defineInRange("ironDamageReduction", 90, 1, 100);

        steelDamageReduction = SERVER_BUILDER.comment("The portion of the incoming damage Steel Shields block in percent [1-100, default: 100]").defineInRange("steelDamageReduction", 100, 1, 100);

        mithrilDamageReduction = SERVER_BUILDER.comment("The portion of the incoming damage Mithril Shields block in percent [1-100, default: 100]").defineInRange("mithrilDamageReduction", 100, 1, 100);

        netheriteDamageReduction = SERVER_BUILDER.comment("The portion of the incoming damage Netherite Shields block in percent [1-100, default: 100]").defineInRange("netheriteDamageReduction", 100, 1, 100);

        enderiteDamageReduction = SERVER_BUILDER.comment("The portion of the incoming damage Enderite Shields block in percent [1-100, default: 100]").defineInRange("enderiteDamageReduction", 100, 1, 100);

        // multiply armor metal's durability multiplier by 32 for each metal's shield

        woodenDurability = SERVER_BUILDER.comment("The durability of the Wooden Shield [1-10000, default: 96]").defineInRange("woodenDurability", 128, 1, 10000);

        copperDurability = SERVER_BUILDER.comment("The durability of the Copper Shield [1-10000, default: 168]").defineInRange("copperDurability", 224, 1, 10000);

        ironDurability = SERVER_BUILDER.comment("The durability of the Bronze Shield [1-10000, default: 336]").defineInRange("bronzeDurability", 448, 1, 10000);

        ironDurability = SERVER_BUILDER.comment("The durability of the Iron Shield [1-10000, default: 336]").defineInRange("ironDurability", 448, 1, 10000);

        steelDurability = SERVER_BUILDER.comment("The durability of the Steel Shield [1-10000, default: 504]").defineInRange("steelDurability", 672, 1, 10000);

        mithrilDurability = SERVER_BUILDER.comment("The durability of the Mithril Shield [1-10000, default: 672]").defineInRange("mithrilDurability", 896, 1, 10000);

        netheriteDurability = SERVER_BUILDER.comment("The durability of the Netherite Shield [1-10000, default: 840]").defineInRange("netheriteDurability", 1120, 1, 10000);

        enderiteDurability = SERVER_BUILDER.comment("The durability of the Enderite Shield [1-10000, default: 1008]").defineInRange("enderiteDurability", 1344, 1, 10000);

        SERVER_BUILDER.pop();
    }
}