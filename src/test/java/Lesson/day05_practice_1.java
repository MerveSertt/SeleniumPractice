package Lesson;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class day05_practice_1 {
      /*
                ODEV

            // http://the-internet.herokuapp.com/add_remove_elements/ adresine gidiniz
            // Add Element butonuna 100 defa basınız
            // 100 defa basıldığını test ediniz
            // 90 defa delete butonuna basınız
            // 90 defa basıldığını doğrulayınız
            // Sayfayı kapatınız
         */
      public static void main(String[] args) {

          System.setProperty("WebDriver.Chrome.Driver","src/resources/drivers/chromedriver.exe");

          WebDriver driver = new ChromeDriver();

          driver.manage().window().maximize();
          driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

          // http://the-internet.herokuapp.com/add_remove_elements/ adresine gidiniz
          driver.get("http://the-internet.herokuapp.com/add_remove_elements/");

          // Add Element butonuna 100 defa basınız
          WebElement addButton = driver.findElement(By.xpath("//button[@onclick='addElement()']"));

          int counter = 0;

          for (int i = 0; i < 100; i++) {
              addButton.click();
              counter++;
          }

          // 100 defa basıldığını test ediniz
          if (counter==100){
              System.out.println("Add Button Test Passed");
          }else {
              System.out.println("Add Button Test Failed");
          }


          // 90 defa delete butonuna basınız
          List<WebElement> deleteButton = driver.findElements(By.xpath("//button[@class='added-manually']"));

            int counterDelete = 0;
          for (int i = 0; i < 90; i++) {
              deleteButton.get(i).click();
              counterDelete++;
          }
          // 90 defa basıldığını doğrulayınız
          if (counterDelete==90){
              System.out.println("Delete Button Test Passed");
          }else {
              System.out.println("Delete Button Test Failed");
          }

          // Sayfayı kapatınız
          driver.close();










      }
}
