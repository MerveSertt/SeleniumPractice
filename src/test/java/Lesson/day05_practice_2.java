package Lesson;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class day05_practice_2 {
    /*
    1-C01_TekrarTesti isimli bir class olusturun
    2- https://www.amazon.com/ adresine gidin
    3- Browseri tam sayfa yapin
    4.- Sayfayi “refresh” yapin
    5. Sayfa basliginin “Spend less” ifadesi icerdigini test edin
    6. Gift Cards sekmesine basin
    7. Birthday butonuna basin
    8. Best Seller bolumunden ilk urunu tiklayin
    9. Gift card details’den 25 $’i secin
    10-Urun ucretinin 25$ oldugunu test edin
    10-Sayfayi kapatin
     */
    public static void main(String[] args) {


        System.setProperty("WebDriver.Chrome.Driver","src/resources/drivers/chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


        //2- https://www.amazon.com/ adresine gidin
        driver.get("https://www.amazon.com");

        //3- Browseri tam sayfa yapin
        driver.manage().window().fullscreen();

        //4- Sayfayi “refresh” yapin
        driver.navigate().refresh();

        //5. Sayfa basliginin “Spend less” ifadesi icerdigini test edin
        String actualTitle = driver.getTitle();
        String expectedTitle = "Spend less";

        if (actualTitle.contains(expectedTitle)){
            System.out.println("Title Test");
            System.out.println("Test Passed");
        }else {
            System.out.println("Test Failed");
        }

        //6. Gift Cards sekmesine basin
        WebElement giftCards = driver.findElement(By.xpath("(//a[@class='nav-a  ']) [4]"));
        giftCards.click();

        //7. Birthday butonuna basin
        WebElement birthdayButton = driver.findElement(By.xpath("//*[text()='Birthday']"));
        birthdayButton.click();

        //Best Seller bolumunden ilk urunu tiklayin
        WebElement bestSeller = driver.findElement(By.xpath("//*[text()='Best Sellers']"));
        bestSeller.click();
        WebElement ilkUrun = driver.findElement(By.xpath("//*[@alt='Amazon Reload']"));
        ilkUrun.click();


        //9. Gift card details’den 25 $’i secin
        WebElement ucret = driver.findElement(By.xpath("(//button[@name='selectAmount']) [1]"));
        ucret.click();


        //10-Urun ucretinin 25$ oldugunu test edin
        String actual = ucret.getText();
        String expected = "25 $";

        if (actual.contains(expected)){
            System.out.println("Ücret Testi");
            System.out.println("Test Passed");
        }else {
            System.out.println("Test Failed");
        }

        //10-Sayfayi kapatin
        driver.close();



    }
}
