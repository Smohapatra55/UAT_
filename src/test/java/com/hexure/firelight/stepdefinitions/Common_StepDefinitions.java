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

    @Given("User is on FireLight Admin login page for TestCase {string}")
    public void userIsOnFLAdminLoginPage(String testCaseID) {
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

    @Then("User verify title of page is {string}")
    public void verifyPageTitle(String title) {
        captureScreenshot(driver, testContext, false);
        Assert.assertTrue("Title of page is not " + title, driver.findElement(By.xpath("//div[text()='" + title + "']")).isDisplayed());
    }

    @Then("User verifies {string} Button should be disable")
    public void verifyButtonShouldBeDisable(String whichButton) {
        captureScreenshot(driver, testContext, false);
        if (whichButton.equalsIgnoreCase("Create")) {
            Assert.assertTrue("Button " + whichButton + " is not disabled", onCreateApplicationPage.getBtn_Create().getAttribute("class").contains("disabled"));
        } else if (whichButton.equalsIgnoreCase("Continue")) {
            Assert.assertTrue("Button " + whichButton + " is not disabled", onCreateApplicationPage.getBtn_Continue().getAttribute("class").contains("disabled"));
        } else if (whichButton.equalsIgnoreCase("Ok")) {
            Assert.assertTrue("Button " + whichButton + " is not disabled", onCreateApplicationPage.getBtn_OK().getAttribute("class").contains("disabled"));
        }
    }

    @Then("User verifies Page heading {string} with form name {string} for data entry flow")
    public void verifyPageHeadingWithFormNameForDataEntryFlow(String pageName, String formName) {
        waitForPageToLoad(driver);
        captureScreenshot(driver, testContext, false);
        Assert.assertEquals("Data entry page header name mismatched", pageName, getElement(driver, getExistingLocator(driver, onCommonMethods_reactPage.getDataEntryPageHeaderMVC(), onCommonMethods_reactPage.getDataEntryPageHeaderReact(), null, null)).getText());
        Assert.assertEquals("Data entry page header name mismatched", formName, onDataEntryPage.getFormName().getAttribute("innerText"));
        captureScreenshot(driver, testContext, false);
    }

    @Then("User verify header of page is {string}")
    public void verifyPageHeader(String header) {
        waitForPageToLoad(driver);
        captureScreenshot(driver, testContext, false);
        Assert.assertTrue(header + " is not displayed on page", getElement(driver, By.xpath("//span[contains(text(),'" + header + "')]")).isDisplayed());
    }

    @Then("User selects radio button {string} for {string}")
    public void selectRadioButtonFor(String buttonName, String panelname) {
        clickElement(driver, String.format(onCommonMethodsPage.radioButton, panelname, buttonName));
        waitForPageToLoad(driver);
        captureScreenshot(driver, testContext, false);
    }

    @Then("User selects radio button {string} for field {string} from section {string}")
    public void selectRadioButtonForFieldFromSection(String buttonName, String fieldName, String panelName) {
        clickElement(driver, String.format(onCommonMethodsPage.YesNoRadioButton, panelName, fieldName, buttonName));
        waitForPageToLoad(driver);
        captureScreenshot(driver, testContext, false);
    }

    @Then("User verifies Red bubble icon at top right corner should be display {string}")
    public void verifyRedBubbleIconAtTopRightCornerShouldBeDisplay(String flag) throws InterruptedException {
        waitForPageToLoad(driver);
        if (testContext.getUiType().equalsIgnoreCase(EnumsCommon.UITYPE_MVC.getText())) {
            if (flag.equals("True")) {
                syncElement(driver, onCommonMethodsPage.getRedColorErrorValidationBubble(), EnumsCommon.TOCLICKABLE.getText());
                captureScreenshot(driver, testContext, false);
                Assert.assertTrue("Red bubble is not showing at top right corner", onCommonMethodsPage.getRedColorErrorValidationBubble().getAttribute("class").contains("alert"));

            } else {

                captureScreenshot(driver, testContext, false);
                Assert.assertTrue("Red bubble is showing at top right corner", onCommonMethodsPage.getRedColorErrorValidationBubble().getAttribute("style").contains("visibility: hidden"));
            }
        } else {
            if (flag.equals("True")) {
                syncElement(driver, onCommonMethodsPage.getRedColorErrorValidationBubble(), EnumsCommon.TOCLICKABLE.getText());
                captureScreenshot(driver, testContext, false);
                Assert.assertTrue("Red bubble is not showing at top right corner", onCommonMethodsPage.getRedColorErrorValidationBubble().isDisplayed());

            } else {

                boolean isPresent = false;
                try {
                    isPresent = onCommonMethodsPage.getRedColorErrorValidationBubble().isDisplayed();
                } catch (NoSuchElementException e) {

                }
                captureScreenshot(driver, testContext, false);
                Assert.assertFalse("Red bubble is showing at top right corner", isPresent);
            }
        }
    }

    @Then("User set value {string} for field {string}")
    public void usersetValueForField(String value, String fieldName) {
        waitForPageToLoad(driver);
        sendKeys(driver, onCommonMethodsPage.findElement(driver, String.format(onCommonMethodsPage.dataEntryTextFields, fieldName, fieldName, fieldName)), value);
        captureScreenshot(driver, testContext, false);
    }

    @Then("User verifies dialog window {string}")
    public void userVerifiesDialogWindow(String windowName) {
        waitForPageToLoad(driver);
        captureScreenshot(driver, testContext, false);
        if (findElements(driver, String.format(onCommonMethods_reactPage.dialog_WindowName, windowName)).size() > 0) {
            Assert.assertTrue(windowName + " is not open", findElement(driver, String.format(onCommonMethods_reactPage.dialog_WindowName, windowName)).isDisplayed());
        } else if (windowName.equalsIgnoreCase("Electronic Signatures Complete") || windowName.equalsIgnoreCase("Agent Off-Site Signature")) {
            Assert.assertTrue(windowName + " is not open", getElement(driver, getExistingLocator(driver, onSignaturesPage.getAgentOnSiteHeadingReact(), onSignaturesPage.getAgentOnSiteHeadingMVC(), null, null)).getText().trim().contains(windowName));
        } else if (windowName.equalsIgnoreCase("CRM")) {
            Assert.assertTrue(windowName + " is not open", getElement(driver, getExistingLocator(driver, onCommonMethodsPage.getDialog_WindowNameMVC(), onCommonMethodsPage.getDialog_WindowNameReact(), null, null)).getText().trim().contains(windowName));
        } else if (getElements(driver, onCommonMethodsPage.getDialog_WindowName()).size() > 0) {
            Assert.assertTrue(windowName + " is not open", getElement(driver, getExistingLocator(driver, onCommonMethodsPage.getDialog_WindowName(), null, null, null)).getText().trim().contains(windowName));
        } else {
            Assert.assertTrue(windowName + " is not open", getElement(driver, getExistingLocator(driver, onCommonMethodsPage.getDialog_WindowNameMVC(), onCommonMethodsPage.getDialog_WindowNameReact(), onCommonMethodsPage.getDialog_WindowName(), null)).getText().trim().contains(windowName));
        }
    }

    @Then("User verifies dialog window {string} popup")
    public void userVerifiesDialogWindowPopup(String windowName) {
        captureScreenshot(driver, testContext, false);
        Assert.assertTrue(windowName + "} is not open", onCommonMethodsPage.getDialog_WindowName_PendingRequest().getText().contains(windowName));
    }

    @Then("User verifies dialog window {string} popup if appears and closes it")
    public void userVerifiesDialogWindowPopupIfAppears(String windowName) {
        waitForPageToLoad(driver);
        captureScreenshot(driver, testContext, false);
        if (new ArrayList<>(driver.findElements(By.id("dialogheader"))).size() > 0) {
            captureScreenshot(driver, testContext, false);
            if (new ArrayList<>(driver.findElements(By.xpath("//button[@class='ITButtonInput  ']//span[text()='Close']"))).size() > 0)
                clickElementByJSE(driver, onDataEntryPage.getBtn_Close());
        } else if (new ArrayList<>(driver.findElements(By.id("lblPendingRequest"))).size() > 0) {
            Assert.assertTrue(windowName + "} is not open", onCommonMethodsPage.getDialog_WindowName_PendingRequest().getText().equals(windowName));
            captureScreenshot(driver, testContext, false);
            clickElementByJSE(driver, getElement(driver, getExistingLocator(driver, onReviewPage.getLink_closeMVC(), onReviewPage.getLink_closeReact(), null, null)));
        }
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

    @Then("User opens {string} Optional for Form {string}")
    public void openOptionalForForm(String formName, String formMenu) {
        waitForPageToLoad(driver);
        clickElement(driver, getElement(driver, getExistingLocator(driver, onCreateApplicationPage.getWizardPageNameExpandmvc(), onExternalLoginPage.getIcon_ExpandMenuMVC(), null, null)));
        sleepInMilliSeconds(3000);
        if (findElements(driver, String.format(onCommonMethods_reactPage.expandMandetoryFormList, formName)).size() > 0) {
            if (findElement(driver, String.format(onCommonMethods_reactPage.expandMandetoryFormList, formName)).getText().equalsIgnoreCase("▼"))
                clickElement(driver, findElement(driver, String.format(onCommonMethods_reactPage.expandMandetoryFormList, formName)));
            sleepInMilliSeconds(2000);
            syncElement(driver, findElement(driver, String.format(onDataEntryPage.getFormMenu(), formMenu, formName)), EnumsCommon.TOCLICKABLE.getText());
            clickElement(driver, findElement(driver, String.format(onDataEntryPage.getFormMenu(), formMenu, formName)));
        } else {
            List<WebElement> mandetoryFormList = findElements(driver, String.format(onCreateApplicationPage.optionalFormList, formMenu));
            int i = 0;
            for (WebElement element : mandetoryFormList) {
                String form = element.getAttribute("innerText");
                if (form.equals(formName)) {
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
                Assert.assertEquals("Value Mismatched for field" + fieldName, expectedValue, findElement(driver,String.format(onCommonMethodsPage.getDataFieldsMVC(),dataItemId,id)).getAttribute("value"));
                    break;
                case "Select":
                    Assert.assertEquals("Value Mismatched for field" + fieldName, expectedValue, new Select(findElement(driver,String.format(onCommonMethodsPage.getDataFieldsSelectTag(),dataItemId,id))).getFirstSelectedOption().getText().trim());
                    break;
                default:
                    // logger.error("Invalid Locator Type: {}", locatorType);
                    Assert.fail("Invalid Locator Type");
            }
            captureScreenshot(driver, testContext, false);
        }
    }

    @Then("User verifies prefilled form for Forms Only Application")
    public void user_verifies_prefilled_form_for_Forms_Only_Application(io.cucumber.datatable.DataTable dataTable) {
        List<Map<String, String>> formFields = dataTable.asMaps(String.class, String.class);
        waitForPageToLoad(driver);
        for (Map<String, String> fieldData : formFields) {
            String fieldName = fieldData.get("Field");
            String expectedValue = fieldData.get("Value");
            String dataItemId = fieldData.get("data-item-id");
            String locatorType = fieldData.get("Locator Type");
            String actualValue = null;

            switch (locatorType) {
                case "Input":
                    if (testContext.getUiType().equalsIgnoreCase(EnumsCommon.UITYPE_MVC.getText())) {
                        actualValue = findElement(driver, String.format(onCommonMethods_reactPage.preFilledFormInput, dataItemId)).getAttribute("value");
                        Assert.assertEquals("Expected field " + fieldName + " is not pre populated on form", actualValue, expectedValue);
                    } else {
                        actualValue = findElement(driver, String.format(onCommonMethodsPage.preFilledFormInputForm, dataItemId)).getAttribute("value");
                        Assert.assertEquals("Expected field " + fieldName + " is not pre populated on form", actualValue, expectedValue);
                    }
                    break;
                default:
                    Assert.fail("The Locator Type provided was not valid");
            }
            captureScreenshot(driver, testContext, false);
        }
    }

    @Then("User Enters DOB {string}")
    public void UserEntersDOB(String dob) {
        waitForPageToLoad(driver);
        captureScreenshot(driver, testContext, false);
        clickElementByJSE(driver, onDataEntryPage.getTxtBox_ClientDob());
        onDataEntryPage.getTxtBox_ClientDob().sendKeys(dob + Keys.TAB);
    }

    @Then("User verify value of field {string} is set to {string}")
    public void verifyFieldValue(String field, String value) {
        waitForPageToLoad(driver);
        if (testContext.getUiType().equalsIgnoreCase(EnumsCommon.UITYPE_MVC.getText()))
            Assert.assertTrue("Field " + field + " value does not match", driver.findElement(By.xpath("//*[@data-item-id='" + field + "']")).getAttribute("value").equalsIgnoreCase(value));
        else
            Assert.assertTrue("Field " + field + " value does not match", driver.findElement(By.xpath("//input[@data-dataitemid='" + field + "']")).getAttribute("value").equalsIgnoreCase(value));
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

    @Then("User verify fields for {string}")
    public void verifyFieldReadOnly(String condition, DataTable dataTable) {
        List<Map<String, String>> formFields = dataTable.asMaps(String.class, String.class);

        for (Map<String, String> fieldData : formFields) {
            String fieldName = fieldData.get("Field");
            String inputValue = fieldData.get("Value");
            String dataItemId = fieldData.get("data-dataitemid");
            String locatorType = fieldData.get("Locator Type");

            String actualValue = null;

            switch (locatorType) {
                case "Input":
                    if (testContext.getUiType().equalsIgnoreCase(EnumsCommon.UITYPE_MVC.getText())) {
                        waitForPageToLoad(driver);
                        String attributeValue = findElement(driver, String.format(onCommonMethods_reactPage.dataEntryTextFields, fieldName, dataItemId, dataItemId)).getAttribute(condition);
                        Assert.assertTrue("Field is not read only", attributeValue.equalsIgnoreCase("true"));
                    } else {
                        waitForPageToLoad(driver);
                        findElement(driver, String.format(onDataEntryPage.txtBox_dataEntryTextFields_Mvc, fieldName, dataItemId)).clear();
                        findElement(driver, String.format(onDataEntryPage.txtBox_dataEntryTextFields_Mvc, fieldName, dataItemId)).sendKeys(inputValue + Keys.TAB);
                    }
                    break;
                case "Check Box":
                    waitForPageToLoad(driver);
                    if (testContext.getUiType().equalsIgnoreCase(EnumsCommon.UITYPE_MVC.getText())) {
                        WebElement checkBoxElement = findElement(driver, String.format(onCommonMethods_reactPage.formCheckBox, fieldName, dataItemId));
                        Assert.assertTrue("Checkbox is not read only", checkBoxElement.getAttribute("class").contains("readonlyCheckBox") | checkBoxElement.getAttribute("class").contains("radioCheckedDisabled"));
                    } else {
                        findElement(driver, String.format(onCommonMethodsPage.formCheckBox_Mvc, fieldName, dataItemId, dataItemId)).click();
                    }
                    break;
                case "textarea":
                    if (findElements(driver, String.format(onCommonMethods_reactPage.txtAreaInput, dataItemId)).size() > 0) {
                        waitForPageToLoad(driver);
                        Assert.assertTrue("Field is not read only", findElement(driver, String.format(onCommonMethods_reactPage.txtAreaInput, dataItemId, dataItemId, dataItemId)).getAttribute(condition).equals("true"));
                    } else {
                        Assert.fail("Locator Type provided was not valid");
                    }
                    break;
                default:
                    // logger.error("Invalid Locator Type: {}", locatorType);
                    Assert.fail("Invalid Locator Type");
            }
            captureScreenshot(driver, testContext, false);
        }
    }

    @Then("User opens Menu {string}")
    public void openMenu(String menus) {
        waitForPageToLoad(driver);
        captureScreenshot(driver, testContext, false);
        for (String menu : menus.split("->")) {
            syncElement(driver, findElement(driver, String.format(onCommonMethodsPage.anchorLinks, menu)), EnumsCommon.TOCLICKABLE.getText());
            clickElementByJSE(driver, findElement(driver, String.format(onCommonMethodsPage.anchorLinks, menu)));
        }
    }

    @Then("User uploads Document {string}")
    public void userUploadDocumentWithType(String documentName) throws AWTException, InterruptedException {
        waitForPageToLoad(driver);
        String filePath = EnumsCommon.ABSOLUTE_DOWNLOADFILES_PATH.getText() + documentName + ".pdf";
        onCommonMethodsPage.getFileDrop().sendKeys(new File(filePath).getAbsolutePath());
        captureScreenshot(driver, testContext, false);
    }

    @Then("User selects check box {string}")
    public void selectCheckBox(String fieldName) {
        captureScreenshot(driver, testContext, false);
        if (testContext.getUiType().equalsIgnoreCase(EnumsCommon.UITYPE_MVC.getText())) {
            clickElement(driver, String.format(onCommonMethods_reactPage.ariaLabelInputFields, fieldName, fieldName));
            waitForPageToLoad(driver);
            captureScreenshot(driver, testContext, false);
        } else {
            clickElement(driver, String.format(onCommonMethodsPage.checkBox, fieldName, fieldName));
            waitForPageToLoad(driver);
            captureScreenshot(driver, testContext, false);
        }
    }

    @Then("User verifies pdf text in {string} document")
    public void userVerifiesPdfText(String fileName, DataTable dataTable) {
        // TODO values are not validating in pdf (canvas)
        try {
            Thread.sleep(3000);
            ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
            if (tabs.size() > 1)
                driver.switchTo().window(tabs.get(1));

            pdfFileName = testContext.getModuleName() + "-" + testContext.getTestCaseID() + "_" + getDate("pdfFileName") + ".pdf";
            Path downloadFilePath = Paths.get(EnumsCommon.ABSOLUTE_DOWNLOADFILES_PATH.getText() + fileName + ".pdf");

            new WebDriverWait(driver, 60).until(d -> downloadFilePath.toFile().exists());
            renameFile(fileName, pdfFileName);
            String pdfText = getPDFText(pdfFileName);
            pdfText_global = pdfText;
            Log.info(pdfFileName);

            System.setProperty(testContext.getTestCaseID(), "PDF1");
            List<String> data = dataTable.asList(String.class);
            for (String fieldValue : data) {
                if (fieldValue.contains("Application Name")) {
                    Assert.assertTrue("Application is not present in pdf", pdfText.contains(testContext.getMapTestData().get("newProductName")));
                }
                Assert.assertTrue(fieldValue + " is not present in pdf", pdfText.contains(fieldValue));
            }
        } catch (IOException e) {
            Log.error("PDF could not be found or read " + e.getMessage());
            throw new FLException("PDF file could not be found or read " + pdfFileName + ">>>> " + e.getMessage());
        } catch (Exception e) {
            Log.error("Error occured while reading pdffilename " + pdfFileName + " " + e.getMessage());
            throw new FLException("Error occured while reading pdffilename " + pdfFileName + ">>>> " + e.getMessage());
        } finally {
            ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
            if (tabs.size() > 1)
                driver.close();

            driver.switchTo().window(tabs.get(0));
        }
    }

    @Then("User verifies pdf document contains {int} pages")
    public void userVerifiesCountPdfPages(int count) throws Exception {
        File pdfFile = new File(EnumsCommon.RELATIVE_DOWNLOADFILES_PATH.getText() + pdfFileName);
        PDDocument pdfDocument = PDDocument.load(new FileInputStream(pdfFile));
        Assert.assertTrue("PDF does not contain expected number of pages, It has " + pdfDocument.getNumberOfPages(), pdfDocument.getNumberOfPages() == count);
    }

    @Then("User clicks Link {string}")
    public void clickLink(String menus) {
        waitForPageToLoad(driver);
        captureScreenshot(driver, testContext, false);
        for (String menu : menus.split("->")) {
            findElement(driver, String.format(onCommonMethodsPage.anchorLinks, menu)).click();
        }
    }

    @Then("User sets value {string}  for field {string} for Send Email To Reviewer page")
    public void userSetValueForFieldForSendEmailToReviewerPage(String fieldValue, String fieldName) {
        onCommonMethodsPage.findElement(driver, String.format(onCommonMethodsPage.ariaLabelInputFields, fieldName)).clear();
        if (fieldValue.contains("Random")) {
            String appName = testContext.getMapTestData().get("newProductName");
            fieldValue = fieldValue + appName.substring(appName.lastIndexOf(" "));
            addPropertyValueInJSON(testContext.getTestCaseID(), testContext, EnumsJSONProp.REVIEWERNAME.getText(), fieldValue);
            addPropertyValueInJSON(testContext.getTestCaseID(), testContext, EnumsJSONProp.REVIEWERNAMERANDOM.getText(), fieldValue);
        }
        onCommonMethodsPage.findElement(driver, String.format(onCommonMethodsPage.ariaLabelInputFields, fieldName)).sendKeys(fieldValue);
        waitForPageToLoad(driver);
        captureScreenshot(driver, testContext, false);
    }

    @Then("User Verifies Two field appears {string} and {string}")
    public void user_Verifies_Two_field_appears_and(String fieldName1, String fieldName2) {
        captureScreenshot(driver, testContext, false);
        Assert.assertTrue(fieldName1 + " is not displayed", onCommonMethodsPage.findElement(driver, String.format(onCommonMethodsPage.ariaLabelInputFields, fieldName1)).isDisplayed());
        Assert.assertTrue(fieldName2 + " is not displayed", onCommonMethodsPage.findElement(driver, String.format(onCommonMethodsPage.ariaLabelInputFields, fieldName2)).isDisplayed());
    }

    @Then("User selects check box {string} for Send Email To Reviewer page")
    public void userSelectCheckBoxForSendEmailToReviewerPage(String fieldName) {
        clickElement(driver, String.format(onCommonMethodsPage.ariaLabelInputFields, fieldName));
        waitForPageToLoad(driver);
        captureScreenshot(driver, testContext, false);
    }

    @Then("User clicks Send Email Request and verify Page Email Requests Sent with Message and Passcode")
    public void verifyPageEmailRequestsSentWithMessageAndPasscode(DataTable dataTable) {
        List<Map<String, String>> formFields = dataTable.asMaps(String.class, String.class);
        String Passcode = onReviewPage.getSendEmailPasscode().getText();
        System.setProperty("Passcode", Passcode);
        onReviewPage.getButtonSendEmailRequest().click();
        waitForPageToLoad(driver);
        for (Map<String, String> fieldData : formFields) {
            String pageName = fieldData.get("Page Name");
            String emailToSend = fieldData.get("Email Send To");
            String passcodeMessage = fieldData.get("Passcode message");
            Assert.assertEquals("Page header name should match", pageName, onReviewPage.getPageHeadingEmailRequestsSent().getAttribute("innerText"));
            Assert.assertEquals("Email to send Message should be", emailToSend, onReviewPage.getPanelContent().getAttribute("innerText"));
            Assert.assertEquals("Passcode message should be", passcodeMessage + " '" + Passcode + "'", onReviewPage.getPassCodeText().getAttribute("innerText"));
            captureScreenshot(driver, testContext, false);
        }
        addPropertyValueInJSON(testContext.getTestCaseID(), testContext, EnumsJSONProp.REVIEWERPASSCODE.getText(), Passcode);
    }

    @Then("User clicks button Back to app")
    public void userClickButtonBackToApp() {
        waitForPageToLoad(driver);
        captureScreenshot(driver, testContext, false);
        if (testContext.getUiType().equalsIgnoreCase(EnumsCommon.UITYPE_MVC.getText())) {
            String button = "Back to Application";
            findElement(driver, String.format(onCommonMethods_reactPage.alt_Field, button, button)).click();
            captureScreenshot(driver, testContext, false);
        } else {
            onReviewPage.getButtonBack().click();
            captureScreenshot(driver, testContext, false);
        }
    }

    @Then("User verifies toast message {string}")
    public void userVerifiesTostMessage(String message) {
        waitForPageToLoad(driver);
        captureScreenshot(driver, testContext, false);
        WebElement element = getElement(driver, getExistingLocator(driver, onCommonMethodsPage.getPopup_ToastMVC(), onCommonMethodsPage.getPopup_ToastReact(), null, null));
        syncElement(driver, element, EnumsCommon.TOVISIBLE.getText());
        Assert.assertTrue(message + ":: Toast popup NOT Visible", element.getAttribute("innerText").contains(message));
        captureScreenshot(driver, testContext, false);
        clickElementByJSE(driver, getElement(driver, getExistingLocator(driver, onCommonMethodsPage.getIcon_closeToastMessageMVC(), onCommonMethodsPage.getIcon_closeToastMessageReact(), null, null)));
    }

    @Then("User verifies toast message Alert {string}")
    public void userVerifiesTostMessageAlert(String message) {
        syncElement(driver, onReviewPage.getAlert_MessageSent(), EnumsCommon.TOVISIBLE.getText());
        captureScreenshot(driver, testContext, false);
        Assert.assertTrue(message + ":: Toast popup NOT Visible", onReviewPage.getAlert_MessageSent().getText().trim().contains(message));
        captureScreenshot(driver, testContext, false);
        clickElement(driver, getElement(driver, getExistingLocator(driver, onReviewPage.getBtn_Ok_ConfPopupMVC(), onReviewPage.getBtn_Ok_ConfPopupReact(), null, null)));
    }

    @Then("User verifies Pending Request dialog details")
    public void verifyPendingRequestDialogDetails(DataTable dataTable) {
        List<Map<String, String>> formFields = dataTable.asMaps(String.class, String.class);

        waitForPageToLoad(driver);
        for (Map<String, String> fieldData : formFields) {
            String recipient = fieldData.get("Recipient");
            String emailToSendTo = fieldData.get("Email Sent To");
            String passcode = System.getProperty("Passcode");
            // Get today's date
            LocalDate currentDate = LocalDate.now();
            // Format the date as per the desired format
            String todaysDate = "";
            if (testContext.getUiType().equalsIgnoreCase(EnumsCommon.UITYPE_REACT.getText())) {
                DateTimeFormatter formatter = convertDateFormat(onReviewPage.getPendingRequestDetails().get(2).getAttribute("innerText"));
                todaysDate = currentDate.format(formatter);
                Assert.assertEquals("Recipient should be " + recipient, onReviewPage.getPendingRequestDetails().get(0).getAttribute("innerText"), "Recipient: " + recipient);
                Assert.assertEquals("To should be " + emailToSendTo, onReviewPage.getPendingRequestDetails().get(1).getAttribute("innerText"), "Email Sent To: " + emailToSendTo);
                Assert.assertEquals("Date should be " + todaysDate, onReviewPage.getPendingRequestDetails().get(2).getAttribute("innerText"), "Create Date: " + todaysDate);
                Assert.assertEquals("Passcode should be " + passcode, onReviewPage.getPendingRequestDetails().get(3).getAttribute("innerText"), "Passcode:" + passcode);
            } else {
                passcode = testContext.getMapTestData().get("reviewerPasscode");
                Assert.assertEquals("Recipient should be " + recipient, onReviewPage.getPendingRequestDetails_mvc().getText().split("\n")[1].trim(), "Recipient: " + recipient);
                Assert.assertEquals("To should be " + emailToSendTo, onReviewPage.getPendingRequestDetails_mvc().getText().split("\n")[2].trim(), "Email Sent: " + emailToSendTo);
                //  Assert.assertEquals("Date should be " + todaysDate, onReviewPage.getPendingRequestDetails_mvc().getText().split("\n")[3].trim(), "Date: " + todaysDate);
                Assert.assertEquals("Passcode should be " + passcode, onReviewPage.getPendingRequestDetails_mvc().getText().split("\n")[4].trim(), "Passcode: " + passcode);

            }

        }
        captureScreenshot(driver, testContext, false);

    }

    public DateTimeFormatter convertDateFormat(String appDate) {
        appDate = appDate.replace("Create Date: ", "");
        String[] dates = appDate.split("/");
        if (dates[0].length() == 1 & dates[1].length() == 1)
            return DateTimeFormatter.ofPattern("M/d/yyyy");
        else if (dates[0].length() == 1)
            return DateTimeFormatter.ofPattern("M/dd/yyyy");
        else if (dates[1].length() == 1)
            return DateTimeFormatter.ofPattern("MM/d/yyyy");
        return DateTimeFormatter.ofPattern("MM/dd/yyyy");
    }

    @Then("User verifies Pending Request dialog popup links")
    public void verifyPendingRequestDialogLinksPopup(List<String> expectedLinks) {
        captureScreenshot(driver, testContext, false);
        Assert.assertEquals(expectedLinks.get(0) + " Link should be ", onReviewPage.getPendingRequestLinks_mvc().get(0).getAttribute("innerText"), expectedLinks.get(0));
        Assert.assertEquals(expectedLinks.get(1) + " Link should be ", onReviewPage.getPendingRequestLinks_mvc().get(1).getAttribute("innerText"), expectedLinks.get(1));
        Assert.assertEquals(expectedLinks.get(2) + " Link should be ", onReviewPage.getPendingRequestLinks_mvc().get(2).getAttribute("innerText"), expectedLinks.get(2));
    }

    @Then("User clicks Send Reminder to {string} link, message template should show.")
    public void userClickSendReminderToLinkMessageTemplateShouldShow(String link) {
        captureScreenshot(driver, testContext, false);
        if (link.toLowerCase().contains("joint owner".toLowerCase())) {
            link = link.substring(0, 15) + testContext.getMapTestData().get("JointName");
        }
        ArrayList<WebElement> requestLink = new ArrayList<>(onReviewPage.getPendingRequestLinks());
        if (requestLink.size() > 0) {
            for (WebElement element : onReviewPage.getPendingRequestLinks()) {
                if (element.getAttribute("innerText").contains(link)) {
                    clickElement(driver, onReviewPage.getLink_sendReminder());
                }
            }
        } else {
            for (WebElement element : onReviewPage.getPendingRequestLinks_mvc()) {
                if (element.getAttribute("innerText").contains(link)) {
                    element.click();
                }
            }
        }
    }

    @Then("User closes current window")
    public void userClosesCurrentWindow() {
        String originalWindowHandle = driver.getWindowHandle();
        Set<String> allWindowHandles = driver.getWindowHandles();

        // Switch to the latest window (new window)
        for (String windowHandle : allWindowHandles) {
            driver.switchTo().window(windowHandle);
        }

        driver.close();
        driver.switchTo().window(originalWindowHandle);
    }

    @And("User verifies {string} tab is green tick mark")
    public void verifyTabWithGreenTickMark(String tabName) {
        Assert.assertTrue(tabName + " tab is NOT highlighted wit green tick mark", findElement(driver, String.format(onCommonMethodsPage.tabWithGreenTickMark, tabName, tabName)).isDisplayed());
    }

    @And("User verifies {string} tab has green tick mark")
    public void verifyTabHasGreenTickMark(String tabName) {
        captureScreenshot(driver, testContext, false);
        Assert.assertTrue(tabName + " tab is NOT highlighted wit green tick mark", onReviewPage.getImage_ReviewCircle().isDisplayed());
    }

    @And("User verifies {string} current tab")
    public void verifyCurrentTab(String tabName) {
        Assert.assertTrue(tabName + " tab is not current tab", findElement(driver, String.format(onCommonMethodsPage.currentTab, tabName)).isDisplayed());
    }

    @Then("User verifies Audit History")
    public void user_verifies_audi_history(DataTable dataTable) {
        captureScreenshot(driver, testContext, false);
        List<Map<String, String>> statusDescriptions = dataTable.asMaps(String.class, String.class);
        int i = 0;
        for (Map<String, String> row : statusDescriptions) {
            String expectedStatus = row.get("Status");
            String expectedDescription = row.get("Status Description");
            Assert.assertEquals("Status should be" + expectedStatus, expectedStatus, onCommonMethodsPage.getAuditDisplayStatus().get(i).getAttribute("innerText"));
            Assert.assertTrue("Description should be" + expectedDescription + " but fund " + onCommonMethodsPage.getAuditDisplayDesc().get(i).getAttribute("aria_label"), onCommonMethodsPage.getAuditDisplayDesc().get(i).getAttribute("aria_label").contains(expectedDescription));
            i++;
        }
        clickElementByJSE(driver, onCommonMethodsPage.getHistoryTabCloseButton());
        captureScreenshot(driver, testContext, false);
    }

    @Then("User verifies Audit History statuses")
    public void user_verifies_audi_history1(DataTable dataTable) {
        captureScreenshot(driver, testContext, false);
        List<Map<String, String>> statusDescriptions = dataTable.asMaps(String.class, String.class);
        for (Map<String, String> row : statusDescriptions) {
            String expectedStatus = row.get("Status");
            String expectedDescription = row.get("Status Description");
            for (WebElement status : onCommonMethodsPage.getAuditDisplayStatus()) {
                if (status.getText().trim().equalsIgnoreCase(expectedStatus)) {
                    Assert.assertTrue("Status should be" + expectedStatus, status.getAttribute("innerText").contains(expectedStatus));
                    WebElement description = driver.findElement(By.xpath("//*[@class=\"auditDisplayStatus\"]/following-sibling::strong[normalize-space()='" + status.getText().trim() + "']/parent::div/following-sibling::div"));
                    if (!expectedDescription.isEmpty())
                        Assert.assertTrue("Description should be " + expectedDescription + " but found " + description.getText().trim(), description.getText().trim().contains(expectedDescription));
                }
            }
        }
        clickElementByJSE(driver, onCommonMethodsPage.getHistoryTabCloseButton());
        captureScreenshot(driver, testContext, false);
    }

    @Then("User selects {string} button on Signature Tab")
    public void userClickButtonOnSignatureTab(String buttonName) {
        clickElement(driver, String.format(onCommonMethods_reactPage.alt_Field, buttonName, buttonName));
        waitForPageToLoad(driver);
    }

    @Then("User verifies {string} button should be disabled")
    public void userVerifiesButtonShouldBeDisabled(String buttonName) {
        Assert.assertTrue(buttonName + "button Should be disabled", findElement(driver, String.format(onCommonMethodsPage.ariaLabelInputFields, buttonName)).getAttribute("style").contains("opacity: 0.5"));
    }

    @Then("User verifies menu {string} should not be present")
    public void verifyElementNotPresent(String menuName) {
        // Attempt to find the element using the provided selector
        WebElement element = null;
        try {
            element = findElement(driver, String.format(onCommonMethodsPage.anchorLinks, menuName)); // You can use other locators as well
        } catch (org.openqa.selenium.NoSuchElementException e) {

        }

        Assert.assertNull("Element should not be present but found: " + menuName, element);
    }

    @Then("User verify all documents are downloaded to system with name {string}")
    public void verifyFileDownloaded(String fileName) {
        captureScreenshot(driver, testContext, false);
        Path downloadFilePath = Paths.get(EnumsCommon.ABSOLUTE_DOWNLOADFILES_PATH.getText(), fileName);
        new WebDriverWait(driver, 60).until(d -> downloadFilePath.toFile().exists());
        downloadFilePath.toFile().delete();
    }


    @Then("User clicks red bubble icon")
    public void userClicksRedBubbleIcon() {
        waitForPageToLoad(driver);
        captureScreenshot(driver, testContext, false);
        onCommonMethodsPage.getRedColorErrorValidationBubble().click();
    }

    @Then("User close the dialog window {string}")
    public void userCloseTheDialogWindow(String windowName) {
        captureScreenshot(driver, testContext, false);
        clickElementByJSE(driver, findElement(driver, String.format(onCommonMethods_reactPage.btn_dialogWindowClose, windowName)));
    }

    @Then("User clicks Yes button")
    public void userClicksYesButton() {
        waitForPageToLoad(driver);
        captureScreenshot(driver, testContext, false);
        clickElement(driver, getElement(driver, getExistingLocator(driver, onReviewPage.getBtn_Ok_ConfPopupMVC(), onReviewPage.getBtn_Ok_ConfPopupReact(), null, null)));
    }

    @Then("User clicks {string} link for {string} document type after uploading documents")
    public void userClicksLinkAfterUploadingDocuments(String linkType, String documentType) {
        captureScreenshot(driver, testContext, false);
        switch (linkType.toLowerCase()) {
            case "view":
                clickElement(driver, String.format(onCommonMethods_reactPage.verifyViewLink, documentType));
                break;
            case "remove":
                if (findElements(driver, String.format(onCommonMethods_reactPage.verifyRemoveLink_MVC, documentType)).size() > 0)
                    clickElement(driver, findElement(driver, String.format(onCommonMethods_reactPage.verifyRemoveLink_MVC, documentType)));
                else
                    clickElement(driver, String.format(onCommonMethods_reactPage.verifyRemoveLink, documentType));
                break;
            default:
                Assert.fail("Invalid Link Type after uploading documents in Documents dialog window: " + linkType);
        }
    }

    @Then("User verifies Error Message for field")
    public void verifyErrorMessage(DataTable dataTable) {
        captureScreenshot(driver, testContext, false);
        List<Map<String, String>> formFields = dataTable.asMaps(String.class, String.class);
        waitForPageToLoad(driver);
        for (Map<String, String> fieldData : formFields) {
            String fieldName = fieldData.get("Field");
            String expectedValue = fieldData.get("Error Message");
            String partialText = fieldData.get("Partial Text");
            String locatorType = fieldData.get("Locator Type");
            String actualValue = null;
            switch (locatorType) {
                case "div":
                    if (testContext.getUiType().equalsIgnoreCase(EnumsCommon.UITYPE_MVC.getText())) {
                        actualValue = findElement(driver, String.format(onCommonMethodsPage.errorMessage, partialText)).getText().trim();
                        Assert.assertEquals("Expected field " + fieldName + " did not display correct error message", actualValue, expectedValue);
                    } else {
                        actualValue = findElement(driver, String.format(onCommonMethodsPage.errorMessage_React, partialText)).getText().trim();
                        Assert.assertEquals("Expected field " + fieldName + " did not display correct error message", actualValue, expectedValue);
                    }

                    break;
                default:
                    Assert.fail("Invalid Locator Type : " + locatorType);
            }
        }
        captureScreenshot(driver, testContext, false);
    }

    @Then("User verifies {string} link for {string} document type after uploading documents")
    public void userVerifyLinkAfterUploadingDocuments(String linkType, String documentType) {
        captureScreenshot(driver, testContext, false);
        switch (linkType.toLowerCase()) {
            case "view":
                if (findElements(driver, String.format(onCommonMethods_reactPage.verifyViewLink, documentType)).size() > 0)
                    Assert.assertTrue(linkType + " link is not showing after uploading document for " + documentType, findElement(driver, String.format(onCommonMethods_reactPage.verifyViewLink, documentType)).isDisplayed());
                else
                    Assert.assertTrue(linkType + " link is not showing after uploading document for " + documentType, findElement(driver, String.format(onCommonMethods_reactPage.verifyViewLinkReviewerPage, documentType)).isDisplayed());
                break;
            case "remove":
                if (findElements(driver, String.format(onCommonMethods_reactPage.verifyRemoveLink, documentType)).size() > 0)
                    Assert.assertTrue(linkType + " link is not showing after uploading document for " + documentType, findElement(driver, String.format(onCommonMethods_reactPage.verifyRemoveLink, documentType)).isDisplayed());
                else
                    Assert.assertTrue(linkType + " link is not showing after uploading document for " + documentType, findElement(driver, String.format(onCommonMethods_reactPage.verifyRemoveLinkReviewerPage, documentType)).isDisplayed());
                break;
            default:
                Assert.fail("Invalid Link Type : " + linkType);
        }
    }

    @Then("User Clicks on React Send Email Request")
    public void user_Clicks_on_React_Send_Email_Request() {
        captureScreenshot(driver, testContext, false);
        clickElement(driver, onCommonMethods_reactPage.getBtn_ReactSendEmailRequest());

    }

    @Then("User Clicks on React Generate Link Without Email")
    public void user_Clicks_on_React_Generate_Link_Without_Email() {
        captureScreenshot(driver, testContext, false);
        clickElement(driver, onCommonMethods_reactPage.getBtn_ReactGenerateLinkWithoutEmail());

    }

    @Then("User Verifies {string} present in PDF")
    public void user_Verifies_present_in_PDF(String text) {
        captureScreenshot(driver, testContext, false);
        String value = testContext.getMapTestData().get(text);
        Assert.assertTrue(text + " is not present in pdf", pdfText_global.contains(value));
    }

    @Then("User Verifies {string} is not present in PDF")
    public void user_Verifies_notpresent_in_PDF(String text) {
        captureScreenshot(driver, testContext, false);
        Assert.assertFalse(text + " is not present in pdf", pdfText_global.contains(text));
    }

    @Then("User verify generated PDF displays signature")
    public void verifySignPDFGeneratedSSN() throws Exception {
        //TODO : Date does not appear in pdf text
        Assert.assertTrue("Signed Image does not exist in generated PDF", verifySignatureMatchingInPDF(testContext, pdfFileName));
    }

    @Then("User opens page {string} of Form {string}")
    public void openPageofForm(String formName, String formMenu) throws InterruptedException {
        waitForPageToLoad(driver);
        captureScreenshot(driver, testContext, false);
        syncElement(driver, findElement(driver, onCommonMethods_reactPage.formListOpen), EnumsCommon.TOCLICKABLE.getText());
        findElement(driver, onCommonMethods_reactPage.formListOpen).click();
        sleepInMilliSeconds(4000);
        clickElementByJSE(driver, findElement(driver, String.format(onCommonMethods_reactPage.menuExpand, formMenu)));
    }

    @Then("User Clicks on {string} link for {string} document type")
    public void userClicksOnLink(String linkType, String documentType) {
        captureScreenshot(driver, testContext, false);
        switch (linkType.toLowerCase()) {
            case "view":
                clickElementByJSE(driver, findElement(driver, String.format(onCommonMethods_reactPage.verifyViewLink, documentType)));
                break;
            case "remove":
                clickElementByJSE(driver, findElement(driver, String.format(onCommonMethods_reactPage.verifyRemoveLink, documentType)));
                break;

            default:
                throw new FLException("Invalid Link Type : " + linkType);
        }
    }


    @Then("User opens {string} Application Login Page")
    public void userOpensFirelightApplicationLoginPage(String whichApp) {
        opensFLAppOrAdminLoginPage(driver, testContext, whichApp);
    }

    @Then("User delete all the cookies from browser")
    public void deleteAllCookies() {
        captureScreenshot(driver, testContext, false);
        driver.manage().deleteAllCookies();
    }

    @Then("User enters new Application name Second Time")
    public void userEntersNewApplicationNameSecondTime() {
        String newAppName = "AT " + testContext.getMapTestData().get("product") + " " + getDate("newAppName");
        onCreateApplicationPage.getTxtBox_newAppName().clear();
        onCreateApplicationPage.getTxtBox_newAppName().sendKeys(newAppName);
        addPropertyValueInJSON(testContext.getTestCaseID(), testContext, EnumsJSONProp.SECONDNEWPRODUCTNAME.getText(), newAppName);
        captureScreenshot(driver, testContext, false);
    }

    @Then("User {string} new tab in browser")
    public void openNewTab(String operation) {
        captureScreenshot(driver, testContext, false);
        if (operation.equalsIgnoreCase("open")) {
            ((JavascriptExecutor) driver).executeScript("window.open()");
            tabs = new ArrayList<>(driver.getWindowHandles());
            driver.switchTo().window(tabs.get(1));
        } else {
            if (tabs.size() > 1) {
                driver.close();
            }
            driver.switchTo().window(tabs.get(0));
        }
    }

    @Then("User verify page title is {string}")
    public void verifyTitlePage(String title) {
        captureScreenshot(driver, testContext, false);
        waitForPageToLoad(driver);
        Assert.assertTrue("Title of page is not " + title, driver.getTitle().equalsIgnoreCase(title));
    }

    @Then("User clicks on {string}")
    public void user_clicks_on(String btnName) {
        captureScreenshot(driver, testContext, false);
        clickElement(driver, String.format(CommonMethodsPage.btn_SelectFormsOption, btnName));
    }


    @Then("User verify {string} button is {string}")
    public void verifyState(String button, String state) {
        captureScreenshot(driver, testContext, false);
        try {
            String disabledValue = findElement(driver, "//button[contains(@class,'button" + button + "')]").getAttribute("disabled");
            Assert.assertTrue(button + " Button is enabled", disabledValue.equalsIgnoreCase("disabled"));
        } catch (Exception e) {
            Assert.assertTrue(button + " Button is disabled", state.equalsIgnoreCase("enabled"));
        }
    }

    @Then("User verifies toast message {string} or {string} on Application Page")
    public void user_verifies_toast_message_or_on_Application_Page(String message1, String message2) {
        waitForPageToLoad(driver);
        captureScreenshot(driver, testContext, false);
        Assert.assertTrue(message1 + " or " + message2 + ":: Toast popup NOT Visible", onCommonMethods_reactPage.getToastPopup_ApplicationPending().getAttribute("innerText").contains(message1) || onCommonMethods_reactPage.getToastPopup_ApplicationPending().getAttribute("innerText").contains(message2));

    }

    @Then("User clicks on lock icon")
    public void user_clicks_on_lock_icon() {
        waitForPageToLoad(driver);
        captureScreenshot(driver, testContext, false);
        clickElement(driver, onDataEntryPage.getCanvasReadOnlyForm());
    }

    @Then("User verifies Activity Summary Dialog box is displayed")
    public void user_verifies_Activity_Summary_Dialog_box_is_displayed() {
        waitForPageToLoad(driver);
        captureScreenshot(driver, testContext, false);
        Assert.assertTrue("Activity Summary Dialog box was not displayed", onDataEntryPage.getDialogBoxActivitySummary().isDisplayed());
    }

    @Then("User Clicks on form {string} Required for Form Menu {string}")
    public void openRequiredFormFromMenu(String formName, String formMenu) {
        waitForPageToLoad(driver);
        clickElementByJSE(driver, getElement(driver, getExistingLocator(driver, By.xpath(String.format(onCreateApplicationPage.getFormName1(), formMenu, formName)), By.xpath(String.format(onCreateApplicationPage.getFormName2(), formMenu, formName)), By.xpath(String.format(onCreateApplicationPage.getFormName3(), formMenu, formName)), null)));

    }

    @Then("User Verifies on form {string} Required for Form Menu {string} is Disabled")
    public void userVerifiesRequiredFormFromMenu(String formName, String formMenu) {
        waitForPageToLoad(driver);
        Assert.assertFalse(formName + " was enabled", getElement(driver, getExistingLocator(driver, By.xpath(String.format(onCreateApplicationPage.getFormName1(), formMenu, formName)), By.xpath(String.format(onCreateApplicationPage.getFormName2(), formMenu, formName)), By.xpath(String.format(onCreateApplicationPage.getFormName3(), formMenu, formName)), By.xpath(String.format(onCreateApplicationPage.getFormName4(), formMenu, formName)))).getAttribute("value").contains("disabled"));
    }

    @Then("User verifies {string} Main Form is displayed")
    public void userVerifiesMainFormIsDisplay(String form) {
        waitForPageToLoad(driver);
        captureScreenshot(driver, testContext, false);
        Assert.assertTrue(form + " form is not displayed", getElement(driver, getExistingLocator(driver, By.xpath(String.format(onCreateApplicationPage.getMainFormName(), form)), null, null, null)).isDisplayed());
    }

    @Then("User verifies toast message {string} in React Page")
    public void userVerifiesTostMessageReact(String message) {
        syncElement(driver, onReviewPage.getAlert_MessageSentReact(), EnumsCommon.TOVISIBLE.getText());
        captureScreenshot(driver, testContext, false);
        Assert.assertTrue(message + ":: Toast popup NOT Visible", onReviewPage.getAlert_MessageSentReact().getText().trim().contains(message));
    }

    @Then("User verifies that the menu item {string} is {string}")
    public void verifyMenuItemCondition(String menuItem, String condition) {
        waitForPageToLoad(driver);
        captureScreenshot(driver, testContext, false);
        // Find the div containing the menu items
        WebElement menuDiv = driver.findElement(By.id("divOtherActions"));
        List<WebElement> menuItems = null;
        // Find all anchor elements within the div
        menuItems = menuDiv.findElements(By.xpath("//*[@id='divOtherActions']//span|//*[@id='divOtherActions']//a"));
        // Check if the menu item is present and disabled
        boolean menuItemPresent = false;
        boolean menuItemDisabled = false;
        for (WebElement item : menuItems) {
            if (item.getText().trim().equalsIgnoreCase(menuItem.trim())) {
                menuItemPresent = true;

                // Check if the menu item is disabled
                if (item.getAttribute("class").contains("disabledMenuLink")) {
                    menuItemDisabled = true;
                }

                break;
            }
        }
        // Check the expected condition
        if (condition.equalsIgnoreCase("present")) {
            Assert.assertTrue("Menu item '" + menuItem + "' should be present, but it is not.", menuItemPresent);
        } else if (condition.equalsIgnoreCase("disabled")) {
            Assert.assertTrue("Menu item '" + menuItem + "' should be disabled, but it is not.", menuItemDisabled);
        } else if (condition.equalsIgnoreCase("not present")) {
            Assert.assertFalse("Menu item '" + menuItem + "' should not be present, but it is.", menuItemPresent);
        } else if (condition.equalsIgnoreCase("enabled")) {
            Assert.assertFalse("Menu item '" + menuItem + "' should not be disabled, but it is.", menuItemDisabled);
        } else {
            throw new FLException("Invalid condition Provided : " + condition);
        }
    }

    @Then("User verifies toast message of {string}")
    public void user_verifies_toast_message_of(String inputValue) {
        waitForPageToLoad(driver);
        captureScreenshot(driver, testContext, false);
        if (inputValue.contains("finished") & onCommonMethodsPage.getPopUpMessage().getText().trim().contains("pending"))
            driver.navigate().refresh();
        Assert.assertTrue("Message mismatched", onCommonMethodsPage.getPopUpMessage().getText().trim().contains(inputValue));
    }

    @Then("User verifies toast message {string} disappears")
    public void user_verifies_toast_message_disappears(String message) {
        captureScreenshot(driver, testContext, false);
        Assert.assertFalse(message + "Popup was not disappeared", onCommonMethodsPage.getList_popupToastWrapper().size() > 0);
        captureScreenshot(driver, testContext, false);
    }

    @Then("User opens {string} Required for Form {string} FormOnly MVC")
    public void user_opens_Required_for_Form_FormOnly_MVC(String formName, String formMenu) throws InterruptedException {
        waitForPageToLoad(driver);
        captureScreenshot(driver, testContext, false);
        if (findElements(driver, onCommonMethods_reactPage.formListOpen).size() > 0) {
            syncElement(driver, findElement(driver, onCommonMethods_reactPage.formListOpen), EnumsCommon.TOCLICKABLE.getText());
            findElement(driver, onCommonMethods_reactPage.formListOpen).click();
            syncElement(driver, findElement(driver, onCommonMethods_reactPage.expandAllFormList), EnumsCommon.TOCLICKABLE.getText());
            if (findElement(driver, String.format(onCommonMethods_reactPage.expandMandetoryFormList, formMenu)).getText().equalsIgnoreCase("▼"))
                clickElementByJSE(driver, findElement(driver, String.format(onCommonMethods_reactPage.expandMandetoryFormList, formMenu)));
            Thread.sleep(2000);
            List<WebElement> mandetoryFormList = findElements(driver, String.format(onCommonMethods_reactPage.mandatoryFormListMVCForms, formMenu));
            int i = 0;
            for (WebElement element : mandetoryFormList) {
                String form = element.getAttribute("innerText");
                if (form.contains(formMenu)) {
                    clickElementByJSE(driver, element);
                    break;
                }
            }
        } else {
            onCreateApplicationPage.getWizardPageNameExpand().click();
            List<WebElement> mandetoryFormList = findElements(driver, String.format(onCreateApplicationPage.mandetoryFormList, formMenu));
            int i = 0;
            for (WebElement element : mandetoryFormList) {
                String form = element.getAttribute("innerText");
                if (form.equals(formName)) {
                    element.click();
                    break;
                }
            }
        }
    }

    @Then("User verifies prefilled data Form input text fields should be blank")
    public void user_verifies_prefilled_data_Form_input_text_fields_should_be_blank(DataTable dataTable) {
        captureScreenshot(driver, testContext, false);
        List<Map<String, String>> formFields = dataTable.asMaps(String.class, String.class);
        for (Map<String, String> fieldData : formFields) {
            String fieldName = fieldData.get("Field");
            String dataItemId = fieldData.get("data-dataitemid");
            String id = fieldData.get("Id");
            String locatorType = fieldData.get("Locator Type");

            switch (locatorType) {
                case "Input":
                    scrollToWebElement(driver, findElement(driver, String.format(onCommonMethodsPage.getDataFieldsMVC(), dataItemId,id)));
                    Assert.assertFalse(" The values are not blank for "+ fieldName, findElement(driver, String.format(onCommonMethodsPage.getDataFieldsMVC(), dataItemId,id)).getAttribute("value").length() > 0);
                    break;
                case "Select":
                    scrollToWebElement(driver, findElement(driver, String.format(onDataEntryPage.dataFieldsMVC2, dataItemId)));
                    Assert.assertFalse("The values are not blank ", findElement(driver, String.format(onDataEntryPage.dataFieldsMVC2, dataItemId)).getAttribute("value").length() > 0);
                    break;

                case "Textarea":
                    scrollToWebElement(driver, findElement(driver, String.format(onCommonMethods_reactPage.txtAreaInput, dataItemId)));
                    Assert.assertFalse("The values are not blank ", findElement(driver, String.format(onCommonMethods_reactPage.txtAreaInput, dataItemId)).getAttribute("value").length() > 0);
                    break;

                default:

                    throw new FLException("Invalid Locator Type : " + locatorType);
            }
        }
        captureScreenshot(driver, testContext, false);
    }

    @Then("User enters new Activity name as {string}")
    public void userEntersNewActivityNameAs(String activityName) {
        onCreateApplicationPage.getTxtBox_newAppName().clear();
        onCreateApplicationPage.getTxtBox_newAppName().sendKeys(activityName);
        addPropertyValueInJSON(testContext.getTestCaseID(), testContext, EnumsJSONProp.NEWACTIVITYNAME.getText(), activityName);
        captureScreenshot(driver, testContext, false);
    }

    @Then("User clicks on {string} link of data entry met Toast popup_Updated")
    public void userClicksOnLinkOfDataEntryMetToastPopup_Updated(String whichLink) {
        driver.navigate().refresh();
        waitForPageToLoad(driver);
        captureScreenshot(driver, testContext, false);
        if (findElements(driver, String.format(onCommonMethods_reactPage.link_toastPopUp, whichLink)).size() > 0) {
            clickElement(driver, findElement(driver, String.format(onCommonMethods_reactPage.link_toastPopUp, whichLink)));
        } else {
            if (whichLink.equalsIgnoreCase("Continue"))
                clickElement(driver, getElement(driver, getExistingLocator(driver, onDataEntryPage.getLink_DataEntryPopupContinueMVC(), onDataEntryPage.getLink_DataEntryPopupContinueReact(), null, null)));
            else
                clickElement(driver, onDataEntryPage.getLink_DataEntryPopupMoreData_New());
        }
    }

    @Then("User Refresh the Page")
    public void user_Refresh_the_page() {
        captureScreenshot(driver, testContext, false);
        waitForPageToLoad(driver);
        driver.navigate().refresh();
    }

    @Then("user verifies {string} are displayed")
    public void userVerifiesAreDisplayed(String fieldType) {
        switch (fieldType) {
            case "checkboxes":
                if (findElements(driver, String.format(onCommonMethods_reactPage.ariaLabelInputFields, testContext.getMapTestData().get("reviewQueuePage"), testContext.getMapTestData().get("reviewQueuePage"))).size() > 0) {
                    String[] expected = {"Week", "Month", "Quarter", "YTD", "OneYear", "TwoYears", "All"};
                    List<WebElement> allOptions = onCreateApplicationPage.getDd_ReviewProductType();
                    for (int i = 0; i < expected.length; i++) {
                        boolean flag = false;
                        String optionValue = allOptions.get(i).getAttribute("id");
                        if (optionValue.equalsIgnoreCase(expected[i])) {
                            flag = true;
                        }
                        Assert.assertTrue("Search criteria is not displayed", flag);
                    }
                } else {
                    String[] expected1 = {"Week", "Month", "Quarter", "YTD", "All"};
                    List<WebElement> allOptions = onCreateApplicationPage.getDd_PrdctType();
                    for (int i = 0; i < expected1.length; i++) {
                        boolean flag = false;
                        String optionValue = allOptions.get(i).getAttribute("id");
                        if (optionValue.equalsIgnoreCase(expected1[i])) {
                            flag = true;
                        }
                        Assert.assertTrue("Search criteria is not displayed", flag);
                    }
                }
                break;
            case "dropDowns":
                String[] expectedDropDown = {"userId", "locale", "activityType", "productTypeFilter", "stType", "sortBy", "signTypes"};
                List<WebElement> allDropDowns = onCreateApplicationPage.getList_dropDown();
                for (int i = 0; i < expectedDropDown.length; i++) {
                    boolean flag = false;
                    String options = allDropDowns.get(i).getAttribute("id");
                    if (options.equalsIgnoreCase(expectedDropDown[i])) {
                        flag = true;
                    }
                    Assert.assertTrue("Search criteria is not displayed", flag);
                }
                break;
            default:
                throw new FLException("Invalid Field Type: " + fieldType);
        }
    }


    @Then("User verifies Audit History status")
    public void user_verifies_audit_history(DataTable dataTable) {
        waitForPageToLoad(driver);
        captureScreenshot(driver, testContext, false);
        List<Map<String, String>> statusDescriptions = dataTable.asMaps(String.class, String.class);
        for (Map<String, String> row : statusDescriptions) {
            String expectedStatus = row.get("Status");
            String expectedDescription = row.get("Status Description");
            for (WebElement status : onCommonMethodsPage.getAuditDisplayStatus()) {
                syncElement(driver, status, EnumsCommon.TOVISIBLE.getText());
                if (status.getText().trim().equalsIgnoreCase(expectedStatus)) {
                    Assert.assertTrue("Status should be" + expectedStatus, status.getAttribute("innerText").contains(expectedStatus));
                    WebElement description = driver.findElement(By.xpath("//*[@class=\"auditDisplayStatus\"]/following-sibling::strong[normalize-space()='" + status.getText().trim() + "']/parent::div/following-sibling::div"));
                    if (!expectedDescription.isEmpty()) {
                        if (!description.getText().trim().contains(expectedDescription)) {
                            Assert.assertTrue("Description should be " + expectedDescription + " but found " + description.getText().trim(), description.getText().trim().replaceAll("[^\\x00-\\x7F]", "").contains(expectedDescription));
                        } else {
                            Assert.assertTrue("Description should be " + expectedDescription + " but found " + description.getText().trim(), description.getText().trim().contains(expectedDescription));
                        }
                    }
                }
            }
        }
    }

    @Then("User select {string} button on Signature Tab")
    public void userSelectButtonOnSignatureTab(String buttonName) {
        waitForPageToLoad(driver);
        captureScreenshot(driver, testContext, false);
        clickElement(driver, String.format(onCommonMethods_reactPage.getBtn_DocSign(), buttonName));
    }

    @Then("User verifies pdf text not present in Pdf For AuditReport")
    public void userVerifiesPdfTextForAuditReport(DataTable dataTable) {

        List<String> data = dataTable.asList(String.class);
        for (String fieldValue : data) {
            if (fieldValue.contains("Application Name")) {
                Assert.assertFalse("Application is present in pdf", pdfText_global.contains(testContext.getMapTestData().get("newProductName")));
            }
            Assert.assertFalse(fieldValue + " is present in pdf", pdfText_global.contains(fieldValue));
        }
    }

    @Then("User Verifies Optional Form {string}")
    public void userVerifiessOptionalForm(String formName) {
        waitForPageToLoad(driver);
        captureScreenshot(driver, testContext, false);
        Assert.assertTrue("Optional Form Not found", findElement(driver, String.format(onCommonMethodsPage.getText_OptionalForms(), formName)).isDisplayed());
    }

    @Then("User Verifies Optional Form {string} not showing")
    public void userVerifiessOptionalFormNotShowing(String formName) {
        waitForPageToLoad(driver);
        captureScreenshot(driver, testContext, false);
        for (WebElement form : onCommonMethodsPage.getList_forms()) {
            if (form.getText().trim().equalsIgnoreCase(formName)) {
                Assert.assertFalse("Optional Form found", true);
            }
        }
    }

    @Then("User Verifies {string} is not Read Only")
    public void user_Verifies_is_not_Read_Only(String fieldName) {
        captureScreenshot(driver, testContext, false);
        boolean flag = true;
        try {
            onCommonMethodsPage.findElement(driver, String.format(onCommonMethodsPage.ariaLabelInputFields, fieldName)).sendKeys("editable");
        } catch (Exception e) {
            flag = false;
        }
        if (onCommonMethodsPage.findElement(driver, String.format(onCommonMethodsPage.ariaLabelInputFields, fieldName)).getAttribute("value").equalsIgnoreCase("editable"))
            flag = false;

        Assert.assertFalse(fieldName + " is not Readonly", flag);
    }

    @Then("User Verifies {string} is Read Only")
    public void user_Verifies_is_not_Only(String fieldName) {
        captureScreenshot(driver, testContext, false);
        Assert.assertTrue(fieldName + " is not Readonly", onCommonMethodsPage.findElement(driver, String.format(onCommonMethodsPage.ariaLabelInputFields, fieldName)).getAttribute("readonly").equalsIgnoreCase("true") || onCommonMethodsPage.findElement(driver, String.format(onCommonMethodsPage.ariaLabelInputFields, fieldName)).getAttribute("readonly").equalsIgnoreCase("readonly"));
    }

    @Then("User verifies {string} is enabled")
    public void user_verifies_is_enabled(String field) {
        captureScreenshot(driver, testContext, false);
        Assert.assertTrue(field + "was not enabled", findElement(driver, String.format(onCommonMethods_reactPage.formCheckBox, field, field)).getAttribute("class").contains("Enabled"));
    }

    @Then("User verifies dialog window {string} Closed")
    public void userVerifiesDialogWindowClosed(String windowName) {
        waitForPageToLoad(driver);
        captureScreenshot(driver, testContext, false);
        if (getElements(driver, onCommonMethodsPage.getDialog_WindowNameMVC()).size() > 0)
            Assert.assertFalse(windowName + " is open", getElements(driver, onCommonMethodsPage.getDialog_WindowNameMVC()).get(0).getText().equals(windowName));
    }

    @Then("User clicks on close history dialog box")
    public void userclicksonCloseHistorydialogbox() {
        captureScreenshot(driver, testContext, false);
        clickElement(driver, onCommonMethodsPage.getHistoryTabCloseButton());
    }

    @Then("User verifies toast message as {string}")
    public void user_verifies_toast_message_as(String message) {
        captureScreenshot(driver, testContext, false);
        driver.navigate().refresh();
        ((JavascriptExecutor) driver).executeScript("debugger;");
        WebElement element = getElement(driver, getExistingLocator(driver, onCommonMethodsPage.getPopup_ToastMVC(), onCommonMethodsPage.getPopup_ToastReact(), null, null));
        syncElement(driver, element, EnumsCommon.TOVISIBLE.getText());
        Assert.assertTrue("Toast popup was not Visible- " + message, element.getAttribute("innerText").contains(message));
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
                        syncElement(driver,findElement(driver, String.format(onCommonMethodsPage.getDataFieldsMVC(), dataItemId, id)),EnumsCommon.TOCLICKABLE.getText());
                        findElement(driver, String.format(onCommonMethodsPage.getDataFieldsMVC(), dataItemId, id)).click();
                        syncElement(driver,findElement(driver, String.format(onCommonMethodsPage.getMsg_ErrorMessageTextBox(), dataItemId, id)),EnumsCommon.TOVISIBLE.getText());
                        Assert.assertEquals(fieldName + ": {" + validationError + "} is not showing required field error message in red color",validationError, findElement(driver, String.format(onCommonMethodsPage.getMsg_ErrorMessageTextBox(), dataItemId, id)).getAttribute("innerText").trim());
                    } else {
                        Assert.fail("Expected Validation Message was Absent");
                    }
                    break;
                case "Select":
                    if (!validationError.equals("")) {
                        findElement(driver, String.format(onCommonMethodsPage.getElementByIdOrDataItemId(), dataItemId,dataItemId, id)).click();
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

    @Then("User Enters data for")
    public void User_Enters_data_for(DataTable dataTable) {
        List<Map<String, String>> formFields = dataTable.asMaps(String.class, String.class);
        captureScreenshot(driver, testContext, false);
        for (Map<String, String> fieldData : formFields) {
            String fieldName = fieldData.get("Field");
            String dataItemId = fieldData.get("data-dataitemid");
            String id = fieldData.get("Id");
            String locatorType = fieldData.get("Locator Type");
            String value = fieldData.get("Value");

            switch (locatorType) {
                case "Input":
                    if (!value.equals("")) {
                        sendKeys(driver, findElement(driver, String.format(onCommonMethods_reactPage.requiredFieldsError, dataItemId, fieldName)), value);
                    } else {
                        Assert.fail("Value to enter was Absent");
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
                        new Select(findElement(driver, String.format(onCommonMethodsPage.getElementByIdOrDataItemId(),dataItemId, dataItemId, id))).selectByVisibleText(option);
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
        new Select(findElement(driver, String.format(onCommonMethodsPage.getElementByIdOrDataItemId(),ddDataItemId, ddDataItemId, ddId))).selectByVisibleText("");

    }

    @Then("User Verifies Default Option is {string} for dropdown {string}")
    public void User_verifies_Validation_Message_for(String option, String ddName, DataTable dataTable) {
        List<Map<String, String>> formFields = dataTable.asMaps(String.class, String.class);
        captureScreenshot(driver, testContext, false);
        for (Map<String, String> fieldData : formFields) {
            String fieldName = fieldData.get("Field");
            String dataItemId = fieldData.get("data-dataitemid");
            String id = fieldData.get("Id");
            String locatorType = fieldData.get("Locator Type");
            sleepInMilliSeconds(3000);
            switch (locatorType) {
                case "Select":
                    Assert.assertEquals(option + " was not selected by default for " + ddName, option, new Select(findElement(driver, String.format(onCommonMethodsPage.getElementByIdOrDataItemId(),dataItemId, dataItemId, id))).getFirstSelectedOption().getText().trim());
            }
        }
    }

    @Then("User Verifies heading as Create Activity")
    public void user_Verifies_heading_as_Create_Activity() {
        captureScreenshot(driver, testContext, false);
        Assert.assertEquals("Remove Link is displayed and it should not display","Create Activity", onCommonMethodsPage.getHeading_CreateActivity().getText().trim());
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
                        waitUntilDropDownListPopulated(driver,new Select(findElement(driver, String.format(onCommonMethodsPage.getElementByIdOrDataItemId(), dataItemId,dataItemId, id))));
                     Assert.assertTrue(option +" was not present in "+ fieldName, new Select(findElement(driver, String.format(onCommonMethodsPage.getElementByIdOrDataItemId(),dataItemId, dataItemId, id))).getWrappedElement().getText().trim().contains(option));
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
            if(! findElement(driver, String.format(onCommonMethodsPage.getRadioBtn_AsPerDataItemId(), dataItemId, option)).isSelected());
            clickElement(driver, findElement(driver, String.format(onCommonMethodsPage.getRadioBtn_AsPerDataItemId(), dataItemId, option)));
        }
    }

    @Then("User Unchecks {string} Radio Button for Field {string}")
    public void user_Unchecks_Radio_Button_for_Field(String option, String field, DataTable dataTable) {
        List<Map<String, String>> formFields = dataTable.asMaps(String.class, String.class);
        captureScreenshot(driver, testContext, false);
        for (Map<String, String> fieldData : formFields) {
            String dataItemId = fieldData.get("data-dataitemid");
            String id = fieldData.get("Id");
            if( findElement(driver, String.format(onCommonMethodsPage.getRadioBtn_AsPerDataItemId(), dataItemId, option)).isSelected());
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
    @Then("User Verifies Blank option present for Dropdown")
    public void User_Verifies_Blank_options_present_for_Dropdown(DataTable dataTable) {
        List<Map<String, String>> formFields = dataTable.asMaps(String.class, String.class);
        captureScreenshot(driver, testContext, false);
        for (Map<String, String> fieldData : formFields) {
            String fieldName = fieldData.get("DropdownName");
            String dataItemId = fieldData.get("data-dataitemid");
            String id = fieldData.get("Id");
            String locatorType = fieldData.get("Locator Type");
            switch (locatorType) {
                case "Select":
                        Assert.assertTrue("Blank option was not present in "+ fieldName, new Select(findElement(driver, String.format(onCommonMethodsPage.getElementByIdOrDataItemId(),dataItemId, dataItemId, id))).getOptions().get(0).getText().isEmpty());
                        break;
                default:
                    Assert.fail("Invalid Locator Type" + locatorType);
            }

        }
    }

    @Then("User Verifies Below Options Present for Lookup {string}")
    public void user_Verifies_Below_Options_Present_for_Mailing_Address_Lookup(String lookup,DataTable dataTable) {
        List<Map<String, String>> formFields = dataTable.asMaps(String.class, String.class);
        captureScreenshot(driver, testContext, false);
        for (Map<String, String> fieldData : formFields) {
            boolean flag = false;
            String option = fieldData.get("Option");
            for(WebElement mailingAdress:onCommonMethodsPage.getList_MailingAdress()){
                if(mailingAdress.getText().trim().equalsIgnoreCase(option)){
                    flag = true;
                    break;
                }
            }
            Assert.assertTrue(option +" was not present Lookup "+ lookup, flag);
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

                    new Actions(driver).moveToElement(element).click().doubleClick().click().sendKeys(Keys.BACK_SPACE,Keys.TAB).perform();
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

    @Then("User Selects Option for Lookup {string}")
    public void user_Selects_Option_for_Mailing_Address_Lookup(String lookup,DataTable dataTable) {
        List<Map<String, String>> formFields = dataTable.asMaps(String.class, String.class);
        captureScreenshot(driver, testContext, false);
        for (Map<String, String> fieldData : formFields) {
            String option = fieldData.get("Option");
            for(WebElement mailingAdress:onCommonMethodsPage.getList_MailingAdress()){
                if(mailingAdress.getText().trim().equalsIgnoreCase(option)){
                    clickElementByJSE(driver,mailingAdress);
                    break;
                }
            }
        }
        sleepInMilliSeconds(3000);
    }

    @Then("User {string} checkbox {string}")
    public void userSelectsCheckbox(String userAction, String whichCheckBox) {
        waitForPageToLoad(driver);
        scrollToWebElement(driver, findElement(driver, String.format(onCommonMethodsPage.chk_Option, whichCheckBox)));
        checkBoxSelectYesNO(userAction, findElement(driver, String.format(onCommonMethodsPage.chk_Option, whichCheckBox)));
        captureScreenshot(driver, testContext, false);
    }

    protected void checkBoxSelectYesNO(String userAction, WebElement element) {
        System.out.println(getCheckBoxAction(userAction));
        if (getCheckBoxAction(userAction)){
            if (element.getAttribute("aria-checked").equals("false"))
                element.click();
        }else {
            if (element.getAttribute("aria-checked").equals("true"))
                element.click();
        }
    }

    private boolean getCheckBoxAction(String action) {
        return action.equalsIgnoreCase("check");
    }

    @Then("User verifies fields is not Present in UI")
    public void user_verifies_text_fields_is_not_present_in_UI(DataTable dataTable) {
        waitForPageToLoad(driver);
        captureScreenshot(driver, testContext, false);
        List<Map<String, String>> formFields = dataTable.asMaps(String.class, String.class);
        for (Map<String, String> fieldData : formFields) {
            String fieldName = fieldData.get("Field");
            String dataItemId = fieldData.get("data-item-id");
            String id = fieldData.get("Id");
            String locatorType = fieldData.get("Locator Type");
            switch (locatorType) {
                case "Input":
                    Assert.assertFalse(fieldName+" Field was Present", findElements(driver, String.format(onCommonMethodsPage.getDataFieldsMVC(), dataItemId, id)).size() > 0);
                    break;
                case "Select":
                    Assert.assertFalse(fieldName+" Field was Present", findElements(driver, String.format(onCommonMethodsPage.getDataFieldsSelectTag(), dataItemId, id)).size()> 0);
                    break;
                default:
                    Assert.fail("Invalid Locator Type" + locatorType);
            }
        }
    }

    @Then("User Verifies {string} Radio Button for Field {string}")
    public void user_Verifies_Radio_Button_for_Field(String option, String field, DataTable dataTable) {
        List<Map<String, String>> formFields = dataTable.asMaps(String.class, String.class);
        captureScreenshot(driver, testContext, false);
        for (Map<String, String> fieldData : formFields) {
            String dataItemId = fieldData.get("data-dataitemid");
            String id = fieldData.get("Id");
            syncElement(driver,findElement(driver, String.format(onCommonMethodsPage.getRadioBtn_AsPerDataItemId(), dataItemId, option)),EnumsCommon.TOVISIBLE.getText());
            Assert.assertTrue(option+ " Radio button for "+ field + " was not Displayed", findElement(driver, String.format(onCommonMethodsPage.getRadioBtn_AsPerDataItemId(), dataItemId, option)).isDisplayed());
        }
    }

    @Then("User Verifies {string} Radio Button for Field {string} is {string}")
    public void userVerifiesSelectsCheckbox( String button, String fieldName, String userAction, DataTable dataTable) {
        waitForPageToLoad(driver);
        List<Map<String, String>> formFields = dataTable.asMaps(String.class, String.class);
        captureScreenshot(driver, testContext, false);
        for (Map<String, String> fieldData : formFields) {
            String dataItemId = fieldData.get("data-dataitemid");
            String id = fieldData.get("Id");

            syncElement(driver,findElement(driver, String.format(onCommonMethodsPage.getRadioBtn_AsPerDataItemId(), dataItemId, button)),EnumsCommon.TOVISIBLE.getText());
            scrollToWebElement(driver,findElement(driver, String.format(onCommonMethodsPage.getRadioBtn_AsPerDataItemId(), dataItemId, button)));

            switch (userAction.toLowerCase()) {
                case "selected":
                    Assert.assertTrue(button + " for " + fieldName + " was not " + userAction, findElement(driver, String.format(onCommonMethodsPage.getRadioBtn_AsPerDataItemId(), dataItemId, button)).isSelected() | findElement(driver, String.format(onCommonMethodsPage.getRadioBtn_AsPerDataItemId(), dataItemId, button)).getAttribute("aria-checked").equalsIgnoreCase("true"));
                    break;
                case "unchecked":
                    Assert.assertFalse(button + " for " + fieldName + " was not " + userAction, findElement(driver, String.format(onCommonMethodsPage.getRadioBtn_AsPerDataItemId(), dataItemId, button)).isSelected() | findElement(driver, String.format(onCommonMethodsPage.getRadioBtn_AsPerDataItemId(), dataItemId, button)).getAttribute("aria-checked").equalsIgnoreCase("false"));
                    break;
                default:
                    Assert.fail("Invalid user Action" + userAction);
            }
        }
    }

    @Then("User {string} checkbox {string} with data item Id {string}")
    public void userSelectsCheckbox(String userAction, String whichCheckBox, String dataItemId) {
        waitForPageToLoad(driver);
        scrollToWebElement(driver, findElement(driver, String.format(onCommonMethodsPage.getChkBox_ByDataItemId(), dataItemId)));
        checkBoxSelectYesNO(userAction, findElement(driver, String.format(onCommonMethodsPage.getChkBox_ByDataItemId(), dataItemId)));
        captureScreenshot(driver, testContext, false);
    }
    @Then("User verifies Agent Information is displayed on Agent Module Header")
    public void user_Verifies_Agent_Information_Is_Displayed_on_Header() {
        captureScreenshot(driver, testContext, false);
        Assert.assertTrue("Agent Information is not Displayed",getElement(driver, getExistingLocator(driver, onCommonMethodsPage.getTxt_AgentInformation(), null, null, null)).isDisplayed());
        Assert.assertTrue("Agent Information is not Displayed",getElement(driver, getExistingLocator(driver, onCommonMethodsPage.getTxt_AgentInformation(), null, null, null)).isDisplayed());
    }

}

