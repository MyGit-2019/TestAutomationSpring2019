package com.cybertek.tests;

import com.cybertek.utilities.BrowserFactory;
import com.cybertek.utilities.SeleniumUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class IFrameDemo {
    WebDriver driver;
    Select allDepartments;

    @BeforeClass
    public void setUpMethod(){
        driver= BrowserFactory.getDriver("chrome");
        driver.get("https://the-internet.herokuapp.com/tinymce");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        }
    @Test(priority = 0)
    public void testDefaultValue(){
        SeleniumUtils.waitPlease(3);

       // WebElement iframe= driver.findElement(By.id("mce_0_ifr"));
        //driver.switchTo().frame(iframe);
        driver.switchTo().frame(0);

        driver.findElement(By.id("tinymce")).clear();
        driver.findElement(By.id("tinymce")).sendKeys("something something");



        //driver.findElement(By.tagName("body")).clear();
        //driver.findElement(By.tagName("body")).sendKeys("something something");

        SeleniumUtils.waitPlease(3);
        driver.switchTo().parentFrame();

        driver.findElement(By.linkText("Elemental Selenium")).click();
        SeleniumUtils.waitPlease(2);


    }
    @Test(priority = 1)
    public void testSortAlphabetical(){

    }
    @Test (priority = 2)
    public void mainDepartmentsTest(){


    }




    @AfterClass
    public void cleanUp(){
        driver.quit();

    }





}
