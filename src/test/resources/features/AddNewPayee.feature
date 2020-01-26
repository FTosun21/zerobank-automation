Feature: Add New Payee under Pay Bills

  Background:
    Given the user logged in with valid credentials
    When the user navigates to "Pay Bills"

  Scenario: Add a new payee
    Given the user accesses the "Add New Payee" tab
    And creates new payee using following information
      |Payee Name | The Law Offices of Hyde, Price & Scharks|
      |Payee Address | 100 Same st, Anytown, USA, 10001 |
      |Account | Checking |
      |Payee Details | XYZ account |
    Then message "The new payee The Law Offices of Hyde, Price & Scharks was successfully created." should be displayed