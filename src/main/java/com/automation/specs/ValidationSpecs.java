package com.automation.specs;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import com.automation.config.Configuration;
import com.automation.config.ConfigurationManager;

import io.cucumber.messages.internal.com.fasterxml.jackson.core.JsonProcessingException;
import io.cucumber.messages.internal.com.fasterxml.jackson.databind.ObjectMapper;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;


public abstract class ValidationSpecs {

    protected static final Configuration configuration = ConfigurationManager.getConfiguration();
        /**
         * See more assertions
         * https://www.petrikainulainen.net/programming/testing/junit-5-tutorial-writing-assertions-with-hamcrest
         */
        protected final Response response;
    
        protected ValidationSpecs(final Response response) {
            this.response = response;
        }
    
        public Logger logger() {
                    
            return Logger.getLogger(getClass().getName());
        }
    
        public void log(String message, String stringResource) {
            logger().log(Level.INFO, message, stringResource);
        }
        
        @SuppressWarnings("rawtypes")
        public Map jsonToMap(String requestBody) {
                
                try {
                    return new ObjectMapper().readValue(requestBody, HashMap.class);
                
                } catch (JsonProcessingException e) {
                    
                    log("{0}", e.toString() );
                }
                return jsonToMap(requestBody);
        }
        
        protected JsonPath jsonPath() {
            return response.getBody().jsonPath();
        }
        
        public String getJsonValue(final String key) {
            return this.jsonPath().getString(key);
        }
        
        public void verifyResponseStatusValue(final Integer expectedCode) {
            
            if (expectedCode == null)
                throw new IllegalArgumentException("Expected code cannot be null.");
            
            assertThat(response.statusCode(), is(expectedCode));
        }
    
        public void verifyStatusCode(final Integer statusCode, final Integer expectedCode) {
            
            if (expectedCode == null)
                throw new IllegalArgumentException("Expected code cannot be null.");
            
            assertThat(statusCode, is(expectedCode));
        }
        
        public void checkSchema(final String schemaName) {
            
            if (schemaName == null)
            
                throw new IllegalArgumentException("Schema name cannot be null.");
    
                    response
                    .then()
                    .assertThat()
                    .body(matchesJsonSchema(getAPISchema(schemaName)));
            
        }
    
        public String nullResponse(Response response) {
            
            if (
                    response == null
                )
    
                log("{Response body is {0}}", "null");

            return "Response body is null";
            
    
        }
        
        public static String getAPISchema(String apiName) {
    
            final File jsonSchemaFile = new File(configuration.schemaPath().concat(apiName).concat(configuration.schemaExtension()));
        String content;

        try {
            content = Files.readString(Path.of(jsonSchemaFile.toString()));
        } catch (IOException ioException) {
            throw new IllegalStateException("Unable to read file: " + jsonSchemaFile.toString(), ioException);
        }


        return content;



}
}