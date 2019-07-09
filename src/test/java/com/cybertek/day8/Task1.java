package com.cybertek.day8;

import com.cybertek.utilities.BrowserFactory;
import com.cybertek.utilities.SeleniumUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Task1 {
    WebDriver driver;



    @BeforeMethod
    public void setup(){
    driver= BrowserFactory.getDriver("chrome");


    }

    @AfterMethod
    public void tearDown(){
        driver.quit();

}




    @Test
    public void defaultDate(){
        driver.get("http://practice.cybertekschool.com/dropdown");
        SeleniumUtils.waitPlease(3);
        Select selectYear=new Select(driver.findElement(By.id("year")));
        Assert.assertEquals(selectYear.getFirstSelectedOption().getText(),"2018");

        Select selectMonth=new Select(driver.findElement(By.id("month")));
        Assert.assertEquals(selectMonth.getFirstSelectedOption().getText(),"June");

        Select selectDay=new Select(driver.findElement(By.id("day")));
        Assert.assertEquals(selectDay.getFirstSelectedOption().getText(),"9");


    }

}
