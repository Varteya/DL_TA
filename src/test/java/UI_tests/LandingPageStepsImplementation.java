package UI_tests;

import org.testng.Assert;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class LandingPageStepsImplementation extends BaseTest {

    private static Properties properties;

    {
        properties = new Properties();
        try(InputStream inputStream = LandingPageStepsImplementation.class.getClassLoader().getResourceAsStream("testData.properties")) {
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected final String baseUrl = properties.getProperty("url");

    protected void openSite(String url) {
        landingPage.openSite(url);
    }

    protected void loginFormTitleIsCorrect(String expectedHeaderText) {
        String actualHeaderText = landingPage.getLoginFormHeaderText();
        Assert.assertEquals(actualHeaderText, expectedHeaderText);
    }

    protected void loginFormCreateAnAccountLinkIsVisible() {
        Assert.assertTrue(landingPage.createAnAccountLinkVisibility());
    }

}
