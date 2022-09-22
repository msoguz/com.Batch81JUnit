package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public abstract class TestBaseBeforeClassAfterClass { //Abstract olmayabilir. abstract olursa obje olusturamiyoruz.
    // Abstract yapmamizin sebebi, bu class'tan obje uretilmesinin onune gecmektir.

    protected static WebDriver driver;    //public de olabilir.
    @Before
    public static void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }


    @After
    public static void tearDown(){
        //  driver.quit();
    }
}
