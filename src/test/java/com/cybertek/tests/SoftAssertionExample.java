package com.cybertek.tests;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAssertionExample {

    @Test
    public void test2(){
        SoftAssert softAssert=new SoftAssert();
        System.out.println("start");
        softAssert.assertTrue(false);
        System.out.println("end");

        softAssert.assertEquals(2,1);


        softAssert.assertAll();



    }
}
