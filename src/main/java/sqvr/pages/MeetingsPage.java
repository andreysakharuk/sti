package sqvr.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class MeetingsPage extends BasePage {

    public MeetingsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy (xpath = "//h1[@class='db5__title']")
    private WebElement meetingsHeader;

    public String getMeetingsHeader() {
        return meetingsHeader.getText();
    }

}
