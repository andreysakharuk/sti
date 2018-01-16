package sqvr;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;


public class FirstTest {

    private WebDriver driver;

    @Test (description = "ghtrigrth")
    public void firstTest() throws Exception {} {
        System.setProperty("webdriver.chrome.driver", "D:\\CDP\\Automation\\driver\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://sqvr.ru");
        driver.findElement(By.xpath("//button[@data-target='#modalLogin']")).click();
        driver.findElement(By.name("username")).sendKeys("ba");
        driver.findElement(By.name("password")).sendKeys("1");
        driver.findElement(By.className("btn btn-blue bb-enter-form-btn")).click();
        System.out.println("Action2");
        System.out.println("ssh added");
        System.out.println("Syuyu ");
    }

}
