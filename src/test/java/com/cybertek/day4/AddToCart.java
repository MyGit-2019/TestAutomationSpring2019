package com.cybertek.day4;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AddToCart {
    public static void main(String[] args) throws Exception{
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("http://www.google.com");
        Thread.sleep(2000);
        driver.navigate().to("http://www.amazon.com");
        Thread.sleep(2000);
        //driver.findElement(By.id("twotabsearchtextbox")).sendKeys("walter savitch java book"+ Keys.ENTER);
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("walter savitch java book");
        driver.findElement(By.className("nav-input")).click();
        Thread.sleep(2000);
        driver.findElement(By.linkText("Java: An Introduction to Problem Solving and Programming (8th Edition)")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("add-to-cart-button")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("hlb-view-cart-announce")).click();
        Thread.sleep(2000);
        String textBook= driver.findElement(By.xpath("//span[@class='a-size-medium sc-product-title a-text-bold']")).getText();
        //System.out.println(textBook);
        Thread.sleep(2000);
        String quantity=driver.findElement(By.name("quantity")).getAttribute("value");
        //System.out.println(quantity);

        if(textBook.equals("Java: An Introduction to Problem Solving and Programming (8th Edition)")&&quantity.equals("1"))
            System.out.println("Test PASS. The Book <Java: An Introduction to Problem Solving and Programming (8th Edition)> added to cart");
            else System.out.println("FAIL");

            Thread.sleep(2000);
        driver.quit();


    }
}