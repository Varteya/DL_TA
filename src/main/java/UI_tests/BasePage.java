package UI_tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage {

    protected WebDriver driver;

    protected String URL;

    public BasePage (WebDriver driver){
        this.driver = driver;
        this.URL = driver.getCurrentUrl();
        PageFactory.initElements(driver, this);
    }
}
