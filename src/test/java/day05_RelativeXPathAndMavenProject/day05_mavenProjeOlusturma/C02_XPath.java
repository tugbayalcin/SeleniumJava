package day05_RelativeXPathAndMavenProject.day05_mavenProjeOlusturma;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_XPath
{
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //1. http://zero.webappsecurity.com sayfasina gidin
        driver.get("http://zero.webappsecurity.com");

        //2. Signin buttonuna tiklayin
        driver.findElement(By.xpath("//button[@id='signin_button']")).click();

        //3. Login alanine  “username” yazdirin
        WebElement loginBox = driver.findElement(By.xpath("//input[@id='user_login']"));
        loginBox.sendKeys("username");

        //4. Password alanine “password” yazdirin
        WebElement passwordBox = driver.findElement(By.xpath("//input[@id='user_password']"));
        passwordBox.sendKeys("password");

        //5. Sign in buttonuna tiklayin
        driver.findElement(By.xpath("//input[@type='submit']")).click();

        //--- guvenlik sayfasini gecmek icin bazi click'ler yapalim
        driver.findElement(By.xpath("//button[@id='details-button']")).click();
        driver.findElement(By.xpath("//a[@id='proceed-link']")).click();

        //6. Pay Bills sayfasina gidin
        WebElement payBillsElementi = driver.findElement(By.linkText("Pay Bills"));
        payBillsElementi.click();

        //7. amount kismina yatirmak istediginiz herhangi bir miktari yazin
        WebElement amountTextBoxElementi = driver.findElement(By.xpath("//input[@id='sp_amount']"));
        amountTextBoxElementi.sendKeys("3000");

        //8. tarih kismina “2020-09-10” yazdirin
        WebElement dateTextBoxElementi = driver.findElement(By.xpath("//input[@id='sp_date']"));
        dateTextBoxElementi.sendKeys("2020-09-10");

        //9. Pay buttonuna tiklayin
        WebElement payButtonElementi = driver.findElement(By.xpath("//input[@id='pay_saved_payees']"));
        payButtonElementi.click();

        //10. “The payment was successfully submitted.” mesajinin ciktigini control edin
        WebElement successfulElementi = driver.findElement(By.xpath("//span[@title='$ 3000 payed to payee sprint']"));
        System.out.println(successfulElementi.isDisplayed() ? "Odeme Basarili Testi Passed " : "Odeme Basarili Testi Failed ");


        driver.close();
    }
}
