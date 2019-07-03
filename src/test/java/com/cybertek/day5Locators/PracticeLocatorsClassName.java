package com.cybertek.day5Locators;

import com.cybertek.utilities.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class PracticeLocatorsClassName {
    static WebDriver driver= BrowserFactory.getDriver("chrome");
    public static void main(String[] args) {
        test1();
    }
    public static void test1(){
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("http://practice.cybertekschool.com");


        List<WebElement> examples=driver.findElements(By.className("list-group-item"));

        System.out.println("Examples count: "+examples.size());

        for(WebElement example:examples){
            System.out.println(example.getText());


            //Thread.sleep(1000);


        }
        driver.quit();





    }

}
