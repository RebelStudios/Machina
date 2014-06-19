package org.rebel.machina.recipe;

import javafx.util.Pair;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import org.rebel.machina.ModItems;
import org.rebel.machina.info.ModNames;
import org.rebel.machina.util.LogHelper;

/**
 * Created by XVicarious on 6/19/2014.
 */
public class RecipeLists {

    public static MCRecipe[] mcRecipes;

    public static void makeRecipes() {
        mcRecipes = new MCRecipe[ModNames.itemDustStrings.length-ModNames.itemBlendStrings.length-2];
        //mcRecipes[0] = new MCRecipe(Blocks.iron_ore, 6, new Pair<ItemStack, Float>(new ItemStack(ModItems.itemDust, 1, 15), 1.0f), new Pair<ItemStack, Float>(new ItemStack(ModItems.itemDust, 1, 15), 0.9f));
        for (int i = 0; i < mcRecipes.length; i++) {
            mcRecipes[i] = new MCRecipe(ModNames.blockOreNames[i], 6, new Pair<ItemStack, Float>(new ItemStack(ModItems.itemDust, 1, i), 1.0f), new Pair<ItemStack, Float>(new ItemStack(ModItems.itemDust, 1, i), 0.9f));
            LogHelper.info("adding::" + ModNames.blockOreNames[i] + ", with " + new ItemStack(ModItems.itemDust,1,i).getUnlocalizedName());
        }
    }

    public static MCRecipe getMCRecipe(Block block) {
       for (MCRecipe r : mcRecipes) {
           //if (r.blockOre == block) {
          //     return r;
          // }
       }
        return null;
    }

}
