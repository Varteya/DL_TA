package UI_tests.elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HeaderMenu extends CompositeElement{

    @FindBy(xpath = "//header[@data-test='layout-header']//*[contains(text(),'Datalore')]")
    private WebElement dataloreLink;

    public HeaderMenu(WebDriver driver) {
        super(driver);
    }

    public String dataloreLinkHref() {
        return dataloreLink.getAttribute("href");
    }

    public boolean dataloreLinkIsEnabled() {
        return dataloreLink.isEnabled();
    }
}
