package UI_tests;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class landingPageSteps extends BaseTest {

    private static Properties properties;

    {
        properties = new Properties();
        try(InputStream inputStream = BaseTest.class.getClassLoader().getResourceAsStream("TestData.properties")) {
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected String baseUrl = properties.getProperty("url");
//    protected String login = System.getProperty("login");
//    protected String password = System.getProperty("password");


    static void openLandingPage(){

    }

    static void checkLoginFormTitle(String title) {

    }

    static void checkLoginFormContainsEmailTextField() {

    }

    static void checkLoginFormContainsPasswordTextField() {

    }

    static void checkLoginFormButtonText(String text) {

    }


}
