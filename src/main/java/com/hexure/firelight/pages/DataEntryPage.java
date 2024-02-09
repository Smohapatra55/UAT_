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
public class DataEntryPage extends FLUtilities {

    private By txtbox_AppName = By.xpath("//div[contains(@class,'summaryDialog__Text')]//input");
    private By txtbox_AppName1 = By.id("txtAppName");
    private By btn_Rename = By.xpath("//span[text()='Rename']");
    private By btn_Rename1 = By.id("btnRename");
    private By btn_CloseRename = By.xpath("//*[@class='ITButtonInput  ']//span[text()='Close']");
    private By btn_CloseRename1 = By.xpath("(//div[@aria-describedby='dialogSummaryToolBar']//span[text()='Activity Summary']//following-sibling::button[contains(@class,'ui-dialog-titlebar-close')])[1]");
    private By img_ReadOnly = By.id("imgNextReadonly");
    private By img_ReadOnly1 = By.id("imgNext");
    private By btn_CloseDialog1 = By.xpath("//div[@id='lnkClose']/a");
    private By btn_CloseDialog2 = By.xpath("//button[@class='ITButtonInput  ']//span[text()='Close']");
    private By txt_PendingRequestMVC = By.xpath("//strong[@id='lblPendingRequest']//following::strong[contains(text(),'Request Type:')]//parent::span");
    private By txt_PendingRequestReact = By.xpath("//td[@class='outstandingRequestsDialog__requestDetails linkFocus']");
    private By list_dataEntryMenuMVC = By.xpath("//li[contains(@class,'listViewItem')]");
    private By list_dataEntryMenuReact = By.xpath("//div[@class='navDrawer__bundleName']");
    private By list_dataEntryMenuMVCApplication = By.xpath("//li[@class='listViewItem']");

    @FindBy(id = "lblPercent")
    private WebElement txt_DataEntryPercentage;

    @FindBy(id = "InitialMessage")
    private WebElement popup_Toast;

    @FindBy(id = "popup_message")
    private WebElement popup_message;

    @FindBy(xpath = "//div[@id='divStatusNotice']//strong")
    private WebElement message_ToastPopup;

    private By link_DataEntryPopupContinueMVC = By.xpath("//div[@id='InitialMessage']//a[contains(text(),'CONTINUE')]");
    private By link_DataEntryPopupContinueReact = By.xpath("//*[@data-linktype='continue']");

    @FindBy(xpath="//*[@data-linktype='closeToast']")
    private WebElement link_DataEntryPopupMoreData;

    @FindBy(id = "toolbar_OtherActions")
    private WebElement tab_otherActions;

    @FindBy(xpath = "//a[.='Request Client to Fill & Sign']")
    private WebElement fillSign;

    @FindBy(id = "divOtherActions")
    private WebElement tabMenu_otherActions;

    @FindBy(xpath = "(//div[@data-dataitemid='Annuitant_NonNaturalName']//span)[1]")
    private WebElement gender;

    @FindBy(xpath = "//div[@id='divOtherActions']/a")
    private List<WebElement> menuListTab_otherActions;

    @FindBy(xpath = "//div[@id='divPercent']/following-sibling::div/ul/li/a")
    private List<WebElement> wizardPages;

    @FindBy(xpath = "//div[@data-dataitemid='Agent_LastName']//div[@class='field_validator__text']")
    private WebElement agentLastNameErrormsg;

    @FindBy(xpath = "//input[@data-dataitemid='Agent_LastName']")
    private WebElement txtBox_agentLastName;

    @FindBy(xpath = "//input[@data-dataitemid='Agent_FLIDNumber']")
    private WebElement txtBox_agentFlidNo;

    @FindBy(xpath = "//input[@data-dataitemid='Agent_Commission']")
    private WebElement txtBox_agentComission;

    @FindBy(xpath = "//div[@data-dataitemid='Agent_FLIDNumber']//div[@class='field_validator__text']")
    private WebElement agentFlidNoErrorMsg;

    @FindBy(xpath = "//div[@data-dataitemid='Agent_Commission']//div[@class='field_validator__text']")
    private WebElement agentComissionErrorMsg;

    @FindBy(id = "ToggleMessagesLink")
    private WebElement agentPgRedBubbleIcon;

    @FindBy(id = "imgOpenWiz")
    private WebElement wizPageWithNo;

    @FindBy(id = "root__wizardName")
    private WebElement wizPageName;

    @FindBy(xpath = "//div[@data-dataitemid='Owner_FirstName']//div[@class='field_validator__text']")
    private WebElement ownerpgFirstNameErrorMsg;

    @FindBy(xpath = "//input[@data-dataitemid='Contract_Number']")
    private WebElement OwnerPgContactNo;

    @FindBy(xpath = "//div[@data-dataitemid='Contract_Number']//div[@class='field_validator__close']")
    private WebElement crossErrorMsg;

    @FindBy(id = "dialogheader")
    private WebElement dialougeHeaderPendingRequestPopup;

    @FindBy(xpath = "(//th/b)[1]")
    private WebElement signerHeaderPendingRequestPopup;

    @FindBy(xpath = "(//div[@aria-describedby='dialogRequest']//button)[1]")
    private WebElement btn_CloseRequestDialog;

    @FindBy(xpath = "(//th/b)[2]")
    private WebElement signer2HeaderPendingRequestPopup;

    @FindBy(xpath = "//b[contains(.,'Owner')]/ancestor::tbody//div[contains(.,'Passcode:')]/span")
    private WebElement passcode_ownerPendingRequestPopup;

    @FindBy(xpath = "//b[contains(.,'Annuitant')]/ancestor::tbody//div[contains(.,'Passcode:')]/span")
    private WebElement passcode_annuitantPendingRequestPopup;

    @FindBy(xpath = "(//div[contains(@id,'divOutStandingRequestActions')]//a)[1]")
    private WebElement sendReminderToOwnerLinkPendingRequestPopup;

    @FindBy(xpath = "//span/span[.='Send']")
    private WebElement btn_sendMessagePopup;

    @FindBy(id = "Message")
    private WebElement mailMessage;

    @FindBy(xpath="//input[@data-dataitemid='JointOwner_FirstName']")
    private WebElement txtBox_jointOwnerFirstName;

    @FindBy(xpath="//input[@data-dataitemid='JointOwner_LastName']")
    private WebElement txtBox_jointOwnerLastName;

    @FindBy(xpath="//textarea[@data-dataitemid='MultiLineTextBox']")
    private WebElement txtBox_MultiLine;

    @FindBy(id = "toolbar__home")
    private WebElement home_tab;

    @FindBy(id="imgExpand")
    private WebElement icn_ExpandMenu;

    @FindBy(id="imgCollapse")
    private WebElement icn_CollapseMenu;

    private By txt_dataEntryPopupTextMVC = By.xpath("//div[contains(@id,'toastid')]");

    private By txt_dataEntryPopupTextReact = By.xpath("//div[@id='divStatusNotice' or @id='divFillAndSignStatusNotice' or @id='divTFMessage']/strong");

    @FindBy(xpath = "//div[@id='divStatusNotice']/strong/a[contains(.,'enter more data')]")
    private WebElement enterMoreData;

