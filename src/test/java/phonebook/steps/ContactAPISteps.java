package phonebook.steps;

import io.cucumber.java8.En;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import phonebook.utils.APITestsHelper;

import static org.junit.Assert.assertEquals;
import static phonebook.utils.Constants.contactAPIURL;

public class ContactAPISteps extends APITestsHelper implements En {
    private RequestSpecification request;
    private static Response response;

    public ContactAPISteps() {

        When("I make POST request for the endpoint 'contact'", () -> {
            request = RestAssured.given().header("Access-Token", token);
            request.header("Content-Type", "application/json");
            response = request.body(createRandomContact()).post(contactAPIURL);
        });

        Then("I see status code {}", (Integer code) -> {
            Integer statusCode = response.getStatusCode();
            assertEquals(code, statusCode);
        });

        When("I make GET request for the endpoint 'contact'", () -> {
            request = RestAssured.given().header("Access-Token", token);
            response = request.get(contactAPIURL);
        });
    }
}
