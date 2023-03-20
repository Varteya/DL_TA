package UI_tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Browser {

    private WebDriver driver;
    private LandingPage landingPage;

    private WebDriverWait wait;

    public Browser (WebDriver driver) {
        this.driver = driver;
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public LandingPage getLandingPage() {
        if (landingPage == null) {
            landingPage = new LandingPage(driver);
        }
        return landingPage;
    }

    public WebDriverWait getWait() {
        return wait;
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    public void tearDown() {
        driver.quit();
    }
}
