package com.infamous.hard_steel.util;

import com.google.common.collect.ImmutableSet;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;

import java.util.Set;

public class BlockStateUtilities {
    public static Set<BlockState> getAllStates(Block block) {
        return ImmutableSet.copyOf(block.getStateContainer().getValidStates());
    }
}
