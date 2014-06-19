package org.rebel.machina;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import org.rebel.machina.network.PacketHandler;
import org.rebel.machina.proxy.MachinaProxy;
import org.rebel.machina.recipe.ModRecipes;
import org.rebel.machina.recipe.RecipeLists;
import org.rebel.machina.util.ConfigHandler;
import org.rebel.machina.util.LogHelper;
import org.rebel.machina.worldgen.MachinaOreGeneration;

/**
 * @author XVicarious
 */

@Mod(modid = Machina.MODID, version = Machina.VERSION, name = Machina.NAME)
public class Machina
{
    public static final String MODID = "Machina";
    public static final String VERSION = "0.1";
    public static final String NAME = "Machina";
    @SidedProxy(clientSide = "org.rebel.machina.proxy.MachinaClientProxy", serverSide = "org.rebel.machina.proxy.MachinaServerProxy")
    public static MachinaProxy proxy;
    public static final PacketHandler packetPipeline = new PacketHandler();
    public static final CreativeTabs machinaTab = new CreativeTabs("tabMachina") {
        @Override
        public Item getTabIconItem() {
            return Items.beef;
        }
    };

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        LogHelper.init();
        ConfigHandler.init(event.getSuggestedConfigurationFile());
    }

    @EventHandler
    public void init(FMLInitializationEvent event) {
        ModBlocks.registerBlocks();
        ModItems.registerItems();
        addRecipes();
        GameRegistry.registerWorldGenerator(new MachinaOreGeneration(), 0);
    }

    private void addRecipes() {
        ModRecipes.addBlendRecipes();
        ModRecipes.addMetalBlockRecipes();
        ModRecipes.addSingleIngotRecipes();
        ModRecipes.addNuggetRecipes();
        RecipeLists.makeRecipes();
    }
}
