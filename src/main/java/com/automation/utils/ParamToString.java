package com.automation.utils;


import java.util.Map;

import org.apache.commons.lang3.text.StrSubstitutor;

public class ParamToString {

    @SuppressWarnings({ "rawtypes", "unchecked" })
    public StrSubstitutor paramsToString(Map paramsToMap) {
        if (paramsToMap == null) {
            throw new IllegalArgumentException("Map with parameters cannot be null.");
            
        }
        return new StrSubstitutor(paramsToMap);
    }
}
