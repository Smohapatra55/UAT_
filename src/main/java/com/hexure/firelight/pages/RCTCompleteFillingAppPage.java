package com.hexure.firelight.pages;

import com.hexure.firelight.libraies.Enums.EnumsJSONProp;
import com.hexure.firelight.libraies.EnumsCommon;
import com.hexure.firelight.libraies.FLUtilities;
import com.hexure.firelight.libraies.TestContext;
import lombok.Data;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;


@Data
public class RCTCompleteFillingAppPage extends FLUtilities {
    private By btn_BackToApp1 = By.id("buttonBack");
    private By btn_BackToApp2 = By.xpath("//span[text()='Back To Signers']");

    private By link_GenerateWithoutEmail = By.xpath("//span[@id='lblSent']/span//strong[contains(.,'https')]");
    private By link_GenerateWithoutEmail1 = By.xpath("//div[contains(text(),'https')]");
    private By link_GenerateWithoutEmail2 = By.className("urlText");
    private By link_PasscodeWithoutEmail = By.className("passcodeText");
    private By link_PasscodeWithoutEmail1 = By.xpath("//span[@id='lblSent']//span/strong");
    private By link_PasscodeWithoutEmail2 = By.xpath("//span[@id='lblSent']/span/strong");
    private By btnBack = By.id("buttonBack");
    private By btnBack1 = By.xpath("//span[text()='Back To Signers']");
    public String requiredField_SignerWithPartialId = "//input[@value='%s']/ancestor::div[contains(@id,'signer')]//input[contains(@id,'%s')]";

    @FindBy(id = "SignerType")
    private WebElement dropdown_signerType;

    @FindBy(id = "ToName")
    private WebElement receipantName;

    @FindBy(id = "ToEmail")
    private WebElement receipantEmail;

    @FindBy(xpath = "//input[@aria-label='Recipient Email']")
    private WebElement txtBox_RecipientEmail;

    @FindBy(xpath = "//span[contains(text(),'Email is required')]")
    private WebElement msg_ErrorRecipientEmail;

    @FindBy(xpath = "//div[@class='fieldDiv']//input[@id='ToEmail']")
    private WebElement recipientEmailBox;

    @FindBy(id = "SSN")
    private WebElement receipantSsn;

    @FindBy(id = "BirthDate")
    private WebElement receipantBirthdate;

    @FindBy(xpath = "//section[@id='main']//div[@class='roundCornersTop heading']/span")
    private WebElement pageHeading;

    @FindBy(id = "buttonSend")
    private WebElement btn_sendEmailRequest;

    @FindBy(id="buttonGenerateLink")
    private WebElement link_GenerateLinkWithOutEmail;

    private By linktxt_ReceipantUrlMVC = By.xpath("//span[@id='lblSent']/span//strong[contains(.,'https')]");
    private By linktxt_ReceipantUrlReact = By.xpath("//div[contains(text(),'https')]");

    private By passcodeMVC = By.xpath("//span[@id='lblSent']//span/strong");
    private By passcodeReact = By.xpath("//span[@id='lblSent']/span/strong");

    @FindBy(id = "buttonBack")
    private WebElement btn_BackToApp;

    @FindBy(xpath = "//input[@aria-label='Your Name']")
    private WebElement recipientYourName;

    @FindBy(id = "SignerType-error")
    private WebElement msg_SignerTypeError;

    @FindBy(id = "ToName-error")
    private WebElement msg_RecipientName;

    @FindBy(id = "BirthDate-error")
    private WebElement msg_ClientBirthDate;

    @FindBy(id = "FromEmail-error")
    private WebElement msg_YourEmail;

    @FindBy(id = "FromName")
    private WebElement txt_Yourname;

    @FindBy(xpath = "//input[@name='FromEmail']")
    private WebElement txt_YourEmail;

    @FindBy(xpath = "//select[@id='SignerType']//option")
    private List<WebElement> list_signertype;

    @FindBy(xpath = "//span[@data-valmsg-for='ToEmail']")
    private WebElement errorMsg_RecipientEmail;

