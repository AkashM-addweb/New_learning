package com.herokuApp;

import com.Basepackage.Baseinit;
import org.apache.lucene.search.spell.SpellChecker;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.security.auth.login.Configuration;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

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
        WebElement removeButton = driver.findElement(By.xpath("//*[@id=\"checkbox-example\"]/button"));
        WebElement addButton = driver.findElement(By.xpath("//*[@id=\"checkbox-example\"]/button"));

        removeButton.click();
        Thread.sleep(3000);
        addButton.click();
        Thread.sleep(3000);
        WebElement checkbox = driver.findElement(By.id("checkbox"));

        Assert.assertTrue(checkbox.isDisplayed());

        //Enable and Disable
        WebElement inputText = driver.findElement(By.xpath("//*[@id=\"input-example\"]/input"));
        WebElement enableButton = driver.findElement(By.xpath("//*[@id=\"input-example\"]/button"));
        Assert.assertTrue(!inputText.isEnabled());
        Thread.sleep(3000);
        enableButton.click();
        Thread.sleep(3000);
        Assert.assertTrue(inputText.isEnabled());
    }

    @Test
    public void contextMenu() throws InterruptedException, IOException {

        startUP();

        driver.get("https://the-internet.herokuapp.com/context_menu");
        Actions actions = new Actions(driver);
        WebElement hot_Spot = driver.findElement(By.id("hot-spot"));
        actions.moveToElement(hot_Spot).contextClick().build().perform();
        Thread.sleep(3000);
        driver.switchTo().alert().accept();
//        actions.moveByOffset().

    }

    @Test
    public void entry_Ad() throws InterruptedException, IOException {
        startUP();
        driver.get("https://the-internet.herokuapp.com/entry_ad");

        WebElement link = driver.findElement(By.id("restart-ad"));
        link.click();

        Thread.sleep(3000);

        WebElement modal = driver.findElement(By.className("modal"));
        Assert.assertTrue(modal.isDisplayed());

        WebElement closeButton = driver.findElement(By.xpath("//*[@id=\"modal\"]/div[2]/div[3]/p"));
        closeButton.click();

        Assert.assertTrue(modal.isDisplayed());
    }

    @Test
    public void checkDownloadedFile() throws InterruptedException, IOException {

        startUP();

        driver.get("https://the-internet.herokuapp.com/download");
        Thread.sleep(3000);

        String filename = "Passport.jpg";

        driver.findElement(By.linkText("Passport.jpg")).click();
        Thread.sleep(3000);

        File dir = new File("/home/addweb/Downloads");
        File[] dirContents = dir.listFiles();
        System.out.println(dirContents);

        System.out.println("Length of the contents: "+dirContents.length);
//
//        for (int j=0; j< dirContents.length; j++){
//            System.out.println(dirContents[j].getName());
//        }

        Thread.sleep(5000);

        for (int i = 0; i <dirContents.length; i++) {

            if (dirContents[i].getName().equalsIgnoreCase(filename)) {
                System.out.println("File found");
                break;
            }
        }
    }

    @Test
    public void uploadFile() throws IOException, InterruptedException {
        startUP();
        driver.get("https://the-internet.herokuapp.com/upload");
        WebElement fileUpload= driver.findElement(By.id("file-upload"));
        fileUpload.sendKeys("/home/addweb/Downloads/Passport.jpg");
        Thread.sleep(3000);
        driver.findElement(By.id("file-submit")).click();

    }

    @Test
    public void floatingMenu() throws IOException, InterruptedException {
        startUP();
        driver.get("https://the-internet.herokuapp.com/floating_menu");
        Thread.sleep(3000);
        WebElement menu= driver.findElement(By.id("menu"));
        Assert.assertTrue(menu.isDisplayed());

        JavascriptExecutor jse= (JavascriptExecutor)driver;
        jse.executeScript("window.scrollBy(0,500)","");
        Assert.assertTrue(menu.isDisplayed());

        Thread.sleep(3000);
        jse.executeScript("window.scrollBy(0,500)","");
        Assert.assertTrue(menu.isDisplayed());

    }

    @Test
    public void handleFrames() throws IOException, InterruptedException {
        startUP();
        driver.get("https://www.guru99.com/handling-iframes-selenium.html");

        //Nested Frames
//        driver.findElement(By.linkText("Nested Frames")).click();
        Thread.sleep(5000);
        driver.switchTo().frame("google_ads_iframe_/24132379/guru99.com_300x250_2_0");

        //iFrame
        driver.get("https://the-internet.herokuapp.com/iframe");
        Thread.sleep(3000);
        driver.switchTo().frame("mce_0_ifr");
        WebElement editor=driver.findElement(By.id("tinymce"));
        editor.sendKeys("google_ads_iframe_/24132379/guru99.com_300x250_2_0");
        Thread.sleep(2000);
        String textEditor=editor.getText();
        System.out.println(textEditor);

    }

