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
        if(landingPage == null) {
            landingPage = new LandingPage(driver);
        }
        return landingPage;
    }

    public String getURL(){
        return driver.getCurrentUrl();
    }

    public WebDriver getDriver(){
        return driver;
    }

    public void tearDown (){
        driver.quit();
    }
}
