package ClassWork;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

public class RelativeLocators {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("WebDriver.Chrome.Driver","src/resources/drivers/chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        /*
        1.) https://www.diemol.com/selenium-4-demo/relative-locators-demo.html adresine
        gidin
        2.) Berlin’i 3 farkli relative locator ile locate
        edin 3 ) Relative locator’larin dogru calistigini
        test edin
         */

        driver.get("https://www.diemol.com/selenium-4-demo/relative-locators-demo.html");
        WebElement bayArea = driver.findElement(By.xpath("(//a) [8]"));

        WebElement nyc = driver.findElement(By.xpath("(//a) [3]"));

        WebElement sailor = driver.findElement(By.xpath("(//a) [11]"));

        WebElement berlin1 = driver.findElement(with(By.tagName("a")).below(nyc));
        berlin1.click();

        sailor.click();
        Thread.sleep(2000);

        WebElement berlin2 = driver.findElement(with(By.tagName("a")).above(sailor));
        berlin2.click();

        bayArea.click();
        Thread.sleep(3000);

        WebElement berlin3 = driver.findElement(with(By.tagName("a")).toLeftOf(bayArea));
        berlin3.click();











    }
}
