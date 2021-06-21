package com.TestSuite;

import com.Basepackage.Baseinit;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.io.IOException;

public class geolocation extends Baseinit {

    @Test
    public void geoLocation() throws IOException, InterruptedException {

    startUP();
    driver.get("https://the-internet.herokuapp.com/geolocation");
    Thread.sleep(3000);
    driver.findElement(By.xpath("//*[@id=\"content\"]/div/button")).click();
    driver.switchTo().alert().accept();

    }
}