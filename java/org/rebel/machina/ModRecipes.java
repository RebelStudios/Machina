package org.rebel.machina;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.ShapelessOreRecipe;
import org.rebel.machina.info.ModNames;

/**
 * Created by bmaurer on 6/17/2014.
 */
public class ModRecipes {

    public static void addBlendRecipes() {
        GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ModItems.itemBlend, 2, 0), new Object[] {"dustGold", "dustSilver"}));
        GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ModItems.itemBlend, 5, 1), new Object[] {"dustCopper", "dustCopper", "dustCopper", "dustCopper", "dustTin"}));
        GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ModItems.itemBlend, 3, 2), new Object[] {"dustIron", "dustIron", "dustNickel"}));
        GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ModItems.itemBlend, 5, 3), new Object[] {"dustTin", "dustTin", "dustTin", "dustLead", "dustLead"}));
        GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ModItems.itemBlend, 3, 4), new Object[] {"dustCopper", "dustCopper", "dustZinc"}));
    }

    public static void addSingleIngotRecipes() {
        for (int i = 0; i < ModNames.blockOreNames.length; i++) {
            GameRegistry.addSmelting(new ItemStack(ModBlocks.blockOre, 1, i), new ItemStack(ModItems.itemIngot, 1, i), 0.5f);
        }
        for (int i = 0; i < ModNames.itemIngotStrings.length; i++) {
            GameRegistry.addSmelting(new ItemStack(ModItems.itemDust, 1, i), new ItemStack(ModItems.itemIngot, 1, i), 0.5f);
        }
        for (int i = 0; i < ModNames.itemIngotStrings.length; i++) {
            GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ModItems.itemIngot, 1, i), new Object[] {ModNames.itemNuggetStrings[i],ModNames.itemNuggetStrings[i],ModNames.itemNuggetStrings[i],ModNames.itemNuggetStrings[i],ModNames.itemNuggetStrings[i],ModNames.itemNuggetStrings[i],ModNames.itemNuggetStrings[i],ModNames.itemNuggetStrings[i],ModNames.itemNuggetStrings[i],}));
        }
        GameRegistry.addSmelting(new ItemStack(ModItems.itemDust, 1, ModNames.itemDustStrings.length-1), new ItemStack(Items.iron_ingot), 0.5f);
        GameRegistry.addSmelting(new ItemStack(ModItems.itemDust, 1, ModNames.itemDustStrings.length-2), new ItemStack(Items.gold_ingot), 0.5f);
    }

    public static void addNuggetRecipes() {
        for (int i = 0; i < ModNames.itemIngotStrings.length; i++) {
            GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ModItems.itemNugget, 9, i), ModNames.itemIngotStrings[i]));
        }
    }

    public static void addMetalBlockRecipes() {
        for (int i = 0; i < ModNames.blockMetalNames.length; i++) {
            GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ModBlocks.blockMetal, 1, i), new Object[] {ModNames.itemIngotStrings[i], ModNames.itemIngotStrings[i],ModNames.itemIngotStrings[i],ModNames.itemIngotStrings[i],ModNames.itemIngotStrings[i],ModNames.itemIngotStrings[i], ModNames.itemIngotStrings[i], ModNames.itemIngotStrings[i], ModNames.itemIngotStrings[i]}));
        }
    }

}
