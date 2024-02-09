package com.hexure.firelight.stepdefinitions;

import com.hexure.firelight.libraies.EnumsCommon;
import com.hexure.firelight.libraies.FLUtilities;
import com.hexure.firelight.libraies.TestContext;
import com.hexure.firelight.pages.FinishPage;
import cucumber.api.java.en.Then;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Finish_StepDefinitions extends FLUtilities {
    private WebDriver driver;
    private FinishPage onFinishPage;
    private TestContext testContext;
    private static final Logger Log = LogManager.getLogger(Finish_StepDefinitions.class);

    public Finish_StepDefinitions(TestContext context) {
        testContext = context;
        driver = context.getDriver();
        onFinishPage = context.getPageObjectManager().getFinishPage();
    }

    @Then("User application is {string} and verify Popup message")
    public void userApplicationFinishAndVerifyPopupMsg(String message) {
        syncElement(driver, onFinishPage.getMsg_Popup_finish1(), EnumsCommon.TOVISIBLE.getText());
        captureScreenshot(driver, testContext, false);
        Assert.assertTrue("Application Finish message1 Mismatched", onFinishPage.getMsg_Popup_finish1().getText().trim().split("\n")[0].trim().equalsIgnoreCase(testContext.getMapTestData().get("applFinish_Msg1")));
        Assert.assertTrue("Application finish message2 MisMatched", onFinishPage.getMsg_Popup_finish1().getText().trim().split("\n")[1].trim().equalsIgnoreCase(testContext.getMapTestData().get("applFinish_Msg2")));
        if(!(testContext.getMapTestData().get("applFinish_Msg3").equalsIgnoreCase("")))
            Assert.assertTrue("Application finish message3 MisMatched", onFinishPage.getMsg_Popup_finish1().getText().trim().split("\n")[2].trim().equalsIgnoreCase(testContext.getMapTestData().get("applFinish_Msg3")));
    }

    @Then("User verifies {string} dialog message")
    public void user_verifies_dialog_message(String message) {
        driver.navigate().refresh();
        captureScreenshot(driver, testContext, false);
        syncElement(driver, onFinishPage.getMsg_Popup_finish1(), EnumsCommon.TOVISIBLE.getText());
        Assert.assertTrue( message+" message Mismatched", onFinishPage.getMsg_Popup_finish1().getText().contains(message));
    }

    @Then("User verifies application is finished and closes toast pop up")
    public void user_verifies_application_is_finished_and_closes_toast_pop_up() {
        waitForPageToLoad(driver);
        captureScreenshot(driver, testContext, false);
        Assert.assertTrue("Application Finish did not appear", onFinishPage.getMsg_Popup_AppFinished().isDisplayed());
        clickElementByJSE(driver, onFinishPage.getIcon_PopUpClose_React());
    }

    @Then("User verifies second toast message {string} or {string} on Application Page")
    public void user_verifies_second_toast_message_or_on_Application_Page(String message1, String message2) {
        waitForPageToLoad(driver);
        captureScreenshot(driver, testContext, false);
        for (WebElement message : onFinishPage.getMsg_Popup_finish2()) {
            Assert.assertTrue(message1 + " or " + message2 + ":: Toast popup NOT Visible", message.getText().contains(message1) || message.getText().contains(message2));
        }
    }
    @Then("User verifies application is {string} and verify Popup message")
    public void userVerifiesApplicationFinishAndVerifyPopupMsg(String message) {
        syncElement(driver, onFinishPage.getMsg_Popup_finish1(), EnumsCommon.TOVISIBLE.getText());
        captureScreenshot(driver, testContext, false);
        Assert.assertTrue("Application Finish message1 Mismatched", onFinishPage.getMsg_Popup_finish1().getText().trim().split("\n")[0].trim().equalsIgnoreCase(testContext.getMapTestData().get("applFinish_Msg1")));
        Assert.assertTrue("Application finish message2 MisMatched", onFinishPage.getMsg_Popup_finish1().getText().trim().split("\n")[1].trim().equalsIgnoreCase(testContext.getMapTestData().get("applFinish_Msg2")));
        if(!(testContext.getMapTestData().get("applFinish_Msg3").equalsIgnoreCase("")))
            Assert.assertTrue(message + "Application finish message3 MisMatched", onFinishPage.getMsg_Popup_finish1().getText().trim().split("\n")[2].trim().equalsIgnoreCase(testContext.getMapTestData().get("applFinish_Msg3")));
    }

}
