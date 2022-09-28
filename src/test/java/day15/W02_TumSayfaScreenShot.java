package day15;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utilities.TestBaseBeforeAfter;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class W02_TumSayfaScreenShot extends TestBaseBeforeAfter {
    @Test
    public void tumSayfa() throws IOException {
        //amazon sayfasina gidip tum sayfanin ekran goruntusunu cekelim

        driver.get("https://www.amazon.com");
        //1.Adim
        TakesScreenshot ts= (TakesScreenshot) driver;
        //2.Adim
        File tumSayfaResim=new File("target/ekranGoruntuleri/tumSayfa.jpeg");
        //3.Adim
        File geciciDosya=ts.getScreenshotAs(OutputType.FILE);
        //4.Adim
        FileUtils.copyFile(geciciDosya,tumSayfaResim);

        LocalDateTime date=LocalDateTime.now();
        DateTimeFormatter dtf=DateTimeFormatter.ofPattern("YYMMddHHmmss");
        String tarih= date.format(dtf);


    }
}
