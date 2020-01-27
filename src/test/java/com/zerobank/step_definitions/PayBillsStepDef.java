package com.zerobank.step_definitions;

import com.zerobank.pages.PayBillsPage;
import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Map;

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

        Assert.assertEquals(expectedMessage, actualMessage);
    }

    @Then("the user should get {string} from Amount input box")
    public void the_user_should_get_from_Amount_input_box(String message) {
        String actualMessage = new PayBillsPage().amountBox.getAttribute("validationMessage");
        String expectedMessage = message;

        Assert.assertEquals(actualMessage, expectedMessage);
    }

    @Then("the user should get {string} from Date input box")
    public void the_user_should_get_from_Date_input_box(String message) {
        String actualMessage = new PayBillsPage().dateBox.getAttribute("validationMessage");
        String expectedMessage = message;

        Assert.assertEquals(actualMessage, expectedMessage);
    }

    @Then("the user should not see the {string} message")
    public void the_user_should_not_see_the_message(String message) {
        PayBillsPage payBillsPage = new PayBillsPage();
        String actualMessage;
        try {
            actualMessage = payBillsPage.paymentMessage.getText();
        } catch (NoSuchElementException e) {
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
        String box = new PayBillsPage().amountBox.getAttribute("value");
        System.out.println("box = " + box);
        Assert.assertTrue(box.isEmpty());
    }

    @Then("Date input box should be empty")
    public void date_input_box_should_be_empty() {
        String box = new PayBillsPage().dateBox.getAttribute("value");
        System.out.println("box = " + box);
        Assert.assertTrue(box.isEmpty());
    }

    @Given("creates new payee using following information")
    public void creates_new_payee_using_following_information(Map<String, String> information) {
        BrowserUtils.waitFor(1);
        PayBillsPage payBillsPage = new PayBillsPage();
        payBillsPage.payeeNameBox.sendKeys(information.get("Payee Name"));
        payBillsPage.payeeAdressBox.sendKeys(information.get("Payee Address"));
        payBillsPage.payeeAccountBox.sendKeys(information.get("Account"));
        payBillsPage.payeeDetailsBox.sendKeys(information.get("Payee Details"));
        payBillsPage.addButton.click();

    }

    @Then("message {string} should be displayed")
    public void message_should_be_displayed(String message) {
        BrowserUtils.waitFor(1);
        PayBillsPage payBillsPage = new PayBillsPage();
        String actualMessage = payBillsPage.addPayeeMessage.getText();
        String expectedMessage = message;

        Assert.assertEquals(actualMessage, expectedMessage);
    }

    @Then("following currencies should be available")
    public void following_currencies_should_be_available(List<String> currency) {
        BrowserUtils.waitFor(1);
        PayBillsPage payBillsPage = new PayBillsPage();
        List<WebElement> options = payBillsPage.CurrencyDropdown().getOptions();
        List<String> optionsText = BrowserUtils.getElementsText(options);

        Assert.assertTrue(optionsText.containsAll(currency));
    }

    @When("user tries to calculate cost without selecting a currency")
    public void user_tries_to_calculate_cost_without_selecting_a_currency() {
        BrowserUtils.waitFor(1);
        PayBillsPage payBillsPage = new PayBillsPage();
        payBillsPage.calculateCostsButton.click();
    }

    @Then("error message should be displayed")
    public void error_message_should_be_displayed() {
        Alert alert = Driver.get().switchTo().alert();
        String alertText = alert.getText();
        String ecpectedAlertText = "Please, ensure that you have filled all the required fields with valid values.";

        Assert.assertEquals(alertText,ecpectedAlertText);

        alert.accept();
    }

    @When("user tries to calculate cost without entering a value")
    public void user_tries_to_calculate_cost_without_entering_a_value() {
        BrowserUtils.waitFor(1);
        PayBillsPage payBillsPage = new PayBillsPage();
        payBillsPage.CurrencyDropdown().selectByVisibleText("Australia (dollar)");
        payBillsPage.calculateCostsButton.click();
    }

}
