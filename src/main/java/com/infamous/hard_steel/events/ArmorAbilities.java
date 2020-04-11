package com.infamous.hard_steel.events;

import com.infamous.hard_steel.HardSteel;
import com.infamous.hard_steel.lists.ItemList;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.DamageSource;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.event.entity.living.LivingEquipmentChangeEvent;
import net.minecraftforge.event.world.NoteBlockEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = HardSteel.modid)
public class ArmorAbilities {
    @SubscribeEvent(receiveCanceled = true, priority= EventPriority.HIGHEST)
    public static void onLivingHurtEvent(LivingAttackEvent event) {
        if (event.getEntityLiving() instanceof PlayerEntity) {
            PlayerEntity player = (PlayerEntity) event.getEntityLiving();

            //Fall Damage negated by both Full Enderite & Enderite with Elytra
            if ((event.getSource() == DamageSource.FALL) &&
                    (hasFullSetEnderite(player) || hasEnderiteWithElytra(player))) {
                if (event.isCancelable()) event.setCanceled(true);
            }

            //Fly Into Wall Damage only negated by Enderite with Elytra
            if ((event.getSource() == DamageSource.FLY_INTO_WALL) &&
                    hasEnderiteWithElytra(player)) {
                if (event.isCancelable()) event.setCanceled(true);
            }

            //Dragon's Breath Damage only negated by Enderite
            if ((event.getSource() == DamageSource.DRAGON_BREATH) &&
                    hasFullSetEnderite(player)) {
                // Only nerfs Dragon's Breath Attack by 50%
                player.heal(event.getAmount() / 2);
                //if (event.isCancelable()) event.setCanceled(true);
            }

            //Fire & Magma Blocks & Fireworks - no, you cannot swim in Lava with Netherite armor!
            if (((event.getSource() == DamageSource.IN_FIRE) ||
                    (event.getSource() == DamageSource.ON_FIRE) ||
                    (event.getSource() == DamageSource.HOT_FLOOR) ||
                    (event.getSource() == DamageSource.FIREWORKS)) &&
                    hasFullSetNetherite(player)) {
                if (event.isCancelable()) event.setCanceled(true);
            }
        }
    }

    public static boolean hasFullSetNetherite(PlayerEntity player){
        ItemStack head = player.getItemStackFromSlot(EquipmentSlotType.HEAD);
        ItemStack chest = player.getItemStackFromSlot(EquipmentSlotType.CHEST);
        ItemStack legs = player.getItemStackFromSlot(EquipmentSlotType.LEGS);
        ItemStack feet = player.getItemStackFromSlot(EquipmentSlotType.FEET);

        if(head.getItem() == ItemList.netherite_helmet &&
            chest.getItem() == ItemList.netherite_chestplate &&
            legs.getItem() == ItemList.netherite_leggings &&
            feet.getItem() == ItemList.netherite_boots) return true;

        return false;
    }

    public static boolean hasFullSetEnderite(PlayerEntity player){
        ItemStack head = player.getItemStackFromSlot(EquipmentSlotType.HEAD);
        ItemStack chest = player.getItemStackFromSlot(EquipmentSlotType.CHEST);
        ItemStack legs = player.getItemStackFromSlot(EquipmentSlotType.LEGS);
        ItemStack feet = player.getItemStackFromSlot(EquipmentSlotType.FEET);

        if(head.getItem() == ItemList.enderite_helmet &&
                chest.getItem() == ItemList.enderite_chestplate &&
                legs.getItem() == ItemList.enderite_leggings &&
                feet.getItem() == ItemList.enderite_boots) return true;

        return false;
    }
    public static boolean hasEnderiteWithElytra(PlayerEntity player){
        ItemStack head = player.getItemStackFromSlot(EquipmentSlotType.HEAD);
        ItemStack chest = player.getItemStackFromSlot(EquipmentSlotType.CHEST);
        ItemStack legs = player.getItemStackFromSlot(EquipmentSlotType.LEGS);
        ItemStack feet = player.getItemStackFromSlot(EquipmentSlotType.FEET);

        if(head.getItem() == ItemList.enderite_helmet &&
                chest.getItem() == Items.ELYTRA &&
                legs.getItem() == ItemList.enderite_leggings &&
                feet.getItem() == ItemList.enderite_boots) return true;

        return false;
    }
}
