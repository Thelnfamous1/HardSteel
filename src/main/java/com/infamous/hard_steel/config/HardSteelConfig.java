package com.infamous.hard_steel.config;

import java.nio.file.Path;

import com.electronwill.nightconfig.core.file.CommentedFileConfig;
import com.electronwill.nightconfig.core.io.WritingMode;

import com.infamous.hard_steel.config.GeneralModConfig;
import net.minecraftforge.common.ForgeConfigSpec;

public class HardSteelConfig
{
    private static final ForgeConfigSpec.Builder SERVER_BUILDER = new ForgeConfigSpec.Builder();

    public static final ForgeConfigSpec SERVER_CONFIG;

    static
    {
        GeneralModConfig.init(SERVER_BUILDER);

        SERVER_CONFIG = SERVER_BUILDER.build();
    }

    public static void loadConfig(ForgeConfigSpec spec, Path path)
    {
        final CommentedFileConfig configData = CommentedFileConfig.builder(path).sync().autosave().writingMode(WritingMode.REPLACE).build();

        configData.load();

        spec.setConfig(configData);
    }
}