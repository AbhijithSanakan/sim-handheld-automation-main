@DepTransStrsplydesinvent
Feature:In the Store DepartmentTransfer when source is Supply and Destination is Inventory
  @demo
  Scenario:Verify the Department Transfer When source is Supply and Destination is Inventory
    Given User Able to Reach From Dashboard to DepartmentTransfer
    Then Check in Department Transfer Page and Source and Destination
    And Verify in Some Sections are Available in Scan Page When Change Source and Destination
    Then User is Department Transfer Verify Able to Reach Scan Items Page and Send to Transaction