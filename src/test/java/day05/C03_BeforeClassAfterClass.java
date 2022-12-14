package day05;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_BeforeClassAfterClass {
    /*
    BeforeClass ve AfterClass notasyonlarini kullanirken methodlarini static yapmamiz lazim.
     */

    static WebDriver driver;
    @BeforeClass
    public static void beforeClass(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterClass
    public static void tearDown(){
        driver.close();
    }


    @Ignore  ("Ahmet'in testi ... gibi aciklama da konabilir.")
            // Calismasini istemedigimiz methodun basina @Ignore notasyonu kullanilir. Genelde ornegin 2 kisi bir projede calisirken
            // baskasinin methodlarini calistirmayacaksak mthodun basina @Ignore notasyonu konur.
    @Test
    public void method1(){
        driver.get("https://amazon.com");
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
