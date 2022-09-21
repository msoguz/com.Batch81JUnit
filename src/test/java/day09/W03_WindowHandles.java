package day09;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Set;

public class W03_WindowHandles {
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

        //● Tests package’inda yeni bir class olusturun: WindowHandle2
        //● https://the-internet.herokuapp.com/windows adresine gidin.
        driver.get("https://the-internet.herokuapp.com/windows");

        //● Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
        WebElement sayfadakiYaziElementi= driver.findElement(By.xpath("//h3"));
        String expectedYazi="Opening a new window";
        String actualYazi=sayfadakiYaziElementi.getText();
        Assert.assertEquals(expectedYazi,actualYazi);


        //● Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
        String expectedTitle="The Internet";
        String actualTitle= driver.getTitle();
        Assert.assertEquals(expectedTitle,actualTitle);

        /*
        Eger kontrolsuz acilan bir tab veya window varsa o sayfalarin window handle degerlerini
        elde etmem gerekir.
        Oncelikle ikinci sayfa acilmadan once ilk sayfanin window handle degerini bir String'e atayalim.
         */

        String ilkSayfaWindowHandleDegeri= driver.getWindowHandle();
        System.out.println(ilkSayfaWindowHandleDegeri);

        //● Click Here butonuna basın.
        driver.findElement(By.linkText("Click Here")).click();
        /*
        switchTo().newWindow() demeden link tiklayarak yeni tab veya window olustugunda biz driver'a
        yeni sayfaya gec demedikce driver eski sayfada kalir ve yeni sayfa ile ilgili hicbir islem yapmaz.
        yeni sayfada driver'i calistirmak istersek once driver'i yeni sayfaya yollamaliyiz.
         */

        /*
        Yeni sayfaya gecebilmek icin oncelikle ikinciSayfaWindowHandleDegeri'ni bulmamiz gerekir.
        Bunun icin driver.getWindowHandles() method'unu kullanarak acik olan tum sayfalarin
        window handle degerlerini alip bir set'e assign ederiz.
        Ilk sayfanin window handle degerini zaten biliyoruz.
        Set'teki window handle degerlerini kontrol edip ilk sayfanin handle degerine esit
        olmayan ikinci sayfanin window handle degeridir deriz.
         */

        Set<String> windowHandleSeti=driver.getWindowHandles();
        System.out.println(windowHandleSeti);

        String ikinciSayfaWindowHandleDegeri="";
        for (String each:windowHandleSeti
             ) {
            if(!each.equals(ilkSayfaWindowHandleDegeri)){
                 ikinciSayfaWindowHandleDegeri=each;
            }
        }

        //Artik ikinci sayfanin window handle degerini biliyoruz.
        //Rahatlikla sayfalara arasi gecis yapabiliriz
        driver.switchTo().window(ikinciSayfaWindowHandleDegeri);


        //● Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu dogrulayin.
        String expectedIkinciTitle="New Window";
        String actualIkinciTitle=driver.getTitle();
        Assert.assertEquals(expectedIkinciTitle,actualIkinciTitle);


        //● Sayfadaki textin “New Window” olduğunu doğrulayın.
        WebElement ikiciSayfaYaziElementi= driver.findElement(By.xpath("//h3"));
        String expectedIkinciYazi="New Window";
        String actualIkinciYazi=ikiciSayfaYaziElementi.getText();
        Assert.assertEquals(expectedIkinciYazi,actualIkinciYazi);

        //● Bir önceki pencereye geri döndükten sonra sayfa başlığının “The Internet” olduğunu
        //doğrulayın.
        driver.switchTo().window(ilkSayfaWindowHandleDegeri);
        expectedTitle="The Internet";
        actualTitle=driver.getTitle();

        Assert.assertEquals(expectedTitle,actualTitle);
    }
}
