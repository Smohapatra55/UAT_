package com.hexure.firelight.pages;

import com.hexure.firelight.libraies.FLUtilities;
import lombok.Data;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

@Data
public class ReviewerDocumentsPage extends FLUtilities
{
    @FindBy(xpath = "//div[@id='divApp']/div/div")
    private WebElement pageHeading;

    @FindBy(xpath = "//input[@data-item-id='Reviewer_Name']")
    private WebElement txtBox_ReviewerName;

    @FindBy(xpath = "//input[@data-item-id='First Name']")
    private WebElement txtBox_ReviewerFirstName;

    @FindBy(xpath = "//input[@data-item-id='Last Name']")
    private WebElement txtBox_ReviewerLastName;

    @FindBy(xpath = "//input[@data-item-id='Reviewer_Comments']")
    private WebElement txtBox_ReviewerComment;

    @FindBy(id = "buttonComplete")
    private WebElement btn_Complete;

    public ReviewerDocumentsPage(WebDriver driver)
    {
        initElements(driver);
    }

    private void initElements(WebDriver driver)
    {
		PageFactory.initElements(driver, this);
    }
}
