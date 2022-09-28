package day16;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import utilities.TestBaseBeforeAfter;

import java.io.File;
import java.io.IOException;

public class C01_GetScreenShotWE extends TestBaseBeforeAfter {
    @Test
    public void test01() throws IOException {
        //Amazon sayfasina gidelim
        driver.get("https://www.amazon.com");

        //Nutella aratalim
         driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Nutella", Keys.ENTER);

        //Arama sonuc yazisinin resmini alalim
        WebElement aramaSonucu= driver.findElement(By.xpath("//h1[@class='a-size-base s-desktop-toolbar a-text-normal']"));
        File nutellaAramaSonucu=aramaSonucu.getScreenshotAs(OutputType.FILE);

        //Sadece webelementin rresmini alacaksak TakeScreenShot class'ini kullanmama gerek yok.
        //Locate ettigimiz webelement'i direkt geccici bir file'e atip FileUtils ile kopyalayip yolunu(path) belirtiriz.
        FileUtils.copyFile(nutellaAramaSonucu,new File("target/ekranGoruntuleri/WebESS.jpeg"));



    }
}
