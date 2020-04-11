package com.infamous.hard_steel.cementation_furnace;

import com.infamous.hard_steel.cementation_furnace.CementationFurnaceContainer;
import com.mojang.blaze3d.platform.GlStateManager;
import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.AbstractFurnaceContainer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;

public class CementationFurnaceScreen extends ContainerScreen<CementationFurnaceContainer> {
    private static final ResourceLocation GUI_TEXTURE = new ResourceLocation("hard_steel:textures/gui/container/cementation_furnace.png");

    public CementationFurnaceScreen(CementationFurnaceContainer screenContainer, PlayerInventory inv, ITextComponent titleIn) {
        super(screenContainer, inv, titleIn);
    }

    @Override
    public void render(int mouseX, int mouseY, float partialTicks) {
        this.renderBackground();
        super.render(mouseX, mouseY, partialTicks);
        this.renderHoveredToolTip(mouseX, mouseY);
    }

    @Override
    protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) {
        String s = this.title.getFormattedText();
        this.font.drawString(s, (float)(this.xSize / 2 - this.font.getStringWidth(s) / 2), 6.0F, 4210752);
        this.font.drawString(this.playerInventory.getDisplayName().getFormattedText(), 8.0F, (float)(this.ySize - 96 + 2), 4210752);
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
        GlStateManager.color4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.minecraft.getTextureManager().bindTexture(GUI_TEXTURE);
        int i = this.guiLeft;
        int j = this.guiTop;
        this.blit(i, j, 0, 0, this.xSize, this.ySize);
        if (((AbstractFurnaceContainer)this.container).func_217061_l()) {
            int k = ((AbstractFurnaceContainer)this.container).getBurnLeftScaled();
            this.blit(i + 56, j + 36 + 12 - k, 176, 12 - k, 14, k + 1);
        }

        int l = ((AbstractFurnaceContainer)this.container).getCookProgressionScaled();
        this.blit(i + 79, j + 34, 176, 14, l + 1, 16);
    }
}
