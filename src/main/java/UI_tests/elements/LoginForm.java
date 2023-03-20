package UI_tests.elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static utils.Utils.isExist;

public class LoginForm extends CompositeElement {

    @FindBy(xpath = "//*[@class ='landing__login-form']/h1")
    private WebElement loginFormHeader;

    @FindBy(xpath = "//*[@class ='landing__login-form']//button[contains(text(), 'Create an account')]")
    private WebElement createAnAccountLink;

    @FindBy(xpath = "//*[@class ='landing__login-form']//button[contains(text(), 'Log in here')]")
    private WebElement logInHereLink;

    @FindBy(xpath = "//*[@class ='landing__login-form']//*[@class=' login-inputs']//input[@type='email']")
    private WebElement emailInput;

    @FindBy(xpath = "//*[@class ='landing__login-form']//*[@data-test='error-message']/*[contains(text(), 'Email is required')]")
    private WebElement emailRequiredWarning;

    @FindBy(xpath = "//*[@class ='landing__login-form']//*[@data-test='error-message']/*[contains(text(), 'Email is invalid')]")
    private WebElement emailInvalidWarning;

    @FindBy(xpath = "//*[@class ='landing__login-form']//*[@class=' login-inputs']//input[@type='password']")
    private WebElement passwordInput;

    @FindBy(xpath = "//*[@class ='landing__login-form']//*[@data-test='error-message']/*[contains(text(), 'Password is required')]")
    private WebElement passwordRequiredWarning;

    @FindBy(xpath = "//*[@class ='landing__login-form']//button[text()='Log in']")
    private WebElement logInButton;

    @FindBy(xpath = "//*[@class ='landing__login-form']//button[contains(text(), 'Create account')]")
    private WebElement createAccountButton;

    @FindBy(xpath = "//*[@class ='landing__login-form']//button[contains(text(), 'Forgot your password')]")
    private WebElement forgotYourPasswordButton;

    @FindBy(xpath = "//*[@class='landing__login-form']//*[contains(text(), 'Check your email')]")
    private WebElement checkYourEmailNotification;

    public LoginForm(WebDriver driver) {
        super(driver);
    }

    public String getLoginFormHeaderText() {
        return loginFormHeader.getText();
    }

    public boolean createAnAccountLinkVisibility() {
        return isExist(createAnAccountLink);
    }

    public void createAnAccountLinkClick() {
        createAnAccountLink.click();
    }

    public boolean logInHereLinkVisibility() {
        return isExist(logInHereLink);
    }

    public void logInHereLinkClick() {
        logInHereLink.click();
    }

    public boolean emailInputVisibility() {
        return isExist(emailInput);
    }

    public void emailInputSetValue(String value) {
        emailInput.clear();
        emailInput.sendKeys(value);
    }

    public boolean emailRequiredWarningVisibility() {
        return isExist(emailRequiredWarning);
    }

    public boolean emailInvalidWarningVisibility() {
        return isExist(emailInvalidWarning);
    }

    public boolean passwordInputVisibility() {
        return isExist(passwordInput);
    }

    public boolean passwordRequiredWarningVisibility() {
        return isExist(passwordRequiredWarning);
    }

    public void passwordInputSetValue(String value) {
        passwordInput.clear();
        passwordInput.sendKeys(value);
    }

    public boolean loginButtonVisibility() {
        return isExist(logInButton);
    }

    public void logInButtonClick() {
        logInButton.click();
    }

    public boolean createAccountButtonVisibility() {
        return isExist(createAccountButton);
    }

    public void createAccountButtonClick() {
        createAccountButton.click();
    }

    public boolean forgotYourPasswordButtonVisibility() {
        return isExist(forgotYourPasswordButton);
    }

    public void forgotYourPasswordButtonClick() {
        forgotYourPasswordButton.click();
    }

    public boolean checkYourEmailNotificationVisibility() {
        return isExist(checkYourEmailNotification);
    }

    public String getCheckYourEmailNotificationText() {
        return checkYourEmailNotification.getText();
    }

}
