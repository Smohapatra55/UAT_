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
public class ExternalLoginPage extends FLUtilities {

    @FindBy(id = "Passcode")
    private WebElement txtBox_Passcode;

    @FindBy(xpath = "//div[@class='labelDiv']")
    private List<WebElement> ssnBirthDateElements;

    @FindBy(xpath = "//span[@class='left']")
    private WebElement passcodeElement;

    @FindBy(id = "SSN")
    private WebElement txtBox_SSN;

    @FindBy(xpath = "//table[@id='tableNav']//button")
    private WebElement textElement_AnnuiantSignDocumentset;

    @FindBy(id = "BirthDate")
    private WebElement txtBox_BirthDate;

    @FindBy(id = "cmdLoginPasscode")
    private WebElement btn_enterPasscode;

    @FindBy(id = "root__wizardName")
    private WebElement pageNameExternalLogin;

    @FindBy(id = "cmdLoginSSN")
    private WebElement btn_enterSsnDob;

    @FindBy(id = "cmdLoginPasscode")
    private WebElement btn_enter;

    @FindBy(id="cmdResendPasscode")
    private WebElement btn_ResendPasscode;

    @FindBy(id = "Passcode")
    private WebElement inputPasscode;

    @FindBy(xpath = "//button[text()='Enter']")
    private WebElement btn_EnterWelcome;

    @FindBy(xpath = "//button[text()='Sign Account Opening']")
    private WebElement clientProtectedWiz_field;

    @FindBy(xpath = "//a[@title='Close']")
    private WebElement icon_PopupCross;

    @FindBy(xpath = "//div[contains(@id,'toastid')]")
    private WebElement msg_toastBox;

    @FindBy(xpath = "//button[text()='Alerts']")
    private WebElement btn_Alert;

    @FindBy(xpath = "//div[@class='ITWizardErrorMenu shadow ']//li")
    private List<WebElement> list_AlertError;

    @FindBy(id="imgExpand")
    private WebElement icon_ExpandMenu;

    @FindBy(xpath = "//div[@class='navDrawer__bundleName']")
    private List<WebElement> list_ExpandForm;

    @FindBy(xpath = "//div[@class='navDrawer']")
    private WebElement menuContainerReact;

    @FindBy(xpath = "//li[@class='navDrawer__page navDrawer__page--selected ']//a[text()='New Page']")
    private WebElement expandPublicProtected_NewPage;

    @FindBy(id="Annuitant_FirstName")
    private WebElement annuitant_FirstName;

    @FindBy(id="Annuitant_LastName")
    private WebElement annuitant_LastName;

    @FindBy(id="Annuitant_SSN")
    private WebElement annuitant_SSN;

    @FindBy(xpath = "//div[text()='Client Protected Template Form']/parent::div//a/span")
    private WebElement btn_ClientPage;

    @FindBy(xpath = "//span[text()='Voided Check Upload']")
    private WebElement btn_VoidedCheckUpload;

    @FindBy(xpath = "(//a[@class='listViewItem-validation-error'])[2]")
    private WebElement alert_ErrorList;

    @FindBy(xpath = "//input[@data-dataitemid='Owner_Mobile_PhoneNumber']")
    private WebElement txt_OwnerPhoneNumber;

    @FindBy(xpath = "//input[@data-dataitemid='Owner_SSN']")
    private WebElement txt_OwnerSSNNumber;

    @FindBy(xpath = "//div[@class='eAppNavigationButtons eAppPanelShadow']//span[text()='Next']")
    private WebElement btn_Next;

    @FindBy(xpath = "//button[@class='linkFocus navActionBtn_Continue ']")
    private WebElement btn_SignAccountOpening;

    @FindBy(xpath = "//button[@class='linkFocus navActionBtn ']//span[@class='far fa-file-pdf navActionIconAdditional']")
    private WebElement btn_Print;

    @FindBy(xpath = "//div[@class='col-md-5' and contains(text(),'Protected')]")
    private List<WebElement> list_SelectPrintDocument;

    @FindBy(xpath = "//div[@class='col-md-5' and contains(text(),'Agent Protected')]//preceding-sibling::div//div[@role=\"checkbox\"]")
    private List<WebElement> listAgent_CheckBox;

    @FindBy(xpath = "//div[@class='col-md-5' and contains(text(),'Client Protected')]//preceding-sibling::div//div[@role=\"checkbox\"]")
    private List<WebElement> listClient_CheckBox;

    @FindBy(xpath = "//div[@class='col-md-5' and contains(text(),'Public Protected')]//preceding-sibling::div//div[@role=\"checkbox\"]")
    private List<WebElement> listPublic_CheckBox;

    @FindBy(xpath = "//span[text()='Print Selected Documents']")
    private WebElement doc_PrintSelected;

    @FindBy(xpath = "//span[text()='Lock Activity']")
    private WebElement btn_LockActivity;

    @FindBy(xpath = "//span[text()='Sign Activity']")
    private WebElement btn_SignActivity;

    @FindBy(id = "chkAgree")
    private WebElement checkBox_Agree;

    @FindBy(xpath = "//button[@type='button']//img[@alt='OK']")
    private WebElement btn_CongratulationOK;

    @FindBy(id = "SSN")
    private WebElement id_SSNWelcome;

    @FindBy(xpath = "//input[@id='BirthDate']")
    private WebElement birthDate_Welcome;

    @FindBy(xpath = "//*[@id='cmdLoginSSN' or @id='btnSendSMS']")
    private WebElement btn_SSNEnter;

    @FindBy(id = "lnkViewDoc")
    private WebElement btn_ReviewDocument;

    @FindBy(id = "tableNav")
    private List<WebElement> list_InsuredSignature;

    @FindBy(id="chkAgree")
    private WebElement checkBox_InsuredSignature;

    @FindBy(xpath = "//input[@name='BirthDate']")
    private WebElement txtBox_birthDate;

    @FindBy(xpath = "//input[@id='Passcode']")
    private WebElement txtBox_PasscodeOnWelcome;

    private By errorMsg_PasscodeInvalidMVC = By.id("lblError1");
    private By errorMsg_PasscodeInvalidMVC1 = By.id("lblError");
    private By errorMsg_PasscodeInvalidReact = By.id("//div[contains(@id,'lblError')]");
    private By errorMsg_PasscodeInvalidReact1 = By.xpath("//span[@class='outstandingRequestsDialog__ExpiredPasscodeText']");

    @FindBy(xpath = "//div[@class='roundCornersTop heading']")
    private WebElement header_ExternalLogin;

    private By txt_MessageResendpasscodeMVC = By.id("divEPassInfo");
    private By txt_MessageResendpasscodeReact = By.id("divEPass");

    @FindBy(xpath = "//div[@id='Main']/div")
    private WebElement msg_ThankYou;

    @FindBy(id="cmdResendPasscode")
    private List<WebElement> listbtn_ResendPasscode;

    @FindBy(xpath = "//p[contains(text(),'Document type already uploaded')]")
    private WebElement msg_DocTypeAlreadyUploaded;

    public String ariaLabelInputFields = "//*[@aria-label=\"%s\"]";

    @FindBy(xpath = "//div[contains(@id,'toastid')]")
    private List<WebElement> list_msgtoastBox;

    private By link_CancelMVC = By.xpath("//label[contains(@id,'lblError')]/following-sibling::a");
    private By link_CancelReact = By.xpath("//div[contains(@id,'divOutStandingRequestActions')]//a");

    private By icon_ExpandMenuMVC = By.id("imgExpand");

    public ExternalLoginPage(WebDriver driver) {
        initElements(driver);
    }

    private void initElements(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}



