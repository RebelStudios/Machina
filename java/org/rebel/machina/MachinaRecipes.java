package org.rebel.machina;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.ShapelessOreRecipe;
import org.rebel.machina.info.ModNames;

/**
 * Created by bmaurer on 6/17/2014.
 */
public class MachinaRecipes {

    public static void addBlendRecipes() {
        GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ModItems.itemBlend, 5, 1), new Object[] {"dustCopper", "dustCopper", "dustCopper", "dustCopper", "dustTin"}));
    }

    public static void addMetalBlockRecipes() {
        for (int i = 0; i < ModNames.blockMetalNames.length; i++) {
            GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ModBlocks.blockMetal, 1, i), new Object[] {ModNames.itemIngotStrings[i], ModNames.itemIngotStrings[i],ModNames.itemIngotStrings[i],ModNames.itemIngotStrings[i],ModNames.itemIngotStrings[i],ModNames.itemIngotStrings[i], ModNames.itemIngotStrings[i], ModNames.itemIngotStrings[i], ModNames.itemIngotStrings[i]}));
        }
    }

}
