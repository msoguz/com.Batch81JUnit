package day10;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBaseBeforeAfter;

import javax.swing.*;

public class C03_Actions extends TestBaseBeforeAfter {
    @Test
    public void test1(){
        //Amazon sayfasina gidelim
        //Account menusunden createa a list linkine tiklyalim

        driver.get("https://www.amazon.com");

        WebElement accountList= driver.findElement(By.xpath("//*[text()='Hello, sign in']"));
        Actions actions=new Actions(driver);
       // actions.moveToElement(accountList).perform();
        /*
        Bir web sitesinde mouse ile acilan bir web elementine ulasmak istersek actions.moveToElement()
        method'unu kullanmamiz geekir. Aksi takdirde HTML kodlari arasinda web elementi bulur ama
        ulasamadigi icin ElementNotInteractableException : element not interactable exception'u firlatir.
         */
        driver.findElement(By.xpath("//*[text()='Create a List']")).click();
    }
}
