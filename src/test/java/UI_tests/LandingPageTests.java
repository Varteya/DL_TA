package UI_tests;

import org.testng.annotations.Test;

public class LandingPageTests extends LandingPageStepsImplementation {


    @Test
    public void isLoginFormShownCorrectly() {
        String expectedLoginFormTitle = "Log in";

        openSite(baseUrl);
        loginFormTitleIsCorrect(expectedLoginFormTitle);
        loginFormCreateAnAccountLinkIsVisible();
    }
}
