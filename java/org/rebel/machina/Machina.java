package org.rebel.machina;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import org.rebel.machina.common.blocks.BlockCrusher;
import org.rebel.machina.common.blocks.BlockCrusherCore;
import org.rebel.machina.common.blocks.BlockMachineWall;
import org.rebel.machina.common.items.ItemBlend;
import org.rebel.machina.common.items.ItemDust;
import org.rebel.machina.common.items.ItemIngot;
import org.rebel.machina.common.items.ItemNugget;

@Mod(modid = Machina.MODID, version = Machina.VERSION)
public class Machina
{
    public static final String MODID = "Machina";
    public static final String VERSION = "0.1";


    @EventHandler
    public void init(FMLInitializationEvent event) {
        ModBlocks.registerBlocks();
        ModItems.registerItems();
    }
}
