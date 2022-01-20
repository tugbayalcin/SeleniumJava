package day02_driverMethods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C06_ManageWindow
{
    public static void main(String[] args) throws InterruptedException {
        //1. Yeni bir Class olusturalim.C06_ManageWindow
        System.setProperty("webdriver.chrome.driver","src/driver/chromedriver");
        WebDriver driver = new ChromeDriver();

        //2. Amazon soyfasina gidelim. https://www.amazon.com/
        driver.navigate().to("https://www.amazon.com/");

        //3. Sayfanin konumunu ve boyutlarini yazdirin
        System.out.println("Position: " + driver.manage().window().getPosition());
        System.out.println("Size: " + driver.manage().window().getSize());

        //4. Sayfayi simge durumuna getirin
        driver.manage().window().minimize();

        //5. simge durumunda 3 saniye bekleyip sayfayi maximize yapin
        Thread.sleep(3000);
        driver.manage().window().maximize();

        //6. Sayfanin konumunu ve boyutlarini maximize durumunda yazdirin
        System.out.println("Maximize Position: " + driver.manage().window().getPosition());
        System.out.println("Maximize Size: " + driver.manage().window().getSize());

        //7. Sayfayi fullscreen yapin
        driver.manage().window().fullscreen();

        //8. Sayfanin konumunu ve boyutlarini fullscreen durumunda yazdirin
        System.out.println("FullScreen Position: " + driver.manage().window().getPosition());
        System.out.println("FullScreen Size: " + driver.manage().window().getSize());
        Thread.sleep(3000);

        //9. Sayfayi kapatin
        driver.close();
    }
}
