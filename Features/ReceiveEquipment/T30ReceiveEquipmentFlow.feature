@Flow
Feature: To Verify Receive Equipment Flow
  @All
  Scenario:Verify the Receive DSD
    Given User reach Dashboard to ReceiveEquipment
    Then Select Receive invoice to Reach Comment Page
    And Verify Some Sections are Available in Summary Page
    Then User is Verify all Final Transaction Done
