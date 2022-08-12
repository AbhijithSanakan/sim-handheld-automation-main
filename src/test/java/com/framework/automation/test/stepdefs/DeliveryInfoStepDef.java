package com.framework.automation.test.stepdefs;

import com.framework.automation.test.pages.ReturnReceivePage;
import io.cucumber.java.en.Then;

import java.io.IOException;

public class DeliveryInfoStepDef {

    public DeliveryInfoStepDef() throws IOException, InterruptedException {
    }

    @Then("Click Credit Not Available")
    public void click_Credit_Not_Available() throws InterruptedException {
        ReturnReceivePage.DeliveryInfo();
    }

    @Then("Click Credit Not Available for Enclosure")
    public void clickCreditNotAvailableForEnclosure() throws InterruptedException {
        ReturnReceivePage.EnclosureInventory();
    }

    @Then("Click Credit Not Available for Enclosure Supply")
    public void clickCreditNotAvailableForEnclosureSupply() throws InterruptedException {
        ReturnReceivePage.EnclosureSupply();
    }

    @Then("Click Credit Not Available for Courier Inventory")
    public void clickCreditNotAvailableForCourierInventory() throws InterruptedException {
        ReturnReceivePage.CourierInventory();
    }

    @Then("Click Credit Not Available for Courier Supply")
    public void clickCreditNotAvailableForCourierSupply() throws InterruptedException {
        ReturnReceivePage.CourierSupply();
    }

    @Then("Verified")
    public void verified() {
        System.out.println("Verified");
    }
}
