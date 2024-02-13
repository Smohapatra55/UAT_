package com.hexure.firelight.pages;

import com.hexure.firelight.libraies.*;
import lombok.Data;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

@Data
public class SignaturesPage extends FLUtilities {

    private static final Logger Log = LogManager.getLogger(SignaturesPage.class);
    private By chk_Owner = By.xpath("//div[text()='Owner']//..//div[@class='ITCheckBoxCheck']");
    private By id_Owner = By.id("Owner");
    private By id_Owner2 = By.id("OwnerChild2");
    private By id_Payer = By.id("Payor");
    private By chk_jointOwner = By.xpath("//div[text()='Joint Owner']//..//div[@class='ITCheckBoxCheck']");
    private By id_jointOwner = By.id("JointOwner");
    private By chk_Agent = By.xpath("//div[text()='Agent']//..//div[@class='ITCheckBoxCheck']");
    private By id_Agent = By.id("Agent");
    private By chk_Insured = By.xpath("//div[text()='Insured']//..//div[@class='ITCheckBoxCheck']");
    private By id_Insured = By.id("Insured");
    private By chk_JointAnnuitant = By.xpath("//div[text()='Joint Annuitant']//..//div[@class='ITCheckBoxCheck']");
    private By id_JointAnnuitant = By.id("JointAnnuitant");
    private By chk_Payor = By.xpath("//div[text()='Payor']//..//div[@class='ITCheckBoxCheck']");
    private By id_Payor = By.id("Payor");
    private By btn_BackToSigners = By.xpath("//span[text()='Back To Signers']");
    private By btn_BackToSigners1 = By.id("buttonBack");
    private By btn_SignNow = By.xpath("//span[text()='Sign Now']");
    private By btn_SignNow1 = By.id("signNow");
    private By btn_SendEmailRequest = By.xpath("//*[@aria-label='Send Email Request']");
    private By btn_SendEmailRequest1 = By.xpath("//span[text()='Send Email Request']");
    private By btn_SendEmailRequest2 = By.id("sendEmail");
    private By btn_SendGenerateEmail = By.id("submitDistribution");
    private By btn_SendSMSText = By.xpath("//span[text()='Send SMS Text']");
    private By btn_CancelReact = By.xpath("//div[@role='dialog']//span[text()='Cancel']");
    private By btn_CancelReact1 = By.xpath("//span[text()='Cancel']");
    private By btn_CancelMVC = By.id("buttonCancel");
    private By btn_CancelMVC1 = By.id("btnCancel");
    private By txtBox_IDNumber = By.id("txtID");
    private By txtBox_IDNumber1 = By.id("IDNumber");
    private By txtBox_Name = By.id("txtName");
    private By txtBox_Name1 = By.id("Name");
    private By txtBox_Name2 = By.id("ToName");
    private By txtBox_Name3 = By.id("SignerName");
    private By txtBox_SSN = By.id("txtSSN");
    private By txtBox_SSN1 = By.id("Last4DigitsofSSN/GovernmentID");
    private By txtBox_BirthDate = By.id("txtBirthDate");
    private By txtBox_BirthDate1 = By.id("BirthDate");
    private By txtBox_EmailAddress = By.id("txtEmail");
    private By txtBox_EmailAddress1 = By.id("EmailAddress");
    private By txtBox_EmailAddress2 = By.id("ToEmail");
    private By txtBox_EmailAddress3 = By.id("SignerEmail");
    private By btnAgree = By.id("chkAgree");
    private By btnClearSignatureReact = By.xpath("//span[text()='Clear Signature']");
    private By btnClearSignatureMvc = By.id("btnClearSignature");
    private By btnIDeclineReact = By.xpath("//span[text()='I Decline']");
    private By btnIDeclineMVC = By.id("btnDecline");
    private By btnEdit = By.xpath("//span[text()='Edit']");
    private By btnAgree1 = By.xpath("//div[@role='checkbox']");
    private By btnAgree2 = By.xpath("//label[contains(text(),'I have reviewed')]//parent::div//preceding-sibling::div//div[@class='ITCheckBox   ']");
    private By btnAgree3 = By.xpath("//div[@class='row documentReview_actions']//label[contains(@for,'Ihave')]//parent::div//preceding-sibling::div//span");
    private By btnConsent = By.xpath("//span[text()='I Consent']");
    private By btnConsent1 = By.xpath("//button[@id='buttonConsent' or @id='btnConsent']");
    private By btnOK = By.xpath("//button[@aria-label='OK']");
    private By btnOK1 = By.xpath("//span[text()='OK']");
    private By btnGenerateLink = By.id("buttonGenerateLink");
    private By btnGenerateLink1 = By.xpath("//span[text()='Generate Link Without Email']");
    private By btnSubmitClient = By.xpath("//span[text()='Submit']");
    private By btnSubmitClient1 = By.id( "buttonVerifySubmit");
    private By btnConfirmAll = By.xpath("//label[contains(text(),'Confirm all')]//parent::div//preceding-sibling::div//div[@class='ITCheckBox   ']");
    private By btnConfirmAll1 = By.id("chkAgreeAll");
    private By btnConfirmAll2 = By.xpath("//div[@class='row documentReview_actions']//label[contains(@for,'Confirmall')]//parent::div//preceding-sibling::div");
    private By btnUseSignature = By.xpath("//span[contains(text(),'Use E-Signature')]");
    private By btnUseSignature1 = By.id("lnkUse");
    private By btnCancel = By.id("popup_cancel");
    private By btnCancel1 = By.id("buttonVerifyCancel");
    private By txtCity = By.id("txtCity");
    private By txtCity1 = By.id("City");
    private By txtBox_FullName = By.id("txtFullName");
    private By txtBox_FullName1 = By.id("SignerFullName");
    private By txtBox_FullName2 = By.id("AgentFullName");
    private By txtBox_AgentID = By.id("txtAgentID");
    private By txtBox_AgentID1 = By.id("AgentID");
    private By btnSignature = By.xpath("//canvas[@class='signaturePadCanvas' or @id='sigPad']");
    private By btnSignature1 = By.id("sigPad");
    private By txtReviewAgree = By.xpath("//span[@class='divReviewDocConfirm']");
    private By txtReviewAgree1 = By.xpath("//div[@class='row documentReview_actions']//label[contains(@for,'Ihave')]");
    private By txtEmailLinkMVC = By.xpath("//div[contains(text(),'Recipient(s)')]");
    private By txtEmailLinkReact = By.xpath("//span[@id='lblSent']//strong");
    private By txtEmailLinkTeleSign = By.xpath("//div[@id='generatedLink']//strong");
    private By txtPasscode = By.className("passcodeText");
    private By txtPasscode1 = By.xpath("//span[@id='lblSent']//strong)[2]");
    private By btnClose = By.xpath("//a[@title='Close']");
    private By btnClose1 = By.xpath("//a[text()='[Close]']");
    private By btnSubmit = By.xpath("//span[text()='Verified']");
    private By btnSubmit1 = By.xpath("//*[@id='buttonSubmit']");
    private By btnSubmitTeleSign = By.id("telesign-continue-button");
    private By signNameSignerPage = By.id("ToName");
    private By signNameSignerPage1 = By.id("SignerName");
    private By signEmailSignerPage = By.id("ToEmail");
    private By signEmailSignerPage1 = By.id("SignerEmail");
    private By ssnCodeSignerPage = By.id("SSN");
    private By ssnCodeSignerPage1 = By.id("*SignerLast4DigitsofSSN/GovernmentID");
    private By birthDateSignerPage = By.id("BirthDate");
    private By birthDateSignerPagee1 = By.id("*SignerBirthDate");
    private By btn_SendPasscode = By.id("buttonSendEPass");
    private By btn_SendPasscode1 = By.xpath("//span[text()='Send Email Passcode']");
    private By txtbox_Passcode1 = By.id("EnterPasscode");
    private By txtbox_Passcode2 = By.id("txtPasscodeVerify");
    private By txt_PageDescription = By.xpath("//div[@class='document_display_label']//label");
    private By txt_NewPageDescription = By.id("lblPage");
    private By btn_InitialDocumentSet1 = By.xpath("//input[contains(@class,'initialCheckbox')]");
    private By btn_InitialDocumentSet2 = By.className("eSign__initials_Signature");
    private By btn_InitialDocumentSet3 = By.xpath("//button[contains(@class,'ITButtonInput')]");
    private By txtBox_Initials1 = By.id("init");
    private By txtBox_Initials2 = By.xpath("//input[contains(@class,'ITTextFieldInput')]");
    private By popup_Ok1 = By.id("popup_ok");
    private By popup_Ok2 = By.xpath("//button//span[text()='OK']");
    private By popup_Ok3 = By.xpath("//span[text()='Apply Initials']");
    private By chk_Producer = By.xpath("//div[text()='Producer']//..//div[@class='ITCheckBoxCheck']");
    private By id_Producer = By.id("AgentProducer");
    private By chk_Agent2 = By.xpath("//div[text()='Agent 2']//..//div[@class='ITCheckBoxCheck']");
    private By id_Agent2 = By.id("AdditionalAgent");
    private By chk_Agent3 = By.xpath("//div[text()='Agent 3']//..//div[@class='ITCheckBoxCheck']");
    private By id_Agent3 = By.id("AgentThird");
    private By alert_Signature = By.id("popup_message");
    private By alert_Signature1 = By.xpath("//div[@class='ITDialog__content ']");
    private By alert_Signature2 = By.xpath("//div[@class='telesignInstructions']");
    private By txt_ErrorMessage = By.xpath("//*[@class='panel roundCorners shadow']//*[@class='roundCornersTop heading']//following-sibling::span");
    private By tab_backToapplicationReact = By.xpath("//a[.='Back to Application']");
    private By tab_backToapplicationMVC = By.xpath("//label[.='Back to Application']");
    private By txtBox_agentFulNameMVC = By.id("txtFullName");
    private By txtBox_agentFulNameReact = By.id("AgentFullName");
    private By agentOnSiteHeadingMVC = By.xpath("//div[@class='roundCornersTop heading']");
    private By agentOnSiteHeadingReact = By.xpath("//div[@class='ITPanelTitleText']");
    private By txtBox_agentCityMVC = By.id("txtCity");
    private By txtBox_agentCityReact = By.id("City");
    private By btn_UnlockActivity_React = By.xpath("//span[contains(text(),'Unlock Activity')]");
    private By btn_UnlockActivity_Mvc = By.xpath("//span[contains(text(),'Unlock Application')]");