    @FindBy(xpath = "//span[@data-valmsg-for='SSN']")
    private WebElement errorMsg_SSNID;

    @FindBy(id = "buttonBack")
    private WebElement btn_Backapp;

    @FindBy(xpath = "//div[@id='lnkClose']//a")
    private WebElement close_PendingRequest;

    @FindBy(xpath = "//div[contains(@id,'divOutStandingRequestActions')]//a[contains(text(),'Send Reminder')]")
    private WebElement link_SendReminder;

    @FindBy(xpath = "//a[contains(@class,'lnkSMSPasscode')]")
    private WebElement link_SendPasscode;

    @FindBy(xpath = "//input[@id='ToEmail']")
    private WebElement txtBox_recipientsEmail;

    @FindBy(xpath = "//button[@aria-label='Cancel']")
    private WebElement btn_Cancel;

    @FindBy(xpath = "//a[contains(text(),'Cancel')]")
    private WebElement link_CancelRequest;

    @FindBy(id="popup_cancel")
    private WebElement btn_CancelDialogBox;

    @FindBy(xpath = "//a[@title='pending request']")
    private WebElement link_PendingRequest_DataEntry;

    @FindBy(xpath = "//div[@id='lnkClose']//a")
    private WebElement btn_ClosePopup;

    @FindBy(id="popup_ok")
    private WebElement btn_OkPopup;

    @FindBy(id = "toolbar_OtherActions")
    private WebElement tab_otherActions;

    @FindBy(xpath = "//a[contains(text(),'Request Client to Fill App')]")
    private WebElement link_ReqClientToFillApp;

    @FindBy(id="SignerType-error")
    private WebElement errorMsg_SignerType;

    @FindBy(xpath = "//span[@class='field-validation-error']")
    private WebElement errorMsg_SSN;

    @FindBy(xpath = "(//span[text()='Next'])[3]")
    private WebElement btn_Next;

    @FindBy(xpath = "//header[contains(text(),'Pending Requests')]")
    private WebElement txt_HeaderPendingReq;

    @FindBy(xpath = "//div[@data-dataitemid='PlanType_NonQualified']//div[@class='ITCheckBoxCheck']")
    private WebElement checkBox_NonQualified;

    @FindBy(xpath = "//input[@data-dataitemid='Owner_FirstName']")
    private WebElement txtBox_OwnerName;

    @FindBy(xpath = "//input[@data-dataitemid='Owner_LastName']")
    private WebElement txtBox_OwnerLName;

    @FindBy(xpath = "//input[@class='ITTextFieldInput leftAlign ' and @data-dataitemid='Owner_ResidentialAddress_Zipcode']")
    private WebElement txtBox_ZipCode;

    @FindBy(xpath = "//input[@data-dataitemid='Owner_DOB']")
    private WebElement txtBox_OwnerDOB;

    @FindBy(xpath = "//input[@data-dataitemid='PrimaryBeneficiary_Percentage']")
    private WebElement txtBox_BenefitPercentage;

    @FindBy(xpath = "//input[@data-dataitemid='Contract_Number']")
    private WebElement txtBox_ContactNumber;

    @FindBy(xpath = "//input[@data-dataitemid='Client_DOB']")
    private WebElement txtBox_DateOfBirth;

    @FindBy(xpath = "//div[@class='ITTextField']//input[@id='FromAddress']")
    private WebElement txtBox_FromAddress;

    @FindBy(id="buttonContactAgent")
    private WebElement btn_ContactAgent;

    @FindBy(xpath = "//span[text()='Send']")
    private WebElement btn_Send;

    @FindBy(id="FromEmail-error")
    private WebElement errroMsg_YourEmail;

    @FindBy(id="BirthDate-error")
    private WebElement errorMsg_ClientBOD;

    @FindBy(id="FromName")
    private WebElement txtBox_yourName;

    @FindBy(id="FromEmail")
    private WebElement txtBox_yourEmail;

