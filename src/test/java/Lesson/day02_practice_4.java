package Lesson;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class day02_practice_4 {
    public static void main(String[] args) {
        System.setProperty("WebDriver.Chrome.Driver","src/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        /*
        2.ChromeDriver kullanarak, facebook sayfasina gidin ve sayfa basliginin (title) “facebook”
        oldugunu dogrulayin (verify), degilse dogru basligi yazdirin.
        3.Sayfa URL’inin “facebook” kelimesi icerdigini dogrulayin, icermiyorsa “actual” URL’i
        yazdirin.
        4.https://www.walmart.com/ sayfasina gidin.
        5. Sayfa basliginin “Walmart.com” icerdigini dogrulayin.
        6. Tekrar “facebook” sayfasina donun
        7. Sayfayi yenileyin
        8.Sayfayi tam sayfa (maximize) yapin
        9.9.Browser’i kapatin
         */

        //2
        driver.get("https://www.facebook.com");

        String expectedTitle = "facebook";
        String actualTitle = driver.getTitle();
        if (expectedTitle.equals(actualTitle)){
            System.out.println("Test PASSED");
        }else {
            System.out.println("Test FAILED \n Actual Title: " + actualTitle);
        }

        //3
        String expectedUrl = "facebook";
        String actualUrl = driver.getCurrentUrl();
        if (actualUrl.contains(expectedUrl)){
            System.out.println("Test PASSED");
        }else {
            System.out.println("Test FAILED \n Actual Url: " + actualUrl);
        }

        //4
        driver.get("https://www.Walmart.com");

        //5
        String actualTitle2 = driver.getTitle();
        String expectedTitle2 = "Walmart.com";

        if (actualTitle2.contains(expectedTitle2)){
            System.out.println("Test PASSED");
        }else {
            System.out.println("Test FAILED");
        }

        //6
        driver.navigate().back();

        //7
        driver.navigate().refresh();

        //8
        driver.manage().window().maximize();

        //9
        driver.close();





    }
}