    @FindBy(xpath = "//*[@class='spanAppName']")
    private WebElement txtFieldformcheck;

    private By btn_UnlockApplication = By.xpath("//a[@aria-label='Unlock Application']");
    @FindBy(xpath = "//div[contains(@id,'client')]")
    private WebElement txt_ClientAuthentication;

    @FindBy(xpath = "//span[text()='SIGNATURES']/preceding-sibling::div")
    private WebElement canvas_Signatures;

    @FindBy(xpath = "//input[@class='activeSignature']")
    private WebElement txtBox_ActiveSignature;

    @FindBy(xpath = "//div[@class='activeSignature']//label")
    private WebElement txtBox_ActiveSignatureReact;

    private By btn_DeclineESignatureMVC = By.id("lnkDecline");
    private By btn_DeclineESignatureReact = By.xpath("//span[contains(text(),'Decline E-Signature')]");

    @FindBy(xpath = "//div[@id='esignDeclined-1']/h3")
    private WebElement msg_ESignatureDeclineMsg1;

    @FindBy(xpath = "//div[@id='esignDeclined-2']/h3")
    private WebElement msg_ESignatureDeclineMsg2;

    @FindBy(xpath = "//div[@id='esignDeclined-3']/h3")
    private WebElement msg_ESignatureDeclineMsg3;

