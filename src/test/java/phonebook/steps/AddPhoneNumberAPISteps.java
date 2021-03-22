package phonebook.steps;

import io.cucumber.java8.En;

import io.restassured.RestAssured;
import phonebook.utils.APITestsHelper;

import static phonebook.utils.Constants.addEditPhoneNumberAPIURL;


public class AddPhoneNumberAPISteps extends APITestsHelper implements En {

    public AddPhoneNumberAPISteps() {

            When("I make POST request for the endpoint 'phone'", () -> {
                response = createAuthRequest().body(createRandomPhoneNumber()).post(addEditPhoneNumberAPIURL);
                response.body().prettyPrint();
            });

            When("I make GET request for the endpoint 'phone'", () -> {
                response = createAuthRequest().get(addEditPhoneNumberAPIURL);
                response.body().prettyPrint();
            });

            Then("I see valid phone number", () -> {

            });
        }
    }
