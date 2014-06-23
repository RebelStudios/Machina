package org.rebel.machina.proxy;

import cpw.mods.fml.common.FMLCommonHandler;
import org.rebel.machina.multiblock.helper.MultiblockClientTickHandler;
import org.rebel.machina.network.MessageManualCrusher;
import org.rebel.machina.util.LogHelper;

/**
 * Created by bmaurer on 6/17/2014.
 */
public class MachinaClientProxy implements MachinaProxy {

    @Override
    public void init() {
        FMLCommonHandler.instance().bus().register(new MultiblockClientTickHandler());
    }

    @Override
    public void handleManualCrusher(MessageManualCrusher message) {
        LogHelper.info("Shouldn't be here?");
    }
}
