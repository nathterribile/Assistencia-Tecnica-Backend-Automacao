package com.automation.utils;

import java.util.logging.Level;
import java.util.logging.Logger;

public class LogUtils {

    public Logger logger() {
                    
        return Logger.getLogger(getClass().getName());
    }

    public void log(String message, String stringResource) {
        logger().log(Level.INFO, message, stringResource);
    }
}
