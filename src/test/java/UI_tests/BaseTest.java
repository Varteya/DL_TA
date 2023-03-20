package UI_tests;

import UI_tests.elements.IncorrectLoginDataWarning;
import UI_tests.elements.LoginForm;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.InvalidArgumentException;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    protected Browser browser;
    protected LandingPage landingPage;

    protected LoginForm loginForm;

    protected IncorrectLoginDataWarning incorrectLoginDataWarning;



    @BeforeMethod
    public void setUp() {
        WebDriverManager.firefoxdriver().setup();
        browser = new Browser(new FirefoxDriver());
        landingPage = browser.getLandingPage();
        loginForm = landingPage.getLoginForm();
        incorrectLoginDataWarning = landingPage.getIncorrectLoginDataWarning();
    }

    @AfterMethod
    public void tearDown() {
        browser.tearDown();
    }
}
