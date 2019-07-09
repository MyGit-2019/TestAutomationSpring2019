package com.cybertek.day7;

import com.cybertek.utilities.BrowserFactory;
import com.cybertek.utilities.SeleniumUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Set;
import java.util.concurrent.TimeUnit;

public class HTMLPopups {
    WebDriver driver;

    @BeforeClass
    public void setUpMethod(){
        driver= BrowserFactory.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }
    @AfterClass
    public void cleanUp(){
        driver.quit();

    }








    @Test
    public void changeTab(){

        driver.get("https://www.primefaces.org/showcase/ui/overlay/confirmDialog.xhtml");

        driver.findElement(By.xpath("//span[.='Destroy the World']")).click();

        driver.findElement(By.xpath("//span[.='No']")).click();
        SeleniumUtils.waitPlease(3);



        }



        @Test
    public void oppstest(){

    driver.get("https://sweetalert.js.org");

    driver.findElement(By.xpath("//*[contains(@onclick,'swal')]")).click();

            //button[@class='swal-button swal-button--confirm']
            SeleniumUtils.waitPlease(2);

            driver.findElement(By.xpath("//button[@class='swal-button swal-button--confirm']")).click();



        SeleniumUtils.waitPlease(2);

            driver.findElement(By.xpath("//*[contains(@onclick,'alert')]")).click();

            //button[@class='swal-button swal-button--confirm']
            SeleniumUtils.waitPlease(2);

            Alert alert=driver.switchTo().alert();
            alert.accept();





    }
    @Test
    public void oppsTest(){
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//button[contains(text(),'Click for JS Confirm')]")).click();
          SeleniumUtils.waitPlease(2);
        Alert alert=driver.switchTo().alert();
        alert.dismiss();




    }
    @Test
    public void alertSwitch(){
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//button[contains(text(),'Click for JS Prompt')]")).click();
        SeleniumUtils.waitPlease(2);
        Alert alert=driver.switchTo().alert();
        alert.sendKeys("Hello");
        SeleniumUtils.waitPlease(3);

        alert.accept();
        SeleniumUtils.waitPlease(2);





    }




}
