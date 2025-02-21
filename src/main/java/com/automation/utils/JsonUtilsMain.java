package com.automation.utils;


import java.util.HashMap;
import java.util.Map;

import org.json.JSONObject;

import io.cucumber.messages.internal.com.fasterxml.jackson.core.JsonProcessingException;
import io.cucumber.messages.internal.com.fasterxml.jackson.databind.ObjectMapper;

public class JsonUtilsMain {

    @SuppressWarnings("rawtypes")
    public Map jsonStringToMap(String requestBody) {
        HashMap jsonMap = new HashMap<>();
        try {
            jsonMap = new ObjectMapper().readValue(requestBody, HashMap.class);
        } catch (JsonProcessingException e) {
            LogUtils logUtils = new LogUtils();
            logUtils.log("{0}", e.toString() );
        }
        return jsonMap;
    }
    

    public JSONObject requestParam(String jsonAsString) {
        JSONObject json = new JSONObject(jsonAsString);
        LogUtils logUtils = new LogUtils();
        logUtils.log("{0}", json.getJSONObject("requestParam").toString() );
        return json.getJSONObject("requestParam");
    }

    public JSONObject requestBody(String jsonAsString) {
        JSONObject json = new JSONObject(jsonAsString);
        LogUtils logUtils = new LogUtils();
        logUtils.log("{0}", json.getJSONObject("requestBody").toString() );
        return json.getJSONObject("requestBody");
    }
}
        

