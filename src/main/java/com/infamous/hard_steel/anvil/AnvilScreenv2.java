package com.infamous.hard_steel.anvil;

import com.infamous.hard_steel.config.GeneralModConfig;
import com.infamous.hard_steel.smithingtable.Message;
import com.mojang.blaze3d.platform.GlStateManager;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.client.gui.widget.TextFieldWidget;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.IContainerListener;
import net.minecraft.inventory.container.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.network.play.client.CRenameItemPacket;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class AnvilScreenv2 extends ContainerScreen<ForgingContainer> implements IContainerListener {
  private static final ResourceLocation ANVIL_RESOURCE = new ResourceLocation("textures/gui/container/anvil.png");
  private TextFieldWidget nameField;

  public AnvilScreenv2(ForgingContainer forgingContainer, PlayerInventory playerInventory, ITextComponent iTextComponent) {
    super(forgingContainer, playerInventory, iTextComponent);
  }

  protected void init() {
    super.init();
    this.minecraft.keyboardListener.enableRepeatEvents(true);
    int lvt_1_1_ = (this.width - this.xSize) / 2;
    int lvt_2_1_ = (this.height - this.ySize) / 2;
    this.nameField = new TextFieldWidget(this.font, lvt_1_1_ + 62, lvt_2_1_ + 24, 103, 12, I18n.format("container.repair"));
    this.nameField.setCanLoseFocus(false);
    this.nameField.changeFocus(true);
    this.nameField.setTextColor(-1);
    this.nameField.setDisabledTextColour(-1);
    this.nameField.setEnableBackgroundDrawing(false);
    this.nameField.setMaxStringLength(35);
    this.nameField.func_212954_a(this::func_214075_a);
    this.children.add(this.nameField);
    this.container.addListener(this);
    this.setFocusedDefault(this.nameField);
  }

  public void resize(Minecraft minecraft, int p_resize_2_, int p_resize_3_) {
    String lvt_4_1_ = this.nameField.getText();
    this.init(minecraft, p_resize_2_, p_resize_3_);
    this.nameField.setText(lvt_4_1_);
  }

  public void removed() {
    super.removed();
    this.minecraft.keyboardListener.enableRepeatEvents(false);
    this.container.removeListener(this);
  }

  public boolean keyPressed(int p_keyPressed_1_, int p_keyPressed_2_, int p_keyPressed_3_) {
    if (p_keyPressed_1_ == 256) {
      this.minecraft.player.closeScreen();
    }

    return this.nameField.keyPressed(p_keyPressed_1_, p_keyPressed_2_, p_keyPressed_3_) || this.nameField.func_212955_f() || super.keyPressed(p_keyPressed_1_, p_keyPressed_2_, p_keyPressed_3_);
  }

  protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) {
    GlStateManager.disableLighting();
    GlStateManager.disableBlend();

    this.font.drawString(this.title.getFormattedText(), 60.0F, 6.0F, 0x404040);
    int levelCost = this.container.getMaxCost();
    if (levelCost > 0) {
      int fontColor = 0x80ff20;
      boolean hasOutput = true;
      String anvilText = I18n.format("Forging Cost: " + levelCost);
      //tell the client this repair is too expensive to be performed
      if (levelCost >= GeneralModConfig.anvil_repair_cost_cap.get() && !this.minecraft.player.abilities.isCreativeMode) {
        anvilText = I18n.format("container.repair.expensive");
        fontColor = 0xff6060;
      } else if (!this.container.getSlot(2).getHasStack()) {
        hasOutput = false;
      } else if (!this.container.getSlot(2).canTakeStack(this.playerInventory.player)) {
        fontColor = 0xff6060;
      }

      if (hasOutput) {
        int lvt_7_1_ = this.xSize - 8 - this.font.getStringWidth(anvilText) - 2;
        fill(lvt_7_1_ - 2, 67, this.xSize - 8, 79, 0x4f000000);
        this.font.drawStringWithShadow(anvilText, (float)lvt_7_1_, 69.0F, fontColor);
      }
    }

    GlStateManager.enableLighting();
  }

  private void func_214075_a(String newName) {
    if (!newName.isEmpty()) {
      String name = newName;
      // gets the name of the item from the output slot for renaming
      Slot slot = this.container.getSlot(2);
      if (slot.getHasStack() && !slot.getStack().hasDisplayName() && newName.equals(slot.getStack().getDisplayName().getString())) {
        name = "";
      }

      this.container.updateItemName(name);
      //this.minecraft.player.connection.sendPacket(new CRenameItemPacket(name));
      Message.INSTANCE.sendToServer(new CPacketAnvilRename(name));
    }
  }

  public void render(int p_render_1_, int p_render_2_, float p_render_3_) {
    this.renderBackground();
    super.render(p_render_1_, p_render_2_, p_render_3_);
    this.renderHoveredToolTip(p_render_1_, p_render_2_);
    GlStateManager.disableLighting();
    GlStateManager.disableBlend();
    this.nameField.render(p_render_1_, p_render_2_, p_render_3_);
  }

  protected void drawGuiContainerBackgroundLayer(float p_146976_1_, int p_146976_2_, int p_146976_3_) {
    GlStateManager.color4f(1.0F, 1.0F, 1.0F, 1.0F);
    this.minecraft.getTextureManager().bindTexture(ANVIL_RESOURCE);
    int lvt_4_1_ = (this.width - this.xSize) / 2;
    int lvt_5_1_ = (this.height - this.ySize) / 2;
    this.blit(lvt_4_1_, lvt_5_1_, 0, 0, this.xSize, this.ySize);
    this.blit(lvt_4_1_ + 59, lvt_5_1_ + 20, 0, this.ySize + (this.container.getSlot(0).getHasStack() ? 0 : 16), 110, 16);
    if ((this.container.getSlot(0).getHasStack() || this.container.getSlot(1).getHasStack()) && !this.container.getSlot(2).getHasStack()) {
      this.blit(lvt_4_1_ + 99, lvt_5_1_ + 45, this.xSize, 0, 28, 21);
    }

  }

  public void sendAllContents(Container container, NonNullList<ItemStack> itemStacks) {
    this.sendSlotContents(container, 2, container.getSlot(2).getStack());
  }

  public void sendSlotContents(Container container, int slot, ItemStack toRename) {
    if (slot == 2) {
      this.nameField.setText(container.getSlot(slot).getStack().isEmpty() ? "" : container.getSlot(slot).getStack().getDisplayName().getString());
      this.nameField.setEnabled(!container.getSlot(slot).getStack().isEmpty());
    }
  }

  public void sendWindowProperty(Container container, int p_71112_2_, int p_71112_3_) {
  }
}
