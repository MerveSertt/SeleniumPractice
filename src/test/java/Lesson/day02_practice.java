package Lesson;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class day02_practice {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","src/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();


    /*

    2. Youtube ana sayfasina gidelim . https://
    www.youtube.com/
    3. Amazon soyfasina gidelim. https://www.amazon.com/
    4. Tekrar YouTube’sayfasina donelim
    5. Yeniden Amazon sayfasina gidelim
    6. Sayfayi Refresh(yenile) yapalim
    7. Sayfayi kapatalim / Tum sayfalari kapatalim

     */

    driver.get("https://www.youtube.com");
    driver.get("https://www.amazon.com");
    driver.navigate().back();
    driver.navigate().forward();
    driver.navigate().refresh();
    driver.close();
    driver.quit();


    }
}
