package sqvr;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;


public class FirstTest {

    private WebDriver driver;
    private static final Logger LOGGER = Logger.getLogger(FirstTest.class.getName());

    @Test (description = "All driver methods")
    public void firstTest() throws Exception {} {
        System.setProperty("webdriver.chrome.driver", "D:\\CDP\\Automation\\driver\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//        driver.get("http://jqueryui.com/");
        driver.get("http://consumerreports.org");

        driver.findElement(By.xpath("//a[@data-trackpagelink=\"['privacy_policy', 'footer']\"]")).click();
        Set <String> windowHand = driver.getWindowHandles();
        System.out.print(windowHand.size());

        // Explicitly wait
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".logo")));

        // Javascript executor
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        Object jsElement = jsExecutor.executeScript("document.getElementById('main');");
        System.out.println(jsElement);

        // Get List of elements with the same locator and click on the first element from the list
        List <WebElement> list = driver.findElements(By.cssSelector(".widget > ul > li > a"));
        list.get(0).click();

        // Get current url
        System.out.println(driver.getCurrentUrl());

        // Get page source
        System.out.println(driver.getPageSource().length());
        //System.out.println(driver.getPageSource().toUpperCase());

        // Get title of the page
        String titleOfPage = driver.getTitle();
        System.out.println(titleOfPage);

        // Get wind
        System.out.println(driver.getWindowHandle());


        // Sleep
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Make screenshot and save to selected directory with specified name
        try {
            File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            String pathname = ("D:/" + screenshot.getName() + ".png");
            FileUtils.copyFile(screenshot, new File(pathname));

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        driver.quit();
    }

}


