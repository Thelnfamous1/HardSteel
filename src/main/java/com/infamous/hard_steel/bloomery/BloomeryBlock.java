package com.infamous.hard_steel.bloomery;

import com.infamous.hard_steel.HardSteel;
import net.minecraft.block.BlockState;
import net.minecraft.block.FurnaceBlock;
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

public class BloomeryBlock extends SmokerBlock {
    public BloomeryBlock() {
        super(Properties.create(Material.ROCK).hardnessAndResistance(3.5F).lightValue(13));
        setRegistryName(HardSteel.modid, "bloomery");
    }

    @Override
    protected void interactWith(World worldIn, BlockPos pos, PlayerEntity player) {
        TileEntity tileentity = worldIn.getTileEntity(pos);
        if (tileentity instanceof BloomeryTileEntity) {
            player.openContainer((INamedContainerProvider) tileentity);
            player.addStat(Stats.INTERACT_WITH_FURNACE);
        }

    }

    @Override
    public TileEntity createNewTileEntity(IBlockReader worldIn) {
        return new BloomeryTileEntity();
    }

    @Nullable
    @Override
    public TileEntity createTileEntity(BlockState state, IBlockReader world) {
        return new BloomeryTileEntity();
    }

    @Override
    public boolean hasTileEntity(BlockState state) {
        return true;
    }
}