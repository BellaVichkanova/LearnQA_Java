import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

public class TestRedirect {
    String urlParam = "https://playground.learnqa.ru/api/long_redirect";

    @Test
    public void getRedirect() {
        Response response = RestAssured
                .get(urlParam)
                .andReturn();
        int StatusCodeResponse = response.getStatusCode();
        System.out.println("\nКод ответа сервера:" + StatusCodeResponse);
        String finalUrl = response.getHeader("X-Host");
        System.out.println(finalUrl);

    }
}
