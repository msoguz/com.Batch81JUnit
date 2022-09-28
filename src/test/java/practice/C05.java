package practice;

import org.junit.Assert;
import org.junit.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C05 {

    @Test
    public void verify() {

        //Verify that we have pom.xml file in our project => please try in 4 min s

        String path="C:\\com.Batch81JUnit\\pom.xml";
        Assert.assertTrue(Files.exists(Paths.get(path)));

    }
}
