package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class ConsumerDataPage {
    //Поле "Имя"
    private  By inputName = By.xpath("//input[@placeholder = '* Имя']");
    //Поле "Фамилия"
    private  By inputSurname = By.xpath("//input[@placeholder = '* Фамилия']");
    //Поле "Адрес"
    private  By inputAddress = By.xpath("//input[@placeholder = '* Адрес: куда привезти заказ']");
    //Поле "Станция метро"
    private  By inputStation = By.xpath("//input[@placeholder = '* Станция метро']");
    //Поле "Телефон: на него позвонит курьер"
    private  By inputPhone = By.xpath("//input[@placeholder = '* Телефон: на него позвонит курьер']");
    //Кнопка "Далее"
    private By nextButton = By.cssSelector("div.Order_NextButton__1_rCA  button");
    private String name = "Семен";
    private String surname = "Семенов";
    private String address = "Москва";
    private String phone = "89009009090";
    private final WebDriver driver;
    public ConsumerDataPage(WebDriver driver) {
        this.driver = driver;
    }
    //Заполнение поля "Имя"
    public void inputConsumerData(){
        driver.findElement(inputName).sendKeys(name);
        //Заполнение поля "Фамилия"
        driver.findElement(inputSurname).sendKeys(surname);
        //Заполнение поля "Адрес"
        driver.findElement(inputAddress).sendKeys(address);
        //Заполнение поля "Станция метро"
        driver.findElement(inputStation).click();
        driver.findElement(inputStation).sendKeys(Keys.DOWN);
        driver.findElement(inputStation).sendKeys(Keys.ENTER);
        //Заполнение поля "Телефон"
        driver.findElement(inputPhone).sendKeys(phone);
    }
    //Кликнуть "Далее"
    public void checkNext(){
        driver.findElement(nextButton).click();
        }
}
