import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class day04_practice_1 {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("WebDriver.Chrome.Driver","src/resources/drivers/chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


        //Techproeducation sayfasına gidelim
        driver.get("https://techproeducation.com");

        //Çıkan reklamı locate edip kapatalım
        driver.findElement(By.xpath("//i[@class='eicon-close']")).click();


        //Arama bölümünde qa aratalım
        driver.findElement(By.xpath("//input[@id='elementor-search-form-9f26725']")).sendKeys("QA", Keys.ENTER);

        //Sayfa başlığının qa içerdiğini doğrulayalım
        String actualTitle = driver.getTitle();
        String expectedTitle = "QA";

        if (actualTitle.contains(expectedTitle)){
            System.out.println("Test PASSED");
        }else {
            System.out.println("Test FAILED");
        }

        //Carrer Opportunities In QA linkinin görünür ve erişilebilir olduğunu doğrulayalım
        WebElement CarrerOpportunitiesInQA = driver.findElement(By.xpath("(//h3[@class='elementor-post__title']) [1]"));
        System.out.println(CarrerOpportunitiesInQA.isEnabled());


        //Carrer Opportunities In QA linkine tıklayalım
        CarrerOpportunitiesInQA.click();
        Thread.sleep(1000);

        //Başlığın Opportunities içerdiğini test edelim
        String opportunitiesactualTitle = driver.getTitle();
        String opportunitiesexpectedTitle = "Opportunities";

        if (opportunitiesactualTitle.contains(opportunitiesexpectedTitle)){
            System.out.println("Test PASSED");
        }else {
            System.out.println("Test FAILED");
        }

        //Tekrar anasayfaya dönelim ve url'in https://techproeducation.com/ olduğunu doğrulayalım
        driver.navigate().back();
        driver.navigate().back();

        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "https://techproeducation.com/";

        if (actualUrl.equals(expectedUrl)){
            System.out.println("Test PASSED");
        }else {
            System.out.println("Test FAILDE");
        }

        driver.close();

    }
}
