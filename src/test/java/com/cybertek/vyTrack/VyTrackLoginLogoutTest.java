package com.cybertek.vyTrack;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

//import java.time.Instant;
import java.util.concurrent.TimeUnit;

public class VyTrackLoginLogoutTest {

    public static WebDriver driverSelection(String browser){


            if(browser.equals("chrome")) {
            WebDriverManager.chromedriver().setup();
            return new ChromeDriver();
            }
            if(browser.equals("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            return new FirefoxDriver();
            }
        if(browser.equals("safari")) {
            System.setProperty("webdriver.safari.driver", "/usr/bin/safaridriver");
            return new SafariDriver();
            }


return null;
    }






    public static void main(String[] args) throws Exception{

      // String[] browsers={"chrome","firefox","safari"};
        //String[] browsers={"chrome","firefox","safari"};
        //String[] browsers={"chrome","firefox","safari"};
        String[] browsers={"chrome"};

        StringBuilder generalTestReport=new StringBuilder("General Test Report");

        for (String browser:browsers){

            boolean isLoginPageTestPass=false;
            boolean isLoginTestPass=false;
            boolean isLogoutTestPass=false;

            WebDriver driver=driverSelection(browser);


            driver.get("http://qa2.vytrack.com/user/login");
//            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS) ;
//            driver.manage().window().fullscreen();

            Thread.sleep(3000);
            if(driver.getCurrentUrl().equals("http://qa2.vytrack.com/user/login")) isLoginPageTestPass=true;

            driver.findElement(By.id("prependedInput")).sendKeys("storemanager98");

            driver.findElement(By.id("prependedInput2")).sendKeys("UserUser123");

            driver.findElement(By.id("_submit")).click();

            Thread.sleep(3000);

            if(driver.getCurrentUrl().equals("http://qa2.vytrack.com/")) isLoginTestPass=true;

            try {
                WebDriverWait wait=new WebDriverWait(driver, 20);
                WebElement dropdown;

                dropdown = wait.until(ExpectedConditions.elementToBeClickable(By.className("dropdown-toggle")));
                dropdown.click();


                //driver.findElement(By.className("dropdown-toggle")).click();
                //Thread.sleep(2000);

                dropdown = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@class='no-hash']")));
                dropdown.click();

                //driver.findElement(By.xpath("//a[@class='no-hash']")).click();

                Thread.sleep(3000);
                if(driver.getCurrentUrl().equals("http://qa2.vytrack.com/user/login")) isLogoutTestPass=true;
            }
            catch (Exception e ){
                System.out.println(e.getMessage());
                generalTestReport.append("\n"+e.getMessage());
            }


            System.out.println();
            System.out.println("Test Results for Browser Type: "+browser); generalTestReport.append("\nTest Results for Browser Type: "+browser);
            if(isLoginPageTestPass) {System.out.println("Login Page Test PASS"); generalTestReport.append("\nLogin Page Test PASS");}

            else {System.out.println("Login Page Test FAIL");generalTestReport.append("\nLogin Page Test FAIL");}

            if(isLoginTestPass) {System.out.println("Login Test PASS");generalTestReport.append("\nLogin Test PASS");}
            else {System.out.println("Login Test FAIL");generalTestReport.append("\nLogin Test FAIL");}

            if(isLogoutTestPass) {System.out.println("Logout Test PASS"); generalTestReport.append("\nLogout Test PASS");}
            else {System.out.println("Logout Test FAIL"); generalTestReport.append("\nLogout Test FAIL");}
            System.out.println();



            driver.quit();

            //Thread.sleep(3000);





        }

        System.out.println(generalTestReport);












    }





}
