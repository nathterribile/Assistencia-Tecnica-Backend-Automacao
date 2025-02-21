package com.automation.steps;

import com.automation.config.Configuration;
import com.automation.config.ConfigurationManager;
import com.automation.resources.rest.RestRequests;
import com.automation.specs.PropostaSpecs;
import com.automation.specs.ValidationSpecs;

import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;



public class MostrarTodasOsSteps {
    
    protected final Configuration configuration = ConfigurationManager.getConfiguration();
    private RestRequests resource;
    private PropostaSpecs specs;
    private Response response;
    private String apiName;
    private Scenario scenario;
    private Integer statusCode;

    @Before
    public void before(Scenario scenario) {
        this.scenario = scenario;
        resource = new RestRequests();
    }
    

    @Given("a API MOSTRAR TODAS OS {string}")
    public void a_API_MOSTRAR_TODAS_OS(String apiName){
        this.apiName = apiName;
        scenario.log(apiName);
    }

    
    @When("o sistema envia um request GET na API MOSTRAR TODAS OS")
    public void o_sistema_envia_um_request_GET_na_API_MOSTRAR_TODAS_OS() {
        response = resource.getRequestWithouParam(apiName);
        specs = new PropostaSpecs(response);
        scenario.log(response.asPrettyString());
    }
    
    @Then("o status code da API MOSTRAR TODAS OS retorna {int}")
    public void o_status_code_da_API_MOSTRAR_TODAS_OS_retorna(final Integer statusCodeEsperado) {
        specs.verifyResponseStatusValue(statusCodeEsperado);
        statusCode = response.getStatusCode();
        scenario.log(statusCode.toString());
    }

    @And("o response body da API MOSTRAR TODAS OS confere com o JSON {string}")
    public void o_response_body_da_API_MOSTRAR_TODAS_OS_confere_com_o_JSON(String schemaName) {
        String schemaCheck = ValidationSpecs.getAPISchema(schemaName);
        specs.checkSchema(schemaName);
        scenario.log(schemaCheck);
    }

}