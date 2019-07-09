package com.cybertek.tests;

import com.cybertek.utilities.TestBase;
import org.testng.Assert;
import org.testng.annotations.*;

import java.nio.file.Files;
import java.nio.file.Paths;

public class FileExistsTest extends TestBase {

    @Test
    public void test(){
        String current=System.getProperty("user.dir");
        System.out.println(current);
        String userFolder=System.getProperty("user.home");
        System.out.println(userFolder);
        String downloads=userFolder+"/Downloads";///Users/mehmet_durkan/Downloads
        System.out.println(downloads);
        String path=downloads+"/test.txt";///Users/mehmet_durkan/Downloads/test.txt
        System.out.println(path);

        Assert.assertTrue(Files.exists(Paths.get(path)));

    }
}
