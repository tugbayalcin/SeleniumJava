package day01;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C01_IlkClass
{
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver","src/driver/chromedriver");
        WebDriver driver = new ChromeDriver();
        // biz bir driver objesi olusturdugumuzda bos bir chrome browser acilir (adres kismi bos olur)

        driver.get("https://www.amazon.com");
        // driver.get() methodu driver'a, gidecegi web adresini girmemizi saglar

        Thread.sleep(3000); // bekletme komutu, milisaniye cinsinden girilir
        // acip 3 sn bekleyip kapatacak
        // exception firlatman gerekiyor

        driver.close(); // driver'i kapatir


    }
}

