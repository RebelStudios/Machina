package org.rebel.machina.recipe;

import javafx.util.Pair;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import org.rebel.machina.ModItems;

/**
 * Created by XVicarious on 6/19/2014.
 */
public class RecipeLists {

    public static MCRecipe[] mcRecipes;

    public static void makeRecipes() {
        mcRecipes = new MCRecipe[1];
        mcRecipes[0] = new MCRecipe(Blocks.iron_ore, 6, new Pair<ItemStack, Float>(new ItemStack(ModItems.itemDust, 1, 15), 1.0f), new Pair<ItemStack, Float>(new ItemStack(ModItems.itemDust, 1, 15), 0.9f));
    }

}
