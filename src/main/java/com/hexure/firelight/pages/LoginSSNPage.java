package com.hexure.firelight.pages;

import com.hexure.firelight.libraies.FLUtilities;
import lombok.Data;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@Data
public class LoginSSNPage extends FLUtilities
{
    private String tabById = "//*[@id='%s']";

    @FindBy(id="Passcode")
    private WebElement txtBox_Passcode;

    @FindBy(id="SSN")
    private WebElement txtBox_MailerSSN;

    @FindBy(id="BirthDate")
    private WebElement txtBox_MailerBirthDate;

    @FindBy(id="cmdLoginSSN")
    private WebElement btn_SubmitSSN;

    @FindBy(id="cmdLoginPasscode")
    private WebElement btn_SubmitPasscode;

    public LoginSSNPage(WebDriver driver)
    {
        initElements(driver);
    }

    private void initElements(WebDriver driver)
    {
		PageFactory.initElements(driver, this);
    }
}
