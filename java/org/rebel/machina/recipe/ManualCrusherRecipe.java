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
public class ManualCrusherRecipe {

    public ArrayList<ItemStack> blockOre;
    private String blockOreString;
    public int jumpsToCrush;
    public Pair<ItemStack,Float>[] outputs;

    /**
     * Adds a new Manual Crusher Recipe
     * @param ore The ore or any block to crush
     * @param jumpsToCrush How many times you have to jump on the crusher to crush the block
     * @param outputs ItemStack (what is given from crushing the ore) Integer (the % chance you will get that output)
     */
    public ManualCrusherRecipe(Object ore, int jumpsToCrush, Pair<ItemStack, Float>... outputs) {
        blockOre = new ArrayList<ItemStack>();
        if (ore instanceof Block) {
            blockOre.add(new ItemStack((Block)ore, 1, 0));  // Bad Practice... Will remove.  Doesn't give any metadata
        } else if (ore instanceof String) {
            blockOreString = (String)ore;
            for (ItemStack i : OreDictionary.getOres((String)ore)) {
                blockOre.add(i);
            }
        }
        this.jumpsToCrush = jumpsToCrush;
        this.outputs = outputs;
    }

    public boolean isValidOre(Block input, int metadata) {
        return false;
    }

}