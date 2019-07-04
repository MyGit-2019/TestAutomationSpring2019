package com.cybertek.batch8Practice;

import com.cybertek.utilities.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class ATestThatCleansUp {

    static WebDriver driver= BrowserFactory.getDriver("chrome");

    @Test
    public void searchAmazon(){
        driver.get("http://amazon.com");
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("fathers day gift"+ Keys.ENTER);
        Assert.assertTrue(driver.getTitle().contains("fathers day gift"));





    }
    @AfterMethod
    public void tearDown(){
    driver.close();

}
}
