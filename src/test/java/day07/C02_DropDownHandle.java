package day07;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C02_DropDownHandle {
    //● Bir class oluşturun: C3_DropDownAmazon
    //● https://www.amazon.com/ adresine gidin.
    //- Test 1
    //Arama kutusunun yanindaki kategori menusundeki kategori sayisinin 45
    //oldugunu test edin
    //-Test 2
    //1. Kategori menusunden Books secenegini secin
    //2. Arama kutusuna Java yazin ve aratin
    //3. Bulunan sonuc sayisini yazdirin
    //4. Sonucun Java kelimesini icerdigini test edin

    WebDriver driver;
    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.amazon.com/");
    }

    @After
    public void tearDown(){
        driver.close();
    }

    //Arama kutusunun yanindaki kategori menusundeki kategori sayisinin 45
    //oldugunu test edin
    @Test
    public void test1(){
        List<WebElement> drops=driver.findElements((By.xpath("//option")));
        System.out.println(drops.size());
        for (WebElement each:drops
             ) {
            System.out.println(each.getText());
        }
        int dropDownList= drops.size();
        int expectedSayi=45;
        Assert.assertNotEquals(expectedSayi,dropDownList);
    }

    //-Test 2
    @Test
    public void test2(){
    WebElement ddm= driver.findElement(By.xpath("//*[@id='searchDropdownBox']"));
        //1. Kategori menusunden Books secenegini secin
    ddm.sendKeys(("Books"));

        //2. Arama kutusuna Java yazin ve aratin
    driver.findElement(By.cssSelector("input[id='twotabsearchtextbox']")).sendKeys("Java"+ Keys.ENTER);

        //3. Bulunan sonuc sayisini yazdirin
    WebElement souncYazisi= driver.findElement(By.xpath("//*[@class='a-section a-spacing-small a-spacing-top-small']"));
        System.out.println(souncYazisi.getText());

        //4. Sonucun Java kelimesini icerdigini test edin
        String expectedKelime="Java";
        String actualSonucYazisi=souncYazisi.getText();
        Assert.assertTrue(actualSonucYazisi.contains(expectedKelime));
    }

}
