Feature: Receive DSD Delivery to ScanItems
  @Scan
  @All
  Scenario:USER is Verify Receive DSD Check Scan Items For Delivery
    Given USER  Login and Going To Loading Supplier Screen
    When Verify The Temperatures Page
    Then USER Verify Every Thing is Ok in San Item Screen
