package org.rebel.machina;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.ShapedOreRecipe;
import net.minecraftforge.oredict.ShapelessOreRecipe;

/**
 * Created by bmaurer on 6/17/2014.
 */
public class MachinaRecipes {

    public static void addBlendRecipes() {
        GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ModItems.itemBlend, 5, 0), new Object[] {"dustCopper", "dustCopper", "dustCopper", "dustCopper", "dustTin"}));
    }

}
