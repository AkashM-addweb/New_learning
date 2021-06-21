package com.TestSuite;

import com.Basepackage.Baseinit;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.io.IOException;
public class Registration extends Baseinit {

    @Test
    public void checkRegistration() throws InterruptedException, IOException {

        test= reports.createTest("Check registration");
        driver.get(siteData.getProperty("url"));

        driver.findElement(By.xpath(objectStorage.getProperty("signUP_xpath"))).click();
        Thread.sleep(3000);

        driver.findElement(By.xpath(objectStorage.getProperty("tryForfree_xpath"))).click();
        Thread.sleep(3000);

        driver.findElement(By.id(objectStorage.getProperty("email_id"))).sendKeys("akash.msh7@gmail.com");
        Thread.sleep(3000);

        driver.findElement(By.name(objectStorage.getProperty("password_name"))).sendKeys("Testing@123");
        Thread.sleep(3000);
        driver.findElement(By.className(objectStorage.getProperty("goToNotes_classname"))).click();


    }

}