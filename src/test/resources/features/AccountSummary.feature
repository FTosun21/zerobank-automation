Feature: Account Summary Page

  Scenario: Account Summary page title
    Given the user logged in with valid credentials
    Then page title should be "Zero - Account Summary"

  Scenario: Account types
    Given the user logged in with valid credentials
    Then the user should see following account types
      | Cash Accounts | Investment Accounts | Credit Accounts | Loan Accounts |

  Scenario: Credit Account table
    Given the user logged in with valid credentials
    Then the user should see following options under "Credit Account"
      | Account | Credit Card | Balance |
