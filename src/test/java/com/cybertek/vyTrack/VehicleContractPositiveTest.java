package com.cybertek.vyTrack;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.SourceType;

public class VehicleContractPositiveTest {
    public static void main(String[] args) throws Exception {

        WebDriverManager.chromedriver().setup();

        WebDriver driver=new ChromeDriver();
        driver.get("http://qa2.vytrack.com/");

        driver.findElement(By.id("prependedInput")).sendKeys("storemanager98");

        driver.findElement(By.id("prependedInput2")).sendKeys("UserUser123");

        driver.findElement(By.id("_submit")).click();

        Actions act=new Actions(driver);
        act.moveToElement(driver.findElement(By.xpath("//*[@id=\'main-menu\']/ul/li[2]/a/span"))).perform();

        Thread.sleep(5000);
        driver.findElement(By.xpath("//div[@id=\'main-menu\']/ul/li[2]/div/div/ul/li[6]/a/span")).click();

        String expectedUrl="http://qa2.vytrack.com/entity/Extend_Entity_VehicleContract";
        String actualUrl=driver.getCurrentUrl();

        if (expectedUrl.equals(actualUrl)) System.out.println("Test PASS\nAs an authorized user storemanager98 can access Vehicle Contract Page");
        else {
            System.out.println("Expected URL: " + expectedUrl);
            System.out.println("Actual URL: " + actualUrl);
            System.out.println("Test FAIL\nAs an authorized user storemanager98 cannot access Vehicle Contract Page");
        }
        Thread.sleep(3000);
        driver.quit();








    }
}
