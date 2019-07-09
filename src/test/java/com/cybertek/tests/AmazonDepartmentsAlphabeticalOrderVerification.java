package com.cybertek.tests;
import com.cybertek.utilities.BrowserFactory;
import com.cybertek.utilities.SeleniumUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class AmazonDepartmentsAlphabeticalOrderVerification {

    static WebDriver driver= BrowserFactory.getDriver("chrome");
    static ArrayList<String> elementsTextsOfDropDownMenuSelections=new ArrayList();
    static ArrayList<String> elementsTextsOfDepartmentNames=new ArrayList();



    public static void main(String[] args) {
        openTheWebsite("https://www.amazon.com");

        SeleniumUtils.waitPlease(3);

        testAllisDefault();
        testDropDownMenuisAlphabetical();
        testDepartmentNamesAreAlphabetical();
        testAllDepartmentsAreListedInDropDownMenu();
        SeleniumUtils.waitPlease(3);

        driver.quit();


    }

    public static void openTheWebsite(String Website){
        driver.get(Website);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);






    }


    public static void testAllisDefault(){
//verifying if All Departments is selected as default.



        boolean isAllSelected= driver.findElement(By.xpath("//*[@id='searchDropdownBox']/option[1]")).isSelected();
        if (isAllSelected) System.out.println("All is selected as default option for dropdown");





    }

    public static void testDropDownMenuisAlphabetical(){
//verifying if dropdown menu is Alphabetical



        List<WebElement> elementsInDropDownMenu= driver.findElements(By.xpath("//*[@id='searchDropdownBox']/option"));
        for (WebElement eachelementsInDropDown:elementsInDropDownMenu){
            elementsTextsOfDropDownMenuSelections.add(eachelementsInDropDown.getText().trim());
        }

        ArrayList<String> elementsTexts2=new ArrayList(elementsTextsOfDropDownMenuSelections);
        Collections.sort(elementsTexts2);

        if(elementsTextsOfDropDownMenuSelections.equals(elementsTexts2)) System.out.println("Test Pass....: Menu in Alphabetical Order");
        else
            {
                System.out.println("Test Fail....: Menu is not in Alphabetical order.");

                System.out.println("Actual\t\t\t\tSorted");
                for(int i=0;i<elementsTextsOfDropDownMenuSelections.size();i++)
                {
                    System.out.println(elementsTextsOfDropDownMenuSelections.get(i)+"\t\t\t\t"+elementsTexts2.get(i));

                }

            }



        //List<WebElement>elementsSorted= Collections.sort(elementsInDropDownMenu);

        }


    public static void testDepartmentNamesAreAlphabetical(){
//verifying if in full store directory page all departments are in Alphabetical order
            driver.findElement(By.id("nav-hamburger-menu")).click();
            SeleniumUtils.waitPlease(2);
            driver.findElement(By.linkText("Full Store Directory")).click();


        List<WebElement> elementsInDepartments= driver.findElements(By.xpath("//h2[@class='fsdDeptTitle']"));
        for (WebElement eachelement:elementsInDepartments){
            elementsTextsOfDepartmentNames.add(eachelement.getText().trim());
        }

        ArrayList<String> elementsTexts2=new ArrayList(elementsTextsOfDepartmentNames);
        Collections.sort(elementsTexts2);

        if(elementsTextsOfDepartmentNames.equals(elementsTexts2)) System.out.println("Test Pass....: Department names are in Alphabetical Order");
        else
        {
            System.out.println("Test Fail....: Department names are not in Alphabetical order.");

            System.out.println("Actual\t\t\t\t\t\tSorted");
            for(int i=0;i<elementsTextsOfDepartmentNames.size();i++)
            {
                System.out.println(elementsTextsOfDepartmentNames.get(i)+"\t\t\t\t\t"+elementsTexts2.get(i));

            }

        }
    }

    public static void testAllDepartmentsAreListedInDropDownMenu(){
        boolean areListed=true;
        boolean isEqual=false;
        for(int i=0;i<elementsTextsOfDepartmentNames.size();i++) {
            isEqual = false;
            for (int j = 0; j < elementsTextsOfDropDownMenuSelections.size(); j++) {
                if ((elementsTextsOfDepartmentNames.get(i).equals(elementsTextsOfDropDownMenuSelections.get(j))))
                {
                    isEqual = true;
                    break;

                }
            }
                if (!isEqual)
                {
                    System.out.println(elementsTextsOfDepartmentNames.get(i) + " department name is not listed");
                    areListed = false;
                }





        }

        if (areListed) System.out.println("Test Pass......All deparment names are listed in drop down menu");
        else System.out.println("Test Fail......One or more deparment names are not listed in drop down menu");





    }







}
