package Lesson;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class day02_practice_2 {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","src/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        /*
        2. Amazon soyfasina gidelim. https://www.amazon.com/
        3. Sayfanin konumunu ve boyutlarini yazdirin
        4. Sayfayi simge durumuna getirin
        5. simge durumunda 3 saniye bekleyip sayfayi maximize yapin
        6. Sayfanin konumunu ve boyutlarini maximize durumunda
        yazdirin
        7. Sayfayi fullscreen yapin
        8. Sayfanin konumunu ve boyutlarini fullscreen durumunda
        yazdirin
        9. Sayfayi kapatin
         */

        driver.get("https://www.amazon.com");
        System.out.println("Sayfanın Konumu: " + driver.manage().window().getPosition());
        System.out.println("Sayfanın Boyutları: " + driver.manage().window().getSize());
        driver.manage().window().minimize();
        Thread.sleep(3000);
        driver.manage().window().maximize();
        System.out.println("Sayfanın Maximize Konumu: " +driver.manage().window().getPosition());
        System.out.println("Sayfanın Maximize Boyutları: " +driver.manage().window().getSize());
        driver.manage().window().fullscreen();
        System.out.println("Sayfanın Full Screen Konumu: " +driver.manage().window().getPosition());
        System.out.println("Sayfanın Full Screen Boyutları: " +driver.manage().window().getSize());
        driver.close();


    }
}
