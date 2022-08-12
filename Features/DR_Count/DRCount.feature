@DRCount
Feature: Verify Count

  @CountVerify @all
  Scenario: To verify Count module and its various sub-modules
    Given logged in the app dashboard page
    Then Verify Count icon from dashboard
    And Click on Count icon and verify Count module and its various sub-modules
    Then Verified the count
