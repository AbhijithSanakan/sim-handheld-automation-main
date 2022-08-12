@Test
Feature:The product code is scanned successfully, The details are retrieved onto the recent screen
  @OrderOptionsRecent
  @Demo1
  Scenario:To Check the product code is scanned successfully then details are retrieved onto the recent screen
    Given User Verify Login and Going in the Scan Item Page Screen
    Then User Check There is Item Details in Recent Page
    Then User Verify all in Item Recent Details Page