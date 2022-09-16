package day05;

import org.junit.Test;

public class W01_Notasyon {

    //Java'daki gibi selenium'da da belirli islevleri yapan methodlar olusturabiliriz
    //Ancak bu methodlar cagrilmadikca calismazlar

    public void ilkTestMEthodu(){
        System.out.println("Ilk test methodumuz");
    }
    //JUnit ile notasyon kullanarak siradan methodlari test methoduna donusturebiliriz
    //Bir Test Method'u bagimsiz olarak calisabilen test yapmamiza imkan verir
    //@Test notasyonu sayesinde main method mecburiyeti ortadan kalkar.

    @Test
    public void notasyonluIlkTestMethodu(){
        System.out.println("Notasyonlu ilk test methodumuz");

    }








}
