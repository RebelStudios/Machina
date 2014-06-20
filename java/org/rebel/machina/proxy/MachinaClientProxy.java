package org.rebel.machina.proxy;

import org.rebel.machina.network.PacketManualCrusher;
import org.rebel.machina.util.LogHelper;

/**
 * Created by bmaurer on 6/17/2014.
 */
public class MachinaClientProxy implements MachinaProxy {
    @Override
    public void handleManualCrusher(PacketManualCrusher message) {
        LogHelper.info("Shouldn't be here?");
    }
}
