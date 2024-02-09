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
public class CreateApplicationPage extends FLUtilities
{
    private By btn_Submit = By.xpath("//span[text()='Submit']");
    private By btn_Submit1 = By.id("submitModal");
    private By btn_Submit2 = By.id("buttonVerifySubmit");
    public String formListOpen="//*[@class='ITWizardPageName']";
    public By btn_ExpandReact = By.id("imgOpenWiz");
    public By btn_ExpandMVC = By.id("imgExpand");

    @FindBy(id="Jurisdiction")
    private WebElement dd_Jurisdiction;

    @FindBy(id="ProductType")
    private WebElement dd_ProductType;

    @FindBy(xpath = "//select[@aria-label='Default Product Type']")
    private WebElement dd_DefaultProduct;

    @FindBy(xpath="//div[@id='divProducts']/a/div[3]")
    private List<WebElement> list_Products;

    @FindBy(id="buildNew")
    private WebElement btn_Create;

    @FindBy(id="buttonSave")
    private WebElement btn_Save;

    @FindBy(id="txtAppName")
    private WebElement txtBox_newAppName;

    @FindBy(id="AppName")
    private WebElement txtBox_newIllustrationName;

    @FindBy(xpath="//button[@id='cmdSave' or @id='cmdCreate']")
    private WebElement btn_CreateActivity;

    @FindBy(id="imgNext")
    private WebElement btn_Continue;

    @FindBy(xpath="//div[@id='navigationButtonsContainer' or @class='navigationButtonsContainer']//span[text()='Next']")
    private WebElement btn_Next;

    @FindBy(xpath="//div[@id='navigationButtonsContainer']//span[text()='Previous']")
    private WebElement btn_Previous;

    @FindBy(xpath="(//button[@type='button'])[1]")
    private WebElement btn_OK;

    @FindBy(xpath="//div[@id='InitialMessage']/div")
    private WebElement msg_ApplicationFinishToastPopup;

    @FindBy(xpath="//div[@id='InitialMessage']/following-sibling::a")
    private WebElement link_Close;

    private By btn_BackToAppMVC = By.xpath("//*[@aria-label='Back to Application']");
    private By btn_BackToAppReact = By.xpath("//a[text()='Back to Application']");

    private By btn_OtherActionsMVC = By.id("toolbar_OtherActions");
    private By btn_OtherActionsReact = By.id("toolbar_OtherActions_image");

    @FindBy(id="lblPercent")
    private WebElement btn_DataPercentage;

    @FindBy(id="popup_ok")
    private WebElement btn_PopOk;

    @FindBy(id="popup_cancel")
    private WebElement btn_PopCancel;

    @FindBy(id="headerCreateNew")
    private WebElement txt_createNewApplicationwindow;

    @FindBy(xpath = "//*[@class='ITWizardPageName']")
    private WebElement WizardPageNameExpand;

    @FindBy(xpath = "//div[@id='divProducts']//div[@aria-label='Annuity,']")
    private List<WebElement> listAnnuityTxt;

    @FindBy(xpath = "//a[contains(@class,'listProd')]//div[2]")
    private List<WebElement> listCarriers;

    @FindBy(xpath = "//div[@id='divProducts']//div[@class='blueText']")
    private List<WebElement> listProductsTxt;

    @FindBy(id = "ProductTypeId")
    private WebElement dd_DefaultProductType;

    public static String mandetoryFormList="//*[@class=\"navDrawer__bundleName\" and text()=\"%s\"]/..//*[@class=\"far fa-exclamation-triangle navDrawer__pageGraphic validation-summary-errors\"]/../..";

    public String optionalFormList="//*[@class=\"navDrawer__bundleName\" and text()=\"%s\"]/..//*[@class=\"far fa-file navDrawer__pageGraphic \" or @class=\"fas fa-file-alt navDrawer__pageGraphic \"]/../..";

    public static String wizardNamePage="//div[@class='navDrawer']//div[contains(text(),'%s')]/parent::div//li[contains(@title,'%s')]//span";

    private String formName1="//div[@title='%s']/following-sibling::li[@title='%s']/a";
    private String formName2="//div[@title='%s']/parent::div/following-sibling::div/li[@title='%s']/a";
    private String formName3="//div[@title='%s']/following-sibling::ul//li[@title='%s']/a";
    private String formName4="//div[@title='%s']/following-sibling::ul//li[@title='%s']";
    private String mainFormName="//div[@title='%s']";

    public By WizardPageNameExpandmvc = By.xpath("//*[@class='ITWizardPageName']");

    public CreateApplicationPage(WebDriver driver)
    {
        initElements(driver);
    }

    private void initElements(WebDriver driver)
    {
		PageFactory.initElements(driver, this);
    }
    @FindBy(id = "SignTypes")
    private WebElement dd_SignatureType;

    @FindBy(id = "advanceSearchbtn")
    private WebElement btn_AdvancedSearch;

    public String btn_SearchCriteriaDuration="//*[@id=\"%s\"]";

    @FindBy(xpath = "//input[@id='month']")
    private WebElement btn_Month;

    @FindBy(id = "userId")
    private WebElement dd_User;

    @FindBy(id = "activityType")
    private WebElement dd_ActivityType;

