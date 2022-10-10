package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class ConsumerDataPage {
    //Поле "Имя"
    private static final By INPUT_NAME = By.xpath("//input[@placeholder = '* Имя']");
    //Поле "Фамилия"
    private static final By INPUT_SURNAME = By.xpath("//input[@placeholder = '* Фамилия']");
    //Поле "Адрес"
    private static final By INPUT_ADDRESS = By.xpath("//input[@placeholder = '* Адрес: куда привезти заказ']");
    //Поле "Станция метро"
    private static final By INPUT_STATION = By.xpath("//input[@placeholder = '* Станция метро']");
    //Поле "Телефон: на него позвонит курьер"
    private static final By INPUT_PHONE = By.xpath("//input[@placeholder = '* Телефон: на него позвонит курьер']");
    //Кнопка "Далее"
    private static final By NEXT_BUTTON = By.cssSelector("div.Order_NextButton__1_rCA  button");
    String name = "Семен";
    String surname = "Семенов";
    String address = "Москва";
    String phone = "89009009090";

    private final WebDriver driver;



    public ConsumerDataPage(WebDriver driver) {
        this.driver = driver;
    }


    //Заполнение поля "Имя"
    public void inputConsumerData(){

        driver.findElement(INPUT_NAME).sendKeys(name);
    //Заполнение поля "Фамилия"
        driver.findElement(INPUT_SURNAME).sendKeys(surname);
        //Заполнение поля "Адрес"
        driver.findElement(INPUT_ADDRESS).sendKeys(address);
        //Заполнение поля "Станция метро"
        driver.findElement(INPUT_STATION).click();
        driver.findElement(INPUT_STATION).sendKeys(Keys.DOWN);
        driver.findElement(INPUT_STATION).sendKeys(Keys.ENTER);
        //Заполнение поля "Телефон"
        driver.findElement(INPUT_PHONE).sendKeys(phone);
    }
    //Кликнуть "Далее"
    public void checkNext(){
        driver.findElement(NEXT_BUTTON).click();
        }

}
