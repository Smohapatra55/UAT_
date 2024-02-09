package com.hexure.firelight.stepdefinitions;

import com.hexure.firelight.libraies.EnumsCommon;
import com.hexure.firelight.libraies.FLUtilities;
import com.hexure.firelight.libraies.TestContext;
import com.hexure.firelight.pages.HistoryPopupPage;
import cucumber.api.java.en.Then;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class HistoryPopup_StepDefinitions extends FLUtilities
{
    private WebDriver driver;
    private HistoryPopupPage onHistoryPopupPage;
    private TestContext testContext;
    private static final Logger Log = LogManager.getLogger(HistoryPopup_StepDefinitions.class);
    String txtHistory = "";
    public HistoryPopup_StepDefinitions(TestContext context)
    {
        testContext = context;
        driver = context.getDriver();
        onHistoryPopupPage = context.getPageObjectManager().getHistoryPopupPage();
    }

    @Then("User verifies {string} Audit, and verify other Audits like {string}, {string}")
    public void CompleteAuditESignatureDeclineReviewComplte(String completeStatus,String ESignstatus,String reviewStatus){
        captureScreenshot(driver, testContext, false);
        Assert.assertEquals("Complete section status is incomplete ",onHistoryPopupPage.getTxt_CompleteSectionTitle().getText().trim(),completeStatus);
        Assert.assertEquals("Review section status is incomplete ",onHistoryPopupPage.getTxt_ReviewSectionStatus().getText().trim(),reviewStatus);
        Assert.assertEquals("E-Signature section status is undeclined ",onHistoryPopupPage.getTxt_Status_ESignatureSection().getText().trim(),ESignstatus);
    }

    @Then("Verifies Application Status as complete")
    public void CompleteAuditESignatureDeclineReviewComplte(){
        captureScreenshot(driver, testContext, false);
        Assert.assertEquals("Application status is mismatched",onHistoryPopupPage.getTxt_ApplicationNameWithStatus().getText().trim(),
                "Activity `" + testContext.getMapTestData().get("newProductName") + "` is complete.");
    }

    @Then("User verify audit entries contains {string} on history dialog")
    public void verifyAuditEntries(String entries){
        waitForPageToLoad(driver);
        captureScreenshot(driver, testContext, false);
        String[] entryList = entries.split(",");
        String[] replacement = new String[]{"newProductName","signerFullName"};
        syncElement(driver, onHistoryPopupPage.getTxt_HistoryContent(), EnumsCommon.TOVISIBLE.getText());
        txtHistory = onHistoryPopupPage.getTxt_HistoryContent().getText().trim();
        for (String entry : entryList) {
            for(String replace : replacement) {
                if(entry.contains(replace))
                    entry = entry.replaceAll(replace, testContext.getMapTestData().get(replace));
            }
            Assert.assertTrue("Audit entries does not contain " + entry, txtHistory.contains(entry));
        }
        onHistoryPopupPage.getBtn_CloseHistoryDialog().click();
    }

    @Then("User verify audit entries does not contain {string} on history dialog")
    public void verifyNoAuditEntries(String entries){
        captureScreenshot(driver, testContext, false);
        String[] entryList = entries.split(",");
        txtHistory = onHistoryPopupPage.getTxt_HistoryContent().getText().trim();
        for (String entry : entryList) {
            Assert.assertFalse("Audit entries contains " + entry, txtHistory.contains(entry));
        }
        onHistoryPopupPage.getBtn_CloseHistoryDialog().click();
    }

    @Then("User verify audit entries contains {string} with variables {string} on history dialog")
    public void CompleteAuditESignatureDeclineReviewComplte(String entry, String variables){
        captureScreenshot(driver, testContext, false);
        String[] replacementList = variables.split(",");
        for (String replacement : replacementList)
            entry = entry.replace(replacement, testContext.getMapTestData().get(replacement));
        Assert.assertTrue("Audit entries does not contain " + entry, txtHistory.contains(entry));
    }

    @Then("User clicks cross button")
    public void user_clicks_cross_button() {
        captureScreenshot(driver, testContext, false);
        clickElementByJSE(driver,onHistoryPopupPage.getBtn_CloseHistoryDialog());
    }

    @Then("User verifies in History showing entry for {string} request")
    public void userVerifiesInHistoryShowingEntryForPendingRequest(String pendingHeader) {
        captureScreenshot(driver, testContext, false);
        Assert.assertTrue("Pending request does not contain.",onHistoryPopupPage.getTxt_statusHeader().getText().trim().contains(pendingHeader));
        clickElementByJSE(driver,onHistoryPopupPage.getTab_historyCloseButton());
    }

    @Then("User Verifies Jurisdiction audit message showing {string}")
    public void user_Verifies_Jurisdiction_audit_message_showing(String auditHistoryMsg) {
        captureScreenshot(driver, testContext, false);
        Assert.assertTrue("Audit message did not contain: "+ auditHistoryMsg,onHistoryPopupPage.getMsg_JurisExceeded().getText().trim().contains(auditHistoryMsg));
    }

    @Then("User Verifies Max Attempt audit message detail showing {string}")
    public void user_Verifies_Max_Attempt_audit_message_detail_showing(String auditHistoryMsgDetail) {
        captureScreenshot(driver, testContext, false);
        Assert.assertTrue("Audit message details did not contain: "+ auditHistoryMsgDetail,onHistoryPopupPage.getMsg_MaxAttempt().getText().trim().contains(auditHistoryMsgDetail));
    }

    @Then("User Verifies Invalid Jurisdiction audit message showing {string}")
    public void user_Verifies_Invalid_Jurisdiction_audit_message_showing(String auditHistoryMsg) {
        captureScreenshot(driver, testContext, false);
        Assert.assertTrue("Audit message did not contain: "+ auditHistoryMsg,onHistoryPopupPage.getMsg_InvalidJurisdiction().getText().trim().contains(auditHistoryMsg));
    }

    @Then("User Verifies Jurisdiction Mismatch audit message detail showing {string}")
    public void user_Verifies_Jurisdiction_Mismatch_audit_message_detail_showing(String auditHistoryMsgDetail) {
        captureScreenshot(driver, testContext, false);
        Assert.assertTrue("Audit message details did not contain: "+ auditHistoryMsgDetail,onHistoryPopupPage.getMsg_JurisdictionMismatch().getText().trim().contains(auditHistoryMsgDetail));
    }

}
