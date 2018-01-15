package sqvr.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class InterestPage extends BasePage{

    public InterestPage(WebDriver driver) {
        super(driver);
    }

    @FindBy (xpath = "//h1[@class='db5__title']")
    private WebElement inrerestHeader;

    public String getInterestHeader() {
        return inrerestHeader.getText();
    }

}
