package day02_driverMethods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * '@deprecated - bu tag bu classin artik yeni versiyonun ciktigini, bunu da eskidigini gosterir
 */
public class C01_Tekrar
{
    // normalde selenium'un kendi IDE'si de var fakat biz daha kullanisli oldugu icin intelliJ kullaniyoruz
    // intelliJ'de yeni bir proje actigimizda oncelikle selenium kutuphanelerini projeye eklememiz gerekir
    // biz en ilkel hali ile projemize kutuphaneleri jar dosyalari olarak yukledik
    // bu ekledigimiz dosyalarla artik driver'in ayarlarini yapabiliriz

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver","src/driver/chromedriver");
        // setProperty method'u 2 parametre ister
        // ilki kullanacagimiz browser'a air driver
        // ikinci parametre ise selenium sitesindenn indirip projemize ekledigimiz chromedriver'in path'i
        // windows kullanicilari sona .exe eklerken, apple kullanicilari .exe eklememeli

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.amazon.com");

        Thread.sleep(3000);
        // java'dan gelir, icine yazilan milisaniye kadar sonra kodlarin calismasini durdurur

        driver.close();

        // kapattiktan sonra bir tane daha driver olusturmak istiyorsak
        driver = new ChromeDriver(); // demeliyiz
        // ancak genellikle driver.close() kodunu class'in sonuna yazariz
    }
}
