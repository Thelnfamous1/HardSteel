package com.infamous.hard_steel.events;

import java.util.*;

import com.infamous.hard_steel.HardSteel;
import com.infamous.hard_steel.lists.ItemList;
import com.infamous.hard_steel.shields.ShieldRegistryEvents;
import com.infamous.hard_steel.util.VillagerTradeUtilities;
import net.minecraft.entity.merchant.villager.VillagerProfession;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.village.VillagerTradesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = HardSteel.modid)
public class VillagerTrades {

    @SubscribeEvent
    public static void onVillagerTradesEvent(VillagerTradesEvent event) {
        if(event.getType() == VillagerProfession.WEAPONSMITH){
            //         p_221237_0_.put(
            //         VillagerProfession.WEAPONSMITH, func_221238_a(
            //         ImmutableMap.of(
            //         1, new VillagerTrades.ITrade[]{
            //         new VillagerTrades.EmeraldForItemsTrade(Items.COAL, 15, 16, 2),
            //         new VillagerTrades.ItemsForEmeraldsTrade(new ItemStack(Items.IRON_AXE), 3, 1, 12, 1, 0.2F), which is located at index 1
            //         new VillagerTrades.EnchantedItemForEmeraldsTrade(Items.IRON_SWORD, 2, 3, 1)}, which is located at index 2

            //         2, new VillagerTrades.ITrade[]{
            //         new VillagerTrades.EmeraldForItemsTrade(Items.IRON_INGOT, 4, 12, 10),
            //         new VillagerTrades.ItemsForEmeraldsTrade(new ItemStack(Items.BELL), 36, 1, 12, 5, 0.2F)},

            //         3, new VillagerTrades.ITrade[]{
            //         new VillagerTrades.EmeraldForItemsTrade(Items.FLINT, 24, 12, 20)},

            //         4, new VillagerTrades.ITrade[]{
            //         new VillagerTrades.EmeraldForItemsTrade(Items.DIAMOND, 1, 12, 30), which is located at index 0
            //         new VillagerTrades.EnchantedItemForEmeraldsTrade(Items.DIAMOND_AXE, 12, 3, 15, 0.2F)}, which is located at index 1

            //         5, new VillagerTrades.ITrade[]{
            //         new VillagerTrades.EnchantedItemForEmeraldsTrade(Items.DIAMOND_SWORD, 8, 3, 30, 0.2F) which is located at index 0
            //         })));

            Integer level1 = 1;
            Integer level2 = 2;
            Integer level3 = 3;
            Integer level4 = 4;
            Integer level5 = 5;

            List<net.minecraft.entity.merchant.villager.VillagerTrades.ITrade> tradesAtLevel1 = event.getTrades().get(level1);
            List<net.minecraft.entity.merchant.villager.VillagerTrades.ITrade> tradesAtLevel2 = event.getTrades().get(level2);
            List<net.minecraft.entity.merchant.villager.VillagerTrades.ITrade> tradesAtLevel3 = event.getTrades().get(level3);
            List<net.minecraft.entity.merchant.villager.VillagerTrades.ITrade> tradesAtLevel4 = event.getTrades().get(level4);
            List<net.minecraft.entity.merchant.villager.VillagerTrades.ITrade> tradesAtLevel5 = event.getTrades().get(level5);

            int ironAxeForEmeraldsTradeIndex = 1;
            int enchantedIronSwordForEmeraldsTradeIndex = 2;
            int emeraldForDiamondTradeIndex = 0;
            int enchantedDiamondAxeForEmeraldsTradeIndex = 1;
            int enchantedDiamondSwordForEmeraldsTradeIndex = 0;

            VillagerTradeUtilities.ItemsForEmeraldsTrade myIronAxeForEmeraldsTrade = new VillagerTradeUtilities.ItemsForEmeraldsTrade(new ItemStack(ItemList.iron_axe), 3, 1, 12, 1, 0.2F);
            VillagerTradeUtilities.EnchantedItemForEmeraldsTrade myEnchantedIronSwordForEmeraldsTrade = new VillagerTradeUtilities.EnchantedItemForEmeraldsTrade(ItemList.iron_sword, 2, 3, 1);

            VillagerTradeUtilities.EmeraldsForItemsTrade emeraldsForMySteelIngotTrade = new VillagerTradeUtilities.EmeraldsForItemsTrade(ItemList.steel_ingot, 4, 12, 10);
            VillagerTradeUtilities.EnchantedItemForEmeraldsTrade myEnchantedSteelAxeForEmeraldsTrade = new VillagerTradeUtilities.EnchantedItemForEmeraldsTrade(ItemList.steel_axe, 12, 3, 15, 0.2F);

            VillagerTradeUtilities.EnchantedItemForEmeraldsTrade myEnchantedSteelSwordForEmeraldsTrade = new VillagerTradeUtilities.EnchantedItemForEmeraldsTrade(ItemList.steel_sword, 8, 3, 30, 0.2F);

            setTrade(myIronAxeForEmeraldsTrade, ironAxeForEmeraldsTradeIndex, tradesAtLevel1);
            setTrade(myEnchantedIronSwordForEmeraldsTrade, enchantedIronSwordForEmeraldsTradeIndex, tradesAtLevel1);

            setTrade(emeraldsForMySteelIngotTrade, emeraldForDiamondTradeIndex, tradesAtLevel4);
            setTrade(myEnchantedSteelAxeForEmeraldsTrade, enchantedDiamondAxeForEmeraldsTradeIndex, tradesAtLevel4);

            setTrade(myEnchantedSteelSwordForEmeraldsTrade, enchantedDiamondSwordForEmeraldsTradeIndex, tradesAtLevel5);
        }
        if(event.getType() == VillagerProfession.TOOLSMITH){
            //         p_221237_0_.put(
            //         VillagerProfession.TOOLSMITH, func_221238_a(
            //         ImmutableMap.of(
            //         1, new VillagerTrades.ITrade[]{
            //         new VillagerTrades.EmeraldForItemsTrade(Items.COAL, 15, 16, 2),
            //         new VillagerTrades.ItemsForEmeraldsTrade(new ItemStack(Items.STONE_AXE), 1, 1, 12, 1, 0.2F), which is located at index 1
            //         new VillagerTrades.ItemsForEmeraldsTrade(new ItemStack(Items.STONE_SHOVEL), 1, 1, 12, 1, 0.2F), which is located at index 2
            //         new VillagerTrades.ItemsForEmeraldsTrade(new ItemStack(Items.STONE_PICKAXE), 1, 1, 12, 1, 0.2F), which is located at index 3
            //         new VillagerTrades.ItemsForEmeraldsTrade(new ItemStack(Items.STONE_HOE), 1, 1, 12, 1, 0.2F)}, which is located at index 4
            //         2, new VillagerTrades.ITrade[]{
            //         new VillagerTrades.EmeraldForItemsTrade(Items.IRON_INGOT, 4, 12, 10),
            //         new VillagerTrades.ItemsForEmeraldsTrade(new ItemStack(Items.BELL), 36, 1, 12, 5, 0.2F)},
            //         3, new VillagerTrades.ITrade[]{
            //         new VillagerTrades.EmeraldForItemsTrade(Items.FLINT, 30, 12, 20),
            //         new VillagerTrades.EnchantedItemForEmeraldsTrade(Items.IRON_AXE, 1, 3, 10, 0.2F), which is located at index 1
            //         new VillagerTrades.EnchantedItemForEmeraldsTrade(Items.IRON_SHOVEL, 2, 3, 10, 0.2F), which is located at index 2
            //         new VillagerTrades.EnchantedItemForEmeraldsTrade(Items.IRON_PICKAXE, 3, 3, 10, 0.2F), which is located at index 3
            //         new VillagerTrades.ItemsForEmeraldsTrade(new ItemStack(Items.DIAMOND_HOE), 4, 1, 3, 10, 0.2F)}, which is located at index 4
            //         4, new VillagerTrades.ITrade[]{
            //         new VillagerTrades.EmeraldForItemsTrade(Items.DIAMOND, 1, 12, 30), which is located at index 0
            //         new VillagerTrades.EnchantedItemForEmeraldsTrade(Items.DIAMOND_AXE, 12, 3, 15, 0.2F), which is located at index 1
            //         new VillagerTrades.EnchantedItemForEmeraldsTrade(Items.DIAMOND_SHOVEL, 5, 3, 15, 0.2F)}, which is located at index 2
            //         5, new VillagerTrades.ITrade[]{
            //         new VillagerTrades.EnchantedItemForEmeraldsTrade(Items.DIAMOND_PICKAXE, 13, 3, 30, 0.2F)}))); which is located at index 0

            Integer level1 = 1;
            Integer level2 = 2;
            Integer level3 = 3;
            Integer level4 = 4;
            Integer level5 = 5;

            List<net.minecraft.entity.merchant.villager.VillagerTrades.ITrade> tradesAtLevel1 = event.getTrades().get(level1);
            List<net.minecraft.entity.merchant.villager.VillagerTrades.ITrade> tradesAtLevel2 = event.getTrades().get(level2);
            List<net.minecraft.entity.merchant.villager.VillagerTrades.ITrade> tradesAtLevel3 = event.getTrades().get(level3);
            List<net.minecraft.entity.merchant.villager.VillagerTrades.ITrade> tradesAtLevel4 = event.getTrades().get(level4);
            List<net.minecraft.entity.merchant.villager.VillagerTrades.ITrade> tradesAtLevel5 = event.getTrades().get(level5);

            int stoneAxeForEmeraldsTradeIndex = 1;
            int stoneShovelForEmeraldsTradeIndex = 2;
            int stonePickaxeForEmeraldsTradeIndex = 3;
            int stoneHoeForEmeraldsTradeIndex = 4;
            int enchantedIronAxeForEmeraldsTradeIndex = 1;
            int enchantedIronShovelForEmeraldsTradeIndex = 2;
            int enchantedIronPickaxeForEmeraldsTradeIndex = 3;
            int diamondHoeForEmeraldsTradeIndex = 4;
            int emeraldForDiamondTradeIndex = 0;
            int enchantedDiamondAxeForEmeraldsTradeIndex = 1;
            int enchantedDiamondShovelForEmeraldsTradeIndex = 2;
            int enchantedDiamondPickaxeForEmeraldsTradeIndex = 0;

            VillagerTradeUtilities.ItemsForEmeraldsTrade myCopperAxeForEmeraldsTrade = new VillagerTradeUtilities.ItemsForEmeraldsTrade(new ItemStack(ItemList.copper_axe), 1, 1, 12, 1, 0.2F);
            VillagerTradeUtilities.ItemsForEmeraldsTrade myCopperShovelForEmeraldsTrade = new VillagerTradeUtilities.ItemsForEmeraldsTrade(new ItemStack(ItemList.copper_shovel), 1, 1, 12, 1, 0.2F);
            VillagerTradeUtilities.ItemsForEmeraldsTrade myCopperPickaxeForEmeraldsTrade = new VillagerTradeUtilities.ItemsForEmeraldsTrade(new ItemStack(ItemList.copper_pickaxe), 1, 1, 12, 1, 0.2F);
            VillagerTradeUtilities.ItemsForEmeraldsTrade myCopperHoeForEmeraldsTrade = new VillagerTradeUtilities.ItemsForEmeraldsTrade(new ItemStack(ItemList.copper_hoe), 1, 1, 12, 1, 0.2F);

            VillagerTradeUtilities.EnchantedItemForEmeraldsTrade myEnchantedIronAxeForEmeraldsTrade = new VillagerTradeUtilities.EnchantedItemForEmeraldsTrade(ItemList.iron_axe, 1, 3, 10, 0.2F);
            VillagerTradeUtilities.EnchantedItemForEmeraldsTrade myEnchantedIronShovelForEmeraldsTrade = new VillagerTradeUtilities.EnchantedItemForEmeraldsTrade(ItemList.iron_shovel, 2, 3, 10, 0.2F);
            VillagerTradeUtilities.EnchantedItemForEmeraldsTrade myEnchantedIronPickaxeForEmeraldsTrade = new VillagerTradeUtilities.EnchantedItemForEmeraldsTrade(ItemList.iron_pickaxe, 3, 3, 10, 0.2F);
            VillagerTradeUtilities.ItemsForEmeraldsTrade mySteelHoeForEmeraldsTrade = new VillagerTradeUtilities.ItemsForEmeraldsTrade(new ItemStack(ItemList.steel_hoe), 4, 1, 3, 10, 0.2F);

            VillagerTradeUtilities.EmeraldsForItemsTrade emeraldsForMySteelIngotTrade = new VillagerTradeUtilities.EmeraldsForItemsTrade(ItemList.steel_ingot, 1, 12, 30);
            VillagerTradeUtilities.EnchantedItemForEmeraldsTrade myEnchantedSteelAxeForEmeraldsTrade = new VillagerTradeUtilities.EnchantedItemForEmeraldsTrade(ItemList.steel_axe, 12, 3, 15, 0.2F);
            VillagerTradeUtilities.EnchantedItemForEmeraldsTrade myEnchantedSteelShovelForEmeraldsTrade = new VillagerTradeUtilities.EnchantedItemForEmeraldsTrade(ItemList.steel_shovel, 5, 3, 15, 0.2F);

            VillagerTradeUtilities.EnchantedItemForEmeraldsTrade myEnchantedSteelPickaxeForEmeraldsTrade = new VillagerTradeUtilities.EnchantedItemForEmeraldsTrade(ItemList.steel_pickaxe, 13, 3, 30, 0.2F);

            setTrade(myCopperAxeForEmeraldsTrade, stoneAxeForEmeraldsTradeIndex, tradesAtLevel1);
            setTrade(myCopperShovelForEmeraldsTrade, stoneShovelForEmeraldsTradeIndex, tradesAtLevel1);
            setTrade(myCopperPickaxeForEmeraldsTrade, stonePickaxeForEmeraldsTradeIndex, tradesAtLevel1);
            setTrade(myCopperHoeForEmeraldsTrade, stoneHoeForEmeraldsTradeIndex, tradesAtLevel1);

            setTrade(myEnchantedIronAxeForEmeraldsTrade, enchantedIronAxeForEmeraldsTradeIndex, tradesAtLevel3);
            setTrade(myEnchantedIronShovelForEmeraldsTrade, enchantedIronShovelForEmeraldsTradeIndex, tradesAtLevel3);
            setTrade(myEnchantedIronPickaxeForEmeraldsTrade, enchantedIronPickaxeForEmeraldsTradeIndex, tradesAtLevel3);
            setTrade(mySteelHoeForEmeraldsTrade, diamondHoeForEmeraldsTradeIndex, tradesAtLevel3);

            setTrade(emeraldsForMySteelIngotTrade, emeraldForDiamondTradeIndex, tradesAtLevel4);
            setTrade(myEnchantedSteelAxeForEmeraldsTrade, enchantedDiamondAxeForEmeraldsTradeIndex, tradesAtLevel4);
            setTrade(myEnchantedSteelShovelForEmeraldsTrade, enchantedDiamondShovelForEmeraldsTradeIndex, tradesAtLevel4);

            setTrade(myEnchantedSteelPickaxeForEmeraldsTrade, enchantedDiamondPickaxeForEmeraldsTradeIndex, tradesAtLevel5);

        }
        if(event.getType() == VillagerProfession.ARMORER){
            //         p_221237_0_.put(
            //         VillagerProfession.ARMORER, func_221238_a(
            //         ImmutableMap.of(
            //         1, new VillagerTrades.ITrade[]{
            //         new VillagerTrades.EmeraldForItemsTrade(Items.COAL, 15, 16, 2),
            //         new VillagerTrades.ItemsForEmeraldsTrade(new ItemStack(Items.IRON_LEGGINGS), 7, 1, 12, 1, 0.2F), which is located at index 1
            //         new VillagerTrades.ItemsForEmeraldsTrade(new ItemStack(Items.IRON_BOOTS), 4, 1, 12, 1, 0.2F), which is located at index 2
            //         new VillagerTrades.ItemsForEmeraldsTrade(new ItemStack(Items.IRON_HELMET), 5, 1, 12, 1, 0.2F), which is located at index 3
            //         new VillagerTrades.ItemsForEmeraldsTrade(new ItemStack(Items.IRON_CHESTPLATE), 9, 1, 12, 1, 0.2F)}, which is located at index 4
            //         2, new VillagerTrades.ITrade[]{
            //         new VillagerTrades.EmeraldForItemsTrade(Items.IRON_INGOT, 4, 12, 10),
            //         new VillagerTrades.ItemsForEmeraldsTrade(new ItemStack(Items.BELL), 36, 1, 12, 5, 0.2F),
            //         new VillagerTrades.ItemsForEmeraldsTrade(new ItemStack(Items.CHAINMAIL_BOOTS), 1, 1, 12, 5, 0.2F), which is located at index 2
            //         new VillagerTrades.ItemsForEmeraldsTrade(new ItemStack(Items.CHAINMAIL_LEGGINGS), 3, 1, 12, 5, 0.2F)}, which is located at index 3
            //         3, new VillagerTrades.ITrade[]{
            //         new VillagerTrades.EmeraldForItemsTrade(Items.LAVA_BUCKET, 1, 12, 20),
            //         new VillagerTrades.EmeraldForItemsTrade(Items.DIAMOND, 1, 12, 20), which is located at index 1
            //         new VillagerTrades.ItemsForEmeraldsTrade(new ItemStack(Items.CHAINMAIL_HELMET), 1, 1, 12, 10, 0.2F), which is located at index 2
            //         new VillagerTrades.ItemsForEmeraldsTrade(new ItemStack(Items.CHAINMAIL_CHESTPLATE), 4, 1, 12, 10, 0.2F), which is located at index 3
            //         new VillagerTrades.ItemsForEmeraldsTrade(new ItemStack(Items.SHIELD), 5, 1, 12, 10, 0.2F)}, which is located at index 4
            //         4, new VillagerTrades.ITrade[]{
            //         new VillagerTrades.EnchantedItemForEmeraldsTrade(Items.DIAMOND_LEGGINGS, 14, 3, 15, 0.2F), which is located at index 0
            //         new VillagerTrades.EnchantedItemForEmeraldsTrade(Items.DIAMOND_BOOTS, 8, 3, 15, 0.2F)}, which is located at index 1
            //         5, new VillagerTrades.ITrade[]{
            //         new VillagerTrades.EnchantedItemForEmeraldsTrade(Items.DIAMOND_HELMET, 8, 3, 30, 0.2F), which is located at index 0
            //         new VillagerTrades.EnchantedItemForEmeraldsTrade(Items.DIAMOND_CHESTPLATE, 16, 3, 30, 0.2F)}))); which is located at index 1

            Integer level1 = 1;
            Integer level2 = 2;
            Integer level3 = 3;
            Integer level4 = 4;
            Integer level5 = 5;

            List<net.minecraft.entity.merchant.villager.VillagerTrades.ITrade> tradesAtLevel1 = event.getTrades().get(level1);
            List<net.minecraft.entity.merchant.villager.VillagerTrades.ITrade> tradesAtLevel2 = event.getTrades().get(level2);
            List<net.minecraft.entity.merchant.villager.VillagerTrades.ITrade> tradesAtLevel3 = event.getTrades().get(level3);
            List<net.minecraft.entity.merchant.villager.VillagerTrades.ITrade> tradesAtLevel4 = event.getTrades().get(level4);
            List<net.minecraft.entity.merchant.villager.VillagerTrades.ITrade> tradesAtLevel5 = event.getTrades().get(level5);

            int ironChainlegsForEmeraldsTradeIndex = 1;
            int ironChainbootsForEmeraldsTradeIndex = 2;
            int ironChainhelmForEmeraldsTradeIndex = 3;
            int ironChainbodyForEmeraldsTradeIndex = 4;
            int shieldForEmeraldsTradeIndex = 4;
            int ironBootsForEmeraldsTradeIndex = 2;
            int ironLeggingsForEmeraldsTradeIndex = 3;
            int emeraldForDiamondTradeIndex = 1;
            int ironHelmetForEmeraldsTradeIndex = 2;
            int ironChestplateForEmeraldsTradeIndex = 3;
            int diamondLeggingsForEmeraldsTradeIndex = 0;
            int diamondBootsForEmeraldsTradeIndex = 1;
            int diamondHelmetForEmeraldsTradeIndex = 0;
            int diamondChestplateForEmeraldsTradeIndex = 1;

            VillagerTradeUtilities.ItemsForEmeraldsTrade myIronChainlegsForEmeraldsTrade = new VillagerTradeUtilities.ItemsForEmeraldsTrade(new ItemStack(ItemList.iron_chainlegs), 3, 1, 12, 1, 0.2F);
            VillagerTradeUtilities.ItemsForEmeraldsTrade myIronChainbootsForEmeraldsTrade = new VillagerTradeUtilities.ItemsForEmeraldsTrade(new ItemStack(ItemList.iron_chainfeet), 1, 1, 12, 1, 0.2F);
            VillagerTradeUtilities.ItemsForEmeraldsTrade myIronChainhelmForEmeraldsTrade = new VillagerTradeUtilities.ItemsForEmeraldsTrade(new ItemStack(ItemList.iron_chainhead), 1, 1, 12, 1, 0.2F);
            VillagerTradeUtilities.ItemsForEmeraldsTrade myIronChainbodyForEmeraldsTrade = new VillagerTradeUtilities.ItemsForEmeraldsTrade(new ItemStack(ItemList.iron_chainbody), 4, 1, 12, 1, 0.2F);

            VillagerTradeUtilities.ItemsForEmeraldsTrade myIronBootsForEmeraldsTrade = new VillagerTradeUtilities.ItemsForEmeraldsTrade(new ItemStack(ItemList.iron_boots), 4, 1, 12, 5, 0.2F);
            VillagerTradeUtilities.ItemsForEmeraldsTrade myIronLeggingsForEmeraldsTrade = new VillagerTradeUtilities.ItemsForEmeraldsTrade(new ItemStack(ItemList.iron_leggings), 7, 1, 12, 5, 0.2F);

            // helmet - 5, chestplate - 9, leggings - 7, boots - 4
            // helmet - 1, chestplate - 4, leggings - 3, boots - 1

            VillagerTradeUtilities.EmeraldsForItemsTrade emeraldsForMySteelIngotTrade = new VillagerTradeUtilities.EmeraldsForItemsTrade(ItemList.steel_ingot, 1, 12, 20);
           VillagerTradeUtilities.ItemsForEmeraldsTrade myIronHelmetForEmeraldsTrade = new VillagerTradeUtilities.ItemsForEmeraldsTrade(new ItemStack(ItemList.iron_helmet), 5, 1, 12, 10, 0.2F);
            VillagerTradeUtilities.ItemsForEmeraldsTrade myIronChestplateForEmeraldsTrade = new VillagerTradeUtilities.ItemsForEmeraldsTrade(new ItemStack(ItemList.iron_chestplate), 9, 1, 12, 10, 0.2F);
            VillagerTradeUtilities.ItemsForEmeraldsTrade myIronShieldForEmeraldsTrade = new VillagerTradeUtilities.ItemsForEmeraldsTrade(new ItemStack(ShieldRegistryEvents.ironShield), 5, 1, 12, 10, 0.2F);


            VillagerTradeUtilities.EnchantedItemForEmeraldsTrade myEnchantedSteelLeggingsForEmeraldsTrade = new VillagerTradeUtilities.EnchantedItemForEmeraldsTrade(ItemList.steel_boots, 14, 3, 15, 0.2F);
            VillagerTradeUtilities.EnchantedItemForEmeraldsTrade myEnchantedSteelBootsForEmeraldsTrade = new VillagerTradeUtilities.EnchantedItemForEmeraldsTrade(ItemList.steel_leggings, 8, 3, 15, 0.2F);

            VillagerTradeUtilities.EnchantedItemForEmeraldsTrade myEnchantedSteelHelmetForEmeraldsTrade = new VillagerTradeUtilities.EnchantedItemForEmeraldsTrade(ItemList.steel_helmet, 8, 3, 30, 0.2F);
            VillagerTradeUtilities.EnchantedItemForEmeraldsTrade myEnchantedSteelChestplateForEmeraldsTrade = new VillagerTradeUtilities.EnchantedItemForEmeraldsTrade(ItemList.steel_chestplate, 16, 3, 30, 0.2F);

            setTrade(myIronChainlegsForEmeraldsTrade, ironChainlegsForEmeraldsTradeIndex, tradesAtLevel1);
            setTrade(myIronChainbootsForEmeraldsTrade, ironChainbootsForEmeraldsTradeIndex, tradesAtLevel1);
            setTrade(myIronChainhelmForEmeraldsTrade, ironChainhelmForEmeraldsTradeIndex, tradesAtLevel1);
            setTrade(myIronChainbodyForEmeraldsTrade, ironChainbodyForEmeraldsTradeIndex, tradesAtLevel1);

            setTrade(myIronBootsForEmeraldsTrade, ironBootsForEmeraldsTradeIndex, tradesAtLevel2);
            setTrade(myIronLeggingsForEmeraldsTrade, ironLeggingsForEmeraldsTradeIndex, tradesAtLevel2);

            setTrade(emeraldsForMySteelIngotTrade, emeraldForDiamondTradeIndex, tradesAtLevel3);
            setTrade(myIronHelmetForEmeraldsTrade, ironHelmetForEmeraldsTradeIndex, tradesAtLevel3);
            setTrade(myIronChestplateForEmeraldsTrade, ironChestplateForEmeraldsTradeIndex, tradesAtLevel3);
            setTrade(myIronChestplateForEmeraldsTrade, shieldForEmeraldsTradeIndex, tradesAtLevel3);

            setTrade(myEnchantedSteelLeggingsForEmeraldsTrade, diamondLeggingsForEmeraldsTradeIndex, tradesAtLevel4);
            setTrade(myEnchantedSteelBootsForEmeraldsTrade, diamondBootsForEmeraldsTradeIndex, tradesAtLevel4);

            setTrade(myEnchantedSteelHelmetForEmeraldsTrade, diamondHelmetForEmeraldsTradeIndex, tradesAtLevel5);
            setTrade(myEnchantedSteelChestplateForEmeraldsTrade, diamondChestplateForEmeraldsTradeIndex, tradesAtLevel5);

        }
    }

    public static void setTrade(VillagerTradeUtilities.ItemsForEmeraldsTrade newTrade, int index, List<net.minecraft.entity.merchant.villager.VillagerTrades.ITrade> tradesAtLevel){
        tradesAtLevel.set(index, newTrade);
    }

    public static void setTrade(VillagerTradeUtilities.EnchantedItemForEmeraldsTrade newTrade, int index, List<net.minecraft.entity.merchant.villager.VillagerTrades.ITrade> tradesAtLevel){
        tradesAtLevel.set(index, newTrade);
    }

    public static void setTrade(VillagerTradeUtilities.EmeraldsForItemsTrade newTrade, int index, List<net.minecraft.entity.merchant.villager.VillagerTrades.ITrade> tradesAtLevel){
        tradesAtLevel.set(index, newTrade);
    }

    public static void setTrade(VillagerTradeUtilities.ItemsForEmeraldsAndItemsTrade newTrade, int index, List<net.minecraft.entity.merchant.villager.VillagerTrades.ITrade> tradesAtLevel){
        tradesAtLevel.set(index, newTrade);
    }

}
