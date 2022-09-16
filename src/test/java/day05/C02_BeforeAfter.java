package day05;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_BeforeAfter {
    WebDriver driver;
    @Before
    //Before notasyonu her testten once calisir.
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }
    @Test
    public void method1(){
        //1 defa before method'u calisir.
        driver.get("https://www.amazon.com");
        //1 defa da after methodu calisir.
    }
    @After
    //After notasyonu her testten sonra calisir.Yaninerede oldugunun onemi yok.Beforun ustunde de olsa sonra calisir.
    public void tearDown(){
        driver.close();
    }

    @Test
    public void method2(){
        driver.get("https://www.techproeducation.com");
    }

    @Test
    public void method3(){
        driver.get("https://www.hepsiburada.com");
    }
}