    @FindBy(id = "lblPendingRequest")
    private WebElement header_PendingRequestPopup;

    @FindBy(xpath = "//span[@id='divOutstandingRequestBody']//a")
    private List<WebElement> linksPresentInPendingRequestPopup;

    @FindBy(xpath = "//strong/parent::span/span")
    private WebElement passcode_recipient;

    private By link_closeMVC = By.xpath("//a[@title='Close']");
    private By link_closeReact = By.xpath("//div[@id='divStatusNotice' or @id='divFillAndSignStatusNotice' or @id='divTFMessage']//p/*[contains(.,'Close')]");

    @FindBy(id="root__wizardName")
    private WebElement txt_linkedChild;

    @FindBy(id="LastName")
    private WebElement txtbox_lastName;

    @FindBy(id="FirstName")
    private WebElement txtbox_FirstName;

    @FindBy(xpath = "//div[contains(@class,'MultiAppPartyChoiceOpen')]//select/option")
    private List<WebElement> list_partyNames;

    @FindBy(xpath = "//button[@title='Applicant Data Auto Fill']")
    private WebElement btn_ApplicantDataAutoFill;

    @FindBy(id="StreetAddress")
    private WebElement txtbox_StreetAddress;

    @FindBy(id="City")
    private WebElement txtbox_City;

    @FindBy(xpath="(//div[@class='customListCell'])[1]")
    private WebElement txt_CustomValue;

    @FindBy(id="State")
    private WebElement txtbox_State;

    @FindBy(xpath = "//select[@id='State']/option")
    private List<WebElement> list_StateDropDown;

    @FindBy(id="ZipCode")
    private WebElement txtbox_ZipCode;

    @FindBy(id="ZipCode")
    private List<WebElement> listTxtbox_ZipCode;

    @FindBy(id="CouncilNumber")
    private WebElement txtbox_CouncilNumber;

    @FindBy(xpath="//button[@title='Insured Data Auto Fill']")
    private WebElement btn_InsuredDataAutoFill;

    @FindBy(xpath = "(//span[text()='Next'])[3]")
    private WebElement btn_Next;

    @FindBy(id="imgExpand")
    private WebElement icon_ExpandMenu;

    @FindBy(id="imgCollapse")
    private WebElement icon_CollapseMenu;

    @FindBy(xpath="//*[@id=\"divStatusNotice\"]/strong/a[1]")
    private WebElement link_DataEntryPopupMoreData_New;

    private By txt_Page1FormMVC = By.xpath("//div[@title='KOC 903 US Life Insurance Application']/parent::div//li[@title='Page 1']");
    private By txt_Page1FormReact = By.xpath("//a[contains(text(), 'eDelivery Required Voided Check  * ')]");

    private By txt_Page1TemplateFormMVC = By.xpath("//div[@title='KOC 903 US Life Insurance Application']/parent::div//li[@title='Page 1']");
    private By txt_Page1TemplateFormReact = By.xpath("//a[contains(text(), 'FL024 Policy Template Form  * ')]");

    private By txt_Page1WetPolicyFormMVC = By.xpath("//div[@title='KOC 903 US Life Insurance Application']/parent::div//li[@title='Page 1']\"");
    private By txt_Page1WetPolicyFormReact = By.xpath("//a[contains(text(), 'FL024 Wet Signed Template Form  * ')]");

    private By message_UploadToastPopUpMVC = By.xpath("//strong[contains(text(), 'template forms with')]");
    private By message_UploadToastPopUpReact = By.xpath("//div[contains(@id,'toastid')]");

    @FindBy(className = "listView")
    private WebElement list_FormsWizards;

    @FindBy(xpath = "//a[contains(text(), 'View')]")
    private WebElement link_View;

    @FindBy(xpath = "//a[contains(text(), 'Remove')]")
    private WebElement link_Remove;

    @FindBy(xpath = "//a[contains(text(), 'Remove')]")
    private List<WebElement> list_RemoveLink;

    @FindBy(xpath = "//div[@class='navDrawer__bundle']/div")
    private List<WebElement> list_formsSectionsInExpand;

    @FindBy(xpath = "//div[@class='navDrawer__bundle']//ul//li")
    private List<WebElement> list_pageName;

    @FindBy(id="root__wizardName")
    private WebElement txt_pageMiddleName;

    @FindBy(xpath = "//div[@class='ITWizardPageName']")
    private WebElement txt_pageleftTopName;

    @FindBy(xpath = "//input[@data-dataitemid='Applicant_FirstName']")
    private WebElement txtbox_applicantFirstName;

    @FindBy(xpath = "//input[@data-dataitemid='Applicant_LastName']")
    private WebElement txtbox_applicantlastName;

    @FindBy(xpath = "//input[contains(@data-dataitemid,'Applicant_ResidentialAddress')]")
    private WebElement txtbox_applicantStreetAddress;
    @FindBy(xpath = "//input[@data-dataitemid='Insured_FirstName']")
    private WebElement txtbox_InsuredFirstName;

    @FindBy(xpath = "//input[@data-dataitemid='Insured_LastName']")
    private WebElement txtbox_InsuredLastName;

    @FindBy(xpath = "//input[@data-dataitemid='Owner_FirstName']")
    private WebElement txtbox_OwnerFirstName;

    @FindBy(xpath = "//input[@data-dataitemid='Owner_LastName']")
    private WebElement txtbox_OwnerLastName;

    @FindBy(xpath = "//button[contains(@data-dataitemid,'Owner_Autofill')]")
    private WebElement btn_OwnerAutoFill;

    @FindBy(xpath = "//input[contains(@data-dataitemid,'Owner_ResidentialAddress')]")
    private WebElement txtbox_OwnerStreetAddress;

    @FindBy(xpath = "//input[@data-dataitemid='Owner_ResidentialAddress_City']")
    private WebElement txtbox_OwnerCity;

    @FindBy(xpath = "//select[@data-dataitemid='Owner_ResidentialAddress_State']")
    private WebElement dd_OwnerState;

    @FindBy(xpath="//input[@data-dataitemid='Owner_ResidentialAddress_Zipcode']")
    private WebElement txtbox_OwnerZipCode;

    @FindBy(xpath = "//button[@title='Open']")
    private List<WebElement> list_AutofillButton;

    @FindBy(xpath = "//button[@data-dataitemid='Applicant Auto Fill']")
    private WebElement btn_ApplicantAutoFill;

    @FindBy(xpath = "//div[@id='fireLightMainDiv']//b")
    private WebElement templatefm_msg;

    @FindBy(xpath = "//a[@aria-label='Close']")
    private WebElement templatefm_crossButton;

    @FindBy(xpath="  //*[@class=\"listViewItem\"]")
    private WebElement showAll;

    @FindBy(xpath="//*[@class='listViewItem-validation-error']")
    private List<WebElement> dataEntryPopUpErrorsList;

    @FindBy(id="root__wizardName")
    private WebElement dataEntryPageHeader;

    @FindBy(id="percentHolder")
    private  WebElement percentBar;

    //******************************************

