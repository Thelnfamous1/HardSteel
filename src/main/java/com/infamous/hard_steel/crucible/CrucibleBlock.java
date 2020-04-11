package com.infamous.hard_steel.crucible;

import com.infamous.hard_steel.HardSteel;
import com.infamous.hard_steel.bloomery.BloomeryTileEntity;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.pathfinding.PathType;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.IProperty;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.stats.Stats;
import net.minecraft.tileentity.AbstractFurnaceTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.shapes.IBooleanFunction;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nullable;
import java.util.Random;

public class CrucibleBlock extends Block implements ITileEntityProvider {
    public static final IntegerProperty LEVEL;
    private static final VoxelShape INSIDE;
    protected static final VoxelShape SHAPE;
    public static final BooleanProperty LIT;

    public CrucibleBlock() {
        super(Properties.create(Material.ROCK).hardnessAndResistance(3.5F).lightValue(13));
        this.setDefaultState((BlockState)((BlockState)((BlockState)this.stateContainer.getBaseState()).with(LIT, false)));
        setRegistryName(HardSteel.modid, "crucible");
    }

    public int getLightValue(BlockState blockState) {
        return (Boolean)blockState.get(LIT) ? super.getLightValue(blockState) : 0;
    }

    public boolean onBlockActivated(BlockState blockState, World world, BlockPos blockPos, PlayerEntity playerEntity, Hand hand, BlockRayTraceResult blockRayTraceResult) {
        if (!world.isRemote) {
            this.interactWith(world, blockPos, playerEntity);
        }

        return true;
    }

    public VoxelShape getShape(BlockState blockState, IBlockReader iBlockReader, BlockPos blockPos, ISelectionContext iSelectionContext) {
        return SHAPE;
    }

    public boolean isSolid(BlockState blockState) {
        return false;
    }

    public VoxelShape getRaytraceShape(BlockState blockState, IBlockReader iBlockReader, BlockPos blockPos) {
        return INSIDE;
    }

    public void onEntityCollision(BlockState blockState, World world, BlockPos blockPos, Entity entity) {
        //int level = (Integer)blockState.get(LEVEL);
        //float lvt_6_1_ = (float)blockPos.getY() + (6.0F + (float)(3 * level)) / 16.0F;
        if (!world.isRemote && blockState.get(LIT)
                // && entity.getBoundingBox().minY <= (double)lvt_6_1_
        ) {
            entity.setFire(5);
        }

    }

    protected void interactWith(World worldIn, BlockPos pos, PlayerEntity player) {
        TileEntity tileentity = worldIn.getTileEntity(pos);
        if (tileentity instanceof CrucibleTileEntity) {
            player.openContainer((INamedContainerProvider) tileentity);
            player.addStat(Stats.INTERACT_WITH_FURNACE);
        }

    }

    @OnlyIn(Dist.CLIENT)
    public void animateTick(BlockState blockState, World world, BlockPos blockPos, Random random) {
        if ((Boolean)blockState.get(LIT)) {
            double xPos = (double)blockPos.getX() + 0.5D;
            double yPos = (double)blockPos.getY();
            double zPos = (double)blockPos.getZ() + 0.5D;
            if (random.nextDouble() < 0.1D) {
                world.playSound(xPos, yPos, zPos, SoundEvents.BLOCK_SMOKER_SMOKE, SoundCategory.BLOCKS, 1.0F, 1.0F, false);
            }

            this.setWaterLevel(world, blockPos, blockState, 2);
            world.addParticle(ParticleTypes.SMOKE, xPos, yPos + 1.1D, zPos, 0.0D, 0.0D, 0.0D);
        }
    }

    public void setWaterLevel(World world, BlockPos blockPos, BlockState blockState, int level) {
        world.setBlockState(blockPos, (BlockState)blockState.with(LEVEL, MathHelper.clamp(level, 0, 3)), 2);
        world.updateComparatorOutputLevel(blockPos, this);
    }

    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> blockStateBuilder) {
        blockStateBuilder.add(new IProperty[]{LEVEL, LIT});
    }

    public boolean allowsMovement(BlockState blockState, IBlockReader iBlockReader, BlockPos blockPos, PathType pathType) {
        return false;
    }

    static {
        LEVEL = BlockStateProperties.LEVEL_0_3;
        INSIDE = makeCuboidShape(2.0D, 4.0D, 2.0D, 14.0D, 16.0D, 14.0D);
        SHAPE = VoxelShapes.combineAndSimplify(VoxelShapes.fullCube(), VoxelShapes.or(makeCuboidShape(0.0D, 0.0D, 4.0D, 16.0D, 3.0D, 12.0D), new VoxelShape[]{makeCuboidShape(4.0D, 0.0D, 0.0D, 12.0D, 3.0D, 16.0D), makeCuboidShape(2.0D, 0.0D, 2.0D, 14.0D, 3.0D, 14.0D), INSIDE}), IBooleanFunction.ONLY_FIRST);
    }

    public boolean eventReceived(BlockState blockState, World world, BlockPos blockPos, int p_189539_4_, int p_189539_5_) {
        super.eventReceived(blockState, world, blockPos, p_189539_4_, p_189539_5_);
        TileEntity tileEntity = world.getTileEntity(blockPos);
        return tileEntity == null ? false : tileEntity.receiveClientEvent(p_189539_4_, p_189539_5_);
    }

    public void onReplaced(BlockState blockState, World world, BlockPos blockPos, BlockState blockState1, boolean b) {
        if (blockState.getBlock() != blockState1.getBlock()) {
            TileEntity tileEntity = world.getTileEntity(blockPos);
            if (tileEntity instanceof CrucibleTileEntity) {
                InventoryHelper.dropInventoryItems(world, blockPos, (CrucibleTileEntity)tileEntity);
                world.updateComparatorOutputLevel(blockPos, this);
            }

            super.onReplaced(blockState, world, blockPos, blockState1, b);
        }
    }

    @Nullable
    public INamedContainerProvider getContainer(BlockState blockState, World world, BlockPos blockPos) {
        TileEntity tileEntity = world.getTileEntity(blockPos);
        return tileEntity instanceof INamedContainerProvider ? (INamedContainerProvider)tileEntity : null;
    }

    public TileEntity createNewTileEntity(IBlockReader worldIn) {
        return new CrucibleTileEntity();
    }

    @Nullable
    @Override
    public TileEntity createTileEntity(BlockState state, IBlockReader world) {
        return new CrucibleTileEntity();
    }

    @Override
    public boolean hasTileEntity(BlockState state) {
        return true;
    }

    static {
        LIT = RedstoneTorchBlock.LIT;
    }
}