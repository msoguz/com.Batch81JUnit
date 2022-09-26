package day13;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBaseBeforeAfter;

public class W03_WebTables extends TestBaseBeforeAfter {
    @Test
    public void dinamikYazici() {

        //Onceki class'taki adrese gidip giris yap methodunu kullanarak sayfaya giris yapin
        //input olarak verilen satir ve sutun sayisina sahip cell'deki text'i yazdirin.

        int satir=3;
        int sutun=3;

        girisYap();

        WebElement arananCell=driver.findElement(By.xpath("//tbody//tr["+satir+"]//td["+sutun+"]"));
        System.out.println(arananCell.getText());

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
