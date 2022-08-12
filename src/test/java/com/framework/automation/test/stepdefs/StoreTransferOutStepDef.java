package com.framework.automation.test.stepdefs;

import com.framework.automation.test.pages.StoreTransferOutPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import java.io.IOException;
import java.net.MalformedURLException;

public class StoreTransferOutStepDef extends StoreTransferOutPage {

    public StoreTransferOutStepDef() throws IOException, InterruptedException {
    }

    @Given("Logged in to app dashboard")
    public void logged_in_to_app_dashboard() throws InterruptedException {
        System.out.println("Logging into App");
        Thread.sleep(4000);
    }

    @Then("Tap on Transfers icon from dashboard")
    public void tap_on_Transfers_icon_from_dashboard() throws InterruptedException {
        StoreTransferOutPage.TransfersClick();
    }

    @Then("Click on Store Transfer Out and verify Scan items screen contents and functionality when doing Store Transfer Out")
    public void click_on_Store_Transfer_Out_and_verify_Scan_items_screen_contents_and_functionality_when_doing_Store_Transfer_Out() throws InterruptedException {
        StoreTransferOutPage.StoreTransferOutClick();
        StoreTransferOutPage.StoreTransferOutScanVerify();
    }

    @And("Click on Store Transfer Out and verify Store Transfer Out when source is Inventory")
    public void clickOnStoreTransferOutAndVerifyStoreTransferOutWhenSourceIsInventory() throws InterruptedException {
        StoreTransferOutPage.StoreTransferOutClick();
        StoreTransferOutPage.StoreTransferOutInventory();
    }

    @And("Click on Store Transfer Out and verify Store Transfer Out when source is Supply")
    public void clickOnStoreTransferOutAndVerifyStoreTransferOutWhenSourceIsSupply() throws InterruptedException {
        StoreTransferOutPage.StoreTransferOutClick();
        StoreTransferOutPage.StoreTransferOutSupply();
    }

    @Then("Verified Store Transfer Out")
    public void verified_Store_Transfer_Out() {
        System.out.println("Verified");
    }
}
