package com.automation.resources.rest;

import java.util.Map;

import org.apache.commons.lang3.text.StrSubstitutor;

import com.automation.specs.InitialStateSpecs;
import com.automation.utils.JsonUtilsMain;
import com.automation.utils.LogUtils;
import com.automation.utils.ParamToString;

import static io.restassured.RestAssured.given;
import io.restassured.response.Response;

@SuppressWarnings("rawtypes")
public class RestRequests {
        
        LogUtils logUtils = new LogUtils();
        JsonUtilsMain jsonUtilsMain = new JsonUtilsMain();
        ParamToString paramsToString = new ParamToString();
        StrSubstitutor paramsUrl;
        Map paramsToMap;
        String params;

        
        public Response postRequest(final String apiName, String requestBody) {

                final Resources resourceAPI = Resources.valueOf(apiName);
                
                logUtils.log("Sending POST request to: {0} service", resourceAPI.getResource());

                return
                        given()
                                .spec(InitialStateSpecs.set())
                                .and()
                                .body(requestBody)
                                .when()
                                .post(resourceAPI.getResource())
                                .then()
                                .log().ifError()
                                .extract()
                                .response();
        }

        public Response postWithParamHeader(final String apiName, String requestBody){

                final Resources resourceAPI = Resources.valueOf(apiName);

                paramsToMap = jsonUtilsMain.jsonStringToMap(requestBody);
                paramsUrl = paramsToString.paramsToString(paramsToMap);
                params = paramsUrl.replace(resourceAPI.getResource());
                
                logUtils.log("Sending POST request, with parameters, to: {0} service", resourceAPI.getResource());

                return
                        given()
                                .spec(InitialStateSpecs.set())
                                .when()
                                .post(params)
                                .then()
                                .log().ifError()
                                .extract()
                                .response();
        }

        public Response deleteRequest(final String apiName, String requestBody){

                final Resources resourceAPI = Resources.valueOf(apiName);

                paramsToMap = jsonUtilsMain.jsonStringToMap(requestBody);
                paramsUrl = paramsToString.paramsToString(paramsToMap);
                params = paramsUrl.replace(resourceAPI.getResource());
                
                logUtils.log("Sending DELETE request to: {0} service", resourceAPI.getResource());

                return
                        given()
                                .spec(InitialStateSpecs.set())
                                .when()
                                .delete(params)
                                .then()
                                .log().ifError()
                                .extract()
                                .response();
                }

        public Response getRequest(final String apiName, String requestBody){

                final Resources resourceAPI = Resources.valueOf(apiName);
                
                paramsUrl = paramsToString.paramsToString(jsonUtilsMain.jsonStringToMap(requestBody));
                params = paramsUrl.replace(resourceAPI.getResource());

                logUtils.log("Sending GET request to: {0} service", resourceAPI.getResource());

                return
                        given()
                                
                                .spec(InitialStateSpecs.set())
                                .and()
                                .body(params)
                                .when()
                                .get(params)
                                .then()
                                .log().ifError()
                                .extract()
                                .response();
        }

        public Response putRequest(final String apiName, String requestBody){

                final Resources resourceAPI = Resources.valueOf(apiName);
                String body = jsonUtilsMain.requestBody(requestBody).toString();
                paramsToMap = jsonUtilsMain.jsonStringToMap(jsonUtilsMain.requestParam(requestBody).toString());
                paramsUrl = paramsToString.paramsToString(paramsToMap);
                params = paramsUrl.replace(resourceAPI.getResource());
                logUtils.log("Sending PUT request to: {0} service", resourceAPI.getResource());

                return
                        given()
                                .with()
                                .spec(InitialStateSpecs.set())
                                .and()
                                .body(body)
                                .when()
                                .put(params)
                                .then()
                                .log().ifError()
                                .extract()
                                .response();
        }

        public Response getRequestWithouParam(final String apiName){

                final Resources resourceAPI = Resources.valueOf(apiName);

                logUtils.log("Sending GET request to: {0} service", resourceAPI.getResource());

                return
                        given()
                                
                                .spec(InitialStateSpecs.set())
                                .when()
                                .get(resourceAPI.getResource())
                                .then()
                                .log().ifError()
                                .extract()
                                .response();
        }

}