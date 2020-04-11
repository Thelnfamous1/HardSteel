package com.infamous.hard_steel.lists;

import com.infamous.hard_steel.config.GeneralModConfig;
import net.minecraft.item.IItemTier;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.Ingredient;


public enum ToolMaterialList implements IItemTier
{	
	/*
	 * Durability:
	 * Wood = 59
	 * Stone = 131
	 * Iron = 250
	 * Diamond = 1561
	 * Netherite = 2031
	 * Gold = 32
	 *
	 * Damage (Swords):
	 * Wood = 4
	 * Gold = 4
	 * Stone = 5
	 * Iron = 6
	 * Diamond = 7
	 * Netherite = 8
	 *
	 * Attack Speeds
	 * Swords = 1.6 = -2.4f
	 * Axes = 0.8 to 1 = -3.4 to -3.2
	 * Pickaxes = 1.2 = -2.8
	 * Shovels = 1 = -3.0
	 * Hoes = 1 to 4 = -3.2 to -0.2
	 *
	 * Enchantability:
	 * Wood = 15
	 * Stone = 5
	 * Iron = 14
	 * Diamond = 10
	 * Netherite = 15
	 * Gold = 22
	 * 
	 */

	// Tier 0
	flint(0.0F, 2.0F, 65, 0, 0, Items.FLINT), // uses vanilla flint
	// Tier 1
	copper(1.0F, 4.0f, 125, 1, 20, ItemList.copper_ingot),
	// Tier 2
	bronze(2.0F, 6.0f, 250, 2, 15, ItemList.bronze_ingot),
	iron(2.0F, 6.0f, 250, 2, 10, Items.IRON_INGOT), // uses vanilla iron ingot
	// Tier 4
	steel(3.0F, 8.0f, 500, 3, 5, ItemList.steel_ingot),
	mithril(3.0F, 8.0f, 1000, 3, 10, ItemList.mithril_ingot),
	// Tier 5
	netherite(4.0F, 10.0f, 2000, 4, 15, ItemList.netherite_ingot),
	enderite(4.0F, 10.0f, 4000, 4, 20, ItemList.enderite_ingot);
	

	private float attackDamage, efficiency;
	private int durability, harvestLevel, enchantability;
	private Item repairMaterial;
	
	private ToolMaterialList(float attackDamage, float efficiency, int durability, int harvestLevel, int enchantability, Item repairMaterial)
	{
		this.attackDamage = attackDamage;
		this.efficiency = efficiency;
		this.durability = durability;
		this.harvestLevel = harvestLevel;
		this.enchantability = enchantability;
		this.repairMaterial = repairMaterial;
	}

	@Override
	public float getAttackDamage() 
	{
		return this.attackDamage;
	}

	@Override
	public float getEfficiency() 
	{
		return this.efficiency;
	}

	@Override
	public int getEnchantability() 
	{
		return this.enchantability;
	}

	@Override
	public int getHarvestLevel()
	{
		return this.harvestLevel;
	}

	@Override
	public int getMaxUses() 
	{
		return this.durability;
	}

	@Override
	public Ingredient getRepairMaterial() 
	{
		return Ingredient.fromItems(this.repairMaterial);
	}
}
