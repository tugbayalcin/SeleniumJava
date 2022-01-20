package day02_driverMethods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C05_NavigationMethods
{
    public static void main(String[] args) {

        //1. Yeni bir Class olusturalim.C02_NavigationMethods
        System.setProperty("webdriver.chrome.driver","src/driver/chromedriver");
        WebDriver driver = new ChromeDriver();

        //2. Youtube ana sayfasina gidelim . https://www.youtube.com/
        driver.get("https://www.youtube.com/");

        //3. Amazon soyfasina gidelim. https://www.amazon.com/
        driver.get("https://www.amazon.com/");

        //4. Tekrar YouTube’sayfasina donelim
        driver.navigate().back();

        //5. Yeniden Amazon sayfasina gidelim
        driver.navigate().forward();

        //6. Sayfayi Refresh(yenile) yapalim
        driver.navigate().refresh();

        //7. Sayfayi tam ekran yapalim

        //8. Sayfayi kapatalim / Tum sayfalari kapatalim
        driver.close(); // sadece driver'in son bulundugu sayfayi kapatir
        driver.quit(); // quit; varsa acik olan tum sayfalari kapatir
    }
}
