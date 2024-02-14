package com.hexure.firelight.pages;

import com.hexure.firelight.libraies.FLException;
import com.hexure.firelight.libraies.FLUtilities;
import lombok.Data;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

@Data
public class CommonMethodsPage extends FLUtilities {
    public static String optionalForms = "//*[@id='optionalFormsHeader']/..//*[text()='%s']/ancestor::tr//input[@type='checkbox']";
    public static String optionalForms_SelectForm = "//strong[text()='%s']/ancestor::div[@class='row optionalForms_formRow ']//div[@role='checkbox']";

    public static String anchorLinks = "//*[text()='%s']";

    public static String tabWithGreenTickMark = "//*[text()='%s']/..//*[contains(@class,'navDisplay_RightIcon_Complete')] | //*[@id='%s' and contains(@class,'bgCanvas roundCornersRight status_past')]";

    @FindBy(id = "sigBox")
    private WebElement sigBox;

    @FindBy(className = "signatureImage")
    private WebElement signatureImage;

    @FindBy(xpath = "(//*[@class='signatureImage'])[2]")
    private WebElement TrusteeSignImage;

    @FindBy(xpath = "(//*[@class='signatureImage'])[3]")
    private WebElement AgentSignImage;

    @FindBy(xpath = "//div[@id='InitialMessage']/div")
    private WebElement popUpMessage;


    public static String currentTab = "//*[text()='%s']/..//*[contains(@class,'navDisplay_LeftIcon_Outer_Current')]";

    public static String ITButtonInput = "//*[@class='ITButtonInput  ']//span[text()='%s']";

    public static String preFilledFormInput = "//*[@data-dataitemid='%s']//input";

    public static String preFilledFormInputForm = "//*[@data-item-id='%s']";


    public static String verifyAndRemoveLink = "//*[@class='ITNavLinkText' and text()='%s']";

    public static String ariaLabelInputFields = "//*[@aria-label=\"%s\"]";

    public static String select_Field = "//select[@title=\"%s\"]";

    public static String selectDocumentType = "//select[@title='%s' or @aria-label='%s' or @data-dataitemid='%s' or @data-item-id='%s' or @id='%s' or @name='%s']";

    @FindBy(id = "City")
    private WebElement nameCity;

    @FindBy(id = "SignerFullName")
    private WebElement nameSigner;

    private By icon_closeToastMessageMVC = By.xpath("//*[@class=\"toast info\"]//*[@aria-label=\"Close\"]");
    private By icon_closeToastMessageReact = By.xpath("//a[contains(text(),'[Close]')]");

    @FindBy(xpath = "//button[contains(@class,'ITButtonBack')]//span[text()='Previous']")
    private WebElement btn_Previous;

    private By dialog_WindowNameMVC = By.id("dialogheader");
    private By dialog_WindowNameReact = By.xpath("//*[@class='ui-dialog-title' and text()='Documents']");
    private By dialog_WindowName = By.xpath("//div[@id='divPackageUpdateMessage']/b");

    @FindBy(id = "lblPendingRequest")
    private WebElement dialog_WindowName_PendingRequest;

    @FindBy(xpath = "//*[@id='ToggleMessagesLink']")
    private WebElement redColorErrorValidationBubble;

    @FindBy(id = "dragText")
    private WebElement fileUploadDragAndDrop;

    @FindBy(id = "File")
    private WebElement fileDrop;

    @FindBy(id = "dropFileErrMsg")
    private WebElement box_FileUpload;

    @FindBy(id = "buttonUpload")
    private WebElement btn_upload;

    private By popup_ToastMVC = By.xpath("//*[@class='toast info']");
    private By popup_ToastReact = By.xpath("//div[@id='divStatusNotice']//strong");

    @FindBy(xpath = "//*[@class=\"auditDisplayStatus\"]/following-sibling::strong")
    private List<WebElement> auditDisplayStatus;

    @FindBy(xpath = "//*[@class=\"auditDisplayStatus\"]/../..//*[contains(@style,\"display\")][2]")
    private List<WebElement> auditDisplayDesc;

    @FindBy(xpath = " //*[@aria-describedby=\"dialogHistory\"]//*[@type=\"button\"]")
    private WebElement tab_HistoryCloseButton;

    @FindBy(xpath = "//div[@class='ITDialog__box ']/header[@id='dialogheader']")
    private WebElement header_PendingReq;

