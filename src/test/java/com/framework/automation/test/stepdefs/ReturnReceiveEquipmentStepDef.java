package com.framework.automation.test.stepdefs;

import com.framework.automation.test.pages.ReturnReceiveEquipmentPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import java.io.IOException;
import java.net.MalformedURLException;

public class ReturnReceiveEquipmentStepDef extends ReturnReceiveEquipmentPage {
    public ReturnReceiveEquipmentStepDef() throws IOException, InterruptedException {
    }

    @Given("Admin is logged in app dashboard page")
    public void admin_is_logged_in_app_dashboard_page() throws InterruptedException {
        System.out.println("Logged In");
        Thread.sleep(8000);
    }

    @Then("Tap on Receive & Return icon from dashboard")
    public void tap_on_Receive_Return_icon_from_dashboard() throws InterruptedException {
        System.out.println("Clicking Receive & Return");
        Thread.sleep(3000);
        ReturnReceiveEquipmentPage.ReturnReceiveClick();
    }

    @Then("Click on Receive Equipment and verify view mode flow")
    public void click_on_Receive_Equipment_and_verify_view_mode_flow() throws InterruptedException {
        ReturnReceiveEquipmentPage.VerifyView();

    }

    @And("Click on Return Equipment and verify functionality for Store destination")
    public void clickOnReturnEquipmentAndVerifyFunctionalityForStoreDestination() throws InterruptedException {
        ReturnReceiveEquipmentPage.EquipStore();
    }

    @And("Click on Return Equipment and verify Equipment Return screen contents and functionality")
    public void clickOnReturnEquipmentAndVerifyEquipmentReturnScreenContentsAndFunctionality() throws InterruptedException {
        ReturnReceiveEquipmentPage.VerifyReturnEquip();
    }

    @Then("Verified the view mode flow")
    public void verifiedTheViewModeFlow() {
        System.out.println("Verified");
    }

}
