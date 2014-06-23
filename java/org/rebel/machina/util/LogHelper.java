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
        logger.log(Level.INFO,"[Machina] " + message);
    }

    public static void warning(String message) { logger.log(Level.WARN, "[Machina] " + message); }

    public static void error(String message) {
        logger.log(Level.ERROR, "[Machina] " + message);
    }

    public static void severe(String message) {
        logger.log(Level.FATAL, "[Machina] " + message);
    }

    public static void mbInfo(String message, Object... ob) {
        logger.log(Level.INFO, "[Machina-Multiblock] " + message, ob);
    }

}
