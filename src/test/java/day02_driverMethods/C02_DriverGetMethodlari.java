package day02_driverMethods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C02_DriverGetMethodlari
{
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver","src/driver/chromedriver");
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.amazon.com");

        System.out.println(driver.getTitle());
        // sayfanin title kismi, html'de de oyleydi, sekme olan yerde yazan aciklamadir

        System.out.println(driver.getCurrentUrl());
        // sayfanin adresini getirir/dondurur

        System.out.println(driver.getWindowHandle());
        // CDwindow-11F13A62F553D6DAE09FD502D1793D71 acilan her pencereye ozel bu kod olusturulur, her pencereye baska olusturulur

        System.out.println(driver.getPageSource());
        // sayfa kaynagini goruntuler


    }
}
