package day10;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBaseBeforeAfter;

public class C05_Actions extends TestBaseBeforeAfter {

    @Test
    public void test1() throws InterruptedException {


        //Yeni bir class olusturalim: MouseActions2
        //1 https://demoqa.com/droppable adresine gidelim
        driver.get("https://demoqa.com/droppable");

        //2 “Drag me” butonunu tutup “Drop here” kutusunun ustune birakalim
        WebElement dragMe= driver.findElement(By.xpath("//*[@id='draggable']"));
        WebElement dropHere=driver.findElement(By.xpath("(//*[@id='droppable'])[1]"));
        Actions actions=new Actions(driver); //Actions objesini TestBase Class'ta da aolusturabilir ve burada kullanmayaniliriz.
        Thread.sleep(3000);
        actions.dragAndDrop(dragMe,dropHere).perform();

        //3 “Drop here” yazisi yerine “Dropped!” oldugunu test edin
        Assert.assertEquals("Dropped!",driver.findElement(By.xpath("//*[text()='Dropped!']")).getText());
    }



}
