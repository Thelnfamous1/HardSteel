package com.infamous.hard_steel.events;

import com.infamous.hard_steel.lists.ItemList;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.monster.WitherSkeletonEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.world.Difficulty;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.Random;

public class WitherSkeletonEquipUtilities {
    public static Random witherSkeleton_rand = new Random();
    /**
     * Gives armor or weapon for entity based on given DifficultyInstance
     */
    public static void setArmorBasedOnDifficulty(DifficultyInstance difficultyInstance, World world, WitherSkeletonEntity witherSkeleton) {
        if(difficultyInstance == null) return;

        if (witherSkeleton_rand.nextFloat() < 0.15F * difficultyInstance.getClampedAdditionalDifficulty()) {
            int i = witherSkeleton_rand.nextInt(2);
            float f = world.getDifficulty() == Difficulty.HARD ? 0.1F : 0.25F;
            if (witherSkeleton_rand.nextFloat() < 0.095F) {
                ++i;
            }

            if (witherSkeleton_rand.nextFloat() < 0.095F) {
                ++i;
            }

            if (witherSkeleton_rand.nextFloat() < 0.095F) {
                ++i;
            }

            boolean flag = true;

            for(EquipmentSlotType equipmentslottype : EquipmentSlotType.values()) {
                if (equipmentslottype.getSlotType() == EquipmentSlotType.Group.ARMOR) {
                    witherSkeleton.setItemStackToSlot(equipmentslottype, ItemStack.EMPTY);
                    ItemStack itemstack = witherSkeleton.getItemStackFromSlot(equipmentslottype);
                    if (!flag && witherSkeleton_rand.nextFloat() < f) {
                        break;
                    }

                    flag = false;
                    if (itemstack.isEmpty()) {
                        Item item = getModdedArmorByChance(equipmentslottype, i);
                        if (item != null) {
                            witherSkeleton.setItemStackToSlot(equipmentslottype, new ItemStack(item));
                        }
                    }
                }
            }
        }
    } // END of setEquipmentBasedOnDifficulty

    // Wither Skeleton wields an Iron Sword instead of a Stone Sword
    public static void setHeldItemsBasedOnDifficulty(WitherSkeletonEntity witherSkeleton) {
        witherSkeleton.setItemStackToSlot(EquipmentSlotType.MAINHAND, new ItemStack(ItemList.iron_sword));


    }

    // Wither Skeleton can only wear Iron Armor to fit its "dark" theme - it will also be a source of iron nuggets
    @Nullable
    public static Item getModdedArmorByChance(EquipmentSlotType slotIn, int chance) {
        switch(slotIn) {
            case HEAD:
                if (chance == 0) {
                    return ItemList.iron_helmet;
                } else if (chance == 1) {
                    return ItemList.iron_helmet;
                } else if (chance == 2) {
                    return ItemList.iron_helmet;
                } else if (chance == 3) {
                    return ItemList.iron_helmet;
                } else if (chance == 4) {
                    return ItemList.iron_helmet;
                }
            case CHEST:
                if (chance == 0) {
                    return ItemList.iron_chestplate;
                } else if (chance == 1) {
                    return ItemList.iron_chestplate;
                } else if (chance == 2) {
                    return ItemList.iron_chestplate;
                } else if (chance == 3) {
                    return ItemList.iron_chestplate;
                } else if (chance == 4) {
                    return ItemList.iron_chestplate;
                }
            case LEGS:
                if (chance == 0) {
                    return ItemList.iron_leggings;
                } else if (chance == 1) {
                    return ItemList.iron_leggings;
                } else if (chance == 2) {
                    return ItemList.iron_leggings;
                } else if (chance == 3) {
                    return ItemList.iron_leggings;
                } else if (chance == 4) {
                    return ItemList.iron_leggings;
                }
            case FEET:
                if (chance == 0) {
                    return ItemList.iron_boots;
                } else if (chance == 1) {
                    return ItemList.iron_boots;
                } else if (chance == 2) {
                    return ItemList.iron_boots;
                } else if (chance == 3) {
                    return ItemList.iron_boots;
                } else if (chance == 4) {
                    return ItemList.iron_boots;
                }
            default:
                return null;
        }
    }

    /**
     * Enchants Entity's current equipments based on given DifficultyInstance
     */
    public static void setEnchantmentBasedOnDifficulty(DifficultyInstance difficultyInstance, WitherSkeletonEntity witherSkeleton) {
        if(difficultyInstance == null) return;

        float f = difficultyInstance.getClampedAdditionalDifficulty();
        if (!witherSkeleton.getHeldItemMainhand().isEmpty() && witherSkeleton_rand.nextFloat() < 0.25F * f) {
            witherSkeleton.setItemStackToSlot(EquipmentSlotType.MAINHAND, EnchantmentHelper.addRandomEnchantment(witherSkeleton_rand, witherSkeleton.getHeldItemMainhand(), (int)(5.0F + f * (float)witherSkeleton_rand.nextInt(18)), false));
        }

        for(EquipmentSlotType equipmentslottype : EquipmentSlotType.values()) {
            if (equipmentslottype.getSlotType() == EquipmentSlotType.Group.ARMOR) {
                ItemStack itemstack = witherSkeleton.getItemStackFromSlot(equipmentslottype);
                if (!itemstack.isEmpty() && witherSkeleton_rand.nextFloat() < 0.5F * f) {
                    witherSkeleton.setItemStackToSlot(equipmentslottype, EnchantmentHelper.addRandomEnchantment(witherSkeleton_rand, itemstack, (int)(5.0F + f * (float)witherSkeleton_rand.nextInt(18)), false));
                }
            }
        }

    }
}
