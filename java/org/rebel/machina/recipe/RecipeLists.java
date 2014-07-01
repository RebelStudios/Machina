package org.rebel.machina.recipe;

import javafx.util.Pair;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
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
        for (int i = 0; i < MachinaNames.blockOreNames.length; i++) {
            ItemStack stack = new ItemStack(MachinaItems.itemDust, 1, i);
            mcRecipes.add(new ManualCrusherRecipe(MachinaNames.blockOreNames[i], new Pair<Integer, Integer>(20, 30), new Pair<ItemStack, Float>(stack, 1.0f), new Pair<ItemStack, Float>(stack, 0.9f)));
        }
        mcRecipes.add(new ManualCrusherRecipe(Blocks.gold_ore, new Pair<Integer, Integer>(20, 30), new Pair<ItemStack, Float>(new ItemStack(MachinaItems.itemDust, 2, 14), 1.0f)));
        mcRecipes.add(new ManualCrusherRecipe(Blocks.redstone_ore, new Pair<Integer, Integer>(20, 30), new Pair<ItemStack, Float>(new ItemStack(Items.redstone, 8), 1.0f)));
    }

    public static ManualCrusherRecipe getMCRecipe(Block block, int metadata) {
        for (ManualCrusherRecipe r : RecipeLists.mcRecipes) {
            if (r != null && r.isValidOre(block, metadata)) {
                return r;
            }
        }
        return null;
    }

}
