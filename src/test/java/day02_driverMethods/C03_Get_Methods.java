package day02_driverMethods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C03_Get_Methods
{
    //1. Yeni bir package olusturalim : day01
    //2. Yeni bir class olusturalim : C01_GetMethods


    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "src/driver/chromedriver");
        WebDriver driver = new ChromeDriver();

        //3. Amazon sayfasina gidelim. https://www.amazon.com/
        driver.get("https://www.amazon.com/");

        //4. Sayfa basligini(title) yazdirin
        System.out.println(driver.getTitle());

        //5. Sayfa basliginin “Amazon” icerdigini test edin
        String actualTitle = driver.getTitle(); // internetten getirilen her sey actual'dir
        String arananKelime = "Amazon";
        if(actualTitle.contains(arananKelime))
        {
            System.out.println("Title testi PASS");
        }
        else
        {
            System.out.println("Title testi FAILED");
            System.out.println("Sayfanin title'i " + actualTitle);
        }
        // bence burada ternary de kullanabilirdik, daha guzel olurdu

        //6. Sayfa adresini(url) yazdirin
        System.out.println(driver.getCurrentUrl());

        //7. Sayfa url’inin “amazon” icerdigini test edin.
        String actualURL = driver.getCurrentUrl(); // internetten getirilen her sey actual'dir
        String urlArananKelime = "amazon";
        if(actualURL.contains(urlArananKelime))
        {
            System.out.println("URL testi PASS");
        }
        else
        {
            System.out.println("URL testi FAILED");
            System.out.println("Sayfanin URL'i " + actualURL);
        }

        //8. Sayfa handle degerini yazdirin
        System.out.println(driver.getWindowHandle());

        //9. Sayfa HTML kodlarinda “alisveris” kelimesi gectigini test edin
        String actualPageSource = driver.getPageSource();
        String pageArananKelime = "alisveris";
        if(actualPageSource.contains(pageArananKelime))
        {
            System.out.println("Page Source testi PASS");
        }
        else
        {
            System.out.println("Page Source testi FAILED");
        }

        //10. Sayfayi kapatin.
        driver.close();


    }
}
