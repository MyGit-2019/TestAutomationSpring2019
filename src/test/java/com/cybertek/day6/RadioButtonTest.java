package com.cybertek.day6;

import com.cybertek.utilities.BrowserFactory;
import com.cybertek.utilities.SeleniumUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class RadioButtonTest {
    static WebDriver driver= BrowserFactory.getDriver("chrome");

    public static void main(String[] args) {
        openTheWebsite("http://practice.cybertekschool.com/radio_buttons");
        test4();
        driver.quit();

    }

        public static void openTheWebsite(String Website){
            driver.get(Website);
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);




        }


    public static void test1()  {






        driver.findElement(By.id("yellow")).click();

        if (driver.findElement(By.id("yellow")).isSelected()) System.out.println("Yellow Test Passed");

        driver.findElement(By.id("football")).click();
        if (driver.findElement(By.id("football")).isSelected()) System.out.println("Football Test Passed");

        SeleniumUtils.waitPlease(3);


    }
    public static void test2()  {


        System.out.println(driver.findElement(By.id("green")).isEnabled()?"Green Button Clickable":"Green Button not Clickable");
        System.out.println(driver.findElement(By.id("black")).isEnabled()?"Black Button Clickable":"Black Button not Clickable");





        SeleniumUtils.waitPlease(3);


    }
    public static void test3() {


        System.out.println(driver.findElement(By.id("blue")).isSelected() ? "Blue Button Selected" : "Blue Button not Selected");
        driver.findElement(By.id("black")).click();
        System.out.println(driver.findElement(By.id("black")).isSelected() ? "Black Button Selected" : "Black Button not Selected");
        System.out.println(driver.findElement(By.id("blue")).isSelected() ? "Blue Button Selected" : "Blue Button not Selected");



        SeleniumUtils.waitPlease(3);

    }
    public static void test4() {

        List<WebElement> lst=driver.findElements(By.xpath("//input[@type='radio']"));
int count=0;
        lst.get(0).click();
        for (WebElement element:lst)
              {

                  if(element.isSelected()) count++;
                  System.out.println(element.getAttribute("id")+" Button "+(element.isSelected()?"is Selected":"is not Selected"));


        }


        System.out.println(count+" buttons clicked");
        SeleniumUtils.waitPlease(3);

    }




    }
