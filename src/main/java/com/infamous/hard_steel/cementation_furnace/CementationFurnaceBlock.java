package com.infamous.hard_steel.cementation_furnace;

import com.infamous.hard_steel.HardSteel;
import com.infamous.hard_steel.cementation_furnace.CementationFurnaceTileEntity;
import net.minecraft.block.BlockState;
import net.minecraft.block.SmokerBlock;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.stats.Stats;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;

import javax.annotation.Nullable;

public class CementationFurnaceBlock extends SmokerBlock {
    public CementationFurnaceBlock() {
        super(Properties.create(Material.ROCK).hardnessAndResistance(3.5F).lightValue(13));
        setRegistryName(HardSteel.modid, "cementation_furnace");
    }

    @Override
    protected void interactWith(World worldIn, BlockPos pos, PlayerEntity player) {
        TileEntity tileentity = worldIn.getTileEntity(pos);
        if (tileentity instanceof CementationFurnaceTileEntity) {
            player.openContainer((INamedContainerProvider) tileentity);
            player.addStat(Stats.INTERACT_WITH_FURNACE);
        }

    }

    @Override
    public TileEntity createNewTileEntity(IBlockReader worldIn) {
        return new CementationFurnaceTileEntity();
    }

    @Nullable
    @Override
    public TileEntity createTileEntity(BlockState state, IBlockReader world) {
        return new CementationFurnaceTileEntity();
    }

    @Override
    public boolean hasTileEntity(BlockState state) {
        return true;
    }
}