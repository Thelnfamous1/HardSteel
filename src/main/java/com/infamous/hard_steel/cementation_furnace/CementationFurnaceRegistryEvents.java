package com.infamous.hard_steel.cementation_furnace;

import com.infamous.hard_steel.HardSteel;
import com.infamous.hard_steel.cementation_furnace.*;
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

public class CementationFurnaceRegistryEvents {

    @ObjectHolder("hard_steel:cementation_furnace")
    public static CementationFurnaceBlock CEMENTATION_FURNACE;

    @ObjectHolder("hard_steel:cementation_furnace")
    public static TileEntityType<CementationFurnaceTileEntity> CEMENTATION_FURNACE_TILEENTITY;

    @ObjectHolder("hard_steel:cementation_furnace")
    public static ContainerType<CementationFurnaceContainer> CEMENTATION_FURNACE_CONTAINER;

    @ObjectHolder("hard_steel:cementation")
    public static CementationRecipeSerializer<CementationRecipe> cementation;

    @Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD)
    public static class RegistryEvents {

        @SubscribeEvent
        public static void registerBlocks(final RegistryEvent.Register<Block> event) {
            event.getRegistry().register(new CementationFurnaceBlock());
        }

        @SubscribeEvent
        public static void registerItems(final RegistryEvent.Register<Item> event) {
            event.getRegistry().register(new BlockItem(CEMENTATION_FURNACE, new Item.Properties().group(HardSteel.hard_steel)).setRegistryName("cementation_furnace"));
        }

        @SubscribeEvent
        public static void onTileEntityRegistry(final RegistryEvent.Register<TileEntityType<?>> event) {
            event.getRegistry().register(TileEntityType.Builder.create(CementationFurnaceTileEntity::new, CEMENTATION_FURNACE).build(null).setRegistryName("cementation_furnace"));
        }

        @SubscribeEvent
        public static void onRecipeSerializersRegistry(final RegistryEvent.Register<IRecipeSerializer<?>> event) {
            event.getRegistry().register(new CementationRecipeSerializer<>(CementationRecipe::new, 1600).setRegistryName("cementation"));
        }

        @SubscribeEvent
        public static void onContainerTypeRegistry(final RegistryEvent.Register<ContainerType<?>> event){
            event.getRegistry().register(new ContainerType<>(CementationFurnaceContainer::new).setRegistryName("cementation_furnace"));
        }

    }

}