//    @Test
//        public void test_Selenium4_Geolocation() throws InterruptedException {
//            Map< String,Object> coordinates =
//                    new HashMap< String,Object>();
//
//            /* Create a hashmap for latitude, longitude, and accuracy as needed by Google Maps */
//            coordinates.put("latitude", 42.1408845);
//            coordinates.put("longitude", -72.5033907);
//            coordinates.put("accuracy", 100);
//
//            /* Command to emulate Geolocation */
//            driver.exe("Emulation.setGeolocationOverride", coordinates);
//            driver.navigate().to(URL);
//            driver.manage().window().maximize();
//
//            /* driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); */
//            /* Not a good programming practice, added for demonstration */
//            Thread.sleep(5000);
//
//            WebElement location_icon = driver.findElement(By.cssSelector(".icon-geolocate"));
//            Thread.sleep(2000);
//            location_icon.click();
//
//            Thread.sleep(6000);
//            System.out.println("Geolocation testing with Selenium is complete");
//        }


    @Test
    public void hovers() throws IOException, InterruptedException {
        startUP();
        driver.get("https://the-internet.herokuapp.com/hovers");
        Thread.sleep(3000);
        Actions actions= new Actions(driver);
        //Hover on 1
        actions.moveToElement(driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[1]/img"))).build().perform();

        WebElement profileText= driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[1]/div/a"));
        Boolean text= profileText.isDisplayed();
        Assert.assertTrue(text);
        Thread.sleep(4000);
        profileText.click();

//        String text= driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[1]/img")).getText();

    }

    @Test
    public void infiniteScroll() throws IOException, InterruptedException {
        startUP();
        driver.get("https://the-internet.herokuapp.com/infinite_scroll");
        Thread.sleep(3000);
        Boolean footer= driver.findElement(By.id("page-footer")).isDisplayed();

        while(footer){
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollTo(0,document.body.scrollHeight);");
    }
 }


    @Test
    public void jQueryUImenu() throws IOException, InterruptedException {
        startUP();
        driver.get("https://the-internet.herokuapp.com/jqueryui/menu");
        Thread.sleep(5000);
        Actions actions= new Actions(driver);
        WebElement disableID= driver.findElement(By.id("ui-id-1"));
        WebElement enabled = driver.findElement(By.xpath("//*[@id='ui-id-3']/a"));
        WebElement downLoad = driver.findElement(By.xpath("//*[@id=\"ui-id-4\"]/span"));
        WebElement CSV = driver.findElement(By.xpath("//*[@id=\"ui-id-6\"]/a"));

        actions.moveToElement(enabled).build().perform();
        Thread.sleep(2000);
        actions.moveToElement(downLoad).build().perform();
        Thread.sleep(2000);
        actions.moveToElement(CSV).click().build().perform();

    }

    @Test
    public void handleJavascriptError() throws IOException, InterruptedException {

        startUP();
//        LogEntries entries = driver.manage().logs().get(LogType.BROWSER);
//        entries.filter(Level.SEVERE);

        driver.get("https://the-internet.herokuapp.com/javascript_error");
        Thread.sleep(3000);

        LogEntries logEntries = driver.manage().logs().get("browser");
        Thread.sleep(3000);

        for (LogEntry entry : logEntries) {
            System.out.println(new Date(entry.getTimestamp()) + " " + entry.getLevel() + " " + entry.getMessage());
//            String errorLogType= entry.getLevel().toString();
            String errorLogType= entry.getLevel().toString();
            String errorLog= entry.getMessage().toString();
            if(errorLog.contains("404")){
                System.out.println("Error LogType: "+ errorLogType+" Error Log message: "+errorLog);
            }
        }

    }

    @Test
    public void spellChecker() throws IOException, InterruptedException {
        startUP();
        driver.get("https://artoftesting.com/maximize-minimize-a-browser-in-selenium-webdriver-java/amp");

        Thread.sleep(3000);
        String texts= driver.findElement(By.tagName("body")).getText();
        System.out.println(texts);

//        SpellChecker checker= new SpellChecker();
        Dimension dimension = new Dimension(300, 500);
        driver.manage().window().setSize(dimension);


    }



}



