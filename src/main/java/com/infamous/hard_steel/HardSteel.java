package com.infamous.hard_steel;

import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import com.infamous.hard_steel.anvil.AnvilRegistryEvents;
import com.infamous.hard_steel.blast_furnace.BlastFurnaceRegistryEvents;
import com.infamous.hard_steel.capabilities.*;
import com.infamous.hard_steel.events.LeatherDrops;
import com.infamous.hard_steel.events.MobEquipEvent;
import com.infamous.hard_steel.group.GroupHardSteel;
import com.infamous.hard_steel.config.HardSteelConfig;
import com.infamous.hard_steel.proxy.ClientProxy;
import com.infamous.hard_steel.proxy.IProxy;
import com.infamous.hard_steel.proxy.ServerProxy;
import com.infamous.hard_steel.smithingtable.Message;
import com.infamous.hard_steel.smithingtable.SmithingTableRegistryEvents;
import com.infamous.hard_steel.util.BlockStateUtilities;
import com.infamous.hard_steel.world.AnvilReplacement;
import com.infamous.hard_steel.world.BlastFurnaceReplacement;
import com.infamous.hard_steel.world.OreGenerator;
import com.infamous.hard_steel.world.SmithingTableReplacement;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.Entity;
import net.minecraft.entity.monster.*;
import net.minecraft.util.ResourceLocation;
import net.minecraft.village.PointOfInterestType;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraft.world.gen.placement.IPlacementConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.ObfuscationReflectionHelper;
import net.minecraftforge.registries.ForgeRegistries;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.minecraft.block.Block;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.InterModComms;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.event.lifecycle.InterModProcessEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.loading.FMLPaths;

@Mod("hard_steel")
public class HardSteel
{

    private static HardSteel instance;
	public static final String modid = "hard_steel";
    public static IProxy proxy = DistExecutor.runForDist(() -> () -> new ClientProxy(), () -> () -> new ServerProxy());
	public static final Logger logger = LogManager.getLogger(modid);	
	public static final ItemGroup hard_steel = new GroupHardSteel();

    public HardSteel()
    {
        instance = this;
    	ModLoadingContext.get().registerConfig(ModConfig.Type.SERVER, HardSteelConfig.SERVER_CONFIG);

		HardSteelConfig.loadConfig(HardSteelConfig.SERVER_CONFIG, FMLPaths.CONFIGDIR.get().resolve("hard_steel-general.toml"));

        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::enqueueIMC);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::processIMC);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::doClientStuff);

        MinecraftForge.EVENT_BUS.register(this);
        MinecraftForge.EVENT_BUS.register(new LeatherDrops());
        MinecraftForge.EVENT_BUS.register(new CapabilityHandler());
        MinecraftForge.EVENT_BUS.register(new MobEquipEvent());
    }

    public static HardSteel getInstance()
    {
        return instance;
    }

    private void setup(final FMLCommonSetupEvent event)
    {
    	OreGenerator.setupOregen();

        CapabilityManager.INSTANCE.register(IReArmer.class, new ReArmerStorage(), ReArmer::new);

        ConfiguredFeature<?> smithingTableReplacement = Biome.createDecoratedFeature(new SmithingTableReplacement(NoFeatureConfig::deserialize), IFeatureConfig.NO_FEATURE_CONFIG, Placement.NOPE , IPlacementConfig.NO_PLACEMENT_CONFIG);
        ForgeRegistries.BIOMES.forEach(biome -> biome.addFeature(GenerationStage.Decoration.TOP_LAYER_MODIFICATION, smithingTableReplacement));

        ConfiguredFeature<?> anvilReplacement = Biome.createDecoratedFeature(new AnvilReplacement(NoFeatureConfig::deserialize), IFeatureConfig.NO_FEATURE_CONFIG, Placement.NOPE , IPlacementConfig.NO_PLACEMENT_CONFIG);
        ForgeRegistries.BIOMES.forEach(biome -> biome.addFeature(GenerationStage.Decoration.TOP_LAYER_MODIFICATION, anvilReplacement));

        ConfiguredFeature<?> blastFurnaceReplacement = Biome.createDecoratedFeature(new BlastFurnaceReplacement(NoFeatureConfig::deserialize), IFeatureConfig.NO_FEATURE_CONFIG, Placement.NOPE , IPlacementConfig.NO_PLACEMENT_CONFIG);
        ForgeRegistries.BIOMES.forEach(biome -> biome.addFeature(GenerationStage.Decoration.TOP_LAYER_MODIFICATION, blastFurnaceReplacement));

        Set<BlockState> smithingTableBlockStates = BlockStateUtilities.getAllStates(SmithingTableRegistryEvents.SMITHING_TABLE);
        Set<BlockState> blastFurnaceBlockStates = BlockStateUtilities.getAllStates(BlastFurnaceRegistryEvents.BLAST_FURNACE);


        Map<BlockState, PointOfInterestType> types = ObfuscationReflectionHelper.getPrivateValue(PointOfInterestType.class, null, "field_221073_u");

        if(types == null) return;

        for(BlockState blockState : smithingTableBlockStates){
            types.put(blockState, PointOfInterestType.TOOLSMITH);
        }
        for(BlockState blockState : blastFurnaceBlockStates){
            types.put(blockState, PointOfInterestType.ARMORER);
        }
        //HardSteel.logger.info("Types are: " + types.toString());

        // smithing table
        Message.registerMessages(HardSteel.modid);
        // anvil
        //com.infamous.hard_steel.anvil.Message.registerMessages(HardSteel.modid);

        proxy.init();
    	
        logger.info("Mod preinit");
    }



    private void doClientStuff(final FMLClientSetupEvent event)
    {

    	logger.info("Got game settings {}", event.getMinecraftSupplier().get().gameSettings);
    }

    private void enqueueIMC(final InterModEnqueueEvent event)
    {

        InterModComms.sendTo("hard_steel", "helloworld", () -> { logger.info("Hello world from Hard Steel"); return "Hello world";});
    }

    private void processIMC(final InterModProcessEvent event)
    {

    	logger.info("Got IMC {}", event.getIMCStream().
                map(m->m.getMessageSupplier().get()).
                collect(Collectors.toList()));
    }

    @SubscribeEvent
    public void onServerStarting(FMLServerStartingEvent event)
    {

    	logger.info("Server starting");
    }
}
