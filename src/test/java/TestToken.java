import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given;


public class TestToken {
    String url = "https://playground.learnqa.ru/ajax/api/longtime_job";
    @Test
    public void createNewJob() {
        JsonPath response = RestAssured
                .get(url)
                .jsonPath();
        String token = response.getString("token");
        String timeToResult = response.getString("seconds") + "000";
        System.out.println("\nЗадача создана с токеном:");
        System.out.println("Токен: " + token + "\nВремя выполнения: " + timeToResult);


        JsonPath jobNotExecuted = given()
                .queryParam("token", token)
                .when()
                .get(url)
                .jsonPath();
        if (jobNotExecuted.getString("status").equals("Job is NOT ready"))
        {
            System.out.println("\n#1. Поле статус соответствует задаче");
            System.out.println("Статус задачи: " + jobNotExecuted.getString("status"));
        }
        else {System.out.println("#1. Ошибка выполнения");}

        try {
            Thread.sleep(Long.parseLong(timeToResult));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        JsonPath jobIsExecuted = RestAssured
                .given()
                .queryParam("token", token)
                .when()
                .get(url)
                .jsonPath();
        if (jobIsExecuted.getString("status").equals("Job is ready")&&jobIsExecuted.getString("result") != null)
        {
            System.out.println("\n#2. Поле статус соответствует задаче, поле результата не пустое");
            System.out.println("Статус задачи: " + jobIsExecuted.getString("status"));
        }
        else {System.out.println("#2. Ошибка выполнения");}

    }


}
