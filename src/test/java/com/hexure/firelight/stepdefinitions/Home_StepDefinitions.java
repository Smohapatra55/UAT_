package com.hexure.firelight.stepdefinitions;

import com.hexure.firelight.libraies.EnumsCommon;
import com.hexure.firelight.libraies.FLException;
import com.hexure.firelight.libraies.FLUtilities;
import com.hexure.firelight.libraies.TestContext;
import com.hexure.firelight.pages.FinalizePage;
import com.hexure.firelight.pages.HomePage;
import cucumber.api.java.en.Then;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class Home_StepDefinitions extends FLUtilities {
    private WebDriver driver;
    private HomePage onHomePage;
    private FinalizePage onFinalizePage;
    private TestContext testContext;
    private WebDriver driverEdge = null;
    private static final Logger Log = LogManager.getLogger(Home_StepDefinitions.class);

    public Home_StepDefinitions(TestContext context) {
        testContext = context;
        driver = context.getDriver();
        onHomePage = context.getPageObjectManager().getHomePage();
        onFinalizePage = context.getPageObjectManager().getOnFinalizePage();
    }

    @Then("User clicks {string} Tab")
    public void userClicksTab(String activityType) {
        captureScreenshot(driver, testContext, false);
        if(findElements(driver, "//td[@class='top']//span[text()='" + activityType + "']").size() > 0)
            clickElement(driver, "//td[@class='top']//span[text()='" + activityType + "']");
        else
            clickElement(driver, "//a[text()='" + activityType + "']");
    }

    @Then("User navigates to Home page")
    public void userNavigatesToHomePage() {
        captureScreenshot(driver, testContext, false);
        clickElement(driver, getElement(driver, getExistingLocator(driver, onHomePage.getToolBar_HomeMVC(), onHomePage.getToolBar_HomeReact(), null, null)));
    }

    @Then("User verifies Application status as {string}")
    public void VerifyApplicationStatus(String applicationStatus) {
        captureScreenshot(driver, testContext, false);
        try {
            waitForPageToLoad(driver);
            sleepInMilliSeconds(2000);
            Assert.assertTrue("Application status Mismatched", findElement(driver, "//div[@class='listRecent__name' and @aria-label='" + testContext.getMapTestData().get("newProductName") + ",']//following-sibling::div//span[@class='orange']").getText().equalsIgnoreCase(applicationStatus));
        } catch (StaleElementReferenceException e) {
        }
    }

    @Then("User navigates to {string}")
    public void userNavigatesTo(String arg0) {
        onHomePage.getToolBar_Home2().click();
    }

    @Then("User verifies Application Status on Recent Activity is {string} now")
    public void userVerifiesApplicationStatusOnRecentActivityIsNow(String applicationStatus) {
        captureScreenshot(driver, testContext, false);
        VerifyApplicationStatus(applicationStatus);
    }

    @Then("User clicks on Other Action Link of Popup message")
    public void clicksOnOtherActionLink() {
        captureScreenshot(driver, testContext, false);
        clickElement(driver, onHomePage.getLink_OtherAction());
    }

    @Then("User verifies Other Action Menu Opens")
    public void userVerifiesOtherActionMenuOpen() {
        syncElement(driver, onHomePage.getList_BoxOtherActions(), EnumsCommon.TOVISIBLE.getText());
        captureScreenshot(driver, testContext, false);
        Assert.assertTrue("Other option menus is not open.", onHomePage.getList_BoxOtherActions().isDisplayed());
    }

    @Then("User clicks {string} button on home page")
    public void userClicksButton(String whichButton) {
        if (whichButton.equalsIgnoreCase("Logoff")) {
            clickElement(driver, getElement(driver, getExistingLocator(driver, onHomePage.getBtn_LogoffMVC(), onHomePage.getBtn_LogoffReact(), null, null)));
        }
    }

    @Then("User open application from recent activity")
    public void userOpenApplication() {
        captureScreenshot(driver, testContext, false);
        int i = 1;
        while (findElements(driver, "//div[@class='listRecent__name' and @aria-label='" + testContext.getMapTestData().get("newProductName") + ",']").size() == 0){
            clickElement(driver,findElement(driver,String.format(onHomePage.getPage(),i)));
            i++;
        }
        clickElement(driver, findElement(driver, "//div[@class='listRecent__name' and @aria-label='" + testContext.getMapTestData().get("newProductName") + ",']"));
    }

    @Then("User open application from shared activity")
    public void userOpenSharedApplication() {
        captureScreenshot(driver, testContext, false);
        clickElement(driver, onHomePage.getBtn_SharedActivity());
        waitForPageToLoad(driver);
        Assert.assertTrue("Application was not displayed", findElement(driver, "//div[@class='listRecent__name' and @aria-label='" + testContext.getMapTestData().get("newProductName") + ",']").isDisplayed());
        clickElement(driver, findElement(driver, "//div[@class='listRecent__name' and @aria-label='" + testContext.getMapTestData().get("newProductName") + ",']"));
    }

    @Then("User click {string} submenu")
    public void userClickSubmenu(String menuoption) {
        waitForPageToLoad(driver);
        captureScreenshot(driver, testContext, false);
        selectOptionFromList(driver, onHomePage.getList_Submenu_OtherActions(), menuoption, EnumsCommon.CLICK.getText());
    }

    @Then("User Verifies Application Status as {string}")
    public void userVerifiesApplicationStatusAs(String exp_status) {
        if (configProperties.getProperty("browser").equalsIgnoreCase(EnumsCommon.FIREFOXBROWSER.getText())){
            waitForPageToLoad(driver);
        }
        captureScreenshot(driver, testContext, false);
        Assert.assertTrue("Application status Mismatched", findElement(driver, "//div[@class='listRecent__name' and @aria-label='" + testContext.getMapTestData().get("newProductName") + ",']//following-sibling::div//span[@class='orange']").getText().equalsIgnoreCase(exp_status));
    }

    @Then("User Log Off from current Application")
    public void userLogOfffromCurrentApplication() {
        waitForPageToLoad(driver);
        captureScreenshot(driver, testContext, false);
        clickElement(driver, getElement(driver, getExistingLocator(driver, onHomePage.getLogOff_HomeMVC(), onHomePage.getLogOff_HomeReact(), null, null)));
        captureScreenshot(driver, testContext, false);
    }

    @Then("User Clicks Application from Recent Activity")
    public void userClicksApplicationfromRecentActivity() {
        waitForPageToLoad(driver);
        captureScreenshot(driver, testContext, false);
        selectOptionFromList(driver, onHomePage.getList_RecentApplication(), testContext.getMapTestData().get("newProductName"), EnumsCommon.CLICK.getText());
    }

    @Then("User goes to Home page")
    public void userGoesToHomePage() {
        waitForPageToLoad(driver);
        WebElement element = getElement(driver, getExistingLocator(driver, onHomePage.getToolBar_HomeMVC(), onHomePage.getToolBar_HomeReact(), null, null));
        syncElement(driver, element, EnumsCommon.TOCLICKABLE.getText());
        captureScreenshot(driver, testContext, false);
        clickElementByJSE(driver, element);
    }

    @Then("User open Application {string}")
    public void openApplication(String applicationStatus) {
        onHomePage.openApplication(testContext, applicationStatus);
    }

    @Then("User verifies Application Status on Recent Activity is {string} or {string} now")
    public void userVerifiesApplicationStatusOnRecentActivityIsOrNow(String applicationStatus1, String applicationStatus2) {
        captureScreenshot(driver, testContext, false);
        String elementText = findElement(driver, "//div[@class='listRecent__name' and @aria-label='" + testContext.getMapTestData().get("newProductName") + ",']//following-sibling::div//span[@class='orange']").getText();
        Assert.assertTrue("Application status Mismatched", elementText.equalsIgnoreCase(applicationStatus1) || elementText.equalsIgnoreCase(applicationStatus2));
    }

    @Then("User Now Navigate to All Activities page")
    public void user_Now_Navigate_to_All_Activities_page() {
        captureScreenshot(driver, testContext, false);
        clickElement(driver,onHomePage.getToolBar_AllActivities());
    }

    @Then("User navigate to home page")
    public void gotoHomePage(){
        captureScreenshot(driver, testContext, false);
        clickElement(driver,getElement(driver, getExistingLocator(driver, onHomePage.getToolBar_HomeMVC(), onHomePage.getToolBar_HomeReact(), null, null)));
    }

    @Then("User Clicks Apply Button")
    public void clickApplyButton(){
        clickElement(driver,onHomePage.getBtn_Apply());
    }

    @Then("User verifies the request tab data")
    public void userVerifiesTheStatus() {
        waitForPageToLoad(driver);
        captureScreenshot(driver, testContext, false);
        Assert.assertEquals("Pending status is not displayed.",testContext.getMapTestData().get("requestPopupStatus"),onHomePage.getMessage_Pending().getText().trim());
        Assert.assertTrue("Pending status is not displayed in red color",onHomePage.getMessage_Pending().getAttribute("style").contains("rgb(182, 0, 0)"));
        Assert.assertTrue("Requested to is not displayed",onHomePage.getLabel_RequestedOn().isDisplayed());
        Assert.assertTrue("Request is not displayed",onHomePage.getLabel_Request().isDisplayed());
        Assert.assertTrue("Full name is not displayed",onHomePage.getLabel_FullName().isDisplayed());
        Assert.assertTrue("Email is not displayed",onHomePage.getLabel_Email().isDisplayed());
    }

    @Then("User clicks close icon of request tab")
    public void userClicksOnCloseIconofRequestTab(){
        waitForPageToLoad(driver);
        captureScreenshot(driver, testContext, false);
        clickElementByJSE(driver,onHomePage.getIcon_CloseOnRequest());
    }

    @Then("User clicks on home menu")
    public void navigateToHome(){
        waitForPageToLoad(driver);
        captureScreenshot(driver, testContext, false);
        clickElementByJSE(driver,onHomePage.getToolBar_HomeMenu2nd());
    }

    @Then("User verify application displayed at Recent Activity")
    public void verifyApplicationDisplayed(){
          boolean flag = false;
          for(WebElement element:onHomePage.getList_RecentApplication()){
            if (element.getText().trim().equalsIgnoreCase(testContext.getMapTestData().get("newProductName"))) {
               flag = true;
                break;
            }
        }
        Assert.assertTrue("Recent created activity is not displayed in Recent activity tab.",flag);
    }

    @Then("User verify application is not displayed at Recent Activity")
    public void verifyApplicationNotDisplayed(){
        boolean flag = false;
        for(WebElement element:onHomePage.getList_RecentApplication()){
            if (element.getText().trim().equalsIgnoreCase(testContext.getMapTestData().get("newProductName"))) {
                flag = true;
                break;
            }
        }
        Assert.assertFalse("Recent created activity is displayed in Recent activity tab.",flag);
    }

    @Then("User Now Clicks {string} option under Other Actions")
    public void user_Now_Clicks_option_under_Other_Actions(String string) {
        captureScreenshot(driver, testContext, false);
        clickElementByJSE(driver,onHomePage.getToolbar_DocumentsOption());
    }

    @Then("User verifies Application status as {string} For second Application")
    public void VerifyApplicationStatusForSecondApplication(String applicationStatus) {
        captureScreenshot(driver, testContext, false);
        try {
            driver.navigate().refresh();
            waitForPageToLoad(driver);
            Assert.assertTrue("Application status Mismatched", onHomePage.verifyApplicationStatusForSeconApplication(testContext, applicationStatus));
        } catch (StaleElementReferenceException e) {
        }
    }

    @Then("User navigates to {string} toolbar menu")
    public void navigateToToolBarTab(String menu){
        WebElement element=driver.findElement(By.xpath(String.format(onHomePage.getToolBarMenu(),menu)));
        syncElement(driver,element,EnumsCommon.TOCLICKABLE.getText());
          element.click();
       }

    @Then("User Navigates Back By Clicking on Back Button")
    public void user_Navigates_Back_By_Clicking_on_Back_Button() {
        captureScreenshot(driver, testContext, false);
        driver.navigate().back();
    }

    @Then("User navigates to New Activity Tab")
    public void user_navigates_to_New_Activity_Tab() {
        captureScreenshot(driver, testContext, false);
        clickElement(driver,onHomePage.getBtn_NewActivity());
    }


    @Then("User open shared activity")
    public void userOpenSharedActivity() {
        waitForPageToLoad(driver);
        captureScreenshot(driver, testContext, false);
        clickElement(driver, onHomePage.getBtn_SharedActivity());
        waitForPageToLoad(driver);
    }

    @Then("User verifies Application status as {string} For {string}")
    public void VerifyApplicationStatusForApplication(String applicationStatus, String appName) {
        captureScreenshot(driver, testContext, false);
        try {
            waitForPageToLoad(driver);
            Assert.assertTrue("Application status Mismatched", onHomePage.verifyApplicationStatusForApplication(testContext,appName, applicationStatus));
        } catch (StaleElementReferenceException e) {
        }
    }

    @Then("User clicks Review Queue on Home Page")
    public void user_clicks_Review_Queue_on_Home_Page() {
        waitForPageToLoad(driver);
        captureScreenshot(driver, testContext, false);
        clickElement(driver, onHomePage.getLink_ReviewQueue());
    }

    @Then("User Clicks on Training Tab")
    public void user_Clicks_on_Training_Tab() {
        captureScreenshot(driver, testContext, false);
        clickElement(driver, onHomePage.getTab_Training());
        waitForPageToLoad(driver);
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        if (tabs.size() > 1)
            driver.switchTo().window(tabs.get(1));

    }

    @Then("User Opens Edge Browser and Open Url {string}")
    public void user_Opens_Edge_Browser_and_Open_Url(String url) throws MalformedURLException {

        System.setProperty(configProperties.getProperty("edgeDriver.property"), configProperties.getProperty("edgeDriver.path"));
        if(configProperties.getProperty("execution.type").trim().equalsIgnoreCase("local")){
            driverEdge = new EdgeDriver(getEdgeOptions());
            driverEdge.manage().window().maximize();}
        else
            driverEdge = new RemoteWebDriver(new URL("http://0.0.0.0:4545/wd/hub"), getEdgeOptions());


        driverEdge.get(testContext.getMapTestData().get(url));
        captureScreenshot(driverEdge, testContext, false);
    }

    @Then("User {string} new tab in browser Edge")
    public void openNewTab(String operation) {
        captureScreenshot(driverEdge, testContext, false);
        ArrayList<String> tabs = null;
        if(operation.equalsIgnoreCase("open")) {
            ((JavascriptExecutor) driverEdge).executeScript("window.open()");
            tabs = new ArrayList<>(driverEdge.getWindowHandles());
            driverEdge.switchTo().window(tabs.get(1));
        }
        else {
            if(tabs.size() > 1) {
                driverEdge.close();
            }
            driverEdge.switchTo().window(tabs.get(0));
        }
    }

    @Then("User Loads the URL generated previously for {string} in edge")
    public void userLoadsTheURLgeneratedPreviously(String key) {
        captureScreenshot(driverEdge, testContext, false);
        String url= testContext.getMapTestData().get(key);
        driverEdge.get(url);
    }

    @Then("User on Login Page enters valid username as {string} and password and clicks Login button in Edge")
    public void userOnLoginPageEntersValidUsernameAsAndPasswordAndClicksLoginButton(String userName) {
        testContext.setCurrentTestUserName(userName);
        System.out.println("Current Test UserName = " + testContext.getCurrentTestUserName());
        driverEdge.findElement(By.xpath("//input[contains(@name,'UserName')]")).sendKeys(configProperties.getProperty(testContext.getCurrentTestUserName()));
        driverEdge.findElement(By.xpath("//input[contains(@name,'Password')]")).sendKeys(configProperties.getProperty(testContext.getCurrentTestUserName() + "-password"));
        captureScreenshot(driverEdge, testContext, false);
        sleepInMilliSeconds(1000);
        driverEdge.findElement(By.xpath("//input[contains(@id,'Login')]")).click();
    }

    @Then("User verifies the {string} page should be open in edge")
    public void user_verifies_the_page_should_be_openInEdge(String pageName) {
        captureScreenshot(driver, testContext, false);
        Assert.assertEquals(pageName+" page was mismatched", pageName, driverEdge.getTitle().trim());
    }

    @Then("User Clears Tabs In Edge Browser")
    public void userClearsTabsInEdgeBrowser() {
    driverEdge.quit();
    }


    @Then("User verifies application is not displayed in shared activity")
    public void userVerifies_application_is_not_displayed_in_shared_activity() {
        captureScreenshot(driver, testContext, false);
        clickElement(driver, onHomePage.getBtn_SharedActivity());
        Assert.assertFalse(findElements(driver, "//div[@class='listRecent__name' and @aria-label='" + testContext.getMapTestData().get("newProductName") + ",']").size() > 0);
    }

    @Then("User verifies {string} button is disabled")
    public void user_verifies_button_is_disabled(String anyButton) {
        captureScreenshot(driver, testContext, false);
        switch (anyButton) {
            case "Finished":
                Assert.assertTrue("Finished Button Is not disabled", onFinalizePage.getBtn_Continue().getAttribute("disabled").contains("true"));
                break;
            default:
                throw new FLException("Invalid ButtonType: " + anyButton);
        }
    }

    @Then("User verifies Any Application status as {string}")
    public void VerifyAnyApplicationStatusAs(String applicationStatus) {
        captureScreenshot(driver, testContext, false);
        waitForPageToLoad(driver);
        List<WebElement> productName = findElements(driver, "//div[@class='listRecent__name' and contains(@aria-label,'"+testContext.getMapTestData().get("product")+"')]//following-sibling::div//span[@class='orange']");
        boolean flag = false;
        for (WebElement singleProduct : productName) {
            if (singleProduct.getText().contains(applicationStatus)) {
                flag = true;
                break;
            }
        }
        Assert.assertTrue("Application status mismatched", flag);
    }

    @Then("User clicks on shared Activity Tab verifies the application is displayed")
    public void UserVerifiesTheApplicationIsDisplayed() {
        captureScreenshot(driver, testContext, false);
        clickElement(driver, onHomePage.getBtn_SharedActivity());
        waitForPageToLoad(driver);
        Assert.assertTrue("Application was not displayed", findElement(driver, "//div[@class='listRecent__name' and @aria-label='" + testContext.getMapTestData().get("newProductName") + ",']").isDisplayed());
    }

    @Then("User verifies Application status Text Color")
    public void UserVerifiesApplicationStatusTextColor() {
        captureScreenshot(driver, testContext, false);
            Assert.assertTrue("Application status Text Color Mismatched", findElement(driver, "//div[@class='listRecent__name' and @aria-label='" + testContext.getMapTestData().get("newProductName") + ",']//following-sibling::div//span[@class='orange']").getCssValue("color").contains(testContext.getMapTestData().get("textColor")));
    }
}
