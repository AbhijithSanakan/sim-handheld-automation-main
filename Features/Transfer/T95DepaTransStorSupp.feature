@TransStoreSupply
Feature:In the Store DepartmentTransfer  when source is Supply
  @Demo1
  Scenario:Verify the DepartmentTransfer when source is Supply
    Given User reach From Dashboard to DepartmentTransfer
    Then Check in DepartmentTransfer Page update UPC
    And Verify in Some Sections are Available in DepartmentTransfer When Source is Supply
    Then User is DepartmentTransfer Verify Able to Reach Scan Items Page and Send to Trans