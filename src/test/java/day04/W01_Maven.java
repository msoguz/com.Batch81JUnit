package day04;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class W01_Maven {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //class'in basinda imlicitlywait() komutu da yazilirsa bu, test
        //boyunca her locator icin driver maximum yazilan zaman kadar bekler.


        //1- https://www.amazon.com/ sayfasina gidelim
        driver.get("https://www.amazon.com/");

        //2- arama kutusunu locate edelim
        WebElement aramaKutusu=driver.findElement(By.id("twotabsearchtextbox"));

        //3- “Samsung headphones” ile arama yapalim
        aramaKutusu.sendKeys("Samsung headphones", Keys.ENTER);

        //4- Bulunan sonuc sayisini yazdiralim
        //WebElement sonucYazisiElementi= driver.findElement(By.className("a-section a-spacing-small a-spacing-top-small"));
        //TODO: By.ClassName ile locate ettigimiz webelementinde class attribute'nun degerinde bosluk varsa saglikli calismayabilir.
        WebElement sonucYazisiElementi= driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        System.out.println(sonucYazisiElementi.getText());

        //5- Ilk urunu tiklayalim
        //WebElement ilkUrunElementi=driver.findElement(By.xpath("(//span[@class='a-size-medium a-color-base a-text-normal'])[1]"));
        //ilkUrunElementi.click();
        //TODO:Sadece click yapacaksak webelement olusturmaya ve assign etmeye gerek yok, direkt locate edip click yapabiliriz.
        driver.findElement(By.xpath("(//span[@class='a-size-medium a-color-base a-text-normal'])[1]")).click();

        //6- Sayfadaki tum basliklari yazdiralim
        driver.navigate().back();
        List<WebElement> urunlerListesi=driver.findElements(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        for (WebElement each:urunlerListesi
             ) {
            System.out.println(each.getText());


        }

    }
}
