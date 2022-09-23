package day13;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBaseBeforeAfter;

import java.util.List;

public class C02_WebTable extends TestBaseBeforeAfter {
    @Test
    public void test01() {
        //● Bir class oluşturun : C02_WebTables
        //● login( ) metodun oluşturun ve oturum açın.
        login();

        //● https://www.hotelmycamp.com/admin/HotelRoomAdmin adresine gidin

        //○ Username : manager
        //○ Password : Manager1!
        //● table( ) metodu oluşturun
        table();

    }

    private void table() {
        //○ Tüm table body’sinin boyutunu(sutun sayisi) bulun. /tbody

        /*
        Tabloda <table> tag'i altinda tablonun basligini gosteren <thead> tag'i bulunur.
        Eger baslikta satir(row) varsa <thead> tag'i altinda <tr> (satir-row) tag'i vardir ve baslikyaki sutunlara
        yani hucrelere(cell) de <th> tag'i ile ulasilir.Basligin altindaki tablodaki verilere <tbody> tag'i ile
        altindaki satirlara(row) <tr> tag'i ile sutunlara yani hucrelere <td> tag'i ile ulasilir.

         */
        List<WebElement> sutunSayisi=driver.findElements(By.xpath("//thead//tr//th"));
        System.out.println("Sutun Sayisi= " + sutunSayisi.size());
        // Table’daki tum body’I ve başlıkları(headers) konsolda yazdırın.
        WebElement basliklar= driver.findElement(By.xpath("//thead//tr"));
        System.out.println("Basliklar : " + basliklar.getText());
        WebElement body= driver.findElement(By.xpath("//tbody"));
        System.out.println("tum body : " + body.getText());

        // printRows( ) metodu oluşturun //tr

        // table body’sinde bulunan toplam satir(row) sayısını bulun.
        List<WebElement> satirList=driver.findElements(By.xpath("//tbody//tr"));
        System.out.println("Tablodaki Satir sayisi : " + satirList.size());

        // Table body’sinde bulunan satirlari(rows) konsolda yazdırın.
        satirList.forEach(t-> System.out.println(t.getText()));


        // 4.satirdaki(row) elementleri konsolda yazdırın.
        System.out.println(driver.findElement(By.xpath("//tbody//tr[4]")).getText());

    }

    private void login(){
        driver.get("https://www.hotelmycamp.com/admin/HotelRoomAdmin");
       // driver.findElement(By.xpath("//*[@id='UserName']")).click();
        Actions actions=new Actions(driver);
        WebElement userName= driver.findElement(By.xpath("//*[@id='UserName']"));
        actions.click(userName).sendKeys("manager").
                sendKeys(Keys.TAB).sendKeys("Manager1!").sendKeys(Keys.ENTER).perform();
    }
}
