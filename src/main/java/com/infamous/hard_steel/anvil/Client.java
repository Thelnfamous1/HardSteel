package com.infamous.hard_steel.anvil;

import com.infamous.hard_steel.HardSteel;
import net.minecraft.client.gui.ScreenManager;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = HardSteel.modid,bus = Mod.EventBusSubscriber.Bus.MOD,value = Dist.CLIENT)
public class Client {
  @SubscribeEvent
  public static void doClientStuff(final FMLClientSetupEvent event) {
    //ClientRegistry.bindTileEntitySpecialRenderer(AnvilTile.class, new AnvilTileSpecialRenderer());
  }
}
