package day02_driverMethods;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C07_ManageWindowSet
{
    public static void main(String[] args) throws InterruptedException {

        //1. Yeni bir Class olusturalim.C07_ManageWindowSet
        System.setProperty("webdriver.chrome.driver","src/driver/chromedriver");
        WebDriver driver = new ChromeDriver();

        //2. Amazon soyfasina gidelim. https://www.amazon.com/
        driver.navigate().to("https://www.amazon.com/");

        //3. Sayfanin konumunu ve boyutlarini yazdirin
        System.out.println("Position: " + driver.manage().window().getPosition());
        System.out.println("Size: " + driver.manage().window().getSize());

        //4. Sayfanin konumunu ve boyutunu istediginiz sekilde ayarlayin
        driver.manage().window().setPosition(new Point(0,0));
        driver.manage().window().setSize(new Dimension(300,500));

        //5. Sayfanin sizin istediginiz konum ve boyuta geldigini test edin
        int actualXPosition = driver.manage().window().getPosition().getX();
        System.out.println(actualXPosition);
        int actualYPosition = driver.manage().window().getPosition().getY();
        System.out.println(actualYPosition);
        int actualWidth = driver.manage().window().getSize().getWidth();
        System.out.println(actualWidth);
        int actualHeight = driver.manage().window().getSize().getHeight();
        System.out.println(actualHeight);

        Thread.sleep(3000);

        if(actualXPosition==0 && actualYPosition==0 && actualWidth==300 && actualHeight==500)
        {
            System.out.println("Olceklendirme Testi PASSED");
        }
        else
        {
            System.out.println("Olceklendirme Testi FAILED");
        }

        //8. Sayfayi kapatin
        driver.close();
    }
}
