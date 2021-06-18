package com.TestSuite;

import com.Basepackage.Baseinit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Iterator;
import java.util.List;

public class Broken_links extends Baseinit {

    @Test
    public void checkBrokenLinks() throws IOException, InterruptedException {

        startUP();
        HttpURLConnection connection=null;
        String url;
        String homepage="https://www.zlti.com/";
        int responseCode=200;

        driver.get(homepage);
        Thread.sleep(7000);

        List<WebElement> linklist=driver.findElements(By.tagName("a"));
        System.out.println(linklist);

        Iterator<WebElement> iterator= linklist.iterator();

        while (iterator.hasNext()){
            url=iterator.next().getAttribute("href");
            System.out.println(url);

            if(url==null || url.isEmpty()){
                System.out.println("URL is empty or NULL");
            }

            if(!url.startsWith(homepage)){
                System.out.println("URL belongs to another domain, skipping it.");
            }

                try{
                    connection= (HttpURLConnection) (new URL(url).openConnection());
                    connection.setRequestMethod("HEAD");
                    connection.connect();
                    responseCode= connection.getResponseCode();

                    if(responseCode>=400){
                        System.out.println("It is a broken link");
                    }

                    else{
                        System.out.println(url+" is a valid link");
                    }

                }catch (Exception e){
                    e.printStackTrace();
                }
        }
    }
}