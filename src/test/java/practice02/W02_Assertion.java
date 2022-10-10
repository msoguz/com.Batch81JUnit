package practice02;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class W02_Assertion {
    /*
    -Amazon sayfasina gidelim
    3 farkli test methodu olusturalim
    a-Url'nin amaozon icerdigini test edelim
    b-Title'in facebook icermedigini test edelim
    c-sol ust kosede amazon logosunun gorundugunu test edelim.
     */
    static WebDriver driver;
    @BeforeClass
    public static void setup() {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.amazon.com");


    }

    @AfterClass
    public static void tearDown() {
        //driver.close();


    }

    @Test
    public void test01() {
        //a-Url'nin amazon icerdigini test edelim

        String actualUrl=driver.getCurrentUrl();
        String arananKelime="amazon";
        Assert.assertTrue(actualUrl.contains(arananKelime));



    }
    @Test
    public void test02() {
        //b-Title'in facebook icermedigini test edelim
        String actualTitle=driver.getTitle();
        String istenenKelime="facebook";
        Assert.assertFalse(actualTitle.contains(istenenKelime));
    }
    @Test
    public void test03() {
        //c-sol ust kosede amazon logosunun gorundugunu test edelim.
        WebElement logo= driver.findElement(By.xpath("//*[@id='nav-logo-sprites']"));
        Assert.assertTrue(logo.isDisplayed());
    }



}
