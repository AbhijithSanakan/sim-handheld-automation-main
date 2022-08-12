@NoCode
Feature: Able to enter/scan an item with no code in Receive DSD flow
  @Demo1
  Scenario: verify user is able to enter/scan an item with no code in Receive DSD flow
    Given User Verify Login and Going To Loading Supplier
    Then Check Able to Edit Delivery Info Page
    Then User Verify  in Record Temperatures Page
    When Check Product able to Add In different Scan Items Page
    And User Verify in DSD Delivery Page Screen
    Then User Verify Summary Page and Submit