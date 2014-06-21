package org.rebel.machina.util;

import net.minecraft.item.ItemStack;

import java.util.Random;

/**
 * Created by XVicarious on 6/20/2014.
 */
public class Util {

    /**
     * Check if event will happen
     * @param chance the chance said event will happen (1.0f being always, 0.0f being never)
     * @return event happens
     */
    public static boolean checkChance(float chance) {
        float c = new Random().nextFloat();
        return c < chance;
    }

    public static boolean isOreEqual(ItemStack lhs, ItemStack rhs) {
        if (lhs.getItem() == rhs.getItem()) {
            if (lhs.getItemDamage() == rhs.getItemDamage()) {
                return true;
            }
        }
        return false;
    }

}
