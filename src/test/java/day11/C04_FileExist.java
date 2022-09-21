package day11;

import org.junit.Assert;
import org.junit.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C04_FileExist {
    @Test
    public void test01() {
        System.out.println(System.getProperty("user.dir"));//  C:\com.Batch81JUnit
        //Suanki icinde bulundugum yolu gosterir
        System.out.println(System.getProperty("user.home"));// C:\Users\msene
        //Gecerli kullanicinin ana dizinini verir.

        /*
        String farkliBolum=System.getProperty("user.home");
        //C:\Users\msene\OneDrive\Masaüstü\text.txt.txt

        String ortakBolum = "\\OneDrive\\Masaüstü\\tex.txt";
        String masaUstuDosyaYolu = farkliBolum+ortakBolum; // Masaüstündeki dosya yolunu gösterir
        System.out.println(masaUstuDosyaYolu); //C:\Users\msene\OneDrive\Masaüstü\text.txt.txt
        System.out.println(Files.exists(Paths.get(dosyaYolu)));
        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));
 */

        String dosyaYolu="C:\\Users\\msene\\OneDrive\\Masaüstü\\text.txt.txt";
        System.out.println(Files.exists(Paths.get(dosyaYolu)));
        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));

        /*

        Bir web sitesinden indirdigimiz ya da windows icinde olusturdugumuz dosyann indirildigini ua da orada
        oldugunu test edebilmem icin o dosyanin uzerine shift tusunua basili olarak sag click yapip
        yolunu kopyalayip bir String degiskene atariz ve dosyayi dogrulamak icin
        Assert.assertTrue(files.exists(paths.get(dosyaYolu))); methodunu kullaniriz.
         */


    }
}
