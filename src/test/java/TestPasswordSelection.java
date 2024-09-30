import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;


public class TestPasswordSelection {
    String[] PopularPasswords = new String[] { "password", "123456", "123456789", "12345678", "12345", "qwerty", "abc123", "football", "1234567",
        "monkey", "111111", "letmein", "1234", "1234567890", "dragon", "baseball", "sunshine", "iloveyou", "trustno1",
        "princess", "adobe123", "123123", "welcome", "login", "admin", "trustno1", "qwerty123", "solo", "1q2w3e4r",
        "master", "666666", "photoshop", "1qaz2wsx", "qwertyuiop", "ashley", "mustang", "121212", "starwars", "654321", "bailey",
        "access", "master", "flower", "555555", "passw0rd", "shadow", "lovely", "7777777", "michael", "!@#$%^&*", "jesus", "password1",
        "superman", "hello", "charlie", "888888", "696969", "hottie", "freedom", "aa123456", "qazwsx", "ninja", "azerty",
        "loveme", "whatever", "donald", "batman", "zaq1zaq1", "Football", "000000", "123qwe"};
    int passwordNumber = 0;
    @Test
    public void getCorrectAuthCookie() {
        Map<String, String> data = new HashMap<>();
        data.put("login", "super_admin");
            data.put("password", PopularPasswords[passwordNumber]);
            Response getAuthCookie = RestAssured
                    .given()
                    .body(data)
                    .when()
                    .post("https://playground.learnqa.ru/ajax/api/get_secret_password_homework")
                    .andReturn();
            String AuthCookie = getAuthCookie.getCookie("auth_cookie");

            Response checkAuthCookie = RestAssured
                    .given()
                    .body(data)
                    .cookie("auth_cookie", AuthCookie)
                    .when()
                    .post("https://playground.learnqa.ru/api/check_auth_cookie")
                    .andReturn();

            String authResult = checkAuthCookie.getBody().asString();
        if (authResult.equals("You are NOT authorized"))
        {
            passwordNumber++;
            getCorrectAuthCookie();
        }
        else
        {
            System.out.println("Вы авторизованы");
            System.out.println("Правильный пароль: " + PopularPasswords[passwordNumber]);
        }

    }
}
