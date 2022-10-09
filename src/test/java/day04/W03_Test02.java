package day04;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class W03_Test02 {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //1. http://zero.webappsecurity.com sayfasina gidin
        driver.get("http://zero.webappsecurity.com");

        //2. Signin buttonuna tiklayin
        WebElement signinButonu= driver.findElement(By.id("signin_button"));
        signinButonu.click();

        //3. Login alanina “username” yazdirin
        WebElement loginYazma= driver.findElement(By.xpath("//input[@type='text']"));
        loginYazma.sendKeys("username");


        //4. Password alanina “password” yazdirin
        WebElement userYazma= driver.findElement(By.xpath("//input[@id='user_password']"));
        userYazma.sendKeys("password");

        //5. Sign in buttonuna tiklayin
        WebElement signInClick=driver.findElement(By.xpath("//input[@name='submit']"));
        signInClick.click();

        //6. Pay Bills sayfasina gidin
        driver.findElement(By.xpath("//strong[text()='Online Banking']")).click();
        driver.findElement(By.id("pay_bills_link")).click();

        //7. amount kismina yatirmak istediginiz herhangi bir miktari yazin
        driver.findElement(By.id("sp_amount")).sendKeys("1000");

        //8. tarih kismina “2020-09-10” yazdirin
        driver.findElement(By.id("sp_date")).sendKeys("2020-09-10");

        //9. Pay buttonuna tiklayin
        driver.findElement(By.id("pay_saved_payees")).click();

        //10. “The payment was successfully submitted.” mesajinin ciktigini control edin
        WebElement basariliYazisiElementi= driver.findElement(By.id("alert_content"));
        if(basariliYazisiElementi.isDisplayed()){
            System.out.println("Test PASSED");
        }else {
            System.out.println("Test FAILED");
        }



    }
}
