@ProduceLow
Feature:Order Guide flow when user chooses 'Cancel' from Low Back Stock Count Message pop-up
  @All
  Scenario:Looking of Order Guide to Produce Items when user chooses 'Cancel' from Low Back Stock Count Message pop-up
    Given Verify in Login and Going To Order Guide Page
    Then Check Contents Present at Produce Items Page
    Then User Verify all in Produce Items Page
    When Verify in Back to Order Guide Page With Send