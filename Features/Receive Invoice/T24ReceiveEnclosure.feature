Feature:Delivery Enclosure Inventory
  @Enclosure
  @All
  Scenario: Verify Receive DSD Check when Delivery/Truck Type is 'Enclosure' and Destination is 'Inventory'
    Given User going from login to Temperature Screen
    Then Verify Scan Items and go to DSD Delivery Page
    Then Verify Comments Page and Summery Page

