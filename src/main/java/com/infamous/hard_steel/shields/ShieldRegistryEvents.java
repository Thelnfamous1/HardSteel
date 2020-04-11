package com.infamous.hard_steel.shields;

import com.infamous.hard_steel.HardSteel;
import com.infamous.hard_steel.config.GeneralModConfig;
import net.minecraft.item.Item;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.registries.IForgeRegistry;

@Mod(HardSteel.modid)
@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public class ShieldRegistryEvents {

	public static BetterShieldItem woodenShield;
	public static BetterShieldItem copperShield;
	public static BetterShieldItem bronzeShield;
	public static BetterShieldItem ironShield;
	public static BetterShieldItem steelShield;
	public static BetterShieldItem mithrilShield;
	public static BetterShieldItem netheriteShield;
	public static BetterShieldItem enderiteShield;

	@SubscribeEvent
	public static void registerItems(RegistryEvent.Register<Item> e) {
		final IForgeRegistry<Item> registry = e.getRegistry();
		registry.registerAll(

				woodenShield = new BetterShieldItem("wooden_shield", () -> GeneralModConfig.woodenDamageReduction.get(),
						new ResourceLocation("minecraft", "planks"), GeneralModConfig.woodenDurability.get(), 0, 0),

				// Chestplate weight multiplier (8 ingots / 24 ingots total for full set of armor) * actual multiplier
				copperShield = new BetterShieldItem("copper_shield", () -> GeneralModConfig.copperDamageReduction.get(),
						new ResourceLocation("forge", "ingots/copper"), GeneralModConfig.copperDurability.get(), 0.05,  0.05),

				bronzeShield  = new BetterShieldItem("bronze_shield", () -> GeneralModConfig.ironDamageReduction.get(),
						new ResourceLocation("forge", "ingots/bronze"), GeneralModConfig.ironDurability.get(), 0.05,  0.05),

				ironShield  = new BetterShieldItem("iron_shield", () -> GeneralModConfig.ironDamageReduction.get(),
						new ResourceLocation("forge", "ingots/iron"), GeneralModConfig.ironDurability.get(), 0.05, 0.05),

				steelShield = new BetterShieldItem("steel_shield", () -> GeneralModConfig.steelDamageReduction.get(),
						new ResourceLocation("forge", "ingots/steel"), GeneralModConfig.steelDurability.get(), 0.05, 0.05),

				mithrilShield = new BetterShieldItem("mithril_shield", () -> GeneralModConfig.mithrilDamageReduction.get(),
						new ResourceLocation("forge", "ingots/mithril"), GeneralModConfig.mithrilDurability.get(), 0.025, 0.025),

				netheriteShield = new BetterShieldItem("netherite_shield", () -> GeneralModConfig.netheriteDamageReduction.get(),
						new ResourceLocation("forge", "ingots/netherite"), GeneralModConfig.netheriteDurability.get(), 0.05, 0.05),

				enderiteShield = new BetterShieldItem("enderite_shield", () -> GeneralModConfig.enderiteDamageReduction.get(),
						new ResourceLocation("forge", "ingots/enderite"), GeneralModConfig.enderiteDurability.get(), 0.05, 0.05)
		);
	}

	@SubscribeEvent
	public static void registerRecipes(RegistryEvent.Register<IRecipeSerializer<?>> e) {
		final IForgeRegistry<IRecipeSerializer<?>> registry = e.getRegistry();
		registry.register(ShieldRecipes.SERIALIZER.setRegistryName(new ResourceLocation(HardSteel.modid, "shield_decoration")));
	}

	public static ITextComponent getDamageReductionTextComponent(int reduction) {
		return new TranslationTextComponent("hard_steel.banner_damage_reduction", reduction)
				.applyTextStyle(TextFormatting.DARK_GREEN);
	}

}