    @FindBy(xpath = "//button[text()='Sign Application']")
    private WebElement btn_SignApplication;

    public String radioButton = "//*[@class='ITPanelTitleText' and text()='%s']/../parent::div[@class=\"ITPanel\"]//*[@title=\"%s\"]";

    public String YesNoRadioButton = "//*[@class='ITPanelTitleText' and text()='%s']/../parent::div[@class=\"ITPanel\"]//*[@title=\"%s\"]/../../..//*[@title=\"%s\"]";

    public String requiredFieldsError = "//*[@data-dataitemid=\"%s\" or @title=\"%s\"]/../..//*[@class=\"errorText\"]";

    public String dataEntryTextFields = "//input[@title=\"%s\" or @data-dataitemid=\"%s\" or @aria-label='%s']";

    public String errorMessage = "//div[contains(text(),\"%s\") and contains(@class,'validation-message-error')]";

    public String errorMessage_React = "//span[@class='validationText' and contains(text(),'%s')]";

    @FindBy(xpath = "//*[@class='ITButtonInput  ']//span[text()='Next']")
    private WebElement btn_Next;

    @FindBy(id="imgOpenWiz")
    private WebElement btn_Expand;

    @FindBy(id="imgMessage")
    private WebElement btn_Notifications;

    @FindBy(xpath="//a[@aria-label='Back Button']")
    private WebElement btn_Back;

    @FindBy(xpath = " //*[@aria-describedby=\"dialogHistory\"]//*[@type=\"button\"]")
    private WebElement historyTabCloseButton;

    public String fieldWithTitleAttribute = "//*[@title=\"%s\"]|//*[@aria-label=\"%s\"]";

    public String checkBox = "//*[@class='ITCheckBoxInput']/..//*[text()='%s']";

    public String formCheckBox = "//*[@title=\"%s\" or  @data-dataitemid=\"%s\"]";

    public String formCheckBox_Mvc = "//*[@title=\"%s\" or  @data-item-id=\"%s\"  or @data-dataitemid=\"%s\"]";

    @FindBy(xpath = "(//*[@class='ITButtonText ']/span[text()='Decline E-Signature'])[2]")
    private WebElement btn_DeclineEsignature;

    @FindBy(id = "CopyAsIsButton")
    private WebElement btn_CopyAsIs;

    @FindBy(id = "CopyWithChangesButton")
    private WebElement btn_CopyWithChanges;

    public String dataEntrySelectFields = "//select[@title=\"%s\" or  @data-item-id=\"%s\" or @data-dataitemid=\"%s\"]";

    @FindBy(xpath = "//strong[text()='Request:']/parent::td/following-sibling::td/strong")
    private List<WebElement> list_status;

    private By btn_CrossRequestMVC = By.xpath("//span[contains(@id,'ui-id') and text()='Requests']/following-sibling::button");
    private By btn_CrossRequestReact = By.xpath("(//span[contains(@id,'ui-id')]/following-sibling::button)[2]");

    @FindBy(xpath = "(//button[@class='blackButton roundCorners shadow'])[3]")
    private WebElement btn_CancelRequest;

    @FindBy(id = "popup_cancel")
    private WebElement btn_PopNo;

    @FindBy(id = "dropFileErrMsg")
    private List<WebElement> list_msgFileUpload;

    @FindBy(xpath = "//label[text()='Exit']//ancestor::button")
    private WebElement btn_Exit;

    @FindBy(xpath = "//button[contains(text(),'Application')]")
    private WebElement btn_IllustrationApplication;

    @FindBy(id = "annot-area")
    private List<WebElement> txt_canvas;

    @FindBy(xpath = "//div[@class='toast info']")
    private List<WebElement> list_popupToastWrapper;

    @FindBy(xpath = "//div[@id='tSizeText']")
    private WebElement totalSizeValue;

    @FindBy(xpath = "//td[contains(text(),'Total Size')]/following-sibling::td/following-sibling::td")
    private WebElement totalSizeValueReact;

    @FindBy(xpath = "//span[contains(text(),'Risk Classifier Results')]")
    private WebElement txt_RiskWrapper;

    private By btn_AdvanceSearchMVC = By.id("advanceSearchbtn");
    private By btn_AdvanceSearchReact = By.id("advancedbutton");

    @FindBy(id = "AppName")
    private WebElement txt_activityTypeName;

    @FindBy(id = "cmdSave")
    private WebElement btn_save;

