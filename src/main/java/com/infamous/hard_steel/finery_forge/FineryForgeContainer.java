package com.infamous.hard_steel.finery_forge;


import com.infamous.hard_steel.proxy.IHardSteelRecipeType;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.container.AbstractFurnaceContainer;
import net.minecraft.util.IIntArray;

public class FineryForgeContainer extends AbstractFurnaceContainer {

    public FineryForgeContainer(int id, PlayerInventory playerInventoryIn) {
        super(FineryForgeRegistryEvents.FINERY_FORGE_CONTAINER, IHardSteelRecipeType.FINING, id, playerInventoryIn);
    }

    public FineryForgeContainer(int id, PlayerInventory playerInventoryIn, IInventory furnaceInventoryIn, IIntArray p_i50098_4_) {
        super(FineryForgeRegistryEvents.FINERY_FORGE_CONTAINER, IHardSteelRecipeType.FINING, id, playerInventoryIn, furnaceInventoryIn, p_i50098_4_);
    }
}
