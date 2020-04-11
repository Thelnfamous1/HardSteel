package com.infamous.hard_steel.anvil.items;

import com.infamous.hard_steel.lists.ItemList;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;

public class AnvilUtilities {

    public static int getForgingCost(ItemStack workableMetalAmount, Item blueprint){
        if(workableMetalAmount.getItem() == Items.IRON_INGOT){
            if(workableMetalAmount.getCount() == 1) return 1;
            if(workableMetalAmount.getCount() == 2) return 2;
            if(workableMetalAmount.getCount() == 3) return 3;
            if(workableMetalAmount.getCount() == 4) return 4;
            if(workableMetalAmount.getCount() == 5) return 5;
            if(workableMetalAmount.getCount() == 6) return 6;
            if(workableMetalAmount.getCount() == 7) return 7;
            if(workableMetalAmount.getCount() == 8) return 8;
            if(workableMetalAmount.getCount() == 9) return 9;
        }

        if(workableMetalAmount.getItem() == ItemList.steel_ingot){
            if(workableMetalAmount.getCount() == 1) return 1;
            if(workableMetalAmount.getCount() == 2) return 2;
            if(workableMetalAmount.getCount() == 3) return 3;
            if(workableMetalAmount.getCount() == 4) return 4;
            if(workableMetalAmount.getCount() == 5) return 5;
            if(workableMetalAmount.getCount() == 6) return 6;
            if(workableMetalAmount.getCount() == 7) return 7;
            if(workableMetalAmount.getCount() == 8) return 8;
            if(workableMetalAmount.getCount() == 9) return 9;
        }

        if(workableMetalAmount.getItem() == ItemList.carbonized_iron_ingot){
            if(workableMetalAmount.getCount() == 1 && blueprint == AnvilItemsList.steel_blueprint) return 1*2 - 1;
        }

        if(workableMetalAmount.getItem() == ItemList.mithril_ingot){
            if(workableMetalAmount.getCount() == 1) return 1;
            if(workableMetalAmount.getCount() == 2) return 2;
            if(workableMetalAmount.getCount() == 3) return 3;
            if(workableMetalAmount.getCount() == 4) return 4;
            if(workableMetalAmount.getCount() == 5) return 5;
            if(workableMetalAmount.getCount() == 6) return 6;
            if(workableMetalAmount.getCount() == 7) return 7;
            if(workableMetalAmount.getCount() == 8) return 8;
            if(workableMetalAmount.getCount() == 9) return 9;
        }

        if(workableMetalAmount.getItem() == ItemList.netherite_ingot){
            if(workableMetalAmount.getCount() == 1) return 1;
            if(workableMetalAmount.getCount() == 2) return 2;
            if(workableMetalAmount.getCount() == 3) return 3;
            if(workableMetalAmount.getCount() == 4) return 4;
            if(workableMetalAmount.getCount() == 5) return 5;
            if(workableMetalAmount.getCount() == 6) return 6;
            if(workableMetalAmount.getCount() == 7) return 7;
            if(workableMetalAmount.getCount() == 8) return 8;
            if(workableMetalAmount.getCount() == 9) return 9;
        }

        if(workableMetalAmount.getItem() == ItemList.enderite_ingot){
            if(workableMetalAmount.getCount() == 1) return 1;
            if(workableMetalAmount.getCount() == 2) return 2;
            if(workableMetalAmount.getCount() == 3) return 3;
            if(workableMetalAmount.getCount() == 4) return 4;
            if(workableMetalAmount.getCount() == 5) return 5;
            if(workableMetalAmount.getCount() == 6) return 6;
            if(workableMetalAmount.getCount() == 7) return 7;
            if(workableMetalAmount.getCount() == 8) return 8;
            if(workableMetalAmount.getCount() == 9) return 9;
        }

        return 0;
    }

