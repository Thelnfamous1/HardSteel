package com.infamous.hard_steel.shields;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.function.Supplier;

import com.google.common.collect.Multimap;
import com.infamous.hard_steel.HardSteel;
import com.infamous.hard_steel.shields.client.ShieldTileEntityRenderer;

import com.infamous.hard_steel.util.EquipmentUtilities;
import net.minecraft.block.DispenserBlock;
import net.minecraft.client.renderer.tileentity.ItemStackTileEntityRenderer;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ShieldItem;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.Tag;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import static net.minecraft.entity.ai.attributes.AttributeModifier.Operation.ADDITION;

public class BetterShieldItem extends ShieldItem {

	private Supplier<Integer> damageReduction;
	private Tag<Item> repairMaterial;


	private double shieldSpeedPenalty;
	private double shieldKnockbackResistanceBenefit;

	public BetterShieldItem(String registryName, Supplier<Integer> damageReduction, ResourceLocation repairMaterial,
			int durability, double speedPenalty, double knockbackResistanceBenefit) {
		super(new Properties().setTEISR(() -> getTEISR()).group(HardSteel.hard_steel).maxDamage(durability));
		setRegistryName(new ResourceLocation(HardSteel.modid, registryName));
		this.damageReduction = damageReduction;
		this.repairMaterial = ItemTags.getCollection().getOrCreate(repairMaterial);
		this.shieldSpeedPenalty = EquipmentUtilities.getDefaultMovementSpeed() * speedPenalty * -1;
		this.shieldKnockbackResistanceBenefit = knockbackResistanceBenefit;
		DispenserBlock.registerDispenseBehavior(this, ArmorItem.DISPENSER_BEHAVIOR);
	}

	@Override
	public Multimap<String, AttributeModifier> getAttributeModifiers(EquipmentSlotType equipmentSlot) {
		Multimap<String, AttributeModifier> multimap = super.getAttributeModifiers(equipmentSlot);
		if(this.shieldSpeedPenalty == 0 && this.shieldKnockbackResistanceBenefit == 0){
			return multimap;
		}
		if(equipmentSlot == EquipmentSlotType.OFFHAND || equipmentSlot == EquipmentSlotType.MAINHAND){
			multimap.put(SharedMonsterAttributes.MOVEMENT_SPEED.getName(), new AttributeModifier(EquipmentUtilities.getSpeedModifierUUID(equipmentSlot), "shiekdSpeedModifier", this.shieldSpeedPenalty, ADDITION));
			multimap.put(SharedMonsterAttributes.KNOCKBACK_RESISTANCE.getName(), new AttributeModifier(EquipmentUtilities.getKnockbackResistanceModifierUUID(equipmentSlot), "shieldKnockbackResistanceModifier", this.shieldKnockbackResistanceBenefit, ADDITION));
		}
		return multimap;
	}

	@OnlyIn(Dist.CLIENT)
	private static Callable<ItemStackTileEntityRenderer> getTEISR() {
		return ShieldTileEntityRenderer::new;
	}

	public int getDamageReduction() {
		return damageReduction.get();
	}

	@Override
	public boolean getIsRepairable(ItemStack toRepair, ItemStack repair) {
		return repairMaterial.contains(repair.getItem());
	}

	@Override
	public boolean isShield(ItemStack stack, LivingEntity entity) {
		return true;
	}

	@Override
	public void addInformation(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
		tooltip.add(ShieldRegistryEvents.getDamageReductionTextComponent(getDamageReduction()));
		super.addInformation(stack, worldIn, tooltip, flagIn);
	}

}