    @FindBy(xpath="//*[@class='ITWizardPageName' or @id='lblPageNumber']")
    private WebElement formName;

    @FindBy(id="searchImg")
    private WebElement searchIcon;

    @FindBy(xpath = "//input[@data-item-id='Owner_FirstName']")
    private WebElement participants_OwnerFN;

    public String dataEntryTextFields="//input[@title=\"%s\" or  @data-dataitemid=\"%s\"]";

    public String txtBox_dataEntryTextFields_Mvc = "//input[@title=\"%s\" or  @data-item-id=\"%s\" or  @data-dataitemid=\"%s\"]";

    @FindBy(id="lblName")
    private WebElement CRMSearchResultHeader;

    @FindBy(xpath="//div[@class='signatureImage']")
    private WebElement txt_ActiveSignature;

    @FindBy(id="divPerson")
    private WebElement CRMCompanyDetails;

    @FindBy(xpath = "//input[@data-item-id='Client_DOB']")
    private WebElement txtBox_ClientDob;

    @FindBy(xpath = "//li[contains(@class,'listViewItem-validation-error')]")
    private List<WebElement> list_ExpandFormMenu;

    @FindBy(xpath = "//li[contains(@class,'listViewItem-validation-error')]//*[contains(@class,'listViewItem-validation-error')]")
    private List<WebElement> list_ExpandFormMenuReact;

    @FindBy(id="imgCollapse")
    private WebElement menu_Collapse;

    @FindBy(id="Agent_LastName")
    private WebElement txtBox_DataEntryUserLastName;

    @FindBy(id="Agent_FirstName")
    private WebElement dataEntry_txtbox_userFirstName;

    @FindBy(id="Agent_IDNumber")
    private WebElement dataEntry_txtbox_userIDNumber;

    @FindBy(xpath = "(//span[text()='Next'])[3]")
    private WebElement bt_next;

    @FindBy(id = "root__wizardName")
    private WebElement txt_publicprotectedform;

    @FindBy(xpath = "//input[@data-dataitemid='Insured_FirstName']")
    private WebElement insuredfirstname_txtbox;

    @FindBy(xpath = "//input[@data-dataitemid='Owner_FirstName']")
    private WebElement agentProtectedowner_firstname;

    @FindBy(xpath = "//input[@data-dataitemid='Owner_LastName']")
    private WebElement lastName_AgentProtectedowner;

    @FindBy(xpath = "//span[text()='State Notice Upload']")
    private WebElement btn_StateUploadNotice;

    @FindBy(xpath = "//select[@id='DocumentType']//option")
    private List<WebElement> list_SelectPolicy;

    @FindBy(id = "File")
    private WebElement upload_file;

    @FindBy(xpath = "//span[text()='Upload']")
    private WebElement btn_Upload;

    @FindBy(xpath = "(//button[@class='ITButtonInput  '])[2]")
    private WebElement btn_documentUploadEnable;

    @FindBy(xpath = "//button[@class='ITButtonInput  ']//span[text()='Close']")
    private WebElement btn_Close;

    @FindBy(id="root__wizardName")
    private WebElement txt_AgentprotectedForm;

    @FindBy(xpath = "//div[@id='toastid1']//b")
    private WebElement msg_toastBox;

    @FindBy(xpath = "//div[@id='toastid1']//b")
    private List<WebElement> list_MsgToastBox;

    @FindBy(xpath = "//a[@title='Close']")
    private WebElement icon_PopupCross;

    @FindBy(id="imgNext")
    private WebElement countinue_button;

    @FindBy(xpath = "//div[@class='ITWizardErrorMenu shadow ']//ul")
    private List<WebElement> list_clientData;

    @FindBy(xpath = "//img[@alt='Close']")
    private WebElement icon_Close;

    @FindBy(id = "toolbar_OtherActions")
    private WebElement otherAction_modl;

    @FindBy(xpath = "//a[text()='Display/Print PDF']")
    private WebElement display_Print_modl;

    @FindBy(xpath = "//div[contains(text(),'Client Protected')]/parent::div//div[@class='ITCheckBoxCheck']")
    private List<WebElement> list_selectPrintDocumentChechBox;

    @FindBy(xpath = "//span[text()='Print Selected Documents']")
    private WebElement printselect_modl;

    @FindBy(xpath = "//a[text()='Request Client to Fill & Sign']")
    private WebElement req_client_fillsign_modl;

    @FindBy(xpath = "(//div[@class='divFillAndSign']//input[@class='largeCheck advSearch'])[2]")
    private WebElement btn_Owner;

    @FindBy(xpath = "//input[@value='Insured']/ancestor::div[contains(@id,'signer')]//input[contains(@id,'ToName')]")
    private WebElement insured_name;

    @FindBy(xpath = "//input[@value='Insured']/ancestor::div[contains(@id,'signer')]//input[contains(@id,'ToEmail')]")
    private WebElement insured_email;

    @FindBy(xpath = "//input[@value='Insured']/ancestor::div[contains(@id,'signer')]//input[contains(@id,'SSN')]")
    private WebElement ssn_Insured;

    @FindBy(xpath = "//input[@value='Insured']/ancestor::div[contains(@id,'signer')]//input[contains(@id,'BirthDate')]")
    private WebElement insured_birthdate;

    @FindBy(xpath = "//input[@value='Owner']/ancestor::div[contains(@id,'signer')]//input[contains(@id,'ToName')]")
    private WebElement name_Owner;

    @FindBy(xpath = "//input[@value='Owner']/ancestor::div[contains(@id,'signer')]//input[contains(@id,'ToEmail')]")
    private WebElement email_Owner;

    @FindBy(xpath = "//input[@value='Owner']/ancestor::div[contains(@id,'signer')]//input[contains(@id,'SSN')]")
    private WebElement ssn_Owner;

    @FindBy(xpath = "//input[@value='Owner']/ancestor::div[contains(@id,'signer')]//input[contains(@id,'BirthDate')]")
    private WebElement birthDate_Owner;

    @FindBy(id="buttonGenerateLink")
    private WebElement btn_GenerateLinkWithOutEmail;

    @FindBy(xpath = "//span[@id='lblSent']//span[@style='font-family:Lucida Console;font-size:medium;']")
    private WebElement owner_PassCode;

    @FindBy(xpath = "//span[@id='lblSent']//span/strong[contains(.,'https')]")
    private WebElement link_GenerateLinkWithOutEmailOnOwner;

    @FindBy(xpath = "//table[@class='outstandingRequestsDialog__table']//span")
    private WebElement passCode_PendingRequest;

    @FindBy(id = "buttonBack")
    private WebElement btn_Backapp;

    @FindBy(xpath = "//header[text()='Pending Requests']")
    private WebElement pendingRequest_header;

    @FindBy(xpath = "//div[text()='Send Reminder to']")
    private WebElement sendRemider_PendingRequest;

    @FindBy(id = "Message")
    private WebElement link_MessageUrl;

    @FindBy(xpath = "//span[text()='Send']")
    private WebElement btn_Send;

    @FindBy(id = "lblAppName")
    private WebElement txt_NewApplication;

    private By link_ClosePopupReact = By.xpath("//a[@class='close']");

