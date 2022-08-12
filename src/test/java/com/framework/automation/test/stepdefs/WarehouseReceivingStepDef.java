package com.framework.automation.test.stepdefs;

import com.framework.automation.test.pages.WarehouseReceivingPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import java.io.IOException;
import java.net.MalformedURLException;

public class WarehouseReceivingStepDef extends WarehouseReceivingPage {
    public WarehouseReceivingStepDef() throws IOException, InterruptedException {
    }

    @Given("Admin is logged in dashboard page")
    public void adminIsLoggedInDashboardPage() throws InterruptedException {
        System.out.println("Admin Logged in");
        Thread.sleep(8000);
    }

    @Then("Tap on Receive & Return icon")
    public void tapOnReceiveReturnIcon() throws InterruptedException {
        WarehouseReceivingPage.RecvRetClick();
    }

    @Then("Click on warehouse receiving & verify functions and screen contents")
    public void click_on_warehouse_receiving_verify_functions_and_screen_contents() throws InterruptedException {
        WarehouseReceivingPage.wareHouseRecvClick();
        WarehouseReceivingPage.VerifyScreen();
    }

    @And("Click on warehouse receiving & verify functions and screen contents when no BOL is available")
    public void clickOnWarehouseReceivingVerifyFunctionsAndScreenContentsWhenNoBOLIsAvailable() throws InterruptedException {
        WarehouseReceivingPage.wareHouseRecvClick();
        WarehouseReceivingPage.VerifyNoInvoiceScreen();

    }

    @And("Click on warehouse receiving & verify break seal screen contents")
    public void clickOnWarehouseReceivingVerifyBreakSealScreenContents() throws InterruptedException {
        WarehouseReceivingPage.wareHouseRecvClick();
        WarehouseReceivingPage.BreakSeal();
    }

    @And("Click on warehouse receiving & verify No warehouse damaged message")
    public void clickOnWarehouseReceivingVerifyNoWarehouseDamagedMessage() throws InterruptedException {
        WarehouseReceivingPage.wareHouseRecvClick();
        WarehouseReceivingPage.NoDamaged();
    }

    @And("Click on warehouse receiving & verify Reseal screen UI contents and functionality")
    public void clickOnWarehouseReceivingVerifyResealScreenUIContentsAndFunctionality() throws InterruptedException {
        WarehouseReceivingPage.wareHouseRecvClick();
        WarehouseReceivingPage.reSeal();
    }

    @And("Click on warehouse receiving & verify Warehouse Receiving when BOL is entered manually")
    public void clickOnWarehouseReceivingVerifyWarehouseReceivingWhenBOLIsEnteredManually() throws InterruptedException {
        WarehouseReceivingPage.wareHouseRecvClick();
        WarehouseReceivingPage.ManualBol();
    }

    @Then("Finish")
    public void finish() {
        System.out.println("Validated");
    }
}
