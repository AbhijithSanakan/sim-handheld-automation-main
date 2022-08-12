Feature:The product code is scanned unsuccessfully, The Error are retrieved onto the Popup in screen
  @OrderOptionsWrong
  @Demo1
  Scenario: Check the Random code is scanned successfully then details are retrieved onto the Popup screen
    Given User Verify Login and Going To Scan Item Page
    Then User Check There is Error Pop up Page