    @FindBy(xpath = "//div[contains(text(),'Electronic Signatures')]")
    private WebElement txt_ElectronicSignatures;

    private By popup_OkMVC = By.id("popup_ok");
    private By popup_OkReact = By.xpath("//button//span[text()='OK']");

    @FindBy(xpath = "(//span[contains(@class,'minus-circle')])[2]")
    private WebElement image_SignatureMinusCircle;

    @FindBy(xpath = "//button//span[text()='Yes']")
    private WebElement popup_Yes;

    @FindBy(xpath = "//button//span[text()='No']")
    private WebElement popup_No;

    @FindBy(xpath = "//div[@id='esignDeclined-3']/following-sibling::button")
    private WebElement btn_Ok_OnElectronicSignaturesDeclined;

    @FindBy(xpath = "//div[@id='esignDeclined-3']/following-sibling::button/img[@alt='OK']")
    private WebElement btn_Ok_img_OnElectronicSignaturesDeclined;

    @FindBy(xpath = "//div[@id='divStatusBarCenter']/following-sibling::div//div[contains(text(),'Electronic Signatures Declined')]")
    private WebElement txt_ElectronicSignaturesDeclined;

    @FindBy(xpath = "//div[@id='esignDeclined-1']/h3")
    private WebElement txt_ESignatureDeclineMessage1;

    @FindBy(xpath = "//div[@id='esignDeclined-2']/h3")
    private WebElement txt_ESignatureDeclineMessage2;

    @FindBy(xpath = "//div[@id='esignDeclined-3']/h3")
    private WebElement txt_ESignatureDeclineMessage3;

    @FindBy(id = "Payor")
    private WebElement link_Payer;

    private By link_AnnuitantMVC = By.id("Annuitant");
    private By link_AnnuitantReact = By.xpath("//div[text()='Annuitant']/parent::div//div[@class='ITCheckBoxCheck']");

    @FindBy(id = "Insured")
    private WebElement link_Insured;

    @FindBy(id = "btnProceed")
    private WebElement btn_Proceed;

    @FindBy(id = "downloadForms")
    private WebElement btn_DownloadForms;

    @FindBy(xpath = "//strong[text()='Done']")
    private WebElement btn_Done;

    private By statusNotice_popupmsgMVC = By.xpath("//div[@id='divStatusNotice']/strong");
    private By statusNotice_popupmsgReact = By.xpath("//header[@id='dialogheader']/following-sibling::div");

    private By btn_Continue = By.id("imgNext");

