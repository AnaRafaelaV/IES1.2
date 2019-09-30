/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.weatherradar;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/**
 *
 * @author ana
 */
public class Log4jExample {
    private static Logger logger = LoggerFactory.getLogger(Log4jExample.class);
 
    public static void main(String[] args) {
        logger.debug("Debug log message");
        logger.info("Info log message");
        logger.error("Error log message");
    }
}
