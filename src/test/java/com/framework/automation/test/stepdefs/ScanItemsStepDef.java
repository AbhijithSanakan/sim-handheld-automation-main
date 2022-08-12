package com.framework.automation.test.stepdefs;

import com.framework.automation.test.pages.ReturnReceivePage;
import io.cucumber.java.en.Then;

public class ScanItemsStepDef {
    @Then("Click Credit Not Available for Scan Items")
    public void click_Credit_Not_Available_for_Scan_Items() throws InterruptedException {
        ReturnReceivePage.ScanItems();
    }

}
