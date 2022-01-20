package day03_WebElementsLocators;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class C_SlackHomework
{
    public static void main(String[] args) throws InterruptedException {

        //  1-java class'imiza chromedriver.exe'yi tanitalim
        System.setProperty("webdriver.chrome.driver","src/driver/chromedriver");

        //  2-driver olusturalim
        WebDriver driver = new ChromeDriver();

        //  3-driver'in tum ekrani kaplamasini saglayalim
        driver.manage().window().maximize();

        //  4-https://github.com/ adresine gidelim
        driver.navigate().to("https://github.com/");
        Thread.sleep(1000);

        //  5-Ardindan https://www.hepsiburada.com/ adrsine gidelim
        driver.navigate().to("https://www.hepsiburada.com/");
        Thread.sleep(1000);

        //  6-Title ve url console da yazdirin ve yine title ve url in "burada" kelimesini icerip icermedigini kontrol edelim
        String currentTitle = driver.getTitle();
        String currentUrl = driver.getCurrentUrl();

        System.out.println("Title: " + currentTitle);
        System.out.println("URL: " + currentUrl);

        String word = "burada";

        System.out.println(currentTitle.contains(word) ? "Title Test Passed" : "Title Test Failed. Actual Title is: " + currentTitle);
        System.out.println(currentUrl.contains(word) ? "URL Test Passed" : "URL Test Failed. Actual URL is: " + currentUrl);

        //  7-Sonrasinda https://github.com/ adresine geri donelim ve  sayfayi yenileyelim
        driver.navigate().back();
        Thread.sleep(1000);
        driver.navigate().refresh();
        Thread.sleep(1000);

        //  8-Son adim olarak butun sayfalarimizi kapatmis olalim
        driver.quit();

    }
}
