package com.hexure.firelight.libraies.pages_react;

import com.hexure.firelight.libraies.FLUtilities;
import lombok.Data;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

@Data
public class DataEntry_ReactPage extends FLUtilities
{
    @FindBy(xpath="//a[@class=\"blueLink\" and contains(text(),\"CONTINUE\")]")
    private WebElement link_DataEntryPopupContinue;

    @FindBy(xpath="//a[(@class='orange' and contains(text(),'[Close]')) or @title='Close']")
    private WebElement btn_CloseButton;

    @FindBy(xpath="//*[@data-item-id='Wet Sign Custom Button' or @title='Wet Sign Custom Button' or @data-dataitemid='Wet Sign Custom Button']")
    private WebElement btn_WetSign;

    @FindBy(xpath="//*[@data-item-id='Open' or @title='Open' or text()='Upload a Copy of Voided Check']")
    private WebElement btn_Open;

    @FindBy(xpath="//*[@data-item-id='Policy Custom button' or @title='Policy Custom button' or @data-dataitemid='Policy Custom button']")
    private WebElement btn_PolicyCustom;

    @FindBy(xpath="//span[text()='Unlock Activity']")
    private WebElement btn_UnlockActivity;

    @FindBy(xpath="//div[@id='appNameEdit']//a")
    private WebElement btn_Lock;

    @FindBy(xpath="//span[text()='Unlock']")
    private WebElement btn_Unlock;

    public static String btn_UploadaCopyofVoidedCheck_MVC = "//span[contains(text(),'%s')]";
    public static String btn_UploadaCopyofVoidedCheck_REACT = "//a[contains(text(),'%s')]";

    public DataEntry_ReactPage(WebDriver driver)
    {
        initElements(driver);
    }

    private void initElements(WebDriver driver)
    {
		PageFactory.initElements(driver, this);
    }

    public WebElement getDefaultDropdownValue(WebDriver driver, String dropDownname){
        return   new Select(driver.findElement(By.xpath("//select[@title='" + dropDownname + "'  or @aria-label='" + dropDownname + "' or @id='" + dropDownname + "']"))).getFirstSelectedOption();
    }

    public WebElement getCheckBox(WebDriver driver, String checkBoxName){
        if (driver.findElements(By.xpath("//div[@title='" + checkBoxName + "']/div")).size() > 0) {
            return driver.findElement(By.xpath("//div[@title='" + checkBoxName + "']/div"));
        } else {
            return driver.findElement(By.xpath("//div[contains(text(),'')]/following-sibling::div /input"));
        }

    }
}
