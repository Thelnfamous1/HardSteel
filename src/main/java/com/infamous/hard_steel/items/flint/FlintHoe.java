package com.infamous.hard_steel.items.flint;

import java.util.List;

import com.infamous.hard_steel.items.BetterHoe;
import com.infamous.hard_steel.lists.ItemList;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.*;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;

public class FlintHoe extends BetterHoe
{

	public FlintHoe(IItemTier tier, float attackDamageIn, float attackSpeedIn, Properties builder)
	{
		super(tier, attackDamageIn, attackSpeedIn, builder);
	}

	@Override
	public boolean isBookEnchantable(ItemStack stack, ItemStack book)
	{
		return true;
	}

	@Override
	public boolean getIsRepairable(ItemStack toRepair, ItemStack repair)
	{
		return repair.getItem() == ItemList.sharp_flint;
	}

	@Override
	public void addInformation(ItemStack stack, World world, List<ITextComponent> list, ITooltipFlag flag)
	{
		super.addInformation(stack, world, list, flag);
		list.add(new StringTextComponent(TextFormatting.GREEN + "Tier 0"));
	}
}
