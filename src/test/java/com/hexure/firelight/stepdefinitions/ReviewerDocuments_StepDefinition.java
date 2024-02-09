package com.hexure.firelight.stepdefinitions;

import com.hexure.firelight.libraies.Enums.EnumsJSONProp;
import com.hexure.firelight.libraies.EnumsCommon;
import com.hexure.firelight.libraies.FLUtilities;
import com.hexure.firelight.libraies.TestContext;
import com.hexure.firelight.pages.ReviewPage;
import com.hexure.firelight.pages.ReviewQueuePage;
import com.hexure.firelight.pages.ReviewerDocumentsPage;
import cucumber.api.java.en.Then;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReviewerDocuments_StepDefinition extends FLUtilities {
    private WebDriver driver;
    private ReviewerDocumentsPage onReviewerDocumentsPage;
    private ReviewQueuePage onReviewQueuePage;
    private TestContext testContext;
    private static final Logger Log = LogManager.getLogger(ReviewerDocuments_StepDefinition.class);

    public ReviewerDocuments_StepDefinition(TestContext context) {
        testContext = context;
        driver = context.getDriver();
        onReviewerDocumentsPage = context.getPageObjectManager().getReviewerDocumentsPage();
        onReviewQueuePage=context.getPageObjectManager().getOnReviewQueuePage();
    }

    @Then("User Enters some data in Reviewer Document Page")
    public void user_Enters_some_data_in_Reviewer_Document_Page() {
        captureScreenshot(driver, testContext, false);
        Assert.assertTrue("User is not on Reviewer Documents page",onReviewerDocumentsPage.getPageHeading().getText().trim().contains("Reviewer Documents"));
        onReviewerDocumentsPage.getTxtBox_ReviewerName().sendKeys(testContext.getMapTestData().get("reviewerName"));
        onReviewerDocumentsPage.getTxtBox_ReviewerFirstName().sendKeys(testContext.getMapTestData().get("reviewerFirstName"));
        onReviewerDocumentsPage.getTxtBox_ReviewerLastName().sendKeys(testContext.getMapTestData().get("reviewerLastName"));
        onReviewerDocumentsPage.getTxtBox_ReviewerComment().clear();
        onReviewerDocumentsPage.getTxtBox_ReviewerComment().sendKeys(testContext.getMapTestData().get("reviewerComment"));
    }

    @Then("User Clicks on Complete button")
    public void user_Clicks_on_Complete_button() {
        captureScreenshot(driver, testContext, false);
        clickElement(driver,onReviewerDocumentsPage.getBtn_Complete());
    }

    @Then("User  Clicks Lock and Complete button")
    public void user_Clicks_Lock_and_Complete_button() {
        waitForPageToLoad(driver);
        captureScreenshot(driver, testContext, false);
        onReviewQueuePage.getBtn_PopOk().click();
    }

    @Then("User Verifies the Reviewer comment entered earlier {string}")
    public void UserVerifiestheReviewerCommentEnteredEarlier(String comment){
        captureScreenshot(driver, testContext, false);
        Assert.assertEquals("Reviewer Comment mismatched",testContext.getMapTestData().get(comment) , onReviewerDocumentsPage.getTxtBox_ReviewerComment().getAttribute("value").trim());
    }

    @Then("User Enters some data in Reviewer Document Page Again")
    public void user_Enters_some_data_in_Reviewer_Document_PageAgain() {
        captureScreenshot(driver, testContext, false);
        sendKeys(driver,onReviewerDocumentsPage.getTxtBox_ReviewerName(),testContext.getMapTestData().get("reviewerName2"));
        sendKeys(driver,onReviewerDocumentsPage.getTxtBox_ReviewerFirstName(),testContext.getMapTestData().get("reviewerFirstName2"));
        sendKeys(driver,onReviewerDocumentsPage.getTxtBox_ReviewerLastName(),testContext.getMapTestData().get("reviewerLastName2"));
        sendKeys(driver,onReviewerDocumentsPage.getTxtBox_ReviewerComment(),testContext.getMapTestData().get("reviewerComment2"));
    }

    @Then("User Enters some data in Reviewer Document Page Again with {string}")
    public void user_Enters_some_data_in_Reviewer_Document_Page_Again_with(String comment) {
        captureScreenshot(driver, testContext, false);
        onReviewerDocumentsPage.getTxtBox_ReviewerName().clear();
        onReviewerDocumentsPage.getTxtBox_ReviewerName().sendKeys(testContext.getMapTestData().get("reviewerName2"));
        onReviewerDocumentsPage.getTxtBox_ReviewerFirstName().clear();
        onReviewerDocumentsPage.getTxtBox_ReviewerFirstName().sendKeys(testContext.getMapTestData().get("reviewerFirstName2"));
        onReviewerDocumentsPage.getTxtBox_ReviewerLastName().clear();
        onReviewerDocumentsPage.getTxtBox_ReviewerLastName().sendKeys(testContext.getMapTestData().get("reviewerLastName2"));
        onReviewerDocumentsPage.getTxtBox_ReviewerComment().clear();
        onReviewerDocumentsPage.getTxtBox_ReviewerComment().sendKeys(testContext.getMapTestData().get(comment));
    }

}
