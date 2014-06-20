package org.rebel.machina.recipe;

import javafx.util.Pair;
import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import org.rebel.machina.ModItems;
import org.rebel.machina.info.ModNames;
import org.rebel.machina.util.LogHelper;

import java.util.ArrayList;

/**
 * Created by XVicarious on 6/19/2014.
 */
public class RecipeLists {

    public static ArrayList<ManualCrusherRecipe> mcRecipes;

    public static void makeRecipes() {
        mcRecipes = new ArrayList<ManualCrusherRecipe>();
        //mcRecipes[0] = new ManualCrusherRecipe(Blocks.iron_ore, 6, new Pair<ItemStack, Float>(new ItemStack(ModItems.itemDust, 1, 15), 1.0f), new Pair<ItemStack, Float>(new ItemStack(ModItems.itemDust, 1, 15), 0.9f));
        for (int i = 0; i < ModNames.blockOreNames.length; i++) {
            ItemStack stack = new ItemStack(ModItems.itemDust, 1, i);
            mcRecipes.add(new ManualCrusherRecipe(ModNames.blockOreNames[i], 6, new Pair<ItemStack, Float>(stack, 1.0f), new Pair<ItemStack, Float>(stack, 0.9f)));
        }
        LogHelper.info(mcRecipes.get(0).blockOreToString());
    }

    public static ManualCrusherRecipe getMCRecipe(Block block) {
       for (ManualCrusherRecipe r : mcRecipes) {
           //if (r.blockOre == block) {
          //     return r;
          // }
       }
        return null;
    }

}
