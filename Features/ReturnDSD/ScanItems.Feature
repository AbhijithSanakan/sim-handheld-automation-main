@ScanItems
  Feature: Scan Item Screen

    @Scan
      Scenario: Verify Scan Item screen contents and functionality for Return DSD Products
      Given In dashboard page
      Then Click Receive & return
      And Click on Return DSD
      Then Click Credit Not Available for Scan Items
      Then Verified