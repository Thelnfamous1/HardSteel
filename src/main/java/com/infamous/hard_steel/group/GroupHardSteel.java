package com.infamous.hard_steel.group;

import com.infamous.hard_steel.HardSteel;
import com.infamous.hard_steel.lists.ItemList;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class GroupHardSteel extends ItemGroup
{
	public GroupHardSteel()
	{
		super(HardSteel.modid);
	}

	@Override
	public ItemStack createIcon() 
	{
		return new ItemStack(ItemList.steel_ingot);
	}	
}
