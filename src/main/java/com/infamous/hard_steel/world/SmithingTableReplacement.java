package com.infamous.hard_steel.world;

import com.infamous.hard_steel.smithingtable.SmithingTableRegistryEvents;
import com.mojang.datafixers.Dynamic;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.GenerationSettings;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.NoFeatureConfig;

import java.util.Random;
import java.util.function.Function;

public class SmithingTableReplacement extends Feature<NoFeatureConfig> {

    public SmithingTableReplacement(Function<Dynamic<?>, ? extends NoFeatureConfig> configFactoryIn) {
        super(configFactoryIn);
    }

    @Override
    public boolean place(IWorld worldIn, ChunkGenerator<? extends GenerationSettings> generator, Random rand, BlockPos pos, NoFeatureConfig config) {
        BlockPos.MutableBlockPos blockPos$mutableBlockPos = new BlockPos.MutableBlockPos();
        int startX = pos.getX();
        int startZ = pos.getZ();
        //if (Config option to replace vanilla smithing table in villages is enabled) {
            for (int x = 0; x < 16; ++x) {
                for (int y = 0; y < worldIn.getMaxHeight(); ++y) {
                    for (int z = 0; z < 16; ++z) {
                        blockPos$mutableBlockPos.setPos(startX + x, y, startZ + z);
                        if (worldIn.getBlockState(blockPos$mutableBlockPos).getBlock() == Blocks.SMITHING_TABLE) {
                            //if (Config.WORLDGEN_CAMPFIRES_STARTLIT.get()) {
                            //    worldIn.setBlockState(blockPos$mutableBlockPos, ModBlocks.CAMPFIRE.getDefaultState().with(ImmersiveCampfireBlock.getIsLit(), true).with(ImmersiveCampfireBlock.getAge(), ImmersiveCampfireBlock.getMinuteCounter()), 3);
                            //    worldIn.getPendingBlockTicks().scheduleTick(blockPos$mutableBlockPos, worldIn.getBlockState(blockPos$mutableBlockPos).getBlock(), worldIn.getBlockState(blockPos$mutableBlockPos).getBlock().tickRate(worldIn));
                            //}
                            //else
                            worldIn.setBlockState(blockPos$mutableBlockPos, SmithingTableRegistryEvents.SMITHING_TABLE.getDefaultState(), 3);
                        }
                    }
                }
            }
        //}
        return true;
    }
}
