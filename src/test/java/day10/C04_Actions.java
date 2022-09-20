package day10;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBaseBeforeAfter;

import java.util.ArrayList;
import java.util.List;

public class C04_Actions extends TestBaseBeforeAfter {
    @Test
    public void test1() {


    //1-Yeni bir class olusturalim: MouseActions1
    //2-https://the-internet.herokuapp.com/context_menu sitesine gidelim
        driver.get("https://the-internet.herokuapp.com/context_menu");
    //3- Cizili alan uzerinde sag click yapalim
        WebElement cizgiliAlan= driver.findElement(By.xpath("//*[@id='hot-spot']"));
        Actions actions=new Actions(driver);
        actions.contextClick(cizgiliAlan).perform();

    //4- Alert’te cikan yazinin “You selected a context menu” oldugunu test edelim.

        String expectedAlertYazisi="You selected a context menu";
        String actualAlertYazisi=driver.switchTo().alert().getText();
        Assert.assertEquals(expectedAlertYazisi,actualAlertYazisi);
        // Assert.assertEquals("You selected a context menu",driver.switchTo().alert().getText()); // kisa yolu

    //5- Tamam diyerek alert’i kapatalim
        driver.switchTo().alert().accept();

    //6- Elemental Selenium linkine tiklayalim
        driver.findElement(By.xpath("//*[text()='Elemental Selenium']")).click();
    //7- Acilan sayfada h1 taginda “Elemental Selenium” yazdigini test edelim
        List<String> windowList=new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(windowList.get(1));
        Assert.assertEquals("Elemental Selenium",driver.findElement(By.xpath("//h1")).getText());
}
}
