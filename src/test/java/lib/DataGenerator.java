package lib;

import java.text.SimpleDateFormat;

public class DataGenerator {
    public static String getRandomEmail() {
        String timestamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new java.util.Date());
        return "lernqa" + timestamp + "@example.com";
    }

    public static String getUserName(int count) {
        String repeated = new String(new char[count]).replace("\0", String.valueOf("x"));
        return  repeated;
    }
}
