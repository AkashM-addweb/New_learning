package com.Basepackage;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Baseinit {

    public static WebDriver driver;
    public static Properties siteData = null;
    public static Properties objectStorage = null;
    public static FileInputStream fi= null;

    public static ExtentHtmlReporter reporter = null;
    public static ExtentReports reports = null;
    public static ExtentTest test = null;

    public void startUP() throws IOException {

        reporter = new ExtentHtmlReporter("./src/main/resources/Reports/Reports.html");
        reporter.config().setDocumentTitle("Evernote Report");
        reporter.config().setTheme(Theme.DARK);
        reporter.config().setReportName("Testing Report_1");

        reports = new ExtentReports();
        reports.setSystemInfo("Environment", "Testing");
        reports.setSystemInfo("Team name", "Quintype_Interview");
        reports.attachReporter(reporter);

        siteData=new Properties();
        fi= new FileInputStream("./src/main/resources/Properties/SiteData.properties");
        siteData.load(fi);

        objectStorage=new Properties();
        fi= new FileInputStream("./src/main/resources/Properties/Objectdata.properties");
        objectStorage.load(fi);

        String browserKey= siteData.getProperty("browser");
        if(browserKey.equalsIgnoreCase("Chrome")) {
            System.setProperty("webdriver.chrome.driver", "./src/main/java/Drivers/chromedriver");
            driver=new ChromeDriver();
        }

        else if(browserKey.equalsIgnoreCase("Firefox")) {
            System.setProperty("webdriver.gecko.driver", "./src/main/java/Drivers/geckodriver");
            driver=new FirefoxDriver();
        }

        else
        {
            System.out.println("No Browser defined");
        }

        driver.manage().window().maximize();
    }
}
