package com.hexure.firelight.stepdefinitions;

import com.hexure.firelight.libraies.Enums.EnumsJSONProp;
import com.hexure.firelight.libraies.EnumsCommon;
import com.hexure.firelight.libraies.FLException;
import com.hexure.firelight.libraies.FLUtilities;
import com.hexure.firelight.libraies.TestContext;
import com.hexure.firelight.pages.ExternalLoginPage;
import com.hexure.firelight.pages.SignApplicationPage;
import cucumber.api.java.en.Then;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.awt.*;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;


public class ExternalLogin_StepDefinition extends FLUtilities {
    private WebDriver driver;
    private ExternalLoginPage onExternalLoginPage;
    private SignApplicationPage onSignApplicationPage;
    private TestContext testContext;
    private static final Logger Log = LogManager.getLogger(ExternalLogin_StepDefinition.class);

    public ExternalLogin_StepDefinition(TestContext context) {
        testContext = context;
        driver = context.getDriver();
        onExternalLoginPage = context.getPageObjectManager().getOnExternalLoginPage();
        onSignApplicationPage = context.getPageObjectManager().getOnSignApplicationPage();
    }

    @Then("User loads the External Reviewer URL noted in step {int} and login with passcode noted on step{int}.")
    public void userLoadTheExternalReviewerURLNotedInStepAndLoginWithPasscodeNotedOnStep(int arg0, int arg1) {
        driver.get(System.getProperty("External URL"));
        onExternalLoginPage.getInputPasscode().sendKeys(System.getProperty("Passcode"));
        onExternalLoginPage.getBtn_enter().click();
        waitForPageToLoad(driver);
    }

    @Then("User Loads the URL generated previously for {string}")
    public void userLoadsTheURLgeneratedPreviously(String key) {
        captureScreenshot(driver, testContext, false);
        if(key.equalsIgnoreCase("url")) {
            addPropertyValueInJSON(testContext.getTestCaseID(), testContext, EnumsJSONProp.URL.getText(), testContext.getMapTestData().get("emailLink"));
        }
        String url= testContext.getMapTestData().get(key);
        if(!(url.startsWith("https"))){
            url=url.substring(url.indexOf("https"));
        }
        driver.get(url);
    }

    @Then("User on External Login page have two for Login SSN,DOB or Passcode")
    public void userOnExternalLoginPage() {
        captureScreenshot(driver, testContext, false);
        Assert.assertTrue("SSN Field is not displaying", onExternalLoginPage.getSsnBirthDateElements().get(0).getText().trim().contains("SSN"));
        Assert.assertTrue("Birth Date Field is not displaying", onExternalLoginPage.getSsnBirthDateElements().get(1).getText().trim().contains("Birth Date"));
        Assert.assertTrue("Passcode Field is not displaying", onExternalLoginPage.getPasscodeElement().getText().trim().contains("Passcode"));
    }

    @Then("User Logs in with Passcode")
    public void userLogsInWithPasscode() {
        captureScreenshot(driver, testContext, false);
        onExternalLoginPage.getTxtBox_Passcode().sendKeys(testContext.getMapTestData().get("annuitantPasscode"));
        onExternalLoginPage.getBtn_enterPasscode().click();
        Assert.assertEquals("User is not in Annuity Wizard page", "Annuity Wizard", onExternalLoginPage.getPageNameExternalLogin().getText().trim());
    }

    @Then("User Loads Secondary Signer URL")
    public void userLoadsSecondarySignerURL() {
        captureScreenshot(driver, testContext, false);
        driver.get(testContext.getMapTestData().get("ownerUrl"));
    }

    @Then("User Logs in With SSN and DOB")
    public void userLogsInWithSSNDOB() {
        captureScreenshot(driver, testContext, false);
        onExternalLoginPage.getTxtBox_SSN().sendKeys(testContext.getMapTestData().get("ownerSsn"));
        onExternalLoginPage.getTxtBox_BirthDate().click();
        onExternalLoginPage.getTxtBox_BirthDate().sendKeys(testContext.getMapTestData().get("ownerBirthdate"));
        onExternalLoginPage.getBtn_enterSsnDob().click();
        Assert.assertTrue("Links are not displaying: Sign Activity,Review Documents,Contact Agent", getElement(driver, getExistingLocator(driver, onSignApplicationPage.getLink_ReviewDocumentsMVC(), onSignApplicationPage.getLink_ReviewDocumentsReact(), null, null)).isDisplayed());
    }

