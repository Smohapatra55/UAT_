package com.hexure.firelight.stepdefinitions;

import com.hexure.firelight.libraies.Enums.EnumsJSONProp;
import com.hexure.firelight.libraies.EnumsCommon;
import com.hexure.firelight.libraies.FLException;
import com.hexure.firelight.libraies.FLUtilities;
import com.hexure.firelight.libraies.TestContext;
import com.hexure.firelight.libraies.pages_react.CommonMethods_ReactPage;
import com.hexure.firelight.pages.CreateApplicationPage;
import com.hexure.firelight.pages.TabAppPage;
import cucumber.api.java.en.Then;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.WebElement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CreateApplication_StepDefinitions extends FLUtilities {
    private WebDriver driver;
    private CreateApplicationPage onCreateApplicationPage;
    private TestContext testContext;

    private CommonMethods_ReactPage onCommonMethods_reactPage;
    private static final Logger Log = LogManager.getLogger(Common_StepDefinitions.class);

    public CreateApplication_StepDefinitions(TestContext context) {
        testContext = context;
        driver = context.getDriver();
        onCreateApplicationPage = context.getPageObjectManager().getCreateApplicationPage();
    }

    @Then("User selects Jurisdiction {string}")
    public void userSelectsJurisdiction(String jurisdiction) {
        captureScreenshot(driver, testContext, false);
        new Select(onCreateApplicationPage.getDd_Jurisdiction()).selectByVisibleText(jurisdiction);
        //TODO: remove below line if not required
        addPropertyValueInJSON(testContext.getTestCaseID(), testContext, EnumsJSONProp.JURISDICTION.getText(), jurisdiction);
    }

    @Then("User selects Product Type Dropdown {string}")
    public void userSelectsProductTypeDropdown(String productType) {
        waitForPageToLoad(driver);
        waitUntilDropDownListPopulated(driver, new Select(onCreateApplicationPage.getDd_ProductType()));
        captureScreenshot(driver, testContext, false);
        new Select(onCreateApplicationPage.getDd_ProductType()).selectByVisibleText(productType);
    }

    @Then("User opens Given Product {string} for application")
    public void UserOpensGivenProductForApp(String product) {
        captureScreenshot(driver, testContext, false);
        syncElement(driver, findElement(driver, String.format(onCreateApplicationPage.list_OfProducts, product)), EnumsCommon.TOCLICKABLE.getText());
       try {
           clickElement(driver, findElement(driver, String.format(onCreateApplicationPage.list_OfProducts, product)));
       } catch (StaleElementReferenceException e){
           clickElement(driver, findElement(driver, String.format(onCreateApplicationPage.list_OfProducts, product)));
       }
           addPropertyValueInJSON(testContext.getTestCaseID(), testContext, EnumsJSONProp.PRODUCT.getText(), product);
    }

    @Then("User Verifies {string} field is present")
    public void userVerifiesFieldIsPresent(String field) {
        captureScreenshot(driver, testContext, false);
        syncElement(driver, findElement(driver, String.format(onCreateApplicationPage.txt_AllInputField, field)), EnumsCommon.TOVISIBLE.getText());
        Assert.assertTrue("Field was not displayed", findElements(driver, String.format(onCreateApplicationPage.txt_AllInputField, field)).size() > 0);
    }
    @Then("User verifies {string} window showing")
    public void userVerifiesWindowShowing(String windownamecreatenew) {
        captureScreenshot(driver, testContext, false);
        Assert.assertEquals("User is not on Create new Application window", windownamecreatenew, onCreateApplicationPage.getTxt_createNewApplicationwindow().getText().trim());
    }
    @Then("User verifies the list of products is displayed")
    public void user_verifies_the_list_of_products_is_displayed() {
        captureScreenshot(driver, testContext, false);
        Assert.assertTrue("Products are not displayed", onCreateApplicationPage.getListProductsTxt().size()>0);
    }
}
