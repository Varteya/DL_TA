package UI_tests.elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FooterMenu extends CompositeElement{

    @FindBy(xpath = "//*[@class='landing__footer']//*[text()='Support']")
    private WebElement supportLink;

    @FindBy(xpath = "//*[@class='landing__footer']//*[text()='Documentation']")
    private WebElement documentationLink;

    @FindBy(xpath = "//*[@class='landing__footer']//*[text()='Community forum']")
    private WebElement communityForumLink;

    @FindBy(xpath = "//*[@class='landing__footer']//*[text()='Blog']")
    private WebElement blogLink;

    public FooterMenu(WebDriver driver) {
        super(driver);
    }

    public String getSupportLinkHref() {
        return supportLink.getAttribute("href");
    }

    public String getDocumentationLinkHref() {
        return documentationLink.getAttribute("href");
    }

    public String getCommunityForumLinkHref() {
        return communityForumLink.getAttribute("href");
    }

    public String getBlogLinkHref() {
        return blogLink.getAttribute("href");
    }

    public boolean supportLinkIsEnabled() {
        return supportLink.isEnabled();
    }

    public boolean documentationLinkIsEnabled() {
        return documentationLink.isEnabled();
    }

    public boolean communityForumLinkIsEnabled() {
        return communityForumLink.isEnabled();
    }

    public boolean blogLinkIsEnabled() {
        return blogLink.isEnabled();
    }


}
