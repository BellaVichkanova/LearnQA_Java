package lib;

import io.restassured.http.Headers;
import io.restassured.response.Response;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class BaseTestCase {
    protected  String getHeader(Response Response, String name){
        Headers headers = Response.getHeaders();

        assertTrue(headers.hasHeaderWithName(name), "Response hasn't header with name " + name);
        return headers.getValue(name);
    }

    protected String getCookie(Response Response, String name){
        Map<String, String> cookies = Response.getCookies();

        assertTrue(cookies.containsKey(name), "Response hasn't cookie with name" + name);
        return cookies.get(name);

    }
}
