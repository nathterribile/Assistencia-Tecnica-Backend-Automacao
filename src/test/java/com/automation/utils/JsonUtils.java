package com.automation.utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import org.json.JSONObject;

import com.automation.config.Configuration;
import com.automation.config.ConfigurationManager;
import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)

public class JsonUtils {

    protected static final Configuration configuration = ConfigurationManager.getConfiguration();
    
    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    private JSONObject json;


    public static String getFileContentFromFullPath(String fullFileName) {
        if (fullFileName == null || fullFileName.isBlank()) {
            throw new IllegalArgumentException("The file name must be non-null and non-empty");
        }

        String content;
        try {
            content = Files.readString(Path.of(fullFileName));
        } catch (IOException ioException) {
            throw new IllegalStateException("Unable to read file: " + fullFileName, ioException);
        }

        if (!isValid(content)) {
            throw new IllegalStateException("JSON file is invalid: " + fullFileName);
        }

        return content;
    }


    public static boolean isValid(String jsonString) {

        if (jsonString == null || jsonString.isBlank()) {
            return false;
        }
        try {
            OBJECT_MAPPER.readTree(jsonString);
        } catch (JacksonException jacksonException) {
            return false;
        }
        return true;
    }

    public String trocaCampoEspecificoParaVazio(String jsonAsString, String campo) {
        json = new JSONObject(jsonAsString);
        Object key = json.get(campo);
        if(key instanceof Integer) {
            json.remove(campo);
            json.put(campo, 0);
        }
        json.remove(campo);
        json.put(campo, "");
        return json.toString(4);
    }
    
    public String trocaCampoEspecificoParaOutroTipo(String body, String campo, String tipo) {
        json = new JSONObject(body);
        if(tipo.equals("string")) {
            String valorCampo = json.getString(campo);
            json.remove(campo);
            json.put(campo, Long.valueOf(valorCampo));
            return json.toString(4);
        }
        Long novoValor = json.getLong(campo);
        json.remove(campo);
        json.put(campo, String.valueOf(novoValor));
        return json.toString(4);
    }

    public String trocaCampoEspecificoParaOutroValor(String body, String campo, String tipo, String novoValor){
        json = new JSONObject(body);
        Object key = json.get(campo);
        if(key instanceof Integer) {
            json.remove(campo);
            json.put(campo, Integer.valueOf(novoValor));
            return json.toString(4);
        }
        json.remove(campo);
        json.put(campo, String.valueOf(novoValor));
        return json.toString(4);
    }

    public static String retiradaCampoEspecifico(String jsonAsString, String campo) {
        JSONObject json = new JSONObject(jsonAsString);
        Object key = json.get(campo);
        if(key instanceof Integer) {
            json.remove(campo);
        }
        json.remove(campo);
        return json.toString(4);
    }
}