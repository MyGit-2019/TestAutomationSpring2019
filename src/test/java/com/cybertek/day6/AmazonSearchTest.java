package com.cybertek.day6;

//
//    TEST 1
//    go to amazon
//    enter any search term
//    click on search button
//    verify title contains search term


import com.cybertek.utilities.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class AmazonSearchTest {
    static WebDriver driver= BrowserFactory.getDriver("chrome");

    public static void main(String[] args) throws Exception{
        test1();
driver.quit();

    }
    public static void test1() throws Exception{
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://amazon.com");

String searchText="book";
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys(searchText+ Keys.ENTER);
Thread.sleep(3000);
if (driver.getTitle().contains(searchText)) System.out.println("passed");
else{
    System.out.println("Test Failed\nActual Title: "+driver.getTitle());
}









    }




}
