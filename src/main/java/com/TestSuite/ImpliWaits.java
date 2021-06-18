package com.TestSuite;

import com.Basepackage.Baseinit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class ImpliWaits extends Baseinit {

//        public static WebDriver driver=null;
//        public static Logger logger=null;
//        public static Properties siteData=null;
//        public static FileInputStream fis;

        @Test
        public void waits() throws IOException {
            //Load the Browser

//            System.setProperty("webdriver.chrome.driver","./src/main/java/Learnings/chromedriver");
//            driver=new ChromeDriver();

//        siteData=new Properties();
//        fis=new FileInputStream("./src/main/java/Properties/siteData.properties");
//        fis.;
            startUP();
            driver.get("http://demo.guru99.com/V4/");

            //Implicit Wait
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

            //Explicit Wait
            WebElement username;
            WebDriverWait wait1= new WebDriverWait(driver, 10);
            driver.findElement(By.name("uid")).sendKeys("test Automation");
//            WebDriverWait wait2= new WebDriverWait(driver, 10);

//            wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("uid")));
////      wait.until(ExpectedConditions.elementToBeClickable(By.name("uid")));
//            driver.findElement(By.name("uid")).sendKeys("test Automation");


        }
    }

