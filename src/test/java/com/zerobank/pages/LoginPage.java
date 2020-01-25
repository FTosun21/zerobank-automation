package com.zerobank.pages;

import com.zerobank.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage{

    public LoginPage(){
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(id="user_login")
    public WebElement username;

    @FindBy(id="user_password")
    public WebElement password;

    @FindBy(name="submit")
    public WebElement signIn;

    @FindBy(css=".alert.alert-error")
    public WebElement errorMessage;

    public void login(String usernameStr,String passwordStr){
        username.sendKeys(usernameStr);
        password.sendKeys(passwordStr);

        signIn.click();
    }

}
