package com.zerobank.step_definitions;

import com.zerobank.pages.PayBillsPage;
import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;

public class PayBillsStepDef {

    @When("the user writes the amount of {string}")
    public void the_user_writes_the_amount_of(String amount) {
        new PayBillsPage().sendAmount(amount);
    }

    @When("the user selects the date")
    public void the_user_selects_the_date() {
        PayBillsPage payBillsPage = new PayBillsPage();
        payBillsPage.dateBox.click();
        payBillsPage.anyDate.click();
    }

    @When("the user clicks the Pay button")
    public void the_user_clicks_the_Pay_button() {
        new PayBillsPage().payButton.click();
    }

    @Then("the user should see the {string} message")
    public void the_user_should_see_the_message(String message) {
        PayBillsPage payBillsPage = new PayBillsPage();
        String actualMessage = payBillsPage.paymentMessage.getText();
        String expectedMessage = message;

        Assert.assertEquals(expectedMessage,actualMessage);
    }

    @Then("the user should get {string} from Amount input box")
    public void the_user_should_get_from_Amount_input_box(String message) {
        String actualMessage = new PayBillsPage().amountBox.getAttribute("validationMessage");
        String expectedMessage = message;

        Assert.assertEquals(actualMessage,expectedMessage);
    }

    @Then("the user should get {string} from Date input box")
    public void the_user_should_get_from_Date_input_box(String message) {
        String actualMessage = new PayBillsPage().dateBox.getAttribute("validationMessage");
        String expectedMessage = message;

        Assert.assertEquals(actualMessage,expectedMessage);
    }
    @Then("the user should not see the {string} message")
    public void the_user_should_not_see_the_message(String message) {
        PayBillsPage payBillsPage = new PayBillsPage();
        String actualMessage;
        try{
            actualMessage = payBillsPage.paymentMessage.getText();
        }catch(NoSuchElementException e){
            actualMessage = null;
        }
        String expectedMessage = message;

        Assert.assertFalse(expectedMessage.equals(actualMessage));
    }

    @When("the user writes date as {string}")
    public void the_user_writes_date_as(String message) {
        PayBillsPage payBillsPage = new PayBillsPage();
        payBillsPage.dateBox.sendKeys(message);
    }

    @Then("Amount input box should be empty")
    public void amount_input_box_should_be_empty() {
        String box = new PayBillsPage().amountBox.getText();
        System.out.println("box = " + box);
        Assert.assertTrue(box.isEmpty());
    }

    @Then("Date input box should be empty")
    public void date_input_box_should_be_empty() {
        String box = new PayBillsPage().dateBox.getText();
        System.out.println("box = " + box);
        Assert.assertTrue(box.isEmpty());
    }


}
