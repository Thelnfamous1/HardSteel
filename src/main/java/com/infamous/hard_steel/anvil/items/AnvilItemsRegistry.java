package com.infamous.hard_steel.anvil.items;

import com.infamous.hard_steel.HardSteel;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

public class AnvilItemsRegistry {
    @Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD)
    public static class RegistryEvents
    {
        @SubscribeEvent
        public static void registerItems(final RegistryEvent.Register<Item> event)
        {
            event.getRegistry().registerAll
                    (
                            AnvilItemsList.axe_blueprint = new Item(new Item.Properties().group(HardSteel.hard_steel)).setRegistryName(location("axe_blueprint")),
                            AnvilItemsList.hoe_blueprint = new Item(new Item.Properties().group(HardSteel.hard_steel)).setRegistryName(location("hoe_blueprint")),
                            AnvilItemsList.pickaxe_blueprint = new Item(new Item.Properties().group(HardSteel.hard_steel)).setRegistryName(location("pickaxe_blueprint")),
                            AnvilItemsList.shovel_blueprint = new Item(new Item.Properties().group(HardSteel.hard_steel)).setRegistryName(location("shovel_blueprint")),
                            AnvilItemsList.sword_blueprint = new Item(new Item.Properties().group(HardSteel.hard_steel)).setRegistryName(location("sword_blueprint")),

                            AnvilItemsList.helmet_blueprint = new Item(new Item.Properties().group(HardSteel.hard_steel)).setRegistryName(location("helmet_blueprint")),
                            AnvilItemsList.chestplate_blueprint = new Item(new Item.Properties().group(HardSteel.hard_steel)).setRegistryName(location("chestplate_blueprint")),
                            AnvilItemsList.leggings_blueprint = new Item(new Item.Properties().group(HardSteel.hard_steel)).setRegistryName(location("leggings_blueprint")),
                            AnvilItemsList.boots_blueprint = new Item(new Item.Properties().group(HardSteel.hard_steel)).setRegistryName(location("boots_blueprint")),

                            AnvilItemsList.steel_blueprint = new Item(new Item.Properties().group(HardSteel.hard_steel)).setRegistryName(location("steel_blueprint"))
                            );
            HardSteel.logger.info("Items registered.");
        }

        private static ResourceLocation location(String name)
        {
            return new ResourceLocation(HardSteel.modid, name);
        }
    }
}
