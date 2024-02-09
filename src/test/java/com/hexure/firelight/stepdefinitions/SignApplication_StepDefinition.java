package com.hexure.firelight.stepdefinitions;

import com.hexure.firelight.libraies.Enums.EnumsJSONProp;
import com.hexure.firelight.libraies.EnumsCommon;
import com.hexure.firelight.libraies.FLException;
import com.hexure.firelight.libraies.FLUtilities;
import com.hexure.firelight.libraies.TestContext;
import com.hexure.firelight.libraies.pages_react.CommonMethods_ReactPage;
import com.hexure.firelight.pages.SignApplicationPage;
import com.hexure.firelight.pages.SignaturesPage;
import cucumber.api.java.en.Then;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class SignApplication_StepDefinition extends FLUtilities {
    private WebDriver driver;
    private SignApplicationPage onSignApplicationPage;
    private TestContext testContext;
    private SignaturesPage onSignaturesPage;
    private CommonMethods_ReactPage onCommonMethods_reactPage;
    private static final Logger Log = LogManager.getLogger(SignApplication_StepDefinition.class);

    public SignApplication_StepDefinition(TestContext context) {
        testContext = context;
        driver = context.getDriver();
        onSignApplicationPage = context.getPageObjectManager().getOnSignApplicationPage();
        onSignaturesPage=context.getPageObjectManager().getOnSignaturesPage();
        onCommonMethods_reactPage = context.getPageObjectManager().getCommonMethods_reactPage();
    }

    @Then("User Verifies the Form menu having two Wizards & Form with Red Exclamation mark on some pages")
    public void userVerifiesTheFormMenu() {
        captureScreenshot(driver, testContext, false);
        Assert.assertEquals("Not in Annuity Wizard page", "Annuity Wizard", onSignApplicationPage.getPagenameExternalLogin().getText().trim());
        clickElement(driver, onSignApplicationPage.getMenuWiz());
        int wizPageCount = onSignApplicationPage.getNoOfWizardsWithExclamatoryINAnnuityWizard().size();
        Assert.assertTrue("Finding Error wizards is not equal to 2", wizPageCount == 2);
        int formPageCount = onSignApplicationPage.getNoOfFormsWithExclamatoryInApplication222().size() + onSignApplicationPage.getNoOfFormsWithExclamatoryInFeeAndExpense().size();
        Assert.assertTrue("Finding Error wizards is Zero", formPageCount > 0);
    }

    @Then("User Clicks on Client Data Page")
    public void userClicksOnClientDataPage() {
        captureScreenshot(driver, testContext, false);
        clickElement(driver, onSignApplicationPage.getClientDataWizardPage());
    }

    @Then("User Clicks on Individual Radio button, Clicks on No for question Annuitant same as owner then clicks Non Qualified, Clicks Yes on Replacement Questions")
    public void userClicksOnIndividualRadioButton() {
        captureScreenshot(driver, testContext, false);
        clickElement(driver, onSignApplicationPage.getRadioBtn_Individual());
        clickElement(driver, onSignApplicationPage.getRadioBtn_IsTheAnnuitantTheSameAsTheOwnerNo());
        clickElement(driver, onSignApplicationPage.getRadioBtn_NonQualifiedAccount());
        for (WebElement option : onSignApplicationPage.getRadioBtnsYesReplacementQuestions()) {
            clickElementByJSE(driver,option);
        }
        sleepInMilliSeconds(3000);
        boolean flag = false;
        ArrayList<WebElement> redButton = new ArrayList<>(onSignApplicationPage.getRedBtn_Errormsg());
        if (redButton.size() > 0)
            flag = true;

        Assert.assertFalse("Red Error msg Button is displaying", flag);
    }

    @Then("User Clicks on Next Button")
    public void userClicksOnNextButton() {
        captureScreenshot(driver, testContext, false);
        clickElement(driver, onSignApplicationPage.getBtn_Next());
    }

    @Then("User checks Current page is {string}")
    public void userChecksCurrentPageIsOwner(String exp_page_name) {
        captureScreenshot(driver, testContext, false);
        Assert.assertEquals("User is not in " + exp_page_name, exp_page_name, onSignApplicationPage.getPagename().getText().trim());
    }

    @Then("User Enters Owner First name, last name & Date of Birth Enter Zipcode")
    public void userEntersOwnerFirstNameLastName() {
        captureScreenshot(driver, testContext, false);
        onSignApplicationPage.getTxtBox_FirstnameOwner().sendKeys(testContext.getMapTestData().get("ownerFirstName"));
        onSignApplicationPage.getTxtBox_LastnameOwner().sendKeys(testContext.getMapTestData().get("ownerLastName"));
        onSignApplicationPage.getTxtBox_DateofBirthOwner().sendKeys(testContext.getMapTestData().get("ownerDob"));
        onSignApplicationPage.getTxtBox_ZipCodeOwner().sendKeys(testContext.getMapTestData().get("ownerZip")+ Keys.TAB);
    }

    @Then("User Clicks on Alerts on top, it will show validation error list, Click on list having {string} text")
    public void clicksOnAlertsTop(String desiredPage) {
        captureScreenshot(driver, testContext, false);
        clickElement(driver, onSignApplicationPage.getBtn_Alerts());
        for (WebElement errorPage : onSignApplicationPage.getErrorListPages()) {
            if (errorPage.getText().trim().contains(desiredPage)) {
                clickElement(driver, errorPage);
                break;
            }
        }

    }

    @Then("User Enters {string} in Beneficiary dropdown, then Updates fields Relationship to owner {string}, Percentage of Proceeds {string}, Beneficiary First name & Last Name")
    public void enterInBeneficiaryDropdown(String value, String relation, String percent) {
        Select select = new Select(onSignApplicationPage.getSelectListBeneficiaries());
        waitUntilDropDownListPopulated(driver, select);
        captureScreenshot(driver, testContext, false);
        select.selectByVisibleText(value);
        new Select(onSignApplicationPage.getSelectListRelationshipToOwner()).selectByVisibleText(relation);
        onSignApplicationPage.getPercentOfProceedBeneficiaries().sendKeys(percent);
        onSignApplicationPage.getFirstNameBeneficiaries().sendKeys(testContext.getMapTestData().get("benefeciaryFirstName"));
        onSignApplicationPage.getLastNameBeneficiaries().sendKeys(testContext.getMapTestData().get("benefeciaryLastName"));
    }

    @Then("User Clicks Next Button for Agent Page, Verify Agent First Name & Last name field is Pre Filled")
    public void clickNextButton() {
        captureScreenshot(driver, testContext, false);
        clickElement(driver, onSignApplicationPage.getBtn_Next());
        Assert.assertTrue("First name of agent is not pre filled", onSignApplicationPage.getFirstNameAgent().getAttribute("value") != null);
        Assert.assertTrue("Last name of agent is not pre filled", onSignApplicationPage.getLastNameAgent().getAttribute("value") != null);
    }

    @Then("User Clicks Next for Payment Details Page")
    public void clickNextforPaymentDetailsPage() {
        captureScreenshot(driver, testContext, false);
        clickElement(driver, onSignApplicationPage.getBtn_Next());
    }

    @Then("User Selects {string} in Payment Method dropdown")
    public void selectInPaymentMethodDropdown(String paymentMethod) {
        captureScreenshot(driver, testContext, false);
        new Select(onSignApplicationPage.getSelectListPaymentMethod()).selectByVisibleText(paymentMethod);
    }

    @Then("User Now Navigates to Page {int} of Fees & Expense Disclosure sample from Form menu")
    public void userNowNavigatesToPageOfFeesExpense(Integer int1) {
        captureScreenshot(driver, testContext, false);
        clickElement(driver, onSignApplicationPage.getMenuWiz());
        syncElement(driver,onSignApplicationPage.getPage1FeesExpenses(),EnumsCommon.TOCLICKABLE.getText());
        captureScreenshot(driver, testContext, false);
        clickElement(driver, onSignApplicationPage.getPage1FeesExpenses());
    }

    @Then("Enter DOB on Client Information section")
    public void enterDOBonClientInformationSection() {
        captureScreenshot(driver, testContext, false);
        syncElement(driver, onSignApplicationPage.getTxtBox_DobFeesExpense(), EnumsCommon.TOVISIBLE.getText());
        onSignApplicationPage.getTxtBox_DobFeesExpense().sendKeys(testContext.getMapTestData().get("clientDOB"));
    }

    @Then("User verifies Alerts tab has green tick now. & Sign Application Button is enabled")
    public void userVerifiesAlertsTabHasGreenTickNow() {
        syncElement(driver, onSignApplicationPage.getAlertGreenTick(), EnumsCommon.TOVISIBLE.getText());
        captureScreenshot(driver, testContext, false);
        Assert.assertTrue("Sign Application Button is not enabled", onSignApplicationPage.getSignApplication_btn().isEnabled());
        Assert.assertTrue("Green tick is not displaying", onSignApplicationPage.getAlertGreenTick().isDisplayed());
    }

    @Then("User Clicks on Attach Documents tab, Selects {string} in Document Type & uploads any PDF")
    public void userClicksOnAttachDocumentstabSelectsInDocumentType(String documentType) {
        captureScreenshot(driver, testContext, false);
        clickElement(driver, onSignApplicationPage.getAttachDocuments_tab());
        new Select(onSignApplicationPage.getSelectlistDocumentType()).selectByVisibleText(documentType);
        onSignApplicationPage.getFileUpload().sendKeys(new File(EnumsCommon.RELATIVE_DOWNLOADFILES_PATH.getText() + "E2E-TC04-pdfFile.pdf").getAbsolutePath());
        clickElement(driver, onSignApplicationPage.getBtn_Upload());
        Assert.assertEquals("View and Remove link is not present", 2, onSignApplicationPage.getList_LinkViewRemove().size());
    }

    @Then("User Closes Documents Window")
    public void userClosesDocumentsWindow() {
        captureScreenshot(driver, testContext, false);
        clickElementByJSE(driver, getElement(driver, getExistingLocator(driver, onSignApplicationPage.getBtn_CloseMVC(), onSignApplicationPage.getBtn_CloseReact(), null, null)));
    }

    @Then("User Now Clicks on Print Tab")
    public void userNowClicksonPrintTab() {
        captureScreenshot(driver, testContext, false);
        clickElement(driver, onSignApplicationPage.getBtn_Print());
    }

    @Then("User Gets Print PDF and Verify the Content in PDF \\(Owner Name Agent Name ect)")
    public void userGetsPrintPDFandVerifytheContent() throws Exception {
        captureScreenshot(driver, testContext, false);
        clickElement(driver, onSignApplicationPage.getBtn_PrintSelectedDocuments());
        //static wait to nwait for pdf TODO : Remove if not required
        sleepInMilliSeconds(2000);
        //TODO : pdf verification
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        String pdfFileName = " ";
        String pdfText = "";
        if(tabs.size() > 1)
            driver.switchTo().window(tabs.get(1));

        if (testContext.getBrowser().equalsIgnoreCase(EnumsCommon.FIREFOXBROWSER.getText())){
            sleepInMilliSeconds(5000);
        }

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
        Assert.assertTrue("Could not find ownerFirstName in PDF File ", pdfText.contains(testContext.getMapTestData().get("ownerFirstName")));
        Assert.assertTrue("Could not find ownerLastName in PDF File ", pdfText.contains(testContext.getMapTestData().get("ownerLastName")));
        Assert.assertTrue("Could not find ownerZip in PDF File ", pdfText.contains(testContext.getMapTestData().get("ownerZip")));
        Assert.assertTrue("Could not find ownerDob in PDF File ", pdfText.contains(testContext.getMapTestData().get("ownerDob")));
        Assert.assertTrue("Could not find benefeciaryFirstName in PDF File ", pdfText.contains(testContext.getMapTestData().get("benefeciaryFirstName")));
        Assert.assertTrue("Could not find benefeciaryLastName in PDF File ", pdfText.contains(testContext.getMapTestData().get("benefeciaryLastName")));
        Assert.assertTrue("Could not find contractNumber in PDF File ", pdfText.contains(testContext.getMapTestData().get("contractNumber")));
    }

    @Then("User Clicks On Sign Application then Clicks Lock Activity")
    public void userClicksOnSignApplication() {
        syncElement(driver, onSignApplicationPage.getSignApplication_btn(), EnumsCommon.TOCLICKABLE.getText());
        captureScreenshot(driver, testContext, false);
        //TODO: without static wait failing
        sleepInMilliSeconds(2000);
        clickElementByJSE(driver, onSignApplicationPage.getSignApplication_btn());
        clickElement(driver, onSignApplicationPage.getBtn_LockActivity());
        waitForPageToLoad(driver);
        Assert.assertTrue("Links are not displaying: Sign Activity,Review Documents,Contact Agent", getElement(driver, getExistingLocator(driver, onSignApplicationPage.getLink_ReviewDocumentsMVC(), onSignApplicationPage.getLink_ReviewDocumentsReact(), null, null)).isDisplayed());
    }

    @Then("User Clicks Review Documents and verify Generated PDF is same as generated before")
    public void userClicksReviewDocuments() throws Exception {
        captureScreenshot(driver, testContext, false);
        clickElement(driver, getElement(driver, getExistingLocator(driver, onSignApplicationPage.getLink_ReviewDocumentsMVC(), onSignApplicationPage.getLink_ReviewDocumentsReact(), null, null)));
        sleepInMilliSeconds(2000);
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        String pdfFileName = "";
        String pdfText = "";
        if(tabs.size() > 1)
            driver.switchTo().window(tabs.get(1));

        if (testContext.getBrowser().equalsIgnoreCase(EnumsCommon.FIREFOXBROWSER.getText())){
           sleepInMilliSeconds(7000);
        }

        try {
            pdfFileName = testContext.getModuleName() + "-" + testContext.getTestCaseID() + "_" + getDate("pdfFileName") + ".pdf";
            Path downloadFilePath = Paths.get(EnumsCommon.ABSOLUTE_DOWNLOADFILES_PATH.getText() + "PrintApp.pdf");
            new WebDriverWait(driver, 60).until(d -> downloadFilePath.toFile().exists());
            renameFile("PrintApp", pdfFileName);
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
        Assert.assertTrue("Could not find ownerFirstName in PDF File ", pdfText.contains(testContext.getMapTestData().get("ownerFirstName")));
        Assert.assertTrue("Could not find ownerLastName in PDF File ", pdfText.contains(testContext.getMapTestData().get("ownerLastName")));
        Assert.assertTrue("Could not find ownerZip in PDF File ", pdfText.contains(testContext.getMapTestData().get("ownerZip")));
        Assert.assertTrue("Could not find ownerDob in PDF File ", pdfText.contains(testContext.getMapTestData().get("ownerDob")));
        Assert.assertTrue("Could not find benefeciaryFirstName in PDF File ", pdfText.contains(testContext.getMapTestData().get("benefeciaryFirstName")));
        Assert.assertTrue("Could not find benefeciaryLastName in PDF File ", pdfText.contains(testContext.getMapTestData().get("benefeciaryLastName")));
        Assert.assertTrue("Could not find contractNumber in PDF File ", pdfText.contains(testContext.getMapTestData().get("contractNumber")));
        Assert.assertTrue("Could not find product name in PDF File ", pdfText.contains(testContext.getMapTestData().get("product")));
    }

    @Then("User Clicks Sign Activity button")
    public void userClicksSignActivitybutton() {
        captureScreenshot(driver, testContext, false);
        clickElement(driver, onSignApplicationPage.getLink_SignActivity());
    }

    @Then("User Verifies Document Set window has text {string}")
    public void userVerifiesDocument(String title) {
        captureScreenshot(driver, testContext, false);
        Assert.assertTrue("Title text is not matching", getElement(driver, getExistingLocator(driver, onSignApplicationPage.getEsignDocumentHeadingMVC(), onSignApplicationPage.getEsignDocumentHeadingReact(), null, null)).getText().trim().equalsIgnoreCase(title));
    }

    @Then("User Verifies Page has {int} document sets for Annuitant, Get the Documents name for each documents need to be identify in next step")
    public void usrerVerifiesPagehasDocumentSetsforAnnuitant(Integer expPageCount) {
        captureScreenshot(driver, testContext, false);
        int documentCount = onSignApplicationPage.getDocumentSetName().size();
        Assert.assertTrue("No of documents displaying is not equal to 2", documentCount == expPageCount);
        addPropertyValueInJSON(testContext.getTestCaseID(), testContext, EnumsJSONProp.DOCUMENT1ANNUITANT.getText(), onSignApplicationPage.getDocumentSetName().get(0).getText());
        addPropertyValueInJSON(testContext.getTestCaseID(), testContext, EnumsJSONProp.DOCUMENT2ANNUITANT.getText(), onSignApplicationPage.getDocumentSetName().get(1).getText());
    }

    @Then("User Clicks Continue Button")
    public void userClicksCintinueButton() {
        captureScreenshot(driver, testContext, false);
        clickElement(driver, getElement(driver, getExistingLocator(driver, onSignApplicationPage.getBtn_ContinueMVC(), onSignApplicationPage.getBtn_ContinueReact(), null, null)));
    }

    @Then("User Checks First Document Set should have same forms as showing on Document Set window")
    public void userChecksFirstDocumentSet() {
        captureScreenshot(driver, testContext, false);
        Assert.assertEquals("Document set1 is not matching ", testContext.getMapTestData().get("document1Annuitant"), onSignApplicationPage.getTextElement_AnnuiantSignDocumentset().getText());
    }

    @Then("User Clicks on Agree Checkbox")
    public void userClicksonAgreeCheckbox() {
        waitForPageToLoad(driver);
        captureScreenshot(driver, testContext, false);
        clickElement(driver, onSignApplicationPage.getAgreeCheckbox());
    }
    @Then("User Clicks on Agree Checkbox Three Times")
    public void userClicksonAgreeCheckboxThreeTimes() {
        captureScreenshot(driver, testContext, false);
        clickElement(driver, onSignApplicationPage.getAgreeCheckbox());
        waitForPageToLoad(driver);
        captureScreenshot(driver, testContext, false);
        clickElement(driver, onSignApplicationPage.getAgreeCheckbox());
        waitForPageToLoad(driver);
        captureScreenshot(driver, testContext, false);
        clickElement(driver, onSignApplicationPage.getAgreeCheckbox());
    }

    @Then("User Verifies {string} window will Appear Enter Signer Full name & City then perform Signature")
    public void userVerifiesWindowEnterSigner(String pageTitle) {
        syncElement(driver, onSignApplicationPage.getSignPageHeader(), EnumsCommon.TOVISIBLE.getText());
        captureScreenshot(driver, testContext, false);
        Assert.assertTrue(pageTitle + " is not appearing", onSignApplicationPage.getSignPageHeader().getText().trim().equalsIgnoreCase(pageTitle));
        onSignApplicationPage.getSignerFullName().sendKeys(testContext.getMapTestData().get("annuitantName"));
        onSignApplicationPage.getSignerCity().sendKeys(testContext.getMapTestData().get("annuitantCity"));
        addDigitalSignature(driver, onSignApplicationPage.getSignerpad());
    }

    @Then("User Verifies {string} window will Appear Enter Signer's Full name & City then perform Signature")
    public void userVerifiesWindowEnterSigners(String pageTitle) {
        syncElement(driver, onSignApplicationPage.getSignPageHeader(), EnumsCommon.TOVISIBLE.getText());
        captureScreenshot(driver, testContext, false);
        Assert.assertTrue(pageTitle + " is not appearing", onSignApplicationPage.getSignPageHeader().getText().trim().equalsIgnoreCase(pageTitle));
        onSignApplicationPage.getSignerFullName().sendKeys(testContext.getMapTestData().get("signerName"));
        onSignApplicationPage.getSignerCity().sendKeys(testContext.getMapTestData().get("signerCity"));
        addDigitalSignature(driver, onSignApplicationPage.getSignerpad());
    }

    @Then("User Clicks on I Consent")
    public void userClicksOnIConsent() {
        captureScreenshot(driver, testContext, false);
        ArrayList<WebElement> listConsent = new ArrayList<>(onSignApplicationPage.getListbtn_IConsent());
        if(listConsent.size() > 0) {
            onSignApplicationPage.getBtn_IConsent().click();
        } else  {
            onSignApplicationPage.getBtn_IConsentAgent().click();
        }
    }

    @Then("User Again Clicks on Continue")
    public void user_Again_Clicks_on_Continue() {
        captureScreenshot(driver, testContext, false);
        clickElement(driver, getElement(driver, getExistingLocator(driver, onSignApplicationPage.getBtn_ContinueMVC(), onSignApplicationPage.getBtn_ContinueReact(), null, null)));
    }

    @Then("Now it will show as document to review as shown on Document Set {int} window")
    public void nowItWillShowAsDocumentToReview(Integer int1) {
        captureScreenshot(driver, testContext, false);
        Assert.assertEquals("Document set2 is not matching ", testContext.getMapTestData().get("document2Annuitant"), onSignApplicationPage.getTextElement_AnnuiantSignDocumentset().getText());
    }

    @Then("Click OK on Congratulations screen. then close the browser")
    public void clickOKonCongratulationsScreen() {
        captureScreenshot(driver, testContext, false);
        clickElement(driver, onSignApplicationPage.getBtn_okInCongradulationPage());
    }

    @Then("User Clicks on Review Documents, Verifies Generated PDF has data entry and Signatures done by Primary Signer")
    public void userClicksOnReviewDocuments() throws Exception {
        captureScreenshot(driver, testContext, false);
        clickElement(driver, getElement(driver, getExistingLocator(driver, onSignApplicationPage.getLink_ReviewDocumentsMVC(), onSignApplicationPage.getLink_ReviewDocumentsReact(), null, null)));
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        if(tabs.size() > 1)
            driver.switchTo().window(tabs.get(1));

        String pdfFileName = testContext.getModuleName() + "-" + testContext.getTestCaseID() + "_" + getDate("pdfFileName") + ".pdf";
        Path downloadFilePath = Paths.get(EnumsCommon.ABSOLUTE_DOWNLOADFILES_PATH.getText() + "PrintApp.pdf");
        new WebDriverWait(driver, 60).until(d -> downloadFilePath.toFile().exists());
        renameFile("PrintApp", pdfFileName);
        String pdfText = getPDFText(pdfFileName);
        Log.info(pdfFileName);

        Assert.assertTrue("Could not find ownerFirstName in PDF File ", pdfText.contains(testContext.getMapTestData().get("ownerFirstName")));
        Assert.assertTrue("Could not find ownerLastName in PDF File ", pdfText.contains(testContext.getMapTestData().get("ownerLastName")));
        Assert.assertTrue("Could not find ownerZip in PDF File ", pdfText.contains(testContext.getMapTestData().get("ownerZip")));
        Assert.assertTrue("Could not find ownerDob in PDF File ", pdfText.contains(testContext.getMapTestData().get("ownerDob")));
        Assert.assertTrue("Could not find benefeciaryFirstName in PDF File ", pdfText.contains(testContext.getMapTestData().get("benefeciaryFirstName")));
        Assert.assertTrue("Could not find benefeciaryLastName in PDF File ", pdfText.contains(testContext.getMapTestData().get("benefeciaryLastName")));
        Assert.assertTrue("Could not find contractNumber in PDF File ", pdfText.contains(testContext.getMapTestData().get("contractNumber")));
        Assert.assertTrue("Could not find product name in PDF File ", pdfText.contains(testContext.getMapTestData().get("product")));
        Assert.assertTrue("Signed Image does not exists in generated PDF", verifySignatureMatchingInPDF(testContext, pdfFileName));
        tabs = new ArrayList<>(driver.getWindowHandles());
        if(tabs.size() > 1)
            driver.close();

        driver.switchTo().window(tabs.get(0));
    }

    @Then("User Clicks on Review Documents")
    public void userClicksOnReviewDocument() {
        captureScreenshot(driver, testContext, false);
        clickElement(driver, getElement(driver, getExistingLocator(driver, onSignApplicationPage.getLink_ReviewDocumentsMVC(), onSignApplicationPage.getLink_ReviewDocumentsReact(), null, null)));
    }

    @Then("User Clicks on  Sign Activity")
    public void user_Clicks_on_Sign_Activity() {
        captureScreenshot(driver, testContext, false);
        clickElement(driver, onSignApplicationPage.getLink_SignActivity());
    }

    @Then("User Verifies Forms Name in Document Set for each Doc set type and verifies at the time of document review")
    public void userVerifiesFormsNameInDocumentSet() {
        captureScreenshot(driver, testContext, false);
        addPropertyValueInJSON(testContext.getTestCaseID(), testContext, "document1Owner", onSignApplicationPage.getDocumentSetName().get(0).getText());
        addPropertyValueInJSON(testContext.getTestCaseID(), testContext, "document2Owner", onSignApplicationPage.getDocumentSetName().get(1).getText());
        addPropertyValueInJSON(testContext.getTestCaseID(), testContext, "document3Owner", onSignApplicationPage.getDocumentSetName().get(2).getText());
        addPropertyValueInJSON(testContext.getTestCaseID(), testContext, "document4Owner", onSignApplicationPage.getDocumentSetName().get(3).getText());

    }

    @Then("User Clicks on Continue")
    public void userClicksOnContinue() {
        captureScreenshot(driver, testContext, false);
        clickElement(driver, getElement(driver, getExistingLocator(driver, onSignApplicationPage.getBtn_ContinueMVC(), onSignApplicationPage.getBtn_ContinueReact(), null, null)));
    }

    @Then("User Performs Initials")
    public void user_Performs_Initials() {
        captureScreenshot(driver, testContext, false);
        waitForPageToLoad(driver);
        Assert.assertEquals("Initial page is not matching ", testContext.getMapTestData().get("document1Owner"), onSignApplicationPage.getTextElement_AnnuiantSignDocumentset().getText());
       for(int i = 0; i < 3; i++){
           waitForPageToLoad(driver);
           clickElement(driver, onSignApplicationPage.getBtn_nextPage());
       }

        waitForPageToLoad(driver);
        clickElement(driver, onSignApplicationPage.getTxtBox_initial());
        onSignApplicationPage.getTxtBox_enterInitial().sendKeys("Mr");
        onSignApplicationPage.getBtn_initialPopupOk().click();
    }

    @Then("User on Document Set {int}")
    public void userOnDocumentSet(Integer int1) {
        captureScreenshot(driver, testContext, false);
        Assert.assertEquals(" Document1 page is not matching ", testContext.getMapTestData().get("document2Owner"), onSignApplicationPage.getTextElement_AnnuiantSignDocumentset().getText());
    }

    @Then("User Follows the same process for remaining Document Set as done in Document Set {int}")
    public void userFollowstheSameProccess(Integer int1) {
        captureScreenshot(driver, testContext, false);
        String pageTitle = "Capture Electronic Signature";
        Assert.assertEquals(" Document2 page is not matching ", testContext.getMapTestData().get("document3Owner"), onSignApplicationPage.getTextElement_AnnuiantSignDocumentset().getText());
        clickElement(driver, onSignApplicationPage.getAgreeCheckbox());
        syncElement(driver, onSignApplicationPage.getSignPageHeader(), EnumsCommon.TOVISIBLE.getText());
        Assert.assertTrue(pageTitle + " is not appearing", onSignApplicationPage.getSignPageHeader().getText().trim().equalsIgnoreCase(pageTitle));
        onSignApplicationPage.getSignerFullName().sendKeys(testContext.getMapTestData().get("ownerName"));
        onSignApplicationPage.getSignerCity().sendKeys(testContext.getMapTestData().get("ownerCity"));
        addDigitalSignature(driver, onSignApplicationPage.getSignerpad());
        clickElement(driver, onSignApplicationPage.getBtn_IConsent());
        clickElement(driver, getElement(driver, getExistingLocator(driver, onSignApplicationPage.getBtn_ContinueMVC(), onSignApplicationPage.getBtn_ContinueReact(), null, null)));
        Assert.assertEquals(" Document3 page is not matching ", testContext.getMapTestData().get("document4Owner"), onSignApplicationPage.getTextElement_AnnuiantSignDocumentset().getText());
        clickElement(driver, onSignApplicationPage.getAgreeCheckbox());
        syncElement(driver, onSignApplicationPage.getSignPageHeader(), EnumsCommon.TOVISIBLE.getText());
        Assert.assertTrue(pageTitle + " is not appearing", onSignApplicationPage.getSignPageHeader().getText().trim().equalsIgnoreCase(pageTitle));
        onSignApplicationPage.getSignerFullName().sendKeys(testContext.getMapTestData().get("ownerName"));
        onSignApplicationPage.getSignerCity().sendKeys(testContext.getMapTestData().get("ownerCity"));
        addDigitalSignature(driver, onSignApplicationPage.getSignerpad());
        clickElement(driver, onSignApplicationPage.getBtn_IConsent());
    }

    @Then("User After Signing All Document set page will be on Congratulations screen, Click OK")
    public void userAfterSigningAllDocumentsetPage() {
        captureScreenshot(driver, testContext, false);
        Assert.assertTrue("Congratulations Page is not displaying",onSignApplicationPage.getMessage_Congratulation().getText().trim().contains("Congratulations"));
        clickElement(driver, onSignApplicationPage.getBtn_okInCongradulationPage());
        driver.manage().deleteAllCookies();
        captureScreenshot(driver, testContext, false);
    }

    @Then("User Enters Signer Full Name, City Then Perform Signature")
    public void user_Enters_Signer_Full_Name_City_Then_Perform_Signature_and_click_I_Consent() {
        captureScreenshot(driver, testContext, false);
        onSignApplicationPage.getSignerFullName().sendKeys(testContext.getMapTestData().get("signerName"));
        onSignApplicationPage.getSignerCity().sendKeys(testContext.getMapTestData().get("signerCity"));
        addDigitalSignature(driver, onSignApplicationPage.getSignerpad());
    }

    @Then("User Enters Agent Full Name,Agent ID, City Then Perform Signature")
    public void user_Enters_Agent_Full_Name_Agent_ID_City_Then_Perform_Signature_and_click_I_Consent() {
       captureScreenshot(driver, testContext, false);
        onSignApplicationPage.getSignerFullName().sendKeys(testContext.getMapTestData().get("agentName"));
        onSignApplicationPage.getSignerCity().sendKeys(testContext.getMapTestData().get("agentCity"));
        onSignApplicationPage.getTxtBox_agentId().sendKeys(testContext.getMapTestData().get("agentID"));
        addDigitalSignature(driver, onSignApplicationPage.getSignerpad());
    }

    @Then("User verifies Accept or decline e-signature request screen should not display and  moves directly into the signing ceremony.")
    public void userVerifiesAcceptOrDeclineESignatureRequestScreenShouldNotDisplayAndMovesDirectlyIntoTheSigningCeremony() {
        try {
            captureScreenshot(driver, testContext, false);
            int countButtonMVC = 0;
            int countButtonReact = 0;
            countButtonMVC = getElements(driver, onSignaturesPage.getBtnUseSignature()).size();
            countButtonReact = getElements(driver, onSignaturesPage.getBtnUseSignature1()).size();
            Assert.assertTrue("Accept e-signature button is displayed", countButtonMVC == 0 & countButtonReact == 0);
            countButtonMVC = getElements(driver, onSignaturesPage.getBtn_DeclineESignatureMVC()).size();
            countButtonReact = getElements(driver, onSignaturesPage.getBtn_DeclineESignatureReact()).size();
            Assert.assertTrue("Decline e-signature button is displayed", countButtonMVC == 0 & countButtonReact == 0);
        } catch (NoSuchElementException e) {
            System.err.println("Element not found: " + e.getMessage());
        }
    }

    @Then("User Clicks On Sign Application Button then Clicks Lock Activity Button")
    public void userClicksOnSignApplicationAndLockActivity() {
        waitForPageToLoad(driver);
        syncElement(driver, onSignApplicationPage.getSignApplication_btn(), EnumsCommon.TOCLICKABLE.getText());
        captureScreenshot(driver, testContext, false);
        clickElementByJSE(driver, onSignApplicationPage.getSignApplication_btn());
        clickElement(driver, onSignApplicationPage.getBtn_LockActivity());
    }

    @Then("User clicks React LN Signer button")
    public void userClicksReactLNSignerButton() {
        waitForPageToLoad(driver);
        captureScreenshot(driver, testContext, false);
        clickElement(driver, onSignApplicationPage.getBtn_ReactLNSigner());
    }

    @Then("User verifies the Select Documents to Print Dialog box")
    public void user_verifies_the_Select_Documents_to_Print_Dialog_box() {
        waitForPageToLoad(driver);
        captureScreenshot(driver, testContext, false);
        Assert.assertTrue("Dialog box was not showing", getElement(driver, getExistingLocator(driver, onSignApplicationPage.getEsignDocumentHeadingMVC(), onSignApplicationPage.getEsignDocumentHeadingReact(), null, null)).isDisplayed());
    }
    @Then("User clicks on {string} Button")
    public void user_clicks_on_Button(String dataItemId) {
        captureScreenshot(driver, testContext, false);
        clickElementByJSE(driver, findElement(driver, String.format(onCommonMethods_reactPage.preFilledFormInput, dataItemId)));
    }

    @Then("User Verifies Next Button Exists")
    public void userVerifiesNextButtonExists() {
        waitForPageToLoad(driver);
        captureScreenshot(driver, testContext, false);
        Assert.assertTrue("Next Button Does not exist",onSignApplicationPage.getBtn_Next().isDisplayed());
    }

    @Then("User Verifies Next Button does not Exist")
    public void userVerifiesNextButtonDoesNotExist() {
        captureScreenshot(driver, testContext, false);
        Assert.assertFalse("Next Button exists",onSignApplicationPage.getListBtn_NextWizard().size() >0);
    }

    @Then("User clicks on Yes Radio button of {string} in form page")
    public void userClicksOnYesRadiob_utton(String string) {
        waitForPageToLoad(driver);
        for (WebElement option : onSignApplicationPage.getRadioBtnsYesReplacementQuestions()) {
            option.click();
        }
    }

    @Then("User clicks on Agree Checkbox")
    public void userClickonAgreeCheckbox() {
        waitForPageToLoad(driver);
        captureScreenshot(driver, testContext, false);
        clickElement(driver, onSignApplicationPage.getChkBox_Agree());
    }

    @Then("User Clicks On Application")
    public void userClicksOnApplication() {
        syncElement(driver, onSignApplicationPage.getApplication_btn(), EnumsCommon.TOCLICKABLE.getText());
        captureScreenshot(driver, testContext, false);
        //TODO: without static wait failing
        sleepInMilliSeconds(2000);
        clickElement(driver, onSignApplicationPage.getApplication_btn());
    }
}

