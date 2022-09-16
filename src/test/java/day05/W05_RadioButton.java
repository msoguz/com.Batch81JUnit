package day05;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class W05_RadioButton {
    //1. Bir class oluşturun : RadioButtonTest
    //2. Gerekli yapiyi olusturun ve aşağıdaki görevi tamamlayın.

    WebDriver driver;

    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @Test
    public void test1() {
        //- https://www.facebook.com adresine gidin
        driver.get("https://www.facebook.com ");

        //- “Create an Account” button’una basin
        WebElement createButton = driver.findElement(By.xpath("//a[@class='_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy']"));
        createButton.click();

        //- “radio buttons” elementlerini locate edin
        WebElement radioButton = driver.findElement(By.xpath("(//label[@class='_58mt'])[2]"));

        //- Secili degilse cinsiyet butonundan size uygun olani secin
        if(!radioButton.isSelected()){
            radioButton.click();
        }
    }

    @After
    public void tearDown() {
    driver.close();
    }
}