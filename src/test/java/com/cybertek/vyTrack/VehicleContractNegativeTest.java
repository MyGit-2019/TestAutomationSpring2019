package com.cybertek.vyTrack;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class VehicleContractNegativeTest {
    public static void main(String[] args) throws Exception {

        WebDriverManager.chromedriver().setup();

        WebDriver driver=new ChromeDriver();
        driver.get("http://qa2.vytrack.com/");

        driver.findElement(By.id("prependedInput")).sendKeys("user165");

        driver.findElement(By.id("prependedInput2")).sendKeys("UserUser123");

        driver.findElement(By.id("_submit")).click();
        Thread.sleep(5000);
        Actions act=new Actions(driver);
        act.moveToElement(driver.findElement(By.xpath("//*[@id=\'main-menu\']/ul/li[1]"))).perform();

        Thread.sleep(5000);
        driver.findElement(By.xpath("//*[@id=\'main-menu\']/ul/li[1]/div/div/ul/li[6]/a/span")).click();
Thread.sleep(3000);

        System.out.println();
        if (driver.findElement(By.xpath("//*[@id=\'flash-messages\']/div/div/div[2]/div")).getText().equals("You do not have permission to perform this action.")) {
            System.out.println("Test PASS\nAs an unauthorized user <user165> cannot access Vehicle Contract Page");
            System.out.println("User reads this warning message:\n" + driver.findElement(By.xpath("//*[@id=\'flash-messages\']/div/div/div[2]/div")).getText());
        }
        else {

            System.out.println("Test FAIL\nAs an unauthorized user <user165> can access Vehicle Contract Page");
        }
        Thread.sleep(3000);
        driver.quit();








    }
}
