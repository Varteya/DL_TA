package UI_tests;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class BaseTest {


    protected Browser browser;
    protected LandingPage landingPage;

    public void setUp() {
        WebDriverManager.chromedriver().setup();
        browser = new Browser(new ChromeDriver());
        landingPage = browser.getLandingPage();
    }





    @AfterMethod
    public void tearDown() {
        browser.tearDown();
    }


}
