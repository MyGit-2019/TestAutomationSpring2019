package com.cybertek.practiceCybertekWebPageTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginNegativeTest {
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

        //String[] browsers={"chrome","firefox","safari"};
        //String[] browsers={"chrome","firefox","safari"};
        String[] browsers={"chrome"};
        // String[] browsers={"firefox"};

        StringBuilder generalTestReport=new StringBuilder("General Test Report");

        for (String browser:browsers){

            boolean isLoginPageTestPass=false;
            boolean isLoginNegativeTestPass=false;

            WebDriver driver=driverSelection(browser);


            driver.get("http://practice.cybertekschool.com/login");
//            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS) ;
//            driver.manage().window().fullscreen();

            Thread.sleep(3000);
            if(driver.getCurrentUrl().equals("http://practice.cybertekschool.com/login")) isLoginPageTestPass=true;

            driver.findElement(By.name("username")).sendKeys("tomsmith"+ Keys.ENTER);


            Thread.sleep(3000);

            if(driver.findElement(By.id("flash")).getText().equals("Your password is invalid!\n" +
                    "×"))
                    isLoginNegativeTestPass=true;


            System.out.println();
            System.out.println("Test Results for Browser Type: "+browser); generalTestReport.append("\nTest Results for Browser Type: "+browser);
            if(isLoginPageTestPass) {System.out.println("Login Page Test PASS"); generalTestReport.append("\nLogin Page Test PASS");}

            else {System.out.println("Login Page Test FAIL");generalTestReport.append("\nLogin Page Test FAIL");}

            if(isLoginNegativeTestPass) {System.out.println("Login Test PASS");generalTestReport.append("\nLogin Test PASS");}
            else {System.out.println("Login Test FAIL");generalTestReport.append("\nLogin Test FAIL");}

            System.out.println(driver.findElement(By.id("flash")).getText());



            driver.quit();

            //Thread.sleep(3000);





        }

        System.out.println(generalTestReport);














    }
}
