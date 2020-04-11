package com.infamous.hard_steel.events;

import com.infamous.hard_steel.HardSteel;
import com.infamous.hard_steel.capabilities.IReArmer;
import com.infamous.hard_steel.capabilities.ReArmer;
import com.infamous.hard_steel.capabilities.ReArmerProvider;
import com.infamous.hard_steel.config.GeneralModConfig;
import net.minecraft.entity.monster.*;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.World;
import net.minecraft.world.chunk.Chunk;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.entity.living.LivingEquipmentChangeEvent;
import net.minecraftforge.event.entity.living.LivingSpawnEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class MobEquipEvent {

    @SubscribeEvent
    public void changeToModdedEquipment(LivingSpawnEvent.SpecialSpawn event){

        if ((event.getEntity() instanceof ZombieEntity &&
                !(event.getEntity() instanceof ZombiePigmanEntity) &&
                !(event.getEntity() instanceof HuskEntity) &&
                !(event.getEntity() instanceof ZombieVillagerEntity)
        ) && GeneralModConfig.MOBS_USE_HARD_STEEL_GEAR.get()) {
            ZombieEntity zombie = (ZombieEntity) event.getEntity();

            IReArmer reArmer = zombie.getCapability(ReArmerProvider.REARMER_CAPABILITY).orElseThrow(IllegalStateException::new);
            HardSteel.logger.info(zombie.toString() + " was re-armed?" + reArmer.getReArmed());

            if(!reArmer.getReArmed()){
                World world = event.getWorld().getWorld();
                //if(world.isBlockLoaded(zombie.getPosition())){
                    HardSteel.logger.info("Getting difficulty instance");
                    BlockPos zombiePosition = zombie.getPosition();
                    DifficultyInstance difficultyInstance = getDifficultyAtPosition(world, zombiePosition);
                    HardSteel.logger.info("Got the difficulty instance");
                    ZombieEquipUtilities.setArmorBasedOnDifficulty(difficultyInstance, world, zombie);
                    ZombieEquipUtilities.setHeldItemsBasedOnDifficulty(world, zombie);
                    ZombieEquipUtilities.setEnchantmentBasedOnDifficulty(difficultyInstance, zombie);

                    reArmer.setReArmed(true);
                    HardSteel.logger.info(zombie.toString() + " was re-armed?" + reArmer.getReArmed());
                //}
            }
        }
        if ((event.getEntity() instanceof HuskEntity) && GeneralModConfig.MOBS_USE_HARD_STEEL_GEAR.get()) {
            HuskEntity husk = (HuskEntity) event.getEntity();

            IReArmer reArmer = husk.getCapability(ReArmerProvider.REARMER_CAPABILITY).orElseThrow(IllegalStateException::new);

            if(!reArmer.getReArmed()){
                World world = event.getWorld().getWorld();
                //if(world.isBlockLoaded(husk.getPosition())){
                    //HardSteel.logger.info("Getting difficulty instance");
                BlockPos huskPosition = husk.getPosition();
                DifficultyInstance difficultyInstance = getDifficultyAtPosition(world, huskPosition);
                    //HardSteel.logger.info("Got the difficulty instance");
                    HuskEquipUtilities.setArmorBasedOnDifficulty(difficultyInstance, world, husk);
                    HuskEquipUtilities.setHeldItemsBasedOnDifficulty(world, husk);
                    HuskEquipUtilities.setEnchantmentBasedOnDifficulty(difficultyInstance, husk);

                    reArmer.setReArmed(true);
                //}

            }
        }
        if ((event.getEntity() instanceof ZombieVillagerEntity) && GeneralModConfig.MOBS_USE_HARD_STEEL_GEAR.get()) {
            ZombieVillagerEntity zombieVillager = (ZombieVillagerEntity) event.getEntity();

            IReArmer reArmer = zombieVillager.getCapability(ReArmerProvider.REARMER_CAPABILITY).orElseThrow(IllegalStateException::new);

            if(!reArmer.getReArmed()){
                World world = event.getWorld().getWorld();
                //if(world.isBlockLoaded(zombieVillager.getPosition())){
                    //HardSteel.logger.info("Getting difficulty instance");
                BlockPos zombieVillagerPosition = zombieVillager.getPosition();
                DifficultyInstance difficultyInstance = getDifficultyAtPosition(world, zombieVillagerPosition);
                    //HardSteel.logger.info("Got the difficulty instance");
                    ZombieVillagerEquipUtilities.setArmorBasedOnDifficulty(difficultyInstance, world, zombieVillager);
                    ZombieVillagerEquipUtilities.setHeldItemsBasedOnDifficulty(world, zombieVillager);
                    ZombieVillagerEquipUtilities.setEnchantmentBasedOnDifficulty(difficultyInstance, zombieVillager);


                    reArmer.setReArmed(true);
                //}
            }
        }
        if((event.getEntity() instanceof SkeletonEntity) && GeneralModConfig.MOBS_USE_HARD_STEEL_GEAR.get()){
            SkeletonEntity skeleton = (SkeletonEntity) event.getEntity();

            IReArmer reArmer = skeleton.getCapability(ReArmerProvider.REARMER_CAPABILITY).orElseThrow(IllegalStateException::new);

            if(!reArmer.getReArmed()){
                World world = event.getWorld().getWorld();
                //if(world.isBlockLoaded(skeleton.getPosition())){
                    //HardSteel.logger.info("Getting difficulty instance");
                BlockPos skeletonPosition = skeleton.getPosition();
                DifficultyInstance difficultyInstance = getDifficultyAtPosition(world, skeletonPosition);
                    //HardSteel.logger.info("Got the difficulty instance");
                    SkeletonEquipUtilities.setArmorBasedOnDifficulty(difficultyInstance, world, skeleton);
                    SkeletonEquipUtilities.setEnchantmentBasedOnDifficulty(difficultyInstance, skeleton);

                    reArmer.setReArmed(true);
                //}
            }
        }
        if((event.getEntity() instanceof StrayEntity) && GeneralModConfig.MOBS_USE_HARD_STEEL_GEAR.get()){
            StrayEntity stray = (StrayEntity) event.getEntity();

            IReArmer reArmer = stray.getCapability(ReArmerProvider.REARMER_CAPABILITY).orElseThrow(IllegalStateException::new);

            if(!reArmer.getReArmed()){
                World world = event.getWorld().getWorld();
                //if(world.isBlockLoaded(stray.getPosition())){
                    //HardSteel.logger.info("Getting difficulty instance");
                BlockPos strayPosition = stray.getPosition();
                DifficultyInstance difficultyInstance = getDifficultyAtPosition(world, strayPosition);
                    //HardSteel.logger.info("Got the difficulty instance");
                    StrayEquipUtilities.setArmorBasedOnDifficulty(difficultyInstance, world, stray);
                    StrayEquipUtilities.setEnchantmentBasedOnDifficulty(difficultyInstance, stray);

                    reArmer.setReArmed(true);
                //}
            }
        }
        if((event.getEntity() instanceof WitherSkeletonEntity) && GeneralModConfig.MOBS_USE_HARD_STEEL_GEAR.get()){
            //HardSteel.logger.info("Spawned a Wither Skeleton!");
            WitherSkeletonEntity witherSkeleton = (WitherSkeletonEntity) event.getEntity();

            IReArmer reArmer = witherSkeleton.getCapability(ReArmerProvider.REARMER_CAPABILITY).orElseThrow(IllegalStateException::new);

            if(!reArmer.getReArmed()){
                World world = event.getWorld().getWorld();
                //if(world.isBlockLoaded(witherSkeleton.getPosition())){
                    //HardSteel.logger.info("Getting difficulty instance");
                BlockPos witherSkeletonPosition = witherSkeleton.getPosition();
                DifficultyInstance difficultyInstance = getDifficultyAtPosition(world, witherSkeletonPosition);
                    //HardSteel.logger.info("Got the difficulty instance");
                    WitherSkeletonEquipUtilities.setHeldItemsBasedOnDifficulty(witherSkeleton);
                    WitherSkeletonEquipUtilities.setEnchantmentBasedOnDifficulty(difficultyInstance, witherSkeleton);

                    reArmer.setReArmed(true);
                //}
            }
        }
        if((event.getEntity() instanceof ZombiePigmanEntity) && GeneralModConfig.MOBS_USE_HARD_STEEL_GEAR.get()){
            ZombiePigmanEntity zombiePigman = (ZombiePigmanEntity) event.getEntity();

            IReArmer reArmer = zombiePigman.getCapability(ReArmerProvider.REARMER_CAPABILITY).orElseThrow(IllegalStateException::new);

            if(!reArmer.getReArmed()){
                World world = event.getWorld().getWorld();
                //if(world.isBlockPresent(zombiePigman.getPosition())){
                    //HardSteel.logger.info("Getting difficulty instance");
                BlockPos zombiePigmanPosition = zombiePigman.getPosition();
                DifficultyInstance difficultyInstance = getDifficultyAtPosition(world, zombiePigmanPosition);
                    //HardSteel.logger.info("Got the difficulty instance");
                    ZombiePigmanEquipUtilities.setHeldItemsBasedOnDifficulty(zombiePigman);
                    ZombiePigmanEquipUtilities.setEnchantmentBasedOnDifficulty(difficultyInstance, zombiePigman);

                    reArmer.setReArmed(true);
                //}
            }

        }

    }

    public DifficultyInstance getDifficultyAtPosition(World world, BlockPos pos) {
        long inhabitedTime = 0L;
        float moonPhaseFactor = 0.0F;


        HardSteel.logger.info("Inhabited Time is " + inhabitedTime);
        HardSteel.logger.info("Current Moon Phase Factor is " + moonPhaseFactor);

        if (world.isBlockLoaded(pos)) {
            HardSteel.logger.info("Inside isBlockLoaded check");
            moonPhaseFactor = world.getCurrentMoonPhaseFactor();
            HardSteel.logger.info("Current Moon Phase Factor is " + moonPhaseFactor);

            // world.getChunkAt(pos)
            // returns this.getChunk(pos.getX() >> 4, pos.getZ() >> 4);
            // which means it gets the chunk at (X / 2^4), (Z / 2^4)

            Chunk chunk = world.getChunkAt(pos);
            inhabitedTime = chunk.getInhabitedTime();
            HardSteel.logger.info("Inhabited Time is " + inhabitedTime);
        }

        HardSteel.logger.info("Done with isBlockLoaded check");

        HardSteel.logger.info("Inhabited Time is " + inhabitedTime);
        HardSteel.logger.info("Current Moon Phase Factor is " + moonPhaseFactor);

        return new DifficultyInstance(world.getDifficulty(), world.getDayTime(), inhabitedTime, moonPhaseFactor);
    }
}
