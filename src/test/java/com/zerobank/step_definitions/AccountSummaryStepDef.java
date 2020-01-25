package com.zerobank.step_definitions;

import com.zerobank.pages.AccountSummaryPage;
import com.zerobank.pages.LoginPage;
import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.ConfigurationReader;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;

import java.util.List;

public class AccountSummaryStepDef {

    @Given("the user logged in with valid credentials")
    public void the_user_logged_in_with_valid_credentials() {
        Driver.get().get(ConfigurationReader.get("url"));

        LoginPage loginPage = new LoginPage();
        String username = ConfigurationReader.get("username");
        String password = ConfigurationReader.get("password");
        loginPage.login(username,password);
    }

    @Then("page title should be {string}")
    public void page_title_should_be(String title) {
        String expectedTitle = title;
        String actualTitle = Driver.get().getTitle();

        Assert.assertEquals(expectedTitle,actualTitle);
    }

    @Then("the user should see following account types")
    public void the_user_should_see_following_account_types(List<String> accountList) {
        AccountSummaryPage accountSummaryPage = new AccountSummaryPage();
        List<String> actualAccountList = BrowserUtils.getElementsText(accountSummaryPage.accountTypeList);
        List<String> expectedAccountList = accountList;

        Assert.assertEquals(expectedAccountList,actualAccountList);
     }

    @Then("the user should see following options under {string}")
    public void the_user_should_see_following_options_under(String accountType, List<String> creditAccOptions) {
        AccountSummaryPage accountSummaryPage = new AccountSummaryPage();
        List<String> actualCreditAccOpList = BrowserUtils.getElementsText(accountSummaryPage.creditAccountOptionList);
        List<String> expectedCreditAccOpList = creditAccOptions;

        Assert.assertEquals(expectedCreditAccOpList,actualCreditAccOpList);

    }
}
