package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class RentDataPage {
    //Страница"Про аренду". Поле "Когда привезти самокат"
    private By inputWhenDelivered = By.cssSelector("div.react-datepicker__input-container  input");
    //Страница"Про аренду". Поле "Срок аренды"
    private  By inputTimeRent = By.xpath("//div[@class = 'Dropdown-placeholder' and text() = '* Срок аренды']");
    //Выпадающий список
    private  By selectTime = By.xpath("//div[@class = 'Dropdown-menu']/div[@class = 'Dropdown-option' and text()='сутки']");
    // Страница"Про аренду". Кнопка вверху "Заказать"
    private  By rentOrderButtonUp = By.xpath("//div[@ class= 'Header_Nav__AGCXC']/button[text()='Заказать']");
    //Страница"Про аренду". Кнопка внизу "Заказать"
    private static final By rentOrderButtonDown = By.xpath("//div[@class='Order_Buttons__1xGrp']/button[text()='Заказать']");
    // Подтверждение оформления заказа. Кнопка "Да"
    private  By confirmOrderButton = By.xpath("//button[@class = 'Button_Button__ra12g Button_Middle__1CSJM' and text() = 'Да']");
    //
    private  By modalOrdered = By.xpath("//div[@class='Order_ModalHeader__3FDaJ']");
    private static final String TEXT_DELIVERY_ORDERED = "Заказ оформлен";
    private final WebDriver driver;
    public RentDataPage(WebDriver driver) {
        this.driver = driver;
    }
    //Заполнение поля "Когда привезти самокат" раздел "Про аренду"
    public void inputRentData(){
        driver.findElement(inputWhenDelivered).click();
        driver.findElement(inputWhenDelivered).sendKeys(Keys.ENTER);
        driver.findElement(inputTimeRent).click();
        driver.findElement(selectTime).click();
        }
    public void checkOrderButtonUp(){
        driver.findElement(rentOrderButtonUp).click();
    }
    public void confirmOrder(){
        driver.findElement(confirmOrderButton).click();
    }
    public void checkOrdered(){
        String actual = driver.findElement(modalOrdered).getText();
        Assert.assertEquals(actual, TEXT_DELIVERY_ORDERED);
    }
    public void checkOrderButtonDown(){
        driver.findElement(rentOrderButtonDown).click();
    }
}