    private By btn_Continue1 = By.xpath("//span[text()='Continue']");

    @FindBy(id = "buttonContinue")
    private WebElement btn_ContinueDocumentSet;

    @FindBy(xpath = "//input[contains(@class,'initialCheckbox')]")
    private WebElement btn_InitialDocumentSet;

    @FindBy(id = "init")
    private WebElement txtBox_Initials;

    @FindBy(id = "ToName")
    private WebElement txtBox_MailerName;

    @FindBy(id = "SSN")
    private WebElement txtBox_MailerSSN;

    @FindBy(id = "BirthDate")
    private WebElement txtBox_MailerBirthDate;

    @FindBy(id = "ToEmail")
    private WebElement txtBox_MailerEmailAddress;

    @FindBy(id = "txtSubject")
    private WebElement txt_Subject;

    @FindBy(id = "SignerName")
    private WebElement txtBox_NewMailerName;

    @FindBy(id = "*SignerLast4DigitsofSSN/GovernmentID")
    private WebElement txtBox_NewMailerSSN;

    @FindBy(id = "*SignerBirthDate")
    private WebElement txtBox_NewMailerBirthDate;

    @FindBy(id = "SignerEmail")
    private WebElement txtBox_NewMailerEmailAddress;

    @FindBy(xpath = "//button[contains(@aria-label,'SoftLimitSignatureForm')]//parent::td//following-sibling::td//img[@alt='Acknowledged']")
    private WebElement img_Acknowledge;

    @FindBy(xpath = "//button[contains(@class,'documentReview')]")
    private WebElement btn_EasySignature;

    @FindBy(id = "chkAgree")
    private WebElement chk_Agree;

    @FindBy(xpath = "//span[@id='lblSent']//strong")
    private WebElement txt_EmailLink;

    @FindBy(xpath = "//span[@id='lblSent']//strong")
    private List<WebElement> txt_EmailLinks;

    @FindBy(xpath = "//strong[contains(.,'Signature Agent')]/parent::span//span")
    private WebElement agentPasscode;

    @FindBy(xpath = "(//span[@id='lblSent']//strong)[2]")
    private WebElement txt_Passcode;

    @FindBy(id = "lblPendingRequest")
    private WebElement txt_PendingRequest;

    @FindBy(xpath = "//strong[contains(.,'Signature Agent')]/parent::span//span")
    private WebElement passcode_Agent;

    @FindBy(xpath = "//span/strong[contains(.,'Request Type')]")
    private List<WebElement> requestTypeText;

    @FindBy(id = "lnkClose")
    private WebElement btn_CloseDialog;

    @FindBy(xpath = "//div[@class='ITDialog__box ']//span[text()='Close']")
    private WebElement btn_CloseAddendum;

    @FindBy(xpath = "//div[text()='Annuitant/Insured Signature']")
    private WebElement txt_AnnuitantInsuredSignature;

    @FindBy(xpath = "//a[contains(text(),'Send Reminder to')]")
    private WebElement link_SendReminder;

    @FindBy(xpath = "//a[contains(text(),'Send Passcode to')]")
    private WebElement link_SendPasscode;

    @FindBy(xpath = "//a[contains(text(),'Cancel this request')]")
    private WebElement link_CancelRequest;

    @FindBy(xpath = "//div[@id='divStatusNotice']//strong")
    private WebElement txt_ProgressMessage;

    @FindBy(xpath = "//strong[contains(text(),'Request Type')]//..//span")
    private WebElement txt_RequestTypePasscode;

    @FindBy(xpath = "//button[contains(span,'Sign Now')]")
    private WebElement btn_ReactSignNow;

    private By agreeWithtermsMVC = By.id("chkAgree");
    private By agreeWithtermsReact = By.xpath("(//div[@class='ITCheckBoxCheck'])[1]");

    @FindBy(xpath = "//a[text()='View Activity PDF']")
    private WebElement btn_ViewActivityPDF;

    @FindBy(className = "nextPage")
    private WebElement btn_NextPage;

    @FindBy(id="FontFamily")
    private WebElement dd_FontType;

    @FindBy(xpath = "//div[@id='MainBody']")
    private WebElement txt_CompleteMessage;

    @FindBy(className = "eSign_complete")
    private WebElement txt_EsignCompleteTitle;

    @FindBy(className = "eSign_complete")
    private List<WebElement> list_EsignCompleteTitle;

    @FindBy(id = "Agent")
    private WebElement agentSignPage;

    @FindBy(id = "signNow")
    private WebElement signNow;

    @FindBy(id = "sigPad")
    private WebElement agentSignPad;

    @FindBy(id = "buttonConsent")
    private WebElement btn_IConsent;

    @FindBy(xpath = "//div[contains(@class,'heading')]")
    private WebElement txt_heading;

