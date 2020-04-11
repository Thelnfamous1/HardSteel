package com.infamous.hard_steel.finery_forge;

import com.infamous.hard_steel.HardSteel;
import net.minecraft.block.BlastFurnaceBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.SmokerBlock;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.stats.Stats;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nullable;
import java.util.Random;

public class FineryForgeBlock extends BlastFurnaceBlock {
    public FineryForgeBlock() {
        super(Properties.create(Material.ROCK).hardnessAndResistance(3.5F).lightValue(13));
        setRegistryName(HardSteel.modid, "finery_forge");
    }

    @Override
    protected void interactWith(World worldIn, BlockPos pos, PlayerEntity player) {
        TileEntity tileentity = worldIn.getTileEntity(pos);
        if (tileentity instanceof FineryForgeTileEntity) {
            player.openContainer((INamedContainerProvider) tileentity);
            player.addStat(Stats.INTERACT_WITH_BLAST_FURNACE);
        }

    }

    @Override
    public TileEntity createNewTileEntity(IBlockReader worldIn) {
        return new FineryForgeTileEntity();
    }

    @Nullable
    @Override
    public TileEntity createTileEntity(BlockState state, IBlockReader world) {
        return new FineryForgeTileEntity();
    }

    @Override
    public boolean hasTileEntity(BlockState state) {
        return true;
    }
}