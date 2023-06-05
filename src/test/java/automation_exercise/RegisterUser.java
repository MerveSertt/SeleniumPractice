package automation_exercise;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class RegisterUser {
    public static void main(String[] args) {
        System.setProperty("WebDriver.Chrome.Driver","src/resources/drivers/chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


       // 1. Launch browser
       // 2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");

       // 3. Verify that home page is visible successfully
        String actualTitle = driver.getTitle();
        System.out.println(actualTitle);
        if (actualTitle.equals("Automation Exercise")){
            System.out.println("Home page is visible successfully");
        }else {
            System.out.println("Home page is not visible");
        }

       // 4. Click on 'Signup / Login' button
        driver.findElement(By.xpath("//a[@href='/login']")).click();

       // 5. Verify 'New User Signup!' is visible
        //1.Way
        WebElement newUserr = driver.findElement(By.xpath("//h2[text()='New User Signup!']"));
        System.out.println("New User is visible?: " + newUserr.isDisplayed());

        //2.Way
        String newUser = driver.findElement(By.xpath("//h2[text()='New User Signup!']")).getText();
        if (newUser.equals("New User Signup!")){
            System.out.println("New User button is visible");
        }else {
            System.out.println("New User button is not visible");
        }

       // 6. Enter name and email address
        driver.findElement(By.xpath("//input[@data-qa='signup-name']")).sendKeys("beyza", Keys.ENTER);
        driver.findElement(By.xpath("//input[@data-qa='signup-email']")).sendKeys("beyzacolak888@gmail.com",Keys.ENTER);

       // 7. Click 'Signup' button
        driver.findElement(By.xpath("(//button[@class='btn btn-default']) [2]")).click();

       // 8. Verify that 'ENTER ACCOUNT INFORMATION' is visible
        WebElement enteraccountInformation = driver.findElement(By.xpath("(//h2[@class='title text-center']) [1]"));
        System.out.println("Is 'Enter Account Information visible': " + enteraccountInformation.isDisplayed());

       driver.close();








    }
}
