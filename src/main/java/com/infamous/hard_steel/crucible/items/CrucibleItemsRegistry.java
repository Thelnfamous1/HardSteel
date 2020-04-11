package com.infamous.hard_steel.crucible.items;

import com.infamous.hard_steel.HardSteel;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

public class CrucibleItemsRegistry {
    @Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD)
    public static class RegistryEvents
    {
        @SubscribeEvent
        public static void registerItems(final RegistryEvent.Register<Item> event)
        {
            event.getRegistry().registerAll
                    (
                            CrucibleItemsList.axe_cast = new Item(new Item.Properties().group(HardSteel.hard_steel)).setRegistryName(location("axe_cast")),
                            CrucibleItemsList.hoe_cast = new Item(new Item.Properties().group(HardSteel.hard_steel)).setRegistryName(location("hoe_cast")),
                            CrucibleItemsList.pickaxe_cast = new Item(new Item.Properties().group(HardSteel.hard_steel)).setRegistryName(location("pickaxe_cast")),
                            CrucibleItemsList.shovel_cast = new Item(new Item.Properties().group(HardSteel.hard_steel)).setRegistryName(location("shovel_cast")),
                            CrucibleItemsList.sword_cast = new Item(new Item.Properties().group(HardSteel.hard_steel)).setRegistryName(location("sword_cast")),

                            CrucibleItemsList.helmet_cast = new Item(new Item.Properties().group(HardSteel.hard_steel)).setRegistryName(location("helmet_cast")),
                            CrucibleItemsList.chestplate_cast = new Item(new Item.Properties().group(HardSteel.hard_steel)).setRegistryName(location("chestplate_cast")),
                            CrucibleItemsList.leggings_cast = new Item(new Item.Properties().group(HardSteel.hard_steel)).setRegistryName(location("leggings_cast")),
                            CrucibleItemsList.boots_cast = new Item(new Item.Properties().group(HardSteel.hard_steel)).setRegistryName(location("boots_cast"))


                            );
            HardSteel.logger.info("Items registered.");
        }

        private static ResourceLocation location(String name)
        {
            return new ResourceLocation(HardSteel.modid, name);
        }
    }
}
