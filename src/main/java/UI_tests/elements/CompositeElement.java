package UI_tests.elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class CompositeElement {

    protected CompositeElement(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}
