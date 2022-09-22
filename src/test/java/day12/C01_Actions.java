package day12;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBaseBeforeAfter;

public class C01_Actions extends TestBaseBeforeAfter {

    @Test
    public void test01() {

        //Automationexercises.com sitesine gidiniz
        driver.get("https://www.automationexercise.com");

        //product bolumune girelim
        driver.findElement(By.cssSelector("a[href=\"products\"]")).click();

        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        driver.findElement(By.xpath("//*[@class='fa fa-plus-square']")).click();

        //ilk urune tiklayalim

    }
}
