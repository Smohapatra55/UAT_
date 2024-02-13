package com.hexure.firelight.stepdefinitions;

import com.hexure.firelight.libraies.EnumsCommon;
import com.hexure.firelight.libraies.FLUtilities;
import com.hexure.firelight.libraies.TestContext;
import com.hexure.firelight.pages.DataEntryPage;
import com.hexure.firelight.libraies.pages_react.DataEntry_ReactPage;
import cucumber.api.java.en.Then;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.*;

public class DataEntry_StepDefinitions extends FLUtilities {
    private WebDriver driver;
    private DataEntryPage onDataEntryPage;
    private TestContext testContext;
    private DataEntry_ReactPage onDataEntryReactPage;
    private static final Logger Log = LogManager.getLogger(DataEntry_StepDefinitions.class);
    public DataEntry_StepDefinitions(TestContext context) {
        testContext = context;
        driver = context.getDriver();
        onDataEntryPage = context.getPageObjectManager().getDataEntryPage();
        onDataEntryReactPage = context.getPageObjectManager().getDataEntryReactPage();
    }

    @Then("User clicks on Next buttons")
    public void userClicksOnNextButtons() {
        syncElement(driver, onDataEntryPage.getBtn_Next(), EnumsCommon.TOCLICKABLE.getText());
        captureScreenshot(driver, testContext, false);
        clickElement(driver, onDataEntryPage.getBtn_Next());
    }

    @Then("User verifies New Application gets created")
    public void User_verifies_New_Application_gets_created() {
        captureScreenshot(driver, testContext, false);
        syncElement(driver, onDataEntryPage.getTxt_NewApplication(), EnumsCommon.TOVISIBLE.getText());
        Assert.assertTrue("Application was not displayed", onDataEntryPage.getTxt_NewApplication().isDisplayed());
    }

    @Then("User Verifies value {string} for field {string}")
    public void userVerifiesValueForField(String value, String fieldName) {
        captureScreenshot(driver, testContext, false);
        Assert.assertEquals("Default value mismatched", value,
                onDataEntryReactPage.getDefaultDropdownValue(driver, fieldName).getText().trim());
    }

}