package day05;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class W03_Before_After {
    //3 test methodu yapin
    //1. method amazon'a
    //2. method techproeducation'a
    //3.method facebook'a gitsin

    //Eger her test methodu icin yeni bir sayfa acilsin ve test methodu sonunda
    // kapansin istiyorsak @Before ve @After notasyonlari kullanmaliyiz.

    WebDriver driver;
    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test
    public void amazonTesti(){
        driver.get("https://www.amazon.com");
        System.out.println(driver.getTitle());
    }

    @Test
    public void techproedTesti(){
        driver.get("https://www.techproeducation.com");
        System.out.println(driver.getTitle());
    }


    @Test
    public void facebookTesti(){
    driver.get("https://www.facebook.com");
    }

    @After
    public void tearDown(){
        driver.close();
    }

}
