package com.infamous.hard_steel.shields.client;

import com.infamous.hard_steel.HardSteel;
import com.infamous.hard_steel.config.GeneralModConfig;
import com.infamous.hard_steel.shields.BetterShieldItem;

import com.infamous.hard_steel.shields.ShieldRegistryEvents;
import net.minecraft.item.Items;
import net.minecraft.item.ShieldItem;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

@EventBusSubscriber(value = Dist.CLIENT, modid = HardSteel.modid)
public class TooltipHandler {

	@SubscribeEvent
	public static void onTooltip(ItemTooltipEvent e) {
		if (e.getItemStack().getItem() == Items.SHIELD)
			e.getToolTip().add(ShieldRegistryEvents.getDamageReductionTextComponent(GeneralModConfig.defaultDamageReduction.get()));
		else if (e.getItemStack().getItem() instanceof ShieldItem
				&& !(e.getItemStack().getItem() instanceof BetterShieldItem))
			e.getToolTip().add(ShieldRegistryEvents.getDamageReductionTextComponent(
					GeneralModConfig.customShieldMaxReduction.get() ? 100 : GeneralModConfig.defaultDamageReduction.get()));
	}

}