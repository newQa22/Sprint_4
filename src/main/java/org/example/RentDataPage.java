package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class RentDataPage {
    //Страница"Про аренду". Поле "Когда привезти самокат"
    private static final By INPUT_WHEN_DELIVERED = By.cssSelector("div.react-datepicker__input-container  input");
    //Страница"Про аренду". Поле "Срок аренды"
    private static final By INPUT_TIME_RENT = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[2]/div/div[1]");
    //Выпадающий список
    private static final By SELECT_TIME = By.xpath("//div[2]/div[2]/div[2]/div[2]/div[1]");
    // Страница"Про аренду". Кнопка вверху "Заказать"
    private static final By RENT_ORDER_BUTTON_UP = By.xpath("//div[@ class= 'Header_Nav__AGCXC']/button[text()='Заказать']");
    //Страница"Про аренду". Кнопка внизу "Заказать"
    private static final By RENT_ORDER_BUTTON_DOWN = By.xpath("//div[@class='Order_Buttons__1xGrp']/button[text()='Заказать']");

    // Подтверждение оформления заказа. Кнопка "Да"
    private static final By CONFIRM_ORDER_BUTTON = By.xpath("//div[5]/div[2]/button[text()='Да']");
    //
    private static final By MODAL_ORDERED = By.xpath("//div[@class='Order_ModalHeader__3FDaJ']");
    private static final String TEXT_DELIVERY_ORDERED = "Заказ оформлен";
    private final WebDriver driver;

    public RentDataPage(WebDriver driver) {
        this.driver = driver;
    }
    //Заполнение поля "Когда привезти самокат" раздел "Про аренду"
    public void inputRentData(){
        driver.findElement(INPUT_WHEN_DELIVERED).sendKeys("07.10.2022");
        driver.findElement(INPUT_WHEN_DELIVERED).sendKeys(Keys.ENTER);
        driver.findElement(INPUT_TIME_RENT).click();
        driver.findElement(SELECT_TIME).click();
        }
    public void checkOrderButtonUp(){
        driver.findElement(RENT_ORDER_BUTTON_UP).click();
    }
    public void confirmOrder(){
        driver.findElement(CONFIRM_ORDER_BUTTON).click();
    }
    public void checkOrdered(){
        String actual = driver.findElement(MODAL_ORDERED).getText();
        Assert.assertEquals(actual, TEXT_DELIVERY_ORDERED);
    }

    public void checkOrderButtonDown(){
        driver.findElement(RENT_ORDER_BUTTON_DOWN).click();

    }
}
