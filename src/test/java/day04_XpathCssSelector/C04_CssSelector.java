package day04_XpathCssSelector;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C04_CssSelector

    // xpath'den farki: 1.tag name'den once // yok
    //                  2.attribute'den once @ isareti yok
{
    public static void main(String[] args) {

        //1 ) Bir class oluşturun : Locators_css
        //2 ) Main method oluşturun ve aşağıdaki görevi tamamlayın.
        System.setProperty("webdriver.chrome.driver","src/driver/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //    a. Verilen web sayfasına gidin. http://a.testaddressbook.com/sign_in
        driver.get("http://a.testaddressbook.com/sign_in");

        //    b. Locate email textbox
        WebElement emailTextBox = driver.findElement(By.cssSelector("input[id='session_email']")); // xpath -> //input[@id='session_email']
        // eger css selector kullanirken yalnizca id ile arayacaksam uzun uzun tag name yazmama gerek yok,
        // id tag name'i yerine  # koyabiliriz
        // --> "tagName#idValue"    veya "#idValue"
        //WebElement emailTextBox = driver.findElement(By.cssSelector("#session_email"));
        //WebElement emailTextBox = driver.findElement(By.cssSelector("input#session_email"));
        // class attribute'u kullaniyor ise de . koyariz

        //    c. Locate password textbox ve
        WebElement passwordTextBox = driver.findElement(By.cssSelector("input[id='session_password']")); // xpath -> //input[@id='session_password']

        //    d. Locate signin button
        WebElement signInButonu = driver.findElement(By.cssSelector("input[name='commit']")); // xpath -> //input[@name='commit']

        //    e. Asagidaki kullanıcı adını ve şifreyi girin ve sign in düğmesini tıklayın
        //        i. Username : testtechproed@gmail.com
        //        ii. Password : Test1234!
        //NOT: cssSelector kullanarak elementleri locate ediniz.

        emailTextBox.sendKeys("testtechproed@gmail.com");
        passwordTextBox.sendKeys("Test1234!");
        signInButonu.click();
    }
}