    @FindBy(xpath = "//b[contains(text(), 'template forms with')]")
    private WebElement msg_UploadToastPopUpReact;

    private By close_popupMVC = By.xpath("//a[@class='orange' and contains(text(),'[Close]')]");
    private By close_popupReact = By.xpath("//a[@title='Close']");

    @FindBy(xpath = "//input[@data-item-id='Agent_FirstName']")
    private WebElement txt_FirstNameOnPublicProtectedRequired;

    @FindBy(xpath = "//input[@data-item-id='Agent_LastName']")
    private WebElement txt_LastNameOnPublicProtectedRequired;

    private By btn_OpenINMenuMVC = By.id("imgOpen");
    private By btn_OpenINMenuReact = By.id("imgOpenWiz");

    @FindBy(id="lblPercent")
    private WebElement btn_DataPercentage;

    @FindBy(xpath = "//div[@class='whiteButton shadow roundCorners']")
    private List<WebElement> list_ClientProtectedCheckBox;

    @FindBy(xpath = "//td[contains(text(),'Print Selected Documents')]")
    private WebElement btn_PrintSelectDocument;

    @FindBy(xpath = "//a[@class='linkedActivitiesButton']//em")
    private WebElement btn_ICon;

    @FindBy(xpath = "//a[@class='linkFocus']")
    private WebElement ParentApplicationName;

    @FindBy(id="viewer")
    private WebElement txt_Pdfpage;

    @FindBy(xpath = "//div[@id='lnkClose']/a")
    private WebElement btn_CloseDialog;

    @FindBy(xpath = "//a[contains(text(),'Cancel this request')]")
    private WebElement link_CancelRequest;

    @FindBy(id="popup_cancel")
    private WebElement btn_CancelPopup;

    @FindBy(xpath = "//div[@id='divOtherActions']/a[text()='History']")
    private WebElement btn_History;

    @FindBy(xpath = "//strong[text()='Pending Request']")
    private WebElement txt_PendingRequest;

    @FindBy(xpath = "//a[@id='toolbar_OtherActions']")
    private WebElement tab_OtherAction;

    @FindBy(id="buttonContactAgent")
    private WebElement btn_ContactAgent;

    @FindBy(xpath="//strong[text()='Message']")
    private WebElement msg_ContactAgentDialog;

    @FindBy(xpath = "//input[@aria-label='From Name']")
    private WebElement msg_FromNameDialogBox;

    @FindBy(id="FromEmail")
    private WebElement msg_FromAddressDialogBox;

    @FindBy(id="FromAddress")
    private WebElement txtbox_FromEmail;

    @FindBy(id="ToUserName")
    private WebElement msg_ToNameDialogBox;

    @FindBy(id="FromUserName")
    private WebElement msg_FromUserNameDialogBox;

    @FindBy(id="ToEmail")
    private WebElement msg_ToAddressDialogBox;

    @FindBy(xpath = "//textarea[@aria-label='Message']")
    private WebElement msg_body;

    private By btn_SendMessageMVC =  By.id("buttonSend");
    private By btn_SendMessageReact =  By.xpath("//span[text()='Send']");

    @FindBy(xpath = "//a[text()='Complete/Log Off']")
    private WebElement btn_CompleteOff;

    @FindBy(xpath = "(//span[text()='Complete Activity'])[1]")
    private WebElement header_CompleteActivity;

    @FindBy(xpath = "//b[contains(text(),'Submit and logoff')]")
    private WebElement txt_CompleteActivity;

    @FindBy(xpath = "(//button[@type='button'])[3]")
    private WebElement btn_CrossActivity;

    @FindBy(xpath = "//button[text()='Submit and logoff']")
    private WebElement btn_SubmitAndLogoff;

    @FindBy(xpath = "//button[contains(text(),'Save')]")
    private WebElement btn_SaveAndFinish;

    @FindBy(xpath = "//div[contains(text(),'Thank you for using our application')]")
    private WebElement txt_ConformationApplication;

    @FindBy(xpath = "(//button[@type='button'])[1]")
    private WebElement icon_CrossHistory;

    @FindBy(xpath = "//div[contains(text(),'Send Reminder to')]")
    private WebElement link_SendReminder;

    private By link_CancelPendingReqMVC = By.xpath("//span[text()='Cancel']");
    private By link_CancelPendingReqReact = By.xpath("//div[contains(text(),'Cancel Request')]");

    @FindBy(xpath = "//div[contains(text(),'Send Passcode to')]")
    private WebElement link_SendPasscodePendingReq;

    @FindBy(xpath = "//span[text()='Cancel']")
    private WebElement btn_CancelMsg;

    @FindBy(xpath = "//span[text()='Submit']")
    private WebElement btn_SubmitMsg;

    @FindBy(xpath = "//a[@title='pending request']")
    private WebElement txtBox_PendingRequest_DataEntry;

    @FindBy(xpath = "//span[text()='OK']")
    private WebElement btn_OkOnCancelReq;

    private By passcode_PendingReqMVC = By.xpath("//div[@class='linkFocus']/span");
    private By passcode_PendingReqReact = By.xpath("//strong/parent::span/span");

    @FindBy(xpath = "//div[@class='ITDialog__content ']//b[contains(text(),'Submit and logoff')]")
    private WebElement txt_CompleteActivityHeader;

    @FindBy(xpath = "//div[@id='lnkClose']//a")
    private WebElement close_PendingRequest;

    @FindBy(xpath = "//div[@data-item-id='PlanType_NonQualified']")
    private WebElement checkBox_nonQulified;

    @FindBy(xpath = "//input[@data-item-id='OWNER_SSN']")
    private WebElement txtBox_OwnerSSN;

    @FindBy(xpath = "//input[@data-item-id='Owner_DOB']")
    private WebElement txtBox_ownerDOB;

    @FindBy(xpath = "//input[@data-item-id='PrimaryBeneficiary_Percentage']")
    private WebElement txtBox_primaryBenefitPecentage;

    @FindBy(xpath = "//input[@data-item-id='Contract_Number']")
    private WebElement txtBox_contractNumber;

    @FindBy(xpath = "//a[@class='nextPage']")
    private WebElement icon_next;

    @FindBy(xpath = "//input[@data-item-id='Agent_FirstName']")
    private WebElement txtBox_agentFirstName;

    @FindBy(id="DATA ENTRY")
    private WebElement tab_DATAENTRY;

    @FindBy(xpath = "//span[contains(text(),'DATA ENTRY')]")
    private List<WebElement>  listtab_Dataentry_React;

    @FindBy(id = "divPercent")
    private WebElement txtBtn_DataEntry;

    @FindBy(xpath = "//input[@data-item-id='Agent_LastName']")
    private WebElement txtBox_agentLastNamefield;

    @FindBy(xpath = "//input[@data-item-id='Agent_FLIDNumber']")
    private WebElement txtBox_stateLicence;

    @FindBy(xpath = "//input[@data-item-id='Agent_Commission']")
    private WebElement txtBox_agentPercent;

    @FindBy(xpath = "//span[text()='Submit and logoff']")
    private WebElement btn_SubmitLogoff;

