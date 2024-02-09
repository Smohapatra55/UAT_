package com.hexure.firelight.pages;

import com.hexure.firelight.libraies.FLUtilities;
import lombok.Data;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@Data
public class TabAppPage extends FLUtilities {

    public static String checkBox = "//*[@id='%s']";

    public static String checkBoxDynmatic = "//label[text()='RV Test Package 1']//ancestor::tr[contains(@class,'Rowcolor')]//input[@type='checkbox']";

    public static String checkBox_hidden = "//*[@id='%s' and contains(@style,'display:none;')]";

    @FindBy(id = "btnSubmit")
    private WebElement btn_Save;

    @FindBy(id = "btnSaveEmailTemp")
    private WebElement btn_SaveTemplate;

    @FindBy(id = "lblStatus")
    private WebElement label_GroupSave;

    @FindBy(id = "HTTPRedirectURL")
    private WebElement txt_URL;

    @FindBy(id = "ITNavBar__Left")
    private WebElement btn_LeftButton;

    public TabAppPage(WebDriver driver) { initElements(driver); }

    private void initElements(WebDriver driver) { PageFactory.initElements(driver, this); }
}