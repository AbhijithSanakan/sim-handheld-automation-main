@DeliveryInfo
Feature: Normal Supply

  @Normal @DInfo
  Scenario:  Verify Return DSD Delivery when Delivery/Truck Type is 'Normal' and Destination is 'Supply'
    Given In dashboard page
    Then Click Receive & return
    And Click on Return DSD
    Then Click Credit Not Available
    Then Verified

  @Enclosure @DInfo
  Scenario:  Verify Return DSD Delivery when Delivery/Truck Type is 'Enclosure' and Destination is 'Inventory'
    Given In dashboard page
    Then Click Receive & return
    And Click on Return DSD
    Then Click Credit Not Available for Enclosure
    Then Verified

  @EnclosureSupply @DInfo
  Scenario:  Verify Return DSD Delivery when Delivery/Truck Type is 'Enclosure' and Destination is 'Supply'
    Given In dashboard page
    Then Click Receive & return
    And Click on Return DSD
    Then Click Credit Not Available for Enclosure Supply
    Then Verified

  @CourierInventory @DInfo
  Scenario: Verify Return DSD Delivery when Delivery/Truck Type is 'Courier' and Destination is 'Inventory'
    Given In dashboard page
    Then Click Receive & return
    And Click on Return DSD
    Then Click Credit Not Available for Courier Inventory
    Then Verified

  @CourierSupply @DInfo
  Scenario: Verify Return DSD Delivery when Delivery/Truck Type is 'Courier' and Destination is 'Supply'
    Given In dashboard page
    Then Click Receive & return
    And Click on Return DSD
    Then Click Credit Not Available for Courier Supply
    Then Verified