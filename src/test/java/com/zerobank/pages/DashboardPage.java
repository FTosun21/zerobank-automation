package com.zerobank.pages;

import com.zerobank.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardPage extends BasePage{

    public DashboardPage(){

        PageFactory.initElements(Driver.get(),this);
    }

    @FindBy(css=".active>a")
    public WebElement activePage;

    public void navigateToModule(String moduleName){
        WebElement module = Driver.get().findElement(By.linkText(moduleName));
        Actions action = new Actions(Driver.get());
        action.moveToElement(module).click().perform();
    }
}
