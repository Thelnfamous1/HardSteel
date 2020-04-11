package com.infamous.hard_steel.finery_forge;

import com.infamous.hard_steel.proxy.IHardSteelRecipeType;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.AbstractFurnaceTileEntity;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;

public class FineryForgeTileEntity extends AbstractFurnaceTileEntity {

    public FineryForgeTileEntity() {
        super(FineryForgeRegistryEvents.FINERY_FORGE_TILEENTITY, IHardSteelRecipeType.FINING);
    }

    @Override
    protected ITextComponent getDefaultName() {
        return new TranslationTextComponent("Finery Forge");
    }

    @Override
    protected int getBurnTime(ItemStack itemStack) {
        return super.getBurnTime(itemStack) / 2;
    }

    @Override
    protected Container createMenu(int id, PlayerInventory player) {
        return new FineryForgeContainer(id, player, this, this.furnaceData);
    }

}
