@LabelPrinting
  Feature: Label Printing Page

    @LabelPrinting
    Scenario: To verify the flow when items are restored and sent in Label Printing module
      Given Admin is logged into dashboard
      Then Tap on Label Printing
      And  Click on label printing and verify the flow when items are restored and sent in Label Printing module
      Then Verified the label printing sent functionality

    @LabelPrinting @RestoreDelete
    Scenario: To verify the flow when the items were restored, deleted some items and sent in Label Printing module
      Given Admin is logged into dashboard
      Then Tap on Label Printing
      And  Click on label printing and verify the flow when the items were restored, deleted some items and sent in Label Printing module
      Then Verified the label printing sent functionality

    @LabelPrinting @DeleteSelected
    Scenario: To verify the flow when the items were restored and all were deleted in Label Printing module
      Given Admin is logged into dashboard
      Then Tap on Label Printing
      And Click on label printing and verify the flow when the items were restored and all were deleted in Label Printing module
      Then Verified the label printing sent functionality

    @LabelPrinting @DeleteRestore
    Scenario: To verify the flow when Delete is selected from Restore pop-up in Label Printing module
      Given Admin is logged into dashboard
      Then Tap on Label Printing
      And Click on label printing and verify the flow when Delete is selected from Restore pop-up in Label Printing module
      Then Verified the label printing sent functionality