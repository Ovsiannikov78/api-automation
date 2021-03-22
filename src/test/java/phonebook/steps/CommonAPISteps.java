package phonebook.steps;

import io.cucumber.java8.En;


import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import phonebook.utils.APITestsHelper;

import static org.junit.Assert.assertEquals;
import static phonebook.utils.Constants.*;


public class CommonAPISteps extends APITestsHelper implements En {

    public CommonAPISteps() {
        //common step to build the client and receive token
        // instance variable token exists in APITestsHelper class
        Given("I have access token", () -> {

            response  =  createContentTypeRequest().body(createUser()).post(loginAPIUrl);
            token = response.getHeader("Access-Token");
        });

        // common step to create a contact before working with it.
        // contact data assigned to the existingContact instance variable
        Given("I have existing contact", () -> {
            existingContact = createRandomContact();
            response = createAuthRequest().body(existingContact).post(contactAPIURL);
            contactId = response.jsonPath().getString("id");
        });

        // common step to create a phone number before working with it.
        // phone data assigned to the existingPhoneNumber instance variable
        Given("I have existing phone number", () -> {
            existingPhoneNumber = createRandomPhoneNumber();
            response = createAuthRequest().body(existingPhoneNumber).post(addEditPhoneNumberAPIURL);
        });

    }
}
