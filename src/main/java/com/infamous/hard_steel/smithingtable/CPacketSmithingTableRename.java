package com.infamous.hard_steel.smithingtable;

import net.minecraft.inventory.container.Container;
import net.minecraft.network.PacketBuffer;
import net.minecraftforge.fml.network.NetworkEvent;

import java.util.function.Supplier;

public class CPacketSmithingTableRename {

    private String name;
    private int length;

    public CPacketSmithingTableRename() {}

    public CPacketSmithingTableRename(String newName) {
        this.name = newName;
    }

    public CPacketSmithingTableRename(PacketBuffer buf) {
        length = buf.readInt();
        name = buf.readString(length);
    }

    public void encode(PacketBuffer buf) {
        buf.writeInt(name.length());
        buf.writeString(name);
    }

    public void handle(Supplier<NetworkEvent.Context> ctx) {
        ctx.get().enqueueWork(() -> {
            if (ctx.get() == null || ctx.get().getSender() == null)return;
            Container smithingTable = ctx.get().getSender().openContainer;
            if (smithingTable instanceof SmithingTableContainer){
                ((SmithingTableContainer)smithingTable).updateItemName(name);}
        });
        ctx.get().setPacketHandled(true);
    }
}
