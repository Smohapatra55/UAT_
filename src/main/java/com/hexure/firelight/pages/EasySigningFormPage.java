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
public class EasySigningFormPage extends FLUtilities {

    public static String buttonWithText = "//a[.='%s']";
    public static String btn_closeDocuments_MVC = "//span[.='Documents']/following-sibling::button[@title='Close']";
    public static String btn_closeDocuments_REACT = "//div[@aria-describedby='dialogDocuments']//button[@title='Close']";

    public static String buttonWithTextDisable = "//span[.='%s']";

    @FindBy(xpath = "//input[@data-item-id='FinInfo_Client_Income']")
    private WebElement txtBoxIncomeOfApplicant;

    @FindBy(xpath = "//input[@data-item-id='FinInfo_JointClient_Income']")
    private WebElement txtBoxIncomeOfJointApplicant;

    @FindBy(xpath = "//select[@data-item-id='FinInfo_Client_TaxBracket']")
    private WebElement selectList_TaxOfApplicant;

    @FindBy(xpath = "//select[@data-item-id='FinInfo_Client_TaxBracket']/option[@selected]")
    private WebElement TaxOfApplicantValue;

    @FindBy(xpath = "//select[@data-item-id='FinInfo_JointClient_TaxBracket']")
    private WebElement selectList_TaxOfJointApplicant;

    @FindBy(xpath = "//select[@data-item-id='FinInfo_JointClient_TaxBracket']/option[@selected]")
    private WebElement TaxOfJointApplicantValue;

    @FindBy(xpath = "//select[@data-item-id='Client_FinObj_Capital']")
    private WebElement selectList_prioritazationCapitalOfApplicant;

    @FindBy(xpath = "//select[@data-item-id='JointClient_FinObj_Capital']")
    private WebElement selectList_prioritazationCapitalOfJointApplicant;

    @FindBy(xpath = "//a[.='Display/Print PDF']")
    private WebElement btn_displayPrintPdf;

    @FindBy(xpath = "//a[.='Attach Documents']")
    private WebElement btn_attachDocuments;

    @FindBy(id = "File")
    private WebElement fileDrop;

    @FindBy(id = "buttonUpload")
    private WebElement btn_upload;

    @FindBy(xpath = "//a[.='View']")
    private WebElement link_view;

    @FindBy(xpath = "//a[.='Remove']")
    private WebElement link_remove;

    @FindBy(xpath = "//div[@aria-describedby='dialogDocuments']//span[contains(.,'Documents')]/following-sibling::button[@title='Close' or contains(@class,'close')]")
    private WebElement btn_closeReviewerDocuments;

    @FindBy(xpath = "//a[.='Complete/Log Off']")
    private WebElement btn_completeLogOff;

    @FindBy(xpath = "//a[@id='buttonAttachDocs']")
    private WebElement btn_attachmentDocuments;

    @FindBy(xpath = "//button[.='Submit and logoff']")
    private WebElement btn_submitAndLogOff;

    @FindBy(xpath = "//button[.='Save - Finish later']")
    private WebElement btn_saveFinishlater;

    @FindBy(id = "imgNext")
    private WebElement btn_continue;

    @FindBy(xpath = "//div[@class='small-notice-text']")
    private WebElement txt_CompleteActivity;

    @FindBy(xpath = "(//button[@title='Close'])[3]")
    private WebElement btn_cross;

    @FindBy(xpath = "//img[@alt='Received']")
    private List<WebElement> list_tickMark;

    private By msg_DocumentTypeMVC = By.xpath("//form[@id='uploadForm']//p");
    private By msg_DocumentTypeReact= By.xpath("//p[@class='SupplementNote']");

    private String uploadedFileName = "//div[contains(text(),'%s')]/preceding-sibling::div";
    private String uploadedFileNameReact = "//td[contains(text(),'%s')]/preceding-sibling::td";
    private String uploadedFileName1 = "//div[contains(text(),'%s')]/preceding-sibling::div[text()='%s']";
    private String uploadedFileNameReact1 = "//td[contains(text(),'%s')]/preceding-sibling::td[text()='%s']";
    private String uploadedFileSize = "//div[contains(text(),'%s')]/following-sibling::div";
    private String uploadedFileSizeReact = "//td[contains(text(),'%s')]/following-sibling::td";
    private String uploadedFileSize1 = "(//div[contains(text(),'%s')]/preceding-sibling::div[text()='%s']/following-sibling::div)[2]";
    private String uploadedFileSizeReact1 = "(//td[contains(text(),'%s')]/preceding-sibling::td[text()='%s']/following-sibling::td)[2]";

    private String uploadedFileSizeMVC = "//div[contains(text(),'%s')]/following-sibling::div[2]";

    @FindBy(xpath = "//div[contains(text(),'Total Size:')]/following-sibling::div")
    private WebElement totalSize;

    @FindBy(xpath = "(//td[contains(text(),'Total Size')]/following-sibling::td)[2]")
    private WebElement totalSizeReact;

    @FindBy(xpath = "//div[contains(text(),'Remaining Size:')]/following-sibling::div")
    private List<WebElement> list_RemainingSize;

    @FindBy(xpath = "//td[contains(text(),'Remaining Size')]")
    private List<WebElement> list_RemainingSizeReact;

    @FindBy(xpath = "//div[@id='docList']/div/div[contains(@class,'docName')]")
    private List<WebElement> list_fileNames;

    @FindBy(xpath = "//div[@class='ITDialog__content ']//td[1]")
    private List<WebElement> list_reactFileNames;

    private By totalSizeReactBy = By.xpath("(//td[contains(text(),'Total Size')]/following-sibling::td)[2]");

    private By totalSizeBy = By.xpath("//div[contains(text(),'Total Size:')]/following-sibling::div");
    public EasySigningFormPage(WebDriver driver) {
        initElements(driver);
    }

    private void initElements(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}
