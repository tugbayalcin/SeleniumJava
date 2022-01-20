package day02_driverMethods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C_TekrarTesti
{
    public static void main(String[] args) throws InterruptedException {

        // 1. Yeni bir class olusturun(Tekrar Testi)
        System.setProperty("webdriver.chrome.driver","src/driver/chromedriver");
        WebDriver driver = new ChromeDriver();

        // 2. Youtube web sayfasina gidin ve sayfa basliginin "youtube" olup olmadigini dogrulayin.
        //    (verify), eger degilse dogru basligi (Actual Title) konsolda yazdirin
        driver.get("https://www.youtube.com");
        Thread.sleep(3000);
        String actualTitle = driver.getTitle();
        String espectedTitle = "youtube";
        System.out.println(
                 (actualTitle.equals(espectedTitle))
                ? "Title Testi Passed. Title is verified."
                : "Title Testi Failed. Actual title is: " + driver.getTitle());

        // 3. Sayfa URL'inin "youtube" icerip icermedigini (contains) dogrulayin, icermiyorsa dogru URL'i yazdirin
        String actualUrl = driver.getCurrentUrl();
        String kelime = "youtube";
        System.out.println((actualUrl.contains(kelime))
                ? "URL Testi Passed. URL is contains that word."
                : "URL Testi Failed. Actual URL is: " + driver.getCurrentUrl());

        // 4. Daha sonra Amazon sayfasina gidin https://www.amazon.com/
        driver.navigate().to("https://www.amazon.com/");
        Thread.sleep(3000);

        // 5. Youtube sayfasina geri donun
        driver.navigate().back();
        Thread.sleep(3000);

        // 6. Sayfayi yenileyin.
        driver.navigate().refresh();
        Thread.sleep(1000);

        // 7. Amazon sayfasina donun.
        driver.navigate().forward();
        Thread.sleep(3000);

        // 8. Sayfayi tam ekran yapin
        driver.manage().window().fullscreen();
        Thread.sleep(3000);

        // 9. Ardindan sayfa basliginin "Amazon" icerip icermedigini (contains) dogrulayin,
        //    Yoksa dogru basligi (Actual Title) yazdirin
        String currentActualTitle = driver.getTitle();
        String kelime1 = "Amazon";
        System.out.println((currentActualTitle.contains(kelime1))
                ? "Title Testi Passed. Title is contains that word."
                : "Title Testi Failed. Actual Title is: " + driver.getTitle());


        // 10. Sayfa URL'inin https://www.amazon.com/ olup olmadigini dogrulayin, degilse dogru URL'i yazdirin
        String currentActualUrl = driver.getCurrentUrl();
        String kelime2 = "https://www.amazon.com/";
        System.out.println((currentActualUrl.equals(kelime2))
                ? "URL Testi Passed. URL is contains that word."
                : "URL Testi Failed. Actual URL is: " + driver.getCurrentUrl());

        // 11. Sayfayi kapatin
        driver.close();
    }
}
