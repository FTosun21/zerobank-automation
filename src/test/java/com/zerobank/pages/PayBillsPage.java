package com.zerobank.pages;

import com.zerobank.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class PayBillsPage extends BasePage{

    public PayBillsPage(){

        PageFactory.initElements(Driver.get(),this);
    }

    @FindBy(id = "sp_amount")
    public WebElement amountBox;

    @FindBy(id = "sp_date")
    public WebElement dateBox;

    @FindBy(css = ".ui-datepicker-calendar>tbody>tr>td[data-handler]")
    public WebElement anyDate;

    @FindBy(id = "pay_saved_payees")
    public WebElement payButton;

    @FindBy(css = "#alert_content>span")
    public WebElement paymentMessage;

    @FindBy(id = "alert_content")
    public WebElement addPayeeMessage;

    @FindBy(id = "np_new_payee_name")
    public WebElement payeeNameBox;

    @FindBy(id = "np_new_payee_address")
    public WebElement payeeAdressBox;

    @FindBy(id = "np_new_payee_account")
    public WebElement payeeAccountBox;

    @FindBy(id = "np_new_payee_details")
    public WebElement payeeDetailsBox;

    @FindBy(id = "add_new_payee")
    public WebElement addButton;

    @FindBy(id = "pc_calculate_costs")
    public WebElement calculateCostsButton;

    public void sendAmount(String amount){
        new PayBillsPage().amountBox.sendKeys(amount);
    }

    public Select CurrencyDropdown(){
        WebElement dDown = Driver.get().findElement(By.id("pc_currency"));
        Select dList = new Select(dDown);
        return  dList;
    }

}
