import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

public class TestLongRedirect {
    String urlParam = "https://playground.learnqa.ru/api/long_redirect";
    int redirectCount = 0;
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
            while (urlParam != null) {
                redirectCount++;
                System.out.println("\nРедирект №" + redirectCount);
                System.out.println("To:" + urlParam);
                getRedirect();
            }
            if (StatusCodeResponse == 200) {
                System.out.println("\nРедиректов:" + redirectCount);
            }


    }
}
