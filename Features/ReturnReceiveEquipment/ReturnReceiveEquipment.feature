@ReturnReceiveEquipment
Feature:  Return & Receive Equipment Page

  @ViewModeFlow @RREqp
  Scenario: To verify Receive .equipment View mode flow
    Given Admin is logged in app dashboard page
    Then Tap on Receive & Return icon from dashboard
    And Click on Receive Equipment and verify view mode flow
    Then Verified the view mode flow

  @EquipmentStore @RREqp
  Scenario: To verify Return Equipment functionality when Equipment Destination is 'Store'
    Given Admin is logged in app dashboard page
    Then Tap on Receive & Return icon from dashboard
    And Click on Return Equipment and verify functionality for Store destination
    Then Verified the view mode flow

  @VerifyReturnEquipment @RREqp
  Scenario: To verify Equipment Return screen contents and functionality
    Given Admin is logged in app dashboard page
    Then Tap on Receive & Return icon from dashboard
    And Click on Return Equipment and verify Equipment Return screen contents and functionality
    Then Verified the view mode flow