package com.zerobank.pages;

import com.zerobank.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class AccountActivityPage extends BasePage{

    public AccountActivityPage(){

        PageFactory.initElements(Driver.get(),this);
    }

    @FindBy(id = "aa_fromDate")
    public WebElement fromDate;

    @FindBy(id = "aa_toDate")
    public WebElement toDate;

    @FindBy(css = ".btn.btn-primary")
    public WebElement findButton;

    @FindBy(id = "aa_description")
    public WebElement descriptionBox;

    @FindBy(id = "aa_type")
    public WebElement typeDropdpown;

    public Select accountDropdownList(){
        WebElement accountDropdownMenu = Driver.get().findElement(By.id("aa_accountId"));
        Select selectList = new Select(accountDropdownMenu);

        return selectList;
    }

    public Select selectTypeList(){
        WebElement selectedType = Driver.get().findElement(By.id("aa_type"));
        Select selectList = new Select(selectedType);
        return selectList;
    }

    public void navigateToTab(String str){
        WebElement link = Driver.get().findElement(By.linkText(str));
        link.click();
    }

    public List<WebElement> transactionsHeaders = Driver.get().findElements(By.xpath("//*[@class='table table-condensed table-hover']/thead/tr/th"));

    public List<WebElement> dateColumnList = Driver.get().findElements(By.xpath("(//table[contains(@class,'table')])[2]//tbody/tr/td[1]"));

    public List<WebElement> descriptionColumnList = Driver.get().findElements(By.xpath("(//table[contains(@class,'table')])[2]//tbody/tr/td[2]"));

    public List<WebElement> depositColumnList = Driver.get().findElements(By.xpath("(//table[contains(@class,'table')])[2]//tbody/tr/td[3]"));

    public List<WebElement> withdrawalColumnList = Driver.get().findElements(By.xpath("(//table[contains(@class,'table')])[2]//tbody/tr/td[4]"));


}
