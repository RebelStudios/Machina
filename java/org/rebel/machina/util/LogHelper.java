package org.rebel.machina.util;

import cpw.mods.fml.common.FMLLog;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.Logger;

/**
 * Created by XVicarious on 6/16/2014.
 */
public class LogHelper {

    private static Logger logger;

    public static void init() {
        logger = FMLLog.getLogger();
    }

    public static void info(String message) {
        logger.log(Level.INFO, message);
    }

    public static void mbInfo(String message, Object... ob) {
        logger.log(Level.INFO, "[Machina-Multiblock] " + message, ob);
    }

}
