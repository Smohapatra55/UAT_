package com.hexure.firelight.pages;

import com.hexure.firelight.libraies.FLUtilities;
import lombok.Data;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.FindAll;
import java.util.List;

@Data
public class ReviewQueuePage extends FLUtilities
{
    @FindBy(xpath="//div[@id='divQueues']//a/span")
    private List<WebElement> listReviewQueue;

    @FindBy(xpath="//button/img[@id='imgSearchQueue']")
    private WebElement btn_searchIcon;

    @FindBy(xpath="//input[contains(@id,'reviewbtn')]")
    private WebElement btn_Review;

    @FindBy(id="txtsearch")
    private WebElement txtBox_Search;

    @FindBy(id="search")
    private WebElement txtBox_SearchHidden;

    @FindBy(id="popup_ok")
    private WebElement btn_PopOk;

    @FindBy(id="popup_cancel")
    private WebElement btn_PopCancel;

    @FindBy(xpath="//button[@aria-label='Unlock Application']")
    private WebElement btn_UnlockApplication;

    @FindBy(xpath="//button[@aria-label='Approve Application']")
    private WebElement btn_ApproveApplication;

    private By btn_ReviewerDocumentsMVC = By.xpath("//a[@aria-label='Reviewer Documents']");
    private By btn_ReviewerDocumentsReact = By.xpath("//button[@aria-label='Reviewer Documents']");

    @FindBy(xpath="//button[@aria-label='Reject Application']")
    private WebElement btn_RejectApplication;

    @FindBy(id="txtActionRemarks")
    private WebElement txtBox_ActionRemarks;

    @FindBy(xpath="//a[@aria-label='History List']")
    private WebElement tab_History;

    @FindBy(xpath="//a[@aria-label='Reviewers List']")
    private WebElement tab_Reviewers;

    @FindBy(xpath="//a[@aria-label='Overall Report List']")
    private WebElement tab_OverallReport;

    @FindBy(xpath="//a[@title='DSB']")
    private WebElement tab_DSB;

    @FindBy(xpath="//a[@title='PreSubmit']")
    private WebElement tab_PreSubmit;

    @FindBy(xpath="//div[@id='divReviewers']//span")
    private WebElement tab_ReviewersSub;

    @FindBy(xpath="//div[@id='OSJResultStatus']")
    private WebElement txt_RedStatus;

    @FindBy(xpath="//a[@aria-label='Summary List']")
    private WebElement tab_Summary;

    @FindBy(xpath = "//a[contains(text(),'Application PDF')]")
    private WebElement link_ApplicationPDF;

    @FindBy(xpath = "//button[contains(text(),'More Info')]/preceding-sibling::button[contains(text(),'Approve')]")
    private WebElement btn_Approve;
    @FindBy(xpath = "//button[contains(text(),'More Info')]/preceding-sibling::button[contains(text(),'Reject')]")
    private WebElement btn_Reject;

    private By tab_LogOffMVC = By.xpath("//div[text()='Log Off']");
    private By tab_LogOffReact = By.xpath("//a[text()='Log Off']");

    @FindBy(xpath = "//a[contains(@class,'queue recent') and contains(@title,'RQ1')]")
    private WebElement rq1Queues;

    @FindBy(xpath = "//a[text()='Home']")
    private WebElement tab_Home;

    @FindBy(id = "Main")
    private WebElement thankYouLogOffPage;

    @FindBy(xpath="//button[@aria-label='More Info Application']")
    private WebElement btn_MoreInfo;

    private By heading_PageMVC = By.id("lblOSJ");
    private By heading_PageReact = By.xpath("//section[@id='main']//div[@class='roundCornersTop heading']/span");

    @FindBy(id="lblHeader")
    private WebElement heading_SubPage;

    @FindBy(xpath = "//tr/td/strong[@style]")
    private WebElement productname;

    @FindBy(xpath = "//td[@style]/a")
    private List<WebElement> list_linksPreSubmit;

    @FindBy(xpath = "//td[@style]/div[contains(@id,'chk')]")
    private WebElement chkbox_Master;

    @FindBy(id = "popup_title")
    private WebElement titlePopup;

    @FindBy(xpath = "//div[@id='popup_message']/strong")
    private WebElement messageNameProduct;

    @FindBy(xpath = "//div[@id='divUpdate']/div/div[@class='red']")
    private WebElement activityCount;

    @FindBy(xpath = "//a[@title='View Audit']/strong")
    private WebElement linkMsg_PreSubmitSubPage;

    @FindBy(xpath = "//a[@title='View Audit']/span")
    private WebElement icon_InfoPreSubmitSubPage;

    @FindBy(xpath = "//strong[contains(text(),'HISTORY')]/parent::div//div/strong[contains(text(),'Request More Info')]/parent::div/parent::div//div/p/span")
    private WebElement txt_RemarksRequestMoreInfo;

    @FindBy(xpath = "//img[@alt='Close']")
    private WebElement btn_closeQueueHistory;

