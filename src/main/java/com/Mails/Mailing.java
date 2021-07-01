package com.Mails;

import com.Basepackage.Baseinit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.io.IOException;

public class Mailing extends Baseinit {


    public void checkMailFunctionality() throws IOException, InterruptedException {

        startUP();
        driver.get("https://mailtrap.io/signin");
        Thread.sleep(2000);

        driver.findElement(By.className("cookies-banner__button")).click();

        WebElement email = driver.findElement(By.xpath("//input[@type='email']"));

        email.sendKeys("akash.m.addweb@gmail.com");

        WebElement password = driver.findElement(By.xpath("//input[@type='password']"));
        password.sendKeys("testing123");

        driver.findElement(By.xpath("//input[@type='submit']")).click();

        driver.findElement(By.xpath("//a[@title='Demo inbox']")).click();

    }
}
