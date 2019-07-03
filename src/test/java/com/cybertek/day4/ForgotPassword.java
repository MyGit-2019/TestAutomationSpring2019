package com.cybertek.day4;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ForgotPassword {
    public static void main(String[] args) throws Exception {

        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().fullscreen();
        Thread.sleep(3000);

        driver.get("http://practice.cybertekschool.com/forgot_password");

        //WebElement submitButton =driver.findElement(By.id("form_submit"));

        driver.findElement(By.name("email")).sendKeys("abc@email.com");
        WebElement submitButton= driver.findElement(By.xpath("//button[@id='form_submit']"));


        submitButton.click();

        String actual=driver.findElement(By.name("confirmation_message")).getText();
        if (actual.equals("Your e-mail's been sent!")) System.out.println("PASS");
        else System.out.println("FAILED actual: "+actual);
        Thread.sleep(3000);
        driver.close();





    }

}
