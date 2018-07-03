package com.example.demo2.utils.loggers;

import com.example.demo2.utils.loggers.base.LoggerProvider;
import org.apache.log4j.Logger;

public class Log4LoggerProvider<T> implements LoggerProvider<T> {

    private Logger logger;

    public void setClass(Class<T> klass) {
        logger = Logger.getLogger(klass);
    }

    @Override
    public void info(Object message) {
        logger.info(message);
    }

    @Override
    public void error(Object message) {
        logger.error(message);
    }
}
