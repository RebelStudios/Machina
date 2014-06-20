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
        this.blockOre = new ArrayList<ItemStack>();
        if (ore instanceof Block) {
            this.blockOre.add(new ItemStack((Block)ore, 1, 0));  // Bad Practice... Will remove.  Doesn't give any metadata
        } else if (ore instanceof String) {
            this.blockOreString = (String)ore;
            for (ItemStack i : OreDictionary.getOres((String)ore)) {
                this.blockOre.add(i);
            }
        }
        this.jumpsToCrush = jumpsToCrush;
        this.outputs = outputs;
    }

    public boolean isValidOre(Block input, int metadata) {
        LogHelper.info(blockOreToString());
        ItemStack compareTo = new ItemStack(input, 1, metadata);
        for (ItemStack i : this.blockOre) {
            //LogHelper.info(i.toString() + " == " + compareTo.toString());
            if (isOreEqual(compareTo, i)) {
                //LogHelper.info("!");
                return true;
            }
        }
        //LogHelper.info(":(");
        return false;
    }

    public String blockOreToString() {
        String s = "[";
        for (ItemStack i : this.blockOre) {
            s += i.toString();
            s += ", ";
        }
        s += "]";
        return s;
    }

    private boolean isOreEqual(ItemStack lhs, ItemStack rhs) {
        if (lhs.getItem() == rhs.getItem()) {
            if (lhs.getItemDamage() == rhs.getItemDamage()) {
                return true;
            }
        }
        return false;
    }

}