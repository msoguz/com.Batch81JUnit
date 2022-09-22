package day10;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBaseBeforeAfter;

public class W03_Actions extends TestBaseBeforeAfter {
    @Test
    public void test01() {

        //1 https://demoqa.com/droppable adresine gidelim
        driver.get("https://demoqa.com/droppable");

        //2 “Drag me” butonunu tutup “Drop here” kutusunun ustune birakalim
        Actions actions=new Actions(driver);
        WebElement tasinacakElement= driver.findElement(By.xpath("//div[@id='draggable']"));
        WebElement hedefElement= driver.findElement(By.xpath("(//div[@id='droppable'])[1]"));
        actions.dragAndDrop(tasinacakElement,hedefElement).perform();

        //3 “Drop here” yazisi yerine “Dropped!” oldugunu test edin
        WebElement sonucYazisiElementi= driver.findElement(By.xpath("//*[text()='Dropped!']"));

        String expectedYazi="Dropped!";
        String actualYazi=sonucYazisiElementi.getText();
        Assert.assertEquals(expectedYazi,actualYazi);
    }
}
