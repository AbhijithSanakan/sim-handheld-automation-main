@ReturnDSD @DEMO
Feature: No Invoice

  @NoInvoice @ReturnDSD
  Scenario: Verify Return DSD screen when no invoices are available
    Given In dashboard page
    Then Click Receive & return
    And Click on Return DSD
    Then Verify the screen contents
    Then Verified Return DSD when no invoices are available

  @CreditNotAvailable @ReturnDSD
  Scenario: Check flow when credit not available is clicked
    Given In dashboard page
    Then Click Receive & return
    And Click on Return DSD
    Then Click on CREDIT NOT AVAILABLE and verify the flow
    Then Verified the flow