package com.hexure.firelight.stepdefinitions;

import com.hexure.firelight.libraies.EnumsCommon;
import com.hexure.firelight.libraies.FLUtilities;
import com.hexure.firelight.libraies.TestContext;
import com.hexure.firelight.pages.PartyEntryPage;
import cucumber.api.java.en.Then;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;

public class PartyEntry_StepDefinitions extends FLUtilities
{
    private WebDriver driver;
    private PartyEntryPage onPartyEntryPage;
    private TestContext testContext;
    private static final Logger Log = LogManager.getLogger(PartyEntry_StepDefinitions.class);

    public PartyEntry_StepDefinitions(TestContext context)
    {
        testContext = context;
        driver = context.getDriver();
        onPartyEntryPage = context.getPageObjectManager().getPartyEntryPage();
    }
    @Then("User selects {string} in parties activity dropdown")
    public void userSelectPartiesActivityDropdown(String option){
        syncElement(driver,onPartyEntryPage.getDd_PartiesActivity(),EnumsCommon.TOVISIBLE.getText());
        new Select(onPartyEntryPage.getDd_PartiesActivityDropDown()).selectByVisibleText(option);
    }

    @Then("User clicks on Expand button to open form menu and verify {string} pages for Party demographic Data & {string} pages for Party Medical data")
    public void verifiesPartyDemographicDataMedicalData(String numbersDemographicData,String numbersMedicalData){
        syncElement(driver,onPartyEntryPage.getIcon_ExpandMenu(),EnumsCommon.TOCLICKABLE.getText());
        captureScreenshot(driver, testContext, false);
        clickElementByJSE(driver,onPartyEntryPage.getIcon_ExpandMenu());
        Assert.assertEquals("4 pages not found for Party demographic Data",numbersDemographicData,String.valueOf(onPartyEntryPage.getList_DemographicDataList().size()));
        Assert.assertEquals("4 pages not found for Party medical Data",numbersMedicalData,String.valueOf(onPartyEntryPage.getList_MedicalDataList().size()));
    }

    @Then("User Close the Form Menu by clicking on Collapse button")
    public void clickOnExpandMenu(){
        captureScreenshot(driver, testContext, false);
        clickElement(driver,onPartyEntryPage.getIcon_CollapseMenu());
    }

    @Then("User enter Last Name {string}, First name {string}, Street Address{string}, City {string}, State {string}, Zip Code {string} for Party{int}")
    public void userEnterLastNameFirstNameStreetAddressCityStateZipCodeForParty(String firstname,String lastname,String streetaddress,String city,String state,String zipCode, int partynumber) {
        captureScreenshot(driver, testContext, false);
        onPartyEntryPage.getTxtbox_ZipCode().sendKeys(zipCode + Keys.TAB);
        addPropertyValueInJSON(testContext.getTestCaseID(), testContext, "zipcodeforParty"+partynumber, zipCode);
        syncElement(driver,onPartyEntryPage.getTxtbox_firstName(),EnumsCommon.TOVISIBLE.getText());
        onPartyEntryPage.getTxtbox_firstName().sendKeys(firstname+ Keys.TAB );
        addPropertyValueInJSON(testContext.getTestCaseID(), testContext, "firstnameforParty"+partynumber, firstname);
        onPartyEntryPage.getTxtbox_lastName().sendKeys(lastname+ Keys.TAB);
        addPropertyValueInJSON(testContext.getTestCaseID(), testContext, "lastnameforParty"+partynumber, lastname);
        onPartyEntryPage.getTxtbox_StreetAddress().sendKeys(streetaddress+ Keys.TAB);
        addPropertyValueInJSON(testContext.getTestCaseID(), testContext, "streetaddressforParty"+partynumber, streetaddress);
        onPartyEntryPage.getTxtbox_City().sendKeys(city+ Keys.TAB);
        addPropertyValueInJSON(testContext.getTestCaseID(), testContext, "cityforParty"+partynumber, city);
        waitForPageToLoad(driver);
        new Select(onPartyEntryPage.getTxt_State()).selectByVisibleText(state);
        addPropertyValueInJSON(testContext.getTestCaseID(), testContext, "stateforParty"+partynumber,onPartyEntryPage.getTxtbox_State().getAttribute("value"));
    }

    @Then("User clicks on Next button")
    public void clicksOnNextButton(){
        captureScreenshot(driver, testContext, false);
        clickElementByJSE(driver,onPartyEntryPage.getBtn_Next());
    }

    @Then("User enter Height-Feet {string}, height- Inches {string}, Weight-lbs {string}, Total Insurance in Force {string}")
    public void userEnterHeightFeetHeightInchesWeightLbsTotalInsuranceInForce(String heightfeet, String heightInches, String weightlbs, String force) {
        captureScreenshot(driver, testContext, false);
        onPartyEntryPage.getTxtbox_HeightFeet().sendKeys(heightfeet);
        onPartyEntryPage.getTxtbox_HeightInches().sendKeys(heightInches);
        onPartyEntryPage.getTxtbox_Weightlbs().sendKeys(weightlbs);
        onPartyEntryPage.getTxtbox_TotalInsuranceinForce().sendKeys(force);
    }

    @Then("User enter Primary Care Physician or Health Facility {string}")
    public void userEnterPrimaryCarePhysicianOrHealthFacility(String primaryCarePhysician) {
        syncElement(driver,onPartyEntryPage.getTxtbox_primaryCarePhysicianorHealthFacility(),EnumsCommon.TOVISIBLE.getText());
        captureScreenshot(driver, testContext, false);
        sleepInMilliSeconds(2000);
        clickElementByJSE(driver,onPartyEntryPage.getTxtbox_primaryCarePhysicianorHealthFacility());
        onPartyEntryPage.getTxtbox_primaryCarePhysicianorHealthFacility().sendKeys(primaryCarePhysician);
    }

