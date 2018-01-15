package sqvr.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class ControlPage extends BasePage{

    public ControlPage(WebDriver driver) {
        super(driver);
    }

    @FindBy (xpath = "//h1[@class='db5__title']")
    private WebElement controlHeader;

    public String getControlHeader() {
        return controlHeader.getText();
    }

}