    @Then("User Logs in with Signer SSN and DOB")
    public void userLogsInWithSignerSSNDOB() {
        captureScreenshot(driver, testContext, false);
        onExternalLoginPage.getTxtBox_SSN().sendKeys(testContext.getMapTestData().get("signerSsn"));
        onExternalLoginPage.getTxtBox_BirthDate().click();
        onExternalLoginPage.getTxtBox_BirthDate().sendKeys(testContext.getMapTestData().get("signerBirthdate"));
        onExternalLoginPage.getBtn_enterSsnDob().click();
        Assert.assertTrue("Links are not displaying: Sign Activity,Review Documents,Contact Agent", getElement(driver, getExistingLocator(driver, onSignApplicationPage.getLink_ReviewDocumentsMVC(), onSignApplicationPage.getLink_ReviewDocumentsReact(), null, null)).isDisplayed());

    }

    @Then("User Loads external link as generated and Login with passcode")
    public void userLoadsExternalLink() {
        captureScreenshot(driver, testContext, false);
        driver.get(testContext.getMapTestData().get("recipientUrl"));
        onExternalLoginPage.getTxtBox_Passcode().sendKeys(testContext.getMapTestData().get("recipientPasscode"));
        captureScreenshot(driver, testContext, false);
        onExternalLoginPage.getBtn_enterPasscode().click();
    }

    @Then("User Logs in with {string}")
    public void user_Logs_in_with(String passcode) {
        captureScreenshot(driver, testContext, false);
        onExternalLoginPage.getTxtBox_Passcode().sendKeys(testContext.getMapTestData().get(passcode));
        captureScreenshot(driver, testContext, false);
        onExternalLoginPage.getBtn_enterPasscode().click();
    }

    @Then("User Load the External URL in another browser session generated")
    public void loadExternalUrlInAnotherBrowser() {
        captureScreenshot(driver, testContext, false);
        driver.get(testContext.getMapTestData().get("UrlLinkOnPrimaryGeneratedLinkWithoutEmailScreen"));
    }

    @Then("User Login with passcode generated")
    public void loginWithPassCodeGenerated() {
        captureScreenshot(driver, testContext, false);
        onExternalLoginPage.getInputPasscode().sendKeys(testContext.getMapTestData().get("PasscodeOnPrimaryGenerateLinkWithoutEmailScreen"));
        clickElement(driver, onExternalLoginPage.getBtn_EnterWelcome());
    }

    @Then("User Client View for External Fill app show, Sign Account Opening Button is disabled")
    public void showExternalFillAndVerifySignAccountOpeningButton() {
        Assert.assertTrue("Sign Account Opening button is enabled", onExternalLoginPage.getClientProtectedWiz_field().getAttribute("class").contains("disabled"));
    }

    @Then("User Verifies toast message Close")
    public void verifyToastMassageAndClose() {
        waitForPageToLoad(driver);
        captureScreenshot(driver, testContext, false);
        Assert.assertEquals("Toast box message mismatched", testContext.getMapTestData().get("applicationPopup"), onExternalLoginPage.getMsg_toastBox().getText().trim());
        clickElementByJSE(driver, onExternalLoginPage.getIcon_PopupCross());
    }

    @Then("User Clicks on Alerts It Should show only Alerts for {string} forms")
    public void clickOnAlertAndVerifyShowOnlyClientProtectedForms(String string) {
        captureScreenshot(driver, testContext, false);
        clickElement(driver, onExternalLoginPage.getBtn_Alert());
        for(WebElement element : onExternalLoginPage.getList_AlertError())
            Assert.assertFalse("Alerts contain Agent forms too", element.getText().contains("Agent"));
    }

    @Then("User Close Error list")
    public void closeErrorList() {
        captureScreenshot(driver, testContext, false);
        clickElement(driver, onExternalLoginPage.getBtn_Alert());
    }

    @Then("User Clicks Expand form menu")
    public void ClickOnExpandMenuForm() {
        waitForPageToLoad(driver);
        captureScreenshot(driver, testContext, false);
        clickElementByJSE(driver, onExternalLoginPage.getIcon_ExpandMenu());
    }

    @Then("User Form Menu have Client protected & Public Protected Forms & Wizard and no Agent Protected Wizard")
    public void verifyClientAndPublicProtectedInForms() {
        captureScreenshot(driver, testContext, false);
        boolean flag = false;
        for (WebElement element : onExternalLoginPage.getList_ExpandForm()) {
            if (element.getText().contains("Client Protected") || element.getText().contains("Public Protected") || (!element.getText().contains("Agent Protected")) || (!element.getText().contains("Wizar"))) {
                flag = true;
            }
            Assert.assertTrue("Form menu either does not have client and public protected forms or contains agent protected form", flag);
        }
    }

