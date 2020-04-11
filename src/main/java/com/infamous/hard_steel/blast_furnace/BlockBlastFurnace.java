package com.infamous.hard_steel.blast_furnace;

import com.infamous.hard_steel.HardSteel;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.stats.Stats;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.network.NetworkHooks;

import javax.annotation.Nullable;
import java.util.Random;

public class  BlockBlastFurnace extends Block {
    public static final BooleanProperty LIT;
    public static final DirectionProperty FACING = HorizontalBlock.HORIZONTAL_FACING;

    public BlockBlastFurnace() {
        super(Properties.create(Material.ROCK)
                .sound(SoundType.METAL)
                .hardnessAndResistance(3.5F)
                .lightValue(13));
        setRegistryName(HardSteel.modid, "blast_furnace");
        this.setDefaultState(this.stateContainer.getBaseState().with(FACING, Direction.NORTH).with(BlockBlastFurnace.LIT, false));
    }

    @OnlyIn(Dist.CLIENT)
    public void animateTick(BlockState blockState, World world, BlockPos blockPos, Random random) {
        if ((Boolean)blockState.get(LIT)) {
            double lvt_5_1_ = (double)blockPos.getX() + 0.5D;
            double lvt_7_1_ = (double)blockPos.getY();
            double lvt_9_1_ = (double)blockPos.getZ() + 0.5D;
            if (random.nextDouble() < 0.1D) {
                world.playSound(lvt_5_1_, lvt_7_1_, lvt_9_1_, SoundEvents.BLOCK_BLASTFURNACE_FIRE_CRACKLE, SoundCategory.BLOCKS, 1.0F, 1.0F, false);
            }

            Direction lvt_11_1_ = (Direction)blockState.get(FACING);
            Direction.Axis lvt_12_1_ = lvt_11_1_.getAxis();
            double lvt_13_1_ = 0.52D;
            double lvt_15_1_ = random.nextDouble() * 0.6D - 0.3D;
            double lvt_17_1_ = lvt_12_1_ == Direction.Axis.X ? (double)lvt_11_1_.getXOffset() * 0.52D : lvt_15_1_;
            double lvt_19_1_ = random.nextDouble() * 9.0D / 16.0D;
            double lvt_21_1_ = lvt_12_1_ == Direction.Axis.Z ? (double)lvt_11_1_.getZOffset() * 0.52D : lvt_15_1_;
            world.addParticle(ParticleTypes.SMOKE, lvt_5_1_ + lvt_17_1_, lvt_7_1_ + lvt_19_1_, lvt_9_1_ + lvt_21_1_, 0.0D, 0.0D, 0.0D);
        }
    }

    protected void interactWith(World p_220089_1_, BlockPos p_220089_2_, PlayerEntity p_220089_3_) {
        TileEntity lvt_4_1_ = p_220089_1_.getTileEntity(p_220089_2_);
        if (lvt_4_1_ instanceof TileEntityBlastFurnace) {
            p_220089_3_.openContainer((INamedContainerProvider)lvt_4_1_);
            p_220089_3_.addStat(Stats.INTERACT_WITH_BLAST_FURNACE);
        }

    }

    public void onReplaced(BlockState state, World worldIn, BlockPos pos, BlockState newState, boolean isMoving) {
        if (state.getBlock() != newState.getBlock()) {
            TileEntity tileentity = worldIn.getTileEntity(pos);
            if (tileentity instanceof TileEntityBlastFurnace) {
                InventoryHelper.dropInventoryItems(worldIn, pos, (TileEntityBlastFurnace)tileentity);
                worldIn.updateComparatorOutputLevel(pos, this);
            }
            super.onReplaced(state, worldIn, pos, newState, isMoving);
        }
    }

    public BlockState getStateForPlacement(BlockItemUseContext context) {
        return this.getDefaultState().with(FACING, context.getPlacementHorizontalFacing().getOpposite());
    }

    public static Direction getFacingFromEntity(BlockPos clickedBlock, LivingEntity entity) {
        return Direction.getFacingFromVector((float) (entity.posX - clickedBlock.getX()), (float) (entity.posY - clickedBlock.getY()), (float) (entity.posZ - clickedBlock.getZ()));
    }

    @Override
    public boolean hasTileEntity(BlockState state) {
        return true;
    }

    @Override
    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(FACING, BlockBlastFurnace.LIT);
    }

    @Nullable
    @Override
    public TileEntity createTileEntity(BlockState state, IBlockReader world) {
        return new TileEntityBlastFurnace();
    }

    @Override
    public boolean onBlockActivated(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockRayTraceResult result) {
        if (!world.isRemote) {
            TileEntity tileEntity = world.getTileEntity(pos);
            if (tileEntity instanceof INamedContainerProvider) {
                NetworkHooks.openGui((ServerPlayerEntity) player, (INamedContainerProvider) tileEntity, tileEntity.getPos());
            } else {
                throw new IllegalStateException("Named container provider missing");
            }
            return true;
        }
        return super.onBlockActivated(state, world, pos, player, hand, result);
    }

    public int getLightValue(BlockState blockState) {
        return (Boolean)blockState.get(LIT) ? super.getLightValue(blockState) : 0;
    }

    static {
        LIT = RedstoneTorchBlock.LIT;
    }
}