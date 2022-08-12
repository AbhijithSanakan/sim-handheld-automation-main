@DeliNoteamLow
Feature:Order Guide flow when user chooses Yes from Last Order Worked message pop-up
  @All
  Scenario:Looking of Order Guide to Deli Items when user chooses No from Last Order Worked message pop-up
    Given Verify on Login page click Order Guide Page Items
    Then User in Contents Present Click No Check at Deli Items Page
    Then Check the Bk all in Deli Items Page
    When Check in Back to Order Guide Deli Page press Send