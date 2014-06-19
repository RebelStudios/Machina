package org.rebel.machina.recipe;

import com.sun.javaws.exceptions.InvalidArgumentException;
import javafx.util.Pair;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;
import org.rebel.machina.ModBlocks;
import org.rebel.machina.util.LogHelper;

import java.util.ArrayList;

/**
 * @author XVicarious
 */
public class MCRecipe {

    public ArrayList<Block> blockOre;
    private String blockOreString;
    public int jumpsToCrush;
    public Pair<ItemStack,Float>[] outputs;

    /**
     * Adds a new Manual Crusher Recipe
     * @param ore The ore or any block to crush
     * @param jumpsToCrush How many times you have to jump on the crusher to crush the block
     * @param outputs ItemStack (what is given from crushing the ore) Integer (the % chance you will get that output)
     */
    public MCRecipe(Object ore, int jumpsToCrush, Pair<ItemStack,Float>... outputs) {
        blockOre = new ArrayList<Block>();
        if (ore instanceof Block) {
            blockOre.add((Block)ore);
        } else if (ore instanceof String) {
            blockOreString = (String)ore;
            //blockOre.add(OreDictionary.getOres();
            for (ItemStack i : OreDictionary.getOres((String)ore)) {
                Block tO = Block.getBlockFromItem(i.getItem());
                blockOre.add(tO);
            }
        }
        this.jumpsToCrush = jumpsToCrush;
        this.outputs = outputs;
    }

    public boolean isValidOre(Block input) {
        LogHelper.info("isValidOre");
        if (input == Blocks.air) {
            return false;
        }
        if (blockOre.contains(input)) {
            LogHelper.info("Hey you're good!");
            return true;
        }
        LogHelper.info("Nope :/");
        return false;
    }

}