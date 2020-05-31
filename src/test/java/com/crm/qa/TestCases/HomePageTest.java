package com.crm.qa.TestCases;

import com.crm.qa.Base.TestBase;
import com.crm.qa.pages.ContactPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class HomePageTest extends TestBase {
    LoginPage page;
    HomePage homePage;
    TestUtil util;
    ContactPage contactsPage;
    public HomePageTest(){
        super();
    }

    @BeforeSuite
    public void setUp() throws InterruptedException {
        initialization();
        util = new TestUtil();
        contactsPage = new ContactPage();
        LoginPage page= new LoginPage();
        page.userlogin(prop.getProperty("username"),prop.getProperty("password"));
        Thread.sleep(10000);
        homePage =  page.clickonloginbtn(); //returning the object of homepage
        Thread.sleep(10000);
    }

    @Test(priority = 1)
    public void varifyHomePage() throws InterruptedException {
        String homepagetitle = homePage.verifyhomepagetitle();
        Assert.assertEquals(homepagetitle,"CRMPRO", "homepage title not match");
        Thread.sleep(10000);

    }
    @Test(priority = 2)
    public void userlabel() throws InterruptedException {

        Assert.assertTrue(homePage.varifyusernamelable(),"label is not matched");


        Thread.sleep(3000);
    }


    @Test(priority = 3)
    public void ContactsPage(){


        //   util.switchtoframe();
        contactsPage  =  homePage.clickonContacts();

    }


    @AfterSuite
    public void teardwon(){
        driver.quit();
    }

}



