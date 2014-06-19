package org.rebel.machina.proxy;

import org.rebel.machina.network.PacketManualCrusher;

/**
 * Created by XVicarious on 6/16/2014.
 */
public interface MachinaProxy {

    void handleManualCrusher(PacketManualCrusher message);

}