    @FindBy(xpath = "//a[text()='Fees and Expense Disclosure Sample ']")
    private WebElement option_feesAndExpense;

    @FindBy(xpath = "//li[@class='listViewItem']/a")
    private List<WebElement> list_expandForm;

    @FindBy(xpath = "(//ul[@class='listView'])[2]")
    private WebElement menuContainer;

    public String nonQualified= "//div[@data-dataitemid='%s']//div[@class='ITCheckBoxInput']//div[@aria-checked]";

    public static String optionsFormMenu = "//input[@aria-label='%s']";

    public static String btn_SelectFormsOption = "//td[contains(text(),'%s')]";

    public static String checkBoxOptionalForms = "//strong[text()='%s']/ancestor::div[contains(@class,'row optionalForms_formRow ')]//div[@role='checkbox']";

    public static String checkBoxOwnershipMVC = "//div[@data-item-id='%s']";

    public static String txtAreaInput_MVC = "//textarea[@data-item-id='%s']";

    public static String btn_Upload = "//button[@class='ITButtonInput ITButtonDisabled ']//span[contains(text(),'%s')]";
    public static String btn_UploadNew = "//button[contains(@class,'ITButtonInput ITButtonDisabled')]//span[contains(text(),'%s')]";
    public static String btn_UploadEnabled = "//span[@class='ITButtonText ']//span[contains(text(),'%s')]";

    public static String btn_openApplication = "(//button[@title='%s'])[1]";

    private String msg_ErrorMessageDropDown = "//select[@id='%s' or @data-dataitemid='%s']/parent::div//span[@class='validationText']";
    private String msg_ErrorMessageRadioButton = "//div[@data-dataitemid='%s']/div/div[@title='%s']/ancestor::div[@class='componentWrapper ']//span[@class='validationText']";
    private String elementByIdOrDataItemId="//select[@data-dataitemid ='%s' or @data-item-id=\"%s\" or @id=\"%s\"]";

    @FindBy(xpath = "//span[text()='Create Activity']")
    private WebElement heading_CreateActivity;

    private String radioBtn_AsPerDataItemId = "//div[@data-dataitemid='%s']/div/div[@title='%s']";

    @FindBy(xpath = "//strong")
    private List<WebElement> list_forms;
    private String text_OptionalForms = "//strong[normalize-space()='%s']";

    private  String dataFieldsMVC="//input[@data-dataitemid='%s' or @id='%s']";
    private  String dataFieldsSelectTag="//select[@data-dataitemid='%s' or @id='%s']";
    private String msg_ErrorMessageTextBox ="//input[@data-dataitemid='%s' or @id='%s']/ancestor::div[@class='componentWrapper ']//div//span[@class='validationText']";
    public static String chk_Option = "//label[text()='%s']//parent::div//preceding-sibling::div//div[contains(@class,'ITCheckBox   ')]";
    private String chkBox_ByDataItemId = "//div[@data-dataitemid='%s']//div[@role]";
    private String chkBox_ByDataItemIdAndTitle = "//div[@data-dataitemid='%s']//div[@title='%s']";
    private String stringElement="//div[text()='%s']//..//..//*[@title='%s']";
    public String requiredFieldError = "//div[@title='%s']//ancestor::div[@class='ITComponent']//div[contains(@class,'errorText')]";
    public static String radio_Option = "//div[@title='%s']//ancestor::div[@class='row baselineAlign']//div[@title='%s']";
    @FindBy(xpath = "//div[contains(text(),'Agent Information')]")
    private WebElement agent_Information;

    @FindBy(className = "react-datepicker-popper")
    private WebElement datePicker;
    private String elementByDataItemId="//select[@data-dataitemid=\"%s\"]";

    @FindBy(xpath = "//div[@class='autocompleteResultItem autofill-result-item']")
    private List<WebElement> list_MailingAdress;
    @FindBy(xpath = "//div[text()='Joint Annuitant Information']")
    private List<WebElement> list_JointAnnuitant;

    public String datePickerPop = "//div[contains(@class,'react-datepicker')]/div[@data-dataitemid='%s']";

    @FindBy(id="StatusBar_Complete")
    private WebElement tost_popupbox;

    private By icon_closeTostPopupboxMVC = By.xpath("//a[@title='Close']");
    public CommonMethodsPage(WebDriver driver) {
        initElements(driver);
    }
    private void initElements(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}

