package com.infamous.hard_steel.anvil;

import com.infamous.hard_steel.HardSteel;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.extensions.IForgeContainerType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.IForgeRegistryEntry;
import net.minecraftforge.registries.ObjectHolder;

// The value here should match an entry in the META-INF/mods.toml file
public class AnvilRegistryEvents
{
  // Directly reference a log4j logger.

  @ObjectHolder("hard_steel:anvil")
  public static AnvilBlockv2 ANVIL;

  @ObjectHolder("hard_steel:anvil_tile")
  public static TileEntityType<AnvilTile> ANVIL_TILE_ENTITY;

  @ObjectHolder("hard_steel:anvil_container")
  public static ContainerType<ForgingContainer> ANVIL_CONTAINER;


  @Mod.EventBusSubscriber(bus= Mod.EventBusSubscriber.Bus.MOD)
  public static class RegistryEvents {
    @SubscribeEvent
    public static void onBlocksRegistry(final RegistryEvent.Register<Block> event) {
      Block.Properties anvilProperties = Block.Properties.create(Material.ANVIL, MaterialColor.IRON)
              .hardnessAndResistance(5.0F, 1200.0F).sound(SoundType.ANVIL);
      registerItemBlock(new AnvilBlockv2(anvilProperties),"anvil",event.getRegistry());
    }

    @SubscribeEvent
    public static void registerItems(final RegistryEvent.Register<Item> event) {
      registerItemBlock(new BlockItem(ANVIL,new Item.Properties().group(HardSteel.hard_steel)), "anvil"
              ,event.getRegistry());
    }

    //@SubscribeEvent
    //public static void registerTiles(final RegistryEvent.Register<TileEntityType<?>> event) {
    //  registerObject(TileEntityType.Builder.create(() -> new AnvilTile(ANVIL_TILE_ENTITY), ANVIL).build(null),"anvil_tile",event.getRegistry());
    //}

    @SubscribeEvent
    public static void registerContainers(final RegistryEvent.Register<ContainerType<?>> event) {
      event.getRegistry().register(new ContainerType<>(ForgingContainer::new).setRegistryName("anvil_container"));

      //registerObject(IForgeContainerType.create((windowId, inv, data) -> new ForgingContainer(windowId, inv.player.world, data.readBlockPos(), inv, inv.player)),"anvil_container",event.getRegistry());
    }

    private static <T extends IForgeRegistryEntry<T>> void registerItemBlock(T obj, String name, IForgeRegistry<T> registry) {
      registry.register(obj.setRegistryName(new ResourceLocation(HardSteel.modid, name)));
    }

    private static <T extends IForgeRegistryEntry<T>> void registerObject(T obj, String name, IForgeRegistry<T> registry) {
      registry.register(obj.setRegistryName(new ResourceLocation(HardSteel.modid, name)));
    }
  }

  @ObjectHolder(HardSteel.modid)
  public static class Stuff {
  }
}