    private By heading_ReviewerDocumentsMVC = By.id("dialogheader");
    private By heading_ReviewerDocumentsReact = By.xpath("(//span[contains(@id,'ui-id-')])[3]");

    @FindBy(xpath = "(//span[contains(@id,'ui-id-')])[4]")
    private WebElement heading_ClientVerification;

    @FindBy(xpath = "//select[@id='ddlDocType']/option[@selected]")
    private WebElement defaultValue_documentType;

    @FindBy(id = "File")
    private WebElement fileDrop;

    @FindBy(xpath = "(//button[@type='button'])[3]")
    private WebElement btnCancel_FileUploadPopup;

    @FindBy(xpath = "//div[@class='roundCornersTop heading']/div")
    private WebElement heading_SubPageDocumentReview;

    @FindBy(id = "historyHeading")
    private WebElement heading_HistoryPopup;

    @FindBy(xpath = "//span[contains(text(),'Reviewer_Comments')]")
    private WebElement txt_ReviewerComment;

    @FindBy(xpath = "//span[contains(text(),'First Name')]")
    private WebElement txt_ReviewerFirstName;

    @FindBy(xpath = "//span[contains(text(),'Reviewer_Name')]")
    private WebElement txt_ReviewerName;

    @FindBy(id = "osj_recall")
    private WebElement btn_Recall;

    @FindBy(xpath = "//img[@alt='Lock']/following-sibling::strong[1]")
    private WebElement msg_Locked;

    @FindBy(xpath = "//select[contains(@id,'drpAvailQueue')]")
    private WebElement drodown_SelectQueue;

    @FindBy(xpath = "//button[contains(@id,'buttonAssignQueue')]")
    private WebElement btn_MoveToQueue;

    @FindBy(xpath = "//select[contains(@id,'drpAvailReviewers')]")
    private WebElement drodown_SelectReviewer;

    @FindBy(xpath = "//select[contains(@id,'drpAvailReviewers')]/option")
    private List<WebElement> list_optionReviewer;

    @FindBy(xpath = "//button[contains(@id,'buttonAssignReviewer')]")
    private WebElement btn_AssignReviewer;

    @FindBy(id = "btnView")
    private WebElement btn_View;

    @FindBy(xpath = "(//span[contains(@id,'ui-id')]/following-sibling::button)[2]")
    private WebElement btn_CrossReviewPopup;

    @FindBy(xpath = "//a[@aria-label='Reviewers List']/parent::div//a")
    private List<WebElement> list_linkReviewers;

    private String msg_LockReviewPage = "//strong[text()='%s']/following-sibling::strong";

    private String remarksBasedOnUsername = "//strong[text()='User Name: Sunil_ FLADEMO_Auto']/following-sibling::p";

    @FindBy(xpath = "//span[contains(@id,'ui-id-6')]")
    private WebElement heading_ActivitySummary1;

    @FindBy(xpath = "//span[contains(@id,'ui-id-4')]")
    private WebElement heading_ActivitySummary2;

    @FindBy(xpath = "//span[contains(@id,'ui-id-6')]/following-sibling::button")
    private WebElement icon_CrossActivitySummary1;

    @FindBy(xpath = "//span[contains(@id,'ui-id-4')]/following-sibling::button")
    private WebElement icon_CrossActivitySummary2;

    @FindBy(xpath = "//div[@id='divMass']/following-sibling::strong")
    private WebElement msg_SearchError;

    @FindBy(xpath = "//span[contains(@id,'ui-id-5')]")
    private WebElement heading_ActivitySummary3;

    @FindBy(xpath = "//span[contains(@id,'ui-id-5')]/following-sibling::button")
    private WebElement icon_CrossActivitySummary3;

    @FindBy(xpath = "//td/strong[@style]")
    private List<WebElement> list_ApplicationName;

    @FindBy(xpath = "//div[@class='center']/*")
    private List<WebElement> list_PaginationLink;


    @FindBy(id = "lnkClear")
    private WebElement icon_clear;

    @FindBy(xpath = "//td[@style]/div[contains(@id,'chk')]")
    private List<WebElement> list_ChkboxMaster;

    @FindBy(xpath = "//span[contains(text(),'RQ1 ')]")
    private WebElement link_RQ1;

    @FindBy(xpath = "//div[@id='divUpdate']//div[@class='red']")
    private WebElement value_Colour;

    public String list_productContent= "//td//strong[contains(text(),'%s')]";

    private String btnRejectWithAppName = "//td/strong[text()='%s']/parent::td/parent::tr/parent::tbody//button[contains(text(),'More Info')]/preceding-sibling::button[contains(text(),'Reject')]";
    private String btnReviewerWithAppName = "//td/strong[text()='%s']/parent::td/parent::tr/parent::tbody//button[@aria-label='Reviewer Documents']";

    @FindBy(xpath = "(//td/strong)[2]")
    private WebElement text_leftParameters;

    private String tabById = "//*[@id='%s']";

    public ReviewQueuePage(WebDriver driver)
    {
        initElements(driver);
    }

    private void initElements(WebDriver driver)
    {
		PageFactory.initElements(driver, this);
    }
}

