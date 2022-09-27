package day14;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;

public class W05_ReadExcel {
    @Test
    public void readExcel() throws IOException {

        //7. Dosya yolunu bir String degiskene atayalim
        String dosyaYolu="src/resources/ulkeler.xlsx";

        //8. FileInputStream objesi olusturup,parametre olarak dosya yolunu girelim
        FileInputStream fis=new FileInputStream(dosyaYolu);

        //9. Workbook objesi olusturalim,parameter olarak fileInputStream objesini girelim
        //10. WorkbookFactory.create(fileInputStream)
        Workbook workbook= WorkbookFactory.create(fis);

        //sayfa2'ye gidip satir sayisinin 24, kullanilan satir sayisinin 12 oldugunu test edin

        int sonSatirIndexi=workbook
                .getSheet("Sayfa2")
                .getLastRowNum();
        int expectedSatirSayisi=24;
        Assert.assertEquals(expectedSatirSayisi,sonSatirIndexi+1);

        int kullanilanSatirSayisi=workbook
                .getSheet("Sayfa2")
                .getPhysicalNumberOfRows();

        int expectedKullanilanSatirSayisi=12;
        Assert.assertEquals(expectedKullanilanSatirSayisi,kullanilanSatirSayisi);




    }
}
