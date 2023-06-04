package ClassWork;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Soru3 {
    public static void main(String[] args) {
        System.setProperty("WebDriver.Chrome.Driver","src/resources/drivers/chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

       // 1.“https://www.saucedemo.com” Adresine gidin
        driver.get("https://www.saucedemo.com");

       // 2. Username kutusuna “standard_user” yazdirin
       WebElement userName = driver.findElement(By.xpath("(//input[@class='input_error form_input']) [1]"));
       userName.sendKeys("standard_user");

       // 3. Password kutusuna “secret_sauce” yazdirin
        WebElement password  = driver.findElement(By.xpath("(//input[@class='input_error form_input']) [2]"));
        password.sendKeys("secret_sauce");

       // 4. Login tusuna basin
        driver.findElement(By.xpath("//input[@id='login-button']")).click();

       // 5. Ilk urunun ismini kaydedin ve bu urunun sayfasina gidin
        WebElement ilkUrun = driver.findElement(By.xpath("(//div[@class='inventory_item_name']) [1]"));
        String ilkUrunBasligi = ilkUrun.getText();
        System.out.println(ilkUrunBasligi);
        ilkUrun.click();

        // 6. Add to Cart butonuna basin
        driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-backpack']")).click();

       // 7. Alisveris sepetine tiklayin
        driver.findElement(By.xpath("(//a) [5]")).click();

       // 8. Sectiginiz urunun basarili olarak sepete eklendigini control edin
        String sepettekiUrun = driver.findElement(By.xpath("(//a) [6]")).getText();

        if (sepettekiUrun.equals(ilkUrunBasligi)){
            System.out.println("Doğru ürün sepete eklenmiştir");
        }else {
            System.out.println("Farklı bir ürün sepete eklenmiştir");
        }

       // 9. Sayfayi kapatin
        driver.close();
//




    }
}
