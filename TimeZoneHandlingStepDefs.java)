import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class TimeZoneHandlingStepDefs {

    private static final String BASE_URL = "http://your-api-url.com";
    private String timestamp;
    private String transformedTimestamp;

    @Given("the data is ingested with a timestamp")
    public void ingestDataWithTimestamp() {
        timestamp = "2024-02-28T12:00:00Z";
        // Assuming API endpoint for data ingestion
        given()
            .header("Content-Type", "application/json")
            .body("{ \"timestamp\": \"" + timestamp + "\" }")
        .when()
            .post(BASE_URL + "/data-ingestion-endpoint")
        .then()
            .statusCode(200);
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
}
