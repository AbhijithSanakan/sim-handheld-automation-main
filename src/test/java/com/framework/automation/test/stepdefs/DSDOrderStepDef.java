package com.framework.automation.test.stepdefs;

import com.framework.automation.test.pages.DSDOrderPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import java.io.IOException;
import java.net.MalformedURLException;

public class DSDOrderStepDef extends DSDOrderPage {

    public DSDOrderStepDef() throws IOException, InterruptedException {
    }


    @Given("Logged in app")
    public void loggedInApp() throws InterruptedException {
        System.out.println("Admin Loggin In");
        Thread.sleep(5000);
    }

    @Then("Tap on the Order icon from dashboard")
    public void tap_on_the_Order_icon_from_dashboard() throws InterruptedException {
        DSDOrderPage.orderClick();

    }

    @Then("Click on DSD Order and validate whether an order can be placed for a product from a DSD vendor")
    public void click_on_DSD_Order_and_validate_whether_an_order_can_be_placed_for_a_product_from_a_DSD_vendor() throws InterruptedException {
        DSDOrderPage.placeDsdOrder();
    }

    @And("Click on DSD Order and validate whether an order can be placed for a product when minimum condition is not met")
    public void clickOnDSDOrderAndValidateWhetherAnOrderCanBePlacedForAProductWhenMinimumConditionIsNotMet() throws InterruptedException {
        DSDOrderPage.placeDsdOrderNegative();
    }

    @Then("Validated case")
    public void validated_case() {
        System.out.println("Validated");
    }
}
