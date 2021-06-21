package com.TestSuite;

import com.Basepackage.Baseinit;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.Duration;

public class ActionClass extends Baseinit {

    @Test
    public void keyboardEvents() throws IOException, InterruptedException {

        startUP();
        driver.get("https://demoqa.com/automation-practice-form");

        WebElement username=driver.findElement(By.id("firstName"));
        Actions actions = new Actions(driver);
        Thread.sleep(5000);

//        System.out.println(actions.moveToElement(driver.findElement(By.linkText("Agile Project"))));
//        driver.findElement(By.id("firstName")).sendKeys("Hello");
//        actions.keyDown(username,Keys.SHIFT).sendKeys("Test Automation").keyUp(Keys.SHIFT);

        //Different Methods for performing Keyboard Events:

        //Move to the Element
        actions.moveToElement(driver.findElement(By.id("firstName"))).click().build().perform();
        Thread.sleep(3000);

        //Typing the text in capital
        actions.moveToElement(driver.findElement(By.id("firstName"))).keyDown(Keys.SHIFT).sendKeys("Testing")
        .keyUp(Keys.SHIFT).build().perform();

        //Opening the link in new tab
        actions.moveToElement(driver.findElement(By.xpath("//*[@id=\"app\"]/header/a/img"))).keyDown(Keys.CONTROL)
        .click().keyDown(Keys.CONTROL).build().perform();

        Thread.sleep(3000);
        driver.quit();
    }

    @Test
    public void mouseEvents() throws InterruptedException, IOException {
//        driver.get("https://demoqa.com/automation-practice-form");

        startUP();
        //Double click
        driver.get("https://mousetester.com/");
        Actions actions=new Actions(driver);

        //Make a double click
        Thread.sleep(3000);
        actions.doubleClick(driver.findElement(By.id("clickMe"))).build().perform();

        //Make a context click
        Thread.sleep(3000);
        actions.contextClick(driver.findElement(By.id("clickMe"))).build().perform();

        //Make the scroll click
        driver.get("https://jqueryui.com/droppable/");
        Thread.sleep(3000);
//        WebElement drag=driver.findElement(By.className("ui-widget-content ui-draggable ui-draggable-handle"));
//        WebElement drop=driver.findElement(By.className("ui-widget-content ui-draggable ui-draggable-handle"));
        WebElement drag=driver.findElement(By.xpath("//*[@id=\"draggable\"]"));
        WebElement drop=driver.findElement(By.xpath("//*[@id=\"droppable\"]"));
//        actions.clickAndHold(drag).pause(Duration.ofSeconds(2)).moveToElement(drop).release().build().perform();
//        actions.moveToElement(drag).clickAndHold(drag).moveToElement(drop).release().build().perform();
        actions.moveToElement(drag).clickAndHold(drag).moveToElement(drop).release().build().perform();

        driver.get("https://jqueryui.com/droppable/");
        Thread.sleep(3000);
        actions.dragAndDrop(drag,drop).perform();

        Thread.sleep(3000);
        driver.quit();

    }

    @Test
    public void clickandHolds() throws IOException, InterruptedException {
        startUP();
        //Double click

        Actions actions=new Actions(driver);
        driver.get("https://dhtmlx.com/docs/products/dhtmlxTree/");

        Thread.sleep(7000);
        actions.moveToElement(driver.findElement(By.xpath("/html/body/section/div[1]/div[1]/div")));
        Thread.sleep(7000);
        WebElement src= driver.findElement(By.xpath("//span[text()='Lawrence Block']"));
        WebElement target= driver.findElement(By.xpath("//li[text()='Ian Rankin']"));

        actions.clickAndHold(src).pause(Duration.ofSeconds(2)).moveToElement(target).release().build().perform();
    }

    @Test
    public void dragANDdropBy() throws IOException, InterruptedException {

        startUP();
        driver.get("https://jqueryui.com/slider/");

        WebElement frame = driver.findElement(By.xpath("//*[@id=\"content\"]/iframe"));
        driver.switchTo().frame(frame);
        Thread.sleep(4000);
        WebElement element= driver.findElement(By.xpath("//*[@id=\"slider\"]/span"));
        Actions actions= new Actions(driver);
        Thread.sleep(4000);
//      actions.moveToElement(element);
        Thread.sleep(4000);
        actions.dragAndDropBy(element, 100, 200).build().perform();
//      actions.clickAndHold(element).moveByOffset(22,75).release().perform();

    }

}
