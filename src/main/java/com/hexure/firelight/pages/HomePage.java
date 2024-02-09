package com.hexure.firelight.pages;

import com.hexure.firelight.libraies.Enums.EnumsJSONProp;
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
public class HomePage extends FLUtilities {

    private String toolBarMenu="//div[@class='toolbar']//div[text()='%s']";

    private By toolBar_HomeMVC = By.id("toolbar_Home");
    private By toolBar_HomeReact = By.id("toolbar__home");

    @FindBy(id="toolbar_AllActivities")
    private WebElement toolBar_AllActivities;

    @FindBy(xpath = "//a[@aria-label='Home']")
    private WebElement toolBar_Home2;

    @FindBy(xpath = "//div[@class='listRecent__name']")
    private List<WebElement> list_RecentApplication;

    @FindBy(xpath = "//span[@class='listRecent__status']/span")
    private List<WebElement> list_ApplicationStatus;

    @FindBy(id = "toolbar_OtherActions")
    private WebElement toolBar_OtherActions;

    @FindBy(xpath = "//a[text()='Log Off']")
    private WebElement btn_LogoffAddendum;

    private By btn_LogoffMVC = By.id("toolbar_LogOff");
    private By btn_LogoffReact = By.xpath("//a[text()='Log Off']");

    @FindBy(xpath = "//a[text()='Other Actions']")
    private WebElement link_OtherAction;

    @FindBy(id = "divOtherActions")
    private WebElement list_BoxOtherActions;

    @FindBy(xpath = "//div[@id='divOtherActions']//a")
    private List<WebElement> list_Submenu_OtherActions;

    private By logOff_HomeMVC = By.id("toolbar_LogOff");
    private By logOff_HomeReact = By.xpath("//a[text()='Log Off']");

    @FindBy(xpath = "//a[text()='Home']")
    private WebElement btn_Home;

    @FindBy(id="imgNext")
    private WebElement btn_Apply;

    @FindBy(id = "manage_ReviewQueue")
    private WebElement link_ReviewQueue;

    @FindBy(xpath ="//label[contains(text(),'Pending')]")
    private WebElement message_Pending;

    @FindBy(xpath = "//strong[contains(text(),'Requested On:')]")
    private WebElement label_RequestedOn;

    @FindBy(xpath = "//strong[contains(text(),'Request:')]")
    private WebElement label_Request;

    @FindBy(xpath = "//strong[contains(text(),'Full Name:')]")
    private WebElement label_FullName;

    @FindBy(xpath = "//strong[contains(text(),'Email:')]")
    private WebElement label_Email;

    @FindBy(xpath = "//div[@role='dialog']/div//span[text()='Requests']/parent::div//button")
    private WebElement icon_CloseOnRequest;

    @FindBy(xpath = "//a[text()='(Pending Requests!)']")
    private WebElement link_PendingRequestAllActivities;

    @FindBy(xpath = "//a[@id='toolbar_Home']")
    private WebElement toolBar_HomeMenu2nd;

    @FindBy(xpath = "//button[text()='Shared Activity']")
    private WebElement btn_SharedActivity;

    @FindBy(xpath = "//a[contains(text(),'Documents')]")
    private WebElement toolbar_DocumentsOption;

    @FindBy(id = "toolbar_NewActivity")
    private WebElement btn_NewActivity;

    public static String homeToolbar="//div[@class='toolbar']//div[contains(text(),'%s')]";

    public static String listOrganisationConfig="//div[@id='dialogOrganizationConfiguration']//a[contains(text(),'%s')]";

    public static String list_activityType= "//div[@class='home-page-actions']//a[contains(text(),'%s')]";

    private String page = "(//a[contains(@id,'page_')])[%s]";

    @FindBy(id = "toolbar_Training")
    private WebElement tab_Training;

    public HomePage(WebDriver driver) {
        initElements(driver);
    }

    private void initElements(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public boolean verifyApplicationStatus(TestContext testContext, String applicationStatus) {
        for (int i = 0; i < list_RecentApplication.size(); i++) {
            if (list_RecentApplication.get(i).getText().trim().equalsIgnoreCase(testContext.getMapTestData().get("newProductName"))) {
                if (list_ApplicationStatus.get(i).getText().trim().equalsIgnoreCase(applicationStatus))
                    return true;
            }
        }
        return false;
    }

    public void openRecentApplication(TestContext testContext) {

        for (int i = 0; i < list_RecentApplication.size(); i++) {
            if (list_RecentApplication.get(i).getText().trim().equalsIgnoreCase(testContext.getMapTestData().get("newProductName"))) {
                list_RecentApplication.get(i).click();
                break;
            }
        }
    }

    public void openApplication(TestContext testContext, String applicationStatus) {
        for (int i = 0; i < list_RecentApplication.size(); i++) {
            if (list_RecentApplication.get(i).getText().trim().equalsIgnoreCase(testContext.getMapTestData().get("newProductName"))) {
                if (list_ApplicationStatus.get(i).getText().equalsIgnoreCase(applicationStatus))
                    list_RecentApplication.get(i).click();
            }
        }
    }

    public boolean verifyApplicationStatusForSeconApplication(TestContext testContext, String applicationStatus) {
        for (int i = 0; i < list_RecentApplication.size(); i++) {
            if (list_RecentApplication.get(i).getText().trim().equalsIgnoreCase(testContext.getMapTestData().get(EnumsJSONProp.SECONDNEWPRODUCTNAME.getText()))) {
                if (list_ApplicationStatus.get(i).getText().trim().equalsIgnoreCase(applicationStatus))
                    return true;
            }
        }
        return false;
    }

    public boolean verifyApplicationStatusForApplication(TestContext testContext,String appName, String applicationStatus) {
        for (int i = 0; i < list_RecentApplication.size(); i++) {
            if (list_RecentApplication.get(i).getText().trim().equalsIgnoreCase(testContext.getMapTestData().get(appName))) {
                if (list_ApplicationStatus.get(i).getText().trim().equalsIgnoreCase(applicationStatus))
                    return true;
            }
        }
        return false;
    }

}
