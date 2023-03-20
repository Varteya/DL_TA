package UI_tests;

import UI_tests.elements.LoginForm;
import org.openqa.selenium.WebDriver;

public class LandingPage extends BasePage {

    private LoginForm loginForm;


    public LandingPage (WebDriver driver){
        super(driver);
        loginForm = new LoginForm(driver);
    }

    public LoginForm getLoginForm() {
        return loginForm;
    }

}
