package com.TestSuite;

import com.Basepackage.Baseinit;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.awt.*;
import java.io.IOException;
import java.util.List;

public class Broken_image extends Baseinit {

    @Test
    public void checkBrokenImage() throws IOException {

        startUP();
        driver.get("https://the-internet.herokuapp.com/broken_images");
        int brokenImgCount=0;

        List<WebElement> image_List= driver.findElements(By.tagName("img"));

        for (WebElement img: image_List) {

            if(img!=null){
                HttpClient client= HttpClientBuilder.create().build();
                System.out.println("HTTP Client");
                System.out.println( client= HttpClientBuilder.create().build());

                System.out.println("--------------------------------------------------");
                System.out.println("--------------------------------------------------");
                System.out.println("--------------------------------------------------");
                System.out.println("--------------------------------------------------");
                System.out.println("--------------------------------------------------");
                System.out.println("--------------------------------------------------");
                HttpGet request = new HttpGet(img.getAttribute("src"));
                System.out.println("--------------------------------------------------");
                System.out.println("--------------------------------------------------");
                System.out.println("--------------------------------------------------");
                System.out.println("--------------------------------------------------");
                System.out.println("--------------------------------------------------");
                System.out.println("--------------------------------------------------");
                System.out.println("Request method");
                System.out.println(request = new HttpGet(img.getAttribute("src")));


                HttpResponse response= client.execute(request);
                System.out.println("--------------------------------------------------");
                System.out.println("--------------------------------------------------");
                System.out.println("--------------------------------------------------");
                System.out.println("--------------------------------------------------");
                System.out.println("--------------------------------------------------");
                System.out.println("--------------------------------------------------");
                System.out.println("Response");
                System.out.println(response= client.execute(request));

                if(response.getStatusLine().getStatusCode()!=200){
                    System.out.println(img.getAttribute("outerHTML") +"  is broken");
                    brokenImgCount++;
                }

            }


        }



    }
}
