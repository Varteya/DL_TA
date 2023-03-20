package UI_tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LandingPageTests extends LandingPageStepsImplementation {

    @Test
    public void verifyLoginFormShownCorrectlyByDefault() {
        openSite(landingPageUrl);
        logInFormIsVisible();
        specialSigningUpOptionsAreNotVisible();
    }

    @Test
    public void verifyLoginFormAndSigningUpChangedByClickingOnTheLink() {
        openSite(landingPageUrl);

        logInFormIsVisible();
        specialSigningUpOptionsAreNotVisible();
        switchToSingingUpForm();
        signingUpFormIsVisible();
        specialLoggingInOptionsAreNotVisible();
        switchToLoggingInForm();
        logInFormIsVisible();
        specialSigningUpOptionsAreNotVisible();
    }

    @Test
    public void verifyWarningMessageForEmptyEmailFieldInLoginForm() {
        openSite(landingPageUrl);

        switchToLoggingInForm();
        setValueToEmailInput("");
        clickOnLogInButton();
        emailRequiredWarningIsDisplayed();
    }

    @Test(dataProvider = "incorrectEmails")
    public void verifyWarningMessageForIncorrectEmailFieldInLoginForm(String[] data) {
        openSite(landingPageUrl);

        switchToLoggingInForm();
        setValueToEmailInput(data[0]);
        clickOnLogInButton();
        emailInvalidWarningIsDisplayed();
    }

    @Test
    public void verifyWarningMessageForEmptyPasswordFieldInLoginForm() {
        openSite(landingPageUrl);

        switchToLoggingInForm();
        setValueToPasswordInput("");
        clickOnLogInButton();
        passwordRequiredWarningIsDisplayed();
    }

    @Test
    public void verifyWarningMessageForEmptyEmailFieldInSignUpForm() {
        openSite(landingPageUrl);

        switchToSingingUpForm();

        setValueToEmailInput("");
        clickOnCreateAccountButton();
        emailRequiredWarningIsDisplayed();
    }

    @Test(dataProvider = "incorrectEmails")
    public void verifyWarningMessageForIncorrectEmailFieldInSignUpForm(String[] data) {
        openSite(landingPageUrl);

        switchToSingingUpForm();

        setValueToEmailInput(data[0]);
        clickOnCreateAccountButton();
        emailInvalidWarningIsDisplayed();
    }

    @Test
    public void verifyWarningMessageForEmptyPasswordFieldInSignUpForm() {
        openSite(landingPageUrl);

        switchToSingingUpForm();

        setValueToPasswordInput("");
        clickOnCreateAccountButton();
        passwordRequiredWarningIsDisplayed();
    }

    @Test
    public void verifyWarningMessageForEmptyEmailFieldForForgottenPassword() {
        openSite(landingPageUrl);

        switchToLoggingInForm();
        setValueToEmailInput("");
        clickOnForgotYourPasswordButton();
        emailRequiredWarningIsDisplayed();
    }

    @Test(dataProvider = "incorrectEmails")
    public void verifyWarningMessageForIncorrectEmailFieldForForgottenPassword(String[] data) {
        openSite(landingPageUrl);

        switchToLoggingInForm();
        setValueToEmailInput(data[0]);
        clickOnForgotYourPasswordButton();
        emailInvalidWarningIsDisplayed();
    }

    @Test
    public void verifyEmailOrPasswordIncorrectWarning() {
        String notRegisteredEmail = "sleeping@in.the";
        String notValidPassword = "coldBel0w";

        openSite(landingPageUrl);

        switchToLoggingInForm();
        setValueToEmailInput(notRegisteredEmail);
        setValueToPasswordInput(notValidPassword);
        clickOnLogInButton();

        incorrectLoginDataMessageAppears();
    }

    @Test
    public void verifyHeaderMenuLinks() {
        openSite(landingPageUrl);

        dataloreLinkShouldLeadToLandingPage();
        dataloreLinkIsEnabled();
    }

    @Test
    public void verifyFooterLinks() {
        openSite(landingPageUrl);

        footerLinksAreCorrect();
        footerLinksAreEnabled();
    }

    @DataProvider
    public Object[][] incorrectEmails() {
        return new Object[][] {
                {" "},
                {"1"},
                {"a@"},
                {"lorem ipsum@gmail.lol"},
                {"fields@of"},
                {"no@way.to."}
        };
    }
}
