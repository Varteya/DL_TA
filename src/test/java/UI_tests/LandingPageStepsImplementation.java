package UI_tests;

import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class LandingPageStepsImplementation extends BaseTest {

    protected static final String LOGGING_IN_FORM_HEADER = "Log in";
    protected static final String SIGNING_UP_FORM_HEADER = "Sign up";

    private static Properties properties;

    {
        properties = new Properties();
        try(InputStream inputStream = LandingPageStepsImplementation.class.getClassLoader().getResourceAsStream("testData.properties")) {
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected final String landingPageUrl = properties.getProperty("url");

    protected void openSite(String url) {
        landingPage.openSite(url);
    }

    protected void loginFormTitleIsCorrect(String expectedHeaderText) {
        String actualHeaderText = loginForm.getLoginFormHeaderText();
        Assert.assertEquals(actualHeaderText, expectedHeaderText);
    }


    protected void switchToSingingUpForm() {
        if (loginForm.createAnAccountLinkVisibility()) {
            loginForm.createAnAccountLinkClick();
        }
    }

    protected void switchToLoggingInForm() {
        if (loginForm.logInHereLinkVisibility()) {
            loginForm.logInHereLinkClick();
        }
    }

    protected void logInFormIsVisible() {
        SoftAssert softAssert = new SoftAssert();

        String actualHeaderText = loginForm.getLoginFormHeaderText();
        softAssert.assertEquals(actualHeaderText,LOGGING_IN_FORM_HEADER);
        softAssert.assertTrue(loginForm.createAnAccountLinkVisibility());
        softAssert.assertTrue(loginForm.emailInputVisibility());
        softAssert.assertTrue(loginForm.passwordInputVisibility());
        softAssert.assertTrue(loginForm.loginButtonVisibility());
        softAssert.assertTrue(loginForm.forgotYourPasswordButtonVisibility());

        softAssert.assertAll();
    }

    protected void specialSigningUpOptionsAreNotVisible() {
        SoftAssert softAssert = new SoftAssert();

        softAssert.assertFalse(loginForm.logInHereLinkVisibility());
        softAssert.assertFalse(loginForm.createAccountButtonVisibility());

        softAssert.assertAll();
    }

    protected void signingUpFormIsVisible() {
        SoftAssert softAssert = new SoftAssert();

        String actualHeaderText = loginForm.getLoginFormHeaderText();
        softAssert.assertEquals(actualHeaderText, SIGNING_UP_FORM_HEADER);
        softAssert.assertTrue(loginForm.logInHereLinkVisibility());
        softAssert.assertTrue(loginForm.emailInputVisibility());
        softAssert.assertTrue(loginForm.passwordInputVisibility());
        softAssert.assertTrue(loginForm.createAccountButtonVisibility());

        softAssert.assertAll();
    }

    protected void specialLoggingInOptionsAreNotVisible() {
        SoftAssert softAssert = new SoftAssert();

        softAssert.assertFalse(loginForm.createAnAccountLinkVisibility(), "create an account link");
        softAssert.assertFalse(loginForm.loginButtonVisibility(), "log in button");
        softAssert.assertFalse(loginForm.forgotYourPasswordButtonVisibility(), "forgot your passwprd");

        softAssert.assertAll();
    }

    protected void setValueToEmailInput(String value) {
        loginForm.emailInputSetValue(value);
    }

    protected void emailRequiredWarningIsDisplayed() {
        Assert.assertTrue(loginForm.emailRequiredWarningVisibility());
    }

    protected void emailInvalidWarningIsDisplayed() {
        Assert.assertTrue(loginForm.emailInvalidWarningVisibility());
    }

    protected void setValueToPasswordInput(String value) {
        loginForm.passwordInputSetValue(value);
    }

    protected void passwordRequiredWarningIsDisplayed() {
        Assert.assertTrue(loginForm.passwordRequiredWarningVisibility());
    }

    protected void clickOnLogInButton() {
        loginForm.logInButtonClick();
    }

    protected void clickOnCreateAccountButton() {
        loginForm.createAccountButtonClick();
    }

    protected void clickOnForgotYourPasswordButton() {
        loginForm.forgotYourPasswordButtonClick();
    }

}
