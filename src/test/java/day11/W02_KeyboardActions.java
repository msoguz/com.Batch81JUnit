package day11;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBaseBeforeAfter;

public class W02_KeyboardActions extends TestBaseBeforeAfter {

    @Test
    public void test01() {
        //facebook anasayfaya gidip
        driver.get("https://www.facebook.com");
        // yeni kayit olustur butonuna basalim.
        driver.findElement(By.xpath("//a[@class='_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy']")).click();
        //Isim kutusunu locate edip geri kalan alanlari TAB ile dolasarak
        WebElement isimKutusu= driver.findElement(By.xpath("//input[@name='firstname']"));

        //geri kalan alanlari TAB ile dolasarak
        //formu doldurun
        Actions actions=new Actions(driver);
        actions.click(isimKutusu)
                .sendKeys("Taha")
                .sendKeys(Keys.TAB)
                .sendKeys("Usta")
                .sendKeys(Keys.TAB)
                .sendKeys("abcdef@gmail.com");




    }
}
