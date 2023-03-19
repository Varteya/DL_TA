package UI_tests.elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginForm extends CompositeElement {

    @FindBy(xpath = "//*[@class ='landing__login-form']/h1")
    private WebElement loginFormHeader;

    @FindBy(xpath = "//*[@class ='landing__login-form']//button[contains(text(), 'Create an account')]")
    private WebElement createAnAccountLink;

    @FindBy(xpath = "//*[@class ='landing__login-form']//*[@class=' login-inputs']//input[@type='email']")
    private WebElement emailInput;

    @FindBy(xpath = "//*[@class ='landing__login-form']//*[@class=' login-inputs']//input[@type='password']")
    private WebElement passwordInput;

    public LoginForm(WebDriver driver) {
        super(driver);
    }

    public String getLoginFormHeaderText() {
        return loginFormHeader.getText();
    }

    public boolean createAnAccountLinkVisibility() {
        return createAnAccountLink.isDisplayed();
    }


}
