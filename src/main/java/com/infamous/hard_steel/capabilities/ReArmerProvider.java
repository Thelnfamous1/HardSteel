package com.infamous.hard_steel.capabilities;

import net.minecraft.nbt.INBT;
import net.minecraft.util.Direction;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;
import net.minecraftforge.common.util.LazyOptional;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class ReArmerProvider implements ICapabilitySerializable<INBT> {

    @CapabilityInject(IReArmer.class)
    public static final Capability<IReArmer> REARMER_CAPABILITY = null;

    private LazyOptional<IReArmer> instance = LazyOptional.of(REARMER_CAPABILITY::getDefaultInstance);

    @Nonnull
    @Override
    public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> cap, @Nullable Direction side) {
        return cap == REARMER_CAPABILITY ? instance.cast() : LazyOptional.empty();    }

    @Override
    public INBT serializeNBT() {
        return REARMER_CAPABILITY.getStorage().writeNBT(REARMER_CAPABILITY, this.instance.orElseThrow(() -> new IllegalArgumentException("LazyOptional must not be empty!")), null);
    }

    @Override
    public void deserializeNBT(INBT nbt) {
        REARMER_CAPABILITY.getStorage().readNBT(REARMER_CAPABILITY, this.instance.orElseThrow(() -> new IllegalArgumentException("LazyOptional must not be empty!")), null, nbt);
    }
}
