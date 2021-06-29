package com.herokuApp;

import com.Basepackage.Baseinit;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

public class heroku2 extends Baseinit {

    @Test
    public void handleWindows() throws IOException, InterruptedException {

        startUP();

        driver.get("https://the-internet.herokuapp.com/windows");

        Thread.sleep(3000);
        driver.findElement(By.linkText("Click Here")).click();
        Thread.sleep(2000);
        driver.findElement(By.linkText("Click Here")).click();

        //To handle 1 window
        String parentWindowHandle = driver.getWindowHandle();
        System.out.println(parentWindowHandle);

        //To handle Multiple windows
        Set<String> handles=driver.getWindowHandles();
        System.out.println(handles);

        Iterator <String> iterator= handles.iterator();

        while (iterator.hasNext()){

        String childWindow = iterator.next();

        if(!parentWindowHandle.equalsIgnoreCase(childWindow)){
            driver.switchTo().window(childWindow);
            System.out.println(driver.switchTo().window(childWindow).getTitle());
        }
        }
        Thread.sleep(3000);
        driver.switchTo().window(parentWindowHandle);
        System.out.println(driver.switchTo().window(parentWindowHandle).getTitle());
    }

    @Test
    public void handlingWindows() throws IOException, InterruptedException {
        startUP();
        driver.get("https://the-internet.herokuapp.com/");
        Thread.sleep(3000);
        WebElement tab1= driver.findElement(By.linkText("Drag and Drop"));
        WebElement tab2= driver.findElement(By.linkText("Dropdown"));

        Actions actions= new Actions(driver);
        actions.moveToElement(tab1).keyDown(Keys.CONTROL).click().keyUp(Keys.CONTROL).build().perform();
        Thread.sleep(2000);
        actions.moveToElement(tab2).keyDown(Keys.CONTROL).click().keyUp(Keys.CONTROL).build().perform();

        String parentHandle= driver.getWindowHandle();
        Set<String> getAllWindowHandles = driver.getWindowHandles();
        System.out.println(getAllWindowHandles);
        Iterator<String> iterator= getAllWindowHandles.iterator();

//        driver.switchTo().window(getAllWindowHandles);
//        while (iterator.hasNext()){




    }

}