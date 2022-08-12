@CAOOrder @DEMO
  Feature: CAO Order Page

    @CAOOrder @UIVerify @CAO
    Scenario: To verify CAO Order screen UI and functionality
      Given logged into app
      Then Tap on Orders icon
      And  Click on CAO Orders and verify CAO Order screen UI and functionality
      Then Verified the CAO Order UI

    @CAOOrder @VerifyCAOOrderBadge @CAO
    Scenario: To verify the badge count displayed for CAO Order icon
      Given logged into app
      Then Tap on Orders icon
      And  Click on CAO Orders and verify the badge count displayed for CAO Order icon
      Then Verified the CAO Order Badge Count

    @CAOOrder @VerifyReviewOrder @CAO
    Scenario: To verify review order screen UI and functionality
      Given logged into app
      Then Tap on Orders icon
      And  Click on CAO Orders and verify review order screen UI and functionality
      Then Verified the CAO Order review order screen