package org.rebel.machina.recipe;

import javafx.util.Pair;
import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;
import org.rebel.machina.util.MachinaUtil;

import java.util.ArrayList;

/**
 * @author XVicarious
 */
public class ManualCrusherRecipe {

    public ArrayList<ItemStack> blockOre;
    public Pair<Integer, Integer> jumpsToCrush;
    public Pair<ItemStack, Float>[] outputs;

    /**
     * Adds a new Manual Crusher Recipe
     *
     * @param ore          The ore or any block to crush
     * @param jumpsToCrush How many times you have to jump on the crusher to crush the block
     * @param outputs      ItemStack (what is given from crushing the ore) Integer (the % chance you will get that output)
     */
    public ManualCrusherRecipe(Object ore, Pair<Integer, Integer> jumpsToCrush, Pair<ItemStack, Float>... outputs) {
        this.blockOre = new ArrayList<ItemStack>();
        if (ore instanceof Block) {
            this.blockOre.add(new ItemStack((Block) ore, 1, 0));
        } else if (ore instanceof String) {
            for (ItemStack i : OreDictionary.getOres((String) ore)) {
                this.blockOre.add(i);
            }
        } else if (ore instanceof ItemStack) {
            this.blockOre.add((ItemStack) ore);
        }
        this.jumpsToCrush = jumpsToCrush;
        this.outputs = outputs;
    }

    public boolean isValidOre(Block input, int metadata) {
        ItemStack compareTo = new ItemStack(input, 1, metadata);
        for (ItemStack i : this.blockOre) {
            if (MachinaUtil.isItemEqual(compareTo, i)) {
                return true;
            }
        }
        return false;
    }

}