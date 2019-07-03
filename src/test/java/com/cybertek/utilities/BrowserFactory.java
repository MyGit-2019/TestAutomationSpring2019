package com.cybertek.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class BrowserFactory {


    public static WebDriver getDriver(String browser){


        if(browser.equals("chrome")) {
            WebDriverManager.chromedriver().setup();
            return new ChromeDriver();
        }
        else if(browser.equals("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            return new FirefoxDriver();
        }
        else if(browser.equals("safari")) {
            System.setProperty("webdriver.safari.driver", "/usr/bin/safaridriver");
            return new SafariDriver();
        }
        else {
            throw new IllegalArgumentException("Wrong browser name!");
        }



    }

}
