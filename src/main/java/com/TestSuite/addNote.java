package com.TestSuite;

import com.Basepackage.Baseinit;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class addNote extends Baseinit {

    @Test
    public void addNotes() throws InterruptedException, IOException {

        startUP();

        driver.findElement(By.id(objectStorage.getProperty("addNoteButton_id"))).click();
        driver.findElement(By.className(objectStorage.getProperty("addTitle_class"))).sendKeys("Title of the note");
        Thread.sleep(3000);
        driver.findElement(By.className(objectStorage.getProperty("addBody_class"))).sendKeys("Body of the note");

        String title= driver.getTitle();
        Assert.assertTrue(title.contains(""));

    }
}
