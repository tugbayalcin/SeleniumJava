package day04_XpathCssSelector;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C_SlackHomework
{
    public static void main(String[] args) throws InterruptedException {

        //1. Bir class oluşturun: LocatorsIntro
        //2. Main method oluşturun ve aşağıdaki görevi tamamlayın.
        System.setProperty("webdriver.chrome.driver", "src/driver/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        // a. http://a.testaddressbook.com adresine gidiniz.
        driver.get("http://a.testaddressbook.com");

        // b. Sign in butonuna basin
        driver.findElement(By.id("sign-in")).click();

        // c. email textbox,password textbox, and signin button elementlerini locate ediniz..
        WebElement emailTextBox = driver.findElement(By.id("session_email"));
        WebElement passwordTextBox = driver.findElement(By.id("session_password"));
        WebElement signInButton = driver.findElement(By.xpath("//input[@name='commit']"));

        // d. Kullanıcı adını ve şifreyi aşağıya girin ve oturum aç (sign in)buttonunu tıklayın:
        // i. Username : testtechproed@gmail.com
        // ii.Password : Test1234!
        emailTextBox.sendKeys("testtechproed@gmail.com");
        passwordTextBox.sendKeys("Test1234!");
        signInButton.click();
        // e. Expected user id nin testtechproed@gmail.com oldugunu dogrulayin(verify).
        // expected bbu ise, giris yapacak demektir, giris yapip, sadece o ekrana ozgu bbir seyin gorunur olup olmadigina bakalim
        WebElement welcomeYazisiElementi = driver.findElement(By.xpath("//h1"));

        // f. “Addresses” ve “Sign Out” textlerinin görüntülendiğini( displayed) doğrulayin(verify).
        WebElement addressBox = driver.findElement(By.xpath("(//a[@class='nav-item nav-link'])[1]"));
        WebElement signOutBox = driver.findElement(By.xpath("(//a[@class='nav-item nav-link'])[2]"));

        //VERIFICATION -DOGRULAMA (Ilerde bunu JUnit-Assert ile yapicaz)
        System.out.println(addressBox.isDisplayed()?"Address Box Goruntuleme Testi Passed":"Address Box Goruntuleme Testi Failed");
        System.out.println(signOutBox.isDisplayed()?"Sign Out Box Goruntuleme Testi Passed":"Sign Out Box Goruntuleme Testi Failed");

        //3. Sayfada kac tane link oldugunu bulun.(asagidaki kod sayfadki tum linkleri alir)
        List<WebElement> linklerinListesi = driver.findElements(By.tagName("a"));

        System.out.println("Toplam Link Sayisi: " + linklerinListesi.size());

        //4.Linklerin yazisini nasil yazdirabiliriz
        // linklerinListesi.stream().map(t-> t.getText()).forEach(System.out::println);
        linklerinListesi.stream().map(t-> t.getAttribute("text")).forEach(System.out::println);
        linklerinListesi.stream().map(webElement -> webElement.getCssValue(""));


        //5. driver i kapatin
        //  driver.close();
    }
}
