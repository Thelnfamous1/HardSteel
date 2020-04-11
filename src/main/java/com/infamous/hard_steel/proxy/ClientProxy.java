package com.infamous.hard_steel.proxy;

import com.infamous.hard_steel.anvil.AnvilRegistryEvents;
import com.infamous.hard_steel.anvil.AnvilScreenv2;
import com.infamous.hard_steel.bloomery.BloomeryRegistryEvents;
import com.infamous.hard_steel.bloomery.BloomeryScreen;
import com.infamous.hard_steel.cementation_furnace.CementationFurnaceRegistryEvents;
import com.infamous.hard_steel.cementation_furnace.CementationFurnaceScreen;
import com.infamous.hard_steel.crucible.CrucibleRegistryEvents;
import com.infamous.hard_steel.crucible.CrucibleScreen;
import com.infamous.hard_steel.finery_forge.FineryForgeRegistryEvents;
import com.infamous.hard_steel.finery_forge.FineryForgeScreen;
import com.infamous.hard_steel.blast_furnace.BlastFurnaceRegistryEvents;
import com.infamous.hard_steel.blast_furnace.BlastFurnaceScreen;
import com.infamous.hard_steel.smithingtable.SmithingTableRegistryEvents;
import com.infamous.hard_steel.smithingtable.SmithingTableScreen;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.ScreenManager;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;

public class ClientProxy implements IProxy {

    public ClientProxy() {
    }

    @Override
    public void init() {


        ScreenManager.registerFactory(AnvilRegistryEvents.ANVIL_CONTAINER, AnvilScreenv2::new);
        ScreenManager.registerFactory(SmithingTableRegistryEvents.SMITHING_TABLE_CONTAINER, SmithingTableScreen::new);
        ScreenManager.registerFactory(CrucibleRegistryEvents.CRUCIBLE_CONTAINER, CrucibleScreen::new);
        ScreenManager.registerFactory(BloomeryRegistryEvents.BLOOMERY_CONTAINER, BloomeryScreen::new);
        ScreenManager.registerFactory(CementationFurnaceRegistryEvents.CEMENTATION_FURNACE_CONTAINER, CementationFurnaceScreen::new);
        ScreenManager.registerFactory(FineryForgeRegistryEvents.FINERY_FORGE_CONTAINER, FineryForgeScreen::new);
        ScreenManager.registerFactory(BlastFurnaceRegistryEvents.BLAST_FURNACE_CONTAINER, BlastFurnaceScreen::new);
    }

    @Override
    public World getClientWorld() {
        return Minecraft.getInstance().world;
    }

    @Override
    public PlayerEntity getClientPlayer() {
        return Minecraft.getInstance().player;
    }

}
