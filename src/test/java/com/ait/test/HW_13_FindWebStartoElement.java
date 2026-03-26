package com.ait.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class HW_13_FindWebStartoElement {

    WebDriver driver;

    @BeforeMethod

    public void setUp(){
        driver = new ChromeDriver();
        driver.get("https://www.strato.de/webshop/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(12));
    }

    @Test
    public void FindElementByCssSelector(){

        //01
        //находил элемент по тегу h1
        driver.findElement(By.cssSelector("h1"));

        //02
        //находил элемент по id
        driver.findElement(By.cssSelector("#consentLayerOne"));

        //03
        //находил элемент по классу
        driver.findElement(By.cssSelector(".clearfix consent--text")); //тест провален, не могу понять почему...

        //04
        //находил составной селектор по тегу+класс+класс
        driver.findElement(By.cssSelector(""));
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
