package com.hexure.firelight.pages;

import com.hexure.firelight.libraies.FLUtilities;
import lombok.Data;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@Data
public class TabAppPage extends FLUtilities {

    @FindBy(id = "btnSubmit")
    private WebElement btn_Save;

    @FindBy(id = "btnSaveEmailTemp")
    private WebElement btn_SaveTemplate;

    public TabAppPage(WebDriver driver) { initElements(driver); }

    private void initElements(WebDriver driver) { PageFactory.initElements(driver, this); }
}