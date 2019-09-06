package stepdefinations.backend;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utility.RestUtility;

import static org.junit.Assert.assertEquals;
import static utility.Constant.*;


/**
 * @author smali
 *
 */
public class EmployeeApiSteps {

    private static final Logger log = LoggerFactory.getLogger(EmployeeApiSteps.class);
    RestUtility restUtility = new RestUtility();

    private String url;
    private String basePath;
    private Response response;
    private String id;

    @Before
    public void beforeScenarios() {
        basePath = BASEPATH;
    }

    /* First step of backend automation where it create an enpoint */
    @Given("^Creating endpoint to add employee$")
    public void creating_endpoint_to_add_employee() {

        //Creating endpoint for POST request
        url = basePath.concat(POST);

        // logging to verify if correct endpoint is made
        log.info("endpoint" + url);
    }

    /* Second step of backend automation where it create calls POST service */
    @When("^request has been processed$")
    public void request_has_been_processed() {

        // POST request to create employee
        response = restUtility.createEmployee(url);

        // Validation response statusCode
        assertEquals(STATUSCODE, response.getStatusCode());
    }

    /* Third step of backend automation where it ensures record saved and retrieve id */
    @Then("^validating if this employee is created correctly$")
    public void statuscode_should_be() {

        // Retrieving id from POST request to verify below
        id = response.getBody().jsonPath().get("id");
        log.info("employeeId: " + id);

        // GET Request is sent
        response = restUtility.getEmployeeById(BASEPATH.concat(GET.concat(id)));

        //Verifying created employee id that retrieve by GET request
        assertEquals(response.getBody().jsonPath().get("id"), id);
    }

    @Then("^delete request has been sent and verified$")
    public void delete_request_has_been_sent() {

        // DELETE Request is sent to delete employee
        response = restUtility.deleteEmployee(BASEPATH.concat(DELETE.concat(id)));

        // Validation response statusCode
        assertEquals(STATUSCODE, response.getStatusCode());

        //Validation response message
        assertEquals(response.getBody().print(), SUCCESSMESSAGEONDELETE);

    }
}
