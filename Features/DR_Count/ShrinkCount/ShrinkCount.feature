@ShrinkCount
  Feature: Shrink Count

    @ShrinkCount
    Scenario: To verify there is a high quantity warning level for Shrink Count
      Given Admin is logged in the app dashboard page
      Then Tap on Count icon from dashboard
      And Click on Shrink Count and verify high quantity warning
      Then Verified the warning