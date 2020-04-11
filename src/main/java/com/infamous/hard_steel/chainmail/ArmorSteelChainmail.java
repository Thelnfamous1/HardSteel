package com.infamous.hard_steel.chainmail;


import com.google.common.collect.Multimap;
import com.infamous.hard_steel.lists.ItemList;
import com.infamous.hard_steel.util.EquipmentUtilities;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;

import java.util.List;

import static net.minecraft.entity.ai.attributes.AttributeModifier.Operation.ADDITION;

public class ArmorSteelChainmail extends ArmorItem
{
	private static double fullyArmoredMovementSpeedPenalty = EquipmentUtilities.getDefaultMovementSpeed() * 0.125 * -1;
	private static double fullyArmoredKnockbackResistanceBenefit = 0.125;

	public ArmorSteelChainmail(IArmorMaterial materialIn, EquipmentSlotType slots, Properties builder)
	{
		super(materialIn, slots, builder);
	}

	public static  double getHelmetSpeedPenalty(){
		return (fullyArmoredMovementSpeedPenalty) * 0.208;
	}

	public static  double getChestplateSpeedPenalty(){
		return (fullyArmoredMovementSpeedPenalty) * 0.333;
	}

	public static  double getLeggingsSpeedPenalty(){
		return (fullyArmoredMovementSpeedPenalty) * 0.292;
	}

	public static  double getBootsSpeedPenalty(){
		return (fullyArmoredMovementSpeedPenalty) * 0.167;
	}

	public static  double getKnockbackResistanceWithHelmet(){
		return fullyArmoredKnockbackResistanceBenefit * 0.208;
	}

	public static  double getKnockbackResistanceWithChestplate(){
		return fullyArmoredKnockbackResistanceBenefit * 0.333;
	}

	public static  double getKnockbackResistanceWithLeggings(){
		return fullyArmoredKnockbackResistanceBenefit * 0.292;
	}

	public static  double getKnockbackResistanceWithBoots(){
		return fullyArmoredKnockbackResistanceBenefit * 0.167;
	}

	public static double getArmorPieceSpeedPenalty(EquipmentSlotType equipmentSlot){
		if(equipmentSlot == EquipmentSlotType.HEAD){
			return getHelmetSpeedPenalty();
		}
		else if(equipmentSlot == EquipmentSlotType.CHEST){
			return getChestplateSpeedPenalty();
		}
		else if(equipmentSlot == EquipmentSlotType.LEGS){
			return getLeggingsSpeedPenalty();
		}
		else if(equipmentSlot == EquipmentSlotType.FEET){
			return getBootsSpeedPenalty();
		}
		else return 0;
	}

	public static double getArmorPieceKnockbackResistanceBenefit(EquipmentSlotType equipmentSlot){
		if(equipmentSlot == EquipmentSlotType.HEAD){
			return getKnockbackResistanceWithHelmet();
		}
		else if(equipmentSlot == EquipmentSlotType.CHEST){
			return getKnockbackResistanceWithChestplate();
		}
		else if(equipmentSlot == EquipmentSlotType.LEGS){
			return getKnockbackResistanceWithLeggings();
		}
		else if(equipmentSlot == EquipmentSlotType.FEET){
			return getKnockbackResistanceWithBoots();
		}
		else return 0;
	}

	// Checking the speed of other armors

	@Override
	public Multimap<String, AttributeModifier> getAttributeModifiers(EquipmentSlotType equipmentSlot) {
		Multimap<String, AttributeModifier> multimap = super.getAttributeModifiers(equipmentSlot);
		if(equipmentSlot == this.slot){
			multimap.put(SharedMonsterAttributes.MOVEMENT_SPEED.getName(), new AttributeModifier(EquipmentUtilities.getSpeedModifierUUID(equipmentSlot), "armorSpeedModifier", getArmorPieceSpeedPenalty(equipmentSlot), ADDITION));
			multimap.put(SharedMonsterAttributes.KNOCKBACK_RESISTANCE.getName(), new AttributeModifier(EquipmentUtilities.getKnockbackResistanceModifierUUID(equipmentSlot), "armorKnockbackResistanceModifier", getArmorPieceKnockbackResistanceBenefit(equipmentSlot), ADDITION));
		}
		return multimap;
	}

	@Override
	public boolean isBookEnchantable(ItemStack stack, ItemStack book)
	{
		return true;
	}

	@Override
	public boolean getIsRepairable(ItemStack toRepair, ItemStack repair)
	{
		return repair.getItem() == ItemList.steel_chain;
	}
	
    @Override
	public void addInformation(ItemStack stack, World world, List<ITextComponent> list, ITooltipFlag flag)
	{
		super.addInformation(stack, world, list, flag);
		list.add(new StringTextComponent(TextFormatting.GREEN + "Tier 3"));

	}
}
