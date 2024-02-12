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

    public String getEmailLink(String mailBody) {
        String[] lstContent = {">Click",","};
        for (String content : lstContent) {
            if (mailBody.contains(content) & mailBody.lastIndexOf(content) > mailBody.lastIndexOf("https"))
                return mailBody.substring(mailBody.lastIndexOf("https"), mailBody.lastIndexOf(content)).trim();
        }
        return null;
    }
    @Then("User Verifies Heading {string}")
    public void user_Verifies_Heading(String pageHeading) {
        syncElement(driver,onCreateApplicationPage.getBtn_Create(),EnumsCommon.TOVISIBLE.getText());
        captureScreenshot(driver, testContext, false);
        Assert.assertEquals("Page is not correct with Heading" + pageHeading, pageHeading, onReviewPage.getHeading_Reviewer().getText().trim());
    }
}













