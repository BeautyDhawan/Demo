package com.crm.qa.pages;

import com.crm.qa.Base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage  extends TestBase {
    @FindBy(name = "username")
    WebElement username;

    @FindBy(name ="password")
    WebElement password;

    @FindBy(css=".btn.btn-small")
    WebElement loginbtn;



    /// initializing the pge objects
    public LoginPage(){   // constructor creation
        // this pointing current class object
        PageFactory.initElements(driver, this);  // how will u initialize pagefactory...ans-pagefactory.initelement(means inititialize elements with driver and this means current class object)
    }

    public void userlogin(String un, String pwd){
        username.sendKeys(un);
        password.sendKeys(pwd);
    }
    public HomePage clickonloginbtn() throws InterruptedException {
        loginbtn.click();

        return new HomePage();
    }


}
