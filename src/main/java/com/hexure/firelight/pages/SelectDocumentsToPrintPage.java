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
public class SelectDocumentsToPrintPage extends FLUtilities
{

    private By btn_PrintDocumentsMVC = By.xpath("//td[contains(text(),'Print Selected Documents')]");
    private By btn_PrintDocumentsReact = By.xpath("//span[text()='Print Selected Documents']");

    @FindBy(xpath="//td[contains(text(),'Back to Application')]")
    private WebElement btn_BackApplication;

    private String checkboxSelectDocuments = "//div[contains(text(),'%s')]/parent::div/parent::div//div[contains(text(),'%s')]/parent::div//img";

    public SelectDocumentsToPrintPage(WebDriver driver)
    {
        initElements(driver);
    }

    private void initElements(WebDriver driver)
    {
		PageFactory.initElements(driver, this);
    }
}
