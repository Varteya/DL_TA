package UI_tests;

import UI_tests.elements.IncorrectLoginDataWarning;
import UI_tests.elements.LoginForm;
import org.openqa.selenium.WebDriver;


public class LandingPage extends BasePage {

    private LoginForm loginForm;

    private IncorrectLoginDataWarning incorrectLoginDataWarning;


    public LandingPage (WebDriver driver){
        super(driver);
        loginForm = new LoginForm(driver);
        incorrectLoginDataWarning = new IncorrectLoginDataWarning(driver);
    }

    public LoginForm getLoginForm() {
        return loginForm;
    }

    public IncorrectLoginDataWarning getIncorrectLoginDataWarning() {
        return incorrectLoginDataWarning;
    }

}
