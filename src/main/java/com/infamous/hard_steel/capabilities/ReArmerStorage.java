package com.infamous.hard_steel.capabilities;

import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.INBT;
import net.minecraft.util.Direction;
import net.minecraftforge.common.capabilities.Capability;

import javax.annotation.Nullable;

public class ReArmerStorage implements Capability.IStorage<IReArmer> {

    @Nullable
    @Override
    public INBT writeNBT(Capability<IReArmer> capability, IReArmer instance, Direction side) {
        CompoundNBT tag = new CompoundNBT();
        tag.putBoolean("isReArmed", instance.getReArmed());
        return tag;
    }

    @Override
    public void readNBT(Capability<IReArmer> capability, IReArmer instance, Direction side, INBT nbt) {
        CompoundNBT tag = (CompoundNBT) nbt;
        instance.setReArmed(tag.getBoolean("isReArmed"));
    }
}
