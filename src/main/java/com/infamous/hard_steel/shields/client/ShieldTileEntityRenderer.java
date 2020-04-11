package com.infamous.hard_steel.shields.client;

import com.infamous.hard_steel.shields.ShieldRegistryEvents;
import com.mojang.blaze3d.platform.GlStateManager;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.ItemRenderer;
import net.minecraft.client.renderer.entity.model.ShieldModel;
import net.minecraft.client.renderer.tileentity.ItemStackTileEntityRenderer;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ShieldItem;
import net.minecraft.tileentity.BannerTileEntity;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class ShieldTileEntityRenderer extends ItemStackTileEntityRenderer {

	private final BannerTileEntity banner = new BannerTileEntity();
	private final ShieldModel modelShield = new ShieldModel();

	@Override
	public void renderByItem(ItemStack itemStackIn) {
		if (itemStackIn.getItem() == ShieldRegistryEvents.ironShield) {
			if (itemStackIn.getChildTag("BlockEntityTag") != null) {
				this.banner.loadFromItemStack(itemStackIn, ShieldItem.getColor(itemStackIn));
				Minecraft.getInstance().getTextureManager()
						.bindTexture(ShieldTextures.IRON_SHIELD_DESIGNS.getResourceLocation(
								this.banner.getPatternResourceLocation(), this.banner.getPatternList(),
								this.banner.getColorList()));
			} else {
				Minecraft.getInstance().getTextureManager().bindTexture(ShieldTextures.IRON_SHIELD_BASE_TEXTURE);
			}

			GlStateManager.pushMatrix();
			GlStateManager.scalef(1.0F, -1.0F, -1.0F);
			this.modelShield.render();
			if (itemStackIn.hasEffect()) {
				this.renderEffect(this.modelShield::render);
			}
			GlStateManager.popMatrix();
		}else if (itemStackIn.getItem() == ShieldRegistryEvents.bronzeShield) {
			if (itemStackIn.getChildTag("BlockEntityTag") != null) {
				this.banner.loadFromItemStack(itemStackIn, ShieldItem.getColor(itemStackIn));
				Minecraft.getInstance().getTextureManager()
						.bindTexture(ShieldTextures.BRONZE_SHIELD_DESIGNS.getResourceLocation(
								this.banner.getPatternResourceLocation(), this.banner.getPatternList(),
								this.banner.getColorList()));
			} else {
				Minecraft.getInstance().getTextureManager().bindTexture(ShieldTextures.BRONZE_SHIELD_BASE_TEXTURE);
			}

			GlStateManager.pushMatrix();
			GlStateManager.scalef(1.0F, -1.0F, -1.0F);
			this.modelShield.render();
			if (itemStackIn.hasEffect()) {
				this.renderEffect(this.modelShield::render);
			}
			GlStateManager.popMatrix();
		}else if (itemStackIn.getItem() == ShieldRegistryEvents.woodenShield) {
			if (itemStackIn.getChildTag("BlockEntityTag") != null) {
				this.banner.loadFromItemStack(itemStackIn, ShieldItem.getColor(itemStackIn));
				Minecraft.getInstance().getTextureManager()
						.bindTexture(ShieldTextures.WOODEN_SHIELD_DESIGNS.getResourceLocation(
								this.banner.getPatternResourceLocation(), this.banner.getPatternList(),
								this.banner.getColorList()));
			} else {
				Minecraft.getInstance().getTextureManager().bindTexture(ShieldTextures.WOODEN_SHIELD_BASE_TEXTURE);
			}

			GlStateManager.pushMatrix();
			GlStateManager.scalef(1.0F, -1.0F, -1.0F);
			this.modelShield.render();
			if (itemStackIn.hasEffect()) {
				this.renderEffect(this.modelShield::render);
			}
			GlStateManager.popMatrix();
		} else if (itemStackIn.getItem() == ShieldRegistryEvents.copperShield) {
			if (itemStackIn.getChildTag("BlockEntityTag") != null) {
				this.banner.loadFromItemStack(itemStackIn, ShieldItem.getColor(itemStackIn));
				Minecraft.getInstance().getTextureManager()
						.bindTexture(ShieldTextures.COPPER_SHIELD_DESIGNS.getResourceLocation(
								this.banner.getPatternResourceLocation(), this.banner.getPatternList(),
								this.banner.getColorList()));
			} else {
				Minecraft.getInstance().getTextureManager().bindTexture(ShieldTextures.COPPER_SHIELD_BASE_TEXTURE);
			}

			GlStateManager.pushMatrix();
			GlStateManager.scalef(1.0F, -1.0F, -1.0F);
			this.modelShield.render();
			if (itemStackIn.hasEffect()) {
				this.renderEffect(this.modelShield::render);
			}
			GlStateManager.popMatrix();
		} else if (itemStackIn.getItem() == ShieldRegistryEvents.steelShield) {
			if (itemStackIn.getChildTag("BlockEntityTag") != null) {
				this.banner.loadFromItemStack(itemStackIn, ShieldItem.getColor(itemStackIn));
				Minecraft.getInstance().getTextureManager()
						.bindTexture(ShieldTextures.STEEL_SHIELD_DESIGNS.getResourceLocation(
								this.banner.getPatternResourceLocation(), this.banner.getPatternList(),
								this.banner.getColorList()));
			} else {
				Minecraft.getInstance().getTextureManager().bindTexture(ShieldTextures.STEEL_SHIELD_BASE_TEXTURE);
			}

			GlStateManager.pushMatrix();
			GlStateManager.scalef(1.0F, -1.0F, -1.0F);
			this.modelShield.render();
			if (itemStackIn.hasEffect()) {
				this.renderEffect(this.modelShield::render);
			}
			GlStateManager.popMatrix();
		}else if (itemStackIn.getItem() == ShieldRegistryEvents.mithrilShield) {
			if (itemStackIn.getChildTag("BlockEntityTag") != null) {
				this.banner.loadFromItemStack(itemStackIn, ShieldItem.getColor(itemStackIn));
				Minecraft.getInstance().getTextureManager()
						.bindTexture(ShieldTextures.MITHRIL_SHIELD_DESIGNS.getResourceLocation(
								this.banner.getPatternResourceLocation(), this.banner.getPatternList(),
								this.banner.getColorList()));
			} else {
				Minecraft.getInstance().getTextureManager().bindTexture(ShieldTextures.MITHRIL_SHIELD_BASE_TEXTURE);
			}

			GlStateManager.pushMatrix();
			GlStateManager.scalef(1.0F, -1.0F, -1.0F);
			this.modelShield.render();
			if (itemStackIn.hasEffect()) {
				this.renderEffect(this.modelShield::render);
			}
			GlStateManager.popMatrix();
		}else if (itemStackIn.getItem() == ShieldRegistryEvents.netheriteShield) {
			if (itemStackIn.getChildTag("BlockEntityTag") != null) {
				this.banner.loadFromItemStack(itemStackIn, ShieldItem.getColor(itemStackIn));
				Minecraft.getInstance().getTextureManager()
						.bindTexture(ShieldTextures.NETHERITE_SHIELD_DESIGNS.getResourceLocation(
								this.banner.getPatternResourceLocation(), this.banner.getPatternList(),
								this.banner.getColorList()));
			} else {
				Minecraft.getInstance().getTextureManager().bindTexture(ShieldTextures.NETHERITE_SHIELD_BASE_TEXTURE);
			}

			GlStateManager.pushMatrix();
			GlStateManager.scalef(1.0F, -1.0F, -1.0F);
			this.modelShield.render();
			if (itemStackIn.hasEffect()) {
				this.renderEffect(this.modelShield::render);
			}
			GlStateManager.popMatrix();
		}else if (itemStackIn.getItem() == ShieldRegistryEvents.enderiteShield) {
			if (itemStackIn.getChildTag("BlockEntityTag") != null) {
				this.banner.loadFromItemStack(itemStackIn, ShieldItem.getColor(itemStackIn));
				Minecraft.getInstance().getTextureManager()
						.bindTexture(ShieldTextures.ENDERITE_SHIELD_DESIGNS.getResourceLocation(
								this.banner.getPatternResourceLocation(), this.banner.getPatternList(),
								this.banner.getColorList()));
			} else {
				Minecraft.getInstance().getTextureManager().bindTexture(ShieldTextures.ENDERITE_SHIELD_BASE_TEXTURE);
			}

			GlStateManager.pushMatrix();
			GlStateManager.scalef(1.0F, -1.0F, -1.0F);
			this.modelShield.render();
			if (itemStackIn.hasEffect()) {
				this.renderEffect(this.modelShield::render);
			}
			GlStateManager.popMatrix();
		} else {
			super.renderByItem(itemStackIn);
		}
	}

	private void renderEffect(Runnable renderModelFunction) {
		GlStateManager.color3f(0.5019608F, 0.2509804F, 0.8F);
		Minecraft.getInstance().getTextureManager().bindTexture(ItemRenderer.RES_ITEM_GLINT);
		ItemRenderer.renderEffect(Minecraft.getInstance().getTextureManager(), renderModelFunction, 1);
	}

}
