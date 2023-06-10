package model.api;

import io.qameta.allure.Step;
import org.apache.commons.lang3.RandomStringUtils;

import java.util.HashMap;
import java.util.Map;

public class UserRandomDataGenerator {
    public Map<String, String> getMapGeneratedDataUser() {
        HashMap<String, String> generatedData = new HashMap<>();
        generatedData.put("email", RandomStringUtils.randomAlphabetic(10) + "@yandex.ru");
        generatedData.put("password", RandomStringUtils.randomAlphabetic(10));
        generatedData.put("name", RandomStringUtils.randomAlphabetic(10));
        return generatedData;
    }
}
