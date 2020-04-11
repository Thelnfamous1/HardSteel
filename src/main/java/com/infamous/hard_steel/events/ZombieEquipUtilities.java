package com.infamous.hard_steel.events;

import com.infamous.hard_steel.lists.ItemList;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.monster.ZombieEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.Difficulty;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.Random;

public class ZombieEquipUtilities {

    public static Random zombie_rand = new Random();
    /*
    public static float additionalDifficulty;


    public static float getClampedAdditionalDifficulty() {
        if (additionalDifficulty < 2.0F) {
            return 0.0F;
        } else {
            return additionalDifficulty > 4.0F ? 1.0F : (additionalDifficulty - 2.0F) / 2.0F;
        }
    }

    public static void setAdditionalDifficulty(Difficulty difficulty, long dayTime, long timePlayerSpentInChunk, float moonPhaseFactor){
        additionalDifficulty = calculateAdditionalDifficulty(difficulty, dayTime, timePlayerSpentInChunk, moonPhaseFactor);
    }

    public static float calculateAdditionalDifficulty(Difficulty difficulty, long dayTime, long timePlayerSpentInChunk, float moonPhaseFactor) {
        if (difficulty == Difficulty.PEACEFUL) {
            return 0.0F;
        } else {
            boolean isHard = difficulty == Difficulty.HARD;
            float difficultyMultiplier = 0.75F;
            float dayTimeFactor = MathHelper.clamp(((float)dayTime + -72000.0F) / 1440000.0F, 0.0F, 1.0F) * 0.25F;
            difficultyMultiplier += dayTimeFactor;
            float timePlayerSpentInChunkFactor = 0.0F;
            timePlayerSpentInChunkFactor += MathHelper.clamp((float)timePlayerSpentInChunk / 3600000.0F, 0.0F, 1.0F) * (isHard ? 1.0F : 0.75F);
            timePlayerSpentInChunkFactor += MathHelper.clamp(moonPhaseFactor * 0.25F, 0.0F, dayTimeFactor);
            if (difficulty == Difficulty.EASY) {
                timePlayerSpentInChunkFactor *= 0.5F;
            }

            difficultyMultiplier += timePlayerSpentInChunkFactor;
            return (float)difficulty.getId() * difficultyMultiplier;
        }
    }
    */

    public static void setArmorBasedOnDifficulty(DifficultyInstance difficultyInstance, World world, ZombieEntity zombie) {

        if(difficultyInstance == null) return;
        if (zombie_rand.nextFloat() < 0.15F * difficultyInstance.getClampedAdditionalDifficulty()) {
            int i = zombie_rand.nextInt(2);
            float f = world.getDifficulty() == Difficulty.HARD ? 0.1F : 0.25F;
            if (zombie_rand.nextFloat() < 0.095F) {
                ++i;
            }

            if (zombie_rand.nextFloat() < 0.095F) {
                ++i;
            }

            if (zombie_rand.nextFloat() < 0.095F) {
                ++i;
            }

            boolean flag = true;

            boolean useChain = zombie_rand.nextBoolean();

            for(EquipmentSlotType equipmentslottype : EquipmentSlotType.values()) {
                if (equipmentslottype.getSlotType() == EquipmentSlotType.Group.ARMOR) {
                    zombie.setItemStackToSlot(equipmentslottype, ItemStack.EMPTY);
                    ItemStack itemstack = zombie.getItemStackFromSlot(equipmentslottype);
                    if (!flag && zombie_rand.nextFloat() < f) {
                        break;
                    }

                    flag = false;
                    if (itemstack.isEmpty()) {
                        Item item = Items.AIR;
                        if(useChain){
                            item = getModdedChainArmor(equipmentslottype, i);
                        }
                        else{
                            item = getModdedPlateArmor(equipmentslottype, i);
                        }
                        if (item != null) {
                            zombie.setItemStackToSlot(equipmentslottype, new ItemStack(item));
                        }
                    }
                }
            }
        }
    } // END of setEquipmentBasedOnDifficulty

    public static void setHeldItemsBasedOnDifficulty(World world, ZombieEntity zombie) {
        if(zombie.getHeldItemMainhand().isDamageable())
        zombie.setItemStackToSlot(EquipmentSlotType.MAINHAND, ItemStack.EMPTY);

        if (zombie_rand.nextFloat() < (world.getDifficulty() == Difficulty.HARD ? 0.05F : 0.01F)) {
            int i = zombie_rand.nextInt(3);
            if (i == 0) {
                zombie.setItemStackToSlot(EquipmentSlotType.MAINHAND, new ItemStack(ItemList.iron_sword));
            } else {
                zombie.setItemStackToSlot(EquipmentSlotType.MAINHAND, new ItemStack(ItemList.iron_shovel));
            }
        }

    }

