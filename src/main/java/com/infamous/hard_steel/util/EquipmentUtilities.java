package com.infamous.hard_steel.util;

import net.minecraft.inventory.EquipmentSlotType;

import java.util.UUID;

public class EquipmentUtilities {

    // the vanilla values for player movement speed and knockback resistance are below
    private static double defaultMovementSpeed = 0.1;
    private static double defaultKnockbackResistance = 0;

    private static UUID helmetSpeedModifier = UUID.fromString("dd113499-2e49-4506-8b56-361a5aa9d317");
    private static UUID chestplateSpeedModifier = UUID.fromString("29fe4bee-4bc6-4815-b2d6-0df995e3c81c");
    private static UUID leggingsSpeedModifier = UUID.fromString("22227d4b-64cf-4455-ade3-7c45d75d6bf9");
    private static UUID bootsSpeedModifier = UUID.fromString("085973b6-6629-4daf-b606-bcbeadeac77e");
    private static UUID shieldSpeedModifier = UUID.fromString("604b0ddd-5fb9-4a2f-b751-826af1e98c39");

    private static UUID helmetKnockbackResistanceModifier = UUID.fromString("cc5d2680-b0b9-4214-b8ca-a20add85d92d");
    private static UUID chestplateKnockbackResistanceModifier = UUID.fromString("af0ed8ce-8732-4c26-a535-4309d5eb31d5");
    private static UUID leggingsKnockbackResistanceModifier = UUID.fromString("c85e53d4-b55e-4f3b-a456-8a044049fee6");
    private static UUID bootsKnockbackResistanceModifier = UUID.fromString("47eda0ed-7d94-484f-88a1-ea023b8c81a7");
    private static UUID shieldKnockbackResistanceModifier = UUID.fromString("f36dbaaa-c419-4ee3-8dc4-eec0bf6b7f41");

    public static UUID getSpeedModifierUUID(EquipmentSlotType equipmentSlot){
        if(equipmentSlot == EquipmentSlotType.HEAD){
            return helmetSpeedModifier;
        }
        else if(equipmentSlot == EquipmentSlotType.CHEST){
            return chestplateSpeedModifier;
        }
        else if(equipmentSlot == EquipmentSlotType.LEGS){
            return leggingsSpeedModifier;
        }
        else if(equipmentSlot == EquipmentSlotType.FEET){
            return bootsSpeedModifier;
        }
        else{
            return shieldSpeedModifier;
        }
    }

    public static UUID getKnockbackResistanceModifierUUID(EquipmentSlotType equipmentSlot){
        if(equipmentSlot == EquipmentSlotType.HEAD){
            return helmetKnockbackResistanceModifier;
        }
        else if(equipmentSlot == EquipmentSlotType.CHEST){
            return chestplateKnockbackResistanceModifier;
        }
        else if(equipmentSlot == EquipmentSlotType.LEGS){
            return leggingsKnockbackResistanceModifier;
        }
        else if(equipmentSlot == EquipmentSlotType.FEET){
            return bootsKnockbackResistanceModifier;
        }
        else{
            return shieldKnockbackResistanceModifier;
        }
    }

    public static double getDefaultMovementSpeed(){
        return defaultMovementSpeed;
    }

    public static double getDefaultKnockbackResistance(){
        return defaultKnockbackResistance;
    }
}
