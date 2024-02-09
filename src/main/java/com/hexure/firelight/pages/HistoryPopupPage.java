package com.hexure.firelight.pages;

import com.hexure.firelight.libraies.FLUtilities;
import lombok.Data;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@Data
public class HistoryPopupPage extends FLUtilities
{
    @FindBy(xpath="(//div[@id='dialogHistory']//div//div[text()='Complete '])[2]")
    private WebElement txt_CompleteSectionTitle;

    @FindBy(xpath = "//div[@id='dialogHistory']//div//div//strong[text()='Complete']")
    private WebElement txt_CompleteSectionStatus;

    @FindBy(xpath = "//div[@id='dialogHistory']//div//strong[text()='E-Signature Process Declined']")
    private WebElement txt_Status_ESignatureSection;

    @FindBy(xpath = "//*[@aria-describedby=\"dialogHistory\"]//*[@type=\"button\"]")
    private WebElement tab_closebuttonOnApp;

    @FindBy(xpath = "//div[@id='dialogHistory']//div//div//strong[text()='Review Complete']")
    private WebElement txt_ReviewSectionStatus;

    @FindBy(xpath = "(//div[@id='dialogHistory']//strong[text()='Complete'])/parent::div/following-sibling::div")
    private WebElement txt_ApplicationNameWithStatus;

    @FindBy(xpath = "//div[@id='dialogHistory']//div[@class='panelContent']")
    private WebElement txt_HistoryContent;

    @FindBy(xpath = "(//div[@aria-describedby='dialogHistory']//button)[1]")
    private WebElement btn_CloseHistoryDialog;

    @FindBy(xpath = "//div[@class='auditDisplayStatus']")
    private WebElement txt_statusHeader;

    @FindBy(xpath = "//*[@aria-describedby=\"dialogHistory\"]//*[@type=\"button\"]")
    private WebElement tab_historyCloseButton;

    @FindBy(xpath = "//strong[contains(text(),'Signing Ceremony - Jurisdiction Attempts Exceeded')]")
    private WebElement msg_JurisExceeded;

    @FindBy(xpath = "//div[contains(text(),'maximum number of acceptable attempts. Activity is no longer active.')]")
    private WebElement msg_MaxAttempt;

    @FindBy(xpath = "//strong[contains(text(),'Signing Ceremony - Invalid Jurisdiction')]")
    private WebElement msg_InvalidJurisdiction;

    @FindBy(xpath = "//div[contains(text(),'does not match the activity jurisdiction.')]")
    private WebElement msg_JurisdictionMismatch;

    public HistoryPopupPage(WebDriver driver)
    {
        initElements(driver);
    }

    private void initElements(WebDriver driver)
    {
		PageFactory.initElements(driver, this);
    }

}
