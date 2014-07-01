package org.rebel.machina.recipe;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.ShapelessOreRecipe;
import org.rebel.machina.MachinaBlocks;
import org.rebel.machina.MachinaItems;
import org.rebel.machina.info.MachinaNames;

/**
 * Created by bmaurer on 6/17/2014.
 */
public class ModRecipes {

    public static void addBlendRecipes() {
        GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(MachinaItems.itemBlend, 2, 0), new Object[]{"dustGold", "dustSilver"}));
        GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(MachinaItems.itemBlend, 5, 1), new Object[]{"dustCopper", "dustCopper", "dustCopper", "dustCopper", "dustTin"}));
        GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(MachinaItems.itemBlend, 3, 2), new Object[]{"dustIron", "dustIron", "dustNickel"}));
        GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(MachinaItems.itemBlend, 5, 3), new Object[]{"dustTin", "dustTin", "dustTin", "dustLead", "dustLead"}));
        GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(MachinaItems.itemBlend, 3, 4), new Object[]{"dustCopper", "dustCopper", "dustZinc"}));
    }

    public static void addSingleIngotRecipes() {
        for (int i = 0; i < MachinaNames.blockOreNames.length; i++) {
            GameRegistry.addSmelting(new ItemStack(MachinaBlocks.blockOre, 1, i), new ItemStack(MachinaItems.itemIngot, 1, i), 0.5f);
        }
        for (int i = 0; i < MachinaNames.itemIngotStrings.length; i++) {
            GameRegistry.addSmelting(new ItemStack(MachinaItems.itemDust, 1, i), new ItemStack(MachinaItems.itemIngot, 1, i), 0.5f);
        }
        for (int i = 0; i < MachinaNames.itemIngotStrings.length; i++) {
            GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(MachinaItems.itemIngot, 1, i), new Object[]{MachinaNames.itemNuggetStrings[i], MachinaNames.itemNuggetStrings[i], MachinaNames.itemNuggetStrings[i], MachinaNames.itemNuggetStrings[i], MachinaNames.itemNuggetStrings[i], MachinaNames.itemNuggetStrings[i], MachinaNames.itemNuggetStrings[i], MachinaNames.itemNuggetStrings[i], MachinaNames.itemNuggetStrings[i],}));
        }
        GameRegistry.addSmelting(new ItemStack(MachinaItems.itemDust, 1, MachinaNames.itemDustStrings.length - 1), new ItemStack(Items.iron_ingot), 0.5f);
        GameRegistry.addSmelting(new ItemStack(MachinaItems.itemDust, 1, MachinaNames.itemDustStrings.length - 2), new ItemStack(Items.gold_ingot), 0.5f);
        /* Blends */
        GameRegistry.addSmelting(new ItemStack(MachinaItems.itemBlend, 1, 0), new ItemStack(MachinaItems.itemIngot, 1, java.util.Arrays.asList(MachinaNames.itemIngotStrings).indexOf("ingotElectrum")), 0.5f);
        GameRegistry.addSmelting(new ItemStack(MachinaItems.itemBlend, 1, 1), new ItemStack(MachinaItems.itemIngot, 1, java.util.Arrays.asList(MachinaNames.itemIngotStrings).indexOf("ingotBronze")), 0.5f);
        GameRegistry.addSmelting(new ItemStack(MachinaItems.itemBlend, 1, 2), new ItemStack(MachinaItems.itemIngot, 1, java.util.Arrays.asList(MachinaNames.itemIngotStrings).indexOf("ingotInvar")), 0.5f);
        GameRegistry.addSmelting(new ItemStack(MachinaItems.itemBlend, 1, 3), new ItemStack(MachinaItems.itemIngot, 1, java.util.Arrays.asList(MachinaNames.itemIngotStrings).indexOf("ingotSolder")), 0.5f);
        GameRegistry.addSmelting(new ItemStack(MachinaItems.itemBlend, 1, 4), new ItemStack(MachinaItems.itemIngot, 1, java.util.Arrays.asList(MachinaNames.itemIngotStrings).indexOf("ingotBrass")), 0.5f);
    }

    public static void addNuggetRecipes() {
        for (int i = 0; i < MachinaNames.itemIngotStrings.length; i++) {
            GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(MachinaItems.itemNugget, 9, i), MachinaNames.itemIngotStrings[i]));
        }
    }

    public static void addMetalBlockRecipes() {
        for (int i = 0; i < MachinaNames.blockMetalNames.length; i++) {
            GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(MachinaBlocks.blockMetal, 1, i), new Object[]{MachinaNames.itemIngotStrings[i], MachinaNames.itemIngotStrings[i], MachinaNames.itemIngotStrings[i], MachinaNames.itemIngotStrings[i], MachinaNames.itemIngotStrings[i], MachinaNames.itemIngotStrings[i], MachinaNames.itemIngotStrings[i], MachinaNames.itemIngotStrings[i], MachinaNames.itemIngotStrings[i]}));
        }
    }

}
