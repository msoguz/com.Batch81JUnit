package day16;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utilities.TestBaseBeforeAfter;

public class W01_JS_Executer extends TestBaseBeforeAfter {
    @Test
    public void JSExecuterTest() throws InterruptedException {

        //amazon'a git
        driver.get("https://www.amazon.com");

        //asagidaki sign in butonu gorununceye kadar js ile scrool yap.
        JavascriptExecutor jse= (JavascriptExecutor) driver;
        WebElement signInButonu= driver.findElement(By.xpath("(//span[text()='Sign in'])[2]"));
        Thread.sleep(2000);
        jse.executeScript("arguments[0].scrollIntoView(true);",signInButonu);

        //sign in butonuna click yap.
        jse.executeScript("arguments[0].click();",signInButonu);


    }
}
