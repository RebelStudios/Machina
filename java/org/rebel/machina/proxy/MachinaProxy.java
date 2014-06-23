package org.rebel.machina.proxy;

import org.rebel.machina.network.MessageManualCrusher;

/**
 * Created by XVicarious on 6/16/2014.
 */
public interface MachinaProxy {

    void init();

    void handleManualCrusher(MessageManualCrusher message);

}
