package com.Scraping;

import com.Basepackage.Baseinit;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.URL;

public class ScrapingAnt extends Baseinit {

    @Test
    public void antScraping() throws IOException {

        startUP();

//        driver.get("https://webscraper.io/test-sites/e-commerce/static/product/542");
//        String myIP= driver.findElement(By.cssSelector("greenip")).getText();
//        System.out.println(myIP);
//        String myIP= driver.findElement(By)

        InetAddress ipAddress= InetAddress.getLocalHost();
        System.out.println(ipAddress);
        String hostname= ipAddress.getHostName();
        System.out.println(hostname);

        URL url= new URL("https://icanhazip.com/");

        //buffered Reader from the site to get the details
        // 1. Is used to read the characters from the Input Stream
        // 2. It buffers characters for efficient handling of characters

        //Reader          Reader object =    //Declaring input stream to read characters            Indicates input of any type
//     BufferedReader       reader=  new BufferedReader(new InputStreamReader                      (System.in));

       BufferedReader brNew= new BufferedReader(new InputStreamReader(url.openStream()));

        System.out.println(brNew.readLine());

    }


    @Test
    public void proxyIPS() throws IOException {
        startUP();

        driver.get("https://free-proxy-list.net/");
        InetAddress ipAddress= InetAddress.getLocalHost();
        System.out.println(ipAddress.getHostAddress());
        Proxy proxy= new Proxy();
        proxy.setHttpProxy("http://google.com:8080");


        ChromeOptions chromeOptions= new ChromeOptions();
        chromeOptions.setCapability("proxy", proxy);

        WebDriver driver= new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        System.out.println(ipAddress.getHostAddress());
        System.out.println(proxy.getHttpProxy());
        System.out.println(proxy.getProxyAutoconfigUrl());


    }

    @Test
    public void proxyIPS2(){
        try {
            startUP();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Proxy proxy = new Proxy();

        driver.get("https://icanhazip.com/");
        proxy.setHttpProxy("https://icanhazip.com/:92.222.153.172:3128");
        System.out.println(proxy.getHttpProxy());

        driver.get("https://icanhazip.com/");
        proxy.setSslProxy("89.66.114.219:8080");
        System.out.println(proxy.getHttpProxy());


        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        capabilities.setCapability("proxy", proxy);

        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");

        capabilities.setCapability(ChromeOptions.CAPABILITY, options);

        driver = new ChromeDriver(capabilities);

    }
}