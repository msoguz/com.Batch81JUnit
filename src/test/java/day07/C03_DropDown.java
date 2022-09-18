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
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class C03_DropDown { //TODO: Bu class C02_DropDownHandle class'inin Select Class'indan yardim alinarak cozumudur!!!!!!!!!!!!!

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
    Select select;
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
        //driver.close();
    }
    //- Test 1
    //Arama kutusunun yanindaki kategori menusundeki kategori sayisinin 45
    //oldugunu test edin
    @Test
    public void test1(){
        WebElement ddm= driver.findElement(By.xpath("//*[@id='searchDropdownBox']"));
        select=new Select(ddm);
        /*
        DropDown menuye ulasmak icin Select class'indan bir obje olustururuz ve locate ettigimiz dropdown webelement'ini
        Select class'ina tanimlariz ve getOption methodu'nu kullanarak dropdown'u bir list'e atarak dropdown menunun
        butun elemanlarinin sayisina ulasabiliriz.
         */
        List<WebElement> ddmList=select.getOptions();
        System.out.println(ddmList.size());
        int expectedSayi=45;
        int actualDds= ddmList.size();
        Assert.assertNotEquals(expectedSayi,actualDds);
    }

    //-Test 2
    @Test
    public void test2(){
        //1. Kategori menusunden Books secenegini secin
        WebElement ddm= driver.findElement(By.xpath("//*[@id='searchDropdownBox']"));
        select=new Select(ddm);
        // select.selectByVisibleText("Books"); //Eger Dropdown menudeki option'a string olarak ulasmak istersek nu methodu kullaniriz
        //select.deselectByIndex(5); //Eger Dropdown menusunun index'i ile ulasmak istersek nu method'u kullaniriz.
        select.selectByValue("search-alias=stripbooks-intl-ship"); //Eger Dropdown menusundeki oprion'a value ile ulasmak istersek bu methodu kullaniriz.

        //Dropdown menude en son sectigimiz option'a erismek istersek select.getFirstSelectedOption() methodunu kullaniriz.
        System.out.println(select.getFirstSelectedOption().getText());
        //2. Arama kutusuna Java yazin ve aratin
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Java", Keys.ENTER);

        //3. Bulunan sonuc sayisini yazdirin
        WebElement souncYazisi= driver.findElement(By.xpath("//*[@class='a-section a-spacing-small a-spacing-top-small']"));
        System.out.println(souncYazisi.getText());

        //4. Sonucun Java kelimesini icerdigini test edin
        String expectedKelime="Java";
        String actualSonucYazisi=souncYazisi.getText();
        Assert.assertTrue(actualSonucYazisi.contains(expectedKelime));



    }

}
