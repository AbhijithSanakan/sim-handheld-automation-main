@InventoryCount
  Feature: Inventory Count

    @InventoryFrontStock @Inv @DEMO
    Scenario: To validate the inventory count can be updated for front stock of a department
      Given logged into the app
      Then Tap on Count icon from dashboard
      And Click on Inventory Count and validate the inventory count can be updated for front stock of a department
      Then Verified the count flow

    @InventoryFinalize @Inv @DEMO
    Scenario: To verify the flow when user clicks on Finalize button
      Given logged into the app
      Then Tap on Count icon from dashboard
      And Click on Inventory Count and verify the flow when user clicks on Finalize button
      Then Verified the count flow

    @InventoryNoData @Inv @DEMO
    Scenario: To validate message is shown when there is no inventory data
      Given logged into the app
      Then Tap on Count icon from dashboard
      And Click on Inventory Count and validate message is shown when there is no inventory data
      Then Verified the count flow

    @InventoryUnableRetrieve @Inv
    Scenario: To validate message is shown when the system is unable to retrieve inventory data
      Given logged into the app
      Then Tap on Count icon from dashboard
      And Click on Inventory Count and validate message is shown when the system is unable to retrieve inventory data
      Then Verified the count flow

    @InventoryCountPrinter @Inv
    Scenario: To verify the print label request functionality
      Given logged into the app
      Then Tap on Count icon from dashboard
      And Click on Inventory Count and verify the print label request functionality
      Then Verified the count flow