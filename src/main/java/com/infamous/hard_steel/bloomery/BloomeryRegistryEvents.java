package com.infamous.hard_steel.bloomery;

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

public class BloomeryRegistryEvents {

    @ObjectHolder("hard_steel:bloomery")
    public static BloomeryBlock BLOOMERY;

    @ObjectHolder("hard_steel:bloomery")
    public static TileEntityType<BloomeryTileEntity> BLOOMERY_TILEENTITY;

    @ObjectHolder("hard_steel:bloomery")
    public static ContainerType<BloomeryContainer> BLOOMERY_CONTAINER;

    @ObjectHolder("hard_steel:blooming")
    public static BloomingRecipeSerializer<BloomingRecipe> blooming;

    @Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD)
    public static class RegistryEvents {

        @SubscribeEvent
        public static void registerBlocks(final RegistryEvent.Register<Block> event) {
            event.getRegistry().register(new BloomeryBlock());
        }

        @SubscribeEvent
        public static void registerItems(final RegistryEvent.Register<Item> event) {
            event.getRegistry().register(new BlockItem(BLOOMERY, new Item.Properties().group(HardSteel.hard_steel)).setRegistryName("bloomery"));
        }

        @SubscribeEvent
        public static void onTileEntityRegistry(final RegistryEvent.Register<TileEntityType<?>> event) {
            event.getRegistry().register(TileEntityType.Builder.create(BloomeryTileEntity::new, BLOOMERY).build(null).setRegistryName("bloomery"));
        }

        @SubscribeEvent
        public static void onRecipeSerializersRegistry(final RegistryEvent.Register<IRecipeSerializer<?>> event) {
            event.getRegistry().register(new BloomingRecipeSerializer<>(BloomingRecipe::new, 1600).setRegistryName("blooming"));
        }

        @SubscribeEvent
        public static void onContainerTypeRegistry(final RegistryEvent.Register<ContainerType<?>> event){
            event.getRegistry().register(new ContainerType<>(BloomeryContainer::new).setRegistryName("bloomery"));
        }

    }

}