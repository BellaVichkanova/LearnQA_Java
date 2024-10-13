import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestUserAgent {
    @ParameterizedTest
    @ValueSource(strings = {"Mozilla/5.0 (Linux; U; Android 4.0.2; en-us; Galaxy Nexus Build/ICL53F) AppleWebKit/534.30 (KHTML, like Gecko) Version/4.0 Mobile Safari/534.30",
            "Mozilla/5.0 (iPad; CPU OS 13_2 like Mac OS X) AppleWebKit/605.1.15 (KHTML, like Gecko) CriOS/91.0.4472.77 Mobile/15E148 Safari/604.1",
            "Mozilla/5.0 (compatible; Googlebot/2.1; +http://www.google.com/bot.html)",
            "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/91.0.4472.77 Safari/537.36 Edg/91.0.100.0",
            "Mozilla/5.0 (iPad; CPU iPhone OS 13_2_3 like Mac OS X) AppleWebKit/605.1.15 (KHTML, like Gecko) Version/13.0.3 Mobile/15E148 Safari/604.1"
    })

    public void getUserAgent(String userAgent) {
        Response response = RestAssured
                .given()
                .header("User-Agent",userAgent)
                .get("https://playground.learnqa.ru/ajax/api/user_agent_check")
                .andReturn();

        switch (userAgent) {
            case "Mozilla/5.0 (Linux; U; Android 4.0.2; en-us; Galaxy Nexus Build/ICL53F) AppleWebKit/534.30 (KHTML, like Gecko) Version/4.0 Mobile Safari/534.30":
                assertEquals("Mobile", response.jsonPath().getString("platform"),"platform is wrong");
                assertEquals("No", response.jsonPath().getString("browser"),"browser is wrong");
                assertEquals("Android", response.jsonPath().getString("device"),"devise is wrong");
                break;

            case "Mozilla/5.0 (iPad; CPU OS 13_2 like Mac OS X) AppleWebKit/605.1.15 (KHTML, like Gecko) CriOS/91.0.4472.77 Mobile/15E148 Safari/604.1":
                assertEquals("Mobile", response.jsonPath().getString("platform"),"platform is wrong");
                assertEquals("Chrome", response.jsonPath().getString("browser"),"browser is wrong");
                assertEquals("iOS", response.jsonPath().getString("device"),"devise is wrong");
                break;

            case "Mozilla/5.0 (compatible; Googlebot/2.1; +http://www.google.com/bot.html)":
                assertEquals("Googlebot", response.jsonPath().getString("platform"),"platform is wrong");
                assertEquals("Unknown", response.jsonPath().getString("browser"),"browser is wrong");
                assertEquals("Unknown", response.jsonPath().getString("device"),"devise is wrong");
                break;

            case "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/91.0.4472.77 Safari/537.36 Edg/91.0.100.0":
                assertEquals("Web", response.jsonPath().getString("platform"),"platform is wrong");
                assertEquals("Chrome", response.jsonPath().getString("browser"),"browser is wrong");
                assertEquals("No", response.jsonPath().getString("device"),"devise is wrong");
                break;

            case "Mozilla/5.0 (iPad; CPU iPhone OS 13_2_3 like Mac OS X) AppleWebKit/605.1.15 (KHTML, like Gecko) Version/13.0.3 Mobile/15E148 Safari/604.1":
                assertEquals("Mobile", response.jsonPath().getString("platform"),"platform is wrong");
                assertEquals("No", response.jsonPath().getString("browser"),"browser is wrong");
                assertEquals("Android", response.jsonPath().getString("device"),"devise is wrong");
                break;
        }

    }
}
