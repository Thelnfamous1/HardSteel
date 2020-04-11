package com.infamous.hard_steel.events;

import com.infamous.hard_steel.lists.ItemList;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.monster.SkeletonEntity;
import net.minecraft.entity.monster.StrayEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.world.Difficulty;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.Random;

public class StrayEquipUtilities {
    public static Random stray_rand = new Random();
    /**
     * Gives armor or weapon for entity based on given DifficultyInstance
     */
    public static void setArmorBasedOnDifficulty(DifficultyInstance difficultyInstance, World world, StrayEntity stray) {
        if(difficultyInstance == null) return;

        if (stray_rand.nextFloat() < 0.15F * difficultyInstance.getClampedAdditionalDifficulty()) {
            int i = stray_rand.nextInt(2);
            float f = world.getDifficulty() == Difficulty.HARD ? 0.1F : 0.25F;
            if (stray_rand.nextFloat() < 0.095F) {
                ++i;
            }

            if (stray_rand.nextFloat() < 0.095F) {
                ++i;
            }

            if (stray_rand.nextFloat() < 0.095F) {
                ++i;
            }

            boolean flag = true;

            boolean useChain = stray_rand.nextBoolean();

            for(EquipmentSlotType equipmentslottype : EquipmentSlotType.values()) {
                if (equipmentslottype.getSlotType() == EquipmentSlotType.Group.ARMOR) {
                    stray.setItemStackToSlot(equipmentslottype, ItemStack.EMPTY);
                    ItemStack itemstack = stray.getItemStackFromSlot(equipmentslottype);
                    if (!flag && stray_rand.nextFloat() < f) {
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
                            stray.setItemStackToSlot(equipmentslottype, new ItemStack(item));
                        }
                    }
                }
            }
        }
    } // END of setEquipmentBasedOnDifficulty

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
    public static void setEnchantmentBasedOnDifficulty(DifficultyInstance difficultyInstance, StrayEntity stray) {
        if(difficultyInstance == null) return;

        float f = difficultyInstance.getClampedAdditionalDifficulty();
        if (!stray.getHeldItemMainhand().isEmpty() && stray_rand.nextFloat() < 0.25F * f) {
            stray.setItemStackToSlot(EquipmentSlotType.MAINHAND, EnchantmentHelper.addRandomEnchantment(stray_rand, stray.getHeldItemMainhand(), (int)(5.0F + f * (float) stray_rand.nextInt(18)), false));
        }

        for(EquipmentSlotType equipmentslottype : EquipmentSlotType.values()) {
            if (equipmentslottype.getSlotType() == EquipmentSlotType.Group.ARMOR) {
                ItemStack itemstack = stray.getItemStackFromSlot(equipmentslottype);
                if (!itemstack.isEmpty() && stray_rand.nextFloat() < 0.5F * f) {
                    stray.setItemStackToSlot(equipmentslottype, EnchantmentHelper.addRandomEnchantment(stray_rand, itemstack, (int)(5.0F + f * (float) stray_rand.nextInt(18)), false));
                }
            }
        }

    }
}