    public static Item getForgingResult(ItemStack workableMetalAmount, Item blueprint){

        // IRON

        if(workableMetalAmount.getItem() == Items.IRON_INGOT){
            if(workableMetalAmount.getCount() == 1){
                if(blueprint == AnvilItemsList.shovel_blueprint){
                    return ItemList.iron_shovel;
                }
            }
            else if(workableMetalAmount.getCount() == 2){
                if(blueprint == AnvilItemsList.sword_blueprint){
                    return ItemList.iron_sword;
                }
                if(blueprint == AnvilItemsList.hoe_blueprint){
                    return ItemList.iron_hoe;
                }
            }
            else if(workableMetalAmount.getCount() == 3){
                if(blueprint == AnvilItemsList.pickaxe_blueprint){
                    return ItemList.iron_pickaxe;
                }
                else if(blueprint == AnvilItemsList.axe_blueprint){
                    return ItemList.iron_axe;
                }
            }
            else if(workableMetalAmount.getCount() == 4){
                if(blueprint == AnvilItemsList.boots_blueprint){
                    return ItemList.iron_boots;
                }
            }
            else if(workableMetalAmount.getCount() == 5){
                if(blueprint == AnvilItemsList.helmet_blueprint){
                    return ItemList.iron_helmet;
                }
            }
            else if(workableMetalAmount.getCount() == 6){
            }
            else if(workableMetalAmount.getCount() == 7){
                if(blueprint == AnvilItemsList.leggings_blueprint){
                    return ItemList.iron_leggings;
                }
            }
            else if(workableMetalAmount.getCount() == 8){
                if(blueprint == AnvilItemsList.chestplate_blueprint){
                    return ItemList.iron_chestplate;
                }
            }
            else if(workableMetalAmount.getCount() == 9){

            }
        }

        // STEEL

        if(workableMetalAmount.getItem() == ItemList.steel_ingot){
            if(workableMetalAmount.getCount() == 1){
                if(blueprint == AnvilItemsList.shovel_blueprint){
                    return ItemList.steel_shovel;
                }
            }
            else if(workableMetalAmount.getCount() == 2){
                if(blueprint == AnvilItemsList.sword_blueprint){
                    return ItemList.steel_sword;
                }
                if(blueprint == AnvilItemsList.hoe_blueprint){
                    return ItemList.steel_hoe;
                }
            }
            else if(workableMetalAmount.getCount() == 3){
                if(blueprint == AnvilItemsList.pickaxe_blueprint){
                    return ItemList.steel_pickaxe;
                }
                else if(blueprint == AnvilItemsList.axe_blueprint){
                    return ItemList.steel_axe;
                }
            }
            else if(workableMetalAmount.getCount() == 4){
                if(blueprint == AnvilItemsList.boots_blueprint){
                    return ItemList.steel_boots;
                }
            }
            else if(workableMetalAmount.getCount() == 5){
                if(blueprint == AnvilItemsList.helmet_blueprint){
                    return ItemList.steel_helmet;
                }
            }
            else if(workableMetalAmount.getCount() == 6){
            }
            else if(workableMetalAmount.getCount() == 7){
                if(blueprint == AnvilItemsList.leggings_blueprint){
                    return ItemList.steel_leggings;
                }
            }
            else if(workableMetalAmount.getCount() == 8){
                if(blueprint == AnvilItemsList.chestplate_blueprint){
                    return ItemList.steel_chestplate;
                }
            }
            else if(workableMetalAmount.getCount() == 9){

            }
        }

        // CARBONIZED_IRON_INGOT

        if(workableMetalAmount.getItem() == ItemList.carbonized_iron_ingot){
            if(workableMetalAmount.getCount() == 1){
                if(blueprint == AnvilItemsList.steel_blueprint){
                    return ItemList.steel_ingot;
                }
            }
        }

        // MITHRIL

        if(workableMetalAmount.getItem() == ItemList.mithril_ingot){
            if(workableMetalAmount.getCount() == 1){
                if(blueprint == AnvilItemsList.shovel_blueprint){
                    return ItemList.mithril_shovel;
                }
            }
            else if(workableMetalAmount.getCount() == 2){
                if(blueprint == AnvilItemsList.sword_blueprint){
                    return ItemList.mithril_sword;
                }
                if(blueprint == AnvilItemsList.hoe_blueprint){
                    return ItemList.mithril_hoe;
                }
            }
            else if(workableMetalAmount.getCount() == 3){
                if(blueprint == AnvilItemsList.pickaxe_blueprint){
                    return ItemList.mithril_pickaxe;
                }
                else if(blueprint == AnvilItemsList.axe_blueprint){
                    return ItemList.mithril_axe;
                }
            }
            else if(workableMetalAmount.getCount() == 4){
                if(blueprint == AnvilItemsList.boots_blueprint){
                    return ItemList.mithril_boots;
                }
            }
            else if(workableMetalAmount.getCount() == 5){
                if(blueprint == AnvilItemsList.helmet_blueprint){
                    return ItemList.mithril_helmet;
                }
            }
            else if(workableMetalAmount.getCount() == 6){
            }
            else if(workableMetalAmount.getCount() == 7){
                if(blueprint == AnvilItemsList.leggings_blueprint){
                    return ItemList.mithril_leggings;
                }
            }
            else if(workableMetalAmount.getCount() == 8){
                if(blueprint == AnvilItemsList.chestplate_blueprint){
                    return ItemList.mithril_chestplate;
                }
            }
            else if(workableMetalAmount.getCount() == 9){

            }
        }

        // NETHERITE

        if(workableMetalAmount.getItem() == ItemList.netherite_ingot){
            if(workableMetalAmount.getCount() == 1){
                if(blueprint == AnvilItemsList.shovel_blueprint){
                    return ItemList.netherite_shovel;
                }
            }
            else if(workableMetalAmount.getCount() == 2){
                if(blueprint == AnvilItemsList.sword_blueprint){
                    return ItemList.netherite_sword;
                }
                if(blueprint == AnvilItemsList.hoe_blueprint){
                    return ItemList.netherite_hoe;
                }
            }
            else if(workableMetalAmount.getCount() == 3){
                if(blueprint == AnvilItemsList.pickaxe_blueprint){
                    return ItemList.netherite_pickaxe;
                }
                else if(blueprint == AnvilItemsList.axe_blueprint){
                    return ItemList.netherite_axe;
                }
            }
            else if(workableMetalAmount.getCount() == 4){
                if(blueprint == AnvilItemsList.boots_blueprint){
                    return ItemList.netherite_boots;
                }
            }
            else if(workableMetalAmount.getCount() == 5){
                if(blueprint == AnvilItemsList.helmet_blueprint){
                    return ItemList.netherite_helmet;
                }
            }
            else if(workableMetalAmount.getCount() == 6){
            }
            else if(workableMetalAmount.getCount() == 7){
                if(blueprint == AnvilItemsList.leggings_blueprint){
                    return ItemList.netherite_leggings;
                }
            }
            else if(workableMetalAmount.getCount() == 8){
                if(blueprint == AnvilItemsList.chestplate_blueprint){
                    return ItemList.netherite_chestplate;
                }
            }
            else if(workableMetalAmount.getCount() == 9){

            }
        }

        // ENDERITE

        if(workableMetalAmount.getItem() == ItemList.enderite_ingot){
            if(workableMetalAmount.getCount() == 1){
                if(blueprint == AnvilItemsList.shovel_blueprint){
                    return ItemList.enderite_shovel;
                }
            }
            else if(workableMetalAmount.getCount() == 2){
                if(blueprint == AnvilItemsList.sword_blueprint){
                    return ItemList.enderite_sword;
                }
                if(blueprint == AnvilItemsList.hoe_blueprint){
                    return ItemList.enderite_hoe;
                }
            }
            else if(workableMetalAmount.getCount() == 3){
                if(blueprint == AnvilItemsList.pickaxe_blueprint){
                    return ItemList.enderite_pickaxe;
                }
                else if(blueprint == AnvilItemsList.axe_blueprint){
                    return ItemList.enderite_axe;
                }
            }
            else if(workableMetalAmount.getCount() == 4){
                if(blueprint == AnvilItemsList.boots_blueprint){
                    return ItemList.enderite_boots;
                }
            }
            else if(workableMetalAmount.getCount() == 5){
                if(blueprint == AnvilItemsList.helmet_blueprint){
                    return ItemList.enderite_helmet;
                }
            }
            else if(workableMetalAmount.getCount() == 6){
            }
            else if(workableMetalAmount.getCount() == 7){
                if(blueprint == AnvilItemsList.leggings_blueprint){
                    return ItemList.enderite_leggings;
                }
            }
            else if(workableMetalAmount.getCount() == 8){
                if(blueprint == AnvilItemsList.chestplate_blueprint){
                    return ItemList.enderite_chestplate;
                }
            }
            else if(workableMetalAmount.getCount() == 9){

            }
        }

        // Unsure of what to do if no return result available
        return Items.AIR;
    }
}
