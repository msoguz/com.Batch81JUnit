package day12;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBaseBeforeAfter;

public class W03_FileUpload extends TestBaseBeforeAfter {

    @Test
    public void test01() throws InterruptedException {

        //1. Tests packagenin altina bir class oluşturun : C05_UploadFile
        //2. https://the-internet.herokuapp.com/upload adresine gidelim
        driver.get("https://the-internet.herokuapp.com/upload");
        //3. chooseFile butonuna basalim
        //4. Yuklemek istediginiz dosyayi secelim.
        /*
        Bu islemi selenium ile yapma imkanimiz yok, cunku web tabanli bir uygulama degil.
        Bu durumda sendKeys() imdadimiza yetisir. Eger chooseFile butonuna varolan bir dosyanin
         dosya yolunu yollarsaniz secme islemi otomatik olarak yapilmis olacaktir.
         */

        //1.ADIM: choose file butonunu locate edelim
        WebElement dosyaSecButonu=driver.findElement(By.id("file-upload"));

        //2.ADIM: yuklenecek dosyanin dosya yolunu olusturalim.
        //Biz masaustundeki Text.txt dosyasini yukleyelim
        String farkliKisim=System.getProperty("user.home");
        String ortakKisim="\\OneDrive\\Masaüstü\\text.txt";
        String yuklenecekDosya=farkliKisim+ortakKisim;

        //3.ADIM: sendKeys ile dosya yolunu, secme butonuna yollayalim.
        dosyaSecButonu.sendKeys(yuklenecekDosya);


        Thread.sleep(3000);

        //5. Upload butonuna basalim.
        driver.findElement(By.xpath("//input[@id='file-submit']")).click();

        //6. “File Uploaded!” textinin goruntulendigini test edelim.
        WebElement yaziElementi= driver.findElement(By.tagName("h3"));
        Assert.assertTrue(yaziElementi.isDisplayed());
    }
}
