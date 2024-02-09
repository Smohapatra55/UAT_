package com.hexure.firelight.stepdefinitions;

import com.hexure.firelight.libraies.FLUtilities;
import com.hexure.firelight.libraies.TestContext;
import com.hexure.firelight.pages.EnrollmentPage;
import cucumber.api.java.en.Then;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.*;

public class Enrollment_StepDefinition extends FLUtilities {
    private WebDriver driver;
    private EnrollmentPage onEnrollmentPage;
    private TestContext testContext;
    private static final Logger Log = LogManager.getLogger(Enrollment_StepDefinition.class);

    public Enrollment_StepDefinition(TestContext context) {
        testContext = context;
        driver = context.getDriver();
        onEnrollmentPage = context.getPageObjectManager().getOnEnrollmentPage();
    }

    @Then("User verify {int} records are imported in {string}")
    public void userVerifyButtonExistence(int occurrence, String buttonName) {
        captureScreenshot(driver, testContext, false);
        Assert.assertTrue("Expected records " + occurrence + " does not match" ,driver.findElements(By.xpath("//*[@class='" + testContext.getMapTestData().get(buttonName) + "']")).size() == occurrence);
    }


}
