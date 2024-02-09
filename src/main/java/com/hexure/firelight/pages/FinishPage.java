package com.hexure.firelight.pages;

import com.hexure.firelight.libraies.FLUtilities;
import lombok.Data;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

@Data
public class FinishPage extends FLUtilities
{
    @FindBy(xpath = "//span[@id='divOutstandingRequestBody']")
    private WebElement msg_Popup_finish1;
    @FindBy(xpath = "//span[@id='divOutstandingRequestBody']//p")
    private List<WebElement> msg_Popup_finish2;

    @FindBy(xpath = "//span[@id='divOutstandingRequestBody']//p[text()=' Thank you for your business!']")
    private WebElement msg_Popup_finish3;

    @FindBy(xpath = "//div[contains(text(),'Application is finished')]")
    private WebElement msg_Popup_AppFinished;

    @FindBy(xpath = "//a[@aria-label=\"[Close]\"]")
    private WebElement icon_PopUpClose_React;

    public FinishPage(WebDriver driver)
    {
        initElements(driver);
    }

    private void initElements(WebDriver driver)
    {
		PageFactory.initElements(driver, this);
    }


}
