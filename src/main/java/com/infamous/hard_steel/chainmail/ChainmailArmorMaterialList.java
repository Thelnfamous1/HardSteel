package com.infamous.hard_steel.chainmail;

import com.infamous.hard_steel.HardSteel;
import com.infamous.hard_steel.config.GeneralModConfig;
import com.infamous.hard_steel.lists.ItemList;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;

public enum ChainmailArmorMaterialList implements IArmorMaterial
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
	copper_chainmail("copper_chainmail", 6, new int[] {1, 3, 4, 1}, 20, ItemList.copper_chain, "item.armor.equip_iron", 0.0f),
	// Tier 2
	bronze_chainmail("bronze_chainmail", 11, new int[] {1, 4, 5, 2}, 15, ItemList.bronze_chain, "item.armor.equip_iron", 0.0f),
	iron_chainmail("iron_chainmail", 11, new int[] {1, 4, 5, 2}, 10, ItemList.iron_chain, "item.armor.equip_iron", 0.0f),
	// Tier 3
	steel_chainmail("steel_chainmail", 17, new int[] {2, 5, 7, 2}, 5, ItemList.steel_chain, "item.armor.equip_iron", 0.0f),
	mithril_chainmail("mithril_chainmail", 24, new int[] {2, 5, 7, 2}, 10, ItemList.mithril_chain, "item.armor.equip_iron", 0.0f),
	// Tier 4
	netherite_chainmail("netherite_chainmail", 28, new int[] {2, 5, 7, 2}, 15, ItemList.netherite_chain, "item.armor.equip_iron", 0.0f),
	enderite_chainmail("enderite_chainmail", 28, new int[] {2, 5, 7, 2}, 20, ItemList.enderite_chain, "item.armor.equip_iron", 0.0f);


	// Armor order: boots, leggings, chestplate, helmet
	private static final int[] max_damage_array = new int[]{13, 15, 16, 11};
	private String name, equipSound;
	private int durability, enchantability;
	private Item repairItem;
	private int[] damageReductionAmounts;
	private float toughness;

	private ChainmailArmorMaterialList(String name, int durability, int[] damageReductionAmounts, int enchantability, Item repairItem, String equipSound, float toughness)
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
