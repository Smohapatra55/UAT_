package com.hexure.firelight.libraies.pages_react;

import com.hexure.firelight.libraies.FLUtilities;
import lombok.Data;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@Data
public class CommonMethods_ReactPage extends FLUtilities {

    public String mandetoryFormList="//li[@class='listViewItem']//a[contains(text(),'%s')]/following-sibling::a[@class='validation-summary-errors']";
    public String expandMandetoryFormList="//li[@class='listViewItem']//a[contains(text(),'%s')]/preceding-sibling::div";
    public String selectPageofForm = "//div[@id='divForms']//a[contains(text(),'%s')]/following-sibling::a";
    public String menuExpand = "//div[@id='divForms']//a[contains(text(),'%s')]";
    public String optionalFormList="//li[@class='listViewItem']//a[contains(text(),'%s')]/following-sibling::a[@class='blueLink']";
    public String formListOpen="//*[@id=\"OpenText\"]";
    public String formListCollapse="//*[@id=\"CloseText\"]";

    public String expandAllFormList="(//li[@class=\"listViewItem\"]//preceding-sibling::div)[position() > 1]";

    public String mandatoryFormListMVCForms ="//li[@class='listViewItem']//a[contains(text(),'%s')]";

    private By dataEntryPageHeaderMVC = By.xpath("//*[@id='imgClose']/following-sibling::div");
    private By dataEntryPageHeaderReact = By.id("root__wizardName");

    public static String preFilledFormInput = "//*[@data-item-id='%s']";

    public String requiredFieldsError="//*[@data-item-id=\"%s\" or @id=\"%s\"]/following-sibling::div[1]";

    public String dataEntryTextFields="//input[@title=\"%s\" or  @data-item-id=\"%s\" or @data-dataitemid='%s']";

    public String formCheckBox="//*[@title=\"%s\" or  @data-item-id=\"%s\"]";

    public String dataEntrySelectFields="//select[@title=\"%s\" or  @data-item-id=\"%s\"]";

    public String dialog_WindowName ="//*[@class='ui-dialog-title' and text()='%s']";

    public String btn_dialogWindowClose ="//*[@class='ui-dialog-title' and text()='%s']/..//button[@title=\"Close\"]";

    public String ariaLabelInputFields = "//*[@aria-label=\"%s\" or @id='%s']";

    public String titleFieldsAndButtons = "//*[@title=\"%s\"]";

    public static String verifyAndRemoveLink = "//*[contains(@class,\"blueLink noteText\") and text()='%s']";

    public static String windowCloseButton="//*[text()=\"%s\"]/..//*[@title=\"Close\"]";

    public static String areaLabelFields="//*[@aria-label='%s']";

    public static String link_toastPopUp="//*[contains(@class,'blueLink') and contains(text(),\"%s\")]";

    public static String alt_Field="//*[@alt='%s' or @aria-label='%s']";

    public static String verifyViewLink = "//td[contains(text(),'%s')]/ancestor::tr//div[@class='ITNavLinkText' and text()='View']";

    public static String verifyViewLinkReviewerPage = "//div[text()='%s']/parent::div//a[text()='View']";

    public static String verifyRemoveLinkReviewerPage = "//div[text()='%s']/parent::div//a[text()='Remove']";

    public static String verifyRemoveLink = "//td[contains(text(),'%s')]/ancestor::tr//div[@class='ITNavLinkText' and text()='Remove']";
    public static String verifyRemoveLink_MVC = "//div[contains(text(),'%s')]/ancestor::div//a[@class='blueLink noteText' and text()='Remove']";
    private By popup_ToastMVC = By.id("InitialMessage");

    @FindBy(xpath = "//div[.='Sign Application']")
    private WebElement btn_signApplication;

    @FindBy(id="buttonUpload")
    private WebElement buttonUpload;

    @FindBy(id="InitialMessage")
    private WebElement popup_Toast;

    @FindBy (xpath = "//button[contains(span,'Send Email Request')]")
    private WebElement btn_ReactSendEmailRequest;

    @FindBy (xpath = "//button[contains(span,'Generate Link Without Email')]")
    private WebElement btn_ReactGenerateLinkWithoutEmail;

    public static String menuListForm="//li[@class='listViewItem']//a[contains(text(),'%s')]";

    public static String btn_AnnuityWizard = "//button[@title='%s']";

    public static String checkBoxOwnership = "//div[@data-dataitemid='%s' and @class='ITCheckBoxContainer']";

    public static String txtAreaInput = "//textarea[@data-item-id='%s']";

    @FindBy(xpath = "//span[@id='divOutstandingRequestBody']//div")
    private WebElement toastPopup_ApplicationPending;

    private String btn_DocSign = "//span[@class='ITButtonText ']//span[contains(text(),'%s')]";

    public CommonMethods_ReactPage(WebDriver driver) {
        initElements(driver);
    }

    private void initElements(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }


}

