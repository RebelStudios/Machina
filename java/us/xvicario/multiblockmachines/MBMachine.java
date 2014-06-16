package us.xvicario.multiblockmachines;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Items;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

@Mod(modid = MBMachine.MODID, version = MBMachine.VERSION)
public class MBMachine
{
    public static final String MODID = "mbm-xvicarious";
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
        machineWall = new MachineWall().setBlockName("mbm.machineWall").setBlockTextureName(MBMachine.MODID+":machineWall_0");
        machineCrusher = new BlockCrusher().setBlockName("mbm.machineCrusher");
        machineCrusherCore = new BlockCrusherCore().setBlockName("mbm.machineCrusherCore").setBlockTextureName(MBMachine.MODID + ":machineCrusherCore");
        itemIngot = new ItemIngot();
        itemBlend = new ItemBlend();
        itemDust = new ItemDust();
        itemNugget = new ItemNugget();
        GameRegistry.registerItem(itemIngot,"mbm.ingot");
        GameRegistry.registerItem(itemBlend,"mbm.blend");
        GameRegistry.registerItem(itemDust,"mbm.dust");
        GameRegistry.registerItem(itemNugget,"mbm.nugget");
        GameRegistry.registerBlock(machineWall, "mbm.machineWall");
        GameRegistry.registerBlock(machineCrusher,"mbm.machineCrusher");
        GameRegistry.registerBlock(machineCrusherCore,"mbm.machineCrusherCore");
    }
}
