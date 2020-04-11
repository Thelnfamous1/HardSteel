package com.infamous.hard_steel.blast_furnace;

import com.infamous.hard_steel.HardSteel;
import net.minecraft.block.Block;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ObjectHolder;

public class BlastFurnaceRegistryEvents {

    @ObjectHolder("hard_steel:blast_furnace")
    public static BlockBlastFurnace BLAST_FURNACE;

    @ObjectHolder("hard_steel:blast_furnace")
    public static TileEntityType<TileEntityBlastFurnace> BLAST_FURNACE_TILEENTITY;

    @ObjectHolder("hard_steel:blast_furnace")
    public static ContainerType<BlastFurnaceContainer> BLAST_FURNACE_CONTAINER;

    @ObjectHolder("hard_steel:hot_blasting")
    public static HotBlastingRecipeSerializer<HotBlastingRecipe> hot_blasting;

    @Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD)
    public static class RegistryEvents {

        @SubscribeEvent
        public static void registerBlocks(final RegistryEvent.Register<Block> event) {
            event.getRegistry().register(new BlockBlastFurnace());
        }

        @SubscribeEvent
        public static void registerItems(final RegistryEvent.Register<Item> event) {
            event.getRegistry().register(new BlockItem(BLAST_FURNACE, new Item.Properties().group(HardSteel.hard_steel)).setRegistryName("blast_furnace"));
        }

        @SubscribeEvent
        public static void onTileEntityRegistry(final RegistryEvent.Register<TileEntityType<?>> event) {
            event.getRegistry().register(TileEntityType.Builder.create(TileEntityBlastFurnace::new, BLAST_FURNACE).build(null).setRegistryName("blast_furnace"));
        }

        @SubscribeEvent
        public static void onRecipeSerializersRegistry(final RegistryEvent.Register<IRecipeSerializer<?>> event) {
            event.getRegistry().register(new HotBlastingRecipeSerializer<>(HotBlastingRecipe::new, 100).setRegistryName("hot_blasting"));
        }

        @SubscribeEvent
        public static void onContainerTypeRegistry(final RegistryEvent.Register<ContainerType<?>> event){
            event.getRegistry().register(new ContainerType<>(BlastFurnaceContainer::new).setRegistryName("blast_furnace"));
        }

    }

}