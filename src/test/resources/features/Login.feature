Feature: Users should be able to login

  Background:
    Given the user is on the login page

  Scenario: Login as an authorized user
    When the user logs in with valid credentials
    Then "Account Summary" page should be displayed

  Scenario: Login using invalid credentials
    When the user uses invalid credential
    Then the user should not be logged in

  Scenario: Login using blank credentials
    When the credentials are blank
    Then the user should not be logged in

    Scenario: Get error message for invalid credentials
      When the user uses invalid credential
      Then Login and or password are wrong message should be displayed




