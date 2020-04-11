package com.infamous.hard_steel.shields.client;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.infamous.hard_steel.HardSteel;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.annotation.Nullable;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.LayeredColorMaskTexture;
import net.minecraft.client.renderer.texture.MissingTextureSprite;
import net.minecraft.item.DyeColor;
import net.minecraft.tileentity.BannerPattern;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Util;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class ShieldTextures {
	public static final Cache WOODEN_SHIELD_DESIGNS = new Cache("shield_",
			new ResourceLocation(HardSteel.modid, "textures/entity/wooden_shield_base.png"),
			"textures/entity/shield/");
	public static final Cache COPPER_SHIELD_DESIGNS = new Cache("shield_",
			new ResourceLocation(HardSteel.modid, "textures/entity/copper_shield_base.png"),
			"textures/entity/shield/");
	public static final Cache BRONZE_SHIELD_DESIGNS = new Cache("shield_",
			new ResourceLocation(HardSteel.modid, "textures/entity/bronze_shield_base.png"),
			"textures/entity/shield/");
	public static final Cache IRON_SHIELD_DESIGNS = new Cache("shield_",
			new ResourceLocation(HardSteel.modid, "textures/entity/iron_shield_base.png"),
			"textures/entity/shield/");
	public static final Cache STEEL_SHIELD_DESIGNS = new Cache("shield_",
			new ResourceLocation(HardSteel.modid, "textures/entity/steel_shield_base.png"),
			"textures/entity/shield/");
	public static final Cache MITHRIL_SHIELD_DESIGNS = new Cache("shield_",
			new ResourceLocation(HardSteel.modid, "textures/entity/mithril_shield_base.png"),
			"textures/entity/shield/");
	public static final Cache NETHERITE_SHIELD_DESIGNS = new Cache("shield_",
			new ResourceLocation(HardSteel.modid, "textures/entity/netherite_shield_base.png"),
			"textures/entity/shield/");
	public static final Cache ENDERITE_SHIELD_DESIGNS = new Cache("shield_",
			new ResourceLocation(HardSteel.modid, "textures/entity/enderite_shield_base.png"),
			"textures/entity/shield/");


	public static final ResourceLocation WOODEN_SHIELD_BASE_TEXTURE = new ResourceLocation(HardSteel.modid,
			"textures/entity/wooden_shield_base_nopattern.png");
	public static final ResourceLocation COPPER_SHIELD_BASE_TEXTURE = new ResourceLocation(HardSteel.modid,
			"textures/entity/copper_shield_base_nopattern.png");
	public static final ResourceLocation BRONZE_SHIELD_BASE_TEXTURE = new ResourceLocation(HardSteel.modid,
			"textures/entity/bronze_shield_base_nopattern.png");
	public static final ResourceLocation IRON_SHIELD_BASE_TEXTURE = new ResourceLocation(HardSteel.modid,
			"textures/entity/iron_shield_base_nopattern.png");
	public static final ResourceLocation STEEL_SHIELD_BASE_TEXTURE = new ResourceLocation(HardSteel.modid,
			"textures/entity/steel_shield_base_nopattern.png");
	public static final ResourceLocation MITHRIL_SHIELD_BASE_TEXTURE = new ResourceLocation(HardSteel.modid,
			"textures/entity/mithril_shield_base_nopattern.png");
	public static final ResourceLocation NETHERITE_SHIELD_BASE_TEXTURE = new ResourceLocation(HardSteel.modid,
			"textures/entity/netherite_shield_base_nopattern.png");
	public static final ResourceLocation ENDERITE_SHIELD_BASE_TEXTURE = new ResourceLocation(HardSteel.modid,
			"textures/entity/enderite_shield_base_nopattern.png");

	@OnlyIn(Dist.CLIENT)
	public static class Cache {
		private final Map<String, CacheEntry> cacheMap = Maps.newLinkedHashMap();
		private final ResourceLocation cacheResourceLocation;
		private final String cacheResourceBase;
		private final String cacheId;
		private final ResourceLocation baseTexture;

		public Cache(String id, ResourceLocation baseResource, String resourcePath) {
			this.cacheId = id;
			this.cacheResourceLocation = baseResource;
			this.cacheResourceBase = resourcePath;
			this.baseTexture = new ResourceLocation(baseResource.getNamespace(),
					baseResource.getPath().replaceAll(".png", "_nopattern.png"));
		}

		@Nullable
		public ResourceLocation getResourceLocation(String id, List<BannerPattern> patternList,
				List<DyeColor> colorList) {
			if (id.isEmpty()) {
				return null;
			} else if (!patternList.isEmpty() && !colorList.isEmpty()) {
				id = this.cacheId + id;
				CacheEntry bannertextures$cacheentry = this.cacheMap.get(id);
				if (bannertextures$cacheentry == null) {
					if (this.cacheMap.size() >= 256 && !this.freeCacheSlot()) {
						return baseTexture;
					}

					List<String> list = Lists.newArrayList();

					for (BannerPattern bannerpattern : patternList) {
						list.add(this.cacheResourceBase + bannerpattern.getFileName() + ".png");
					}

					bannertextures$cacheentry = new CacheEntry();
					bannertextures$cacheentry.textureLocation = new ResourceLocation(id);
					Minecraft.getInstance().getTextureManager().loadTexture(bannertextures$cacheentry.textureLocation,
							new LayeredColorMaskTexture(this.cacheResourceLocation, list, colorList));
					this.cacheMap.put(id, bannertextures$cacheentry);
				}

				bannertextures$cacheentry.lastUseMillis = Util.milliTime();
				return bannertextures$cacheentry.textureLocation;
			} else {
				return MissingTextureSprite.getLocation();
			}
		}

		private boolean freeCacheSlot() {
			long i = Util.milliTime();
			Iterator<String> iterator = this.cacheMap.keySet().iterator();

			while (iterator.hasNext()) {
				String s = iterator.next();
				CacheEntry bannertextures$cacheentry = this.cacheMap.get(s);
				if (i - bannertextures$cacheentry.lastUseMillis > 5000L) {
					Minecraft.getInstance().getTextureManager()
							.deleteTexture(bannertextures$cacheentry.textureLocation);
					iterator.remove();
					return true;
				}
			}

			return this.cacheMap.size() < 256;
		}
	}

	@OnlyIn(Dist.CLIENT)
	static class CacheEntry {
		public long lastUseMillis;
		public ResourceLocation textureLocation;

		private CacheEntry() {
		}
	}
}
