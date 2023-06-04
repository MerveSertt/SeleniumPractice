package ClassWork;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class TekrarTesti {
    public static void main(String[] args) {
        System.setProperty("WebDriver.Chrome.Driver","src/resources/drivers/chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        /*
        1-C01_TekrarTesti isimli bir class olusturun
        2- https://www.google.com/ adresine gidin
        3- cookies uyarisini kabul ederek kapatin
        4. Sayfa basliginin “Google” ifadesi icerdigini test edin
        5. Arama cubuguna “Nutella” yazip aratin
        6. Bulunan sonuc sayisini yazdirin
        7. sonuc sayisinin 10 milyon’dan fazla oldugunu test edin
        8. Sayfayi kapatin
         */

        driver.get("https://www.google.com/");

        String title = driver.getTitle();
        if (title.contains("google")){
            System.out.println("Title google ifadesi içeriyor");
        }else {
            System.out.println("Title google ifadesi içermiyor");
        }

        WebElement aramaKutusu = driver.findElement(By.xpath("//textarea[@id='APjFqb']"));
        aramaKutusu.sendKeys("Nutella", Keys.ENTER);

        WebElement sonucYazisi = driver.findElement(By.xpath("//div[@id='result-stats']"));
        String sonucYazisiString = sonucYazisi.getText();
        String[] sonuclar = sonucYazisiString.split(" ");
        String sonucSayisi = sonuclar[1];
        String sadecesayi = sonucSayisi.replace(".","");
        System.out.println(sadecesayi);
        int sonucSayi = Integer.parseInt(sadecesayi);
        System.out.println("Sonuç Sayısı: " + sonucSayisi);

        if (sonucSayi>10000000){
            System.out.println("Sonuç Sayısı 10 milyondan fazla");
        }else {
            System.out.println("Sonuç Sayısı 10 milyondan az");
        }

        driver.close();


    }
}
