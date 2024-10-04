import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestShortPhrase {
    @ParameterizedTest
    @ValueSource(strings = {"123456789011121", "12345678901112"})
    public void checkTextLength(String textString) {
        assertTrue((textString.length()>14), "В строке меньше 15 символов: "+ textString);

    }
}
