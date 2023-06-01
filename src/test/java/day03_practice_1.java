import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class day03_practice_1 {
    public static void main(String[] args) {
        System.setProperty("WebDriver.Chrome.Driver","src/resources/drivers/chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        /*
            ODEV
       Amazon sayfasına git
       iphone aratın
       çıkan sonuç yazısını konsola yazdırınız
       çıkan ürünlerden ilk 5 tanesine tıklayıp sayfa başlıklarını yazdırınız.

     */

        driver.get("https://www.amazon.com");

        driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("iphone", Keys.ENTER);

        WebElement sonucYazisi = driver.findElement(By.xpath("(//div[@class='sg-col-inner']) [1]"));
        System.out.println(sonucYazisi.getText());


        for (int i = 0; i < 5; i++) {
            List <WebElement> sonuclar = driver.findElements(By.xpath("//div[@class='a-section aok-relative s-image-fixed-height']"));
            sonuclar.get(i).click();
            System.out.println((i+1) +". Sayfa Başlığı: " + driver.getTitle());
            driver.navigate().back();
        }

        driver.close();








        /*
        Çözüm
        //-ÖDEV-
        //Amazon sayfasına gidiniz
        driver.get("https://amazon.com");
        //iphone aratınız
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone", Keys.ENTER);
        //çıkan sonuç yazısını konsola yazdırınız
        WebElement sonucYazisi = driver.findElement(By.xpath("//h1//*[@class='a-section a-spacing-small a-spacing-top-small']"));
        System.out.println(sonucYazisi.getText());
        String [] sonucSayisi = sonucYazisi.getText().split(" ");
        System.out.println("Sonuc Sayisi = "+sonucSayisi[2]);
        //çıkan ürünlerden ilk 5 tanesine tıklayıp sayfa başlıklarını yazdırınız
        for (int i = 0; i < 5 ; i++) {
            List<WebElement> urunler = driver.findElements(By.xpath("//*[@class='a-section aok-relative s-image-fixed-height']"));
            Thread.sleep(2000);
            urunler.get(i).click();
            Thread.sleep(2000);
            System.out.println((i+1)+". Urun basligi : "+driver.getTitle());
            driver.navigate().back();
            Thread.sleep(2000);
        }
        driver.close();
         */


    }
}
