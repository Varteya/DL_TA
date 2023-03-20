package API_tests;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class LoginVerification {

    private static final String USER_LOGIN = System.getProperty("login");
    private static final String USER_PASSWORD = System.getProperty("password");

    private final String apiUri;

    LoginVerification() throws IOException {
        Properties properties = new Properties();
        try (InputStream inputStream = LoginVerification.class.getClassLoader().getResourceAsStream("api/testData.properties")) {
            properties.load(inputStream);
        }
        apiUri = properties.getProperty("uri");
    }

    @Test(dataProvider = "testData")
    public void verificationApiValidation(String[] testData) {
        String expectedResponse = testData[0];
        String email = testData[1];
        String password = testData[2];

        DTO credentials = new DTO(email, password);

        String credentialsJson = dtoToJson(credentials);

        String apiPath = "api/user_management/v1/login/authenticate";
        Response r1 = RestAssured.given()
                .baseUri(apiUri)
                .header("Content-Type", "application/json")
                .body(credentialsJson)
                .request(Method.POST, apiPath);

        Assert.assertEquals(r1.asString(), expectedResponse);
    }

    public String dtoToJson(DTO dto) {
        ObjectWriter ow = new ObjectMapper().writer();
        try {
            return ow.writeValueAsString(dto);
        } catch (JsonProcessingException e) {
            throw new IllegalArgumentException(e);
        }
    }

    @DataProvider
    private Object[][] testData() {
        return new Object[][]{
                {"\"INCORRECT\"", "does@that.make", "meInsane"},
                {"\"OK\"", USER_LOGIN, USER_PASSWORD}
        };
    }

}