    @FindBy(xpath = "//input[@id='BirthDate']")
    private WebElement txtBox_clientBOD;

    @FindBy(xpath = "//select[@aria-label='Signer Type']")
    private WebElement select_SignerType;

    @FindBy(xpath = "//span[@id='lblSent' and contains(text(),'Link generated at')]")
    private WebElement txtMsg_linkGeneratedTimeStamp;

    @FindBy(xpath = "//div[@id='clientFillEmailVerify']//input[@id='BirthDate']")
    private WebElement client_DOB;

    @FindBy(xpath = "//div[@class='fieldDiv']//input[@id='BirthDate']")
    private WebElement txtBox_ClientDOB;

    @FindBy(xpath = "//input[@id='SSN']")
    private WebElement txtBox_SSNID;

    @FindBy(xpath = "//header[contains(text(),'Pending Requests')]")
    private List<WebElement> list_PendingRequest;

    public void entersDetailsForNameEmailSSNDOB(TestContext testContext, WebDriver driver, String name, String email, String ssn, String birthdate) {
        syncElement(driver, getReceipantName(), EnumsCommon.TOCLICKABLE.getText());
        sleepInMilliSeconds(1000);
        getReceipantName().clear();
        name = testContext.getMapTestData().get(name);
        if(name.contains("Random")) {
            String appName = testContext.getMapTestData().get("newProductName");
            name = name.replace("Random", "") + appName.substring(appName.lastIndexOf(" ")).trim();
            addPropertyValueInJSON(testContext.getTestCaseID(), testContext, EnumsJSONProp.REVIEWERNAME.getText(), name);
            addPropertyValueInJSON(testContext.getTestCaseID(), testContext, EnumsJSONProp.OWNERNAME.getText(), name);
        }

        getReceipantName().sendKeys(name);
        getReceipantEmail().click();
        getReceipantEmail().sendKeys(testContext.getMapTestData().get(email));
        getReceipantSsn().click();
        getReceipantSsn().clear();
        getReceipantSsn().sendKeys(testContext.getMapTestData().get(ssn));
        getReceipantBirthdate().click();
        getReceipantBirthdate().sendKeys(testContext.getMapTestData().get(birthdate));
    }

    public void entersDetailsForNameEmail(TestContext testContext, WebDriver driver, String name, String email) {
        syncElement(driver, getReceipantName(), EnumsCommon.TOCLICKABLE.getText());
        sleepInMilliSeconds(1000);
        getReceipantName().clear();
        name = testContext.getMapTestData().get(name);
        if(name.contains("Random")) {
            String appName = testContext.getMapTestData().get("newProductName");
            name = name.replace("Random", "") + appName.substring(appName.lastIndexOf(" ")).trim();
            addPropertyValueInJSON(testContext.getTestCaseID(), testContext, EnumsJSONProp.REVIEWERNAME.getText(), name);
        }
        getReceipantName().sendKeys(name);
        getReceipantEmail().click();
        getReceipantEmail().sendKeys(testContext.getMapTestData().get(email));
    }

    @FindBy(xpath = "//div[text()='Sign Application']")
    private WebElement btn_SignApplication;

    @FindBy(xpath = "//button[contains(text(),'Application')]")
    private WebElement btn_Application;

    @FindBy(xpath = "//input[@class='initialCheckbox focusblink']")
    private WebElement checkBox_Application;

    @FindBy(id="init")
    private WebElement txtBox_Initial;

    @FindBy(xpath = "(//a[contains(text(),'[Close]')])[2]")
    private WebElement link_CloseIcon;

    @FindBy(xpath = "//a[contains(text(),'[Close]')]")
    private WebElement link_Close;

    @FindBy(xpath = "//span[contains(text(),'Validate Account Information at the Bank')]")
    private WebElement link_ValidateAccountAtBank;

    @FindBy(id = "dialogMessage")
    private WebElement myMessage;

    public RCTCompleteFillingAppPage(WebDriver driver) {
        initElements(driver);
    }

    private void initElements(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}
