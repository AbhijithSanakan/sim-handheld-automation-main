package com.framework.automation.test.stepdefs;

import com.framework.automation.test.pages.DRCountPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import java.io.IOException;
import java.net.MalformedURLException;

public class DRCountStepDef extends DRCountPage {

    public DRCountStepDef() throws IOException, InterruptedException {
    }


    @Given("logged into the app")
    public void loggedIntoTheApp() throws InterruptedException {
        System.out.println("Logging in");
        Thread.sleep(8000);
    }

    @Given("Admin is logged in the app dashboard page")
    public void admin_is_logged_in_the_app_dashboard_page() throws InterruptedException {
        System.out.println("Logging in");
        Thread.sleep(8000);
    }

    @Then("Tap on Count icon from dashboard")
    public void tap_on_Count_icon_from_dashboard() throws InterruptedException {
        DRCountPage.countClick();
    }

    @Then("Click on Shrink Count and verify high quantity warning")
    public void click_on_Shrink_Count_and_verify_high_quantity_warning() throws InterruptedException {
        DRCountPage.shrinkVerify();
    }

    @And("Click on Hole Count and verify the flow when holes are counted for few items")
    public void clickOnHoleCountAndVerifyTheFlowWhenHolesAreCountedForFewItems() throws InterruptedException {
        DRCountPage.holeCount();
    }

    @And("Click on Hole Count and verify Hole count screen UI and functionality")
    public void clickOnHoleCountAndVerifyHoleCountScreenUIAndFunctionality() throws InterruptedException {
        DRCountPage.HoleCountScreenVerify();
    }

    @And("Click on Hole Count and verify Hole Count icon badge count")
    public void clickOnHoleCountAndVerifyHoleCountIconBadgeCount() throws InterruptedException {
        DRCountPage.HoleCountBadge();
    }
    
    @And("Click on Inventory Count and verify the print label request functionality")
    public void clickOnInventoryCountAndVerifyThePrintLabelRequestFunctionality() throws InterruptedException {
        DRCountPage.InventoryCountPrinter();
    }

    @And("Click on Inventory Count and validate the inventory count can be updated for front stock of a department")
    public void clickOnInventoryCountAndValidateTheInventoryCountCanBeUpdatedForFrontStockOfADepartment() throws InterruptedException {
        DRCountPage.InventoryFrontStock();
    }

    @And("Click on Inventory Count and verify the flow when user clicks on Finalize button")
    public void clickOnInventoryCountAndVerifyTheFlowWhenUserClicksOnFinalizeButton() throws InterruptedException {
        DRCountPage.InventoryFinalize();
    }

    @And("Click on Inventory Count and validate message is shown when there is no inventory data")
    public void clickOnInventoryCountAndValidateMessageIsShownWhenThereIsNoInventoryData() throws InterruptedException {
        DRCountPage.InventoryNoData();
    }

    @And("Click on Inventory Count and validate message is shown when the system is unable to retrieve inventory data")
    public void clickOnInventoryCountAndValidateMessageIsShownWhenTheSystemIsUnableToRetrieveInventoryData() throws InterruptedException {
        DRCountPage.InventoryUnableRetrieve();
    }

    @And("Click on Cycle Count and verify Cycle Count flow when a Cycle Count is not started yet")
    public void clickOnCycleCountAndVerifyCycleCountFlowWhenACycleCountIsNotStartedYet() throws InterruptedException {
        DRCountPage.CycleCountNotStarted();
    }

    @And("Click on Cycle Count and verify Cycle Count flow when Finalized Counts checkbox is checked")
    public void clickOnCycleCountAndVerifyCycleCountFlowWhenFinalizedCountsCheckboxIsChecked() throws InterruptedException {
        DRCountPage.cycleCountFinalizedCheckbox();
    }

    @And("Click on Cycle Count and verify Scan items screen and its various features")
    public void clickOnCycleCountAndVerifyScanItemsScreenAndItsVariousFeatures() throws InterruptedException {
        DRCountPage.cycleCountScanItemScreen();
    }

    @And("Click on Cycle Count and verify Cycle Count icon badge count")
    public void clickOnCycleCountAndVerifyCycleCountIconBadgeCount() throws InterruptedException {
        DRCountPage.CycleCountBadgeCount();
    }

    @And("Click on Recall Count and verify Recall Count flow for a recall not started yet")
    public void clickOnRecallCountAndVerifyRecallCountFlowForARecallNotStartedYet() throws InterruptedException {
        DRCountPage.RecallCountStart();
    }

    @And("Click on Recall Count and verify Recall Count flow for a recall that has been submitted earlier")
    public void clickOnRecallCountAndVerifyRecallCountFlowForARecallThatHasBeenSubmittedEarlier() throws InterruptedException {
        DRCountPage.RecallCountContinue();
    }

    @Then("Verified the count flow")
    public void verifiedTheCountFlow() {
        System.out.println("Verified");
    }

    @Then("Verified the warning")
    public void verified_the_warning() {
        System.out.println("Verified");
    }
}
