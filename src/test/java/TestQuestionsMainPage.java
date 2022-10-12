import org.example.MainPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;


public class TestQuestionsMainPage {
    private WebDriver driver;
    @Before
    public void setUp() {
        driver = new ChromeDriver();
    }
    @Test
    public void checkQuestionFirst() {
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        MainPage mainPage = new MainPage(driver);
        mainPage.openMainPage();
        mainPage.confirmCookie();
        mainPage.scrollPage();
        mainPage.clickFirstQuestion();
        mainPage.checkFirstAnswerText();
    }
    @Test
    public void checkQuestionSecond(){
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        MainPage mainPage = new MainPage(driver);
        mainPage.openMainPage();
        mainPage.confirmCookie();
        mainPage.scrollPage();
        mainPage.clickSecondQuestion();
        mainPage.checkSecondAnswerText();
    }
    @Test
    public void checkQuestionThird(){
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        MainPage mainPage = new MainPage(driver);
        mainPage.openMainPage();
        mainPage.confirmCookie();
        mainPage.scrollPage();
        mainPage.clickThirdQuestion();
        mainPage.checkThirdAnswerText();
    }
    @Test
    public void checkQuestionFourth(){
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        MainPage mainPage = new MainPage(driver);
        mainPage.openMainPage();
        mainPage.confirmCookie();
        mainPage.scrollPage();
        mainPage.clickFourthQuestion();
        mainPage.checkFourthAnswerText();
    }
    @Test
    public void checkQuestionFifth(){
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        MainPage mainPage = new MainPage(driver);
        mainPage.openMainPage();
        mainPage.confirmCookie();
        mainPage.scrollPage();
        mainPage.clickFifthQuestion();
        mainPage.checkFifthAnswerText();
    }
    @Test
    public void checkQuestionSixth(){
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        MainPage mainPage = new MainPage(driver);
        mainPage.openMainPage();
        mainPage.confirmCookie();
        mainPage.scrollPage();
        mainPage.clickSixthQuestion();
        mainPage.checkSixthAnswerText();
    }
    @Test
    public void checkQuestionSeventh(){
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        MainPage mainPage = new MainPage(driver);
        mainPage.openMainPage();
        mainPage.confirmCookie();
        mainPage.scrollPage();
        mainPage.clickSeventhQuestion();
        mainPage.checkSeventhAnswerText();
    }
    @Test
    public void checkQuestionEighth(){
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        MainPage mainPage = new MainPage(driver);
        mainPage.openMainPage();
        mainPage.confirmCookie();
        mainPage.scrollPage();
        mainPage.clickEighthQuestion();
        mainPage.checkEighthAnswerText();
    }
    @After
    public void cleanUp() {
        driver.quit();
    }
}