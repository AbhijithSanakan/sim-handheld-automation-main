@HoleCount
  Feature: Hole Count

    @HoleCount
    Scenario: To verify Hole count flow when holes are counted for few items.
      Given logged into the app
      Then Tap on Count icon from dashboard
      And Click on Hole Count and verify the flow when holes are counted for few items
      Then Verified the count flow

    @HoleCountVerifyUI
    Scenario: To verify Hole count screen UI and functionality
      Given logged into the app
      Then Tap on Count icon from dashboard
      And Click on Hole Count and verify Hole count screen UI and functionality
      Then Verified the count flow

    @HoleCountBadge
    Scenario: To verify Hole Count icon badge count
      Given logged into the app
      Then Tap on Count icon from dashboard
      And Click on Hole Count and verify Hole Count icon badge count
      Then Verified the count flow