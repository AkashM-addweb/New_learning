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
        WebElement AddButton = driver.findElement(By.xpath("//*[@id=\"content\"]/div/button"));
//        driver.findElement(By.xpath("//*[@id=\"content\"]/div/button")).click();
        AddButton.click();

        WebElement deleteBox = driver.findElement(By.xpath("//*[@id=\"elements\"]/button"));
        Assert.assertTrue(deleteBox.isDisplayed());

        //To check the number of clicks and the number of elements
        for (int i = 0; i < 10; i++) {
            AddButton.click();
        }

        WebElement del_buttons = driver.findElement(By.xpath("//*[@id=\"elements\"]"));
        List<WebElement> deleteButtons = del_buttons.findElements(By.className("added-manually"));
        int countButtons = deleteButtons.size();
        Thread.sleep(3000);
        System.out.println(countButtons);

    }

    @Test
    public void disappearing_elements() throws InterruptedException, IOException {

        startUP();
        driver.get("https://the-internet.herokuapp.com/disappearing_elements");
        Thread.sleep(3000);

        WebElement elements = driver.findElement(By.xpath("//*[@id=\"content\"]/div/ul"));
        List<WebElement> menus = elements.findElements(By.tagName("a"));
        System.out.println(menus.size());

        Assert.assertEquals(menus.size(), 5);
        driver.navigate().refresh();

        Thread.sleep(4000);
        Assert.assertEquals(menus.size(), 6);

    }


    @Test
    public void dynamic_controls() throws IOException, InterruptedException {

        startUP();

        //Add or Remove

        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        WebElement removeButton= driver.findElement(By.xpath("//*[@id=\"checkbox-example\"]/button"));
        WebElement addButton= driver.findElement(By.xpath("//*[@id=\"checkbox-example\"]/button"));

        removeButton.click();
        Thread.sleep(3000);
        addButton.click();
        Thread.sleep(3000);
        WebElement checkbox= driver.findElement(By.id("checkbox"));

        Assert.assertTrue(checkbox.isDisplayed());
//        Assert.assertTrue(textElement.isDisplayed());

        //Enable and Disable

        WebElement inputText= driver.findElement(By.xpath("//*[@id=\"input-example\"]/input"));
        WebElement enableButton= driver.findElement(By.xpath("//*[@id=\"input-example\"]/button"));
        Assert.assertTrue(!inputText.isEnabled());
        Thread.sleep(3000);
        enableButton.click();
        Thread.sleep(3000);
        Assert.assertTrue(inputText.isEnabled());

    }

}
