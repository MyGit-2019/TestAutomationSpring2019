package com.cybertek.tests;

import com.cybertek.utilities.SeleniumUtils;
import com.cybertek.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class DragAndDrop extends TestBase {
    @Test
    public void test(){
        driver.get("http://demos.telerik.com/kendo-ui/dragdrop/index");
        WebElement source=driver.findElement(By.id("draggable"));
        WebElement target=driver.findElement(By.id("droptarget"));
        actions.dragAndDrop(source,target).perform();



    }


    @Test
    public void test2(){
        driver.get("http://demos.telerik.com/kendo-ui/dragdrop/index");
        WebElement source=driver.findElement(By.id("draggable"));
        WebElement target=driver.findElement(By.id("droptarget"));
        actions.moveToElement(source).clickAndHold().moveToElement(target).release().perform();
        SeleniumUtils.waitPlease(5);


    }

}
