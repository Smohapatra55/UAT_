package com.hexure.firelight.stepdefinitions;

import com.hexure.firelight.libraies.Enums.EnumsJSONProp;
import com.hexure.firelight.libraies.EnumsCommon;
import com.hexure.firelight.libraies.FLUtilities;
import com.hexure.firelight.libraies.TestContext;
import com.hexure.firelight.pages.RCTCompleteFillingAndSigningPage;
import com.hexure.firelight.pages.RequestSentPage;
import cucumber.api.java.en.Then;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RCTCompleteFillingSigning_StepDefinition extends FLUtilities {
    private WebDriver driver;
    private TestContext testContext;
    private RCTCompleteFillingAndSigningPage onRCTCompleteFillingAndSigningPage;
    private static final Logger Log = LogManager.getLogger(RCTCompleteFillingSigning_StepDefinition.class);
    private RequestSentPage onRequestSentPage;

    public RCTCompleteFillingSigning_StepDefinition(TestContext context) {
        testContext = context;
        driver = context.getDriver();
        onRCTCompleteFillingAndSigningPage = context.getPageObjectManager().getonRCTCompleteFillingAndSigningPage();
        onRequestSentPage = context.getPageObjectManager().getOnRequestSentPage();
    }

    @Then("User Keeps the Annuitant as Primary owner enters Details for Both Annuitant & owner")
    public void userKeepsTheAnnuitantasPrimaryOwnerEntersDetails() {
        captureScreenshot(driver, testContext, false);
        onRCTCompleteFillingAndSigningPage.entersDetailsForBothAnnuitantOwner(testContext, driver);
    }

    @Then("User enters {string} details on page")
    public void enterUserDetails(String user) {
        captureScreenshot(driver, testContext, false);
        onRCTCompleteFillingAndSigningPage.enterUserDetails(testContext, driver, user);
    }

    @Then("User verify {string} text {string} for {string}")
    public void verifyClientAuthenticationText(String text, String condition, String user) {
        captureScreenshot(driver, testContext, false);
        if(condition.equalsIgnoreCase("exists"))
            Assert.assertTrue(text + " text does not exists for user " + user, driver.findElement(By.xpath("//input[@value='" + user + "']//parent::div//parent::div[@class='divFillAndSign']")).getText().contains(text));
        else
            Assert.assertFalse(text + " text exists for user " + user, driver.findElement(By.xpath("//input[@value='" + user + "']//parent::div//parent::div[@class='divFillAndSign']")).getText().contains(text));
    }

    @Then("User verify field {string} {string} for {string}")
    public void verifyUserFields(String field, String condition, String user) {
        captureScreenshot(driver, testContext, false);
        int fieldElementSize = driver.findElements(By.xpath("//input[@value='" + user + "']//parent::div//parent::div[@class='divFillAndSign']//input[contains(@aria-label,'" + field + "')]")).size();
        if(condition.equalsIgnoreCase("exists"))
            Assert.assertTrue(field + " does not exists for user " + user, fieldElementSize > 0);
        else
            Assert.assertTrue(field + " does not exists for user " + user, fieldElementSize == 0);
    }

    @Then("User remove {string} details on page")
    public void femoveUserDetails(String user) {
        captureScreenshot(driver, testContext, false);
        onRCTCompleteFillingAndSigningPage.removeUserDetails(testContext, driver, user);
    }

    @Then("User Now Clicks Send Email Request button")
    public void userNowClicksSendEmailRequestButton() {
        captureScreenshot(driver, testContext, false);
        onRCTCompleteFillingAndSigningPage.getBtn_SendEmail().click();
    }

    @Then("User {string} Dialog appear with Generated URL for {string}, Stores the URL, Verifies the email on dialog box, Then Clicks on OK")
    public void userRequestsSentDialogAppear(String popupHeader, String user) {
        captureScreenshot(driver, testContext, false);
        Assert.assertEquals("User is not in " + popupHeader, popupHeader, onRequestSentPage.getPopupTitleRequestSent().getText().trim());
        Assert.assertTrue("Url not displayed", onRequestSentPage.getUrl().isDisplayed());
        addPropertyValueInJSON(testContext.getTestCaseID(), testContext, EnumsJSONProp.RECEIPANTURL.getText(), onRequestSentPage.getUrl().getText().trim());
        Assert.assertTrue("Email not verified", onRequestSentPage.getPopupMsg().getText().contains(testContext.getMapTestData().get(user + "Email")));
        clickElement(driver, onRequestSentPage.getPopupOkbtn());
    }


    @Then("User clicks on Send Email button on signing application")
    public void userClicksOnSendEmailButtonOnSigningApplication() {
        waitForPageToLoad(driver);
        captureScreenshot(driver, testContext, false);
        clickElementByJSE(driver,onRCTCompleteFillingAndSigningPage.getBtn_SendEmailOnSigningApp());
    }

    @Then("User clicks on remove link of joint owner")
    public void userClicksOnRemve(){
        captureScreenshot(driver, testContext, false);
        clickElementByJSE(driver,onRCTCompleteFillingAndSigningPage.getBtn_RemoveJointOwner());
    }

    @Then("User verifies {string} popup box appeared")
    public void userVerifiesPopupBoxAppeared(String title) {
        waitForPageToLoad(driver);
        captureScreenshot(driver, testContext, false);
        if (findElements(driver, "//div[@class='toastTitle']").size() > 0) {
            Assert.assertEquals("Popup box is mismatched", title, onRCTCompleteFillingAndSigningPage.getHeader_RequestSentPopupReact().getText().trim());
        } else {
            Assert.assertEquals("Popup box is mismatched", title, onRCTCompleteFillingAndSigningPage.getHeader_RequestSentPopup().getText().trim());
        }
    }

    @Then("User Verifies data on Request Sent dialogue box")
    public void userVerifiesDataOnRequestSentDialogueBox() {
        waitForPageToLoad(driver);
        captureScreenshot(driver, testContext, false);
        Assert.assertEquals("Request Sent dialog box 1st msg line is mismatched","Message sent to "+testContext.getMapTestData().get("ownerEmail"),onRCTCompleteFillingAndSigningPage.getMsg_RequestSentPopup().getText().split("\n")[0].trim());
        Assert.assertTrue("Request Sent dialog box 2nd msg line is mismatched",onRCTCompleteFillingAndSigningPage.getMsg_RequestSentPopup().getText().split("\n")[1].trim().contains("at "));
        Assert.assertEquals("Request Sent dialog box 3rdt msg line is mismatched",testContext.getMapTestData().get("thirdMsgOnRequestSentPopupBox"),onRCTCompleteFillingAndSigningPage.getMsg_RequestSentPopup().getText().split("\n")[3].trim());
        Assert.assertTrue("Ok button is not displayed on Request Sent dialog box",onRCTCompleteFillingAndSigningPage.getBtn_OkDialogBox().isDisplayed());
        Assert.assertTrue("External URl/link is not displayed.",onRCTCompleteFillingAndSigningPage.getLink_ExternalURL().isDisplayed());
        addPropertyValueInJSON(testContext.getTestCaseID(), testContext, "externalURl", onRCTCompleteFillingAndSigningPage.getLink_ExternalURL().getText().trim());
    }

    @Then("User verify {string} button does not exist")
    public void userVerifyNoButton(String whichButton) {
        captureScreenshot(driver, testContext, false);
        waitForPageToLoad(driver);
        if(findElements(driver, String.format(onRCTCompleteFillingAndSigningPage.getTabById(),whichButton)).size() == 0)
            Assert.assertTrue("Button " + whichButton + " is displayed",findElements(driver, String.format(onRCTCompleteFillingAndSigningPage.getTabById(),whichButton)).size() == 0);
        else
            Assert.assertTrue("Button " + whichButton + " is displayed", driver.findElement(By.xpath(String.format(onRCTCompleteFillingAndSigningPage.getTabById(),whichButton))).getAttribute("style").contains("display: none"));
    }

    @Then("User Enters Name And Email For {string}")
    public void user_Enters_Name_And_Email_For(String user) {
        captureScreenshot(driver, testContext, false);
        onRCTCompleteFillingAndSigningPage.enterUserDetailsOnlyNameEmail(testContext, driver, user);
        captureScreenshot(driver, testContext, false);
    }

    @Then("User Verifies text {string}")
    public void user_Verifies_text(String message) {
        captureScreenshot(driver, testContext, false);
        Assert.assertTrue("Message is not matching on Fill and Sign app",getElement(driver, getExistingLocator(driver, onRCTCompleteFillingAndSigningPage.getTxt_OwnerMVC(), onRCTCompleteFillingAndSigningPage.getTxt_OwnerReact(), onRCTCompleteFillingAndSigningPage.getTxt_OwnerMVC1(), null)).getText().trim().contains(message));
        captureScreenshot(driver, testContext, false);
    }

    @Then("User verifies insured error msg name,email,ssn and DOB")
    public void verifyPayorFiled(){
        Assert.assertEquals("Error Msg name is Mismatched",testContext.getMapTestData().get("insuredErrorNM"),onRCTCompleteFillingAndSigningPage.getErrorMsg_InsuredNM().getText().trim());
        Assert.assertEquals("Error Msg email is Mismatched",testContext.getMapTestData().get("insuredErroremail"),onRCTCompleteFillingAndSigningPage.getErrorMsg_InsuredEmail().getText().trim());
        Assert.assertEquals("Error Msg DOB is Mismatched",testContext.getMapTestData().get("insuredErrorSSN"),onRCTCompleteFillingAndSigningPage.getErrorMsg_InsuredSsn().getText().trim());
        Assert.assertEquals("Error Msg email is Mismatched",testContext.getMapTestData().get("insuredErrorDOB"),onRCTCompleteFillingAndSigningPage.getErrorMsg_InsuredDOB().getText().trim());
    }

    @Then("User select {string} checkbox on ReactApp page")
    public void selectCheckbox(String user) {
        captureScreenshot(driver, testContext, false);
        onRCTCompleteFillingAndSigningPage.selectCheckbox(testContext, driver, user);
    }

    @Then("User verifies {string} popup box does not appeared")
    public void userVerifiesPopupBoxDoesNotAppeared(String title) {
        waitForPageToLoad(driver);
        captureScreenshot(driver, testContext, false);
        Assert.assertFalse("PopUp Displayed: "+title,findElements(driver, onRCTCompleteFillingAndSigningPage.header_RequestPopupReact).size() > 0);
    }
}
