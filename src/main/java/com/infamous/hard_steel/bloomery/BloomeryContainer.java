package com.infamous.hard_steel.bloomery;

import com.infamous.hard_steel.proxy.IHardSteelRecipeType;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.container.AbstractFurnaceContainer;
import net.minecraft.util.IIntArray;

public class BloomeryContainer extends AbstractFurnaceContainer {

    public BloomeryContainer(int id, PlayerInventory playerInventoryIn) {
        super(BloomeryRegistryEvents.BLOOMERY_CONTAINER, IHardSteelRecipeType.BLOOMING, id, playerInventoryIn);
    }

    public BloomeryContainer(int id, PlayerInventory playerInventoryIn, IInventory furnaceInventoryIn, IIntArray p_i50098_4_) {
        super(BloomeryRegistryEvents.BLOOMERY_CONTAINER, IHardSteelRecipeType.BLOOMING, id, playerInventoryIn, furnaceInventoryIn, p_i50098_4_);
    }
}
