Feature: Receive DSD Review an invoice
  @Review
  @All
  Scenario:Verify The Receive DSD Flow When Review Button is Clicked
    Given Admin Reach Dashboard and Select Receive Invoice
    Then  User Verify the Temperature Page
    When User Verify Scan Items in Scan Page
    And User Enter Grand Total With GST in DSD Delivery Page
    Then User Verify Summary page