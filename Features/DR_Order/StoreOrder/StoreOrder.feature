@StoreOrder
Feature:  Store Order Page

  @StoreOrderPlace
  Scenario: To validate whether an order can be placed for a product
    Given Admin is logged into the app dashboard page
    Then Tap on Order icon from dashboard
    And Click on Store Order and validate whether an order can be placed for a product
    Then Validated

  @StoreOrderScreenUiVerify
  Scenario: to validate the Store order screen UI and its functionality.
    Given Admin is logged into the app dashboard page
    Then Tap on Order icon from dashboard
    And Click on Store Order and validate the Store order screen UI and its functionality
    Then Validated