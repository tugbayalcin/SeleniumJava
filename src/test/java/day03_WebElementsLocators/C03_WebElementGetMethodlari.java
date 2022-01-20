package day03_WebElementsLocators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_WebElementGetMethodlari
{
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "src/driver/chromedriver"); // Adim 1
        WebDriver driver = new ChromeDriver(); // Adim 2
        driver.manage().window().maximize(); // Adim 3
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));  // Adim 4

        //    a. http://a.testaddressbook.com adresine gidiniz.
        driver.get("http://a.testaddressbook.com");

        // signIn linkini locate edelim
        WebElement signInLinki = driver.findElement(By.id("sign-in"));

        // ---------------------------------------------------webEleemnt objesi. dedigimizde cikan methodlara bakalim
        // .get ile baslayanlar
        System.out.println("Size: " + signInLinki.getSize());
        System.out.println("AriaRole: " + signInLinki.getAriaRole()); // testerlar kullanmaz, banane ki ben designer degilim, isimiz olmaz
        System.out.println("Accessible Name: " + signInLinki.getAccessibleName());
        System.out.println("id Attribute Value: " + signInLinki.getAttribute("id"));
        System.out.println("Location: " + signInLinki.getLocation());
        System.out.println("Genislik: " + signInLinki.getRect().width);
        System.out.println("Color: " + signInLinki.getCssValue("color"));

        driver.close();
    }
}
