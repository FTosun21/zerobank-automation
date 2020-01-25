package com.zerobank.pages;

import com.zerobank.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class AccountSummaryPage extends BasePage{

    public AccountSummaryPage(){

        PageFactory.initElements(Driver.get(),this);
    }

    @FindBy(linkText = "Savings")
    public WebElement savings;

    public List<WebElement> accountTypeList = Driver.get().findElements(By.cssSelector(".board-header"));

    public List<WebElement> creditAccountOptionList = Driver.get().findElements(By.xpath("(//*[contains(text(),'Credit Accounts')]/following-sibling::div)[1]//th"));

    public void navigateToLinkElement(String str){
        WebElement link = Driver.get().findElement(By.linkText(str));
        link.click();
    }
}
