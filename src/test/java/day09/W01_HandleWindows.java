package day09;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class W01_HandleWindows {

    WebDriver driver;

    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @After
    public void tearDown(){
        //driver.quit();
    }

    @Test
    public void test01(){
        //1-amazon ana sayfaya git.
        driver.get("https://www.amazon.com");
        String ilkSayfaHandleDegeri=driver.getWindowHandle();

        //2- nutella icin arama yap.
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Nutella", Keys.ENTER);
        //CDwindow-1B6C99079162E44D906F0DB2936B39D6  Bu kod acilan sayfanin unique hash kodudur.
        //Selenium sayfalar arasi geciste bu window handle degerini kullanir.
        //Eger sayfalar arasinda driver'i gezdiriyorsak ve herhangi bir sayfasan su anda bulundugumuz sayfaya gecmek istiyorsak
        //driver.switchTo().window("CDwindow-1B6C99079162E44D906F0DB2936B39D6");
        //bu sayfanin window handle degerini girerek busayfaya gecisi saglayabiliriz.


        //3-ilk urunun resmini tiklayarak farkli bir tab olarak acin
        WebElement ilkUrunResmi= driver.findElement(By.xpath("(//div[@class='a-section aok-relative s-image-square-aspect'])[1]"));
        driver.switchTo().newWindow(WindowType.TAB);
        /*
        Bu komutu kullandigimizda driver otomatik olarak olusturulan new tab'a tiklar
        Yeni Tab'da gorevi gerceklestirmek icin adimlari bastan almamiz gerekir.
         */

        driver.get("https://www.amazon.com");
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Nutella", Keys.ENTER);
        driver.findElement(By.xpath("(//div[@class='a-section aok-relative s-image-square-aspect'])[1]")).click();

        //4- yeni tab'da acilan urunun title'ini yazdirin.
        WebElement urunTitleElementi= driver.findElement(By.xpath("//span[@id='productTitle']"));
        System.out.println(urunTitleElementi.getText());
        System.out.println(driver.getCurrentUrl());// ikinci sayfanin url'i
        //ilk sayfaya gecip Url'i yazdiralim
        driver.switchTo().window(ilkSayfaHandleDegeri);
        System.out.println(driver.getCurrentUrl());


    }


}
