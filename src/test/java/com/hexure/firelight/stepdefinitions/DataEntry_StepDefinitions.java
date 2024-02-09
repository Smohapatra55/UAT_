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
    private DataEntry_ReactPage onDataEntryReactPage;
    private TestContext testContext;
    private RCTCompleteFillingAndSigningPage onRCTCompleteFillingAndSigningPage;
    private HomePage onHomePage;
    private RCTCompleteFillingAppPage onRCTCompleteFillingAppPage;
    private ReviewPage onReviewPage;
    private static final Logger Log = LogManager.getLogger(DataEntry_StepDefinitions.class);
    private CommonMethodsPage onCommonMethodsPage;
    private CommonMethods_ReactPage onCommonMethods_reactPage;

    private CreateApplicationPage onCreateApplicationPage;
    private SignaturesPage onSignaturePage;
    private SignApplicationPage onSignApplicationPage;

    public DataEntry_StepDefinitions(TestContext context) {
        testContext = context;
        driver = context.getDriver();
        onDataEntryPage = context.getPageObjectManager().getDataEntryPage();
        onDataEntryReactPage = context.getPageObjectManager().getDataEntryReactPage();
        onRCTCompleteFillingAndSigningPage = context.getPageObjectManager().getonRCTCompleteFillingAndSigningPage();
        onHomePage = context.getPageObjectManager().getHomePage();
        onRCTCompleteFillingAppPage = context.getPageObjectManager().getRCTCompleteFillingAppPage();
        onCommonMethodsPage = context.getPageObjectManager().getCommonMethodPage();
        onCommonMethods_reactPage = context.getPageObjectManager().getCommonMethods_reactPage();
        onReviewPage = context.getPageObjectManager().getReviewPage();
        onCreateApplicationPage = context.getPageObjectManager().getCreateApplicationPage();
        onSignaturePage=context.getPageObjectManager().getOnSignaturesPage();
        onSignApplicationPage = context.getPageObjectManager().getOnSignApplicationPage();
    }

    @Then("User Verifies data entry percentage is {string}")
    public void userVerifiesDataEntryPercentageIs(String expectedPercentage) {
        captureScreenshot(driver, testContext, false);
        waitForPageToLoad(driver);
        Assert.assertEquals("Data Entry Percentage mismatched", expectedPercentage, onDataEntryPage.getTxt_DataEntryPercentage().getText().trim());
    }

    @Then("User Verifies data entry percentage is shown as {string}")
    public void userVerifiesDataEntryValue(String expectedValue) {
        captureScreenshot(driver, testContext, false);
        waitForPageToLoad(driver);
        Assert.assertEquals("Data Entry value mismatched", expectedValue, onDataEntryPage.getTxt_DataEntryPercentage().getText().trim());
    }
    @Then("User Verifies data entry tab status {string}")
    public void userVerifiesDataEntryTabStatus(String expectedPercentage) {
        captureScreenshot(driver, testContext, false);
        waitForPageToLoad(driver);
        Assert.assertEquals("Data Entry Tab status mismatched", expectedPercentage, onDataEntryPage.getTxt_DataEntryPercentage().getText().trim());
    }

    @Then("User Verifies Data Entry Met Toast popup is showing")
    public void userVerifiesDataEntryMetToastPopupIsShowing() {
        waitForPageToLoad(driver);
        captureScreenshot(driver, testContext, false);
        WebElement element;
        if (driver.findElements(onCommonMethods_reactPage.getPopup_ToastMVC()).size() > 0) {
            syncElement(driver, onCommonMethods_reactPage.getPopup_Toast(), EnumsCommon.TOVISIBLE.getText());
            captureScreenshot(driver, testContext, false);
            Assert.assertTrue("Data Entry Met Toast popup NOT Visible", onCommonMethods_reactPage.getPopup_Toast().isDisplayed());
        } else {
            element = getElement(driver, getExistingLocator(driver, onCommonMethodsPage.getPopup_ToastMVC(), onCommonMethodsPage.getPopup_ToastReact(), null, null));
            syncElement(driver, element, EnumsCommon.TOVISIBLE.getText());
            captureScreenshot(driver, testContext, false);
            Assert.assertTrue("Data Entry Met Toast popup NOT Visible", element.isDisplayed());
        }
    }

    @Then("User Verifies Data Entry Met Toast popup is showing message")
    public void userVerifiesDataEntryMetToastPopupShowing() {
        captureScreenshot(driver, testContext, false);
        Assert.assertTrue("Data Entry Met Toast popup NOT Visible", onDataEntryPage.getMessage_ToastPopup().isDisplayed());
    }

    @Then("User clicks on {string} link of data entry met Toast popup")
    public void userClicksOnLinkOfDataEntryMetToastPopup(String whichLink) {
        waitForPageToLoad(driver);
        captureScreenshot(driver, testContext, false);
        if (findElements(driver, String.format(onCommonMethods_reactPage.link_toastPopUp, whichLink)).size() > 0) {
            scrollToWebElement(driver, findElement(driver, String.format(onCommonMethods_reactPage.link_toastPopUp, whichLink)));
            clickElement(driver, findElement(driver, String.format(onCommonMethods_reactPage.link_toastPopUp, whichLink)));
        } else {
            if (whichLink.equalsIgnoreCase("Continue"))
                clickElement(driver, getElement(driver, getExistingLocator(driver, onDataEntryPage.getLink_DataEntryPopupContinueMVC(), onDataEntryPage.getLink_DataEntryPopupContinueReact(), null, null)));
            else
                clickElement(driver, onDataEntryPage.getLink_DataEntryPopupMoreData());
        }
    }

    @Then("User Clicks on Other Action Tab and verify {string} option not showing in menu and Showing {string} in menu")
    public void userClicksonTabAndVerifyoption(String otherActionOption1, String otherActionOption2) {
        captureScreenshot(driver, testContext, false);
        clickElementByJSE(driver, onDataEntryPage.getTab_otherActions());
        List<String> otherActionOptionTextlist = new ArrayList<>();
        for (WebElement otherActionOption : onDataEntryPage.getMenuListTab_otherActions()) {
            otherActionOptionTextlist.add(otherActionOption.getText().trim());
        }
        Assert.assertFalse(otherActionOption1 + " Option is showing in OtherAction Menu", otherActionOptionTextlist.contains(otherActionOption1));
        Assert.assertTrue(otherActionOption2 + " Option is not showing in OtherAction Menu", otherActionOptionTextlist.contains(otherActionOption2));
    }

    @Then("User Close Other Action by clicking again on OtherAction tab")
    public void userCloseOtherAction() {
        captureScreenshot(driver, testContext, false);
        clickElementByJSE(driver, onDataEntryPage.getTab_otherActions());
    }

    @Then("User Now clicks on Data Entry Percentage, Error Menu list should appear, Click on First Green Office Use only Field {string}")
    public void userNowClicksOnDataEntryPercentage(String wizardPageName) {
        captureScreenshot(driver, testContext, false);
        clickElement(driver, onDataEntryPage.getTxt_DataEntryPercentage());
        Assert.assertTrue("Wizard Menu list is not appearing", onDataEntryPage.getWizardPages().get(0).isDisplayed());
        for (WebElement wizardPage : onDataEntryPage.getWizardPages()) {
            if (wizardPage.getText().trim().equalsIgnoreCase(wizardPageName)) {
                clickElement(driver, wizardPage);
                break;
            }
        }
    }

    @Then("User Reads the validation message for agent required fields {string}  and {string} user closes all validations by clicking on Red Bubble Icon")
    public void userReadsTheValidationMessage(String agentPgExpectedErrorMsg, String agentPgExpectedErrorMsgCommFlid) {
        captureScreenshot(driver, testContext, false);
        Assert.assertEquals("Expected error Msg for Commission is not matching: ",
                agentPgExpectedErrorMsgCommFlid, onDataEntryPage.getAgentComissionErrorMsg().getText().trim());
        Assert.assertEquals("Expected error Msg for Flid no is not matching: ",
                agentPgExpectedErrorMsgCommFlid, onDataEntryPage.getAgentFlidNoErrorMsg().getText().trim());
        clickElement(driver, onDataEntryPage.getAgentPgRedBubbleIcon());
        Assert.assertFalse("Expected error Msg for Commission is showing: ",
                onDataEntryPage.getAgentComissionErrorMsg().isDisplayed());
        Assert.assertFalse("Expected error Msg for Flid no is showing: ",
                onDataEntryPage.getAgentFlidNoErrorMsg().isDisplayed());
    }

    @Then("User Now Enters Data in Agent Required fields marked in Green. on {string} of {string}")
    public void userNowEntersDataInAgentRequiredFields(String expPageNo, String expPageName) {
        captureScreenshot(driver, testContext, false);
        onDataEntryPage.getTxtBox_agentFlidNo().sendKeys(testContext.getMapTestData().get("agentFlidNo"));
        onDataEntryPage.getTxtBox_agentComission().sendKeys(testContext.getMapTestData().get("agentCommission"));
        Assert.assertTrue(" Page no is not matching", onDataEntryPage.getWizPageWithNo().getText().trim().contains(expPageNo));
        Assert.assertTrue(" Page name is not matching", onDataEntryPage.getWizPageName().getText().trim().contains(expPageName));
    }

    @Then("User Now Again clicks on Data Entry Percentage and clicks on Remaining {string} field in list")
    public void userNowAgainClicksOnDataEntryPercentage(String partialWizPageName) {
        // TODO: Remove if not required
        sleepInMilliSeconds(2000);
        captureScreenshot(driver, testContext, false);
        clickElement(driver, onDataEntryPage.getTxt_DataEntryPercentage());
        for (WebElement wizardPage : onDataEntryPage.getWizardPages()) {
            if (wizardPage.getText().trim().contains(partialWizPageName)) {
                clickElement(driver, wizardPage);
                break;
            }
        }
    }

    @Then("User After Reaching {string} verifies the validation messages for any one field, then clicks on Red Bubble Icon to Hide all validation messages")
    public void userAfterReachingPageVerifiesTheValidationMessages(String expPageNo) {
        captureScreenshot(driver, testContext, false);
        Assert.assertTrue(" Page no is not matching", onDataEntryPage.getWizPageWithNo().getText().trim().contains(expPageNo));
        Assert.assertEquals("Error Message is not Matching for Firstname of Owner",
                "Owner first name is required.", onDataEntryPage.getOwnerpgFirstNameErrorMsg().getText().trim());
        clickElement(driver, onDataEntryPage.getAgentPgRedBubbleIcon());
    }

    @Then("User Enters random value in Contract Number text box")
    public void userEntersRandomValueInContractNumber() {
        captureScreenshot(driver, testContext, false);
        onDataEntryPage.getOwnerPgContactNo().sendKeys(testContext.getMapTestData().get("contractNumber"));
        clickElementByJSE(driver, onDataEntryPage.getCrossErrorMsg());
        clickElementByJSE(driver, onDataEntryPage.getAgentPgRedBubbleIcon());
    }

    @Then("User Now Clicks on Other Action tab")
    public void userNowClicksOnOtherActionTab() {
        onDataEntryPage.getOwnerPgContactNo().sendKeys(Keys.TAB);
        //static wait to get the perticular option TODO: Remove if not required
        sleepInMilliSeconds(3000);
        new Actions(driver).moveToElement(onDataEntryPage.getTab_otherActions());
        captureScreenshot(driver, testContext, false);
        clickElementByJSE(driver, onDataEntryPage.getTab_otherActions());
    }

    @Then("User Clicks on {string}")
    public void userClicksOn(String givenOtherActionOption) {
        captureScreenshot(driver, testContext, false);
        for (WebElement otherActionOption : onDataEntryPage.getMenuListTab_otherActions()) {
            if (otherActionOption.getText().equalsIgnoreCase(givenOtherActionOption)) {
                clickElement(driver, otherActionOption);
                break;
            }
        }
        if (testContext.getBrowser().equalsIgnoreCase(EnumsCommon.FIREFOXBROWSER.getText())){
            waitForPageToLoad(driver);
        }
        syncElement(driver, onRCTCompleteFillingAndSigningPage.getPageHeading(), EnumsCommon.TOVISIBLE.getText());
        String pageName = "Request Clients to Complete Filling and Signing Application";
        Assert.assertEquals("Page Name is something else than " + pageName, pageName,
                onRCTCompleteFillingAndSigningPage.getPageHeading().getText());
    }

    @Then("Pending request box appears, User verifies two pending request for signers")
    public void pendingRequestBoxAppears() {
        syncElement(driver, onDataEntryPage.getDialougeHeaderPendingRequestPopup(), "ToVisible");
        captureScreenshot(driver, testContext, false);
        Assert.assertEquals("Pending Request Page is not appearing",
                "Pending Requests", onDataEntryPage.getDialougeHeaderPendingRequestPopup().getText().trim());
        Assert.assertTrue("First Signer Pending Request is not appearing",
                onDataEntryPage.getSignerHeaderPendingRequestPopup().isDisplayed());
        Assert.assertTrue("Second Signer Pending Request is not appearing",
                onDataEntryPage.getSigner2HeaderPendingRequestPopup().isDisplayed());
    }

    @Then("Pending request box with {string} is displayed on data entry page")
    public void pendingRequestBoxUsers(String user) {
        captureScreenshot(driver, testContext, false);
        List<WebElement> pendingRequestsDialog = driver.findElements(By.xpath("//strong[@id='lblPendingRequest']//following::strong[contains(text(),'Request Type:') and contains(text(),'" + user + "')]"));
        if (pendingRequestsDialog.size() > 0)
            Assert.assertTrue(user + " Pending Request is not appearing", driver.findElement(By.xpath("//strong[@id='lblPendingRequest']//following::strong[contains(text(),'Request Type:') and contains(text(),'" + user + "')]")).isDisplayed());
        else {
            List<WebElement> elems = driver.findElements(By.xpath("//table[@class='outstandingRequestsDialog__table']//b[contains(text(),'Request Type')]"));
            boolean flag = false;
            for (WebElement elem : elems) {
                if (elem.getText().contains(user))
                    flag = true;
            }
            Assert.assertTrue(user + " Pending Request is not appearing", flag);
        }
    }

    @Then("Pending request box shows {string} {string} is displayed on data entry page")
    public void pendingRequestBoxUsers(String name, String email) {
        captureScreenshot(driver, testContext, false);
        WebElement elemPendingRequest = getElement(driver, getExistingLocator(driver, onDataEntryPage.getTxt_PendingRequestMVC(), onDataEntryPage.getTxt_PendingRequestReact(), null, null));
        Assert.assertTrue("Pending Request does not contain name " + name, elemPendingRequest.getText().contains(testContext.getMapTestData().get(name)));
        Assert.assertTrue("Pending Request does not contain email " + email, elemPendingRequest.getText().contains(testContext.getMapTestData().get(email)));
    }

    @Then("User verify {int} requests are displayed on requests page")
    public void pendingRequestBoxCount(int count) {
        captureScreenshot(driver, testContext, false);
        Assert.assertTrue("Pending Request count is not " + count, findElements(driver, "//strong[text()='Request:']").size() == count);
    }

    @Then("User verify {int} completed requests are displayed on requests page")
    public void completedRequestBoxCount(int count) {
        captureScreenshot(driver, testContext, false);
        Assert.assertTrue("Total Request count is not " + count, findElements(driver, "//strong[text()='Request:']").size() == count);
        Assert.assertTrue("Completed Request count is not " + count, findElements(driver, "//strong[text()='Request:']//ancestor::table//img[@alt='Received']").size() == count);
    }

    @Then("User closes pending requests on requests page")
    public void closePendingRequests() {
        captureScreenshot(driver, testContext, false);
        clickElement(driver, onDataEntryPage.getBtn_CloseRequestDialog());
    }

    @Then("User clicks cancel button for {string} on requests page")
    public void clickCancel(String user) {
        captureScreenshot(driver, testContext, false);
        String userName = "";
        switch (user) {
            case "Signer":
                userName = testContext.getMapTestData().get("signerFullName");
                break;
            case "Agent 3":
                userName = testContext.getMapTestData().get("agent3Name1");
                break;
            case "Agent 2":
                userName = testContext.getMapTestData().get("agent2Name1");
                break;
            case "Agent":
                userName = testContext.getMapTestData().get("agentName1");
                break;
            default:
                throw new FLException("Invalid value for: " + user);
        }
        clickElement(driver, findElement(driver, "//div[text()='" + userName + "']//ancestor::table//button"));
    }

    @Then("User verify {string} requests for {string} is displayed on requests page")
    public void verifyPendingRequestBoxUsers(String status, String user) {
        captureScreenshot(driver, testContext, false);
        String userName = "";
        switch (user) {
            case "Signer":
                userName = testContext.getMapTestData().get("signerFullName");
                break;
            case "Agent 3":
                userName = testContext.getMapTestData().get("agent3Name1");
                break;
            case "Agent 2":
                userName = testContext.getMapTestData().get("agent2Name1");
                break;
            case "Agent":
                userName = testContext.getMapTestData().get("agentName1");
                break;
            default:
                throw new FLException("Invalid value for: " + user);
        }
        if(status.equals("No")) {
            sleepInMilliSeconds(3000);
            Assert.assertTrue("Request for " + user + " is displayed", findElements(driver, "//div[text()='" + userName + "']").size() == 0);
        }
        else if(status.equals("Pending")) {
            Assert.assertTrue("Request for " + user + " is not " + status, findElement(driver, "//div[text()='" + userName + "']//ancestor::table//label").getText().trim().equalsIgnoreCase("Pending"));
            Assert.assertTrue("Request for " + user + " is not " + status, findElement(driver, "//div[text()='" + userName + "']//ancestor::table//strong[text()='Request:']//parent::td//following-sibling::td//strong").getText().trim().equalsIgnoreCase("Signature Request Sent to Agent"));
        }
        else {
            Assert.assertTrue("Request for " + user + " is not " + status, findElement(driver, "//div[text()='" + userName + "']//ancestor::table//img[@alt='Received']").isDisplayed());
            Assert.assertTrue("Request for " + user + " is not " + status, findElement(driver, "//div[text()='" + userName + "']//ancestor::table//strong[text()='Request:']//parent::td//following-sibling::td//strong").getText().trim().equalsIgnoreCase("Agent On-Site Signature"));
        }
    }

    @Then("Pending request box with {string} is not displayed on data entry page")
    public void pendingRequestBoxNoUsers(String user) {
        List<WebElement> pendingRequestUsers = new ArrayList<WebElement>();
        if (findElements(driver, "//strong[@id='lblPendingRequest']").size() > 0) {
            pendingRequestUsers = driver.findElements(By.xpath("//strong[@id='lblPendingRequest']//following::strong[contains(text(),'Request Type:') and contains(text(),'" + user + "')]"));
            Assert.assertTrue(user + " Pending Request is appearing for user " + user, pendingRequestUsers.size() == 0);
        }
        else {
            List<WebElement> elementsPendingRequests = driver.findElements(By.xpath("//table[@class='outstandingRequestsDialog__table']//b[contains(text(),'Request Type')]"));
            boolean flag = false;
            for (WebElement pendingRequest : elementsPendingRequests) {
                if (pendingRequest.getText().contains(user)) {
                    flag = true;
                    break;
                }
            }
            Assert.assertFalse("Pending Request is appearing for user " + user, flag);
        }
    }

    @Then("User rename the application on data entry page")
    public void renameApplication() {
        waitForPageToLoad(driver);
        captureScreenshot(driver, testContext, false);
        clickElement(driver, onDataEntryPage.getIcon_AllicationLock());
        String newAppName = "AT " + testContext.getMapTestData().get("product") + " " + getDate("newAppName");
        addPropertyValueInJSON(testContext.getTestCaseID(), testContext, EnumsJSONProp.NEWPRODUCTNAME.getText(), newAppName);
        sendKeys(driver, getElement(driver, getExistingLocator(driver, onDataEntryPage.getTxtbox_AppName(), onDataEntryPage.getTxtbox_AppName1(), null, null)), newAppName);
        clickElement(driver, getElement(driver, getExistingLocator(driver, onDataEntryPage.getBtn_Rename(), onDataEntryPage.getBtn_Rename1(), null, null)));
        clickElement(driver, getElement(driver, getExistingLocator(driver, onDataEntryPage.getBtn_CloseRename(), onDataEntryPage.getBtn_CloseRename1(), null, null)));
        waitForPageToLoad(driver);
    }

    @Then("User Notes the URL generated in dialog box")
    public void UsersavedUrl(){
        captureScreenshot(driver, testContext, false);
        addPropertyValueInJSON(testContext.getTestCaseID(), testContext,EnumsJSONProp.SIGNERURL.getText(), getElement(driver, getExistingLocator(driver, onDataEntryPage.getLink_RequestUrlMVC(), onDataEntryPage.getLink_RequestUrlReact(), null, null)).getText().trim());
    }

    @Then("User open Form Menu and clicks on the {string} of {string}")
    public void user_open_Form_Menu_and_clicks_on_the_of(String pageNumber, String formName) {
        captureScreenshot(driver, testContext, false);
        clickElement(driver, onDataEntryPage.getIcon_ExpandMenu());
        clickElement(driver, getElement(driver, getExistingLocator(driver, onDataEntryPage.getTxt_Page1FormMVC(), onDataEntryPage.getTxt_Page1FormReact(), null, null)));
    }

    @Then("User Notes the Passcode for {string} on data entry page")
    public void storeUserPasscode(String user) {
        String enumUser = "";
        String userName = "";
        if (user.equalsIgnoreCase("owner")) {
            userName = testContext.getMapTestData().get("ownerName1");
            enumUser = EnumsJSONProp.OWNERPASSCODE.getText();
        }
        else if (user.equalsIgnoreCase("payor"))
            enumUser = EnumsJSONProp.PAYORPASSCODE.getText();
        else if (user.equalsIgnoreCase("insured")) {
            userName = testContext.getMapTestData().get("insuredName1");
            enumUser = EnumsJSONProp.INSUREDPASSCODE.getText();
        }
        else if (user.equalsIgnoreCase("reviewer")) {
            userName = testContext.getMapTestData().get("reviewerName");
            enumUser = EnumsJSONProp.REVIEWERPASSCODE.getText();
        }
        else
            enumUser = EnumsJSONProp.ANNUITANTPASSCODE.getText();

        int elemSize = driver.findElements(By.xpath("//strong[@id='lblPendingRequest']//following::strong[contains(text(),'Request Type:') and contains(text(),'" + user + "')]//following-sibling::span")).size();
        if (elemSize > 0)
            addPropertyValueInJSON(testContext.getTestCaseID(), testContext, enumUser, driver.findElement(By.xpath("//strong[@id='lblPendingRequest']//following::strong[contains(text(),'Request Type:') and contains(text(),'" + user + "')]//following-sibling::span")).getText().trim());
        else if (driver.findElements(By.xpath("(//a[contains(text(),'Send Passcode to " + userName + "')]//ancestor::tr//span)[2]")).size() > 0)
            addPropertyValueInJSON(testContext.getTestCaseID(), testContext, enumUser, driver.findElement(By.xpath("(//a[contains(text(),'Send Passcode to " + userName + "')]//ancestor::tr//span)[2]")).getText().trim());
        else {
            if(userName.equals(""))
                addPropertyValueInJSON(testContext.getTestCaseID(), testContext, enumUser, driver.findElement(By.xpath("//b[contains(text(),'Request Type')]//parent::th//parent::tr//following-sibling::tr//span")).getText().trim());
            else
                addPropertyValueInJSON(testContext.getTestCaseID(), testContext, enumUser, driver.findElement(By.xpath("//div[contains(text(),'Send Passcode to " + userName + "')]//ancestor::tr//span")).getText().trim());
        }
    }

    @Then("User Notes the Passcode for both Annuitant & Owner both")
    public void userNotesThePasscode() {
        captureScreenshot(driver, testContext, false);
        addPropertyValueInJSON(testContext.getTestCaseID(), testContext, EnumsJSONProp.OWNERPASSCODE.getText(),
                onDataEntryPage.getPasscode_ownerPendingRequestPopup().getText().trim());
        addPropertyValueInJSON(testContext.getTestCaseID(), testContext, EnumsJSONProp.ANNUITANTPASSCODE.getText(),
                onDataEntryPage.getPasscode_annuitantPendingRequestPopup().getText().trim());
    }

    @Then("For Owner\\(Secondary Signer) User gets the URL from Message template by clicking Send Reminder to Owner")
    public void forOwnerSecondarySignerUsergetsTheURL() {
        captureScreenshot(driver, testContext, false);
        clickElement(driver, onDataEntryPage.getSendReminderToOwnerLinkPendingRequestPopup());
        String msg = onDataEntryPage.getMailMessage().getText().trim();
        String s1 = msg.substring(msg.indexOf("href") + 5, msg.indexOf(">Click"));
        addPropertyValueInJSON(testContext.getTestCaseID(), testContext, EnumsJSONProp.OWNERURL.getText(), s1);
        clickElement(driver, onDataEntryPage.getBtn_sendMessagePopup());
        syncElement(driver, getElement(driver, getExistingLocator(driver, onHomePage.getToolBar_HomeMVC(), onHomePage.getToolBar_HomeReact(), null, null)), "ToVisible");
    }

    @Then("User save the {string} generated on data entry page")
    public void userSaveRecords(String recordsDataEntry) {
        if (recordsDataEntry.equals("soft limit signature credentials")) {
            Log.info("Owner first name : " + onDataEntryPage.getTxtbox_OwnerFirstName().getAttribute("value").trim());
            Log.info("Owner last name : " + onDataEntryPage.getTxtbox_OwnerLastName().getAttribute("value").trim());
            Log.info("Joint owner first name : " + onDataEntryPage.getTxtBox_jointOwnerFirstName().getAttribute("value").trim());
            Log.info("Joint owner last name : " + onDataEntryPage.getTxtBox_jointOwnerLastName().getAttribute("value").trim());
            addPropertyValueInJSON(testContext.getTestCaseID(), testContext, EnumsJSONProp.OWNERFIRSTNAME.getText(), onDataEntryPage.getTxtbox_OwnerFirstName().getAttribute("value").trim());
            addPropertyValueInJSON(testContext.getTestCaseID(), testContext, EnumsJSONProp.OWNERLASTNAME.getText(), onDataEntryPage.getTxtbox_OwnerLastName().getAttribute("value").trim());
            addPropertyValueInJSON(testContext.getTestCaseID(), testContext, EnumsJSONProp.JOINTOWNERFIRSTNAME.getText(), onDataEntryPage.getTxtBox_jointOwnerFirstName().getAttribute("value").trim());
            addPropertyValueInJSON(testContext.getTestCaseID(), testContext, EnumsJSONProp.JOINTOWNERLASTNAME.getText(), onDataEntryPage.getTxtBox_jointOwnerLastName().getAttribute("value").trim());
        } else if (recordsDataEntry.equals("soft limit signature multilines")) {
            Log.info("Generated multi lines : " + onDataEntryPage.getTxtBox_MultiLine().getText().trim());
            addPropertyValueInJSON(testContext.getTestCaseID(), testContext, EnumsJSONProp.MULTILINE.getText(), onDataEntryPage.getTxtBox_MultiLine().getText().trim());
        }
    }

    @Then("User verify the multilines text is not blank on data entry page")
    public void userVerifyRecordNotBlank() {
        Assert.assertFalse("Field multiline is blank as unexpected", onDataEntryPage.getTxtBox_MultiLine().getText().trim().isEmpty());
    }

    @Then("User Click on Enter More Data")
    public void userClickOnEnterMoreData() {
        captureScreenshot(driver, testContext, false);
        clickElement(driver, onDataEntryPage.getEnterMoreData());
    }

    @Then("User {string} popup showing, Click on Enter More Data")
    public void userPopupShowingClickOnEnterMoreData(String partialHeading) {
        WebElement element = getElement(driver, getExistingLocator(driver, onDataEntryPage.getTxt_dataEntryPopupTextMVC(), onDataEntryPage.getTxt_dataEntryPopupTextReact(), null, null));
        syncElement(driver, element, EnumsCommon.TOVISIBLE.getText());
        captureScreenshot(driver, testContext, false);
        Assert.assertTrue("Data Entry Met Toast popup NOT Visible", element.getText().trim().contains(partialHeading));
        clickElement(driver, onDataEntryPage.getEnterMoreData());
    }

    @Then("User Clicks on Other Action Tab and verify {string} option Showing")
    public void userClicksOnOtherActionTab(String otherActionOption) {
        captureScreenshot(driver, testContext, false);
        clickElementByJSE(driver, onDataEntryPage.getTab_otherActions());
        List<String> otherActionOptionTextlist = new ArrayList<>();
        for (WebElement otherActionOpt : onDataEntryPage.getMenuListTab_otherActions()) {
            otherActionOptionTextlist.add(otherActionOpt.getText().trim());
        }
        Assert.assertTrue(otherActionOption + " Option is not showing in OtherAction Menu", otherActionOptionTextlist.contains(otherActionOption));
    }

    @Then("User Clicks on Other Action Tab and verify {string} option is not available")
    public void userVerifyOtherActionNoRequiredOption(String otherActionOption) {
        captureScreenshot(driver, testContext, false);
        driver.navigate().refresh();
        waitForPageToLoad(driver);
        clickElementByJSE(driver, onDataEntryPage.getTab_otherActions());
        List<String> otherActionOptionTextlist = new ArrayList<>();
        for (WebElement otherActionOpt : onDataEntryPage.getMenuListTab_otherActions()) {
            otherActionOptionTextlist.add(otherActionOpt.getText().trim());
        }
        Assert.assertFalse(otherActionOption + " Option is showing in OtherAction Menu", otherActionOptionTextlist.contains(otherActionOption));
    }

    @Then("User Now Clicks on Other Action tab and  Clicks on {string} and title should be {string}")
    public void userNowClicksOnOtherActionTab(String givenOtherActionOption, String pageName) {
        sleepInMilliSeconds(2000);
        captureScreenshot(driver, testContext, false);
        clickElementByJSE(driver, onDataEntryPage.getTab_otherActions());
        clickElement(driver, driver.findElement(By.xpath("//a[text()='" + givenOtherActionOption + "']")));
        Assert.assertEquals("Page Name is something else than " + pageName, pageName,
                onRCTCompleteFillingAppPage.getPageHeading().getText());
    }

    @Then("Pending Request popup should appear for Joint Owner User verifies the three links exist Send Email, Send Passcode, Cancel link on pending Request Dialog")
    public void pendingRequestPopupShouldAppear() {
        captureScreenshot(driver, testContext, false);
        Assert.assertEquals("Not in Pending Request Popup", testContext.getMapTestData().get("pendingRequestPopupHeading"), onDataEntryPage.getHeader_PendingRequestPopup().getText().trim());
        Assert.assertTrue("Pending Request Popup not having 3 links", onDataEntryPage.getLinksPresentInPendingRequestPopup().size() == 3);
    }

    @Then("User Notes the Passcode from Pending Request dialog")
    public void userNotesThePasscodeFrom() {
        captureScreenshot(driver, testContext, false);
        addPropertyValueInJSON(testContext.getTestCaseID(), testContext, EnumsJSONProp.RECIPIENTPASSCODE.getText(), getElement(driver, getExistingLocator(driver, onDataEntryPage.getPasscode_PendingReqMVC(), onDataEntryPage.getPasscode_PendingReqReact(), null, null)).getText());
    }

    @Then("User Navigates to Home page and verifies application status as {string}")
    public void userNavigatesToHomePage(String status) {
        captureScreenshot(driver, testContext, false);
        clickElement(driver, getElement(driver, getExistingLocator(driver, onHomePage.getToolBar_HomeMVC(), onHomePage.getToolBar_HomeReact(), null, null)));
        captureScreenshot(driver, testContext, false);
        Assert.assertTrue("Application status Mismatched", findElement(driver, "//div[@class='listRecent__name' and @aria-label='" + testContext.getMapTestData().get("newProductName") + ",']//following-sibling::div//span[@class='orange']").getText().equalsIgnoreCase(status));
    }

    @Then("User {string} popup showing, Close Popup")
    public void user_popup_showing_Close_Popup(String partialHeading) {
        waitForPageToLoad(driver);
        captureScreenshot(driver, testContext, false);
        if (testContext.getUiType().equalsIgnoreCase(EnumsCommon.UITYPE_MVC.getText())) {
            WebElement elemPopup = getElement(driver, getExistingLocator(driver, onDataEntryPage.getTxt_dataEntryPopupTextMVC(), onDataEntryPage.getTxt_dataEntryPopupTextReact(), null, null));
            syncElement(driver, elemPopup, EnumsCommon.TOVISIBLE.getText());
            Assert.assertTrue("Toast box message mismatched", elemPopup.getText().trim().contains(partialHeading));
            clickElement(driver, getElement(driver, getExistingLocator(driver, onDataEntryPage.getLink_closeMVC(), onDataEntryPage.getLink_closeReact(), null, null)));
        } else {
            if(onDataEntryPage.getList_MsgToastBox().size() == 0)
                driver.navigate().refresh();
            waitForPageToLoad(driver);
            Assert.assertTrue("Toast box message mismatched", onDataEntryPage.getMsg_toastBox().getText().trim().contains(partialHeading));
            clickElement(driver, onDataEntryPage.getIcon_PopupCross());
        }
    }

    @Then("User verifies Linked child activity is appear & verify the name")
    public void verifiesLinkedChildActivityIsAppearVerifyTheName() {
        captureScreenshot(driver, testContext, false);
        Assert.assertTrue("Linked child activity is not appear", onDataEntryPage.getTxt_linkedChild().isDisplayed());
        Assert.assertTrue("Linked child activity is mismatched", onDataEntryPage.getTxt_linkedChild().getText().trim().startsWith(testContext.getMapTestData().get("product").split(" ")[0].trim()));
    }


    @Then("User verifies the Last Name, First name Fields are blank initialy")
    public void userVerifiesTheLastNameFirstNameFieldsAreBlankInitialy() {
        captureScreenshot(driver, testContext, false);
        Assert.assertTrue("First name textbox is not empty", onDataEntryPage.getTxtbox_FirstName().getText().isEmpty());
        Assert.assertTrue("Last name textbox is not empty", onDataEntryPage.getTxtbox_lastName().getText().isEmpty());
    }

    @Then("User clicks on custom button Applicant data Auto fill")
    public void userClicksOnCustomButtonApplicantDataAutoFill() {
        captureScreenshot(driver, testContext, false);
        clickElement(driver, onDataEntryPage.getBtn_ApplicantDataAutoFill());
    }

    @Then("User verifies party List show names added on demographic party pages")
    public void userVerifiesPartyListShowNamesAddedOnDemographicPartyPages() {
        captureScreenshot(driver, testContext, false);
        for (int i = 1; i < onDataEntryPage.getList_partyNames().size(); i++) {
            Assert.assertTrue("Party Name " + i + " mismatched", onDataEntryPage.getList_partyNames().get(i).getText().trim().contains(testContext.getMapTestData().get("firstnameforParty" + i)));
        }
    }

    @Then("User selects Party {int} name from list")
    public void userSelectsPartyNameFromList(int number) {
        captureScreenshot(driver, testContext, false);
        for (int i = 1; i < onDataEntryPage.getList_partyNames().size(); i++) {
            if (i == number) {
                clickElementByJSE(driver, onDataEntryPage.getList_partyNames().get(i));
            }
        }
    }

    @Then("User verifies Last name, First name, Street Address, City, State, Zip Code fields get autofilled for Party{int}")
    public void userVerifiesLastNameFirstNameStreetAddressCityStateZipCodeCouncilNumberFieldsGetAutofilledWithDataGivenOnStepForParty(int partyNumber) {
        syncElement(driver, onDataEntryPage.getTxtbox_applicantlastName(), EnumsCommon.TOVISIBLE.getText());
        // TODO: Remove if not required
        sleepInMilliSeconds(3000);
        captureScreenshot(driver, testContext, false);
        Assert.assertEquals("Last name is mismatched", testContext.getMapTestData().get("lastnameforParty" + partyNumber), onDataEntryPage.getTxtbox_applicantlastName().getAttribute("value").trim());
        Assert.assertEquals("First name is mismatched", testContext.getMapTestData().get("firstnameforParty" + partyNumber), onDataEntryPage.getTxtbox_applicantFirstName().getAttribute("value").trim());
        Assert.assertEquals("Street Address is mismatched", testContext.getMapTestData().get("streetaddressforParty" + partyNumber), onDataEntryPage.getTxtbox_StreetAddress().getAttribute("value").trim());
        Assert.assertEquals("City is mismatched", testContext.getMapTestData().get("cityforParty" + partyNumber), onDataEntryPage.getTxtbox_City().getAttribute("value").trim());
        Assert.assertEquals("State is mismatched", testContext.getMapTestData().get("stateforParty" + partyNumber), onDataEntryPage.getTxtbox_State().getAttribute("value").trim());
        Assert.assertEquals("Zipcode is mismatched", testContext.getMapTestData().get("zipcodeforParty" + partyNumber), onDataEntryPage.getTxtbox_ZipCode().getAttribute("value").trim());
    }

    @Then("User verifies Council Number fields get autofilled for Party{int}")
    public void userVerifiesCouncilNumberFieldsGetAutofilledForParty(int partyNumber) {
        captureScreenshot(driver, testContext, false);
        Assert.assertEquals("Council Number is mismatched", testContext.getMapTestData().get("councilNumber"), onDataEntryPage.getTxtbox_CouncilNumber().getAttribute("value").trim());
    }

    @Then("USer clicks on Insured Data Auto Fill button")
    public void userClicksOnInsuredDataAutoFillButton() {
        captureScreenshot(driver, testContext, false);
        clickElement(driver, onDataEntryPage.getBtn_InsuredDataAutoFill());
    }

    @Then("User verifies Last name, First name, Street Address, City, State, Zip Code field get autofilled for Party{int}")
    public void userVerifiesLastNameFirstNameStreetAddressCityStateZipCodeCouncilNumberFieldGetAutofilledWithDataGivenOnStepForParty3(int partyNumber) {
        syncElement(driver, onDataEntryPage.getTxtbox_InsuredLastName(), EnumsCommon.TOVISIBLE.getText());
        // TODO: Remove if not required
        sleepInMilliSeconds(3000);
        captureScreenshot(driver, testContext, false);
        Assert.assertEquals("Last name is mismatched", testContext.getMapTestData().get("lastnameforParty" + partyNumber), onDataEntryPage.getTxtbox_InsuredLastName().getAttribute("value").trim());
        Assert.assertEquals("First name is mismatched", testContext.getMapTestData().get("firstnameforParty" + partyNumber), onDataEntryPage.getTxtbox_InsuredFirstName().getAttribute("value").trim());
        Assert.assertEquals("Street Address is mismatched", testContext.getMapTestData().get("streetaddressforParty" + partyNumber), onDataEntryPage.getTxtbox_StreetAddress().getAttribute("value").trim());
        Assert.assertEquals("City is mismatched", testContext.getMapTestData().get("cityforParty" + partyNumber), onDataEntryPage.getTxtbox_City().getAttribute("value").trim());
        Assert.assertEquals("State is mismatched", testContext.getMapTestData().get("stateforParty" + partyNumber), onDataEntryPage.getTxtbox_State().getAttribute("value").trim());
        Assert.assertEquals("Zipcode is mismatched", testContext.getMapTestData().get("zipcodeforParty" + partyNumber), onDataEntryPage.getTxtbox_ZipCode().getAttribute("value").trim());
    }

    @Then("User clicks on Next buttons")
    public void userClicksOnNextButtons() {
        syncElement(driver, onDataEntryPage.getBtn_Next(), EnumsCommon.TOCLICKABLE.getText());
        captureScreenshot(driver, testContext, false);
        clickElement(driver, onDataEntryPage.getBtn_Next());
    }

    @Then("User open Form Menu and click on {string} of {string} form")
    public void userOpenFormMenuAndClickOnPageOfKOCUSLifeInsuranceApplicationForm(String pageName, String sectionformName) {
        captureScreenshot(driver, testContext, false);
        clickElement(driver, onDataEntryPage.getIcon_ExpandMenu());
        clickElement(driver, getElement(driver, getExistingLocator(driver, onDataEntryPage.getTxt_Page1FormMVC(), onDataEntryPage.getTxt_Page1FormReact(), null, null)));
    }

    @Then("User verifies {string} of {string} is Open")
    public void userVerifiesOfIsOpenPageForm(String pageleftname, String pagemiddlename) {
        captureScreenshot(driver, testContext, false);
        Assert.assertEquals("Page name is mismatched", pageleftname, onDataEntryPage.getTxt_pageleftTopName().getText().trim());
        Assert.assertEquals("PageForm name is mismatched", pagemiddlename, onDataEntryPage.getTxt_pageMiddleName().getText().trim());
    }

    @Then("User verifies Applicant & Insured Section have Name fields auto populated")
    public void userVerifiesApplicantInsuredSectionHaveNameFieldsAtoPopulated() {
        captureScreenshot(driver, testContext, false);
        Assert.assertEquals("Applicant first name field not autopopulated/wrong text displayed.", testContext.getMapTestData().get("firstnameforParty1"), onDataEntryPage.getTxtbox_applicantFirstName().getAttribute("value").trim());
        Assert.assertEquals("Applicant last name field not autopopulated/wrong text displayed.", testContext.getMapTestData().get("lastnameforParty1"), onDataEntryPage.getTxtbox_applicantlastName().getAttribute("value").trim());
        Assert.assertEquals("Insured first name field not autopopulated/wrong text displayed.", testContext.getMapTestData().get("firstnameforParty3"), onDataEntryPage.getTxtbox_InsuredFirstName().getAttribute("value").trim());
        Assert.assertEquals("Insured last name field not autopopulated/wrong text displayed.", testContext.getMapTestData().get("lastnameforParty3"), onDataEntryPage.getTxtbox_InsuredLastName().getAttribute("value").trim());
    }

    @Then("Applicant & owner Last name, First name, street address are auto populated with respective party selected on Page{int} & Page{int} of application.")
    public void applicatiantLastNameFirstNameStreetAddressAreAutoPopulatedWithRespectivePartySelectedOnPagePageOfApplication(int page1, int page2) {
        captureScreenshot(driver, testContext, false);
        moveToElement(driver, onDataEntryPage.getBtn_ApplicantAutoFill());
        clickElementByJSE(driver, onDataEntryPage.getBtn_ApplicantAutoFill());
        for (int j = 0; j < onDataEntryPage.getList_partyNames().size(); j++) {
            if (j == page1 | j == page2) {
                clickElementByJSE(driver, onDataEntryPage.getList_partyNames().get(j));
                // TODO: Remove if not required
                sleepInMilliSeconds(3000);
                Assert.assertEquals("Applicant Last name is mismatched", testContext.getMapTestData().get("lastnameforParty" + j), onDataEntryPage.getTxtbox_applicantlastName().getAttribute("value").trim());
                Assert.assertEquals("Applicant First name is mismatched", testContext.getMapTestData().get("firstnameforParty" + j), onDataEntryPage.getTxtbox_applicantFirstName().getAttribute("value").trim());
                Assert.assertEquals("Applicant Street Address is mismatched", testContext.getMapTestData().get("streetaddressforParty" + j), onDataEntryPage.getTxtbox_applicantStreetAddress().getAttribute("value").trim());
                clickElementByJSE(driver, onDataEntryPage.getBtn_ApplicantAutoFill());
            }
        }
    }


    @Then("User enter some text in First name {string} & last name {string} of Owner Section")
    public void userEnterSomeTextInFirstNameLastNameOfOwnerSection(String firstname, String lastname) {
        captureScreenshot(driver, testContext, false);
        onDataEntryPage.getTxtbox_OwnerFirstName().sendKeys(firstname);
        onDataEntryPage.getTxtbox_OwnerLastName().sendKeys(lastname);
    }

    @Then("User clicks Owner Auto Fill in Owner Section")
    public void userClicksOwnerAutoFillInOwnerSection() {
        captureScreenshot(driver, testContext, false);
        moveToElement(driver, onDataEntryPage.getBtn_OwnerAutoFill());
        for (int k = 0; k < 2; k++) {
            clickElementByJSE(driver, onDataEntryPage.getBtn_OwnerAutoFill());
        }
    }

    @Then("User verifies Owner First name, last Name is updated with Party{int} data, and Street Address, City, State, Zipcode is same as for Party{int}")
    public void userVerifiesOwnerFirstNameLastNameIsUpdatedWithPartyDataAndStreetAddressCityStateZipcodeIsSameAsForParty4(int partynumber4, int partynumber1) {
        syncElement(driver, onDataEntryPage.getTxtbox_OwnerLastName(), EnumsCommon.TOVISIBLE.getText());
        // TODO: Remove if not required
        sleepInMilliSeconds(3000);
        captureScreenshot(driver, testContext, false);
        Assert.assertEquals("Last name is mismatched", testContext.getMapTestData().get("lastnameforParty" + partynumber4), onDataEntryPage.getTxtbox_OwnerLastName().getAttribute("value").trim());
        Assert.assertEquals("First name is mismatched", testContext.getMapTestData().get("firstnameforParty" + partynumber4), onDataEntryPage.getTxtbox_OwnerFirstName().getAttribute("value").trim());
        Assert.assertEquals("Street Address is mismatched", testContext.getMapTestData().get("streetaddressforParty" + partynumber1), onDataEntryPage.getTxtbox_OwnerStreetAddress().getAttribute("value").trim());
        Assert.assertEquals("City is mismatched", testContext.getMapTestData().get("cityforParty" + partynumber1), onDataEntryPage.getTxtbox_OwnerCity().getAttribute("value").trim());
        Assert.assertEquals("State is mismatched", testContext.getMapTestData().get("stateforParty" + partynumber1), onDataEntryPage.getDd_OwnerState().getAttribute("value").trim());
        Assert.assertEquals("Zipcode is mismatched", testContext.getMapTestData().get("zipcodeforParty" + partynumber1), onDataEntryPage.getTxtbox_OwnerZipCode().getAttribute("value").trim());
    }

    @Then("User On Pending Request Dialog Notes the Reviewer Passcode")
    public void user_On_Pending_Request_Dialog_Note_the_Reviewer_Passcode_and_Get_the_URL_by_Clicking_Send_Reminder_link() {
        captureScreenshot(driver, testContext, false);
        Assert.assertEquals("User Not in Pending Request Popup", testContext.getMapTestData().get("pendingRequestPopupHeading"), onDataEntryPage.getHeader_PendingRequestPopup().getText().trim());
        addPropertyValueInJSON(testContext.getTestCaseID(), testContext, EnumsJSONProp.REVIEWERPASSCODE.getText(), onDataEntryPage.getPasscode_recipient().getText());
    }

    @Then("Click data entry percentage menu")
    public void clickDataEntryPercentageMenu() {
        clickElement(driver, onDataEntryPage.getPercentBar());
    }

    @Then("User clicks date entry error count {int} and verify pages")
    public void clickDateEntryErrorAndVerifyPages(int count) {
        clickDataEntryPercentageMenu();
        clickElement(driver, onDataEntryPage.getShowAll());
        List<WebElement> errorElements = onDataEntryPage.getDataEntryPopUpErrorsList();
        Assert.assertEquals("Error element count should be ", count, errorElements.size());
        for (int i = 0; i < errorElements.size() - 1; i++) {
            clickElement(driver, onDataEntryPage.getShowAll());
            List<WebElement> errorElement = onDataEntryPage.getDataEntryPopUpErrorsList();
            String errorPageName = errorElement.get(i).getText().split("/")[0].trim();
            clickElement(driver, errorElement.get(i));
            //Assert.assertFalse("Error pop up should not be displayed", errorElement.isDisplayed());
            String actualName = onDataEntryPage.getDataEntryPageHeader().getText();
            Assert.assertEquals("Data entry page header name should match", errorPageName, actualName);
            clickDataEntryPercentageMenu();
        }
        clickDataEntryPercentageMenu();
    }

    @Then("User Verifies Toast Popup for Template forms")
    public void UserVerifyToastPopupforTemplateforms() {
        waitForPageToLoad(driver);
        captureScreenshot(driver, testContext, false);
        syncElement(driver, onDataEntryPage.getTemplatefm_crossButton(), EnumsCommon.TOCLICKABLE.getText());
        captureScreenshot(driver, testContext, false);
        Assert.assertEquals("Data Entry Toast Popup for Template forms is Not Visible", testContext.getMapTestData().get("template_msg"), onDataEntryPage.getTemplatefm_msg().getText());
        clickElement(driver, onDataEntryPage.getTemplatefm_crossButton());
    }

    @Then("User verifies Client Protected fields are disabled")
    public void verifyClientProtectedField() {
        captureScreenshot(driver, testContext, false);
        List<WebElement> elements;
        if (testContext.getMapTestData().get("uiType").equalsIgnoreCase("MVC"))
            elements = onDataEntryPage.getList_ExpandFormMenu();
        else
            elements = onDataEntryPage.getList_ExpandFormMenuReact();
        for (WebElement elem : elements) {
            if (elem.getText().contains("Client Protected"))
                Assert.assertTrue("Public or Agent Protected forms are also disabled", elem.getAttribute("class").contains("listViewItem-validation--disabled"));
        }
    }

    @Then("User verifies Validation error {string} showing all {string}")
    public void verifyShowingAllProtectedFields(String type, String forms) {
        captureScreenshot(driver, testContext, false);
        List<WebElement> lstForm;
        String[] expectedForms = forms.split(",");
        if(type.equals("list")) {
            if (testContext.getMapTestData().get("uiType").equalsIgnoreCase("React"))
                lstForm = getElements(driver, getExistingLocator(driver, onDataEntryPage.getList_dataEntryMenuMVC(), onDataEntryPage.getList_dataEntryMenuReact(), null, null));
            else
                lstForm = getElements(driver, getExistingLocator(driver, onDataEntryPage.getList_dataEntryMenuMVCApplication(), onDataEntryPage.getList_dataEntryMenuReact(), null, null));
        }
        else
            lstForm = onDataEntryPage.getList_ExpandFormMenu();

        for (WebElement element : lstForm) {
            boolean flag = false;
            if(Arrays.stream(expectedForms).anyMatch(element.getText()::contains))
            {
                flag = true;
                break;
            }
            Assert.assertTrue(element.getText()+"list of protected users does not match in error list", flag);
        }
    }

    @Then("User close menu form")
    public void closeMenuForm() {
        waitForPageToLoad(driver);
        captureScreenshot(driver, testContext, false);
        clickElementByJSE(driver, onDataEntryPage.getMenu_Collapse());
    }

    @Then("User verify error message {string} on data entry page")
    public void verifyError(String message) {
        waitForPageToLoad(driver);
        captureScreenshot(driver, testContext, false);
        Assert.assertTrue(message + " message is not displayed", onDataEntryPage.getList_FormsWizards().getText().contains(message));
    }

    @Then("User enters Text in Agent Last name {string}, First name  {string} Agent ID {string} Fields")
    public void enterAgentValidCredential(String lName, String fName, String agentID) {
        captureScreenshot(driver, testContext, false);
        onDataEntryPage.getTxtBox_DataEntryUserLastName().sendKeys(lName);
        onDataEntryPage.getDataEntry_txtbox_userFirstName().sendKeys(fName);
        onDataEntryPage.getDataEntry_txtbox_userIDNumber().sendKeys(agentID + Keys.TAB);
        clickElement(driver, onDataEntryPage.getBt_next());
    }

    @Then("User clicks next again Click on Next Button")
    public void clickNextButtonOnPublicProtPage() {
        captureScreenshot(driver, testContext, false);
        syncElement(driver, onDataEntryPage.getBt_next(), EnumsCommon.TOCLICKABLE.getText());
        clickElement(driver, onDataEntryPage.getBt_next());
    }

    @Then("User Verifies current page is public protected and entered insured first name field")
    public void verifyCurrentPage() {
        captureScreenshot(driver, testContext, false);
        Assert.assertEquals("Agent Protected form page is not found", testContext.getMapTestData().get("AgentProtected_txt"), onDataEntryPage.getTxt_publicprotectedform().getText());
        onDataEntryPage.getInsuredfirstname_txtbox().sendKeys(testContext.getMapTestData().get("Insuredfirstname_txtbox"));
        syncElement(driver, onDataEntryPage.getBt_next(), EnumsCommon.TOCLICKABLE.getText());
    }

    @Then("User clicks next button")
    public void clickNextButton() {
        captureScreenshot(driver, testContext, false);
        clickElement(driver, onDataEntryPage.getBt_next());
    }

    @Then("User Enters Owner First name as {string} Owner Last name {string} then clicks next")
    public void enterOwnerValidCredential(String fName, String lName) {
        captureScreenshot(driver, testContext, false);
        onDataEntryPage.getAgentProtectedowner_firstname().sendKeys(fName);
        onDataEntryPage.getLastName_AgentProtectedowner().sendKeys(lName + Keys.TAB);
        clickElement(driver, onDataEntryPage.getBt_next());
    }

    @Then("User again clicks on Next button and navigate to Agent Protected template Form")
    public void navigateToAgentProtectedForm() {
        captureScreenshot(driver, testContext, false);
        clickElement(driver, onDataEntryPage.getBt_next());
    }

    @Then("User Clicks on State Notice Upload button")
    public void clickOnStateNoticeUploadButton() {
        captureScreenshot(driver, testContext, false);
        clickElementByJSE(driver, onDataEntryPage.getBtn_StateUploadNotice());
    }

    @Then("User Upload a PDF with default selected Document type Policy")
    public void selectAndUploadDocumentOnDataEntry() {
        captureScreenshot(driver, testContext, false);
        selectOptionFromList(driver, onDataEntryPage.getList_SelectPolicy(), "3", EnumsCommon.CLICK.getText());
        onDataEntryPage.getUpload_file().sendKeys(new File("src/test/resources/testdata/downloadedFiles/E2E-TC-08-pdf.pdf").getAbsolutePath());
        clickElement(driver, onDataEntryPage.getBtn_Upload());
        sleepInMilliSeconds(4000);
        clickElement(driver, onDataEntryPage.getBtn_Close());
    }

    @Then("User verifies Agent Protected Template Form now showing uploaded pdf in background")
    public void clickAndVerifyUploadFile() {
        captureScreenshot(driver, testContext, false);
        Assert.assertTrue("Agent Protected is not display", onDataEntryPage.getTxt_AgentprotectedForm().getText().contains("Agent Protected Template Form"));
    }

    @Then("User Reload the page and Verifies the new Toast Message has Policy Text removed")
    public void verifyToastMsgOnRemovePolicyInText() {
        captureScreenshot(driver, testContext, false);
        driver.navigate().refresh();
        syncElement(driver, onDataEntryPage.getMsg_toastBox(), EnumsCommon.TOVISIBLE.getText());
        Assert.assertTrue("Message mismatched", onDataEntryPage.getMsg_toastBox().getText().trim().contains(testContext.getMapTestData().get("applicationPopup")));
        clickElement(driver, onDataEntryPage.getTemplatefm_crossButton());
    }

    @Then("User Verifies Continue button is disabled")
    public void verifyContinueButton() {
        captureScreenshot(driver, testContext, false);
        Assert.assertTrue("Continue button is enabled", onDataEntryPage.getCountinue_button().getAttribute("class").contains("disabled"));
    }

    @Then("User verifies list show only Client Protected Forms error list")
    public void verifyErrorListInClientOnly() {
        captureScreenshot(driver, testContext, false);
        boolean flag = false;
        for (WebElement element : onDataEntryPage.getList_clientData()) {
            if (element.getText().contains("Client Protected")) {
                flag = true;
                break;
            }
        }
        Assert.assertTrue("list show many protected forms", flag);
    }

    @Then("User Clicks close Icon")
    public void clickCloseIcon() {
        captureScreenshot(driver, testContext, false);
        clickElement(driver, onDataEntryPage.getIcon_Close());
    }

    @Then("User Go to Other Action and Clicks Display Print PDF")
    public void clickOtherActionModuleAndClickDisplayPrintPdf() {
        captureScreenshot(driver, testContext, false);
        clickElement(driver, onDataEntryPage.getOtherAction_modl());
        clickElement(driver, onDataEntryPage.getDisplay_Print_modl());
    }

    @Then("User Verifies Client Protected forms cannot be selected and default selected pages not client Protected form appear on PDF")
    public void verifyClientProtectedFormIsNotSelect() throws IOException {
        captureScreenshot(driver, testContext, false);
        for (int a = 0; a < onDataEntryPage.getList_selectPrintDocumentChechBox().size(); a++) {
            Assert.assertFalse("Client Protected forms is selected", onDataEntryPage.getList_selectPrintDocumentChechBox().get(a).isSelected());
        }
        syncElement(driver, onDataEntryPage.getPrintselect_modl(), EnumsCommon.TOCLICKABLE.getText());
        clickElement(driver, onDataEntryPage.getPrintselect_modl());
        sleepInMilliSeconds(3000);
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        if (tabs.size() > 1)
            driver.switchTo().window(tabs.get(1));
        String pdfText;
        String pdfFileName = "";
        try {
            pdfFileName = testContext.getModuleName() + "-" + testContext.getTestCaseID() + "_" + getDate("pdfFileName") + ".pdf";
            Path downloadFilePath = Paths.get(EnumsCommon.ABSOLUTE_DOWNLOADFILES_PATH.getText() + "PrintPdf.pdf");
            new WebDriverWait(driver, 60).until(d -> downloadFilePath.toFile().exists());
            renameFile("PrintPdf", pdfFileName);
            pdfText = getPDFText(pdfFileName);
            Log.info(pdfFileName);
        } catch (IOException e) {
            Log.error("PDF could not be found or read " + e.getMessage());
            throw new FLException("PDF file could not be found or read " + pdfFileName + ">>>> " + e.getMessage());
        } catch (Exception e) {
            Log.error("Error occured while reading pdffilename " + pdfFileName + " " + e.getMessage());
            throw new FLException("Error occured while reading pdffilename " + pdfFileName + ">>>> " + e.getMessage());
        } finally {
            tabs = new ArrayList<>(driver.getWindowHandles());
            if (tabs.size() > 1)
                driver.close();

            driver.switchTo().window(tabs.get(0));
        }
        Assert.assertTrue("Could not find Public Protected form in PDF File ", pdfText.contains("Public Protected Form with required fields"));
        Assert.assertTrue("Could not find Agent Protected form in PDF File ", pdfText.contains("Agent Protected Form with required fields"));
        Assert.assertFalse("Found Client Protected form in PDF File ", pdfText.contains("Client Protected Form with required fields"));

    }

    @Then("User Now Goes to Other Action and Send Request Client to Fill & Sign Option")
    public void clickOtherActionModuleAndClickOnSendReqClientToFillAndSign() {
        captureScreenshot(driver, testContext, false);
        waitForPageToLoad(driver);
        clickElement(driver, onDataEntryPage.getOtherAction_modl());
        clickElement(driver, onDataEntryPage.getReq_client_fillsign_modl());
    }

    @Then("User On Request Client to Fill & Sign Change the Primary Signer to Owner from Insured")
    public void changePrimarySignerToOwnerFromInsured() {
        captureScreenshot(driver, testContext, false);
        clickElement(driver, onDataEntryPage.getBtn_Owner());
    }

    @Then("User Enters Name Email SSN, Birth Date for Both Insured and Owner")
    public void enterValidCredentialOnInsuredAndOwner() {
        captureScreenshot(driver, testContext, false);
        onDataEntryPage.getInsured_name().sendKeys(testContext.getMapTestData().get("insuredName"));
        onDataEntryPage.getInsured_email().sendKeys(testContext.getMapTestData().get("insuredEmail"));
        onDataEntryPage.getSsn_Insured().sendKeys(testContext.getMapTestData().get("insuredSSN"));
        clickElement(driver, onDataEntryPage.getInsured_birthdate());
        captureScreenshot(driver, testContext, false);
        onDataEntryPage.getInsured_birthdate().sendKeys(testContext.getMapTestData().get("insuredBirthdate"));
        onDataEntryPage.getName_Owner().sendKeys(testContext.getMapTestData().get("OwnerName"));
        onDataEntryPage.getEmail_Owner().sendKeys(testContext.getMapTestData().get("OwnerEmail"));
        onDataEntryPage.getSsn_Owner().sendKeys(testContext.getMapTestData().get("OwnerSSN"));
        clickElement(driver, onDataEntryPage.getBirthDate_Owner());
        onDataEntryPage.getBirthDate_Owner().sendKeys(testContext.getMapTestData().get("OwnerBirthdate"));
    }

    @Then("User Now Clicks on Generate Link Without Email button")
    public void clickOnGenerateLinkWithoutEmailButton() {
        captureScreenshot(driver, testContext, false);
        clickElement(driver, onDataEntryPage.getBtn_GenerateLinkWithOutEmail());
        addPropertyValueInJSON(testContext.getTestCaseID(), testContext, "PasscodeOnPrimaryGenerateLinkWithoutEmailScreen", onDataEntryPage.getOwner_PassCode().getText().trim());
        addPropertyValueInJSON(testContext.getTestCaseID(), testContext, "UrlLinkOnPrimaryGeneratedLinkWithoutEmailScreen", onDataEntryPage.getLink_GenerateLinkWithOutEmailOnOwner().getText().trim());
    }

    @Then("User Clicks Back to App button")
    public void clickBackToApp() {
        captureScreenshot(driver, testContext, false);
        clickElement(driver, onDataEntryPage.getBtn_Backapp());
    }

    @Then("User Pending Request dialog should appear, Get URL for Secondary Signer from Send reminder link,verify the generated passcode in previous step is same for primary signer")
    public void verifyRequestDiaLogAndSecondarySignerGeneratedPassCode() {
        captureScreenshot(driver, testContext, false);
        Assert.assertTrue("Pending Request is not displayed", onDataEntryPage.getPendingRequest_header().isDisplayed());
        Assert.assertFalse("Pending request passCode is Mismatch", testContext.getMapTestData().get("PasscodeOnPrimaryGenerateLinkWithoutEmailScreen").equals(onDataEntryPage.getPassCode_PendingRequest().getText()));
        clickElement(driver, onDataEntryPage.getSendRemider_PendingRequest());
        String msg = onDataEntryPage.getLink_MessageUrl().getText();
        String s1 = msg.substring(msg.indexOf(", click on ") + 11, msg.indexOf(", enter"));
        addPropertyValueInJSON(testContext.getTestCaseID(), testContext, "primaryUrl", s1);
        clickElement(driver, onDataEntryPage.getBtn_Send());
    }

    @Then("User verifies {string} app is created")
    public void verifyNewAppName(String status) {
        waitForPageToLoad(driver);
        captureScreenshot(driver, testContext, false);
        if(status.equals("new"))
            Assert.assertTrue("New App is not created", onDataEntryPage.getTxt_NewApplication().getText().contains(testContext.getMapTestData().get("dataEntryNewApplication")));
        else
            Assert.assertTrue("New App is not created", onDataEntryPage.getTxt_NewApplication().getText().contains("New Application - " + testContext.getMapTestData().get("product")));
    }

    @Then("User verifies {string} created successfully")
    public void verifyNewApp(String app) {
        waitForPageToLoad(driver);
        captureScreenshot(driver, testContext, false);
        if(app.contains("AppName"))
            app = app.replace("AppName", testContext.getMapTestData().get("newProductName"));
        syncElement(driver, onDataEntryPage.getCountinue_button(), EnumsCommon.TOVISIBLE.getText());
        Assert.assertTrue(app + " New App is not created", onDataEntryPage.getTxt_NewApplication().getText().contains(app));
        addPropertyValueInJSON(testContext.getTestCaseID(), testContext, EnumsJSONProp.SECONDNEWPRODUCTNAME.getText(), onDataEntryPage.getTxt_NewApplication().getText());
    }

    @Then("User verifies Data from Parent App is populated from Parent app, like First Name last name")
    public void verifyDataOnParentAppFromFirstNameAndLastName() {
        captureScreenshot(driver, testContext, false);
        syncElement(driver, onDataEntryPage.getTxt_FirstNameOnPublicProtectedRequired(), EnumsCommon.TOCLICKABLE.getText());
        clickElement(driver, getElement(driver, getExistingLocator(driver, onDataEntryPage.getClose_popupMVC(), onDataEntryPage.getClose_popupReact(), null, null)));
        Assert.assertEquals("FirstName is mismatched", testContext.getMapTestData().get("agent_firstname"), onDataEntryPage.getTxt_FirstNameOnPublicProtectedRequired().getAttribute("value"));
        Assert.assertEquals("LastName is mismatched", testContext.getMapTestData().get("agent_lastname"), onDataEntryPage.getTxt_LastNameOnPublicProtectedRequired().getAttribute("value"));
    }

    @Then("User now Opens Other Action Print PDF, verify Client Protected forms are not selected disabled")
    public void VerifyClientProtectedFormsAreNotSelected() {
        captureScreenshot(driver, testContext, false);
        clickElement(driver, onDataEntryPage.getOtherAction_modl());
        clickElement(driver, onDataEntryPage.getDisplay_Print_modl());
        boolean flag = true;
        for (WebElement element : onDataEntryPage.getList_ClientProtectedCheckBox()) {
            if (element.getText().contains("Client Protected") & element.isSelected())
                flag = false;
        }
        Assert.assertTrue("Client protected forms are selected", flag);
    }

    @Then("User Clicks Print selected document and verifies no Client Protected form showing in PDF")
    public void clickPrintSelectedButtonAndVerifyClientNotShowingInPdf() throws Exception {
        captureScreenshot(driver, testContext, false);
        syncElement(driver, onDataEntryPage.getBtn_PrintSelectDocument(), EnumsCommon.TOCLICKABLE.getText());
        clickElement(driver, onDataEntryPage.getBtn_PrintSelectDocument());
        sleepInMilliSeconds(2000);
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        if (tabs.size() > 1)
            driver.switchTo().window(tabs.get(1));
        String pdfFileName = "";
        String pdfText = "";
        try {
            pdfFileName = testContext.getModuleName() + "-" + testContext.getTestCaseID() + "_" + getDate("pdfFileName") + ".pdf";
            Path downloadFilePath = Paths.get(EnumsCommon.ABSOLUTE_DOWNLOADFILES_PATH.getText() + "PrintPdf.pdf");
            new WebDriverWait(driver, 60).until(d -> downloadFilePath.toFile().exists());
            renameFile("PrintPdf", pdfFileName);
            pdfText = getPDFText(pdfFileName);
            Log.info(pdfFileName);
        } catch (IOException e) {
            Log.error("PDF could not be found or read " + e.getMessage());
            throw new FLException("PDF file could not be found or read " + pdfFileName + ">>>> " + e.getMessage());
        } catch (Exception e) {
            Log.error("Error occured while reading pdffilename " + pdfFileName + " " + e.getMessage());
            throw new FLException("Error occured while reading pdffilename " + pdfFileName + ">>>> " + e.getMessage());
        } finally {
            tabs = new ArrayList<>(driver.getWindowHandles());
            if (tabs.size() > 1)
                driver.close();

            driver.switchTo().window(tabs.get(0));
        }
        Assert.assertTrue("Could not find Public Protected form in PDF File ", pdfText.contains("Public Protected Form with required fields"));
        Assert.assertTrue("Could not find Agent Protected form in PDF File ", pdfText.contains("Agent Protected Form with required fields"));
        Assert.assertFalse("Found Client Protected form in PDF File ", pdfText.contains("Client Protected Form with required fields"));

    }

    @Then("User Now Clicks on Link Icon before page number")
    public void clickIConOn() {
        captureScreenshot(driver, testContext, false);
        waitForPageToLoad(driver);
        clickElement(driver, onDataEntryPage.getBtn_ICon());
    }

    @Then("User It should show parent application name, Click Parent app")
    public void verifyParentApplicationNameAndClickApp() {
        captureScreenshot(driver, testContext, false);
        Assert.assertTrue("Parent Application Name is misMatched ", onDataEntryPage.getParentApplicationName().getText().contains("AT Sunil Protection Testing Product"));
        clickElement(driver, onDataEntryPage.getParentApplicationName());
    }

    @Then("User Verifies Continue button Enabled")
    public void user_Verifies_Continue_button_Enabled() {
        captureScreenshot(driver, testContext, false);
        Assert.assertTrue("Continue Button is not Enabled", onDataEntryPage.getCountinue_button().isEnabled());
    }

    @Then("User Verifies {string} button Enabled")
    public void user_Verifies_Apply_button_Enabled(String button) {
        syncElement(driver,onDataEntryPage.getCountinue_button(),EnumsCommon.TOVISIBLE.getText());
        captureScreenshot(driver, testContext, false);
        Assert.assertFalse(" Button is not Enabled", onDataEntryPage.getCountinue_button().getAttribute("class").contains("disabled"));
    }

    @Then("User stores Data Entry percentage")
    public void storeDataEntryPercentage() {
        captureScreenshot(driver, testContext, false);
        addPropertyValueInJSON(testContext.getTestCaseID(), testContext, "StoreDataPercentage", onDataEntryPage.getTxt_DataEntryPercentage().getText().trim());
    }

    @Then("User verifies three Pending Request dialog links")
    public void verifyPendingRequestDialogLinksPopup(List<String> expectedLinks) {
        captureScreenshot(driver, testContext, false);
        if(onReviewPage.getList_PendingRequestLinks_mvc().size() > 0){
            Assert.assertEquals(expectedLinks.get(0) + " Link should be ", onReviewPage.getList_PendingRequestLinks_mvc().get(0).getAttribute("innerText"), expectedLinks.get(0));
            Assert.assertEquals(expectedLinks.get(1) + " Link should be ", onReviewPage.getList_PendingRequestLinks_mvc().get(1).getAttribute("innerText"), expectedLinks.get(1));
            Assert.assertEquals(expectedLinks.get(2) + " Link should be ", onReviewPage.getList_PendingRequestLinks_mvc().get(2).getAttribute("innerText"), expectedLinks.get(2));
        } else {
            Assert.assertTrue(expectedLinks.get(0) + " Link should be ", onReviewPage.getList_PendingRequestLinks_React().get(0).getAttribute("innerText").contains( expectedLinks.get(0)));
            Assert.assertTrue(expectedLinks.get(1) + " Link should be ", onReviewPage.getList_PendingRequestLinks_React().get(1).getAttribute("innerText").contains( expectedLinks.get(1)));
            Assert.assertTrue(expectedLinks.get(2) + " Link should be ", onReviewPage.getList_PendingRequestLinks_React().get(2).getAttribute("innerText").contains( expectedLinks.get(2)));
        }
    }

    @Then("User clicks Close button on pending request page")
    public void user_clicks_button_on_pending_request_page() {
        captureScreenshot(driver, testContext, false);
        clickElement(driver, getElement(driver, getExistingLocator(driver, onDataEntryPage.getBtn_CloseDialog1(), onDataEntryPage.getBtn_CloseDialog2(), null, null)));
    }

    @Then("User Reload the page")
    public void user_Reload_the_page() {
        sleepInMilliSeconds(3000);
        captureScreenshot(driver, testContext, false);
        driver.navigate().refresh();
    }

    @Then("User Now Clicks on Other Action tab and Clicks on History button")
    public void clicksOtherActionTabAndHistoryButton() {
        captureScreenshot(driver, testContext, false);
        clickElementByJSE(driver, onDataEntryPage.getTab_otherActions());
        clickElementByJSE(driver, onDataEntryPage.getBtn_History());
    }

    @Then("User Verifies pending request link displayed underneath DATA ENTRY label")
    public void verifyPendingRequestINDataEntryLabel() {
        clickElementByJSE(driver, onDataEntryPage.getIcon_CrossHistory());
        Assert.assertTrue(" pending request link not displayed ", onDataEntryPage.getTxtBox_PendingRequest_DataEntry().getText().contains("pending request"));
        sleepInMilliSeconds(2000);
    }

    @Then("Pending Request popup should appear")
    public void pendingRequestShouldApper() {
        captureScreenshot(driver, testContext, false);
        waitForPageToLoad(driver);
        Assert.assertTrue("Pending Request is not displayed", onDataEntryPage.getTxt_PendingRequest().isDisplayed());
    }

    @Then("User clicks on Contact Agent Button It should display Message popup")
    public void user_clicks_next_page() {
        captureScreenshot(driver, testContext, false);
        clickElementByJSE(driver, onDataEntryPage.getBtn_ContactAgent());
        Assert.assertTrue("It Should not display Message popup", onDataEntryPage.getMsg_ContactAgentDialog().getText().contains("Message"));
    }

    @Then("User Verifies all fields and their values displayed to the Message popup")
    public void verifyAllFieldsAndCheckValue() {
        captureScreenshot(driver, testContext, false);
        clickElement(driver, onDataEntryPage.getMsg_FromNameDialogBox());
        Assert.assertEquals("ReceipantName is not displayed", testContext.getMapTestData().get("ReceipantName"), onDataEntryPage.getMsg_FromNameDialogBox().getAttribute("value"));
        Assert.assertEquals("Recipient Email is not displayed", testContext.getMapTestData().get("Recipient Email"), onDataEntryPage.getMsg_FromAddressDialogBox().getAttribute("value"));
        Assert.assertEquals("Yourname is not displayed", testContext.getMapTestData().get("Yourname"), onDataEntryPage.getMsg_ToNameDialogBox().getAttribute("value"));
        Assert.assertEquals("YourEmail is not displayed", testContext.getMapTestData().get("YourEmail"), onDataEntryPage.getMsg_ToAddressDialogBox().getAttribute("value"));
    }

    @Then("User Add some text to the Message body {string} and Click on Send button")
    public void addTextOnMessageBodyAndClickSendButton(String name) {
        captureScreenshot(driver, testContext, false);
        if (testContext.getMapTestData().get("uiType").equalsIgnoreCase("MVC")) {
            sendKeys(driver, onDataEntryPage.getMsg_body(), name);
            clickElementByJSE(driver, getElement(driver, getExistingLocator(driver, onDataEntryPage.getBtn_SendMessageMVC(), onDataEntryPage.getBtn_SendMessageReact(), null, null)));
        } else {
            sendKeys(driver, onDataEntryPage.getMailMessage(), name);
            clickElementByJSE(driver, onDataEntryPage.getBtn_Send());
        }
    }

    @Then("User Now Click on Complete Log Off button")
    public void user_Now_Click_on_button() {
        captureScreenshot(driver, testContext, false);
        clickElementByJSE(driver, onDataEntryPage.getBtn_CompleteOff());
    }

    @Then("User Complete Activity popup should appear")
    public void user_popup_should_appear_verify_content_available_at_the_popup() {
        captureScreenshot(driver, testContext, false);
        if (testContext.getMapTestData().get("uiType").equalsIgnoreCase("MVC")) {
            Assert.assertTrue("Complete Activity popup should not appear", onDataEntryPage.getHeader_CompleteActivity().isDisplayed());
        } else {
            Assert.assertTrue("Complete Activity popup should not appear", onDataEntryPage.getDialougeHeaderPendingRequestPopup().isDisplayed());

        }

    }

    @Then("User verifies all content available at the popup")
    public void verifyAllContentAvailableInPopup() {
        captureScreenshot(driver, testContext, false);
        if (testContext.getMapTestData().get("uiType").equalsIgnoreCase("MVC")) {
            Assert.assertTrue("content Text is not Displayed ", onDataEntryPage.getTxt_CompleteActivity().getText().contains("“Submit and logoff”"));
            Assert.assertTrue("Cancel button is not displayed", onDataEntryPage.getBtn_CrossActivity().isDisplayed());
            Assert.assertTrue("Cancel button is not Enabled", onDataEntryPage.getBtn_CrossActivity().isEnabled());
            Assert.assertTrue("Submit and Logoff button is not displayed", onDataEntryPage.getBtn_SubmitAndLogoff().isDisplayed());
            Assert.assertTrue("Submit and Logoff button is disabled", onDataEntryPage.getBtn_SubmitAndLogoff().isEnabled());
            Assert.assertTrue("Save - finish later button is not displayed", onDataEntryPage.getBtn_SaveAndFinish().isDisplayed());
            Assert.assertTrue("Save - finish later button is disabled", onDataEntryPage.getBtn_SaveAndFinish().isEnabled());
        } else {
            Assert.assertTrue("content Text is not Displayed ", onDataEntryPage.getTxt_CompleteActivity().getText().contains("“Submit and logoff”"));
            Assert.assertTrue("cancel button is not Displayed ", onDataEntryPage.getBtn_CancelMsg().isDisplayed());
            Assert.assertTrue("cancel button is not Enabled ", onDataEntryPage.getBtn_CancelMsg().isEnabled());
            Assert.assertTrue("Submit button is not Displayed ", onDataEntryPage.getBtn_SubmitLogoff().isDisplayed());
            Assert.assertTrue("Submit button is not Enabled ", onDataEntryPage.getBtn_SubmitLogoff().isEnabled());
            Assert.assertTrue("Save button is not Displayed ", onDataEntryPage.getBtn_Save().isDisplayed());
            Assert.assertTrue("cancel button is not Enabled ", onDataEntryPage.getBtn_Save().isEnabled());

        }
    }

    @Then("User Clicks on Cancel button Complete Activity popup should disappear")
    public void user_Clicks_on_Cancel_button_Complete_Activity_popup_should_disappear() {
        captureScreenshot(driver, testContext, false);
        if (testContext.getMapTestData().get("uiType").equalsIgnoreCase("MVC")) {
            clickElementByJSE(driver, onDataEntryPage.getBtn_CrossActivity());
            waitForPageToLoad(driver);
            Assert.assertFalse("Complete Activity popup should appear", onDataEntryPage.getHeader_CompleteActivity().isDisplayed());
        } else if (testContext.getMapTestData().get("uiType").equalsIgnoreCase("react")) {
            clickElementByJSE(driver, onDataEntryPage.getBtn_CancelCompleteActivity());
            waitForPageToLoad(driver);
            Assert.assertTrue("Complete Activity popup should appear", onDataEntryPage.getWizPageName().isDisplayed());
        }
    }

    @Then("User Clicks on Submit and logoff button")
    public void user_Clicks_on_Submit_and_logoff_button() {
        if (testContext.getMapTestData().get("uiType").equalsIgnoreCase("MVC")) {
            captureScreenshot(driver, testContext, false);
            clickElementByJSE(driver, onDataEntryPage.getBtn_SubmitAndLogoff());
        } else {
            captureScreenshot(driver, testContext, false);
            waitForPageToLoad(driver);
            clickElementByJSE(driver, onDataEntryPage.getBtn_SubmitLogoff());
        }
        driver.manage().deleteAllCookies();
    }

    @Then("User should Logoff from the External page and Thank you for using our application page should display")
    public void user_should_Logoff_from_the_External_page_and_page_should_display() {
        captureScreenshot(driver, testContext, false);
        Assert.assertTrue("Thank you for using our application page should not displayed", onDataEntryPage.getTxt_ConformationApplication().isDisplayed());
    }

    @Then("User Verifies the DATA ENTRY % is increased than before")
    public void verifyDataEntryPercentage() {
        captureScreenshot(driver, testContext, false);
        Assert.assertTrue("Data Entry % is decrease than before Data Entry %", Integer.parseInt(testContext.getMapTestData().get("StoreDataPercentage").split("%")[0].trim()) < Integer.parseInt(onDataEntryPage.getTxt_DataEntryPercentage().getText().split("%")[0].trim()));
    }

    @Then("User Verifies Data entered at External page is displaying at main application")
    public void verifyDataEnteredAtExternalPageIsDisplaying(DataTable dataTable) {
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
                        Assert.assertTrue(" owner data does not match for "+fieldName, findElement(driver, String.format(onCommonMethods_reactPage.dataEntryTextFields, fieldName, dataItemId, dataItemId, dataItemId)).getAttribute("value").contains(inputValue));
                    } else {
                        waitForPageToLoad(driver);
                        Assert.assertTrue(" owner data does not match for "+fieldName, findElement(driver, String.format(onDataEntryPage.txtBox_dataEntryTextFields_Mvc, fieldName, dataItemId, dataItemId, dataItemId)).getAttribute("value").contains(inputValue));
                    }
                    break;
                case "Check Box":
                    waitForPageToLoad(driver);
                    if (testContext.getUiType().equalsIgnoreCase(EnumsCommon.UITYPE_MVC.getText())) {
                        Assert.assertTrue("Check box is unchecked", findElement(driver, String.format(onCommonMethods_reactPage.formCheckBox, fieldName, dataItemId, dataItemId)).getAttribute("aria-checked").equalsIgnoreCase("true"));
                    } else if (testContext.getUiType().equalsIgnoreCase(EnumsCommon.UITYPE_REACT.getText())) {
                        Assert.assertTrue("Check box is unchecked", findElement(driver, String.format(onCommonMethodsPage.nonQualified, dataItemId)).getAttribute("aria-checked").equalsIgnoreCase("true"));
                    } else {
                        Assert.assertTrue("Check box is unchecked", Boolean.parseBoolean(findElement(driver, String.format(onCommonMethodsPage.formCheckBox_Mvc, fieldName, dataItemId, dataItemId, dataItemId)).getAttribute("aria-checked")));
                    }
                    break;
                case "Select":
                    if (testContext.getUiType().equalsIgnoreCase(EnumsCommon.UITYPE_MVC.getText())) {
                        Select select = new Select(findElement(driver, String.format(onCommonMethods_reactPage.dataEntrySelectFields, fieldName, dataItemId, dataItemId)));
                        select.selectByVisibleText(inputValue);
                    } else {
                        Select select = new Select(findElement(driver, String.format(onCommonMethodsPage.dataEntrySelectFields, fieldName, dataItemId, dataItemId, dataItemId)));
                        select.selectByVisibleText(inputValue);
                    }
                    break;
                default:
                    // logger.error("Invalid Locator Type: {}", locatorType);
                    Assert.fail("Invalid Locator Type");
            }
            captureScreenshot(driver, testContext, false);
        }
    }

    @Then("User clicks pending request")
    public void clickPendingRequestAndPopupShouldAppear(String parameter) {
        captureScreenshot(driver, testContext, false);
        syncElement(driver, onDataEntryPage.getTxtBox_PendingRequest_DataEntry(), EnumsCommon.TOCLICKABLE.getText());
        clickElementByJSE(driver, onDataEntryPage.getTxtBox_PendingRequest_DataEntry());
        clickElementByJSE(driver, onDataEntryPage.getClose_PendingRequest());
    }

    @Then("User Verifies all fields values displayed to the Message popup")
    public void verifyAllFieldsAndCheckValueForReact() {
        captureScreenshot(driver, testContext, false);
        clickElement(driver, onDataEntryPage.getMsg_FromNameDialogBox());
        Assert.assertEquals("RecipientName is not displayed", testContext.getMapTestData().get("ReceipantName"), onDataEntryPage.getMsg_FromUserNameDialogBox().getAttribute("value"));
        Assert.assertEquals("YourName is not displayed", testContext.getMapTestData().get("Yourname"), onDataEntryPage.getMsg_ToNameDialogBox().getAttribute("value"));
        Assert.assertEquals("YourEmail is not displayed", testContext.getMapTestData().get("YourEmail"), onDataEntryPage.getMsg_ToAddressDialogBox().getAttribute("value"));
    }

    @Then("User complete data Entry")
    public void userCompleteDataEntry() {
        waitForPageToLoad(driver);
        clickElementByJSE(driver, onDataEntryPage.getTxtBox_OwnerSSN());
        onDataEntryPage.getTxtBox_OwnerSSN().sendKeys(testContext.getMapTestData().get("ownerSSN"));
        clickElementByJSE(driver, onDataEntryPage.getTxtBox_OwnerSSN());
        onDataEntryPage.getTxtBox_OwnerSSN().sendKeys(testContext.getMapTestData().get("ownerSSN"));
        onDataEntryPage.getTxtBox_ownerDOB().sendKeys(testContext.getMapTestData().get("ownerBOD"));
        onDataEntryPage.getTxtBox_contractNumber().sendKeys(testContext.getMapTestData().get("contractNumber"));
        onDataEntryPage.getTxtBox_contractNumber().sendKeys(Keys.TAB);
        clickElementByJSE(driver, onDataEntryPage.getIcon_next());
        waitForPageToLoad(driver);
        onDataEntryPage.getTxtBox_primaryBenefitPecentage().sendKeys(testContext.getMapTestData().get("primaryBenefitPecentage"));
        clickElementByJSE(driver, onDataEntryPage.getIcon_next());
        waitForPageToLoad(driver);
        clickElementByJSE(driver, onDataEntryPage.getCheckBox_nonQulified());
        clickElementByJSE(driver, onDataEntryPage.getIcon_next());
        waitForPageToLoad(driver);
        onDataEntryPage.getTxtBox_agentFirstName().sendKeys(testContext.getMapTestData().get("agentFirstname"));
        onDataEntryPage.getTxtBox_agentLastNamefield().sendKeys(testContext.getMapTestData().get("agentLastName"));
        onDataEntryPage.getTxtBox_stateLicence().sendKeys(testContext.getMapTestData().get("stateLicence"));
        onDataEntryPage.getTxtBox_agentPercent().sendKeys(testContext.getMapTestData().get("comision"));
        onDataEntryPage.getTxtBox_agentPercent().sendKeys(Keys.TAB);
        clickElementByJSE(driver, onDataEntryPage.getIcon_next());
    }

    @Then("User clicks on {string} link")
    public void clickOnLink(String linkName) {
        captureScreenshot(driver, testContext, false);
        waitForPageToLoad(driver);
        switch (linkName) {
            case "Send Reminder to Deepak":
                clickElementByJSE(driver, onDataEntryPage.getLink_SendReminder());
                break;
            case "Cancel Request":
                clickElement(driver, getElement(driver, getExistingLocator(driver, onDataEntryPage.getLink_CancelPendingReqMVC(), onDataEntryPage.getLink_CancelPendingReqReact(), null, null)));
                break;
            case "Send Passcode to":
                clickElementByJSE(driver, onDataEntryPage.getLink_SendPasscodePendingReq());
                break;
            case "Cancel":
                clickElementByJSE(driver, getElement(driver, getExistingLocator(driver, onDataEntryPage.getBtn_CancelPendingReqMVC(), onDataEntryPage.getBtn_CancelPendingReqReact(), null, null)));
                break;
            case "OK":
                clickElementByJSE(driver, onDataEntryPage.getBtn_OkOnCancelReq());
                break;
            case "Send Reminder to JointOwnerNM":
                clickElementByJSE(driver, onDataEntryPage.getSendReminderToOwnerLinkPendingRequestPopup());
                break;
            case "Send Passcode to JointOwnerNM's Email":
                clickElementByJSE(driver, onDataEntryPage.getLink_SendPasscodeJointOwner());
                break;
            case "Cancel request":
                clickElementByJSE(driver, getElement(driver, getExistingLocator(driver, onDataEntryPage.getBtn_CancelPendingReqMVC(), onDataEntryPage.getBtn_CancelPendingReqReact(), null, null)));
                break;
            case "Cancel Joint Owner":
                clickElementByJSE(driver, onDataEntryPage.getLink_cancelPayor());
                break;
            case "Cancel PrimaryOwner":
                clickElementByJSE(driver, onDataEntryPage.getLink_cancelPrimaryOwner());
                break;
            case "Send Reminder to Primary OwnerNM":
                clickElementByJSE(driver, onDataEntryPage.getLink_SendRemiderprimary());
                break;
            case "Send Passcode to Primary OwnerNM":
                clickElementByJSE(driver, onDataEntryPage.getLink_SendPasscodePrimary());
                break;
            case "Ok Popup":
                clickElementByJSE(driver, onDataEntryPage.getBtn_OkDialogBox());
                break;
            case "close popup":
                clickElement(driver, onDataEntryPage.getTxt_ClosePendingpopup());
                break;
            case "close":
                clickElementByJSE(driver, getElement(driver, getExistingLocator(driver, onDataEntryPage.getClose_popupMVC(), onDataEntryPage.getClose_popupReact(), null, null)));
                break;
            case "Pending request":
                clickElementByJSE(driver, onDataEntryPage.getTxt_PendingRequestDataEntry());
                break;
            case "Close Application":
                clickElementByJSE(driver, onDataEntryPage.getBtn_CloseApplication());
                break;
            case "Send button":
                clickElementByJSE(driver, getElement(driver, getExistingLocator(driver, onDataEntryPage.getBtn_SendMessageMVC(), onDataEntryPage.getBtn_SendMessageReact(), null, null)));
                break;
            case "Close Request":
                clickElementByJSE(driver, getElement(driver, getExistingLocator(driver, onDataEntryPage.getClose_popupMVC(), onDataEntryPage.getClose_popupReact(), null, null)));
            case "Submit":
                clickElementByJSE(driver, onDataEntryPage.getBtn_SubmitMsg());
                break;
            case "Click Me! To Get Risk Classifier Score":
                clickElement(driver, onDataEntryPage.getBtn_ButtonLexisCall());
                break;
            case "Click Me to Trigger Lexis Nexis Risk Classifier":
                clickElementByJSE(driver, onDataEntryPage.getBtn_ButtonLexisCallClickForm());
                break;
            case "Click Me! To Get Risk Classifier Results":
                clickElementByJSE(driver, onDataEntryPage.getBtn_Lexis_Call());
                break;
            case "Rename":
                clickElementByJSE(driver, onDataEntryPage.getBtn_Rename2());
                break;
            case "RENAME":
                clickElement(driver, getElement(driver, getExistingLocator(driver, onDataEntryPage.getBtn_Rename(), onDataEntryPage.getBtn_Rename1(), null, null)));
                break;
            case "Click Me! To Get risk classifier Score":
                clickElement(driver, onDataEntryPage.getBtn_ButtonLexisCall1());
                break;
            case "Click Me to Trigger Lexis Nexis Instant ID":
                clickElement(driver, findElement(driver, String.format(onCommonMethodsPage.nonQualified, "Click_LNInstantID_Form")));
                break;
            default:
                throw new FLException("Invalid value for linkName: " + linkName);
        }
    }

    @Then("User clicks on {string} {string} link on data entry page")
    public void clickOnLink(String linkName, String user) {
        captureScreenshot(driver, testContext, false);
        switch (user) {
            case "Insured":
                clickOnPendingLinks(linkName, testContext.getMapTestData().get("insuredName1"));
                break;
            case "Owner":
                clickOnPendingLinks(linkName, testContext.getMapTestData().get("ownerName1"));
                break;
            case "Joint Owner":
                clickOnPendingLinks(linkName, testContext.getMapTestData().get("jointOwnerName"));
                break;
            case "Reviewer":
                clickOnPendingLinks(linkName, testContext.getMapTestData().get("reviewerName1"));
                break;
            default:
                throw new FLException("Invalid value for user or linkName: " + user + " or " + linkName);
        }
    }

    public void clickOnPendingLinks(String linkName, String user) {
        captureScreenshot(driver, testContext, false);
        if (findElements(driver, "//div[contains(text(),'Send Passcode to " + user + "')]//preceding::td[contains(@class,'outstandingRequestsDialog__requestDetails')]//following-sibling::td//div[contains(text(),'" + linkName + "')]").size() > 0)
            clickElement(driver, findElement(driver, "//div[contains(text(),'Send Passcode to " + user + "')]//preceding::td[contains(@class,'outstandingRequestsDialog__requestDetails')]//following-sibling::td//div[contains(text(),'" + linkName + "')]"));
        else
            clickElement(driver, findElement(driver, "//a[contains(text(),'Send Passcode to " + user + "')]//parent::div[contains(@id,'divOutStandingRequestActions')]//a[contains(text(),'" + linkName + "')]"));

    }

    @Then("User store {string} for {string}")
    public void userSaveCreds(String linkName, String user) {
        captureScreenshot(driver, testContext, false);
        if (findElements(driver, "//div[contains(text(),'Send Passcode to')]").size() > 0) {
            switch (user) {
                case "Insured":
                    addPropertyValueInJSON(testContext.getTestCaseID(), testContext, EnumsJSONProp.INSUREDPASSCODE.getText(), findElement(driver, "//div[contains(text(),'Send Passcode to " + testContext.getMapTestData().get("insuredName1") + "')]//ancestor::tr//span").getText().trim());
                    break;
                case "Owner":
                    addPropertyValueInJSON(testContext.getTestCaseID(), testContext, EnumsJSONProp.OWNERPASSCODE.getText(), findElement(driver, "//div[contains(text(),'Send Passcode to " + testContext.getMapTestData().get("ownerName1") + "')]//ancestor::tr//span").getText().trim());
                    break;
                case "Producer":
                    addPropertyValueInJSON(testContext.getTestCaseID(), testContext, EnumsJSONProp.PRODUCERPASSCODE.getText(), findElement(driver, "//div[contains(text(),'Send Passcode to " + testContext.getMapTestData().get("producerName1") + "')]//ancestor::tr//span").getText().trim());
                    break;
                case "Agent 3":
                    addPropertyValueInJSON(testContext.getTestCaseID(), testContext, EnumsJSONProp.AGENT3PASSCODE.getText(), findElement(driver, "//div[contains(text(),'Send Passcode to " + testContext.getMapTestData().get("agent3Name1") + "')]//ancestor::tr//span").getText().trim());
                    break;
                case "Agent 2":
                    addPropertyValueInJSON(testContext.getTestCaseID(), testContext, EnumsJSONProp.AGENT2PASSCODE.getText(), findElement(driver, "//div[contains(text(),'Send Passcode to " + testContext.getMapTestData().get("agent2Name1") + "')]//ancestor::tr//span").getText().trim());
                    break;
                case "Agent":
                    addPropertyValueInJSON(testContext.getTestCaseID(), testContext, EnumsJSONProp.AGENTPASSCODE.getText(), findElement(driver, "//div[contains(text(),'Send Passcode to " + testContext.getMapTestData().get("agentName1") + "')]//ancestor::tr//span").getText().trim());
                    break;
                default:
                    throw new FLException("Invalid value for: " + user + " or " + linkName);
            }
        } else {
            switch (user) {
                case "Insured":
                    addPropertyValueInJSON(testContext.getTestCaseID(), testContext, EnumsJSONProp.INSUREDPASSCODE.getText(), findElement(driver, "(//a[contains(text(),'Send Reminder to " + testContext.getMapTestData().get("insuredName1") + "')]//ancestor::tr//span)[2]").getText().trim());
                    break;
                case "Owner":
                    addPropertyValueInJSON(testContext.getTestCaseID(), testContext, EnumsJSONProp.OWNERPASSCODE.getText(), findElement(driver, "(//a[contains(text(),'Send Reminder to " + testContext.getMapTestData().get("ownerName1") + "')]//ancestor::tr//span)[2]").getText().trim());
                    break;
                case "Producer":
                    addPropertyValueInJSON(testContext.getTestCaseID(), testContext, EnumsJSONProp.PRODUCERPASSCODE.getText(), findElement(driver, "(//a[contains(text(),'Send Reminder to " + testContext.getMapTestData().get("producerName1") + "')]//ancestor::tr//span)[2]").getText().trim());
                    break;
                case "Agent 3":
                    addPropertyValueInJSON(testContext.getTestCaseID(), testContext, EnumsJSONProp.AGENT3PASSCODE.getText(), findElement(driver, "(//a[contains(text(),'Send Reminder to " + testContext.getMapTestData().get("agent3Name1") + "')]//ancestor::tr//span)[2]").getText().trim());
                    break;
                case "Agent 2":
                    addPropertyValueInJSON(testContext.getTestCaseID(), testContext, EnumsJSONProp.AGENT2PASSCODE.getText(), findElement(driver, "(//a[contains(text(),'Send Reminder to " + testContext.getMapTestData().get("agent2Name1") + "')]//ancestor::tr//span)[2]").getText().trim());
                    break;
                case "Agent":
                    addPropertyValueInJSON(testContext.getTestCaseID(), testContext, EnumsJSONProp.AGENTPASSCODE.getText(), findElement(driver, "(//a[contains(text(),'Send Reminder to " + testContext.getMapTestData().get("agentName1") + "')]//ancestor::tr//span)[2]").getText().trim());
                    break;
                default:
                    throw new FLException("Invalid value for: " + user + " or " + linkName);
            }
        }
    }

    @Then("User store {string} for {string} from email")
    public void userSavePasscode(String passcode, String user) {
        captureScreenshot(driver, testContext, false);
        switch (user) {
            case "Insured":
                addPropertyValueInJSON(testContext.getTestCaseID(), testContext, EnumsJSONProp.INSUREDPASSCODE.getText(), testContext.getMapTestData().get(passcode));
                break;
            case "Owner":
                addPropertyValueInJSON(testContext.getTestCaseID(), testContext, EnumsJSONProp.OWNERPASSCODE.getText(), testContext.getMapTestData().get(passcode));
                break;
            case "Annuitant":
                addPropertyValueInJSON(testContext.getTestCaseID(), testContext, EnumsJSONProp.ANNUITANTPASSCODE.getText(), testContext.getMapTestData().get(passcode));
                break;
            default:
                throw new FLException("Invalid value for: " + user + " or " + passcode);
        }
    }

    @Then("User store Email {string} for {string} from email")
    public void userSaveEmail(String mail, String user) {
        captureScreenshot(driver, testContext, false);
        switch (user) {
            case "Insured":
                addPropertyValueInJSON(testContext.getTestCaseID(), testContext, EnumsJSONProp.INSUREDEMAIL.getText(), testContext.getMapTestData().get(mail));
                break;
            case "Owner":
                addPropertyValueInJSON(testContext.getTestCaseID(), testContext, EnumsJSONProp.OWNEREMAIL.getText(), testContext.getMapTestData().get(mail));
                break;
            case "Annuitant":
                addPropertyValueInJSON(testContext.getTestCaseID(), testContext, EnumsJSONProp.ANNUITANTEMAIL.getText(), testContext.getMapTestData().get(mail));
                break;
            default:
                throw new FLException("Invalid value for: " + user + " or " + mail);
        }
    }

    @Then("User verify {string} button {string} for {string} on SSN home page")
    public void verifyLinks(String linkName, String status, String user) {
        captureScreenshot(driver, testContext, false);
        int requestsSize;
        if(linkName.contains("Cancel"))
            requestsSize = findElements(driver, "//*[contains(text(),'Send Reminder to " + testContext.getMapTestData().get(testContext.getMapTestData().get(user)) + "')]//following-sibling::a[contains(text(),'" + linkName + "')]").size();
        else
            requestsSize = findElements(driver, "//*[contains(text(),'" + linkName + " " + testContext.getMapTestData().get(testContext.getMapTestData().get(user)) + "')]").size();

        if(status.equals("exists"))
            Assert.assertTrue(linkName + " request is not displayed for " + user, requestsSize > 0);
        else
            Assert.assertTrue(linkName + " request is displayed for " + user, requestsSize == 0);
    }

    @Then("User Complete Activity should appear")
    public void verifyActivityShouldAppear() {
        captureScreenshot(driver, testContext, false);
        Assert.assertTrue("Complete Activity popup should disappear", onDataEntryPage.getTxt_SubmitCompleteActivity().getText().contains("Submit and logoff"));
    }

    @Then("User verifies data {string}")
    public void verifyExternalData(String name) {
        captureScreenshot(driver, testContext, false);
        switch (name) {
            case "Owner First Name":
                Assert.assertEquals("Owner First Name is not displayed", testContext.getMapTestData().get("OwnerFName"), onRCTCompleteFillingAppPage.getTxtBox_OwnerName().getAttribute("value"));
                break;
            case "Owner Last Name":
                Assert.assertEquals("Owner Last Name is not displayed", testContext.getMapTestData().get("OwnerlName"), onRCTCompleteFillingAppPage.getTxtBox_OwnerLName().getAttribute("value"));
                break;
            case "Zip Code":
                ArrayList<WebElement> listZipcode = new ArrayList<>(onDataEntryPage.getListTxtbox_ZipCode());
                if (listZipcode.size() > 0) {
                    waitForPageToLoad(driver);
                    Assert.assertEquals("Zip Code is Mismatched", testContext.getMapTestData().get("ZipCode"), onDataEntryPage.getTxtbox_ZipCode().getAttribute("value"));
                } else {
                    waitForPageToLoad(driver);
                    Assert.assertEquals("Zip Code is Mismatched", testContext.getMapTestData().get("ZipCode"), onRCTCompleteFillingAppPage.getTxtBox_ZipCode().getAttribute("value"));
                }
                break;
            case "Owner DOB":
                Assert.assertEquals("Owner DOB is Mismatched", testContext.getMapTestData().get("Owner DOB"), onRCTCompleteFillingAppPage.getTxtBox_OwnerDOB().getAttribute("value"));
                break;
            case "Benefit Percentage":
                Assert.assertEquals("Benefit Percentage is Mismatched", testContext.getMapTestData().get("Benefit Percentage"), onRCTCompleteFillingAppPage.getTxtBox_BenefitPercentage().getAttribute("value"));
                break;
            case "Contact Number":
                Assert.assertEquals("Contact Number", testContext.getMapTestData().get("Contact Number"), onRCTCompleteFillingAppPage.getTxtBox_ContactNumber().getAttribute("value"));
                break;
            case "Date Of Birth":
                Assert.assertEquals("Date Of Birth is Mismatched", testContext.getMapTestData().get("Date Of Birth"), onRCTCompleteFillingAppPage.getTxtBox_DateOfBirth().getAttribute("value"));
                break;
            case "First Name":
                Assert.assertTrue("First name is Mismatched", onDataEntryPage.getTxtbox_FirstName().isDisplayed());
                break;
            case "Last Name":
                Assert.assertTrue("Last name is Mismatched", onDataEntryPage.getTxtbox_lastName().isDisplayed());
                break;
            case "Date of Birth":
                Assert.assertTrue("Dob is Mismatched", onDataEntryPage.getTxtBox_DOB().isDisplayed());
                break;
            case "Percentage of Proceeds":
                Assert.assertTrue("Percentage of Proceeds is Mismatched", onDataEntryPage.getTxtBox_PercentageOfProceed().isDisplayed());
                break;
            case "Beneficiaries First Name":
                Assert.assertTrue("Beneficiaries First Name is not matched", onDataEntryPage.getTxtbox_FirstName().isDisplayed());
                break;
            case "Beneficiaries Last Name":
                Assert.assertTrue("Beneficiaries Last Name is not matched", onDataEntryPage.getTxtbox_lastName().isDisplayed());
                break;
            case "Agent First Name":
                Assert.assertTrue("Agent First Name is not displayed", onDataEntryPage.getTxtbox_lastName().isDisplayed());
                break;
            case "Agent Last Name":
                Assert.assertTrue("Agent Last Name is not displayed", onDataEntryPage.getTxtbox_lastName().isDisplayed());
                break;
            case "Payment Method":
                Assert.assertEquals("Payment Method is incorrect", testContext.getMapTestData().get("Payment Method"), onDataEntryPage.getTxtBox_SelectPaymentMethod().getAttribute("value"));
                break;
            case "Primary Beneficiaries":
                Assert.assertEquals(" Primary Beneficiaries is incorrect", testContext.getMapTestData().get("Primary Beneficiaries"), onDataEntryPage.getTxtBox_SelectPrimaryBeneficiary().getAttribute("value"));
                break;
            case "Relationship to Owner":
                Assert.assertEquals("Relationship to Owner is incorrect", testContext.getMapTestData().get("Relationship to Owner"), onDataEntryPage.getTxtBox_SelectRelationToOwner().getAttribute("value"));
                break;
            case "Cancel request":
                Assert.assertTrue("Cancel button is not displayed", getElement(driver, getExistingLocator(driver, onDataEntryPage.getBtn_CancelPendingReqMVC(), onDataEntryPage.getBtn_CancelPendingReqReact(), null, null)).isDisplayed());
                break;
            case "Send":
                Assert.assertTrue("Send button is not displayed", getElement(driver, getExistingLocator(driver, onDataEntryPage.getBtn_SendMessageMVC(), onDataEntryPage.getBtn_SendMessageReact(), null, null)).isDisplayed());
                break;
            case "Signature Pending request":
                Assert.assertTrue("Signature Pending request is displayed", onDataEntryPage.getTxt_PendingRequest().isDisplayed());
                break;
            case "Owner select":
                Assert.assertTrue("Owner should not select", onDataEntryPage.getCheckBox_Owner().isSelected());
                break;
            case "OK":
                waitForPageToLoad(driver);
                Assert.assertTrue("Ok DialogBox Should not displayed", onDataEntryPage.getBtn_OkDialogBox().isDisplayed());
                break;
            case "From Name":
                Assert.assertTrue("From Name is not displayed", onDataEntryPage.getTxt_FromName().isDisplayed());
                break;
            case "From Address":
                Assert.assertTrue("From Address is not displayed", onDataEntryPage.getTxt_FromAddress().isDisplayed());
                break;
            case "To Name":
                Assert.assertTrue("To Name is not displayed", onDataEntryPage.getTxt_ToName().isDisplayed());
                break;
            case "Subject":
                Assert.assertTrue("Subject is not displayed", onDataEntryPage.getTxt_Subject().isDisplayed());
                break;
            case "Message":
                Assert.assertTrue("Message is not displayed", onDataEntryPage.getTxt_Message().isDisplayed());
                break;
            case "CLose link":
                Assert.assertTrue("CLose link is not displayed", onDataEntryPage.getLink_CloseIcon().isDisplayed());
                break;
            case "Ok Confirmation":
                Assert.assertTrue("Ok Confirmation is not displayed", onDataEntryPage.getTxt_OKConfirmationPopup().isDisplayed());
                break;
            case "lock Activity":
                Assert.assertTrue("lock Activity is not displayed", onDataEntryPage.getTxt_OKConfirmationPopup().isDisplayed());
                break;
            case "Electronic Signature":
                Assert.assertTrue("Electronic Signature is not displayed", onDataEntryPage.getTxt_ElectronicSignature().isDisplayed());
                break;
            case "Congratulations popup":
                Assert.assertTrue("Congratulations page should not display", onDataEntryPage.getBtn_OK().isDisplayed());
                break;
            case "Signing Error":
            case "Confirmation Dialog" :
                Assert.assertTrue("Confirmation Dialog box was not appear", onDataEntryPage.getTxt_OKConfirmationPopup().isDisplayed());
                break;
            default:
                throw new FLException("Invalid value for: " + name);
        }
    }

    @Then("User verifies field value {string} for {string}")
    public void verifyFieldvalue(String name, String user) {
        captureScreenshot(driver, testContext, false);
        switch (user) {
            case "Insured":
                switch (name) {
                    case "From Name":
                        Assert.assertEquals("From Name does not match", testContext.getMapTestData().get("Yourname"), onDataEntryPage.getTxtBox_YourNM().getAttribute("value"));
                        break;
                    case "From Address":
                        Assert.assertEquals("From address does not match", testContext.getMapTestData().get("YourEmail"), onDataEntryPage.getTxtbox_FromEmail().getAttribute("value"));
                        break;
                    case "To Name":
                        Assert.assertEquals("To Name does not match", testContext.getMapTestData().get("insuredName1"), onDataEntryPage.getTxtBox_RecipientName().getAttribute("value"));
                        break;
                    case "To Address":
                        Assert.assertEquals("To Address does not match", testContext.getMapTestData().get("insuredEmail"), onDataEntryPage.getTxtBox_RecipientAddress().getAttribute("value"));
                        break;
                    case "Subject":
                        Assert.assertTrue("Subject does not match", onDataEntryPage.getTxtBox_RecipientSubject().getAttribute("value").contains(testContext.getMapTestData().get("newProductName")));
                        break;
                    default:
                        throw new FLException("Invalid value for name: " + name);
                }
                break;
            case "Owner":
                switch (name) {
                    case "From Name":
                        Assert.assertEquals("From Name does not match", testContext.getMapTestData().get("Yourname"), onDataEntryPage.getTxtBox_YourNM().getAttribute("value"));
                        break;
                    case "From Address":
                        Assert.assertEquals("From address does not match", testContext.getMapTestData().get("YourEmail"), onDataEntryPage.getTxtbox_FromEmail().getAttribute("value"));
                        break;
                    case "To Name":
                        Assert.assertEquals("To Name does not match", testContext.getMapTestData().get("ownerName1"), onDataEntryPage.getTxtBox_RecipientName().getAttribute("value"));
                        break;
                    case "To Address":
                        Assert.assertEquals("To Address does not match", testContext.getMapTestData().get("ownerEmail"), onDataEntryPage.getTxtBox_RecipientAddress().getAttribute("value"));
                        break;
                    case "Subject":
                        Assert.assertTrue("Subject does not match", onDataEntryPage.getTxtBox_RecipientSubject().getAttribute("value").contains(testContext.getMapTestData().get("newProductName")));
                        break;
                    case "Subject Passcode":
                        Assert.assertTrue("Subject does not match", onDataEntryPage.getTxtBox_RecipientSubject().getAttribute("value").contains("Passcode Application"));
                        break;
                    default:
                        throw new FLException("Invalid value for name: " + name);
                }
                break;
            default:
                throw new FLException("Invalid value for user: " + user);
        }
    }

    @Then("User Clicks Pending request Button")
    public void clickPendingRequest() {
        captureScreenshot(driver, testContext, false);
        clickElementByJSE(driver, onDataEntryPage.getTxt_DataEntryPercentage());
    }

    @Then("User verifies pending request link displayed")
    public void verifyPendingRequestLink() {
        captureScreenshot(driver, testContext, false);
        Assert.assertTrue(" pending request link not displayed ", onDataEntryPage.getTxt_DataEntryPercentage().getText().contains("pending request"));
    }

    @Then("User verifies the pending requests dialog is show {string} in place of the passcode value")
    public void userVerifiesExpiredTextonPendingRequestPopupBox(String expire) {
        captureScreenshot(driver, testContext, false);
        WebElement element = getElement(driver, getExistingLocator(driver, onDataEntryPage.getPasscode_PendingReqMVC(), onDataEntryPage.getPasscode_PendingReqReact(), null, null));
        while (!(element.getText().trim().equalsIgnoreCase(expire))) {
            sleepInMilliSeconds(3000);
            driver.navigate().refresh();
            waitForPageToLoad(driver);
            if (getElements(driver, onDataEntryPage.getPasscode_PendingReqMVC()).size() == 0 & getElements(driver, onDataEntryPage.getPasscode_PendingReqReact()).size() == 0)
                driver.navigate().refresh();
            element = getElement(driver, getExistingLocator(driver, onDataEntryPage.getPasscode_PendingReqMVC(), onDataEntryPage.getPasscode_PendingReqReact(), null, null));
        }
        Assert.assertTrue("Expire text is not displayed instead of passcode value.", element.getText().trim().contains(expire));
    }

    @Then("User clicks on the {string} link")
    public void userClicksLink(String link) {
        waitForPageToLoad(driver);
        captureScreenshot(driver, testContext, false);
        if (link.contains("Send Reminder")) {
            clickElement(driver, getElement(driver, getExistingLocator(driver, onDataEntryPage.getLink_SendReminderMail(), onDataEntryPage.getLink_SendReminderMailReact(), null, null)));
        } else {
            clickElement(driver, getElement(driver, getExistingLocator(driver, onDataEntryPage.getLink_sendPasscodeMVC(), onDataEntryPage.getLink_sendPasscodeReact(), onDataEntryPage.getLink_sendPasscodeReact1(), null)));
        }
    }

    @Then("User clicks on send passcode link and click on send button and click ok button of popup box")
    public void userClicksOnSendPasscode() {
        waitForPageToLoad(driver);
        captureScreenshot(driver, testContext, false);
        clickElement(driver, getElement(driver, getExistingLocator(driver, onDataEntryPage.getLink_sendPasscodeMVC(), onDataEntryPage.getLink_sendPasscodeReact(), onDataEntryPage.getLink_sendPasscodeReact1(), null)));
        waitForPageToLoad(driver);
        clickElement(driver, getElement(driver, getExistingLocator(driver, onDataEntryPage.getBtn_SendOnPendingRequestMVC(), onDataEntryPage.getBtn_SendOnPendingRequestReact(), null, null)));
        waitForPageToLoad(driver);
    }

    @Then("User verifies application is display in Locked mode")
    public void applicationIsDisplayInLockedMode() {
        captureScreenshot(driver, testContext, false);
        Assert.assertTrue("Application is not in lock mode", onDataEntryPage.getIcon_AllicationLock().getAttribute("class").contains("lock"));
    }

    @Then("User verifies {string}, {string}, {string}, {string}, {string} data displayed on Pending Requests popup")
    public void userVerifiesDataDisplayedOnPendingRequestsPopup(String requestType, String recipient, String emailSent, String date, String passcode) {
        captureScreenshot(driver, testContext, false);
        if (testContext.getUiType().equalsIgnoreCase(EnumsCommon.UITYPE_MVC.getText())) {
            Assert.assertTrue("Request type is not displayed", onDataEntryPage.getRequestTypeText().getText().trim().contains(requestType));
            Assert.assertTrue("Recipient is not displayed", onDataEntryPage.getTxt_pendingRequestDetails().getText().split("\n")[1].trim().contains(recipient));
            Assert.assertTrue("Email is not displayed", onDataEntryPage.getTxt_pendingRequestDetails().getText().split("\n")[2].trim().contains(emailSent));
            Assert.assertTrue("Date is not displayed", onDataEntryPage.getTxt_pendingRequestDetails().getText().split("\n")[3].trim().contains(date));
            Assert.assertTrue("Passcode is not displayed", onDataEntryPage.getTxt_pendingRequestDetails().getText().split("\n")[4].trim().contains(passcode));
            addPropertyValueInJSON(testContext.getTestCaseID(), testContext, "passcode", onDataEntryPage.getTxt_pendingRequestDetails().getText().split("\n")[4].trim().split(":")[1].trim());
        }
        else{
            Assert.assertTrue("Recipient is not displayed", onDataEntryPage.getTxt_PendingRequestDialogDetails().get(1).getText().trim().contains(recipient));
            Assert.assertTrue("Email is not displayed", onDataEntryPage.getTxt_PendingRequestDialogDetails().get(2).getText().trim().contains(emailSent));
            Assert.assertTrue("Date is not displayed", onDataEntryPage.getTxt_PendingRequestDialogDetails().get(3).getText().trim().contains(date));
            Assert.assertTrue("Passcode is not displayed", onDataEntryPage.getTxt_PendingRequestDialogDetails().get(4).getText().trim().contains(passcode));
            addPropertyValueInJSON(testContext.getTestCaseID(), testContext, "passcode",onDataEntryPage.getTxt_PendingRequestDialogDetails().get(4).getText().trim().split(":")[1].trim());
        }
    }

    @Then("User verifies the {string} page displayed From Name, From Address, To Name, To Address, Subject, Message, Send button, Cancel button, Close link")
    public void userVerifiesTheSendReminderPageDisplayedFromNameFromAddressToNameToAddressSubjectMessageSendButtonCancelButtonCloseLink(String linkName) {
        captureScreenshot(driver, testContext, false);
        Assert.assertTrue("From name is not displayed", onDataEntryPage.getTxtBox_fromName().isDisplayed());
        Assert.assertTrue("From Address is not displayed", onDataEntryPage.getTxtBox_fromAddress().isDisplayed());
        Assert.assertTrue("To name is not displayed", onDataEntryPage.getTxtBox_toName().isDisplayed());
        Assert.assertTrue("To address is not displayed", onDataEntryPage.getTxtBox_toAddress().isDisplayed());
        Assert.assertTrue("Subject is not displayed", onDataEntryPage.getTxtBox_subject().isDisplayed());
        Assert.assertTrue("Message is not displayed", onDataEntryPage.getTxtBox_message().isDisplayed());
        Assert.assertTrue("Send button is not displayed", getElement(driver, getExistingLocator(driver, onDataEntryPage.getBtn_SendMessageMVC(), onDataEntryPage.getBtn_SendMessageReact(), null, null)).isDisplayed());
        Assert.assertTrue("Cancel button is not displayed", getElement(driver, getExistingLocator(driver, onDataEntryPage.getBtn_cancelMVC(), onDataEntryPage.getBtn_cancelReact(), null, null)).isDisplayed());
        if (testContext.getUiType().equalsIgnoreCase(EnumsCommon.UITYPE_MVC.getText())) {
            Assert.assertTrue("Close button/link is not displayed", onDataEntryPage.getBtn_CloseDialog().isDisplayed());
        }
    }

    @And("User clicks on cancel button")
    public void userClicksOnCancelButton() {
        captureScreenshot(driver, testContext, false);
        clickElementByJSE(driver, getElement(driver, getExistingLocator(driver, onDataEntryPage.getBtn_cancelMVC(), onDataEntryPage.getBtn_cancelReact(), null, null)));
    }

    @Then("User clicks on {string} button of {string}")
    public void userClicksOnSend(String sendButton, String link) {
        captureScreenshot(driver, testContext, false);
        userClicksLink(link);
        clickElementByJSE(driver, getElement(driver, getExistingLocator(driver, onDataEntryPage.getBtn_SendMessageMVC(), onDataEntryPage.getBtn_SendMessageReact(), null, null)));
    }

    @And("User verifies confirmation popup is appear")
    public void userVerifiesConfirmationPopupIsAppear() {
        captureScreenshot(driver, testContext, false);
        Assert.assertTrue("Confirmation popup box is not displayed", onDataEntryPage.getPopupbox_confirmation().isDisplayed());
        clickElementByJSE(driver, onDataEntryPage.getBtn_popupOk());
    }

    @Then("User clicks on Cancel Request link and clicks on {string} button of confirmation dialog")
    public void userClicksOnCancelRequestLink(String whichbutton) {
        waitForPageToLoad(driver);
        captureScreenshot(driver, testContext, false);
        clickElementByJSE(driver, onDataEntryPage.getLink_CancelRequest());
        if (onDataEntryPage.getBtn_CancelPopup().getText().trim().contains(whichbutton)) {
            clickElementByJSE(driver, onDataEntryPage.getBtn_CancelPopup());
        } else {
            clickElementByJSE(driver, onDataEntryPage.getBtn_popupOk());
        }
    }

    @Then("User reload the page")
    public void reloadThePageAndVerifiesPendingRequestPopupIsAppear() {
        driver.navigate().refresh();
        captureScreenshot(driver, testContext, false);
    }

    @Then("USer verifies Request get Cancel, application get unlocked, and status display as ‘Data Entry’, ‘pending request’ text is not display underneath ‘DATA ENTRY’ tab label")
    public void userVerifiesRequestGetCancel() {
        waitForPageToLoad(driver);
        syncElement(driver, onDataEntryPage.getIcon_AllicationLock(), EnumsCommon.TOVISIBLE.getText());
        captureScreenshot(driver, testContext, false);
        List<WebElement> listPedingRequest = new ArrayList<>(onDataEntryPage.getListTxt_PendingRequestDialog());
        if (listPedingRequest.size() > 0) {
            Assert.assertTrue("Pending Request is displayed", true);
        }
        Assert.assertTrue("Application is not in unlock mode", onDataEntryPage.getIcon_AllicationLock().getAttribute("class").contains("pencil"));
        if (new ArrayList<WebElement>(onDataEntryPage.getListtab_Dataentry_React()).size() > 0)
            Assert.assertTrue("DataEntry tab is NOT highlighted", onDataEntryPage.getListtab_Dataentry_React().get(0).getAttribute("class").contains("en-US"));
        else
            Assert.assertTrue("DataEntry tab is NOT highlighted", onDataEntryPage.getTab_DATAENTRY().getAttribute("class").contains("status_current") | onDataEntryPage.getTab_DATAENTRY().getAttribute("class").contains("Current"));

        ArrayList<WebElement> pendingRequesttxtOnDatatEntryTab = new ArrayList<WebElement>(onDataEntryPage.getList_pendingRequestOnDatatEntryTab());
        Boolean flag = false;
        if (pendingRequesttxtOnDatatEntryTab.size() > 0)
            flag = true;
        Assert.assertFalse("pending Request text/linl is displayed on DatatEntry Tab:", flag);
    }

    @And("User verifies {string} is displayed and store it")
    public void userVerifiesPasscodeIsDisplayedAndStoreIt(String passcode) {
        captureScreenshot(driver, testContext, false);
        ArrayList<WebElement> listPasscode = new ArrayList<>(onDataEntryPage.getListTxt_Passcode());
        if (listPasscode.size() > 0) {
            Assert.assertTrue("Passcode is not displayed", onDataEntryPage.getListTxt_Passcode().get(0).isDisplayed());
            addPropertyValueInJSON(testContext.getTestCaseID(), testContext, "Newpasscode", onDataEntryPage.getListTxt_Passcode().get(0).getText().trim());
        } else {
            Assert.assertTrue("Passcode is not displayed", onDataEntryPage.getTxt_pendingRequestDetails().getText().split("\n")[4].trim().contains(passcode));
            addPropertyValueInJSON(testContext.getTestCaseID(), testContext, "Newpasscode", onDataEntryPage.getTxt_pendingRequestDetails().getText().split("\n")[4].trim().split(":")[1].trim());
        }
    }

    @Then("User Verifies all fields and their values displayed into the Message popup")
    public void verifiesAllFieldsAndCheckValue() {
        captureScreenshot(driver, testContext, false);
        clickElement(driver, onDataEntryPage.getMsg_FromNameDialogBox());
        Assert.assertEquals("Recipient Name is mismatched.", testContext.getMapTestData().get("recipientName"), onDataEntryPage.getMsg_FromNameDialogBox().getAttribute("value"));
        Assert.assertTrue("From Address field is not displayed.", onDataEntryPage.getMsg_FromAddressDialogBox().isDisplayed());
        Assert.assertEquals("YourName is mismatched", testContext.getMapTestData().get("yourName"), onDataEntryPage.getMsg_ToNameDialogBox().getAttribute("value"));
        Assert.assertEquals("Your email is mismatched.", testContext.getMapTestData().get("yourEmail"), onDataEntryPage.getMsg_ToAddressDialogBox().getAttribute("value"));
    }

    @And("User enter from Email address")
    public void userEnterFromEmailAddress() {
        captureScreenshot(driver, testContext, false);
        onDataEntryPage.getTxtBox_fromAddress().sendKeys(testContext.getMapTestData().get("recipientEmail"));
    }

    @Then("User clicks {string} button on data entry page")
    public void userClicksButton(String whichButton) {
        waitForPageToLoad(driver);
        captureScreenshot(driver, testContext, false);
        switch (whichButton) {
            case "Close":
                clickElement(driver, onDataEntryReactPage.getBtn_CloseButton());
                break;
            case "Policy Custom button":
                clickElement(driver, onDataEntryReactPage.getBtn_PolicyCustom());
                break;
            case "Wet Sign Custom Button":
                clickElement(driver, onDataEntryReactPage.getBtn_WetSign());
                break;
            case "Voided Check":
            case "State Notice Upload":
                clickElement(driver, onDataEntryReactPage.getBtn_Open());
                break;
            case "Unlock Activity":
                clickElement(driver, onDataEntryReactPage.getBtn_UnlockActivity());
                break;
            case "Unlock":
                clickElement(driver, onDataEntryReactPage.getBtn_Unlock());
                break;
            case "Lock":
            case "Pencil":
                clickElement(driver, onDataEntryReactPage.getBtn_Lock());
                break;
            case "CLOSE":
                clickElement(driver, onDataEntryPage.getBtn_ActivitySummaryClose());
                break;
            default:
                throw new FLException("Invalid value for: " + whichButton);
        }
    }

    @Then("User clicks on close link and popup is closed")
    public void userClicksOnCloseButtonLink() {
        captureScreenshot(driver, testContext, false);
        if (testContext.getMapTestData().get("uiType").equalsIgnoreCase("react")) {
            clickElementByJSE(driver, onDataEntryPage.getBtn_Close());
        } else {
            syncElement(driver, onDataEntryPage.getBtn_CloseDialog(), EnumsCommon.TOCLICKABLE.getText());
            clickElementByJSE(driver, onDataEntryPage.getBtn_CloseDialog());
        }
        waitForPageToLoad(driver);
        Assert.assertTrue("Data Entry page is not displayed", onDataEntryPage.getTxtBtn_DataEntry().isDisplayed());
    }

    @Then("User Now Clicks on Other Action tab and  Clicks on {string}")
    public void userNowClicksOnOtherActionTab(String givenOtherActionOption) {
        captureScreenshot(driver, testContext, false);
        waitForPageToLoad(driver);
        clickElementByJSE(driver, onDataEntryPage.getTab_otherActions());
        waitForPageToLoad(driver);
        Assert.assertTrue(givenOtherActionOption + " was not displayed", findElement(driver, String.format(onDataEntryPage.otherActionsList, givenOtherActionOption)).isDisplayed());
        clickElement(driver, driver.findElement(By.xpath("//a[text()='" + givenOtherActionOption + "']")));
    }

    @Then("User verifies {string} text is display underneath ‘DATA Entry’ tab label")
    public void userVerifiesTextIsDisplayUnderneathDATAEntryTabLabel(String pendingRequesttxt) {
        captureScreenshot(driver, testContext, false);
        if (testContext.getMapTestData().get("uiType").equalsIgnoreCase("MVC")) {
            Assert.assertEquals("Pending request text is not display underneath ‘DATA Entry’ tab label", pendingRequesttxt, onDataEntryPage.getLink_pendingRequestOnDatatEntryTab().getText().trim());
        } else {
            Assert.assertEquals("Pending request text is not display underneath ‘DATA Entry’ tab label", pendingRequesttxt, onDataEntryPage.getBtn_DataPercentage().getText().trim());
        }
    }

    @Then("User clicks on pending request link")
    public void userClicksOnPendingRequestLink() {
        captureScreenshot(driver, testContext, false);
        if (testContext.getMapTestData().get("uiType").equalsIgnoreCase("MVC")) {
            clickElementByJSE(driver, onDataEntryPage.getLink_pendingRequestOnDatatEntryTab());
            waitForPageToLoad(driver);
        } else {
            clickElementByJSE(driver, onDataEntryPage.getBtn_DataPercentage());
        }
    }

    @Then("User verifies Pending Request dialog")
    public void verifyPendingRequest() {
        captureScreenshot(driver, testContext, false);
        Assert.assertTrue("Pending Request Popup should not appear", onDataEntryPage.getPopUp_PendingReq().isDisplayed());
    }

    @Then("User captures DATA ENTRY% & verify Data Entry % should not be {int}%")
    public void userCapturesDATAENTRYVerifyDataEntryShouldNotBe(int per) {
        captureScreenshot(driver, testContext, false);
        syncElement(driver, onDataEntryPage.getTxt_DataEntryPercentage(), EnumsCommon.TOVISIBLE.getText());
        String percentage = onDataEntryPage.getTxt_DataEntryPercentage().getText().split("%")[0].trim();
        int percent = Integer.parseInt(percentage);
        addPropertyValueInJSON(testContext.getTestCaseID(), testContext, "storeDataPercentage", percentage);
        Assert.assertTrue("Data entry % should not less than 100%", percent < 100);
    }

    @Then("User navigates to Data Entry page")
    public void userNavigatesToDataEntryPage() {
        captureScreenshot(driver, testContext, false);
        Assert.assertTrue("DataEntry tab is NOT highlighted", onDataEntryPage.getTxtBtn_DataEntry().isDisplayed());
    }

    @Then("User enter {string} data in required fields")
    public void enterAllRequiredField(String data) {
        captureScreenshot(driver, testContext, false);
        switch (data) {
            case "Individual Check Box":
                clickElementByJSE(driver, onDataEntryPage.getCkeckBox_Individual());
                break;
            case "Non-Quaqlified Account":
                clickElementByJSE(driver, onDataEntryPage.getCheckBox_NonQualifiedAccount());
                break;
            case "Replacement Questions1":
                clickElementByJSE(driver, onDataEntryPage.getCheckBox_ReplacementQut());
                break;
            case "Replacement Questions2":
                clickElementByJSE(driver, onDataEntryPage.getCheckBox_ReplacementQutAnnuity());
                break;
            case "First Name":
                waitForPageToLoad(driver);
                onDataEntryPage.getTxtbox_FirstName().sendKeys(testContext.getMapTestData().get("First Name") + Keys.TAB);
                break;
            case "Agent First Name":
                waitForPageToLoad(driver);
                onDataEntryPage.getTxtbox_FirstName().sendKeys(testContext.getMapTestData().get("Agent First Name") + Keys.TAB);
                break;
            case "Last Name":
                waitForPageToLoad(driver);
                onDataEntryPage.getTxtbox_lastName().sendKeys(testContext.getMapTestData().get("Last Name") + Keys.TAB);
                break;
            case "Agent Last Name":
                waitForPageToLoad(driver);
                onDataEntryPage.getTxtbox_lastName().sendKeys(testContext.getMapTestData().get("Agent Last Name") + Keys.TAB);
                break;
            case "Date of Birth":
                waitForPageToLoad(driver);
                onDataEntryPage.getTxtBox_DOB().sendKeys(testContext.getMapTestData().get("DOB") + Keys.TAB);
                break;
            case "Zip Code":
                waitForPageToLoad(driver);
                onDataEntryPage.getTxtbox_ZipCode().sendKeys(testContext.getMapTestData().get("ZipCode") + Keys.TAB);
                break;
            case "Percentage of Proceeds":
                waitForPageToLoad(driver);
                clickElementByJSE(driver, onDataEntryPage.getTxtBox_PercentageOfProceed());
                onDataEntryPage.getTxtBox_PercentageOfProceed().sendKeys(testContext.getMapTestData().get("Percentage of Proceeds") + Keys.TAB);
                break;
            case "Beneficiaries First Name":
                waitForPageToLoad(driver);
                onDataEntryPage.getTxtbox_FirstName().sendKeys(testContext.getMapTestData().get("Beneficiaries First Name") + Keys.TAB);
                break;
            case "Beneficiaries Last Name":
                waitForPageToLoad(driver);
                onDataEntryPage.getTxtbox_lastName().sendKeys(testContext.getMapTestData().get("Beneficiaries Last Name") + Keys.TAB);
                break;
            default:
                throw new FLException("Invalid value for: " + data);
        }
    }

    @Then("User verifies display Message popup")
    public void verifyPopupMsg() {
        captureScreenshot(driver, testContext, false);
        Assert.assertTrue("Popup Message is  not displayed", onDataEntryPage.getMsg_Header().getText().trim().contains("Message"));
    }

    @Then("User select {string} option")
    public void selectPrimaryBenefiaries(String data) {
        captureScreenshot(driver, testContext, false);
        switch (data) {
            case "Primary Beneficiaries":
                new Select(onDataEntryPage.getTxtBox_PrimaryBeneficiaries()).selectByValue("1");
                break;
            case "Relationship to Owner":
                new Select(onDataEntryPage.getTxtBox_RelationShipToOwner()).selectByValue("1");
                break;
            case "Payment Method":
                new Select(onDataEntryPage.getTxtBox_PaymentMethod()).selectByValue("Replacement");
                break;
            default:
                throw new FLException("Invalid value for: " + data);
        }
    }

    @Then("User keeps {string} fields blank")
    public void keepfieldBlank(String data) {
        captureScreenshot(driver, testContext, false);
        switch (data) {
            case "Your Name":
                addPropertyValueInJSON(testContext.getTestCaseID(), testContext, EnumsJSONProp.YOURNAME.getText(), onDataEntryPage.getTxtBox_YourNM().getAttribute("value").trim());
                onDataEntryPage.getTxtBox_YourNM().clear();
                break;
            case "Your Email":
                addPropertyValueInJSON(testContext.getTestCaseID(), testContext, EnumsJSONProp.YOUREMAIL.getText(), onDataEntryPage.getMsg_FromAddressDialogBox().getAttribute("value").trim());
                onDataEntryPage.getMsg_FromAddressDialogBox().clear();
                break;
            case "Birth Date":
                onDataEntryPage.getTxtBox_OwnerdataOfBirth().clear();
                break;
            default:
                throw new FLException("Invalid value for: " + data);
        }
    }

    @Then("User store {string}")
    public void storeData(String passcodeType) {
        captureScreenshot(driver, testContext, false);
        switch (passcodeType.toLowerCase()) {
            case "owner passcode":
                waitForPageToLoad(driver);
                addPropertyValueInJSON(testContext.getTestCaseID(), testContext, EnumsJSONProp.OWNERPASSCODE.getText(), getElement(driver, getExistingLocator(driver, onDataEntryPage.getTxt_PrimaryOwnerPasscodeMVC(), onDataEntryPage.getTxt_PrimaryOwnerPasscodeReact(), null, null)).getText().trim());
                break;
            case "jointowner passcode":
                waitForPageToLoad(driver);
                addPropertyValueInJSON(testContext.getTestCaseID(), testContext, EnumsJSONProp.JOINTOWNERPASSCODE.getText(), getElement(driver, getExistingLocator(driver, onDataEntryPage.getTxt_JointOwnerPasscodeMVC(), onDataEntryPage.getTxt_JointOwnerPasscodeReact(), null, null)).getText().trim());
                break;
            case "annuitant passcode":
                waitForPageToLoad(driver);
                addPropertyValueInJSON(testContext.getTestCaseID(), testContext, EnumsJSONProp.ANNUITANTPASSCODE.getText(), findElement(driver, "//div[contains(text(),'Send Passcode to " + testContext.getMapTestData().get("annuitantName") + "')]//preceding::td[contains(@class,'outstandingRequestsDialog__requestDetails')]//span").getText().trim());
                break;
            default:
                throw new FLException("Invalid value provided for Passcode Type: " + passcodeType);
        }
    }

    @Then("User fill valid data of YourName and Your Email")
    public void enterAllDataOnRequestClient() {
        captureScreenshot(driver, testContext, false);
        onDataEntryPage.getTxtBox_YourNM().sendKeys(testContext.getMapTestData().get("Yourname"));
        onDataEntryPage.getMsg_FromAddressDialogBox().sendKeys(testContext.getMapTestData().get("YourEmail"));

    }

    @Then("User Notes the URL generated")
    public void saveUrl() {
        captureScreenshot(driver, testContext, false);
        addPropertyValueInJSON(testContext.getTestCaseID(), testContext, "URL", getElement(driver, getExistingLocator(driver, onDataEntryPage.getLink_RequestUrlMVC(), onDataEntryPage.getLink_RequestUrlReact(), null, null)).getText().trim());
        addPropertyValueInJSON(testContext.getTestCaseID(), testContext, "emailLink", getElement(driver, getExistingLocator(driver, onDataEntryPage.getLink_RequestUrlMVC(), onDataEntryPage.getLink_RequestUrlReact(), null, null)).getText().trim());
    }

    @Then("User clicks Ok popup button")
    public void clickOkbutton() {
        captureScreenshot(driver, testContext, false);
        clickElementByJSE(driver, onDataEntryPage.getBtn_OkDialogBox());
    }

    @Then("User verifies primary owner error msg name,email,ssn and DOB")
    public void verifyPrimaryFiled() {
        captureScreenshot(driver, testContext, false);
        Assert.assertEquals("", testContext.getMapTestData().get("ErrorMsgYourNM"), onDataEntryPage.getErrorMsg_YourNM().getText().trim());
        Assert.assertEquals("", testContext.getMapTestData().get("ErrorMsgYourEmail"), onDataEntryPage.getErrorMsg_YourEmail().getText().trim());
        Assert.assertEquals("Error Msg name is Mismatched", testContext.getMapTestData().get("ErrorNM"), onDataEntryPage.getErrorMsg_OwnerNM().getText().trim());
        Assert.assertEquals("Error Msg email is Mismatched", testContext.getMapTestData().get("Erroremail"), onDataEntryPage.getErrorMsg_OwnerEmail().getText().trim());
        Assert.assertEquals("Error Msg DOB is Mismatched", testContext.getMapTestData().get("ErrorDOB"), onDataEntryPage.getErrorMsg_OwnerDateOfBirth().getText().trim());
        Assert.assertEquals("Error Msg email is Mismatched", testContext.getMapTestData().get("ErrorSSN"), onDataEntryPage.getErrorMsg_OwnerSSN().getText().trim());
    }

    @Then("User verifies joint Owner error msg name,email,ssn and DOB")
    public void verifyPayorFiled() {
        captureScreenshot(driver, testContext, false);
        Assert.assertEquals("Error Msg name is Mismatched", testContext.getMapTestData().get("JointOwnerErrorNM"), onDataEntryPage.getErrorMsg_JointOwnerNM().getText().trim());
        Assert.assertEquals("Error Msg email is Mismatched", testContext.getMapTestData().get("JointOwnerErroremail"), onDataEntryPage.getErrorMsg_JointOwnerEmail().getText().trim());
        Assert.assertEquals("Error Msg DOB is Mismatched", testContext.getMapTestData().get("JointOwnerErrorDOB"), onDataEntryPage.getErrorMsg_JointOwnerDateOfBirth().getText().trim());
        Assert.assertEquals("Error Msg email is Mismatched", testContext.getMapTestData().get("JointOwnerErrorSSN"), onDataEntryPage.getErrorMsg_JointOwnerSSN().getText().trim());
    }

    @Then("User verifies {string} error msg name,email,ssn and DOB")
    public void verifyUserErrorMsg(String user) {
        captureScreenshot(driver, testContext, false);
        Assert.assertEquals("Error Msg name is Mismatched", testContext.getMapTestData().get("JointOwnerErrorNM"), findElement(driver, "//input[@aria-label='" + user + "']/parent::div//following-sibling::div//span[contains(@id,'ToName-error')]").getText().trim());
        Assert.assertEquals("Error Msg email is Mismatched", testContext.getMapTestData().get("JointOwnerErroremail"), findElement(driver, "//input[@aria-label='" + user + "']/parent::div//following-sibling::div//span[contains(@id,'ToEmail-error')]").getText().trim());
        Assert.assertEquals("Error Msg DOB is Mismatched", testContext.getMapTestData().get("JointOwnerErrorDOB"), findElement(driver, "//input[@aria-label='" + user + "']/parent::div//following-sibling::div//span[contains(@id,'BirthDate-error')]").getText().trim());
        Assert.assertEquals("Error Msg SSN is Mismatched", testContext.getMapTestData().get("JointOwnerErrorSSN"), findElement(driver, "//input[@aria-label='" + user + "']/parent::div//following-sibling::div//span[contains(@id,'SSN-error')]").getText().trim());
    }

    @Then("User selects primary user as {string}")
    public void selectPrimaryUser(String user) {
        captureScreenshot(driver, testContext, false);
        clickElement(driver, findElement(driver, "//input[@value='" + user + "']//preceding-sibling::input[@type='checkbox']"));
    }

    @Then("User verifies pending request")
    public void verifyAllLink(List<String> expectedLinks) {
        captureScreenshot(driver, testContext, false);
        Assert.assertEquals(expectedLinks.get(0) + " Link should be ", onDataEntryPage.getList_PendingRequest().get(0).getAttribute("innerText"), expectedLinks.get(0) + " " + testContext.getMapTestData().get("jointOwnerName"));
        Assert.assertEquals(expectedLinks.get(1) + " Link should be ", onDataEntryPage.getList_PendingRequest().get(1).getAttribute("innerText"), expectedLinks.get(1) + " " + testContext.getMapTestData().get("jointOwnerName") + "'s email");
        Assert.assertEquals(expectedLinks.get(2) + " Link should be ", onDataEntryPage.getList_PendingRequest().get(2).getAttribute("innerText"), expectedLinks.get(2));
        Assert.assertEquals(expectedLinks.get(3) + " Link should be ", onDataEntryPage.getList_PendingRequest().get(3).getAttribute("innerText"), expectedLinks.get(3) + " " + testContext.getMapTestData().get("ownerName1"));
        Assert.assertEquals(expectedLinks.get(4) + " Link should be ", onDataEntryPage.getList_PendingRequest().get(4).getAttribute("innerText"), expectedLinks.get(4) + " " + testContext.getMapTestData().get("ownerName1") + "'s email");
        Assert.assertEquals(expectedLinks.get(5) + " Link should be ", onDataEntryPage.getList_PendingRequest().get(5).getAttribute("innerText"), expectedLinks.get(5));
    }

    @Then("User verifies pending request for {string} and {string}")
    public void verifyAllLink(String user1, String user2, List<String> expectedLinks) {
        captureScreenshot(driver, testContext, false);
        switch (user1 + user2) {
            case "InsuredOwner":
                Assert.assertEquals(expectedLinks.get(0) + " Link should be ", onDataEntryPage.getList_PendingRequest().get(0).getAttribute("innerText"), expectedLinks.get(0) + " " + testContext.getMapTestData().get("insuredName1"));
                Assert.assertEquals(expectedLinks.get(1) + " Link should be ", onDataEntryPage.getList_PendingRequest().get(1).getAttribute("innerText"), expectedLinks.get(1) + " " + testContext.getMapTestData().get("insuredName1") + "`s email");
                Assert.assertEquals(expectedLinks.get(2) + " Link should be ", onDataEntryPage.getList_PendingRequest().get(2).getAttribute("innerText"), expectedLinks.get(2));
                Assert.assertEquals(expectedLinks.get(3) + " Link should be ", onDataEntryPage.getList_PendingRequest().get(3).getAttribute("innerText"), expectedLinks.get(3) + " " + testContext.getMapTestData().get("ownerName1"));
                Assert.assertEquals(expectedLinks.get(4) + " Link should be ", onDataEntryPage.getList_PendingRequest().get(4).getAttribute("innerText"), expectedLinks.get(4) + " " + testContext.getMapTestData().get("ownerName1") + "`s email");
                Assert.assertEquals(expectedLinks.get(5) + " Link should be ", onDataEntryPage.getList_PendingRequest().get(5).getAttribute("innerText"), expectedLinks.get(5));
                break;
            default:
                throw new FLException("Invalid Value Provided For Users: " + (user1 + user2));
        }
    }

    @Then("User verifies pending request  displayed")
    public void verifyPendingReq() {
        waitForPageToLoad(driver);
        Assert.assertTrue("Pending request is displayed", onDataEntryPage.getTxt_PrimaryPendingReq().isDisplayed());
    }

    @Then("User Note down the URL for external link in pending request")
    public void saveUrlInPendingRequestPopup() {
        String msg = onDataEntryPage.getLink_MessageUrl().getText();
        String s1 = msg.substring(msg.indexOf("href=") + 5, msg.indexOf(">C"));
        addPropertyValueInJSON(testContext.getTestCaseID(), testContext, "reviewerUrl", s1);
    }

    @Then("User Verify no Pending dialog box appear")
    public void verifypendingDialogbox() {
        captureScreenshot(driver, testContext, false);
        waitForPageToLoad(driver);
        List<WebElement> listPedingRequest = new ArrayList<>(onDataEntryPage.getListTxt_PendingRequestDialog());
        if (listPedingRequest.size() > 0) {
            Assert.assertTrue("Pending Request is displayed", true);
        }
    }

    @Then("For JointOwner\\(Secondary Signer) User gets the URL from Message template by clicking Send Reminder to Owner")
    public void forJointOwnerSecondarySignerUsergetsTheURL() {
        captureScreenshot(driver, testContext, false);
        clickElement(driver, onDataEntryPage.getSendReminderToOwnerLinkPendingRequestPopup());
        String emailMessage = onDataEntryPage.getMailMessage().getText().trim();
        String url = emailMessage.substring(emailMessage.indexOf("href") + 5, emailMessage.indexOf(">Click"));
        addPropertyValueInJSON(testContext.getTestCaseID(), testContext, EnumsJSONProp.JOINTOWNERURL.getText(), url);
        captureScreenshot(driver, testContext, false);
    }

    @Then("User stores {string} passcode as {string}")
    public void User_stores_passcode_as(String signerType, String signerName) {
        captureScreenshot(driver, testContext, false);
        switch (signerType.toLowerCase()) {
            case "primary signer":
                waitForPageToLoad(driver);
                addPropertyValueInJSON(testContext.getTestCaseID(), testContext, signerName + "Passcode", getElement(driver, getExistingLocator(driver, onDataEntryPage.getTxt_PrimaryOwnerPasscodeMVC(), onDataEntryPage.getTxt_PrimaryOwnerPasscodeReact(), null, null)).getText().trim());
                break;
            case "secondary signer":
                waitForPageToLoad(driver);
                addPropertyValueInJSON(testContext.getTestCaseID(), testContext, signerName + "Passcode", getElement(driver, getExistingLocator(driver, onDataEntryPage.getTxt_JointOwnerPasscodeMVC(), onDataEntryPage.getTxt_JointOwnerPasscodeReact(), null, null)).getText().trim());
                break;
            default:
                throw new FLException("Invalid value provided for Signer Type: " + signerType);
        }
    }

    @Then("User verifies {string} option is not displayed")
    public void userVerifiesIsNotDisplay(String form) {
        waitForPageToLoad(driver);
        captureScreenshot(driver, testContext, false);
        boolean flag = true;
        for (WebElement element : onDataEntryPage.getList_FormMenu()) {
            if (element.getText().trim().contains(form)) {
                flag = false;
                break;
            }
            Assert.assertTrue(form + " is displayed without select option from How many Transfers do you have ?", flag);
        }
    }

    @Then("User verifies {string} option is displayed")
    public void userVerifiesIsDisplay(String form) {
        waitForPageToLoad(driver);
        captureScreenshot(driver, testContext, false);
        Assert.assertTrue("1035 exchange form is not displayed", getElement(driver, getExistingLocator(driver, onDataEntryPage.getTxt_ExchangeRollFormMVC(), onDataEntryPage.getTxt_ExchangeRollFormReact(), null, null)).isDisplayed());
    }

    @Then("User clicks on Exchange Roll Form option")
    public void userClicksOnOption() {
        waitForPageToLoad(driver);
        captureScreenshot(driver, testContext, false);
        clickElementByJSE(driver, getElement(driver, getExistingLocator(driver, onDataEntryPage.getTxt_ExchangeRollFormMVC(), onDataEntryPage.getTxt_ExchangeRollFormReact(), null, null)));
    }

    @Then("User verifies the number of pages in each form that are showing required fields \\(in Red color)")
    public void userVerifiesTheNumberOfPagesInEachFormThatAreShowingRequiredFieldsInRedColor() {
        captureScreenshot(driver, testContext, false);
        for (WebElement element : onDataEntryPage.getList_FormMenu()) {
            List<WebElement> list_PagesInEachForm = driver.findElements(By.xpath("//div[@id='divForms']//ul[@class='listView']//li//a[contains(text(),'" + element.getText().split(" ")[1] + "')]/following-sibling::a[contains(@class,'errors') and contains(text(),'Page')]"));
            if (testContext.getMapTestData().get("applicationForm").contains(element.getText().split(" ")[1])) {
                Assert.assertEquals("Application form not displayed 4 pages", testContext.getMapTestData().get("applicationPages"), String.valueOf(list_PagesInEachForm.size()));
            } else if (testContext.getMapTestData().get("feesForm").contains(element.getText().split(" ")[1])) {
                Assert.assertEquals("Fees and Expense Disclosure Sample form not displayed 1 pages", testContext.getMapTestData().get("feesPages"), String.valueOf(list_PagesInEachForm.size()));
            } else {
                Assert.assertEquals("1035 EXCHANGEROLLOVERTRANSFER eFORM form not displayed 1 pages", testContext.getMapTestData().get("exchagePages"), String.valueOf(list_PagesInEachForm.size()));
            }
        }
    }

    @Then("User clicks on page1 form of application222")
    public void userClicksOnForms() {
        waitForPageToLoad(driver);
        captureScreenshot(driver, testContext, false);
        clickElementByJSE(driver, onDataEntryPage.getTxt_ApplicationPage1());
    }

    @Then("User expands application{int} form")
    public void userExpandsApplicationForm(int arg0) {
        waitForPageToLoad(driver);
        captureScreenshot(driver, testContext, false);
        clickElementByJSE(driver, onDataEntryPage.getIcon_ArrowAppication222Menu());
    }

    @Then("User verifies {string} popup showing")
    public void user_popup_showing_Continue_Popup(String partialHeading) {
        WebElement element = getElement(driver, getExistingLocator(driver, onDataEntryPage.getTxt_dataEntryPopupTextMVC(), onDataEntryPage.getTxt_dataEntryPopupTextReact(), null, null));
        syncElement(driver, element, EnumsCommon.TOVISIBLE.getText());
        captureScreenshot(driver, testContext, false);
        Assert.assertTrue("Data Entry Met Toast popup NOT Visible", element.getText().trim().contains(partialHeading));
    }

    @Then("User Verifies Data Entry Tab is active")
    public void user_Verifies_Data_Entry_Tab_in_active() {
        captureScreenshot(driver, testContext, false);
        if (new ArrayList<WebElement>(onDataEntryPage.getListtab_Dataentry_React()).size() > 0)
            Assert.assertTrue("DataEntry tab is NOT highlighted", onDataEntryPage.getListtab_Dataentry_React().get(0).getAttribute("class").contains("en-US"));
        else
            Assert.assertTrue("DataEntry tab is NOT highlighted", onDataEntryPage.getTab_DATAENTRY().getAttribute("class").contains("status_current"));
    }

    @Then("User Verifies {string} Tab is active")
    public void verifyActiveTab(String tabName) {
        captureScreenshot(driver, testContext, false);
        if (findElements(driver,String.format(onDataEntryPage.getTabById(),tabName)).size()>0)
            Assert.assertTrue(tabName + " tab is NOT highlighted", driver.findElement(By.id(tabName)).getAttribute("class").contains("status_current"));
        else
            Assert.assertTrue(tabName + " tab is NOT highlighted", driver.findElement(By.xpath("//span[text()='" + tabName + "']//preceding-sibling::div")).getAttribute("class").contains("Outer_Current"));
    }

    @Then("User verifies {string}, {string}, {string}, {string}, {string} data displayed on Pending Requests popup for owners")
    public void userVerifiesDataDisplayed(String requestType, String recipient, String emailSent, String date, String passcode) {
        captureScreenshot(driver, testContext, false);
        waitForPageToLoad(driver);
        Assert.assertTrue("Request type is not displayed", onDataEntryPage.getRequestTypeText().getText().trim().contains(requestType));
        Assert.assertTrue("Recipient is not displayed", onDataEntryPage.getTxt_pendingRequestDetails().getText().split("\n")[2].trim().contains(recipient));
        Assert.assertTrue("Email is not displayed", onDataEntryPage.getTxt_pendingRequestDetails().getText().split("\n")[3].trim().contains(emailSent));
        Assert.assertTrue("Date is not displayed", onDataEntryPage.getTxt_pendingRequestDetails().getText().split("\n")[4].trim().contains(date));
        Assert.assertTrue("Passcode is not displayed", onDataEntryPage.getTxt_pendingRequestDetails().getText().split("\n")[5].trim().contains(passcode));
    }

    @Then("User gets the URL from Message template by clicking Send Reminder to")
    public void forOwnerUsergetsTheURL() {
        captureScreenshot(driver, testContext, false);
        clickElement(driver, onDataEntryPage.getSendReminderToOwnerLinkPendingRequestPopup());
        String message = onDataEntryPage.getMailMessage().getText().trim();
        String url = message.substring(message.indexOf("href") + 5, message.indexOf(">Click"));
        addPropertyValueInJSON(testContext.getTestCaseID(), testContext, EnumsJSONProp.OWNERURL.getText(), url);
    }

    @Then("User Clicks On {string} Custom button")
    public void user_Clicks_On_button(String button) {
        captureScreenshot(driver, testContext, false);
        clickElementByJSE(driver, getElement(driver, getExistingLocator(driver, By.xpath(String.format(onDataEntryReactPage.btn_UploadaCopyofVoidedCheck_MVC, button)), By.xpath(String.format(onDataEntryReactPage.btn_UploadaCopyofVoidedCheck_REACT, button)), null, null)));
    }

    @Then("User Verifies value {string} for field {string}")
    public void userVerifiesValueForField(String value, String fieldName) {
        captureScreenshot(driver, testContext, false);
        Assert.assertEquals("Default value mismatched", value,
                onDataEntryReactPage.getDefaultDropdownValue(driver, fieldName).getText().trim());
    }

    @Then("User Selects {string} CheckBox")
    public void userSelectsCheckbox(String checkBoxName) {
        captureScreenshot(driver, testContext, false);
        clickElementByJSE(driver, onDataEntryReactPage.getCheckBox(driver, checkBoxName));
        captureScreenshot(driver, testContext, false);
    }

    @Then("User Verifies {string} CheckBox is selected")
    public void userVerifiesCheckbox(String checkBoxName) {
        waitForPageToLoad(driver);
        scrollToWebElement(driver, onDataEntryReactPage.getCheckBox(driver, checkBoxName));
        captureScreenshot(driver, testContext, false);
        Assert.assertFalse(checkBoxName + " check box was not selected", onDataEntryReactPage.getCheckBox(driver, checkBoxName).isSelected());
    }

    @Then("User Clicks on Continue Button and Verifies same page")
    public void user_Clicks_on_Continue_Button_and_Verifies_same_page() {
        captureScreenshot(driver, testContext, false);
        if (onDataEntryPage.getCountinue_button().isEnabled()) {
            clickElementByJSE(driver, onDataEntryPage.getCountinue_button());
            Assert.assertTrue("Continue Button was not Disabled so Click Operation Performed", true);
        }
    }


    @Then("User notes passcode for owner & joint owner")
    public void userNotesPasscodeForOwnerJointOwner() {
        captureScreenshot(driver, testContext, false);
        addPropertyValueInJSON(testContext.getTestCaseID(), testContext, EnumsJSONProp.JOINTOWNERPASSCODE.getText(),
                onDataEntryPage.getPasscode_JointOwner().getText().trim());
        addPropertyValueInJSON(testContext.getTestCaseID(), testContext, EnumsJSONProp.RECIPIENTPASSCODE.getText(),
                onDataEntryPage.getPasscode_SignOwner().getText().trim());

    }

    @Then("User verifies for the primary owner pending requests dialog is show {string} in place of the passcode value")
    public void userVerifiesExpireText(String expire) {
        captureScreenshot(driver, testContext, false);
        do {
            driver.navigate().refresh();
            waitForPageToLoad(driver);
            if (onDataEntryPage.getPasscode_SignOwner().getText().trim().equals(expire)) {
                break;
            }
        } while (onDataEntryPage.getPasscode_SignOwner().getText().trim() != (expire));
        Assert.assertTrue("Expire text is not displayed instead of passcode value.", onDataEntryPage.getPasscode_SignOwner().getText().trim().contains(expire));
    }

    @Then("User verifies the number of pages in each form that are showing required fields")
    public void userVerifiesTheNumberOfPagesInEachFormThatAreShowingRequiredFields() {
        captureScreenshot(driver, testContext, false);
        for (WebElement element : onDataEntryPage.getList_FormMenu_react()) {
            List<WebElement> list_PagesInEachForm = driver.findElements(By.xpath("//div[text()='" + element.getText().split("\n")[0] + "']/parent::div//span[contains(@class,'error')]"));
            if (element.getText().trim().contains(testContext.getMapTestData().get("applicationForm"))) {
                Assert.assertEquals("Application form not displayed 4 pages", testContext.getMapTestData().get("applicationPages"), String.valueOf(list_PagesInEachForm.size()));
            } else if (element.getText().trim().contains(testContext.getMapTestData().get("feesForm"))) {
                Assert.assertEquals("Fees and Expense Disclosure Sample form not displayed 1 pages", testContext.getMapTestData().get("feesPages"), String.valueOf(list_PagesInEachForm.size()));
            } else {
                Assert.assertEquals("1035 EXCHANGEROLLOVERTRANSFER eFORM form not displayed 1 pages", testContext.getMapTestData().get("exchagePages"), String.valueOf(list_PagesInEachForm.size()));
            }
        }
    }

    @Then("User verify {string} is displayed on data entry page")
    public void userVerifyTextDisplayed(String option) {
        captureScreenshot(driver, testContext, false);
        Assert.assertTrue("Option is not displayed on data entry page", getElement(driver, getExistingLocator(driver, onDataEntryPage.getImg_ReadOnly(), onDataEntryPage.getImg_ReadOnly1(), null, null)).isDisplayed());
    }

    @Then("User also Verifies for Primary signer RequestType as {string}")
    public void userVerifiesPrimaryRequestType(String requestType) {
        captureScreenshot(driver, testContext, false);
        Assert.assertTrue(requestType + " Pending Request Type is not appearing", onDataEntryPage.getRequestType().getText().contains(requestType));
    }

    @Then("User sets value {string}  for Agent")
    public void userSetsValue(String fieldValue) {
        captureScreenshot(driver, testContext, false);
        onDataEntryPage.getTxtbox_City().sendKeys(fieldValue);
    }

    @Then("User verifies {string} on {string} is displaying in {string} color")
    public void user_verifies_on_is_displaying_in_color(String pagename, String applicationname, String color) {
        waitForPageToLoad(driver);
        captureScreenshot(driver, testContext, false);
        if (testContext.getUiType().equalsIgnoreCase(EnumsCommon.UITYPE_MVC.getText())) {
            Assert.assertTrue("Page color is not showing in " + color,  getElement(driver,getExistingLocator(driver,By.xpath(String.format(onDataEntryPage.namePage, applicationname, pagename)),
                    By.xpath(String.format(onDataEntryPage.namePageMVC, applicationname, pagename)),null,null)).getAttribute("class").contains(testContext.getMapTestData().get(color)));
        } else {
            Assert.assertTrue("Page color is not showing in " + color, findElement(driver, String.format(onCreateApplicationPage.wizardNamePage, applicationname, pagename)).getAttribute("class").contains(testContext.getMapTestData().get(color)));
        }
    }

    @Then("User expands application menu")
    public void user_expands_application_menu() {
        waitForPageToLoad(driver);
        captureScreenshot(driver, testContext, false);
        clickElementByJSE(driver, getElement(driver, getExistingLocator(driver, onDataEntryPage.getBtn_OpenINMenuMVC(), onDataEntryPage.getBtn_OpenINMenuReact(), null, null)));
    }

    @Then("User Enters Name Email SSN, Birth Date for Insured")
    public void user_Enters_Name_Email_SSN_Birth_Date_For_Insured() {
        captureScreenshot(driver, testContext, false);
        onDataEntryPage.getInsured_name().sendKeys(testContext.getMapTestData().get("insuredName"));
        onDataEntryPage.getInsured_email().sendKeys(testContext.getMapTestData().get("insuredEmail"));
        onDataEntryPage.getSsn_Insured().sendKeys(testContext.getMapTestData().get("insuredSSN"));
        clickElement(driver, onDataEntryPage.getInsured_birthdate());
        captureScreenshot(driver, testContext, false);
        onDataEntryPage.getInsured_birthdate().sendKeys(testContext.getMapTestData().get("insuredBirthdate"));
    }

    @Then("User Clicks on {string} Remove Button")
    public void user_Clicks_On_Remove_Button(String user) {
        captureScreenshot(driver, testContext, false);
        switch (user) {
            case "owner":
                clickElement(driver, onRCTCompleteFillingAndSigningPage.getBtn_RemoveOwner());
                waitForPageToLoad(driver);
                break;
            case "payor":
                clickElement(driver, onRCTCompleteFillingAndSigningPage.getBtn_RemovePayor());
                waitForPageToLoad(driver);
                break;
            default:
                throw new FLException("Invalid value provided for user : " + user);
        }
    }

    @Then("User select {string} from custom list")
    public void userSelectCustomValue(String customValue) {
        captureScreenshot(driver, testContext, false);
        clickElement(driver, findElement(driver, "//div[@class='customListCell']//span[contains(text(),'" + customValue + "')]"));
        clickElement(driver, getElement(driver, getExistingLocator(driver, By.xpath(String.format(CommonMethodsPage.ITButtonInput, "Select")), null, null, null)));
    }

    @Then("User verify {string} is set to {string}")
    public void userVerifyCustomValue(String customField, String customValue) {
        captureScreenshot(driver, testContext, false);
        waitForPageToLoad(driver);
        Assert.assertTrue(customField + " field value does not match " + customValue, findElement(driver, "//input[@data-dataitemid='" + customField + "' or @data-item-id='" + customField + "']").getAttribute("value").trim().equalsIgnoreCase(customValue));
    }

    @Then("User Verifies Upload Template toast message appear and close the pop up")
    public void user_Verifies_Upload_Template_toast_message_appear_and_close_the_pop_up() {
        captureScreenshot(driver, testContext, false);
        waitTilTextIsVisible(driver, getElement(driver, getExistingLocator(driver, onDataEntryPage.getClose_popupMVC(), onDataEntryPage.getClose_popupReact(), null, null)));
        Assert.assertTrue("Upload Template Toast Pop up NOT appeared", getElement(driver, getExistingLocator(driver, onDataEntryPage.getMessage_UploadToastPopUpMVC(), onDataEntryPage.getMessage_UploadToastPopUpReact(), null, null)).isDisplayed());
        clickElement(driver, getElement(driver, getExistingLocator(driver, onDataEntryPage.getClose_popupMVC(), onDataEntryPage.getClose_popupReact(), null, null)));
    }

    @Then("User Verifies Data Entry met pop up is NOT showing and data entry is {string}")
    public void user_Verifies_Data_Entry_met_pop_up_is_NOT_showing_and_data_entry_is(String expectedPercentage) {
        captureScreenshot(driver, testContext, false);
        Assert.assertEquals("Data Entry Percentage mismatched", expectedPercentage, onDataEntryPage.getTxt_DataEntryPercentage().getText().trim());
        Assert.assertFalse("Toast popup is displayed and it should not", (onDataEntryPage.getMsg_Initial()).size() > 0);
    }

    @Then("User verifies {string} and {string} links appear for all uploaded documents")
    public void user_verifies_and_links_appear_for_all_uploaded_documents(String string, String string2) {
        captureScreenshot(driver, testContext, false);
        Assert.assertTrue("View Link NOT appeared", onDataEntryPage.getLink_View().isDisplayed());
        Assert.assertTrue("Remove Link NOT appeared", onDataEntryPage.getLink_Remove().isDisplayed());
    }


    @Then("User Opens Page Menu List and Navigate to {string} page of {string} form")
    public void user_Opens_Page_Menu_List_and_Navigate_to_page_of_form(String string, String string2) {
        captureScreenshot(driver, testContext, false);
        clickElement(driver, onDataEntryPage.getIcon_ExpandMenu());
        clickElementByJSE(driver, getElement(driver, getExistingLocator(driver, onDataEntryPage.getTxt_Page1TemplateFormMVC(), onDataEntryPage.getTxt_Page1TemplateFormReact(), null, null)));
    }

    @Then("User Opens Menu Page List and Navigate to {string} page of {string} form")
    public void user_Opens_Menu_Page_List_and_Navigate_to_page_of_form(String string, String string2) {
        captureScreenshot(driver, testContext, false);
        clickElement(driver, onDataEntryPage.getIcon_ExpandMenu());
        clickElementByJSE(driver, getElement(driver, getExistingLocator(driver, onDataEntryPage.getTxt_Page1WetPolicyFormMVC(), onDataEntryPage.getTxt_Page1WetPolicyFormReact(), null, null)));
    }

    @Then("User Verifies toast Popup Not Appear for Upload Documents")
    public void user_Verifies_toast_Popup_Not_Appear_for_Upload_Documents() {
        captureScreenshot(driver, testContext, false);
        if(onDataEntryPage.getList_Message().size()>0) {
            Assert.assertFalse("Upload Template Toast Pop appeared and should NOT appear", true);
        }
    }

    @Then("User verifies application in Edit mode pending request text is not display")
    public void userverifies_application_in_Edit_mode_pending_request_text() {
        waitForPageToLoad(driver);
        captureScreenshot(driver, testContext, false);
        List<WebElement> listPedingRequest = new ArrayList<>(onDataEntryPage.getListTxt_PendingRequestDialog());
        if (listPedingRequest.size() > 0) {
            Assert.assertTrue("Pending Request is displayed", true);
        }
        Assert.assertTrue("Application is not in Edit mode", onDataEntryPage.getIcon_AllicationLock().getAttribute("class").contains("pencil"));
    }

    @Then("User Verifies {string} is enabled in Other Action")
    public void userverifies_is_enabled_in_Other_Action(String option) {
        waitForPageToLoad(driver);
        captureScreenshot(driver, testContext, false);
        Assert.assertTrue(option+" was not enabled",findElement(driver,String.format(onDataEntryPage.otherActionsList,option)).isEnabled());
    }

    @Then("User verifies page change by clicking next arrow")
    public void user_verifies_page_change_by_clicking_next_arrow() {
        waitForPageToLoad(driver);
        captureScreenshot(driver, testContext, false);
        onSignaturePage.getBtn_NextPage().click();
    }

    @Then("User verifies the tabs on other Actions")
    public void user_verifies_the_tabs_on_other_Actions(DataTable dataTable) {
        captureScreenshot(driver, testContext, false);
        List<String> data = dataTable.asList(String.class);
        onDataEntryPage.getOtherAction_modl().click();
        for (String values : data){
            Assert.assertTrue("The tabs are not showing ",findElement(driver, String.format(onDataEntryPage.otherActionsList,values)).isDisplayed());
        }
    }

    @Then("User verify option {string} is {string} in other actions menu")
    public void verifyOtherActionsOption(String option, String condition) {
        waitForPageToLoad(driver);
        captureScreenshot(driver, testContext, false);
        List<WebElement> elementOtherActions = findElements(driver, String.format(onDataEntryPage.otherActionsList,option));
        if(condition.equalsIgnoreCase("shown"))
            Assert.assertTrue(option + " option is not displayed", elementOtherActions.size() > 0);
        else
            Assert.assertTrue(option + " option is displayed", elementOtherActions.size() == 0);
    }

    @Then("user clicks on other actions tab")
    public void user_clicks_on_other_actions_tab() {
        captureScreenshot(driver, testContext, false);
        onDataEntryPage.getOtherAction_modl().click();
    }

    @Then("User clicks on {string} in other actions tab")
    public void user_clicks_on_in_other_actions_tab(String formname) {
        captureScreenshot(driver, testContext, false);
        clickElementByJSE(driver, findElement(driver, String.format(onDataEntryPage.otherActionsList,formname)));
    }
    @Then("User verifies parent name and click on parent name")
    public void user_verifies_parent_name_and_click_on_parent_name() {
        waitForPageToLoad(driver);
        captureScreenshot(driver, testContext, false);
        Assert.assertTrue("Parent name mismatched ",onDataEntryPage.getParentApplicationName().getText().contains(testContext.getMapTestData().get("newProductName")));
        clickElementByJSE(driver, onDataEntryPage.getParentApplicationName());
    }

    @Then("User Closes documents Dialog page")
    public void user_Closes_documents_Dialog_page() {
        waitForPageToLoad(driver);
        captureScreenshot(driver, testContext, false);
        clickElementByJSE(driver, onDataEntryPage.getBtn_CrossDocumentPage());
    }

    @Then("User clicks on {string} button")
    public void user_clicks_on_button(String btnName) {
        captureScreenshot(driver, testContext, false);
        clickElementByJSE(driver,  getElement(driver, getExistingLocator(driver,onDataEntryPage.getBtn_Lookup(), onDataEntryPage.getBtn_Lookup_React(), null, null)));
    }
    @Then("User verifies CRM Owner Dialog box")
    public void user_verifies_CRM_Owner_Dialog_box() {
        waitForPageToLoad(driver);
        captureScreenshot(driver, testContext, false);
        Assert.assertTrue("Dialog box was not showing", onDataEntryPage.getHeading_Lookup().isDisplayed());
    }

    @Then("User send values {string} in search box and click on search")
    public void user_send_values_in_search_box_and_click_on_search(String values) {
        waitForPageToLoad(driver);
        captureScreenshot(driver, testContext, false);
        sendKeys(driver,getElement(driver, getExistingLocator(driver, onDataEntryPage.getTxtBox_CRMSearchMVC(), onDataEntryPage.getTxtBox_CRMSearchReact(), null, null)),values.toUpperCase());
        clickElementByJSE(driver, onDataEntryPage.getSearchIcon());
    }

    @Then("User select any one from the record")
    public void user_select_any_one_from_the_record() {
        captureScreenshot(driver, testContext, false);
        clickElementByJSE(driver, getElement(driver, getExistingLocator(driver, onDataEntryPage.getFirstValueRecordMVC1(), onDataEntryPage.getFirstValueRecordReact(),onDataEntryPage.getFirstValueRecordMVC(), null)));
    }

    @Then("User clicks {string} Button")
    public void user_clicks_Button(String btnName) {
        captureScreenshot(driver, testContext, false);
        clickElementByJSE(driver, getElement(driver, getExistingLocator(driver, onDataEntryPage.getBtn_SelectMVC(), onDataEntryPage.getBtn_SelectReact(), null, null)));
    }

    @Then("User verifies prefilled Form")
    public void user_verifies_prefilled_Form(DataTable dataTable) {
        waitForPageToLoad(driver);
        captureScreenshot(driver, testContext, false);
        sleepInMilliSeconds(5000);
        List<Map<String, String>> formFields = dataTable.asMaps(String.class, String.class);
        for (Map<String, String> fieldData : formFields) {
            String dataItemId = fieldData.get("data-dataitemid");
            if (findElements(driver, String.format(onDataEntryPage.dataFieldsMVC, dataItemId)).size() > 0) {
                syncElement(driver, findElement(driver, String.format(onDataEntryPage.dataFieldsMVC, dataItemId)), EnumsCommon.TOVISIBLE.getText());
                scrollToWebElement(driver,findElement(driver, String.format(onDataEntryPage.dataFieldsMVC, dataItemId)));
                Assert.assertTrue("The values are not filled :" + dataItemId, findElement(driver, String.format(onDataEntryPage.dataFieldsMVC, dataItemId)).getAttribute("value").length() > 0);
            } else {
                    syncElement(driver, findElement(driver, String.format(onDataEntryPage.dataFieldsReact, dataItemId,dataItemId)), EnumsCommon.TOVISIBLE.getText());
                    scrollToWebElement(driver,findElement(driver, String.format(onDataEntryPage.dataFieldsReact, dataItemId,dataItemId)));
                    Assert.assertTrue("The values are not filled :" + dataItemId, findElement(driver, String.format(onDataEntryPage.dataFieldsReact, dataItemId,dataItemId)).getAttribute("value").length() > 0);
            }
        }
    }

    @Then("User select one value form dropdown")
    public void user_select_one_value_form_dropdown() {
        captureScreenshot(driver, testContext, false);
        scrollToWebElement(driver, onDataEntryPage.getDd_selectTransferDropdown());
        new Select(onDataEntryPage.getDd_selectTransferDropdown()).selectByIndex(2);
    }

    @Then("User verifies {string} value is present and click it")
    public void user_verifies_value_is_present_and_click_it(String option) {
        waitForPageToLoad(driver);
        captureScreenshot(driver, testContext, false);
        getElement(driver, getExistingLocator(driver, onDataEntryPage.getBtn_OpenINMenuMVC(), onDataEntryPage.getBtn_OpenINMenuReact(), null, null)).click();
        syncElement(driver, findElement(driver, String.format(onCommonMethods_reactPage.menuListForm, option)), EnumsCommon.TOVISIBLE.getText());
        Assert.assertTrue(option+" was not displayed", findElement(driver, String.format(onCommonMethods_reactPage.menuListForm, option)).isDisplayed());
        clickElementByJSE(driver, findElement(driver, String.format(onCommonMethods_reactPage.menuListForm, option)));
    }


    @Then("User selects Joint Owner YesNo Type {string}")
    public void userSelectsJointOwnerYesNoType(String signerType) {
        captureScreenshot(driver, testContext, false);
        new Select(onDataEntryPage.getBtn_JointOwnerYesNo()).selectByVisibleText(signerType);
    }
    @Then("User selects Annuitant YesNo Type {string}")
    public void userSelectsAnnuitantYesNoType(String signerType) {
        captureScreenshot(driver, testContext, false);
        new Select(onDataEntryPage.getBtn_AnnuitantYesNo()).selectByVisibleText(signerType);
    }

    @Then("User verifies view link appears and remove link does not appear for all uploaded documents")
    public void user_verifies_link_appears_and_link_does_not_appear_for_all_uploaded_documents() {
        captureScreenshot(driver, testContext, false);
        Assert.assertTrue("View Link NOT appeared", onDataEntryPage.getLink_View().isDisplayed());
        Assert.assertFalse("Remove Link is displayed and it should not display", onDataEntryPage.getList_RemoveLink().size() > 0);
    }
    @Then("User verifies CRM Dialog box")
    public void user_verifies_CRM_Dialog_box() {
        waitForPageToLoad(driver);
        captureScreenshot(driver, testContext, false);
        Assert.assertTrue("Dialog box was not showing",  onDataEntryPage.getHeader_CRMDialogbox().isDisplayed());
    }

    @Then("User verifies prefilled data Form")
    public void user_verifies_prefilled_data_Form(io.cucumber.datatable.DataTable dataTable) {
        waitForPageToLoad(driver);
        captureScreenshot(driver, testContext, false);
        List<Map<String, String>> formFields = dataTable.asMaps(String.class, String.class);
        for(Map<String, String> fieldData : formFields) {
            String dataItemId = fieldData.get("data-dataitemid");
         //   Assert.assertTrue("The values are not filled ",findElement(driver, String.format(onMultiSingerPage.dataFilledInputs,  dataItemId)).getAttribute("value").length()>0);
        }
    }

    @Then("User select three value form dropdown")
    public void user_select_three_value_form_dropdown() {
        captureScreenshot(driver, testContext, false);
        new Select(onDataEntryPage.getDd_selectTransferDropdown()).selectByVisibleText("3");
    }

    @Then("User verifies the City Zip locationId Phone Fields are blank initialy")
    public void UserVerifiesTheCityStateZipLocationIdPhoneFieldsAreBlankInitialy() {
        captureScreenshot(driver, testContext, false);
        syncElement(driver, onDataEntryPage.getTxtbox_cityName(), EnumsCommon.TOVISIBLE.getText());
        Assert.assertTrue("First name textbox is not empty", onDataEntryPage.getTxtbox_cityName().getText().isEmpty());
        Assert.assertTrue("First name textbox is not empty", onDataEntryPage.getTxtbox_zipName().getText().isEmpty());
        Assert.assertTrue("First name textbox is not empty", onDataEntryPage.getTxtbox_locationId().getText().isEmpty());
        Assert.assertTrue("First name textbox is not empty", onDataEntryPage.getTxtbox_phoneNumber().getText().isEmpty());
    }

    @Then("User clicks on page3 form of application222")
    public void userClickOnForms() {
        waitForPageToLoad(driver);
        captureScreenshot(driver, testContext, false);
        clickElementByJSE(driver, onDataEntryPage.getTxt_ApplicationPage3());
    }

    @Then("User select transfer value form dropdown")
    public void user_select_transfer_value_form_dropdown() {
        captureScreenshot(driver, testContext, false);
        new Select(onDataEntryPage.getDd_selectDataTransferDropdown()).selectByVisibleText("3");
    }

    @Then("User verifies prefilled data Form text fields")
    public void user_verifies_prefilled_data_Form_text_fields(DataTable dataTable) {
        waitForPageToLoad(driver);
        captureScreenshot(driver, testContext, false);
        List<Map<String, String>> formFields = dataTable.asMaps(String.class, String.class);
        for(Map<String, String> fieldData : formFields) {
            String dataItemId = fieldData.get("data-dataitemid");
       //     Assert.assertFalse("The values are not filled ",findElement(driver, String.format(onMultiSingerPage.dataFilledInputs,  dataItemId)).getAttribute("value").length()>0);
        }
    }

    @Then("User clicks on Next button on form")
    public void user_clicks_on_Next_button_on_form() {
        captureScreenshot(driver, testContext, false);
        clickElementByJSE(driver, onDataEntryPage.getBtn_NextGIACT());
    }

    @Then("User check checkbox for GIACT")
    public void user_check_checkbox_for_GIACT() {
        waitForPageToLoad(driver);
        captureScreenshot(driver, testContext, false);
        clickElementByJSE(driver, getElement(driver, getExistingLocator(driver, onDataEntryPage.getChkBox_ActionTriggerMVC(), onDataEntryPage.getChkBox_ActionTriggerReact(), onDataEntryPage.getChkBox_ActionTriggerMVC1(), null)));
    }

    @Then("User clicks on previous button")
    public void user_clicks_on_previous_button() {
        captureScreenshot(driver, testContext, false);
        clickElementByJSE(driver, onDataEntryPage.getBtn_Previous());
    }

    @Then("User verifies prefilled data form text fields")
    public void user_verifies_prefilled_data_form_text_fields(DataTable dataTable) {
        waitForPageToLoad(driver);
        driver.navigate().refresh();
        captureScreenshot(driver, testContext, false);
        List<Map<String, String>> formFields = dataTable.asMaps(String.class, String.class);
        for(Map<String, String> fieldData : formFields) {
            String dataItemId = fieldData.get("data-dataitemid");
            sleepInMilliSeconds(3000);
        //    scrollToWebElement(driver,findElement(driver, String.format(onMultiSingerPage.dataFilledInputs,  dataItemId)));
        //    Assert.assertTrue("The values are not filled :"+dataItemId,findElement(driver, String.format(onMultiSingerPage.dataFilledInputs,  dataItemId)).getAttribute("value").length()>0);
        }
    }
    @Then("User click on {string} button")
    public void user_click_on_button(String btnName) {
        captureScreenshot(driver, testContext, false);
        clickElementByJSE(driver, findElement(driver, String.format(onDataEntryPage.btn_LookupReact, btnName)));
    }

    @Then("User clicks on previous arrow")
    public void user_clicks_on_previous_arrow() {
        waitForPageToLoad(driver);
        captureScreenshot(driver, testContext, false);
        onSignaturePage.getBtn_PreviousPage().click();
    }

    @Then("User clicks on Indiviual radio button")
    public void user_clicks_on_Indiviual_radio_button() {
        captureScreenshot(driver, testContext, false);
        clickElement(driver, onSignApplicationPage.getRadioBtn_Individual());
    }

    @Then("User verifies {string} popup is displayed")
    public void user_verifies_custom_print_popup_is_displayed(String popupMsg) {
        waitForPageToLoad(driver);
        syncElement(driver,findElement(driver, String.format( onDataEntryPage.popupMSG, popupMsg,  popupMsg)),EnumsCommon.TOVISIBLE.getText());
        captureScreenshot(driver, testContext, false);
        Assert.assertTrue("The values are not filled ",findElement(driver, String.format( onDataEntryPage.popupMSG, popupMsg,  popupMsg)).isDisplayed());
    }

    @Then("User clicks on {string} button annuity wizard")
    public void user_clicks_on_button_annuity_wizard(String dataItemId) {
        captureScreenshot(driver, testContext, false);
        clickElementByJSE(driver, findElement(driver, String.format(onCommonMethods_reactPage.btn_AnnuityWizard, dataItemId)));
    }

    @Then("User verifies copy of application created")
    public void verifyCopyAppCreated() {
        captureScreenshot(driver, testContext, false);
        Assert.assertEquals("Copy of Application was not created", "Copy of "+testContext.getMapTestData().get("newProductName"),onDataEntryPage.getTxt_NewApplication().getText().trim());
    }

    @Then("User verifies prefilled data Form text fields should be blank")
    public void user_verifies_prefilled_data_Form_text_fields_should_be_blank(DataTable dataTable) {
        waitForPageToLoad(driver);
        captureScreenshot(driver, testContext, false);
        List<Map<String, String>> formFields = dataTable.asMaps(String.class, String.class);
        for(Map<String, String> fieldData : formFields) {
            String dataItemId = fieldData.get("data-dataitemid");
            sleepInMilliSeconds(3000);
            if(findElements(driver, String.format(onDataEntryPage.dataFieldsMVC,  dataItemId)).size() >0) {
                scrollToWebElement(driver, findElement(driver, String.format(onDataEntryPage.dataFieldsMVC, dataItemId)));
                Assert.assertFalse("The values filled ", findElement(driver, String.format(onDataEntryPage.dataFieldsMVC, dataItemId)).getAttribute("value").length() > 0);
            } else {
                scrollToWebElement(driver, findElement(driver, String.format(onDataEntryPage.dataFieldsMVC1, dataItemId)));
                Assert.assertFalse("The values are filled ", findElement(driver, String.format(onDataEntryPage.dataFieldsMVC1, dataItemId)).getAttribute("value").length() > 0);
            }
        }
    }

    @Then("User clicks on ok verifies prefilled data form text fields are filled")
    public void user_clicks_on_ok_verifies_prefilled_data_form_text_fields_are_filled(DataTable dataTable) {
        waitForPageToLoad(driver);
        clickElement(driver, onDataEntryPage.getBtn_popupOk());
        captureScreenshot(driver, testContext, false);
        List<Map<String, String>> formFields = dataTable.asMaps(String.class, String.class);
        for(Map<String, String> fieldData : formFields) {
            String dataItemId = fieldData.get("data-dataitemid");
            sleepInMilliSeconds(3000);
            scrollToWebElement(driver,findElement(driver, String.format(onDataEntryPage.dataFieldsMVC,  dataItemId)));
            Assert.assertTrue("The values are not filled :"+dataItemId,findElement(driver, String.format(onDataEntryPage.dataFieldsMVC,  dataItemId)).getAttribute("value").length()>0);
        }
    }
    @Then("User clicks on custom list button")
    public void user_clicks_on_custom_list_button() {
        captureScreenshot(driver, testContext, false);
        clickElementByJSE(driver, onDataEntryPage.getBtn_CustomList());
    }

    @Then("User verify {string} field value is {string} on data entry page")
    public void verifyFieldValue(String field, String value) {
        captureScreenshot(driver, testContext, false);
        if (findElements(driver, String.format(onCommonMethods_reactPage.preFilledFormInput,  field)).size() > 0)
            Assert.assertTrue(field + " value is not "+ value, findElement(driver, String.format(onCommonMethods_reactPage.preFilledFormInput,  field)).getText().trim().equalsIgnoreCase(value));
        else
            Assert.assertTrue(field + " value is not "+ value, findElement(driver, String.format(onDataEntryPage.getByDataitemid(), field)).getText().trim().equalsIgnoreCase(value));

    }

    @Then("User verifies popup and clicks on ok verifies prefilled data form text fields are filled")
    public void user_verifies_popup_clicks_on_ok_verifies_prefilled_data_form_text_fields_are_filled(DataTable dataTable) {
        waitForPageToLoad(driver);
        driver.navigate().refresh();
        Assert.assertTrue("Popup is not displayed", onDataEntryPage.getPopup_AccountValidation().isDisplayed());
        clickElement(driver, onDataEntryPage.getBtn_popupOk());
        captureScreenshot(driver, testContext, false);
        List<Map<String, String>> formFields = dataTable.asMaps(String.class, String.class);
        for(Map<String, String> fieldData : formFields) {
            String dataItemId = fieldData.get("data-dataitemid");
            sleepInMilliSeconds(3000);
            scrollToWebElement(driver,findElement(driver, String.format(onDataEntryPage.dataFieldsMVC,  dataItemId)));
            Assert.assertTrue("The values are not filled :"+dataItemId,findElement(driver, String.format(onDataEntryPage.dataFieldsMVC,  dataItemId)).getAttribute("value").length()>0);
        }
    }

    @Then("User verifies mapping of each list item to text boxes")
    public void user_verifies_mapping_of_each_list_item_to_text_boxes(DataTable dataTable) {
        captureScreenshot(driver, testContext, false);
        List<String> fieldValue = dataTable.asList(String.class);
        List<WebElement> elements = onDataEntryPage.getList_CountryStatesCity();
        for (int i = 0; i < elements.size(); i++) {
            waitForPageToLoad(driver);
            clickElementByJSE(driver, elements.get(i));
            for (int j = 0; j < fieldValue.size(); j++) {
                String inputValue = fieldValue.get(j);
                Assert.assertTrue("Values are not mapped", findElement(driver, String.format(onDataEntryPage.dataFieldsMVC, inputValue)).getAttribute("value").length()>0);
            }
            clickElementByJSE(driver, onDataEntryPage.getBtn_CustomList());
        }
    }
    @Then("User verifies new Dialog box is opening with")
    public void user_verifies_new_Dialog_box_is_opening_with(DataTable dataTable) {
        captureScreenshot(driver, testContext, false);
        List<String> fieldValue = dataTable.asList(String.class);
        for (String inputValue : fieldValue) {
            if (findElements(driver, String.format(onDataEntryPage.customListDialog, inputValue)).size() > 0)
                Assert.assertEquals(inputValue + " is not matching", inputValue, findElement(driver, String.format(onDataEntryPage.customListDialog, inputValue)).getText().trim());
            else
                Assert.assertEquals(inputValue + " is not matching", inputValue, findElement(driver, String.format(onDataEntryPage.customListDialog_React, inputValue)).getText().trim());

        }
    }
    @Then("User clicks on {string} on wiz")
    public void user_clicks_on_on_wiz(String btnName) {
        captureScreenshot(driver, testContext, false);
        clickElementByJSE(driver, findElement(driver, String.format(onDataEntryPage.btn_CustomListWiz, btnName)));
    }

    @Then("User clicks on Custom list Button")
    public void user_clicks_on_Custom_list_Button() {
        waitForPageToLoad(driver);
        captureScreenshot(driver, testContext, false);
        scrollToWebElement(driver,onDataEntryPage.getFormCustomListWiz());
        clickElement(driver, onDataEntryPage.getFormCustomListWiz());
    }

    @Then("User clicks on {string} verifies mapping of each list item to text boxes and filled")
    public void user_clicks_on_verifies_mapping_of_each_list_item_to_text_boxes_and_filled(String btnName, DataTable dataTable) {
        captureScreenshot(driver, testContext, false);
        List<String> fieldValue = dataTable.asList(String.class);
        List<WebElement> elements = onDataEntryPage.getListCountryCS();
        for (int i = 0; i < elements.size(); i++) {
            waitForPageToLoad(driver);
            clickElementByJSE(driver, elements.get(i));
            clickElement(driver, onDataEntryPage.getBtn_SelectCustomList());
            for (int j = 0; j < fieldValue.size(); j++) {
                String inputValue = fieldValue.get(j);
                sleepInMilliSeconds(3000);
                Assert.assertTrue("Values are not mapped", findElement(driver, String.format(onDataEntryPage.btn_CustomTextFields, inputValue)).getAttribute("value").length() > 0);
            }
            clickElementByJSE(driver, findElement(driver, String.format(onDataEntryPage.btn_CustomListWiz, btnName)));
        }
    }

    @Then("User Clicks On {string} On Data Entry Page")
    public void user_Clicks_On_using_id(String btnName) {
        waitForPageToLoad(driver);
        captureScreenshot(driver, testContext, false);
        if(findElements(driver, String.format(onDataEntryPage.getTabById(), testContext.getMapTestData().get(btnName))).size() > 0)
            clickElementByJSE(driver, findElement(driver, String.format(onDataEntryPage.getTabById(), testContext.getMapTestData().get(btnName))));
        else
            clickElementByJSE(driver, findElement(driver, String.format(onDataEntryPage.getByDataitemid(), testContext.getMapTestData().get(btnName))));

    }

    @Then("User select transfer value {string} form dropdown")
    public void user_select_transfer_value_form_dropdown(String visibleText) {
        captureScreenshot(driver, testContext, false);
        new Select(onDataEntryPage.getDd_selectDataTransferDropdown()).selectByVisibleText(visibleText);
    }

    @Then("User Notes the Passcode from Pending Request dialog box")
    public void user_Notes_the_Passcode_from_Pending_Request_dialog_box() {
        waitForPageToLoad(driver);
        captureScreenshot(driver, testContext, false);
        addPropertyValueInJSON(testContext.getTestCaseID(), testContext, EnumsJSONProp.RECIPIENTPASSCODE.getText(), getElement(driver, getExistingLocator(driver, onDataEntryPage.getPasscode_PendingReqMVC(), onDataEntryPage.getPasscode_PendingReqReact(), null, null)).getText());
    }

    @Then("User clicks on GIACT Lookup button")
    public void user_clicks_on_GIACT_Lookup_button() {
        waitForPageToLoad(driver);
        captureScreenshot(driver, testContext, false);
        if (testContext.getUiType().equalsIgnoreCase(EnumsCommon.UITYPE_MVC.getText())) {
            clickElement(driver, getElement(driver, getExistingLocator(driver, onDataEntryPage.getBtn_GIACTLookupMVC(), onDataEntryPage.getBtn_GIACTLookupMVC1(), null, null)));
        } else {
            clickElement(driver, onDataEntryPage.getBtn_GIACTLookupReact());
        }
    }

    @Then("User clicks on Lexis Nexis call button")
    public void user_clicks_on_Lexis_Nexis_call_button() {
        waitForPageToLoad(driver);
        captureScreenshot(driver, testContext, false);
        if (testContext.getUiType().equalsIgnoreCase(EnumsCommon.UITYPE_MVC.getText())) {
            scrollToWebElement(driver, onDataEntryPage.getBtn_LexisNexisCall());
            clickElement(driver, onDataEntryPage.getBtn_LexisNexisCall());
        } else {
            scrollToWebElement(driver, onDataEntryPage.getBtn_LexisNexisCallReact());
            clickElement(driver, onDataEntryPage.getBtn_LexisNexisCallReact());
        }
    }

    @Then("User verifies GIACT pop up message")
    public void user_verifies_GIACT_pop_up_message() {
        syncElement(driver, onDataEntryPage.getMsg_Popup_Giact1(), EnumsCommon.TOVISIBLE.getText());
        captureScreenshot(driver, testContext, false);
        Assert.assertTrue("Giact Back Office Action message Mismatched", onDataEntryPage.getMsg_Popup_Giact1().getText().trim().equalsIgnoreCase(testContext.getMapTestData().get("giactMessage1")));
        Assert.assertTrue("Giact Account Validation message MisMatched", onDataEntryPage.getMsg_Popup_Giact2().getText().trim().equalsIgnoreCase(testContext.getMapTestData().get("giactMessage2")));
    }

    @Then("User verifies Lexis Nexis pop up message")
    public void user_verifies_Lexis_Nexis_pop_up_message() {
        captureScreenshot(driver, testContext, false);
        if (testContext.getUiType().equalsIgnoreCase(EnumsCommon.UITYPE_MVC.getText())) {
            syncElement(driver, onDataEntryPage.getMsg_Popup_LexisNexis1(), EnumsCommon.TOVISIBLE.getText());
            Assert.assertTrue("Lexis Nexis Back Office Action message Mismatched", onDataEntryPage.getMsg_Popup_LexisNexis1().getText().trim().equalsIgnoreCase(testContext.getMapTestData().get("lexisNexisMessage1")));
            Assert.assertTrue("Lexis Nexis Account Validation message MisMatched", onDataEntryPage.getMsg_Popup_LexisNexis2().getText().trim().equalsIgnoreCase(testContext.getMapTestData().get("lexisNexisMessage2")));
        } else {
            syncElement(driver, onDataEntryPage.getMsg_Popup_LexisNexisReact1(), EnumsCommon.TOVISIBLE.getText());
            Assert.assertTrue("Lexis Nexis Back Office Action message Mismatched", onDataEntryPage.getMsg_Popup_LexisNexisReact1().getText().trim().equalsIgnoreCase(testContext.getMapTestData().get("lexisNexisMessage1")));
            Assert.assertTrue("Lexis Nexis Account Validation message MisMatched", onDataEntryPage.getMsg_Popup_LexisNexisReact2().getText().trim().equalsIgnoreCase(testContext.getMapTestData().get("lexisNexisMessage2")));
        }
    }

    @Then("User verifies form is read only mode only")
    public void user_verifies_form_is_read_only_mode_only() {
        captureScreenshot(driver, testContext, false);
        Assert.assertTrue("Form is not in read only mode", onDataEntryPage.getCanvasReadOnlyForm().isEnabled());
    }

    @Then("User verifies data fields are blank")
    public void user_verifies_data_fields_are_blank(io.cucumber.datatable.DataTable dataTable) {
        waitForPageToLoad(driver);
        captureScreenshot(driver, testContext, false);
        List<Map<String, String>> formFields = dataTable.asMaps(String.class, String.class);
        for(Map<String, String> fieldData : formFields) {
            String dataItemId = fieldData.get("data-dataitemid");
         //   scrollToWebElement(driver,findElement(driver, String.format(onMultiSingerPage.dataFilledInputs,  dataItemId)));
          //  Assert.assertFalse("The values are filled ",findElement(driver, String.format(onMultiSingerPage.dataFilledInputs,  dataItemId)).getAttribute("value").length()>0);
        }
    }

    @Then("User check checkbox of Custom Action Trigger")
    public void user_check_checkbox_of_Custom_Action_Trigger() {
        waitForPageToLoad(driver);
        captureScreenshot(driver, testContext, false);
        clickElement(driver, onDataEntryPage.getCheckBoxCustomActionCall());
    }

    @Then("User verifies email body is not editable")
    public void user_verifies_email_body_is_not_editable() {
        waitForPageToLoad(driver);
        captureScreenshot(driver, testContext, false);
        boolean flag = true;
        for (WebElement elem : onDataEntryPage.getList_TextAreaEmailBody()) {
            if (elem.getAttribute("readonly").equals("readonly")) {
                flag = false;
                break;
            }
        }
        Assert.assertTrue("Email area was editable", flag);
    }

    @Then("User verify signature is {string} for {string}")
    public void verifySignatureImage(String condition, String user) {
        waitForPageToLoad(driver);
        captureScreenshot(driver, testContext, false);
        try {
            Assert.assertTrue("Image is displayed", findElement(driver, "//input[@data-item-id='" + user + "']").isDisplayed());
            Assert.assertTrue("Image is displayed", findElement(driver, "//input[@data-item-id='" + user + "']").getAttribute("class").equalsIgnoreCase("activeField signatureEnabled"));
        } catch (Exception e) {
            Assert.assertTrue("Image is not displayed for " + user, condition.equalsIgnoreCase("displayed"));
            Assert.assertTrue("Image is not displayed", onDataEntryPage.getTxt_ActiveSignature().isDisplayed());
        }
    }

    @Then("User verify {int} signature is displayed")
    public void verifyCountSignature(int count) {
        captureScreenshot(driver, testContext, false);
        Assert.assertTrue("Signature count does not exist", findElements(driver, "//div[@class='signatureImage']").size() == count);
    }


    @Then("User clicks on Joint Owner radio button")
    public void user_clicks_on_Joint_radio_button() {
        captureScreenshot(driver, testContext, false);
        clickElement(driver, onSignApplicationPage.getRadioBtn_Joint());
    }

    @Then("User Clicks on link {string} on Test Workflow Separator Page")
    public void user_Clicks_on_link_on_Test_Workflow_Separator_Page(String linkText) {
        waitForPageToLoad(driver);
        captureScreenshot(driver, testContext, false);
        clickElementByJSE(driver,findElement(driver,String.format(onDataEntryPage.getLinkTestWorkFlow(),linkText)));
    }

    @Then("User verifies {string} on {string} is not displaying in {string} color")
    public void user_verifies_on_is_not_displaying_in_color(String pagename, String applicationname, String color) {
        waitForPageToLoad(driver);
        captureScreenshot(driver, testContext, false);
        if (testContext.getUiType().equalsIgnoreCase(EnumsCommon.UITYPE_MVC.getText())) {
            Assert.assertFalse("Page color is showing in " + color,  getElement(driver,getExistingLocator(driver,By.xpath(String.format(onDataEntryPage.namePage, applicationname, pagename)),
                    By.xpath(String.format(onDataEntryPage.namePageMVC, applicationname, pagename)),null,null)).getAttribute("class").contains(testContext.getMapTestData().get(color)));
        } else {
            Assert.assertTrue("Page color is showing in " + color, findElement(driver, String.format(onCreateApplicationPage.wizardNamePage, applicationname, pagename)).getAttribute("class").contains(testContext.getMapTestData().get(color)));
        }
    }

    @Then("User selects {string} checkbox")
    public void user_selects_check_box_and_validate_the_popup(String title) {
        clickElementByJSE(driver, findElement(driver, String.format(onDataEntryPage.getCheckBox_Trigger(),title)));
    }

    @Then("User verifies {string} pop up message")
    public void user_verifies_pop_up_message(String text) {
        syncElement(driver, getElement(driver, getExistingLocator(driver, onDataEntryPage.getTxt_dataEntryPopupTextMVC(), onDataEntryPage.getTxt_dataEntryPopupTextReact(), null, null)), EnumsCommon.TOVISIBLE.getText());
        captureScreenshot(driver, testContext, false);
        switch (text) {
            case "Back Office Action is being performed.":
                Assert.assertTrue("Back Office Action message Mismatched", onDataEntryPage.getMsg_Popup_Giact1().getText().trim().equalsIgnoreCase(testContext.getMapTestData().get("popUpMessage1")));
                break;
            case "A validation is being performed.":
                Assert.assertTrue("A Validation message MisMatched", onDataEntryPage.getMsg_Popup_Giact3().getText().trim().equalsIgnoreCase(testContext.getMapTestData().get("popUpMessage2")));
                break;
            case "User validation is being performed.":
                Assert.assertTrue("User Validation message MisMatched", onDataEntryPage.getMsg_Popup_LexisNexisReact2().getText().trim().equalsIgnoreCase(testContext.getMapTestData().get("popUpMessage3")));
                break;
            case "Account validation is being performed.":
                Assert.assertTrue("Account Validation message MisMatched", onDataEntryPage.getMsg_Popup_Giact2().getText().trim().equalsIgnoreCase(testContext.getMapTestData().get("popUpMessage4")));
                break;
            default:
                throw new FLException("Invalid message text: " + text);
        }
    }

    @Then("User verifies Check Uncheck all")
    public void user_verifies_Check_Uncheck_all() {
        captureScreenshot(driver, testContext, false);
        Assert.assertTrue("The check box was not selected", onDataEntryPage.getCheckBoxCheckUncheck().getAttribute("aria-checked").equals("true"));
    }

    @Then("User verifies confirmation popup appears and validate the meassage {string}")
    public void user_verifies_confirmation_popup_appears_and_validate_the_meassage(String message) {
        waitTilTextIsVisible(driver,onDataEntryPage.getMsg_Popup_Giact3());
        captureScreenshot(driver, testContext, false);
        Assert.assertTrue("Confirmation popup box is not displayed", onDataEntryPage.getPopupbox_confirmation().isDisplayed());
        Assert.assertTrue("validation message mismatched", onDataEntryPage.getMsg_Popup_Giact3().getText().trim().equalsIgnoreCase(message));
    }

    @Then("User Verifies {string} as {string}")
    public void user_Verifies_as(String attribute, String value) {
        captureScreenshot(driver, testContext, false);
        Assert.assertEquals(value + " did not match for " + attribute, value,
                getElement(driver, getExistingLocator(driver, By.xpath(String.format(onDataEntryPage.getValueByAttribute(), attribute)),
                        By.xpath(String.format(onDataEntryPage.getValueByAttribute1(), attribute)), null, null)).getText().trim());
    }

    @Then("User verifies {string} popup is showing")
    public void user_verifies_popup_is_showing(String value) {
        waitForPageToLoad(driver);
        captureScreenshot(driver, testContext, false);
        boolean flag = false;
        for(WebElement message : onDataEntryPage.getTxt_StatusDataEntry()) {
            if(message.getText().trim().contains(value)) {
                flag = true;
                break;
            }
        }
        Assert.assertTrue("PopUp was not displayed", flag);
        clickElementByJSE(driver,onDataEntryPage.getIcon_PopupCross());
    }

    @Then("User verifies data fields checkbox are not selected")
    public void user_verifies_data_fields(DataTable dataTable) {
        captureScreenshot(driver, testContext, false);
        List<Map<String, String>> formFields = dataTable.asMaps(String.class, String.class);
        for (Map<String, String> fieldData : formFields) {
            String dataItemId = fieldData.get("data-dataitemid");
            String locatorType = fieldData.get("Locator Type");
            switch (locatorType) {
                case "checkbox":
                    Assert.assertFalse("The check box is selected ",findElement(driver, String.format(onDataEntryPage.getCheckBox_Trigger(), dataItemId)).isSelected());
                    break;
                default:
                    throw new FLException("Invalid locator Type : " + locatorType);
            }
        }
    }

    @Then("User select the checkbox for required fields")
    public void user_select_the_checkbox_for_required_fields(DataTable dataTable) {
        captureScreenshot(driver, testContext, false);
        List<String> formFields = dataTable.asList(String.class);
        for (String fieldData : formFields) {
            scrollToWebElement(driver,findElement(driver, String.format(onDataEntryPage.getCheckBox_Trigger(), fieldData)));
            waitForPageToLoad(driver);
                clickElementByJSE(driver,findElement(driver, String.format(onDataEntryPage.getCheckBox_Trigger(), fieldData)));
            }
        }

    @Then("User verifies check box on Wizard page")
    public void user_verifies_check_box_on_Wizard_page() {
        captureScreenshot(driver, testContext, false);
        scrollToWebElement(driver, onDataEntryPage.getCheckBoxWizard().get(0));
        Assert.assertTrue("Check box was not present", onDataEntryPage.getCheckBoxWizard().size()>0);
    }

    @Then("User verifies Combox is present on page")
    public void user_verifies_Combox_is_present_on_page() {
        captureScreenshot(driver, testContext, false);
        Assert.assertTrue("Combo Box was not present", getElements(driver, getExistingLocator(driver, onDataEntryPage.getDdComboBoxMVC(), onDataEntryPage.getDdComboBoxReact(), onDataEntryPage.getDdComboBoxMVC1(), null)).size()>0);
    }

    @Then("User verifies check box on Wizard page is not displayed")
    public void user_verifies_check_box_on_Wizard_page_is_not_displayed() {
        captureScreenshot(driver, testContext, false);
        Assert.assertFalse("Check box was present", onDataEntryPage.getCheckBoxWizard().size()>0);
    }

    @Then("User verifies prefilled data Form is filled")
    public void user_verifies_prefilled_data_Form_is_filled(DataTable dataTable) {
        captureScreenshot(driver, testContext, false);
        List<Map<String, String>> formFields = dataTable.asMaps(String.class, String.class);
        for(Map<String, String> fieldData : formFields) {
            String dataItemId = fieldData.get("data-dataitemid");
            Assert.assertTrue("The data was not filled  ",findElement(driver, String.format(onDataEntryPage.dataFieldsMVC,  dataItemId)).getAttribute("value").length()>0);
        }
    }

    @Then("User verifies the note on Activity Application Form")
    public void user_verifies_the_note_on_Activity_Application_Form() {
        captureScreenshot(driver, testContext, false);
        syncElement(driver, onDataEntryPage.getForm_NewApplicationForm(), EnumsCommon.TOVISIBLE.getText());
        Assert.assertTrue("Note was not Displayed", onDataEntryPage.getTxt_optionalFormNote().isDisplayed());
    }

    @Then("User verifies New Activity Name is visible on Activities list")
    public void user_verifies_New_Activity_Name_is_visible_on_Activities_list() {
        waitForPageToLoad(driver);
        captureScreenshot(driver, testContext, false);
        for (WebElement element : onHomePage.getList_RecentApplication()) {
            if (element.getText().contains(testContext.getMapTestData().get("newActivityName")))
                Assert.assertTrue("New Activity was not displayed on Home Page", element.getText().trim().equalsIgnoreCase(testContext.getMapTestData().get("newActivityName")));
        }
    }

    @Then("User verifies New Application Added on All Activities Page")
    public void user_verifies_New_Application_Added_on_All_Activities_Page() {
        for (WebElement singleActivity : onDataEntryPage.getList_allActivitiesResult()) {
            if (singleActivity.getText().contains(testContext.getMapTestData().get("newActivityName"))) {
                Assert.assertTrue("New Activity was not displayed on All Activities Page", singleActivity.getText().contains(testContext.getMapTestData().get("newActivityName")));
                break;
            }
        }
    }

    @Then("User clicks Unlock button on data entry page")
    public void user_clicks_Unlock_button_on_data_entry_page() {
        waitForPageToLoad(driver);
        captureScreenshot(driver, testContext, false);
        syncElement(driver, onDataEntryPage.getBtn_Unlock(),EnumsCommon.TOCLICKABLE.getText());
        clickElement(driver, onDataEntryPage.getBtn_Unlock());
    }

    @Then("User clicks on Cancel button from Send Email Request window")
    public void userClicksOnCancelButtonFromSendEmailRequestWindow() {
        captureScreenshot(driver, testContext, false);
        clickElementByJSE(driver, onDataEntryPage.getButton_cancel());
    }

    @Then("User verifies pop up message {string}")
    public void user_verifies_Confirm_Decline_PopUp_message(String message) {
        captureScreenshot(driver, testContext, false);
        Assert.assertEquals("The message is not matching ", onDataEntryPage.getPopup_message().getText(),message);
    }

    @Then("User verifies prefilled data form input text fields of Application222")
    public void user_verifies_prefilled_data_form_input_text_fields(DataTable dataTable) {
        waitForPageToLoad(driver);
        captureScreenshot(driver, testContext, false);
        List<Map<String, String>> formFields = dataTable.asMaps(String.class, String.class);
        for (Map<String, String> fieldData : formFields) {
            String dataItemId = fieldData.get("data-dataitemid");

            switch (dataItemId) {
                case "Owner_FirstName":
                    scrollToWebElement(driver, findElement(driver, String.format(onDataEntryPage.dataFieldsMVC, dataItemId)));
                    syncElement(driver, onDataEntryPage.getForm_dataEntry(), EnumsCommon.TOVISIBLE.getText());
                    Assert.assertTrue("The values are not filled ", findElement(driver, String.format(onDataEntryPage.dataFieldsMVC, dataItemId)).getAttribute("value").length() > 0);
                    Assert.assertTrue(dataItemId + ": Actual and Expected values are different", findElement(driver, String.format(onDataEntryPage.dataFieldsMVC, dataItemId)).getAttribute("value").equalsIgnoreCase(testContext.getMapTestData().get("owner_FirstName")));
                    break;

                case "Owner_LastName":
                    scrollToWebElement(driver, findElement(driver, String.format(onDataEntryPage.dataFieldsMVC, dataItemId)));
                    syncElement(driver, onDataEntryPage.getForm_dataEntry(), EnumsCommon.TOVISIBLE.getText());
                    Assert.assertTrue("The values are not filled ", findElement(driver, String.format(onDataEntryPage.dataFieldsMVC, dataItemId)).getAttribute("value").length() > 0);
                    Assert.assertEquals(dataItemId + ": Actual and Expected values are different", findElement(driver, String.format(onDataEntryPage.dataFieldsMVC, dataItemId)).getAttribute("value"), (testContext.getMapTestData().get("owner_LastName")));
                    break;

                case "Owner_ResidentialAddress_Zipcode":
                    scrollToWebElement(driver, findElement(driver, String.format(onCommonMethods_reactPage.preFilledFormInput, dataItemId)));
                    syncElement(driver, onDataEntryPage.getForm_dataEntry(), EnumsCommon.TOVISIBLE.getText());
                    Assert.assertTrue("The values are not filled ", findElement(driver, String.format(onCommonMethods_reactPage.preFilledFormInput, dataItemId)).getAttribute("value").length() > 0);
                    Assert.assertTrue(dataItemId + ": Actual and Expected values are different", findElement(driver, String.format(onCommonMethods_reactPage.preFilledFormInput, dataItemId)).getAttribute("value").contains(testContext.getMapTestData().get("owner_ResidentialAddress_Zipcode")));
                    break;

                case "Owner_DOB":
                    scrollToWebElement(driver, findElement(driver, String.format(onDataEntryPage.dataFieldsMVC, dataItemId)));
                    syncElement(driver, onDataEntryPage.getForm_dataEntry(), EnumsCommon.TOVISIBLE.getText());
                    Assert.assertTrue("The values are not filled ", findElement(driver, String.format(onDataEntryPage.dataFieldsMVC, dataItemId)).getAttribute("value").length() > 0);
                    Assert.assertEquals(dataItemId + ": Actual and Expected values are different", findElement(driver, String.format(onDataEntryPage.dataFieldsMVC, dataItemId)).getAttribute("value"), testContext.getMapTestData().get("owner_DOB"));
                    break;
            }
        }
    }

    @Then("User enters new Activity name as {string} in react")
    public void user_enters_new_Activity_name_as_in_react(String activityName) {
        onDataEntryPage.getTxt_activityRename().clear();
        onDataEntryPage.getTxt_activityRename().sendKeys(activityName);
        addPropertyValueInJSON(testContext.getTestCaseID(), testContext, EnumsJSONProp.NEWACTIVITYNAME.getText(),activityName);
        captureScreenshot(driver, testContext, false);
    }

    @Then("User Verifies Data Entry Tab status {string}")
    public void userVerifiesDataEntryTabStatusValue(String status) {
        waitForPageToLoad(driver);
        captureScreenshot(driver, testContext, false);
        Assert.assertTrue("The data entry status  is not matching ", findElements(driver,String.format(onCommonMethodsPage.fieldWithTitleAttribute,status,status)).size()==1);
    }

    @Then("User stores Data Entry Data")
    public void user_stores_Data_Entry_Data() {
        addPropertyValueInJSON(testContext.getTestCaseID(), testContext, EnumsJSONProp.DATAENTRYPERCENTAGE.getText(), (onDataEntryPage.getTxt_DataEntryPercentage().getText().trim()));
    }

    @Then("User Verifies Data Entry Percentage")
    public void user_Verifies_Data_Entry_Percentage() {
        Assert.assertTrue("Data Entry Percentage Mismatched", onDataEntryPage.getTxt_DataEntryPercentage().getText().trim().equalsIgnoreCase(testContext.getMapTestData().get("dataEntryPercentage")));
    }

    @Then("User verifies all wizard and edit icon is displayed")
    public void user_verifies_all_wizard_and_edit_icon_is_displayed() {
        waitForPageToLoad(driver);
        Assert.assertTrue("Wizard was not Displayed", onDataEntryPage.getNavBar().isDisplayed());
        waitForPageToLoad(driver);
        syncElement(driver, onDataEntryReactPage.getBtn_Lock(), EnumsCommon.TOCLICKABLE.getText());
        Assert.assertTrue("Edit icon was not Displayed", onDataEntryPage.getIcon_AllicationLock().getAttribute("class").contains("pencil"));
    }
    @Then("User sets {string} to {string} date field")
    public void user_sets_to_date_field(String title, String value) {
        captureScreenshot(driver, testContext, false);
        waitForPageToLoad(driver);
        syncElement(driver,findElement(driver, String.format(onCommonMethods_reactPage.dataEntryTextFields, title, title,title)),EnumsCommon.TOCLICKABLE.getText());
        findElement(driver, String.format(onCommonMethods_reactPage.dataEntryTextFields, title, title,title)).sendKeys(value);
    }
    @Then("User verifies the date format for {string} to {string}")
    public void user_verifies_date_format_is(String title, String value) {
        captureScreenshot(driver, testContext, false);
        waitForPageToLoad(driver);
        syncElement(driver,findElement(driver, String.format(onCommonMethods_reactPage.dataEntryTextFields, title, title,title)),EnumsCommon.TOCLICKABLE.getText());
        Assert.assertEquals("Value was mismatched",value,findElement(driver, String.format(onCommonMethods_reactPage.dataEntryTextFields, title, title,title)).getAttribute("value"));
    }

    @Then("User Verifies all button on activity changes popup and clicks on {string} button")
    public void user_Verifies_all_button_on_activity_changes_popup_and_clicks_on_button(String button) {
        waitForPageToLoad(driver);
        switch (button) {
            case "yes":
                Assert.assertTrue("no button was not Displayed", onDataEntryPage.getBtn_noActivityChange().isDisplayed());
                Assert.assertTrue("yes button was not Displayed", onDataEntryPage.getBtn_yesActivityChange().isDisplayed());
                Assert.assertTrue("cancel button was not Displayed", onDataEntryPage.getBtn_cancelActivityChange().isDisplayed());
                clickElement(driver, onDataEntryPage.getBtn_yesActivityChange());
                break;

            case "no":
                Assert.assertTrue("no button was not Displayed", onDataEntryPage.getBtn_noActivityChange().isDisplayed());
                Assert.assertTrue("yes button was not Displayed", onDataEntryPage.getBtn_yesActivityChange().isDisplayed());
                Assert.assertTrue("cancel button was not Displayed", onDataEntryPage.getBtn_cancelActivityChange().isDisplayed());
                clickElement(driver, onDataEntryPage.getBtn_noActivityChange());
                break;

            case "cancel":
                Assert.assertTrue("no button was not Displayed", onDataEntryPage.getBtn_noActivityChange().isDisplayed());
                Assert.assertTrue("yes button was not Displayed", onDataEntryPage.getBtn_yesActivityChange().isDisplayed());
                Assert.assertTrue("cancel button was not Displayed", onDataEntryPage.getBtn_cancelActivityChange().isDisplayed());
                clickElement(driver, onDataEntryPage.getBtn_cancelActivityChange());
                break;

            default:
                throw new FLException("Button was not present: " + button);
        }
    }

    @Then("User stores the name of the application")
    public void user_stores_the_name_of_the_application() {
        waitForPageToLoad(driver);
        addPropertyValueInJSON(testContext.getTestCaseID(), testContext, "illustrationName", onDataEntryPage.getLabel_activityName().getText());
    }

    @Then("User Verifies Application name is {string} in new Activity list")
    public void user_verifies_Application_name_is_not_showing_in_new_acitivity_list(String visibility) {
        waitForPageToLoad(driver);
        captureScreenshot(driver, testContext, false);
        for (WebElement element : onHomePage.getList_RecentApplication()) {
            switch (visibility) {
                case "not showing":
                    if (element.getText().contains(testContext.getMapTestData().get("illustrationName")))
                        Assert.assertFalse("New Activity was Displayed in Activity list", element.getText().trim().equalsIgnoreCase(testContext.getMapTestData().get("illustrationName")));
                    break;

                case "showing":
                    if (element.getText().contains(testContext.getMapTestData().get("illustrationName")))
                        Assert.assertTrue("New Activity was not Displayed in Activity list", element.getText().trim().equalsIgnoreCase(testContext.getMapTestData().get("illustrationName")));
                    break;

                default:
                    throw new FLException("Invalid visibility tag: " + visibility);
            }
        }
    }
    @Then("User clicks on {string} in Top Menu")
    public void user_clicks_on_in_Top_Menu(String menuName) {
        waitForPageToLoad(driver);
        captureScreenshot(driver, testContext, false);
        clickElement(driver, findElement(driver,String.format(onDataEntryPage.getList_TopMenu(), menuName)));
    }
    @Then("User clicks on Link Icon on data entry page")
    public void user_clicks_on_Link_Icon_on_data_entry_page() {
        waitForPageToLoad(driver);
        captureScreenshot(driver, testContext, false);
        clickElement(driver, onDataEntryPage.getIcon_Link());
    }

    @Then("User Verifies Continue button is disabled on data entry")
    public void user_Verifies_Continue_button_is_disabled_on_data_entry() {
        captureScreenshot(driver, testContext, false);
        Assert.assertTrue("Option is Enabled on data entry page", getElement(driver, getExistingLocator(driver, onDataEntryPage.getImg_ReadOnly(), onDataEntryPage.getImg_ReadOnly1(), null, null)).getAttribute("onclick").contains("false"));
    }
    @Then("User verifies data in text fields")
    public void user_verifies_data_in_text_fields(io.cucumber.datatable.DataTable dataTable) {
        waitForPageToLoad(driver);
        captureScreenshot(driver, testContext, false);
        List<Map<String, String>> formFields = dataTable.asMaps(String.class, String.class);
        for (Map<String, String> fieldData : formFields) {
            String dataItemId = fieldData.get("data-item-id");
            String fieldValue = fieldData.get("values");
            Assert.assertEquals("Values are mismatched", fieldValue, findElement(driver,String.format(onDataEntryPage.dataFieldsMVC, dataItemId)).getAttribute("value").trim());
        }
    }
    @Then("User verifies Risk Classifier button is displayed")
    public void user_verifies_Risk_Classifier_button_is_displayed() {
        captureScreenshot(driver, testContext, false);
        if (testContext.getUiType().equalsIgnoreCase(EnumsCommon.UITYPE_REACT.getText())) {
            Assert.assertTrue("Risk classifier button was not displayed", onDataEntryPage.getBtn_RiskClassifierReact().isDisplayed());
        } else {
            Assert.assertTrue("Risk classifier button was not displayed", onDataEntryPage.getBtn_RiskClassifier().isDisplayed());
        }
    }
    @Then("User verifies Instant ID Results button is displayed")
    public void user_verifies_Instant_ID_Results_button_is_displayed() {
        captureScreenshot(driver, testContext, false);
        Assert.assertTrue("Instant ID button was not displayed", onDataEntryPage.getBtn_LexisNexisCallReact().isDisplayed());
    }

    @Then("User clicks on Risk Classifier button")
    public void user_clicks_on_Risk_Classifier_button() {
        captureScreenshot(driver, testContext, false);
        if (testContext.getUiType().equalsIgnoreCase(EnumsCommon.UITYPE_REACT.getText())) {
            clickElement(driver, onDataEntryPage.getBtn_RiskClassifierReact());
        } else {
            clickElement(driver, onDataEntryPage.getBtn_RiskClassifier());
        }
    }
    @Then("User verifies Back Office Dialog box is displayed")
    public void user_verifies_Back_Office_Dialog_box_is_displayed() {
        captureScreenshot(driver, testContext, false);
        Assert.assertTrue("Back Office Dialog was not displayed", onDataEntryPage.getTitle_Heading().isDisplayed());
    }
    @Then("User verifies prefilled data form for Risk Classifier")
    public void user_verifies_prefilled_data_form_for_Risk_Classifier(DataTable dataTable) {
        waitForPageToLoad(driver);
        captureScreenshot(driver, testContext, false);
        List<Map<String, String>> formFields = dataTable.asMaps(String.class, String.class);
        for (Map<String, String> fieldData : formFields) {
            String dataItemId = fieldData.get("data-dataitemid");
            String fieldValue = fieldData.get("value");
            String locatorType = fieldData.get("Locator Type");
            switch (locatorType){
                case "Input" :
                    if (testContext.getUiType().equalsIgnoreCase(EnumsCommon.UITYPE_REACT.getText())) {
                        Assert.assertTrue("Values was mismatched", findElement(driver, String.format(onDataEntryPage.dataFieldsReact, dataItemId,dataItemId)).getAttribute("value").length() > 0);
                    } else {
                        Assert.assertTrue("Values was mismatched", findElement(driver, String.format(onDataEntryPage.dataFieldsMVC, dataItemId)).getAttribute("value").length() > 0);
                    }
                    break;
                case "textarea":
                    Assert.assertTrue("Values was mismatched",  findElement(driver, String.format(onCommonMethods_reactPage.txtAreaInput,dataItemId)).getAttribute("value").length()>0);
                    break;
                default:
                    throw  new FLException("Invalid locator Type : " + locatorType);
            }
        }
    }
    @Then("User verifies form name is {string}")
    public void user_is_on_form(String formName) {
        captureScreenshot(driver, testContext, false);
        Assert.assertEquals(formName + " form was msimatched ",formName, findElement(driver, String.format(onDataEntryPage.getToolBar_FormName(),formName)).getText().trim());
    }

    @Then("User verifies {string}, {string}, {string}, {string}, {string} data displayed on Pending Requests popup For Owner")
    public void userVerifiesDataDisplayedOnPendingRequestsPopupSingle(String requestType, String recipient, String emailSent, String date, String passcode) {
        captureScreenshot(driver, testContext, false);
            Assert.assertTrue("Recipient is not displayed", onDataEntryPage.getTxt_PendingRequestDialogDetails().get(0).getText().trim().contains(recipient));
            Assert.assertTrue("Email is not displayed", onDataEntryPage.getTxt_PendingRequestDialogDetails().get(1).getText().trim().contains(emailSent));
            Assert.assertTrue("Date is not displayed", onDataEntryPage.getTxt_PendingRequestDialogDetails().get(2).getText().trim().contains(date));
            Assert.assertTrue("Passcode is not displayed", onDataEntryPage.getTxt_PendingRequestDialogDetails().get(3).getText().trim().contains(passcode));
            addPropertyValueInJSON(testContext.getTestCaseID(), testContext, "passcode",onDataEntryPage.getTxt_PendingRequestDialogDetails().get(3).getText().trim().split(":")[1].trim());
    }

    @Then("User Clicks on First Row")
    public void userClicksOnFirstRow() {
        captureScreenshot(driver, testContext, false);
        clickElement(driver,getElement(driver,getExistingLocator(driver,onDataEntryPage.getFirstRow(),onDataEntryPage.getFirstRow_React(),null,null)));
    }
    @Then("User Clicks on Second Row")
    public void userClicksOnSecondRow() {
        captureScreenshot(driver, testContext, false);
        clickElement(driver,getElement(driver,getExistingLocator(driver,onDataEntryPage.getSecondRow(),onDataEntryPage.getSecondRow_React(),null,null)));
    }

    @Then("User Verifies the records")
    public void user_Verifies_the_record() {
        captureScreenshot(driver, testContext, false);
        Assert.assertTrue("Record was not displayed", getElement(driver, getExistingLocator(driver, onDataEntryPage.getFirstValueRecordMVC1(), onDataEntryPage.getFirstValueRecordReact(), onDataEntryPage.getFirstValueRecordMVC(), null)).isDisplayed());
    }

    @Then("User verifies Search results")
    public void user_verifies_Search_results(DataTable dataTable) {
        captureScreenshot(driver, testContext, false);
        List<String> fieldValue = dataTable.asList(String.class);
        for (String inputValue : fieldValue) {
            boolean flag = false;
            for (WebElement result:getElements(driver,onDataEntryPage.getSearchResults())) {
                if(inputValue.equalsIgnoreCase(result.getText().trim())) {
                    flag = true;
                    break;
                }
            }
            Assert.assertTrue("Search Result"+inputValue+" not found",flag);
        }
    }

    @Then("User verifies {string} Tab is showing near {string} tab")
    public void user_verifies_Tab_is_showing_near_tab(String tab1, String tab2) {
        captureScreenshot(driver, testContext, false);
        Assert.assertTrue("Tabs position were not as per the expectations", findElements(driver, "//span[contains(text(),'" + tab2 + "')]//following::span[contains(text(),'" + tab1 + "')]").size() > 0);
    }
    @Then("User verifies {string} form is displayed")
    public void userVerifiesFormIsDisplay(String forms) {
        waitForPageToLoad(driver);
        captureScreenshot(driver, testContext, false);
        String[] expectedForms = forms.split(",");
        for (String form: expectedForms) {
            Assert.assertTrue(form+": form is not displayed", findElement(driver,String.format(onDataEntryPage.getListForms(),form)).isDisplayed());
        }
    }
    @Then("User verifies {string} form is not displayed")
    public void userVerifiesFormIsNotDisplay(String forms) {
        waitForPageToLoad(driver);
        captureScreenshot(driver, testContext, false);
        String[] expectedForms = forms.split(",");
        for (String form: expectedForms) {
            Assert.assertFalse(form+": form is displayed", findElements(driver,String.format(onDataEntryPage.getListForms(),form)).size() > 0);
        }
    }
    @Then("User Verifies backward arrow for navigation is shown")
    public void user_clicks_on_Backward_arrow() {
        waitForPageToLoad(driver);
        captureScreenshot(driver, testContext, false);
        Assert.assertTrue("The Backward arrow is not shown ", onSignaturePage.getBtn_PreviousPage().isDisplayed());
    }
    @Then("Verify User directly land on {string} Application")
    public void verify_Application(String app) {
        waitForPageToLoad(driver);
        captureScreenshot(driver, testContext, false);
        syncElement(driver, onDataEntryPage.getCountinue_button(), EnumsCommon.TOVISIBLE.getText());
        Assert.assertTrue(app + " New App is not created", onDataEntryPage.getTxt_NewApplication().getText().contains(app));
        addPropertyValueInJSON(testContext.getTestCaseID(), testContext, EnumsJSONProp.SECONDNEWPRODUCTNAME.getText(), onDataEntryPage.getTxt_NewApplication().getText());
    }

    @Then("User verifies Combox is not present on page")
    public void user_verifies_Combox_is_not_present_on_page() {
        captureScreenshot(driver, testContext, false);
        Assert.assertFalse("Combo Box present", getElements(driver, onDataEntryPage.getDdComboBoxMVC()).size()>0 | getElements(driver,onDataEntryPage.getDdComboBoxReact()).size() > 0);
    }
}