    @FindBy(xpath = "(//h2[contains(text(),'Document Set')]//..//div)[1]")
    private WebElement txt_DocumentSetDocument;

    @FindBy(xpath = "(//h2[contains(text(),'Document Set')]//..//div)[2]")
    private WebElement txt_DocumentSetAddendum;

    @FindBy(xpath = "(//h2[contains(text(),'Document Set')]//..//div)[3]")
    private WebElement txt_DocumentSet2Document;

    @FindBy(xpath = "(//h2[contains(text(),'Document Set')]//..//div)[4]")
    private WebElement txt_DocumentSet2Addendum;

    @FindBy(xpath = "(//h2[contains(text(),'Initials')]//..//div)[1]")
    private WebElement txt_InitialsDocument;

    @FindBy(xpath = "//a[.='Revoke Request']")
    private List<WebElement> list_RevokeStatement;

    @FindBy(xpath = "//strong[.='Back To App']")
    private WebElement btn_backToapp;

    @FindBy(xpath = "//*[@class='heading' and text()='Owner/Payor - Client Identification Verification']")
    private WebElement OwnerPayorClientIdentificationVerificationHeading;

    @FindBy(xpath = " //*[@class='signTitle roundCornersTop heading largeText' and text()='Owner Initial']")
    private WebElement pageHeadingOwnerInitial;

    @FindBy(xpath = "//*[@id='divIntialMsg']//*[text()='Initials are required in this document set.']")
    private WebElement initialsAreRequiredInThisDocumentSet;

    @FindBy(xpath = "//*[@class='initialCheckbox focusblink']")
    private WebElement initialCheckbox;

    @FindBy(xpath = "//*[contains(text(),'I have reviewed and agree with the terms expressed within this document.')]/..//input[@aria-label='Check Agree'][1]")
    private WebElement reviewAndAgreeCheckbox;

    @FindBy(xpath = "//span[contains(text(),'Confirm all documents without reviewing individually.')]/../input[@aria-label='Check Agree'][2]")
    private WebElement ConfirmAllDocumentsCheckBox;

    private By pageHeading1 = By.xpath("//*[@class='panel roundCorners shadow']/..//*[@class='signTitle roundCornersTop heading largeText']");
    private By pageHeading2 = By.xpath("//*[@class='panel roundCorners shadow']//*[contains(@class,'roundCornersTop heading')]");
    private By pageHeading3 = By.xpath("//div[@class='ITPanelTitleText' or @class='ITWizardName']");
    private By checkBoxTrusteeMVC = By.id("Trustee");
    private By checkBoxTrusteeReact = By.xpath("//div[contains(text(),'Trustee')]/parent::div//div[@class='ITCheckBox   ']");
    private By txt_SignerFullNameMVC = By.id("SignerFullName");
    private By txt_SignerFullNameReact = By.id("txtFullName");
    private By txt_CityMVC = By.id("txtCity");
    private By txt_CityReact = By.id("City");

    @FindBy(id = "init")
    private WebElement initInputField;

    @FindBy(className = "signers_completedSignerType")
    private WebElement signerType;

    @FindBy(className = "signers_completedSignerName")
    private WebElement signerName;

    @FindBy(className = "signers_completedSignerState")
    private WebElement signerState;

    @FindBy(className = "signers_completedSignerDate")
    private WebElement signerDate;

    @FindBy(xpath = "//table[@id='tableNav']//button[@class='blackButton clsFormButton roundCorners shadow']")
    private List<WebElement> list_OwnerSignature;

    @FindBy(id = "sigPad")
    private WebElement field_Signature;

    @FindBy(id = "btnConsent")
    private WebElement btn_IConsentOnSignature;

    @FindBy(id = "txtFullName")
    private WebElement btn_SignerFullName;

    @FindBy(id = "txtCity")
    private WebElement btn_City;

    @FindBy (xpath = "//button[contains(span,'Send Email Request')]")
    private WebElement btn_ReactSendEmailRequest;

    @FindBy(xpath = "//label[contains(text(),'Confirm all documents without reviewing individually.')]")
    private WebElement chkBox_ReactConfirmAll;

    @FindBy(xpath = "//label[contains(text(),'I have reviewed and agree with the terms expressed within this document.')]")
    private WebElement chkBox_ReactConfirmReview;

    @FindBy(id = "AgentFullName")
    private WebElement txtBox_AgentfullName_React;

    @FindBy(id = "AgentID")
    private WebElement txtBox_AgentID_React;

    @FindBy(id = "City")
    private WebElement txtBox_AgentCity_React;

    @FindBy(xpath = "//button//span[text()='OK']")
    private WebElement btn_ConfirmDocOK_React;

    @FindBy(xpath = "//a[contains(text(),'Unlock Application')]")
    private WebElement btn_UnlockApplication_React;

    @FindBy(id="Agent")
    private WebElement btn_agent;

