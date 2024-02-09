package com.hexure.firelight.pages;

import com.hexure.firelight.libraies.Enums.EnumsJSONProp;
import com.hexure.firelight.libraies.FLException;
import com.hexure.firelight.libraies.FLUtilities;
import com.hexure.firelight.libraies.TestContext;
import lombok.Data;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


@Data
public class RCTCompleteFillingAndSigningPage extends FLUtilities {

    private String tabById = "//*[@id='%s']";
    @FindBy(xpath = "//section[@id='main']//div[@class='roundCornersTop heading']/span")
    private WebElement pageHeading;

    @FindBy(xpath = "//input[@value='Annuitant']/ancestor::div[contains(@id,'signer')]//input[contains(@class,'ToName')]")
    private WebElement annuitantName;

    @FindBy(xpath = "//input[@value='Annuitant']/ancestor::div[contains(@id,'signer')]//input[contains(@class,'ToEmail')]")
    private WebElement annuitantEmail;

    @FindBy(xpath = "//input[@value='Annuitant']/ancestor::div[contains(@id,'signer')]//input[contains(@id,'SSN')]")
    private WebElement annuitantSsn;

    @FindBy(xpath = "//input[@value='Annuitant']/ancestor::div[contains(@id,'signer')]//input[contains(@id,'BirthDate')]")
    private WebElement annuitantBirthdate;

    @FindBy(xpath = "//input[@value='Payor']/ancestor::div[contains(@id,'signer')]//input[contains(@class,'ToName')]")
    private WebElement payorName;


    @FindBy(xpath = "//input[@value='Insured']/ancestor::div[contains(@id,'signer')]//input[contains(@class,'ToName')]")
    private WebElement insuredName;

    @FindBy(xpath = "//input[@value='Insured']/ancestor::div[contains(@id,'signer')]//input[contains(@class,'ToEmail')]")
    private WebElement insuredEmail;

    @FindBy(xpath = "//input[@value='Insured']/ancestor::div[contains(@id,'signer')]//input[contains(@id,'SSN')]")
    private WebElement insuredSsn;

    @FindBy(xpath = "//input[@value='Insured']/ancestor::div[contains(@id,'signer')]//input[contains(@id,'BirthDate')]")
    private WebElement insuredBirthdate;

    @FindBy(xpath = "//input[@value='Payor']//following-sibling::a")
    private WebElement btn_RemovePayor;

    @FindBy(xpath = "//input[@value='Owner']//following-sibling::a")
    private WebElement btn_RemoveOwner;

    @FindBy(xpath = "//input[@value='Joint Owner']//following-sibling::a")
    private WebElement btn_RemoveJointOwner;

    @FindBy(xpath = "//input[@value='Joint Annuitant']//following-sibling::a")
    private WebElement btn_RemoveJointAnnuitant;

    @FindBy(xpath = "//input[@value='Owner 2']//following-sibling::a")
    private WebElement btn_RemoveOwner2;

    @FindBy(xpath = "//input[@value='Annuitant']//following-sibling::a")
    private WebElement btn_RemoveAnnuitant;

    @FindBy(xpath = "//input[@value='Insured']//following-sibling::a")
    private WebElement btn_RemoveInsured;

    @FindBy(xpath = "//input[@value='Payor']/ancestor::div[contains(@id,'signer')]//input[contains(@class,'ToEmail')]")
    private WebElement payorEmail;

    @FindBy(xpath = "//input[@value='Payor']/ancestor::div[contains(@id,'signer')]//input[contains(@id,'SSN')]")
    private WebElement payorSsn;

    @FindBy(xpath = "//input[@value='Payor']/ancestor::div[contains(@id,'signer')]//input[contains(@id,'BirthDate')]")
    private WebElement payorBirthdate;

    @FindBy(xpath = "//input[@value='Owner']/ancestor::div[contains(@id,'signer')]//input[contains(@class,'ToName')]")
    private WebElement ownerName;

