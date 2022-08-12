@Review
Feature: Receive DSD Adjust an invoice
  @Demo1
  Scenario:Verify  Receive DSD Flow When Review Button is Clicked
    Given User is Reach Dashboard and Select Receive Invoice Enter in Adjust
    Then  User is Verify the Temperature Page
    When User is Verify Scan Items in Scan Page
    And User Enter is Grand Total With GST in DSD Delivery Page
    Then User is Verify Summary page