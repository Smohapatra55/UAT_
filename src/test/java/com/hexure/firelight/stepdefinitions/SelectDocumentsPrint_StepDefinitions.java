package com.hexure.firelight.stepdefinitions;

import com.hexure.firelight.libraies.Enums.EnumsJSONProp;
import com.hexure.firelight.libraies.EnumsCommon;
import com.hexure.firelight.libraies.FLException;
import com.hexure.firelight.libraies.FLUtilities;
import com.hexure.firelight.libraies.TestContext;
import com.hexure.firelight.pages.SelectDocumentsToPrintPage;
import cucumber.api.java.en.Then;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class SelectDocumentsPrint_StepDefinitions extends FLUtilities
{
    private WebDriver driver;
    private SelectDocumentsToPrintPage onSelectDocumentsToPrintPage;
    private TestContext testContext;
    private static final Logger Log = LogManager.getLogger(Common_StepDefinitions.class);

    public SelectDocumentsPrint_StepDefinitions(TestContext context)
    {
        testContext = context;
        driver = context.getDriver();
        onSelectDocumentsToPrintPage = context.getPageObjectManager().getSelectDocumentsToPrintPage();
    }

    @Then("User clicks {string} button on select documents to print page")
    public void userClicksButton(String whichButton) {
        captureScreenshot(driver, testContext, false);
        if(whichButton.equalsIgnoreCase("Print Selected Documents"))
            getElement(driver, getExistingLocator(driver, onSelectDocumentsToPrintPage.getBtn_PrintDocumentsMVC(), onSelectDocumentsToPrintPage.getBtn_PrintDocumentsReact(), null, null)).click();
        else if(whichButton.equalsIgnoreCase("Back to Application"))
            onSelectDocumentsToPrintPage.getBtn_BackApplication().click();
    }

    @Then("User verifies {string} for {string} is {string}")
    public void userClicksButton(String formType, String formName, String status) {
        captureScreenshot(driver, testContext, false);
        WebElement elem;
        if(  driver.findElements(By.xpath("//div[contains(text(),'" + formName + "')]//parent::div//*[@role='checkbox' or @aria-label='" + formType + "']")).size() >0) {
            elem = driver.findElement(By.xpath("//div[contains(text(),'" + formName + "')]//parent::div//*[@role='checkbox' or @aria-label='" + formType + "']"));
            if(!(elem.getAttribute("aria-checked") == null)) {
                if(status.equalsIgnoreCase("Checked"))
                    Assert.assertTrue("Checkbox for application form " + formName + " is not in expected state", Boolean.parseBoolean(elem.getAttribute("aria-checked")));
                else
                    Assert.assertFalse("Checkbox for application form " + formName + " is not in expected state", Boolean.parseBoolean(elem.getAttribute("aria-checked")));
            }
            else
                Assert.assertTrue("Checkbox for application form " + formName +" is not in expected state", elem.getAttribute("src").contains(status));
        }
        else
            Assert.assertTrue("Checkbox for application form " + formName +" is not "+ status,findElement(driver,String.format(onSelectDocumentsToPrintPage.getCheckboxSelectDocuments(),formName,formType)).getAttribute("src").contains(status));
    }

    @Then("User verifies {string} button {string} for application {string}")
    public void userVerifyButtonExistence(String buttonName, String condition, String formName) {
        captureScreenshot(driver, testContext, false);
        boolean flag = false;
        int documentListSize = 0;
        try {
            documentListSize = driver.findElements(By.xpath("//td[text()='" + formName + "']//parent::tr//div[text()='" + buttonName + "']")).size();
            if(documentListSize == 0)
                documentListSize = driver.findElements(By.xpath("//div[@class='docName' and text()='" + formName + "']//parent::div//a[text()='" + buttonName + "']")).size();

            if(condition.equals("exists"))
                Assert.assertTrue(buttonName + " Button for application form " + formName + " does not exists", documentListSize > 0);
            else
                Assert.assertTrue(buttonName + " Button for application form " + formName + " exists", documentListSize == 0);
        }
        catch(NoSuchElementException e) {
            throw new FLException("Button state does not match " + e.getMessage());
        }
    }

    @Then("User clicks {string} button for application {string} on select documents to print page")
    public void userClickButton(String buttonName, String formName) {
        captureScreenshot(driver, testContext, false);
        boolean flag = false;
        try {
            if(testContext.getUiType().equalsIgnoreCase(EnumsCommon.UITYPE_REACT.getText()))
                clickElement(driver, driver.findElement(By.xpath("//td[text()='" + formName + "']//parent::tr//div[text()='" + buttonName + "']")));
            else
                clickElement(driver, driver.findElement(By.xpath("//div[@class='docName' and text()='" + formName + "']//parent::div//a[text()='" + buttonName + "']")));
        }
        catch(NoSuchElementException e) {
            throw new FLException("Button state does not match " + e.getMessage());
        }
    }

    @Then("User verify document for {string} does not exists on select documents to print page")
    public void userVerifyDocument(String documentType) {
        captureScreenshot(driver, testContext, false);
        waitForPageToLoad(driver);
        if(testContext.getUiType().equalsIgnoreCase(EnumsCommon.UITYPE_REACT.getText()))
            Assert.assertTrue("Document exists on select documents page", driver.findElements(By.xpath("//td[contains(text(),'" + documentType + "')]")).size() == 0);
        else
            Assert.assertTrue("Document exists on select documents page", driver.findElements(By.xpath("//div[@class='SigDoc' and text()='" + documentType + "']")).size() == 0);
    }

    @Then("User verifies {int} occurrence of {string} button for applications")
    public void userVerifyButtonExistence(int occurrence, String buttonName) {
        captureScreenshot(driver, testContext, false);
        Assert.assertTrue("Expected occurrence of button " + buttonName + "does not match" ,driver.findElements(By.xpath("//*[text()='" + buttonName + "']")).size() == occurrence);
    }

    @Then("User verifies {string} button {string} for uploaded document")
    public void userVerifyButtonNonExistence(String buttonName, String condition) {
        captureScreenshot(driver, testContext, false);
        try {
            List<WebElement> uploadedDocumentList = driver.findElements(By.xpath("//*[@class='SigDoc' or @class='documentDialog__table']//parent::div//*[text()='" + buttonName + "']"));
            if(condition.equals("exists"))
                Assert.assertTrue(buttonName + " does not exists for uploaded document", uploadedDocumentList.size() > 0);
            else
                Assert.assertTrue(buttonName + " Button for uploaded document exists", uploadedDocumentList.size() == 0);
        }
        catch(NoSuchElementException e) {
            throw new FLException("Button state does not match " + e.getMessage());
        }
    }

    @Then("User verifies document for {string} does not exists on select documents to print page")
    public void user_verifies_document_for_does_not_exists_on_select_documents_to_print_page(String documentType) {
        waitForPageToLoad(driver);
        captureScreenshot(driver, testContext, false);
        List <WebElement> list_DocTypes = driver.findElements(By.xpath("//div[@class='SigDoc' and text()='" + documentType + "']"));
        Assert.assertFalse("Remove Link is displayed and it should not display", list_DocTypes.size()>0);
    }

    @Then("User check document {string}")
    public void userSelectDocument(String document) {
        captureScreenshot(driver, testContext, false);
        waitForPageToLoad(driver);
        clickElement(driver, "//img[@aria-label='" + document + "']");
    }

}