    @FindBy(id = "tableNav")
    private List<WebElement> list_ReviewDocuments;

    @FindBy(id = "chkAgreeAll")
    private WebElement checkBox_AllDocuments;

    @FindBy(xpath = "//div[@id='popup_panel']//button[@id='popup_ok']")
    private WebElement btn_ConformDocuments;

    @FindBy(id = "txtCity")
    private WebElement btn_CityName;

    @FindBy(id = "sigPad")
    private WebElement txt_Signature;

    @FindBy(xpath = "//button[@id='lnkUse']")
    private WebElement btn_useESignature;

    @FindBy(xpath = "//a[@id='Owner']")
    private WebElement btn_owner;

    @FindBy(xpath = "//div[contains(text(),'Client Identification Verification')]")
    private WebElement txt_clientIdentificationVerification;

    @FindBy(xpath = "//span[text()='SSN does not match value entered in application.']")
    private WebElement errorMsg_SSN;

    @FindBy(xpath = "//span[text()='Birth date does not match value entered in application.']")
    private WebElement errorMsg_DOB;

    @FindBy(xpath = "//div[@id='lblBeforeSign']")
    private WebElement msg_documentReviewPages;

    @FindBy(xpath = "//input[@class='initialCheckbox focusblink']")
    private WebElement checBox_EDocument;

    @FindBy(xpath = "//input[@id='init']")
    private WebElement txtBox_initial;

    @FindBy(xpath = "//input[@id='txtFullName']")
    private WebElement txtBox_signeFullName;

    @FindBy (xpath = "//span[@class='signers_completedSignerName']/label")
    private WebElement name_CompletedSignature;

    @FindBy(xpath = "//span[@class='signers_completedSignerState']/label")
    private WebElement state_CompletedSignature;

    @FindBy(id="cmdResendPasscode")
    private WebElement btn_ResendPasscode;

    @FindBy(id="buttonSendEPass")
    private WebElement btn_SendEmailPasscode;

    @FindBy(id="buttonSendEPass")
    private WebElement btn_ReSendEmailPasscode;

    private By txtBox_PasscodeMVC = By.id("txtPasscodeVerify");
    private By txtBox_PasscodeReact = By.id("EnterPasscode");

    @FindBy(id = "buttonVerifySubmit")
    private WebElement btn_Submit;

    @FindBy(xpath = "//header[@id='dialogheader']/parent::div//div[@class='ITTextField']/textarea")
    private WebElement txtField_DeclineEsignature;

    private By txt_ESignatureDeclineMessagesMVC = By.xpath("//div[@class='panelContent']//span");
    private By txt_ESignatureDeclineMessagesReact = By.xpath("//div[@class='ITPanelContents']//div[contains(@class,'col-md')]");

    @FindBy(xpath = "//div[@class='ITPanelTitleText']")
    private WebElement heading_SignaturePage_React;

    @FindBy(xpath = "//p[@class='verification_AuthenticationHeader']")
    private WebElement heading_SignaturePage_React1;

    public static String txtFieldWithId = "//*[@id=\"%s\" or @name=\"%s\" or @data-dataitemid=\"%s\"]";
    public static String tableWithClass = "(//table[@class='%s'])[1]//th";
    public static String txtFieldWithClass = "//*[@class=\"%s\"]";

    public static String btnText = "//span[text()='%s']";

    private String btn_Previous = "//div[@id='navigationButtonsContainer']//span[text()='%s']";
    public static String selectFieldWithId = "//select[@id=\"%s\" or @name=\"%s\" or @data-dataitemid=\"%s\"]";
    public static String txtFieldWithLabelText = "//label[contains(text(),'%s')]/parent::div/following-sibling::select";

    public String msg_ErrorReact = "//input[@id='%s']/parent::div/following-sibling::div/div[@class='field_validator__text']";
    public String msg_ErrorMVC = "//input[@name='%s']//following-sibling::span";
    public String msg_ErrorSelectMVC = "//select[@aria-label='%s']//following-sibling::span";

    @FindBy(xpath = "//div[contains(text(),'https')]")
    private WebElement link_Signer;

    @FindBy(xpath = "//div[@class='ITDialog__content ']")
    private WebElement confirmWindowMessage;

    @FindBy(xpath = "//footer[@class='ITDialog__footer']//span[contains(text(),'Decline E-Signature')]")
    private WebElement btn_PopUpDeclineESignature;

    public String toolBarWithText = "//*[text()='%s']";

    @FindBy(xpath = "//div[contains(text(),'Electronic Signatures')]")
    private WebElement electronicSignaturePage;

    @FindBy(id = "InitialMessage")
    private WebElement msg_ToastPopup;

    @FindBy(xpath = "//span[contains(text(),'Resend SMS')]")
    private WebElement btn_ResendSMSWithTime;

