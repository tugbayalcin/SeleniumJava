package day04_XpathCssSelector;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C01_TekrarTesti
{
    public static void main(String[] args) {

        // 1. Bir class oluşturun : AmazonSearchTest
        // 2. Main method oluşturun ve aşağıdaki görevi tamamlayın.
        System.setProperty("webdriver.chrome.driver","src/driver/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //    a.amazon web sayfasına gidin. https://www.amazon.com/
        driver.get("https://www.amazon.com/");

        //    b. Search(ara) kutusuna “city bike” yazip aratin
        WebElement searchTextBox = driver.findElement(By.id("twotabsearchtextbox"));
        searchTextBox.sendKeys("city bike" + Keys.ENTER); // + yerine , koyarsak da calisir
        //searchTextBox.submit(); // enter'a basma isini yapar, istersek Keys.ENTER yerine bu satiri kullanabiliriz
        // enter'a basmanin iki yolu vardir, ikisinin de ornegi bu

        //    c. Amazon'da görüntülenen ilgili sonuçların sayısını yazdırın
        /*   bazen web developer elementi parcali sekilde kodlar,
             bu ornegimizde 1-16 of 120 results for "city bike"
             cumlesinin bulundugu element de parcali tanimlanmis
             for'a kadar olan kisim bir parca, bosluk bir parca ve city bike kismi bir parca
             ben bu grubun (her bir parcanin gosterildigi kod grubunun) ustune cikarsam
             bunlari kapsayan div'e gelirsem tum satiri almis olurum
             (bir tag'in basinda ok varsa burasi bir sonraki ok'a kadar tek bir web elementtir)
             normalde web elementler tag ile baslayip tag ile biter ama ic ice taglar ve elementler oldugu icin ok yardimiyla ayirt edebiliriz
             bu durumun hem faydasi hem zarari vardir, cok dikkatli olmali ve yanlis yeri locate etmemerliyiz
             simdi en genel, en kapsayici durum olan div'i secerek locate etmeye calisalim
             bu div'de 1 tane attribute var o da class attribute'u
             value'sunu ctrl f ile arattigimda 24 tane daha yanisindan oldugunu goruyorum
             bu zaten bekledigimiz bir durumdu cunku class attribute'u benzer ozellikteki elementleri bir arada tutmaya yarayan bir yapiydi
             boyle durumlarda findElement kullanirsak 1'den fazla sonuc bulunmasi durumunda bize yalnizca ilkini getirir
       */
        //--------------------------------
        // WebElement sonucYazisiElementi = driver.findElement(By.className("a-section a-spacing-small a-spacing-top-small"));
        // class attribute'un value'sunde bosluk var ama simdiki bilgilerimizle tek attribute olan class'i kullanmak zorundayiz
        //System.out.println(sonucYazisiElementi.getText());
        // hata verdi, className ile arama satiri hata olusturdu --> invalid_selector_exception
        //--------------------------------
        // plan B
        // o zaman biz tum bu 24 tane web elementi alip diziye koymayi deneyelim
        List<WebElement> sonucListesi = driver.findElements(By.className("a-section a-spacing-small a-spacing-top-small"));
        System.out.println(sonucListesi.size());
        // yine hata verdi, locator hatasi aldik, bu durumda artik className kullanamayiz
        //--------------------------------
        // plan c
        // baska nereden yapabiliriz diye bakarken city bike parcasinin class attribute'unun value'sunun tek oldugunu farkettik
        // haydi deneyelim
        // WebElement sonucYazisiElementi = driver.findElement(By.className("a-color-state a-text-bold"));
        //System.out.println(sonucYazisiElementi.getText());
        // hata verdi
        //--------------------------------
        // plan d
        // baska nereden yapabiliriz diye bakarken istedigimiz satirin daha genel div tag'inin
        // class attribute'unun value'sunun tek oldugunu farkettik
        // haydi deneyelim
        WebElement sonucYazisiElementi = driver.findElement(By.className("sg-col-inner"));
        System.out.println(sonucYazisiElementi.getText());
        //WebElement sonucYazisiElementi = driver.findElement(By.xpath("//div[@class='sg-col-14-of-20 sg-col s-breadcrumb sg-col-10-of-16 sg-col-6-of-12']"));
        // className ile daha once bu elementi locate edemedigimiz halde xPath ile class attribute'u kullanarak locate edebildik
        // bu da bir digeri -- direk aradigimiz elementin hemen ustundeki div
        //WebElement sonucYazisiElementi = driver.findElement(By.xpath("(//div[@class='a-section a-spacing-small a-spacing-top-small'])[1]"));
        // x path ile 23 tane cikti, xpath'i paranteze alip yanina [] icerisinde kacincisini istedigimizi yazarsak gelir

        //  e. Sonra karsiniza cikan ilk sonucun resmine tiklayin
        WebElement ilkUrunResmi = driver.findElement(By.className("s-image"));
        ilkUrunResmi.click();

        // sadece click yapmak gibi basit bir islemde kullanacagimiz web elementler icin variable oljusturmadan,
        // direk locate edip istedigimiz islemi yapabiliriz, asagidaki gibi
        // --> driver.findElement(By.className("s-image")).click();


    }
}
