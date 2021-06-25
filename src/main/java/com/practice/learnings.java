package com.practice;

import com.Basepackage.Baseinit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.io.IOException;

public class learnings extends Baseinit{

      @Test
 public void learning() throws IOException, InterruptedException {

          startUP();
          driver.get("https://demoqa.com/automation-practice-form");
//          Thread.sleep(3000);
//          driver.findElement(By.id("dateOfBirthInput")).click();
          Thread.sleep(3000);
//          WebElement monthBox = driver.findElement(By.className("react-datepicker__month-select"));
//          WebElement yearBox = driver.findElement(By.className("react-datepicker__year-select"));
//
//          JavascriptExecutor jse= new JavascriptExecutor;
//          jse.executeScript("window.scrollBy(0,250");
//          Thread.sleep(3000);
//
//          Select objSelectYear = new Select(yearBox);
//          objSelectYear.selectByValue("2022");
//
//          Thread.sleep(3000);
//
//          Select objSelectMonth = new Select(monthBox);
//          objSelectMonth.selectByIndex(0);
//          Thread.sleep(3000);
//          driver.findElement(By.xpath("//*[@id=\"dateOfBirth\"]/div[2]/div[2]/div/div/div[2]/div[2]/div[3]/div[2]")).click();

//          Select select= new Select(driver.findElement(By.className(" css-1uccc91-singleValue")));
//          select.selectByValue("Uttar Pradesh");


    }


}
