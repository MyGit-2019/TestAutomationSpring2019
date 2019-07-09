package com.cybertek.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.swing.*;

public class DoubleClickTest extends TestBase {
    @Test
    public void test(){
        driver.get("http://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_ev_ondblclick2");
        driver.switchTo().frame("iframeResult");
        Actions actions=new Actions (driver);
        WebElement text=driver.findElement(By.id("demo"));
        actions.doubleClick(text).perform();
        Assert.assertTrue(text.getAttribute("style").contains("red"));





    }

}
