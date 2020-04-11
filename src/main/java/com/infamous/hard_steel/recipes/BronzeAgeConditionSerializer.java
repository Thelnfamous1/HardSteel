package com.infamous.hard_steel.recipes;

import com.google.gson.JsonObject;

import net.minecraft.util.JSONUtils;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.crafting.conditions.IConditionSerializer;

public class BronzeAgeConditionSerializer implements IConditionSerializer<BronzeAgeCondition> {

    public BronzeAgeConditionSerializer() {
    }

    @Override
    public void write(JsonObject json, BronzeAgeCondition value) {
        json.addProperty("bronzeage", value.bronzeage);
    }

    @Override
    public BronzeAgeCondition read(JsonObject json) {
        return new BronzeAgeCondition(JSONUtils.getBoolean(json, "bronzeage"));
    }

    @Override
    public ResourceLocation getID() {
        return BronzeAgeCondition.NAME;
    }

}