package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public abstract class TestBaseBeforeAfter { // abstract olsa da olur olmasa da olur.
    // Abstract yapmamizin sebebi, bu class'tan obje uretilmesinin onune gecmektir.

    protected WebDriver driver;    //public de olabilir.
    protected Actions actions;

    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
       // driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        actions=new Actions(driver);

    }


    @After
    public void tearDown(){
      //  driver.quit();
    }
}
