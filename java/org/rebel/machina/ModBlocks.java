package org.rebel.machina;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import org.rebel.machina.common.blocks.BlockCrusher;
import org.rebel.machina.common.blocks.BlockCrusherCore;
import org.rebel.machina.common.blocks.BlockMachineWall;
import org.rebel.machina.common.blocks.BlockManualCrusher;

/**
 * Created by XVicarious on 6/16/2014.
 */
public class ModBlocks {

    public static Block machineWall;
    public static Block machineCrusherCore;
    public static Block machineCrusher;
    public static Block blockManualCrusher;

    private static void makeBlocks() {
        machineWall = new BlockMachineWall().setBlockName("machina.machineWall").setBlockTextureName(Machina.MODID+":machineWall_0").setCreativeTab(Machina.machinaTab);
        machineCrusher = new BlockCrusher().setBlockName("machina.machineCrusher").setCreativeTab(Machina.machinaTab);
        machineCrusherCore = new BlockCrusherCore().setBlockName("machina.machineCrusherCore").setBlockTextureName(Machina.MODID + ":machineCrusherCore").setCreativeTab(Machina.machinaTab);
        blockManualCrusher = new BlockManualCrusher().setBlockName("machina.blockManualCrusher").setCreativeTab(Machina.machinaTab);
}

    public static void registerBlocks() {
        makeBlocks();
        GameRegistry.registerBlock(machineWall, "machina.machineWall");
        GameRegistry.registerBlock(machineCrusher,"machina.machineCrusher");
        GameRegistry.registerBlock(machineCrusherCore,"machina.machineCrusherCore");
        GameRegistry.registerBlock(blockManualCrusher,"machina.blockManualCrusher");
    }

}
