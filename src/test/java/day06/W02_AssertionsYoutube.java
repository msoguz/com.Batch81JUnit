package day06;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
        driver.findElement(By.xpath("//*[text()='I Agree']")).click();
    }

    //○ titleTest => Sayfa başlığının “YouTube” oldugunu test edin
    @Test
    public void titleTest(){
        String expectedTitle="YouTube";
        String actualTitle= driver.getTitle();
        Assert.assertEquals("Sayfa title'i beklenenden farkli",expectedTitle,actualTitle);
    }

    //○ imageTest => YouTube resminin görüntülendiğini (isDisplayed()) test edin
    @Test
    public void logoTesti(){
        WebElement logo= driver.findElement(By.xpath("(yt-icon[@id='logo-icon'])[1]"));
        Assert.assertTrue("Logo gorunmuyor", logo.isDisplayed());
    }

    //○ Search Box 'in erisilebilir oldugunu test edin (isEnabled())
    @Test
    public void aramaKutusuTesti(){
        WebElement aramaKutusu= driver.findElement(By.xpath("//input[@id='search']"));
        Assert.assertTrue("Arama kutusuna ulasilamiyor", aramaKutusu.isEnabled());
    }

    //○ wrongTitleTest => Sayfa basliginin “youtube” olmadigini dogrulayin
    @Test
    public void yanlisTitleTesti(){
        String istenmeyenBaslik="youtube";
        String actualTitle= driver.getTitle();
        Assert.assertNotEquals("Title istenmeyen kelimeye esit", istenmeyenBaslik, actualTitle);
    }


    @AfterClass
    static public void tearDown(){
       driver.close();
    }


}
