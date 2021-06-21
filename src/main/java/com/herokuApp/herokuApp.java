package com.herokuApp;

import com.Basepackage.Baseinit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.awt.*;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class herokuApp extends Baseinit {

    @Test
    public void addRemoveElements() throws IOException, InterruptedException {
        startUP();
        driver.get("https://the-internet.herokuapp.com/add_remove_elements/");
        //Implicitly wait
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement AddButton= driver.findElement(By.xpath("//*[@id=\"content\"]/div/button"));
//        driver.findElement(By.xpath("//*[@id=\"content\"]/div/button")).click();
        AddButton.click();

        WebElement deleteBox= driver.findElement(By.xpath("//*[@id=\"elements\"]/button"));
        Assert.assertTrue(deleteBox.isDisplayed());

        //To check the number of clicks and the number of elements
        for(int i=0; i<10 ; i++){
            AddButton.click();
        }

        WebElement del_buttons= driver.findElement(By.xpath("//*[@id=\"elements\"]"));
        List<WebElement> deleteButtons= del_buttons.findElements(By.className("added-manually"));
        int countButtons= deleteButtons.size();
        Thread.sleep(3000);
        System.out.println(countButtons);

    }
}
