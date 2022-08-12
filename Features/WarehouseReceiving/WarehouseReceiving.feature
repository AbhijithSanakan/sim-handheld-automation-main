@WarehouseReceiving
Feature: Warehouse Receiving Screen

  @BOL @WRall
  Scenario: verify Select BOL screen UI when BOLs are received
    Given Admin is logged in dashboard page
    Then Tap on Receive & Return icon
    And Click on warehouse receiving & verify functions and screen contents
    Then Finish

  @NoBOL @WRall
  Scenario: verify Select BOL screen UI when no BOLs are received
    Given Admin is logged in dashboard page
    Then Tap on Receive & Return icon
    And Click on warehouse receiving & verify functions and screen contents when no BOL is available
    Then Finish

  @BreakSeal @WRall
  Scenario: Verify Break Seal screen UI contents and functionality.
    Given Admin is logged in dashboard page
    Then Tap on Receive & Return icon
    And Click on warehouse receiving & verify break seal screen contents
    Then Finish

  @NoDamaged @WRall
  Scenario: To verify Warehouse receiving flow when NO is selected from Warehouse Damaged message in Review Items screen
    Given Admin is logged in dashboard page
    Then Tap on Receive & Return icon
    And Click on warehouse receiving & verify No warehouse damaged message
    Then Finish

  @ReSeal @WRall
  Scenario: To verify Reseal screen UI contents and functionality.
    Given Admin is logged in dashboard page
    Then Tap on Receive & Return icon
    And Click on warehouse receiving & verify Reseal screen UI contents and functionality
    Then Finish

  @ManualBOL @WRall
  Scenario: To verify Warehouse Receiving when BOL# is entered manually, it is filtered from the list.
    Given Admin is logged in dashboard page
    Then Tap on Receive & Return icon
    And Click on warehouse receiving & verify Warehouse Receiving when BOL is entered manually
    Then Finish

