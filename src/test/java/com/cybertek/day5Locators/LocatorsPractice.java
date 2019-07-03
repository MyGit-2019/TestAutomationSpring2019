package com.cybertek.day5Locators;

import com.cybertek.utilities.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class LocatorsPractice {
    static WebDriver driver= BrowserFactory.getDriver("chrome");
    public static void main(String[] args) throws Exception{
    test1();
    }

    public static void test1() throws Exception{
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("http://practice.cybertekschool.com/multiple_buttons");
        List<WebElement> buttons=driver.findElements(By.tagName("button"));

        System.out.println("Buttons count: "+buttons.size());

        for(WebElement button:buttons){
            System.out.println(button.getText());
            button.click();

            Thread.sleep(1000);


        }
        driver.quit();



    }

}
