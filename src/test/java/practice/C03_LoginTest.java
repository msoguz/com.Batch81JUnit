package practice;

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

public class C03_LoginTest {


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
        //driver.close();
    }

    @Test
    public void test01(){
        //1- https://www.koalaresorthotels.com/ sayfasina gidiniz.
        driver.get("https://www.koalaresorthotels.com/");

        //2- Login butonuna tiklayiniz.
        driver.findElement(By.xpath("//a[text()='Log in']")).click();

        //3- Log in ekranina girdiginizi 4 farkli web elementi kullanarak dogrulayiniz.

        //1-
        Assert.assertTrue("Login ekranina giris yapilamadi", driver.getTitle().contains("Log in"));

        //2-
        String expectedUrl="https://www.koalaresorthotels.com/Account/Logon";
        String actualUrl=driver.getCurrentUrl();
        Assert.assertEquals("Login ekranina giris yapilmadi ",expectedUrl,actualUrl);

        //3-
        WebElement L3=driver.findElement(By.xpath("//*[@id='btnSubmit']"));
        Assert.assertTrue(L3.isDisplayed());

        //4-
        Assert.assertTrue("Url yanlis", driver.getCurrentUrl().contains("Logon"));

    }
}
