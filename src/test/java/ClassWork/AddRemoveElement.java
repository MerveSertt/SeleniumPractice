package ClassWork;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class AddRemoveElement {
    public static void main(String[] args) {
        System.setProperty("WebDriver.Chrome.Driver","src/resources/drivers/chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        /*
        Asagidaki testi text’leri kullanarak locate edin
        1. https://the-internet.herokuapp.com/add_remove_elements/ adresine
        gidin
        2. Add Element butonuna basin
        3. Delete butonu’nun gorunur oldugunu test edin
        4. Delete tusuna basin
        5. “Add/Remove Elements” yazisinin gorunur oldugunu test edin
         */

        driver.get("https://the-internet.herokuapp.com/add_remove_elements/");

        WebElement addButton = driver.findElement(By.xpath("//button[@onclick='addElement()']"));
        addButton.click();

        WebElement deleteButton = driver.findElement(By.xpath("//button[@onclick='deleteElement()']"));
        System.out.println(deleteButton.isDisplayed());
        deleteButton.click();
        WebElement addRemove = driver.findElement(By.xpath("//h3"));
        System.out.println(addRemove.isDisplayed());

        driver.close();


    }
}
