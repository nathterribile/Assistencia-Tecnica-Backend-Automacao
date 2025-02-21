package com.automation.steps;

import com.automation.config.Configuration;
import com.automation.config.ConfigurationManager;
import com.automation.resources.rest.RestRequests;
import com.automation.specs.PropostaSpecs;
import com.automation.specs.ValidationSpecs;
import com.automation.utils.JsonUtils;

import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;



public class AlterarOsSteps {
    
    protected final Configuration configuration = ConfigurationManager.getConfiguration();
    private RestRequests resource;
    private PropostaSpecs specs;
    private Response response;
    private String requestBodyParam;
    private Scenario scenario;
    private Integer statusCode;

    @Before
    public void before(Scenario scenario) {
        this.scenario = scenario;
        resource = new RestRequests();
    }
    

    @Given("o request da API ALTERAR OS {string}")
    public void o_request_da_API_ALTERAR_OS(String requestBody){
        this.requestBodyParam = JsonUtils.getFileContentFromFullPath(configuration.bodyPath().concat(requestBody));
        scenario.log(requestBodyParam);
    }

    
    @When("o sistema envia um request PUT na API ALTERAR OS {string}")
    public void o_sistema_envia_um_request_PUT_na_API_ALTERAR_OS(String apiName) {
        response = resource.putRequest(apiName, requestBodyParam);
        specs = new PropostaSpecs(response);
        scenario.log(response.asPrettyString());
    }
    
    @Then("o status code da API ALTERAR OS retorna {int}")
    public void o_status_code_da_API_ALTERAR_OS_retorna(final Integer statusCodeEsperado) {
        specs.verifyResponseStatusValue(statusCodeEsperado);
        statusCode = response.getStatusCode();
        scenario.log(statusCode.toString());
    }

    @And("o response body da API ALTERAR OS confere com o JSON {string}")
    public void o_response_body_da_API_ALTERAR_OS_confere_com_o_JSON(String schemaName) {
        String schemaCheck = ValidationSpecs.getAPISchema(schemaName);
        specs.checkSchema(schemaName);
        scenario.log(schemaCheck);
    }
}