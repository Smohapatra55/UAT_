package com.hexure.firelight.pages;

import com.hexure.firelight.libraies.FLException;
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
public class SSNHomePage extends FLUtilities
{
    @FindBy(id="lnkViewDoc")
    private WebElement link_ReviewDocuments;

    private By link_SignActivityMVC = By.id("lnkStartSign");
    private By link_SignActivityReact = By.xpath("//span[text()='Sign Activity']");

    @FindBy(id="buttonContactAgent")
    private WebElement link_ContactAgent;

    @FindBy(xpath="//span[text()='Review Documents']")
    private WebElement link_NewReviewDocuments;

    @FindBy(xpath="//span[text()='Sign Activity']")
    private WebElement link_NewSignActivity;

    @FindBy(xpath="//span[text()='Contact Agent']")
    private WebElement link_NewContactAgent;

    @FindBy(xpath="//a[text()='Log Off']")
    private WebElement btn_Logoff;

    @FindBy(xpath="//a[text()='View Activity PDF']")
    private WebElement btn_ViewActivityPDF;

    @FindBy(xpath="//a[text()='Download All']")
    private WebElement link_DownloadAll;

    @FindBy(xpath="//a[text()='View All']")
    private WebElement link_ViewAll;


    @FindBy(xpath="//a[text()='Download']")
    private WebElement link_Download;

    @FindBy(xpath="//a[text()='View']")
    private WebElement link_View;

    @FindBy(xpath = "//div[contains(text(),'Send Reminder to')]")
    private WebElement link_SendReminderPendingReq;

    @FindBy(xpath = "//div[contains(text(),'Send Passcode to')]")
    private WebElement link_SendPasscodePendingReq;

    @FindBy(xpath = "//div[contains(text(),'Cancel Request')]")
    private WebElement link_CancelPendingReq;

    @FindBy(xpath = "//span[text()='Cancel']")
    private WebElement btn_CancelMsg;

    @FindBy(xpath = "//span[text()='Send']")
    private WebElement btn_SendMsg;

    public SSNHomePage(WebDriver driver)
    {
        initElements(driver);
    }

    private void initElements(WebDriver driver)
    {
		PageFactory.initElements(driver, this);
    }

    public boolean userVerifyButton(String whichButton, TestContext testContext, WebDriver driver) {
        switch (whichButton) {
            case "View Activity PDF":
                return getBtn_ViewActivityPDF().isDisplayed();
            case "Log Off":
                return getBtn_Logoff().isDisplayed();
        }

        if(testContext.getMapTestData().get("uiType").equalsIgnoreCase("react")) {
            switch (whichButton) {
                case "Review Documents":
                    return getLink_NewReviewDocuments().isDisplayed();
                case "Sign Activity":
                    return getLink_NewSignActivity().isDisplayed();
                case "Contact Agent":
                    return getLink_NewContactAgent().isDisplayed();
                case "Contact Agent Details":
                    return getLink_ContactAgent().isDisplayed();
                case "Send Reminder to":
                    return getLink_SendReminderPendingReq().isDisplayed();
                case "Send Passcode to":
                    return getLink_SendPasscodePendingReq().isDisplayed();
                case "Cancel Request":
                    return getLink_CancelPendingReq().isDisplayed();
                case "Cancel" :
                    return getBtn_CancelMsg().isDisplayed();
                case "Send":
                    return getBtn_SendMsg().isDisplayed();
                default:
                    throw new FLException("Invalid value for: " + whichButton);
            }
        }
        else {
            switch (whichButton) {
                case "Review Documents":
                    return getLink_ReviewDocuments().isDisplayed();
                case "Sign Activity":
                    return getElement(driver, getExistingLocator(driver, getLink_SignActivityMVC(), getLink_SignActivityReact(), null, null)).isDisplayed();
                case "Contact Agent":
                    return getLink_ContactAgent().isDisplayed();
                case "Download All":
                    return getLink_DownloadAll().isDisplayed();
                case "View All":
                    return getLink_ViewAll().isDisplayed();
                case "Download":
                    return getLink_Download().isDisplayed();
                case "View":
                    return getLink_View().isDisplayed();
            }
        }
        return false;
    }

}
