package com.ait.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class Hw_12_TestLocation {


    WebDriver driver;
    @BeforeMethod

    public void setUp(){
        driver = new ChromeDriver();
        driver.get("https://demowebshop.tricentis.com/");
        driver.manage().window().maximize();
    }

    @Test

    // Нашел элемент по тегу "title" Demo Web Shop в HEAD и тег "span" в Categories
    public void findElementByTagName(){

        WebElement title = driver.findElement(By.tagName("title"));
        System.out.println(title.getText());
        System.out.println(title.getDomAttribute("title"));

        WebElement span = driver.findElement(By.tagName("span"));
        System.out.println(span.getText());

        // Не знаю насколько мой выбор по тегам верный, т.к. думаю, что теги title, span являются не уникальными, а списком...

    }

    @Test
    // Нашел элемент по тегу id
    public void findElementById(){

        WebElement button = driver.findElement(By.id("mob-menu-button"));
        System.out.println(button.getText());
        System.out.println(button.getDomAttribute("mob-menu-button"));

    }

    @Test

    // Нашел элемент по классу
    public void findElementByClassName(){

        WebElement wrapper = driver.findElement(By.className("master-wrapper-page"));
        System.out.println(wrapper.getText());

        WebElement header = driver.findElement(By.className("header"));
        System.out.println(header.getDomAttribute("header"));


    }

    @Test
    // Поиск по списку, сделал потому, что забыл как это делать и решил вспомнить...
     public void findElementsByList(){

        List<WebElement> li = driver.findElements(By.tagName("li"));
        System.out.println(); // здесь пробовал разное, но так и не понял, что нужно указать в скобках...
    }

    @AfterMethod

    public void tearDown(){
        driver.quit(); // закрывает весь браузер + WebDriver сессию, не только текущую вкладку
    }
}
