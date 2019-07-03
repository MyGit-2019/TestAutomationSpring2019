package com.cybertek.locatorsHomework;


//1.Open browser
//2.Go to https://ebay.com
// 3.Search for wooden spoon
// 4.Save the total number of results
// 5.Click on link All
// 6.Verify that number of results is bigger than the number in step 4
// 7.Navigate back to previous research results page
// 8.Verify that wooden spoon is displayed in the search box
// 9.Navigate back to home page
// 10.Verify that search box is blan


import com.cybertek.utilities.BrowserFactory;
import com.cybertek.utilities.SeleniumUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class EtsyTest {
    static WebDriver driver= BrowserFactory.getDriver("chrome");

    public static void main(String[] args) {

        openTheWebsite("https://ebay.com");
        test1();
        driver.quit();

    }

    public static void openTheWebsite(String Website){
        driver.get(Website);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);




    }
    public static void test1()  {

        driver.findElement(By.id("gh-ac")).sendKeys("wooden spoon"+ Keys.ENTER);
        SeleniumUtils.waitPlease(3);
        String result=driver.findElement(By.xpath("//h1[@class='srp-controls__count-heading']")).getText();
        result=result.substring(0,result.indexOf(" ")).replace(",","");
        int resultCountSearch=Integer.parseInt(result);

        driver.findElement(By.linkText("All")).click();
        SeleniumUtils.waitPlease(3);

        String result2=driver.findElement(By.xpath("//h1[@class='srp-controls__count-heading']")).getText();
        result2=result2.substring(0,result2.indexOf(" ")).replace(",","");
        int result2CountSearch=Integer.parseInt(result2);


        if(result2CountSearch>resultCountSearch) System.out.println("Test1 (Verify the number of results) Passed");
        else System.out.println("Test1 (Verify the number of results) Fail\nSearch results :"+resultCountSearch+" and all search results: "+result2CountSearch);
        SeleniumUtils.waitPlease(3);


        driver.navigate().back();
        String text=driver.findElement(By.id("gh-ac")).getAttribute("value");
        if(text.equals("wooden spoon")) System.out.println("Test2 (Verify that wooden spoon is displayed) Pass");
        else System.out.println("Test 2 (Verify that wooden spoon is displayed) Failed\nText on search box is "+text);

        driver.navigate().back();
        text=driver.findElement(By.id("gh-ac")).getAttribute("value");
        if(text.equals("")) System.out.println("Test3 (Verify that search box is blank) Pass");
        else System.out.println("Test 3 (Verify that search box is blank) Failed\nText on search box is "+text);

        SeleniumUtils.waitPlease(3);


    }

}
