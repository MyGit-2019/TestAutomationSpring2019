package com.cybertek.day6;

import com.cybertek.utilities.BrowserFactory;
import com.cybertek.utilities.SeleniumUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class CheckBoxTests {
    public static WebDriver driver=BrowserFactory.getDriver("chrome");

    public static void main(String[] args) {

        openTheWebsite("http://practice.cybertekschool.com/checkboxes");


        test1();


        SeleniumUtils.waitPlease(3);

        driver.quit();

    }

    public static void openTheWebsite(String Website){
        driver.get(Website);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        WebElement checkbox1 = driver.findElement(By.xpath("//input[@type='checkbox'][1]"));
        WebElement checkbox2 = driver.findElement(By.xpath("//input[@type='checkbox'][2]"));



        System.out.println(checkbox1.isSelected() ? "Selected" : "Not Selected" );
        System.out.println(checkbox2.isSelected() ? "Selected" : "Not Selected" );




    }
    public static void test1()  {









    }


}
