package day16;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utilities.TestBaseBeforeAfter;

public class C02_JSExecutor extends TestBaseBeforeAfter {

    @Test
    public void test01() {
        //Amazon sayfasina gidelim
        driver.get("https://www.amazon.com");

        //Asagidaki carreers butonunu gorunceye kadar js ile scroll yapalim
        WebElement carrers= driver.findElement(By.xpath("//*[text()='Careers']"));
        JavascriptExecutor jse= (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView(true);",carrers);


        //Carreers butonuna js ile click yapalim
        jse.executeScript("arguments[0].click();",carrers);


    }
}
