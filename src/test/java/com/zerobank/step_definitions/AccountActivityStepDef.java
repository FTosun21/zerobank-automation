package com.zerobank.step_definitions;

import com.zerobank.pages.AccountActivityPage;
import com.zerobank.pages.AccountSummaryPage;
import com.zerobank.pages.DashboardPage;
import com.zerobank.pages.LoginPage;
import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.ConfigurationReader;
import com.zerobank.utilities.Driver;
import io.cucumber.java.bs.A;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class AccountActivityStepDef {

    @When("the user navigates to {string}")
    public void the_user_navigates_to(String module) {
        DashboardPage dashboardPage = new DashboardPage();
        dashboardPage.navigateToModule(module);
    }

    @When("the user clicks on {string} link on the Account Summary page")
    public void the_user_clicks_on_link_on_the_Account_Summary_page(String link) {
        new AccountSummaryPage().navigateToLinkElement(link);
    }

    @Then("Account dropdown option should be {string}")
    public void account_dropdown_option_should_be(String Option) {
        AccountActivityPage accountActivityPage = new AccountActivityPage();
        String selectedOption = accountActivityPage.accountDropdownList().getFirstSelectedOption().getText();
        String expectedOption = Option;

        Assert.assertEquals(expectedOption,selectedOption);
    }

    @Then("Account dropdown should have following options")
    public void account_dropdown_should_have_following_options(List<String> dropdownOptions) {
       AccountActivityPage accountActivityPage = new AccountActivityPage();
       List<WebElement> options = accountActivityPage.accountDropdownList().getOptions();
       List<String> actualOptionList = BrowserUtils.getElementsText(options);
       List<String> expectedOptionList = dropdownOptions;

       Assert.assertEquals(expectedOptionList,actualOptionList);
    }

    @Then("transactions table headers should be as following")
    public void transactions_table_headers_should_be_as_following(List<String> headers) {
        BrowserUtils.waitFor(1);
        AccountActivityPage accountActivityPage = new AccountActivityPage();
        List<WebElement> options = accountActivityPage.transactionsHeaders;
        List<String> actualHeaderList = BrowserUtils.getElementsText(options);
        List<String> expectedHeaderList = headers;

        Assert.assertEquals(expectedHeaderList,actualHeaderList);
    }

    @Given("the user is logged in")
    public void the_user_is_logged_in() {
        String url = ConfigurationReader.get("url");
        Driver.get().get(url);
        LoginPage loginPage = new LoginPage();
        String username = ConfigurationReader.get("username");
        String password = ConfigurationReader.get("password");
        loginPage.login(username,password);

    }

    @Then("the Account Activity page should be displayed")
    public void the_Account_Activity_page_should_be_displayed() {
        String expectedTitle = "Zero - Account Activity";
        String actualTitle = Driver.get().getTitle();

        Assert.assertEquals(expectedTitle,actualTitle);
    }

    @Then("Account drop down should have {string} selected")
    public void account_drop_down_should_have_selected(String Option) {
        AccountActivityPage accountActivityPage = new AccountActivityPage();
        String selectedOption = accountActivityPage.accountDropdownList().getFirstSelectedOption().getText();
        String expectedOption = Option;

        Assert.assertEquals(expectedOption,selectedOption);
    }

    @Given("the user accesses the {string} tab")
    public void the_user_accesses_the_tab(String tab) {
        new AccountActivityPage().navigateToTab(tab);
    }

    @When("the user enters date range from {string} to {string}")
    public void the_user_enters_date_range_from_to(String date1, String date2) {
        BrowserUtils.waitFor(1);
        AccountActivityPage accountActivityPage = new AccountActivityPage();
        accountActivityPage.fromDate.sendKeys(date1);
        accountActivityPage.toDate.sendKeys(date2);
    }

    @When("clicks search")
    public void clicks_search() {
        new AccountActivityPage().findButton.click();
    }

    @Then("results table should only show transactions dates between {string} to {string}")
    public void results_table_should_only_show_transactions_dates_between_to(String date1, String date2) throws ParseException {
        BrowserUtils.waitFor(1);

        SimpleDateFormat formatter1 = new SimpleDateFormat("yyyy-mm-dd");
        Date ndate1 = formatter1.parse(date1);
        Date ndate2 = formatter1.parse(date2);

        List<String> actualDateList = BrowserUtils.getElementsText(new AccountActivityPage().dateColumnList);
        System.out.println("actualDateList = " + actualDateList);
        List<Date> actualDates = new ArrayList<>();
        for (String dates : actualDateList) {
            Date ad = formatter1.parse(dates);
            actualDates.add(ad);
        }

        int counter = 0;
        for(int i=0; i<actualDates.size(); i++){
            if(ndate1.compareTo(actualDates.get(i))<=0 && ndate2.compareTo(actualDates.get(i))>=0){
                counter++;
            }
        }

        boolean flag = false;
        if(counter==actualDates.size()){
            flag =true;
        }

        Assert.assertTrue(flag);

        /*List<String> actualDateList = BrowserUtils.getElementsText(new AccountActivityPage().dateColumnList);
        System.out.println("actualDateList = " + actualDateList);

        int fromDate = Integer.parseInt(date1.replace("-",""));
        int toDate = Integer.parseInt(date2.replace("-",""));

        System.out.println("fromDate = " + fromDate);
        System.out.println("toDate = " + toDate);

        List<Integer> newList = new ArrayList<>();
        for(String actualDate : actualDateList){
           int dates  = Integer.parseInt(actualDate.replace("-",""));
            System.out.println("dates = " + dates);
            newList.add(dates);
        }

        System.out.println("newList = " + newList);

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for(int i=0; i<newList.size(); i++){
            if(newList.get(i)>max){
                max = newList.get(i);
            }
            if(newList.get(i)<min){
                min = newList.get(i);
            }
        }

        System.out.println("min = " + min);
        System.out.println("max = " + max);

        Assert.assertTrue(fromDate<max && fromDate>min && toDate<max && toDate>min);
*/
    }

    @Then("the results should be sorted by most recent date")
    public void the_results_should_be_sorted_by_most_recent_date() {
        BrowserUtils.waitFor(1);
        List<String> actualDateList = BrowserUtils.getElementsText(new AccountActivityPage().dateColumnList);
        System.out.println("actualDateList = " + actualDateList);

        List<Integer> newList = new ArrayList<>();
        for(String actualDate : actualDateList){
            int dates  = Integer.parseInt(actualDate.replace("-",""));
            System.out.println("dates = " + dates);
            newList.add(dates);
        }

        Collections.sort(newList);
        System.out.println("newList = " + newList);

        Collections.reverse(newList);
        System.out.println("newList = " + newList);

    }

    @Then("the results table should only not contain transactions dated “{int}{int}{int}”")
    public void the_results_table_should_only_not_contain_transactions_dated(Integer int1, Integer int2, Integer int3) {
        // Write code here that turns the phrase above into concrete actions
        throw new cucumber.api.PendingException();
    }


}
