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
public class FinalizePage extends FLUtilities {
    @FindBy(id = "imgNext")
    private WebElement btn_Continue;

    @FindBy(id = "popup_ok")
    private WebElement btn_PopYes;

    @FindBy(id = "popup_cancel")
    private WebElement btn_PopNo;

    @FindBy(xpath = "//span[@id='divOutstandingRequestBody']//a")
    private WebElement link_OtherActionPopup;

    private By popupMsgMVC = By.xpath("//div[@id='InitialMessage']/div");
    private By popupMsgReact = By.xpath("//span[@id='divOutstandingRequestBody']//div");

    @FindBy(id = "divOtherActions")
    private List<WebElement> otheraction_options;

    @FindBy(xpath = "//span[text()='Yes']")
    private WebElement btn_yes;

    @FindBy(xpath = "//div[@id='InitialMessage']/div")
    private WebElement txt_ToastMsgLine1;

    @FindBy(xpath = "//div[@id='InitialMessage']//div/p")
    private WebElement txt_ToastMsgLine2;

    @FindBy(xpath = "(//div[@id='InitialMessage']//div/p)[2]")
    private WebElement txt_ToastMsgLine3;

    @FindBy(xpath = "//em[@class='far fa-link']")
    private WebElement linkIcon;

    @FindBy(xpath = "//span[@id='divOutstandingRequestBody']/div")
    private WebElement popUpBody;

    public String statusNoticeBar= "//div[@class='roundCorners']//div//canvas[contains(@class,'%s')]";

    public FinalizePage(WebDriver driver) {
        initElements(driver);
    }

    private void initElements(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}
