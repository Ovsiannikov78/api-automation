package phonebook.utils;

public class Constants {

    //    ------------  Commons  ---------------
    public static String baseUrl = "http://dev.phonebook-1.telran-edu.de";


//  -----------------  Endpoints  -------------------------

    public static String loginAPIUrl = baseUrl + "/api/user/login";
    public static String passChangeAPIUrl = baseUrl + "/api/user/auth-password";
    public static String registrationAPIUrl = baseUrl + "/api/user";
    public static String passForgotAPIUrl = baseUrl + "/api/user/password/recovery";
    public static String passRenewAPIUrl = baseUrl + "/api/user/password";
    public static String contactAPIURL = baseUrl + "/api/contact";
    public static String addEditPhoneNumberAPIURL = baseUrl + "/api/phone";


}
