package com.hexure.firelight.stepdefinitions;

import com.hexure.firelight.libraies.Enums.EnumsJSONProp;
import com.hexure.firelight.libraies.EnumsCommon;
import com.hexure.firelight.libraies.FLException;
import com.hexure.firelight.libraies.FLUtilities;
import com.hexure.firelight.libraies.TestContext;
import com.hexure.firelight.libraies.pages_react.CommonMethods_ReactPage;
import com.hexure.firelight.pages.CreateApplicationPage;
import com.hexure.firelight.pages.TabAppPage;
import cucumber.api.java.en.Then;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.WebElement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CreateApplication_StepDefinitions extends FLUtilities {
    private WebDriver driver;
    private CreateApplicationPage onCreateApplicationPage;
    private TestContext testContext;

    private CommonMethods_ReactPage onCommonMethods_reactPage;
    private static final Logger Log = LogManager.getLogger(Common_StepDefinitions.class);

    public CreateApplication_StepDefinitions(TestContext context) {
        testContext = context;
        driver = context.getDriver();
        onCreateApplicationPage = context.getPageObjectManager().getCreateApplicationPage();
    }

    @Then("User selects Jurisdiction {string}")
    public void userSelectsJurisdiction(String jurisdiction) {
        captureScreenshot(driver, testContext, false);
        new Select(onCreateApplicationPage.getDd_Jurisdiction()).selectByVisibleText(jurisdiction);
        //TODO: remove below line if not required
        addPropertyValueInJSON(testContext.getTestCaseID(), testContext, EnumsJSONProp.JURISDICTION.getText(), jurisdiction);
    }

    @Then("User selects Product Type Dropdown {string}")
    public void userSelectsProductTypeDropdown(String productType) {
        waitForPageToLoad(driver);
        waitUntilDropDownListPopulated(driver, new Select(onCreateApplicationPage.getDd_ProductType()));
        captureScreenshot(driver, testContext, false);
        new Select(onCreateApplicationPage.getDd_ProductType()).selectByVisibleText(productType);
    }

    @Then("User selects Given Product {string}")
    public void userSelectsGivenProduct(String product) {
        syncMultipleElement(driver,onCreateApplicationPage.getList_Products(),EnumsCommon.TOVISIBLE.getText());
        captureScreenshot(driver, testContext, false);
        selectOptionFromList(driver, onCreateApplicationPage.getList_Products(), product, EnumsCommon.CLICK.getText());
        addPropertyValueInJSON(testContext.getTestCaseID(), testContext, EnumsJSONProp.PRODUCT.getText(), product);
    }

    @Then("User selects Given Product {string} for application")
    public void userSelectsGivenProductForApp(String product) {
        captureScreenshot(driver, testContext, false);
        selectOptionFromListByCase(driver, onCreateApplicationPage.getList_Products(), product, EnumsCommon.CLICK.getText());
        if(product.length() > 35)
            product = product.substring(0, product.lastIndexOf(" "));
        addPropertyValueInJSON(testContext.getTestCaseID(), testContext, EnumsJSONProp.PRODUCT.getText(), product);
    }


    @Then("User verifies application is {string} with toast popup")
    public void userVerifiesApplicationIsFinishedWithToastPopup(String message) {
        syncElement(driver, onCreateApplicationPage.getMsg_ApplicationFinishToastPopup(), EnumsCommon.TOVISIBLE.getText());
        if (testContext.getMapTestData().get("applicationFinishToastPopupMessage").contains("finished") & onCreateApplicationPage.getMsg_ApplicationFinishToastPopup().getText().contains("pending"))

        Assert.assertTrue("Application Finish ToastPopup Message MisMatched", onCreateApplicationPage.getMsg_ApplicationFinishToastPopup().getText().trim().contains(
                testContext.getMapTestData().get("applicationFinishToastPopupMessage")));

        if(!(testContext.getMapTestData().get("applicationFinishToastPopupMessage2").equals("")))
            Assert.assertTrue("Application Finish ToastPopup Message MisMatched", onCreateApplicationPage.getMsg_ApplicationFinishToastPopup().getText().trim().contains(
                    testContext.getMapTestData().get("applicationFinishToastPopupMessage2")));

        captureScreenshot(driver, testContext, false);
        onCreateApplicationPage.getLink_Close().click();
    }

    @Then("User clicks on {string} button on incomplete activity pop up dialog")
    public void clickIncompleteActivity(String value) {
        waitForPageToLoad(driver);
        if (value.equalsIgnoreCase("ok"))
            onCreateApplicationPage.getBtn_PopOk().click();
        else
            onCreateApplicationPage.getBtn_PopCancel().click();
    }

    @Then("User verifies {string} window showing")
    public void userVerifiesWindowShowing(String windownamecreatenew) {
        captureScreenshot(driver, testContext, false);
        Assert.assertEquals("User is not on Create new Application window", windownamecreatenew, onCreateApplicationPage.getTxt_createNewApplicationwindow().getText().trim());
    }

    @Then("User check optional form {string}")
    public void userCheckOptional(String optionalForm) {
        captureScreenshot(driver, testContext, false);
        clickElement(driver, driver.findElement(By.xpath("//*[text()='" + optionalForm + "']//parent::strong//parent::td//preceding-sibling::td//input[@type='checkbox']")));
    }

    @Then("User verify {string} product not showing")
    public void userVerifyProductNotShowing(String option) {
        captureScreenshot(driver, testContext, false);
        List<String> applicationOptions = new ArrayList<>();
        for (WebElement options : onCreateApplicationPage.getList_Products()) {
            applicationOptions.add(options.getText().trim());
        }
        Assert.assertFalse(option + " is showing", applicationOptions.contains(option));
    }

    @Then("User clicks on Product Type")
    public void user_clicks_on_Product_Type() {
        waitForPageToLoad(driver);
        captureScreenshot(driver, testContext, false);
        clickElement(driver,onCreateApplicationPage.getDd_ProductType());
         }

    @Then("User verifies {string} option is present in dropdown")
    public void user_verifies_option_is_present_in_dropdown(String fieldValue) {
        captureScreenshot(driver, testContext, false);
        waitUntilDropDownListPopulated(driver, new Select(onCreateApplicationPage.getDd_ProductType()));
        boolean flagValue = new Select(onCreateApplicationPage.getDd_ProductType()).getOptions().stream().anyMatch(actualValue -> actualValue.getText().equals(fieldValue));
        Assert.assertTrue(fieldValue+" was not present in dropdown", flagValue);
        captureScreenshot(driver, testContext, false);
    }

    @Then("User verifies {string} is present on left side with each product")
    public void user_verifies_is_present_on_left_side_with_each_product(String fieldValue) {
        waitForPageToLoad(driver);
        captureScreenshot(driver, testContext, false);
       List<WebElement> allTexts = onCreateApplicationPage.getListAnnuityTxt();
      for(WebElement dataTexts : allTexts){
         Assert.assertTrue(fieldValue+" was not present",dataTexts.getAttribute("aria-label").length()>0);
      }
    }

    @Then("User verify all displayed products are for {string} and not for {string}")
    public void verifyCarrier(String carrier, String invalidCarrier) {
        captureScreenshot(driver, testContext, false);
        boolean flag = true;
        for(WebElement dataTexts : onCreateApplicationPage.getListCarriers()){
            if(!(dataTexts.getAttribute("aria-label").equalsIgnoreCase(carrier)) & dataTexts.getAttribute("aria-label").equalsIgnoreCase(invalidCarrier)) {
                flag = false;
                break;
            }
        }
        Assert.assertTrue(carrier + " was not present or " + invalidCarrier + " was present",flag);
    }

    @Then("User verifies {string} is present in Default Product Type")
    public void user_verifies_is_present_in_Default_Product_Type(String expValue) {
        captureScreenshot(driver, testContext, false);
        boolean flagValue = new Select(onCreateApplicationPage.getDd_DefaultProduct()).getOptions().stream().anyMatch(actulValue -> actulValue.getText().equals(expValue));
        Assert.assertTrue(expValue+" was not present in Default product type.", flagValue);
    }

    @Then("User selects {string} from default Product type")
    public void user_selects_from_default_Product_type(String inputValue) {
        captureScreenshot(driver, testContext, false);
        new Select(onCreateApplicationPage.getDd_DefaultProductType()).selectByVisibleText(inputValue);
    }

    @Then("User verifies {string} is selected in Jurisdiction")
    public void user_verifies_is_selected_in_Jurisdiction(String inputValue) {
        captureScreenshot(driver, testContext, false);
        String actValue = new Select(onCreateApplicationPage.getDd_Jurisdiction()).getFirstSelectedOption().getText();
        Assert.assertEquals(inputValue+" are mismatched", inputValue, actValue);
    }

    @Then("User verifies the list of products is displayed")
    public void user_verifies_the_list_of_products_is_displayed() {
        captureScreenshot(driver, testContext, false);
        Assert.assertTrue("Products are not displayed", onCreateApplicationPage.getListProductsTxt().size()>0);
    }
    @Then("User selects option from Dropdown {string} from Advanced Search dialog box")
    public void userSelectsProductTypeFromDropdownFromAdvancedSearchDialogBox(String signType) {
        waitForPageToLoad(driver);
        captureScreenshot(driver, testContext, false);
        if(findElements(driver, String.format(onCreateApplicationPage.txt_AllInputField, testContext.getMapTestData().get("signaturetypeId"))).size()>0) {
            new Select(onCreateApplicationPage.getDdown_signatureType()).selectByVisibleText(signType);
        }
        else {
            new Select(onCreateApplicationPage.getDd_SignatureType()).selectByVisibleText(signType);
        }
    }

    @Then("User verifies {string} product not avaliable")
    public void user_verifies_product_not_avaliable(String proName) {
       waitForPageToLoad(driver);
        captureScreenshot(driver, testContext, false);
         List<WebElement> allProducts = onCreateApplicationPage.getList_Products();
         boolean flagValue = false;
         for (WebElement product : allProducts){
             if (product.getText().contains(proName)){
                 flagValue = true;
                 break;
             }
         }
         Assert.assertFalse("Activity was present", flagValue);
    }
    @Then("User verifies {string} product is avaliable")
    public void user_verifies_product_is_avaliable(String proName) {
        waitForPageToLoad(driver);
        captureScreenshot(driver, testContext, false);
        List<WebElement> allProducts = onCreateApplicationPage.getList_Products();
        boolean flagValue = false;
        for (WebElement product : allProducts){
            if (product.getText().contains(proName)){
                flagValue = true;
                break;
            }
        }
        Assert.assertTrue("Activity was not present", flagValue);
    }

    @Then("User waits for page to load")
    public void user_waits_for_page_to_load() {
        captureScreenshot(driver, testContext, false);
        waitForPageToLoad(driver);
    }

    @Then("User verifies all options are in Alphabetical Orders except {string} and {string}")
    public void user_verifies_all_options_are_in_Alphabetical_Orders_except_and(String option1, String option2) {
        waitForPageToLoad(driver);
        captureScreenshot(driver, testContext, false);
        String[] options = {"1031 Exchanges","Accident And Health","Annuity","Corporate Forms","Fixed Annuity","Fixed Indexed Annuity","Life","Term Life","Variable Annuity"};
        ArrayList<String> expectedOption = new ArrayList<>(Arrays.asList(options));
        Collections.sort(expectedOption);
        ArrayList<String> actualOption = new ArrayList<>();
        for (WebElement optionText : new Select(onCreateApplicationPage.getDd_ProductType()).getOptions()) {
            if (!optionText.getText().trim().contains(option1) && !optionText.getText().trim().contains(option2)) {
                actualOption.add(optionText.getText().trim());
            }
        }
        Assert.assertTrue("Actual Options were not sorted", actualOption.equals(expectedOption));
    }

    @Then("User verifies all options are in Alphabetical Orders and {string} is at {int}th index and {string} is at {int}st index in list")
    public void user_verifies_all_options_are_in_Alphabetical_Orders_and_is_at_th_index_and_is_at_st_index_in_list(String option1, Integer index1, String option2, Integer index2) {
        waitForPageToLoad(driver);
        captureScreenshot(driver, testContext, false);
        String[] options = {"1031 Exchanges","Accident And Health","Annuity","Corporate Forms","Fixed Annuity","Fixed Indexed Annuity","Life","Multi-Year Guaranteed Annuity","Mutual Fund","Non-Insurance Product","Paper Upload","Pre-sale Suitability Review","Term Life","Variable Annuity"};
        ArrayList<String> expectedOption = new ArrayList<>(Arrays.asList(options));
        Collections.sort(expectedOption);
        ArrayList<String> actualOption = new ArrayList<>();
        for (WebElement option : new Select(onCreateApplicationPage.getDd_DefaultProduct()).getOptions()) {
                    actualOption.add(option.getText().trim());
                }
        if (actualOption.get(index1).equalsIgnoreCase(option1) && actualOption.get(index2).equalsIgnoreCase(option2)) {
            actualOption.remove(0);
            actualOption.remove(0);
            Assert.assertTrue("Actual Options were not sorted", actualOption.equals(expectedOption));
        }
        else {
            Assert.fail("Option 1 was not at the 1st position or Option 2 was not at the 2nd position");
        }
    }

    @Then("User verifies {string} is selected in Default Jurisdiction")
    public void user_verifies_is_selected_in_Default_Jurisdiction(String inputValue) {
        captureScreenshot(driver, testContext, false);
        String actValue = new Select(onCreateApplicationPage.getDd_DefaultJurisdiction()).getFirstSelectedOption().getText();
        Assert.assertTrue(inputValue + " are mismatched", actValue.contains(inputValue));
    }

    @Then("User verifies {string} is present in Product Type")
    public void user_verifies_is_present_in_Product_Type(String expValue) {
        captureScreenshot(driver, testContext, false);
        boolean flagValue = new Select(onCreateApplicationPage.getDd_ProductType()).getOptions().stream().anyMatch(actulValue -> actulValue.getText().equals(expValue));
        Assert.assertTrue(expValue+" was not present in Default product type.", flagValue);
    }

    @Then("User {string} the ReadOnly checkbox on properties dialog box")
    public void user_the_ReadOnly_checkbox_on_properties_dialog_box(String action) {
        waitForPageToLoad(driver);
        syncElement(driver, onCreateApplicationPage.getCheckboxReadOnly(),EnumsCommon.TOCLICKABLE.getText());
        captureScreenshot(driver, testContext, false);
        switch (action) {
            case "check":
                Assert.assertFalse("Checkbox was checked", onCreateApplicationPage.getCheckboxReadOnly().isSelected());
                clickElement(driver, onCreateApplicationPage.getCheckboxReadOnly());
                break;
            case "uncheck":
                clickElement(driver, onCreateApplicationPage.getCheckboxReadOnly());
                break;
            default:
                throw new FLException("Invalid value provided for action: " + action);
        }
    }

    @Then("User clicks on {string} Revoke User Share Request dialog box")
    public void UserClicksOnRevokeUserShareRequestDialogBox(String value) {
        waitForPageToLoad(driver);
        if (value.equalsIgnoreCase("ok"))
            onCreateApplicationPage.getBtn_PopOk().click();
        else
            onCreateApplicationPage.getBtn_PopCancel().click();
    }

    @Then("User opens Given Product {string} for application")
    public void UserOpensGivenProductForApp(String product) {
        captureScreenshot(driver, testContext, false);
        syncElement(driver, findElement(driver, String.format(onCreateApplicationPage.list_OfProducts, product)), EnumsCommon.TOCLICKABLE.getText());
       try {
           clickElement(driver, findElement(driver, String.format(onCreateApplicationPage.list_OfProducts, product)));
       } catch (StaleElementReferenceException e){
           clickElement(driver, findElement(driver, String.format(onCreateApplicationPage.list_OfProducts, product)));
       }
           addPropertyValueInJSON(testContext.getTestCaseID(), testContext, EnumsJSONProp.PRODUCT.getText(), product);
    }

    @Then("User Verifies {string} field is present")
    public void userVerifiesFieldIsPresent(String field) {
        captureScreenshot(driver, testContext, false);
        syncElement(driver, findElement(driver, String.format(onCreateApplicationPage.txt_AllInputField, field)), EnumsCommon.TOVISIBLE.getText());
        Assert.assertTrue("Field was not displayed", findElements(driver, String.format(onCreateApplicationPage.txt_AllInputField, field)).size() > 0);
    }
}
