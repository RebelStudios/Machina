package org.rebel.machina.util;

import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import java.util.Random;

/**
 * Created by XVicarious on 6/20/2014.
 */
public class MachinaUtil {

    /**
     * Check if event will happen
     * @param chance the chance said event will happen (1.0f being always, 0.0f being never)
     * @return event happens
     */
    public static boolean checkChance(float chance) {
        float c = new Random().nextFloat();
        return c < chance;
    }

    /**
     * Checks if both itemstacks contain the same block/item, true if so, false if not
     * @param lhs the first itemstack
     * @param rhs the second itemstack
     * @return true if blocks/items in the itemstack are the same, false if they are not
     */
    public static boolean isItemEqual(ItemStack lhs, ItemStack rhs) {
        if (lhs.getItem() == rhs.getItem()) {
            if (lhs.getItemDamage() == rhs.getItemDamage()) {
                return true;
            }
        }
        return false;
    }

    /**
     * Checks if the block occupying the space is air
     * @param world the world to check in
     * @param x the x coordinate of the block
     * @param y the y coordinate of the block
     * @param z the z coordinate of the block
     * @return If the block is in fact air, true.  If not false
     */
    public static boolean isBlockAir(World world, int x, int y, int z) {
        if (world.getBlock(x, y, z) == Blocks.air) {
            return true;
        }
        return false;
    }

    /**
     * computes a random integer between (and including) two values
     * @param min the least the random integer is allowed to be
     * @param max the highest the random integer is allowed to be
     * @return an integer [min, max]
     */
    public static int randomIntRange(int min, int max) {
        return min + (int)(Math.random() * ((max - min) + 1));
    }

}
