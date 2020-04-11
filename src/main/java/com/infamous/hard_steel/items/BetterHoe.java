package com.infamous.hard_steel.items;

import java.util.List;
import java.util.Map;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import com.google.common.collect.Multimap;
import com.infamous.hard_steel.lists.ItemList;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.*;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;

public class BetterHoe extends TieredItem
{
    private final float attackDamage;
    private final float attackSpeed;
    protected static final Map<Block, BlockState> HOE_LOOKUP = Maps.newHashMap(ImmutableMap.of(Blocks.GRASS_BLOCK, Blocks.FARMLAND.getDefaultState(), Blocks.GRASS_PATH, Blocks.FARMLAND.getDefaultState(), Blocks.DIRT, Blocks.FARMLAND.getDefaultState(), Blocks.COARSE_DIRT, Blocks.DIRT.getDefaultState()));


    public BetterHoe(IItemTier tier, float attackDamageIn, float attackSpeedIn, Properties builder)
    {
        super(tier, builder);
        this.attackDamage = attackDamageIn + (tier.getAttackDamage() / 2.0F);
        this.attackSpeed = attackSpeedIn;
    }

    public ActionResultType onItemUse(ItemUseContext context) {
        World world = context.getWorld();
        BlockPos blockpos = context.getPos();
        int hook = net.minecraftforge.event.ForgeEventFactory.onHoeUse(context);
        if (hook != 0) return hook > 0 ? ActionResultType.SUCCESS : ActionResultType.FAIL;
        if (context.getFace() != Direction.DOWN && world.isAirBlock(blockpos.up())) {
            BlockState blockstate = HOE_LOOKUP.get(world.getBlockState(blockpos).getBlock());
            if (blockstate != null) {
                PlayerEntity playerentity = context.getPlayer();
                world.playSound(playerentity, blockpos, SoundEvents.ITEM_HOE_TILL, SoundCategory.BLOCKS, 1.0F, 1.0F);
                if (!world.isRemote) {
                    world.setBlockState(blockpos, blockstate, 11);
                    if (playerentity != null) {
                        context.getItem().damageItem(1, playerentity, (p_220043_1_) -> {
                            p_220043_1_.sendBreakAnimation(context.getHand());
                        });
                    }
                }

                return ActionResultType.SUCCESS;
            }
        }

        return ActionResultType.PASS;
    }

    public boolean hitEntity(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        // A vanilla hoe is only damaged by 1 per hit, but since this is a hoe that can effectively be used as a weapon, it now is damaged by 2 per hit
        stack.damageItem(2, attacker, (p_220042_0_) -> {
            p_220042_0_.sendBreakAnimation(EquipmentSlotType.MAINHAND);
        });
        return true;
    }

    public Multimap<String, AttributeModifier> getAttributeModifiers(EquipmentSlotType equipmentSlot) {
        Multimap<String, AttributeModifier> multimap = super.getAttributeModifiers(equipmentSlot);
        if (equipmentSlot == EquipmentSlotType.MAINHAND) {
            multimap.put(SharedMonsterAttributes.ATTACK_DAMAGE.getName(), new AttributeModifier(ATTACK_DAMAGE_MODIFIER, "Tool modifier", (double)this.attackDamage, AttributeModifier.Operation.ADDITION));
            multimap.put(SharedMonsterAttributes.ATTACK_SPEED.getName(), new AttributeModifier(ATTACK_SPEED_MODIFIER, "Tool modifier", (double)this.attackSpeed, AttributeModifier.Operation.ADDITION));
        }

        return multimap;
    }
}
