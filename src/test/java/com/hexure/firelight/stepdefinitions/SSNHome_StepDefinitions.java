package com.hexure.firelight.stepdefinitions;

import com.hexure.firelight.libraies.EnumsCommon;
import com.hexure.firelight.libraies.FLException;
import com.hexure.firelight.libraies.FLUtilities;
import com.hexure.firelight.libraies.TestContext;
import com.hexure.firelight.pages.SSNHomePage;
import cucumber.api.java.en.Then;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.velocity.util.introspection.UberspectImpl;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

public class SSNHome_StepDefinitions extends FLUtilities
{
    private WebDriver driver;
    private SSNHomePage onSSNHomePage;
    private TestContext testContext;
    private static final Logger Log = LogManager.getLogger(SSNHome_StepDefinitions.class);
    String pdfFileName = "";
    private String ssnPage;

    public SSNHome_StepDefinitions(TestContext context)
    {
        testContext = context;
        driver = context.getDriver();
        onSSNHomePage = context.getPageObjectManager().getSSNHomePage();
    }

    @Then("User clicks {string} button on page")
    public void userClicksButton(String whichButton) {
        captureScreenshot(driver, testContext, false);
        waitForPageToLoad(driver);
        switch (whichButton) {
            case "Sign Activity":
                clickElement(driver, getElement(driver, getExistingLocator(driver, onSSNHomePage.getLink_SignActivity1(), onSSNHomePage.getLink_SignActivity2(), onSSNHomePage.getLink_SignActivity3(), null)));
                break;
            case "Attach Documents":
                clickElement(driver, getElement(driver, getExistingLocator(driver, onSSNHomePage.getLink_AttachDocuments(), null, null, null)));
                break;
        }

        if(testContext.getMapTestData().get("uiType").equalsIgnoreCase("react")) {
            switch (whichButton) {
                case "Logoff":
                    clickElement(driver, onSSNHomePage.getBtn_Logoff());
                    break;
                case "Review Documents":
                    clickElement(driver, onSSNHomePage.getLink_NewReviewDocuments());
                    break;
                case "OK":
                    clickElementByJSE(driver, onSSNHomePage.getBtn_NewOK());
                    break;
                }
            }
        else {
            switch (whichButton) {
                case "Review Documents":
                    clickElement(driver, onSSNHomePage.getLink_ReviewDocuments());
                    break;
                case "Logoff":
                    clickElement(driver, onSSNHomePage.getBtn_Logoff());
                    break;
                case "Download All":
                    clickElement(driver,  onSSNHomePage.getLink_DownloadAll());
                    break;
                case "View All":
                    clickElement(driver,  onSSNHomePage.getLink_ViewAll());
                    break;
            }
        }
    }

    @Then("User verify {string} button exists")
    public void userVerifyButton(String whichButton) {
        captureScreenshot(driver, testContext, false);
        waitForPageToLoad(driver);
        Assert.assertTrue("Button " + whichButton + " is not displayed",onSSNHomePage.userVerifyButton(whichButton, testContext, driver));
    }

    @Then("User verify there are {string} documents available on SSN home page")
    public void userVerifyDocumentCounts(String countDocuments) {
        captureScreenshot(driver, testContext, false);
        Assert.assertEquals("Expected count of documents does not match",onSSNHomePage.getTxt_DocumentNames().size()-1, Integer.parseInt(countDocuments));
    }

    @Then("User verify title of page is {string} for {string}")
    public void verifyPageTitle(String title, String user) {
        captureScreenshot(driver, testContext, false);
        Assert.assertTrue("Title of page is not " + title, driver.findElement(By.xpath("//div[contains(text(),\"" + title + " '" + testContext.getMapTestData().get("newProductName") + "'\")]")).isDisplayed());
    }

    @Then("User verify document {string} exists with view and download buttons on SSN home page")
    public void verifyDocuments(String documentName) {
        captureScreenshot(driver, testContext, false);
        Assert.assertTrue("Document " + documentName + " does not exists", driver.findElement(By.xpath("//table[@id='tblFinalPdf']//tr//td[contains(text(),'" + documentName + "')]")).isDisplayed());
        Assert.assertTrue("Document " + documentName + " does not exists", driver.findElement(By.xpath("//table[@id='tblFinalPdf']//tr//td[contains(text(),'" + documentName + "')]//..//a[text()='View']")).isDisplayed());
        Assert.assertTrue("Document " + documentName + " does not exists", driver.findElement(By.xpath("//table[@id='tblFinalPdf']//tr//td[contains(text(),'" + documentName + "')]//..//a[text()='Download']")).isDisplayed());
    }


    @Then("User verify generated PDF displays correct data on SSN home page")
    public void verifyDataPDFGeneratedSSN() throws Exception{
        //TODO : Date does not appear in pdf text

        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        String pdfText = "";
        if (tabs.size() > 1)
            driver.switchTo().window(tabs.get(1));
        try {
            pdfFileName = testContext.getModuleName() + "-" + testContext.getTestCaseID() + "_" + getDate("pdfFileName") + ".pdf";
            Path downloadFilePath = Paths.get(EnumsCommon.ABSOLUTE_DOWNLOADFILES_PATH.getText(), "PrintPDF.pdf");
            new WebDriverWait(driver, 60).until(d -> downloadFilePath.toFile().exists());
            renameFile("PrintPDF", pdfFileName);
            pdfText = getPDFText(pdfFileName);
        }
        catch (IOException e) {
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
        Assert.assertTrue("Could not find applicant income in PDF File ", pdfText.contains(testContext.getMapTestData().get("amountIncome")));
        Assert.assertTrue("Could not find joint applicant income in PDF File ", pdfText.contains(testContext.getMapTestData().get("amountJointIncome")));
        Assert.assertTrue("Could not find applicant net worth in PDF File ", pdfText.contains(testContext.getMapTestData().get("amountNetWorth")));
        Assert.assertTrue("Could not find joint applicant net worth in PDF File ", pdfText.contains(testContext.getMapTestData().get("amountNetJointWorth")));
    }

    @Then("User verify generated PDF displays signature done by first client on SSN home page")
    public void verifySignPDFGeneratedSSN() throws Exception{
        //TODO : Date does not appear in pdf text
        Assert.assertTrue("Signed Image does not exists in generated PDF", verifySignatureMatchingInPDF(testContext, pdfFileName));
    }

    @Then("User verify that application forms and templates are not displayed on SSN home page")
    public void verifyNoApplicationFormTemplate() throws Exception{
        captureScreenshot(driver, testContext, false);
        Assert.assertTrue("Application form or template do exists", onSSNHomePage.getList_ApplicationForms().size() == 0);
    }

    @Then("User verify error message {string} on SSN home page")
    public void verifyErrorMessage(String message) throws Exception{
        captureScreenshot(driver, testContext, false);
        Assert.assertTrue("Error message does not exist", getElement(driver, getExistingLocator(driver, onSSNHomePage.getTxt_ErrorMsg(), onSSNHomePage.getTxt_ErrorMsg1(), onSSNHomePage.getTxt_ErrorMsg2(), null)).getText().equalsIgnoreCase(message));
    }

    @Then("User verify error message {string}")
    public void verifyErrorMessages(String message) throws Exception{
        captureScreenshot(driver, testContext, false);
        Assert.assertTrue("Error message does not exist", getElement(driver, getExistingLocator(driver, onSSNHomePage.getTxt_ErrorMsg(), onSSNHomePage.getTxt_ErrorMsg1(), onSSNHomePage.getTxt_ErrorMsg2(), null)).getText().equalsIgnoreCase(message));
    }
}
