import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.HashMap;
import java.util.Map;

public class TestCheckSomeCookie {
    @Test

    public void getSomeCookie() {
        Map<String, String> expectedCookie = new HashMap<>();
        expectedCookie.put("HomeWork", "hw_value");
        Response response = RestAssured
        .get("https://playground.learnqa.ru/api/homework_cookie")
        .andReturn();
        Map<String, String> responseCookies = response.getCookies();
        assertTrue(responseCookies!=null, "Cookies are empty");
        assertEquals(expectedCookie, responseCookies, "Cookies value doesn't match expected value");


    }
}
