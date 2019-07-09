package com.cybertek.TestNGPreviousBatches;

import org.testng.Assert;
import org.testng.annotations.Test;

public class UnitTest {

    @Test
    public void addTest() {
        int expected = 2;
        Unit unit = new Unit();
        int actual = unit.add(1, 1);


        Assert.assertEquals(actual, expected);
    }


        @Test
        public void addTest2 () {
            int expected2 = 4;
            Unit unit2 = new Unit();
            int actual2 = unit2.add(1, 1);


            Assert.assertEquals(actual2, expected2);

        }


    }

