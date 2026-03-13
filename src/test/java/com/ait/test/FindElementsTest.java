package com.ait.test;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FindElementsTest {

    WebDriver driver;

    @BeforeMethod

    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://icarro-v1.netlify.app/search?page=0&size=10");
        driver.manage().window().maximize();
        //driver.manage().window().setSize(new Dimension( 900, 400));


    }

    @Test
    public void findElementByTagNameTest() {

        //поиск элемента по тексту стратегия ByTagName
        WebElement element = driver.findElement(By.tagName("h1"));
        System.out.println(element.getText());

        //поиск элемента по тексту стратегия ByTagName - a
        WebElement link = driver.findElement(By.tagName("a"));
        System.out.println(link.getText());

        //поиск WEB element по label
        WebElement label = driver.findElement(By.tagName("label"));
        System.out.println(label.getText());



    }

    @Test  // Поиск по id
    public void findElementById(){
        WebElement city = driver.findElement(By.id("city"));
        System.out.println(city.getDomAttribute("id"));

        WebElement dates = driver.findElement(By.id("dates"));
        System.out.println(dates.getDomAttribute("id"));
    }

    @Test // Поиск элементов по классу
    public void findElementByClassName(){
        WebElement telephone = driver.findElement(By.className("telephone"));
        System.out.println(telephone.getText());

        WebElement search = driver.findElement(By.className("navigation-link"));
        System.out.println(search.getText());
        System.out.println(search.getDomAttribute("class"));
    }

    @AfterMethod(enabled = false)

    public void tearDown() {
        driver.quit();
    }
}