    @FindBy(xpath = "//span[text() = 'Resend SMS']")
    private WebElement btn_ResendSMS;

    @FindBy(xpath = "//span[contains(text(),'Resend SMS')]//parent::span//parent::button")
    private WebElement btn_ResendSMSButton;

    @FindBy(xpath = "//*[@id='IDIssueJurisdiction']")
    private WebElement dd_IDIssueJurisdiction;

    private String name_Document = "//span[@class='ITButtonText__Selectable ']";
    private String statusWithRole = "//div[text()='%s']/following-sibling::div[text()='%s']";
    private String buttonWithRole = "//div[text()='%s']/following-sibling::div//span[text()='%s']";

    @FindBy(xpath = "//div[@class='document_display_label']")
    private WebElement nameForm;

    @FindBy(xpath = "(//button[@class='ITButtonInput  ']//span[text()='Decline E-Signature'])[2]")
    private WebElement btn_DeclineESignatureConfirmDialogue;

    @FindBy(xpath = "//a[@class='prevPage']")
    private WebElement btn_PreviousPage;

    @FindBy(id = "teleSign")
    private WebElement btn_TeleSign;

    @FindBy(id = "teleSign")
    private List<WebElement> list_BtnTeleSign;

    private String signer = "//*[@id='%s']";

    @FindBy(xpath = "//span[text()='Unlock']/ancestor::button")
    private List<WebElement> listBtn_Unlock;

    private By btn_Unlock = By.id("btnUnlock");


    @FindBy(xpath = "//div[text()='Owner']//..//div[@class='ITCheckBox disabled  ']")
    private WebElement chkBox_Owner;

    @FindBy(xpath = "//div[text()='Insured']//..//div[@class='ITCheckBox disabled  ']")
    private WebElement chkBox_Insured;

    @FindBy(xpath = "//div[text()='Agent 2']//..//div[@class='ITCheckBoxCheck']")
    private WebElement chkBox_Agent2;

    @FindBy(xpath = "//button[contains(span,'Re-Sign')]")
    private WebElement reSignBtn_Insured;

    @FindBy(xpath = "//button[contains(@class,' ITButtonDisabled  signers__request__button')]")
    private WebElement reSignBtn_Agent;

    @FindBy(xpath = "//span[contains(text(),'Edit')]")
    private WebElement btn_Edit;

    @FindBy(id = "AgentFullName")
    private WebElement txt_agentFullName;

    @FindBy(id = "City")
    private WebElement txt_agentCityName;

    @FindBy(id = "buttonVerifyCancel")
    private WebElement btn_CancelSMS;

    @FindBy(xpath = "//span[contains(text(),'I Consent')]")
    private WebElement btn_IConsentOnCaptElectSign;

    @FindBy(xpath = "//div[text()='Agent 2']//..//div[@class='ITCheckBox disabled  ']")
    private WebElement chkBox_AgentTwo;

    @FindBy(xpath = "//button[contains(span,'Re-Sign')]")
    private WebElement reSignBtn_Owner;

    @FindBy(xpath = "//div[@class='enrollmentParticipantGrid']//div[@class='ITCheckBoxCheck']")
    private WebElement checkbox_designPage;

    @FindBy(xpath = "//div[@id='signerListDiv']")
    private WebElement signatureWindow;

    public static String txtField = "//div[@title='%s']//ancestor::div[@class='dataGrid__row']//input";
    public String txtImg_selectedReviewDoc = "//button[contains(text(),'%s')]//parent::td//preceding-sibling::td//img";

    public SignaturesPage(WebDriver driver) {
        initElements(driver);
    }

