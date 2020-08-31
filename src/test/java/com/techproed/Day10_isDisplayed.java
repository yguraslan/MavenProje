package com.techproed;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Day10_isDisplayed {

    static WebDriver driver;// instance variable

    @BeforeClass
    public static void setUp(){
        // driver i kullanilabilir hale getirelim.
        WebDriverManager.chromedriver().setup();
        //driver objesini olusturuyoruz
        driver = new ChromeDriver();
        //driver komutlarimizi girelim
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void test1(){
        //google
        driver.get("http://google.com");
        WebElement logo = driver.findElement(By.id("hplogo"));

        //eger webelement kullaniciya gosteriliyorsa TRUE,
        //eger webelement kullanicidan gizleniyorsa, FALSE
        boolean gorunuyorMu = logo.isDisplayed();

        // testimizin sonucunu bildiriyoruz.
        // eğer "gorunuyorMu" TRUE ise testim PASSED(BAŞARILI)
        // eğer "gorunuyorMu" FALSE ise testim FAILED(BAŞARISIZ)
        Assert.assertTrue(gorunuyorMu);

    }
    @AfterClass
    public static void tearDown() {
     //driver.quit();
    }
}












