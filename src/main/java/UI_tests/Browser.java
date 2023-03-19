package UI_tests;

import org.openqa.selenium.WebDriver;

public class Browser {

    private WebDriver driver;
    private LandingPage landingPage;

    public Browser (WebDriver driver) {
        this.driver = driver;
        driver.manage().window().maximize();
    }

    public LandingPage getLandingPage() {
        if (landingPage == null) {
            landingPage = new LandingPage(driver);
        }
        return landingPage;
    }

    public void tearDown() {
        driver.quit();
    }
}
