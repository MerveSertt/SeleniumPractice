import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class day02_practice_5 {
    public static void main(String[] args) {
        System.setProperty("WebDriver.Chrome.Driver","src/resources/drivers/chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        /*
        2. Youtube web sayfasına gidin ve sayfa başlığının “youtube” olup olmadığını doğrulayın
        (verify), eğer değilse doğru başlığı(Actual Title) konsolda yazdirin.
        3. Sayfa URL'sinin “youtube” içerip içermediğini (contains) doğrulayın, içermiyorsa doğru
        URL'yi yazdırın.
        4. Daha sonra Amazon sayfasina gidin https://www.amazon.com/
        5. Youtube sayfasina geri donun
        6. Sayfayi yenileyin
        7. Amazon sayfasina donun
        8. Sayfayi tamsayfa yapin
        9. Ardından sayfa başlığının "Amazon" içerip içermediğini (contains) doğrulayın, Yoksa doğru
        başlığı(Actual Title) yazdırın.
        10.Sayfa URL'sinin https://www.amazon.com/ olup olmadığını doğrulayın, degilse doğru
        URL'yi yazdırın
        11.Sayfayi kapatin
         */

        //2
        driver.get("https://www.youtube.com");

        String actualTitleForYoutube = driver.getTitle();
        String expectedTitleForYoutube = "youtube";

        if (actualTitleForYoutube.equals(expectedTitleForYoutube)){
            System.out.println("Test PASSED");
        }else {
            System.out.println("Test FAILED \n Actual Title: " + actualTitleForYoutube);
        }

        //3
        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "youtube";

        if (actualUrl.contains(expectedUrl)){
            System.out.println("Test PASSED");
        }else {
            System.out.println("Test FAILED \n Actual Url: " + actualUrl);
        }

        //4
        driver.get("https://www.amazon.com");

        //5
        driver.navigate().back();

        //6
        driver.navigate().refresh();

        //7
        driver.navigate().forward();

        //8
        driver.manage().window().fullscreen();

        //9
        String actualTitleForAmazon = driver.getTitle();
        String expectedTitleForAmazon = "Amazon";

        if (actualTitleForAmazon.contains(expectedTitleForAmazon)){
            System.out.println("Test PASSED");
        }else {
            System.out.println("Test FAILED \n Actual Title: " + actualTitleForAmazon);
        }

        //10
        String actualUrlForAmazon = driver.getCurrentUrl();
        String expectedUrlForAmazon = "https://www.amazon.com/";

        if (expectedUrlForAmazon.equals(actualUrlForAmazon)){
            System.out.println("Test PASSED");
        }else {
            System.out.println("Test FAILED \n Actual Url For Amazon: " + actualUrlForAmazon);
        }

        //11
        driver.close();



    }

}
