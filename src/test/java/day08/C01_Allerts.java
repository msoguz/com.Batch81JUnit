package day08;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_Allerts {

    /*
    -https://the-internet.herokuapp.com/javascript_alerts adresine gidelim
    -Click for js Alert butonuna tiklayalim
    -Tikladiktan sonra cikan uyari mesajina (alerte) tamam diyelim.
     */
    WebDriver driver;

    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    /*
    Herhangi bir web sitesine gidince veya bir web sitesinde herhangi bir islem yaptigimizda
    ortaya cikan uyarilara alert diyoruz.
    Eger bir alert inspect yapilabiliyorsa, o laert otomasyon ile kullanilabilir, bu tur
    alert'lere HTML alert denir ve bunlar icin extra bir islem yapmaya gerek yoktur.
    Tum webelement'ler gibi locate edip istedigimiz islemleri yapabiliriz,
    driver.get("https://www.facebook.com")'da cikan alert vb.

    Ancak web uygulamalarinda HTML alert yaninda java script alert de bulunabilir,
    JS alert'ler locate edilemezler.
    Selenium'da JS alert'ler icin ozel bir yontem gelistirilmistir.
     */

    @Test
    public void test1() throws InterruptedException {
        //-https://the-internet.herokuapp.com/javascript_alerts adresine gidelim
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");

        //-"Click for js Alert" butonuna tiklayalim
        driver.findElement(By.xpath("//*[text()='Click for JS Alert']")).click();

        //-Tikladiktan sonra cikan uyari mesajina (alerte) tamam diyelim.
        Thread.sleep(2000);
        driver.switchTo().alert().accept();
    }
}
