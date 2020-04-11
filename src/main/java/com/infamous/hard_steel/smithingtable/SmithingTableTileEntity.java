package com.infamous.hard_steel.smithingtable;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SUpdateTileEntityPacket;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.IWorldPosCallable;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.Random;

public class SmithingTableTileEntity extends TileEntity implements INamedContainerProvider {

    public SmithingTableHandler handler;

    public final Random rand = new Random();
    public int[] angles = {0,0};

    public SmithingTableTileEntity(TileEntityType<?> tileEntityType) {
        super(tileEntityType);
        this.handler = new SmithingTableHandler(2);
    }

    @Nonnull
    @Override
    public CompoundNBT write(CompoundNBT tag) {
        CompoundNBT compound = this.handler.serializeNBT();
        tag.put("inv", compound);
        return super.write(tag);
    }

    @Override
    public void read(CompoundNBT tag) {
        CompoundNBT invTag = tag.getCompound("inv");
        handler.deserializeNBT(invTag);
        super.read(tag);
    }

    @Override
    public ITextComponent getDisplayName() {
        return new TranslationTextComponent("Repair & Rename");
    }

    @Nullable
    @Override
    public Container createMenu(int i, PlayerInventory playerInventory, PlayerEntity player) {
        return new SmithingTableContainer(i, playerInventory, IWorldPosCallable.of(world, pos));
    }

    @Override
    public void markDirty() {
        super.markDirty();
    }

    @Override
    public CompoundNBT getUpdateTag()
    {
        return write(new CompoundNBT());    // okay to send entire inventory on chunk load
    }

    @Override
    public SUpdateTileEntityPacket getUpdatePacket()
    {
        CompoundNBT nbt = new CompoundNBT();
        this.write(nbt);

        return new SUpdateTileEntityPacket(getPos(), 1, nbt);
    }

    @Override
    public void onDataPacket(NetworkManager net, SUpdateTileEntityPacket packet)
    {
        this.read(packet.getNbtCompound());
    }
}
