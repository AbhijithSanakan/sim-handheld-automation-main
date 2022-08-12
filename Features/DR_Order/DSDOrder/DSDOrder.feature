@DSDOrder
Feature:  DSD Order Page

  @DSDOrder
  Scenario: To validate whether an order can be placed for a product from a DSD vendor
    Given Logged in app
    Then Tap on the Order icon from dashboard
    And Click on DSD Order and validate whether an order can be placed for a product from a DSD vendor
    Then Validated case

  @DSDOrderNegativeCase
  Scenario: To validate whether an order can be placed for a product from a DSD vendor even when minimum condition is not met
    Given Logged in app
    Then Tap on the Order icon from dashboard
    And Click on DSD Order and validate whether an order can be placed for a product when minimum condition is not met
    Then Validated case