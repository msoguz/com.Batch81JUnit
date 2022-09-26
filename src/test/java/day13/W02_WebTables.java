package day13;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBaseBeforeAfter;

import java.util.List;

public class W02_WebTables extends TestBaseBeforeAfter {

    @Test
    public void webtable() {

        //● Bir class oluşturun : C02_WebTables
        //● login( ) metodun oluşturun ve oturum açın.

            girisYap();
        // https://www.hotelmycamp.com admin/HotelRoomAdmin adresine gidin
        // Username : manager
        // Password : Manager1!
        // table( ) metodu oluşturun

        // Tüm table body’sinin boyutunu(sutun sayisi) bulun. /tbody
        List<WebElement> sutunBasliklariListesi=driver.findElements(By.xpath("//thead//tr[1]//th"));
        System.out.println("Sutun Sayisi : " + sutunBasliklariListesi.size());

        // Table’daki tum body’I ve başlıkları(headers) konsolda yazdırın.
        //TODO:Tum body'i bir String olarak yazdirmak isterseniz body webElementini locate edip, getText() methodu ile yazdirabilirsiniz
        WebElement tumBody= driver.findElement(By.xpath("//tbody"));
        System.out.println(tumBody.getText());

        // printRows( ) metodu oluşturun //tr
        // table body’sinde bulunan toplam satir(row) sayısını bulun.
        List<WebElement> satirlarListesi=driver.findElements(By.xpath("//tbody//tr"));
        System.out.println("Satir saysis : " + satirlarListesi.size());


        //○ Table body’sinde bulunan satirlari(rows) konsolda yazdırın.
        for (WebElement each:satirlarListesi
             ) {
            System.out.println(each.getText());
        }

        // 4.satirdaki(row) elementleri konsolda yazdırın
        List<WebElement> cellList=driver.findElements(By.xpath("//tbody//tr[4]//td"));
        for (WebElement each: cellList
             ) {
            System.out.println(each.getText());
        }

        // Email basligindaki tum elementleri(sutun) konsolda yazdırın
        //TODO: Once email basliginin kacinci sutunda oldugunu bulalim
        List<WebElement> basliklarListesi=driver.findElements(By.xpath("//thead//tr[1]//th"));
        int emailSutunNo=0;
        for (int i = 0; i <basliklarListesi.size() ; i++) {
            if(basliklarListesi.get(i).getText().equals("Email")){
                emailSutunNo=i;
            }
        }

        List<WebElement> emailSutunListesi=driver.findElements(By.xpath("//tbody//td["+(emailSutunNo+1)+"]"));
        for (WebElement each: emailSutunListesi
        ) {
            System.out.println(each.getText());
        }
    }

    public void girisYap() {
        driver.get("https://www.hotelmycamp.com");
        driver.findElement(By.linkText("Log in")).click();
        WebElement username= driver.findElement(By.id("UserName"));
        actions.click(username)
                .sendKeys("manager")
                .sendKeys(Keys.TAB)
                .sendKeys("Manager1!")
                .sendKeys(Keys.ENTER)
                .perform();
    }
}