    @FindBy(xpath = "//select[@id='stType' or @id='statusType']")
    private WebElement dd_Status;

    @FindBy(id = "sortBy")
    private WebElement dd_Sort;

    @FindBy(xpath = "//*[@id='ApplicationName']")
    private WebElement txtbox_ActivityName;

    @FindBy(xpath = "//*[@id='FLI_TELESIGN_APP_ID']")
    private WebElement txtbox_TeleSignName;

    @FindBy(xpath = "//*[@id='FLI_ISSUED_STATE_ABBREV']")
    private WebElement txtbox_IssueState;

    @FindBy(xpath = "//*[@id='FLI_CONFIRMATION_NUMBER']")
    private WebElement txtbox_PolicyNumber;

    @FindBy(xpath = "//*[@id='FLI_PRODUCT_NAME']")
    private WebElement txtbox_ProductName;

    @FindBy(xpath = "//*[@id='OSJBeginDate']")
    private WebElement txtbox_BeginDate;

    @FindBy(xpath = "//*[@id='SJEndDate']")
    private WebElement txtbox_EndDate;

    @FindBy(id = "productTypeFilter")
    private WebElement dd_ProductTypeList;

    @FindBy(xpath = "//select[@id='productTypeFilter']//option")
    private List<WebElement> dd_ProductTypeValue;

    @FindBy(xpath = "//td//div[contains(text(),'User')]")
    private WebElement txt_User;

    @FindBy(xpath = "//td//div[contains(text(),'Activity Type')]")
    private WebElement txt_ActivityType;

    @FindBy(xpath = "//input[@id='OSJBeginDate']")
    private WebElement txt_BeginDate;

    @FindBy(xpath = "//input[@id='OSJEndDate']")
    private WebElement txt_EndDate;

    @FindBy(xpath = "//div[normalize-space()='Sort']")
    private WebElement txt_Sort;

    @FindBy(xpath = "//div[normalize-space()='Signature Type']']")
    private WebElement txt_SignType;

    @FindBy(xpath = "//div[normalize-space()='Signature Type']")
    private WebElement txt_PolicyNumber;

    @FindBy(xpath = "//div[normalize-space()='Issue State']")
    private WebElement txt_IssueState;

    @FindBy(xpath = "//div[normalize-space()='Policy Name']")
    private WebElement txt_PolicyName;

    @FindBy(xpath = "//div[normalize-space()='Activity Name'")
    private WebElement txt_ActivityName;

    @FindBy(xpath = "//*[@name='duration']")
    private List<WebElement> dd_PrdctType;

    @FindBy(id="dateFilter_Week")
    private WebElement txt_Week;
    @FindBy(id="dateFilter_Month")
    private WebElement txt_Month;
    @FindBy(id="dateFilter_Quarter")
    private WebElement txt_Quarter;
    @FindBy(id="dateFilter_YTD")
    private WebElement txt_YTD;
    @FindBy(id="dateFilter_All")
    private WebElement txt_All;
    @FindBy(xpath="//input[@id='searchString']")
    private WebElement txt_SearchString;
    @FindBy(xpath="//select[@id='savedrp']")
    private WebElement select_AdvanceSearch;
    @FindBy(id="exportActitivitiesbutton")
    private WebElement txt_Export;
    @FindBy(xpath="//select[@id='drpUser']")
    private WebElement select_UserSelect;
    @FindBy(xpath="//select[@id='drpTransType']")
    private WebElement select_ActivityType;
    @FindBy(xpath = "//select[@id='drpStatus']")
    private WebElement select_Status;
    @FindBy(xpath="//select[@id='drpSort']")
    private WebElement select_Sort;

    @FindBy(xpath="//a[@aria-label='Page 2']")
    private WebElement txt_PageLinks;

    @FindBy(xpath = "//div[@class='roundCornersTop heading recentapp']//label[@tabindex='0']")
    private List<WebElement> list_Sort;

    @FindBy(xpath = "//select[@id='drpSort']//option")
    private WebElement dd_SortValue;

    @FindBy(id="productTypeFilter")
    private WebElement dd_ProductTypeFilter;

    @FindBy(xpath = "//div[@class='panelContent']//strong[text()='Last Audit Entry:']")
    private List<WebElement> txt_dateandTime;

    @FindBy(xpath = "//*[@class='blueDropdown']")
    private List<WebElement> list_dropDown;

    @FindBy(id = "signTypes")
    private WebElement ddown_signatureType;

    @FindBy(xpath = "//*[@name='SaveAdvanceSearch.duration']")
    private List<WebElement> dd_ReviewProductType;

    @FindBy(xpath = "//select[contains(@name,'SaveAdvanceSearch')]")
    private List<WebElement> list_ReviewDropDown;


    @FindBy(xpath = "//select[@aria-label='Default Jurisdiction']")
    private WebElement dd_DefaultJurisdiction;

    @FindBy(xpath = "//div[@id='readOnly']//div[@class='checkbox__box']")
    private WebElement checkboxReadOnly;

    public String  list_OfProducts = "//div[@id='divProducts']/a//div[contains(text(),'%s')]";

    public String txt_AllInputField= "//*[@id='%s']";
}
