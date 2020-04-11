package com.infamous.hard_steel.recipes;

import com.infamous.hard_steel.HardSteel;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.crafting.conditions.ICondition;
import com.infamous.hard_steel.config.GeneralModConfig;

public class BronzeAgeCondition implements ICondition {
    public static final ResourceLocation NAME = new ResourceLocation(HardSteel.modid, "bronzeagecondition");
    public boolean bronzeage;

    public BronzeAgeCondition(Boolean value) {
        this.bronzeage = value;
    }

    @Override
    public ResourceLocation getID() {
        return NAME;
    }

    @Override
    public boolean test() {
        if(GeneralModConfig.ENABLE_BRONZE_AGE.get() && this.bronzeage) {
            return true;
        } else if(!GeneralModConfig.ENABLE_BRONZE_AGE.get() && !this.bronzeage) {
            return true;
        } else return false;
    }

    @Override
    public String toString() {
        return "bronzeagecondition";
    }

}