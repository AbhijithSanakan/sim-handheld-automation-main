@NotPoC2
Feature:Verify the Receive DSD flow when user manually enters the invoice number and receiving is already  done for the shipment
  @DEMO
  Scenario:User  Verify Receive DSD Check when Delivery For Pick Suppliers
    Given User is Verify Login and Going To Loading Supplier Screen
    Then User is Check Able to Edit Delivery Info Page
    When Check if Product able to Add In Scan Items Page
    And User is Verify in DSD Delivery Page
    Then Verify is Summary Page and Submit