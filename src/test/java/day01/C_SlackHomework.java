package day01;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C_SlackHomework
{
    public static void main(String[] args) {

        // 1. Bir class olusturun
        System.setProperty("webdriver.chrome.driver", "src/driver/chromedriver");
        WebDriver driver = new ChromeDriver();

        // 2. https://www.youtube.com sayfasina gidin
        driver.get("https://www.youtube.com ");

        // 3. Title'i console'a yazdirin
        System.out.println("Title is: " + driver.getTitle());

        // 4. Title "YouTube" a esitse "correct title" yazdirin, degilse "incorrect title" yazdirin
        String title = driver.getTitle();
        String word = "YouTube";
        System.out.println(title.equals(word) ? "correct title" : "incorrect title" );

        // 5. Sayfayi kapatin
        driver.close();

        // 6. Tum sayfalari kapatin
        driver.quit();

        // 7. Console'a "Test Completed" yazdirin
        System.out.println("Test Completed");
    }
}
