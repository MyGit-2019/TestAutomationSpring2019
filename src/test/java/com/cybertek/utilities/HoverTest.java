package com.cybertek.utilities;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HoverTest extends TestBase{
    @Test
    public void amazonTest(){
        driver.get("http://amazon.com ");
        actions.moveToElement(driver.findElement(By.xpath("//span[contains(text(),'Hello, Sign in')]"))).perform();

        driver.findElement(By.xpath("//span[contains(text(),'Your Hearts')]")).click();
        SeleniumUtils.waitPlease(3);

        Assert.assertTrue(driver.getTitle().contains("Interesting"));




    }



}
