package com.infamous.hard_steel.smithingtable;

import com.infamous.hard_steel.HardSteel;
import com.infamous.hard_steel.anvil.CPacketAnvilRename;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.network.NetworkRegistry;
import net.minecraftforge.fml.network.simple.SimpleChannel;


public class Message {

    public static SimpleChannel INSTANCE;

    public static void registerMessages(String channelName) {
        INSTANCE = NetworkRegistry.newSimpleChannel(new ResourceLocation(HardSteel.modid, channelName), () -> "1.0", s -> true, s -> true);
        INSTANCE.registerMessage(0, CPacketSmithingTableRename.class,
                CPacketSmithingTableRename::encode,
                CPacketSmithingTableRename::new,
                CPacketSmithingTableRename::handle);
        INSTANCE.registerMessage(1, CPacketAnvilRename.class,
                CPacketAnvilRename::encode,
                CPacketAnvilRename::new,
                CPacketAnvilRename::handle);
    }
}
