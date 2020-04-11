package com.infamous.hard_steel.crucible.items;

import com.infamous.hard_steel.crucible.items.CrucibleItemsList;
import com.infamous.hard_steel.lists.ItemList;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;

public class CrucibleUtilities {

    public static ItemStack lastSmeltedMetal = new ItemStack(Items.AIR);
    public static ItemStack lastSmeltedCast = new ItemStack(Items.AIR);;

    public static void setLastSmeltedMetal(ItemStack workableMetalAmount){
        lastSmeltedMetal = workableMetalAmount;
    }

    public static void setLastSmeltedCast(ItemStack cast){
        lastSmeltedCast = cast;
    }

    public static ItemStack getLastSmeltedMetal(){
        return lastSmeltedMetal;
    }

    public static ItemStack getLastSmeltedCast(){
        return lastSmeltedCast;
    }

    public static boolean isCast(ItemStack itemstack){
        if(itemstack.getItem() == CrucibleItemsList.shovel_cast ||
                itemstack.getItem() == CrucibleItemsList.sword_cast ||
                itemstack.getItem() == CrucibleItemsList.hoe_cast ||
                itemstack.getItem() == CrucibleItemsList.pickaxe_cast ||
                itemstack.getItem() == CrucibleItemsList.axe_cast ||
                itemstack.getItem() == CrucibleItemsList.boots_cast ||
                itemstack.getItem() == CrucibleItemsList.helmet_cast ||
                itemstack.getItem() == CrucibleItemsList.leggings_cast ||
                itemstack.getItem() == CrucibleItemsList.chestplate_cast){
            return true;
        }

        return false;
    }

    public static boolean isCastable(ItemStack itemStack){
        if(itemStack.getItem() == ItemList.copper_ingot ||
            itemStack.getItem() == ItemList.bronze_ingot){
            return true;
        }
        return false;
    }

    public static int getCastingCost(ItemStack cast){
        if(cast.getItem() == CrucibleItemsList.shovel_cast) return 1;
        if(cast.getItem() == CrucibleItemsList.sword_cast) return 2;
        if(cast.getItem() == CrucibleItemsList.hoe_cast) return 2;
        if(cast.getItem() == CrucibleItemsList.pickaxe_cast) return 3;
        if(cast.getItem() == CrucibleItemsList.axe_cast) return 3;
        if(cast.getItem() == CrucibleItemsList.boots_cast) return 4;
        if(cast.getItem() == CrucibleItemsList.helmet_cast) return 5;
        if(cast.getItem() == CrucibleItemsList.leggings_cast) return 7;
        if(cast.getItem() == CrucibleItemsList.chestplate_cast) return 8;

        return 0;
    }

    public static boolean hasCastingResult(ItemStack workableMetalAmount, Item cast){
        if(getCastingResult(workableMetalAmount, cast) != Items.AIR){
            return true;
        }
        return false;
    }

    public static Item getCastingResult(ItemStack workableMetalAmount, Item cast){

        // COPPER

        if(workableMetalAmount.getItem() == ItemList.copper_ingot){
                if(workableMetalAmount.getCount() == 1 && cast == CrucibleItemsList.shovel_cast){
                    return ItemList.copper_shovel;
                }
                if(workableMetalAmount.getCount() == 2 && cast == CrucibleItemsList.sword_cast){
                    return ItemList.copper_sword;
                }
                if(workableMetalAmount.getCount() == 2 && cast == CrucibleItemsList.hoe_cast){
                    return ItemList.copper_hoe;
                }
                if(workableMetalAmount.getCount() == 3 && cast == CrucibleItemsList.pickaxe_cast){
                    return ItemList.copper_pickaxe;
                }
                if(workableMetalAmount.getCount() == 3 && cast == CrucibleItemsList.axe_cast){
                    return ItemList.copper_axe;
                }
                if(workableMetalAmount.getCount() == 4 && cast == CrucibleItemsList.boots_cast){
                    return ItemList.copper_boots;
                }
                if(workableMetalAmount.getCount() == 5 && cast == CrucibleItemsList.helmet_cast){
                    return ItemList.copper_helmet;
                }
                if(workableMetalAmount.getCount() == 7 && cast == CrucibleItemsList.leggings_cast){
                    return ItemList.copper_leggings;
                }
                if(workableMetalAmount.getCount() == 8 && cast == CrucibleItemsList.chestplate_cast){
                    return ItemList.copper_chestplate;
                }
        }


        // BRONZE

        if(workableMetalAmount.getItem() == ItemList.bronze_ingot){
                if(workableMetalAmount.getCount() == 1 && cast == CrucibleItemsList.shovel_cast){
                    return ItemList.bronze_shovel;
                }
                if(workableMetalAmount.getCount() == 2 && cast == CrucibleItemsList.sword_cast){
                    return ItemList.bronze_sword;
                }
                if(workableMetalAmount.getCount() == 2 && cast == CrucibleItemsList.hoe_cast){
                    return ItemList.bronze_hoe;
                }
                if(workableMetalAmount.getCount() == 3 && cast == CrucibleItemsList.pickaxe_cast){
                    return ItemList.bronze_pickaxe;
                }
                if(workableMetalAmount.getCount() == 3 && cast == CrucibleItemsList.axe_cast){
                    return ItemList.bronze_axe;
                }
                if(workableMetalAmount.getCount() == 4 && cast == CrucibleItemsList.boots_cast){
                    return ItemList.bronze_boots;
                }
                if(workableMetalAmount.getCount() == 5 && cast == CrucibleItemsList.helmet_cast){
                    return ItemList.bronze_helmet;
                }
                if(workableMetalAmount.getCount() == 7 && cast == CrucibleItemsList.leggings_cast){
                    return ItemList.bronze_leggings;
                }
                if(workableMetalAmount.getCount() == 8 && cast == CrucibleItemsList.chestplate_cast){
                    return ItemList.bronze_chestplate;
                }
        }

        // Unsure of what to do if no return result available
        return Items.AIR;
    }
}
