package phonebook.utils;


import com.github.javafaker.Faker;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONException;
import org.json.JSONObject;

public class APITestsHelper {
    protected static String token;
    protected static String existingContact;
    protected static String existingPhoneNumber;
    protected static String contactId;

    protected RequestSpecification request;
    protected static Response response;

    private Faker faker = new Faker();


    protected APITestsHelper() {
    }

    //create user using hard-coded credentials
    protected String createUser() throws JSONException {
        return new JSONObject()
                .put("email", "test111@gmail.com")
                .put("password", "12345678").toString();
    }

    //create random contact using Faker
    protected String createRandomContact() throws JSONException {
        return new JSONObject()
                .put("id", faker.random().nextInt(100))
                .put("firstName", faker.name().firstName())
                .put("lastName", faker.name().lastName())
                .put("decription", faker.shakespeare().asYouLikeItQuote()).toString();
    }

    //create random phone number using Faker
    protected String createRandomPhoneNumber() throws JSONException {
        return new JSONObject()
                .put("contactId", "249")
                .put("countryCode", faker.country().countryCode2())
                .put("phoneNumber", faker.phoneNumber()).toString();
    }

    protected RequestSpecification createContentTypeRequest() {
        return RestAssured.given().header("Content-Type", "application/json");
    }

    protected RequestSpecification createAuthRequest() {
       return createContentTypeRequest().header("Access-Token", token);
    }
}
