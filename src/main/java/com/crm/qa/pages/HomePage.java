package com.crm.qa.pages;

import com.crm.qa.Base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends TestBase {

    @FindBy(xpath = "//td[contains(text(),'User: Demo User')]")
    WebElement UserNameLabel;
    @FindBy(xpath = "//a[contains(text(),'Contacts')]")
    WebElement contacts;
    @FindBy(xpath = "//a[contains(text(),'Deals')]")
    WebElement Deals;
    @FindBy(xpath = "//a[contains(text(),'Tasks')]")
    WebElement Task;
    @FindBy(xpath = "//a[contains(text(),'New Contact')]")
    WebElement NewContact;


    //initilizing the page object:
    public HomePage(){
        PageFactory.initElements(driver,this);
    }

    public boolean varifyusernamelable(){

        WebDriverWait wait = new WebDriverWait(driver, 3);
        WebElement checklabel = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[contains(text(),'User: Demo User')]")));
        return checklabel.isDisplayed();

    }

    public String verifyhomepagetitle(){
        return driver.getTitle();
    }
    public ContactPage clickonContacts(){

        return new ContactPage();
    }
    public DealsPage ClickOnDealsLink(){
        Deals.click();
        return new DealsPage();

    }
    public TaskPage ClickOnTaskLin(){
        Task.click();
        return new TaskPage();
    }

    // for visible to hidden element in drop down we use action class
    public void newcontact(){
        Actions action = new Actions(driver);
        action.moveToElement(contacts).build().perform();
        NewContact.click();
    }



}
