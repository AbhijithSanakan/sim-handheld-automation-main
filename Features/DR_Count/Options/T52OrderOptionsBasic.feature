@Test
Feature:The product code is scanned successfully, The details are retrieved onto the order screen
  @OrderOptionsOrder
  @Demo1
  Scenario:To Check the product code is scanned successfully then details are retrieved onto the order screen
    Given User Verify Login and Going To the Scan Item Page Screen
    Then User Check There is Item Details in Order Page
    Then User Verify all in Item Order Details Page
