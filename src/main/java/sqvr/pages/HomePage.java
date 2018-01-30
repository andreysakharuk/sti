package sqvr.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
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

    @FindBy(css = "[href='/interest']")
    private WebElement interestLink;

    @FindBy(xpath = "//*[@class='copy_2W']")
    private WebElement buttonZ;

    @FindBy (css = ".db5__btnBox > a[data-target='#modalRegisterNav']")
    private WebElement SignUpHeader;

    @FindBy (css = "a[data-status='go_to_register_owner']")
    private WebElement ownerButton;


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

    public void clickOnSignUpButton() {
        new Actions(driver).moveToElement(SignUpHeader).click(SignUpHeader).build().perform();
    }

    public RegistrationPage clickOnOwnerButton() {
        waiting().until(ExpectedConditions.elementToBeClickable(ownerButton)).click();
        return new RegistrationPage(driver);
    }

}
