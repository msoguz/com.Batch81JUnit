package day09;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_WindowHandle {

    WebDriver driver;
    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @After
    public void tearDown(){
        driver.close();
    }
    @Test
    public void test1(){
        //1- Amazon Sayfasina girelim
        driver.get("https://www.amazon.com");
        String amazonWindowHandle= driver.getWindowHandle();
        /*
        Eger bize verilen task'ta sayflar arasi gecis varsa her river.get() methodundan sonra
        driver'in window handle degerini String bir degiskene atariz.
        Sonrasinda farkli bir sayfaya ya da sekmeye gittikten sonra ilk sayfaya donmemiz istenirse
        String degiskene atadigimiz window handle degerleriyle sayfalar arasi gecis yapabiliriz.
         */
        //2- Url'nin amazon içerdiğini test edelim
        String expectedUrl="amazon";
        String actualUrl=driver.getCurrentUrl();
        Assert.assertTrue(actualUrl.contains(expectedUrl));
        //3- Yeni bir pencere açıp bestbuy anasayfasına gidelim.(https://www.bestbuy.com)
        driver.switchTo().newWindow(WindowType.WINDOW); // Yeni bir pencere acmak icin bu methodu kullandik.
        driver.get("https://www.bestbuy.com");
        String bestBuyWindowHandle= driver.getWindowHandle();
        //4- title'in BestBuy içerdiğini test edelim
        String expectedTitle="Best Buy";
        String actualTitle= driver.getTitle();
        Assert.assertTrue(actualTitle.contains(expectedTitle));

        //5- İlk sayfaya dönüp sayfada java aratalım
        driver.switchTo().window(amazonWindowHandle); //Sayfalar arasi gecis icin bu method kullanilir.
        WebElement searchBox=driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("java", Keys.ENTER);

        //6- Arama sonuclarının java içerdiğini test edelim
        WebElement aramaSonucu= driver.findElement(By.xpath("//*[@class='a-section a-spacing-small a-spacing-top-small']"));
        String arananKelime="java";
        String actualSonuc=aramaSonucu.getText();
        Assert.assertTrue(actualSonuc.contains(arananKelime));

        //7- Yeniden bestbuy sayfasına gidelim
        driver.switchTo().window(bestBuyWindowHandle);


        //8- Logonun görünürlüğünü test edelim
        Assert.assertTrue(driver.findElement(By.xpath("//*[@class='logo'])[1]")).isDisplayed());


        //9- Sayfaları Kapatalım
        //driver.quit();
    }
}
