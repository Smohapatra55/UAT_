package com.hexure.firelight.pages;

import com.hexure.firelight.libraies.FLUtilities;
import com.hexure.firelight.libraies.TestContext;
import lombok.Data;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

@Data
public class HistoryPage extends FLUtilities
{
    @FindBy(xpath="//strong[contains(text(),'Approved by')]")
    private List<WebElement> list_HistoryApplication;

    @FindBy(xpath="//strong[contains(text(),'Rejected by')]")
    private List<WebElement> list_HistoryApplicationReject;

    @FindBy(xpath = "//div[text()='Joint Annuitant Information']")
    private List<WebElement> list_JointAnnuitant;

    public HistoryPage(WebDriver driver)
    {
        initElements(driver);
    }

    private void initElements(WebDriver driver)
    {
		PageFactory.initElements(driver, this);
    }

    public boolean verifyIfApplicationInHistory(TestContext testContext) {
        for (WebElement singleApplication: list_HistoryApplication) {
            if (singleApplication.getText().trim().contains("Approved by")
                && singleApplication.getText().trim().contains(configProperties.getProperty(testContext.getCurrentTestUserName())))
                return true;
        }
        return false;
    }

    public boolean verifyIfApplicationInHistoryforReject(TestContext testContext) {
        for (WebElement singleApplication: list_HistoryApplicationReject) {
            if (singleApplication.getText().trim().contains("Rejected by")
                    && singleApplication.getText().trim().contains(configProperties.getProperty(testContext.getCurrentTestUserName())))
                return true;
        }
        return false;
    }
}
