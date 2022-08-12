package com.framework.automation.test.stepdefs;

import com.framework.automation.test.pages.FreeCountPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import java.io.IOException;
import java.net.MalformedURLException;

public class FreeCountStepDef extends FreeCountPage {
    public FreeCountStepDef() throws IOException, InterruptedException {
    }

    @Given("Logged in to app")
    public void logged_in_to_app() throws InterruptedException {
        System.out.println("Logging into App");
        Thread.sleep(4000);
    }

    @Then("Tap on Count icon from app dashboard")
    public void tap_on_Count_icon_from_app_dashboard() throws InterruptedException {
        FreeCountPage.countClick();
    }

    @Then("Click on Free Count and verify the Free Count flow when there is no backup available")
    public void click_on_Free_Count_and_verify_the_Free_Count_flow_when_there_is_no_backup_available() throws InterruptedException {
        FreeCountPage.FreeCountClick();
        FreeCountPage.FreeCountNoBackup();
    }

    @And("Click on Free Count and verify the Free Count flow when there is backup available")
    public void clickOnFreeCountAndVerifyTheFreeCountFlowWhenThereIsBackupAvailable() throws InterruptedException {
        FreeCountPage.FreeCountClick();
        FreeCountPage.FreeCountBackup();
    }

    @And("Click on Free Count and verify the Free Count flow when backup is cancelled")
    public void clickOnFreeCountAndVerifyTheFreeCountFlowWhenBackupIsCancelled() throws InterruptedException {
        FreeCountPage.FreeCountClick();
        FreeCountPage.FreeCountCancelled();
    }

    @And("Click on Free Count and verify if Minimum Shelf Inventory functionality is working")
    public void clickOnFreeCountAndVerifyIfMinimumShelfInventoryFunctionalityIsWorking() throws InterruptedException {
        FreeCountPage.FreeCountClick();
        FreeCountPage.FreeCountMinimumShelfInventory();
    }

    @Then("Verified the Free Count flow")
    public void verified_the_Free_Count_flow() {
        System.out.println("Verified");
    }
}
