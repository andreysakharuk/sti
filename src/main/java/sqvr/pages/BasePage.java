package sqvr.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class BasePage {

    protected final WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    @FindBy (xpath = "//a[@data-target='#modalFindHOA']")
    private WebElement findHomeLink;

    @FindBy (css = "div#modalFindHOA h1.h1")
    private WebElement findHomeModalHeader;

    @FindBy (xpath = "//button[@data-target='#modalCode']")
    private WebElement enterCodeLink;

    @FindBy (css = "div#modalCode h1.h1")
    private WebElement enterCodeModalHeader;

    @FindBy (xpath = "//button[@data-target='#modalLogin']")
    private WebElement loginLink;

    @FindBy (css = "div#modalLogin h1.h1")
    private WebElement loginModalHeader;

    @FindBy (name = "username")
    private WebElement loginField;

    @FindBy (name = "password")
    private WebElement passwordField;

    @FindBy (xpath = "//button[@tabindex='1']")
    private WebElement loginButton;


    public WebDriverWait waiting() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        return wait;
    }

    public void clickOnFindHomeLink() {
        waiting().until(ExpectedConditions.elementToBeClickable(findHomeLink)).click();
    }

    public String getFindHomeModalHeader() {
        return waiting().until(ExpectedConditions.visibilityOf(findHomeModalHeader)).getText();
    }

    public void clickOnEnterCodeLink() {
        waiting().until(ExpectedConditions.elementToBeClickable(enterCodeLink)).click();
    }

    public String getEnterCodeModalHeader() {
        return waiting().until(ExpectedConditions.visibilityOf(enterCodeModalHeader)).getText();
    }

    public void clickOnLoginLink() {
        waiting().until(ExpectedConditions.elementToBeClickable(loginLink)).click();
    }

    public String getLoginModalHeader() {
        return waiting().until(ExpectedConditions.visibilityOf(loginModalHeader)).getText();
    }

    public void enterCredentialsInLoginModal(String login, String password) {
        loginField.sendKeys(login);
        passwordField.sendKeys(password);
    }

    public void clickLoginButtonInLoginModal() {
        loginButton.click();
    }
}
