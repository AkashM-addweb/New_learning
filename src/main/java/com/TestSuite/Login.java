package com.TestSuite;

import com.Basepackage.Baseinit;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;

public class Login extends Baseinit {

    @Test
    public void checkLogin() throws InterruptedException, IOException {

    startUP();

//    test= reports.createTest("Check login");

    //Get the URL
    driver.get(siteData.getProperty("url"));

    //Click on the login
    driver.findElement(By.linkText(objectStorage.getProperty("login_linktext"))).click();
    Thread.sleep(3000);

    driver.findElement(By.id(objectStorage.getProperty("username_id"))).sendKeys("akash.msh7@gmail.com");
//    driver.findElement(By.id(objectStorage.getProperty("continue_id"))).click();

//    driver.manage().timeouts().implicitlyWait();
        ((JavascriptExecutor)driver).executeScript("scroll(0,300");
    driver.findElement(By.id(objectStorage.getProperty("password_id"))).sendKeys("Testing@123");
    driver.findElement(By.id(objectStorage.getProperty("continue_id"))).click();

    String title= driver.getTitle();
    Assert.assertTrue(title.contains("https://www.evernote.com/client/web?_sourcePage="));

    }
}