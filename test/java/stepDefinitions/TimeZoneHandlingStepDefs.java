import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TimeZoneHandlingStepDefs {

    private static final String BASE_URL = "http://your-api-url.com";
    private String timestamp;
    private String transformedTimestamp;

    @Before
    public void setUpData() {
        // Set up test data before each scenario
        timestamp = "2024-02-28T12:00:00Z";
        // Assuming API endpoint for data ingestion
        given()
                .header("Content-Type", "application/json")
                .body("{ \"timestamp\": \"" + timestamp + "\" }")
                .when()
                .post(BASE_URL + "/setup-data-endpoint")
                .then()
                .statusCode(200);
    }

    @After
    public void tearDownData() {
        // Tear down test data after each scenario
        // Assuming API endpoint for tearing down data
        given()
                .header("Content-Type", "application/json")
                .body("{ \"timestamp\": \"" + timestamp + "\" }")
                .when()
                .post(BASE_URL + "/teardown-data-endpoint")
                .then()
                .statusCode(200);
    }

    @Given("the data is ingested with a timestamp")
    public void ingestDataWithTimestamp() {
        // No action needed here, as data is set up in @Before method
    }

    @When("the data is transformed")
    public void transformData() {
        // Assuming API endpoint for data transformation
        transformedTimestamp = given()
                .header("Content-Type", "application/json")
                .body("{ \"timestamp\": \"" + timestamp + "\" }")
                .when()
                .post(BASE_URL + "/data-transformation-endpoint")
                .then()
                .statusCode(200)
                .extract()
                .path("timestamp");
    }

    @Then("the timestamp is correctly handled in the transformed data")
    public void verifyTimeZoneHandling() {
        assertThat(transformedTimestamp, equalTo(timestamp));
    }

    public static String getBaseUrl() {
        return BASE_URL;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getTransformedTimestamp() {
        return transformedTimestamp;
    }

    public void setTransformedTimestamp(String transformedTimestamp) {
        this.transformedTimestamp = transformedTimestamp;
    }
}
