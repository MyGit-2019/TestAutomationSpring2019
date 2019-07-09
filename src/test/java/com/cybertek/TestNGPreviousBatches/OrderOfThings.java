package com.cybertek.TestNGPreviousBatches;

import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class OrderOfThings {

    @Test
    public void test1(){

        System.out.println("test1");



    }

    @Test(priority=1)
    public void test2(){

        System.out.println("test2");



    }

    @Ignore
    @Test
    public void test3(){

        System.out.println("test3");



    }





}
