package day04_XpathCssSelector;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C_SlackHomework
{
    public static void main(String[] args)
    {
        System.setProperty("webdriver.chrome.driver", "src/driver/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //1.  https://id.heroku.com/login sayfasina gidin
        driver.get("https://id.heroku.com/login");

        //2.  Bir mail adersi giriniz
        WebElement mailTextBox = driver.findElement(By.xpath("//input[@id='email']"));
        mailTextBox.sendKeys("esttechproed@gmail.com");

        //3.  Bir password giriniz
        WebElement passwordTextBox = driver.findElement(By.xpath("//input[@id='password']"));
        passwordTextBox.sendKeys("Test1234!");

        //4.  Login butonuna tiklayiniz
        WebElement loginButton = driver.findElement(By.xpath("//button[@name='commit']"));
        loginButton.click();

        //5.  "There was a problem with your login." texti gorunur ise
        WebElement logginMessage = driver.findElement(By.xpath("//div[@class='alert alert-danger']"));

        if(logginMessage.isDisplayed())
        {
            System.out.println("kayit yapilamadi");
        }
        else
        {
            System.out.println("kayit yapildi");
        }

        //6.  "kayit yapilamadi" yazdiriniz
        //8.  eger yazi gorunur degilse "kayit yapildi" yazdiriniz
        //9.  Tum sayfalari kapatiniz
        driver.quit();

    }
}