    @FindBy(xpath = "//span[contains(text(),'Save - Finish later')]")
    private WebElement btn_Save;

    @FindBy(xpath = "//div[contains(@class,'ITDialog__content ')]//b[contains(text(),'Submit and logoff')]")
    private WebElement txt_SubmitCompleteActivity;

    @FindBy(xpath = "//span[@class='ITButtonText ']//span[text()='Cancel']")
    private WebElement btn_CancelCompleteActivity;

    @FindBy(xpath = "//div[@id='divOutstandingRequests']")
    private WebElement popupbox_PendingRequest;

    private By link_SendReminderMail = By.xpath("//div[contains(@id,'divOutStandingRequestActions')]/a[contains(text(),'Reminder')]");
    private By link_SendReminderMailReact = By.xpath("//div[contains(text(),'Send Reminder to')]");

    private By link_sendPasscodeMVC = By.xpath("//div[contains(@id,'divOutStandingRequestActions')]/a[contains(text(),'end Passcode')]");
    private By link_sendPasscodeReact = By.xpath("//div[contains(text(),'Resend Passcode to')]");
    private By link_sendPasscodeReact1 = By.xpath("//div[contains(@id,'divOutStandingRequestActions')]//div[contains(text(),'Send Passcode')]");

    private By btn_SendOnPendingRequestMVC = By.xpath("//button[@id='buttonSend']");
    private By btn_SendOnPendingRequestReact = By.xpath("//span[text()='Send']");

    @FindBy(id = "popup_ok")
    private WebElement btn_popupOk;

    @FindBy(xpath = "//div[@id='appNameEdit']/a")
    private WebElement icon_AllicationLock;

    @FindBy(xpath = "//span/strong[contains(.,'Request Type')]")
    private WebElement requestTypeText;

    @FindBy(xpath = "//tbody/tr/td/span")
    private WebElement txt_pendingRequestDetails;

    @FindBy(xpath = "//td[contains(@class,'outstandingRequestsDialog__requestDetails linkFocus')]/div/span")
    private List<WebElement> listTxt_Passcode;

    @FindBy(xpath = "//input[@id='FromUserName' or @id='FromName' or @aria-label='From Name']")
    private WebElement txtBox_fromName;

    @FindBy(xpath = "//input[@id='FromEmail' or @id='FromAddress' or @aria-label='From Address']")
    private WebElement txtBox_fromAddress;

    @FindBy(xpath = "//input[@id='ToName' or @id='ToUserName' or @id='Name']")
    private WebElement txtBox_toName;

    @FindBy(xpath = "//input[@id='ToEmail' or @id='ToAddress' or @id='Email']")
    private WebElement txtBox_toAddress;

    @FindBy(xpath = "//input[contains(@id,'Subject')]")
    private WebElement txtBox_subject;

    @FindBy(xpath = "//textarea[contains(@id,'Message')]")
    private WebElement txtBox_message;

    private By btn_cancelMVC = By.xpath("//button[contains(text(),'Cancel')]");
    private By btn_cancelReact = By.xpath("//span[text()='Cancel']");

    @FindBy(id = "popup_container")
    private WebElement popupbox_confirmation;

    @FindBy(xpath = "//a[@title='pending request']")
    private List<WebElement> list_pendingRequestOnDatatEntryTab;

    @FindBy(xpath = "//a[contains(text(),'Send Passcode to')]")
    private WebElement link_SendPasscode;

    @FindBy(xpath = "//a[@title='pending request']")
    private WebElement link_pendingRequestOnDatatEntryTab;

    @FindBy(xpath = "//header[text()='Pending Requests']")
    private WebElement popUp_PendingReq;

    @FindBy(xpath = "//div[@data-dataitemid='Owner_Type']//div[@title='Individual']")
    private WebElement ckeckBox_Individual;

    @FindBy(xpath = "//div[@data-dataitemid='PlanType_NonQualified']//div[@title='Non-Qualified Account']")
    private WebElement checkBox_NonQualifiedAccount;

    @FindBy(xpath = "//div[@data-dataitemid='Owner_ExistingPolicies']//div[@title='Yes']")
    private WebElement checkBox_ReplacementQut;

    @FindBy(xpath = "//div[@data-dataitemid='Owner_ChangePolicies']//div[@title='Yes']")
    private WebElement checkBox_ReplacementQutAnnuity;

    @FindBy(id="DateofBirth")
    private WebElement txtBox_DOB;

    @FindBy(xpath = "//select[@id='HowmanyPrimaryBeneficiariesdoyouhave?']")
    private WebElement txtBox_PrimaryBeneficiaries;

    @FindBy(xpath = "//select[@id='RelationshiptoOwner']")
    private WebElement txtBox_RelationShipToOwner;

    @FindBy(id = "PercentageofProceeds")
    private WebElement txtBox_PercentageOfProceed;

    @FindBy(xpath = "//select[@data-dataitemid='SourceOfFunds_PaymentMethod']")
    private WebElement txtBox_PaymentMethod;

    @FindBy(xpath = "//div[@class='ITDialog__box ']//header[@id='dialogheader']")
    private WebElement msg_Header;

    @FindBy(xpath = "//select[@id='PaymentMethod']")
    private WebElement txtBox_SelectPaymentMethod;

    @FindBy(xpath = "//select[@id='HowmanyPrimaryBeneficiariesdoyouhave?']")
    private WebElement txtBox_SelectPrimaryBeneficiary;

    @FindBy(xpath = "//select[@id='RelationshiptoOwner']")
    private WebElement txtBox_SelectRelationToOwner;


    @FindBy(xpath = "//strong[text()='Pending Request']")
    private List<WebElement> listTxt_PendingRequestDialog;

    @FindBy(xpath = "//*[text()='From Name']")
    private WebElement  txt_FromName;

    @FindBy(xpath = "//*[text()='From Address']")
    private WebElement  txt_FromAddress;

    @FindBy(xpath = "//*[text()='To Name']")
    private WebElement  txt_ToName;

    @FindBy(xpath = "//*[text()='Subject']")
    private WebElement  txt_Subject;

    @FindBy(xpath = "//*[text()='Message']")
    private WebElement  txt_Message;

    @FindBy(xpath = "(//a[contains(text(),'[Close]')])[2]")
    private WebElement link_CloseIcon;

    @FindBy(id="FromName")
    private WebElement txtBox_YourNM;

    @FindBy(id="ToName")
    private WebElement txtBox_RecipientName;

    @FindBy(id="ToAddress")
    private WebElement txtBox_RecipientAddress;

    @FindBy(id="Subject")
    private WebElement txtBox_RecipientSubject;

    @FindBy(xpath = "//input[@aria-label='Owner']/parent::div//following-sibling::div//input[@aria-label='* Birth Date']")
    private WebElement txtBox_OwnerdataOfBirth;

    @FindBy(xpath = "//input[@aria-label='Owner']/parent::div//following-sibling::div//span[contains(text(),'Name is required')]")
    private WebElement errorMsg_OwnerNM;

    @FindBy(xpath = "//input[@aria-label='Joint Owner']/parent::div//following-sibling::div//span[contains(text(),'Name is required')]")
    private WebElement errorMsg_JointOwnerNM;

