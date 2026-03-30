package com.ait.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class HW_FindxPath_Elements {

    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://icarro-v1.netlify.app/search?page=0&size=10");
    }

    @Test
    public void findElementByXPath(){

        driver.findElement(By.xpath("//p"));
        driver.findElement(By.xpath("//a"));
        driver.findElement(By.xpath("//*[@id='dates']"));
        driver.findElement(By.xpath("//*[@class='input-label ']"));
        //driver.findElement(By.xpath("//*[text()='Fabulous car!']")); test failled
        //driver.findElement(By.xpath("//*[.()='Fabulous car!']")); test failled
        WebElement element = driver.findElement(By.xpath("//p[contains(text(),'Not so dramatic consumption')]"));
        driver.findElement(By.xpath("//*[@class='feedback-card']/parent::*"));
        driver.findElement(By.xpath("//*[@class='feedback-grid']/parent::*"));
        driver.findElement(By.xpath("//span[@class='feedback-name']"));


    }

    @AfterMethod
    public void dearDown(){
        driver.quit();
    }
}
