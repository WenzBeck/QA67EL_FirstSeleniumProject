package com.ait.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class FindDemoWebShopElement {

            WebDriver driver;

        @BeforeMethod
        public void setUp() {
            driver = new ChromeDriver();
            driver.get("https://demowebshop.tricentis.com");
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        }
            @Test
            public void findElementByCssSelector(){
                //1.register link
                driver.findElement(By.cssSelector("[href='/register']"));
                //2.search input
                driver.findElement(By.cssSelector("#small-searchterms"));
                //3.search class
                driver.findElement(By.cssSelector(".header-logo"));
                //4.search tag "h1" не смог найти //failed
                //5.one step below
                driver.findElement(By.cssSelector(".header-logo>img")); //failed
                //6.search end to $
                driver.findElement(By.cssSelector("[class$='ico-register']")); //failed
                //7.




        }
        @AfterMethod
        public void tearDown(){
            driver.quit();
        }
}
