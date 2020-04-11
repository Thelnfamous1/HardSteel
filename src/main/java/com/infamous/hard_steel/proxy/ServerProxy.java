package com.infamous.hard_steel.proxy;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;

public class ServerProxy implements IProxy {

    public ServerProxy() {
    }

    @Override
    public void init() {
    }

    @Override
    public World getClientWorld() {
        throw new IllegalStateException("Trying to call getClientWorld on server...");
    }

    @Override
    public PlayerEntity getClientPlayer() {
        throw new IllegalStateException("Trying to call getClientPlayer on server...");
    }

}
