import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.junit.jupiter.api.Test;


public class TestParseJson {
    @Test
    public void JsonParsing(){
        JsonPath response = RestAssured
                .get("https://playground.learnqa.ru/api/get_json_homework")
                .jsonPath();

        Object secondAnswer = response.get("messages[1].message");
        System.out.println(secondAnswer);

    }
}
