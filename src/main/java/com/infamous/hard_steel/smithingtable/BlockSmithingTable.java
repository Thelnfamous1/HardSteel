package com.infamous.hard_steel.smithingtable;

import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.item.FallingBlockEntity;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.inventory.container.RepairContainer;
import net.minecraft.inventory.container.SimpleNamedContainerProvider;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.ItemStack;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.IProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.IWorldPosCallable;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkHooks;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.Random;
import java.util.stream.IntStream;

//import static net.minecraft.tags.BlockTags.ANVIL;

public class BlockSmithingTable extends Block {

    public static final DirectionProperty FACING;

    public BlockSmithingTable() {
        super(Block.Properties.create(Material.WOOD, MaterialColor.IRON).hardnessAndResistance(2.5F).sound(SoundType.WOOD));
        this.setDefaultState((BlockState)((BlockState)this.stateContainer.getBaseState()).with(FACING, Direction.NORTH));
        this.setRegistryName("hard_steel", "smithing_table");
    }

    public BlockState getStateForPlacement(BlockItemUseContext p_196258_1_) {
        return (BlockState)this.getDefaultState().with(FACING, p_196258_1_.getPlacementHorizontalFacing());
    }

    public BlockState rotate(BlockState p_185499_1_, Rotation p_185499_2_) {
        return (BlockState) p_185499_1_.with(FACING, p_185499_2_.rotate((Direction) p_185499_1_.get(FACING)));
    }

    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> p_206840_1_) {
        p_206840_1_.add(new IProperty[]{FACING});
    }

    static {
        FACING = HorizontalBlock.HORIZONTAL_FACING;
    }

    //@Override
    //public boolean hasTileEntity(BlockState state) {
        //return true;
    //}

   // @Override
    //public INamedContainerProvider getContainer(BlockState state, World world, BlockPos pos) {
        //INamedContainerProvider container = state.getContainer(world,pos);
        //TileEntity te = world.getTileEntity(pos);
            //return te instanceof SmithingTableTileEntity ? (INamedContainerProvider) te : null;
        //return container instanceof SmithingTableContainer ? (INamedContainerProvider) container : null;
    //}

    @Nullable
    public INamedContainerProvider getContainer(BlockState blockState, World world, BlockPos blockPos) {
        return new SimpleNamedContainerProvider((windowId, playerInventory, p_220272_4_) -> {
            return new SmithingTableContainer(windowId, playerInventory, IWorldPosCallable.of(world, blockPos));
        }, new TranslationTextComponent("Repair & Rename"));
    }

    public boolean onBlockActivated(BlockState blockState, World world, BlockPos blockPos, PlayerEntity playerEntity, Hand hand, BlockRayTraceResult blockRayTraceResult) {
        playerEntity.openContainer(blockState.getContainer(world, blockPos));
        return true;
    }

    //@Override
    //public boolean onBlockActivated(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockRayTraceResult result) {
    //    if (!world.isRemote) {
    //        TileEntity tileEntity = world.getTileEntity(pos);
    //        if (tileEntity instanceof INamedContainerProvider) {
    //            NetworkHooks.openGui((ServerPlayerEntity) player, (INamedContainerProvider) tileEntity, tileEntity.getPos());
    //        } else {
     //           throw new IllegalStateException("Our named container provider is missing!");
     //       }
     //   }
     //   return true;
   // }

    @Override
    public void onReplaced(BlockState state, @Nonnull World worldIn, @Nonnull BlockPos pos, @Nonnull BlockState newState, boolean isMoving) {
        //if (!newState.getBlock().isIn(ANVIL)) {
            TileEntity tileentity = worldIn.getTileEntity(pos);
            if (tileentity instanceof SmithingTableTileEntity) {
                dropItems((SmithingTableTileEntity) tileentity,worldIn, pos);
                // worldIn.updateComparatorOutputLevel(pos, this);
            }
            super.onReplaced(state, worldIn, pos, newState, isMoving);
        //}
    }

    public static void dropItems(SmithingTableTileEntity smithingTable, World world, BlockPos pos) {
        IntStream.range(0, smithingTable.handler.getSlots()).mapToObj(i -> smithingTable.handler.getStackInSlot(i)).filter(stack -> !stack.isEmpty()).forEach(stack -> spawnItemStack(world, pos.getX(), pos.getY(), pos.getZ(), stack));
    }

    private static final Random RANDOM = new Random();

    public static void spawnItemStack(World worldIn, double x, double y, double z, ItemStack stack) {
        double d0 = EntityType.ITEM.getWidth();
        double d1 = 1.0D - d0;
        double d2 = d0 / 2.0D;
        double d3 = Math.floor(x) + RANDOM.nextDouble() * d1 + d2;
        double d4 = Math.floor(y) + RANDOM.nextDouble() * d1;
        double d5 = Math.floor(z) + RANDOM.nextDouble() * d1 + d2;

        while(!stack.isEmpty()) {
            ItemEntity itementity = new ItemEntity(worldIn, d3, d4, d5, stack.split(RANDOM.nextInt(21) + 10));
            float f = 0.05F;
            itementity.setMotion(RANDOM.nextGaussian() * f, RANDOM.nextGaussian() * f + 0.2, RANDOM.nextGaussian() * f);
            worldIn.addEntity(itementity);
        }
    }

    //@Nullable
    //@Override
    //public TileEntity createTileEntity(BlockState state, IBlockReader world) {
     //   return new SmithingTableTileEntity(SmithingTableRegistryEvents.SMITHING_TABLE_TILEENTITY);
    //}
}
