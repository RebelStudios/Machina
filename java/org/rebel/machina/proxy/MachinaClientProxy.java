package org.rebel.machina.proxy;

import cpw.mods.fml.common.FMLCommonHandler;
import org.rebel.machina.multiblock.helper.MultiblockClientTickHandler;

/**
 * Created by bmaurer on 6/17/2014.
 */
public class MachinaClientProxy extends MachinaServerProxy {

    @Override
    public void init() {
        super.init();
        FMLCommonHandler.instance().bus().register(new MultiblockClientTickHandler());
    }

}
