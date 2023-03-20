package UI_tests;

import UI_tests.elements.FooterMenu;
import UI_tests.elements.HeaderMenu;
import UI_tests.elements.IncorrectLoginDataWarning;
import UI_tests.elements.LoginForm;
import org.openqa.selenium.WebDriver;


public class LandingPage extends BasePage {

    private LoginForm loginForm;

    private IncorrectLoginDataWarning incorrectLoginDataWarning;

    private HeaderMenu headerMenu;

    private FooterMenu footerMenu;


    public LandingPage (WebDriver driver){
        super(driver);
        loginForm = new LoginForm(driver);
        incorrectLoginDataWarning = new IncorrectLoginDataWarning(driver);
        headerMenu = new HeaderMenu(driver);
        footerMenu = new FooterMenu(driver);
    }

    public LoginForm getLoginForm() {
        return loginForm;
    }

    public IncorrectLoginDataWarning getIncorrectLoginDataWarning() {
        return incorrectLoginDataWarning;
    }

    public HeaderMenu getHeaderMenu() {
        return headerMenu;
    }

    public FooterMenu getFooterMenu() {
        return footerMenu;
    }

}
