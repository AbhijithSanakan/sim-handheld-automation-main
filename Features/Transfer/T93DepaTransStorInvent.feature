@TransStoreInvent
Feature:In the Department Transfer Out when source is Inventory
  @Demo1
  Scenario:Verify the DepartmentTransfer  when source is Inventory
    Given User is reach From Dashboard to DepartmentTransfer
    Then Check in DepartmentTransfer Out page
    And Verify in Some Sections are Available in DepartmentTransfer Out when source is Inventory
    Then User is Verify Able to Reach Enter Items Page and Send