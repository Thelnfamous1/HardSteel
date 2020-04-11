package com.infamous.hard_steel.init;

import com.infamous.hard_steel.lists.BlockList;
import com.infamous.hard_steel.HardSteel;

import net.minecraft.block.Block;
import net.minecraft.block.OreBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

public class BlockInit
{
	@Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD)
	public static class RegistryEvents
	{
		@SubscribeEvent
		public static void registerBlocks(final RegistryEvent.Register<Block> event)
		{
			event.getRegistry().registerAll
			(

					BlockList.copper_ore = new OreBlock(Block.Properties.create(Material.ROCK).hardnessAndResistance(3.0f, 3.0f).harvestLevel(0).harvestTool(net.minecraftforge.common.ToolType.PICKAXE).lightValue(0).sound(SoundType.METAL)).setRegistryName(location("copper_ore")),
				BlockList.tin_ore = new OreBlock(Block.Properties.create(Material.ROCK).hardnessAndResistance(3.0f, 3.0f).harvestLevel(0).harvestTool(net.minecraftforge.common.ToolType.PICKAXE).lightValue(0).sound(SoundType.METAL)).setRegistryName(location("tin_ore")),

					BlockList.mithril_ore = new OreBlock(Block.Properties.create(Material.ROCK).hardnessAndResistance(3.0f, 3.0f).harvestLevel(2).harvestTool(net.minecraftforge.common.ToolType.PICKAXE).lightValue(0).sound(SoundType.METAL)).setRegistryName(location("mithril_ore")),

					BlockList.ancient_debris = new OreBlock(Block.Properties.create(Material.ROCK).hardnessAndResistance(5.0F, 1200.0F).harvestLevel(3).harvestTool(net.minecraftforge.common.ToolType.PICKAXE).lightValue(0).sound(SoundType.METAL)).setRegistryName(location("ancient_debris")),
					BlockList.elder_remnants = new OreBlock(Block.Properties.create(Material.ROCK).hardnessAndResistance(5.0F, 1200.0F).harvestLevel(3).harvestTool(net.minecraftforge.common.ToolType.PICKAXE).lightValue(0).sound(SoundType.METAL)).setRegistryName(location("elder_remnants")),

					BlockList.limestone = new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(3.0f, 3.0f).harvestLevel(0).harvestTool(ToolType.PICKAXE).lightValue(0).sound(SoundType.STONE)).setRegistryName(location("limestone")),

					BlockList.copper_block = new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(3.0f, 3.0f).harvestLevel(0).harvestTool(net.minecraftforge.common.ToolType.PICKAXE).lightValue(0).sound(SoundType.METAL)).setRegistryName(location("copper_block")),
					BlockList.tin_block = new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(3.0f, 3.0f).harvestLevel(0).harvestTool(net.minecraftforge.common.ToolType.PICKAXE).lightValue(0).sound(SoundType.METAL)).setRegistryName(location("tin_block")),

					BlockList.bronze_block = new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(5.0f, 6.0f).harvestLevel(1).harvestTool(net.minecraftforge.common.ToolType.PICKAXE).lightValue(0).sound(SoundType.METAL)).setRegistryName(location("bronze_block")),

					BlockList.iron_bloom = new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(3.0f, 3.0f).harvestLevel(1).harvestTool(net.minecraftforge.common.ToolType.PICKAXE).lightValue(0).sound(SoundType.METAL)).setRegistryName(location("iron_bloom")),
					BlockList.carbonized_iron_ore = new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(3.0f, 3.0f).harvestLevel(1).harvestTool(net.minecraftforge.common.ToolType.PICKAXE).lightValue(0).sound(SoundType.METAL)).setRegistryName(location("carbonized_iron_ore")),
					BlockList.steel_bloom = new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(3.0f, 3.0f).harvestLevel(1).harvestTool(net.minecraftforge.common.ToolType.PICKAXE).lightValue(0).sound(SoundType.METAL)).setRegistryName(location("steel_bloom")),

					BlockList.steel_block = new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(5.0f, 6.0f).harvestLevel(2).harvestTool(net.minecraftforge.common.ToolType.PICKAXE).lightValue(0).sound(SoundType.METAL)).setRegistryName(location("steel_block")),
					BlockList.mithril_block = new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(5.0f, 6.0f).harvestLevel(2).harvestTool(net.minecraftforge.common.ToolType.PICKAXE).lightValue(0).sound(SoundType.METAL)).setRegistryName(location("mithril_block")),

					BlockList.enderite_block = new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(5.0F, 1200.0F).harvestLevel(3).harvestTool(net.minecraftforge.common.ToolType.PICKAXE).lightValue(0).sound(SoundType.METAL)).setRegistryName(location("netherite_block")),
					BlockList.netherite_block = new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(5.0F, 1200.0F).harvestLevel(3).harvestTool(net.minecraftforge.common.ToolType.PICKAXE).lightValue(0).sound(SoundType.METAL)).setRegistryName(location("enderite_block"))

			);
			HardSteel.logger.info("Blocks registered.");
		}
	}
	
	private static ResourceLocation location(String name)
	{
		return new ResourceLocation(HardSteel.modid, name);
	}	
}
