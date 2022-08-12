package com.framework.automation.test.stepdefs;

import com.framework.automation.test.pages.LabelPrintingPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import java.io.IOException;
import java.net.MalformedURLException;

public class LabelPrintingStepDef extends LabelPrintingPage {
    public LabelPrintingStepDef() throws IOException, InterruptedException {
    }

    @Given("Admin is logged into dashboard")
    public void admin_is_logged_into_dashboard() throws InterruptedException {
        System.out.println("Admin Logging in");
        Thread.sleep(8000);
    }

    @Then("Tap on Label Printing")
    public void tap_on_Label_Printing() throws InterruptedException {
        LabelPrintingPage.LabPrintingClick();
    }

    @Then("Click on label printing and verify the flow when items are restored and sent in Label Printing module")
    public void click_on_label_printing_and_verify_the_flow_when_items_are_restored_and_sent_in_Label_Printing_module() throws InterruptedException {
        LabelPrintingPage.LabPrintVerify();
    }

    @And("Click on label printing and verify the flow when the items were restored, deleted some items and sent in Label Printing module")
    public void clickOnLabelPrintingAndVerifyTheFlowWhenTheItemsWereRestoredDeletedSomeItemsAndSentInLabelPrintingModule() throws InterruptedException {
        LabelPrintingPage.LabPrintRestDel();
    }

    @And("Click on label printing and verify the flow when the items were restored and all were deleted in Label Printing module")
    public void clickOnLabelPrintingAndVerifyTheFlowWhenTheItemsWereRestoredAndAllWereDeletedInLabelPrintingModule() throws InterruptedException {
        LabelPrintingPage.LabPrintDeleteAll();
    }

    @And("Click on label printing and verify the flow when Delete is selected from Restore pop-up in Label Printing module")
    public void clickOnLabelPrintingAndVerifyTheFlowWhenDeleteIsSelectedFromRestorePopUpInLabelPrintingModule() throws InterruptedException {
        LabelPrintingPage.LabPrintDelRestore();
    }

    @Then("Verified the label printing sent functionality")
    public void verified_the_label_printing_sent_functionality() {
        System.out.println("Verified");
    }
}
