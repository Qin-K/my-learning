package com.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogTest {
    private final static Logger logger = LoggerFactory.getLogger(LogTest.class);
    public static void main(String[] args) {
        logger.debug("debug message");
        logger.info("info message");
        logger.warn("warn message");
        logger.error("error message");
    }

}
