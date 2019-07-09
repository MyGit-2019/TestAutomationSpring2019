package com.cybertek.tests;

import com.cybertek.utilities.BrowserFactory;
import com.cybertek.utilities.SeleniumUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

public class AmazonDepartmentTest {
    WebDriver driver;
    Select allDepartments;

    @BeforeClass
    public void setUpMethod(){
        driver=BrowserFactory.getDriver("chrome");
        driver.get("http:/amazon.com");
    }
    @Test(priority = 0)
    public void testDefaultValue(){
        WebElement selectElement=driver.findElement(By.id("searchDropdownBox"));
        allDepartments=new Select(selectElement);
        String selectedOption=allDepartments.getFirstSelectedOption().getText();

        //it is failing
        Assert.assertEquals(selectedOption,"All");


    }
    @Test(priority = 1)
    public void testSortAlphabetical(){
        WebElement selectElement=driver.findElement(By.id("searchDropdownBox"));
        allDepartments=new Select(selectElement);
        //boolean isAlphabetical=true;
        for(int i=0;i<allDepartments.getOptions().size()-1;i++){

            String current=allDepartments.getOptions().get(i).getText();
            String next= allDepartments.getOptions().get(i+1).getText();
            System.out.println(current+" comparing to "+ next);
            Assert.assertTrue(current.compareTo(next)<=0);

        }

    }
    @Test (priority = 2)
    public void mainDepartmentsTest(){

        driver.findElement(By.cssSelector("i.hm-icon.nav-sprite")).click();
        SeleniumUtils.waitPlease(2);
        driver.findElement(By.xpath("//a[@href='/gp/site-directory?ref_=nav_em_T1_0_2_2_35__fullstore']")).click();
        SeleniumUtils.waitPlease(2);

        List<WebElement> departmentsList=driver.findElements(By.cssSelector("h2.fsdDeptTitle"));
        //<h2 class="fsdDeptTitle">Prime Video</h2>

        for(int i=0;i<departmentsList.size()-1;i++){

            String current=departmentsList.get(i).getText();
            String next= departmentsList.get(i+1).getText();
            System.out.println(current+" comparing to "+ next);
            Assert.assertTrue(current.compareTo(next)<=0);

        }


    }




@AfterClass
    public void cleanUp(){
        driver.quit();

}


}
