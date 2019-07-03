package com.cybertek.day5Locators;

import com.cybertek.utilities.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class EbayTest {

    static WebDriver driver = BrowserFactory.getDriver("chrome");

    public static void main(String[] args) {
        test1();
    }


    public static void test1() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://ebay.com");
        driver.findElement(By.id("gh-ac")).sendKeys("Java Book" + Keys.ENTER);
        System.out.println("Results count: " + driver.findElement(By.className("srp-controls__count-heading")).getText());

        List<WebElement> results = driver.findElements(By.className("s-item"));
        System.out.println("count on page: " + results.size());


    }
}