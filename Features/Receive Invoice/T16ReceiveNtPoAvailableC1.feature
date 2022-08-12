@NotPo
Feature:The Receive DSD flow when Invoice/PO not available button is clicked to manually enter the invoice and it is not already present or found in receivings
 @DEMO
  Scenario:User Verify Receive DSD Check when Delivery For Pick Suppliers
    Given User Verify Login and Going To Loading Supplier Screen
    Then User Check Able to Edit Delivery Info Page
    Then User Verify all in Record Temperatures Page
    When Check Product able to Add In Scan Items Page
    And User Verify in DSD Delivery Page
    Then Verify Summary Page and Submit