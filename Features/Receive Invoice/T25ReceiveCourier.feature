Feature:Destination Courier Inventory
  @Courier
  @All
  Scenario: User Verify Receive DSD Check when Delivery/Truck Type is 'Courier' and Destination is 'Inventory'
    Given User Going from Dashboard to Temperature Screen
    Then User Verify Scan Items Then  Go to DSD Delivery Page
    Then User Verify Comments Page and Summery Page