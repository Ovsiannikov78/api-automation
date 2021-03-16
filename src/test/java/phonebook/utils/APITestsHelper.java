package phonebook.utils;


import com.github.javafaker.Faker;
import org.json.JSONException;
import org.json.JSONObject;

public class APITestsHelper {
    protected static String token;
    protected static String existingContact;
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
}
