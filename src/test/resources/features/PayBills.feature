Feature: Pay Bills Page

  Scenario: Pay Bills page title
    Given the user logged in with valid credentials
    When the user navigates to "Pay Bills"
    Then page title should be "Zero - Pay Bills"

    Scenario: Successfull payment
      Given the user logged in with valid credentials
      When the user navigates to "Pay Bills"
      And the user writes the amount of "100"
      And the user selects the date
      And the user clicks the Pay button
      Then the user should see the "The payment was successfully submitted." message

  Scenario: No amount input
    Given the user logged in with valid credentials
    When the user navigates to "Pay Bills"
    And the user clicks the Pay button
    Then the user should get "Please fill in this field." from Amount input box

  Scenario: No date input
    Given the user logged in with valid credentials
    When the user navigates to "Pay Bills"
    And the user writes the amount of "100"
    And the user clicks the Pay button
    Then the user should get "Please fill in this field." from Date input box

  Scenario: Invalid amount input
    Given the user logged in with valid credentials
    When the user navigates to "Pay Bills"
    And the user writes the amount of "as/^^^dgs"
    And the user selects the date
    Then Amount input box should be empty

  Scenario: Invalid date input
    Given the user logged in with valid credentials
    When the user navigates to "Pay Bills"
    And the user writes the amount of "100"
    And the user writes date as "adfasğpk"
    And the user clicks the Pay button
    Then Date input box should be empty



  