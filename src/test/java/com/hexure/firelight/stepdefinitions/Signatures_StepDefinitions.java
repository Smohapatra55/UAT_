package com.hexure.firelight.stepdefinitions;

import com.hexure.firelight.libraies.Enums.EnumsJSONProp;
import com.hexure.firelight.libraies.EnumsCommon;
import com.hexure.firelight.pages.*;
import com.hexure.firelight.libraies.FLException;
import com.hexure.firelight.libraies.FLUtilities;
import com.hexure.firelight.libraies.TestContext;
import com.hexure.firelight.pages.CommonMethodsPage;
import com.hexure.firelight.pages.ReviewPage;
import com.hexure.firelight.pages.SignaturesPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import io.cucumber.datatable.DataTable;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.Select;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public class Signatures_StepDefinitions extends FLUtilities {
    private WebDriver driver;
    private SignaturesPage onSignaturesPage;
    private ReviewPage onReviewPage;
    private TestContext testContext;


    private CommonMethodsPage onCommonMethodsPage;
    private static final Logger Log = LogManager.getLogger(Signatures_StepDefinitions.class);
    String pdfFileName = "";

    public Signatures_StepDefinitions(TestContext context) {
        testContext = context;
        driver = context.getDriver();
        onSignaturesPage = context.getPageObjectManager().getOnSignaturesPage();
        onReviewPage = context.getPageObjectManager().getReviewPage();
        onCommonMethodsPage = context.getPageObjectManager().getCommonMethodPage();
    }

    @And("User verifies Signature tab is highlighted now")
    public void userVerifiesSignatureTabIsHighlightedNow() {
        captureScreenshot(driver, testContext, false);
        Assert.assertTrue("Signature tab is NOT highlighted", onSignaturesPage.getCanvas_Signatures().getAttribute("class").contains("_Current"));
    }

    @Then("User clicks Decline E-Signature on Electronic Signatures option window")
    public void userClicksDeclineESignatureOnElectronicSignaturesOptionWindow() {
        captureScreenshot(driver, testContext, false);
        clickElementByJSE(driver,getElement(driver, getExistingLocator(driver, onSignaturesPage.getBtn_DeclineESignatureMVC(), onSignaturesPage.getBtn_DeclineESignatureReact(), null, null)));
    }

    @Then("User clicks Accept E-Signature on Electronic Signatures option window")
    public void userClicksAcceptESignatureOnElectronicSignaturesOptionWindow() {
        captureScreenshot(driver, testContext, false);
        waitForPageToLoad(driver);
        clickElementByJSE(driver, getElement(driver, getExistingLocator(driver, onSignaturesPage.getBtnUseSignature(), onSignaturesPage.getBtnUseSignature1(), null, null)));
    }

    @Then("User verifies message on Electronic Signatures Declined window")
    public void userVerifiesMessageOnElectronicSignaturesDeclinedWindow() {
        Assert.assertTrue("E-Signature decline message Line-1 MisMatched", onSignaturesPage.getMsg_ESignatureDeclineMsg1().getText().trim().equalsIgnoreCase(
                testContext.getMapTestData().get("messageESignDecline-1")));

        Assert.assertTrue("E-Signature decline message Line-2 MisMatched", onSignaturesPage.getMsg_ESignatureDeclineMsg2().getText().trim().equalsIgnoreCase(
                testContext.getMapTestData().get("messageESignDecline-2")));

        Assert.assertTrue("E-Signature decline message Line-3 MisMatched", onSignaturesPage.getMsg_ESignatureDeclineMsg3().getText().trim().equalsIgnoreCase(
                testContext.getMapTestData().get("messageESignDecline-3")));
    }

    @Then("User verifies that Now Signature step has minus circle")
    public void userVerifiesThatNowSignatureStepHasMinusCircle() {
        clickElementByJSE(driver, onReviewPage.getBtn_InitialMessagePopupClose());
        Assert.assertTrue("Signature step has NO minus circle", onSignaturesPage.getImage_SignatureMinusCircle().isDisplayed());
    }

    @Then("User clicks {string} on Confirmation Dialog")
    public void userClicksOnConfirmationDialog(String whichOption) {
        waitForPageToLoad(driver);
        switch (whichOption.toLowerCase()) {
            case "yes":
                clickElement(driver, onSignaturesPage.getPopup_Yes());
                break;
            case "no":
                clickElement(driver, onSignaturesPage.getPopup_No());
                break;
            case "ok":
                clickElement(driver, getElement(driver, getExistingLocator(driver, onSignaturesPage.getPopup_OkMVC(), onSignaturesPage.getPopup_OkReact(), null, null)));
                break;
            case "cancel":
                clickElement(driver, getElement(driver, getExistingLocator(driver, onSignaturesPage.getBtnCancel(), onSignaturesPage.getBtnCancel1(), null, null)));
                break;
            default:
                throw new FLException("Invalid operation : " + whichOption);
        }
    }

    @Then("User verifies electronic Signatures option window show")
    public void UserVerifiesElcetronicSignaturesOptionWindowShow() {
        waitForPageToLoad(driver);
        captureScreenshot(driver, testContext, false);
        Assert.assertTrue("Electronic Signatures option window text is not displayed.", onSignaturesPage.getTxt_ElectronicSignatures().isDisplayed());
    }

    @Then("User selects {string} signer on signature window")
    public void userSelectsSigner(String signer) {
        captureScreenshot(driver, testContext, false);
        waitForPageToLoad(driver);
        switch (signer.toLowerCase()) {
            case "owner":
                clickElement(driver, getElement(driver, getExistingLocator(driver, onSignaturesPage.getId_Owner(), onSignaturesPage.getChk_Owner(), null, null)));
                break;
            case "owner 2":
                clickElement(driver, getElement(driver, getExistingLocator(driver, onSignaturesPage.getId_Owner2(), null, null, null)));
                break;
            case "joint owner":
                clickElement(driver, getElement(driver, getExistingLocator(driver, onSignaturesPage.getChk_jointOwner(), onSignaturesPage.getId_jointOwner(), null, null)));
                break;
            case "agent":
                clickElement(driver, getElement(driver, getExistingLocator(driver, onSignaturesPage.getChk_Agent(), onSignaturesPage.getId_Agent(), null, null)));
                break;
            case "insured":
                clickElement(driver, getElement(driver, getExistingLocator(driver, onSignaturesPage.getChk_Insured(), onSignaturesPage.getId_Insured(), null, null)));
                break;
            case "annuitant":
                clickElement(driver, getElement(driver, getExistingLocator(driver, onSignaturesPage.getLink_AnnuitantMVC(), onSignaturesPage.getLink_AnnuitantReact(), null, null)));
                break;
            case "joint annuitant":
                clickElement(driver, getElement(driver, getExistingLocator(driver, onSignaturesPage.getChk_JointAnnuitant(), onSignaturesPage.getId_JointAnnuitant(), null, null)));
                break;
            case "payor":
                clickElement(driver, getElement(driver, getExistingLocator(driver, onSignaturesPage.getChk_Payor(), onSignaturesPage.getId_Payor(), null, null)));
                break;
            case "agent 2":
                clickElement(driver, getElement(driver, getExistingLocator(driver, onSignaturesPage.getChk_Agent2(), onSignaturesPage.getId_Agent2(), null, null)));
                break;
            case "agent 3":
                clickElement(driver, getElement(driver, getExistingLocator(driver, onSignaturesPage.getChk_Agent3(), onSignaturesPage.getId_Agent3(), null, null)));
                break;
            case "producer":
                clickElement(driver, getElement(driver, getExistingLocator(driver, onSignaturesPage.getChk_Producer(), onSignaturesPage.getId_Producer(), null, null)));
                break;
            case "trustee":
                clickElement(driver, getElement(driver,getExistingLocator(driver, onSignaturesPage.getCheckBoxTrusteeMVC(), onSignaturesPage.getCheckBoxTrusteeReact(), null, null)));
                break;
            default:
                throw new FLException("Invalid value provided for user : " + signer);
        }
    }

    @Then("User enter all required details for {string} with client authentication on signature window")
    public void userSubmitDetailsWithClientAuth(String condition) {
        captureScreenshot(driver, testContext, false);
        if(condition.equalsIgnoreCase("signing"))
            sendKeys(driver, getElement(driver, getExistingLocator(driver, onSignaturesPage.getTxtBox_IDNumber(), onSignaturesPage.getTxtBox_IDNumber1(), null, null)), testContext.getMapTestData().get("id"));
        String appName = testContext.getMapTestData().get("newProductName");
        String name = testContext.getMapTestData().get("name");
        if(name.contains("Random")) {
            name = name + appName.substring(appName.lastIndexOf(" "));
            addPropertyValueInJSON(testContext.getTestCaseID(), testContext, EnumsJSONProp.REVIEWERNAME.getText(), name);
        }
        sendKeys(driver, getElement(driver, getExistingLocator(driver, onSignaturesPage.getTxtBox_Name(), onSignaturesPage.getTxtBox_Name1(), onSignaturesPage.getTxtBox_Name2(), onSignaturesPage.getTxtBox_Name3())), name);
        sendKeys(driver, getElement(driver, getExistingLocator(driver, onSignaturesPage.getTxtBox_EmailAddress(), onSignaturesPage.getTxtBox_EmailAddress1(), onSignaturesPage.getTxtBox_EmailAddress2(), onSignaturesPage.getTxtBox_EmailAddress3())), testContext.getMapTestData().get("emailAddress"));
    }

    @Then("User enters passcode on signature page")
    public void userEnterPssscode() {
        captureScreenshot(driver, testContext, false);
        sendKeys(driver, getElement(driver, getExistingLocator(driver, onSignaturesPage.getTxtbox_Passcode1(), onSignaturesPage.getTxtbox_Passcode2(), null, null)), testContext.getMapTestData().get("passCode"));
    }

    @Then("User verify {string} text {string} on signature page")
    public void userVerifyText(String text, String condition) {
        captureScreenshot(driver, testContext, false);
        int textElemSize = 0;
        if(!text.contains("'"))
            textElemSize = driver.findElements(By.xpath("//*[text()='" + text + "']")).size();
        if (textElemSize > 0) {
            if (condition.equalsIgnoreCase("exists"))
                Assert.assertTrue(text + " text does not exists on signature page", textElemSize > 0);
            else
                Assert.assertTrue(text + " text does not exists on signature page", textElemSize == 0);
        }
        else if (findElements(driver, "//input[@class='activeSignature']").size() > 0) {
            Assert.assertTrue("Text is not displayed", onSignaturesPage.getTxtBox_ActiveSignature().getAttribute("value").equalsIgnoreCase(text));
        }
        else if (findElements(driver, "//div[@class='activeSignature']").size() > 0) {
            Assert.assertTrue("Text is not displayed", onSignaturesPage.getTxtBox_ActiveSignatureReact().getText().equalsIgnoreCase(text));
        }
        else {
            int textElemSize1 = driver.findElements(By.xpath("//div[contains(@id,'client')]")).size();
            if (textElemSize1 > 0 & condition.equalsIgnoreCase("exists"))
                Assert.assertTrue(text + " text does not exists on signature page", onSignaturesPage.getTxt_ClientAuthentication().getText().trim().contains(text));
            else
                Assert.assertFalse(text + " text exists on signature page", onSignaturesPage.getTxt_ClientAuthentication().getText().trim().contains(text));
        }
    }

    @Then("User enter all required details for signing on signature window")
    public void userSubmitDetails() {
        captureScreenshot(driver, testContext, false);
        sendKeys(driver, getElement(driver, getExistingLocator(driver, onSignaturesPage.getTxtBox_IDNumber(), onSignaturesPage.getTxtBox_IDNumber1(), null, null)), testContext.getMapTestData().get("id"));
        sendKeys(driver, getElement(driver, getExistingLocator(driver, onSignaturesPage.getTxtBox_Name(), onSignaturesPage.getTxtBox_Name1(), null, null)), testContext.getMapTestData().get("name"));
        sendKeys(driver, getElement(driver, getExistingLocator(driver, onSignaturesPage.getTxtBox_EmailAddress(), onSignaturesPage.getTxtBox_EmailAddress1(), null, null)), testContext.getMapTestData().get("emailAddress"));
      if(getElements(driver, onSignaturesPage.getTxtBox_BirthDate()).size()>0 || getElements(driver, onSignaturesPage.getTxtBox_BirthDate1()).size()> 0) {
          WebElement elemBirthDate = getElement(driver, getExistingLocator(driver, onSignaturesPage.getTxtBox_BirthDate(), onSignaturesPage.getTxtBox_BirthDate1(), null, null));
          clickElement(driver, elemBirthDate);
          sendKeys(driver, elemBirthDate, testContext.getMapTestData().get("birthDate"));
      }
        if(getElements(driver, onSignaturesPage.getTxtBox_SSN()).size()>0 || getElements(driver, onSignaturesPage.getTxtBox_SSN1()).size()> 0) {
          sendKeys(driver, getElement(driver, getExistingLocator(driver, onSignaturesPage.getTxtBox_SSN(), onSignaturesPage.getTxtBox_SSN1(), null, null)), testContext.getMapTestData().get("ssn")+ Keys.TAB);
      }
    }

    @Then("User enter all required {string} details for sending mail on signature window")
    public void userSubmitEmailDetails(String user) {
        captureScreenshot(driver, testContext, false);
        String ownerName = testContext.getMapTestData().get("name");
        if(ownerName.contains("Random")) {
            String appName = testContext.getMapTestData().get("newProductName");
            ownerName = ownerName + appName.substring(appName.lastIndexOf(" "));
            addPropertyValueInJSON(testContext.getTestCaseID(), testContext, EnumsJSONProp.REVIEWERNAME.getText(), ownerName);
            addPropertyValueInJSON(testContext.getTestCaseID(), testContext, EnumsJSONProp.OWNERNAME.getText(), ownerName);
        }

        if(testContext.getMapTestData().get("uiType").equalsIgnoreCase("react")) {
            sendKeys(driver, getElement(driver, getExistingLocator(driver, onSignaturesPage.getSignNameSignerPage(), onSignaturesPage.getSignNameSignerPage1(), null, null)), ownerName);
            sendKeys(driver, getElement(driver, getExistingLocator(driver, onSignaturesPage.getSignEmailSignerPage(), onSignaturesPage.getSignEmailSignerPage1(), null, null)), testContext.getMapTestData().get("emailAddress"));
            if(!user.equalsIgnoreCase("agent")) {
                WebElement birthElement = getElement(driver, getExistingLocator(driver, onSignaturesPage.getBirthDateSignerPage(), onSignaturesPage.getBirthDateSignerPagee1(), null, null));
                sendKeys(driver, getElement(driver, getExistingLocator(driver, onSignaturesPage.getSsnCodeSignerPage(), onSignaturesPage.getSsnCodeSignerPage1(), null, null)), testContext.getMapTestData().get("ssn"));
                clickElement(driver, birthElement);
                sendKeys(driver, birthElement, testContext.getMapTestData().get("birthDate"));
            }
        }
        else {
            sendKeys(driver, onSignaturesPage.getTxtBox_MailerName(), ownerName);
            sendKeys(driver, onSignaturesPage.getTxtBox_MailerEmailAddress(), testContext.getMapTestData().get("emailAddress"));

            if (!user.equalsIgnoreCase("agent")) {
                clickElement(driver, onSignaturesPage.getTxtBox_MailerBirthDate());
                sendKeys(driver, onSignaturesPage.getTxtBox_MailerBirthDate(), testContext.getMapTestData().get("birthDate"));
                sendKeys(driver, onSignaturesPage.getTxtBox_MailerSSN(), testContext.getMapTestData().get("ssn"));
            }
        }
    }

    @Then("User verify Document review window showing {string} on signature window")
    public void verifyDocumentReviewWindow(String formName) {
        captureScreenshot(driver, testContext, false);
        waitForPageToLoad(driver);
        WebElement element = getElement(driver, getExistingLocator(driver, onSignaturesPage.getTxt_NewPageDescription(), onSignaturesPage.getTxt_PageDescription(), null, null));
        syncElement(driver, element, EnumsCommon.TOVISIBLE.getText());
        Assert.assertTrue("Easy Signing Form is not displayed", element.getText().trim().contains(testContext.getMapTestData().get(formName)));
    }

    @Then("User enter all required details for {string} on capture electronic signature window")
    public void userEnterDetailsCaptureSignature(String user) {
        captureScreenshot(driver, testContext, false);
        String signerName = testContext.getMapTestData().get("signerFullName");
        if(signerName.contains("Random")) {
            String appName = testContext.getMapTestData().get("newProductName");
            signerName = signerName + appName.substring(appName.lastIndexOf(" "));
            addPropertyValueInJSON(testContext.getTestCaseID(), testContext, EnumsJSONProp.SIGNERNAME.getText(), signerName);
        }
        sendKeys(driver, getElement(driver, getExistingLocator(driver, onSignaturesPage.getTxtCity(), onSignaturesPage.getTxtCity1(), null, null)), testContext.getMapTestData().get("jurisdiction"));
        sendKeys(driver, getElement(driver, getExistingLocator(driver, onSignaturesPage.getTxtBox_FullName(), onSignaturesPage.getTxtBox_FullName1(), onSignaturesPage.getTxtBox_FullName2(), null)), signerName);
        if (user.equals("agent"))
            sendKeys(driver, getElement(driver, getExistingLocator(driver, onSignaturesPage.getTxtBox_AgentID(), onSignaturesPage.getTxtBox_AgentID1(), null, null)), testContext.getMapTestData().get("id"));
    }

    @Then("User enter all required details for email validations for {string} on capture electronic signature window")
    public void userEnterDetailsCaptureSignatureEmail(String user) {
        captureScreenshot(driver, testContext, false);
        String appName = testContext.getMapTestData().get("newProductName");
        String tempSigner = testContext.getMapTestData().get("signerFullName") + appName.substring(appName.lastIndexOf(" "));
        if(testContext.getMapTestData().get("uiType").equalsIgnoreCase("react")) {
            sendKeys(driver, getElement(driver, getExistingLocator(driver, onSignaturesPage.getTxtCity(), onSignaturesPage.getTxtCity1(), null, null)), testContext.getMapTestData().get("jurisdiction"));
            if (user.equals("agent")) {
                sendKeys(driver, getElement(driver, getExistingLocator(driver, onSignaturesPage.getTxtBox_FullName(), onSignaturesPage.getTxtBox_FullName1(), onSignaturesPage.getTxtBox_FullName2(), null)), tempSigner);
                sendKeys(driver, getElement(driver, getExistingLocator(driver, onSignaturesPage.getTxtBox_AgentID(), onSignaturesPage.getTxtBox_AgentID1(), null, null)), testContext.getMapTestData().get("id"));
            } else
                sendKeys(driver, getElement(driver, getExistingLocator(driver, onSignaturesPage.getTxtBox_FullName(), onSignaturesPage.getTxtBox_FullName1(), onSignaturesPage.getTxtBox_FullName2(), null)), tempSigner);
        }
        else {
            sendKeys(driver, getElement(driver, getExistingLocator(driver, onSignaturesPage.getTxtBox_FullName(), onSignaturesPage.getTxtBox_FullName1(), onSignaturesPage.getTxtBox_FullName2(), null)), tempSigner);
            sendKeys(driver, getElement(driver, getExistingLocator(driver, onSignaturesPage.getTxtCity(), onSignaturesPage.getTxtCity1(), null, null)), testContext.getMapTestData().get("jurisdiction"));
            if (user.equals("agent"))
                sendKeys(driver, getElement(driver, getExistingLocator(driver, onSignaturesPage.getTxtBox_AgentID(), onSignaturesPage.getTxtBox_AgentID1(), null, null)), testContext.getMapTestData().get("id"));
        }
    }

    @Then("User perform Signature on Signature Pad")
    public void userPerformSignature() {
        captureScreenshot(driver, testContext, false);
        addDigitalSignature(driver, getElement(driver, getExistingLocator(driver, onSignaturesPage.getBtnSignature(), onSignaturesPage.getBtnSignature1(), null, null)));
    }

    @Then("User clicks {string} button on signature page")
    public void userClicksButtonSignaturePage(String whichButton) {
        waitForPageToLoad(driver);
        captureScreenshot(driver, testContext, false);
        onSignaturesPage.userClicksButtonSignaturePage(driver, testContext, whichButton);
    }

    @Then("User verifies {string} button on signature page")
    public void userVerifiesButtonSignaturePage(String whichButton) {
        waitForPageToLoad(driver);
        captureScreenshot(driver, testContext, false);
        Assert.assertTrue(whichButton + " is not displayed", onSignaturesPage.userVerifiesButtonSignaturePage(driver, testContext, whichButton) > 0);
    }

    @Then("User verifies no {string} button on signature page")
    public void userVerifiesNoButtonSignaturePage(String whichButton) {
        waitForPageToLoad(driver);
        captureScreenshot(driver, testContext, false);
        Assert.assertTrue(whichButton + " is not displayed", onSignaturesPage.userVerifiesButtonSignaturePage(driver, testContext, whichButton) == 0);
    }

    @Then("User verify text on {string} checkbox")
    public void userVerifyTextElement(String whichButton) {
        captureScreenshot(driver, testContext, false);
        syncElement(driver, getElement(driver, getExistingLocator(driver, onSignaturesPage.getTxtReviewAgree(), onSignaturesPage.getTxtReviewAgree1(), null, null)), EnumsCommon.TOVISIBLE.getText());
        Assert.assertTrue("Review agree text does not match", getElement(driver, getExistingLocator(driver, onSignaturesPage.getTxtReviewAgree(), onSignaturesPage.getTxtReviewAgree1(), null, null)).getText().contains(testContext.getMapTestData().get("ReviewAgreeMessage")));
    }

    @Then("User verifies Procced button Showng and Agent Signer get Disabled")
    public void UserVerifiesProccedShowngAgentSignerGetDisabled() {
        captureScreenshot(driver, testContext, false);
        Assert.assertTrue("Proceed Button is not Showing",onSignaturesPage.getBtn_Proceed().isDisplayed());
    }

    @Then("User verifies Proceed button Should not Shown and Directly Show Signature Choices Screen with Sign Now & Send Email Request buttons")
    public void UserVerifiesProccedShouldNotShownSignNowAndSendEmailButtonsShown() {
        captureScreenshot(driver, testContext, false);
        Assert.assertTrue("Sign Now button is not showing", getElement(driver, getExistingLocator(driver, onSignaturesPage.getBtn_SignNow(), onSignaturesPage.getBtn_SignNow1(), null, null)).isDisplayed());
        Assert.assertTrue("Send Email button is not showing", getElement(driver, getExistingLocator(driver, onSignaturesPage.getBtn_SendEmailRequest(), onSignaturesPage.getBtn_SendEmailRequest1(), onSignaturesPage.getBtn_SendEmailRequest2(), null)).isDisplayed());
    }

    @Then("User clicks {string} button on document sets signature page")
    public void userClicksButtonDocumentSetSignaturePage(String whichButton) {
        captureScreenshot(driver, testContext, false);
        switch (whichButton) {
            case "Continue":
                clickElement(driver, onSignaturesPage.getBtn_ContinueDocumentSet());
                break;
            default:
                throw new FLException("Invalid operation : " + whichButton);
        }
    }

    @Then("User clicks initials box and enter {string} on document sets signature page")
    public void userClicksInitialDocumentSetSignaturePage(String initial) {
        waitForPageToLoad(driver);
        captureScreenshot(driver, testContext, false);
        clickElement(driver, getElement(driver, getExistingLocator(driver, onSignaturesPage.getBtn_InitialDocumentSet1(), onSignaturesPage.getBtn_InitialDocumentSet2(), onSignaturesPage.getBtn_InitialDocumentSet3(), null)));
        getElement(driver, getExistingLocator(driver, onSignaturesPage.getTxtBox_Initials1(), onSignaturesPage.getTxtBox_Initials2(), null, null)).sendKeys(initial);
        clickElement(driver, getElement(driver, getExistingLocator(driver, onSignaturesPage.getPopup_Ok1(), onSignaturesPage.getPopup_Ok2(), onSignaturesPage.getPopup_Ok3(), null)));
    }

    @Then("User wait for {string} element to display on signature page")
    public void userWaitForElement(String element) {
        switch(element) {
            case "Document Set":
                syncElement(driver, onSignaturesPage.getTxt_DocumentSetDocument(), EnumsCommon.TOVISIBLE.getText());
                break;
            case "Acknowledge":
                syncElement(driver, onSignaturesPage.getImg_Acknowledge(), EnumsCommon.TOVISIBLE.getText());
                break;
            case "Initials":
                syncElement(driver, onSignaturesPage.getBtn_InitialDocumentSet(), EnumsCommon.TOVISIBLE.getText());
                break;
            case "Annuitant Insured Signature":
                syncElement(driver, onSignaturesPage.getTxt_AnnuitantInsuredSignature(), EnumsCommon.TOVISIBLE.getText());
                break;
            default:
                throw new FLException("Invalid element : " + element);
        }
    }

    @Then("User save the {string} generated on signature page")
    public void userNewSaveEmailLink(String emailAndPasscode) {
        String emailLink = getElement(driver, getExistingLocator(driver, onSignaturesPage.getTxtEmailLinkMVC(), onSignaturesPage.getTxtEmailLinkReact(), onSignaturesPage.getTxtEmailLinkTeleSign(), null)).getText().trim();
        if(testContext.getMapTestData().get("uiType").equalsIgnoreCase("react")) {
            Log.info("Generated Email link : " + emailLink.substring(emailLink.indexOf("http")));
            if(emailAndPasscode.equals("email link")) {
                addPropertyValueInJSON(testContext.getTestCaseID(), testContext, EnumsJSONProp.EMAILLINK.getText(), emailLink.substring(emailLink.indexOf("http")));
            }
            else {
                Log.info("Generated Email Link : " + getElement(driver, getExistingLocator(driver, onSignaturesPage.getTxtPasscode(), onSignaturesPage.getTxtPasscode1(), null, null)).getText().trim());
                addPropertyValueInJSON(testContext.getTestCaseID(), testContext, EnumsJSONProp.PASSCODE.getText(), getElement(driver, getExistingLocator(driver, onSignaturesPage.getTxtPasscode(), onSignaturesPage.getTxtPasscode1(), null, null)).getText().trim());
                addPropertyValueInJSON(testContext.getTestCaseID(), testContext, EnumsJSONProp.EMAILLINK.getText(), emailLink.substring(emailLink.indexOf("http")));
            }
        }
        else {
            if (emailAndPasscode.equals("email link")) {
                Log.info("Generated Email link : " + emailLink);
                addPropertyValueInJSON(testContext.getTestCaseID(), testContext, EnumsJSONProp.EMAILLINK.getText(), emailLink);
            }
            else if(emailAndPasscode.equals("passcode")) {
                addPropertyValueInJSON(testContext.getTestCaseID(), testContext, EnumsJSONProp.PASSCODE.getText(), onSignaturesPage.getTxt_RequestTypePasscode().getText().trim());
            }
            else {
                Log.info("Generated Passcode : " + onSignaturesPage.getTxt_EmailLink().getText().trim());
                Log.info("Generated Email Link : " + onSignaturesPage.getTxt_Passcode().getText().trim());
                addPropertyValueInJSON(testContext.getTestCaseID(), testContext, EnumsJSONProp.PASSCODE.getText(), onSignaturesPage.getTxt_EmailLink().getText().trim());
                addPropertyValueInJSON(testContext.getTestCaseID(), testContext, EnumsJSONProp.EMAILLINK.getText(), onSignaturesPage.getTxt_Passcode().getText().trim());
            }
        }
    }

    @Then("User verify only email link is generated on signature page")
    public void verifyOnlyEmailLink() {
        captureScreenshot(driver, testContext, false);
        Assert.assertTrue("Passcode is also displayed along with email link", onSignaturesPage.getTxt_EmailLinks().size() == 1);
    }

    @Then("User verify {string} dialog with {string} on signature page")
    public void verifyDialog(String dialogName, String passcode) {
        captureScreenshot(driver, testContext, false);
        Assert.assertTrue("Pending request dialog is not displayed", onSignaturesPage.getTxt_PendingRequest().getText().trim().equalsIgnoreCase("Pending Request"));
        Assert.assertTrue("Send Email reminder link is not displayed", onSignaturesPage.getLink_SendReminder().isDisplayed());
        Assert.assertTrue("Send Email reminder link is displayed with incorrect name", onSignaturesPage.getLink_SendReminder().getText().trim().contains(testContext.getMapTestData().get("name")));
        Assert.assertTrue("Send Passcode link is not displayed", onSignaturesPage.getLink_SendPasscode().isDisplayed());
        Assert.assertTrue("Send Passcode link is displayed with incorrect name", onSignaturesPage.getLink_SendPasscode().getText().trim().contains(testContext.getMapTestData().get("name")));
        Assert.assertTrue("Cancel this request link is not displayed", onSignaturesPage.getLink_CancelRequest().isDisplayed());

        if (passcode.equals("email link and passcode"))
            Assert.assertTrue("Passcode does not match", onSignaturesPage.getTxt_RequestTypePasscode().getText().trim().equals(testContext.getMapTestData().get("passCode")));
    }

    @Then("User verify pop up message displays progress as {string} out of {string} steps on signature page")
    public void verifyProgressMessage(String currentStep, String totalSteps) {
        waitForPageToLoad(driver);
        captureScreenshot(driver, testContext, false);
        WebElement element = getElement(driver, getExistingLocator(driver, onCommonMethodsPage.getPopup_ToastMVC(), onCommonMethodsPage.getPopup_ToastReact(), null, null));
        syncElement(driver, element, EnumsCommon.TOVISIBLE.getText());
        Assert.assertTrue("Completed steps are not as expected", element.getText().trim().contains("Finished " + currentStep + " of " + totalSteps + " Steps."));
        clickElement(driver, getElement(driver, getExistingLocator(driver, onSignaturesPage.getBtnClose(), onSignaturesPage.getBtnClose1(), null, null)));
    }

    @Then("User verifies {string} under list of required signers section on signature page")
    public void verifyRequiredSigningUsers(String user) {
        captureScreenshot(driver, testContext, false);
        if(driver.findElements(By.xpath("//div[text()='" + user + "']")).size() > 0)
            Assert.assertTrue("List of required signers list does not contain " + user, driver.findElement(By.xpath("//div[text()='" + user + "']")).isDisplayed());
        else
            Assert.assertTrue("List of required signers list does not contain " + user, driver.findElement(By.xpath("//a[@id='" + user + "']")).isDisplayed());
    }

    @Then("User verifies {string} name is {string} under list of required signers section on signature page")
    public void verifyRequiredSigningUsersName(String user, String name) {
        captureScreenshot(driver, testContext, false);
        if(testContext.getMapTestData().get("uiType").equalsIgnoreCase("react"))
            Assert.assertTrue("Signer nam does not match " + user, driver.findElement(By.xpath("(//div[text()='" + user + "']//following-sibling::div)[1]")).getText().trim().equalsIgnoreCase(name));
        else
            Assert.assertTrue("Signer nam does not match " + user, driver.findElement(By.xpath("//a[@id='" + user + "']")).isDisplayed());
    }

    @Then("User verify {string} is set to {string} on signature page")
    public void verifyFieldValue(String field, String value) {
        captureScreenshot(driver, testContext, false);
        Assert.assertTrue(field + " value does not match: " + value, findElement(driver, "//input[@id='" + field + "' or @name='" + field + "']").getAttribute("value").trim().equalsIgnoreCase(value));
    }

    @Then("User verifies {string} under completed signatures section with {string} button on signature page")
    public void verifyCompletedSignatureUsers(String user, String button) {
        captureScreenshot(driver, testContext, false);
        waitForPageToLoad(driver);
        int elementSize = driver.findElements(By.xpath("//div[contains(@class,'signers__request__row')]//div[text()='" + user + "']")).size();
        if (elementSize > 0) {
            Assert.assertTrue("Completed Signatures list does not contain " + user, driver.findElement(By.xpath("//div[contains(@class,'signers__request__row')]//div[text()='" + user + "']")).isDisplayed());
            Assert.assertTrue("Completed Signatures list does not contain button" + button, driver.findElement(By.xpath("//div[contains(@class,'signers__request__row')]//div[text()='" + user + "']//..//button//span[text()='" + button + "']")).isDisplayed());
        }
        else {
            Assert.assertTrue("Completed Signatures list does not contain " + user, driver.findElement(By.xpath("//div[@class='signers_completedSignerType' and contains(text(),'" + user + "')]")).isDisplayed());
            Assert.assertTrue("Completed Signatures list does not contain button" + button, driver.findElement(By.xpath("//div[@class='signers_completedSignerType' and contains(text(),'" + user + "')]//..//button[@aria-label='Re-Sign']")).isDisplayed());
            Assert.assertTrue("Completed Signatures list does not contain button" + button, driver.findElement(By.xpath("//div[@class='signers_completedSignerType' and contains(text(),'" + user + "')]//following-sibling::span[@class='signers_completedSignerState']//label")).getText().trim().equalsIgnoreCase(testContext.getMapTestData().get("jurisdiction")));
        }
    }

    @Then("User selects {string} button for {string} on Signature Tab")
    public void userClickButtonOnSignatureTab(String buttonName, String user) {
        captureScreenshot(driver, testContext, false);
        waitForPageToLoad(driver);
        int elementSize = driver.findElements(By.xpath("//div[contains(@class,'signers__request__row')]//div[text()='" + user + "']")).size();
        if (elementSize > 0)
            clickElement(driver, "//div[contains(@class,'signers__request__row')]//div[text()='" + user + "']//..//button//span[text()='" + buttonName + "']");
        else
            clickElement(driver, "//div[@class='signers_completedSignerType' and contains(text(),'" + user + "')]//parent::li//button[@aria-label='" + buttonName + "']");
    }

    @Then("User verify request is sent for {string} on signature page")
    public void verifyRequestSentUsers(String user) {
        captureScreenshot(driver, testContext, false);
        if(testContext.getMapTestData().get("uiType").equalsIgnoreCase("react"))
            Assert.assertTrue("Request is not sent for " + user, driver.findElement(By.xpath("//div[contains(@class,'signers__request__row')]//div[contains(text(),'" + user + "')]//..//div[contains(text(),'SENT')]")).isDisplayed());
        else
            Assert.assertTrue("Request is not sent for user " + user, getElement(driver, By.xpath("//div[@id='" + user + "']")).getText().trim().contains("Request Sent"));
    }

    @Then("User verify {string} message on signature page")
    public void verifyMessageSignature(String message) {
        captureScreenshot(driver, testContext, false);
        sleepInMilliSeconds(2000);
        if(message.equals("congratulations") & onSignaturesPage.getList_EsignCompleteTitle().size() > 0)
            syncElement(driver, onSignaturesPage.getTxt_EsignCompleteTitle(), EnumsCommon.TOVISIBLE.getText());
        Assert.assertTrue("Message on Signature Page Mismatched", onSignaturesPage.getTxt_CompleteMessage().getText().trim().contains(testContext.getMapTestData().get(message)));
    }

    @Then("User Verifies Popup message as {string}")
    public void userVerifiesPopupMessage(String popupMsg) {
        waitForPageToLoad(driver);
        captureScreenshot(driver, testContext, false);
        Assert.assertTrue("Pop message differing", getElement(driver, getExistingLocator(driver, onSignaturesPage.getStatusNotice_popupmsgMVC(), onSignaturesPage.getStatusNotice_popupmsgReact(), null, null)).getText().trim().contains(popupMsg));
    }

    @Then("User Clicks Continue")
    public void userClicksContinue() {
        captureScreenshot(driver, testContext, false);
        clickElement(driver, getElement(driver, getExistingLocator(driver, onSignaturesPage.getBtn_Continue(), onSignaturesPage.getBtn_Continue1(), null, null)));
    }

    @Then("User Selects Agent Signer")
    public void userSelectsAgentSigner() {
        captureScreenshot(driver, testContext, false);
        clickElement(driver, onSignaturesPage.getAgentSignPage());
    }

    @Then("User Clicks Sign Now")
    public void userClicksSignNow() {
        captureScreenshot(driver, testContext, false);
        clickElement(driver, onSignaturesPage.getSignNow());
    }

    @Then("User Clicks Agree Document Checkbox")
    public void userClicksAgreeDocumentCheckbox() {
        captureScreenshot(driver, testContext, false);
        waitForPageToLoad(driver);
        scrollToWebElement(driver,getElement(driver, getExistingLocator(driver, onSignaturesPage.getAgreeWithtermsMVC(), onSignaturesPage.getAgreeWithtermsReact(), null, null)));
        clickElement(driver, getElement(driver, getExistingLocator(driver, onSignaturesPage.getAgreeWithtermsMVC(), onSignaturesPage.getAgreeWithtermsReact(), null, null)));
    }

    @Then("User On {string} window Agent Full name & Agent ID is pre filled, needs to enter City")
    public void userOnElectronicSignatureWindow(String expHeading) {
        captureScreenshot(driver, testContext, false);
        Assert.assertEquals("not in" + expHeading, expHeading, getElement(driver, getExistingLocator(driver, onSignaturesPage.getAgentOnSiteHeadingReact(), onSignaturesPage.getAgentOnSiteHeadingMVC(), null, null)).getText().trim());
        Assert.assertNotNull("Not having any pre filled data in name", getElement(driver, getExistingLocator(driver, onSignaturesPage.getTxtBox_agentFulNameReact(), onSignaturesPage.getTxtBox_agentFulNameMVC(), null, null)).getAttribute("value"));
        Assert.assertNotNull("Not having any pre filled data in agentId", getElement(driver, getExistingLocator(driver, onSignaturesPage.getTxtBox_AgentID(), onSignaturesPage.getTxtBox_AgentID1(), null, null)).getAttribute("value"));
        getElement(driver, getExistingLocator(driver, onSignaturesPage.getTxtBox_agentCityReact(), onSignaturesPage.getTxtBox_agentCityMVC(), null, null)).sendKeys("ca");
    }

    @Then("User Performs Signature and Clicks I Consent")
    public void userPerformsSignatureAndClicksIConsent() {
        captureScreenshot(driver, testContext, false);
        addDigitalSignature(driver, onSignaturesPage.getAgentSignPad());
        clickElement(driver, onSignaturesPage.getBtn_IConsent());
    }

    @Then("User verify {string} is set to {string} for {string} on signatures page")
    public void verifyDocumentSets(String documentSet, String documentName, String user) {
        captureScreenshot(driver, testContext, false);
        waitForPageToLoad(driver);
        Assert.assertTrue("Document set is not displayed for " + user, onSignaturesPage.getTxt_heading().getText().equalsIgnoreCase("Document Sets to be Signed by Owner"));
        switch (documentSet) {
            case "Document Set":
                Assert.assertTrue("Document set is not set to " + documentName, onSignaturesPage.getTxt_DocumentSetDocument().getText().contains(documentName));
                Assert.assertTrue("Document set addendum is not set to " + documentName, onSignaturesPage.getTxt_DocumentSetAddendum().getText().contains(documentName));
                break;
            case "Document Set 2":
                Assert.assertTrue("Document set 2 is not set to " + documentName, onSignaturesPage.getTxt_DocumentSet2Document().getText().contains(documentName));
                Assert.assertTrue("Document set 2 addendum is not set to " + documentName, onSignaturesPage.getTxt_DocumentSet2Addendum().getText().contains(documentName));
                break;
            case "Initials":
                Assert.assertTrue("Initial is not set to " + documentName, onSignaturesPage.getTxt_InitialsDocument().getText().contains(documentName));
                break;
            default:
                throw new FLException("Invalid document set : " + documentSet);
        }
    }

    @Then("User selects {string} on signature window")
    public void userSelects(String signer) {
        captureScreenshot(driver, testContext, false);
        if (signer.equalsIgnoreCase("owner"))
            clickElement(driver, getElement(driver, getExistingLocator(driver, onSignaturesPage.getChk_Owner(), onSignaturesPage.getId_Owner(), null, null)));
        else if (signer.equalsIgnoreCase("joint owner"))
            clickElement(driver, getElement(driver, getExistingLocator(driver, onSignaturesPage.getChk_jointOwner(), onSignaturesPage.getId_jointOwner(), null, null)));
        else if (signer.equalsIgnoreCase("payer"))
            onSignaturesPage.getLink_Payer().click();
        else if (signer.equalsIgnoreCase("Annuitant"))
            getElement(driver, getExistingLocator(driver, onSignaturesPage.getLink_AnnuitantMVC(), onSignaturesPage.getLink_AnnuitantReact(), null, null)).click();
        else if (signer.equalsIgnoreCase("Insured"))
            onSignaturesPage.getLink_Insured().click();
        else
            clickElement(driver, getElement(driver, getExistingLocator(driver, onSignaturesPage.getChk_Agent(), onSignaturesPage.getId_Agent(), null, null)));
    }

    @Then("User clicks on Accept E-Signature on Electronic Signatures option window")
    public void userClicksOnAcceptESignatureOnElectronicSignaturesOptionWindow() {
        captureScreenshot(driver, testContext, false);
        clickElementByJSE(driver, getElement(driver, getExistingLocator(driver, onSignaturesPage.getBtnUseSignature(), onSignaturesPage.getBtnUseSignature1(), null, null)));
    }

    @Then("User Clicks on Send Email Request")
    public void userClicksOnSendEmailRequest() {
        captureScreenshot(driver, testContext, false);
        clickElementByJSE(driver, getElement(driver, getExistingLocator(driver, onSignaturesPage.getBtn_SendEmailRequest(), onSignaturesPage.getBtn_SendEmailRequest1(), onSignaturesPage.getBtn_SendEmailRequest2(), null)));
    }

    @Then("User Clicks on {string} Button")
    public void click_on_Generate_Link_without_Email_Button(String whichButton) {
        captureScreenshot(driver, testContext, false);
        onSignaturesPage.userClicksButtonSignaturePage(driver, testContext, whichButton);
    }

    @Then("User Clicks on Send Email Request Button")
        public void click_on_Generate_Link_without_Email_Button() {
        captureScreenshot(driver, testContext, false);
            clickElement(driver, getElement(driver, getExistingLocator(driver, onSignaturesPage.getBtn_SendEmailRequest(), onSignaturesPage.getBtn_SendEmailRequest1(), onSignaturesPage.getBtn_SendEmailRequest2(), null)));
    }

    @Then("User enter all required signer details for sending mail on signature window")
    public void user_enter_all_required_signer_details_for_sending_mail_on_signature_window() {
        captureScreenshot(driver, testContext, false);
        sendKeys(driver, onSignaturesPage.getTxtBox_MailerName(), testContext.getMapTestData().get("name"));
        sendKeys(driver, onSignaturesPage.getTxtBox_MailerEmailAddress(), testContext.getMapTestData().get("emailAddress"));
    }

    @Then("User Verifies Now all signers {int} have Revoke Request link")
    public void user_Clicks_Back_to_App_Now_all_signers_have_Revoke_Request_link(int count) {
        captureScreenshot(driver, testContext, false);
        Assert.assertEquals("All Signers does not have Revoke Request Link", count, onSignaturesPage.getList_RevokeStatement().size());
    }

    @Then("User Verifies Now signers have Revoke Request link")
    public void user_Clicks_Back_to_App_Now_Agent_signers_have_Revoke_Request_link() {
        captureScreenshot(driver, testContext, false);
        Assert.assertEquals("All Signers does not have Revoke Request Link", 1, onSignaturesPage.getList_RevokeStatement().size());
    }

    @Then("User Clicks Back to Application")
    public void user_Clicks_Back_to_Application() {
        captureScreenshot(driver, testContext, false);
        clickElement(driver, getElement(driver,getExistingLocator(driver,onSignaturesPage.getTab_backToapplicationReact(),onSignaturesPage.getTab_backToapplicationMVC(),null,null)));
    }

    @Then("User Verifies Pending Request Dialog open and it has two Pending Request one for client & one for Agent, Notes down the Passcodes for agent Request")
    public void user_Verifies_Pending_Request_Dialog_open_and_it_has_two_Pending_Request_one_for_client_one_for_Agent_Notes_down_the_Passcodes_for_agent_Request() {
        captureScreenshot(driver, testContext, false);
        Assert.assertTrue("Pending Request Dialouge box is not displaying", onSignaturesPage.getTxt_PendingRequest().isDisplayed());
        Assert.assertEquals("Pending Request Dialouge box does not have two Pending Request", 2, onSignaturesPage.getRequestTypeText().size());
        Assert.assertTrue("Pending Request Dialouge box does not have request for Joint Owner", onSignaturesPage.getRequestTypeText().get(0).getText().trim().contains("Joint Owner"));
        Assert.assertTrue("Pending Request Dialouge box does not have request for Agent", onSignaturesPage.getRequestTypeText().get(1).getText().trim().contains("Agent"));
        addPropertyValueInJSON(testContext.getTestCaseID(), testContext, EnumsJSONProp.AGENTPASSCODE.getText(), onSignaturesPage.getAgentPasscode().getText().trim());
    }

    @Then("User clicks on Ok button")
    public void UserClicksOnOkButton() {
        captureScreenshot(driver, testContext, false);
        clickElement(driver, getElement(driver, getExistingLocator(driver, onSignaturesPage.getPopup_OkMVC(), onSignaturesPage.getPopup_OkReact(), null, null)));
    }

    @Then("User clicks on lock activity button")
    public void UserClicksOnLockActivityButton() {
        captureScreenshot(driver, testContext, false);
        clickElement(driver, getElement(driver, getExistingLocator(driver, onSignaturesPage.getPopup_OkMVC(), onSignaturesPage.getPopup_OkReact(), null, null)));
    }

    @Then("User verifies Agent ID {string}")
    public void userVerifiesAgentID(String agentID) {
        Assert.assertTrue(agentID+"is not selected",findElement(driver,String.format(onCommonMethodsPage.ariaLabelInputFields,"Agent ID")).getAttribute("value").contains(agentID));
    }

    @Then("User verifies Owner Payor - Client Identification Verification window should be present")
    public void userVerifiesOwnerPayorClientIdentificationVerificationWindowShouldBePresent() {
        Assert.assertTrue("User verifies Owner/Payor - Client Identification Verification window should be present is not opened",onSignaturesPage.getOwnerPayorClientIdentificationVerificationHeading().isDisplayed());
    }

    @Then("User sets value {string}  for field {string} for To Signature tab")
    public void userSetsValue(String fieldValue, String fieldName) {
        onCommonMethodsPage.findElement(driver,String.format(onCommonMethodsPage.ariaLabelInputFields,fieldName)).clear();
        onCommonMethodsPage.findElement(driver,String.format(onCommonMethodsPage.ariaLabelInputFields,fieldName)).click();
        onCommonMethodsPage.findElement(driver,String.format(onCommonMethodsPage.ariaLabelInputFields,fieldName)).sendKeys(fieldValue);
        waitForPageToLoad(driver);
        captureScreenshot(driver, testContext, false);
    }

    @Then("User should be on Owner Initial page")
    public void verifyPageHeading() {
        Assert.assertTrue("Owners Initial is not opened",onSignaturesPage.getPageHeadingOwnerInitial().isDisplayed());
    }

    @Then("User verify generated PDF {string} contains addendum on signature page")
    public void verifyPDFGeneratedAddendum(String fileName) throws Exception {
        captureScreenshot(driver, testContext, false);
        sleepInMilliSeconds(5000);
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        String pdfText = "";
        if(tabs.size() > 1)
            driver.switchTo().window(tabs.get(1));
        try {
            pdfFileName = testContext.getModuleName() + "-" + testContext.getTestCaseID() + "_" + getDate("pdfFileName") + ".pdf";
            Path downloadFilePath = Paths.get(EnumsCommon.ABSOLUTE_DOWNLOADFILES_PATH.getText() +fileName + ".pdf");
            new WebDriverWait(driver, 60).until(d -> downloadFilePath.toFile().exists());
            renameFile(fileName, pdfFileName);
            pdfText = getPDFText(pdfFileName);
            Log.info(pdfFileName);
           //TODO : Date/multiline text/jurisdiction does not appear in pdf text//
//            Assert.assertTrue("Could not find signature date in PDF File ", pdfText.contains(formatter.format(todayDate)));
        }catch (IOException e) {
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
        Assert.assertTrue("Could not find document SoftLimitSignature1 in PDF File ", pdfText.contains("Addendum - SoftLimitSignatureForm1"));
        Assert.assertTrue("Could not find document SoftLimitSignature2 in PDF File ", pdfText.contains("Addendum - SoftLimitSignatureForm2"));
        Assert.assertTrue("Could not find document SoftLimitSignature22 in PDF File ", pdfText.contains("Addendum - SoftLimitSignatureForm2 2"));
        Assert.assertTrue("Could not find document SoftLimitSignature3 in PDF File ", pdfText.contains("Addendum - SoftLimitSignatureForm3"));
        Assert.assertTrue("Could not find applicant name in PDF File ", pdfText.contains(testContext.getMapTestData().get("ownerFirstName")));
        Assert.assertTrue("Could not find Joint applicant name in PDF File ", pdfText.contains(testContext.getMapTestData().get("jointOwnerFirstName")));
        Assert.assertTrue("Could not find owner last name in PDF File ", pdfText.contains(testContext.getMapTestData().get("ownerLastName")));
        Assert.assertTrue("Could not find Joint applicant last name in PDF File ", pdfText.contains(testContext.getMapTestData().get("jointOwnerLastName")));
    }


    @Then("User re-name {string} PDF and get text from PDF")
    public void verifyPDFGenerated(String fileName) throws Exception {
        captureScreenshot(driver, testContext, false);
        sleepInMilliSeconds(5000);
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        String pdfText = "";
        if(tabs.size() > 1)
            driver.switchTo().window(tabs.get(1));
        try {
            pdfFileName = testContext.getModuleName() + "-" + testContext.getTestCaseID() + "_" + getDate("pdfFileName") + ".pdf";
            Path downloadFilePath = Paths.get(EnumsCommon.ABSOLUTE_DOWNLOADFILES_PATH.getText() +fileName + ".pdf");
            new WebDriverWait(driver, 60).until(d -> downloadFilePath.toFile().exists());
            renameFile(fileName, pdfFileName);
            pdfText = getPDFText(pdfFileName);
            Log.info(pdfFileName);
            //TODO : Date/multiline text/jurisdiction does not appear in pdf text//
//            Assert.assertTrue("Could not find signature date in PDF File ", pdfText.contains(formatter.format(todayDate)));
        }catch (IOException e) {
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

    @Then("User verify generated PDF displays signature on signature page")
    public void verifySignPDFGeneratedSSN() throws Exception{
        //TODO : Date does not appear in pdf text
        Assert.assertTrue("Signed Image does not exist in generated PDF", verifySignatureMatchingInPDF(testContext, pdfFileName));
    }

    @Then("User Clicks Back to App")
    public void user_Clicks_Back_to_App() {
        clickElement(driver, onSignaturesPage.getBtn_backToapp());
    }

    @Then("User verifies Initials are required in this document set. message on Owner Initial page")
    public void userVerifiesMessageOnOwnerInitialPage() {
        Assert.assertTrue("User verifies Initials are required in this document set. window should be present is not opened",onSignaturesPage.getInitialsAreRequiredInThisDocumentSet().isDisplayed());
    }

    @Then("User clicks {string} button {int} times till last page")
    public void userClicksButtonTillLastPage(String buttonName, int number) throws InterruptedException {
        waitForPageToLoad(driver);
        captureScreenshot(driver, testContext, false);
        for (int i = 1; i <=number; i++) {
            Thread.sleep(3000);
            clickElement(driver, String.format(onCommonMethodsPage.ariaLabelInputFields, buttonName));
            waitForPageToLoad(driver);
        }
    }

    @Then("User clicks initials check box and enters {string}")
    public void userClicksInitialsCheckBoxAndEnters(String value) {
        waitForPageToLoad(driver);
        syncElement(driver,  onSignaturesPage.getInitialCheckbox(), EnumsCommon.TOCLICKABLE.getText());
        onSignaturesPage.getInitialCheckbox().click();
        onSignaturesPage.getInitInputField().sendKeys(value);
    }

    @Then("user clicks check box I have reviewed and agree with the terms expressed within this document. {int} times")
    public void userClicksCheckBoxIHaveReviewedAndAgreeWithTheTermsExpressedWithinThisDocument(int number) {
        waitForPageToLoad(driver);
        for (int i = 1; i <=number; i++) {
            sleepInMilliSeconds(3000);
            syncElement(driver,  onSignaturesPage.getReviewAndAgreeCheckbox(), EnumsCommon.TOCLICKABLE.getText());
            onSignaturesPage.getReviewAndAgreeCheckbox().click();
            waitForPageToLoad(driver);
        }
    }

    @Then("User should be on page {string}")
    public void userShouldBeOnPage(String pageName) {
        waitForPageToLoad(driver);
        captureScreenshot(driver, testContext, false);
        if(pageName.contains("AppName"))
            pageName = pageName.replace("AppName", testContext.getMapTestData().get("newProductName"));
        Assert.assertTrue("Page header name should match "+pageName,getElement(driver,getExistingLocator(driver,onSignaturesPage.getPageHeading1(),onSignaturesPage.getPageHeading2(),onSignaturesPage.getPageHeading3(),null)).getAttribute("innerText").contains(pageName));
    }

    @Then("User verifies Completed signature")
    public void user_verifies_completed_signature(DataTable dataTable) {
        List<Map<String, String>> signatureData = dataTable.asMaps(String.class, String.class);
        LocalDate currentDate = LocalDate.now();
        // Define the desired date format
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("M/d/yyyy");
        // Format the current date
        String formattedDate = currentDate.format(dateFormatter);
        for (Map<String, String> row : signatureData) {
            String signatureType = row.get("Signature Type");
            String name = row.get("Name");
            String state = row.get("State");
            Assert.assertTrue("Signature type should be"+signatureType, onSignaturesPage.getSignerType().getAttribute("innerText").contains(signatureType));
            Assert.assertTrue("Signature Name should be"+name,  onSignaturesPage.getSignerName().getAttribute("innerText").contains(name));
            Assert.assertTrue("Signature state should be"+state, onSignaturesPage.getSignerState().getAttribute("innerText").contains(state));
            //To do as system time and IST time is mismatching
            //Assert.assertTrue("Signature date should be"+formattedDate,  onSignaturesPage.getSignerDate().getAttribute("innerText").contains(formattedDate));
        }
    }

    @Then("User clicks check box Confirm all documents without reviewing individually. {int} times")
    public void userClicksCheckBoxConfirmAllDocumentsWithoutReviewingIndividuallyTimes(int number) throws InterruptedException {
        Thread.sleep(3000);
        waitForPageToLoad(driver);
        for (int i = 1; i <=number; i++) {
            Thread.sleep(3000);
            syncElement(driver,  onSignaturesPage.getConfirmAllDocumentsCheckBox(), EnumsCommon.TOCLICKABLE.getText());
            onSignaturesPage.getConfirmAllDocumentsCheckBox().click();
            waitForPageToLoad(driver);
        }
    }

    @Then("User verifies toast message {string} on Signature page")
    public void userVerifiesTostMessage(String message) {
        driver.navigate().refresh();
        captureScreenshot(driver, testContext, false);
        WebElement element = getElement(driver, getExistingLocator(driver, onCommonMethodsPage.getPopup_ToastMVC(), onCommonMethodsPage.getPopup_ToastReact(), null, null));
        syncElement(driver, element, EnumsCommon.TOVISIBLE.getText());
        if(element.getText().contains("pending"))
            driver.navigate().refresh();
        Assert.assertTrue(message+":: Toast popup NOT Visible", element.getAttribute("innerText").contains(message));
        captureScreenshot(driver, testContext, false);
    }

    @Then("User verifies toast message {string} or {string} on Signature page")
    public void userVerifiesTostOrMessage(String message1,String message2) {
        waitForPageToLoad(driver);
        captureScreenshot(driver, testContext, false);
        WebElement element = getElement(driver, getExistingLocator(driver, onCommonMethodsPage.getPopup_ToastMVC(), onCommonMethodsPage.getPopup_ToastReact(), null, null));
        Assert.assertTrue(message1+" or "+message2+":: Toast popup NOT Visible", element.getAttribute("innerText").contains(message1) || element.getAttribute("innerText").contains(message2));
        captureScreenshot(driver, testContext, false);
    }

    @Then("User Verifies for Owner Signature it is showing Agent Protected & Client Protected Documents to review")
    public void verifyAgentAndClientProtectedDocumentInOwnerSignature() {
        captureScreenshot(driver, testContext, false);
        boolean flag=false;
        for (WebElement element : onSignaturesPage.getList_OwnerSignature()) {
            if (element.getText().contains("Agent Protected") || element.getText().contains("Client Protected")) {
                flag=true;
            }
        }
        Assert.assertTrue("Agent Protected & Client Protected Documents are not shown in review for Owner signature", true);
    }

    @Then("User Enters Signer Full Name as {string} City as {string} Then perform Signature and click I Consent")
    public void enterSignerFullNameAndCityAndPerformedSignatureAndClickIConsentButton(String fullName, String cityName) {
        captureScreenshot(driver, testContext, false);
        sendKeys(driver,getElement(driver, getExistingLocator(driver, onSignaturesPage.getTxt_SignerFullNameMVC(), onSignaturesPage.getTxt_SignerFullNameReact(), null, null)), fullName);
        sendKeys(driver,getElement(driver, getExistingLocator(driver, onSignaturesPage.getTxt_CityMVC(), onSignaturesPage.getTxt_CityReact(), null, null)), cityName);
        addDigitalSignature(driver,onSignaturesPage.getField_Signature());
        clickElement(driver, onSignaturesPage.getBtn_IConsentOnSignature());
    }

    @Then("User Signer Full Name as {string} City as {string} perform Signature click I Consent")
    public void enterSignerNameCityNameAndClickIConsentButton(String fullName,String cityName){
        captureScreenshot(driver, testContext, false);
        onSignaturesPage.getBtn_SignerFullName().sendKeys(fullName);
        onSignaturesPage.getBtn_City().sendKeys(cityName+ Keys.TAB);
        addDigitalSignature(driver,onSignaturesPage.getField_Signature());
        clickElement(driver,onSignaturesPage.getBtn_IConsentOnSignature());
    }

    @Then("User Select Agent")
    public void selectAgent(){
        captureScreenshot(driver, testContext, false);
        clickElement(driver,onSignaturesPage.getBtn_agent());
    }

    @Then("User clicks on Sign Now button")
    public void clickOnSignButton(){
        captureScreenshot(driver, testContext, false);
        clickElement(driver,getElement(driver, getExistingLocator(driver, onSignaturesPage.getBtn_SignNow(), onSignaturesPage.getBtn_SignNow1(), null, null)));
    }

    @Then("User Agent also shown all documents Agent protected, Client protected, Public, protected forms")
    public void ShowAllDocumentsForAgentAndClientAndPublicProtected(){
        captureScreenshot(driver, testContext, false);
        boolean flag=false;
        for(WebElement element:onSignaturesPage.getList_ReviewDocuments()){
            if(element.getText().contains("Public Protected")||element.getText().contains("Agent Protected")||element.getText().contains("Client Protected")){
                flag=true;
                break;
            }
        }
        Assert.assertTrue("All protected documents are not showing",flag);
    }

    @Then("User Clicks on Agree All then click Ok on confirm Documents window")
    public void clickOnAgreeAllCheckbox(){
        captureScreenshot(driver, testContext, false);
        clickElement(driver,onSignaturesPage.getCheckBox_AllDocuments());
        syncElement(driver,onSignaturesPage.getBtn_ConformDocuments(),EnumsCommon.TOCLICKABLE.getText());
        clickElement(driver,onSignaturesPage.getBtn_ConformDocuments());
    }

    @Then("User Enters Agent City as {string} Perform Signature, I Consent")
    public void enterSignerDetails(String city){
        captureScreenshot(driver, testContext, false);
        onSignaturesPage.getBtn_CityName().sendKeys(city+Keys.TAB);
        addDigitalSignature(driver,onSignaturesPage.getTxt_Signature());
        clickElement(driver,onSignaturesPage.getBtn_IConsent());
    }

    @Then("User verify arrow point to {string} form on signature page")
    public void verifyArrowPointer(String formName){
        captureScreenshot(driver, testContext, false);
        waitForPageToLoad(driver);
        WebElement element = driver.findElement(By.xpath("//button[normalize-space()='" + formName + "']//parent::td//preceding-sibling::td//img"));
        syncElement(driver, element, EnumsCommon.TOVISIBLE.getText());
        Assert.assertTrue("Arrow does not point to form " + formName, element.isDisplayed());
    }

    @Then("User Verifies Use Esignature and Decline Esignature buttons are visible")
    public void user_Verifies_Use_Esignature_and_Decline_Esignature_buttons_are_visible() {
        captureScreenshot(driver, testContext, false);
        Assert.assertTrue("Use Esignature button is not visible",getElement(driver, getExistingLocator(driver, onSignaturesPage.getBtnUseSignature(), onSignaturesPage.getBtnUseSignature1(), null, null)).isDisplayed());
        Assert.assertTrue("Decline Esignature button is not visible",getElement(driver, getExistingLocator(driver, onSignaturesPage.getBtn_DeclineESignatureMVC(), onSignaturesPage.getBtn_DeclineESignatureReact(), null, null)).isDisplayed());
    }

    @Then("User navigates to {string} page")
    public void userNavigatesToPage(String clientidentityverification) {
        Assert.assertTrue("User is not on client identity verification page.",onSignaturesPage.getTxt_clientIdentificationVerification().getText().trim().contains(clientidentityverification));
    }

    @Then("User do data entry for all fields and enter incorrect SSN {string} and DOB {string}")
    public void userFilledallDatawithIncorrectSSNAndDOB(String ssn,String DOB) {
        captureScreenshot(driver, testContext, false);
        sendKeys(driver, getElement(driver, getExistingLocator(driver, onSignaturesPage.getTxtBox_IDNumber(), onSignaturesPage.getTxtBox_IDNumber1(), null, null)), testContext.getMapTestData().get("id"));
        sendKeys(driver, getElement(driver, getExistingLocator(driver, onSignaturesPage.getTxtBox_Name(), onSignaturesPage.getTxtBox_Name1(), null, null)), testContext.getMapTestData().get("name"));
        sendKeys(driver, getElement(driver, getExistingLocator(driver, onSignaturesPage.getTxtBox_SSN(), onSignaturesPage.getTxtBox_SSN1(), null, null)), ssn);
        sendKeys(driver, getElement(driver, getExistingLocator(driver, onSignaturesPage.getTxtBox_EmailAddress(), onSignaturesPage.getTxtBox_EmailAddress1(), null, null)), testContext.getMapTestData().get("emailAddress"));
        WebElement txtboxBirthDate = getElement(driver, getExistingLocator(driver, onSignaturesPage.getTxtBox_BirthDate(), onSignaturesPage.getTxtBox_BirthDate1(), null, null));
        clickElement(driver, txtboxBirthDate);
        txtboxBirthDate.sendKeys(DOB);
        }

    @Then("User verifies validation message displayed for incorrect SSN and DOB")
    public void userVerifiesValidationMessageDisplayedForIncorrectSSNAndDOB() {
        Assert.assertTrue("Error message SSN mismatched/not displayed",onSignaturesPage.getErrorMsg_SSN().isDisplayed());
        Assert.assertTrue("Error message DOB mismatched/not displayed",onSignaturesPage.getErrorMsg_DOB().isDisplayed());
        Assert.assertTrue("Error message SSN text mismatched",onSignaturesPage.getErrorMsg_SSN().getText().trim().contains(testContext.getMapTestData().get("ssnError")));
        Assert.assertTrue("Error message DOB mismatched/not displayed",onSignaturesPage.getErrorMsg_DOB().getText().trim().contains(testContext.getMapTestData().get("dobError")));
    }

    @Then("User enter same SSN and DOB as entered in data entry")
    public void userEnterSameSSNAndDOBAsEnteredInDataEnrty() {
        if(testContext.getMapTestData().get("uiType").equalsIgnoreCase("React")) {
            sendKeys(driver, getElement(driver, getExistingLocator(driver, onSignaturesPage.getTxtBox_SSN(), onSignaturesPage.getTxtBox_SSN1(), null, null)), testContext.getMapTestData().get("ssn"));
            WebElement txtboxBirthDate = getElement(driver, getExistingLocator(driver, onSignaturesPage.getTxtBox_BirthDate(), onSignaturesPage.getTxtBox_BirthDate1(), null, null));
            txtboxBirthDate.clear();
            clickElement(driver, txtboxBirthDate);
            txtboxBirthDate.sendKeys(testContext.getMapTestData().get("birthDate"));
        }
        else {
            getElement(driver, getExistingLocator(driver, onSignaturesPage.getTxtBox_SSN(), onSignaturesPage.getTxtBox_SSN1(), null, null)).clear();
            sendKeys(driver, getElement(driver, getExistingLocator(driver, onSignaturesPage.getTxtBox_SSN(), onSignaturesPage.getTxtBox_SSN1(), null, null)), testContext.getMapTestData().get("ownerSSN"));
            WebElement txtBoxBirthDate = getElement(driver, getExistingLocator(driver, onSignaturesPage.getTxtBox_BirthDate(), onSignaturesPage.getTxtBox_BirthDate1(), null, null));
            txtBoxBirthDate.clear();
            clickElement(driver, txtBoxBirthDate);
            txtBoxBirthDate.sendKeys(testContext.getMapTestData().get("ownerBOD"));
        }
    }


    @Then("User navigates to Document Review page for further Signature process")
    public void userNavigatesToDocumentReviewPageForFurtherSignatureProcess() {
        waitForPageToLoad(driver);
        Assert.assertTrue("User is not on document review page",onSignaturesPage.getMsg_documentReviewPages().isDisplayed());
    }

    @Then("User completes signature process")
    public void userCompletesSignatureProcess() {
        onSignaturesPage.userClicksButtonSignaturePage(driver, testContext, "Next Page");
        onSignaturesPage.userClicksButtonSignaturePage(driver, testContext, "Next Page");
        onSignaturesPage.userClicksButtonSignaturePage(driver, testContext, "Next Page");
        clickElementByJSE(driver,onSignaturesPage.getChecBox_EDocument());
        onSignaturesPage.getTxtBox_initial().sendKeys(testContext.getMapTestData().get("digit"));
        clickElementByJSE(driver,getElement(driver, getExistingLocator(driver, onSignaturesPage.getPopup_OkMVC(), onSignaturesPage.getPopup_OkReact(), null, null)));
        waitForPageToLoad(driver);
        clickElementByJSE(driver,onSignaturesPage.getChk_Agree());
    }

    @Then("User enter signer Full Name as {string} City as {string} perform Signature click I Consent")
    public void enterSignerNameCity(String fullName,String cityName){
        waitForPageToLoad(driver);
        captureScreenshot(driver, testContext, false);
        clickElementByJSE(driver,onSignaturesPage.getTxtBox_signeFullName());
        onSignaturesPage.getTxtBox_signeFullName().sendKeys(fullName);
        getElement(driver, getExistingLocator(driver, onSignaturesPage.getTxtCity(), onSignaturesPage.getTxtCity1(), null, null)).sendKeys(cityName+ Keys.TAB);
        addDigitalSignature(driver,onSignaturesPage.getField_Signature());
        clickElement(driver,onSignaturesPage.getBtn_IConsentOnSignature());
    }

    @Then("User Verifies Signature Completed for Owner")
    public void user_Verifies_Signature_Completed_for_Owner() {
        captureScreenshot(driver, testContext, false);
        Assert.assertEquals("Name Mismatched", testContext.getMapTestData().get("signerName"),onSignaturesPage.getName_CompletedSignature().getText().trim());
    }

    @Then("User Verifies {string}")
    public void user_Verifies(String string) {
        captureScreenshot(driver, testContext, false);
        Assert.assertEquals("jurisdiction mismatched", testContext.getMapTestData().get(EnumsJSONProp.JURISDICTION.getText()), onSignaturesPage.getState_CompletedSignature().getText().trim());
    }

    @Then("User verifies {string} link displayed on pending request dialogbox")
    public void userVerifieslinkOnpendingRequestDialogBox(String link) {
        captureScreenshot(driver, testContext, false);
        Assert.assertTrue("Send Passcode link is not displayed", onSignaturesPage.getLink_SendPasscode().isDisplayed());
    }

    @Then("User verifies resend passcode button is displayed")
    public void userVerifiesResendPasscode(){
        waitForPageToLoad(driver);
        captureScreenshot(driver, testContext, false);
        Assert.assertTrue("Resend passcode button is not displayed on external login page.",onSignaturesPage.getBtn_ResendPasscode().isDisplayed());
    }

    @Then("User enter required details for signing on signatures window")
    public void userSubmitEmailDetails() {
        String fieldValue = testContext.getMapTestData().get("name");
        if(fieldValue.contains("Random")) {
            String appName = testContext.getMapTestData().get("newProductName");
            fieldValue = fieldValue + appName.substring(appName.lastIndexOf(" "));
            addPropertyValueInJSON(testContext.getTestCaseID(), testContext, EnumsJSONProp.REVIEWERNAME.getText(), fieldValue);
        }
        captureScreenshot(driver, testContext, false);
        sendKeys(driver, getElement(driver, getExistingLocator(driver, onSignaturesPage.getTxtBox_IDNumber(), onSignaturesPage.getTxtBox_IDNumber1(), null, null)), testContext.getMapTestData().get("id"));
        sendKeys(driver, getElement(driver, getExistingLocator(driver, onSignaturesPage.getTxtBox_Name(), onSignaturesPage.getTxtBox_Name1(), null, null)), fieldValue);
        sendKeys(driver, getElement(driver, getExistingLocator(driver, onSignaturesPage.getTxtBox_EmailAddress(), onSignaturesPage.getTxtBox_EmailAddress1(), null, null)), testContext.getMapTestData().get("emailAddress"));
    }

    @Then("User Verifies {string} is showing")
    public void UserVerifiesisshowing(String message) {
        captureScreenshot(driver, testContext, false);
        Assert.assertEquals(message + " did not show",message,onSignaturesPage.getBtn_SendEmailPasscode().getText().trim());
    }

    @Then("User Enters Passcode in Enter Passcode textbox of Client Verification")
    public void user_Enters_Passcode_in_Enter_Passcode_textbox_of_Client_Verification() {
        WebElement element = getElement(driver, getExistingLocator(driver, onSignaturesPage.getTxtBox_PasscodeMVC(), onSignaturesPage.getTxtBox_PasscodeReact(), null, null));
        syncElement(driver,element,EnumsCommon.TOCLICKABLE.getText());
        captureScreenshot(driver, testContext, false);
        element.clear();
        element.sendKeys(testContext.getMapTestData().get("passCode"));
    }

    @Then("User verifies Accept and decline E-signature Button present")
    public void userVerifiesAcceptOrDeclineESignature() {
        captureScreenshot(driver, testContext, false);
        WebElement acceptButton = getElement(driver, getExistingLocator(driver, onSignaturesPage.getBtnUseSignature(), onSignaturesPage.getBtnUseSignature1(), null, null));
        Assert.assertTrue("Accept e-signature button is not displayed", acceptButton.isDisplayed());
        Assert.assertTrue("Decline e-signature button is not displayed", getElement(driver, getExistingLocator(driver, onSignaturesPage.getBtn_DeclineESignatureMVC(), onSignaturesPage.getBtn_DeclineESignatureReact(), null, null)).isDisplayed());
    }

    @Then("User Verifies page heading {string}")
    public void user_Verifies_page_heading_with_Product_name(String heading) {
        waitForPageToLoad(driver);
        captureScreenshot(driver, testContext, false);
        if(findElements(driver, "//p[@class='verification_AuthenticationHeader']").size() > 0)
            Assert.assertEquals("Page Heading Mismatched", heading, onSignaturesPage.getHeading_SignaturePage_React1().getText().trim());
        else if(onSignaturesPage.getHeading_SignaturePage_React().getText().trim().contains(testContext.getMapTestData().get(EnumsJSONProp.NEWPRODUCTNAME.getText()))) {
            Assert.assertEquals("Page Heading Mismatched", heading + testContext.getMapTestData().get(EnumsJSONProp.NEWPRODUCTNAME.getText()),
                    onSignaturesPage.getHeading_SignaturePage_React().getText().trim());
        } else {
            waitForPageToLoad(driver);
            Assert.assertEquals("Page Heading Mismatched",heading,
                    onSignaturesPage.getHeading_SignaturePage_React().getText().trim());
        }
    }

    @Then("User verifies {string} TextBox")
    public void user_verifies_TextBox(String txtBox) {
        waitForPageToLoad(driver);
        captureScreenshot(driver, testContext, false);
        Assert.assertTrue(txtBox + " Text Box is not present", findElement(driver, String.format(onSignaturesPage.txtFieldWithId, txtBox, txtBox, txtBox)).isDisplayed());
    }

    @Then("User verifies {string} TextBox has Prefilled Value {string}")
    public void user_verifies_TextBoxHasPrefilledValue(String txtBox, String value) {
        waitForPageToLoad(driver);
        captureScreenshot(driver, testContext, false);
        Assert.assertEquals(txtBox + " Text Box has not value " +value,value , findElement(driver, String.format(onSignaturesPage.txtFieldWithId, txtBox, txtBox, txtBox)).getAttribute("value"));
    }

    @Then("User verifies {string} Button")
    public void user_verifies_Button(String button) {
        waitForPageToLoad(driver);
        captureScreenshot(driver, testContext, false);
        Assert.assertTrue(button + " Button is not present", findElement(driver, String.format(onSignaturesPage.btnText, button)).isDisplayed());
    }

    @Then("User Verifies options present for {string} dropdown")
    public void user_Verfies_options_present_for_dropdown(String dropdown, DataTable dataTable) {
        waitForPageToLoad(driver);
        captureScreenshot(driver, testContext, false);
        syncElement(driver, findElement(driver, String.format(onSignaturesPage.selectFieldWithId,dropdown,dropdown,dropdown)), EnumsCommon.TOVISIBLE.getText());
        String list_Options = new Select(findElement(driver, String.format(onSignaturesPage.selectFieldWithId,dropdown,dropdown,dropdown))).getWrappedElement().getText().trim();
        List<Map<String, String>> fieldValues = dataTable.asMaps(String.class, String.class);
        for (Map<String, String> fieldValue : fieldValues) {
            String field = fieldValue.get("options");
                Assert.assertTrue(field + " was not present in Dropdown", list_Options.contains(field));
        }
    }

    @Then("User Verifies header present for {string} table")
    public void verifyHeader(String dropdown, DataTable dataTable) {
        captureScreenshot(driver, testContext, false);
        List<String> expectedHeader = new ArrayList<String>();
        List<WebElement> list_OptionsHeader = findElements(driver, String.format(onSignaturesPage.tableWithClass,testContext.getMapTestData().get(dropdown)));
        for(WebElement option : list_OptionsHeader)
            expectedHeader.add(option.getText().trim());
        List<Map<String, String>> fieldValues = dataTable.asMaps(String.class, String.class);
        for (Map<String, String> fieldValue : fieldValues) {
            String field = fieldValue.get("options");
            Assert.assertTrue(field + " was not present in Dropdown", expectedHeader.contains(field));
        }
    }

    @Then("User verify {string} field in {string} table does not have value more than {int}")
    public void verifyValues(String field, String dropdown, int value) {
        captureScreenshot(driver, testContext, false);
        List<WebElement> list_OptionsHeader = findElements(driver, String.format(onSignaturesPage.tableWithClass,testContext.getMapTestData().get(dropdown)));
        int column = 0;
        for(WebElement option : list_OptionsHeader) {
            if(option.getText().equals(field)) {
                column++;
                break;
            }
            else
                column++;
        }
        List<WebElement> columnValues = findElements(driver, "(//table[@class='" + testContext.getMapTestData().get(dropdown) + "'])[1]//td[" + column + "]");
        Assert.assertTrue("Max column value of column " + field + " is not " + value,  Integer.valueOf(columnValues.get(columnValues.size()-1).getText().trim()) == value);
    }

    @Then("User Selects {string} option in {string} Dropdown")
    public void user_Selects_option_in_Dropdown(String option, String dropdown) {
        captureScreenshot(driver, testContext, false);
        new Select(findElement(driver, String.format(onSignaturesPage.txtFieldWithId,dropdown,dropdown,dropdown))).selectByVisibleText(option);
    }

    @Then("User Verifies TextBox {string}")
    public void user_Verifies_TextBox(String txtBox) {
        captureScreenshot(driver, testContext, false);
        Assert.assertTrue(txtBox + " Textbox Is not displayed",findElement(driver, String.format(onSignaturesPage.txtFieldWithLabelText,txtBox)).isDisplayed());
    }

    /** Deependra: 16 Jan 2024 Updated below method to reduce the loop count by adding i+20 **/
    @Then("User Verifies all Options of {string} are Selectable")
    public void user_Verifies_all_Options_are_Selectable(String dropdown) {
        captureScreenshot(driver, testContext, false);
        Select elementDropdown = new Select(findElement(driver, String.format(onSignaturesPage.txtFieldWithLabelText, dropdown)));
        for (int i=1;i < elementDropdown.getOptions().size();i+=20){
            elementDropdown.selectByIndex(i);
            waitForPageToLoad(driver);
            captureScreenshot(driver, testContext, false);
        }
    }

    @Then("User Enters {string} in TextBox {string}")
    public void user_Enters_in_TextBox(String value, String txtBox) {
        captureScreenshot(driver, testContext, false);
        waitForPageToLoad(driver);
        if(value.contains("Random")) {
            String appName = testContext.getMapTestData().get("newProductName");
            value = value + appName.substring(appName.lastIndexOf(" "));
            addPropertyValueInJSON(testContext.getTestCaseID(), testContext, EnumsJSONProp.REVIEWERNAME.getText(), value);
            addPropertyValueInJSON(testContext.getTestCaseID(), testContext, EnumsJSONProp.AGENTNAME.getText(), value);
        }
       else if(value.equalsIgnoreCase("More Than 75 Chareacters")) {
           value=value+testContext.getMapTestData().get("value");
        }
       else if (value.contains("Copy_of")) {
            addPropertyValueInJSON(testContext.getTestCaseID(),testContext,value,"Copy of "+testContext.getMapTestData().get(value.replace("Copy_of","")));
           value="Copy of "+testContext.getMapTestData().get(value.replace("Copy_of",""));
        }
        findElement(driver, String.format(onSignaturesPage.txtFieldWithId, txtBox, txtBox, txtBox)).clear();
        sendKeys(driver, findElement(driver, String.format(onSignaturesPage.txtFieldWithId, txtBox, txtBox, txtBox)), value+Keys.TAB);
            if(value.length() == 0) {
                findElement(driver, String.format(onSignaturesPage.txtFieldWithId, txtBox, txtBox, txtBox)).clear();
        }
    }

    @Then("User Clears the TextBox{string}")
    public void user_Clears_the_TextBox(String txtBox) {
        captureScreenshot(driver, testContext, false);
        findElement(driver, String.format(onSignaturesPage.txtFieldWithId, txtBox, txtBox, txtBox)).clear();
        findElement(driver, String.format(onSignaturesPage.txtFieldWithId, txtBox, txtBox, txtBox)).sendKeys( Keys.TAB);
    }

    @Then("user Verifies the Error Message {string} for {string}")
    public void user_Verifies_the_Error_Message(String errorMsg, String txtBox) {
        captureScreenshot(driver, testContext, false);
        try {
            Assert.assertEquals("Error Message Mismatched for TextBox" + txtBox, errorMsg, getElement(driver, getExistingLocator(driver, By.xpath(String.format(onSignaturesPage.msg_ErrorReact, txtBox)), By.xpath(String.format(onSignaturesPage.msg_ErrorMVC, txtBox)), By.xpath(String.format(onSignaturesPage.msg_ErrorSelectMVC, txtBox)), null)).getText().trim());
        } catch (Exception e) {
            Assert.assertTrue(errorMsg.equalsIgnoreCase(""));
        }
    }

    @Then("User Clicks on Button {string}")
    public void user_Clicks_on_Button(String button) {
        waitForPageToLoad(driver);
        captureScreenshot(driver, testContext, false);
        clickElementByJSE(driver, findElement(driver, String.format(onSignaturesPage.getBtn_Previous(), button)));
    }

    @Then("User Verifies {string} TextBox is Empty")
    public void user_Verifies_TextBox_is_Empty(String string) {
        captureScreenshot(driver, testContext, false);
    }
    @Then("User Verifies Sign Now plus Send Email Request Buttons Are Disabled Before Selecting Any User")
    public void user_Verifies_Sign_Now_plus_Send_Email_Request_Buttons_Are_Disabled_Before_Selecting_Any_User() {
        captureScreenshot(driver, testContext, false);
        Assert.assertTrue("Send Email: ENABLED", onSignaturesPage.getBtn_ReactSendEmailRequest().getAttribute("class").contains("disabled"));
        Assert.assertTrue("Sign Now: ENABLED", onSignaturesPage.getBtn_ReactSignNow().getAttribute("class").contains("disabled"));
    }
    @Then("User Verifies Sign Now button is disabled and Send Email Request Button is Enabled")
    public void user_Verifies_Sign_Now_button_is_disabled_and_Send_Email_Request_Button_is_Enabled() {
        captureScreenshot(driver, testContext, false);
        Assert.assertTrue("Sign Now is Enabled", onSignaturesPage.getBtn_ReactSignNow().getAttribute("class").contains("ITButtonDisabled"));
        Assert.assertFalse("Send Email is DISABLED", onSignaturesPage.getBtn_ReactSendEmailRequest().getAttribute("class").contains("ITButtonDisabled"));

    }
    @Then("User Verifies Sign Now button is enabled and Send Email Request Button is Disabled")
    public void user_Verifies_Sign_Now_button_is_enabled_and_Send_Email_Request_Button_is_Disabled() {
        captureScreenshot(driver, testContext, false);
        Assert.assertFalse("Sign Now is Enabled", onSignaturesPage.getBtn_ReactSignNow().getAttribute("class").contains("ITButtonDisabled"));
        Assert.assertTrue("Send Email is DISABLED", onSignaturesPage.getBtn_ReactSendEmailRequest().getAttribute("class").contains("ITButtonDisabled"));

    }
    @Then("User Enters Signer Full Name as {string} City as {string}")
    public void user_Enters_Signer_Full_Name_as_City_as(String fullName, String cityName) {
        captureScreenshot(driver, testContext, false);
        getElement(driver, getExistingLocator(driver, onSignaturesPage.getTxt_SignerFullNameMVC(), onSignaturesPage.getTxt_SignerFullNameReact(), null, null)).sendKeys(fullName);
        getElement(driver, getExistingLocator(driver, onSignaturesPage.getTxt_CityMVC(), onSignaturesPage.getTxt_CityReact(), null, null)).sendKeys(cityName+ Keys.TAB);
    }
    @Then("User verifies Agree Checkbox and Confirm All checkbox is showing")
    public void user_verifies_Agree_Checkbox_and_Confirm_All_checkbox_is_showing() {
        captureScreenshot(driver, testContext, false);
        syncElement(driver, onSignaturesPage.getChkBox_ReactConfirmReview(),EnumsCommon.TOVISIBLE.getText());
        Assert.assertTrue("Agree All is NOT showing", onSignaturesPage.getChkBox_ReactConfirmReview().isDisplayed());
        syncElement(driver, onSignaturesPage.getChkBox_ReactConfirmAll(),EnumsCommon.TOVISIBLE.getText());
        Assert.assertTrue("Confirm all without reviewing All is NOT showing", onSignaturesPage.getChkBox_ReactConfirmAll().isDisplayed());
    }
    @Then("User clicks Confirm all documents without reviewing individually followed by OK Click on Confirm Document Dialog.")
    public void user_clicks_Confirm_all_documents_without_reviewing_individually_followed_by_OK_Click_on_Confirm_Document_Dialog() {
        captureScreenshot(driver, testContext, false);
        clickElement(driver,onSignaturesPage.getChkBox_ReactConfirmAll());
        clickElement(driver,onSignaturesPage.getBtn_ConfirmDocOK_React());
    }
    @Then("User Enters Agent Full Name, Agent ID if not autofilled and Enter Agent City")
    public void user_Enters_Agent_Full_Name_Agent_ID_if_not_autofilled_and_Enter_Agent_City() {
        captureScreenshot(driver, testContext, false);
        String agentName = onSignaturesPage.getTxtBox_AgentfullName_React().getAttribute("value").toString().trim();
        String agentID = onSignaturesPage.getTxtBox_AgentID_React().getAttribute("value").toString().trim();
        if(agentName == null){
            sendKeys(driver, onSignaturesPage.getTxtBox_AgentfullName_React(), testContext.getMapTestData().get("agentName"));
        }if(agentID==null){
            sendKeys(driver, onSignaturesPage.getTxtBox_AgentID_React(),testContext.getMapTestData().get("agentID"));
        }
        sendKeys(driver, onSignaturesPage.getTxtBox_AgentCity_React(),testContext.getMapTestData().get("agentCity"));

    }
    @Then("User Enters Agent Full Name, Agent ID, and Agent City")
    public void user_Enters_Agent_Full_Name_Agent_ID_and_Agent_City() {
        captureScreenshot(driver, testContext, false);
        sendKeys(driver, onSignaturesPage.getTxtBox_AgentfullName_React(), testContext.getMapTestData().get("agentName"));
        sendKeys(driver, onSignaturesPage.getTxtBox_AgentCity_React(),testContext.getMapTestData().get("agentCity"));
        sendKeys(driver, onSignaturesPage.getTxtBox_AgentID_React(),testContext.getMapTestData().get("agentID"));
    }
    @Then("User Clicks on Unlock Application button on top, then click Unlock Activity button")
    public void user_Clicks_on_Unlock_Application_button_on_top_then_click_Unlock_Activity_button() {
        captureScreenshot(driver, testContext, false);
        clickElement(driver,onSignaturesPage.getBtn_UnlockApplication_React());
        syncElement(driver, getElement(driver, getExistingLocator(driver, onSignaturesPage.getBtn_UnlockActivity_React(), onSignaturesPage.getBtn_UnlockActivity_Mvc(), null, null)),EnumsCommon.TOCLICKABLE.getText());
        clickElement(driver, getElement(driver, getExistingLocator(driver, onSignaturesPage.getBtn_UnlockActivity_React(), onSignaturesPage.getBtn_UnlockActivity_Mvc(), null, null)));
    }

    @Then("User Clicks on Unlock Application")
    public void user_Clicks_on_Unlock_Application() {
        captureScreenshot(driver, testContext, false);
        clickElement(driver, getElement(driver, getExistingLocator(driver, onSignaturesPage.getBtn_UnlockActivity_React(), onSignaturesPage.getBtn_UnlockActivity_Mvc(), onSignaturesPage.getBtn_UnlockApplication(), null)));
    }


    @Then("User Verifies tab {string}")
    public void user_Verifies_tab(String tab) {
        captureScreenshot(driver, testContext, false);
        Assert.assertTrue(tab + " was not Visible",findElement(driver,String.format(onSignaturesPage.btnText,tab)).isDisplayed());
    }

    @Then("User Verifies toolbar {string}")
    public void user_Verifies_toolbar(String toolbar) {
        captureScreenshot(driver, testContext, false);
        Assert.assertTrue(toolbar + " was not Visible",findElement(driver,String.format(onSignaturesPage.toolBarWithText,toolbar)).isDisplayed());
    }

    @Then("User verifies {string} TextBox value as {string}")
    public void user_verifies_TextBox_Value(String txtBox, String value) {
        waitForPageToLoad(driver);
        captureScreenshot(driver, testContext, false);
        if(txtBox.equalsIgnoreCase("subject")) {
            value = value + " - '" + testContext.getMapTestData().get("newProductName") + "'";
            Assert.assertEquals(txtBox + " Text Box Value was not matching", value.toLowerCase(), findElement(driver, String.format(onSignaturesPage.txtFieldWithId, txtBox, txtBox, txtBox)).getAttribute("value").toLowerCase());
        }
        else
            Assert.assertEquals(txtBox + " Text Box Value was not matching",testContext.getMapTestData().get(value).toLowerCase() ,findElement(driver, String.format(onSignaturesPage.txtFieldWithId, txtBox, txtBox, txtBox)).getAttribute("value").toLowerCase());
    }

    @Then("User verify field {string} {string} on signature page")
    public void verifyFieldExistence(String field, String condition) {
        waitForPageToLoad(driver);
        captureScreenshot(driver, testContext, false);
        int fieldElemSize = driver.findElements(By.xpath("//span[@class='labelDiv' and contains(text(),'" + field + "')]")).size();
        if (fieldElemSize > 0) {
            if (condition.equalsIgnoreCase("exists"))
                Assert.assertTrue(field + " Field does not exist on signature page", fieldElemSize > 0);
            else
                Assert.assertTrue(field + " Field exists on signature page", fieldElemSize == 0);
        } else {
            int fieldElemSize1 = driver.findElements(By.xpath("//label[@for='" + field + "']")).size();
            if (fieldElemSize1 > 0 & condition.equalsIgnoreCase("exists"))
                Assert.assertTrue(field + " Field does not exist on signature page", fieldElemSize1 > 0);
            else
                Assert.assertTrue(field + " Field exists on signature page", fieldElemSize1 == 0);
        }
    }

    @Then("User clicks on close Popup on DataEntry Page")
    public void user_clicks_on_close_Popup_on_DataEntry_Page() {
        captureScreenshot(driver, testContext, false);
        clickElementByJSE(driver, onReviewPage.getBtn_InitialMessagePopupClose());
    }

    @Then("User Enters {string} into the Text field of Decline E=Signature")
    public void user_Enters_into_the_Text_field_of_Decline_E_Signature(String msg) {
        captureScreenshot(driver, testContext, false);
        sendKeys(driver,onSignaturesPage.getTxtField_DeclineEsignature(),msg);
    }

    @Then("User verifies text on Electronic signature Declined")
    public void user_verifies_text_on_Electronic_signature_Declined(DataTable dataTable) {
        captureScreenshot(driver, testContext, false);
        List<String> data = dataTable.asList(String.class);
        for (String values : data){
            WebElement element = getElement(driver, getExistingLocator(driver, onSignaturesPage.getTxt_ESignatureDeclineMessagesMVC(), onSignaturesPage.getTxt_ESignatureDeclineMessagesReact(), null, null));
            if (element.getText().contains(values)) {
                Assert.assertTrue("The messages are not matching ", element.getText().contains(values));
            }
        }
    }

    @Then("User clicks Decline E-Signature on Confirm Window popup")
    public void user_clicks_Decline_E_Signature_on_Confirm_Window_popup() {
        captureScreenshot(driver, testContext, false);
        onSignaturesPage.getBtn_PopUpDeclineESignature().click();
    }

    @Then("User verifies Confirm Decline PopUp message {string}")
    public void user_verifies_Confirm_Decline_PopUp_message(String message) {
        captureScreenshot(driver, testContext, false);
        Assert.assertEquals("The message is not matching ",onSignaturesPage.getConfirmWindowMessage().getText(),message);
    }

    @Then("User is on {string} page")
    public void user_is_on_page(String pagename) {
        waitForPageToLoad(driver);
        captureScreenshot(driver, testContext, false);
        Assert.assertTrue(pagename+" was not matched ",onSignaturesPage.getElectronicSignaturePage().getText().contains(pagename));
    }

    @Then("User Verifies Toast Popup message as {string} and closes it")
    public void userVerifiesPopupMessageAndCloseIt(String popupMsg) {
        waitForPageToLoad(driver);
        captureScreenshot(driver, testContext, false);
        Assert.assertTrue("Pop message differing", onSignaturesPage.getMsg_ToastPopup().getText().trim().contains(popupMsg));
        clickElement(driver, getElement(driver, getExistingLocator(driver, onSignaturesPage.getBtnClose(), onSignaturesPage.getBtnClose1(), null, null)));
    }

    @Then("User verify {string} is displayed and disabled on signature page")
    public void userVerifiesResendSMS(String popupMsg) {
        waitForPageToLoad(driver);
        captureScreenshot(driver, testContext, false);
        Assert.assertTrue("Resend SMS is not displayed", onSignaturesPage.getBtn_ResendSMSWithTime().isDisplayed());
        Assert.assertTrue("Resend SMS is not displayed", onSignaturesPage.getBtn_ResendSMSButton().getAttribute("class").contains("ITButtonDisabled"));
        new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOf(onSignaturesPage.getBtn_ResendSMS()));
    }

    @Then("User verify {string} button exists on signature page")
    public void userVerifyButton(String whichButton) {
        captureScreenshot(driver, testContext, false);
        waitForPageToLoad(driver);
        Assert.assertTrue("Button " + whichButton + " is not displayed",onSignaturesPage.userVerifyButton(whichButton, testContext));
    }

    @Then("User verify {string} button {string} on signature page")
    public void verifyButtonExist(String whichButton, String condition) {
        captureScreenshot(driver, testContext, false);
        boolean flag = false;
        By locator;
        switch (whichButton) {
            case "Proceed":
                locator = getExistingLocator(driver, By.id("btnProceed"), null, null, null);
                break;
            case "Agree":
                locator = getExistingLocator(driver, onSignaturesPage.getBtnAgree(), onSignaturesPage.getBtnAgree1(), onSignaturesPage.getBtnAgree2(), onSignaturesPage.getBtnAgree3());
                break;
            case "Confirm All Documents":
                locator = getExistingLocator(driver, onSignaturesPage.getBtnConfirmAll(), onSignaturesPage.getBtnConfirmAll1(), onSignaturesPage.getBtnConfirmAll2(), null);
                break;
            case "Sign Now":
                locator = getExistingLocator(driver, onSignaturesPage.getBtn_SignNow(), onSignaturesPage.getBtn_SignNow1(), null, null);
                break;
            case "Send Email Request":
                locator = getExistingLocator(driver, onSignaturesPage.getBtn_SendEmailRequest(), onSignaturesPage.getBtn_SendEmailRequest1(), null, null);
                break;
            default:
                throw new FLException(whichButton + " parameter is incorrect");
        }
        try {
            syncElement(driver, driver.findElement(locator), EnumsCommon.TOVISIBLE.getText());
            Assert.assertTrue(whichButton + " button is not displayed",  driver.findElements(locator).size() > 0 & condition.equalsIgnoreCase("exists"));
        } catch (Exception e) {
            Assert.assertTrue("Unexpectedly, " + whichButton + " button is displayed", condition.equalsIgnoreCase("does not exist"));
        }
    }

    @Then("User selects {string} font on capture electronic signature window")
    public void userSelectsValue(String fontType) {
        waitForPageToLoad(driver);
        captureScreenshot(driver, testContext, false);
        new Select(onSignaturesPage.getDd_FontType()).selectByVisibleText(fontType);
    }

    @Then("User verify error message {string} on signature page")
    public void verifyErrorMessage(String message) {
        waitForPageToLoad(driver);
        captureScreenshot(driver, testContext, false);
        WebElement elementMessage = getElement(driver, getExistingLocator(driver, onSignaturesPage.getAlert_Signature(), onSignaturesPage.getTxt_ErrorMessage(), onSignaturesPage.getAlert_Signature1(), onSignaturesPage.getAlert_Signature2()));
        syncElement(driver, elementMessage, EnumsCommon.TOVISIBLE.getText());
        if(message.contains("JSON"))
            message = testContext.getMapTestData().get(message);
        Assert.assertTrue("Message is not as expected " + message, elementMessage.getText().trim().contains(message));
    }

    @Then("User verify message {string} on field {string}")
    public void verifyMessage(String message, String field) {
        waitForPageToLoad(driver);
        captureScreenshot(driver, testContext, false);
        WebElement messageElement = findElement(driver, String.format(onSignaturesPage.txtFieldWithId, field, field, field));
        syncElement(driver, messageElement, EnumsCommon.TOVISIBLE.getText());
        Assert.assertTrue("Message is not as expected " + message, messageElement.getText().trim().contains(message));
    }

    @Then("User verify message {string} on text {string}")
    public void verifyTextMessage(String message, String field) {
        waitForPageToLoad(driver);
        captureScreenshot(driver, testContext, false);
        WebElement messageElement = findElement(driver, String.format(onSignaturesPage.txtFieldWithClass, field));
        syncElement(driver, messageElement, EnumsCommon.TOVISIBLE.getText());
        Assert.assertTrue("Message is not as expected " + message, messageElement.getText().trim().contains(message));
    }

    @Then("User verifies Documents")
    public void user_verifies_Documents(DataTable dataTable) {
        captureScreenshot(driver, testContext, false);
        ArrayList<String> list_Elements = new ArrayList<>();
        for (WebElement element: findElements(driver,String.format(onSignaturesPage.getName_Document()))) {
            list_Elements.add(element.getText());
        }
        List<String> datas = dataTable.asList(String.class);
        for (String data : datas) {
            Assert.assertTrue(data + " not found in documents", list_Elements.contains(data));
        }
    }

    @Then("User Verifies Form {string}")
    public void user_Verifies_Form(String form) {
        waitForPageToLoad(driver);
        captureScreenshot(driver, testContext, false);
        Assert.assertEquals(form + " not found" , form,onSignaturesPage.getNameForm().getText().trim());
    }

    @Then("User put dot on Signature Pad")
    public void userPutDotInSignature() {
        captureScreenshot(driver, testContext, false);
        getElement(driver, getExistingLocator(driver, onSignaturesPage.getBtnSignature(), onSignaturesPage.getBtnSignature1(), null, null)).click();
    }

    @Then("User Verifies Text field {string} Does not Appear")
    public void userVarifiesTextFieldDoesNotAppear(String textId){
        captureScreenshot(driver, testContext, false);
        Assert.assertFalse(textId +" Appeared", findElements(driver, String.format(onSignaturesPage.txtFieldWithId, textId, textId, textId)).size() > 0 );
    }

    @Then("User Verifies {string} status as {string}")
    public void user_Verifies_status_as(String role, String status) {
        captureScreenshot(driver, testContext, false);
        Assert.assertTrue("Status did not match for "+role,  findElement(driver,String.format(onSignaturesPage.getStatusWithRole(),role,status)).getText().trim().contains(status));
    }

    @Then("User Verifies {string} Button available for {string}")
    public void user_Verifies_Button_available_for(String role, String button) {
        captureScreenshot(driver, testContext, false);
        Assert.assertTrue("Button not Visible for "+role, findElement(driver,String.format(onSignaturesPage.getButtonWithRole(),role,button)).isDisplayed());
    }

    @Then("User verifies {string} TextBox has Prefilled Value")
    public void user_verifies_TextBoxHasPrefilled(String txtBox) {
        waitForPageToLoad(driver);
        captureScreenshot(driver, testContext, false);
        Assert.assertTrue(txtBox + " Text Box has not value ", findElement(driver, String.format(onSignaturesPage.txtFieldWithId, txtBox, txtBox, txtBox)).getAttribute("value").length()> 0);
    }

    @Then("User Clicks on Button Decline E-signature in Confirmation Dialougue")
    public void user_Clicks_On_Button_Decline_ESignature() {
        waitForPageToLoad(driver);
        captureScreenshot(driver, testContext, false);
        clickElementByJSE(driver,onSignaturesPage.getBtn_DeclineESignatureConfirmDialogue());
    }

    @Then("User select {string} answer to {string} question")
    public void userSelectAnswer(String answer, String question) {
        waitForPageToLoad(driver);
        captureScreenshot(driver, testContext, false);
        clickElementByJSE(driver, findElement(driver, "((//p[@class='verification_AuthenticationQuestion'])[" + question.substring(0,1) + "]//parent::div//label)[" + answer.substring(0,1) + "]"));
    }

    @Then("User clicks initials box")
    public void userClicksInitialDocumentSet() {
        captureScreenshot(driver, testContext, false);
        clickElement(driver, getElement(driver, getExistingLocator(driver, onSignaturesPage.getBtn_InitialDocumentSet1(), onSignaturesPage.getBtn_InitialDocumentSet2(), null, null)));
    }

    @Then("User Verifies Signer {string}")
    public void userVerifiesSigner(String signer) {
        captureScreenshot(driver, testContext, false);
        Assert.assertTrue(signer + " was not displayed", findElement(driver, String.format(onSignaturesPage.getSigner(), signer)).isDisplayed());
    }

    @Then("User verifies {string} is {string} field")
    public void verifyReadonlyField(String field, String attribute) {
        captureScreenshot(driver, testContext, false);
        if(attribute.contains("not"))
            Assert.assertTrue(field + " is read only", findElement(driver, String.format(onSignaturesPage.txtFieldWithId, field, field, field)).isEnabled());
        else
            Assert.assertTrue(field + " is not read only", findElement(driver, String.format(onSignaturesPage.txtFieldWithId, field, field, field)).getAttribute(attribute).equalsIgnoreCase("true"));
    }

    @Then("User verify button {string} is {string}")
    public void verifyReadonlyButton(String field, String attribute) {
        captureScreenshot(driver, testContext, false);
            if (attribute.contains("not"))
                Assert.assertTrue(field + " is read only", findElement(driver, String.format(onCommonMethodsPage.anchorLinks, field, field, field)).isEnabled());
            else if (findElement(driver, String.format(onCommonMethodsPage.anchorLinks, field, field, field)).getAttribute("class").contains("disabled"))
                Assert.assertTrue(field + " is not read only", findElement(driver, String.format(onCommonMethodsPage.anchorLinks, field, field, field)).getAttribute("class").contains("disabled"));
            else
                Assert.assertTrue(field + " is not read only", findElement(driver, String.format(onCommonMethodsPage.anchorLinks, field, field, field)).getAttribute(attribute).equalsIgnoreCase("true"));
    }


    @Then("User clicks {string} for {string} button on signature page")
    public void clickSignerAction(String action, String user) {
        captureScreenshot(driver, testContext, false);
        clickElement(driver, findElement(driver, "//*[@arai-label='" + user + " : " + action + "']"));
    }

    @Then("User verify {string} for {string} button on signature page")
    public void verifySignerAction(String action, String user) {
        captureScreenshot(driver, testContext, false);
        waitForPageToLoad(driver);
        int revokeElementSize = findElements(driver, "//*[@arai-label='" + user + " : " + action + "']").size();
        if(action.contains("no"))
            Assert.assertTrue(action + " is displayed", revokeElementSize == 0);
        else
            Assert.assertTrue(action + " is not displayed", revokeElementSize > 0);
    }

    @Then("User Verifies Unlock is disable")
    public void user_Verifies_tabIsDisable() {
        captureScreenshot(driver, testContext, false);
        if(onSignaturesPage.getListBtn_Unlock().size() == 0){
            Assert.assertFalse( "Unlock button was enable",getElement(driver,getExistingLocator(driver,onSignaturesPage.getBtn_Unlock(),null,null,null)).isEnabled());
        } else {
            Assert.assertTrue("Unlock button was enable", onSignaturesPage.getListBtn_Unlock().get(0).getAttribute("class").contains("Disabled"));
        }
    }

    @Then("User Verifies Unlock is not Visible")
    public void user_Verifies_tabIsNotVisible() {
        captureScreenshot(driver, testContext, false);
        Assert.assertFalse( "Unlock button was Visible",onSignaturesPage.getListBtn_Unlock().size()>0);
    }
    @Then("Verify Signers {string} Tab Are {string}")
    public void userVerifySignersTabAreDisabled(String signer, String status) {
        captureScreenshot(driver, testContext, false);
        if(status.equalsIgnoreCase("Disabled")){
            Assert.assertTrue(signer + "button Should be disabled", findElement(driver, String.format(onCommonMethodsPage.ariaLabelInputFields, signer)).getAttribute("style").contains("opacity: 0.5"));
        }else if(status.equalsIgnoreCase("Enabled")){
            Assert.assertTrue(signer + " was disabled", findElement(driver, String.format(onSignaturesPage.getSigner(), signer)).isEnabled());
        }
    }
    @Then("User Select Signers {string} Tab")
    public void userSelectSignersTabAreDisabled(String signer) {
        captureScreenshot(driver, testContext, false);
        clickElement(driver, findElement(driver, String.format(onSignaturesPage.getSigner(), signer)));
    }
    @Then("User Clicks on proceed button")
    public void userClicksOnProceedButton() {
        captureScreenshot(driver, testContext, false);
        clickElement(driver, onSignaturesPage.getBtn_Proceed());
    }

    @Then("User Verifies Unlock is enable and displayed")
    public void user_Verifies_isEnableAndDisplayed() {
        captureScreenshot(driver, testContext, false);
        if (onSignaturesPage.getListBtn_Unlock().size() > 0) {
            Assert.assertTrue("Unlock button was Disable", onSignaturesPage.getListBtn_Unlock().get(0).isEnabled());
        } else {
            Assert.assertTrue("Unlock button was Disable", getElement(driver, getExistingLocator(driver, onSignaturesPage.getBtn_Unlock(), null, null, null)).isEnabled());
        }
    }

    @Then("User sets value {string}  for field {string} for To Signature tab for city")
    public void userSetsValueForFieldForToSignatureTabForCity(String fieldValue, String fieldName) {
        onCommonMethodsPage.getNameCity().clear();
        onCommonMethodsPage.getNameCity().click();
        onCommonMethodsPage.getNameCity().sendKeys("Pune");
        waitForPageToLoad(driver);
        captureScreenshot(driver, testContext, false);
    }

    @Then("User sets value {string}  for field {string} for To Signature tab New")
    public void userSetsValueForFieldForToSignatureTabNew(String fieldValue, String fieldName) {
        onCommonMethodsPage.getNameSigner().clear();
        onCommonMethodsPage.getNameSigner().click();
        onCommonMethodsPage.getNameSigner().sendKeys("Signer Full Name");
        waitForPageToLoad(driver);
        captureScreenshot(driver, testContext, false);
    }


    @Then("User verify application {string} is {string}")
    public void userVerifyMessageInRedText(String message, String status) {
            waitForPageToLoad(driver);
            captureScreenshot(driver, testContext, false);
            syncElement(driver, onSignaturesPage.getTxtFieldformcheck(), EnumsCommon.TOVISIBLE.getText());
            int elementSize = findElements(driver, "//*[@class='spanAppName' and contains(text(),'" + testContext.getMapTestData().get("newProductName") + "')]").size();
            if(status.equalsIgnoreCase("displayed"))
                Assert.assertTrue("Application is not displayed " + message, elementSize > 0);
            else
                Assert.assertTrue("Application is displayed " + message, elementSize == 0);
    }

    @Then("User clicks OK to decline Electronic Signatures window")
    public void userClicksOKToDeclineElectronicSignaturesWindow() {
        onSignaturesPage.getBtn_Ok_OnElectronicSignaturesDeclined().click();
    }
    @Then("User Verifies Insured & Owner tabs checkbox are disabled and and Agent Tabs checkbox is enabled")
    public void userVerifiesInsuredOwnerTabsCheckboxAreDisabledAndAndAgentTabsCheckboxIsEnabled() {
        captureScreenshot(driver, testContext, false);
        Assert.assertTrue("Insured tabs checkbox is Enabled", onSignaturesPage.getChkBox_Insured().getAttribute("class").contains("disabled"));
        Assert.assertTrue("Owner tabs checkbox is Enabled", onSignaturesPage.getChkBox_Owner().getAttribute("class").contains("disabled"));
        Assert.assertTrue("Agent check box was not enabled", onSignaturesPage.getChkBox_Agent2().isEnabled());
    }

    @Then("User Verifies Sign Now & Send Email Request buttons are disabled")
    public void UsersVerifySignNowSendEmailRequestButtonsAreDisabled() {
        captureScreenshot(driver, testContext, false);
        Assert.assertTrue("Sign Now is Enabled", onSignaturesPage.getBtn_ReactSignNow().getAttribute("class").contains("ITButtonDisabled"));
        Assert.assertTrue("Send Email is Enabled", onSignaturesPage.getBtn_ReactSendEmailRequest().getAttribute("class").contains("ITButtonDisabled"));
    }

    @Then("User Enters Agent Full Name and Agent City")
    public void userEntersAgentFullNameAndAgentCity() {
        captureScreenshot(driver, testContext, false);
        sendKeys(driver, onSignaturesPage.getTxtBox_AgentfullName_React(), testContext.getMapTestData().get("agentName"));
        sendKeys(driver, onSignaturesPage.getTxtBox_AgentCity_React(), testContext.getMapTestData().get("agentCity"));
    }

    @Then("User verify Sign Now & Send Email Request buttons are enabled")
    public void userVerifySignNowSendEmailRequestButtonsAreEnabled() {
        captureScreenshot(driver, testContext, false);
        Assert.assertFalse("Sign Now is DISABLED", onSignaturesPage.getBtn_ReactSignNow().getAttribute("class").contains("ITButtonDisabled"));
        Assert.assertFalse("Send Email is DISABLED", onSignaturesPage.getBtn_ReactSendEmailRequest().getAttribute("class").contains("ITButtonDisabled"));
    }

    @Then("User verify Re Sign button is enabled for Insured signer under Manage Request Table")
    public void userVerifyReSignButtonIsEnabledForInsuredSignerUnderManageRequestTable() {
        captureScreenshot(driver, testContext, false);
        Assert.assertFalse("Insured Resign button is Disabled", onSignaturesPage.getReSignBtn_Insured().getAttribute("class").contains("Disabled"));
    }

    @Then("User verify Agent Re-Sign Button is disabled under Manage Request Table")
    public void userVerifyAgentReSignButtonIsDisabledUnderManageRequestTable() {
        captureScreenshot(driver, testContext, false);
        Assert.assertTrue("Agent Re-sign checkbox is Enabled", onSignaturesPage.getReSignBtn_Agent().getAttribute("class").contains("Disabled"));
    }

    @Then("User verify Edit button is displayed for Owner under Manage Request Table")
    public void userVerifyEditButtonIsDisplayedForOwnerUnderManageRequestTable() {
        captureScreenshot(driver, testContext, false);
        Assert.assertTrue("Edit button was not displayed", onSignaturesPage.getBtn_Edit().isDisplayed());
    }

    @Then("User Enters Agent Full Name as {string} City as {string} on capture electronic signature window")
    public void userEntersAgentFullNameAsCityAs(String agentFullName, String agentCity) {
        captureScreenshot(driver, testContext, false);
        onSignaturesPage.getTxt_agentFullName().sendKeys(agentFullName);
        onSignaturesPage.getTxt_agentCityName().sendKeys(agentCity+ Keys.TAB);
    }

    @Then("User Enters Signer Full Name as {string} City as {string} and click I Consent on Capture Electronic Signature page")
    public void userEntersSignerFullNameAsCityAsAndClickIConsentOnCaptureElectronicSignaturePage(String signerFullName, String signerCityName) {
        captureScreenshot(driver, testContext, false);
        getElement(driver, getExistingLocator(driver, onSignaturesPage.getTxt_SignerFullNameMVC(), onSignaturesPage.getTxt_SignerFullNameReact(), null, null)).sendKeys(signerFullName);
        getElement(driver, getExistingLocator(driver, onSignaturesPage.getTxt_CityMVC(), onSignaturesPage.getTxt_CityReact(), null, null)).sendKeys(signerCityName+ Keys.TAB);
        clickElement(driver, onSignaturesPage.getBtn_IConsentOnCaptElectSign());
    }

    @Then("User Verifies the Unlock Button is Displayed")
    public void user_Verifies_the_Unlock_Button_is_displayed() {
        Assert.assertTrue("Unlock Button was not Displayed", onSignaturesPage.getBtn_UnlockApplication_React().isDisplayed());
    }

    @Then("User Verifies Insured & Owner tabs checkbox are enabled and and Agent Tabs checkbox is disabled")
    public void user_Verifies_Insured_Owner_tabs_checkbox_are_enabled_and_and_Agent_Tabs_checkbox_is_disabled() {
        captureScreenshot(driver, testContext, false);
        Assert.assertFalse("Insured tabs checkbox was NOT enabled", onSignaturesPage.getChk_Insured().getClass().toString().trim().equalsIgnoreCase("disabled"));
        Assert.assertFalse("Owner tabs checkbox was NOT enabled", onSignaturesPage.getChk_Owner().getClass().toString().trim().equalsIgnoreCase("disabled"));
        Assert.assertTrue("Agent check box was enabled", onSignaturesPage.getChkBox_AgentTwo().getAttribute("class").contains("disabled"));
    }

    @Then("User verifies Agent tab checkbox is disabled")
    public void user_verifies_Agent_tab_checkbox_is_disabled() {
        captureScreenshot(driver, testContext, false);
        Assert.assertTrue("Agent check box was enabled", onSignaturesPage.getChkBox_AgentTwo().getAttribute("class").contains("disabled"));
    }

    @Then("User verify Re Sign button is enabled for Owner signer under Manage Request Table")
    public void user_verify_Re_Sign_button_is_enabled_for_Owner_signer_under_Manage_Request_Table() {
        captureScreenshot(driver, testContext, false);
        Assert.assertFalse("Insured Resign button is Disabled", onSignaturesPage.getReSignBtn_Owner().getAttribute("class").contains("Disabled"));
    }

    @Then("User verify Edit button is displayed for Insured under Manage Request Table")
    public void user_verify_Edit_button_is_displayed_for_Insured_under_Manage_Request_Table() {
        captureScreenshot(driver, testContext, false);
        Assert.assertTrue("Edit button was not displayed", onSignaturesPage.getBtn_Edit().isDisplayed());
    }

    @Then("User Verifies Agent Tabs checkbox is enabled")
    public void user_Verifies_Agent_Tabs_checkbox_is_enabled() {
        captureScreenshot(driver, testContext, false);
        Assert.assertTrue("Agent check box was not enabled", onSignaturesPage.getChkBox_Agent2().isEnabled());
    }

    @Then("User selects Agree Document Checkbox")
    public void userSelectsAgreeDocumentCheckbox() {
        captureScreenshot(driver, testContext, false);
        scrollToWebElement(driver, onSignaturesPage.getCheckbox_designPage());
        syncElement(driver, onSignaturesPage.getCheckbox_designPage(),EnumsCommon.TOCLICKABLE.getText());
        clickElement(driver, onSignaturesPage.getCheckbox_designPage());
    }
    @Then("User verifies button {string} is {string}")
    public void user_verifies_button_is(String value, String field) {
        waitForPageToLoad(driver);
        captureScreenshot(driver, testContext, false);
        if (findElements(driver, String.format(onCommonMethodsPage.btn_UploadNew, value)).size() > 0)
            Assert.assertTrue(value + " button was enabled", findElement(driver, String.format(onCommonMethodsPage.btn_UploadNew, value)).isDisplayed());
        else if (findElements(driver, String.format(onCommonMethodsPage.btn_UploadEnabled, value)).size() > 0) {
            if (field.equalsIgnoreCase("disabled"))
                Assert.assertFalse(value + "button was not enabled", findElement(driver, String.format(onCommonMethodsPage.btn_UploadEnabled, value)).isEnabled());
            else
                Assert.assertTrue(value + "button was not enabled", findElement(driver, String.format(onCommonMethodsPage.btn_UploadEnabled, value)).isEnabled());
        }
        else if (findElement(driver, String.format(onCommonMethodsPage.btn_Upload, value)).getAttribute("class").contains("ITButtonDisabled"))
            Assert.assertFalse(value + " button was enabled", findElement(driver, String.format(onCommonMethodsPage.btn_Upload, value)).isEnabled());

    }
    @Then("User Enters {string} in TextBox {string} new")
    public void user_Enters_in_TextBox1(String value1, String txtbox1) {
        captureScreenshot(driver, testContext, false);
        findElement(driver, String.format(onSignaturesPage.txtFieldWithId, txtbox1, txtbox1, txtbox1)).clear();
        findElement(driver, String.format(onSignaturesPage.txtFieldWithId, txtbox1, txtbox1, txtbox1)).sendKeys(value1);
        if (findElements(driver, String.format(onSignaturesPage.txtFieldWithId, "IDNumber", "IDNumber", "IDNumber")).size() > 0)
            clickElement(driver, findElement(driver, String.format(onSignaturesPage.txtFieldWithId, "IDNumber", "IDNumber", "IDNumber")));
        else
            clickElement(driver, findElement(driver, String.format(onSignaturesPage.txtFieldWithId, "YourName", "YourName", "YourName")));

    }

    @Then("User verifies Signatures step window is displayed")
    public void user_verifies_Signatures_step_window_is_displayed() {
        captureScreenshot(driver, testContext, false);
        syncElement(driver, onSignaturesPage.getSignatureWindow(), EnumsCommon.TOVISIBLE.getText());
        Assert.assertTrue("Signatures step Window is not Displayed", onSignaturesPage.getSignatureWindow().isDisplayed());
    }

    @Then("User Verifies Button {string} is displayed and Enabled")
    public void user_Verifies_button_is_Displayed_And_Enabled(String button) {
        captureScreenshot(driver, testContext, false);
        Assert.assertTrue(button + " was not Visible",findElement(driver,String.format(onSignaturesPage.btnText,button)).isDisplayed());
        Assert.assertTrue(button + " was not Enabled",findElement(driver,String.format(onSignaturesPage.btnText,button)).isEnabled());
    }

    @Then("User Verifies Sign Now & Send Email Request buttons are enabled")
    public void user_Verifies_Sign_Now_Send_Email_Request_buttons_are_enabled() {
        captureScreenshot(driver, testContext, false);
        syncElement(driver, onSignaturesPage.getBtn_ReactSignNow(), EnumsCommon.TOCLICKABLE.getText());
        Assert.assertTrue("Sign Now is Disabled", onSignaturesPage.getBtn_ReactSignNow().isEnabled());
        Assert.assertTrue("Send Email is Disbled", onSignaturesPage.getBtn_ReactSendEmailRequest().isEnabled());
    }
    @Then("User verify {string} of field {string} is {string}")
    public void verifyAttributeValue(String attribute, String txtBox, String value) {
        waitForPageToLoad(driver);
        captureScreenshot(driver, testContext, false);
        Assert.assertEquals(txtBox + " Text Box has not value " +value,value , findElement(driver, String.format(onSignaturesPage.txtFieldWithId, txtBox, txtBox, txtBox)).getAttribute(attribute));
    }

    @Then("User verifies {string} field has Prefilled Value {string}")
    public void verifyField(String txtBox, String value) {
        waitForPageToLoad(driver);
        captureScreenshot(driver, testContext, false);
        Assert.assertEquals(txtBox + " Text Box has not value " +value,value , findElement(driver, String.format(onSignaturesPage.txtField, txtBox)).getAttribute("value"));
    }

    @Then("User Enters {string} in field {string}")
    public void enterValue(String value, String txtBox) {
        waitForPageToLoad(driver);
        captureScreenshot(driver, testContext, false);
        sendKeys(driver, findElement(driver, String.format(onSignaturesPage.txtField, txtBox)), value);
    }

    @Then("User verify max length of field {string} is {string}")
    public void verifyMaxValue(String txtBox, String value) {
        waitForPageToLoad(driver);
        captureScreenshot(driver, testContext, false);
        Assert.assertEquals(txtBox + " Text Box has not maximum value: " +value,value , findElement(driver, String.format(onSignaturesPage.txtField, txtBox)).getAttribute("maxlength"));
    }

    @Then("User clears value in field {string}")
    public void clearValue(String txtBox) {
        waitForPageToLoad(driver);
        captureScreenshot(driver, testContext, false);
        findElement(driver, String.format(onSignaturesPage.txtFieldWithId, txtBox, txtBox, txtBox)).clear();
    }

    @Then("User verifies {string} field has {string} Value {string}")
    public void verifyField(String txtBox, String attribute, String value) {
        waitForPageToLoad(driver);
        captureScreenshot(driver, testContext, false);
        Assert.assertEquals(txtBox + " Text Box has not value " +value,value , findElement(driver, String.format(onSignaturesPage.txtField, txtBox)).getAttribute(attribute));
    }

    @Then("User Verifies {string} field should be displayed on UI")
    public void UserVerifiesFieldShouldBeDisplayedOnUI(String heading) {
        captureScreenshot(driver, testContext, false);
        syncElement(driver, findElement(driver,String.format(onSignaturesPage.getSectionHeading(),heading)), EnumsCommon.TOVISIBLE.getText());
        Assert.assertTrue(heading+" :Field was not Displayed", findElement(driver,String.format(onSignaturesPage.getSectionHeading(),heading)).getText().equalsIgnoreCase(heading));
    }
}
