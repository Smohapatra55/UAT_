package com.hexure.firelight.stepdefinitions;

import com.hexure.firelight.libraies.EnumsCommon;
import com.hexure.firelight.libraies.FLUtilities;
import com.hexure.firelight.libraies.TestContext;
import com.hexure.firelight.pages.FinalizePage;
import com.hexure.firelight.pages.HomePage;
import cucumber.api.java.en.Then;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.ArrayList;
import java.util.List;

public class Finalize_StepDefinition extends FLUtilities {

    private WebDriver driver;
    private FinalizePage onFinalizePage;
    private TestContext testContext;
    private HomePage onHomepage;
    private static final Logger Log = LogManager.getLogger(Finalize_StepDefinition.class);

    public Finalize_StepDefinition(TestContext context) {
        testContext = context;
        driver = context.getDriver();
        onFinalizePage = context.getPageObjectManager().getOnFinalizePage();
        onHomepage = context.getPageObjectManager().getHomePage();
    }

    @Then("User Clicks on Continue when app is in Finalize step")
    public void userClicksOnContinue() {
        waitForPageToLoad(driver);
        captureScreenshot(driver, testContext, false);
        clickElement(driver, onFinalizePage.getBtn_Continue());
    }

    @Then("User Clicks on {string} on confirmation dialog")
    public void userClicksOnConfirmationDialog(String option) {
        captureScreenshot(driver, testContext, false);
        clickElement(driver, onFinalizePage.getBtn_PopYes());
    }
    @Then("User Verifies Final popup after application submitted with message {string}")
    public void userVerifiesFinalPopupAfterApplicationSubmitted(String msg) {
       waitForPageToLoad(driver);
        captureScreenshot(driver, testContext, false);
        driver.navigate().refresh();
        waitForPageToLoad(driver);
        captureScreenshot(driver, testContext, false);
        sleepInMilliSeconds(3000);
        Assert.assertTrue("Final Popup msg is not matching", getElement(driver, getExistingLocator(driver, onFinalizePage.getPopupMsgMVC(), onFinalizePage.getPopupMsgReact(), null, null)).getText().trim().contains(msg));
    }

    @Then("User Clicks on Other Action link in popup and verify {string} not showing in Other Action Menu")
    public void userClicksOnOtherActionLink(String option) {
        captureScreenshot(driver, testContext, false);
        clickElement(driver, onFinalizePage.getLink_OtherActionPopup());
        List<String> otherActionOptions = new ArrayList<>();
        for (WebElement options : onFinalizePage.getOtheraction_options()) {
            otherActionOptions.add(options.getText().trim());
        }
        Assert.assertFalse(option + " is showing", otherActionOptions.contains(option));
    }

    @Then("User Navigates to Home Page")
    public void userNavigatestoHomePage() {
        captureScreenshot(driver, testContext, false);
        clickElement(driver, getElement(driver, getExistingLocator(driver, onHomepage.getToolBar_HomeMVC(), onHomepage.getToolBar_HomeReact(), null, null)));
    }

    @Then("User verifies Application is still in Finalize mode with Disabled Finished Tab.")
    public void user_verifies_Application_is_still_in_Finalize_mode_with_Disabled_Finished_Tab() {
        captureScreenshot(driver, testContext, false);
        Assert.assertFalse("Finished Button Is not disabled",onFinalizePage.getBtn_Continue().isEnabled());
    }


    @Then("User Clicks on yes Confirmation dialog")
    public void clickOnConfirmationDialog(){
        captureScreenshot(driver, testContext, false);
        clickElement(driver,onFinalizePage.getBtn_yes());
    }

    @Then("User App is finished verify toast Account opening is finished To print or view the application, history or documents, click on Other Actions")
    public void verifyToastPopup(){
        captureScreenshot(driver, testContext, false);
        driver.navigate().refresh();
        captureScreenshot(driver, testContext, false);
        syncElement(driver,onFinalizePage.getTxt_ToastMsgLine1(), EnumsCommon.TOVISIBLE.getText());
        Assert.assertTrue("Toast massage is showing Account is pending",onFinalizePage.getTxt_ToastMsgLine1().getText().trim().contains("Account opening is finished."));
    }

    @Then("User verifies URL is redirected to {string}")
    public void user_verifies_URL_is_redirected_to(String urlValue) {
        captureScreenshot(driver, testContext, false);
        waitForPageToLoad(driver);
        Assert.assertEquals("Current URL did not match the expected URL" , driver.getCurrentUrl(), urlValue);
    }

    @Then("User Navigates back to previous page and verifies user is lead to Firelight Login Page and Not Submission page")
    public void user_Navigates_back_to_previous_page_and_verifies_user_is_lead_to_Firelight_Login_Page_and_Not_Submission_page() {
        captureScreenshot(driver, testContext, false);
        driver.navigate().back();
        Assert.assertTrue("User did not navigate back to Firelight Login Page", driver.getCurrentUrl().contains(testContext.getMapTestData().get("expectedURLBack")));
    }

    @Then("User verifies URL is NOT redirected to {string}")
    public void user_verifies_URL_is_NOT_redirected_to(String urlValue) {
        captureScreenshot(driver, testContext, false);
        waitForPageToLoad(driver);
        Assert.assertNotEquals("Current URL matched the expected URL" , driver.getCurrentUrl(), urlValue);
    }

    @Then("User clicks on Linked Icon on Top border of the form")
    public void user_clicks_on_Linked_Icon_on_Top_border_of_the_form() {
        captureScreenshot(driver, testContext, false);
        clickElementByJSE(driver, onFinalizePage.getLinkIcon());
    }

    @Then("User verifies popup {string}")
    public void user_verifies_popup(String fieldValue) {
        captureScreenshot(driver, testContext, false);
        Assert.assertTrue("Popup message mismatched ", onFinalizePage.getPopUpBody().getText().trim().contains(fieldValue));
    }


    @Then("User Verifies Yes and No button displayed on Confirmation Dialog")
    public void userVerifiesYesAndNoButtonDisplayedOnConfirmationDialog() {
        captureScreenshot(driver, testContext, false);
        Assert.assertTrue("Yes button is not displayed",onFinalizePage.getBtn_PopYes().isDisplayed());
        Assert.assertTrue("No button is not displayed",onFinalizePage.getBtn_PopNo().isDisplayed());
    }
    @Then("User verifies the popup {string}")
    public void user_verifies_the_popup(String popUpMSG) {
        waitForPageToLoad(driver);
        captureScreenshot(driver, testContext, false);
        Assert.assertTrue("Popup was not displayed", onFinalizePage.getTxt_ToastMsgLine1().getText().contains(popUpMSG));
    }

    @Then("User verifies {string} is {string} tab")
    public void user_verifies_is_tab(String statusNotice, String status) {
        Assert.assertTrue(statusNotice + " :is not the current tab", findElement(driver, String.format(onFinalizePage.statusNoticeBar, status)).getAttribute("class").contains(status));
    }
}
