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



public class CadastrarOsSteps {
    
    protected final Configuration configuration = ConfigurationManager.getConfiguration();
    private RestRequests resource;
    private PropostaSpecs specs;
    private Response response;
    private String body;
    private Scenario scenario;
    private Integer statusCode;

    @Before
    public void before(Scenario scenario) {
        this.scenario = scenario;
        resource = new RestRequests();
    }
    

    @Given("o request da API CADASTRAR OS {string}")
    public void o_request_da_API_CADASTRAR_OS(String requestBody){
        this.body = JsonUtils.getFileContentFromFullPath(configuration.bodyPath().concat(requestBody));
        scenario.log(body);
    }

    
    @When("o sistema envia um request POST na API CADASTRAR OS {string}")
    public void o_sistema_envia_um_request_POST_na_API_CADASTRAR_OS(String apiName) {
        response = resource.postRequest(apiName, body);
        specs = new PropostaSpecs(response);
        scenario.log(response.asPrettyString());
    }
    
    @Then("o status code da API CADASTRAR OS retorna {int}")
    public void o_status_code_da_API_CADASTRAR_OS_retorna(final Integer statusCodeEsperado) {
        specs.verifyResponseStatusValue(statusCodeEsperado);
        statusCode = this.response.getStatusCode();
        scenario.log(statusCode.toString());
    }

    @And("o response body da API CADASTRAR OS confere com o JSON {string}")
    public void o_response_body_da_API_CADASTRAR_OS_confere_com_o_JSON(String schemaName) {
        String schemaCheck = ValidationSpecs.getAPISchema(schemaName);
        specs.checkSchema(schemaName);
        scenario.log(schemaCheck);
    }
        
}