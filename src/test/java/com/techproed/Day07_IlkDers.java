package com.techproed;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Day07_IlkDers {

    public static void main(String[] args) {
        // Browserlari kullanabimek icin WebDriverManager kutuphanesini kullaniyor.
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://www.amazon.com");


        WebElement aramaKutusu = driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("samsung headphones" + Keys.ENTER);
        //aramaKutusu.submit(); nun yerine Keys.ENTER kullandik

        WebElement sonucSayisi = driver.findElement(By.xpath("//span[@dir='auto']"));
        System.out.println(sonucSayisi.getText());

       WebElement ilkUrun = driver.findElement(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']"));
        System.out.println(ilkUrun.getText());

        // Tum urunleri listeledik
       List<WebElement> listem = driver.findElements(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']"));

      // listem.get(4).getText(); ile 5. urunu bulur, ilk index 0 dir.
        for (WebElement w : listem){
            System.out.println(w.getText());
        }






    }
}