    @FindBy(xpath = "//input[@value='Owner']/ancestor::div[contains(@id,'signer')]//input[contains(@class,'ToEmail')]")
    private WebElement ownerEmail;

    @FindBy(xpath = "//input[@value='Owner']/ancestor::div[contains(@id,'signer')]//input[contains(@id,'SSN')]")
    private WebElement ownerSsn;

    @FindBy(xpath = "//input[@value='Owner']/ancestor::div[contains(@id,'signer')]//input[contains(@id,'BirthDate')]")
    private WebElement ownerBirthdate;

    @FindBy(id = "buttonSend")
    private WebElement btn_SendEmail;

    @FindBy(xpath = "//button[@id='buttonSend']")
    private WebElement btn_SendEmailOnSigningApp;

    @FindBy(id="popup_title")
    private WebElement header_RequestSentPopup;

    @FindBy(xpath = "//div[@class='toastTitle']")
    private WebElement header_RequestSentPopupReact;

    @FindBy(id="popup_message")
    private WebElement msg_RequestSentPopup;

    @FindBy(id="popup_ok")
    private WebElement btn_OkDialogBox;

    @FindBy(xpath = "//strong[contains(.,'https')]")
    private WebElement link_ExternalURL;

    @FindBy(xpath = "//input[@value='Joint Owner']/ancestor::div[contains(@id,'signer')]//input[contains(@class,'ToName')]")
    private WebElement name_jointOwner;

    @FindBy(xpath = "//input[@value='Joint Owner']/ancestor::div[contains(@id,'signer')]//input[contains(@class,'ToEmail')]")
    private WebElement email_jointOwner;

    @FindBy(xpath = "//input[@value='Joint Owner']/ancestor::div[contains(@id,'signer')]//input[contains(@id,'SSN')]")
    private WebElement jointOwnerSsn;

    @FindBy(xpath = "//input[@value='Joint Owner']/ancestor::div[contains(@id,'signer')]//input[contains(@id,'BirthDate')]")
    private WebElement birthday_jointOwner;

    private By txt_OwnerMVC = By.xpath("//div[contains(@id,'signer')]");
    private By txt_OwnerReact = By.xpath("//div[contains(@id,'clientFillEmailVerify')]/span");
    private By txt_OwnerMVC1 = By.xpath("(//div[@id='clientVerify']/span)[4]");

    @FindBy(xpath = "//input[@aria-label='Insured']/parent::div//following-sibling::div//span[contains(text(),'Name is required')]")
    private WebElement errorMsg_InsuredNM;

    @FindBy(xpath = "//input[@aria-label='Insured']/parent::div//following-sibling::div//span[contains(text(),'Email is required.')]")
    private WebElement errorMsg_InsuredEmail;

    @FindBy(xpath = "//input[@aria-label='Insured']/parent::div//following-sibling::div//span[contains(text(),'The last 4 digits of SSN is required.')]")
    private WebElement errorMsg_InsuredSsn;

    @FindBy(xpath = "//input[@aria-label='Insured']/parent::div//following-sibling::div//span[contains(text(),'A valid birth date is required.')]")
    private WebElement errorMsg_InsuredDOB;

    @FindBy(xpath = "//input[@value='Owner']/ancestor::div[contains(@id,'signer')]//input[@type='checkbox']")
    private WebElement checkBox_owner;

    @FindBy(xpath = "//input[@value='Insured']/ancestor::div[contains(@id,'signer')]//input[@type='checkbox']")
    private WebElement checkBox_insured;

    @FindBy(xpath = "//input[@value='Joint Owner']/ancestor::div[contains(@id,'signer')]//input[@type='checkbox']")
    private WebElement checkBox_JointOwner;

    public String header_RequestPopupReact = "//div[@class='toastTitle']";

