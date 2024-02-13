package com.hexure.firelight.stepdefinitions;

import com.hexure.firelight.libraies.Enums.EnumsJSONProp;
import com.hexure.firelight.libraies.EnumsCommon;
import com.hexure.firelight.libraies.FLException;
import com.hexure.firelight.libraies.FLUtilities;
import com.hexure.firelight.libraies.TestContext;
import com.hexure.firelight.pages.DataEntryPage;
import com.hexure.firelight.libraies.pages_react.DataEntry_ReactPage;
import com.hexure.firelight.pages.HomePage;
import com.hexure.firelight.pages.RCTCompleteFillingAndSigningPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import io.cucumber.datatable.DataTable;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.interactions.Actions;
import com.hexure.firelight.libraies.pages_react.CommonMethods_ReactPage;
import com.hexure.firelight.pages.*;

import org.openqa.selenium.support.ui.WebDriverWait;

import org.openqa.selenium.support.ui.Select;

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