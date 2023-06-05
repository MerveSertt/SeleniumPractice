package ClassWork;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class HerokuTest {
    public static void main(String[] args) {
        System.setProperty("WebDriver.Chrome.Driver","src/resources/drivers/chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //https://id.heroku.com/login sayfasina gidin
        driver.get("https://id.heroku.com/login");

        //Bir mail adersi giriniz
        driver.findElement(By.xpath("//input[@autofocus='true']")).sendKeys("beyzacolak888@gmail.com");

        //Login butonuna tiklayini
        driver.findElement(By.xpath("//button[@class='btn btn-primary btn-lg btn-block']")).click();

        // "There was a problem with your login." texti gorunur ise
        //"kayit yapilamadi" yazdiriniz
        //eger yazi gorunur degilse "kayit yapildi" yazdiriniz
        String warning = driver.findElement(By.xpath("//div[@class='alert alert-danger']")).getText();
        if (warning.equals("There was a problem with your login.")){
            System.out.println("Kayıt yapılamadı");
        }else {
            System.out.println("Kayıt Yapıldı");
        }

        //sayfayı kapatiniz
        driver.close();




    }
}
