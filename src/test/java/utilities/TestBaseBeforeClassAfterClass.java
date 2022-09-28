package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public abstract class TestBaseBeforeClassAfterClass { //Abstract olmayabilir. abstract olursa obje olusturamiyoruz.
    // Abstract yapmamizin sebebi, bu class'tan obje uretilmesinin onune gecmektir.

    protected static WebDriver driver;    //public de olabilir.
    @BeforeClass
    public static void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }


    @AfterClass
    public static void tearDown(){
        //  driver.quit();
    }
}
