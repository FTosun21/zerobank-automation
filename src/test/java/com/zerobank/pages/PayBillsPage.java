package com.zerobank.pages;

import com.zerobank.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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

    public void sendAmount(String amount){
        new PayBillsPage().amountBox.sendKeys(amount);
    }

}
