package day11;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBaseBeforeAfter;

public class W02_KeyboardActions extends TestBaseBeforeAfter {

    @Test
    public void test01() throws InterruptedException {
        //facebook anasayfaya gidip
        driver.get("https://www.facebook.com");
        // yeni kayit olustur butonuna basalim.
        driver.findElement(By.xpath("//a[@class='_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy']")).click();
        //Isim kutusunu locate edip geri kalan alanlari TAB ile dolasarak
        WebElement isimKutusu= driver.findElement(By.xpath("//input[@placeholder='First name']"));

        //geri kalan alanlari TAB ile dolasarak
        //formu doldurun
        Actions actions=new Actions(driver);
        Thread.sleep(2000);
        actions.click(isimKutusu)
                .sendKeys("Taha")
                .sendKeys(Keys.TAB)
                .sendKeys("Usta")
                .sendKeys(Keys.TAB)
                .sendKeys("abcdef@gmail.com")
                .sendKeys(Keys.TAB)
                .sendKeys("abcdef@gmail.com")
                .sendKeys(Keys.TAB)
                .sendKeys("1234abc.")
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                        .sendKeys("Apr")
                .sendKeys(Keys.TAB)
                        .sendKeys("10")
                .sendKeys(Keys.TAB)
                        .sendKeys("1999")
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.ARROW_DOWN)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.ENTER)
                .perform();

        Thread.sleep(3000);





    }
}
