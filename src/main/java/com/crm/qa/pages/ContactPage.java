package com.crm.qa.pages;

import com.crm.qa.Base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ContactPage extends TestBase {
    @FindBy(xpath = "//td[contains(text(),'Contacts')]")
    WebElement contactlabel;

    // initilazing the page object:
    public ContactPage(){
        PageFactory.initElements(driver,this);
    }

    public boolean verifycontactslabel(){

        WebDriverWait wait = new WebDriverWait(driver, 3);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[contains(text(),'Contacts')]")));

        return contactlabel.isDisplayed();

    }

    public void selectcheckbox(String name){

        WebDriverWait wait = new WebDriverWait(driver, 3);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"vContactsForm\"]/table/tbody/tr[4]/td[1]/input"))).click();

    }


}
