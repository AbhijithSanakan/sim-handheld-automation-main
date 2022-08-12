@StoreTransferOut
Feature: Store Transfer Out Page

  @STO @STOUi
  Scenario: To verify Scan items screen contents and functionality when doing Store Transfer Out
    Given Logged in to app dashboard
    Then Tap on Transfers icon from dashboard
    And Click on Store Transfer Out and verify Scan items screen contents and functionality when doing Store Transfer Out
    Then Verified Store Transfer Out

  @STO @STOInventory
  Scenario: To verify Store Transfer Out when source is Inventory
    Given Logged in to app dashboard
    Then Tap on Transfers icon from dashboard
    And Click on Store Transfer Out and verify Store Transfer Out when source is Inventory
    Then Verified Store Transfer Out

  @STO @STOSupply
  Scenario: To verify Store Transfer Out when source is Supply
    Given Logged in to app dashboard
    Then Tap on Transfers icon from dashboard
    And Click on Store Transfer Out and verify Store Transfer Out when source is Supply
    Then Verified Store Transfer Out