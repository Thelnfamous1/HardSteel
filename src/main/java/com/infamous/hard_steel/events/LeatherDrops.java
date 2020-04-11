package com.infamous.hard_steel.events;

import com.infamous.hard_steel.config.GeneralModConfig;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.Random;

public class LeatherDrops {

    private Random rand = new Random();

    @SubscribeEvent
    public void livingDrop(LivingDropsEvent event)
    {
        // If either the drop chance is zero or the amount to drop is zero, don't even bother executing the rest of the code
        // Player decided to have either a X% chance to drop 0 extra leather, or a 0% chance to drop 100 extra leather. Really?
        if (GeneralModConfig.LEATHER_DROP_CHANCE.get() == 0 || GeneralModConfig.LEATHER_DROP_AMOUNT.get() == 0)
        {
            return;
        }

        ResourceLocation resourceLocation = ForgeRegistries.ENTITIES.getKey(event.getEntityLiving().getType());

        GeneralModConfig.LEATHER_DROP_ENTITIES.get().forEach((name) -> {
            if (name.equals(resourceLocation.toString()))
            {
                if (rand.nextInt(100) < GeneralModConfig.LEATHER_DROP_CHANCE.get())
                {
                        ItemEntity drop = new ItemEntity(event.getEntityLiving().world, event.getEntityLiving().posX,
                                event.getEntityLiving().posY, event.getEntityLiving().posZ, new ItemStack(Items.LEATHER, GeneralModConfig.LEATHER_DROP_AMOUNT.get()));

                        event.getDrops().add(drop);
                }
            }
        });
    }
}
