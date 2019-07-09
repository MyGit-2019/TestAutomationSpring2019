package com.cybertek.day7;

import com.cybertek.utilities.BrowserFactory;
import com.cybertek.utilities.SeleniumUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Set;
import java.util.concurrent.TimeUnit;

public class TabsExample {
    WebDriver driver;

    @BeforeMethod
    public void setUpMethod(){
        driver= BrowserFactory.getDriver("chrome");

    }

    //@Test
    public void changeTab(){

        driver.get("https://the-internet.herokuapp.com/windows");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        System.out.println(driver.getWindowHandles().size());

        driver.findElement(By.linkText("Click Here")).click();
        SeleniumUtils.waitPlease(2);

        System.out.println(driver.getWindowHandles().size());
        Set<String> windowHandles=driver.getWindowHandles();
        for(String handle:windowHandles) {
            System.out.println(handle);
            driver.switchTo().window(handle);
            SeleniumUtils.waitPlease(2);
            if (driver.getTitle().equals("New Window")) break;
        }


        String expected="New Window";
        String actual=driver.getTitle();
        Assert.assertEquals(actual,expected);
        Assert.assertNotEquals(actual,"Internet");





    }
    @Test
    public void changeTab2(){
        driver.get("https://w3schools.com/html");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.findElement(By.linkText("Try it Yourself »")).click();
        SeleniumUtils.waitPlease(2);

        //Set<String> windowHandles=driver.getWindowHandles();



        for(String handle:driver.getWindowHandles()) {
            System.out.println(handle);
            driver.switchTo().window(handle);
            SeleniumUtils.waitPlease(2);
            if (driver.getTitle().equals("Tryit Editor v3.6")) break;
        }


        Assert.assertTrue(driver.getCurrentUrl().contains("default"));
        System.out.println(driver.getWindowHandles().size());
        driver.close();
        System.out.println(driver.getWindowHandles().size());



    }




    @AfterClass
    public void cleanUp(){
        driver.quit();

    }


}
