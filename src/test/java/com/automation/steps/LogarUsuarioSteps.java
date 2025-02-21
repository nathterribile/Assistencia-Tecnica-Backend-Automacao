package com.automation.steps;


import com.automation.config.Configuration;
import com.automation.config.ConfigurationManager;
import com.automation.resources.rest.RestRequests;
import com.automation.specs.PropostaSpecs;
import com.automation.utils.JsonUtils;

import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;



public class LogarUsuarioSteps {
    
    protected final Configuration configuration = ConfigurationManager.getConfiguration();
    private RestRequests resource;
    private PropostaSpecs specs;
    private Response response;
    private String body;
    private Scenario scenario;
    private String apiName;
    private Integer statusCode;
    private String responseLengthCheck;

    @Before
    public void before(Scenario scenario) {
        this.scenario = scenario;
        resource = new RestRequests();
    }
    

    @Given("o request da API LOGAR USUARIO {string}")
    public void o_request_da_API_LOGAR_USUARIO(String requestBody){
        this.body = JsonUtils.getFileContentFromFullPath(configuration.bodyPath().concat(requestBody));
        scenario.log(body);
    }

    
    @When("o sistema envia um request GET na API LOGAR USUARIO {string}")
    public void o_sistema_envia_um_request_POST_na_API_LOGAR_USUARIO(String apiName) {
        specs = new PropostaSpecs(response);
        statusCode = resource.postWithParamHeader(apiName, body).statusCode();
        String responseHeaderConnection= resource.postWithParamHeader(apiName, body).getHeader("connection");
        responseLengthCheck = resource.postWithParamHeader(apiName, body).getHeader("content-length");
        this.apiName = apiName;
        scenario.log(responseHeaderConnection);
    }
    
    @Then("o status code da API LOGAR USUARIO retorna {int}")
    public void o_status_code_da_API_LOGAR_USUARIO_retorna(final Integer statusCodeEsperado) {
        scenario.log(statusCode.toString());
        specs.verifyStatusCode(statusCode, statusCodeEsperado);
    }

    @And("o response body da API LOGAR USUARIO sera nulo")
    public void o_response_body_da_API_LOGAR_USUARIO_sera_nulo() {
        String responseCheck = specs.nullResponse(resource.postWithParamHeader(apiName, body));
        scenario.log(responseCheck);
        scenario.log(responseLengthCheck);

    }
        
}