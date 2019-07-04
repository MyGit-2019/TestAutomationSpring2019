package com.cybertek.batch8Practice;

import org.testng.annotations.*;

public class TestNGDemo {

    @BeforeClass
    public void setUpClass(){
        System.out.println("runs once before everything in this class");




    }




    @BeforeMethod
    public void setUpMethod(){
        System.out.println("runs once before every method");



    }


    @Test
    public void testOne(){
        System.out.println("First one");



    }
    @Test
    public void testTwo(){
        System.out.println("Second one");





    }
    @AfterMethod
    public void tearDownMethod(){
        System.out.println("runs once after every method");


    }
    @AfterClass
    public void tearDownClass(){
        System.out.println("runs once after everything in this class");




    }




}
