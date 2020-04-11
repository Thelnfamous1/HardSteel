package com.infamous.hard_steel.shields.client;

import java.util.Map;

import com.infamous.hard_steel.HardSteel;

import net.minecraft.client.renderer.model.IBakedModel;
import net.minecraft.client.renderer.model.ModelResourceLocation;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.ModelBakeEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

@EventBusSubscriber(value = Dist.CLIENT, modid = HardSteel.modid, bus = EventBusSubscriber.Bus.MOD)
public class ModelHandler {

	@SubscribeEvent
	public static void onModelBake(ModelBakeEvent e) {
		final Map<ResourceLocation, IBakedModel> registry = e.getModelRegistry();
		replaceShieldModel(registry, "wooden");
		replaceShieldModel(registry, "copper");
		replaceShieldModel(registry, "bronze");
		replaceShieldModel(registry, "iron");
		replaceShieldModel(registry, "steel");
		replaceShieldModel(registry, "mithril");
		replaceShieldModel(registry, "netherite");
		replaceShieldModel(registry, "enderite");
	}

	private static void replaceShieldModel(Map<ResourceLocation, IBakedModel> registry, String material) {
		ModelResourceLocation location = new ModelResourceLocation(HardSteel.modid + ":" + material + "_shield",
				"inventory");
		IBakedModel originalModel = registry.get(location);
		registry.put((location), new ShieldModel(originalModel));
	}

}