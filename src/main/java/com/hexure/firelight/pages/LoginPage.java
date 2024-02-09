package com.hexure.firelight.pages;

import com.hexure.firelight.libraies.FLUtilities;
import com.hexure.firelight.libraies.TestContext;
import lombok.Data;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.sql.SQLException;

@Data
public class LoginPage extends FLUtilities
{
    @FindBy(xpath="//input[contains(@name,'UserName')]")
    private WebElement txtbox_userName;

    @FindBy(xpath="//input[contains(@name,'Password')]")
    private WebElement txtbox_Password;

    @FindBy(xpath="//input[contains(@id,'Login')]")
    private WebElement btn_SignIn;

    public LoginPage(WebDriver driver)
    {
        initElements(driver);
    }

    private void initElements(WebDriver driver)
    {
		PageFactory.initElements(driver, this);
    }

/*
    public String[] getLoginCredentials(TestContext testContext, String empid){
        String[] loginCredentials = new String[2];

        String query = "select * from users where empid='" + empid + "'";
        setResultSet(testContext, query);

        try {
            while(testContext.getResultSet() != null && testContext.getResultSet().next()){
                loginCredentials[0]= testContext.getResultSet().getString("username");
                loginCredentials[1]=testContext.getResultSet().getString("password");
                System.out.println(loginCredentials[0]);
                System.out.println(loginCredentials[1]);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        closeDBResources(testContext);

        return loginCredentials;
    }
*/
}
