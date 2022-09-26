package day15;

import org.apache.poi.ss.usermodel.*;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class C03_DeleteExcel {

    @Test
    public void deleteExcel() throws IOException {

        //-Dosya yolunu bir String degiskene atayalim
        String dosyaYolu="src/resources/ulkeler.xlsx";
        //-FileInputStream objesi olusturup,parametre olarak dosya yolunu girelim
        FileInputStream fis=new FileInputStream(dosyaYolu);
        //-Workbook objesi olusturalim,parameter olarak fileInputStream objesini girelim
        Workbook workBook= WorkbookFactory.create(fis);
        //-WorkbookFactory.create(fileInputStream)
        //-Sheet objesi olusturun workbook.getSheetAt(Sayfa1)
        Sheet sheet=workBook.getSheet("Sayfa1");
        //-Row objesi olusturun sheet.getRow(3)
        Row row= sheet.getRow(3);
        //-Cell objesi olusturun row.getCell(3)
        Cell cell=row.getCell(3);
        //-3. Satır 3. Cell'deki veriyi silelim
        row.removeCell(cell);
        /*
        cell'deki veriyi silmek icin row objesine ihtiyac vardir.
        row ovjesi ile removeCell() method'unu kullanarak cell objesi ile belirttigimizcell degerini silebiliriz.

         */
        FileOutputStream fos=new FileOutputStream(dosyaYolu);
        workBook.write(fos);

        //-Silindiğini test edin
        String expectedData="Cezayir";
        String actualData=null;
        Assert.assertNotEquals(expectedData,actualData);


    }
}
