package com.cybertek.tests;

import com.cybertek.utilities.SeleniumUtils;
import com.cybertek.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GoogleDemo extends TestBase {
    @Test
    public void searchTest(){
        driver.get("http://google.com");
        driver.findElement(By.cssSelector(".gLFyf.gsfi")).sendKeys("Selenium Cookbook"+ Keys.ENTER);
        SeleniumUtils.waitPlease(3);

        Assert.assertTrue(driver.getTitle().contains("Selenium Cookbook"));

    }


}
