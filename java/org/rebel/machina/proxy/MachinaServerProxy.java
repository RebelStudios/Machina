package org.rebel.machina.proxy;

import cpw.mods.fml.common.FMLCommonHandler;
import org.rebel.machina.multiblock.helper.MultiblockServerTickHandler;
import org.rebel.machina.network.MessageManualCrusher;

/**
 * Created by XVicarious on 6/16/2014.
 */
public class MachinaServerProxy implements IMachinaProxy {

    @Override
    public void init() {
        FMLCommonHandler.instance().bus().register(new MultiblockServerTickHandler());
    }

}
