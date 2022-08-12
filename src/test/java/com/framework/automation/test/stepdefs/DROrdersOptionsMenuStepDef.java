package com.framework.automation.test.stepdefs;

import com.framework.automation.test.pages.DROrdersOptionsMenuPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import java.io.IOException;
import java.net.MalformedURLException;

public class DROrdersOptionsMenuStepDef extends DROrdersOptionsMenuPage {

    public DROrdersOptionsMenuStepDef() throws IOException, InterruptedException {
    }

    @Given("logged into the app dashboard")
    public void loggedIntoTheAppDashboard() throws InterruptedException {
        System.out.println("Admin Logging in");
        Thread.sleep(8000);
    }

    @Then("Tap on Options Menu")
    public void tap_on_Options_Menu() throws InterruptedException {
        DROrdersOptionsMenuPage.OptionsMenuClick();
        System.out.println("Inside Options Menu");
    }

    @Then("Click on Item lookup and validate when the product code is entered manually, the details are retrieved onto the basic screen")
    public void click_on_Item_lookup_and_validate_when_the_product_code_is_entered_manually_the_details_are_retrieved_onto_the_basic_screen() throws InterruptedException {
        DROrdersOptionsMenuPage.ItemLookupClick();
    }

    @And("Click on Item lookup and validate when the wrong product code is entered manually,the details are not retrieved onto the screen")
    public void clickOnItemLookupAndValidateWhenTheWrongProductCodeIsEnteredManuallyTheDetailsAreNotRetrievedOntoTheScreen() throws InterruptedException {
        DROrdersOptionsMenuPage.ItemLookupClickInvalidUpc();
    }

    @And("Click on Item lookup and validate when Order Tab is clicked, the summary of sales, order and locations are displayed")
    public void clickOnItemLookupAndValidateWhenOrderTabIsClickedTheSummaryOfSalesOrderAndLocationsAreDisplayed() throws InterruptedException {
        DROrdersOptionsMenuPage.ItemLookupOrder();
    }

    @And("Click on Item lookup and validate the data on recent quantites are displayed when Recents tab is clicked")
    public void clickOnItemLookupAndValidateTheDataOnRecentQuantitesAreDisplayedWhenRecentsTabIsClicked() throws InterruptedException {
        DROrdersOptionsMenuPage.ItemLookupRecent();
    }

    @And("Click on Item lookup and validate when the sales Tab is clicked, the data for the week is displayed on the screen")
    public void clickOnItemLookupAndValidateWhenTheSalesTabIsClickedTheDataForTheWeekIsDisplayedOnTheScreen() throws IOException, InterruptedException {
        DROrdersOptionsMenuPage.ItemLookupSales();
    }

    @And("Click on Item lookup and validate when the movements Tab is clicked, the data is displayed on the screen")
    public void clickOnItemLookupAndValidateWhenTheMovementsTabIsClickedTheDataIsDisplayedOnTheScreen() throws IOException, InterruptedException {
        DROrdersOptionsMenuPage.ItemLookupMovement();
    }

    @And("Click on Item lookup and validate when the Actions tab is clicked, the link for Shrink, Count and Label are shown and these icons are clickable")
    public void clickOnItemLookupAndValidateWhenTheActionsTabIsClickedTheLinkForShrinkCountAndLabelAreShownAndTheseIconsAreClickable() throws InterruptedException {
        DROrdersOptionsMenuPage.ItemLookupActions();
    }

    @And("Click on Item lookup and validate when Prices button is clicked, offer on the item is displayed")
    public void clickOnItemLookupAndValidateWhenPricesButtonIsClickedOfferOnTheItemIsDisplayed() throws InterruptedException {
        DROrdersOptionsMenuPage.ItemLookupPrices();
    }

    @And("Click on Item lookup and validate the WH driver checkin functionality")
    public void clickOnItemLookupAndValidateTheWHDriverCheckinFunctionality() throws InterruptedException {
        DROrdersOptionsMenuPage.WHDriver();
    }

    @And("Click on Item lookup and validate the WH driver checkin functionality for invalid driver details")
    public void clickOnItemLookupAndValidateTheWHDriverCheckinFunctionalityForInvalidDriverDetails() throws InterruptedException {
        DROrdersOptionsMenuPage.WHDriverInvalidDriver();
    }

    @And("Click on Item lookup and validate the WH driver checkin functionality for cancel button")
    public void clickOnItemLookupAndValidateTheWHDriverCheckinFunctionalityForCancelButton() throws InterruptedException {
        DROrdersOptionsMenuPage.WHDriverCancelButton();
    }

    @Then("Validated the item lookup options menu")
    public void validated_the_item_lookup_options_menu() {
        System.out.println("Validated");
    }
}
