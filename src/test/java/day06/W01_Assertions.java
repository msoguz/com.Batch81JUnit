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

public class W01_Assertions {
    //1) Bir class oluşturun: BestBuyAssertions
    //2) https://www.bestbuy.com/ Adresine gidin farkli test method’lari olusturarak
    //asagidaki testleri yapin
    //○ Sayfa URL’inin https://www.bestbuy.com/ ‘a esit oldugunu test edin
    //○ titleTest => Sayfa başlığının “Rest” içermediğini(contains) test edin
    //○ logoTest => BestBuy logosunun görüntülendigini test edin
    //○ FrancaisLinkTest => Fransizca Linkin görüntülendiğini test edin

    static WebDriver driver;
    @BeforeClass
    public static void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.bestbuy.com/");
    }
    // Sayfa URL’inin https://www.bestbuy.com/ ‘a esit oldugunu test edin
    @Test
    public void urlTest(){
        String expectedURL="https://www.bestbuy.com/";
        String actualURL=driver.getCurrentUrl();
        Assert.assertEquals("Istenen URL bulunamadi", expectedURL,actualURL);
    }

    // titleTest => Sayfa başlığının “Rest” içermediğini(contains) test edin
    @Test
    public void titleTest(){
        String istenmeyenKelime="Rest";
        String actualTitle=driver.getTitle();

        Assert.assertFalse("istenmeyen kelime title'da var", actualTitle.contains(istenmeyenKelime));

    }

    //○ logoTest => BestBuy logosunun görüntülendigini test edin
    @Test
    public void logoTest(){
      WebElement logo= driver.findElement(By.xpath("(//img[@class='logo'])[1]"));
      Assert.assertTrue("logo gorunmuyor",logo.isDisplayed());
    }

    //○ FrancaisLinkTest => Fransizca Linkin görüntülendiğini test edin
    @Test
    public void fransizcaTesti() {
        WebElement fransizcaLinki = driver.findElement(By.xpath("//button[text()='Français']"));
        Assert.assertTrue("Fransizca linki gorunmuyor", fransizcaLinki.isDisplayed());

    }
    @AfterClass
    public static void tearDown(){
        driver.close();
    }
}
