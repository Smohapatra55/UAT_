package com.hexure.firelight.pages;

import com.hexure.firelight.libraies.FLUtilities;
import lombok.Data;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;


@Data
public class SignApplicationPage extends FLUtilities {

    @FindBy(id = "root__wizardName")
    private WebElement pagenameExternalLogin;

    @FindBy(xpath = "//div[@title='Annuity Wizard']/parent::div//span[contains(@class,'errors')]")
    private List<WebElement> noOfWizardsWithExclamatoryINAnnuityWizard;

    @FindBy(xpath = "//div[@title='Application222 With Groups for signers']/parent::div//span[contains(@class,'errors')]")
    private List<WebElement> noOfFormsWithExclamatoryInApplication222;

    @FindBy(xpath = "//div[@title='Fees and Expense Disclosure Sample with Groups for Signers']/parent::div//span[contains(@class,'errors')]")
    private List<WebElement> noOfFormsWithExclamatoryInFeeAndExpense;

    @FindBy(id = "imgExpand")
    private WebElement menuWiz;

    @FindBy(xpath = "//li[@title='Client Data']")
    private WebElement clientDataWizardPage;

    @FindBy(xpath = "//div[@title='Individual']")
    private WebElement radioBtn_Individual;

    @FindBy(xpath = "//div[@title='Joint']")
    private WebElement radioBtn_Joint;

    @FindBy(xpath = "//div[.='Annuitant']/ancestor::div[@data-dataitemid='Annuitant_SameAsOwner_Panel']//div[@title='No']")
    private WebElement radioBtn_IsTheAnnuitantTheSameAsTheOwnerNo;

    @FindBy(xpath = "//div[.='Annuitant']/ancestor::div[@data-dataitemid='Annuitant_SameAsOwner_Panel']//div[@title='Yes']")
    private WebElement radioBtn_IsTheAnnuitantTheSameAsTheOwnerYes;

    @FindBy(xpath = "//div[@title='Non-Qualified Account']")
    private WebElement radioBtn_NonQualifiedAccount;

    @FindBy(xpath = "//div[.='Replacement Questions']/parent::div//div[@class='ITCheckBoxInput']/div[@title='Yes']")
    private List<WebElement> radioBtnsYesReplacementQuestions;

    @FindBy(xpath = "//div[@id='navigationButtonsContainer']//span[.='Next']")
    private WebElement btn_Next;

    @FindBy(id = "ToggleMessagesLink")
    private List<WebElement> redBtn_Errormsg;

    @FindBy(xpath = "//a[@id='imgOpenWiz']/div")
    private WebElement pagename;

    @FindBy(id = "FirstName")
    private WebElement txtBox_FirstnameOwner;

    @FindBy(id = "LastName")
    private WebElement txtBox_LastnameOwner;

    @FindBy(id = "DateofBirth")
    private WebElement txtBox_DateofBirthOwner;

    @FindBy(id = "ZipCode")
    private WebElement txtBox_ZipCodeOwner;

    @FindBy(xpath = "//button[.='Alerts']")
    private WebElement btn_Alerts;

    @FindBy(xpath = "//a[@class='listViewItem-validation-error']")
    private List<WebElement> errorListPages;

    @FindBy(id = "HowmanyPrimaryBeneficiariesdoyouhave?")
    private WebElement selectListBeneficiaries;

    @FindBy(id = "RelationshiptoOwner")
    private WebElement selectListRelationshipToOwner;

    @FindBy(id = "PercentageofProceeds")
    private WebElement percentOfProceedBeneficiaries;

    @FindBy(id = "FirstName")
    private WebElement firstNameBeneficiaries;

    @FindBy(id = "LastName")
    private WebElement lastNameBeneficiaries;

    @FindBy(id = "FirstName")
    private WebElement firstNameAgent;

    @FindBy(id = "LastName")
    private WebElement lastNameAgent;

    @FindBy(id = "PaymentMethod")
    private WebElement selectListPaymentMethod;

    @FindBy(xpath = "//div[.='Fees and Expense Disclosure Sample with Groups for Signers']/parent::div//li[@title='Page 1']")
    private WebElement page1FeesExpenses;

