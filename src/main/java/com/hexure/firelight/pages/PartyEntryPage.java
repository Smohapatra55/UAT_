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
public class PartyEntryPage extends FLUtilities
{
    @FindBy(xpath="//select[@data-dataitemid='Total_NumberOfParties']")
    private WebElement dd_PartiesActivity;

    @FindBy(xpath="//select[@data-dataitemid='Total_NumberOfParties']/option")
    private List<WebElement> list_PartiesActivityDropDown;

    @FindBy(id="imgExpand")
    private WebElement icon_ExpandMenu;

    @FindBy(xpath="//select[@data-dataitemid='Total_NumberOfParties']")
    private WebElement dd_PartiesActivityDropDown;

    @FindBy(id="imgCollapse")
    private WebElement icon_CollapseMenu;

    @FindBy(xpath = "//li[contains(@title,'Demographic Data')]")
    private List<WebElement> list_DemographicDataList;

    @FindBy(xpath = "//li[contains(@title,'Medical Data')]")
    private List<WebElement> list_MedicalDataList;

    @FindBy(id="FirstName")
    private WebElement txtbox_firstName;

    @FindBy(id="LastName")
    private WebElement txtbox_lastName;

    @FindBy(id="MI")
    private WebElement txtbox_MiddleName;

    @FindBy(id="StreetAddress")
    private WebElement txtbox_StreetAddress;

    @FindBy(id="City")
    private WebElement txtbox_City;

    @FindBy(id="State")
    private WebElement txtbox_State;

    @FindBy(xpath = "//select[@id='State']")
    private WebElement txt_State;

    @FindBy(xpath="//input[@id='ZipCode']")
    private WebElement txtbox_ZipCode;

    @FindBy(xpath = "//input[@id='CouncilNumber']")
    private WebElement txtbox_CouncilNumber;

    @FindBy(id = "MembershipNumber")
    private WebElement txtbox_MembershipNumber;

    @FindBy(id = "ToggleMessagesLink")
    private WebElement icon_RedBubble;

    @FindBy(id = "ToggleMessagesLink")
    private List<WebElement> list_iconRedBubble;

    @FindBy(xpath = "(//span[text()='Next'])[3]")
    private WebElement btn_Next;

    @FindBy(id = "Height-Feet")
    private WebElement txtbox_HeightFeet;

    @FindBy(xpath = "//select[@id='Height-Feet']/option")
    private WebElement list_HeightFeet;

    @FindBy(id = "Height-Inches")
    private WebElement txtbox_HeightInches;
    @FindBy(xpath = "//select[@id='Height-Feet']/option")
    private WebElement list_HeightInches;

    @FindBy(id = "Weight-lbs")
    private WebElement txtbox_Weightlbs;

    @FindBy(id = "TotalInsuranceinForce")
    private WebElement txtbox_TotalInsuranceinForce;

    @FindBy(id = "PrimaryCarePhysicianorHealthFacility")
    private WebElement txtbox_primaryCarePhysicianorHealthFacility;

    @FindBy(xpath = "//div[@data-dataitemid='Party4_AddressSameAsParty1_Label']/parent::div/following-sibling::div//div[@title='Yes']")
    private WebElement radio_DoesParty4;

    @FindBy(id="StatusBar_Complete")
    private WebElement tost_popupbox;

    @FindBy(id="StatusBar_Complete")
    private List<WebElement> list_tostPopupBox;

    private By icon_closeTostPopupboxMVC = By.xpath("//a[@title='Close']");
    private By icon_closeTostPopupboxReact = By.xpath("//a[@aria-label='[Close]']");

    @FindBy(id="//a[@class='orange']")
    private WebElement icon_closeToastPopupbox;

    @FindBy(xpath="//div[@class='navDrawer']//li/a")
    private List<WebElement> list_FormMenulist;

    @FindBy(xpath="//*[@id='divStatusNotice']/p/a")
    private WebElement icon_closeTostPopupboxNew;

    @FindBy(xpath = "//div[@class='panelContent']/strong")
    private WebElement icon_MoreInfo;


    public PartyEntryPage(WebDriver driver) {initElements(driver);}

    private void initElements(WebDriver driver)
    {
		PageFactory.initElements(driver, this);
    }


}
