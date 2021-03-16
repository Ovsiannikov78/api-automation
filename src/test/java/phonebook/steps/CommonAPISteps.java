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


import static phonebook.utils.Constants.baseUrl;
import static phonebook.utils.Constants.contactAPIURL;
import static phonebook.utils.Constants.loginAPIUrl;


public class CommonAPISteps extends APITestsHelper implements En {
    private  static Response response;
    private RequestSpecification request;


    public CommonAPISteps() {
        //common step to build the client and receive token
        // instance variable token exists in APITestsHelper class
        Given("I have access token", () -> {
            request  =  RestAssured.given().header("Content-Type",  "application/json");
            response  =  request.body(createUser()).post(loginAPIUrl);
            token = response.getHeader("Access-Token");
        });

        // common step to create a contact before working with it.
        // contact data assigned to the existingContact instance variable
        Given("I have existing contact", () -> {
            existingContact = createRandomContact();
            request.header("Access-Token", token);
            response = request.body(existingContact).post(contactAPIURL);
        });
    }
}
