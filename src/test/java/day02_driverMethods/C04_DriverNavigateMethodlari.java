package day02_driverMethods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C04_DriverNavigateMethodlari
{
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.webdriver","src/driver/chromedriver");
        WebDriver driver = new ChromeDriver();

        driver.navigate().to("https://www.amazon.com");
        // driver.get ile ayni islemi yapar ama daha hizlidir

        driver.navigate().to("https://www.techproeducation.com");
        // yeni driver olusturulmus olsa idi yeni sayfada acardi ancak ayni driver ile gittigimiz icin ayni
        // pencere uzerinde yeni adrese gidilecek

        driver.navigate().back(); // bir onceki bulundugu yere (geldigi yere) doner. Geri tusu gibi
        driver.navigate().forward(); // ileri gider
        driver.navigate().refresh(); // yenile tusu

    }
}
