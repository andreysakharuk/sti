package sqvr;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import sqvr.pages.ControlPage;
import sqvr.pages.HomePage;
import sqvr.pages.InterestPage;
import sqvr.pages.MeetingsPage;

import java.util.concurrent.TimeUnit;

public class LandingTests {

    private WebDriver driver;

    @BeforeMethod
    public void beforeMethod() {
        System.setProperty("webdriver.chrome.driver", "D:\\CDP\\Automation\\driver\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://sqvr.ru/");
    }

    @Test (description = "Клик на ссылку 'Собрания' в меню")
    public void clickOnMeetingsLinkInMenu() throws Exception {
        System.out.println("Стартуем тест 1");
        HomePage homePage = new HomePage(driver);
        homePage.waitForChatAppearance();
        homePage.clickOnMeetingsLink();
        MeetingsPage meetingsPage = new MeetingsPage(driver);
        Assert.assertEquals(meetingsPage.getMeetingsHeader(), "Организация общего собрания собственников",
                            "Заголовки не совпадают");
        System.out.println("Тест 1 успешно завершен");
    }

    @Test (description = "Клик на ссылку 'Контроль' в меню")
    public void clickOnControlLinkInMenu() throws Exception {
        System.out.println("Стартуем тест 2");
        HomePage homePage = new HomePage(driver);
        homePage.waitForChatAppearance();
        homePage.clickOnControlLink();
        ControlPage controlPage = new ControlPage(driver);
        Assert.assertEquals(controlPage.getControlHeader(), "Контроль работы и жалобы",
                            "Заголовки не совпадают");
        System.out.println("Тест 2 успешно завершен");
    }

    @Test (description = "Клик на ссылку 'Жизнь дома' в меню")
    public void clickOnInterestLinkInMenu() throws Exception {
        System.out.println("Стартуем тест 3");
        HomePage homePage = new HomePage(driver);
        homePage.waitForChatAppearance();
        homePage.clickOnInterestLink();
        InterestPage interestPage = new InterestPage(driver);
        Assert.assertEquals(interestPage.getInterestHeader(), "Вовлечение собственников в процесс управления домом",
                            "Заголовки не совпадают");
        System.out.println("Тест 3 успешно завершен");
    }

    @Test (description = "Клик на ссылку 'Найдите свой дом' в меню")
    public void clickOnFindHomeLinkInMenu() throws Exception {
        System.out.println("Стартуем тест 4");
        HomePage homePage = new HomePage(driver);
        homePage.waitForChatAppearance();
        homePage.clickOnFindHomeLink();
        Assert.assertEquals(homePage.getFindHomeModalHeader(), "Найдите свой дом или поселок",
                            "Заголовки не совпадают");
        System.out.println("Тест 4 успешно завершен");
    }

    @Test (description = "Клик на ссылку 'Ввести код регистрации' в меню")
    public void clickOnEnterCodeLinkInMenu() throws Exception {
        System.out.println("Стартуем тест 5");
        HomePage homePage = new HomePage(driver);
        homePage.waitForChatAppearance();
        homePage.clickOnEnterCodeLink();
        Assert.assertEquals(homePage.getEnterCodeModalHeader(), "Код регистрации",
                            "Заголовки не совпадают");
        System.out.println("Тест 5 успешно завершен");
    }

    @Test (description = "Клик на ссылку 'Войти' в меню")
    public void clickOnLoginLinkInMenu() throws Exception {
        System.out.println("Стартуем тест 6");
        HomePage homePage = new HomePage(driver);
        homePage.waitForChatAppearance();
        homePage.clickOnLoginLink();
        Assert.assertEquals(homePage.getLoginModalHeader(), "Войти",
                            "Заголовки не совпадают");
        System.out.println("Тест 6 успешно завершен");
    }

    @Test (description = "Залогиниться с правильными логином и паролем")
    public void loginWithValidCredentials() throws Exception {
        System.out.println("Стартуем тест 7");
        String login = "ba";
        String password = "1";
        HomePage homePage = new HomePage(driver);
        homePage.waitForChatAppearance();
        homePage.clickOnLoginLink();
        homePage.enterCredentialsInLoginModal(login, password);
        homePage.clickLoginButtonInLoginModal();
        System.out.println("Тест 7 успешно завершен");
    }

    @AfterMethod
    public void afterMethod() {
        driver.quit();
    }
}
