package day03_WebElementsLocators;

import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C_Homework
{
    public static void main(String[] args) throws InterruptedException {

        // 1. Bir class olusturun (AmazonSearch Test)
        // 2. Main method olusturun ve asagidaki gorevi tamamlayin
        System.setProperty("webdriver.chrome.driver", "src/driver/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //  a. amazon web sayfasina gidin. https://www.amazon.com/
        driver.get("https://www.amazon.com/");
        Thread.sleep(1000);

        //    b. Search(ara) kutusuna “city bike” yazip aratin
        WebElement searchTextBox = driver.findElement(By.id("twotabsearchtextbox"));
        searchTextBox.sendKeys("city bike" + Keys.ENTER);

        //  c. Amazonda goruntulenen ilgili sonuclarin sayisini yazdirin
        WebElement ilgiliSonucSayisi = driver.findElement(By.tagName("span")); //  burasini yapamadim

        //  e. Sonra karsiniza cikan ilk sonucun resmine tiklayin

    }
}
