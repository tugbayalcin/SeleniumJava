package day03_WebElementsLocators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

/**
 * This class Login Scenario. By Selenium 4.0
 * @author tugbayalcin
 * @since 1.0
 * @see day01.C01_IlkClass
 */

public class C02_LoginTest
{
    /**
     * Main method is the Runner Method. All codes written will be compiled.
     * @param args Main method String[] args parametresi alir
     * @throws InterruptedException - aciklama yapinca warning gider
     * @version 1.0 - First Selenium Project of TugbaYalcin
     */
    public static void main(String[] args) throws InterruptedException {

        // 1. Bir class oluşturun: LoginTest
        // 2. Main method oluşturun ve aşağıdaki görevi tamamlayın.
        System.setProperty("webdriver.chrome.driver", "src/driver/chromedriver"); // Adim 1
        WebDriver driver = new ChromeDriver(); // Adim 2
        driver.manage().window().maximize(); // Adim 3
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));  // Adim 4

        //    a. http://a.testaddressbook.com adresine gidiniz.
        driver.get("http://a.testaddressbook.com");

        //    b. Sign in butonuna basin
        WebElement signInLinki = driver.findElement(By.id("sign-in")); // sadece locate edip bir variable'a assign ettik
        signInLinki.click();

        //    c. email textbox,password textbox, and signin button elementlerini locate ediniz..
        WebElement emailTextBox = driver.findElement(By.id("session_email"));
        WebElement passwordTextBox = driver.findElement(By.id("session_password"));
        WebElement signInButton = driver.findElement(By.name("commit"));

        //    d. Kullanıcı adını ve şifreyi aşağıya girin ve oturum aç (sign in)buttonunu tıklayın:
        //        i. Username : testtechproed@gmail.com
        //        ii. Password : Test1234!
        emailTextBox.sendKeys("testtechproed@gmail.com");
        passwordTextBox.sendKeys("Test1234!");

        Thread.sleep(3000);
        signInButton.click();

        //    e. Expected user id nin testtechproed@gmail.com oldugunu dogrulayin(verify).
        //       yani giris yapildigini test et demek istiyor
        WebElement girisYazisiElementi = driver.findElement(By.tagName("h1"));
        System.out.println(girisYazisiElementi.getText()); // internetteki, webElementinin tuttugu yaziyi yazdirdik
        // ancak bu bir web elemanttir, locate ile gelen (donen) sey bir web elementtir, uzerinde yazi olsa bile bir web elementtir
        String actualGirisYazisi = girisYazisiElementi.getText(); // burasi artik o web elementin uzerinde bulunan string yazidir
        String expectedGirisYazisi = "Welcome to Address Book";
        if (actualGirisYazisi.equals(expectedGirisYazisi))
        {
            System.out.println("Sayafa Giris Testi Passed");
        }
        else
        {
            System.out.println("Sayfaya Giris Testi Failed");
        }

        //    f. “Addresses” ve “Sign Out” textlerinin görüntülendiğini( displayed) doğrulayin(verify).
        WebElement addressWebElementi = driver.findElement(By.linkText("Addresses"));
        WebElement signOutElementi = driver.findElement(By.linkText("Sign out"));

        if(addressWebElementi.isDisplayed())    // display: gorunuyor mu demektir, boolean deger dondurur
        {
            System.out.println("Address Elementi Goruntuleme Testi Passed");
        }
        else
        {
            System.out.println("Address Elementi Goruntuleme Testi Failed");
        }

        if(signOutElementi.isDisplayed())
        {
            System.out.println("Sign Out Elementi Goruntuleme Testi Passed");
        }
        else
        {
            System.out.println("Sign Out Elementi Goruntuleme Testi Failed");
        }

        // 3. Sayfada kac tane link oldugunu bulun.
        List<WebElement> linklerListesi = driver.findElements(By.tagName("a"));
        System.out.println("Sayfada " + linklerListesi.size() + " adet link bulunmaktadir.");

        driver.close();
    }
}