    public void entersDetailsForBothAnnuitantOwner(TestContext testContext,WebDriver driver){
        getAnnuitantName().sendKeys(testContext.getMapTestData().get("annuitantName"));
        getAnnuitantEmail().sendKeys(testContext.getMapTestData().get("annuitantEmail"));
        getAnnuitantSsn().sendKeys(testContext.getMapTestData().get("annuitantSsn"));
        clickElement(driver,getAnnuitantBirthdate());
        getAnnuitantBirthdate().sendKeys(testContext.getMapTestData().get("annuitantBirthdate"));
        getOwnerName().sendKeys(testContext.getMapTestData().get("ownerName"));
        getOwnerEmail().sendKeys(testContext.getMapTestData().get("ownerEmail"));
        getOwnerSsn().sendKeys(testContext.getMapTestData().get("ownerSsn"));
        getOwnerBirthdate().click();
        getOwnerBirthdate().sendKeys(testContext.getMapTestData().get("ownerBirthdate"));

    }

    public void enterUserDetails(TestContext testContext,WebDriver driver, String user){
        String ownerName = testContext.getMapTestData().get("ownerName");
        String jointOwnerName = testContext.getMapTestData().get("JointName");
        String appName = testContext.getMapTestData().get("newProductName");
        String insuredName = testContext.getMapTestData().get("insuredName");

        switch (user.toLowerCase()) {
            case "owner":
                if(ownerName.contains("Random")) {
                    ownerName = ownerName + appName.substring(appName.lastIndexOf(" "));
                    addPropertyValueInJSON(testContext.getTestCaseID(), testContext, EnumsJSONProp.OWNERNAME.getText(), ownerName);
                }
                getOwnerName().sendKeys(ownerName);
                getOwnerEmail().sendKeys(testContext.getMapTestData().get("ownerEmail"));
                getOwnerSsn().sendKeys(testContext.getMapTestData().get("ownerSsn"));
                getOwnerBirthdate().click();
                getOwnerBirthdate().sendKeys(testContext.getMapTestData().get("ownerBirthdate"));
                break;
            case "annuitant":
                getAnnuitantName().sendKeys(testContext.getMapTestData().get("annuitantName"));
                getAnnuitantEmail().sendKeys(testContext.getMapTestData().get("annuitantEmail"));
                getAnnuitantSsn().sendKeys(testContext.getMapTestData().get("annuitantSsn"));
                clickElement(driver,getAnnuitantBirthdate());
                getAnnuitantBirthdate().sendKeys(testContext.getMapTestData().get("annuitantBirthdate"));
                break;
            case "annuitantclientauthentication":
                getAnnuitantName().sendKeys(testContext.getMapTestData().get("annuitantName"));
                getAnnuitantEmail().sendKeys(testContext.getMapTestData().get("annuitantEmail"));
                break;
            case "payor":
                getPayorName().sendKeys(testContext.getMapTestData().get("payorName"));
                getPayorEmail().sendKeys(testContext.getMapTestData().get("payorEmail"));
                getPayorSsn().sendKeys(testContext.getMapTestData().get("payorSsn"));
                clickElement(driver,getPayorBirthdate());
                getPayorBirthdate().sendKeys(testContext.getMapTestData().get("payorBirthdate"));
                break;
            case "insured":
                if(insuredName.contains("Random")) {
                    insuredName = insuredName + appName.substring(appName.lastIndexOf(" "));
                    addPropertyValueInJSON(testContext.getTestCaseID(), testContext, EnumsJSONProp.INSUREDNAME.getText(), insuredName);
                }
                getInsuredName().sendKeys(insuredName);
                getInsuredEmail().sendKeys(testContext.getMapTestData().get("insuredEmail"));
                getInsuredSsn().sendKeys(testContext.getMapTestData().get("insuredSsn"));
                clickElement(driver,getInsuredBirthdate());
                getInsuredBirthdate().sendKeys(testContext.getMapTestData().get("insuredBirthdate"));
                break;
            case "jointowner":
                if(jointOwnerName.contains("Random")) {
                    jointOwnerName = jointOwnerName + appName.substring(appName.lastIndexOf(" "));
                    addPropertyValueInJSON(testContext.getTestCaseID(), testContext, EnumsJSONProp.JOINTOWNERNAME.getText(), jointOwnerName);
                }
                getName_jointOwner().sendKeys(jointOwnerName);
                getEmail_jointOwner().sendKeys(testContext.getMapTestData().get("JointEmail"));
                getJointOwnerSsn().sendKeys(testContext.getMapTestData().get("JointSsn"));
                clickElement(driver,getBirthday_jointOwner());
                getBirthday_jointOwner().sendKeys(testContext.getMapTestData().get("JointBirthdate"));
                break;
            default:
                throw new FLException("Invalid value provided for user : : " + user);
        }
    }

