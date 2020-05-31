package com.crm.qa.TestCases;

import com.crm.qa.Base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;
// what is log = to caturing the info at the time of rpogram execution.
// lvel of logd-
//info
//warn
//debug
//fatal
// how to generate the logs - with the help o apache api and log4j propertis file.
//where to create- insie resources



public class LoginTest  extends TestBase {
    LoginPage page;
    HomePage homepage;
    Logger log = Logger.getLogger(LoginTest.class);

    public LoginTest(){
        super();

    }

    @BeforeSuite
    public void setup() throws InterruptedException {
        initialization();
        log.info("launching broswer");
        page = new LoginPage();
        Thread.sleep(3000);
    }

    @Test(priority = 1)
    public void userloginTest() throws InterruptedException {
        page.userlogin(prop.getProperty("username"),prop.getProperty("password"));
        log.info("succesfull login");
        Thread.sleep(3000);
    }

    @Test(priority = 2)
    public void loginclick() throws InterruptedException {
        homepage =  page.clickonloginbtn();   // it will give us homepage object so we can save in homepage object

    }

    @AfterSuite
    public void teardown(){
        driver.quit();
    }
}
