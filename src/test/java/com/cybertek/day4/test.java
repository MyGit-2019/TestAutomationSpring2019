package com.cybertek.day4;

public class test {
    public static void main(String[] args) {
        int count = 0;
        ROW_LOOP: for(int row = 1; row <=3; row++) {


            for (int col = 1; col <= 2; col++) {
                if (row * col % 2 == 0) continue ROW_LOOP;
                count++;
            }

        }




            System.out.println(count);
    }
}

//count=0
//row=1  col=1 ==>  1%2=1 ==> count=1
//row=1  col=2 ==>  2%2=0 ==>
//row=2  col=1 ==>  2%2=0
//row=2  col=2
//row=3  col=1 ==>  3%2=1==> count=2
//row=3  col=2 ==>  6%2=0==>