    private void initElements(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void userClicksButtonSignaturePage(WebDriver driver, TestContext testContext, String whichButton) {
        captureScreenshot(driver, testContext, false);
        switch (whichButton) {
            case "Continue":
                sleepInMilliSeconds(5000);
                clickElement(driver, getElement(driver, getExistingLocator(driver, btn_Continue, btn_Continue1, getBtnSubmitTeleSign(), null)));
                break;
            case "Proceed":
                clickElement(driver, getBtn_Proceed());
                break;
            case "Close":
                clickElementByJSE(driver, getBtn_CloseDialog());
                break;
            case "Close Addendum":
                clickElement(driver, getBtn_CloseAddendum());
                break;
            case "View Activity PDF":
                clickElement(driver, getBtn_ViewActivityPDF());
                break;
            case "Next Page":
                clickElementByJSE(driver, getBtn_NextPage());
                sleepInMilliSeconds(5000);
                break;
            case "Initials":
                clickElement(driver, getBtn_InitialDocumentSet());
                break;
            case "Sign Now":
                clickElement(driver, getElement(driver, getExistingLocator(driver, getBtn_SignNow(), getBtn_SignNow1(), null, null)));
                break;
            case "Send Email":
            case "Send Email Request":
                clickElement(driver, getElement(driver, getExistingLocator(driver, getBtn_SendEmailRequest(), getBtn_SendEmailRequest1(), getBtn_SendGenerateEmail(), null)));
                break;
            case "Agree":
                clickElement(driver, getElement(driver, getExistingLocator(driver, getBtnAgree(), getBtnAgree1(), getBtnAgree2(), getBtnAgree3())));
                break;
            case "I Consent":
                clickElement(driver, getElement(driver, getExistingLocator(driver, getBtnConsent(), getBtnConsent1(), null, null)));
                break;
            case "Verified":
                clickElement(driver, getElement(driver, getExistingLocator(driver, getBtnSubmit(), getBtnSubmit1(), null, null)));
                break;
            case "Back To Signers":
                clickElement(driver, getElement(driver, getExistingLocator(driver, getBtn_BackToSigners(), getBtn_BackToSigners1(), null, null)));
                break;
            case "OK":
                clickElement(driver, getElement(driver, getExistingLocator(driver, getBtnOK(), getBtnOK1(), null, null)));
                break;
            case "Generate Link":
            case "Generate Link Without Email":
                clickElement(driver, getElement(driver, getExistingLocator(driver, getBtnGenerateLink(), getBtnGenerateLink1(), getBtn_SendGenerateEmail(), null)));
                break;
            case "Confirm All Documents":
                clickElement(driver, getElement(driver, getExistingLocator(driver, getBtnConfirmAll(), getBtnConfirmAll1(), getBtnConfirmAll2(), null)));
                break;
            case "Use E-Signature":
                syncElement(driver, getElement(driver, getExistingLocator(driver, btnUseSignature, btnUseSignature1,null,null)), EnumsCommon.TOCLICKABLE.getText());
                clickElement(driver,getElement(driver, getExistingLocator(driver, btnUseSignature, btnUseSignature1,null,null)));
                break;
            case "Owner":
                clickElement(driver,getBtn_owner());
                break;
            case "Send Email Passcode" :
            case "Send email passcode" :
                clickElement(driver,getElement(driver, getExistingLocator(driver, btn_SendPasscode, btn_SendPasscode1,null,null)));
                break;
            case "Resend Email Passcode":
                clickElement(driver,getBtn_ReSendEmailPasscode());
                break;
            case "Submit":
                clickElement(driver,getElement(driver, getExistingLocator(driver, btnSubmitClient, btnSubmitClient1,null,null)));
                break;
            case "Clear Signature":
                clickElement(driver, getElement(driver, getExistingLocator(driver, btnClearSignatureMvc, btnClearSignatureReact, null, null)));
                break;
            case "I Decline":
                clickElement(driver, getElement(driver, getExistingLocator(driver, btnIDeclineReact, btnIDeclineMVC, null, null)));
                break;
            case "Edit":
                clickElement(driver, getElement(driver, getExistingLocator(driver, btnEdit, null, null, null)));
                break;
            case "Send SMS Text":
                clickElement(driver, getElement(driver, getExistingLocator(driver, getBtn_SendSMSText(), null, null, null)));
                break;
            case "Cancel":
                clickElement(driver, getElement(driver, getExistingLocator(driver, getBtn_CancelMVC(), getBtn_CancelReact1(), getBtn_CancelReact(), getBtn_CancelMVC1())));
                break;
            case "CancelSMS":
                clickElement(driver, getBtn_CancelSMS());
                break;
            case "TeleSign":
                clickElement(driver, getBtn_TeleSign());
                break;
            case "Download Forms":
                clickElement(driver, getBtn_DownloadForms());
                break;
            case "Done":
                clickElement(driver, getBtn_Done());
                break;
            default:
                throw new FLException("Invalid value provided for Button : " + whichButton);
        }
    }

    public int userVerifiesButtonSignaturePage(WebDriver driver, TestContext testContext, String whichButton) {
        captureScreenshot(driver, testContext, false);
        int elementSize = 0;
        switch (whichButton) {
            case "Sign Now":
                elementSize = driver.findElements(getExistingLocator(driver, getBtn_SignNow(), getBtn_SignNow1(), null, null)).size();
                break;
            case "Send Email Request":
                elementSize = driver.findElements(getExistingLocator(driver, getBtn_SendEmailRequest(), getBtn_SendEmailRequest1(), null, null)).size();
                break;
            case "TeleSign":
                elementSize = getList_BtnTeleSign().size();
                break;
            default:
                throw new FLException("Invalid value provided for Button : " + whichButton);
        }
        return elementSize;
    }

    public boolean userVerifyButton(String whichButton, TestContext testContext) {
        switch (whichButton) {
            case "Resend SMS":
                return getBtn_ResendSMS().isDisplayed();
            default:
                throw new FLException("Invalid value for button: " + whichButton);
        }
    }
}

