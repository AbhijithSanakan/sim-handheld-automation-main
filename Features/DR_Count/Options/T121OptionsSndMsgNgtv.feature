Feature:send message does not work when id is not given
@Demo1
  Scenario:Validate send message doesn't Work When ID is not given
    Given User is Verify Login and Going Options Menu
    Then User going to Click in Send Button with out enter Mail
