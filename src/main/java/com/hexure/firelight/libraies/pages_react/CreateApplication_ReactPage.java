package com.hexure.firelight.libraies.pages_react;

import com.hexure.firelight.libraies.FLUtilities;
import lombok.Data;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

@Data
public class CreateApplication_ReactPage extends FLUtilities
{
    public CreateApplication_ReactPage(WebDriver driver)
    {
        initElements(driver);
    }
    private void initElements(WebDriver driver)
    {
		PageFactory.initElements(driver, this);
    }
}
