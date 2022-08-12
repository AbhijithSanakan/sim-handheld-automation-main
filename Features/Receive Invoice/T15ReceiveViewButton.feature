@View
Feature: Receive View Button
  @DEMO
  Scenario:Verify the Receive DSD flow when View button
    Given User reach Dashboard for further operation
    Then Select invoice and non editable delivery info
    And Verify non editable record temperature
    Then Verify non editable Scan Items
    Then Verify non editable DSD Delivery