    @Then("User Clicks on First Page")
    public void clickFirstPage() {
        captureScreenshot(driver, testContext, false);
        clickElement(driver, onExternalLoginPage.getExpandPublicProtected_NewPage());
    }

    @Then("User Enters Annuitant First Name as {string} and Last name as {string}, Annuitant SSN as {string}")
    public void enterAnnuitantFirstNameAndLastNameAndSSN(String firstName, String lastName, String ssn) {
        captureScreenshot(driver, testContext, false);
        onExternalLoginPage.getAnnuitant_FirstName().sendKeys(firstName);
        onExternalLoginPage.getAnnuitant_LastName().sendKeys(lastName + Keys.TAB);
        clickElement(driver, onExternalLoginPage.getAnnuitant_SSN());
        onExternalLoginPage.getAnnuitant_SSN().sendKeys(ssn);
    }

    @Then("User Open Form Menu and Click Client Protected Template Form")
    public void openMenuAndClickClientProtectedForm() {
        captureScreenshot(driver, testContext, false);
        syncElement(driver, onExternalLoginPage.getIcon_ExpandMenu(), EnumsCommon.TOCLICKABLE.getText());
        clickElement(driver, onExternalLoginPage.getIcon_ExpandMenu());
        syncElement(driver, onExternalLoginPage.getBtn_ClientPage(), EnumsCommon.TOCLICKABLE.getText());
        clickElement(driver, onExternalLoginPage.getBtn_ClientPage());
    }

    @Then("User Clicks on Voided Check upload button")
    public void clickOnVoidedCheckUploadButton() {
        captureScreenshot(driver, testContext, false);
        clickElement(driver, onExternalLoginPage.getBtn_VoidedCheckUpload());
    }

    @Then("User Now navigate to remaining Required field from Alert menu")
    public void navigateToAgainAlertMenu() {
        captureScreenshot(driver, testContext, false);
        clickElement(driver, onExternalLoginPage.getBtn_Alert());
        clickElement(driver, onExternalLoginPage.getAlert_ErrorList());
    }

    @Then("User Now navigate to remaining Required field from Alert menu button")
    public void navigateToAgainAlertMenuButton() {
        captureScreenshot(driver, testContext, false);
        clickElement(driver, onExternalLoginPage.getBtn_Alert());
    }

    @Then("User Enters Owner Phone number as {string} & SSN as {string}")
    public void enterOwnerPhoneNumberAndSSN(String phoneNum, String ssn) {
        captureScreenshot(driver, testContext, false);
        onExternalLoginPage.getTxt_OwnerPhoneNumber().sendKeys(phoneNum);
        onExternalLoginPage.getTxt_OwnerSSNNumber().sendKeys(ssn + Keys.TAB);
    }

    @Then("User Sign Account Opening button is now enable")
    public void verifySignAccountOpeningButton() {
        clickElement(driver, onExternalLoginPage.getBtn_Next());
        clickElement(driver, onExternalLoginPage.getBtn_Next());
        Assert.assertTrue("Sign Account Opening Is Disabled", onExternalLoginPage.getBtn_SignAccountOpening().isEnabled());
    }

    @Then("User Clicks Print")
    public void clickPrintButton() {
        captureScreenshot(driver, testContext, false);
        clickElement(driver, onExternalLoginPage.getBtn_Print());
    }

    @Then("User verifies Print Window have Agent Protected forms as Unchecked")
    public void verifyPrintWindowHaveAgentProtectedFormsUnchecked() {
        captureScreenshot(driver, testContext, false);
        boolean flag = true;
        for (WebElement element : onExternalLoginPage.getListAgent_CheckBox()) {
            if (element.getAttribute("aria-checked").equals("true")) {
                flag = false;
                break;
            }
        }
        Assert.assertTrue("Agent Protected Forms Checked", flag);

        for (WebElement element : onExternalLoginPage.getListPublic_CheckBox()) {
            if (element.getAttribute("aria-checked").equals("false")) {
                flag = false;
                break;
            }
        }
        Assert.assertTrue("Public Protected Forms are unchecked", flag);

        for (WebElement element : onExternalLoginPage.getListClient_CheckBox()) {
            if (element.getAttribute("aria-checked").equals("false")) {
                flag = false;
                break;
            }
        }
        Assert.assertTrue("Client Protected Forms are unchecked", flag);

    }

