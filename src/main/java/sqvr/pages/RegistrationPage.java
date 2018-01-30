package sqvr.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class RegistrationPage extends BasePage {

    public RegistrationPage(WebDriver driver) {
        super(driver);
    }

    @FindBy (xpath = "//*[@data-type='resident']//*[@name='last_name']")
    private WebElement lastNameInput;

    @FindBy (xpath = "//*[@data-type='resident']//*[@name='first_name']")
    private WebElement firstNameInput;

    @FindBy (xpath = "//*[@data-type='resident']//*[@name='middle_name']")
    private WebElement middleNameInput;

    public void enterLastName(String lastName) {
        waiting().until(ExpectedConditions.visibilityOf(lastNameInput)).sendKeys(lastName);
    }

    public void enterFirstName(String firstName) {
        firstNameInput.sendKeys(firstName);
    }

    public void enterMiddleName(String middleName) {
        middleNameInput.sendKeys(middleName);
    }

    public void enterFIO(String lastName, String firstName, String middleName) {
        enterLastName(lastName);
        enterFirstName(firstName);
        enterMiddleName(middleName);
    }
}
