package org.rebel.machina;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerAboutToStartEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.network.NetworkManager;
import net.minecraftforge.common.MinecraftForge;
import org.rebel.machina.gui.MachinaGuiHandler;
import org.rebel.machina.multiblock.helper.MultiblockEventHandler;
import org.rebel.machina.network.MessageManualCrusher;
import org.rebel.machina.proxy.IMachinaProxy;
import org.rebel.machina.proxy.MachinaServerProxy;
import org.rebel.machina.recipe.ModRecipes;
import org.rebel.machina.recipe.RecipeLists;
import org.rebel.machina.tileentity.TEBlastFurnacePart;
import org.rebel.machina.util.ConfigHandler;
import org.rebel.machina.util.MachinaLog;
import org.rebel.machina.worldgen.MachinaOreGeneration;

/**
 * @author XVicarious
 */

@Mod(modid = Machina.MODID, version = Machina.VERSION, name = Machina.NAME)
public class Machina
{
    public static final String MODID = "Machina";
    @Mod.Instance(MODID)
    public static Machina instance;
    public static final String VERSION = "0.1";
    public static final String NAME = "Machina";
    @SidedProxy(clientSide = "org.rebel.machina.proxy.MachinaClientProxy", serverSide = "org.rebel.machina.proxy.MachinaServerProxy")
    public static MachinaServerProxy proxy;
    public static SimpleNetworkWrapper network;
    public static MultiblockEventHandler multiblockEventHandler;
    public static final CreativeTabs machinaTab = new CreativeTabs("tabMachina") {
        @Override
        public Item getTabIconItem() {
            return Items.beef;
        }
    };

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        MachinaLog.init();
        ConfigHandler.init(event.getSuggestedConfigurationFile());
        network = NetworkRegistry.INSTANCE.newSimpleChannel("Machina");
        network.registerMessage(MessageManualCrusher.Handle.class, MessageManualCrusher.class, 1, Side.SERVER);
    }

    @EventHandler
    public void startServer(FMLServerAboutToStartEvent event) {

    }

    @EventHandler
    public void init(FMLInitializationEvent event) {
        multiblockEventHandler = new MultiblockEventHandler();
        MinecraftForge.EVENT_BUS.register(multiblockEventHandler);
        proxy.init();
        MachinaBlocks.registerBlocks();
        MachinaItems.registerItems();
        addRecipes();
        GameRegistry.registerTileEntity(TEBlastFurnacePart.class, "TEBlastFurnacePart");
        GameRegistry.registerWorldGenerator(new MachinaOreGeneration(), 0);
        NetworkRegistry.INSTANCE.registerGuiHandler(this, new MachinaGuiHandler());
    }

    private void addRecipes() {
        ModRecipes.addBlendRecipes();
        ModRecipes.addMetalBlockRecipes();
        ModRecipes.addSingleIngotRecipes();
        ModRecipes.addNuggetRecipes();
        RecipeLists.makeRecipes();
    }

}
