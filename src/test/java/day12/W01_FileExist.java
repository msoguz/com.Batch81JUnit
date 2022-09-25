package day12;

import org.junit.Assert;
import org.junit.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

public class W01_FileExist {
    @Test
    public void test01() {

        System.out.println(System.getProperty("user.dir")); //C:\com.Batch81JUnit
        //Bana icinde oldugum projenin dosya yolunu(path) verir.

        System.out.println(System.getProperty("user.home"));//C:\Users\msene
        //Benim bilgisayarimin bana ozel kismi.

        //Masaustundeki text dosyasinin varligini test edelim

        String dosyaYolu=System.getProperty("user.home")+ "\\OneDrive\\Masaüstü\\text.txt";
        System.out.println(dosyaYolu);

        /*
        Bilgisayarimizdaki bir dosyanin varligini test etmek icin once o dosyaya ulasmamiz gerekir.
        Java'da dosyaya erisim  icin dosya yoluna (path) ihtiyac vardir.
        Her bilgisayarin kullanici adi farkli olacagindan masaustu dosya yolu da birbirinden farkli olacaktir.
        Testlerimizin tum bilgisayarlarda calismasi icin dosya yolunu DINAMIK yapmak zorundayiz.

        Bunun icin
        her bilgisayarin birbirinden farkli olan yolunu bulabilmek icin
        */
        String farkliKisim=System.getProperty("user.home");

        //herkesin bilgisayarinda ortak olan kisim ise
        String ortakKisim="\\OneDrive\\Masaüstü\\text.txt";

        String masaUstuDosyaYolu=farkliKisim+ortakKisim;

        System.out.println(Files.exists(Paths.get(masaUstuDosyaYolu)));

        Assert.assertTrue(Files.exists(Paths.get(masaUstuDosyaYolu)));









    }
}
