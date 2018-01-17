package sqvr;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;


public class FirstTest {

    private WebDriver driver;
    private static final Logger LOGGER = Logger.getLogger(FirstTest.class.getName());

    @Test (description = "ghtrigrth")
    public void firstTest() throws Exception {} {
        System.setProperty("webdriver.chrome.driver", "D:\\CDP\\Automation\\driver\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://sqvr.ru");
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='copy_2W']")));
        driver.findElement(By.xpath("//button[@data-target='#modalLogin']")).click();
        driver.findElement(By.name("username")).sendKeys("ba");
        driver.findElement(By.name("password")).sendKeys("1");
        LOGGER.info("Log with info");
        driver.quit();

        LOGGER.info("local branch to master ++++++++++++++++");

    }

}
