package org.rebel.machina;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;
import org.rebel.machina.blocks.*;
import org.rebel.machina.info.ModNames;
import org.rebel.machina.items.ItemBlockBlastFurnacePart;
import org.rebel.machina.items.ItemBlockMetal;
import org.rebel.machina.items.ItemBlockOre;
import org.rebel.machina.util.MachinaLog;

/**
 * Created by XVicarious on 6/16/2014.
 */
public class ModBlocks {

    public static Block machineWall;
    public static Block machineCrusherCore;
    public static Block machineCrusher;
    public static Block blockManualCrusher;
    public static Block blockOre;
    public static Block blockMetal;
    public static Block blockBFParts;
    //public static Block blockBlastController;
    //public static Block blockToughBrick;

    private static void makeBlocks() {
        machineWall = new BlockMachineWall().setBlockName("machina.machineWall").setBlockTextureName(Machina.MODID+":machineWall_0").setCreativeTab(Machina.machinaTab);
        machineCrusher = new BlockCrusher().setBlockName("machina.machineCrusher").setCreativeTab(Machina.machinaTab);
        machineCrusherCore = new BlockCrusherCore().setBlockName("machina.machineCrusherCore").setBlockTextureName(Machina.MODID + ":machineCrusherCore").setCreativeTab(Machina.machinaTab);
        blockManualCrusher = new BlockManualCrusher().setBlockName("machina.blockManualCrusher").setCreativeTab(Machina.machinaTab);
        blockManualCrusher.slipperiness = 69.0f;
        blockOre = new BlockOre().setBlockName("machina.blockOre").setCreativeTab(Machina.machinaTab);
        blockMetal = new BlockMetal().setBlockName("machina.blockMetal").setCreativeTab(Machina.machinaTab);
        blockBFParts = new BlockBlastFurnacePart().setBlockName("machina.blockBFPart").setCreativeTab(Machina.machinaTab);
        //blockBlastController = new BlockBlastController().setBlockName("machina.blockBlastController").setCreativeTab(Machina.machinaTab).setBlockTextureName(Machina.MODID + ":blockBlastController");
        //blockToughBrick = new BlockToughBrick().setBlockName("machina.blockToughBrick").setCreativeTab(Machina.machinaTab).setBlockTextureName(Machina.MODID + ":blockToughBrick");
    }

    private static void oreRegister() {
        for (int i = 0; i < ModNames.blockOreNames.length; i++) {
            OreDictionary.registerOre(ModNames.blockOreNames[i], new ItemStack(blockOre, 1, i));
        }
        MachinaLog.info("Registered: Ores");
        for (int i = 0; i < ModNames.blockMetalNames.length; i++) {
            OreDictionary.registerOre(ModNames.blockMetalNames[i], new ItemStack(blockMetal, 1, i));
        }
        MachinaLog.info("Registered: Metal Blocks");
    }

    public static void registerBlocks() {
        makeBlocks();
        GameRegistry.registerBlock(machineWall, "machina.machineWall");
        GameRegistry.registerBlock(machineCrusher,"machina.machineCrusher");
        GameRegistry.registerBlock(machineCrusherCore,"machina.machineCrusherCore");
        GameRegistry.registerBlock(blockManualCrusher,"machina.blockManualCrusher");
        GameRegistry.registerBlock(blockOre, ItemBlockOre.class,"machina.blockOre");
        GameRegistry.registerBlock(blockMetal, ItemBlockMetal.class, "machina.blockMetal");
        GameRegistry.registerBlock(blockBFParts, ItemBlockBlastFurnacePart.class, "machina.blockBFPart");
        //GameRegistry.registerBlock(blockBlastController, "machina.blockBlastController");
        //GameRegistry.registerBlock(blockToughBrick, "machina.blockToughBrick");
        oreRegister();
    }

}
