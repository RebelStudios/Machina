package org.rebel.machina.util;

import cpw.mods.fml.common.FMLLog;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.Logger;

/**
 * Created by XVicarious on 6/16/2014.
 */
public class MachinaLog {

    private static Logger logger;

    public static void init() {
        logger = FMLLog.getLogger();
    }

    private static void log(Level level, String message) {
        logger.log(level, "[Machina] " + message);
    }

    private static void mbLog(Level level, String message, Object... obj) {
        logger.log(level, "[Machina-Multiblock] " + message);
    }

    public static void info(String message) {
        log(Level.INFO, message);
    }

    public static void warning(String message) {
        log(Level.WARN, message);
    }

    public static void error(String message) {
        log(Level.ERROR, message);
    }

    public static void severe(String message) {
        log(Level.FATAL, message);
    }

    public static void mbInfo(String message, Object... obj) {
        mbLog(Level.INFO, message, obj);
    }

    public static void mbWarn(String message, Object... obj) {
        mbLog(Level.WARN, message, obj);
    }

    public static void mbError(String message, Object... obj) {
        mbLog(Level.ERROR, message, obj);
    }

}
