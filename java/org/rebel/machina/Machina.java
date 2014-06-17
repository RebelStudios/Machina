package org.rebel.machina;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.item.Item;

@Mod(modid = Machina.MODID, version = Machina.VERSION)
public class Machina
{
    public static final String MODID = "Machina";
    public static final String VERSION = "0.1";

    public static Block machineWall;
    public static Block machineCrusherCore;
    public static Block machineCrusher;

    public static Item itemIngot;
    public static Item itemBlend;
    public static Item itemDust;
    public static Item itemNugget;

    @EventHandler
    public void init(FMLInitializationEvent event) {
        machineWall = new MachineWall().setBlockName("machina.machineWall").setBlockTextureName(Machina.MODID+":machineWall_0");
        machineCrusher = new BlockCrusher().setBlockName("machina.machineCrusher");
        machineCrusherCore = new BlockCrusherCore().setBlockName("machina.machineCrusherCore").setBlockTextureName(Machina.MODID + ":machineCrusherCore");
        itemIngot = new ItemIngot();
        itemBlend = new ItemBlend();
        itemDust = new ItemDust();
        itemNugget = new ItemNugget();
        GameRegistry.registerItem(itemIngot,"machina.ingot");
        GameRegistry.registerItem(itemBlend,"machina.blend");
        GameRegistry.registerItem(itemDust,"machina.dust");
        GameRegistry.registerItem(itemNugget,"machina.nugget");
        GameRegistry.registerBlock(machineWall, "machina.machineWall");
        GameRegistry.registerBlock(machineCrusher,"machina.machineCrusher");
        GameRegistry.registerBlock(machineCrusherCore,"machina.machineCrusherCore");
    }
}
