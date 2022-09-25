package day12;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBaseBeforeAfter;

import java.nio.file.Files;
import java.nio.file.Paths;

public class W02_fileDownload extends TestBaseBeforeAfter {



    @Test
    public void test01() throws InterruptedException {
        //1. Tests packagenin altina bir class oluşturalim : C04_FileDownload
        //2. https://the-internet.herokuapp.com/download adresine gidelim.
        driver.get("https://the-internet.herokuapp.com/download");

        //3. LambdaTest.txt dosyasını indirelim
        WebElement lambdaTextLinki= driver.findElement(By.xpath("//a[text()='LambdaTest.txt']"));
       lambdaTextLinki.click();
       Thread.sleep(3000);

        //4. Dosyanın başarıyla indirilip indirilmediğini test edelim
        //dosya downloads'a indirilecektir.Bize downloads'in dosya yolu lazim.

        String farkliKisim=System.getProperty(("user.home"));
        String ortakKisim="\\Downloads\\LambdaTest.txt";

        String arananDosyaYolu=farkliKisim+ortakKisim;

        //geriye o dosya yolundaki dosyanin var oldugunu assert edelim
        Assert.assertTrue(Files.exists(Paths.get(arananDosyaYolu)));





    }
}
