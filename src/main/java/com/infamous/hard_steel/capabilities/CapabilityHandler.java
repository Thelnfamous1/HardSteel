package com.infamous.hard_steel.capabilities;

import com.infamous.hard_steel.HardSteel;
import net.minecraft.entity.Entity;
import net.minecraft.entity.monster.SkeletonEntity;
import net.minecraft.entity.monster.StrayEntity;
import net.minecraft.entity.monster.WitherSkeletonEntity;
import net.minecraft.entity.monster.ZombieEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class CapabilityHandler {
    @SubscribeEvent
    public void onAttachCapabilities(AttachCapabilitiesEvent<Entity> event) {
        if (isArmorableMob(event.getObject())) {
            event.addCapability(new ResourceLocation(HardSteel.modid, "rearmer"), new ReArmerProvider());
        }
    }

    public static boolean isArmorableMob(Entity entity){
        if((entity instanceof ZombieEntity) || // covers Zombies, Husks, Zombie Villagers, Zombie Pigmen and Drowned
                (entity instanceof SkeletonEntity) ||
                (entity instanceof StrayEntity) ||
                (entity instanceof WitherSkeletonEntity)) return true;
        return false;
    }
}
