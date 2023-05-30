import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class day02_practice_3 {
    public static void main(String[] args) {
        System.setProperty("WebDriver.Chrome.Driver","src/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        /*
        2. Amazon soyfasina gidelim. https://www.amazon.com/
        3. Sayfanin konumunu ve boyutlarini yazdirin
        4. Sayfanin konumunu ve boyutunu istediginiz sekilde
        ayarlayin
        5. Sayfanin sizin istediginiz konum ve boyuta geldigini test
        edin
        8. Sayfayi kapatin
         */

        driver.get("https://www.amazon.com");
        System.out.println("Amazon Sayfası Konumu: " + driver.manage().window().getPosition());
        System.out.println("Amazon Sayfaso Boyutları: " + driver.manage().window().getSize());

        Point amazonKonumAyari = new Point(80,0);
        driver.manage().window().setPosition(amazonKonumAyari);
        driver.manage().window().getPosition();

        Dimension amazonboyutAyari = new Dimension(800,600);
        driver.manage().window().setSize(amazonboyutAyari);
        driver.manage().window().getSize();


        Point currentPosition = driver.manage().window().getPosition();
        Dimension currentSize = driver.manage().window().getSize();


        if (currentPosition.equals(amazonKonumAyari)){
            System.out.println("Test PASSED");
        }else {
            System.out.println("Test FAILED \n Var Olan Konum: "+ currentPosition);
        }

        if (currentSize.equals(amazonboyutAyari)){
            System.out.println("Test PASSED");
        }else {
            System.out.println("Test FAILED \n Var Olan Konum Ayari; " + currentSize);
        }

        driver.close();

    }
}
