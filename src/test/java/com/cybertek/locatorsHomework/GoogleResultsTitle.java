package com.cybertek.locatorsHomework;

import com.cybertek.utilities.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class GoogleResultsTitle {

    static WebDriver driver= BrowserFactory.getDriver("chrome");

    public static void main(String[] args) throws Exception{
        test1();


    }

    public static void test1() throws Exception{

        List<String> searchStrs = Arrays.asList("Java", "JUnit", "REST Assured");

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://google.com");

        Thread.sleep(3000);

        for(int i=0;i<searchStrs.size();i++ ) {
            driver.findElement(By.xpath("//input[@title='Search']")).sendKeys(searchStrs.get(i)+ Keys.ENTER);



            List<WebElement>lst=driver.findElements(By.xpath("//cite[@class='iUh30']"));

            System.out.println(searchStrs.get(i)+" search links text:");
            ArrayList<String>textList=new ArrayList<String>();
            for (WebElement element:lst)
                  {
                      textList.add(element.getText());

            }

            //String expectedUrl = driver.findElement(By.xpath("//cite")).getText();

            driver.findElement(By.xpath("//cite[@class='iUh30']")).getText();


            //String strXpath= "//h3[contains(text(),'"+searchStrs.get(i)+"')]";

            driver.findElement(By.xpath("//h3[@class='LC20lb']")).click();


            Thread.sleep(3000);

            String actualUrl=driver.getCurrentUrl();




            if(textList.get(0).equals(actualUrl)) {
                System.out.println(searchStrs.get(i)+" URL Test Pass");

            }
             else {
                System.out.println(searchStrs.get(i)+" URL Test Fail");
                System.out.println("Expected URL: "+textList.get(0));
                System.out.println("Actual URl: "+actualUrl);



            }

             driver.navigate().back();
             Thread.sleep(3000);
             driver.findElement(By.xpath("//input[@title='Search']")).clear();



        }

        driver.quit();







    }










}
