package com.infamous.hard_steel.recipes;

import com.infamous.hard_steel.HardSteel;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.crafting.CraftingHelper;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

public class Serializers {

    public static final IRecipeSerializer<DamageItemRecipe> DAMAGE_ITEM_RECIPE = new DamageItemRecipe.Serializer();

    @Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD)
    public static class RegistrySerializers{

        @SubscribeEvent
        public static void register(RegistryEvent.Register<IRecipeSerializer<?>> event) {
            CraftingHelper.register(new BronzeAgeConditionSerializer());
            event.getRegistry().register(
                    DAMAGE_ITEM_RECIPE.setRegistryName(new ResourceLocation(HardSteel.modid, "damage_tools")));
        }

    }

}
