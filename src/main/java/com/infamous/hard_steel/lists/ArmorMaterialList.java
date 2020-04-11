package com.infamous.hard_steel.lists;

import com.infamous.hard_steel.HardSteel;

import com.infamous.hard_steel.config.GeneralModConfig;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;

public enum ArmorMaterialList implements IArmorMaterial
{
	//Armor order: boots, leggings, chestplate, helmet

	/*
	 * Durability:
	 * Leather - 5
	 * Iron = 14
	 * Diamond = 33
	 * Netherite = 37
	 * Gold = 7
	 *
	 * Enchantability:
	 * Leather = 15
	 * Iron = 9
	 * Diamond = 10
	 * Netherite = 15
	 * Gold = 25
	 *
	 */

	// Tier 1
	copper("copper", 7, new int[] {1, 3, 5, 2}, 20, ItemList.copper_ingot, "item.armor.equip_iron", 0.0f),
	// Tier 2
	bronze("bronze", 14, new int[] {2, 5, 6, 2}, 15, ItemList.bronze_ingot, "item.armor.equip_iron", 1.0f),
	iron("iron", 14, new int[] {2, 5, 6, 2}, 10, Items.IRON_INGOT, "item.armor.equip_iron", 1.0f),
	// Tier 3
	steel("steel", 21, new int[] {3, 6, 8, 3}, 5, ItemList.steel_ingot, "item.armor.equip_iron", 2.0f),
	mithril("mithril", 28, new int[] {3, 6, 8, 3}, 10, ItemList.mithril_ingot, "item.armor.equip_iron", 2.0f),
	// Tier 4
	netherite("netherite", 35, new int[] {3, 6, 8, 3}, 15, ItemList.netherite_ingot, "item.armor.equip_iron", 3.0f),
	enderite("enderite", 42, new int[] {3, 6, 8, 3}, 20, ItemList.enderite_ingot, "item.armor.equip_iron", 3.0f);


	// Armor order: boots, leggings, chestplate, helmet
	private static final int[] max_damage_array = new int[]{13, 15, 16, 11};
	private String name, equipSound;
	private int durability, enchantability;
	private Item repairItem;
	private int[] damageReductionAmounts;
	private float toughness;
	
	private ArmorMaterialList(String name, int durability, int[] damageReductionAmounts, int enchantability, Item repairItem, String equipSound, float toughness) 
	{
		this.name = name;
		this.equipSound = equipSound;
		this.durability = durability;
		this.enchantability = enchantability;
		this.repairItem = repairItem;
		this.damageReductionAmounts = damageReductionAmounts;
		this.toughness = toughness;
	}

	@Override
	public int getDamageReductionAmount(EquipmentSlotType slot) 
	{
		return this.damageReductionAmounts[slot.getIndex()];
	}

	@Override
	public int getDurability(EquipmentSlotType slot) 
	{
		return max_damage_array[slot.getIndex()] * this.durability;
	}

	@Override
	public int getEnchantability() 
	{
		return this.enchantability;
	}

	@Override
	public String getName() 
	{
		return HardSteel.modid + ":" + this.name;
	}

	@Override
	public Ingredient getRepairMaterial() 
	{
		return Ingredient.fromItems(this.repairItem);
	}

	@Override
	public SoundEvent getSoundEvent() 
	{
		return new SoundEvent(new ResourceLocation(equipSound));
	}

	@Override
	public float getToughness() 
	{
		return this.toughness;
	}
}
