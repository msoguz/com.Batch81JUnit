package day11;

import com.github.javafaker.Faker;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBaseBeforeAfter;

public class C02_Actions extends TestBaseBeforeAfter {
    @Test
    public void test01() throws InterruptedException {
        //1- https://www.facebook.com adresine gidelim
        driver.get("https://www.facebook.com");

        //2- Yeni hesap olustur butonuna basalim
        driver.findElement(By.xpath("//*[@class='_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy']")).click();

        //3- Ad, soyad, mail ve sifre kutularina deger yazalim ve kaydol tusuna basalim
        //Actions actions=new Actions(driver); //TestBaseBeforeAfter classinda tanimladigi icin extends oldugundan burada tekara tanimlamadik.
        WebElement isim = driver.findElement(By.xpath("(//*[@class='inputtext _58mg _5dba _2ph-'])[1]"));
        Faker faker=new Faker();
        String email=faker.internet().emailAddress();

        isim.sendKeys("Sener");
        actions.sendKeys(Keys.TAB)
                .sendKeys("Oguz")
                .sendKeys(Keys.TAB)
                .sendKeys("seneroguz@gmail.com")
                .sendKeys(Keys.TAB)
                .sendKeys("seneroguz@gmail.com")
                .sendKeys(Keys.TAB)
                .sendKeys("1234567")
                .sendKeys(Keys.TAB).sendKeys(Keys.TAB)
                .sendKeys("1")
                .sendKeys(Keys.TAB)
                .sendKeys("Nisan")
                .sendKeys(Keys.TAB)
                .sendKeys("1978")
                .sendKeys(Keys.TAB).sendKeys(Keys.TAB)
                .sendKeys(Keys.RIGHT)
                .sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB).sendKeys(Keys.TAB)
                .sendKeys(Keys.ENTER).perform();









    }
}
