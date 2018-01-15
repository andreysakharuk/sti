package sqvr.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//a[@href='/meetings']")
    private WebElement meetingsLink;

    @FindBy(xpath = "//a[@href='/control']")
    private WebElement controlLink;

    @FindBy(xpath = "//a[@href='/interest']")
    private WebElement interestLink;

    @FindBy(xpath = "//*[@class='copy_2W']")
    private WebElement buttonZ;

    public void waitForChatAppearance() {
        waiting().until(ExpectedConditions.visibilityOf(buttonZ));
    }

    public void clickOnMeetingsLink() {
        waiting().until(ExpectedConditions.elementToBeClickable(meetingsLink)).click();
    }

    public void clickOnControlLink() {
        waiting().until(ExpectedConditions.elementToBeClickable(controlLink)).click();
    }

    public void clickOnInterestLink() {
        waiting().until(ExpectedConditions.elementToBeClickable(interestLink)).click();
    }
}