    @Then("User Clicks Print Selected Documents and verify data Entry for client protected an Public protected forms, Also check no Agent Protected forms showing")
    public void clickPrintDocumentAndVerifyDataEntryForClientAndPublicAndAgentProtectedForms() throws Exception {
        clickElement(driver, onExternalLoginPage.getDoc_PrintSelected());
        sleepInMilliSeconds(2000);
        String pdfFileName = "";
        String pdfText = "";
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        if (tabs.size() > 1)
            driver.switchTo().window(tabs.get(1));
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

        Assert.assertTrue("Could not find Public Protected form in PDF File ", pdfText.contains("Public Protected Form with required fields"));
        Assert.assertTrue("Could not find Client Protected form in PDF File ", pdfText.contains("Client Protected Form with required fields"));
        Assert.assertFalse("Found Agent Protected form in PDF File ", pdfText.contains("Agent Protected Form with required fields"));
    }

    @Then("User Clicks Sign Account Opening, then Lock Activity")
    public void clickSignAccountOpeningAndClickLOckActivity() {
        clickElement(driver, onExternalLoginPage.getBtn_SignAccountOpening());
        syncElement(driver, onExternalLoginPage.getBtn_LockActivity(), EnumsCommon.TOCLICKABLE.getText());
        clickElement(driver, onExternalLoginPage.getBtn_LockActivity());
    }

    @Then("User Clicks on Sign Activity")
    public void clickSignActivityButton() {
        captureScreenshot(driver, testContext, false);
        clickElement(driver, onExternalLoginPage.getBtn_SignActivity());
    }

    @Then("User Clicks on Agree Checkbox for both documents")
    public void clickOnAgreeCheckBox() {
        captureScreenshot(driver, testContext, false);
        clickElement(driver, onExternalLoginPage.getCheckBox_Agree());
        sleepInMilliSeconds(2000);
        clickElement(driver, onExternalLoginPage.getCheckBox_Agree());
    }

    @Then("User clicks on OK In Congratulation field Button")
    public void ClickOnOKButton() {
        captureScreenshot(driver, testContext, false);
        clickElement(driver, onExternalLoginPage.getBtn_CongratulationOK());
        driver.manage().deleteAllCookies();
    }

    @Then("User Load External URL2")
    public void loadNextExternalUrl() {
        captureScreenshot(driver, testContext, false);
        driver.navigate().refresh();
        driver.get(testContext.getMapTestData().get("primaryUrl"));
    }

    @Then("User Login with SSN and birth date")
    public void LoginWithSSNAndBirthDate() {
        captureScreenshot(driver, testContext, false);
        onExternalLoginPage.getId_SSNWelcome().sendKeys(testContext.getMapTestData().get("insuredSSN"));
        clickElement(driver, onExternalLoginPage.getBirthDate_Welcome());
        syncElement(driver, onExternalLoginPage.getBirthDate_Welcome(), EnumsCommon.TOCLICKABLE.getText());
        onExternalLoginPage.getBirthDate_Welcome().sendKeys(testContext.getMapTestData().get("insuredBirthdate"));
        clickElement(driver, onExternalLoginPage.getBtn_SSNEnter());
    }

