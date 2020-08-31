package com.techproed;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Day09_Assertion {

    private static WebDriver driver;

    @BeforeClass
    public static void etUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    @Test
    public void test1() {
        driver.get("http://google.com");
        String title = driver.getTitle();

      // Test Case: Google.com un basligi "Google Arama Sayfasi" olsun.
      // Google in title i "Google Arama Sayfasi" na esir mi, degil mi?

        Assert.assertEquals("Google Arama Sayfasi", title);
        //Assert.assertEquals(5,5);
        //Assert.assertEquals(true,false);
        //Assert.assertEquals("Yazı","Google");

     /*   if (title.contains("Arama")){             *******if else gerek yok******
            System.out.println("Arama kelimesi VAR");
        }else{
            System.out.println("Arama kelimesi YOK");
        }*/
    }
    @Test
    public void test2(){
        driver.get("http://amazon.com");
        // Amazon.com'un başlığı Amazon kelimesini içeriyor olsun.
        String title = driver.getTitle();
        boolean iceriyorMu =title.contains("Amazon");// true ya da false

        // boolean veri tipinde bir değer giriyoruz.
        Assert.assertTrue(iceriyorMu);
    }
    @Test
    public void test3(){
        driver.get("http://facebook.com");
        String title = driver.getTitle();

        //Facebook.com title i Youtube kelimesini icermesin.
        boolean iceriyorMu =title.contains("Youtube");
        Assert.assertFalse(iceriyorMu);// False oldugunu dogrula
        // parantezin içerisi FALSE ise test başarılı.

    }
    @Test
    public void test4(){
            driver.get("http://google.com");
            String title = driver.getTitle();

        System.out.println("MERHABALAR");

            Assert.assertEquals("Google Arama Sayfasi", title);

          //Eger test basarisiz ise ayni testteki kalan kismi calistirmaz
            System.out.println("TEST DOGRULAMA ISLEMI BITTI");
    }
    @Test
    public void test5() {
        driver.get("http://facebook.com");
        String title = driver.getTitle();

        //Facebook.com title i Youtube kelimesini icermesin.
        boolean iceriyorMu = title.contains("Youtube");
        Assert.assertFalse(iceriyorMu);// False oldugunu dogrula
        System.out.println("TEST DOGRULAMA ISLEMI BITTI");
    }
        @AfterClass
        public static void tearDown () {
            driver.quit();

        }
    }
