package com.cybertek.tests;

import com.cybertek.utilities.TestBase;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

public class ScrollTest extends TestBase {
    @Test
    public void test(){
        driver.get("http://youtube.com");
        actions.sendKeys(Keys.PAGE_DOWN).perform();

        actions.sendKeys(Keys.PAGE_DOWN).perform();
        actions.sendKeys(Keys.PAGE_UP).perform();

        actions.sendKeys(Keys.ARROW_DOWN).perform();
        actions.sendKeys(Keys.ARROW_DOWN).perform();
        actions.sendKeys(Keys.ARROW_UP).perform();
        actions.sendKeys(Keys.ARROW_UP).perform();

    }



}
