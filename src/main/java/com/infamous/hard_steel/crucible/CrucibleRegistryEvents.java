package com.infamous.hard_steel.crucible;

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

public class CrucibleRegistryEvents {

    @ObjectHolder("hard_steel:crucible")
    public static CrucibleBlock CRUCIBLE;

    @ObjectHolder("hard_steel:crucible")
    public static TileEntityType<CrucibleTileEntity> CRUCIBLE_TILEENTITY;

    @ObjectHolder("hard_steel:crucible")
    public static ContainerType<CrucibleContainer> CRUCIBLE_CONTAINER;

    @ObjectHolder("hard_steel:casting")
    public static AlloyingRecipeSerializer<AlloyingRecipe> alloying;

    @Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD)
    public static class RegistryEvents {

        @SubscribeEvent
        public static void registerBlocks(final RegistryEvent.Register<Block> event) {
            event.getRegistry().register(new CrucibleBlock());
        }

        @SubscribeEvent
        public static void registerItems(final RegistryEvent.Register<Item> event) {
            event.getRegistry().register(new BlockItem(CRUCIBLE, new Item.Properties().group(HardSteel.hard_steel)).setRegistryName("crucible"));
        }

        @SubscribeEvent
        public static void onTileEntityRegistry(final RegistryEvent.Register<TileEntityType<?>> event) {
            event.getRegistry().register(TileEntityType.Builder.create(CrucibleTileEntity::new, CRUCIBLE).build(null).setRegistryName("crucible"));
        }

        @SubscribeEvent
        public static void onRecipeSerializersRegistry(final RegistryEvent.Register<IRecipeSerializer<?>> event) {
            event.getRegistry().register(new AlloyingRecipeSerializer<>(AlloyingRecipe::new, 200).setRegistryName("alloying"));
        }

        @SubscribeEvent
        public static void onContainerTypeRegistry(final RegistryEvent.Register<ContainerType<?>> event){
            event.getRegistry().register(new ContainerType<>(CrucibleContainer::new).setRegistryName("crucible"));
        }

    }

}