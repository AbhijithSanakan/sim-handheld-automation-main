@Test
Feature:The product code is scanned successfully, The details are retrieved onto the basic screen
  @OrderOptions
  @Demo1
  Scenario:To Check the product code is scanned successfully then details are retrieved onto the basic screen
    Given User Verify Login and Going To Scan Item Page Screen
    Then User Check There is Item Details Page
    Then User Verify all in Item Basic Details Page
