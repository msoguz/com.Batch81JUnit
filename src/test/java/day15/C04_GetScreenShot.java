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

public class C04_GetScreenShot extends TestBaseBeforeAfter {

    @Test
    public void test01() throws IOException {
        //Amazon sayfasina git.
        driver.get("https://www.amazon.com");

        //Tum sayfanin resmini al.


        /*
        Bir web sayfasinin resmini alabilmek icin TakesScreenshot class'indan obje olusturup
        gecici bir File class'indan degiskene,TakesScreenShot'dan olusturdugum obje'den getScreenShotAs method'unu kullnarak
        gecici bir file olustururuz.
         */



        TakesScreenshot ts= (TakesScreenshot) driver;

        File tumSayfaResmi=ts.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(tumSayfaResmi,new File("target/ekranGoruntuleri/amazonallPage"+tarih+".jpeg"));
        System.out.println(tarih);

    }
}
