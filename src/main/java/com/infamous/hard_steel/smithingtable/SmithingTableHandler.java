package com.infamous.hard_steel.smithingtable;

import net.minecraft.item.ItemStack;
import net.minecraftforge.items.ItemStackHandler;

import java.util.List;

public class SmithingTableHandler extends ItemStackHandler {
    public SmithingTableHandler(int i) {
        super(i);
    }
    public List<ItemStack> getContents(){
        return this.stacks;
    }
}
