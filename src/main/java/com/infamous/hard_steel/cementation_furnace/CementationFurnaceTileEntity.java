package com.infamous.hard_steel.cementation_furnace;

import com.infamous.hard_steel.cementation_furnace.CementationFurnaceContainer;
import com.infamous.hard_steel.cementation_furnace.CementationFurnaceRegistryEvents;
import com.infamous.hard_steel.proxy.IHardSteelRecipeType;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.tileentity.AbstractFurnaceTileEntity;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;

public class CementationFurnaceTileEntity extends AbstractFurnaceTileEntity {

    public CementationFurnaceTileEntity() {
        super(CementationFurnaceRegistryEvents.CEMENTATION_FURNACE_TILEENTITY, IHardSteelRecipeType.CEMENTATION);
    }

    @Override
    protected ITextComponent getDefaultName() {
        return new TranslationTextComponent("Cementation Furnace");
    }

    @Override
    protected Container createMenu(int id, PlayerInventory player) {
        return new CementationFurnaceContainer(id, player, this, this.furnaceData);
    }

}
