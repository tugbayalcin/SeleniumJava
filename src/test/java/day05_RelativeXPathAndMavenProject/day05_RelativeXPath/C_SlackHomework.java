package day05_RelativeXPathAndMavenProject.day05_RelativeXPath;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C_SlackHomework {
    public static void main(String[] args)
    {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //   https://www.amazon.com/ adresine gidin.
        driver.get("https://www.amazon.com/");

        //   Test 1
        //1. Arama kutusunun yanindaki kategori menusundeki kategori sayisinin 45 oldugunu test edin
        List<WebElement> kategoriListesi = driver.findElements(By.xpath("//option"));

        System.out.println((kategoriListesi.size()==45)
                ? "Kategori Sayisi Testi Passed"
                : "Kategori Sayisi Testi Failed. Actual Kategori Sayisi: " + kategoriListesi.size());

        //   Test 2
        //1. Kategori menusunden Books secenegini secin
        WebElement kategoriMenusundekiBooksElementi = driver.findElement(By.xpath("//option[@value='search-alias=stripbooks-intl-ship']"));
        kategoriMenusundekiBooksElementi.click(); // semekten kasit click yapmak sanirim

        //2. Arama kutusuna Java yazin ve aratin
        WebElement searchTextBoxElementi = driver.findElement(By.id("twotabsearchtextbox"));
        searchTextBoxElementi.sendKeys("Java" + Keys.ENTER);

        //3. Bulunan sonuc sayisini yazdirin
        WebElement sonucSayisiElementi = driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        String sonucSayisiCumlesiString = sonucSayisiElementi.getText();
        String[] sonucSayisiKelimeleriDizisi = sonucSayisiCumlesiString.split(" ");
        String sonucSayisiString = sonucSayisiKelimeleriDizisi[3];

        sonucSayisiString = sonucSayisiString.replace(",","");
        int sonucSayisiInteger = Integer.valueOf(sonucSayisiString);

        Boolean buyukMu=false;
        for (String each : sonucSayisiKelimeleriDizisi)
        {
            if(each.equals("over"))
            {
                buyukMu = true;
            }

        }
        if(buyukMu)
        {
            System.out.print (sonucSayisiKelimeleriDizisi[2] + " ");
            System.out.println(sonucSayisiInteger);
        }
        else
        {
            System.out.println(sonucSayisiInteger);
        }

        //4. Sonucun Java kelimesini icerdigini test edin
        System.out.println(sonucSayisiCumlesiString.contains("Java")
                ? "Sonuc Java Iceriyor Testi Passed."
                : "Sonuc Java Iceriyor Testi Failed. Actual Sonuc Cumlesi: " + sonucSayisiCumlesiString);


        //5. Pencereyi kapatin
        driver.close();

    }
}
