package com.framework.automation.test.stepdefs;

import com.framework.automation.test.pages.CAOOrderPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import java.io.IOException;

public class CAOOrderStepDef extends CAOOrderPage {
    public CAOOrderStepDef() throws IOException, InterruptedException {
    }

    @Given("logged into app")
    public void loggedIntoApp() throws InterruptedException {
        System.out.println("Logging in");
        Thread.sleep(8000);
    }

    @Then("Tap on Orders icon")
    public void tap_on_Orders_icon() throws InterruptedException {
        CAOOrderPage.orderClick();
    }

    @Then("Click on CAO Orders and verify CAO Order screen UI and functionality")
    public void click_on_CAO_Orders_and_verify_CAO_Order_screen_UI_and_functionality() throws InterruptedException {
        CAOOrderPage.CAOOrderClick();
        CAOOrderPage.CAOOrderUiVerify();
    }

    @And("Click on CAO Orders and verify the badge count displayed for CAO Order icon")
    public void clickOnCAOOrdersAndVerifyTheBadgeCountDisplayedForCAOOrderIcon() {
        CAOOrderPage.CAOOrderBadgeVerify();
    }

    @And("Click on CAO Orders and verify review order screen UI and functionality")
    public void clickOnCAOOrdersAndVerifyReviewOrderScreenUIAndFunctionality() throws IOException, InterruptedException {
        CAOOrderPage.CAOOrderClick();
        CAOOrderPage.CAOOrderReviewOrderVerify();
    }

    @Then("Verified the CAO Order UI")
    public void verified_the_CAO_Order_UI() {
        System.out.println("Verified");
    }

    @Then("Verified the CAO Order Badge Count")
    public void verifiedTheCAOOrderBadgeCount() {
        System.out.println("Verified Badge Count");
    }

    @Then("Verified the CAO Order review order screen")
    public void verifiedTheCAOOrderReviewOrderScreen() {
        System.out.println("Verified CAO Order review order screen");
    }

}
