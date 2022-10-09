import org.example.ConsumerDataPage;
import org.example.MainPage;
import org.example.RentDataPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class TestOrder {
    private WebDriver driver;

    @Before
    public void setUp() {
        driver = new ChromeDriver();
    }

    @Test
    public void checkOrderUpButton() {
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        MainPage mainPage = new MainPage(driver);
        mainPage.openMainPage();
        mainPage.confirmCookie();
        mainPage.scrollPage();
        mainPage.checkOrderButtonUp();
        ConsumerDataPage consumerDataPage = new ConsumerDataPage(driver);
        consumerDataPage.inputConsumerData();
        consumerDataPage.checkNext();


        RentDataPage rentDataPage = new RentDataPage(driver);
        rentDataPage.inputRentData();
        rentDataPage.checkOrderButtonUp();
        rentDataPage.confirmOrder();
        rentDataPage.checkOrdered();
    }

    @Test
    public void checkOrderDownButton() {
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        MainPage mainPage = new MainPage(driver);
        mainPage.openMainPage();
        mainPage.confirmCookie();
        mainPage.scrollPage();
        mainPage.checkOrderButtonDown();

        ConsumerDataPage consumerDataPage = new ConsumerDataPage(driver);
        consumerDataPage.inputConsumerData();
        consumerDataPage.checkNext();

        RentDataPage rentDataPage = new RentDataPage(driver);
        rentDataPage.inputRentData();
        rentDataPage.checkOrderButtonDown();
        rentDataPage.confirmOrder();
        rentDataPage.checkOrdered();
    }

        @After
    public void cleanUp() {
        driver.quit();
    }
}