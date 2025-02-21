package com.automation.utils;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class EnvironmentUtils {

    public static boolean isLocalEnvironment() {
        String environment = System.getProperty("ENVIRONMENT");
        return !(environment != null && environment.matches("(?i)tu|ti|th"));
    }
}
