package com.hexure.firelight.stepdefinitions;

import com.hexure.firelight.libraies.*;
import com.hexure.firelight.libraies.Enums.EnumsJSONProp;
import com.hexure.firelight.libraies.pages_react.CommonMethods_ReactPage;
import com.hexure.firelight.pages.*;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import io.cucumber.datatable.DataTable;
import io.qameta.allure.Allure;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;

import java.awt.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Common_StepDefinitions extends FLUtilities {
    private WebDriver driver;
    private TestContext testContext;
    private CreateApplicationPage onCreateApplicationPage;
    private CommonMethods_ReactPage onCommonMethods_reactPage;
    private DataEntryPage onDataEntryPage;
    private CommonMethodsPage onCommonMethodsPage;
    private ReviewPage onReviewPage;
    private TabAppPage onTabAppPage;
    private ExternalLoginPage onExternalLoginPage;
    private SignaturesPage onSignaturesPage;

    private static final Logger Log = LogManager.getLogger(Common_StepDefinitions.class);
    private String pdfFileName = "";
    ArrayList<String> tabs = null;
    private String pdfText_global = "";

    public Common_StepDefinitions(TestContext context) {
        testContext = context;
        driver = context.getDriver();
        onCreateApplicationPage = context.getPageObjectManager().getCreateApplicationPage();
        onCommonMethods_reactPage = context.getPageObjectManager().getCommonMethods_reactPage();
        onDataEntryPage = context.getPageObjectManager().getDataEntryPage();
        onCommonMethodsPage = context.getPageObjectManager().getCommonMethodPage();
        onReviewPage = context.getPageObjectManager().getReviewPage();
        onTabAppPage = context.getPageObjectManager().getOnTabAppPage();
        onExternalLoginPage = context.getPageObjectManager().getOnExternalLoginPage();
        onSignaturesPage = context.getPageObjectManager().getOnSignaturesPage();
    }

    @Given("User is on FireLight login page for TestCase {string}")
    public void userIsOnFLLoginPage(String testCaseID) {
        commonSetup(testCaseID);
    }

    private void commonSetup(String testCaseID) {
        testContext.setTestCaseID(testCaseID.split("_")[1] + "_" + testCaseID.split("_")[2]);
        testContext.setModuleName(testCaseID.split("_")[0]);
        System.out.println("Environment = " + testContext.getEnvironment());
        System.out.println("ApplicationType = " + testContext.getAppType());
        System.out.println("TestCaseID = " + testContext.getTestCaseID());
        System.out.println("ModuleName = " + testContext.getModuleName());
        System.out.println("CaptureScreenshot = " + testContext.getCaptureScreenshot());
        openLoginPage(driver, testContext);
        testContext.setUiType(testContext.getMapTestData().get("uiType"));
        System.out.println("UI TYPE is = " + testContext.getMapTestData().get("uiType"));
        Log.info("TEST CASE " + testCaseID + " STARTED");
    }

    @Then("User clicks {string} button")
    public void userClicksButton(String whichButton) {
        waitForPageToLoad(driver);
        captureScreenshot(driver, testContext, false);
        int elemSize = 0;
        switch (whichButton) {
            case "Create":
                clickElement(driver, onCreateApplicationPage.getBtn_Create());
                break;
            case "Continue":
            case "Apply":
                syncElement(driver, onCreateApplicationPage.getBtn_Continue(), EnumsCommon.TOCLICKABLE.getText());
                clickElementByJSE(driver, onCreateApplicationPage.getBtn_Continue());
                break;
            case "Ok":
            case "OK":
                if (findElements(driver, String.format(onCommonMethodsPage.ITButtonInput, "OK")).size() > 0) {
                    clickElement(driver, findElement(driver, String.format(onCommonMethodsPage.ITButtonInput, "OK")));
                } else {
                    clickElement(driver, onCreateApplicationPage.getBtn_OK());
                }
                break;
            case "Back To Application":
                clickElement(driver, getElement(driver, getExistingLocator(driver, onCreateApplicationPage.getBtn_BackToAppMVC(), onCreateApplicationPage.getBtn_BackToAppReact(), null, null)));
                break;
            case "Other Actions":
                syncElement(driver, getElement(driver, getExistingLocator(driver, onCreateApplicationPage.getBtn_OtherActionsMVC(), onCreateApplicationPage.getBtn_OtherActionsReact(), null, null)), EnumsCommon.TOCLICKABLE.getText());
                clickElement(driver, getElement(driver, getExistingLocator(driver, onCreateApplicationPage.getBtn_OtherActionsMVC(), onCreateApplicationPage.getBtn_OtherActionsReact(), null, null)));
                break;
            case "Submit":
                clickElement(driver, getElement(driver, getExistingLocator(driver, onCreateApplicationPage.getBtn_Submit(), onCreateApplicationPage.getBtn_Submit1(), onCreateApplicationPage.getBtn_Submit2(), null)));
                break;
            case "Next":
                clickElement(driver, onCreateApplicationPage.getBtn_Next());
                break;
            case "Previous":
                clickElement(driver, onCreateApplicationPage.getBtn_Previous());
                break;
            case "Yes":
            case "Select":
            case "Send":
            case "Clear Initials":
            case "Print Selected Documents":
                sleepInMilliSeconds(2000);
                elemSize = findElements(driver, String.format(onCommonMethods_reactPage.alt_Field, whichButton, whichButton)).size();
                if (elemSize > 0) {
                    clickElement(driver, findElement(driver, String.format(onCommonMethods_reactPage.alt_Field, whichButton, whichButton)));
                } else {
                    clickElement(driver, onCommonMethodsPage.findElement(driver, String.format(onCommonMethodsPage.ITButtonInput, whichButton)));
                }
                break;
            case "Upload":
                elemSize = findElements(driver, "//*[@id='buttonUpload']").size();
                if (elemSize > 0) {
                    clickElement(driver, onCommonMethods_reactPage.getButtonUpload());
                } else {
                    clickElement(driver, onCommonMethodsPage.findElement(driver, String.format(onCommonMethodsPage.ITButtonInput, whichButton)));
                }
                waitForPageToLoad(driver);
                break;
            case "Close":
                clickElement(driver, getElement(driver, getExistingLocator(driver, By.xpath(String.format(onCommonMethods_reactPage.titleFieldsAndButtons, whichButton)), By.xpath(String.format(onCommonMethodsPage.ITButtonInput, whichButton)), By.xpath(String.format(onCommonMethods_reactPage.alt_Field, whichButton, whichButton)), null)));
                break;
            case "Expand":
                clickElement(driver, getElement(driver, getExistingLocator(driver, onCreateApplicationPage.getBtn_ExpandMVC(), onCreateApplicationPage.getBtn_ExpandReact(), null, null)));
                break;
            case "dataEntry percentage":
                clickElement(driver, onCreateApplicationPage.getBtn_DataPercentage());
                break;
            case "Review":
                clickElement(driver, onCommonMethodsPage.findElement(driver, String.format(onCommonMethodsPage.ariaLabelInputFields, "Review Application Button")));
                break;
            case "Lock and Review Order":
                clickElement(driver, onCommonMethodsPage.findElement(driver, String.format(onCommonMethodsPage.ariaLabelInputFields, whichButton)));
                break;
            case "Sign Application":
                if (testContext.getUiType().equalsIgnoreCase(EnumsCommon.UITYPE_MVC.getText())) {
                    clickElement(driver, onCommonMethods_reactPage.getBtn_signApplication());
                } else {
                    clickElement(driver, onCommonMethodsPage.getBtn_SignApplication());
                }
                waitForPageToLoad(driver);
                break;
            case "Cancel":
            case "Clear":
                elemSize = findElements(driver, String.format(onCommonMethodsPage.ariaLabelInputFields, whichButton)).size();
                if (elemSize > 0)
                    clickElement(driver, findElement(driver, String.format(onCommonMethodsPage.ariaLabelInputFields, whichButton)));
                else
                    clickElement(driver, onCommonMethodsPage.findElement(driver, String.format(onCommonMethodsPage.ITButtonInput, whichButton)));
                break;
            case "Notifications":
                clickElement(driver, onCommonMethodsPage.getBtn_Notifications());
                break;
            case "Back":
                clickElement(driver, onCommonMethodsPage.getBtn_Back());
                break;
            case "Custom List Button 2":
                clickElement(driver, getElement(driver, getExistingLocator(driver, By.xpath(String.format(CommonMethodsPage.ITButtonInput, whichButton)), null, null, null)));
                break;
            case "Decline E-Signature":
                clickElementByJSE(driver, onCommonMethodsPage.getBtn_DeclineEsignature());
                break;
            case "Save":
            case "Save Organization":
            case "Save Product Config":
            case "Save Sales Agreement":
                clickElement(driver, onTabAppPage.getBtn_Save());
                break;
            case "Save Template":
                clickElement(driver, onTabAppPage.getBtn_SaveTemplate());
                break;
            case "Save Application":
                clickElement(driver, onCreateApplicationPage.getBtn_Save());
                break;
            case "Copy As Is":
                clickElement(driver, onCommonMethodsPage.getBtn_CopyAsIs());
                break;
            case "Copy with Changes":
                clickElement(driver, onCommonMethodsPage.getBtn_CopyWithChanges());
                break;
            case "Exit":
                clickElement(driver, onCommonMethodsPage.getBtn_Exit());
                break;
            case "Application":
                clickElement(driver, onCommonMethodsPage.getBtn_IllustrationApplication());
                break;
            case "Deploy Now":
            case "Copy Group":
            case "Load Deployment Information":
            case "Export":
                clickElementByJSE(driver, findElement(driver, String.format(onDataEntryPage.getTabById(), testContext.getMapTestData().get(whichButton))));
                break;
            case "View":
                clickElement(driver, onCommonMethodsPage.findElement(driver, String.format(onCommonMethodsPage.fieldWithTitleAttribute, whichButton, whichButton)));
                break;
            case "CLOSE":
                clickElement(driver, getElement(driver, getExistingLocator(driver, onDataEntryPage.getBtn_CloseRename(), onDataEntryPage.getBtn_CloseRename1(), null, null)));
                break;
            case "Open Application":
                clickElement(driver, findElement(driver, String.format(onCommonMethods_reactPage.titleFieldsAndButtons, whichButton) + "//span"));
                break;
            case "Advance Search":
                clickElement(driver, getElement(driver, getExistingLocator(driver, onCommonMethodsPage.getBtn_AdvanceSearchMVC(), onCommonMethodsPage.getBtn_AdvanceSearchReact(), null, null)));
                break;
            case "save":
                clickElement(driver, onCommonMethodsPage.getBtn_save());
                break;
            case "Show All":
            case "Case Access":
            case "App":
            case "Admin":
            case "Review Queue":
            case "Activity Access":
            case "Product Access":
            case "Training":
            case "Debugging Tools":
            case "React Multiple Signer for Automation Project":
            case "Hide All":
                clickElement(driver, findElement(driver, String.format(onCommonMethodsPage.anchorLinks, whichButton)));
                break;
            case "Create New ":
                clickElement(driver, findElement(driver, String.format(onCommonMethodsPage.anchorLinks, whichButton)));
                sleepInMilliSeconds(3000);
                break;
            default:
                clickElement(driver, onCommonMethodsPage.findElement(driver, String.format(onCommonMethodsPage.fieldWithTitleAttribute, whichButton, whichButton)));
                break;
        }
    }

    @Then("User enters new Application name")
    public void userEntersNewApplicationName() {
        String newAppName = "AT " + testContext.getMapTestData().get("product") + " " + getDate("newAppName");
        Allure.addAttachment("Application name is ", newAppName);
        Log.info("Application name is " + newAppName + "for test case " + testContext.getTestCaseID());
        onCreateApplicationPage.getTxtBox_newAppName().clear();
        onCreateApplicationPage.getTxtBox_newAppName().sendKeys(newAppName);
        addPropertyValueInJSON(testContext.getTestCaseID(), testContext, EnumsJSONProp.NEWPRODUCTNAME.getText(), newAppName);
        addPropertyValueInJSON(testContext.getTestCaseID(), testContext, EnumsJSONProp.NEWACTIVITYNAME.getText(), newAppName);
        captureScreenshot(driver, testContext, false);
    }

    @Then("User verifies Page heading {string} with form name {string} for data entry flow")
    public void verifyPageHeadingWithFormNameForDataEntryFlow(String pageName, String formName) {
        waitForPageToLoad(driver);
        captureScreenshot(driver, testContext, false);
        Assert.assertEquals("Data entry page header name mismatched", pageName, getElement(driver, getExistingLocator(driver, onCommonMethods_reactPage.getDataEntryPageHeaderMVC(), onCommonMethods_reactPage.getDataEntryPageHeaderReact(), null, null)).getText());
        Assert.assertEquals("Data entry page header name mismatched", formName, onDataEntryPage.getFormName().getAttribute("innerText"));
        captureScreenshot(driver, testContext, false);
    }

    @Then("User opens {string} Required for Form {string}")
    public void openRequiredForForm(String formName, String formMenu) throws InterruptedException {
        waitForPageToLoad(driver);
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        String script = "return getComputedStyle(arguments[0]).getPropertyValue('color');";
        captureScreenshot(driver, testContext, false);
        if (findElements(driver, onCommonMethods_reactPage.formListOpen).size() > 0) {
            syncElement(driver, findElement(driver, onCommonMethods_reactPage.formListOpen), EnumsCommon.TOCLICKABLE.getText());
            findElement(driver, onCommonMethods_reactPage.formListOpen).click();
            sleepInMilliSeconds(3000);
            syncElement(driver, findElement(driver, onCommonMethods_reactPage.expandAllFormList), EnumsCommon.TOVISIBLE.getText());
            syncElement(driver, findElement(driver, onCommonMethods_reactPage.expandAllFormList), EnumsCommon.TOCLICKABLE.getText());
            if (findElement(driver, String.format(onCommonMethods_reactPage.expandMandetoryFormList, formMenu)).getText().equalsIgnoreCase("▼"))
                clickElementByJSE(driver, findElement(driver, String.format(onCommonMethods_reactPage.expandMandetoryFormList, formMenu)));
            List<WebElement> mandetoryFormList = findElements(driver, String.format(onCommonMethods_reactPage.mandetoryFormList, formMenu));
            int i = 0;
            for (WebElement element : mandetoryFormList) {
                System.out.println("**********" + element.getAttribute("innerText"));
                String form = element.getAttribute("innerText");
                if (form.contains(formName)) {
                    Assert.assertTrue("Page name is not in red color", executor.executeScript(script, element).toString().contains("rgb(255, 0, 0)"));
                    clickElementByJSE(driver, element);
                    break;
                }
            }
        } else {
            onCreateApplicationPage.getWizardPageNameExpand().click();
            List<WebElement> mandetoryFormList = findElements(driver, String.format(onCreateApplicationPage.mandetoryFormList, formMenu));
            int i = 0;
            for (WebElement element : mandetoryFormList) {
                System.out.println("**********" + element.getAttribute("innerText"));
                String form = element.getAttribute("innerText");
                if (form.equals(formName)) {
                    Assert.assertTrue("Page name is not in red color", executor.executeScript(script, element.findElement(By.xpath("//span"))).toString().contains("rgb(255, 0, 0)") || executor.executeScript(script, element.findElement(By.xpath("//span"))).toString().contains("rgb(241, 62, 29)"));
                    element.click();
                    break;
                }
            }
        }
    }

    @Then("User verifies prefilled form")
    public void verifyPrefilledForm(DataTable dataTable) {
        List<Map<String, String>> formFields = dataTable.asMaps(String.class, String.class);
        waitForPageToLoad(driver);
        for (Map<String, String> fieldData : formFields) {
            String fieldName = fieldData.get("Field");
            String expectedValue = fieldData.get("Value");
            String dataItemId = fieldData.get("data-dataitemid");
            String locatorType = fieldData.get("Locator Type");
            String id = fieldData.get("Id");
            switch (locatorType) {
                case "Input":
                    Assert.assertEquals("Value Mismatched for field" + fieldName, expectedValue, findElement(driver, String.format(onCommonMethodsPage.getDataFieldsMVC(), dataItemId, id)).getAttribute("value"));
                    break;
                case "Select":
                    Assert.assertEquals("Value Mismatched for field" + fieldName, expectedValue, new Select(findElement(driver, String.format(onCommonMethodsPage.getDataFieldsSelectTag(), dataItemId, id))).getFirstSelectedOption().getText().trim());
                    break;
                default:
                    // logger.error("Invalid Locator Type: {}", locatorType);
                    Assert.fail("Invalid Locator Type");
            }
            captureScreenshot(driver, testContext, false);
        }
    }

    @Then("User sets data for the field")
    public void setValuesForPrefilledForm(DataTable dataTable) {
        List<Map<String, String>> formFields = dataTable.asMaps(String.class, String.class);
        waitForPageToLoad(driver);
        for (Map<String, String> fieldData : formFields) {
            String fieldName = fieldData.get("Field");
            String inputValue = fieldData.get("Value");
            String dataItemId = fieldData.get("data-dataitemid");
            String locatorType = fieldData.get("Locator Type");
            String id = fieldData.get("Id");

            switch (locatorType) {
                case "Input":
                    syncElement(driver, findElement(driver, String.format(onCommonMethodsPage.getDataFieldsMVC(), dataItemId, id)), EnumsCommon.TOCLICKABLE.getText());
                    scrollToWebElement(driver, findElement(driver, String.format(onCommonMethodsPage.getDataFieldsMVC(), dataItemId, id)));
                    sendKeys(driver, findElement(driver, String.format(onCommonMethodsPage.getDataFieldsMVC(), dataItemId, id)), inputValue);
                    break;
                case "Check Box":
                    if (testContext.getUiType().equalsIgnoreCase(EnumsCommon.UITYPE_MVC.getText())) {
                        findElement(driver, String.format(onCommonMethods_reactPage.formCheckBox, fieldName, dataItemId)).click();
                    } else {
                        findElement(driver, String.format(onCommonMethodsPage.formCheckBox_Mvc, fieldName, dataItemId, dataItemId)).click();
                    }
                    break;
                case "Select":
                    if (testContext.getUiType().equalsIgnoreCase(EnumsCommon.UITYPE_MVC.getText())) {
                        Select select = new Select(findElement(driver, String.format(onCommonMethods_reactPage.dataEntrySelectFields, fieldName, dataItemId)));
                        select.selectByVisibleText(inputValue);
                    } else {
                        Select select = new Select(findElement(driver, String.format(onCommonMethodsPage.dataEntrySelectFields, fieldName, dataItemId, dataItemId)));
                        select.selectByVisibleText(inputValue);
                    }
                    break;
                case "div":
                    if (findElements(driver, String.format(onCommonMethods_reactPage.checkBoxOwnership, dataItemId)).size() > 0) {
                        clickElement(driver, findElement(driver, String.format(onCommonMethods_reactPage.checkBoxOwnership, dataItemId)));
                    } else {
                        clickElement(driver, findElement(driver, String.format(onCommonMethodsPage.checkBoxOwnershipMVC, dataItemId)));
                    }
                    break;
                case "textarea":
                    if (findElements(driver, String.format(onCommonMethods_reactPage.txtAreaInput, dataItemId)).size() > 0) {
                        sendKeys(driver, findElement(driver, String.format(onCommonMethods_reactPage.txtAreaInput, dataItemId)), inputValue);
                    } else {
                        Assert.fail("Locator Type provided was not valid");
                    }
                    break;

                default:
                    // logger.error("Invalid Locator Type: {}", locatorType);
                    Assert.fail("Invalid Locator Type");
            }
            waitForPageToLoad(driver);
            captureScreenshot(driver, testContext, false);
        }
    }

    @Then("User clicks red bubble icon")
    public void userClicksRedBubbleIcon() {
        waitForPageToLoad(driver);
        captureScreenshot(driver, testContext, false);
        onCommonMethodsPage.getRedColorErrorValidationBubble().click();
    }

    @Then("User verifies Validation Message for")
    public void User_verifies_Validation_Message_for(DataTable dataTable) {
        List<Map<String, String>> formFields = dataTable.asMaps(String.class, String.class);
        waitForPageToLoad(driver);
        captureScreenshot(driver, testContext, false);
        for (Map<String, String> fieldData : formFields) {
            String fieldName = fieldData.get("Field");
            String dataItemId = fieldData.get("data-dataitemid");
            String id = fieldData.get("Id");
            String locatorType = fieldData.get("Locator Type");
            String validationError = fieldData.get("Validation Error");
            switch (locatorType) {
                case "Input":
                    if (!validationError.equals("")) {
                        syncElement(driver, findElement(driver, String.format(onCommonMethodsPage.getDataFieldsMVC(), dataItemId, id)), EnumsCommon.TOCLICKABLE.getText());
                        findElement(driver, String.format(onCommonMethodsPage.getDataFieldsMVC(), dataItemId, id)).click();
                        syncElement(driver, findElement(driver, String.format(onCommonMethodsPage.getMsg_ErrorMessageTextBox(), dataItemId, id)), EnumsCommon.TOVISIBLE.getText());
                        Assert.assertEquals(fieldName + ": {" + validationError + "} is not showing required field error message in red color", validationError, findElement(driver, String.format(onCommonMethodsPage.getMsg_ErrorMessageTextBox(), dataItemId, id)).getAttribute("innerText").trim());
                    } else {
                        Assert.fail("Expected Validation Message was Absent");
                    }
                    break;
                case "Select":
                    if (!validationError.equals("")) {
                        findElement(driver, String.format(onCommonMethodsPage.getElementByIdOrDataItemId(), dataItemId, dataItemId, id)).click();
                        Assert.assertEquals(fieldName + ": {" + validationError + "} is not showing required field error message in red color", validationError, findElement(driver, String.format(onCommonMethodsPage.getMsg_ErrorMessageDropDown(), id, dataItemId)).getAttribute("innerText"));
                    } else {
                        Assert.fail("Expected Validation Message was Absent");
                    }
                    break;
                default:
                    Assert.fail("Invalid Locator Type" + locatorType);
            }
        }
    }

    @Then("User Chooses option for Dropdown")
    public void User_Chooses_option_for_Dropdown(DataTable dataTable) {
        List<Map<String, String>> formFields = dataTable.asMaps(String.class, String.class);
        captureScreenshot(driver, testContext, false);
        for (Map<String, String> fieldData : formFields) {
            String fieldName = fieldData.get("DropdownName");
            String dataItemId = fieldData.get("data-dataitemid");
            String id = fieldData.get("Id");
            String locatorType = fieldData.get("Locator Type");
            String option = fieldData.get("Option");
            switch (locatorType) {
                case "Select":
                    if (!option.equals("")) {
                        new Select(findElement(driver, String.format(onCommonMethodsPage.getElementByIdOrDataItemId(), dataItemId, dataItemId, id))).selectByVisibleText(option);
                    } else {
                        Assert.fail("Expected Option was Absent");
                    }

                    break;
                default:
                    Assert.fail("Invalid Locator Type" + locatorType);
            }

        }
    }

    @Then("User Chooses Blank option for Dropdown {string} having id {string} or DataItemId {string}")
    public void User_Chooses_option_for_Dropdown(String ddName, String ddId, String ddDataItemId) {
        captureScreenshot(driver, testContext, false);
        new Select(findElement(driver, String.format(onCommonMethodsPage.getElementByIdOrDataItemId(), ddDataItemId, ddDataItemId, ddId))).selectByVisibleText("");

    }

    @Then("User Verifies options present for Dropdown")
    public void User_Verifies_options_present_for_Dropdown(DataTable dataTable) {
        List<Map<String, String>> formFields = dataTable.asMaps(String.class, String.class);
        captureScreenshot(driver, testContext, false);
        for (Map<String, String> fieldData : formFields) {
            String fieldName = fieldData.get("Field");
            String dataItemId = fieldData.get("data-dataitemid");
            String id = fieldData.get("Id");
            String locatorType = fieldData.get("Locator Type");
            String option = fieldData.get("Option");
            switch (locatorType) {
                case "Select":
                    if (!option.equals("")) {
                        waitUntilDropDownListPopulated(driver, new Select(findElement(driver, String.format(onCommonMethodsPage.getElementByIdOrDataItemId(), dataItemId, dataItemId, id))));
                        Assert.assertTrue(option + " was not present in " + fieldName, new Select(findElement(driver, String.format(onCommonMethodsPage.getElementByIdOrDataItemId(), dataItemId, dataItemId, id))).getWrappedElement().getText().trim().contains(option));
                    } else {
                        Assert.fail("Expected Option was Absent");
                    }

                    break;
                default:
                    Assert.fail("Invalid Locator Type" + locatorType);
            }

        }
    }

    @Then("User Selects {string} Radio Button for Field {string}")
    public void user_Selects_Radio_Button_for_Field(String option, String field, DataTable dataTable) {
        List<Map<String, String>> formFields = dataTable.asMaps(String.class, String.class);
        captureScreenshot(driver, testContext, false);
        for (Map<String, String> fieldData : formFields) {
            String dataItemId = fieldData.get("data-dataitemid");
            String id = fieldData.get("Id");
            if (!findElement(driver, String.format(onCommonMethodsPage.getRadioBtn_AsPerDataItemId(), dataItemId, option)).isSelected())
                ;
            clickElement(driver, findElement(driver, String.format(onCommonMethodsPage.getRadioBtn_AsPerDataItemId(), dataItemId, option)));
        }
    }

    @Then("User verifies Validation Message for Radio Button")
    public void User_verifies_Validation_Message_for_RadioButton(DataTable dataTable) {
        List<Map<String, String>> formFields = dataTable.asMaps(String.class, String.class);
        captureScreenshot(driver, testContext, false);
        for (Map<String, String> fieldData : formFields) {
            String fieldName = fieldData.get("Field");
            String dataItemId = fieldData.get("data-dataitemid");
            String id = fieldData.get("Id");
            String locatorType = fieldData.get("Locator Type");
            String validationError = fieldData.get("Validation Error");
            String radioButtonType = fieldData.get("RadioButtonType");

            switch (locatorType) {
                case "Div":
                    if (!validationError.equals("")) {
                        Assert.assertEquals(fieldName + ": {" + validationError + "} is not showing required field error message in red color", validationError, findElement(driver, String.format(onCommonMethodsPage.getMsg_ErrorMessageRadioButton(), dataItemId, radioButtonType)).getAttribute("innerText").trim());
                    } else {
                        Assert.fail("Expected Validation Message was Absent");
                    }
                    break;
                default:
                    Assert.fail("Invalid Locator Type" + locatorType);
            }

        }
    }

    @Then("User clicks on Create button on Rename window")
    public void userClicksOnCreateButtonOnRenameWindow() {
        captureScreenshot(driver, testContext, false);
        onCreateApplicationPage.getBtn_CreateActivity().click();
    }

    @Then("User Verifies input value for field is getting converted into Currency Value")
    public void UserVerifiesInputValueIsGettingConvertedIntoCurrencyValue(DataTable dataTable) {
        Pattern pattern;
        Matcher match;
        List<Map<String, String>> formFields = dataTable.asMaps(String.class, String.class);
        waitForPageToLoad(driver);
        captureScreenshot(driver, testContext, false);
        for (Map<String, String> fieldData : formFields) {
            String fieldName = fieldData.get("Field");
            String id = fieldData.get("Id");
            String dataItemId = fieldData.get("data-dataitemid");
            captureScreenshot(driver, testContext, false);
            pattern = Pattern.compile("^\\$\\d{1,3}(,\\d{3})*$");
            if (fieldName.equalsIgnoreCase("Total$")) {
                match = pattern.matcher(findElement(driver, String.format(onDataEntryPage.dataFieldsMVC1, dataItemId)).getAttribute("value"));
            } else {
                match = pattern.matcher(findElement(driver, String.format(onDataEntryPage.btn_CustomTextFields, id)).getAttribute("value"));
            }
            Assert.assertTrue("Converted Value doesn't matched with the expected", match.matches());
        }
    }

    @Then("User verifies field should display sum of all above fields")
    public void UserVerifiesFieldShouldDisplaySumOfAllAboveFields(DataTable dataTable) {
        List<Map<String, String>> formFields = dataTable.asMaps(String.class, String.class);
        waitForPageToLoad(driver);
        Pattern pattern;
        String value;
        for (Map<String, String> fieldData : formFields) {
            String fieldName = fieldData.get("Field");
            String inputValue = fieldData.get("Value");
            String dataItemId = fieldData.get("data-dataitemid");
            String locatorType = fieldData.get("Locator Type");
            String id = fieldData.get("Id");

            switch (locatorType) {
                case "Input":
                    syncElement(driver, findElement(driver, String.format(onCommonMethodsPage.getDataFieldsMVC(), dataItemId, id)), EnumsCommon.TOCLICKABLE.getText());
                    scrollToWebElement(driver, findElement(driver, String.format(onCommonMethodsPage.getDataFieldsMVC(), dataItemId, id)));
                    pattern = Pattern.compile("^\\$\\d{1,3}(,\\d{3})*$");
                    Matcher match = pattern.matcher(inputValue);
                    if (match.matches()) {
                        value = inputValue;
                    } else {
                        value = String.format("$%,d", Long.parseLong(inputValue));
                    }
                    Assert.assertTrue("Total value Mismatched", findElement(driver, String.format(onCommonMethodsPage.getDataFieldsMVC(), dataItemId, id)).getAttribute("value").equalsIgnoreCase(value));
                    break;
            }
        }
    }

    @Then("User Verifies input value for field is getting converted into Currency Value without currency symbol")
    public void UserVerifiesInputValueIsGettingConvertedIntoCurrencyValueWithoutCurrencySymbol(DataTable dataTable) {
        Pattern pattern;
        Matcher match;
        List<Map<String, String>> formFields = dataTable.asMaps(String.class, String.class);
        waitForPageToLoad(driver);
        captureScreenshot(driver, testContext, false);
        for (Map<String, String> fieldData : formFields) {
            String fieldName = fieldData.get("Field");
            String id = fieldData.get("Id");
            String dataItemId = fieldData.get("data-dataitemid");
            captureScreenshot(driver, testContext, false);
            pattern = Pattern.compile("^\\d{1,3}(,\\d{3})*$");
            if (fieldName.contains("What is the Client's Total Net Worth?")) {
                match = pattern.matcher(findElement(driver, String.format(onDataEntryPage.dataFieldsMVC1, dataItemId)).getAttribute("value"));
            } else {
                match = pattern.matcher(findElement(driver, String.format(onDataEntryPage.btn_CustomTextFields, id)).getAttribute("value"));
            }
            Assert.assertTrue("Converted Value doesn't matched with the expected", match.matches());
        }
    }

    @Then("User Clears data for the field")
    public void user_Clears_data_for_the_field(DataTable dataTable) {
        captureScreenshot(driver, testContext, false);
        List<Map<String, String>> formFields = dataTable.asMaps(String.class, String.class);
        for (Map<String, String> fieldData : formFields) {
            String fieldName = fieldData.get("Field");
            String dataItemId = fieldData.get("data-dataitemid");
            String locatorType = fieldData.get("Locator Type");
            String id = fieldData.get("Id");

            switch (locatorType) {
                case "Input":
                    WebElement element = findElement(driver, String.format(onCommonMethodsPage.getDataFieldsMVC(), dataItemId, id));

                    new Actions(driver).moveToElement(element).click().doubleClick().click().sendKeys(Keys.BACK_SPACE, Keys.TAB).perform();
//                    ((JavascriptExecutor) driver).executeScript("inner", findElement(driver, String.format(onCommonMethodsPage.getDataFieldsMVC(), dataItemId, id)));
//                    syncElement(driver,findElement(driver, String.format(onCommonMethodsPage.getDataFieldsMVC(), dataItemId, id)),EnumsCommon.TOCLICKABLE.getText());
//                    findElement(driver, String.format(onCommonMethodsPage.getDataFieldsMVC(), dataItemId, id)).click();
//                    findElement(driver, String.format(onCommonMethodsPage.getDataFieldsMVC(), dataItemId, id)).clear();
//                    findElement(driver, String.format(onCommonMethodsPage.getDataFieldsMVC(), dataItemId, id)).sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
                    // findElement(driver, String.format(onCommonMethodsPage.getDataFieldsMVC(), dataItemId, id)).sendKeys(Keys.TAB);

                    break;
                default:
                    // logger.error("Invalid Locator Type: {}", locatorType);
                    Assert.fail("Invalid Locator Type");
            }
        }
    }
    protected void checkBoxSelectYesNO(String userAction, WebElement element) {
        System.out.println(getCheckBoxAction(userAction));
        if (getCheckBoxAction(userAction)) {
            if (element.getAttribute("aria-checked").equals("false"))
                element.click();
        } else {
            if (element.getAttribute("aria-checked").equals("true"))
                element.click();
        }
    }
    private boolean getCheckBoxAction(String action) {
        return action.equalsIgnoreCase("check");
    }
    @Then("User verifies Agent Information is displayed on Agent Module Header")
    public void user_Verifies_Agent_Information_Is_Displayed_on_Header() {
        captureScreenshot(driver, testContext, false);
        Assert.assertTrue("Application Status is not matching", onCommonMethodsPage.getAgent_Information().isDisplayed());
    }
    @Then("User verifies fields Present in UI")
    public void user_verifies_data_in_text_fields(io.cucumber.datatable.DataTable dataTable) {
        captureScreenshot(driver, testContext, false);
        List<Map<String, String>> formFields = dataTable.asMaps(String.class, String.class);
        for (Map<String, String> fieldData : formFields) {
            String fieldName = fieldData.get("Field");
            String dataItemId = fieldData.get("data-item-id");
            String id = fieldData.get("Id");
            String locatorType = fieldData.get("Locator Type");
            String title = fieldData.get("Title");
            switch (locatorType) {
                case "Input":
                    Assert.assertTrue(fieldName + " Field was Not Present", findElement(driver, String.format(onCommonMethodsPage.getDataFieldsMVC(), dataItemId, id)).isDisplayed());
                    break;
                case "Select":
                    Assert.assertTrue(fieldName + " Field was Not Present", findElement(driver, String.format(onCommonMethodsPage.getDataFieldsSelectTag(), dataItemId, id)).isDisplayed());
                    break;
                case "Div":
                    Assert.assertTrue(title + " Field was Not Present", findElement(driver, String.format(onCommonMethodsPage.getRadioBtn_AsPerDataItemId(), dataItemId, title)).isDisplayed());
                    break;
                default:
                    Assert.fail("Invalid Locator Type" + locatorType);
            }
        }
    }


}