    @FindBy(xpath = "//input[@data-dataitemid='Client_DOB']")
    private WebElement txtBox_DobFeesExpense;

    @FindBy(xpath = "//button[.='Sign Application']")
    private WebElement signApplication_btn;

    @FindBy(xpath = "//span[contains(@class,'navAlertIcon')]")
    private WebElement alertGreenTick;

    @FindBy(id = "buttonAttachDocs")
    private WebElement attachDocuments_tab;

    @FindBy(id = "DocumentType")
    private WebElement selectlistDocumentType;

    @FindBy(id = "File")
    private WebElement fileUpload;

    @FindBy(xpath = "//span[.='Upload']")
    private WebElement btn_Upload;

    @FindBy(xpath = "//a[@class=' ITNavLink linkFocus']")
    private List<WebElement> list_LinkViewRemove;

    private By btn_CloseMVC = By.xpath("(//button[@title='Close'])[4]");
    private By btn_CloseReact = By.xpath("//span[.='Close']");

    @FindBy(xpath = "//button[.='Print']")
    private WebElement btn_Print;

    @FindBy(xpath = "//span[.='Print Selected Documents']")
    private WebElement btn_PrintSelectedDocuments;

    @FindBy(xpath = "//span[.='Lock Activity']")
    private WebElement btn_LockActivity;

    private By Link_ReviewDocumentsMVC = By.id("lnkViewDoc");
    private By Link_ReviewDocumentsReact = By.xpath("//button[@class='ITButtonInput  ']");

    @FindBy(id = "lnkStartSign")
    private WebElement link_SignActivity;

    private By esignDocumentHeadingMVC = By.xpath("//header[contains(text(),'Select Documents to Print')]");
    private By esignDocumentHeadingReact = By.xpath("//div[@class='roundCornersTop heading']");

    @FindBy(xpath = "//div[@class='panelContent']/div")
    private List<WebElement> documentSetName;

    private By btn_ContinueMVC = By.id("buttonContinue");
    private By btn_ContinueReact = By.xpath("//button[@id='imgNext']");

    @FindBy(xpath = "//table[@id='tableNav']//button")
    private WebElement textElement_AnnuiantSignDocumentset;

    @FindBy(id = "chkAgree")
    private WebElement agreeCheckbox;

    @FindBy(xpath = "//div[@id='divSign']/div")
    private WebElement signPageHeader;

    @FindBy(id = "txtFullName")
    private WebElement signerFullName;

    @FindBy(id = "txtCity")
    private WebElement signerCity;

    @FindBy(id = "container")
    private WebElement signerpad;

    @FindBy(id = "btnConsent")
    private WebElement btn_IConsent;

    @FindBy(id = "buttonConsent")
    private WebElement btn_IConsentAgent;

    @FindBy(id = "popup_ok")
    private WebElement btn_popupOk;

    @FindBy(xpath = "//button[@aria-label]")
    private WebElement btn_okInCongradulationPage;

    @FindBy(xpath = "//section[@id='main']//h2")
    private WebElement message_Congratulation;

    @FindBy(xpath = "//a[@aria-label='Next Page']")
    private WebElement btn_nextPage;

    @FindBy(xpath = "//input[@class='initialCheckbox focusblink']")
    private WebElement txtBox_initial;

    @FindBy(id = "init")
    private WebElement txtBox_enterInitial;

    @FindBy(id = "lblPage")
    private WebElement pageNo;

    @FindBy(id = "popup_ok")
    private WebElement btn_initialPopupOk;

    @FindBy(id = "txtAgentID")
    private WebElement txtBox_agentId;

    @FindBy(xpath = "//span[contains(text(),'React LN Signer with Document Set')]")
    private WebElement btn_ReactLNSigner;

    @FindBy(id = "btnConsent")
    private List<WebElement> listbtn_IConsent;

    @FindBy(xpath = "//div[@id='navigationButtonsContainer']//span[.='Next']")
    private List<WebElement> listBtn_NextWizard;

    @FindBy(xpath = "//div[@class='ITCheckBoxCheck']")
    private WebElement chkBox_Agree;

    public SignApplicationPage(WebDriver driver) {
        initElements(driver);
    }

    private void initElements(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "ITNavBar__Right")
    private WebElement application_btn;

}

