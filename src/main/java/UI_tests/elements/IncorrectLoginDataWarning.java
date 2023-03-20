package UI_tests.elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static utils.Utils.isExist;

public class IncorrectLoginDataWarning extends CompositeElement {

    @FindBy(xpath = "//*[contains(@class,'alert_container')]/*[contains(@class,'alert_message-error')]/*[@class='alert_content']")
    private WebElement alertMessage;

    @FindBy(xpath = "//*[contains(@class,'alert_container')]/*[contains(@class,'alert_message-error')]/*[contains(@class,'alert_close')]")
    private WebElement closeMessageIcon;

    public IncorrectLoginDataWarning(WebDriver driver) {
        super(driver);
    }

    public String getAlertMessageTest() {
        return alertMessage.getText();
    }

    public boolean alertMessageVisibility(WebDriverWait wait) {
        wait.until(ExpectedConditions.visibilityOf(alertMessage));
        return isExist(alertMessage);
    }

    public void closeWarningMessage() {
        closeMessageIcon.click();
    }
}
