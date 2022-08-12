@DROrdersOptionsMenu
Feature: DR Orders Options Menu

  @ItemLookup @ValidUpc
  Scenario: To validate when the product code is entered manually, the details are retrieved onto the basic screen
    Given logged into the app dashboard
    Then Tap on Options Menu
    And Click on Item lookup and validate when the product code is entered manually, the details are retrieved onto the basic screen
    Then Validated the item lookup options menu

  @ItemLookup @InvalidUpc
  Scenario: To validate when the wrong product code is entered manually,the details are not retrieved onto the screen
    Given logged into the app dashboard
    Then Tap on Options Menu
    And Click on Item lookup and validate when the wrong product code is entered manually,the details are not retrieved onto the screen
    Then Validated the item lookup options menu

  @ItemLookup @OrderTab
  Scenario: To validate when Order Tab is clicked, the summary of sales, order and locations are displayed
    Given logged into the app dashboard
    Then Tap on Options Menu
    And Click on Item lookup and validate when Order Tab is clicked, the summary of sales, order and locations are displayed
    Then Validated the item lookup options menu

  @ItemLookup @RecentTab
  Scenario: To validate the data on recent quantites are displayed when Recents tab is clicked
    Given logged into the app dashboard
    Then Tap on Options Menu
    And Click on Item lookup and validate the data on recent quantites are displayed when Recents tab is clicked
    Then Validated the item lookup options menu

  @ItemLookup @SalesTab
  Scenario: To validate when the sales Tab is clicked, the data for the week is displayed on the screen
    Given logged into the app dashboard
    Then Tap on Options Menu
    And Click on Item lookup and validate when the sales Tab is clicked, the data for the week is displayed on the screen
    Then Validated the item lookup options menu

  @ItemLookup @MovementTab
  Scenario: To validate when the movements Tab is clicked, the data is displayed on the screen
    Given logged into the app dashboard
    Then Tap on Options Menu
    And Click on Item lookup and validate when the movements Tab is clicked, the data is displayed on the screen
    Then Validated the item lookup options menu

  @ItemLookup @ActionsTab
  Scenario: To validate when the Actions tab is clicked, the link for Shrink, Count and Label are shown and these icons are clickable
    Given logged into the app dashboard
    Then Tap on Options Menu
    And Click on Item lookup and validate when the Actions tab is clicked, the link for Shrink, Count and Label are shown and these icons are clickable
    Then Validated the item lookup options menu

  @ItemLookup @PricesTab
  Scenario: To validate when Prices button is clicked, offer on the item is displayed
    Given logged into the app dashboard
    Then Tap on Options Menu
    And Click on Item lookup and validate when Prices button is clicked, offer on the item is displayed
    Then Validated the item lookup options menu

  @WHDriver @WHDriverCheckin
  Scenario: To validate the WH driver checkin functionality
    Given logged into the app dashboard
    Then Tap on Options Menu
    And Click on Item lookup and validate the WH driver checkin functionality
    Then Validated the item lookup options menu

  @WHDriver @WHDriverCheckinInvalidDriver
  Scenario: To validate the WH driver checkin functionality for invalid driver details
    Given logged into the app dashboard
    Then Tap on Options Menu
    And Click on Item lookup and validate the WH driver checkin functionality for invalid driver details
    Then Validated the item lookup options menu

  @WHDriver @WHDriverCheckinCancelButton
  Scenario: To validate the WH driver checkin functionality for cancel button
    Given logged into the app dashboard
    Then Tap on Options Menu
    And Click on Item lookup and validate the WH driver checkin functionality for cancel button
    Then Validated the item lookup options menu
