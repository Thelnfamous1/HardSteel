package com.infamous.hard_steel.bloomery;

import com.infamous.hard_steel.proxy.IHardSteelRecipeType;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.tileentity.AbstractFurnaceTileEntity;
import net.minecraft.util.Direction;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;

import javax.annotation.Nullable;

public class BloomeryTileEntity extends AbstractFurnaceTileEntity {

    public BloomeryTileEntity() {
        super(BloomeryRegistryEvents.BLOOMERY_TILEENTITY, IHardSteelRecipeType.BLOOMING);
    }

    @Override
    protected ITextComponent getDefaultName() {
        return new TranslationTextComponent("Bloomery");
    }

    @Override
    protected Container createMenu(int id, PlayerInventory player) {
        return new BloomeryContainer(id, player, this, this.furnaceData);
    }

}
