@CycleCount
  Feature: Cycle Count

    @CycleCount @CountNotStarted
    Scenario: To verify Cycle Count flow when a Cycle Count is not started yet
      Given logged into the app
      Then Tap on Count icon from dashboard
      And Click on Cycle Count and verify Cycle Count flow when a Cycle Count is not started yet
      Then Verified the count flow

    @CycleCount @FinalizedCheckboxChecked
    Scenario: To verify Cycle Count flow when Finalized Counts checkbox is checked
      Given logged into the app
      Then Tap on Count icon from dashboard
      And Click on Cycle Count and verify Cycle Count flow when Finalized Counts checkbox is checked
      Then Verified the count flow

    @CycleCount @ScanItemScreen
    Scenario: To verify Cycle Count Scan items screen and its various features
      Given logged into the app
      Then Tap on Count icon from dashboard
      And Click on Cycle Count and verify Scan items screen and its various features
      Then Verified the count flow

    @CycleCountBadge
    Scenario: To verify Cycle Count icon badge count
      Given logged into the app
      Then Tap on Count icon from dashboard
      And Click on Cycle Count and verify Cycle Count icon badge count
      Then Verified the count flow