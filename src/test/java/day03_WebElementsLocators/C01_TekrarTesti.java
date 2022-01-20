package day03_WebElementsLocators;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_TekrarTesti
{
    public static void main(String[] args) {

        // 1. Yeni bir class olusturun (TekrarTesti)
        System.setProperty("webdriver.chrome.driver", "src/driver/chromedriver"); // 1. adim
        WebDriver driver = new ChromeDriver(); // 2. adim
        driver.manage().window().maximize(); // 3. adim
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15)); // 4. adim
        // bu 4 adim farz


        //2. Youtube web sayfasına gidin ve sayfa başlığının “youtube” olup olmadığını doğrulayın (verify),
        //   eğer değilse doğru başlığı(Actual Title) konsolda yazdirin.
        driver.navigate().to("https://www.youtube.com/");
        // --> case'de ileri geri silemleri varsa baslangicta da gitmek icin navigate kullan
        String actualTitleYouTube = driver.getTitle();
        String expectedTitleYouTube = "youtube";
        if(actualTitleYouTube.equals(expectedTitleYouTube))
        {
            System.out.println("YouTube Title Testi Passed");
        }
        else
        {
            System.out.println("YouTube Title Testi Failed \nExpected Sayfa Basligi: " +expectedTitleYouTube +
                    "\nActual Sayfa Basligi: " + actualTitleYouTube);

        }

        //3. Sayfa URL'sinin “youtube” içerip içermediğini (contains) doğrulayın, içermiyorsa doğru URL'yi yazdırın.
        String actualYouTubeUrl = driver.getCurrentUrl();
        String arananKelimeYouTubeUrl = "youtube";
        if(actualYouTubeUrl.contains(arananKelimeYouTubeUrl))
        {
            System.out.println("YouTube URL Testi Passed.");
        }
        else
        {
            System.out.println("YouTube URL testi FAILED \nActual YouTube url : " + actualYouTubeUrl);
        }

        //4. Daha sonra Amazon sayfasina gidin https://www.amazon.com/
        driver.navigate().to("https://www.amazon.com/");

        //5. Youtube sayfasina geri donun
        driver.navigate().back();

        //6. Sayfayi yenileyin
        driver.navigate().refresh();

        //7. Amazon sayfasina donun
        driver.navigate().forward();

        //8. Sayfayi tamsayfa yapin
        driver.manage().window().fullscreen();

        //9. Ardından sayfa başlığının "Amazon" içerip içermediğini (contains) doğrulayın,
        //   Yoksa doğru başlığı(Actual Title) yazdırın.
        String actualAmazonTitle= driver.getTitle();
        String amazonTitleArananKelime="Amazon";

        if (actualAmazonTitle.contains(amazonTitleArananKelime)){
            System.out.println("Amazon Title testi PASS");
        }else {
            System.out.println("Amazon Title testi FAILED \nActual amazon Title : " + actualAmazonTitle);
        }

        //10.Sayfa URL'sinin https://www.amazon.com/ olup olmadığını doğrulayın, degilse doğru URL'yi yazdırın
        String expectedAmazonUrl="https://www.amazon.com/";
        String actualAmazonUrl= driver.getCurrentUrl();

        if (expectedAmazonUrl.equals(actualAmazonUrl)){
            System.out.println("Amazon URL testi PASS");
        } else {
            System.out.println("Amazon Url testi FAILED \nActual Amazon Url : " + actualAmazonUrl);
        }

        //11.Sayfayi kapatin
        driver.close();

    }
}
