package org.rebel.machina;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;
import org.rebel.machina.info.ModNames;
import org.rebel.machina.items.ItemBlend;
import org.rebel.machina.items.ItemDust;
import org.rebel.machina.items.ItemIngot;
import org.rebel.machina.items.ItemNugget;
import org.rebel.machina.util.MachinaLog;

/**
 * Created by XVicarious on 6/16/2014.
 */
public class ModItems {

    public static Item itemIngot;
    public static Item itemBlend;
    public static Item itemDust;
    public static Item itemNugget;

    private static void makeItems() {
        itemIngot = new ItemIngot().setCreativeTab(Machina.machinaTab);
        itemBlend = new ItemBlend().setCreativeTab(Machina.machinaTab);
        itemDust = new ItemDust().setCreativeTab(Machina.machinaTab);
        itemNugget = new ItemNugget().setCreativeTab(Machina.machinaTab);
    }

    private static void oreRegister() {
        for (int i = 0; i < ModNames.itemIngotStrings.length; i++) {
            OreDictionary.registerOre(ModNames.itemIngotStrings[i], new ItemStack(itemIngot, 1, i));
        }
        MachinaLog.info("Registered: Ingots");
        for (int i = 0; i < ModNames.itemNuggetStrings.length; i++) {
            OreDictionary.registerOre(ModNames.itemNuggetStrings[i], new ItemStack(itemNugget, 1, i));
        }
        MachinaLog.info("Registered: Nuggets");
        for (int i = 0; i < ModNames.itemDustStrings.length; i++) {
            OreDictionary.registerOre(ModNames.itemDustStrings[i], new ItemStack(itemDust, 1, i));
        }
        MachinaLog.info("Registered: Dusts");
    }

    public static void registerItems() {
        makeItems();
        GameRegistry.registerItem(itemIngot, "machina.ingot");
        GameRegistry.registerItem(itemBlend,"machina.blend");
        GameRegistry.registerItem(itemDust,"machina.dust");
        GameRegistry.registerItem(itemNugget,"machina.nugget");
        oreRegister();
    }

}
