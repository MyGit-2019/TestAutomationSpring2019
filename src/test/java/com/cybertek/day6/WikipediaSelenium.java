package com.cybertek.day6;

import com.cybertek.utilities.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;



//
//TEST 2
//        go to wikipedia.org
//        enter search term ‘selenium webdriver’
//        click on search button
//        click on search result ‘Selenium (software)’
//        verify url ends with ‘x’
public class WikipediaSelenium {
    static WebDriver driver= BrowserFactory.getDriver("chrome");

    public static void main(String[] args) throws Exception{
        test1();
        driver.quit();


    }
    public static void test1() throws Exception{
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://wikipedia.org");

        String searchText="selenium webdriver";
        driver.findElement(By.id("searchInput")).sendKeys(searchText+ Keys.ENTER);
        Thread.sleep(3000);
        driver.findElement(By.xpath("//a[@title='Selenium (software)']")).click();
        Thread.sleep(3000);


        if (driver.getCurrentUrl().endsWith("x")) System.out.println("passed");
        else{
            System.out.println("Test Failed\nActual URL: "+driver.getCurrentUrl());
        }









    }




}
