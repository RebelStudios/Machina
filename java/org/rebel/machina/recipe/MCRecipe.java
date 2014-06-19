package org.rebel.machina.recipe;

import javafx.util.Pair;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

/**
 * @author XVicarious
 */
public class MCRecipe {

    public Block blockOre;
    public int jumpsToCrush;
    public Pair<ItemStack,Float>[] outputs;

    /**
     * Adds a new Manual Crusher Recipe
     * @param ore The ore or any block to crush
     * @param jumpsToCrush How many times you have to jump on the crusher to crush the block
     * @param outputs ItemStack (what is given from crushing the ore) Integer (the % chance you will get that output)
     */
    public MCRecipe(Block ore, int jumpsToCrush, Pair<ItemStack,Float>... outputs) {
        this.blockOre = ore;
        this.jumpsToCrush = jumpsToCrush;
        this.outputs = outputs;
    }

}