package com.hexure.firelight.stepdefinitions;

import com.hexure.firelight.libraies.Enums.EnumsJSONProp;
import com.hexure.firelight.libraies.EnumsCommon;
import com.hexure.firelight.libraies.FLException;
import com.hexure.firelight.libraies.FLUtilities;
import com.hexure.firelight.libraies.TestContext;
import com.hexure.firelight.pages.DataEntryPage;
import com.hexure.firelight.pages.RCTCompleteFillingAndSigningPage;
import com.hexure.firelight.pages.RCTCompleteFillingAppPage;
import cucumber.api.java.en.Then;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class RCTCompleteFillingApp_StepDefinition extends FLUtilities {
    private WebDriver driver;
    private TestContext testContext;
    private RCTCompleteFillingAppPage onRCTCompleteFillingAppPage;
    private RCTCompleteFillingAndSigningPage onRCTCompleteFillingAndSigningPage;

    private static final Logger Log = LogManager.getLogger(RCTCompleteFillingApp_StepDefinition.class);

    public RCTCompleteFillingApp_StepDefinition(TestContext context) {
        testContext = context;
        driver = context.getDriver();
        onRCTCompleteFillingAppPage = context.getPageObjectManager().getRCTCompleteFillingAppPage();
        onRCTCompleteFillingAndSigningPage = context.getPageObjectManager().getonRCTCompleteFillingAndSigningPage();
    }

    @Then("User Selects the Signer Type as {string}")
    public void userSelectsTheSignerType(String signertype) {
        captureScreenshot(driver, testContext, false);
        new Select(onRCTCompleteFillingAppPage.getDropdown_signerType()).selectByVisibleText(signertype);
    }

    @Then("User Enters Recipient name, Email")
    public void userEntersRecipientNameEmail() {
        captureScreenshot(driver, testContext, false);
        onRCTCompleteFillingAppPage.entersDetailsForNameEmail(testContext, driver, "receipantName",
                "receipantEmail");
    }

    @Then("User Enters Recipient name, Email, SSN, DOB")
    public void userEntersRecipientNameEmailSSNDOB() {
        captureScreenshot(driver, testContext, false);
        onRCTCompleteFillingAppPage.entersDetailsForNameEmailSSNDOB(testContext, driver, "receipantName",
                "receipantEmail", "receipantSsn", "receipantBirthdate");
    }

    @Then("User Clicks {string} Button")
    public void userClicksSendEmailRequestButton(String parameter) {
        captureScreenshot(driver, testContext, false);
        waitForPageToLoad(driver);
        switch (parameter) {
            case "Generate Link Without Email":
                clickElementByJSE(driver,onRCTCompleteFillingAppPage.getLink_GenerateLinkWithOutEmail());
                break;
            case "Send Email request":
                clickElementByJSE(driver, onRCTCompleteFillingAppPage.getBtn_sendEmailRequest());
                break;
            case "Back to App":
                clickElementByJSE(driver, onRCTCompleteFillingAppPage.getBtn_Backapp());
                break;
            case "Pending request":
                syncElement(driver, onRCTCompleteFillingAppPage.getLink_PendingRequest_DataEntry(), EnumsCommon.TOCLICKABLE.getText());
                clickElementByJSE(driver, onRCTCompleteFillingAppPage.getLink_PendingRequest_DataEntry());
                break;
            case "Close_PendingRequest":
                clickElementByJSE(driver, onRCTCompleteFillingAppPage.getClose_PendingRequest());
                break;
            case "Other Action":
                waitForPageToLoad(driver);
                clickElement(driver, onRCTCompleteFillingAppPage.getTab_otherActions());
                break;
            case "Request Client to Fill App":
                waitForPageToLoad(driver);
                clickElementByJSE(driver,onRCTCompleteFillingAppPage.getLink_ReqClientToFillApp());
                break;
            case "next":
                clickElementByJSE(driver, onRCTCompleteFillingAppPage.getBtn_Next());
                break;
            case "Benefit Percentage":
                clickElementByJSE(driver,onRCTCompleteFillingAppPage.getTxtBox_BenefitPercentage());
                break;
            case "Contact Agent":
                clickElementByJSE(driver,onRCTCompleteFillingAppPage.getBtn_ContactAgent());
                break;
            case "Send":
                clickElementByJSE(driver,onRCTCompleteFillingAppPage.getBtn_Send());
                break;
            case "Sign Application":
                clickElementByJSE(driver,onRCTCompleteFillingAppPage.getBtn_SignApplication());
                break;
            case"OK lock Activity":
                clickElementByJSE(driver,onRCTCompleteFillingAppPage.getBtn_OkPopup());
                break;
            case "Application":
                clickElementByJSE(driver,onRCTCompleteFillingAppPage.getBtn_Application());
                break;
            case "Check box":
                clickElementByJSE(driver,onRCTCompleteFillingAppPage.getCheckBox_Application());
                break;
            case "Close pending request":
                clickElementByJSE(driver,onRCTCompleteFillingAppPage.getLink_CloseIcon());
                break;
            case "Close pending review request":
                clickElementByJSE(driver,onRCTCompleteFillingAppPage.getLink_Close());
                break;
            case "Validate Account Information at the Bank":
                clickElementByJSE(driver,onRCTCompleteFillingAppPage.getLink_ValidateAccountAtBank());
                break;
            default:
                throw new FLException("Invalid value for: " + parameter);
        }
    }

    @Then("User Clicks Send Email request Button")
    public void userClicksSendEmailRequestButton() {
        captureScreenshot(driver, testContext, false);
        clickElement(driver,onRCTCompleteFillingAppPage.getBtn_sendEmailRequest());
    }

    @Then("User Notes the URL generated and clicks Back to App")
    public void userNotesTheURLGeneratedAndClicksBackToApp() {
        captureScreenshot(driver, testContext, false);
        addPropertyValueInJSON(testContext.getTestCaseID(), testContext, EnumsJSONProp.RECIPIENTURL.getText(), getElement(driver, getExistingLocator(driver, onRCTCompleteFillingAppPage.getLinktxt_ReceipantUrlMVC(), onRCTCompleteFillingAppPage.getLinktxt_ReceipantUrlReact(), null, null)).getText().trim());
        clickElement(driver, onRCTCompleteFillingAppPage.getBtn_BackToApp());
    }

    @Then("User Enters {string} Name, Email, SSN, DOB on Request Signature page")
    public void enter_Signer_Name_Email_SSN_DOB_on_Request_Signature_page(String type) {
        captureScreenshot(driver, testContext, false);
        if (type.equalsIgnoreCase("receipant")) {
            onRCTCompleteFillingAppPage.entersDetailsForNameEmailSSNDOB(testContext, driver, "receipantName",
                    "receipantEmail", "receipantSsn", "receipantBirthdate");
        } else {
            onRCTCompleteFillingAppPage.entersDetailsForNameEmailSSNDOB(testContext, driver, "signerName",
                    "signerEmail", "signerSsn", "signerBirthdate");
        }
    }

    @Then("User Notes the Generated URL & Passcode for Client Signer Party User Clicks Back to Signer")
    public void user_Notes_the_Generated_URL_Passcode_for_Client_Signer_Party() {
        captureScreenshot(driver, testContext, false);
        addPropertyValueInJSON(testContext.getTestCaseID(), testContext, EnumsJSONProp.SIGNERURL.getText(), getElement(driver, getExistingLocator(driver, onRCTCompleteFillingAppPage.getLink_GenerateWithoutEmail(), onRCTCompleteFillingAppPage.getLink_GenerateWithoutEmail1(), onRCTCompleteFillingAppPage.getLink_GenerateWithoutEmail2(), null)).getText().trim());
        addPropertyValueInJSON(testContext.getTestCaseID(), testContext, EnumsJSONProp.SIGNERPASSCODE.getText(), getElement(driver, getExistingLocator(driver, onRCTCompleteFillingAppPage.getLink_PasscodeWithoutEmail(), onRCTCompleteFillingAppPage.getLink_PasscodeWithoutEmail1(), onRCTCompleteFillingAppPage.getLink_PasscodeWithoutEmail2(), null)).getText().trim());
        clickElement(driver, getElement(driver, getExistingLocator(driver, onRCTCompleteFillingAppPage.getBtnBack(), onRCTCompleteFillingAppPage.getBtnBack1(), null, null)));
    }

    @Then("User Notes the Generated URL & Passcode and User Clicks Back to Signer")
    public void user_Notes_the_Generated_URL_Passcode_forAgent() {
        captureScreenshot(driver, testContext, false);
        addPropertyValueInJSON(testContext.getTestCaseID(), testContext, EnumsJSONProp.AGENTURL.getText(), getElement(driver, getExistingLocator(driver, onRCTCompleteFillingAppPage.getLinktxt_ReceipantUrlMVC(), onRCTCompleteFillingAppPage.getLinktxt_ReceipantUrlReact(), null, null)).getText().trim());
        addPropertyValueInJSON(testContext.getTestCaseID(), testContext, EnumsJSONProp.AGENTPASSCODE.getText(), getElement(driver, getExistingLocator(driver, onRCTCompleteFillingAppPage.getPasscodeMVC(), onRCTCompleteFillingAppPage.getPasscodeReact(), null, null)).getText().trim());
        clickElement(driver, onRCTCompleteFillingAppPage.getBtn_BackToApp());
    }

    @Then("User Notes the URL generated and clicks Back to Signer")
    public void userNotesTheURLGeneratedAndClicksBackToSigner() {
        captureScreenshot(driver, testContext, false);
        String url = getElement(driver, getExistingLocator(driver, onRCTCompleteFillingAppPage.getLinktxt_ReceipantUrlMVC(), onRCTCompleteFillingAppPage.getLinktxt_ReceipantUrlReact(), null, null)).getText().trim();
        url = url.substring(url.indexOf("https"));
        addPropertyValueInJSON(testContext.getTestCaseID(), testContext, EnumsJSONProp.SIGNERURL.getText(), url);
        clickElement(driver,getElement(driver, getExistingLocator(driver, onRCTCompleteFillingAppPage.getBtn_BackToApp1(), onRCTCompleteFillingAppPage.getBtn_BackToApp2(), null, null)));
    }

    @Then("User Notes the {string} URL generated and clicks Back to Signer")
    public void userNoteTheURLGeneratedAndClicksBackToSigner(String sequence) {
        captureScreenshot(driver, testContext, false);
        String url = getElement(driver, getExistingLocator(driver, onRCTCompleteFillingAppPage.getLinktxt_ReceipantUrlMVC(), onRCTCompleteFillingAppPage.getLinktxt_ReceipantUrlReact(), null, null)).getText().trim();
        url = url.substring(url.indexOf("https"));
        addPropertyValueInJSON(testContext.getTestCaseID(), testContext, sequence + EnumsJSONProp.SIGNERURL.getText(), url);
        clickElement(driver,getElement(driver, getExistingLocator(driver, onRCTCompleteFillingAppPage.getBtn_BackToApp1(), onRCTCompleteFillingAppPage.getBtn_BackToApp2(), null, null)));
    }

    @Then("User keeps all fields blank")
    public void user_keeps_all_fileds_blank() {
        captureScreenshot(driver, testContext, false);
        onRCTCompleteFillingAppPage.getTxt_Yourname().clear();
        onRCTCompleteFillingAppPage.getTxt_YourEmail().clear();
    }

    @Then("User verifies validation message displayed to respective fields")
    public void user_clicks_Send_Email_Request_Button_verifies_validation_message_displayed_to_respective_fields() {
        captureScreenshot(driver, testContext, false);
        Assert.assertTrue(" Message SignerType is not displayed", onRCTCompleteFillingAppPage.getMsg_SignerTypeError().isDisplayed());
        Assert.assertTrue(" Message RecipientName is not displayed", onRCTCompleteFillingAppPage.getMsg_RecipientName().isDisplayed());
        Assert.assertTrue("Message YourEmail is not displayed", onRCTCompleteFillingAppPage.getMsg_YourEmail().isDisplayed());
        Assert.assertTrue("Message ClientBirthDate is not displayed", onRCTCompleteFillingAppPage.getMsg_ClientBirthDate().isDisplayed());
    }

    @Then("User Select Signer type as {string}")
    public void user_Select_Signer_type_as(String ownerName) {
        waitForPageToLoad(driver);
        captureScreenshot(driver, testContext, false);
        clickElement(driver, onRCTCompleteFillingAppPage.getDropdown_signerType());
        selectOptionFromList(driver, onRCTCompleteFillingAppPage.getList_signertype(), ownerName, EnumsCommon.CLICK.getText());
    }

    @Then("User keeps fill the following details as recipient Name,Your Name,your Email and Client BirthDate")
    public void user_keeps_fill_the_following_details_as_recipient_Name_Your_Name_your_Email_and_Client_BirthDate() {
        captureScreenshot(driver, testContext, false);
        waitForPageToLoad(driver);
        onRCTCompleteFillingAppPage.getReceipantName().sendKeys(testContext.getMapTestData().get("ReceipantName"));
        onRCTCompleteFillingAppPage.getTxt_Yourname().sendKeys(testContext.getMapTestData().get("Yourname"));
        onRCTCompleteFillingAppPage.getTxt_YourEmail().sendKeys(testContext.getMapTestData().get("YourEmail"));
        clickElement(driver, onRCTCompleteFillingAppPage.getReceipantBirthdate());
        onRCTCompleteFillingAppPage.getReceipantBirthdate().sendKeys(testContext.getMapTestData().get("ReceipantBirthdate"));
    }


    @Then("User enter {string} on ReactApp page")
    public void user_keeps_fill_the_following_details_as_recipient_Name_Your_Name_your_Email_and_Client_BirthDate(String parameter) {
        captureScreenshot(driver, testContext, false);
        waitForPageToLoad(driver);
        switch (parameter) {
            case "Recipient Name":
                onRCTCompleteFillingAppPage.getReceipantName().sendKeys(testContext.getMapTestData().get("ReceipantName"));
                break;
            case "Your Name":
                onRCTCompleteFillingAppPage.getTxt_Yourname().sendKeys(testContext.getMapTestData().get("Yourname"));
                break;
            case "your Email":
                onRCTCompleteFillingAppPage.getTxt_YourEmail().sendKeys(testContext.getMapTestData().get("YourEmail"));
                break;
            case "Client BirthDate":
                waitForPageToLoad(driver);
                clickElement(driver, onRCTCompleteFillingAppPage.getReceipantBirthdate());
                onRCTCompleteFillingAppPage.getTxtBox_ClientDOB().sendKeys(testContext.getMapTestData().get("ReceipantBirthdate")+ Keys.TAB);
                break;
            case "recipient email":
                onRCTCompleteFillingAppPage.getTxtBox_RecipientEmail().sendKeys(testContext.getMapTestData().get("Recipient Email")+ Keys.TAB);
                break;
            case "ReceipantSSN":
                onRCTCompleteFillingAppPage.getReceipantSsn().sendKeys(testContext.getMapTestData().get("ReceipantSsn")+Keys.TAB);
                break;
            case "Owner First Name":
                onRCTCompleteFillingAppPage.getTxtBox_OwnerName().sendKeys(testContext.getMapTestData().get("OwnerFName")+ Keys.TAB);
                break;
            case "Owner Last Name":
                onRCTCompleteFillingAppPage.getTxtBox_OwnerLName().sendKeys(testContext.getMapTestData().get("OwnerlName")+ Keys.TAB);
                break;
            case "Zip Code":
                onRCTCompleteFillingAppPage.getTxtBox_ZipCode().sendKeys(testContext.getMapTestData().get("ZipCode")+ Keys.TAB);
                break;
            case "Owner DOB":
                onRCTCompleteFillingAppPage.getTxtBox_OwnerDOB().sendKeys(testContext.getMapTestData().get("Owner DOB")+ Keys.TAB);
                break;
            case "Benefit Percentage":
                onRCTCompleteFillingAppPage.getTxtBox_BenefitPercentage().sendKeys(testContext.getMapTestData().get("Benefit Percentage")+ Keys.TAB);
                break;
            case "Contact Number":
                onRCTCompleteFillingAppPage.getTxtBox_ContactNumber().sendKeys(testContext.getMapTestData().get("Contact Number")+ Keys.TAB);
                break;
            case "Date Of Birth":
                onRCTCompleteFillingAppPage.getTxtBox_DateOfBirth().sendKeys(testContext.getMapTestData().get("Date Of Birth")+ Keys.TAB);
                break;
            case "From Address":
                clickElementByJSE(driver,onRCTCompleteFillingAppPage.getTxtBox_FromAddress());
                onRCTCompleteFillingAppPage.getTxtBox_FromAddress().sendKeys(testContext.getMapTestData().get("From Address")+ Keys.TAB);
                break;
            case "Recipient Email" :
                waitForPageToLoad(driver);
                onRCTCompleteFillingAppPage.getTxtBox_RecipientEmail().sendKeys(testContext.getMapTestData().get("Recipient Email")+ Keys.TAB);
               break;
            default:
                throw new FLException("Invalid value for: " + parameter);
        }
    }

    @Then("User verifies validation message displayed to {string} field")
    public void user_clicks_button_verify_validation_message_displayed_to_field(String parameter) {
        captureScreenshot(driver, testContext, false);
        switch (parameter) {
            case "Recipient Name":
                Assert.assertEquals("Recipient mail is not in validation message popup ", testContext.getMapTestData().get("Recipient Error msg"), onRCTCompleteFillingAppPage.getMsg_ErrorRecipientEmail().getText().trim());
                break;
            case "SSN/government Id":
                Assert.assertEquals("SSNID is not in validation message popup", testContext.getMapTestData().get("SSNID"), onRCTCompleteFillingAppPage.getErrorMsg_SSNID().getText().trim());
                break;
            case "Signer Type":
             Assert.assertTrue("Signer Type  Message is not Displayed",onRCTCompleteFillingAppPage.getErrorMsg_SignerType().getText().contains("Signer Type is required."));
                break;
             case "Recipient Email":
                Assert.assertTrue("Your Email Error Message is not Displayed",onRCTCompleteFillingAppPage.getErrorMsg_RecipientEmail().getText().contains("Email is required."));
                break;
            case "SSN":
                Assert.assertTrue("Client Last 4 Digits of SSN Error  Message is not Displayed",onRCTCompleteFillingAppPage.getErrorMsg_SSN().getText().contains("The last 4 digits of SSN is required."));
                break;
            case "Client Birth Date":
                Assert.assertTrue("Client Birth Date Error  Message is not Displayed",onRCTCompleteFillingAppPage.getMsg_ClientBirthDate().getText().contains("A valid birth date is required."));
                break;
        }
    }

    @Then("User now fills valid data to recipient email field")
    public void user_now_fills_valid_data_to_recipient_email() {
        captureScreenshot(driver, testContext, false);
        clickElementByJSE(driver, onRCTCompleteFillingAppPage.getReceipantEmail());
        onRCTCompleteFillingAppPage.getReceipantEmail().sendKeys(testContext.getMapTestData().get("Recipient Email"));
    }

    @Then("User Clicks Send Email request button")
    public void clickSendRequestButton() {
        captureScreenshot(driver, testContext, false);
        onRCTCompleteFillingAndSigningPage.getBtn_SendEmail().click();
    }

    @Then("User verifies validation essage displayed to Client last four digit of SSN government Id fieldm")
    public void user_verifies_validation_message_displayed_to_Client_last_digit_of_SSN_government_Id_field() {
        captureScreenshot(driver, testContext, false);
        Assert.assertEquals("Error message is not displayed to Client last four digit of SSN government Id field", testContext.getMapTestData().get("SSNID"), onRCTCompleteFillingAppPage.getErrorMsg_SSNID().getText().trim());
    }

    @Then("User now fills valid data to other fields")
    public void user_now_fills_valid_data_to_all_other_fields_and_clicks_on_send_email_request_button() {
        captureScreenshot(driver, testContext, false);
        onRCTCompleteFillingAppPage.getReceipantSsn().sendKeys(testContext.getMapTestData().get("ReceipantSsn"));
    }

    @Then("User verify the functionality of all links available on Pending Requests box")
    public void user_verify_the_functionality_of_all_links_available_on_box() {
        captureScreenshot(driver, testContext, false);
        clickElementByJSE(driver, onRCTCompleteFillingAppPage.getLink_SendReminder());
        Assert.assertTrue("Send button is not displayed", onRCTCompleteFillingAppPage.getBtn_sendEmailRequest().isDisplayed());
        sleepInMilliSeconds(1000);
        Assert.assertTrue("Cancel button is not displayed", onRCTCompleteFillingAppPage.getBtn_Cancel().isDisplayed());
        clickElementByJSE(driver, onRCTCompleteFillingAppPage.getBtn_Cancel());
        clickElementByJSE(driver, onRCTCompleteFillingAppPage.getLink_SendPasscode());
        Assert.assertTrue("Send button is not displayed", onRCTCompleteFillingAppPage.getBtn_sendEmailRequest().isDisplayed());
        sleepInMilliSeconds(1000);
        Assert.assertTrue("Cancel button is not displayed", onRCTCompleteFillingAppPage.getBtn_Cancel().isDisplayed());
        clickElementByJSE(driver, onRCTCompleteFillingAppPage.getBtn_Cancel());
        clickElementByJSE(driver, onRCTCompleteFillingAppPage.getBtn_ClosePopup());
    }

    @Then("User verifies validation messaged displayed to respective fields ‘Signer Type’, ‘Recipient Name’, ‘Your Email’, Client Birth Date’ fields")
    public void userVerifiesValidationMessagedDisplayedToRespectiveFields() {
        captureScreenshot(driver, testContext, false);
        Assert.assertEquals("Error msg mismatched for Signer Type",testContext.getMapTestData().get("errorMsgSignerType"),onRCTCompleteFillingAppPage.getErrorMsg_SignerType().getText().trim());
        Assert.assertEquals("Error msg mismatched for Recipient Name",testContext.getMapTestData().get("errorMsgRecipientName"),onRCTCompleteFillingAppPage.getMsg_RecipientName().getText().trim());
        Assert.assertEquals("Error msg mismatched for Your Email",testContext.getMapTestData().get("errorMsgYourEmail"),onRCTCompleteFillingAppPage.getErrroMsg_YourEmail().getText().trim());
        Assert.assertEquals("Error msg mismatched for ClientBOD",testContext.getMapTestData().get("errorMsgClientBOD"),onRCTCompleteFillingAppPage.getErrorMsg_ClientBOD().getText().trim());
    }

    @Then("User Now Cancel the Request Clicks OK at Confirmation dialog")
    public void user_Now_Cancel_the_Request() {
        captureScreenshot(driver, testContext, false);
        clickElementByJSE(driver, onRCTCompleteFillingAppPage.getLink_CancelRequest());
        clickElementByJSE(driver, onRCTCompleteFillingAppPage.getBtn_OkPopup());
    }

    @Then("User verify pending request dialogue should appear")
    public void popupShouldAppear(){
        captureScreenshot(driver, testContext, false);
        Assert.assertTrue("Pending Request is not displayed", onRCTCompleteFillingAppPage.getTxt_HeaderPendingReq().isDisplayed());
    }

    @Then("User verify pending request dialogue should not appear")
    public void popupShouldNotAppear(){
        captureScreenshot(driver, testContext, false);
        int elemSize = onRCTCompleteFillingAppPage.getList_PendingRequest().size();
        Assert.assertTrue("Popup appeared on pending request", elemSize == 0);
    }

    @Then("User check Non Qualified box")
    public void checkNonQualifiedBox(){
        captureScreenshot(driver, testContext, false);
        clickElementByJSE(driver,onRCTCompleteFillingAppPage.getCheckBox_NonQualified());
    }

    @Then("User verifies link is generated and store it")
    public void userVerifiesLinkIsGenerated() {
        captureScreenshot(driver, testContext, false);
        WebElement element = getElement(driver, getExistingLocator(driver, onRCTCompleteFillingAppPage.getLinktxt_ReceipantUrlMVC(), onRCTCompleteFillingAppPage.getLinktxt_ReceipantUrlReact(), null, null));
        Assert.assertTrue("Recipient link is not displayed",element.isDisplayed());
        addPropertyValueInJSON(testContext.getTestCaseID(),testContext, "NewrecipientLink",element.getText().trim());
        addPropertyValueInJSON(testContext.getTestCaseID(),testContext, "receipantLink(url)",element.getText().trim());
    }
    @Then("User enter all the requeired details")
    public void userEnterAllTheRequeiredDetails() {
        waitForPageToLoad(driver);
        syncElement(driver, onRCTCompleteFillingAppPage.getReceipantName(), EnumsCommon.TOCLICKABLE.getText());
        captureScreenshot(driver, testContext, false);
        onRCTCompleteFillingAppPage.getReceipantName().sendKeys(testContext.getMapTestData().get("recipientName"));
        onRCTCompleteFillingAppPage.getTxtBox_recipientsEmail().sendKeys(testContext.getMapTestData().get("recipientEmail"));
        onRCTCompleteFillingAppPage.getTxt_Yourname().clear();
        onRCTCompleteFillingAppPage.getTxt_Yourname().sendKeys(testContext.getMapTestData().get("yourName"));
        onRCTCompleteFillingAppPage.getTxt_YourEmail().clear();
        onRCTCompleteFillingAppPage.getTxt_YourEmail().sendKeys(testContext.getMapTestData().get("yourMail"));
        onRCTCompleteFillingAppPage.getTxtBox_SSNID().sendKeys(testContext.getMapTestData().get("ssnNumber"));
        syncElement(driver, onRCTCompleteFillingAppPage.getReceipantBirthdate(), EnumsCommon.TOCLICKABLE.getText());
        clickElementByJSE(driver,onRCTCompleteFillingAppPage.getReceipantBirthdate());
        onRCTCompleteFillingAppPage.getReceipantBirthdate().sendKeys(testContext.getMapTestData().get("clientBOD"));
        onRCTCompleteFillingAppPage.getReceipantBirthdate().sendKeys(Keys.TAB);
    }

    @Then("User fill the details Recipient Name {string}, Your Name {string}, Your Email {string}, Client Birth Date {string}")
    public void userFillTheDetailsRecipientNameYourNameYourEmailClientBirthDate(String recipientName, String yourName, String yourMail, String clientBOD) {
        waitForPageToLoad(driver);
        syncElement(driver,onRCTCompleteFillingAppPage.getReceipantName(), EnumsCommon.TOCLICKABLE.getText());
        captureScreenshot(driver, testContext, false);
        onRCTCompleteFillingAppPage.getReceipantName().sendKeys(recipientName);
        onRCTCompleteFillingAppPage.getTxt_Yourname().sendKeys(yourName);
        onRCTCompleteFillingAppPage.getTxt_YourEmail().sendKeys(yourMail);
        syncElement(driver,onRCTCompleteFillingAppPage.getTxtBox_clientBOD(), EnumsCommon.TOCLICKABLE.getText());
        onRCTCompleteFillingAppPage.getTxtBox_clientBOD().sendKeys(clientBOD);
        onRCTCompleteFillingAppPage.getTxtBox_clientBOD().sendKeys(Keys.TAB);
    }

    @Then("USer fill valid data to ‘Recipient Email’ field {string},Recipient Name {string}, Client Birth Date {string}")
    public void userFillValidDataToRecipientEmailField(String recipientEmail,String recientName,String clientBOD) {
        syncElement(driver,onRCTCompleteFillingAppPage.getReceipantEmail(), EnumsCommon.TOCLICKABLE.getText());
        captureScreenshot(driver, testContext, false);
        onRCTCompleteFillingAppPage.getReceipantEmail().sendKeys(recipientEmail);
        onRCTCompleteFillingAppPage.getTxtBox_clientBOD().sendKeys(clientBOD);
        onRCTCompleteFillingAppPage.getTxtBox_clientBOD().sendKeys(Keys.TAB);
    }

    @Then("User verifies validation message displayed to ‘Client Last4 Digits of SSN,Government ID’ field")
    public void userVerifiesValidationMessageDisplayedToClientLastDigitsOfSSNGovernmentIDField() {
        captureScreenshot(driver, testContext, false);
        Assert.assertTrue("Error msg not displayed on SSN field",onRCTCompleteFillingAppPage.getErrorMsg_SSN().isDisplayed());
        Assert.assertEquals("Error msg mismatched for SSN field",testContext.getMapTestData().get("errorMsgSSN"),onRCTCompleteFillingAppPage.getErrorMsg_SSN().getText().trim());
    }

    @Then("User Fill valid data to all other fields SSN {string}")
    public void userFillValidDataToAllOtherFields(String ssnNumber) {
        captureScreenshot(driver, testContext, false);
        onRCTCompleteFillingAppPage.getReceipantSsn().sendKeys(ssnNumber);
    }

    @Then("User verifies {string} text is displayed with timestamp, {string} text is displayed having External link \\(Store External Link),{string} button is display")
    public void userVerifiesTextIsDisplayedWithTimestampTextIsDisplayedHavingExternalLinkStoreExternalLinkButtonIsDisplay(String linkGenerated, String recipientsText, String arg2) {
        captureScreenshot(driver, testContext, false);
        WebElement element = getElement(driver, getExistingLocator(driver, onRCTCompleteFillingAppPage.getLinktxt_ReceipantUrlMVC(), onRCTCompleteFillingAppPage.getLinktxt_ReceipantUrlReact(), null, null));
        Assert.assertTrue("Link generated at text is not displayed with timestamp",onRCTCompleteFillingAppPage.getTxtMsg_linkGeneratedTimeStamp().getText().split("\n")[0].trim().contains(linkGenerated));
        Assert.assertTrue("Recipient link is not displayed",element.isDisplayed());
        addPropertyValueInJSON(testContext.getTestCaseID(),testContext, "recipientLink",element.getText().trim());
        Assert.assertTrue("'Back to App' button is not displayed",onRCTCompleteFillingAppPage.getBtn_BackToApp().isDisplayed());
    }

    @Then("User clicks on Back To App button")
    public void userClicksOnBackToAppButton() {
        captureScreenshot(driver, testContext, false);
        clickElementByJSE(driver,onRCTCompleteFillingAppPage.getBtn_BackToApp());
    }


    @Then("User fill the details Recipient Name {string}, Recipient Email {string}, Your Name {string}, Your Email {string}, SSN {string}, Client Birth Date {string}")
    public void userFillTheDetailsRecipientNameRecipientEmailYourNameYourEmailSSNClientBirthDate(String recipientName, String recipientEmail, String yourName, String yourMail, String ssnNumber, String clientBOD) {
        waitForPageToLoad(driver);
        syncElement(driver,onRCTCompleteFillingAppPage.getReceipantName(),EnumsCommon.TOCLICKABLE.getText());
        captureScreenshot(driver, testContext, false);
        onRCTCompleteFillingAppPage.getReceipantName().sendKeys(recipientName);
        addPropertyValueInJSON(testContext.getTestCaseID(),testContext, "recipientName",recipientName);
        onRCTCompleteFillingAppPage.getReceipantEmail().sendKeys(recipientEmail);
        addPropertyValueInJSON(testContext.getTestCaseID(),testContext, "recipientEmail",recipientEmail);
        onRCTCompleteFillingAppPage.getTxt_Yourname().sendKeys(yourName);
        addPropertyValueInJSON(testContext.getTestCaseID(),testContext, "yourName",yourName);
        onRCTCompleteFillingAppPage.getTxtBox_yourEmail().sendKeys(yourMail);
        addPropertyValueInJSON(testContext.getTestCaseID(),testContext, "yourEmail",yourMail);
        onRCTCompleteFillingAppPage.getReceipantSsn().sendKeys(ssnNumber);
        addPropertyValueInJSON(testContext.getTestCaseID(),testContext, "ReceipantSsn",ssnNumber);
        syncElement(driver,onRCTCompleteFillingAppPage.getTxtBox_clientBOD(),EnumsCommon.TOCLICKABLE.getText());
        clickElementByJSE(driver,onRCTCompleteFillingAppPage.getTxtBox_clientBOD());
        sleepInMilliSeconds(2000);
        onRCTCompleteFillingAppPage.getTxtBox_clientBOD().sendKeys(clientBOD);
        addPropertyValueInJSON(testContext.getTestCaseID(),testContext, "ReceipantBirthdate",clientBOD);
        onRCTCompleteFillingAppPage.getTxtBox_clientBOD().sendKeys(Keys.TAB);
    }

    @Then("User Enters partial id as {string} for signer {string} as value {string}")
    public void user_Enters_Name_SSN_BirthDate_And_Email_For(String partialId, String signer, String value) {
        captureScreenshot(driver, testContext, false);
        findElement(driver,String.format(onRCTCompleteFillingAppPage.requiredField_SignerWithPartialId,signer,partialId)).click();
        findElement(driver,String.format(onRCTCompleteFillingAppPage.requiredField_SignerWithPartialId,signer,partialId)).clear();
        sendKeys(driver,findElement(driver,String.format(onRCTCompleteFillingAppPage.requiredField_SignerWithPartialId,signer,partialId)),
                testContext.getMapTestData().get(value));
    }

    @Then("User Verifies Message Popup is not Displaying")
    public void userVerifiesMessagePopupIsNotDisplaying() {
        captureScreenshot(driver, testContext, false);
        Assert.assertFalse("Message Box is Opened", onRCTCompleteFillingAppPage.getMyMessage().isDisplayed());
    }

}

