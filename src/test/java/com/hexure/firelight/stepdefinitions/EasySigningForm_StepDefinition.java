package com.hexure.firelight.stepdefinitions;

import com.hexure.firelight.libraies.Enums.EnumsJSONProp;
import com.hexure.firelight.libraies.EnumsCommon;
import com.hexure.firelight.libraies.FLException;
import com.hexure.firelight.libraies.FLUtilities;
import com.hexure.firelight.libraies.TestContext;
import com.hexure.firelight.pages.EasySigningFormPage;
import cucumber.api.java.en.Then;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class EasySigningForm_StepDefinition extends FLUtilities {
    private WebDriver driver;
    private EasySigningFormPage onEasySigningFormPage;
    private TestContext testContext;
    private static final Logger Log = LogManager.getLogger(EasySigningForm_StepDefinition.class);

    public EasySigningForm_StepDefinition(TestContext context) {
        testContext = context;
        driver = context.getDriver();
        onEasySigningFormPage = context.getPageObjectManager().getEasySigningFormPage();
    }

    @Then("User Enters any text Applicant , Joint Applicant Grid, and select any percentage values in any dropdowns showing on page")
    public void user_Enters_any_text_Applicant_Joint_Applicant_Grid_and_select_any_percentage_values_in_any_dropdowns_showing_on_page() {
        captureScreenshot(driver, testContext, false);
        onEasySigningFormPage.getTxtBoxIncomeOfApplicant().sendKeys(testContext.getMapTestData().get("incomeOfApplicant"));
        onEasySigningFormPage.getTxtBoxIncomeOfJointApplicant().sendKeys(testContext.getMapTestData().get("incomeOfJointApplicant"));
        new Select(onEasySigningFormPage.getSelectList_TaxOfApplicant()).selectByVisibleText(testContext.getMapTestData().get("taxOfApplicant"));
        new Select(onEasySigningFormPage.getSelectList_TaxOfJointApplicant()).selectByVisibleText(testContext.getMapTestData().get("taxOfJointApplicant"));
        new Select(onEasySigningFormPage.getSelectList_prioritazationCapitalOfApplicant()).selectByVisibleText(testContext.getMapTestData().get("prioritazationCapitalOfApplicant"));
        new Select(onEasySigningFormPage.getSelectList_prioritazationCapitalOfJointApplicant()).selectByVisibleText(testContext.getMapTestData().get("prioritazationCapitalOfJointApplicant"));
    }

    @Then("User Clicks on DisplayPrint PDF, verifies the entered text in PDF")
    public void user_Clicks_on_Display_Print_PDF_verifies_the_enetered_text_in_PDF() throws Exception {
        clickElement(driver, onEasySigningFormPage.getBtn_displayPrintPdf());
        //static wait added to wait for pdf tab TODO - remove if not required
        sleepInMilliSeconds(2000);
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        if (tabs.size() > 1)
            driver.switchTo().window(tabs.get(1));
        if (configProperties.getProperty("browser").equalsIgnoreCase(EnumsCommon.FIREFOXBROWSER.getText())){
            sleepInMilliSeconds(4000);
        }
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

    @Then("User Clicks on Attach Document and Upload any document on Documents page")
    public void user_Clicks_on_Attach_Document_and_Upload_any_document_on_Documents_page() {
        captureScreenshot(driver, testContext, false);
        clickElement(driver, onEasySigningFormPage.getBtn_attachDocuments());
        //TODO: Remove Hardcoded Path
        onEasySigningFormPage.getFileDrop().sendKeys(new File(EnumsCommon.RELATIVE_DOWNLOADFILES_PATH.getText() + "E2E-TC05-pdfFile.pdf").getAbsolutePath());
        clickElement(driver, onEasySigningFormPage.getBtn_upload());
        Assert.assertTrue(" View link is not displaying", onEasySigningFormPage.getLink_view().isDisplayed());
        Assert.assertTrue(" Remove link is not displaying", onEasySigningFormPage.getLink_remove().isDisplayed());
        captureScreenshot(driver, testContext, false);
    }

    @Then("User clicks on upload and verifies the view and remove link")
    public void user_clicks_on_upload_and_verifies_the_view_and_remove_link() {
        captureScreenshot(driver, testContext, false);
        clickElementByJSE(driver, onEasySigningFormPage.getBtn_upload());
        Assert.assertTrue(" View link is not displaying", onEasySigningFormPage.getLink_view().isDisplayed());
        Assert.assertTrue(" Remove link is not displaying", onEasySigningFormPage.getLink_remove().isDisplayed());
    }


    @Then("User uploads Document")
    public void userUploadDocument(){
        captureScreenshot(driver, testContext, false);
        onEasySigningFormPage.getFileDrop().sendKeys(new File(EnumsCommon.ABSOLUTE_DOWNLOADFILES_PATH.getText() + "E2E-TC02-pdfFile.pdf").getAbsolutePath());
    }

    @Then("User Closes Documents window")
    public void user_Closes_Documents_window() {
        captureScreenshot(driver, testContext, false);
        waitForPageToLoad(driver);
        if(findElements(driver, onEasySigningFormPage.btn_closeDocuments_MVC).size() > 0)
            clickElement(driver, findElement(driver, onEasySigningFormPage.btn_closeDocuments_MVC));
        else
            clickElement(driver, findElement(driver, onEasySigningFormPage.btn_closeDocuments_REACT));
    }

    @Then("User Closes Reviewer Documents window")
    public void user_Closes_Reviewer_Documents_window() {
        captureScreenshot(driver, testContext, false);
        waitForPageToLoad(driver);
        clickElement(driver, onEasySigningFormPage.getBtn_closeReviewerDocuments());
    }

    @Then("User Clicks CompleteLog off Tab")
    public void user_Clicks_Complete_Log_off_Tab() {
        captureScreenshot(driver, testContext, false);
        waitForPageToLoad(driver);
        clickElement(driver, onEasySigningFormPage.getBtn_completeLogOff());
    }

    @Then("User Clicks Attach Documents Tab")
    public void user_Clicks_Attach_Documents_Tab() {
        waitForPageToLoad(driver);
        captureScreenshot(driver, testContext, false);
        syncElement(driver, onEasySigningFormPage.getBtn_attachDocuments(), EnumsCommon.TOCLICKABLE.getText());
        clickElement(driver, onEasySigningFormPage.getBtn_attachmentDocuments());
    }

    @Then("User Clicks on Submit and log off")
    public void click_Submit_and_log_off() {
        captureScreenshot(driver, testContext, false);
        syncElement(driver, onEasySigningFormPage.getBtn_submitAndLogOff(), EnumsCommon.TOVISIBLE.getText());
        Assert.assertTrue("Submit And Log Off button is not displayed", onEasySigningFormPage.getBtn_submitAndLogOff().isDisplayed());
        Assert.assertTrue("Save Finish later button is not displayed", onEasySigningFormPage.getBtn_saveFinishlater().isDisplayed());
        clickElement(driver, onEasySigningFormPage.getBtn_submitAndLogOff());
        captureScreenshot(driver, testContext, false);
        driver.manage().deleteAllCookies();
    }

    @Then("User verifies fields updated by external clients showing on Application")
    public void user_verifies_fields_updated_by_external_clients_showing_on_Application() {
        captureScreenshot(driver, testContext, false);
        Assert.assertEquals("Applicant Income not verified", testContext.getMapTestData().get("incomeOfApplicant"), onEasySigningFormPage.getTxtBoxIncomeOfApplicant().getAttribute("value"));
        Assert.assertEquals("Joint Applicant Income not verified", testContext.getMapTestData().get("incomeOfJointApplicant"), onEasySigningFormPage.getTxtBoxIncomeOfJointApplicant().getAttribute("value"));
        Assert.assertEquals("Applicant tax not verified", testContext.getMapTestData().get("taxOfApplicant"), onEasySigningFormPage.getTaxOfApplicantValue().getAttribute("value"));
        Assert.assertEquals("Joint Applicant tax not verified", testContext.getMapTestData().get("taxOfJointApplicant"), onEasySigningFormPage.getTaxOfJointApplicantValue().getAttribute("value"));
        Assert.assertEquals("Prioritazation Capital Of Applicant not verified", testContext.getMapTestData().get("prioritazationCapitalOfApplicant"), onEasySigningFormPage.getSelectList_prioritazationCapitalOfApplicant().getAttribute("value"));
        Assert.assertEquals("Prioritazation Capital Of Joint Applicant not verified", testContext.getMapTestData().get("prioritazationCapitalOfJointApplicant"), onEasySigningFormPage.getSelectList_prioritazationCapitalOfJointApplicant().getAttribute("value"));
    }

    @Then("User Clicks on Continue button")
    public void userClicksOnContinue() {
        waitForPageToLoad(driver);
        captureScreenshot(driver, testContext, false);
        clickElementByJSE(driver, onEasySigningFormPage.getBtn_continue());
    }

    @Then("User Verifies the message in popup")
    public void user_Verifies_the_message_in_popup() {
        captureScreenshot(driver, testContext, false);
        Assert.assertEquals("Message Mismatched", testContext.getMapTestData().get("applicationPopup"), onEasySigningFormPage.getTxt_CompleteActivity().getText().trim());
    }

    @Then("User Closes the Popup window")
    public void user_Closes_the_Popup_window() {
        waitForPageToLoad(driver);
        captureScreenshot(driver, testContext, false);
        clickElement(driver,onEasySigningFormPage.getBtn_cross());
    }

    @Then("User Clicks on button {string} in All Activities Page")
    public void user_Clicks_on_button_in_All_Activities_Page(String button) {
        captureScreenshot(driver, testContext, false);
        clickElementByJSE(driver,findElement(driver,String.format(onEasySigningFormPage.buttonWithText,button)));
    }

    @Then("User Verifies {int} Right Mark")
    public void user_Verifies_Right_Mark(int noOfTickMark) {
        captureScreenshot(driver, testContext, false);
        Assert.assertEquals("No of Tick Marks Not Matching",noOfTickMark,onEasySigningFormPage.getList_tickMark().size());
    }

    @Then("User Verifies {string} button is disabled in All Activities Page")
    public void user_Verifies_button_is_disabled_in_All_Activities_Page(String button) {
        captureScreenshot(driver, testContext, false);
        Assert.assertTrue(button+" was enabled",findElement(driver,String.format(onEasySigningFormPage.buttonWithTextDisable,button)).isEnabled());
    }

    @Then("User Verifies {string} is Disabled in Other Action")
    public void userverifies_is_Disabled_in_Other_Action(String option) {
        waitForPageToLoad(driver);
        captureScreenshot(driver, testContext, false);
        Assert.assertTrue(option+" was enabled",findElement(driver,String.format(onEasySigningFormPage.buttonWithTextDisable,option)).isEnabled());
    }

    @Then("User clicks on submit and Log Off")
    public void user_clicks_on_submit_and_Log_Off() {
        captureScreenshot(driver, testContext, false);
        Assert.assertTrue("Submit And Log Off button is not displayed", onEasySigningFormPage.getBtn_submitAndLogOff().isDisplayed());
        Assert.assertTrue("Save Finish later button is not displayed", onEasySigningFormPage.getBtn_saveFinishlater().isDisplayed());
        clickElement(driver, onEasySigningFormPage.getBtn_submitAndLogOff());
        captureScreenshot(driver, testContext, false);
    }

    @Then("User Now Click on Save Finish Later button")
    public void userClickSaveLater() {
        captureScreenshot(driver, testContext, false);
        clickElementByJSE(driver, onEasySigningFormPage.getBtn_saveFinishlater());
    }

    @Then("User Verifies Document Type Note Message as {string}")
    public void user_Verifies_Document_Type_Note_Message_as(String message) {
        captureScreenshot(driver, testContext, false);
        WebElement element  = getElement(driver, getExistingLocator(driver, onEasySigningFormPage.getMsg_DocumentTypeMVC(), onEasySigningFormPage.getMsg_DocumentTypeReact(), null, null));
        Assert.assertEquals("Message Should be: "+message+" But found: "+ element.getText().trim(),message,element.getText().trim());
    }

    @Then("User Verifies Uploaded file is {string} for {string} Document type and Size Of File Appears")
    public void user_Verifies_Uploaded_file_is_for_Document_type_and_Size_Of_File_Appears(String filename, String documentType) {
        waitForPageToLoad(driver);
        captureScreenshot(driver, testContext, false);
        if (testContext.getUiType().equalsIgnoreCase(EnumsCommon.UITYPE_REACT.getText())) {
            Assert.assertTrue("File Name Should be :" + filename, findElement(driver, String.format(onEasySigningFormPage.getUploadedFileNameReact1(), documentType, filename)).getText().trim().contains(filename));
            Assert.assertTrue("File Size not Displayed", findElement(driver, String.format(onEasySigningFormPage.getUploadedFileSizeReact1(), documentType, filename)).getText().trim().length() > 0);
        } else {
            Assert.assertTrue("File Name Should be :" + filename, findElement(driver, String.format(onEasySigningFormPage.getUploadedFileName1(), documentType, filename)).getText().trim().contains(filename));
            Assert.assertTrue("File Size not Displayed", findElement(driver, String.format(onEasySigningFormPage.getUploadedFileSize1(), documentType, filename)).getText().trim().length() > 0);
        }
    }

    @Then("User Verifies Total size Shows in the Popup")
    public void user_Verifies_Total_size_Shows_in_the_Popup() {
        waitForPageToLoad(driver);
        captureScreenshot(driver, testContext, false);
        if (testContext.getUiType().equalsIgnoreCase(EnumsCommon.UITYPE_REACT.getText())) {
            Assert.assertTrue("Total Size Not Displayed", onEasySigningFormPage.getTotalSizeReact().getText().trim().length() > 0);
        } else {
            Assert.assertTrue("Total Size Not Displayed", onEasySigningFormPage.getTotalSize().getText().trim().length() > 0);
        }
    }

    @Then("User Verifies Remaining Size Shows in the Popup")
    public void user_Verifies_remainingSize_Shows_in_the_Popup() {
        waitForPageToLoad(driver);
        captureScreenshot(driver, testContext, false);
        if (testContext.getUiType().equalsIgnoreCase(EnumsCommon.UITYPE_REACT.getText())) {
            Assert.assertTrue("Remaining Size Not Displayed", onEasySigningFormPage.getList_RemainingSizeReact().get(0).getText().trim().length() > 0);
        } else {
            Assert.assertTrue("Remaining Size Not Displayed", onEasySigningFormPage.getList_RemainingSize().get(0).getText().trim().length() > 0);
        }
    }

    @Then("User Verifies Remaining Size Does not Show in the Popup")
    public void user_Verifies_remainingSize_Does_not_Show_in_the_Popup() {
        waitForPageToLoad(driver);
        captureScreenshot(driver, testContext, false);
        if (testContext.getUiType().equalsIgnoreCase(EnumsCommon.UITYPE_REACT.getText())) {
            Assert.assertFalse("Remaining Size Displayed", onEasySigningFormPage.getList_RemainingSizeReact().size() > 0);
        } else {
            Assert.assertFalse("Remaining Size Displayed", onEasySigningFormPage.getList_RemainingSize().size() > 0);
        }
    }

    @Then("User Verifies Uploaded file is {string} for {string} Document type and Size Of File Does Not Appear")
    public void user_Verifies_Uploaded_file_is_for_Document_type_and_Size_Of_File_Does_not_Appear(String filename, String documentType) {
        waitForPageToLoad(driver);
        captureScreenshot(driver, testContext, false);
        if (testContext.getUiType().equalsIgnoreCase(EnumsCommon.UITYPE_REACT.getText())) {
            Assert.assertFalse("File Name Displayed :" + filename, findElement(driver, String.format(onEasySigningFormPage.getUploadedFileNameReact(), documentType)).getText().trim().contains(filename));
        } else {
            if(findElements(driver, String.format(onEasySigningFormPage.getUploadedFileName(), documentType)).size()==0) {
                Assert.assertTrue("File Name Displayed :" + filename,true);
            }
            else {
                Assert.assertFalse("File Name Displayed :" + filename, findElement(driver, String.format(onEasySigningFormPage.getUploadedFileName(), documentType)).getText().trim().contains(filename));
            }
        }
    }

    @Then("User Verifies Upload button is Disabled")
    public void user_Verifies_Upload_button_is_Disabled() {
        waitForPageToLoad(driver);
        captureScreenshot(driver, testContext, false);
        Assert.assertFalse("Upload Button was enabled",onEasySigningFormPage.getBtn_upload().isEnabled());
    }

    @Then("User Verifies Uploaded file is {string} for {string} Document type and Size Of File Appears at Reviewer Docs")
    public void user_Verifies_Uploaded_file_is_for_Document_type_and_Size_Of_File_Appears_Reviewer_Docs(String filename, String documentType) {
        waitForPageToLoad(driver);
        captureScreenshot(driver, testContext, false);
        if (testContext.getUiType().equalsIgnoreCase(EnumsCommon.UITYPE_REACT.getText())) {
            Assert.assertEquals("File Name Should be :" + filename, filename, findElement(driver, String.format(onEasySigningFormPage.getUploadedFileName(), documentType)).getText().trim());
            Assert.assertTrue("File Size not Displayed", findElement(driver, String.format(onEasySigningFormPage.getUploadedFileSize(), documentType)).getText().trim().length() > 0);
        } else {
            Assert.assertEquals("File Name Should be :" + filename, filename, findElement(driver, String.format(onEasySigningFormPage.getUploadedFileNameReact(), documentType)).getText().trim());
            Assert.assertTrue("File Size not Displayed", findElement(driver, String.format(onEasySigningFormPage.getUploadedFileSizeReact(), documentType)).getText().trim().length() > 0);
        }
    }

    @Then("User Verifies Uploaded file is {string} for {string} Document type and size Of file Appears")
    public void user_Verifies_Uploaded_file_is_for_Document_type_and_size_Of_file_Appears(String filename, String documentType) {
        waitForPageToLoad(driver);
        captureScreenshot(driver, testContext, false);
        if (onEasySigningFormPage.getList_reactFileNames().size() > 0) {
            boolean flag = false;
            for (WebElement singleFileName : onEasySigningFormPage.getList_reactFileNames()) {
                if (singleFileName.getText().trim().contains(filename)) {
                    flag = true;
                    break;
                }
            }
                Assert.assertTrue("File Name Should be :" + filename, flag);
                Assert.assertTrue("File Size not Displayed", findElement(driver, String.format(onEasySigningFormPage.getUploadedFileSizeReact(), documentType)).getText().trim().length() > 0);
        } else {
            boolean flag = false;
            for (WebElement singleFileName : onEasySigningFormPage.getList_fileNames()) {
                if (singleFileName.getText().trim().contains(filename)) {
                    flag = true;
                    break;
                }
            }
                Assert.assertTrue("File Name Should be :" + filename, flag);
                Assert.assertTrue("File Size not Displayed", findElement(driver, String.format(onEasySigningFormPage.getUploadedFileSize(), documentType)).getText().trim().length() > 0);
        }
    }

    @Then("User Verifies Uploaded file is {string} for {string} Document type Appears")
    public void user_Verifies_Uploaded_file_is_for_Document_type_Appears(String filename, String documentType) {
        waitForPageToLoad(driver);
        captureScreenshot(driver, testContext, false);
        if (testContext.getUiType().equalsIgnoreCase(EnumsCommon.UITYPE_REACT.getText())) {
            Assert.assertTrue("File Name Should be :" + filename, findElement(driver, String.format(onEasySigningFormPage.getUploadedFileNameReact1(), documentType, filename)).getText().trim().contains(filename));
        } else {
            Assert.assertTrue("File Name Should be :" + filename, findElement(driver, String.format(onEasySigningFormPage.getUploadedFileName1(), documentType, filename)).getText().trim().contains(filename));
        }
    }

    @Then("User Verifies Total size Shows Blank")
    public void user_Verifies_Total_size_Shows_Blank() {
        waitForPageToLoad(driver);
        captureScreenshot(driver, testContext, false);
        Assert.assertFalse("Total Size Displayed", getElements(driver, onEasySigningFormPage.getTotalSizeReactBy()).size() > 0 | getElements(driver, onEasySigningFormPage.getTotalSizeBy()).size() > 0);
    }

    @Then("User Verifies Remaining Size Shows Blank")
    public void user_Verifies_remainingSize_Shows_Blank() {
        waitForPageToLoad(driver);
        captureScreenshot(driver, testContext, false);
        if (testContext.getUiType().equalsIgnoreCase(EnumsCommon.UITYPE_REACT.getText())) {
            Assert.assertFalse("Remaining Size Displayed", onEasySigningFormPage.getList_RemainingSizeReact().size() > 0);
        } else {
            Assert.assertFalse("Remaining Size Displayed", onEasySigningFormPage.getList_RemainingSize().size() > 0);
        }
    }

    @Then("User Verifies Remaining Size is {string}")
    public void user_Verifies_remainingSize_Shows_in_the_Popup(String remainingSize) {
        waitForPageToLoad(driver);
        captureScreenshot(driver, testContext, false);
        if (testContext.getUiType().equalsIgnoreCase(EnumsCommon.UITYPE_REACT.getText())) {
            Assert.assertTrue("Remaining Size Not Displayed", onEasySigningFormPage.getList_RemainingSizeReact().get(0).getText().trim().contains(remainingSize));
        } else {
            Assert.assertTrue("Remaining Size Not Displayed", onEasySigningFormPage.getList_RemainingSize().get(0).getText().trim().contains(remainingSize));
        }
    }

    @Then("User Verifies Uploaded file is {string} for {string} Document type and Size Of File is blank")
    public void user_Verifies_Uploaded_file_is_for_Document_type_and_Size_Of_File_Is_Blank(String filename, String documentType) {
        waitForPageToLoad(driver);
        captureScreenshot(driver, testContext, false);
        if (testContext.getUiType().equalsIgnoreCase(EnumsCommon.UITYPE_REACT.getText())) {
            Assert.assertTrue("File Size Displayed", findElements(driver, String.format(onEasySigningFormPage.getUploadedFileSizeReact1(), documentType, filename)).get(0).getText().trim().equalsIgnoreCase(""));
        } else {
            Assert.assertTrue("File Size Displayed", findElements(driver, String.format(onEasySigningFormPage.getUploadedFileSize1(), documentType, filename)).get(0).getText().trim().equalsIgnoreCase(""));
        }
    }

    @Then("User Verifies Remaining Size Shows in the Popup and stores the remaining Size")
    public void user_stores_the_remaining_Size() {
        waitForPageToLoad(driver);
        captureScreenshot(driver, testContext, false);
        if (testContext.getUiType().equalsIgnoreCase(EnumsCommon.UITYPE_REACT.getText())) {
            Assert.assertTrue("Remaining Size Not Displayed", onEasySigningFormPage.getList_RemainingSizeReact().get(0).getText().trim().length() > 0);
            addPropertyValueInJSON(testContext.getTestCaseID(), testContext, EnumsJSONProp.REMAININGSIZE.getText(), onEasySigningFormPage.getList_RemainingSizeReact().get(0).getText().trim());
        } else {
            Assert.assertTrue("Remaining Size Not Displayed", onEasySigningFormPage.getList_RemainingSize().get(0).getText().trim().length() > 0);
            addPropertyValueInJSON(testContext.getTestCaseID(), testContext, EnumsJSONProp.REMAININGSIZE.getText(), onEasySigningFormPage.getList_RemainingSize().get(0).getText().trim());
        }
    }

    @Then("User Compares the Remaining Size")
    public void user_Compares_Size() {
        waitForPageToLoad(driver);
        captureScreenshot(driver, testContext, false);
        if (testContext.getUiType().equalsIgnoreCase(EnumsCommon.UITYPE_REACT.getText())) {
            Assert.assertTrue("Remaining Size Mismatched", onEasySigningFormPage.getList_RemainingSizeReact().get(0).getText().trim().contains(testContext.getMapTestData().get("remainingSize")));
        } else {
            Assert.assertTrue("Remaining Size Mismatched", onEasySigningFormPage.getList_RemainingSize().get(0).getText().trim().contains(testContext.getMapTestData().get("remainingSize")));
        }
    }

    @Then("User Verifies Uploaded {string} Size Of File is blank")
    public void user_Verifies_Uploaded_Size_Of_File_Is_Blank(String filename) {
        waitForPageToLoad(driver);
        captureScreenshot(driver, testContext, false);
            Assert.assertFalse("File Size Displayed", findElements(driver, String.format(onEasySigningFormPage.getUploadedFileSizeMVC(), filename)).size()>0);

    }
}

