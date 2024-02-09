package com.hexure.firelight.stepdefinitions;

import com.hexure.firelight.libraies.Enums.EnumsJSONProp;
import com.hexure.firelight.libraies.EnumsCommon;
import com.hexure.firelight.libraies.FLException;
import com.hexure.firelight.libraies.FLUtilities;
import com.hexure.firelight.libraies.TestContext;
import com.hexure.firelight.pages.CommonMethodsPage;
import com.hexure.firelight.pages.CreateApplicationPage;
import com.hexure.firelight.pages.ReviewPage;
import cucumber.api.java.en.Then;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Review_StepDefinitions extends FLUtilities {
    private WebDriver driver;
    private ReviewPage onReviewPage;
    private CreateApplicationPage onCreateApplicationPage;
    private TestContext testContext;
    private static final Logger Log = LogManager.getLogger(Review_StepDefinitions.class);

    public Review_StepDefinitions(TestContext context) {
        testContext = context;
        driver = context.getDriver();
        onReviewPage = context.getPageObjectManager().getReviewPage();
        onCreateApplicationPage = context.getPageObjectManager().getCreateApplicationPage();
    }

    @Then("User clicks {string} E-Review")
    public void userClicksEReview(String whichButton) {
        captureScreenshot(driver, testContext, false);
        if (whichButton.equalsIgnoreCase("Decline"))
            onReviewPage.getBtn_DeclineReview().click();
        else
            onReviewPage.getBtn_SendRequestToReviewer().click();
    }

    @Then("User Note down the URL for external link from Message template.")
    public void userNoteDownTheURLForExternalLinkFromMessageTemplate() {
        captureScreenshot(driver, testContext, false);

        String inputString = onReviewPage.getMessage().getText();

        // Define a regular expression pattern to match URLs
        String regex = "https?://\\S+";

        // Create a Pattern object
        Pattern pattern = Pattern.compile(regex);

        // Create a Matcher object
        Matcher matcher = pattern.matcher(inputString);
        String url = null;
        // Find and print all matching URLs

        while (matcher.find()) {
            url = matcher.group();
            System.out.println("Found URL: " + url);
        }
        url = getEmailLink(url);

        addPropertyValueInJSON(testContext.getTestCaseID(),testContext,EnumsJSONProp.REVIEWERURL.getText(),url );
        addPropertyValueInJSON(testContext.getTestCaseID(),testContext,EnumsJSONProp.RECIPIENTURL.getText(),url );
        System.setProperty("External URL",url);
    }

    public String getEmailLink(String mailBody) {
        String[] lstContent = {">Click",","};
        for (String content : lstContent) {
            if (mailBody.contains(content) & mailBody.lastIndexOf(content) > mailBody.lastIndexOf("https"))
                return mailBody.substring(mailBody.lastIndexOf("https"), mailBody.lastIndexOf(content)).trim();
        }
        return null;
    }

    @Then("User verifies message on Electronic Review Declined window")
    public void userVerifiesMessageOnElectronicReviewDeclinedWindow() {
        captureScreenshot(driver, testContext, false);
        Assert.assertTrue("Electronic Review Declined Message Mismatched - First Line",
                onReviewPage.getMsg_ElectronicReviewDecline().getText().trim().contains(testContext.getMapTestData().get("messageElectronicReviewDecline-1")));
        Assert.assertTrue("Electronic Review Declined Message Mismatched - Second Line",
                onReviewPage.getMsg_ElectronicReviewDecline().getText().trim().contains(testContext.getMapTestData().get("messageElectronicReviewDecline-2")));
    }

    @Then("User clicks Ok to decline Electronic Review")
    public void userClicksOkToDeclineElectronicReview() {
        onReviewPage.getBtn_OK().click();
    }

    @Then("User verifies Review step has minus circle")
    public void userVerifiesReviewStepHasMinusCircle() {
        clickElementByJSE(driver,onReviewPage.getBtn_InitialMessagePopupClose());
        syncElement(driver, onReviewPage.getTab_REVIEW(), EnumsCommon.TOVISIBLE.getText());
        Assert.assertTrue("Review step has NO minus circle", onReviewPage.getImage_ReviewMinusCircle().isDisplayed());
    }

    @Then("User verifies Application is in review step")
    public void userApplicationIsInReviewStep() {
        captureScreenshot(driver, testContext, false);
        Assert.assertTrue("Review tab is NOT highlighted", getElement(driver, getExistingLocator(driver, onReviewPage.getCanvas_ReviewMVC(), onReviewPage.getCanvas_ReviewReact(), null, null)).getAttribute("class").contains("status_current"));
    }

    @Then("User clicks Submit link")
    public void userClickSubmitLink() {
        captureScreenshot(driver, testContext, false);
        clickElement(driver, getElement(driver, getExistingLocator(driver, onReviewPage.getLink_SubmitMVC(), onReviewPage.getLink_SubmitReact(), null, null)));
    }

    @Then("User verifies Submit Confirmation Message")
    public void userVerifySubmitConfirmationMessage() {
        captureScreenshot(driver, testContext, false);
        moveToElement(driver, onReviewPage.getMsg_Submit_Confirmation1());
        Assert.assertTrue("Submit Confirmation message Line1 MisMatched", onReviewPage.getMsg_Submit_Confirmation1().getText().split("\n")[0].trim()
                .contains(testContext.getMapTestData().get("Submit_Cmf_Msg_Line1")));
        Assert.assertTrue("Submit Confirmation message Line2 MisMatched", onReviewPage.getMsg_Submit_Confirmation2().getText().trim().split("\n")[0].trim()
                .contains(testContext.getMapTestData().get("Submit_Cmf_Msg_Line2")));
        Assert.assertTrue("Submit Confirmation message Line3 MisMatched", onReviewPage.getMsg_Submit_Confirmation3().getText().trim()
                .contains(testContext.getMapTestData().get("Submit_Cmf_Msg_Line3")));
    }

    @Then("User Goes to Other Action, Verifies {string} is showing, Now Clicks on History")
    public void userGoesToOtherAction(String otherOption) {
        captureScreenshot(driver, testContext, false);
        clickElement(driver, onReviewPage.getOtherAction_tab());
        List<String> optionlist = new ArrayList<>();
        for (WebElement option : onReviewPage.getOtherActionOptions()) {
            optionlist.add(option.getText().trim());
        }
        Assert.assertTrue(otherOption + " is not showing", optionlist.contains(otherOption));
        selectOptionFromList(driver, onReviewPage.getOtherActionOptions(), "History", EnumsCommon.CLICK.getText());
    }

    @Then("User On History Dialog verifies few Audits like {string}, {string}, {string} \\({int} times), {string}")
    public void userOnHistoryDialogVerifiesFewAuditsLikeTime(String auditStatus, String auditMsg1, String auditMsg2, int auditMsg3, String auditMsg4) {
        captureScreenshot(driver, testContext, false);
        Boolean flag = false;
        for (WebElement actualStatus : onReviewPage.getAuditStatuses()) {
            if (actualStatus.getText().trim().equalsIgnoreCase(auditStatus)) {
                flag = true;
            }
        }
        for (WebElement actualMsg : onReviewPage.getAuditStatusmsgs()) {
            String msg = actualMsg.getText().trim();
            if (msg.equalsIgnoreCase(auditMsg1))
                flag = true;
        }
        Assert.assertTrue("Status not Verified", flag);
    }

    @Then("User On History Dialog verifies few Audits like {string}, {string}, {string}")
    public void userOnHistoryDialogVerifiesFewAudits(String auditStatus, String auditMsg1, String auditMsg2) {
        captureScreenshot(driver, testContext, false);
        Boolean flag = false;
        for (WebElement actualStatus : onReviewPage.getAuditStatuses()) {
            if (actualStatus.getText().trim().equalsIgnoreCase(auditStatus)) {
                flag = true;
            }
        }
        for (WebElement actualMsg : onReviewPage.getAuditStatusmsgs()) {
            String msg = actualMsg.getText().trim();
            if (msg.equalsIgnoreCase(auditMsg1))
                flag = true;
        }
        Assert.assertTrue("Status not Verified", flag);
    }

    @Then("User Closes History Dialog")
    public void userClosesHistoryDialog() {
        captureScreenshot(driver, testContext, false);
        clickElement(driver, onReviewPage.getBtn_Historyclose());
    }

    @Then("User Clicks on Request Review")
    public void userClicksOnRequestReview() {
        captureScreenshot(driver, testContext, false);
        clickElement(driver, getElement(driver, getExistingLocator(driver, onReviewPage.getLink_requestReviewMVC(), onReviewPage.getLink_requestReviewReact(), null, null)));
    }
    @Then("User Select Application from activity selection menu")
    public void userSlectApplicationFromActivitySelectionMenu() {
        captureScreenshot(driver, testContext, false);
        clickElementByJSE(driver, onReviewPage.getLink_Application());
    }

    @Then("User Clicks on Decline E-Review")
    public void userClicksonDeclineEReview() {
        captureScreenshot(driver, testContext, false);
        clickElement(driver, onReviewPage.getBtn_DeclineReview());
    }

    @Then("User Clicks OK")
    public void userClicksOK() {
        captureScreenshot(driver, testContext, false);
        clickElement(driver, onReviewPage.getBtn_OK());
    }

    @Then("User Navigate to Main URL")
    public void userNavigateToMainURL(){
        captureScreenshot(driver, testContext, false);
        openLoginPage(driver, testContext);
    }

    @Then("User Verifies Data Entry, Signatures tab has green tick and Review tab has minus circle")
    public void userVerifiesDataEntrySignaturestab() {
        syncElement(driver, onReviewPage.getTab_SIGNATURES(), EnumsCommon.TOVISIBLE.getText());
        captureScreenshot(driver, testContext, false);
        Assert.assertTrue("Review step has NO minus circle", onReviewPage.getImage_ReviewCircle().isDisplayed());
        syncElement(driver, onReviewPage.getTab_SIGNATURES(), EnumsCommon.TOVISIBLE.getText());
        Assert.assertTrue("SIGNATURES step has NO Tick symbol", onReviewPage.getImage_SignatureTick().isDisplayed());
        syncElement(driver, onReviewPage.getTab_DATAENTRY(), EnumsCommon.TOVISIBLE.getText());
        Assert.assertTrue("DATAENTRY step has NO Tick symbol", onReviewPage.getImage_DataEntryTick().isDisplayed());
    }

    @Then("User Clicks on Add to Reviewer link")
    public void user_Clicks_on_Add_to_Reviewer_link() {
        captureScreenshot(driver, testContext, false);
       clickElement(driver,onReviewPage.getLink_AddReviewer());
    }

    @Then("User Updates Reviewer Name, Email & Click on Checkbox")
    public void user_Updates_Reviewer_Name_Email_Click_on_Checkbox() {
        captureScreenshot(driver, testContext, false);
        clickElement(driver,onReviewPage.getCheckBox_Reviewer());
        String appName = testContext.getMapTestData().get("newProductName");
        String name = testContext.getMapTestData().get("reviewerName");
        if(name.contains("Random")) {
            name = name + appName.substring(appName.lastIndexOf(" "));
            addPropertyValueInJSON(testContext.getTestCaseID(), testContext, EnumsJSONProp.REVIEWERNAMERANDOM.getText(), name);
        }
        onReviewPage.getTxtBox_ReviewerName().sendKeys(name);
        onReviewPage.getTxtBox_ReviewerEmail().sendKeys(testContext.getMapTestData().get("reviewerEmail"));
    }

    @Then("User enters reviewer Email on Send Email Joint Owner")
    public void user_Enters_Reviewer_Email_on_Send_Email_Joint_Owner(){
        captureScreenshot(driver, testContext, false);
        onReviewPage.getTxtBox_ReviewerEmail().sendKeys(testContext.getMapTestData().get("reviewerEmail"));
        onReviewPage.getTxtBox_MailerSSN().clear();
        onReviewPage.getTxtBox_MailerSSN().sendKeys(testContext.getMapTestData().get("signerSsn"));
    }

    @Then("User enters SignerName, SingerEmail, SSN, DOB on Send Email Signer")
    public void user_Enters_SignerName_SingerEmail_SSN_DOB_on_Send_Email_Signer(){
        captureScreenshot(driver, testContext, false);
        onReviewPage.getTxtBox_ReviewerEmail().sendKeys(testContext.getMapTestData().get("reviewerEmail"));
        onReviewPage.getTxtBox_MailerSSN().clear();
        onReviewPage.getTxtBox_MailerSSN().sendKeys(testContext.getMapTestData().get("signerSsn"));
        onReviewPage.getTxtBox_ReviewerName().sendKeys(testContext.getMapTestData().get("signerFullName"));
        clickElement(driver,onReviewPage.getTxtBox_SignerDOB());
        onReviewPage.getTxtBox_SignerDOB().sendKeys(testContext.getMapTestData().get("signerBirthdate"));
     }

    @Then(("User Gets the URL by Clicking Send Reminder link"))
    public void UserGetsTheURLByClickingSendReminderlink(){
        captureScreenshot(driver, testContext, false);
        clickElement(driver,getElement(driver, getExistingLocator(driver, onReviewPage.getLink_SendReminderMailMVC(), onReviewPage.getLink_SendReminderMailReact(), null, null)));
        String s = onReviewPage.getEmailMsg().getText().trim();
        addPropertyValueInJSON(testContext.getTestCaseID(),testContext, EnumsJSONProp.REVIEWERURL.getText(),s.substring(s.indexOf(", click on ") + 11, s.indexOf(", and")));
    }

    @Then(("User Gets the URL from message box by Clicking {string} Send Reminder link"))
    public void UserGetsTheURLFromMessageBoxByClickingSendReminderlink(String user){
        captureScreenshot(driver, testContext, false);
        for(WebElement sendReminder: onReviewPage.getList_LinkSendReminder()){
            if(sendReminder.getText().contains(user)){
                sendReminder.click();
                syncElement(driver, onReviewPage.getEmailMsg(), EnumsCommon.TOVISIBLE.getText());
                String getMessage = onReviewPage.getEmailMsg().getText().trim();
                addPropertyValueInJSON(testContext.getTestCaseID(),testContext, EnumsJSONProp.REVIEWERURL.getText()+user,getMessage.substring(getMessage.indexOf("<a href")+8, getMessage.indexOf(">Click here")));
                break;
            }
        }
    }

    @Then("User verifies same Passcode as generated Before")
    public void user_verifies_same_Passcode_as_generated_Before() {
        captureScreenshot(driver, testContext, false);
       Assert.assertEquals("Reviewer Passcode is not matching",testContext.getMapTestData().get("reviewerPasscode"),onReviewPage.getPasscode_Reviewer().getText().trim());
    }
    @Then("User verifies same Passcode as generated")
    public void user_verifies_same_Passcode_as_generated() {
        captureScreenshot(driver, testContext, false);
        Assert.assertEquals("Agent Passcode is not matching",testContext.getMapTestData().get("agentPasscode"),onReviewPage.getPasscode_Reviewer().getText().trim());
    }

    @Then("User clicks button Back to app in Email request page")
    public void user_clicks_button_Back_to_app_in_Email_request_page() {
        syncElement(driver,onReviewPage.getButtonBack(),EnumsCommon.TOCLICKABLE.getText());
        captureScreenshot(driver, testContext, false);
        clickElementByJSE(driver,onReviewPage.getButtonBack());
    }

    @Then("User clicks Send button in pending Request")
    public void user_clicks_button_in_pending_Request() {
        captureScreenshot(driver, testContext, false);
        clickElement(driver,onReviewPage.getBtn_sendEmailRequest());
    }

    @Then("User  Verifies current Breadcrumb selected is Review step and Data entry step has green tick mark")
    public void user_Verifies_current_Breadcrumb_selected_is_Review_step_and_Data_entry_step_has_green_tick_mark() {
        Assert.assertTrue(onReviewPage.getImage_DataEntryTick().isDisplayed());
    }

    @Then("User Navigates To Review Page")
    public void user_Navigates_To_Review_Page() {
        captureScreenshot(driver, testContext, false);
      Assert.assertTrue("User is not in Review page",getElement(driver, getExistingLocator(driver, onReviewPage.getCanvas_ReviewMVC(), onReviewPage.getCanvas_ReviewReact(), null, null)).isEnabled());
    }

    @Then("User Verifies Heading {string}")
    public void user_Verifies_Heading(String pageHeading) {
        syncElement(driver,onCreateApplicationPage.getBtn_Create(),EnumsCommon.TOVISIBLE.getText());
        captureScreenshot(driver, testContext, false);
        Assert.assertEquals("Page is not correct with Heading" + pageHeading, pageHeading, onReviewPage.getHeading_Reviewer().getText().trim());
    }

    @Then("User Verifies First Line of page as {string}")
    public void user_Verifies_First_Line_of_page_as(String message) {
        captureScreenshot(driver, testContext, false);
       Assert.assertEquals("The Mentioned Message is not showing",message,onReviewPage.getMessageText_SendEmailtoReviewerPage().getText().trim());
    }

    @Then("User Verifies Your name TextBox has {string}")
    public void user_Verifies_Your_name_TextBox_has(String name) {
        captureScreenshot(driver, testContext, false);
        Assert.assertEquals(name + " is not matching", testContext.getMapTestData().get(name), onReviewPage.getTxtBox_Yourname().getAttribute("value").trim());
    }

    @Then("User Verifies Your Email TextBox has {string}")
    public void user_Verifies_Your_Email_TextBox_has(String email) {
        captureScreenshot(driver, testContext, false);
        Assert.assertEquals(email + " is not matching", testContext.getMapTestData().get(email), onReviewPage.getTxtBox_YourEmail().getAttribute("value").trim());
    }

    @Then("User Verifies Subject Text Box having Text {string}")
    public void user_Verifies_Subject_Text_Box_having_Text(String subjectMessage) {
        captureScreenshot(driver, testContext, false);
        Assert.assertEquals(subjectMessage + " is not matching", subjectMessage, onReviewPage.getTxtBox_Subject().getAttribute("value").trim());
    }

    @Then("User Verifies Add Reviewer and reset link is available")
    public void user_Verifies_Add_Reviewer_and_reset_link_is_available() {
        captureScreenshot(driver, testContext, false);
        Assert.assertTrue("Add Reviewer Link is available",onReviewPage.getLink_AddReviewer().isDisplayed());
        Assert.assertTrue("Reset Link is available",onReviewPage.getLink_Reset().isDisplayed());
    }

    @Then("User Verifies Passcode is displayed")
    public void user_Verifies_Passcode_is_displayed() {
        captureScreenshot(driver, testContext, false);
        Assert.assertTrue("Passcode is available",onReviewPage.getSendEmailPasscode().isDisplayed());
        addPropertyValueInJSON(testContext.getTestCaseID(), testContext, EnumsJSONProp.REVIEWERPASSCODE.getText(), onReviewPage.getSendEmailPasscode().getText().trim());
    }

    @Then("User Verifies Send Email button and cancel button is available")
    public void user_Verifies_Send_Email_button_and_cancel_button_is_available() {
        captureScreenshot(driver, testContext, false);
        Assert.assertTrue("Send Email request Button is available",onReviewPage.getBtn_sendEmailRequest().isDisplayed());
        Assert.assertTrue("Cancel Button is available",onReviewPage.getBtn_Cancel().isDisplayed());
    }

    @Then("User Clears Your name TextBox")
    public void user_Clears_Your_name_TextBox() {
        captureScreenshot(driver, testContext, false);
        onReviewPage.getTxtBox_Yourname().clear();
    }

    @Then("User Clears Your Email TextBox")
    public void user_Clears_Your_Email_TextBox() {
        captureScreenshot(driver, testContext, false);
        onReviewPage.getTxtBox_YourEmail().clear();
    }

    @Then("User Verifies the error message text for all four fields")
    public void user_Verifies_the_error_message_text_for_all_fields() {
        waitForPageToLoad(driver);
        captureScreenshot(driver, testContext, false);
        Assert.assertTrue("Your Name Error Message is not Displaying",onReviewPage.getTxtMsg_ErrorYourname().getText().trim().contains("Name is required."));
        Assert.assertTrue("Your Email Error Message is not Displaying",onReviewPage.getTxtMsg_ErrorYourEmail().getText().trim().contains("Email is required."));
        Assert.assertTrue("Reviewer Name Error Message is not Displaying",onReviewPage.getTxtMsg_ErrorReviewerName().getText().trim().contains("Name is required"));
        Assert.assertTrue("Reviewer Email Error Message is not Displaying",onReviewPage.getTxtMsg_ErrorReviewerEmail().getText().trim().contains("Email is required"));
    }

    @Then("User Verifies Close Button is available")
    public void user_Verifies_Close_Button_is_available() {
        captureScreenshot(driver, testContext, false);
       Assert.assertTrue("Cancel Link is not available",getElement(driver, getExistingLocator(driver, onReviewPage.getLink_closeMVC(), onReviewPage.getLink_closeReact(), null, null)).isDisplayed());
    }

    @Then("User Clicks Cancel Button")
    public void user_Clicks_Cancel_Button() {
        captureScreenshot(driver, testContext, false);
        clickElementByJSE(driver,onReviewPage.getBtn_Cancel());
    }

    @Then("User Clicks on {string} link")
    public void user_Clicks_on_link(String option) {
        captureScreenshot(driver, testContext, false);
        for (WebElement link:onReviewPage.getPendingRequestLinks_mvc()) {
            if(link.getAttribute("innerText").contains(option))
                clickElementByJSE(driver,link);
        }
    }

    @Then("User Clicks on Cancel button")
    public void user_Clicks_on_Cancel_button() {
        captureScreenshot(driver, testContext, false);
        clickElementByJSE(driver,onReviewPage.getBtn_cancelMessage());
    }

    @Then("User Clicks on Close link at bottom of the popup")
    public void user_Clicks_on_Close_link_at_bottom_of_the_popup() {
        captureScreenshot(driver, testContext, false);
      clickElementByJSE(driver,getElement(driver, getExistingLocator(driver, onReviewPage.getLink_closeMVC(), onReviewPage.getLink_closeReact(), null, null)));
    }

    @Then("User Verifies Review Queue Popup Heading {string}")
    public void user_Verifies_Review_Queue_Popup_Heading(String heading) {
        waitForPageToLoad(driver);
        captureScreenshot(driver, testContext, false);
        Assert.assertEquals("Popup Heading Mismatched", heading, onReviewPage.getHeading_ReviewQueuePopup().getText().trim());

    }

    @Then("User Verifies text Message in Popup")
    public void user_Varifies_text_Message_in_Popup() {
        captureScreenshot(driver, testContext, false);
        Assert.assertEquals("Message Text  Mismatched",
                testContext.getMapTestData().get("actionRemarks") + testContext.getMapTestData().get(EnumsJSONProp.NEWPRODUCTNAME.getText()),
                onReviewPage.getTxtMsg_ReviewQueuePopup().getText().trim());
    }

    @Then("User Clicks on Reply link")
    public void user_Clicks_on_Reply_link() {
        captureScreenshot(driver, testContext, false);
        clickElementByJSE(driver,onReviewPage.getLink_Reply());
    }

    @Then("User Enters Text Into Reply Text box")
    public void user_Enters_Text_Into_Reply_Text_box() {
        waitForPageToLoad(driver);
        captureScreenshot(driver, testContext, false);
        clickElementByJSE(driver,onReviewPage.getTxtBox_Reply());
        onReviewPage.getTxtBox_Reply().sendKeys(testContext.getMapTestData().get("actionRemarks") + testContext.getMapTestData().get(EnumsJSONProp.NEWPRODUCTNAME.getText()));
    }

    @Then("User Clicks on Send Button")
    public void user_Clicks_on_Send_Button() {
        captureScreenshot(driver, testContext, false);
        clickElementByJSE(driver,onReviewPage.getBtn_Send());
    }

    @Then("User Verifies Request Review and Submit Button")
    public void user_Verifies_Request_Review_and_Submit_Button() {
        captureScreenshot(driver, testContext, false);
        Assert.assertTrue("Request Review Button Did not display", getElement(driver, getExistingLocator(driver, onReviewPage.getLink_requestReviewMVC(), onReviewPage.getLink_requestReviewReact(), null, null)).isDisplayed());
        Assert.assertTrue("Submit Button Did not display", getElement(driver, getExistingLocator(driver, onReviewPage.getLink_SubmitMVC(), onReviewPage.getLink_SubmitReact(), null, null)).isDisplayed());
    }
    @Then("User clicks {string} on review page")
    public void userClicksButton(String whichButton) {
        captureScreenshot(driver, testContext, false);
        switch (whichButton) {
            case "Send Email Request":
                clickElement(driver, onReviewPage.getButtonSendEmailRequest());
                waitForPageToLoad(driver);
                break;
            default:
                throw new FLException("Invalid value for: " + whichButton);
        }
    }

    @Then("User verifies same Passcode as generated Before for {string}")
    public void user_verifies_same_Passcode_as_generated_BeforeFor(String passcode) {
        captureScreenshot(driver, testContext, false);
        Assert.assertEquals(passcode + " is not matching",testContext.getMapTestData().get(passcode),onReviewPage.getPasscode_Reviewer().getText().trim());
    }

    @Then("User Verifies Review Tab is There in Browser")
    public void user_Verifies_Review_Tab_is_There_in_Browser() {
        captureScreenshot(driver, testContext, false);
        Assert.assertTrue("Review Tab was not Visible", getElement(driver, getExistingLocator(driver, onReviewPage.getCanvas_ReviewMVC(), onReviewPage.getCanvas_ReviewReact(), null, null)).isDisplayed());
    }

    @Then("User Verifies Review Tab is not There in Browser")
    public void user_Verifies_Review_Tab_is_not_There_in_Browser() {
        captureScreenshot(driver, testContext, false);
        Assert.assertFalse("Review Tab was Visible", onReviewPage.getList_TabREVIEW().size()>0);
    }

    @Then("User Verifies Send Request To Reviewer Button is Enabled")
    public void user_Verifies_ButtonSend() {
        captureScreenshot(driver, testContext, false);
        Assert.assertTrue("Send Request To Reviewer Button was not enabled", onReviewPage.getBtn_SendRequestToReviewer().isEnabled());
    }

    @Then("User Verifies Decline E-Review Button is Disabled")
    public void user_Verifies_ButtonDecline() {
        captureScreenshot(driver, testContext, false);
        Assert.assertFalse("Decline E-Review Button was enabled", onReviewPage.getBtn_DeclineReview().isEnabled());
    }

    @Then("User verifies {string} option is selected")
    public void user_verifies_option_is_selected(String formName) {
        captureScreenshot(driver, testContext, false);
        Assert.assertTrue(formName+" was not selected", findElement(driver, String.format(CommonMethodsPage.optionsFormMenu,formName)).isSelected());
    }

    @Then("User {string} Your name TextBox")
    public void user_Your_name_TextBox(String name) {
        captureScreenshot(driver, testContext, false);
        sendKeys(driver,onReviewPage.getTxtBox_Yourname(),name);
    }

    @Then("User Verifies Decline E-Review Button is Enabled")
    public void user_Verifies_ButtonDeclineEnabled() {
        captureScreenshot(driver, testContext, false);
        Assert.assertTrue("Decline E-Review Button was enabled", onReviewPage.getBtn_DeclineReview().isEnabled());
    }

    @Then("User Verifies {string} tab number is {int}")
    public void user_Verifies_tab_number_is(String tab, Integer tabNumber) {
        captureScreenshot(driver, testContext, false);
        if(findElements(driver,String.format(onReviewPage.getTabNumber(),tab)).size() > 0)
        Assert.assertTrue(" tab Place mismatched",findElement(driver,String.format(onReviewPage.getTabNumber(),tab)).getText().contains(tabNumber.toString()));
        else {
            tabNumber = tabNumber -1;
            Assert.assertTrue(" tab Place mismatched", findElement(driver, String.format(onReviewPage.getTabNumber2(), tab)).getAttribute("id").contains(tabNumber.toString()));
        }
    }

    @Then("User verifies heading contains Application Name and It should be in {string}")
    public void user_verifies_heading_contains_Application_Name_and_It_should_be_in(String textColor) {
        captureScreenshot(driver, testContext, false);
        WebElement applicationNameOnApprovePopup = driver.findElement(By.xpath(
                "//strong[contains(text(),'Approve \""+ testContext.getMapTestData().get("newProductName") +"\"')]"));
        Assert.assertTrue("Heading id different than expected", applicationNameOnApprovePopup.isDisplayed());
        Assert.assertTrue("Text Colour was not as per expectations", applicationNameOnApprovePopup.getAttribute("class").contains(textColor));
    }
}