    @FindBy(xpath = "//div[contains(text(),'Your Name')]/parent::div//span[@id='FromName-error']")
    private WebElement errorMsg_YourNM;

    @FindBy(xpath="//div[contains(text(),'Your Email')]/parent::div//span[@id='FromEmail-error']")
    private WebElement errorMsg_YourEmail;

    @FindBy(xpath = "//input[@aria-label='Owner']/parent::div//following-sibling::div//span[contains(text(),'Email')]")
    private WebElement errorMsg_OwnerEmail;

    @FindBy(xpath = "//input[@aria-label='Joint Owner']/parent::div//following-sibling::div//span[contains(text(),'Email')]")
    private WebElement errorMsg_JointOwnerEmail;

    @FindBy(xpath = "//input[@aria-label='Payor']/parent::div//following-sibling::div//span[text()='Email is required.']")
    private WebElement errorMsg_Email;

    @FindBy(xpath = "//input[@aria-label='Owner']/parent::div//following-sibling::div//span[contains(text(),'The last 4 digits of SSN is required')]")
    private WebElement errorMsg_OwnerSSN;

    @FindBy(xpath = "//input[@aria-label='Joint Owner']/parent::div//following-sibling::div//span[text()='The last 4 digits of SSN is required.']")
    private WebElement errorMsg_JointOwnerSSN;

    @FindBy(xpath = "//input[@aria-label='Owner']/parent::div//following-sibling::div//span[contains(text(),'A valid birth date is required.')]")
    private WebElement errorMsg_OwnerDateOfBirth;

    @FindBy(xpath = "//input[@aria-label='Joint Owner']/parent::div//following-sibling::div//span[contains(text(),'A valid birth date is required.')]")
    private WebElement errorMsg_JointOwnerDateOfBirth;


    @FindBy(xpath = "(//span[@class='field-validation-error']//span[text()='A valid birth date is required.'])[2]")
    private WebElement errorMsg_PayorDOB;

    @FindBy(xpath = "(//input[contains(@id,'FillAndSignPersons') ])[6]")
    private WebElement txtBox_PrimaryOwnerNM;

    @FindBy(xpath = "(//input[@aria-label='Email'])[1]")
    private WebElement txtBox_PrimaryEmail;

    @FindBy(xpath = "(//input[@aria-label='Email'])[2]")
    private WebElement txtBox_PayorEmail;

    @FindBy(xpath = "(//input[contains(@id,'SSN')])[1]")
    private WebElement txtBox_PrimarySSN;

    @FindBy(xpath = "(//input[@aria-label='Name'])[2]")
    private WebElement txtBox_PayorNM;

    @FindBy(xpath = "(//input[@aria-label='Last 4 Digits of SSN/Government ID'])[2]")
    private WebElement txtBox_PayorSSN;

    @FindBy(xpath = "(//input[@aria-label='* Birth Date'])[1]")
    private WebElement txtBox_PrimaryDOB;

    @FindBy(xpath = "(//input[@aria-label='* Birth Date'])[2]")
    private WebElement txtBox_PayorDOB;

    @FindBy(xpath = "//a[contains(text(),'Send Reminder to PayORNM')]")
    private WebElement link_SendRemiderPayor;

    @FindBy(xpath = "(//a[@class='blueLink lnkSMSPasscode'])[1]")
    private WebElement link_SendPasscodeJointOwner;

    @FindBy(xpath = "//a[contains(text(),'Send Passcode to')]")
    private WebElement link_SendPasscodePrimary;

    @FindBy(xpath = "//a[contains(text(),'Send Reminder to')]")
    private WebElement link_SendRemiderprimary;

    @FindBy(xpath = "(//div[contains(@id,'divOutStandingRequestActions')]/a[@class='blueLink' and contains(text(),'Cancel this request')])[1]")
    private WebElement link_cancelPayor;

    @FindBy(xpath = "//a[contains(text(),'Cancel this request')]")
    private WebElement link_cancelPrimaryOwner;

    private By link_RequestUrlMVC = By.xpath("//div[@id='popup_message']//span/strong");
    private By link_RequestUrlReact = By.xpath("//span[@id='lblSent']//span/strong");

    private By btn_CancelPendingReqMVC = By.xpath("//button[@aria-label='Cancel']");
    private By btn_CancelPendingReqReact = By.xpath("//span[text()='Cancel']");

    @FindBy(xpath = "//div[contains(@id,'divOutStandingRequestActions')]//a")
    private List<WebElement> list_PendingRequest;

    private By txt_JointOwnerPasscodeMVC = By.xpath("//div[@class='linkFocus' and contains(text(),'Passcode')]/span");
    private By txt_JointOwnerPasscodeReact = By.xpath("(//strong[@id='lblPendingRequest']/parent::span//following-sibling::table//span)[2]");

    private By txt_PrimaryOwnerPasscodeMVC = By.xpath("(//div[@class='linkFocus' and contains(text(),'Passcode')]/span)[2]");
    private By txt_PrimaryOwnerPasscodeReact = By.xpath("(//strong[@id='lblPendingRequest']/parent::span//following-sibling::table//span)[4]");

    @FindBy(id="popup_ok")
    private WebElement btn_OkDialogBox;

    @FindBy(xpath = "//div[@id='lnkClose']/a")
    private WebElement txt_ClosePendingpopup;

    @FindBy(xpath = "//*[text()='pending request']")
    private WebElement txt_PendingRequestDataEntry;

    @FindBy(xpath = "(//strong[text()='Pending Request'])[1]")
    private WebElement txt_PrimaryPendingReq;

    @FindBy(xpath = "//font[text()='[Close]']")
    private WebElement btn_CloseApplication;

    @FindBy(xpath = "//input[@value='Owner']//preceding-sibling::input[@aria-label='Primary']")
    private WebElement checkBox_Owner;

    @FindBy(id="popup_title")
    private WebElement txt_OKConfirmationPopup;

    @FindBy(xpath = "//div[contains(text(),'Electronic Signatures')]")
    private WebElement txt_ElectronicSignature;

    @FindBy(xpath = "//button[@aria-label='OK']")
    private WebElement btn_OK;

    @FindBy(xpath = "(//div[@class='linkFocus'])[4]")
    private WebElement passcode_PendingRequest;

    @FindBy(xpath = "//div[@id='divForms']//ul[@class='listView']//li")
    private List<WebElement> list_FormMenu;

    @FindBy(xpath = "//div[@class='navDrawer__bundle']")
    private List<WebElement> list_FormMenu_react;

    private By txt_ExchangeRollFormMVC = By.xpath("//div[contains(text(),'1035 EXCHANGEROLLOVERTRANSFER eFORM')]");
    private By txt_ExchangeRollFormReact = By.xpath("//a[contains(text(),'1035 EXCHANGEROLLOVERTRANSFER eFORM')]");

    @FindBy(xpath = "//div[@id='divForms']//ul[@class='listView']//li//a[contains(@class,'errors') and contains(text(),'Page')]")
    private List<WebElement> list_Pages;

