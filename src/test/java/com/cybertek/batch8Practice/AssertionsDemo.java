package com.cybertek.batch8Practice;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class AssertionsDemo {

    @AfterMethod
    public void tearDown(){
        System.out.println("cleaning up");


    }



    @Test
    public void testOne(){

        System.out.println("asserting first");
        Assert.assertTrue(false);
        System.out.println("done asserting first");






    }
    @Test
    public void testTwo(){

        System.out.println("asserting two");
        Assert.assertTrue(true);
        System.out.println("done asserting two");






    }



}
