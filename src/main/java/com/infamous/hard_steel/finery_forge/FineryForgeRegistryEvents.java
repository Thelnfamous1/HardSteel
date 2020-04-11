package com.infamous.hard_steel.finery_forge;

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

public class FineryForgeRegistryEvents {

    @ObjectHolder("hard_steel:finery_forge")
    public static FineryForgeBlock FINERY_FORGE;

    @ObjectHolder("hard_steel:finery_forge")
    public static TileEntityType<FineryForgeTileEntity> FINERY_FORGE_TILEENTITY;

    @ObjectHolder("hard_steel:finery_forge")
    public static ContainerType<FineryForgeContainer> FINERY_FORGE_CONTAINER;

    @ObjectHolder("hard_steel:fining")
    public static FiningRecipeSerializer<FiningRecipe> fining;

    @Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD)
    public static class RegistryEvents {

        @SubscribeEvent
        public static void registerBlocks(final RegistryEvent.Register<Block> event) {
            event.getRegistry().register(new FineryForgeBlock());
        }

        @SubscribeEvent
        public static void registerItems(final RegistryEvent.Register<Item> event) {
            event.getRegistry().register(new BlockItem(FINERY_FORGE, new Item.Properties().group(HardSteel.hard_steel)).setRegistryName("finery_forge"));
        }

        @SubscribeEvent
        public static void onTileEntityRegistry(final RegistryEvent.Register<TileEntityType<?>> event) {
            event.getRegistry().register(TileEntityType.Builder.create(FineryForgeTileEntity::new, FINERY_FORGE).build(null).setRegistryName("finery_forge"));
        }

        @SubscribeEvent
        public static void onRecipeSerializersRegistry(final RegistryEvent.Register<IRecipeSerializer<?>> event) {
            event.getRegistry().register(new FiningRecipeSerializer<>(FiningRecipe::new, 100).setRegistryName("fining"));
        }

        @SubscribeEvent
        public static void onContainerTypeRegistry(final RegistryEvent.Register<ContainerType<?>> event){
            event.getRegistry().register(new ContainerType<>(FineryForgeContainer::new).setRegistryName("finery_forge"));
        }

    }

}