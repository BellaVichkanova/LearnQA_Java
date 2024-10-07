import io.restassured.RestAssured;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestCheckSomeHeader {
    @Test

    public void getSomeHeader() {
        String expectedHeaderValue = "Some secret value";
        Response response = RestAssured
                .get("https://playground.learnqa.ru/api/homework_header")
                .andReturn();
        Headers responseHeaders = response.getHeaders();
        assertTrue((responseHeaders.hasHeaderWithName("x-secret-homework-header")), "Header 'x-secret-homework-header' is absent");
        String responseHeader = response.getHeader("x-secret-homework-header");
        assertEquals(expectedHeaderValue, responseHeader, "Header 'x-secret-homework-header' has wrong value");


    }
}
