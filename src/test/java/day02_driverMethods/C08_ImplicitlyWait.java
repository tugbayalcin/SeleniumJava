package day02_driverMethods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class C08_ImplicitlyWait
{
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver","src/driver/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize(); // bunu mutlaka her calismamizin en basina ekleyecegiz
        // cunku minimize'da goremedigimiz button'lar olabilir

        //driver.manage().timeouts().implicitlyWait(TimeUnit.SECONDS,5); // --> selenium4 ile gelen yenilik, ustu cizilmis
        // yapamadik, aslinda su an hala calisiyor ama kullanimini bulamadik, ustu cizili iken gecici bir sure daha kullanabilirsin demek
        // yakinda kaldiracagim demek
        // yakinda time unit tamamen kalkacak
        // yerine durationOf geldi

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        // sayfa acildi ve hemen kapandi, e o zaman bu code ne isse yaradi
        // verdigim sure boyunca verdigim url'yi bulmaya calisir
        // mesela olmayan sacma bir url yazalim
        driver.get("https://techproeducation.commm");
        // 15 saniye boyunca arayacak ve bulamayacagi icin 15 saniye sonunda hata verecek


        /*
        implicitly wait testimiz boyunca sayfa acilmasi ve element bulunmasi konusunda driver'in bekleyecegi max sureyi belirler
        bu sure icerisinde gorevini bitirir bitirmez, bir sonraki adima gecer
        bu sure icerisinde gorevini bitiremezse o zaman hata verir

        belirlenen max sure Thread.sleep'deki gibi mutlak bekleme suresi degildir
        isi bitince gider ama thread.sleep mutlaka ama mutlaka belirlenen sure kadar bekledikten sonra sonraki adima gecer
         */

    }
}
