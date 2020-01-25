Feature: Account Activity Page

  Scenario: Account Activity page title
    Given the user logged in with valid credentials
    When the user navigates to "Account Activity"
    Then page title should be "Zero - Account Activity"

  Scenario: Account dropdown
    Given the user logged in with valid credentials
    When the user navigates to "Account Activity"
    Then Account dropdown option should be "Savings"


  Scenario: Account dropdown options
    Given the user logged in with valid credentials
    When the user navigates to "Account Activity"
    Then Account dropdown should have following options
      | Savings | Checking | Loan | Credit Card | Brokerage |


  Scenario: Transactions table columns
    Given the user logged in with valid credentials
    When the user navigates to "Account Activity"
    Then transactions table headers should be as following
      | Date | Description | Deposit | Withdrawal |

