package utility;

import com.github.javafaker.Faker;
import com.google.gson.JsonObject;
import io.restassured.response.Response;
import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static io.restassured.RestAssured.expect;

/**
 * Created by smali on 9/5/2019.
 */
public class RestUtility {
    private static final Logger log = LoggerFactory.getLogger(RestUtility.class);

    /**
     * To create employee using POST api
     * @param apiEndpoint
     * @return
     */
    public Response createEmployee(String apiEndpoint) {

        DateTime dtBeforeAPIRequest = new DateTime();
        long current = dtBeforeAPIRequest.getMillis();

        Response response = expect().statusCode(200).given().
                contentType("application/json").
                body(createEmployeeRequest()).
                when().
                post(apiEndpoint);

        DateTime dtAfterResponse = new DateTime();
        log.info("Response Time - api Information: "
                + Long.toString(dtAfterResponse.getMillis() - current) + " ms");

        return response;
    }


    public Response getEmployeeById(String apiEndpoint){
        DateTime dtBeforeAPIRequest = new DateTime();
        long current = dtBeforeAPIRequest.getMillis();

        Response response = expect().statusCode(200).given().
                contentType("application/json").
                when().
                get(apiEndpoint);

        DateTime dtAfterResponse = new DateTime();
        log.info("Response Time - api Information: "
                + Long.toString(dtAfterResponse.getMillis() - current) + " ms");

        return response;



    }

    /**
     * To Delete employee using DELETE api
     * @param endpoint
     * @return
     */
    public Response deleteEmployee(String endpoint) {

        DateTime dtBeforeAPIRequest = new DateTime();
        long current = dtBeforeAPIRequest.getMillis();

        Response response = expect().statusCode(200).given().
                contentType("application/json").
                when().
                delete(endpoint);

        DateTime dtAfterResponse = new DateTime();
        log.info("Response Time - api Information: "
                + Long.toString(dtAfterResponse.getMillis() - current) + " ms");

        return response;
    }

    /**
     * as POST request doesn't allow duplication, the method is used to generate random name
     * @return
     */
    public String randomName() {
        Faker faker = new Faker();
        String name = faker.name().fullName();
        return name;
    }

    /**
     * To generate JSON for POST request
     * @return
     */
    public JsonObject createEmployeeRequest() {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("name", randomName().toString());
        jsonObject.addProperty("salary", "123");
        jsonObject.addProperty("age", "23");
        return jsonObject;
    }
}
