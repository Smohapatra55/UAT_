package com.hexure.firelight.stepdefinitions;

import com.hexure.firelight.libraies.EnumsCommon;
import com.hexure.firelight.libraies.FLUtilities;
import com.hexure.firelight.libraies.TestContext;
import com.hexure.firelight.pages.HomePage;
import com.hexure.firelight.pages.LoginSSNPage;
import com.hexure.firelight.pages.SignaturesPage;
import cucumber.api.java.en.Then;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class LoginSSN_StepDefinitions extends FLUtilities
{
    private WebDriver driver;
    private LoginSSNPage onLoginSSNPage;
    private SignaturesPage onSignaturesPage;
    private TestContext testContext;
    private static final Logger Log = LogManager.getLogger(LoginSSN_StepDefinitions.class);

    public LoginSSN_StepDefinitions(TestContext context)
    {
        testContext = context;
        driver = context.getDriver();
        onLoginSSNPage = context.getPageObjectManager().getLoginSSNPage();
    }

    @Then("User login to email link with {string} generated on signature page from home page")
    public void userLoginEmailLink(String type) {
        captureScreenshot(driver, testContext, false);
        if(type.equals("SSN")) {
            driver.get(testContext.getMapTestData().get("emailLink"));
            onLoginSSNPage.getTxtBox_MailerSSN().sendKeys(testContext.getMapTestData().get("ssn"));
            onLoginSSNPage.getTxtBox_MailerBirthDate().click();
            onLoginSSNPage.getTxtBox_MailerBirthDate().sendKeys(testContext.getMapTestData().get("birthDate"));
            onLoginSSNPage.getBtn_SubmitSSN().click();
        }
        else if(type.equals("passcode")) {
            driver.get(testContext.getMapTestData().get("emailLink"));
            onLoginSSNPage.getTxtBox_Passcode().sendKeys(testContext.getMapTestData().get("passCode"));
            onLoginSSNPage.getBtn_SubmitPasscode().click();
        }
        else {
            driver.get(testContext.getMapTestData().get("receipantLink(url)"));
            onLoginSSNPage.getTxtBox_Passcode().sendKeys(testContext.getMapTestData().get(type));
            onLoginSSNPage.getBtn_SubmitPasscode().click();
        }
    }


    @Then("User verify {string} button does not exist on SSN login page")
    public void userVerifyNoButton(String whichButton) {
        captureScreenshot(driver, testContext, false);
        waitForPageToLoad(driver);
        Assert.assertTrue("Button " + whichButton + " is displayed",findElements(driver, String.format(onLoginSSNPage.getTabById(),whichButton)).size() == 0);
    }

    @Then("User verify {string} button exists on page")
    public void userVerifyButton(String whichButton) {
        captureScreenshot(driver, testContext, false);
        waitForPageToLoad(driver);
        Assert.assertTrue("Button " + whichButton + " is displayed",findElements(driver, String.format(onLoginSSNPage.getTabById(),whichButton)).size() > 0);
    }
}
