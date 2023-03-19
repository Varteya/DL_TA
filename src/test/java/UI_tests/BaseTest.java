package UI_tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    protected Browser browser;
    protected LandingPage landingPage;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.firefoxdriver().setup();
        browser = new Browser(new FirefoxDriver());
        landingPage = browser.getLandingPage();
    }

    @AfterMethod
    public void tearDown() {
        browser.tearDown();
    }
}
