package com.zerobank.step_definitions;

import com.zerobank.pages.DashboardPage;
import com.zerobank.pages.LoginPage;
import com.zerobank.utilities.ConfigurationReader;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class LoginStepDef {

    @Given("the user is on the login page")
    public void the_user_is_on_the_login_page() throws InterruptedException {
        String url = ConfigurationReader.get("url");
        Driver.get().get(url);

    }

    @When("the user logs in with valid credentials")
    public void the_user_logs_in_with_valid_credentials() throws InterruptedException {
        LoginPage loginPage = new LoginPage();
        String username = ConfigurationReader.get("username");
        String password = ConfigurationReader.get("password");
        loginPage.login(username,password);

    }

    @Then("{string} page should be displayed")
    public void page_should_be_displayed(String displayedPage) {
        DashboardPage dashboardPage = new DashboardPage();
        String expectedPage = displayedPage;
        String actualPage = dashboardPage.activePage.getText();

        Assert.assertEquals(actualPage,expectedPage);
    }

    @When("the user uses invalid credential")
    public void the_user_uses_invalid_credential() {
        LoginPage loginPage = new LoginPage();
        String username = "smthg";
        String password = "smthng";
        loginPage.login(username,password);
    }

    @Then("the user should not be logged in")
    public void the_user_should_not_be_logged_in() {
        LoginPage loginPage = new LoginPage();
        String expectedUrl = "http://zero.webappsecurity.com/login.html?login_error=true";
        String actualUrl = Driver.get().getCurrentUrl();

        Assert.assertEquals(expectedUrl,actualUrl);
    }

    @When("the credentials are blank")
    public void the_credentials_are_blank() {
        LoginPage loginPage = new LoginPage();
        String username = "";
        String password = "";
        loginPage.login(username,password);
    }

    @Then("Login and or password are wrong message should be displayed")
    public void login_and_or_password_are_wrong_message_should_be_displayed() {
        LoginPage loginPage = new LoginPage();
        String expectedMessage = "Login and/or password are wrong.";
        String actualMessage = loginPage.errorMessage.getText();

        Assert.assertEquals(actualMessage,expectedMessage);
    }

}
