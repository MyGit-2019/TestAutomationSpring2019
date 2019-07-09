package com.cybertek.day7;


import com.cybertek.utilities.BrowserFactory;
import com.cybertek.utilities.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class DrowpDownsPractice {

    static WebDriver driver= BrowserFactory.getDriver("chrome");



    public static void main(String[] args) {

        openTheWebsite("http://practice.cybertekschool.com/dropdown");

        SeleniumUtils.waitPlease(3);

        test5();



        driver.quit();


    }

    public static void openTheWebsite(String Website){
        driver.get(Website);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);






    }
    public static void test1() {
        WebElement dropdown1 = driver.findElement(By.id("dropdown"));
        Select dropdownSelect = new Select(dropdown1);

        String actual = dropdownSelect.getFirstSelectedOption().getText();
        String expected = "Please select an option1";
        SeleniumUtils.verifyEquals(expected, actual);

        List<WebElement> options = dropdownSelect.getOptions();
        for (WebElement option : options) {
            System.out.println(option.getText());

        }
    }
        public static void test2(){
            WebElement dropdown1=driver.findElement(By.id("state"));
            Select dropdownSelect=new Select(dropdown1);


            List<WebElement> options=dropdownSelect.getOptions();
            for (WebElement option: options)
            {
                SeleniumUtils.waitPlease(1);
                dropdownSelect.selectByVisibleText(option.getText());
            }



    }
    public static void test3(){
        WebElement dropdown1=driver.findElement(By.id("state"));
        Select dropdownSelect=new Select(dropdown1);


        List<WebElement> options=dropdownSelect.getOptions();
        dropdownSelect.selectByValue("PA");

        SeleniumUtils.waitPlease(3);
        String expected="Pennsylvania";
        String actual=dropdownSelect.getFirstSelectedOption().getText();
        SeleniumUtils.verifyEquals(expected,actual);
    }

    public static void test4(){
        WebElement dropdown1=driver.findElement(By.xpath("//select[@name='Languages']"));
        Select dropdownSelect=new Select(dropdown1);


        List<WebElement> options=dropdownSelect.getOptions();
        dropdownSelect.selectByIndex(0);
        dropdownSelect.selectByIndex(1);



        SeleniumUtils.waitPlease(3);

        dropdownSelect.deselectAll();
        SeleniumUtils.waitPlease(3);

        dropdownSelect.selectByIndex(0);
        dropdownSelect.selectByIndex(1);

        SeleniumUtils.waitPlease(3);

        dropdownSelect.deselectByIndex(1);

        SeleniumUtils.waitPlease(3);
        dropdownSelect.deselectByValue("java");
        SeleniumUtils.waitPlease(3);
        System.out.println(dropdownSelect.isMultiple());


        //String expected="Pennsylvania";
        //String actual=dropdownSelect.getFirstSelectedOption().getText();
        //SeleniumUtils.verifyEquals(expected,actual);
    }

    public static void test5(){
        WebElement dropdown1=driver.findElement(By.id("state"));
        Select dropdownSelect=new Select(dropdown1);


        List<WebElement> options=dropdownSelect.getOptions();

        SeleniumUtils.waitPlease(3);

        boolean isAlphabetical=true;
        for (int i=1;i<options.size()-1;i++)
        {
            System.out.println(options.get(i).getText()+" to "+ options.get(i+1).getText()+" " +
                    (options.get(i).getText().compareTo(options.get(i+1).getText())<=0?true:false));

            if(options.get(i).getText().compareTo(options.get(i+1).getText())>-1) isAlphabetical=false;


        }
        System.out.println(" Dropdown menu is "+((isAlphabetical)?"in Alphabetical Order":"not in Alphabetical Order"));



       }







}
