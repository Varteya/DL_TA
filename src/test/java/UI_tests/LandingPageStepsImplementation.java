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
        softAssert.assertEquals(actualHeaderText,LOGGING_IN_FORM_HEADER, "header");
        softAssert.assertTrue(loginForm.createAnAccountLinkVisibility(), "create an account link");
        softAssert.assertTrue(loginForm.emailInputVisibility(), "email input");
        softAssert.assertTrue(loginForm.passwordInputVisibility(), "password input");
        softAssert.assertTrue(loginForm.loginButtonVisibility(), "login button");
        softAssert.assertTrue(loginForm.forgotYourPasswordButtonVisibility(), "forgot password button");

        softAssert.assertAll();
    }

    protected void specialSigningUpOptionsAreNotVisible() {
        SoftAssert softAssert = new SoftAssert();

        softAssert.assertFalse(loginForm.logInHereLinkVisibility(), "log in here link");
        softAssert.assertFalse(loginForm.createAccountButtonVisibility(), "create an account button");

        softAssert.assertAll();
    }

    protected void signingUpFormIsVisible() {
        SoftAssert softAssert = new SoftAssert();

        String actualHeaderText = loginForm.getLoginFormHeaderText();
        softAssert.assertEquals(actualHeaderText, SIGNING_UP_FORM_HEADER, "header");
        softAssert.assertTrue(loginForm.logInHereLinkVisibility(), "log in here link");
        softAssert.assertTrue(loginForm.emailInputVisibility(), "email input");
        softAssert.assertTrue(loginForm.passwordInputVisibility(), "password input");
        softAssert.assertTrue(loginForm.createAccountButtonVisibility(), "create account button");

        softAssert.assertAll();
    }

    protected void specialLoggingInOptionsAreNotVisible() {
        SoftAssert softAssert = new SoftAssert();

        softAssert.assertFalse(loginForm.createAnAccountLinkVisibility(), "create an account link");
        softAssert.assertFalse(loginForm.loginButtonVisibility(), "log in button");
        softAssert.assertFalse(loginForm.forgotYourPasswordButtonVisibility(), "forgot your password");

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

    protected void incorrectLoginDataMessageAppears() {
        Assert.assertTrue(landingPage.getIncorrectLoginDataWarning().alertMessageVisibility(browser.getWait()));
    }

    protected void dataloreLinkShouldLeadToLandingPage() {
        String actualLink = headerMenu.dataloreLinkHref();
        Assert.assertTrue(actualLink.equals(landingPageUrl) ||
                (actualLink.equals("") && browser.getCurrentUrl().equals(landingPageUrl)));
    }

    protected void dataloreLinkIsEnabled() {
        Assert.assertTrue(headerMenu.dataloreLinkIsEnabled());
    }

    protected void footerLinksAreCorrect() {
        SoftAssert softAssert = new SoftAssert();

        String expectedSupportHref = properties.getProperty("supportUrl");
        String expectedDocumentationHref = properties.getProperty("documentationUrl");
        String expectedCommunityForumHref = properties.getProperty("communityForumUrl");
        String expectedBlogHref = properties.getProperty("blogUrl");

        softAssert.assertEquals(footerMenu.getSupportLinkHref(), expectedSupportHref, "support href");
        softAssert.assertEquals(footerMenu.getDocumentationLinkHref(), expectedDocumentationHref, "documentation href");
        softAssert.assertEquals(footerMenu.getCommunityForumLinkHref(), expectedCommunityForumHref, "community forum href");
        softAssert.assertEquals(footerMenu.getBlogLinkHref(), expectedBlogHref, "blog");

        softAssert.assertAll();
    }

    protected void footerLinksAreEnabled() {
        SoftAssert softAssert = new SoftAssert();

        softAssert.assertTrue(footerMenu.supportLinkIsEnabled(), "support");
        softAssert.assertTrue(footerMenu.documentationLinkIsEnabled(), "documentation");
        softAssert.assertTrue(footerMenu.communityForumLinkIsEnabled(), "community forum");
        softAssert.assertTrue(footerMenu.blogLinkIsEnabled(), "blog");

        softAssert.assertAll();
    }

}