    public void enterUserDetailsOnlyNameEmail(TestContext testContext,WebDriver driver, String user) {
        switch (user.toLowerCase()) {
            case "owner":
                getOwnerName().sendKeys(testContext.getMapTestData().get("ownerName"));
                getOwnerEmail().sendKeys(testContext.getMapTestData().get("ownerEmail"));
                break;
            case "annuitant":
                getAnnuitantName().sendKeys(testContext.getMapTestData().get("annuitantName"));
                getAnnuitantEmail().sendKeys(testContext.getMapTestData().get("annuitantEmail"));
                break;

            case "payor":
                getPayorName().sendKeys(testContext.getMapTestData().get("payorName"));
                getPayorEmail().sendKeys(testContext.getMapTestData().get("payorEmail"));
                break;

            case "jointowner":
                getName_jointOwner().sendKeys(testContext.getMapTestData().get("JointName"));
                getEmail_jointOwner().sendKeys(testContext.getMapTestData().get("JointEmail"));
                break;

            default:
                throw new FLException("Invalid value provided for user : : " + user);
        }
    }


    public void removeUserDetails(TestContext testContext,WebDriver driver, String user){
        switch (user.toLowerCase()) {
            case "owner":
                clickElement(driver, getBtn_RemoveOwner());
                waitForPageToLoad(driver);
                break;
            case "payor":
                clickElement(driver, getBtn_RemovePayor());
                waitForPageToLoad(driver);
                break;
            case "insured":
                clickElement(driver, getBtn_RemoveInsured());
                waitForPageToLoad(driver);
                break;
            case "annuitant":
                clickElement(driver, getBtn_RemoveAnnuitant());
                waitForPageToLoad(driver);
                break;
            case "joint owner":
                clickElement(driver, getBtn_RemoveJointOwner());
                waitForPageToLoad(driver);
                break;
            case "joint annuitant":
                clickElement(driver, getBtn_RemoveJointAnnuitant());
                waitForPageToLoad(driver);
                break;
            case "owner 2":
                clickElement(driver, getBtn_RemoveOwner2());
                waitForPageToLoad(driver);
                break;
            default:
                throw new FLException("Invalid value provided for user : " + user);
        }
    }

    public void selectCheckbox(TestContext testContext,WebDriver driver, String user){
        switch(user.toLowerCase()){
            case "owner":
                clickElementByJSE(driver,getCheckBox_owner());
                waitForPageToLoad(driver);
                break;
            case "insuresd":
                clickElementByJSE(driver,getCheckBox_insured());
                waitForPageToLoad(driver);
                break;
            case "jointowner":
                clickElementByJSE(driver,getCheckBox_JointOwner());
                waitForPageToLoad(driver);
                break;
            default:
                throw new FLException("Invalid value provided for user : "+user);
        }
    }


    public RCTCompleteFillingAndSigningPage(WebDriver driver)
    {
        initElements(driver);
    }

    private void initElements(WebDriver driver)
    {
        PageFactory.initElements(driver, this);
    }
}
