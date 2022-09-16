package day06;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class W02_AssertionsYoutube {

    //1) Bir class oluşturun: YoutubeAssertions
    //2) https://www.youtube.com adresine gidin
    //3) Aşağıdaki adları kullanarak 3 test metodu oluşturun ve gerekli testleri yapin
    //○ titleTest => Sayfa başlığının “YouTube” oldugunu test edin
    //○ imageTest => YouTube resminin görüntülendiğini (isDisplayed()) test edin
    //○ Search Box 'in erisilebilir oldugunu test edin (isEnabled())
    //○ wrongTitleTest => Sayfa basliginin “youtube” olmadigini dogrulayin

    static WebDriver driver;
    @BeforeClass
    public static void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.youtube.com");
    }

    //○ titleTest => Sayfa başlığının “YouTube” oldugunu test edin
    @Test
    public void titleTest(){
        String expectedTitle="https://www.youtube.com";
        String actualTitle= driver.getTitle();
        Assert.assertEquals("Sayfa title'i beklenenden farkli",expectedTitle,actualTitle);
    }

    //○ imageTest => YouTube resminin görüntülendiğini (isDisplayed()) test edin
    @Test
    public void imageTest(){
        
    }




    @AfterClass
    public void tearDown(){
        driver.close();
    }


}
