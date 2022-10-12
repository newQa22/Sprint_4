package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;


public class MainPage {
    private final WebDriver driver;
    //URL главной страницы
    private static final String MAIN_PAGE_URL = "https://qa-scooter.praktikum-services.ru";
    // Кнопка "Да все привыкли"
    private  By cookieButton = By.cssSelector("button.App_CookieButton__3cvqF");
    //Вопросы
    //Выпадающий список. Вопрос1: Сколько это стоит?
    private  By dropdownQuestionPaid = By.xpath("//div[text() ='Сколько это стоит? И как оплатить?']");
    //выпадающий список. Вопрос2: Несколько самокатов?
    private  By dropdownQuestionSomeScooter = By.xpath("//div[text() ='Хочу сразу несколько самокатов! Так можно?']");
    //выпадающий список. Вопрос3: Как расчитывается время аренды?
    private  By dropdownQuestionRentTime = By.xpath("//div[text() = 'Как рассчитывается время аренды?']");
    //выпадающий список. Вопрос4: Можно заказать самокат сегодня?
    private  By dropdownQuestionTodayScooter = By.xpath("//div[text() = 'Можно ли заказать самокат прямо на сегодня?']");
    //выпадающий список. Вопрос5: Можно сокращать/продлевать время?
    private  By dropdownQuestionChangeTime = By.xpath("//div[text() = 'Можно ли продлить заказ или вернуть самокат раньше?']");
    //выпадающий список. Вопрос6: Привозите зарядку с самокатом?
    private  By dropdownQuestionChargerScooter = By.xpath("//div[text() = 'Вы привозите зарядку вместе с самокатом?']");
    //выпадающий список. Вопрос7: Можно отменить заказ?
    private  By dropdownQuestionCancelledOrder = By.xpath("//div[text() = 'Можно ли отменить заказ?']");
    //выпадающий список. Вопрос8: Привезете за МКАД?
    private  By dropdownQuestionDeliveryOutside = By.xpath("//div[text() = 'Я жизу за МКАДом, привезёте?']");
    // Ответы
    // Текст ответа на 1 вопрос
    private static final String TEXT_ANSWER_PAID = "Сутки — 400 рублей. Оплата курьеру — наличными или картой.";
    //Локатор ответа 1
    private  By answerPaid = By.xpath("//div[@class = 'accordion__panel']/p[text()='Сутки — 400 рублей. Оплата курьеру — наличными или картой.']");
    // Текст ответа на 2 вопрос
    private static final String TEXT_ANSWER_SOME_SCOOTER = "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.";
    //Локатор ответа 2
    private By answerSomeScooter = By.xpath("//p[text() = 'Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.']");
    // Текст ответа на 3 вопрос
    private static final String  TEXT_RENT_TIME = "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.";
    // Локатор ответа 3
    private  By rentTime = By.xpath("//p[text() = 'Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.']");
    // Текст ответа на 4 вопрос
    private static final String TEXT_TODAY_SCOOTER = "Только начиная с завтрашнего дня. Но скоро станем расторопнее.";
    //Локатор ответа 4
    private  By todayScooter = By.xpath("//p[text() = 'Только начиная с завтрашнего дня. Но скоро станем расторопнее.']");
    // Текст ответа на 5 вопрос
    private static final String TEXT_CHANGE_TIME = "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.";
    //Локатор ответа 5
    private By changeTime = By.xpath("//p[text() = 'Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.']");
    // Текст ответа на 6 вопрос
    private static final String TEXT_CHARGER_SCOOTER = "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.";
    // Локатор ответа 6
    private By chargerScooter = By.xpath("//p[text() = 'Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.']");
    // Текст ответа на 7 вопрос
    private static final String TEXT_CANCELLED_ORDER = "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.";
    // Локатор ответа 7
    private  By cancelledOrder = By.xpath("//p[text() = 'Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.']");
    // Текст ответа на 8 вопрос
    private static final String TEXT_DELIVERY_OUTSIDE = "Да, обязательно. Всем самокатов! И Москве, и Московской области.";
    //локатор ответа 8
    private By deliveryOutside = By.xpath("//p[text() = 'Да, обязательно. Всем самокатов! И Москве, и Московской области.']");
    //Кнопка "Заказать" вверху страницы
    private By checkOrderButtonUp = By.xpath("//button[@class = 'Button_Button__ra12g' and text() = 'Заказать']");
    //Кнопка "Заказать" внизу страницы
    private By checkOrderButtonDown = By.xpath("//button[@class = 'Button_Button__ra12g Button_Middle__1CSJM' and text() = 'Заказать']");
    public MainPage(WebDriver driver) {
        this.driver = driver;
    }
    //Открыть главную страницу
    public void openMainPage(){
    driver.get(MAIN_PAGE_URL);
    }
    //Принять куки
    public void confirmCookie(){
        driver.findElement(cookieButton).click();
            }
    //Скролл страницы
    public void scrollPage(){
        WebElement element = driver.findElement(By.id("root"));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
            }
    //Кликнуть выпадающий список 1 вопроса
    public void clickFirstQuestion(){
        driver.findElement(dropdownQuestionPaid).click();
            }
     //Проверка текста ответа на первый вопрос
    public void checkFirstAnswerText() {
        String actual = driver.findElement(answerPaid).getText();
        Assert.assertEquals(actual, TEXT_ANSWER_PAID);
            }
    //Кликнуть выпадающий список 2 вопроса
    public void clickSecondQuestion(){
        driver.findElement(dropdownQuestionSomeScooter).click();
    }
    //Проверка текста ответа на второй вопрос
    public void checkSecondAnswerText() {
        String actual = driver.findElement(answerSomeScooter).getText();
        Assert.assertEquals(actual, TEXT_ANSWER_SOME_SCOOTER);
    }
    //Кликнуть выпадающий список 3 вопроса
    public void clickThirdQuestion(){
        driver.findElement(dropdownQuestionRentTime).click();
    }
    //Проверка текста ответа на третий  вопрос
    public void checkThirdAnswerText() {
        String actual = driver.findElement(rentTime).getText();
        Assert.assertEquals(actual, TEXT_RENT_TIME);
    }
    //Кликнуть выпадающий список 4 вопроса
    public void clickFourthQuestion(){
        driver.findElement(dropdownQuestionTodayScooter).click();
    }
    //Проверка текста ответа на четвертый вопрос
    public void checkFourthAnswerText() {
        String actual = driver.findElement(todayScooter).getText();
        Assert.assertEquals(actual, TEXT_TODAY_SCOOTER);
    }
    //Кликнуть выпадающий список 5 вопроса
    public void clickFifthQuestion(){
        driver.findElement(dropdownQuestionChangeTime).click();
    }
    //Проверка текста ответа на пятый вопрос
    public void checkFifthAnswerText() {
        String actual = driver.findElement(changeTime).getText();
        Assert.assertEquals(actual, TEXT_CHANGE_TIME);
    }
    //Кликнуть выпадающий список 6 вопроса
    public void clickSixthQuestion(){
        driver.findElement(dropdownQuestionChargerScooter).click();
    }
    //Проверка текста ответа на шестой вопрос
    public void checkSixthAnswerText() {
        String actual = driver.findElement(chargerScooter).getText();
        Assert.assertEquals(actual, TEXT_CHARGER_SCOOTER);
    }
    //Кликнуть выпадающий список 7 вопроса
    public void clickSeventhQuestion(){
        driver.findElement(dropdownQuestionCancelledOrder).click();
    }
    //Проверка текста ответа на седьмой вопрос
    public void checkSeventhAnswerText() {
        String actual = driver.findElement(cancelledOrder).getText();
        Assert.assertEquals(actual, TEXT_CANCELLED_ORDER);
    }
    //Кликнуть выпадающий список 8 вопроса
    public void clickEighthQuestion(){
        driver.findElement(dropdownQuestionDeliveryOutside).click();
    }
    //Проверка текста ответа на восьмой вопрос
    public void checkEighthAnswerText() {
        String actual = driver.findElement(deliveryOutside).getText();
        Assert.assertEquals(actual, TEXT_DELIVERY_OUTSIDE);
    }
    //Кликнуть "Заказать" вверху страницы
    public void checkOrderButtonUp(){
        driver.findElement(checkOrderButtonUp).click();
    }
    //Кликнуть "Заказать" внизу страницы
    public void checkOrderButtonDown(){
        driver.findElement(checkOrderButtonDown).click();
    }
}
