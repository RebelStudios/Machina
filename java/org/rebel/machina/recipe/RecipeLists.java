package org.rebel.machina.recipe;

import javafx.util.Pair;
import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import org.rebel.machina.MachinaItems;
import org.rebel.machina.info.MachinaNames;

import java.util.ArrayList;

/**
 * Created by XVicarious on 6/19/2014.
 */
public class RecipeLists {

    public static ArrayList<ManualCrusherRecipe> mcRecipes;

    public static void makeRecipes() {
        mcRecipes = new ArrayList<ManualCrusherRecipe>();
        //mcRecipes[0] = new ManualCrusherRecipe(Blocks.iron_ore, 6, new Pair<ItemStack, Float>(new ItemStack(MachinaItems.itemDust, 1, 15), 1.0f), new Pair<ItemStack, Float>(new ItemStack(MachinaItems.itemDust, 1, 15), 0.9f));
        for (int i = 0; i < MachinaNames.blockOreNames.length; i++) {
            ItemStack stack = new ItemStack(MachinaItems.itemDust, 1, i);
            mcRecipes.add(new ManualCrusherRecipe(MachinaNames.blockOreNames[i], new Pair<Integer, Integer>(10, 15), new Pair<ItemStack, Float>(stack, 1.0f), new Pair<ItemStack, Float>(stack, 0.9f)));
        }
    }

    public static ManualCrusherRecipe getMCRecipe(Block block, int metadata) {
        for (ManualCrusherRecipe r : RecipeLists.mcRecipes) {
            if  (r != null && r.isValidOre(block, metadata)) {
                return r;
            }
        }
        return null;
    }

}