    @Then("User Document Review Window have All Public protected, Agent Protected, Client Protected forms")
    public void documentReviewWindowHaveAllProtectedForms() throws IOException {
        captureScreenshot(driver, testContext, false);
        clickElement(driver, onExternalLoginPage.getBtn_ReviewDocument());
        boolean flag = true;
        for (WebElement element : onExternalLoginPage.getList_InsuredSignature()) {
            if (!(element.getText().contains("Public Protected") || element.getText().contains("Agent Protected") || element.getText().contains("Client Protected"))) {
                flag = false;
                break;
            }
        }
        String pdfFileName = "";
        Assert.assertTrue("User Document Review Window does not have All Public protected, Agent Protected, Client Protected forms", flag);
        sleepInMilliSeconds(2000);
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        if (tabs.size() > 1)
            driver.switchTo().window(tabs.get(1));
        try {
            pdfFileName = testContext.getModuleName() + "-" + testContext.getTestCaseID() + "_" + getDate("pdfFileName") + ".pdf";
            Path downloadFilePath = Paths.get(EnumsCommon.ABSOLUTE_DOWNLOADFILES_PATH.getText() + "PrintApp.pdf");
            new WebDriverWait(driver, 60).until(d -> downloadFilePath.toFile().exists());
            renameFile("PrintApp", pdfFileName);
            String pdfText = getPDFText(pdfFileName);
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
    }

    @Then("User Agree checkbox for all documents")
    public void clickAgreeCheckBoxForAllDocument() {
        captureScreenshot(driver, testContext, false);
        clickElement(driver, onExternalLoginPage.getBtn_SignActivity());
        int elemSize = driver.findElements(By.xpath("//table[@id='tableNav']//button")).size();
        for(int i=0; i<elemSize; i++) {
            clickElement(driver, onExternalLoginPage.getCheckBox_InsuredSignature());
            sleepInMilliSeconds(2000);
        }
    }

    @Then("User load the external url")
    public void loadNewUrl() {
        captureScreenshot(driver, testContext, false);
        driver.navigate().refresh();
        driver.get(testContext.getMapTestData().get("recipientUrl"));
    }

    @Then("User Login to External Link using Client Last 4 Digits of SSN Govt ID")
    public void LoginWithSSNId() {
        captureScreenshot(driver, testContext, false);
        onExternalLoginPage.getId_SSNWelcome().sendKeys(testContext.getMapTestData().get("ReceipantSsn"));
        clickElement(driver, onExternalLoginPage.getBirthDate_Welcome());
        syncElement(driver, onExternalLoginPage.getBirthDate_Welcome(), EnumsCommon.TOCLICKABLE.getText());
        onExternalLoginPage.getBirthDate_Welcome().sendKeys(testContext.getMapTestData().get("ReceipantBirthdate"));
        clickElement(driver, onExternalLoginPage.getBtn_SSNEnter());
    }

    @Then("User Loads the URL generated by previous actions {string}")
    public void userLoadsTheURLGeneratedByPreviousActions(String URL) throws AWTException {
        captureScreenshot(driver, testContext, false);
        ((JavascriptExecutor) driver).executeScript("window.open()");
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        driver.get(testContext.getMapTestData().get(URL));
    }

    @Then("User use passcode and verifies validation message appeared {string}")
    public void userUsePasscodeAndVerifiesValidationMessageAppeared(String msg) {
        waitForPageToLoad(driver);
        captureScreenshot(driver, testContext, false);
        Assert.assertEquals("User is not navigate to external login page",testContext.getMapTestData().get("headerExternalLogin"),onExternalLoginPage.getHeader_ExternalLogin().getText().trim());
        onExternalLoginPage.getTxtBox_PasscodeOnWelcome().sendKeys(testContext.getMapTestData().get("recipientPasscode"));
        clickElementByJSE(driver,onExternalLoginPage.getBtn_enter());
        WebElement element = getElement(driver, getExistingLocator(driver, onExternalLoginPage.getErrorMsg_PasscodeInvalidMVC(), onExternalLoginPage.getErrorMsg_PasscodeInvalidReact(), null, null));
        Assert.assertEquals("Invalid or expired Passcode error message mismatched",msg,element.getText().trim());
        Assert.assertTrue("Invalid or expired Passcode error msg is not displayed in red color",element.getAttribute("class").contains("red"));
        driver.manage().deleteAllCookies();
    }
    @Then("User use passcode and verifies validation message {string}")
    public void userUsePasscodeAndVerifiesValidationMessage(String msg) {
        waitForPageToLoad(driver);
        captureScreenshot(driver, testContext, false);
        WebElement element = getElement(driver, getExistingLocator(driver, onExternalLoginPage.getErrorMsg_PasscodeInvalidMVC(), onExternalLoginPage.getErrorMsg_PasscodeInvalidReact(), null, null));
        Assert.assertEquals("Invalid or expired Passcode error message mismatched",msg,element.getText().trim());
        Assert.assertTrue("Invalid or expired Passcode error msg is not displayed in red color",element.getAttribute("class").contains("red"));
        driver.manage().deleteAllCookies();
    }

    @Then("User Login to External Link for {string}")
    public void loginExternallink(String name){
        captureScreenshot(driver, testContext, false);
        switch (name){
            case "Primary Owner":
                onExternalLoginPage.getId_SSNWelcome().sendKeys(testContext.getMapTestData().get("ownerSsn")+Keys.TAB);
                onExternalLoginPage.getBirthDate_Welcome().sendKeys(testContext.getMapTestData().get("ownerBirthdate")+Keys.TAB);
                clickElement(driver, onExternalLoginPage.getBtn_SSNEnter());
                break;
            case "Joint Owner":
                onExternalLoginPage.getId_SSNWelcome().sendKeys(testContext.getMapTestData().get("JointSsn")+Keys.TAB);
                onExternalLoginPage.getBirthDate_Welcome().sendKeys(testContext.getMapTestData().get("JointBirthdate")+Keys.TAB);
                clickElement(driver, onExternalLoginPage.getBtn_SSNEnter());
                break;
            case "Insured":
                onExternalLoginPage.getId_SSNWelcome().sendKeys(testContext.getMapTestData().get("insuredSsn")+Keys.TAB);
                onExternalLoginPage.getBirthDate_Welcome().sendKeys(testContext.getMapTestData().get("insuredBirthdate")+Keys.TAB);
                clickElement(driver, onExternalLoginPage.getBtn_SSNEnter());
                break;
            case "Receipant":
                onExternalLoginPage.getId_SSNWelcome().sendKeys(testContext.getMapTestData().get("receipantSsn")+Keys.TAB);
                onExternalLoginPage.getBirthDate_Welcome().sendKeys(testContext.getMapTestData().get("receipantBirthdate")+Keys.TAB);
                clickElement(driver, onExternalLoginPage.getBtn_SSNEnter());
                break;
            default:
                throw new FLException("Invalid value for name: " + name);
        }
    }

    @Then("User Verifies Enter Button")
    public void user_Verifies_Enter_Button() {
        captureScreenshot(driver, testContext, false);
        Assert.assertTrue("Enter Button did not Display",onExternalLoginPage.getBtn_enter().isDisplayed());
        captureScreenshot(driver, testContext, false);
    }

    @Then("User Clicks on Resend Passcode")
    public void user_Clicks_on_Resend_Passcode() {
        captureScreenshot(driver, testContext, false);
        clickElementByJSE(driver,onExternalLoginPage.getBtn_ResendPasscode());
        captureScreenshot(driver, testContext, false);
    }

    @Then("User Verifies the message of {string} in external Login Page")
    public void user_Verifies_the_message_of_in_external_Login_Page(String message) {
        WebElement element = getElement(driver, getExistingLocator(driver, onExternalLoginPage.getTxt_MessageResendpasscodeMVC(), onExternalLoginPage.getTxt_MessageResendpasscodeReact(), null, null));
        syncElement(driver,element,EnumsCommon.TOVISIBLE.getText());
        captureScreenshot(driver, testContext, false);
        Assert.assertTrue("Message mismatched", element.getText().trim().contains(message));
    }

    @Then("user Enters {string} in Passcode Text Field")
    public void user_Enters_in_Passcode_Text_Field(String userType) {
        captureScreenshot(driver, testContext, false);
        switch (userType.toLowerCase()) {
            case "owner passcode":
                waitForPageToLoad(driver);
                sendKeys(driver, onExternalLoginPage.getInputPasscode(), testContext.getMapTestData().get(EnumsJSONProp.OWNERPASSCODE.getText()));
                break;
            case "jointowner passcode":
                waitForPageToLoad(driver);
                sendKeys(driver, onExternalLoginPage.getInputPasscode(), testContext.getMapTestData().get(EnumsJSONProp.JOINTOWNERPASSCODE.getText()));
                break;
            default:
                throw new FLException("Invalid value provided for user : " + userType);
        }
        captureScreenshot(driver, testContext, false);
    }

    @Then("User Clicks on Enter Button")
    public void user_Clicks_on_Enter_Button() {
        captureScreenshot(driver, testContext, false);
        clickElementByJSE(driver,onExternalLoginPage.getBtn_enter());
        captureScreenshot(driver, testContext, false);
    }

    @Then("User Verifies message {string}")
    public void user_Verifies_message(String message) {
        Assert.assertEquals("Thank you message Mismatched", message, onExternalLoginPage.getMsg_ThankYou().getText().trim());
        captureScreenshot(driver, testContext, false);
    }
    @Then("User Verifies Resend Button")
    public void user_VerifiesResend_Button() {
        captureScreenshot(driver, testContext, false);
        Assert.assertTrue("Resend Button did not Display",onExternalLoginPage.getBtn_ResendPasscode().isDisplayed());
        captureScreenshot(driver, testContext, false);
    }

    @Then("User Verifies Resend Button does not show")
    public void user_VerifiesResend_ButtonDoesnotshow() {
        captureScreenshot(driver, testContext, false);
        if(new ArrayList<>(onExternalLoginPage.getListbtn_ResendPasscode()).size()>0){
            Assert.fail("Resend Passcode Button Displayed");
        }
        captureScreenshot(driver, testContext, false);
    }

    @Then("User Verifies the message of {string}")
    public void user_Verifies_the_message_of(String message) {
        WebElement element = getElement(driver, getExistingLocator(driver, onExternalLoginPage.getTxt_MessageResendpasscodeMVC(), onExternalLoginPage.getTxt_MessageResendpasscodeReact(), null, null));
        syncElement(driver,element,EnumsCommon.TOVISIBLE.getText());
        captureScreenshot(driver, testContext, false);
        Assert.assertTrue("Message mismatched", element.getText().trim().contains(message));
    }

    @Then("User open the link received to client \\(Primary signer) & verifies Heading {string}")
    public void userOpenTheLinkReceivedToClientPrimarySigner(String pageHeading) {
        captureScreenshot(driver, testContext, false);
        ((JavascriptExecutor) driver).executeScript("window.open()");
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        driver.get(testContext.getMapTestData().get("UrlLinkOnPrimaryGeneratedLinkWithoutEmailScreen"));
        captureScreenshot(driver, testContext, false);
        Assert.assertEquals("User navigate to wrong page" + pageHeading, pageHeading, onExternalLoginPage.getHeader_ExternalLogin().getText().trim());
        driver.close();
        driver.switchTo().window(tabs.get(0));
    }

    @Then("User Verifies toast Popup Not Appear")
    public void verifyToastPopupNotAppear() {
        waitForPageToLoad(driver);
        captureScreenshot(driver, testContext, false);
        Assert.assertFalse("Toast message Popup Displayed", onExternalLoginPage.getMsg_toastBox().isEnabled());
    }

    @Then("User verifies {string} TextBox in External Login Page")
    public void user_verifies_TextBox_in_External_Login_Page(String textBox) {
        captureScreenshot(driver, testContext, false);
        Assert.assertTrue(textBox + " was not displayed",findElement(driver,String.format(onExternalLoginPage.ariaLabelInputFields,textBox)).isDisplayed());
    }

    @Then("User verifies no {string} TextBox in External Login Page")
    public void user_verifies_No_TextBox_in_External_Login_Page(String textBox) {
        captureScreenshot(driver, testContext, false);
        Assert.assertTrue(textBox + " is displayed",findElements(driver,String.format(onExternalLoginPage.ariaLabelInputFields,textBox)).size() == 0);
    }

    @Then("User Logs in with {string} SSN and DOB")
    public void userLogsInWithSSNDOB(String signerType) {
        captureScreenshot(driver, testContext, false);
        onExternalLoginPage.getTxtBox_SSN().clear();
        onExternalLoginPage.getTxtBox_BirthDate().clear();
        switch (signerType) {
            case "Joint owner":
                 onExternalLoginPage.getTxtBox_SSN().sendKeys(testContext.getMapTestData().get(signerType.split(" ")[0]+"Ssn"));
                 onExternalLoginPage.getTxtBox_BirthDate().click();
                 onExternalLoginPage.getTxtBox_BirthDate().sendKeys(testContext.getMapTestData().get(signerType.split(" ")[0]+"Birthdate"));
                 onExternalLoginPage.getBtn_enterSsnDob().click();
            break;
            case "owner":
                onExternalLoginPage.getTxtBox_SSN().sendKeys(testContext.getMapTestData().get(signerType+"Ssn"));
                onExternalLoginPage.getTxtBox_BirthDate().click();
                onExternalLoginPage.getTxtBox_BirthDate().sendKeys(testContext.getMapTestData().get(signerType+"Birthdate"));
                onExternalLoginPage.getBtn_enterSsnDob().click();
                break;
            default:
                throw new FLException("Invalid value for signerType :" + signerType);
        }
    }

    @Then("User verifies validation message appeared {string}")
    public void userVerifiesValidationMessageAppeared(String msg) {
        waitForPageToLoad(driver);
        captureScreenshot(driver, testContext, false);
        WebElement element = getElement(driver, getExistingLocator(driver, onExternalLoginPage.getErrorMsg_PasscodeInvalidMVC(), onExternalLoginPage.getErrorMsg_PasscodeInvalidReact(),onExternalLoginPage.getErrorMsg_PasscodeInvalidMVC1(), null));
        Assert.assertEquals("Login error message mismatched",msg,element.getText().trim());
        Assert.assertTrue("Login error msg is not displayed in red color",element.getAttribute("class").contains("red"));
    }
    @Then("User Verifies the Page Title as {string}")
    public void user_Verifies_the_Page_Title_as(String heading) {
        captureScreenshot(driver, testContext, false);
        Assert.assertEquals("Page Heading Did not Match , Expected: "+ heading + "But Found :"+
        driver.getTitle(),heading , driver.getTitle());
        driver.manage().deleteAllCookies();
    }

    @Then("User Verifies toast message {string} and Closes it")
    public void verifyToastMassageAndCloseAndClosesIt(String msg) {
        waitForPageToLoad(driver);
        captureScreenshot(driver, testContext, false);
        Assert.assertEquals("Toast box message mismatched", msg, onExternalLoginPage.getMsg_toastBox().getText().trim());
        clickElementByJSE(driver, onExternalLoginPage.getIcon_PopupCross());
    }

    @Then("User clicks {string} button on External link page")
    public void userClicksButton(String whichButton) {
        captureScreenshot(driver, testContext, false);
        waitForPageToLoad(driver);
        switch (whichButton) {
            case "Enter":
                clickElement(driver, onExternalLoginPage.getBtn_SSNEnter());
                break;
            default:
                throw new FLException("Invalid value for button : " + whichButton);
        }
    }

    @Then("User Verifies Document Type Already Uploaded error message on Documents Window")
    public void user_Verifies_Document_Type_Already_Uploaded_error_message_on_Documents_Window() {
        captureScreenshot(driver, testContext, false);
        Assert.assertTrue("Document Type Already Uploaded error message did not appear", onExternalLoginPage.getMsg_DocTypeAlreadyUploaded().isEnabled());
    }

    @Then("User Close the Popup")
    public void user_Close_the_Popup() {
        captureScreenshot(driver, testContext, false);
        clickElementByJSE(driver, onExternalLoginPage.getIcon_PopupCross());
    }

    @Then("User  verifies Error message {string} appeared in red")
    public void userVerifiesErrorMessageAppeared(String msg) {
        waitForPageToLoad(driver);
        captureScreenshot(driver, testContext, false);
        WebElement element = getElement(driver, getExistingLocator(driver, onExternalLoginPage.getErrorMsg_PasscodeInvalidMVC1(), onExternalLoginPage.getErrorMsg_PasscodeInvalidMVC(), onExternalLoginPage.getErrorMsg_PasscodeInvalidReact(), onExternalLoginPage.getErrorMsg_PasscodeInvalidReact1()));
        Assert.assertEquals("Invalid or expired Passcode error message mismatched",msg,element.getText().trim());
        if(!element.getAttribute("style").isEmpty())
            Assert.assertTrue("Invalid or expired Passcode error msg is not displayed in red color",element.getAttribute("style").contains("red"));
    }

    @Then("User Verifies {string} link")
    public void user_Verifies_link(String link) {
        captureScreenshot(driver, testContext, false);
        Assert.assertEquals(link+" Link mismatched",link,getElement(driver, getExistingLocator(driver, onExternalLoginPage.getLink_CancelMVC(), onExternalLoginPage.getLink_CancelReact(), null, null)).getText().trim());
    }

    @Then("User Clicks on Cancel this request link")
    public void user_ClicksOn_link() {
        captureScreenshot(driver, testContext, false);
        clickElementByJSE(driver,getElement(driver, getExistingLocator(driver, onExternalLoginPage.getLink_CancelMVC(), onExternalLoginPage.getLink_CancelReact(), null, null)));
    }


    @Then("User Log in with SSN and DOB")
    public void userLogInWithSSNDOB() {
        captureScreenshot(driver, testContext, false);
        onExternalLoginPage.getTxtBox_SSN().sendKeys(testContext.getMapTestData().get("signerSsn"));
        onExternalLoginPage.getTxtBox_BirthDate().click();
        onExternalLoginPage.getTxtBox_BirthDate().sendKeys(testContext.getMapTestData().get("signerBirthdate"));
        onExternalLoginPage.getBtn_enterSsnDob().click();
    }

    @Then("User Loads {string} external link as generated and Login with {string}")
    public void userLoadsLink(String url, String passcode) {
        captureScreenshot(driver, testContext, false);
        driver.get(testContext.getMapTestData().get(url));
        onExternalLoginPage.getTxtBox_Passcode().sendKeys(testContext.getMapTestData().get(passcode));
        captureScreenshot(driver, testContext, false);
        onExternalLoginPage.getBtn_enterPasscode().click();
    }

    @Then("User Load the External URL for {string}")
    public void loadExternalUrl(String urlKey) {
        captureScreenshot(driver, testContext, false);
        driver.get(testContext.getMapTestData().get(urlKey));
    }
    @Then("User Login with SSN {string} and birth date {string}")
    public void LoginsWithSSNAndBirthDate(String ssnKey, String birthDateKey) {
        captureScreenshot(driver, testContext, false);
        onExternalLoginPage.getId_SSNWelcome().sendKeys(testContext.getMapTestData().get(ssnKey));
        clickElement(driver, onExternalLoginPage.getBirthDate_Welcome());
        syncElement(driver, onExternalLoginPage.getBirthDate_Welcome(), EnumsCommon.TOCLICKABLE.getText());
        onExternalLoginPage.getBirthDate_Welcome().sendKeys(testContext.getMapTestData().get(birthDateKey));
        clickElement(driver, onExternalLoginPage.getBtn_SSNEnter());
    }
}

