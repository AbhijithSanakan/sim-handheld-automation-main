@SelectInvoice
Feature: Select Invoice

  Scenario: Verify Receive DSD screen when no invoices are available
    Given Admin is on dashboard page
    Then Click on Receive & return
    And Click on Receive DSD
    Then Verify screen contents
    When All invoice received is displayed
    Then No invoice screen is succesfully verified