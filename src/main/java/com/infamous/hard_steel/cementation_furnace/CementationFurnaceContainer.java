package com.infamous.hard_steel.cementation_furnace;

import com.infamous.hard_steel.cementation_furnace.CementationFurnaceRegistryEvents;
import com.infamous.hard_steel.proxy.IHardSteelRecipeType;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.container.AbstractFurnaceContainer;
import net.minecraft.util.IIntArray;

public class CementationFurnaceContainer extends AbstractFurnaceContainer {

    public CementationFurnaceContainer(int id, PlayerInventory playerInventoryIn) {
        super(CementationFurnaceRegistryEvents.CEMENTATION_FURNACE_CONTAINER, IHardSteelRecipeType.CEMENTATION, id, playerInventoryIn);
    }

    public CementationFurnaceContainer(int id, PlayerInventory playerInventoryIn, IInventory furnaceInventoryIn, IIntArray p_i50098_4_) {
        super(CementationFurnaceRegistryEvents.CEMENTATION_FURNACE_CONTAINER, IHardSteelRecipeType.CEMENTATION, id, playerInventoryIn, furnaceInventoryIn, p_i50098_4_);
    }
}
