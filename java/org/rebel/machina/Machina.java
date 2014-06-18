package org.rebel.machina;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import org.rebel.machina.util.LogHelper;

@Mod(modid = Machina.MODID, version = Machina.VERSION, name = Machina.NAME)
public class Machina
{
    public static final String MODID = "Machina";
    public static final String VERSION = "0.1";
    public static final String NAME = "Machina";
    @SidedProxy(clientSide = "org.rebel.machina.MachinaClientProxy", serverSide = "org.rebel.machina.MachinaServerProxy")
    public static MachinaProxy proxy;
    public static final PacketHandler packetPipeline = new PacketHandler();
    public static final CreativeTabs machinaTab = new CreativeTabs("tabMachina") {
        @Override
        public Item getTabIconItem() {
            return Items.beef;
        }
    };

    @EventHandler
    public void init(FMLInitializationEvent event) {
        LogHelper.init();
        ModBlocks.registerBlocks();
        ModItems.registerItems();
        MachinaRecipes.addBlendRecipes();
        MachinaRecipes.addMetalBlockRecipes();
        GameRegistry.registerWorldGenerator(new MachinaOreGeneration(), 0);
    }
}
