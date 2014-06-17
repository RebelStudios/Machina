package org.rebel.machina;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;
import org.rebel.machina.common.items.ItemBlend;
import org.rebel.machina.common.items.ItemDust;
import org.rebel.machina.common.items.ItemIngot;
import org.rebel.machina.common.items.ItemNugget;

/**
 * Created by XVicarious on 6/16/2014.
 */
public class ModItems {

    public static Item itemIngot;
    public static Item itemBlend;
    public static Item itemDust;
    public static Item itemNugget;

    private static void makeItems() {
        itemIngot = new ItemIngot();
        itemBlend = new ItemBlend();
        itemDust = new ItemDust();
        itemNugget = new ItemNugget();
    }

    public static void registerItems() {
        makeItems();
        GameRegistry.registerItem(itemIngot, "machina.ingot");
        GameRegistry.registerItem(itemBlend,"machina.blend");
        GameRegistry.registerItem(itemDust,"machina.dust");
        GameRegistry.registerItem(itemNugget,"machina.nugget");
    }

}
