package UI_tests;

import UI_tests.elements.LoginForm;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    protected Browser browser;
    protected LandingPage landingPage;

    protected LoginForm loginForm;



    @BeforeMethod
    public void setUp() {
        WebDriverManager.firefoxdriver().setup();
        browser = new Browser(new FirefoxDriver());
        landingPage = browser.getLandingPage();
        loginForm = landingPage.getLoginForm();
    }

    @AfterMethod
    public void tearDown() {
        browser.tearDown();
    }
}
