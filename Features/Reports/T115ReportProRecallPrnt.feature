Feature:Print Product Recall Report generation via printer

  @ReportProRecall
  @All
  Scenario:Reports To verify Print Product Recall Report generation via printer
    Given User Verify Login page and Reach To Select Hamburger Icon
    Then User Check Verify in Report and select Product Recall
    Then User in Report Discard
    When Click on Send button