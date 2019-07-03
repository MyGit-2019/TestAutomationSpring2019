package com.cybertek.utilities;

public class SeleniumUtils {
    public void verifyEquals(String expectedResult,String actualResult){
        if(expectedResult.equals(actualResult)){
            System.out.println("Passed");
        }else{
            System.out.println("Failed");
            System.out.println("Expected result: "+expectedResult);
            System.out.println("Actual result: "+actualResult);
        }


    }

    public static void waitPlease(int seconds){
        try {
            Thread.sleep(seconds * 1000 );
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }
}
