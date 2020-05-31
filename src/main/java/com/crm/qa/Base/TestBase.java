package com.crm.qa.Base;
//Static variables are initialized only once ,
// at the start of the execution. These variables will be initialized first,
// before the initialization of any instance variables

import com.crm.qa.util.WebEventListerner;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

// golbal variable for using in child and other class
public class TestBase {

    public static WebDriver driver;
    public static Properties prop;
    public static EventFiringWebDriver e_driver;
    public static WebEventListerner eventListener;
  public TestBase(){
        prop = new Properties();
        FileInputStream ip = null;
        try {
            ip = new FileInputStream("C:\\Users\\Beauty\\IdeaProjects\\CRMJOBS\\src\\main\\java\\com\\crm\\qa\\config\\config.properties");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            prop.load(ip);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void initialization() throws InterruptedException {
        String browsername = prop.getProperty("browser");
        if (browsername.equals("firefox")) {
            System.setProperty("webdriver.gecko.driver", "C:\\Users\\Beauty\\Desktop\\New\\geckodriver.exe");


            driver = new FirefoxDriver();
        }

        e_driver = new EventFiringWebDriver(driver);
        // Now create object of EventListerHandler to register it with EventFiringWebDriver
        eventListener = new WebEventListerner();
        e_driver.register(eventListener);
        driver = e_driver;


        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        //driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
        //  driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
        Thread.sleep(10000);
        //  driver.get(prop.getProperty("url"));
        driver.get(prop.getProperty("urlforlogin"));

    }
}