    @Then("User enter Council Number {string} on same page. Make sure Red Bubble icon removed on page")
    public void userEnterCouncilNumberOnSamePageMakeSureRedBubbleIconRemovedOnPage(String councilnumber) {
      syncElement(driver,onPartyEntryPage.getTxtbox_CouncilNumber(),EnumsCommon.TOCLICKABLE.getText());
      captureScreenshot(driver, testContext, false);
      clickElement(driver,onPartyEntryPage.getTxtbox_CouncilNumber());
      onPartyEntryPage.getTxtbox_CouncilNumber().sendKeys(councilnumber);
      onPartyEntryPage.getTxtbox_CouncilNumber().sendKeys(Keys.TAB);
      addPropertyValueInJSON(testContext.getTestCaseID(), testContext, "councilNumber", councilnumber);
        driver.navigate().refresh();
        ArrayList<WebElement> iconRedBubble=new ArrayList<WebElement>(onPartyEntryPage.getList_iconRedBubble());
        Boolean flag=false;
        if(iconRedBubble.size() > 0)
            flag = true;

        Assert.assertFalse("Required error message Redbubble is displayed",flag);
    }

    @Then("User enter Last Name {string}, First name {string} & Middle Name {string} for Party{int}")
    public void userEnterLastNameFirstNameMiddleName(String firstname,String lastname,String middlename,int partynumber) {
        syncElement(driver,onPartyEntryPage.getTxtbox_firstName(),EnumsCommon.TOVISIBLE.getText());
        captureScreenshot(driver, testContext, false);
        onPartyEntryPage.getTxtbox_firstName().sendKeys(firstname);
        addPropertyValueInJSON(testContext.getTestCaseID(), testContext, "firstnameforParty"+partynumber, firstname);
        onPartyEntryPage.getTxtbox_lastName().sendKeys(lastname);
        addPropertyValueInJSON(testContext.getTestCaseID(), testContext, "lastnameforParty"+partynumber, lastname);
        onPartyEntryPage.getTxtbox_MiddleName().sendKeys(middlename);
        addPropertyValueInJSON(testContext.getTestCaseID(), testContext, "middlenameforParty"+partynumber, middlename);
    }

    @Then("User clicks on Yes Radio button {string}")
    public void userClicksOnYesRadioButtonDoesPartyHaveTheSameAddressAsParty(String string) {
        syncElement(driver,onPartyEntryPage.getRadio_DoesParty4(),EnumsCommon.TOCLICKABLE.getText());
        captureScreenshot(driver, testContext, false);
        clickElement(driver,onPartyEntryPage.getRadio_DoesParty4());
    }

    @Then("User Verifies Data Entry Met Toast popup is show")
    public void userVerifiesDataEntryMetToastPopupIsShow() {
        syncElement(driver,onPartyEntryPage.getTost_popupbox(),EnumsCommon.TOVISIBLE.getText());
        captureScreenshot(driver, testContext, false);
      Assert.assertTrue("Toast popup is not displayed",onPartyEntryPage.getTost_popupbox().isDisplayed());
    }

    @Then("User clicks on Close icon on Toast Popup")
    public void userClicksOnCloseIconOnToastPopup() {
        captureScreenshot(driver, testContext, false);
        clickElementByJSE(driver,getElement(driver, getExistingLocator(driver, onPartyEntryPage.getIcon_closeTostPopupboxMVC(), onPartyEntryPage.getIcon_closeTostPopupboxReact(), null, null)));
    }

    @Then("User verifies Toast Popup show remove")
    public void userVerifiesToastPopupShowRemove() {
        sleepInMilliSeconds(3000);
        captureScreenshot(driver, testContext, false);
        ArrayList<WebElement> toastPopupBox=new ArrayList<WebElement>(onPartyEntryPage.getList_tostPopupBox());
        Boolean flag=false;
        if(toastPopupBox.size() > 0)
            flag = true;

        Assert.assertFalse("Toast popup box is displayed :",flag);
    }

    @Then("User Open Form menu and click on {string} Wizard")
    public void userOpenFormMenuAndClickOnMutipleActivitiesWizard(String multipleActivity) {
        waitForPageToLoad(driver);
        captureScreenshot(driver, testContext, false);
        clickElement(driver,onPartyEntryPage.getIcon_ExpandMenu());
        selectOptionFromList(driver,onPartyEntryPage.getList_FormMenulist(),multipleActivity,EnumsCommon.CLICK.getText());
    }

    @Then("User sets value {string} for field City for To Signature tab")
    public void user_sets_value_for_field_City_for_To_Signature_tab(String cityName) {
        waitForPageToLoad(driver);
        captureScreenshot(driver, testContext, false);
        onPartyEntryPage.getTxtbox_City().sendKeys(cityName);
    }

    @Then("User Clicks on Close icon on Toast Popup")
    public void userClickOnCloseIconOnToastPopup() {
        captureScreenshot(driver, testContext, false);
        clickElementByJSE(driver,onPartyEntryPage.getIcon_closeToastPopupbox());
    }

    @Then("User clicks on Close icon on Toast Popup New")
    public void userClicksOnCloseIconOnToastPopupNew() {
        captureScreenshot(driver, testContext, false);
        clickElementByJSE(driver,onPartyEntryPage.getIcon_closeTostPopupboxNew());
    }

    @Then("User Verifies More Info Displayed")
    public void user_Verifies_More_Info_Displayed() {
        captureScreenshot(driver, testContext, false);
        Assert.assertTrue("More Info was not displayed in Review popup",onPartyEntryPage.getIcon_MoreInfo().isDisplayed());
    }

}
