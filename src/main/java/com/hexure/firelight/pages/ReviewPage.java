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
public class ReviewPage extends FLUtilities {
    @FindBy(xpath = "//div[@id='InitialMessage']/following-sibling::a")
    private WebElement btn_InitialMessagePopupClose;

    @FindBy(xpath = "//div[@class='roundCornersTop heading']")
    private WebElement heading_Reviewer;


    public ReviewPage(WebDriver driver) {
        initElements(driver);
    }

    private void initElements(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}
