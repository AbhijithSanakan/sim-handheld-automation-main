@RecallCount
  Feature: Recall Count
    @RecallCount @CountStart
    Scenario: To verify Recall Count flow for a recall not started yet
      Given logged into the app
      Then Tap on Count icon from dashboard
      And Click on Recall Count and verify Recall Count flow for a recall not started yet
      Then Verified the count flow

    @RecallCount @CountContinue
    Scenario: To verify Recall Count flow for a recall that has been submitted earlier
      Given logged into the app
      Then Tap on Count icon from dashboard
      And Click on Recall Count and verify Recall Count flow for a recall that has been submitted earlier
      Then Verified the count flow