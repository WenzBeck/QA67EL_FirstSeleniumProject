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

    @Test
    public void findElement(){
        WebElement LinkText = driver.findElement(By.linkText("Let car work"));
        System.out.println(LinkText.getText());
    }

    @Test
    public void findElementByPartialLinkText() {
        WebElement partialLinkText = driver.findElement(By.partialLinkText("work"));
    }

    //поиск по ByCss Selector
    @Test
    public void findElementByCssSelector(){
        //driver.findElement(By.tagName("h1"));
        //tagName h1 -> "h1"
        driver.findElement(By.cssSelector("h1"));

        //driver.findElement(By.id("city"));
        //id = "city"-> #css
        driver.findElement(By.cssSelector("#city"));

        //driver.findElement(By.className("telephone"));
        //className = "telephone" -> css.telephone
        driver.findElement(By.cssSelector(".telephone"));

        //частичное совпадение, contains/start/end to
        //contains *
        driver.findElement(By.cssSelector("[class*='container']"));
        //start ^
        driver.findElement(By.cssSelector("[class^='input']"));
        //end to $
        driver.findElement(By.cssSelector("[class$='icon']"));

        //[for='city'] для поиска элемента в консоли браузера в SelectorsHub вводится команда в квадратных скобках с одинарными ковычками
        //[key='value']
        driver.findElement(By.cssSelector("[placeholder='City']"));

        //tag+class+class составной селектор composition
        driver.findElement(By.cssSelector("a.navigation-link.active"));

        //one step below(один шаг вниз)
        driver.findElement(By.cssSelector(".logo>img"));

        //.feedback-card:nth-child(3) достучаться до детей
        //<tag> or <class> or <id>:nth-child(number child)
        driver.findElement(By.cssSelector(".feedback-card:nth-child(1)"));
        driver.findElement(By.cssSelector(".navigation-link:nth-child(2)"));


    }

    // xPath
    @Test
    public void findElementByxPath(){

        // -> синтаксис//какой-то tag[@attribute='value']  в квадратных скобках находится предикат, условие отвечающее тегу
        // tag[text()='title'] поиск по точному совпадению текста. text это метод.
        // * - значит искать везде

        //driver.findElement(By.cssSelector("h1"));
        driver.findElement(By.xpath("//h1"));

        //driver.findElement(By.cssSelector("#city"));
        driver.findElement(By.xpath("//*[@id='city']"));

        //driver.findElement(By.cssSelector(".telephone"));
        driver.findElement(By.xpath("//*[@class='telephone']"));

        // driver.findElement(By.cssSelector("[class*='container']"));
        //driver.findElement(By.xpath("//*[class*='container']")); - не работает
        WebElement element = driver.findElement(By.xpath("//p[contains(text(),'best services')]"));
        System.out.println(element.getText());

        //equals text
        driver.findElement(By.xpath("//*[text()='Find your car now!']"));
        //driver.findElement(By.xpath("//*[.()='Find your car now!']")); второй способ

        //driver.findElement(By.cssSelector(".logo>img"));
       // driver.findElement(By.xpath("//*[@class='logo']/img")); - тест не прошел



    }


    @AfterMethod(enabled = false)

    public void tearDown(){
        driver.quit();
    }
}