    @FindBy(xpath = "//a[contains(text(),'Application222')]/following-sibling::a[contains(text(),'Page 1')]")
    private WebElement txt_ApplicationPage1;

    public static String otherActionsList="//div[@id='divOtherActions']//a[contains(text(),'%s')]";

    @FindBy(xpath = "//li[@class='listViewItem']/div")
    private WebElement icon_ArrowAppication222Menu;

    @FindBy( id = "InitialMessage")
    private List <WebElement> msg_Initial;

    @FindBy(xpath = "//strong[contains(text(), 'template forms with')]")
    private List <WebElement> list_Message;

    @FindBy(xpath = "//b[contains(.,'Joint Owner')]/ancestor::tbody//div[contains(.,'Passcode:')]/span")
    private WebElement passcode_JointOwner;

    @FindBy(xpath = "//b[contains(.,'Sign Owner')]/ancestor::tbody//div[contains(.,'Passcode:')]/span")
    private WebElement passcode_SignOwner;

    @FindBy(xpath = "(//table[@class='outstandingRequestsDialog__table']//b[contains(text(),'Request Type')])[2]")
    private WebElement requestType;

    @FindBy(xpath = "//div[@id='dialogDocuments']/parent::div//button[@title='Close']")
    private WebElement btn_CrossDocumentPage;

    @FindBy(xpath = "//select[@data-dataitemid='JointOwner_YesNo']")
    private WebElement btn_JointOwnerYesNo;

    @FindBy(xpath = "//select[@data-dataitemid='Annuitant_YesNo']")
    private WebElement btn_AnnuitantYesNo;

    @FindBy(id = "h1Title")
    private WebElement heading_Lookup;

    private By txtBox_CRMSearchMVC = By.id("MyContacts");
    private By txtBox_CRMSearchReact = By.id("search");

    private By firstValueRecordMVC = By.xpath("(//div[@class='crmListPanel']//li)[1]");
    private By firstValueRecordMVC1 = By.xpath("//div[@id='divCRMList']/div/ul/li/a");
    private By firstValueRecordReact = By.xpath("//ul//li");

    private By btn_SelectMVC = By.xpath("//button[@class='ITButtonInput  ']//span[text()='Select']") ;
    private By btn_SelectReact = By.xpath("//button[contains(text(),'Select')]") ;

    @FindBy(xpath = "//header[text()='CRM']")
    private WebElement header_CRMDialogbox;

    private By btn_Lookup = By.xpath("//a[contains(text(),'CRM Owner Lookup')]");

    private By btn_Lookup_React = By.xpath("//span[contains(text(),'CRM Owner Lookup')]");

    @FindBy(xpath = "//select[@data-item-id='Transfers']")
    private WebElement dd_selectTransferDropdown;

    public static String dataFieldsMVC="//input[@data-item-id='%s']";
    public static String dataFieldsMVC2="//select[@data-item-id='%s']";
    public static String dataFieldsMVC1="//input[@data-dataitemid='%s']";

    @FindBy(xpath = "(//div[@id='divCRMList']//ul//li/a)[1]")
    private WebElement exchangeFirstValue;

    public static String btn_LookupMvc="//a[contains(text(),'CRM Owner Lookup')]";

    public static String btn_LookupReact="//span[contains(text(),'Lookup Owner in CRM')]";

    @FindBy(xpath = "//select[@data-dataitemid='Transfers']")
    private WebElement dd_selectDataTransferDropdown;

    public static String pageHeading="//div[@id='appTopBar']//div//div[contains(text(),'%s')]";

    public static String namePage="//li[@class='listViewItem']//a[contains(text(),'%s')]/following-sibling::a[contains(text(),'%s')]";
    public static String namePageMVC="//ul[@class='navDrawer__pages']//div[contains(text(),'%s')]/following-sibling::li[@title='%s']/a/span";

    private String tabById = "//*[@id='%s']";

    private String byDataitemid = "//*[@data-dataitemid='%s']";

    @FindBy(xpath = "//td[@class='outstandingRequestsDialog__requestDetails linkFocus']/div")
    private List<WebElement> txt_PendingRequestDialogDetails;

    @FindBy(xpath = "//input[@data-item-id='Replacement_Company_City2'] | //input[@data-dataitemid='Replacement_Company_City2'] | //input[@data-dataitemid='Replacement_Company_City3']")
    private WebElement txtbox_cityName;

    @FindBy(xpath = "//input[@data-item-id='Replacement_Company_Zipcode2'] | //input[@data-dataitemid='Replacement_Company_Zipcode2'] | //input[@data-dataitemid='Replacement_Company_Zipcode3']")
    private WebElement txtbox_zipName;

    @FindBy(xpath = "//input[@data-item-id='Replacement_Company_LocationID2'] | //input[@data-dataitemid='Replacement_Company_LocationID2'] | //input[@data-dataitemid='Replacement_Company_LocationID3']")
    private WebElement txtbox_locationId;

    @FindBy(xpath = "//input[@data-item-id='Replacement_Company_PhoneNumber2'] | //input[@data-dataitemid='Replacement_Company_LocationID2'] | //input[@data-dataitemid='Replacement_Company_LocationID3']")
    private WebElement txtbox_phoneNumber;

    @FindBy(xpath = "//a[contains(text(),'Application222')]/following-sibling::a[contains(text(),'Page 3')]")
    private WebElement txt_ApplicationPage3;

    @FindBy(xpath = "//div[@id='navigationButtonsContainer']//button[@class='ITButtonInput  ']")
    private WebElement btn_NextGIACT;

    private By chkBox_ActionTriggerMVC = By.xpath("//div[@data-item-id='Click_Form' or @data-dataitemid= 'Click_Form']//div[@role]");
    private By chkBox_ActionTriggerMVC1 = By.xpath("//div[@data-item-id='Click_Form' or @data-dataitemid= 'Click_Form']");
    private By chkBox_ActionTriggerReact = By.xpath("//div[@data-dataitemid='Click_Wiz_GIACT']//div[@class='ITCheckBox   ']");

    @FindBy(xpath = "//div[@id='navigationButtonsContainer']//span[text()='Previous']")
    private WebElement btn_Previous;

    @FindBy(xpath = "//a[@data-item-id='Custom list button']")
    private WebElement btn_CustomList;

    @FindBy(xpath = "//div[@id='divContent']//div[@class='linkFocus enabledMenuLink']")
    private List<WebElement> list_CountryStatesCity;

    public static String customListDialog = "//div[@id='divContent']//div[contains(text(),'%s')]";

    public static String customListDialog_React = "//div[@id='statusmessage']/following-sibling::div//div[contains(text(),'%s')]";

    public static String popupMSG = "//div[@id='toastid1']/div[contains(text(),'%s')]";

    @FindBy(xpath = "//div[contains(text(),'Account validation is being performed.')]")
    private WebElement popup_AccountValidation;

    @FindBy(xpath = "//li[@title='Custom list Wiz']")
    private WebElement formCustomListWiz;

    @FindBy(xpath = "//div[@class='customListValues']/div[@class='customListRow ']")
    private List<WebElement> listCountryCS;

    @FindBy(xpath = "//footer[@class='ITDialog__footer']//span[text()='Select']")
    private WebElement btn_SelectCustomList;

