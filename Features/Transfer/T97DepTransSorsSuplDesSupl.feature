@TransSorcSupplyDestiSupply
Feature:In the Store DepartmentTransfer  when Source is Supply & Destination is Supply
  @demo
  Scenario:Verify the DepartmentTransfer when source is Supply & Destination is Supply
    Given User Reach From Dashboard to Department Transfer
    Then Check in Department Transfer Page Update Supply
    And Verify in Some Sections are Available in DepartmentTransfer When Source And Destination is Supply
    Then User Able to Reach Scan Items Page and Send to Trans