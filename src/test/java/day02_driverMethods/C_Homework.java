package day02_driverMethods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C_Homework
{
    public static void main(String[] args) throws InterruptedException {

        // 1. Yeni bir class olusturalim (Homework)
        System.setProperty("webdriver.chrome.driver", "src/driver/chromedriver");
        WebDriver driver = new ChromeDriver();

        // 2. ChromeDriver kullanarak, facebook sayfasina gidin ve sayfa basliginin (title) "facebook" oldugunu dogrulayin (verify)
        //    degilse dogru basligi yazdirin
        driver.get("https://www.facebook.com/");
        Thread.sleep(3000);
        String actualTitle = driver.getTitle();
        String expectedTitel = "facebook";
        System.out.println(actualTitle.equals(expectedTitel)
                ? "Title Test Passed. Title is Verified"
                : "Title Test Failed. Actual Title is: " + actualTitle);

        // 3. Sayfa URL'inin "facebook" kelimesi icerdigini dogrulayin, icermiyorsa actual URL'i yazdirin
        String actualUrl = driver.getCurrentUrl();
        String kelime = "facebook";
        System.out.println(actualUrl.contains(kelime)
                ? "URL Test Passed. URL is contains that word"
                : "URL Test Failed. Actual URL is: " + actualUrl );

        // 4. https://www.walmart.com/ sayfasina gidin
        driver.navigate().to("https://www.walmart.com/ ");
        Thread.sleep(3000);

        // 5. Sayfa basliginin "Walmart.com" icerdigini dogrulayin
        String currentActualTitle = driver.getTitle();
        String word = "Walmart.com";
        System.out.println(currentActualTitle.contains(word)
                ? "Title Test Passed. Title is contains that word"
                : "Title Test Failed. Actual Title is: " + currentActualTitle);

        // 6. Tekrar "facebook" sayfasina donun
        driver.navigate().back();
        Thread.sleep(3000);

        // 7. Sayfayi yenileyin
        driver.navigate().refresh();
        Thread.sleep(1000);

        // 8. Sayfayi tam sayfa (maximize) yapin
        driver.manage().window().maximize();
        Thread.sleep(1000);

        // 9. Browser'i kapatin
        driver.quit();
    }
}
