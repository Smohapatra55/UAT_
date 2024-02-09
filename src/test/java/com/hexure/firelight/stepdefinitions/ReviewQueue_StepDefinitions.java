package com.hexure.firelight.stepdefinitions;

import com.hexure.firelight.libraies.Enums.EnumsJSONProp;
import com.hexure.firelight.libraies.EnumsCommon;
import com.hexure.firelight.libraies.FLException;
import com.hexure.firelight.libraies.FLUtilities;
import com.hexure.firelight.libraies.TestContext;
import com.hexure.firelight.pages.ReviewQueuePage;
import cucumber.api.java.en.Then;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.Select;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class ReviewQueue_StepDefinitions extends FLUtilities {
    private WebDriver driver;
    private ReviewQueuePage onReviewQueuePage;
    private TestContext testContext;
    private static final Logger Log = LogManager.getLogger(ReviewQueue_StepDefinitions.class);

    public ReviewQueue_StepDefinitions(TestContext context) {
        testContext = context;
        driver = context.getDriver();
        onReviewQueuePage = context.getPageObjectManager().getOnReviewQueuePage();
    }

    @Then("User selects Queue as {string}")
    public void userSelectsQueueAs(String queueName) {
        captureScreenshot(driver, testContext, false);
        waitForPageToLoad(driver);
        selectOptionFromList(driver, onReviewQueuePage.getListReviewQueue(), queueName, EnumsCommon.CLICK.getText());
    }


    @Then("User enters App Name in search box then click search Icon")
    public void userEntersAppNameInSearchBoxThenClickSearchIcon() {
        waitForPageToLoad(driver);
        captureScreenshot(driver, testContext, false);
        onReviewQueuePage.getTxtBox_Search().clear();
        onReviewQueuePage.getTxtBox_Search().sendKeys(testContext.getMapTestData().get("newProductName") + Keys.TAB);
        captureScreenshot(driver, testContext, false);
        waitForPageToLoad(driver);
        clickElementByJSE(driver,onReviewQueuePage.getBtn_searchIcon());
    }

    @Then("User clicks Review Button")
    public void userClicksReviewButton() {
        waitForPageToLoad(driver);
        captureScreenshot(driver, testContext, false);
        clickElement(driver, onReviewQueuePage.getBtn_Review());
    }

    @Then("User verifies Application should appear in review queue")
    public void userVerifiesApplicationShouldAppearInReviewQueue() {
        waitForPageToLoad(driver);
        List<WebElement> applicationNameInQueue = driver.findElements(By.xpath(
                "//strong[contains(text(),'" + testContext.getMapTestData().get("newProductName") + "')]"));
        captureScreenshot(driver, testContext, false);
        Assert.assertTrue("Application Did not Appear in Review Queue", applicationNameInQueue.size() > 0);
    }

    @Then("User verifies Application should not appear in review queue")
    public void userVerifiesApplicationShouldNotAppearInReviewQueue() {
        waitForPageToLoad(driver);
        List<WebElement> applicationNameInQueue = driver.findElements(By.xpath(
                "//strong[contains(text(),'" + testContext.getMapTestData().get("newProductName") + "')]"));
        captureScreenshot(driver, testContext, false);
        Assert.assertFalse("Application Appears in Review Queue", applicationNameInQueue.size() > 0);
    }

    @Then("User clicks Lock and Review Order")
    public void userClicksLockAndReviewOrder() {
        captureScreenshot(driver, testContext, false);
        onReviewQueuePage.getBtn_PopOk().click();
    }

    @Then("User verifies PDF {string} is generated")
    public void userVerifiesPDFIsGenerated(String fileName) {
        waitForPageToLoad(driver);
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        if (tabs.size() > 1)
            driver.switchTo().window(tabs.get(1));
//        static wait added to capture screenshot TODO - remove if not required
        try {
            Path downloadFilePath = Paths.get(EnumsCommon.ABSOLUTE_DOWNLOADFILES_PATH.getText(), fileName + ".pdf");
            new WebDriverWait(driver, 60).until(d -> downloadFilePath.toFile().exists());
            downloadFilePath.toFile().delete();

        }
        catch (Exception e) {
            Log.error("Error occured while reading pdffilename " + e.getMessage());
            throw new FLException("Error occured while reading pdffilename >>>> " + e.getMessage());
        }  finally {
            tabs = new ArrayList<>(driver.getWindowHandles());
            if (tabs.size() > 1)
                driver.close();

            driver.switchTo().window(tabs.get(0));
        }
    }

    @Then("User clicks on Approve, Then on dialog window enter your own comment and click Approve")
    public void userClicksOnApproveThenOnDialogWindowEnterYourOwnCommentAndClickApprove() {
        captureScreenshot(driver, testContext, false);
        onReviewQueuePage.getBtn_ApproveApplication().click();
        syncElement(driver, onReviewQueuePage.getTxtBox_ActionRemarks(), EnumsCommon.TOVISIBLE.getText());
        captureScreenshot(driver, testContext, false);
        onReviewQueuePage.getTxtBox_ActionRemarks().sendKeys(
                testContext.getMapTestData().get("actionRemarks") + testContext.getMapTestData().get(EnumsJSONProp.NEWPRODUCTNAME.getText()));
        captureScreenshot(driver, testContext, false);
        onReviewQueuePage.getBtn_PopOk().click();
    }

    @Then("User clicks on {string} in Left panel")
    public void userClicksOnInLeftPanel(String whichTab) {
        switch (whichTab) {
            case "History Tab":
                onReviewQueuePage.getTab_History().click();
                break;

            case "Summary":
                onReviewQueuePage.getTab_Summary().click();
                break;

            case "Reviewers Tab":
                onReviewQueuePage.getTab_Reviewers().click();
                break;

            case "Overall Report":
                onReviewQueuePage.getTab_OverallReport().click();
                break;

            case "DSB Tab":
                onReviewQueuePage.getTab_DSB().click();
                break;

            case "PreSubmit":
                onReviewQueuePage.getTab_PreSubmit().click();
                break;

            case "Reviewers Sub":
                onReviewQueuePage.getTab_PreSubmit().click();
                break;
            default:
                throw new FLException("Invalid Value Provided For Tab " + whichTab);
        }
        captureScreenshot(driver, testContext, false);
    }

    @Then("User Clicks on Application PDF Link and verify app data and signatures done by all signers")
    public void user_Clicks_on_Application_PDF_Link_and_verify_app_data_and_signatures_done_by_all_signers() throws Exception {
        //        static wait added to capture screenshot TODO - remove if not required
        clickElement(driver, onReviewQueuePage.getLink_ApplicationPDF());
        //static wait added to capture screenshot TODO - remove if not required
        sleepInMilliSeconds(1000);
        String pdfFileName = "";
        String pdfText = "";
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        if(tabs.size() > 1)
            driver.switchTo().window(tabs.get(1));
        if (configProperties.getProperty("browser").equalsIgnoreCase(EnumsCommon.FIREFOXBROWSER.getText())){
            sleepInMilliSeconds(4000);
        }
        try {
            pdfFileName = testContext.getModuleName() + "-" + testContext.getTestCaseID() + "_" + getDate("pdfFileName") + ".pdf";
            Path downloadFilePath = Paths.get(EnumsCommon.ABSOLUTE_DOWNLOADFILES_PATH.getText() + "DisplayApplication.pdf");
            new WebDriverWait(driver, 60).until(d -> downloadFilePath.toFile().exists());
            renameFile("DisplayApplication", pdfFileName);
            pdfText = getPDFText(pdfFileName);
            Log.info(pdfFileName);
       } catch (IOException e) {
            Log.error("PDF could not be found or read " + e.getMessage());
            throw new FLException("PDF file could not be found or read " + pdfFileName + ">>>> " + e.getMessage());
        }
        catch (Exception e) {
            Log.error("Error occured while reading pdffilename " + pdfFileName + " " + e.getMessage());
            throw new FLException("Error occured while reading pdffilename " + pdfFileName + ">>>> " + e.getMessage());
        } finally {
            tabs = new ArrayList<>(driver.getWindowHandles());
            if (tabs.size() > 1)
                driver.close();

            driver.switchTo().window(tabs.get(0));
        }
        Assert.assertTrue("Could not find incomeOfApplicant in PDF File ", pdfText.contains(testContext.getMapTestData().get("incomeOfApplicant")));
        Assert.assertTrue("Could not find incomeOfJointApplicant in PDF File ", pdfText.contains(testContext.getMapTestData().get("incomeOfJointApplicant")));
        Assert.assertTrue("Could not find taxOfApplicant in PDF File ", pdfText.contains(testContext.getMapTestData().get("taxOfApplicant")));
        Assert.assertTrue("Could not find taxOfJointApplicant in PDF File ", pdfText.contains(testContext.getMapTestData().get("taxOfJointApplicant")));
        Assert.assertTrue("Could not find prioritazationCapitalOfApplicant in PDF File ", pdfText.contains(testContext.getMapTestData().get("prioritazationCapitalOfApplicant")));
        Assert.assertTrue("Could not find prioritazationCapitalOfJointApplicant in PDF File ", pdfText.contains(testContext.getMapTestData().get("prioritazationCapitalOfJointApplicant")));
    }

    @Then("User Verifies Opened pdf is same as generated before")
    public void userVerifiesOpenedPdf() throws Exception {
        captureScreenshot(driver, testContext, false);
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        String pdfFileName = "";
        String pdfText = "";
        if(tabs.size() > 1)
            driver.switchTo().window(tabs.get(1));
        try {
            pdfFileName = testContext.getModuleName() + "-" + testContext.getTestCaseID() + "_" + getDate("pdfFileName") + ".pdf";
            Path downloadFilePath = Paths.get(EnumsCommon.ABSOLUTE_DOWNLOADFILES_PATH.getText() + "DisplayApplication.pdf");
            new WebDriverWait(driver, 60).until(d -> downloadFilePath.toFile().exists());
            renameFile("DisplayApplication", pdfFileName);
            pdfText = getPDFText(pdfFileName);
            Log.info(pdfFileName);
        } catch (IOException e) {
            Log.error("PDF could not be found or read " + e.getMessage());
            throw new FLException("PDF file could not be found or read " + pdfFileName + ">>>> " + e.getMessage());
        }
        catch (Exception e) {
            Log.error("Error occured while reading pdffilename " + pdfFileName + " " + e.getMessage());
            throw new FLException("Error occured while reading pdffilename " + pdfFileName + ">>>> " + e.getMessage());
        } finally {
            tabs = new ArrayList<>(driver.getWindowHandles());
            if (tabs.size() > 1)
                driver.close();

            driver.switchTo().window(tabs.get(0));
        }
        Assert.assertTrue("Could not find incomeOfApplicant in PDF File ", pdfText.contains(testContext.getMapTestData().get("incomeOfApplicant")));
        Assert.assertTrue("Could not find incomeOfJointApplicant in PDF File ", pdfText.contains(testContext.getMapTestData().get("incomeOfJointApplicant")));
        Assert.assertTrue("Could not find taxOfApplicant in PDF File ", pdfText.contains(testContext.getMapTestData().get("taxOfApplicant")));
        Assert.assertTrue("Could not find taxOfJointApplicant in PDF File ", pdfText.contains(testContext.getMapTestData().get("taxOfJointApplicant")));
        Assert.assertTrue("Could not find prioritazationCapitalOfApplicant in PDF File ", pdfText.contains(testContext.getMapTestData().get("prioritazationCapitalOfApplicant")));
        Assert.assertTrue("Could not find prioritazationCapitalOfJointApplicant in PDF File ", pdfText.contains(testContext.getMapTestData().get("prioritazationCapitalOfJointApplicant")));
    }

    @Then("User Clicks on Approve, then Click Approve on Approve Activity Dialog")
    public void user_Clicks_on_Approve_then_Click_Approve_on_Approve_Activity_Dialog() {
        driver.navigate().refresh();
        captureScreenshot(driver, testContext, false);
        clickElement(driver, onReviewQueuePage.getBtn_Approve());
        captureScreenshot(driver, testContext, false);
        clickElement(driver, onReviewQueuePage.getBtn_PopOk());
    }

    @Then("User Log Off from current Application With PopUp OK")
    public void userLogsOfffromCurrentApplicationWithPopUpOK() {
        captureScreenshot(driver, testContext, false);
        clickElement(driver, getElement(driver, getExistingLocator(driver, onReviewQueuePage.getTab_LogOffMVC(), onReviewQueuePage.getTab_LogOffReact(), null, null)));
        sleepInMilliSeconds(2000);
        clickElementByJSE(driver,onReviewQueuePage.getBtn_PopOk());
        syncElement(driver,onReviewQueuePage.getThankYouLogOffPage(),EnumsCommon.TOVISIBLE.getText());
        captureScreenshot(driver, testContext, false);
        driver.manage().deleteAllCookies();
    }

    @Then("User Logs Off from current Application")
    public void userLogOfffromCurrentApplication() {
        captureScreenshot(driver, testContext, false);
        clickElement(driver, getElement(driver, getExistingLocator(driver, onReviewQueuePage.getTab_LogOffMVC(), onReviewQueuePage.getTab_LogOffReact(), null, null)));
        syncElement(driver,onReviewQueuePage.getThankYouLogOffPage(),EnumsCommon.TOVISIBLE.getText());
        captureScreenshot(driver, testContext, false);
        driver.manage().deleteAllCookies();
    }

    @Then("User Selects Queue RQ")
    public void user_Selects_Queue_RQ_and_Search_for_our_application() {
        waitForPageToLoad(driver);
        captureScreenshot(driver, testContext, false);
        clickElement(driver, onReviewQueuePage.getRq1Queues());
    }

    @Then("User Now Clicks Reject Button, then Clicks Reject on Reject Activity Dialog")
    public void user_Now_Clicks_Reject_Button_then_Clicks_Reject_on_Reject_Activity_Dialog() {
        captureScreenshot(driver, testContext, false);
        clickElement(driver, onReviewQueuePage.getBtn_Reject());
        captureScreenshot(driver, testContext, false);
        clickElement(driver, onReviewQueuePage.getBtn_PopOk());
    }

    @Then("User Now Clicks Reject Button")
    public void user_Now_Clicks_Reject_Button() {
        captureScreenshot(driver, testContext, false);
        clickElementByJSE(driver, onReviewQueuePage.getBtn_Reject());
    }
    @Then("User navigates to Home page from review Queue page")
    public void UsernavigatesToHomePageOfReviewQueuePage() {
        captureScreenshot(driver, testContext, false);
        clickElement(driver, onReviewQueuePage.getTab_Home());
    }

    @Then("User verifies Approve, Reject, More Info Buttons are now enabled.")
    public void userVerifyApproveRejectMoreInfoButtonsAreNowEnabled() {
        captureScreenshot(driver, testContext, false);
        Assert.assertTrue("Button Approve is not showing on screen",onReviewQueuePage.getBtn_ApproveApplication().isDisplayed());
        Assert.assertTrue("Button Reject is not showing on screen",onReviewQueuePage.getBtn_RejectApplication().isDisplayed());
        Assert.assertTrue("Button More info is not showing on screen",onReviewQueuePage.getBtn_MoreInfo().isDisplayed());
    }

    @Then("User Now Verifies Reviewer Documents, Approve, Reject, More Info Buttons are now enabled")
    public void user_Now_Verifies_Reviewer_Documents_Approve_Reject_More_Info_Buttons_are_now_enabled() {
        captureScreenshot(driver, testContext, false);
        Assert.assertTrue("Reviewer Documents Button is not Enabled",getElement(driver, getExistingLocator(driver, onReviewQueuePage.getBtn_ReviewerDocumentsMVC(), onReviewQueuePage.getBtn_ReviewerDocumentsReact(), null, null)).isEnabled());
        Assert.assertTrue("Approve Button is not Enabled",onReviewQueuePage.getBtn_ApproveApplication().isEnabled());
        Assert.assertTrue("Reject Button is not Enabled",onReviewQueuePage.getBtn_RejectApplication().isEnabled());
        Assert.assertTrue("More Info Button is not Enabled",onReviewQueuePage.getBtn_MoreInfo().isEnabled());

    }

    @Then("User Clicks on Reviewer Documents Button")
    public void user_Clicks_on_Reviewer_Documents_Button() {
        captureScreenshot(driver, testContext, false);
       clickElement(driver,getElement(driver, getExistingLocator(driver, onReviewQueuePage.getBtn_ReviewerDocumentsMVC(), onReviewQueuePage.getBtn_ReviewerDocumentsReact(), null, null)));
    }

    @Then("User clicks {string} from review queue")
    public void userClickLink(String link) {
        captureScreenshot(driver, testContext, false);
        waitForPageToLoad(driver);
        switch (link) {
            case "Application PDF":
                syncElement(driver,driver.findElement(By.xpath("//a[@aria-label=\"Application PDF for '" + testContext.getMapTestData().get("newProductName") + "'\"]")), EnumsCommon.TOVISIBLE.getText());
                clickElement(driver,driver.findElement(By.xpath("//a[@aria-label=\"Application PDF for '" + testContext.getMapTestData().get("newProductName") + "'\"]")));
                break;
            case "Attach Documents":
                syncElement(driver,driver.findElement(By.xpath("//a[@aria-label=\"Attach Documents for '" + testContext.getMapTestData().get("newProductName") + "'\" or text()='Attach Documents' or @id='buttonAttachDocs']")), EnumsCommon.TOVISIBLE.getText());
                clickElement(driver,driver.findElement(By.xpath("//a[@aria-label=\"Attach Documents for '" + testContext.getMapTestData().get("newProductName") + "'\" or text()='Attach Documents' or @id='buttonAttachDocs']")));
                break;
            case "Review Application Button":
                syncElement(driver,driver.findElement(By.xpath("//input[@aria-label='Review Application Button' and @appname='" + testContext.getMapTestData().get("newProductName") + "']")), EnumsCommon.TOVISIBLE.getText());
                clickElement(driver,driver.findElement(By.xpath("//input[@aria-label='Review Application Button' and @appname='" + testContext.getMapTestData().get("newProductName") + "']")));
                break;
            case "Approve Application Button":
                syncElement(driver,driver.findElement(By.xpath("//button[@aria-label='Approve Application' and contains(@onclick,'" + testContext.getMapTestData().get("newProductName") + "')]")), EnumsCommon.TOVISIBLE.getText());
                clickElement(driver,driver.findElement(By.xpath("//button[@aria-label='Approve Application' and contains(@onclick,'" + testContext.getMapTestData().get("newProductName") + "')]")));
                break;
            case "Display/Print PDF":
                syncElement(driver,driver.findElement(By.xpath("//*[text()='Display/Print PDF' or text()='Print']")), EnumsCommon.TOVISIBLE.getText());
                clickElement(driver,driver.findElement(By.xpath("//*[text()='Display/Print PDF' or text()='Print']")));
                break;
            default:
                throw new FLException("Invalid Link " + link);
        }
    }

    @Then("User Verifies on page {string}")
    public void user_Verifies_on_page(String pageName) {
        waitForPageToLoad(driver);
        captureScreenshot(driver, testContext, false);
        Assert.assertTrue("User is not in page" + pageName, getElement(driver, getExistingLocator(driver, onReviewQueuePage.getHeading_PageMVC(), onReviewQueuePage.getHeading_PageReact(), null, null)).getText().trim().contains(pageName));
    }

    @Then("User Verifies on sub page {string}")
    public void user_Verifies_on_sub_page(String subPageName) {
        waitForPageToLoad(driver);
        captureScreenshot(driver, testContext, false);
        Assert.assertTrue("User is not in page" + subPageName, onReviewQueuePage.getHeading_SubPage().getText().trim().contains(subPageName));
    }

    @Then("User Verifies the sub page {string}")
    public void user_Verifies_the_sub_page(String subPageName) {
        waitForPageToLoad(driver);
        captureScreenshot(driver, testContext, false);
        Assert.assertTrue("User is not in page" + subPageName, onReviewQueuePage.getHeading_SubPageDocumentReview().getText().trim().contains(subPageName));
    }

    @Then("User Verifies below links in Review Queue page")
    public void user_Verifies_below_links_in_Review_Queue_page(List<String> expectedLinks) {
        waitForPageToLoad(driver);
        captureScreenshot(driver, testContext, false);
        for (int i=0;i<expectedLinks.size();i++){
            Assert.assertEquals(expectedLinks.get(i)+" Link should be ", onReviewQueuePage.getList_linksPreSubmit().get(i).getAttribute("innerText"),expectedLinks.get(i));
        }
    }

    @Then("User Verifies Review button is enabled in Review Queue page")
    public void user_Verifies_Review_button_is_enabled_in_Review_Queue_page() {
        syncElement(driver,onReviewQueuePage.getBtn_Review(),EnumsCommon.TOVISIBLE.getText());
        captureScreenshot(driver, testContext, false);
        Assert.assertTrue("Review button is not enabled",onReviewQueuePage.getBtn_Review().isEnabled());
    }

    @Then("User verifies Approve, Reject, More Info Buttons are now disabled in Review Queue page")
    public void user_verifies_Approve_Reject_More_Info_Buttons_are_now_disabled_in_Review_Queue_page() {
        captureScreenshot(driver, testContext, false);
        Assert.assertFalse("Approve button is  enabled",onReviewQueuePage.getBtn_Approve().isEnabled());
        Assert.assertFalse("Reject button is enabled",onReviewQueuePage.getBtn_Reject().isEnabled());
        Assert.assertFalse("More Info button is enabled",onReviewQueuePage.getBtn_MoreInfo().isEnabled());
    }

    @Then("User verifies Unlock, ReviewerDocuments,Approve,Reject, More Info Buttons are now enabled in Review Queue page")
    public void user_verifies_ReviewerDocuments_Approve_Reject_More_Info_Buttons_are_now_enabled_in_Review_Queue_page() {
        captureScreenshot(driver, testContext, false);
        Assert.assertTrue("Unlock button is not  enabled",onReviewQueuePage.getBtn_UnlockApplication().isEnabled());
        Assert.assertTrue("ReviewerDocuments button is not enabled",getElement(driver, getExistingLocator(driver, onReviewQueuePage.getBtn_ReviewerDocumentsMVC(), onReviewQueuePage.getBtn_ReviewerDocumentsReact(), null, null)).isEnabled());
        Assert.assertTrue("More Info button is not enabled",onReviewQueuePage.getBtn_MoreInfo().isEnabled());
        Assert.assertTrue("Approve button is not  enabled",onReviewQueuePage.getBtn_Approve().isEnabled());
        Assert.assertTrue("Reject button is not enabled",onReviewQueuePage.getBtn_Reject().isEnabled());
    }

    @Then("User Verifies popup {string}")
    public void user_Verifies_popup(String popupHeading) {
        waitForPageToLoad(driver);
        captureScreenshot(driver, testContext, false);
        if (new ArrayList<WebElement>(driver.findElements(By.id("popup_title"))).size()>0) {
            syncElement(driver,driver.findElement(By.id("popup_title")),"ToVisible");
            Assert.assertEquals("User is not in " + popupHeading, popupHeading, onReviewQueuePage.getTitlePopup().getText().trim());
        } else {
            Assert.assertTrue("User is not in " + popupHeading, onReviewQueuePage.getHeading_HistoryPopup().getText().trim().contains(popupHeading));
        }
    }

    @Then("User verifies unlock button is now enabled")
    public void user_verifies_unlock_button_is_now_enabled() {
        captureScreenshot(driver, testContext, false);
        Assert.assertTrue("unlock button is now not enabled", onReviewQueuePage.getBtn_UnlockApplication().isEnabled());
    }

    @Then("User Clicks on Approve Button")
    public void user_Clicks_on_Approve_Button() {
        captureScreenshot(driver, testContext, false);
        clickElementByJSE(driver,onReviewQueuePage.getBtn_ApproveApplication());
    }

    @Then("User Verifies {string} and Cancel Button")
    public void user_Verifies_Approve_and_Cancel_Button(String button) {
        captureScreenshot(driver, testContext, false);
        Assert.assertTrue(button + " button is not displayed", onReviewQueuePage.getBtn_PopOk().isDisplayed());
        Assert.assertTrue("cancel button is not displayed", onReviewQueuePage.getBtn_PopCancel().isDisplayed());
    }

    @Then("User on dialog window enters own comment and clicks {string} button")
    public void user_on_dialog_window_enters_own_comment_and_clicks_Approve_button(String button) {
        syncElement(driver, onReviewQueuePage.getTxtBox_ActionRemarks(), EnumsCommon.TOVISIBLE.getText());
        captureScreenshot(driver, testContext, false);
        onReviewQueuePage.getTxtBox_ActionRemarks().clear();
        onReviewQueuePage.getTxtBox_ActionRemarks().sendKeys(
                testContext.getMapTestData().get("actionRemarks") + testContext.getMapTestData().get(EnumsJSONProp.NEWPRODUCTNAME.getText()));
        captureScreenshot(driver, testContext, false);
        Assert.assertTrue(button + " is not Visible",onReviewQueuePage.getBtn_PopOk().isDisplayed());
        onReviewQueuePage.getBtn_PopOk().click();
        sleepInMilliSeconds(5000);
    }

    @Then("User Notes the activity count")
    public void user_Notes_the_activity_count() {
        captureScreenshot(driver, testContext, false);
        char str[] = onReviewQueuePage.getActivityCount().getText().trim().toCharArray();
        addPropertyValueInJSON(testContext.getTestCaseID(),testContext,EnumsJSONProp.ACTIVITYCOUNT.getText(),str[0] + "" );
    }

    @Then("User Verifies Activity count decreased by one")
    public void user_Verifies_Activity_count_decresed_by_one() {
        waitForPageToLoad(driver);
        captureScreenshot(driver, testContext, false);
        int a=Integer.parseInt(testContext.getMapTestData().get("activityCount"))-1;
        Assert.assertTrue("Activity count is not decreased by one",onReviewQueuePage.getActivityCount().getText().trim().contains(String.valueOf(a)));
    }

    @Then("User clicks on more info button")
    public void user_clicks_on_more_info_button() {
        captureScreenshot(driver, testContext, false);
        clickElementByJSE(driver,onReviewQueuePage.getBtn_MoreInfo());
    }

    @Then("User enters own comment and clicks on send")
    public void user_enters_own_comment_and_clicks_on_send() {
        onReviewQueuePage.getTxtBox_ActionRemarks().sendKeys(
                testContext.getMapTestData().get("actionRemarks") + testContext.getMapTestData().get(EnumsJSONProp.NEWPRODUCTNAME.getText()));
        captureScreenshot(driver, testContext, false);
        onReviewQueuePage.getBtn_PopOk().click();
    }

    @Then("User Verifies link {string} and info icon")
    public void user_Verifies_Text_and_info_icon(String message) {
        waitForPageToLoad(driver);
        captureScreenshot(driver, testContext, false);
        Assert.assertEquals("Red Text Message is not matching with " + message, message, onReviewQueuePage.getLinkMsg_PreSubmitSubPage().getText().trim());
        Assert.assertTrue("Info Icon is not Visible ",onReviewQueuePage.getIcon_InfoPreSubmitSubPage().isDisplayed());
    }

    @Then("User Clicks on above link")
    public void user_Clicks_on_above_link() {
        captureScreenshot(driver, testContext, false);
        clickElementByJSE(driver,onReviewQueuePage.getLinkMsg_PreSubmitSubPage());
    }

    @Then("User Verifies Custom message")
    public void user_Verifies_Custom_message() {
        captureScreenshot(driver, testContext, false);
        Assert.assertEquals("The custom message mismatched in Popup",
                testContext.getMapTestData().get("actionRemarks") + testContext.getMapTestData().get(EnumsJSONProp.NEWPRODUCTNAME.getText()),
                onReviewQueuePage.getTxt_RemarksRequestMoreInfo().getText().trim());
    }

    @Then("User Closes the Popup")
    public void user_Closes_the_Popup() {
        captureScreenshot(driver, testContext, false);
      clickElementByJSE(driver,onReviewQueuePage.getBtn_closeQueueHistory());
    }

    @Then("User lets the default message and clicks on Approve button")
    public void user_lets_the_default_message_and_clicks_on_Approve_button() {
        captureScreenshot(driver, testContext, false);
        clickElementByJSE(driver,onReviewQueuePage.getBtn_PopOk());
    }

    @Then("User lets the default message and clicks on Reject button")
    public void user_lets_the_default_message_and_clicks_on_Reject_button() {
        captureScreenshot(driver, testContext, false);
        clickElementByJSE(driver,onReviewQueuePage.getBtn_PopOk());
    }

    @Then("User clicks on {string} link in Review Queue Page")
    public void user_clicks_on_link_in_Review_Queue_Page(String option) {
        waitForPageToLoad(driver);
        captureScreenshot(driver, testContext, false);
        selectOptionFromList(driver,onReviewQueuePage.getList_linksPreSubmit(),option,EnumsCommon.CLICK.getText());
    }

    @Then("User Verifies Popup Heading As {string}")
    public void user_Verifies_Popup_Heading_As(String heading) {
        syncElement(driver,getElement(driver, getExistingLocator(driver, onReviewQueuePage.getHeading_ReviewerDocumentsMVC(), onReviewQueuePage.getHeading_ReviewerDocumentsReact(), null, null)),EnumsCommon.TOVISIBLE.getText());
        captureScreenshot(driver, testContext, false);
        Assert.assertEquals("Popup Heading is not matching ", heading, getElement(driver, getExistingLocator(driver, onReviewQueuePage.getHeading_ReviewerDocumentsMVC(), onReviewQueuePage.getHeading_ReviewerDocumentsReact(), null, null)).getText().trim());
    }

    @Then("User uploads Document in Review Queue")
    public void user_uploads_Document_in_Review_Queue() {
        captureScreenshot(driver, testContext, false);
        onReviewQueuePage.getFileDrop().sendKeys(new File(EnumsCommon.RELATIVE_DOWNLOADFILES_PATH.getText() + "E2E-TC05-pdfFile.pdf").getAbsolutePath());
    }

    @Then("User Clicks on Unlock Button On Review Queue Page")
    public void user_Clicks_on_Unlock_Button_On_Review_Queue_Page() {
        captureScreenshot(driver, testContext, false);
        clickElementByJSE(driver,onReviewQueuePage.getBtn_UnlockApplication());
    }

    @Then("User Verifies Message on Popup {string} with product name")
    public void user_Verifies_Message_on_Popup_with_product_name(String message) {
        captureScreenshot(driver, testContext, false);
        Assert.assertTrue("Message is not matching in Popup" , onReviewQueuePage.getMessageNameProduct().getText().split("\n")[0].trim().contains(message + "\"" +testContext.getMapTestData().get(EnumsJSONProp.NEWPRODUCTNAME.getText()) + "\""));
    }

    @Then("User clicks Close button for popup")
    public void user_clicks_Close_button_for_popup() {
        captureScreenshot(driver, testContext, false);
        clickElementByJSE(driver,onReviewQueuePage.getBtnCancel_FileUploadPopup());
    }

    @Then("User Verifies Button {string} and {string}")
    public void user_Verifies_Button_and(String btn_Name1, String btn_Name2) {
        captureScreenshot(driver, testContext, false);
        Assert.assertTrue(btn_Name1 + " did not displayed", onReviewQueuePage.getBtn_PopOk().getText().contains(btn_Name1));
        Assert.assertTrue(btn_Name2 + " did not displayed", onReviewQueuePage.getBtn_PopCancel().getText().contains(btn_Name2));
    }

    @Then("User Clicks on Cancel Button")
    public void user_Clicks_on_Cancel_Button() {
        captureScreenshot(driver, testContext, false);
        clickElementByJSE(driver,onReviewQueuePage.getBtn_PopCancel());
    }

    @Then("User Clicks on {string} button")
    public void user_Clicks_on_button(String btn_Name) {
        captureScreenshot(driver, testContext, false);
        clickElementByJSE(driver,onReviewQueuePage.getBtn_PopOk());
    }

    @Then("User Logs Off from the current Application and clicks {string} on Confirmation Dialog")
    public void userLogOfffromtheCurrentApplication(String button) {
        captureScreenshot(driver, testContext, false);
        clickElement(driver, getElement(driver, getExistingLocator(driver, onReviewQueuePage.getTab_LogOffMVC(), onReviewQueuePage.getTab_LogOffReact(), null, null)));
        user_Clicks_on_button(button);
        syncElement(driver,onReviewQueuePage.getThankYouLogOffPage(),EnumsCommon.TOVISIBLE.getText());
        captureScreenshot(driver, testContext, false);
        driver.manage().deleteAllCookies();
    }

    @Then("User Verifies Reviewer Comment {string}")
    public void UserVerifiesReviewerComment(String comment) {
        captureScreenshot(driver, testContext, false);
        Assert.assertTrue("Review comment mismatched", onReviewQueuePage.getTxt_ReviewerComment().getText().trim()
                .contains(testContext.getMapTestData().get(comment)) || onReviewQueuePage.getTxt_ReviewerComment()
                .getText().trim().contains(testContext.getMapTestData().get("reviewerComment")));
    }

    @Then("User Clicks On Recall Button")
    public void UserClicksOnRecallButton(){
        captureScreenshot(driver, testContext, false);
        clickElementByJSE(driver,onReviewQueuePage.getBtn_Recall());
    }

    @Then("User Verifies Application on Locked State")
    public void UserVerifiesApplicationonLockedState(){
        captureScreenshot(driver, testContext, false);
        Assert.assertEquals("Application not in Locked mode", "Locked by you", onReviewQueuePage.getMsg_Locked().getText().trim());
    }

    @Then("User Selects {string} in Select Queue Drop Down")
    public void user_Selects_in_Select_Queue_Drop_Down(String text) {
        captureScreenshot(driver, testContext, false);
        new Select(onReviewQueuePage.getDrodown_SelectQueue()).selectByVisibleText(text);
        captureScreenshot(driver, testContext, false);
    }

    @Then("User clicks on Move To Queue Button")
    public void user_clicks_on_Move_To_Queue_Button() {
        captureScreenshot(driver, testContext, false);
        clickElementByJSE(driver,onReviewQueuePage.getBtn_MoveToQueue());
    }

    @Then("User clicks on Move App Button")
    public void user_clicks_on_Move_App_Button() {
        captureScreenshot(driver, testContext, false);
        clickElementByJSE(driver,onReviewQueuePage.getBtn_PopOk());
    }

    @Then("User Selects {string} in Select Reviewer Drop Down")
    public void user_Selects_in_Select_Reviewer_Drop_Down(String text) {
        waitForPageToLoad(driver);
        captureScreenshot(driver, testContext, false);
        Select select = new Select(onReviewQueuePage.getDrodown_SelectReviewer());
        waitForPageToLoad(driver);
        select.selectByVisibleText(text);
        captureScreenshot(driver, testContext, false);
    }

    @Then("User clicks on Assign Reviewer Button")
    public void user_clicks_on_Assign_Reviewer_Button() {
        captureScreenshot(driver, testContext, false);
        clickElementByJSE(driver,onReviewQueuePage.getBtn_AssignReviewer());
    }

    @Then("User clicks on Assign Reviewer button on popup")
    public void UserclicksonAssignReviewerButtononPopup() {
        captureScreenshot(driver, testContext, false);
        clickElementByJSE(driver,onReviewQueuePage.getBtn_PopOk());
    }

    @Then("User Verifies Popup Heading As {string} in Client Verification")
    public void user_Verifies_Popup_Heading_AsInClientVerification(String heading) {
        syncElement(driver,onReviewQueuePage.getHeading_ClientVerification(),EnumsCommon.TOVISIBLE.getText());
        captureScreenshot(driver, testContext, false);
        Assert.assertEquals("Popup Heading is not matching ", heading, onReviewQueuePage.getHeading_ClientVerification().getText().trim());
    }

    @Then("User Clicks on View Button")
    public void user_Clicks_on_View_Button() {
        captureScreenshot(driver, testContext, false);
        clickElementByJSE(driver,onReviewQueuePage.getBtn_View());
    }

    @Then("User Closes Reviewer Documents Window")
    public void user_Closes_Reviewer_Documents_window() {
        captureScreenshot(driver, testContext, false);
        waitForPageToLoad(driver);
        clickElement(driver, onReviewQueuePage.getBtn_CrossReviewPopup());
    }

    @Then("User Verifies Links Present Below Reviewers Tab")
    public void user_Verifies_Links_Present_Below_Reviewers_Tab() {
        captureScreenshot(driver, testContext, false);
            for (WebElement link : onReviewQueuePage.getList_linkReviewers()) {
                Assert.assertTrue("Link not Present", link.getAttribute("href").length() > 0);
            }
    }

    @Then("User Clicks on link {string} below Reviewers Tab")
    public void user_Clicks_on_link_below_Reviewers_Tab(String formName) {
        captureScreenshot(driver, testContext, false);
        for (WebElement link : onReviewQueuePage.getList_linkReviewers()) {
            if(link.getAttribute("title").equalsIgnoreCase(formName+" ("+testContext.getCurrentTestUserName()+")")){
                clickElementByJSE(driver,link);
                break;
            }
        }
    }

    @Then("User Verifies Review button is Disabled in Review Queue page")
    public void user_Verifies_Review_button_is_Disabled_in_Review_Queue_page() {
        syncElement(driver,onReviewQueuePage.getBtn_Review(),EnumsCommon.TOVISIBLE.getText());
        captureScreenshot(driver, testContext, false);
        Assert.assertFalse("Review button was enabled",onReviewQueuePage.getBtn_Review().isEnabled());
    }

    @Then("User enters Second Application Name in search box then click search Icon")
    public void userEntersSecondApplicationNameInSearchBoxThenClickSearchIcon() {
        waitForPageToLoad(driver);
        captureScreenshot(driver, testContext, false);
        onReviewQueuePage.getTxtBox_Search().clear();
        onReviewQueuePage.getTxtBox_Search().sendKeys(testContext.getMapTestData().get("secondNewProductName") + Keys.TAB);
        captureScreenshot(driver, testContext, false);
        waitForPageToLoad(driver);
        clickElementByJSE(driver,onReviewQueuePage.getBtn_searchIcon());
    }

    @Then("User verifies Second Application should appear in review queue")
    public void userVerifiesSecondApplicationShouldAppearInReviewQueue() {
        waitForPageToLoad(driver);
        List<WebElement> applicationNameInQueue = driver.findElements(By.xpath(
                "//strong[contains(text(),'" + testContext.getMapTestData().get("secondNewProductName") + "')]"));
        captureScreenshot(driver, testContext, false);
        Assert.assertTrue("Application Did not Appear in Review Queue", applicationNameInQueue.size() > 0);
    }

    @Then("User Clicks on Review Button and Verifies same page")
    public void user_Clicks_on_Review_Button_and_Verifies_same_page() {
        captureScreenshot(driver, testContext, false);
        if (onReviewQueuePage.getBtn_Review().isEnabled()) {
            clickElementByJSE(driver, onReviewQueuePage.getBtn_Review());
            Assert.assertTrue("Continue Button was not Disabled so Click Operation Perfermed", true);
        }
    }

    @Then("User Verifies Locked Message as {string} for {string} Application")
    public void userVerifiesLockedMessageAsFor(String message, String applicationName) {
        waitForPageToLoad(driver);
        captureScreenshot(driver, testContext, false);
        switch (applicationName.toLowerCase()) {
            case "first":
                Assert.assertTrue(message + " did not match", findElement(driver,
                        String.format(onReviewQueuePage.getMsg_LockReviewPage(), testContext.getMapTestData().
                                get(EnumsJSONProp.NEWPRODUCTNAME.getText()))).getText().trim().contains(message));
                break;
            case "second":
                Assert.assertTrue(message + " did not match", findElement(driver,
                        String.format(onReviewQueuePage.getMsg_LockReviewPage(), testContext.getMapTestData().
                                get(EnumsJSONProp.SECONDNEWPRODUCTNAME.getText()))).getText().trim().contains(message));
                break;
        }
    }

    @Then("User verifies Second Application should not appear in review queue")
    public void userVerifiesSecondApplicationShouldNotAppearInReviewQueue() {
        waitForPageToLoad(driver);
        List<WebElement> applicationNameInQueue = driver.findElements(By.xpath(
                "//strong[contains(text(),'" + testContext.getMapTestData().get("secondNewProductName") + "')]"));
        captureScreenshot(driver, testContext, false);
        Assert.assertFalse("Application Did not Appear in Review Queue", applicationNameInQueue.size() > 0);
    }

    @Then("User Verifies Message on Popup {string} with Second product name")
    public void user_Verifies_Message_on_Popup_with_Second_product_name(String message) {
        captureScreenshot(driver, testContext, false);
        Assert.assertTrue("Message is not matching in Popup" , onReviewQueuePage.getMessageNameProduct().getText().split("\n")[0].trim().contains(message + "\"" +testContext.getMapTestData().get(EnumsJSONProp.SECONDNEWPRODUCTNAME.getText()) + "\""));
    }

    @Then("User Verifies Popup Heading Activity Summary {string}")
    public void user_Verifies_Popup_Heading_ActivitySummary(String time) {
        captureScreenshot(driver, testContext, false);
        switch (time){
            case "First Time":
                Assert.assertEquals("Popup Heading is not matching ","Activity Summary",onReviewQueuePage.getHeading_ActivitySummary1().getAttribute("innerText").trim());
                break;
            case "Second Time":
            case "Third Time":
                Assert.assertEquals("Popup Heading is not matching ","Activity Summary",onReviewQueuePage.getHeading_ActivitySummary2().getAttribute("innerText").trim());
                break;
            case "Fourth Time":
                Assert.assertEquals("Popup Heading is not matching ","Activity Summary",onReviewQueuePage.getHeading_ActivitySummary3().getAttribute("innerText").trim());
                break;
            default:
                throw new FLException("Invalid Input for no of time: "+time);
        }

    }

    @Then("User Clicks on Icon Cross in Activity Summary {string}")
    public void user_Clicks_Popup_Heading_ActivitySummaryCross(String time) {
        captureScreenshot(driver, testContext, false);
        switch (time){
            case "First Time":
                clickElementByJSE(driver,onReviewQueuePage.getIcon_CrossActivitySummary1());
                break;
            case "Second Time":
            case "Third Time":
                clickElementByJSE(driver,onReviewQueuePage.getIcon_CrossActivitySummary2());
                break;
            case "Fourth Time":
                clickElementByJSE(driver,onReviewQueuePage.getIcon_CrossActivitySummary3());
                break;
            default:
                throw new FLException("Invalid Input for no of time: "+time);
        }
    }

    @Then("User verifies Approve button is now enabled")
    public void user_verifies_Approve_button_is_now_enabled() {
        captureScreenshot(driver, testContext, false);
        Assert.assertTrue("Approve button is not enabled",onReviewQueuePage.getBtn_Approve().isEnabled());
    }

    @Then("User Verifies Search Error Message as {string}")
    public void user_Verifies_Search_Error_Message_as(String message) {
        captureScreenshot(driver, testContext, false);
        Assert.assertEquals(message + " Not matched",message,onReviewQueuePage.getMsg_SearchError().getText().trim());
    }

    @Then("User Stores the First Application Name")
    public void user_Stores_the_Application_Name() {
        captureScreenshot(driver, testContext, false);
        waitForPageToLoad(driver);
        for (WebElement application : onReviewQueuePage.getList_ApplicationName()) {
            if (application.getText().trim().contains("Income Choice") && !(application.getText().trim().contains("Income Choice Wizard"))) {
                addPropertyValueInJSON(testContext.getTestCaseID(), testContext, EnumsJSONProp.NEWPRODUCTNAME.getText(), application.getText().trim());
                break;
            } else if (application.getText().trim().contains("Firm Product Wizard")) {
                addPropertyValueInJSON(testContext.getTestCaseID(), testContext, EnumsJSONProp.NEWPRODUCTNAME.getText(), application.getText().trim());
                break;
            }
        }
    }

    @Then("User Clicks on Last page of Pagination")
    public void user_Clicks_on_Last_page_of_Pagination() {
        captureScreenshot(driver, testContext, false);
        clickElementByJSE(driver,onReviewQueuePage.getList_PaginationLink().get(onReviewQueuePage.getList_PaginationLink().size()-2));
    }

    @Then("User Stores the last Application Name")
    public void user_Stores_theLast_Application_Name() {
        captureScreenshot(driver, testContext, false);
        addPropertyValueInJSON(testContext.getTestCaseID(), testContext, EnumsJSONProp.NEWPRODUCTNAME.getText(), onReviewQueuePage.getList_ApplicationName().get(onReviewQueuePage.getList_ApplicationName().size()-1).getText().trim());
    }

    @Then("User Now Verifies Reviewer Documents, Approve, Reject, More Info Buttons are now Disabled")
    public void user_Now_Verifies_Reviewer_Documents_Approve_Reject_More_Info_Buttons_are_now_Disabled() {
        waitForPageToLoad(driver);
        captureScreenshot(driver, testContext, false);
        Assert.assertFalse("Reviewer Documents Button is  Enabled",getElement(driver, getExistingLocator(driver, onReviewQueuePage.getBtn_ReviewerDocumentsMVC(), onReviewQueuePage.getBtn_ReviewerDocumentsReact(), null, null)).isEnabled());
        Assert.assertFalse("Approve Button is Enabled",onReviewQueuePage.getBtn_ApproveApplication().isEnabled());
        Assert.assertFalse("Reject Button is Enabled",onReviewQueuePage.getBtn_RejectApplication().isEnabled());
        Assert.assertFalse("More Info Button Enabled",onReviewQueuePage.getBtn_MoreInfo().isEnabled());
    }

    @Then("User Verifies Reviewer FirstName {string}")
    public void UserVerifiesFirstName(String comment) {
        captureScreenshot(driver, testContext, false);
        Assert.assertTrue("Reviewer FirstName mismatched", onReviewQueuePage.getTxt_ReviewerFirstName().getText().trim()
                .contains(testContext.getMapTestData().get(comment)) );
    }
    @Then("User Verifies Reviewer Name {string}")
    public void UserVerifiesReviewerName(String comment) {
        captureScreenshot(driver, testContext, false);
        Assert.assertTrue("Reviewer Name mismatched", onReviewQueuePage.getTxt_ReviewerName().getText().trim()
                .contains(testContext.getMapTestData().get(comment)) );
    }

    @Then("User Verifies Master Check Box is Selected")
    public void user_Verifies_Master_Check_Box_is_Selected() {
        captureScreenshot(driver, testContext, false);
        Assert.assertTrue("Master Check Box was not Selected", onReviewQueuePage.getChkbox_Master().getAttribute("class").contains("largeCheck"));
    }

    @Then("User Clears Search Box")
    public void user_Clears_Search_Box() {
        captureScreenshot(driver, testContext, false);
        clickElementByJSE(driver,onReviewQueuePage.getIcon_clear());
    }

    @Then("User Verifies Message on Popup {string} in Queue")
    public void user_Verifies_Message_on_Popup_in_queue(String message) {
        captureScreenshot(driver, testContext, false);
        Assert.assertTrue("Message is not matching in Popup" , onReviewQueuePage.getMessageNameProduct().getText().trim().contains(message));
    }
    @Then("User click on the Review Queue button with title {string}")
    public void clickOnReviewQueButton(String buttonTitle) {
        // Find the Review Que button by its title
        WebElement reviewQueButton = driver.findElement(By.xpath("//a[contains(@title,'" + buttonTitle + "')]"));
        // Click on the Review Que button
       clickElement(driver,reviewQueButton);
    }

    @Then("User Verifies app showing in pre submit list")
    public void userVerifiesAppShowingInPreSubmitList() {
        waitForPageToLoad(driver);
        captureScreenshot(driver, testContext, false);
        Assert.assertTrue("Application is not showing",driver.findElements(By.xpath("//strong[contains(text(),'" + testContext.getMapTestData().get("newProductName") + "')]")).size()==1);
    }

    @Then("User Verifies app not showing in pre submit list")
    public void userVerifiesAppNotShowingInPreSubmitList() {
        waitForPageToLoad(driver);
        captureScreenshot(driver, testContext, false);
        Assert.assertTrue("Application is showing",driver.findElements(By.xpath("//strong[contains(text(),'" + testContext.getMapTestData().get("newProductName") + "')]")).size()==0);
    }
    @Then("User verifies that the link {string} is {string}")
    public void verifyLinkStatus(String ariaLabel, String status) {
        captureScreenshot(driver, testContext, false);
        WebElement linkElement = driver.findElement(By.xpath("//strong[text()='"+testContext.getMapTestData().get("newProductName")+"']/../..//a[text()='" + ariaLabel + "']"));

        if (status.equalsIgnoreCase("enabled")) {
            Assert.assertTrue("Link is expected to be enabled but is not.", linkElement.isEnabled());
        } else if (status.equalsIgnoreCase("disabled")) {
            Assert.assertFalse("Link is expected to be disabled but is not.", linkElement.isEnabled());
        } else {
            throw new FLException("Invalid link status: " + status);
        }
    }

    @Then("User verifies application status should be {string} in pre-submit")
    public void verifyApplicationStatus(String status) {
        captureScreenshot(driver, testContext, false);
        String xpathExpression = "//*[text()='"+testContext.getMapTestData().get("newProductName")+"'][//*[@class='red' and text()='"+status+"']]";
        Assert.assertTrue("Application status is not 'In Data Entry Review'", driver.findElement(By.xpath(xpathExpression)).isDisplayed());
    }

    @Then("User clicks on review queue application button {string}")
    public void clickAppButton(String button) {
        waitForPageToLoad(driver);
        captureScreenshot(driver, testContext, false);
        String xpathExpression = "//*[text()='"+testContext.getMapTestData().get("newProductName")+"']/../../..//*[@value='"+button+"' or contains(@aria-label,'"+button+"')]";
         driver.findElement(By.xpath(xpathExpression)).click();

    }

    @Then("User verifies warning message should be displayed with application details {string}")
    public void verifyApplicationMessage(String expectedMessage) {
        captureScreenshot(driver, testContext, false);
        String xpathExpression = "//*[@id='popup_message']/strong[contains(@class, 'red')]";
        WebElement messageElement = driver.findElement(By.xpath(xpathExpression));
        Assert.assertTrue("Warning message is not displayed", messageElement.isDisplayed());
        String actualMessage = messageElement.getText().trim();
        Assert.assertEquals("Unexpected warning message", String.format(expectedMessage,testContext.getMapTestData().get("newProductName")), actualMessage);
    }

    @Then("User verifies {string} button should be {string}")
    public void verifyButtonStatus(String buttonLabel, String status) {
        waitForPageToLoad(driver);
        String xpathExpression = "(//button[contains(@aria-label, '" + buttonLabel + "')][//*[text()='"+testContext.getMapTestData().get("newProductName")+"']])[1]";
        List<WebElement> buttonElement = driver.findElements(By.xpath(xpathExpression));

        // Check if the button is enabled or disabled
        if (status.equalsIgnoreCase("enabled")) {
            Assert.assertFalse("Button is not enabled", buttonElement.get(0).getAttribute("disabled") != null && !buttonElement.get(0).getAttribute("disabled").equals("disabled"));
        } else if (status.equalsIgnoreCase("disabled")) {
            Assert.assertFalse("Button is not disabled", buttonElement.get(0).getAttribute("disabled").equals("disabled"));
        }else if (status.equalsIgnoreCase("present")) {
            Assert.assertTrue("Button is expected to be present, but it is not.",buttonElement.size()==1);
        } else if (status.equalsIgnoreCase("not present")) {
            Assert.assertTrue("Button is expected to be present, but it is not.",buttonElement.size()==0);
        }else {
            throw new FLException("Invalid status. Use 'enabled' or 'disabled'.");
        }
    }

    @Then("User on Approve Activity dialog window enters own comment and clicks {string} button")
    public void userEntersOwnMessage(String button) {
        syncElement(driver, onReviewQueuePage.getTxtBox_ActionRemarks(), EnumsCommon.TOVISIBLE.getText());
        captureScreenshot(driver, testContext, false);
        String actionRemark= onReviewQueuePage.getTxtBox_ActionRemarks()+testContext.getMapTestData().get("newProductName");
        onReviewQueuePage.getTxtBox_ActionRemarks().clear();
        onReviewQueuePage.getTxtBox_ActionRemarks().sendKeys(actionRemark);
        captureScreenshot(driver, testContext, false);
        Assert.assertTrue(button + " is not Visible",onReviewQueuePage.getBtn_PopOk().isDisplayed());
        onReviewQueuePage.getBtn_PopOk().click();
    }

    @Then("User verifies Activity is cancelled and no longer available {string} should contain the text:")
    public void theHTMLTagWithIdShouldContainTheText(String expectedText) {
        waitForPageToLoad(driver);
        WebElement element = driver.findElement(By.xpath("//*[@id=\"divDERAppRejectedMessage\"]//b"));
        String actualText = element.getAttribute("innerText");
        Assert.assertTrue("Expected text not found on pop up", actualText.contains(expectedText));
    }

    @Then("User Verifies Master Check Box is not Displayed")
    public void user_Verifies_Master_Check_Box_isnotDisplayed() {
        waitForPageToLoad(driver);
        captureScreenshot(driver, testContext, false);
        Assert.assertFalse("Master Check Box was displayed", onReviewQueuePage.getList_ChkboxMaster().size() > 0);
    }

    @Then("User verifies Approve button is now Disabled")
    public void user_verifies_Approve_button_is_now_Disabled() {
        waitForPageToLoad(driver);
        captureScreenshot(driver, testContext, false);
        Assert.assertTrue("Approve button is enabled",onReviewQueuePage.getBtn_Approve().getAttribute("class").contains("disabled"));
    }

    @Then("User verifies ReviewerDocuments Button is enabled in Review Queue page")
    public void user_verifies_ReviewerDocumentsButton_is_now_enabled_in_Review_Queue_page() {
        captureScreenshot(driver, testContext, false);
        Assert.assertTrue("ReviewerDocuments button is not enabled",getElement(driver, getExistingLocator(driver, onReviewQueuePage.getBtn_ReviewerDocumentsMVC(), onReviewQueuePage.getBtn_ReviewerDocumentsReact(), null, null)).isEnabled());
    }

    @Then("User verifies Reject Button is enabled in Review Queue page")
    public void user_verifies_RejectButton_is_now_enabled_in_Review_Queue_page() {
        captureScreenshot(driver, testContext, false);
        Assert.assertTrue("ReviewerDocuments button is not enabled",getElement(driver, getExistingLocator(driver, onReviewQueuePage.getBtn_ReviewerDocumentsMVC(), onReviewQueuePage.getBtn_ReviewerDocumentsReact(), null, null)).isEnabled());
    }

    @Then("User Verifies Recall Button displayed")
    public void UserClicksOnRecallButtondisplayed(){
        captureScreenshot(driver, testContext, false);
        Assert.assertTrue("Recall Button was not displayed" , onReviewQueuePage.getBtn_Recall().isDisplayed());
    }

    @Then("User Clicks on RQ1 option under Queues")
    public void user_Clicks_on_RQ1_option_under_Queues() {
        captureScreenshot(driver, testContext, false);
        clickElementByJSE(driver, onReviewQueuePage.getLink_RQ1());
    }

    @Then("User note text from {string} in {string} property")
    public void addProperty(String status, String property) {
        captureScreenshot(driver, testContext, false);
        if(status.equalsIgnoreCase("URL"))
            addPropertyValueInJSON(testContext.getTestCaseID(), testContext, property, driver.getCurrentUrl().substring(driver.getCurrentUrl().indexOf("AppGuid="), driver.getCurrentUrl().indexOf("&Record")).replace("AppGuid=","") + " ");
        else
            addPropertyValueInJSON(testContext.getTestCaseID(), testContext, property, onReviewQueuePage.getTxt_RedStatus().getText());
    }
    @Then("User Verifies below links are not showing in Review Queue page")
    public void user_Verifies_below_linkslinksarenotshowing_in_Review_Queue_page(List<String> expectedLinks) {
        waitForPageToLoad(driver);
        captureScreenshot(driver, testContext, false);
        for (int i=0;i<expectedLinks.size();i++){
            if( onReviewQueuePage.getList_linksPreSubmit().get(i).getAttribute("innerText").contains(expectedLinks.get(i))){
                Assert.fail(expectedLinks.get(i) + " is Shown in List");
            }
        }
    }

    @Then("User verifies total items showing & it's in {string}")
    public void user_verifies_total_items_showing_it_s_in_red(String colour) {
        Assert.assertTrue("Total item text is not present", !onReviewQueuePage.getValue_Colour().getText().isEmpty());
        Assert.assertTrue("Text colour mismatched", onReviewQueuePage.getValue_Colour().getAttribute("class").contains(colour));
    }

    @Then("User verifies {string} items {string}")
    public void user_verifies_items(String itemCount, String action) {
        switch (action) {
            case "showing":
                Assert.assertTrue("Item conut mismatched", onReviewQueuePage.getValue_Colour().getText().contains(itemCount));
                break;
        }
    }

    @Then("User verifies {string} is {string}")
    public void user_verifies_is(String text, String action) {
        for(WebElement productContent: findElements(driver, String.format(onReviewQueuePage.list_productContent, text))) {
            switch (action) {
                case "displayed":
                    Assert.assertTrue("text mismatched", productContent.getText().contains(text));
                    break;
            }
        }
    }
    @Then("Then User verifies showing & it's in {string}")
    public void user_verifies_showing__it_s_in(String colour) {
        Assert.assertTrue("Total item text is not present", !onReviewQueuePage.getValue_Colour().getText().isEmpty());
        Assert.assertTrue("Text colour mismatched", onReviewQueuePage.getValue_Colour().getAttribute("class").contains(colour));
    }

    @Then("User Extracts the {string} Link and Stores PDF name")
    public void user_Extracts_the_Link_and_Stores_PDF_name(String eLink) {
        waitForPageToLoad(driver);
        captureScreenshot(driver, testContext, false);
        for (WebElement link : onReviewQueuePage.getList_linksPreSubmit()) {
            if (link.getText().trim().equalsIgnoreCase(eLink)) {
                String pdfName = link.getAttribute("href");
                pdfName = pdfName.substring(pdfName.indexOf("ViewDocument/") + 13);
                testContext.setPdfName(pdfName);
            }
        }
    }

    @Then("User Now Clicks Reject Button for {string}")
    public void user_Now_Clicks_Reject_ButtonFor(String appName) {
        captureScreenshot(driver, testContext, false);
        clickElement(driver,findElement(driver,String.format(onReviewQueuePage.getBtnRejectWithAppName(),testContext.getMapTestData().get(appName))));
    }

    @Then("User Now Clicks Reviewer Documents Button for {string}")
    public void user_Now_Clicks_ReviewerDocuments_ButtonForApprove(String appName) {
        waitForPageToLoad(driver);
        captureScreenshot(driver, testContext, false);
        clickElement(driver,findElement(driver,String.format(onReviewQueuePage.getBtnReviewerWithAppName(),testContext.getMapTestData().get(appName))));
    }

    @Then("User Notes the activity count from Page")
    public void user_Notes_the_activity_countFromPage() {
        waitForPageToLoad(driver);
        captureScreenshot(driver, testContext, false);
        String activityCount = onReviewQueuePage.getActivityCount().getText().trim();
        activityCount = activityCount.substring(0,activityCount.indexOf(' '));
        addPropertyValueInJSON(testContext.getTestCaseID(),testContext,EnumsJSONProp.ACTIVITYCOUNT.getText(),activityCount );
    }

    @Then("User Verifies Activity count decreased by {int}")
    public void user_Verifies_Activity_count_decresed_by(int activityCount) {
        waitForPageToLoad(driver);
        captureScreenshot(driver, testContext, false);
        int eActivityCount=Integer.parseInt(testContext.getMapTestData().get("activityCount"))-activityCount;
        Assert.assertTrue("Activity count is not decreased by "+activityCount,onReviewQueuePage.getActivityCount().getText().trim().contains(String.valueOf(eActivityCount)));
    }

    @Then("User Verifies the same activity")
    public void user_Verifies_the_activity_count() {
        waitForPageToLoad(driver);
        captureScreenshot(driver, testContext, false);
        String activityCount = onReviewQueuePage.getActivityCount().getText().trim();
        activityCount = activityCount.substring(0,activityCount.indexOf(' '));
        addPropertyValueInJSON(testContext.getTestCaseID(),testContext,EnumsJSONProp.ACTIVITYCOUNT.getText(),activityCount );
    }

    @Then("User Verifies Activity count as {int}")
    public void user_Verifies_Activity_count_as(int activityCount) {
        waitForPageToLoad(driver);
        captureScreenshot(driver, testContext, false);
        Assert.assertTrue("Activity count was not : "+activityCount,onReviewQueuePage.getActivityCount().getText().trim().contains(String.valueOf(activityCount)));
    }

    @Then("User Verifies Application Name in search box {string}")
    public void userVerifiesApplicationNameInSearchBox(String appname) {
        waitForPageToLoad(driver);
        captureScreenshot(driver, testContext, false);
       Assert.assertTrue("application Name in Search Text Box Mismatched",onReviewQueuePage.getTxtBox_SearchHidden().getAttribute("value").contains(testContext.getMapTestData().get(appname)));
    }

    @Then("User Verifies below parameters in Review Queue page")
    public void user_Verifies_below_parameters_in_Review_Queue_page(List<String> expectedLinks) {
        waitForPageToLoad(driver);
        captureScreenshot(driver, testContext, false);
        for (int i=0;i<expectedLinks.size();i++){
            Assert.assertTrue(expectedLinks.get(i)+" parameter should be ", onReviewQueuePage.getText_leftParameters().getAttribute("innerText").contains(expectedLinks.get(i)));
        }
    }

    @Then("User Enters Optional Note as {string}")
    public void user_Enters_Optional_Note_As(String message) {
        captureScreenshot(driver, testContext, false);
        sendKeys(driver, onReviewQueuePage.getTxtBox_ActionRemarks(), message);
    }
    @Then("User verifies pop message {string} disappears")
    public void user_verifies_pop_message_disappears(String message) {
        captureScreenshot(driver, testContext, false);
        Assert.assertFalse(message+"Popup was not disappeared",(driver.findElements(By.id("popup_title"))).size()>0);

    }
    @Then("User should be able to edit the default message by sending {string}")
    public void user_should_edit_default_message(String message) {
        captureScreenshot(driver, testContext, false);
        try {
            sendKeys(driver, onReviewQueuePage.getTxtBox_ActionRemarks(), message);
            }
        catch(Exception e) {
            Assert.fail("Default message is not Editable");
            }
    }
    @Then("User Verify the Default message {string}")
    public void user_Verify_default_message(String message) {
        captureScreenshot(driver, testContext, false);
        Assert.assertTrue("Default message Mismatched", onReviewQueuePage.getTxtBox_ActionRemarks().getText().contains(message));

    }

    @Then("User Verifies Field {string} is read only")
    public void user_Verifies_Field_is_read_only(String field) {
        captureScreenshot(driver, testContext, false);
        boolean notreadonly = true;
            try {
                findElement(driver, String.format(onReviewQueuePage.getTabById(), field)).sendKeys("Editable");
                notreadonly =  findElement(driver, String.format(onReviewQueuePage.getTabById(), field)).getText().trim().contains("Editable");
            } catch (Exception e) {
                notreadonly = false;
            }
        Assert.assertFalse(field + " was not Read only",notreadonly);
    }


}