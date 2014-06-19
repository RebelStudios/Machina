package org.rebel.machina;

import net.minecraftforge.common.config.Configuration;

import java.io.File;

/**
 * Created by XVicarious on 6/18/2014.
 */
public class ConfigHandler {

    public static void init(File configFile) {
        Configuration config = new Configuration(configFile);
        config.load();
        // Set up ore generation values
        MachinaInfo.oreGenerationSize = config.get("OreGeneration","oreGeneration",new int[] {10,9,8,7,6,5,4,3,2}).getIntList();
        MachinaInfo.oreGenerationDepth = config.get("OreGeneration","oreGenerationDepth", new int[] {10,9,8,7,6,5,4,3,2}).getIntList();
        config.save();
    }

}
