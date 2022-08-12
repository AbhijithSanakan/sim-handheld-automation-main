package com.framework.automation.test.stepdefs;

import com.framework.automation.test.pages.ReturnReceivePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import java.io.IOException;

public class ReturnDSDStepDef extends ReturnReceivePage {

    public ReturnDSDStepDef() throws IOException, InterruptedException {
    }

    @Given("In dashboard page")
    public void In_dashboard_page() throws InterruptedException {
       System.out.println("Logged In");
       Thread.sleep(10000);
    }

    @Then("Click Receive & return")
    public void clickReceiveReturn() throws InterruptedException {
        ReturnReceivePage.returnReceiveClick();
    }

    @Then("Click on Return DSD")
    public void click_on_Return_DSD() throws InterruptedException {
        ReturnReceivePage.ReturnClick();

    }
    @Then("Verify the screen contents")
    public void verify_the_screen_contents() {
        ReturnReceivePage.ReturnVerification();
    }

    @Then("Verified Return DSD when no invoices are available")
    public void verifiedReturnDSDWhenNoInvoicesAreAvailable() {
        System.out.println("Verified");
    }

    @Then("Click on CREDIT NOT AVAILABLE and verify the flow")
    public void clickOnCREDITNOTAVAILABLEAndVerifyTheFlow() throws InterruptedException {
        ReturnReceivePage.Pickup();
    }

    @Then("Verified the flow")
    public void verifiedTheFlow() {
        System.out.println("Verified");
    }
}
