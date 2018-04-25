package com.olivadevelop.lotery;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class LoggerBet {

    private static Logger logger;

    public LoggerBet(Class clase) {
        logger = LogManager.getLogger(clase);
    }


    public void warn(Object s) {
        logger.warn(s);
    }

    public void info(Object s) {
        logger.info(s);
    }

    public void debug(Object s) {
        logger.debug(s);
    }

    public void trace(Object s) {
        logger.trace(s);
    }

    public void error(Object s) {
        logger.error(s);
    }

    public void error(Object s, Throwable throwable) {
        logger.error(s, throwable);
    }
}
