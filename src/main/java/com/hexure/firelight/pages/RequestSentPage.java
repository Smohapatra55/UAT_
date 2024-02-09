package com.hexure.firelight.pages;

import com.hexure.firelight.libraies.FLUtilities;
import lombok.Data;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


@Data
public class RequestSentPage extends FLUtilities {

    @FindBy(id = "popup_title")
    private WebElement PopupTitleRequestSent;

    @FindBy(xpath = "//div[@id='popup_message']/span/span/strong")
    private WebElement url;

    @FindBy(xpath = "//div[@id='popup_message']/span")
    private WebElement popupMsg;

    @FindBy(id = "popup_ok")
    private WebElement popupOkbtn;

    public RequestSentPage(WebDriver driver)
    {
        initElements(driver);
    }
    private void initElements(WebDriver driver)
    {
        PageFactory.initElements(driver, this);
    }
}
