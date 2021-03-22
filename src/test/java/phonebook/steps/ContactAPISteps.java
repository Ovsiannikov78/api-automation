package phonebook.steps;

import io.cucumber.java8.En;
import io.restassured.RestAssured;
import phonebook.utils.APITestsHelper;

import static org.junit.Assert.assertEquals;
import static phonebook.utils.Constants.contactAPIURL;

public class ContactAPISteps extends APITestsHelper implements En {


    public ContactAPISteps() {

        When("I make POST request for the endpoint 'contact'", () -> {

            response = createAuthRequest().body(createRandomContact()).post(contactAPIURL);
            response.body().prettyPrint();
        });

        Then("I see status code {}", (Integer code) -> {
            Integer statusCode = response.getStatusCode();
            assertEquals(code, statusCode);
        });

        // here we parth response
        When("I make GET request for the endpoint 'contact'", () -> {
            response = createAuthRequest().get(contactAPIURL + "/" + contactId);
            response.body().prettyPrint();
        });
    }
}
