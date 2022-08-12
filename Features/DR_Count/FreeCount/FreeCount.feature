@FreeCount
  Feature: FreeCount Page

    @FreeCount @NoBackup
    Scenario: To verify the Free Count flow when there is no backup available.
      Given Logged in to app
      Then Tap on Count icon from app dashboard
      And Click on Free Count and verify the Free Count flow when there is no backup available
      Then Verified the Free Count flow

    @FreeCount @Backup
    Scenario: To verify the Free Count flow when there is backup available
      Given Logged in to app
      Then Tap on Count icon from app dashboard
      And Click on Free Count and verify the Free Count flow when there is backup available
      Then Verified the Free Count flow

    @FreeCount @BackupCancelled
    Scenario: To verify the Free Count flow when backup is cancelled
      Given Logged in to app
      Then Tap on Count icon from app dashboard
      And Click on Free Count and verify the Free Count flow when backup is cancelled
      Then Verified the Free Count flow

    @FreeCount @MinimumShelfInventory
    Scenario: To verify if Minimum Shelf Inventory functionality is working
      Given Logged in to app
      Then Tap on Count icon from app dashboard
      And Click on Free Count and verify if Minimum Shelf Inventory functionality is working
      Then Verified the Free Count flow