    @FindBy(xpath = "//a[@data-item-id='Button_Lexis_Call']")
    private WebElement btn_ButtonLexisCall;

    private By btn_GIACTLookupMVC = By.xpath("//a[contains(text(),'Click to get GIACT Results')]");
    private By btn_GIACTLookupMVC1 = By.xpath("//span[contains(text(),'Click to get GIACT Results')]");

    @FindBy(xpath = "//button[@title='Click me to get GIACT Results']")
    private WebElement btn_GIACTLookupReact;

    @FindBy(xpath = "//a[contains(text(),'Use Lexis Test to fill below fields')]")
    private WebElement btn_LexisNexisCall;

    @FindBy(xpath = "//button[@title='Click Me! To Get Instant ID Results']")
    private WebElement btn_LexisNexisCallReact;

    @FindBy(xpath = "//div[contains(text(),'Back Office Action is being performed')]")
    private WebElement msg_Popup_Giact1;

    @FindBy(xpath = "//div[contains(text(),'Account validation is being performed')]")
    private WebElement msg_Popup_Giact2;

    @FindBy(id="popup_title")
    private WebElement msg_Popup_LexisNexis1;

    @FindBy(xpath = "//div[contains(text(),'Back Office Action is being performed')]")
    private WebElement msg_Popup_LexisNexisReact1;

    @FindBy (id="popup_message")
    private WebElement msg_Popup_LexisNexis2;

    @FindBy(xpath = "//div[contains(text(),'User validation is being performed')]")
    private WebElement msg_Popup_LexisNexisReact2;

    @FindBy(xpath = "//div[@data-item-id='Click_Form']")
    private WebElement btn_ButtonLexisCallClickForm;

    public static String btn_CustomListWiz = "//button[@data-dataitemid='%s']";

    public static String btn_CustomTextFields = "//input[@id='%s']";

    @FindBy(xpath = "//div[@id='appNameEdit']/a")
    private WebElement canvasReadOnlyForm;

    @FindBy(xpath = "(//span[contains(text(),'Activity Summary')])[2]")
    private WebElement DialogBoxActivitySummary;

    @FindBy(xpath = "//div[@data-dataitemid='Click_Form' and @class='ITCheckBoxContainer' ]")
    private WebElement checkBoxCustomActionCall;

    @FindBy(xpath = "//textarea[@id='Body']")
    private List<WebElement> list_TextAreaEmailBody;

    @FindBy(xpath="//button[@title='Click Me! To Get Risk Classifier Results']")
    private WebElement btn_Lexis_Call;

    @FindBy(xpath = "//div[@class='row printCheckAll']//div[@class='ITCheckBox   fillColor']")
    private WebElement checkBoxCheckUncheck;

    @FindBy(xpath = "//div[contains(text(),'A validation is being performed')]")
    private WebElement msg_Popup_Giact3;

    @FindBy(xpath = "//button[@data-dataitemid='Button_Lexis_Call']")
    private WebElement btn_ButtonLexisCall1;

    @FindBy(id = "btnRename")
    private WebElement btn_Rename2;

    @FindBy(xpath = "(//span[text()='Activity Summary']//following-sibling::button)[1]")
    private WebElement btn_ActivitySummaryClose;

    @FindBy(xpath = "//label[@class='blueText']")
    private WebElement txt_optionalFormNote;

    @FindBy(id = "NewForm")
    private WebElement form_NewApplicationForm;

    @FindBy(xpath = "//span[@class='spanAppName']")
    private List<WebElement> list_allActivitiesResult;

    private String linkTestWorkFlow = "//div[@class='centerAlign ITLink  ' or @class='leftAlign ITLink  ']/a[@title='%s']";

    private String checkBox_Trigger = "//div[@title='%s']";

    private String txt_popUp= "//div[contains(text(),'%s')";

    private String valueByAttribute = "//div[text()='%s']/following-sibling::div";
    private String valueByAttribute1 = "//td[contains(text(),'%s')]/following-sibling::td";

    @FindBy(xpath = "//div[@id='StatusBar_Complete']/div")
    private List<WebElement> txt_StatusDataEntry;

    @FindBy(xpath = "//div[@class='ITCheckBoxContainer']//span")
    private List<WebElement> checkBoxWizard;

    private By ddComboBoxMVC = By.xpath("//select[@id='C_21']");
    private By ddComboBoxMVC1 = By.xpath("//div[@id=\"ComboBox_0\"]");
    private By ddComboBoxReact = By.xpath("//select[@data-dataitemid='ComboBox_0']");

    @FindBy(id = "btnUnlock")
    private WebElement btn_Unlock;

    @FindBy(xpath="//span[contains(text(),'Cancel')]")
    private WebElement button_cancel;

    @FindBy(xpath = "//div[@id='divMainForm']")
    private WebElement form_dataEntry;

    @FindBy(xpath = "//div[@class='ITDialog__box ']//input")
    private WebElement txt_activityRename;

    @FindBy(className = "ITNavBar")
    private WebElement navBar;

    @FindBy(id = "dialog__yesButton")
    private WebElement btn_yesActivityChange;

    @FindBy(id = "dialog__noButton")
    private WebElement btn_noActivityChange;

    @FindBy(id = "dialog__cancelButton")
    private WebElement btn_cancelActivityChange;

    @FindBy(id = "lblAppName")
    private WebElement label_activityName;

    @FindBy(xpath = "//a[@title='Linked Activities']")
    private WebElement icon_Link;

    @FindBy(xpath = "//span[contains(text(),'Linked')]")
    private WebElement title_Linked;

    private String list_TopMenu = "//a[contains(text(),'%s')]";
    @FindBy(xpath = "//a[@data-item-id='LN_Annuitant']")
    private WebElement btn_RiskClassifier;

    @FindBy(id = "popup_title")
    private WebElement title_Heading;

    @FindBy(xpath = "//button[@data-dataitemid='Owner_Risk_Button']")
    private WebElement btn_RiskClassifierReact;

    private String listForms = "//li[@class='listViewItem']/a[contains(text(),'%s')]";

    private String formMenu = "//div[@id='divForms']//a[contains(text(),'%s')]/following-sibling::a[contains(text(),'%s')]";
    private String toolBar_FormName = "//div[@id='divTopBar']//div[contains(text(),'%s')]";

    public static String dataFieldsReact="//input[@data-dataitemid='%s' or @data-item-id='%s']";

    private String navBarSteps = "//span[contains(text(),'%s')]//following::span[contains(text(),'%s')]";

    private By firstRow = By.xpath("//div[@id='cols']/following-sibling::div/div");
    private By firstRow_React = By.xpath("//header[@id='dialogheader']/following-sibling::div//div[@class='customListRow ']");
    private By secondRow = By.xpath("(//div[@id='cols']/following-sibling::div/div)[3]");
    private By secondRow_React = By.xpath("//header[@id='dialogheader']/following-sibling::div//div[@class='customListRow ']");
    private By searchResults = By.xpath("//ul[@class='listView']/li");
    public DataEntryPage(WebDriver driver) {
        initElements(driver);
    }

    private void initElements(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}