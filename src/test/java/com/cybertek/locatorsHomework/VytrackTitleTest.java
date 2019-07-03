package com.cybertek.locatorsHomework;

import com.cybertek.utilities.BrowserFactory;
import com.cybertek.utilities.SeleniumUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

//        1.Open browser
//        2.Go to Vytrack login page
//        3.Login as any user
//        4.Click on your name on top right
//        5.Click on  My Configuration
//        6.Verify that title start with the same name on top right




public class VytrackTitleTest {
    static WebDriver driver= BrowserFactory.getDriver("chrome");

    public static void main(String[] args) {

        openTheWebsite("http://qa2.vytrack.com/user/login");
        test1();
        driver.quit();

    }

    public static void openTheWebsite(String Website){
        driver.get(Website);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);




    }
    public static void test1()  {

        driver.findElement(By.id("prependedInput")).sendKeys("user165");
        driver.findElement(By.id("prependedInput2")).sendKeys("UserUser123"+ Keys.ENTER);
        SeleniumUtils.waitPlease(3);

        String expected =driver.findElement(By.xpath("//a[@class='dropdown-toggle']")).getText();
        driver.findElement(By.xpath("//a[@class='dropdown-toggle']")).click();
        SeleniumUtils.waitPlease(2);

        driver.findElement(By.linkText("My Configuration")).click();
        SeleniumUtils.waitPlease(3);
        String actual=driver.getTitle();
        if(actual.startsWith(expected)) System.out.println("Test Pass");
        else System.out.println("Test Fail\nTitle is "+actual);

        SeleniumUtils.waitPlease(3);



    }

}
