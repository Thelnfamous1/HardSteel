package com.infamous.hard_steel.smithingtable;

import com.infamous.hard_steel.HardSteel;
import net.minecraft.block.Block;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.IForgeRegistryEntry;
import net.minecraftforge.registries.ObjectHolder;

public class SmithingTableRegistryEvents {

    @ObjectHolder("hard_steel:smithing_table")
    public static BlockSmithingTable SMITHING_TABLE;

    //@ObjectHolder("hard_steel:smithing_table_tile")
    //public static TileEntityType<SmithingTableTileEntity> SMITHING_TABLE_TILEENTITY;

    @ObjectHolder("hard_steel:smithing_table_container")
    public static ContainerType<SmithingTableContainer> SMITHING_TABLE_CONTAINER;

    //@ObjectHolder("minecraft:smithing")
    //public static BloomingRecipeSerializer<SmithingRecipe> smithing;

    @Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD)
    public static class RegistryEvents {

        //@SubscribeEvent
        //public static void registerBlocks(final RegistryEvent.Register<Block> event) {
        //    PlaceboUtil.registerOverrideBlock(new BlockSmithingTable(), HardSteel.modid);
        //    event.getRegistry().register(new SmithingTableBlock());
        //}

        @SubscribeEvent
        public static void registerBlocks(final RegistryEvent.Register<Block> event) {
            event.getRegistry().register(new BlockSmithingTable());
        }

        @SubscribeEvent
        public static void registerItems(final RegistryEvent.Register<Item> event) {
            event.getRegistry().register(new BlockItem(SMITHING_TABLE, new Item.Properties().group(HardSteel.hard_steel)).setRegistryName("hard_steel", "smithing_table"));
        }

        //@SubscribeEvent
        //public static void onTileEntityRegistry(final RegistryEvent.Register<TileEntityType<?>> event) {
        //    registerObject(TileEntityType.Builder.create(() -> new SmithingTableTileEntity(SMITHING_TABLE_TILEENTITY), SMITHING_TABLE).build(null),"smithing_table_tile",event.getRegistry());
        //}

        //@SubscribeEvent
        //public static void onRecipeSerializersRegistry(final RegistryEvent.Register<IRecipeSerializer<?>> event) {
        //    event.getRegistry().register(new BloomingRecipeSerializer<>(BloomingRecipe::new, 200).setRegistryName("smithing"));
        //}

        @SubscribeEvent
        public static void onContainerTypeRegistry(final RegistryEvent.Register<ContainerType<?>> event){

            event.getRegistry().register(new ContainerType<>(SmithingTableContainer::new).setRegistryName("smithing_table_container"));
            //registerObject(IForgeContainerType.create((windowId, inv, data) -> new SmithingTableContainer(windowId, inv, IWorldPosCallable.of(inv.player.world, data.readBlockPos()))),"smithing_table_container",event.getRegistry());
        }

        private static <T extends IForgeRegistryEntry<T>> void registerObject(T obj, String name, IForgeRegistry<T> registry) {
            registry.register(obj.setRegistryName(new ResourceLocation(HardSteel.modid, name)));
        }

    }

}