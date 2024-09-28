import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

public class TestLongRedirect {
    String urlParam = "https://playground.learnqa.ru/api/long_redirect";
    int redirectCount = 1;
    @Test
    public  void getRedirect() {
        Response response = RestAssured
                .given()
                .redirects()
                .follow(false)
                .when()
                .get(urlParam)
                .andReturn();
        int StatusCodeResponse = response.getStatusCode();
        urlParam = response.getHeader("Location");
        if (StatusCodeResponse != 200) {
            System.out.println("\nРедирект №" + redirectCount);
            System.out.println(urlParam);
            redirectCount++;
            getRedirect();
        }
        else {System.out.println("\nКод ответа сервера:" + StatusCodeResponse);}



    }
}
