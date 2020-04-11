package com.infamous.hard_steel.init;

import com.infamous.hard_steel.chainmail.*;
import com.infamous.hard_steel.items.enderite.*;
import com.infamous.hard_steel.items.flint.*;
import com.infamous.hard_steel.items.netherite.*;
import com.infamous.hard_steel.items.copper.*;
import com.infamous.hard_steel.items.iron.*;
import com.infamous.hard_steel.items.steel.*;
import com.infamous.hard_steel.items.mithril.*;
import com.infamous.hard_steel.lists.ArmorMaterialList;
import com.infamous.hard_steel.lists.BlockList;
import com.infamous.hard_steel.lists.ItemList;
import com.infamous.hard_steel.lists.ToolMaterialList;
import com.infamous.hard_steel.HardSteel;
import com.infamous.hard_steel.items.bronze.*;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

public class ItemInit
{
	@Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD)
	public static class RegistryEvents
	{
		@SubscribeEvent
		public static void registerItems(final RegistryEvent.Register<Item> event)
		{
			event.getRegistry().registerAll
			(
					ItemList.sharp_flint = new Item(new Item.Properties().group(HardSteel.hard_steel)).setRegistryName(location("sharp_flint")),

				ItemList.tin_ore = new BlockItem(BlockList.tin_ore, new Item.Properties().group(HardSteel.hard_steel)).setRegistryName(BlockList.tin_ore.getRegistryName()),
				ItemList.copper_ore = new BlockItem(BlockList.copper_ore, new Item.Properties().group(HardSteel.hard_steel)).setRegistryName(BlockList.copper_ore.getRegistryName()),
					ItemList.mithril_ore = new BlockItem(BlockList.mithril_ore, new Item.Properties().group(HardSteel.hard_steel)).setRegistryName(BlockList.mithril_ore.getRegistryName()),
					ItemList.ancient_debris = new BlockItem(BlockList.ancient_debris, new Item.Properties().group(HardSteel.hard_steel)).setRegistryName(BlockList.ancient_debris.getRegistryName()),
					ItemList.elder_remnants = new BlockItem(BlockList.elder_remnants, new Item.Properties().group(HardSteel.hard_steel)).setRegistryName(BlockList.elder_remnants.getRegistryName()),

					ItemList.iron_bloom = new BlockItem(BlockList.iron_bloom, new Item.Properties().group(HardSteel.hard_steel)).setRegistryName(BlockList.iron_bloom.getRegistryName()),
					ItemList.carbonized_iron_ore = new BlockItem(BlockList.carbonized_iron_ore, new Item.Properties().group(HardSteel.hard_steel)).setRegistryName(BlockList.carbonized_iron_ore.getRegistryName()),
					ItemList.steel_bloom = new BlockItem(BlockList.steel_bloom, new Item.Properties().group(HardSteel.hard_steel)).setRegistryName(BlockList.steel_bloom.getRegistryName()),

					ItemList.limestone = new BlockItem(BlockList.limestone, new Item.Properties().group(HardSteel.hard_steel)).setRegistryName(BlockList.limestone.getRegistryName()),

					ItemList.netherite_scrap = new Item(new Item.Properties().group(HardSteel.hard_steel)).setRegistryName(location("netherite_scrap")),
					ItemList.enderite_scrap = new Item(new Item.Properties().group(HardSteel.hard_steel)).setRegistryName(location("enderite_scrap")),

					ItemList.bronze_blend = new Item(new Item.Properties().group(HardSteel.hard_steel)).setRegistryName(location("bronze_blend")),
					ItemList.netherite_blend = new Item(new Item.Properties().group(HardSteel.hard_steel)).setRegistryName(location("netherite_blend")),
					ItemList.enderite_blend = new Item(new Item.Properties().group(HardSteel.hard_steel)).setRegistryName(location("enderite_blend")),

					ItemList.tin_ingot = new Item(new Item.Properties().group(HardSteel.hard_steel)).setRegistryName(location("tin_ingot")),
					ItemList.copper_ingot = new Item(new Item.Properties().group(HardSteel.hard_steel)).setRegistryName(location("copper_ingot")),
					ItemList.bronze_ingot = new Item(new Item.Properties().group(HardSteel.hard_steel)).setRegistryName(location("bronze_ingot")),
					ItemList.carbonized_iron_ingot = new Item(new Item.Properties().group(HardSteel.hard_steel)).setRegistryName(location("carbonized_iron_ingot")),
					ItemList.bloomery_steel_ingot = new Item(new Item.Properties().group(HardSteel.hard_steel)).setRegistryName(location("bloomery_steel_ingot")),
					ItemList.blister_steel_ingot = new Item(new Item.Properties().group(HardSteel.hard_steel)).setRegistryName(location("blister_steel_ingot")),
					ItemList.pig_iron_ingot = new Item(new Item.Properties().group(HardSteel.hard_steel)).setRegistryName(location("pig_iron_ingot")),
				ItemList.steel_ingot = new Item(new Item.Properties().group(HardSteel.hard_steel)).setRegistryName(location("steel_ingot")),
					ItemList.mithril_ingot = new Item(new Item.Properties().group(HardSteel.hard_steel)).setRegistryName(location("mithril_ingot")),
					ItemList.netherite_ingot = new Item(new Item.Properties().group(HardSteel.hard_steel)).setRegistryName(location("netherite_ingot")),
					ItemList.enderite_ingot = new Item(new Item.Properties().group(HardSteel.hard_steel)).setRegistryName(location("enderite_ingot")),

					ItemList.copper_chain = new Item(new Item.Properties().group(HardSteel.hard_steel)).setRegistryName(location("copper_chain")),
					ItemList.bronze_chain = new Item(new Item.Properties().group(HardSteel.hard_steel)).setRegistryName(location("bronze_chain")),
					ItemList.iron_chain = new Item(new Item.Properties().group(HardSteel.hard_steel)).setRegistryName(location("iron_chain")),
					ItemList.steel_chain = new Item(new Item.Properties().group(HardSteel.hard_steel)).setRegistryName(location("steel_chain")),
					ItemList.mithril_chain = new Item(new Item.Properties().group(HardSteel.hard_steel)).setRegistryName(location("mithril_chain")),
					ItemList.netherite_chain = new Item(new Item.Properties().group(HardSteel.hard_steel)).setRegistryName(location("netherite_chain")),
					ItemList.enderite_chain = new Item(new Item.Properties().group(HardSteel.hard_steel)).setRegistryName(location("enderite_chain")),

					ItemList.coal_nugget = new Item(new Item.Properties().group(HardSteel.hard_steel)).setRegistryName(location("coal_nugget")),
					ItemList.tin_nugget = new Item(new Item.Properties().group(HardSteel.hard_steel)).setRegistryName(location("tin_nugget")),
					ItemList.copper_nugget = new Item(new Item.Properties().group(HardSteel.hard_steel)).setRegistryName(location("copper_nugget")),
					ItemList.bronze_nugget = new Item(new Item.Properties().group(HardSteel.hard_steel)).setRegistryName(location("bronze_nugget")),
					ItemList.bloomery_steel_nugget = new Item(new Item.Properties().group(HardSteel.hard_steel)).setRegistryName(location("bloomery_steel_nugget")),
					ItemList.steel_nugget = new Item(new Item.Properties().group(HardSteel.hard_steel)).setRegistryName(location("steel_nugget")),
					ItemList.mithril_nugget = new Item(new Item.Properties().group(HardSteel.hard_steel)).setRegistryName(location("mithril_nugget")),
					ItemList.netherite_nugget = new Item(new Item.Properties().group(HardSteel.hard_steel)).setRegistryName(location("netherite_nugget")),
					ItemList.enderite_nugget = new Item(new Item.Properties().group(HardSteel.hard_steel)).setRegistryName(location("enderite_nugget")),

					ItemList.tin_block = new BlockItem(BlockList.tin_block, new Item.Properties().group(HardSteel.hard_steel)).setRegistryName(BlockList.tin_block.getRegistryName()),
					ItemList.copper_block = new BlockItem(BlockList.copper_block, new Item.Properties().group(HardSteel.hard_steel)).setRegistryName(BlockList.copper_block.getRegistryName()),
					ItemList.bronze_block = new BlockItem(BlockList.bronze_block, new Item.Properties().group(HardSteel.hard_steel)).setRegistryName(BlockList.bronze_block.getRegistryName()),
				ItemList.steel_block = new BlockItem(BlockList.steel_block, new Item.Properties().group(HardSteel.hard_steel)).setRegistryName(BlockList.steel_block.getRegistryName()),
					ItemList.mithril_block = new BlockItem(BlockList.mithril_block, new Item.Properties().group(HardSteel.hard_steel)).setRegistryName(BlockList.mithril_block.getRegistryName()),
					ItemList.netherite_block = new BlockItem(BlockList.netherite_block, new Item.Properties().group(HardSteel.hard_steel)).setRegistryName(BlockList.netherite_block.getRegistryName()),
					ItemList.enderite_block = new BlockItem(BlockList.enderite_block, new Item.Properties().group(HardSteel.hard_steel)).setRegistryName(BlockList.enderite_block.getRegistryName()),

					ItemList.flint_knife = new FlintKnife(ToolMaterialList.flint, 3, -2.4f, new Item.Properties().group(HardSteel.hard_steel)).setRegistryName(location("flint_knife")),
					ItemList.flint_pick = new FlintPick(ToolMaterialList.flint, 1, -2.8f, new Item.Properties().group(HardSteel.hard_steel)).setRegistryName(location("flint_pick")),
					ItemList.flint_hatchet = new FlintHatchet(ToolMaterialList.flint, 5, -3.1f, new Item.Properties().group(HardSteel.hard_steel)).setRegistryName(location("flint_hatchet")),
					ItemList.flint_spade = new FlintSpade(ToolMaterialList.flint, 1, -3.0f, new Item.Properties().group(HardSteel.hard_steel)).setRegistryName(location("flint_spade")),
					ItemList.flint_hoe = new FlintHoe(ToolMaterialList.flint, 0, -2.0f, new Item.Properties().group(HardSteel.hard_steel)).setRegistryName(location("flint_hoe")),

					ItemList.copper_sword = new CopperSword(ToolMaterialList.copper, 3, -2.4f, new Item.Properties().group(HardSteel.hard_steel)).setRegistryName(location("copper_sword")),
					ItemList.copper_pickaxe = new CopperPickaxe(ToolMaterialList.copper, 1, -2.8f, new Item.Properties().group(HardSteel.hard_steel)).setRegistryName(location("copper_pickaxe")),
					ItemList.copper_axe = new CopperAxe(ToolMaterialList.copper, 5, -3.1f, new Item.Properties().group(HardSteel.hard_steel)).setRegistryName(location("copper_axe")),
					ItemList.copper_shovel = new CopperShovel(ToolMaterialList.copper, 1, -3.0f, new Item.Properties().group(HardSteel.hard_steel)).setRegistryName(location("copper_shovel")),
					ItemList.copper_hoe = new CopperHoe(ToolMaterialList.copper,0,  -2.0f, new Item.Properties().group(HardSteel.hard_steel)).setRegistryName(location("copper_hoe")),

					ItemList.bronze_sword = new BronzeSword(ToolMaterialList.bronze, 3, -2.4f, new Item.Properties().group(HardSteel.hard_steel)).setRegistryName(location("bronze_sword")),
				ItemList.bronze_pickaxe = new BronzePickaxe(ToolMaterialList.bronze, 1, -2.8f, new Item.Properties().group(HardSteel.hard_steel)).setRegistryName(location("bronze_pickaxe")),
				ItemList.bronze_axe = new BronzeAxe(ToolMaterialList.bronze, 5, -3.1f, new Item.Properties().group(HardSteel.hard_steel)).setRegistryName(location("bronze_axe")),
				ItemList.bronze_shovel = new BronzeShovel(ToolMaterialList.bronze, 1, -3.0f, new Item.Properties().group(HardSteel.hard_steel)).setRegistryName(location("bronze_shovel")),
				ItemList.bronze_hoe = new BronzeHoe(ToolMaterialList.bronze, 0, -2.0f, new Item.Properties().group(HardSteel.hard_steel)).setRegistryName(location("bronze_hoe")),

					ItemList.iron_sword = new IronSword(ToolMaterialList.iron, 3, -2.4f, new Item.Properties().group(HardSteel.hard_steel)).setRegistryName(location("iron_sword")),
					ItemList.iron_pickaxe = new IronPickaxe(ToolMaterialList.iron, 1, -2.8f, new Item.Properties().group(HardSteel.hard_steel)).setRegistryName(location("iron_pickaxe")),
					ItemList.iron_axe = new IronAxe(ToolMaterialList.iron, 5, -3.1f, new Item.Properties().group(HardSteel.hard_steel)).setRegistryName(location("iron_axe")),
					ItemList.iron_shovel = new IronShovel(ToolMaterialList.iron, 1, -3.0f, new Item.Properties().group(HardSteel.hard_steel)).setRegistryName(location("iron_shovel")),
					ItemList.iron_hoe = new IronHoe(ToolMaterialList.iron,0,  -2.0f, new Item.Properties().group(HardSteel.hard_steel)).setRegistryName(location("iron_hoe")),

					ItemList.steel_sword = new SteelSword(ToolMaterialList.steel, 3, -2.4f, new Item.Properties().group(HardSteel.hard_steel)).setRegistryName(location("steel_sword")),
				ItemList.steel_pickaxe = new SteelPickaxe(ToolMaterialList.steel, 1, -2.8f, new Item.Properties().group(HardSteel.hard_steel)).setRegistryName(location("steel_pickaxe")),
				ItemList.steel_axe = new SteelAxe(ToolMaterialList.steel, 5, -3.1f, new Item.Properties().group(HardSteel.hard_steel)).setRegistryName(location("steel_axe")),
				ItemList.steel_shovel = new SteelShovel(ToolMaterialList.steel, 1, -3.0f, new Item.Properties().group(HardSteel.hard_steel)).setRegistryName(location("steel_shovel")),
				ItemList.steel_hoe = new SteelHoe(ToolMaterialList.steel,0,  -2.0f, new Item.Properties().group(HardSteel.hard_steel)).setRegistryName(location("steel_hoe")),

					ItemList.mithril_sword = new MithrilSword(ToolMaterialList.mithril, 3, -2.4f, new Item.Properties().group(HardSteel.hard_steel)).setRegistryName(location("mithril_sword")),
					ItemList.mithril_pickaxe = new MithrilPickaxe(ToolMaterialList.mithril, 1, -2.8f, new Item.Properties().group(HardSteel.hard_steel)).setRegistryName(location("mithril_pickaxe")),
					ItemList.mithril_axe = new MithrilAxe(ToolMaterialList.mithril, 5, -3.1f, new Item.Properties().group(HardSteel.hard_steel)).setRegistryName(location("mithril_axe")),
					ItemList.mithril_shovel = new MithrilShovel(ToolMaterialList.mithril, 1, -3.0f, new Item.Properties().group(HardSteel.hard_steel)).setRegistryName(location("mithril_shovel")),
					ItemList.mithril_hoe = new MithrilHoe(ToolMaterialList.mithril,0,  -2.0f, new Item.Properties().group(HardSteel.hard_steel)).setRegistryName(location("mithril_hoe")),

					ItemList.netherite_sword = new NetheriteSword(ToolMaterialList.netherite, 3, -2.4f, new Item.Properties().group(HardSteel.hard_steel)).setRegistryName(location("netherite_sword")),
					ItemList.netherite_pickaxe = new NetheritePickaxe(ToolMaterialList.netherite, 1, -2.8f, new Item.Properties().group(HardSteel.hard_steel)).setRegistryName(location("netherite_pickaxe")),
					ItemList.netherite_axe = new NetheriteAxe(ToolMaterialList.netherite, 5, -3.1f, new Item.Properties().group(HardSteel.hard_steel)).setRegistryName(location("netherite_axe")),
					ItemList.netherite_shovel = new NetheriteShovel(ToolMaterialList.netherite, 1, -3.0f, new Item.Properties().group(HardSteel.hard_steel)).setRegistryName(location("netherite_shovel")),
					ItemList.netherite_hoe = new NetheriteHoe(ToolMaterialList.netherite,0,  -2.0f, new Item.Properties().group(HardSteel.hard_steel)).setRegistryName(location("netherite_hoe")),

					ItemList.enderite_sword = new EnderiteSword(ToolMaterialList.enderite, 3, -2.4f, new Item.Properties().group(HardSteel.hard_steel)).setRegistryName(location("enderite_sword")),
					ItemList.enderite_pickaxe = new EnderitePickaxe(ToolMaterialList.enderite, 1, -2.8f, new Item.Properties().group(HardSteel.hard_steel)).setRegistryName(location("enderite_pickaxe")),
					ItemList.enderite_axe = new EnderiteAxe(ToolMaterialList.enderite, 5, -3.1f, new Item.Properties().group(HardSteel.hard_steel)).setRegistryName(location("enderite_axe")),
					ItemList.enderite_shovel = new EnderiteShovel(ToolMaterialList.enderite, 1, -3.0f, new Item.Properties().group(HardSteel.hard_steel)).setRegistryName(location("enderite_shovel")),
					ItemList.enderite_hoe = new EnderiteHoe(ToolMaterialList.enderite,0,  -2.0f, new Item.Properties().group(HardSteel.hard_steel)).setRegistryName(location("enderite_hoe")),

					ItemList.copper_helmet = new ArmorCopper(ArmorMaterialList.copper, EquipmentSlotType.HEAD, new Item.Properties().group(HardSteel.hard_steel)).setRegistryName(location("copper_helmet")),
					ItemList.copper_chestplate = new ArmorCopper(ArmorMaterialList.copper, EquipmentSlotType.CHEST, new Item.Properties().group(HardSteel.hard_steel)).setRegistryName(location("copper_chestplate")),
					ItemList.copper_leggings = new ArmorCopper(ArmorMaterialList.copper, EquipmentSlotType.LEGS, new Item.Properties().group(HardSteel.hard_steel)).setRegistryName(location("copper_leggings")),
					ItemList.copper_boots = new ArmorCopper(ArmorMaterialList.copper, EquipmentSlotType.FEET, new Item.Properties().group(HardSteel.hard_steel)).setRegistryName(location("copper_boots")),

					ItemList.bronze_helmet = new ArmorBronze(ArmorMaterialList.bronze, EquipmentSlotType.HEAD, new Item.Properties().group(HardSteel.hard_steel)).setRegistryName(location("bronze_helmet")),
				ItemList.bronze_chestplate = new ArmorBronze(ArmorMaterialList.bronze, EquipmentSlotType.CHEST, new Item.Properties().group(HardSteel.hard_steel)).setRegistryName(location("bronze_chestplate")),
				ItemList.bronze_leggings = new ArmorBronze(ArmorMaterialList.bronze, EquipmentSlotType.LEGS, new Item.Properties().group(HardSteel.hard_steel)).setRegistryName(location("bronze_leggings")),
				ItemList.bronze_boots = new ArmorBronze(ArmorMaterialList.bronze, EquipmentSlotType.FEET, new Item.Properties().group(HardSteel.hard_steel)).setRegistryName(location("bronze_boots")),

					ItemList.iron_helmet = new ArmorIron(ArmorMaterialList.iron, EquipmentSlotType.HEAD, new Item.Properties().group(HardSteel.hard_steel)).setRegistryName(location("iron_helmet")),
					ItemList.iron_chestplate = new ArmorIron(ArmorMaterialList.iron, EquipmentSlotType.CHEST, new Item.Properties().group(HardSteel.hard_steel)).setRegistryName(location("iron_chestplate")),
					ItemList.iron_leggings = new ArmorIron(ArmorMaterialList.iron, EquipmentSlotType.LEGS, new Item.Properties().group(HardSteel.hard_steel)).setRegistryName(location("iron_leggings")),
					ItemList.iron_boots = new ArmorIron(ArmorMaterialList.iron, EquipmentSlotType.FEET, new Item.Properties().group(HardSteel.hard_steel)).setRegistryName(location("iron_boots")),

				ItemList.steel_helmet = new ArmorSteel(ArmorMaterialList.steel, EquipmentSlotType.HEAD, new Item.Properties().group(HardSteel.hard_steel)).setRegistryName(location("steel_helmet")),
				ItemList.steel_chestplate = new ArmorSteel(ArmorMaterialList.steel, EquipmentSlotType.CHEST, new Item.Properties().group(HardSteel.hard_steel)).setRegistryName(location("steel_chestplate")),
				ItemList.steel_leggings = new ArmorSteel(ArmorMaterialList.steel, EquipmentSlotType.LEGS, new Item.Properties().group(HardSteel.hard_steel)).setRegistryName(location("steel_leggings")),
				ItemList.steel_boots = new ArmorSteel(ArmorMaterialList.steel, EquipmentSlotType.FEET, new Item.Properties().group(HardSteel.hard_steel)).setRegistryName(location("steel_boots")),

					ItemList.mithril_helmet = new ArmorMithril(ArmorMaterialList.mithril, EquipmentSlotType.HEAD, new Item.Properties().group(HardSteel.hard_steel)).setRegistryName(location("mithril_helmet")),
					ItemList.mithril_chestplate = new ArmorMithril(ArmorMaterialList.mithril, EquipmentSlotType.CHEST, new Item.Properties().group(HardSteel.hard_steel)).setRegistryName(location("mithril_chestplate")),
					ItemList.mithril_leggings = new ArmorMithril(ArmorMaterialList.mithril, EquipmentSlotType.LEGS, new Item.Properties().group(HardSteel.hard_steel)).setRegistryName(location("mithril_leggings")),
					ItemList.mithril_boots = new ArmorMithril(ArmorMaterialList.mithril, EquipmentSlotType.FEET, new Item.Properties().group(HardSteel.hard_steel)).setRegistryName(location("mithril_boots")),

					ItemList.netherite_helmet = new ArmorNetherite(ArmorMaterialList.netherite, EquipmentSlotType.HEAD, new Item.Properties().group(HardSteel.hard_steel)).setRegistryName(location("netherite_helmet")),
					ItemList.netherite_chestplate = new ArmorNetherite(ArmorMaterialList.netherite, EquipmentSlotType.CHEST, new Item.Properties().group(HardSteel.hard_steel)).setRegistryName(location("netherite_chestplate")),
					ItemList.netherite_leggings = new ArmorNetherite(ArmorMaterialList.netherite, EquipmentSlotType.LEGS, new Item.Properties().group(HardSteel.hard_steel)).setRegistryName(location("netherite_leggings")),
					ItemList.netherite_boots = new ArmorNetherite(ArmorMaterialList.netherite, EquipmentSlotType.FEET, new Item.Properties().group(HardSteel.hard_steel)).setRegistryName(location("netherite_boots")),

					ItemList.enderite_helmet = new ArmorEnderite(ArmorMaterialList.enderite, EquipmentSlotType.HEAD, new Item.Properties().group(HardSteel.hard_steel)).setRegistryName(location("enderite_helmet")),
					ItemList.enderite_chestplate = new ArmorEnderite(ArmorMaterialList.enderite, EquipmentSlotType.CHEST, new Item.Properties().group(HardSteel.hard_steel)).setRegistryName(location("enderite_chestplate")),
					ItemList.enderite_leggings = new ArmorEnderite(ArmorMaterialList.enderite, EquipmentSlotType.LEGS, new Item.Properties().group(HardSteel.hard_steel)).setRegistryName(location("enderite_leggings")),
					ItemList.enderite_boots = new ArmorEnderite(ArmorMaterialList.enderite, EquipmentSlotType.FEET, new Item.Properties().group(HardSteel.hard_steel)).setRegistryName(location("enderite_boots")),

					ItemList.copper_chainhead = new ArmorCopperChainmail(ChainmailArmorMaterialList.copper_chainmail, EquipmentSlotType.HEAD, new Item.Properties().group(HardSteel.hard_steel)).setRegistryName(location("copper_chainhead")),
					ItemList.copper_chainbody = new ArmorCopperChainmail(ChainmailArmorMaterialList.copper_chainmail, EquipmentSlotType.CHEST, new Item.Properties().group(HardSteel.hard_steel)).setRegistryName(location("copper_chainbody")),
					ItemList.copper_chainlegs = new ArmorCopperChainmail(ChainmailArmorMaterialList.copper_chainmail, EquipmentSlotType.LEGS, new Item.Properties().group(HardSteel.hard_steel)).setRegistryName(location("copper_chainlegs")),
					ItemList.copper_chainfeet = new ArmorCopperChainmail(ChainmailArmorMaterialList.copper_chainmail, EquipmentSlotType.FEET, new Item.Properties().group(HardSteel.hard_steel)).setRegistryName(location("copper_chainfeet")),

					ItemList.bronze_chainhead = new ArmorBronzeChainmail(ChainmailArmorMaterialList.bronze_chainmail, EquipmentSlotType.HEAD, new Item.Properties().group(HardSteel.hard_steel)).setRegistryName(location("bronze_chainhead")),
					ItemList.bronze_chainbody = new ArmorBronzeChainmail(ChainmailArmorMaterialList.bronze_chainmail, EquipmentSlotType.CHEST, new Item.Properties().group(HardSteel.hard_steel)).setRegistryName(location("bronze_chainbody")),
					ItemList.bronze_chainlegs = new ArmorBronzeChainmail(ChainmailArmorMaterialList.bronze_chainmail, EquipmentSlotType.LEGS, new Item.Properties().group(HardSteel.hard_steel)).setRegistryName(location("bronze_chainlegs")),
					ItemList.bronze_chainfeet = new ArmorBronzeChainmail(ChainmailArmorMaterialList.bronze_chainmail, EquipmentSlotType.FEET, new Item.Properties().group(HardSteel.hard_steel)).setRegistryName(location("bronze_chainfeet")),

					ItemList.iron_chainhead = new ArmorIronChainmail(ChainmailArmorMaterialList.iron_chainmail, EquipmentSlotType.HEAD, new Item.Properties().group(HardSteel.hard_steel)).setRegistryName(location("iron_chainhead")),
					ItemList.iron_chainbody = new ArmorIronChainmail(ChainmailArmorMaterialList.iron_chainmail, EquipmentSlotType.CHEST, new Item.Properties().group(HardSteel.hard_steel)).setRegistryName(location("iron_chainbody")),
					ItemList.iron_chainlegs = new ArmorIronChainmail(ChainmailArmorMaterialList.iron_chainmail, EquipmentSlotType.LEGS, new Item.Properties().group(HardSteel.hard_steel)).setRegistryName(location("iron_chainlegs")),
					ItemList.iron_chainfeet = new ArmorIronChainmail(ChainmailArmorMaterialList.iron_chainmail, EquipmentSlotType.FEET, new Item.Properties().group(HardSteel.hard_steel)).setRegistryName(location("iron_chainfeet")),

					ItemList.steel_chainhead = new ArmorSteelChainmail(ChainmailArmorMaterialList.steel_chainmail, EquipmentSlotType.HEAD, new Item.Properties().group(HardSteel.hard_steel)).setRegistryName(location("steel_chainhead")),
					ItemList.steel_chainbody = new ArmorSteelChainmail(ChainmailArmorMaterialList.steel_chainmail, EquipmentSlotType.CHEST, new Item.Properties().group(HardSteel.hard_steel)).setRegistryName(location("steel_chainbody")),
					ItemList.steel_chainlegs = new ArmorSteelChainmail(ChainmailArmorMaterialList.steel_chainmail, EquipmentSlotType.LEGS, new Item.Properties().group(HardSteel.hard_steel)).setRegistryName(location("steel_chainlegs")),
					ItemList.steel_chainfeet = new ArmorSteelChainmail(ChainmailArmorMaterialList.steel_chainmail, EquipmentSlotType.FEET, new Item.Properties().group(HardSteel.hard_steel)).setRegistryName(location("steel_chainfeet")),

					ItemList.mithril_chainhead = new ArmorMithrilChainmail(ChainmailArmorMaterialList.mithril_chainmail, EquipmentSlotType.HEAD, new Item.Properties().group(HardSteel.hard_steel)).setRegistryName(location("mithril_chainhead")),
					ItemList.mithril_chainbody = new ArmorMithrilChainmail(ChainmailArmorMaterialList.mithril_chainmail, EquipmentSlotType.CHEST, new Item.Properties().group(HardSteel.hard_steel)).setRegistryName(location("mithril_chainbody")),
					ItemList.mithril_chainlegs = new ArmorMithrilChainmail(ChainmailArmorMaterialList.mithril_chainmail, EquipmentSlotType.LEGS, new Item.Properties().group(HardSteel.hard_steel)).setRegistryName(location("mithril_chainlegs")),
					ItemList.mithril_chainfeet = new ArmorMithrilChainmail(ChainmailArmorMaterialList.mithril_chainmail, EquipmentSlotType.FEET, new Item.Properties().group(HardSteel.hard_steel)).setRegistryName(location("mithril_chainfeet")),

					ItemList.netherite_chainhead = new ArmorNetheriteChainmail(ChainmailArmorMaterialList.netherite_chainmail, EquipmentSlotType.HEAD, new Item.Properties().group(HardSteel.hard_steel)).setRegistryName(location("netherite_chainhead")),
					ItemList.netherite_chainbody = new ArmorNetheriteChainmail(ChainmailArmorMaterialList.netherite_chainmail, EquipmentSlotType.CHEST, new Item.Properties().group(HardSteel.hard_steel)).setRegistryName(location("netherite_chainbody")),
					ItemList.netherite_chainlegs = new ArmorNetheriteChainmail(ChainmailArmorMaterialList.netherite_chainmail, EquipmentSlotType.LEGS, new Item.Properties().group(HardSteel.hard_steel)).setRegistryName(location("netherite_chainlegs")),
					ItemList.netherite_chainfeet = new ArmorNetheriteChainmail(ChainmailArmorMaterialList.netherite_chainmail, EquipmentSlotType.FEET, new Item.Properties().group(HardSteel.hard_steel)).setRegistryName(location("netherite_chainfeet")),

					ItemList.enderite_chainhead = new ArmorEnderiteChainmail(ChainmailArmorMaterialList.enderite_chainmail, EquipmentSlotType.HEAD, new Item.Properties().group(HardSteel.hard_steel)).setRegistryName(location("enderite_chainhead")),
					ItemList.enderite_chainbody = new ArmorEnderiteChainmail(ChainmailArmorMaterialList.enderite_chainmail, EquipmentSlotType.CHEST, new Item.Properties().group(HardSteel.hard_steel)).setRegistryName(location("enderite_chainbody")),
					ItemList.enderite_chainlegs = new ArmorEnderiteChainmail(ChainmailArmorMaterialList.enderite_chainmail, EquipmentSlotType.LEGS, new Item.Properties().group(HardSteel.hard_steel)).setRegistryName(location("enderite_chainlegs")),
					ItemList.enderite_chainfeet = new ArmorEnderiteChainmail(ChainmailArmorMaterialList.enderite_chainmail, EquipmentSlotType.FEET, new Item.Properties().group(HardSteel.hard_steel)).setRegistryName(location("enderite_chainfeet"))

			);
			HardSteel.logger.info("Items registered.");
		}
		
		private static ResourceLocation location(String name)
		{
			return new ResourceLocation(HardSteel.modid, name);
		}
	}
}
