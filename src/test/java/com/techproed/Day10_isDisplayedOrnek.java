package com.techproed;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Day10_isDisplayedOrnek {

    static WebDriver driver;// instance variable

    //ORNEK
    /*
titleTest => Sayfa başlığının "Best" içerdiğini(contains) doğrulayın
logoTest => BestBuy logosunun görüntülenip görüntülenmediğini doğrulayın
mexicoLinkTest => Linkin görüntülenip görüntülenmediğini doğrulayın
 */

    @BeforeClass
    public static void setUp() {
        // driver i kullanilabilir hale getirelim.
        WebDriverManager.chromedriver().setup();

    }

    @Before
    public void testtenOnce() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://bestbuy.com");

    }

    @After
    public void testtenSonra() {
        driver.quit();
    }

    @Test
    public void titleTest() {
        String sayfaBasligi = driver.getTitle();
        boolean iceriyorMu = sayfaBasligi.contains("Best");
        Assert.assertTrue(iceriyorMu);
    }

    @Test
    public void logoTest() {
        WebElement logo = driver.findElement(By.className("logo"));
                       //   xpath ile bulma  ("//img[@class='logo']")
        boolean logoGorunuyorMu = logo.isDisplayed();
        Assert.assertTrue(logoGorunuyorMu);

    }

    @Test
    public void mexicoLinkTest() {
        // <a href="https://www.bestbuy.com.mx/">
        // <img src="https://www.bestbuy.com/~assets/bby/_intl/landing_page/images/maps/mexico.svg" alt="Mexico">
        // <h4>Mexico</h4>
        // </a>

        WebElement mexicoLinki = driver.findElement(By.partialLinkText("Mexico"));
        boolean linkGorunuyorMu = mexicoLinki.isDisplayed();
        Assert.assertTrue(linkGorunuyorMu);


    }
}









