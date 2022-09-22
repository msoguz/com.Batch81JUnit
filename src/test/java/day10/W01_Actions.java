package day10;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBaseBeforeAfter;

public class W01_Actions extends TestBaseBeforeAfter {
    @Test
    public void test01() throws InterruptedException {
        //amazon ana sayfasina gidip
        //account menusunden 'create a list' linkine tiklayin

       Actions actions=new Actions(driver);
       driver.get("https://www.amazon.com");
       WebElement accountLinki= driver.findElement(By.xpath("//*[text()='Account & Lists']"));
       actions.moveToElement(accountLinki).perform();

       driver.findElement(By.xpath("//*[text()='Create a List']")).click();


       Thread.sleep(4000);

    }
}
