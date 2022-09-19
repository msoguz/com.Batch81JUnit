package day08;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class C04_Iframe {

    WebDriver driver;
    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @After
    public void tearDown(){
        //driver.close();
    }
    @Test
    public void test1() {
        //https://html.com/tags/iframe/ adresine gidiniz
        driver.get("https://html.com/tags/iframe/");
        //Youtube videosunu calistiriniz.
        //WebElement youtubeFrame= driver.findElement(By.xpath("//*[@src='https://www.youtube.com/embed/owsfdh4gxyc']"));
        //Burada linki locate ettik ancak linkin degisme ihtimali var.Bu durumda test'imiz calismaz.
        // Dinamik olmasi icin iframe'i locatte kullanmaliyiz.Iframe sayica cok oldugu icin bir list'e atariz.
        // driver.switchTo().frame(youtubeFrame);
        //driver.findElement(By.xpath("//*[@aria-label='Play']")).click();

        List<WebElement> iframeList=new ArrayList<>(driver.findElements(By.xpath("//iframe")));
       driver.switchTo().frame(iframeList.get(0));
       driver.findElement(By.xpath("//*[@aria-label='Play']")).click();

    }
}
