package com.framework.automation.test.stepdefs;

import com.framework.automation.test.pages.StoreOrderPage;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import java.io.IOException;
import java.net.MalformedURLException;

public class StoreOrderStepDef extends StoreOrderPage {

    public StoreOrderStepDef() throws IOException, InterruptedException {
    }

    @Given("Admin is logged into the app dashboard page")
    public void admin_is_logged_into_the_app_dashboard_page() {
        System.out.println("Admin Loggin In");
    }

    @Then("Tap on Order icon from dashboard")
    public void tap_on_Order_icon_from_dashboard() throws InterruptedException {
        StoreOrderPage.orderClick();
    }

    @Then("Click on Store Order and validate whether an order can be placed for a product")
    public void click_on_Store_Order_and_validate_whether_an_order_can_be_placed_for_a_product() throws InterruptedException {
        StoreOrderPage.placeStoreOrder();
    }

    @And("Click on Store Order and validate the Store order screen UI and its functionality")
    public void clickOnStoreOrderAndValidateTheStoreOrderScreenUIAndItsFunctionality() throws InterruptedException, IOException {
        StoreOrderPage.storeOrderScreenVerify();
    }

    @Then("Validated")
    public void validated() {
        System.out.println("Validated");
    }
}
