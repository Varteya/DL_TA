package UI_tests;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class testCases {

    private static final String LOGGING_IN_FORM_TITLE = "Log in";
    private static final String LOGGING_IN_BUTTON_TEXT = "Log in";




    @BeforeTest
    public void openLandingPage() {
        landingPageSteps.openLandingPage();
    }

    @Test
    public void pageContainsLoginForm() {
        landingPageSteps.checkLoginFormTitle(LOGGING_IN_FORM_TITLE);
        landingPageSteps.checkLoginFormContainsEmailTextField();
        landingPageSteps.checkLoginFormContainsPasswordTextField();
        landingPageSteps.checkLoginFormButtonText(LOGGING_IN_BUTTON_TEXT);
    }

}
