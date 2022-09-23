package day12;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBaseBeforeAfter;

import java.time.Duration;

public class C03_SenkronizasyonWait extends TestBaseBeforeAfter {

    @Test
    public void implicitlyWaitTest01() {
        //Bir class olusturun : WaitTest
        //Iki tane metod olusturun : implicitWait() , explicitWait()
        /*
        implicitlyWait kullandigimiz bu methodda sayfadaki butun webelement'ler icin max belirttigimiz sure altinda
        butun webelementler icin bekler.

         */

        //Iki metod icin de asagidaki adimlari test edin.
        //https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        //Remove butonuna basin.
        driver.findElement(By.xpath("//*[text()='Remove']")).click();

        //“It’s gone!” mesajinin goruntulendigini dogrulayin.

        Assert.assertTrue(driver.findElement(By.xpath("//*[text()=\"It's gone!\"]")).isDisplayed());

        //Add buttonuna basin
        driver.findElement(By.xpath("//*[text()='Add']")).click();

        //It’s back mesajinin gorundugunu test edin
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id='message']")).isDisplayed());

    }

    @Test
    public void explicitlyWaitTest02(){
        //https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        //Remove butonuna basin.
        driver.findElement(By.xpath("//*[text()='Remove']")).click();

        //“It’s gone!” mesajinin goruntulendigini dogrulayin.
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement itsGoneWebElem=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()=\"It's gone!\"]")));
        Assert.assertTrue(itsGoneWebElem.isDisplayed());
        /*
        explicitlyWait itsGoneWebElem gorunur olmasini beklerken o webelementinin locate'ini kullanarak assert yapmak
        sorun olur ve exception firlatir. Henuz gorunnmeyen bir web elementin locate edilmesi de otomasyon icin mumkun olmaz.
        Bu durumda bekleme islmei icin explicitlyWait'i locate ile birlikte kullaniriz.
         */

        //Add buttonuna basin
        driver.findElement(By.xpath("//*[text()='Add']")).click();

        //It’s back mesajinin gorundugunu test edin

        WebElement itsBackWebElem=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='message']")));
        Assert.assertTrue(itsBackWebElem.isDisplayed());
    }
}
