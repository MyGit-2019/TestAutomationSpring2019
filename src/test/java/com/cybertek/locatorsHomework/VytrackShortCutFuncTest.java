package com.cybertek.locatorsHomework;

import com.cybertek.utilities.BrowserFactory;
import com.cybertek.utilities.SeleniumUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.concurrent.TimeUnit;
//        1.Open browser
//        2.Go to Vytrack login page
//        3.Login as a sales manager
//        4.Verify Dashboard page is open
//        5.Click on Shortcuts icon
//        6.Click on link See full list
//        7.Click on link Opportunities
//        8.Verify Open opportunities page is open
//        9.Click on Shortcuts icon
//        10.Click on link Vehicle Service Logs
//        11.Verify error message text is You do not have permission to perform this action.
//        12.Verify Open opportunities page is still open
//



public class VytrackShortCutFuncTest {
    static WebDriver driver= BrowserFactory.getDriver("chrome");

    public static void main(String[] args) {

        openTheWebsite("http://qa2.vytrack.com/user/login");
        test1();
        driver.quit();

    }

    public static void openTheWebsite(String Website){
        driver.get(Website);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);




    }
    public static void test1()  {

        driver.findElement(By.id("prependedInput")).sendKeys("salesmanager261");
        driver.findElement(By.id("prependedInput2")).sendKeys("UserUser123"+ Keys.ENTER);
        SeleniumUtils.waitPlease(7);


        //verify dashboard

        if(driver.getTitle().equals("Dashboard")) System.out.println("Test1 (Verify Dashboard page is open) Pass");
        else System.out.println("Test1 (Verify Dashboard page is open) Fail\nTitle is "+driver.getTitle());

        //shortcuts
        driver.findElement(By.xpath("//i[@class='fa-share-square']")).click();
        SeleniumUtils.waitPlease(2);
        driver.findElement(By.linkText("See full list")).click();
        SeleniumUtils.waitPlease(2);

        driver.findElement(By.linkText("Opportunities")).click();
        SeleniumUtils.waitPlease(7);

//verify Opportunities

        if(driver.getTitle().startsWith("Open Opportunities")) System.out.println("Test2 (Verify Open opportunities page is open) Pass");
        else System.out.println("Test2 (Verify Open opportunities page is open) Fail\nTitle is "+driver.getTitle());

//shortcuts again
        driver.findElement(By.xpath("//i[@class='fa-share-square']")).click();
        SeleniumUtils.waitPlease(2);
        driver.findElement(By.linkText("See full list")).click();
        SeleniumUtils.waitPlease(2);


//Verify error message text is You do not have permission to perform this action.&&Verify Open opportunities page is still open
        driver.findElement(By.linkText("Vehicle Services Logs")).click();
        SeleniumUtils.waitPlease(2);
        List<WebElement> lst=driver.findElements(By.xpath("//div[@class='message']"));
        boolean isErrorMessageExists = lst.size()>0;

        if(driver.getTitle().startsWith("Shortcut")&&isErrorMessageExists) System.out.println("Test3 (Verify error message text & Verify Open opportunities page is still open) Pass");
        else System.out.println("Test3 (Verify error message text & Verify Open opportunities page is still open) Fail\n\tTitle is "+driver.getTitle()+" and there is no error message");

        SeleniumUtils.waitPlease(2);


    }



}