    @Nullable
    public static Item getModdedPlateArmor(EquipmentSlotType slotIn, int chance) {
        switch(slotIn) {
            case HEAD:
                if (chance == 0) {
                    return Items.LEATHER_HELMET;
                } else if (chance == 1) {
                    return ItemList.copper_helmet;
                } else if (chance == 2) {
                    return ItemList.bronze_helmet;
                } else if (chance == 3) {
                    return ItemList.iron_helmet;
                } else if (chance == 4) {
                    return ItemList.steel_helmet;
                }
            case CHEST:
                if (chance == 0) {
                    return Items.LEATHER_CHESTPLATE;
                } else if (chance == 1) {
                    return ItemList.copper_chestplate;
                } else if (chance == 2) {
                    return ItemList.bronze_chestplate;
                } else if (chance == 3) {
                    return ItemList.iron_chestplate;
                } else if (chance == 4) {
                    return ItemList.steel_chestplate;
                }
            case LEGS:
                if (chance == 0) {
                    return Items.LEATHER_LEGGINGS;
                } else if (chance == 1) {
                    return ItemList.copper_leggings;
                } else if (chance == 2) {
                    return ItemList.bronze_leggings;
                } else if (chance == 3) {
                    return ItemList.iron_leggings;
                } else if (chance == 4) {
                    return ItemList.steel_leggings;
                }
            case FEET:
                if (chance == 0) {
                    return Items.LEATHER_BOOTS;
                } else if (chance == 1) {
                    return ItemList.copper_boots;
                } else if (chance == 2) {
                    return ItemList.bronze_boots;
                } else if (chance == 3) {
                    return ItemList.iron_boots;
                } else if (chance == 4) {
                    return ItemList.steel_boots;
                }
            default:
                return null;
        }
    }

    @Nullable
    public static Item getModdedChainArmor(EquipmentSlotType slotIn, int chance) {
        switch(slotIn) {
            case HEAD:
                if (chance == 0) {
                    return Items.LEATHER_HELMET;
                } else if (chance == 1) {
                    return ItemList.copper_chainhead;
                } else if (chance == 2) {
                    return ItemList.bronze_chainhead;
                } else if (chance == 3) {
                    return ItemList.iron_chainhead;
                } else if (chance == 4) {
                    return ItemList.steel_chainhead;
                }
            case CHEST:
                if (chance == 0) {
                    return Items.LEATHER_CHESTPLATE;
                } else if (chance == 1) {
                    return ItemList.copper_chainbody;
                } else if (chance == 2) {
                    return ItemList.bronze_chainbody;
                } else if (chance == 3) {
                    return ItemList.iron_chainbody;
                } else if (chance == 4) {
                    return ItemList.steel_chainbody;
                }
            case LEGS:
                if (chance == 0) {
                    return Items.LEATHER_LEGGINGS;
                } else if (chance == 1) {
                    return ItemList.copper_chainlegs;
                } else if (chance == 2) {
                    return ItemList.bronze_chainlegs;
                } else if (chance == 3) {
                    return ItemList.iron_chainlegs;
                } else if (chance == 4) {
                    return ItemList.steel_chainlegs;
                }
            case FEET:
                if (chance == 0) {
                    return Items.LEATHER_BOOTS;
                } else if (chance == 1) {
                    return ItemList.copper_chainfeet;
                } else if (chance == 2) {
                    return ItemList.bronze_chainfeet;
                } else if (chance == 3) {
                    return ItemList.iron_chainfeet;
                } else if (chance == 4) {
                    return ItemList.steel_chainfeet;
                }
            default:
                return null;
        }
    }

    /**
     * Enchants Entity's current equipments based on given DifficultyInstance
     */
    public static void setEnchantmentBasedOnDifficulty(DifficultyInstance difficultyInstance, ZombieEntity zombie) {
        if(difficultyInstance == null) return;
        float f = difficultyInstance.getClampedAdditionalDifficulty();
        if (!zombie.getHeldItemMainhand().isEmpty() && zombie_rand.nextFloat() < 0.25F * f) {
            zombie.setItemStackToSlot(EquipmentSlotType.MAINHAND, EnchantmentHelper.addRandomEnchantment(zombie_rand, zombie.getHeldItemMainhand(), (int)(5.0F + f * (float)zombie_rand.nextInt(18)), false));
        }

        for(EquipmentSlotType equipmentslottype : EquipmentSlotType.values()) {
            if (equipmentslottype.getSlotType() == EquipmentSlotType.Group.ARMOR) {
                ItemStack itemstack = zombie.getItemStackFromSlot(equipmentslottype);
                if (!itemstack.isEmpty() && zombie_rand.nextFloat() < 0.5F * f) {
                    zombie.setItemStackToSlot(equipmentslottype, EnchantmentHelper.addRandomEnchantment(zombie_rand, itemstack, (int)(5.0F + f * (float)zombie_rand.nextInt(18)), false));
                }
            }
        }

    }
}
