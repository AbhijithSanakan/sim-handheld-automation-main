@DepartmentActuals
  Feature: Deparment Actuals Page

    @DepActuals @DepActualsFunctionality @all
    Scenario: To verify Department Actuals app is working
      Given Logged in app dashboard
      Then Tap on Department Actuals
      And  Click on review actuals and verify department actuals app is working
      Then Verified the deparment actuals functionality

    @DepActuals @BackAndDiscardFunctionality @all
    Scenario: To verify Back and Discard button functionality on Daily Totals screen
      Given Logged in app dashboard
      Then Tap on Department Actuals
      And  Click on review actuals and verify Back and Discard button functionality on Daily Totals screen
      Then Verified the back and discard button functionality