package com.hexure.firelight.libraies;

import org.apache.commons.io.FileUtils;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageTree;
import org.apache.pdfbox.pdmodel.PDResources;
import org.apache.pdfbox.pdmodel.graphics.PDXObject;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;
import org.apache.pdfbox.text.PDFTextStripper;
import org.json.simple.parser.ParseException;
import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.*;
import java.sql.*;
import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FLUtilities extends BaseClass
{
    private static final Logger Log = LogManager.getLogger(FLUtilities.class);

    protected void syncElement(WebDriver driver, WebElement element, String conditionForWait)
    {
        try{
            switch (conditionForWait)
            {
                case "ToVisible":
                    new WebDriverWait(driver, 15)
                            .until(ExpectedConditions.visibilityOf(element));
                    break;

                case "ToClickable":
                    new WebDriverWait(driver, 15)
                            .until(ExpectedConditions.elementToBeClickable(element));
                    break;

                case "ToInvisible":
                    new WebDriverWait(driver, 15)
                            .until(ExpectedConditions.invisibilityOf(element));
                    break;

                case "AttrbuiteNotEmpty":
                    new WebDriverWait(driver,15)
                            .until(ExpectedConditions.attributeToBeNotEmpty(element,"value"));
                    break;
                case "AttributeContainsPercentage":
                    new WebDriverWait(driver,15)
                            .until(ExpectedConditions.attributeContains(element,"value","%"));
                    break;
                case "AttributeContainsDollar":
                    new WebDriverWait(driver,15)
                            .until(ExpectedConditions.attributeContains(element,"value","$"));
                    break;
                default:
                    throw new FLException("Invalid Condition " + conditionForWait);
            }
        }catch (StaleElementReferenceException e){}
        catch (Exception e)
        {
            Log.error("Could Not Sync WebElement ", e);
            throw new FLException("Could Not Sync WebElement " + e.getMessage());
        }
    }

    protected void syncMultipleElement(WebDriver driver, List<WebElement> elementsList, String conditionForWait)
    {
        try{
            switch (conditionForWait)
            {
                case "ToVisible":
                    new WebDriverWait(driver, 15).until(ExpectedConditions.visibilityOfAllElements(elementsList));
                    break;

                case "ToInvisible":
                    new WebDriverWait(driver, 15).until(ExpectedConditions.invisibilityOfAllElements(elementsList));
                    break;

                default:
                    throw new FLException("Invalid Condition " + conditionForWait);
            }
        }catch (Exception e)
        {
            Log.error("Could Not Sync WebElement ", e);
            throw new FLException("Could Not Sync WebElement " + e.getMessage());
        }
    }

    protected void clickElement(WebDriver driver, WebElement element)
    {
        syncElement(driver, element, EnumsCommon.TOCLICKABLE.getText());

        try{
            if(!element.isDisplayed()){
                scrollToWebElement(driver, element);
                element.click();
            }else{
                element.click();
            }
        }catch (StaleElementReferenceException s){
            element.click();
        }
        catch (Exception e){
            Log.error("Could Not Click WebElement ", e);
            throw new FLException("Could Not Click WebElement " + e.getMessage());
        }
    }

    protected void scrollToWebElement(WebDriver driver, WebElement element) {
        try{
            ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", element);
        }catch (Exception e){
            Log.error("Could Not Scroll WebElement ", e);
            throw new FLException("Could Not Scroll WebElement " + e.getMessage());
        }
    }

    protected void scrollToTopOfPage(WebDriver driver) {
        try{
            ((JavascriptExecutor) driver).executeScript("window.scrollTo({behavior: \"instant\", top: 0, left: 0})");
        }catch (Exception e){
            Log.error("Could Not Scroll WebElement ", e);
            throw new FLException("Could Not Scroll WebElement " + e.getMessage());
        }
    }


    protected void clickElementByJSE(WebDriver driver, WebElement element) {
        syncElement(driver, element, EnumsCommon.TOVISIBLE.getText());

        try{
            ((JavascriptExecutor)driver).executeScript("arguments[0].click();", element);
        }catch (Exception e){
            Log.error("Clicking WebElement By JavaScriptExecutor Failed ", e);
            throw new FLException("Clicking WebElement By JavaScriptExecutor Failed " + e.getMessage());
        }
    }

    protected void moveToElement(WebDriver driver, WebElement element)
    {
        try {
            new Actions(driver).moveToElement(element).build().perform();
        }catch (Exception e) {
            Log.error("Move MouseOver Action WebElement Failed ", e);
            throw new FLException("Move MouseOver Action WebElement Failed " + e.getMessage());
        }
    }

    protected void sendKeysThruAction(WebDriver driver, WebElement element, String stringToInput)
    {
        try {
            new Actions(driver).sendKeys(element,stringToInput);
        }catch (Exception e) {
            Log.error("SendKeys Thru Action Failed ", e);
            throw new FLException("SendKeys Thru Action Failed " + e.getMessage());
        }
    }

    protected void sendKeys(WebDriver driver, WebElement element, String stringToInput)
    {
        syncElement(driver, element, EnumsCommon.TOCLICKABLE.getText());
        try {
            element.clear();
            clickElement(driver, element);
            sleepInMilliSeconds(100);
            element.sendKeys(stringToInput);
            element.sendKeys(Keys.TAB);
        }catch (ElementClickInterceptedException s) {
            clickElementByJSE(driver, element);
            element.sendKeys(stringToInput);
            element.sendKeys(Keys.TAB);
        }
        catch (Exception e) {
            Log.error("SendKeys Failed ", e);
            throw new FLException(stringToInput + " could not be entered in element" + e.getMessage());
        }
        sleepInMilliSeconds(500);
    }

    protected void selectOptionFromList(WebDriver driver, List<WebElement> webElementList, String optionValue, String actionType)
    {
        try {
            for (WebElement webElement: webElementList){
                if (webElement.getText().trim().contains(optionValue.trim())){
                    if(actionType.trim().equalsIgnoreCase("click"))
                        clickElement(driver, webElement);
                    else
                        moveToElement(driver, webElement);
                }
            }
        }catch (StaleElementReferenceException e){}
        catch (Exception e) {
            Log.error("Clicking WebElement From List Failed ", e);
            throw new FLException("Clicking WebElement From List Failed " + e.getMessage());
        }

    }

    protected void selectOptionFromListByCase(WebDriver driver, List<WebElement> webElementList, String optionValue, String actionType)
    {
        try {
            for (WebElement webElement: webElementList){
                if (webElement.getText().trim().equalsIgnoreCase(optionValue.trim())){
                    if(actionType.trim().equalsIgnoreCase("click"))
                        clickElement(driver, webElement);
                    else
                        moveToElement(driver, webElement);
                }
            }
        }catch (StaleElementReferenceException e){}
        catch (Exception e) {
            Log.error("Clicking WebElement From List Failed ", e);
            throw new FLException("Clicking WebElement From List Failed " + e.getMessage());
        }

    }

    protected void sleepInMilliSeconds(int milliSeconds)
    {
        try {
            Thread.sleep(milliSeconds);
        } catch (InterruptedException e) {
            Log.error("Explicit Sleep Failed ", e);
            throw new FLException("Explicit Sleep Failed " + e.getMessage());
        }
    }

    protected Alert getAlert(TestContext testContext){
        return testContext.getDriver().switchTo().alert();
    }

    protected String getRandomString(int stringLength, String dataType)
    {
        StringBuilder builder = new StringBuilder();
        String stringType;

        switch (dataType)
        {
            case "Numbers":
                stringType = "0123456789";
                break;

            case "Alpha":
                stringType = "AaBbCcDdEeFfGgHhIiJjKkLlMmNnOoPpQqRrSsTtUuVvWwXxYyZz";
                break;

            case "AlphaNumbers":
                stringType = "A0a1B2b3C4c5D6d7E8e9F0f1G2g3H4h5I6i7J8j9K0k1L2l3M4m5N6n7O8o9P0p1Q2q3R4r5S6s7T8t9U0u1V2v3W4w5X6x7Y8y9Z0z1";
                break;

            default:
                Log.error("Invalid Datatype For Random String ");
                throw new FLException("Invalid Datatype For Random String ");
        }
        try{
            while (stringLength != 0)
            {
                int characterIndex = (int) (Math.random() * stringType.length());
                builder.append(stringType.charAt(characterIndex));
            }
        }catch (Exception e){
            Log.error("Random String Generation Failed ", e);
            throw new FLException("Random String Generation Failed " + e.getMessage());
        }

        return builder.toString();
    }

    protected void waitTilTextIsVisible(WebDriver driver, WebElement element){
        try {
            (new WebDriverWait(driver, 15)).until(new ExpectedCondition<Boolean>() {

                public Boolean apply(WebDriver driver1){

                    return element.getText().length() != 0;
                }
            });
        }catch (Exception e){
            Log.error("TEXT WAS NOT VISIBLE WITHIN GIVEN TIME");
            throw new FLException("TEXT WAS NOT VISIBLE WITHIN GIVEN TIME" + e);
        }
    }

    protected void waitTillTextIsReplaced(WebDriver driver, WebElement element, String expectedText){
        new WebDriverWait(driver, 15).until(ExpectedConditions.textToBePresentInElement(element, expectedText));
    }

    protected void setResultSet(TestContext testContext, String query) {
        
        createConnection(testContext);

        try {
            testContext.setStatement(testContext.getConnection().createStatement());
            testContext.setResultSet(testContext.getStatement().executeQuery(query));
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    private void createConnection(TestContext testContext) {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Connecting to Database...");
            testContext.setConnection(DriverManager.getConnection("jdbc:mysql://freeonlineDB.net:3306/dbName", "username", "password"));
            if (testContext.getConnection() != null) {
                System.out.println("Connection Hashcode " + testContext.getConnection().hashCode());
                System.out.println("Connected to the Database...");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }

    protected void closeDBResources(TestContext testContext){
        try {
            if (testContext.getResultSet() != null){
                System.out.println("ResultSet closing...");
                testContext.getResultSet().close();
                System.out.println("ResultSet closed");
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        try {
            if (testContext.getStatement() != null){
                System.out.println("Statement closing...");
                testContext.getStatement().close();
                System.out.println("Statement closed");
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        try {
            if (testContext.getConnection() != null){
                System.out.println("Connection closing...");
                testContext.getConnection().close();
                System.out.println("Connection closed");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    protected void waitUntilDropDownListPopulated(WebDriver driver, Select dropdown)
    {
        try{
            FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver);
            wait.pollingEvery(250,  TimeUnit.MILLISECONDS);
            wait.withTimeout(15, TimeUnit.SECONDS);
            wait.ignoring(NoSuchElementException.class);

            Function<WebDriver, Boolean> function = arg0 -> {
                return dropdown.getOptions().size() > 3;
            };

            wait.until(function);

        }catch (StaleElementReferenceException se){}
        catch (Exception e) {}
    }

    protected void addDigitalSignature(WebDriver driver, WebElement element) {
        try {
            Actions builder = new Actions(driver);
            scrollToWebElement(driver, element);
            builder.moveToElement(element).perform();
            builder.clickAndHold(element).perform();
            builder.moveByOffset(0, -90).perform();
            builder.moveToElement(element).perform();
            builder.clickAndHold(element).perform();
            builder.moveByOffset(0, 75).perform();
            builder.moveToElement(element).perform();
            builder.clickAndHold(element).perform();
            builder.moveByOffset(150, 0).perform();
            builder.moveToElement(element).perform();
            builder.clickAndHold(element).perform();
            builder.moveByOffset(-150, 0).perform();
            builder.moveToElement(element).perform();

            builder.moveToElement(element).perform();
            builder.clickAndHold(element).perform();
            builder.moveByOffset(0, -90).perform();
            builder.moveToElement(element).perform();
            builder.clickAndHold(element).perform();
            builder.moveByOffset(0, 75).perform();
            builder.moveToElement(element).perform();
            builder.clickAndHold(element).perform();
            builder.moveByOffset(150, 0).perform();
            builder.moveToElement(element).perform();
            builder.clickAndHold(element).perform();
            builder.moveByOffset(-150, 0).perform();
            builder.moveToElement(element).perform();
      } catch (Exception e) {
            Log.error("Adding Digital Signature Failed", e);
            throw new FLException("Adding Digital Signature Failed " + e.getMessage());
        }
    }

    protected  String getPDFText(String pdfFileName) {

        String pdfText;

        try {
            File pdfFile = new File (EnumsCommon.RELATIVE_DOWNLOADFILES_PATH.getText() + pdfFileName);
            PDDocument pdfDocument = PDDocument.load(new FileInputStream(pdfFile));
            pdfText = new PDFTextStripper().getText(pdfDocument);
            pdfDocument.close();
        } catch (FileNotFoundException e) {
            Log.error("PDF File Could Not Find ", e);
            throw new FLException("PDF File Could Not Find" + e.getMessage());
        } catch (IOException e) {
            Log.error("IO Exception ", e);
            throw new FLException("IO Exception " + e.getMessage());
        } catch (Exception e) {
            Log.error("Exception ", e);
            throw new FLException("Exception " + e.getMessage());
        }

        return pdfText;
    }

    protected void renameFile(String oldFileName, String newFileName) throws IOException {
        Path source = Paths.get(EnumsCommon.ABSOLUTE_DOWNLOADFILES_PATH.getText()+ oldFileName +".pdf");
        Files.move(source, source.resolveSibling(newFileName));
    }


    protected void clickElement(WebDriver driver, String stringXpath)
    {
        WebElement element= driver.findElement(By.xpath(stringXpath));
        syncElement(driver, element, EnumsCommon.TOCLICKABLE.getText());

        try{
            if(!element.isDisplayed()){
                scrollToWebElement(driver, element);
                element.click();
            }else{
                element.click();
            }
        }catch (Exception e){
            Log.error("Could Not Click WebElement ", e);
            throw new FLException("Could Not Click WebElement " + e.getMessage());
        }
    }

    public WebElement findElement(WebDriver driver,String stringXpath)
    {
        WebElement element= driver.findElement(By.xpath(stringXpath));
        syncElement(driver, element, EnumsCommon.TOVISIBLE.getText());
        return element;
    }

    public List<WebElement> findElements(WebDriver driver,String stringXpath)
    {
        List<WebElement> element= driver.findElements(By.xpath(stringXpath));
        return element;
    }

    public void PDFBoxExtractImages(String pdfLocation, String pdfFleName, TestContext testContext) {
        PDDocument document = null;
        try {
            document = PDDocument.load(new File(pdfLocation));
            File imagesFolder = new File(configProperties.get("imagesFolder.path") + testContext.getTestCaseID() + "/" + pdfFleName.replace(".pdf","") + "/");
            if(!imagesFolder.exists())
                imagesFolder.mkdirs();
            PDPageTree pageList = document.getPages();
            for (PDPage page : pageList) {
                PDResources pdResources = page.getResources();
                for (COSName object : pdResources.getXObjectNames()) {
                    PDXObject pdxObject = null;
                    pdxObject = pdResources.getXObject(object);
                    if (pdxObject instanceof PDImageXObject) {
                        File file = new File(configProperties.get("imagesFolder.path") + testContext.getTestCaseID() + "/" + pdfFleName.replace(".pdf","") + "/" + System.nanoTime() + ".png");
                        ImageIO.write(((PDImageXObject) pdxObject).getImage(), "png", file);
                    }
                }
            }
        } catch (FileNotFoundException e)
        {
            Log.error("PDF File Could Not Be Loaded ", e);
            throw new FLException("PDF File Could Not Be Loaded " + e.getMessage());
        }
        catch (IOException e) {
            Log.error("Could Not Read PDF File ", e);
            throw new FLException("Could Not Read PDF File " + e.getMessage());
        } catch (Exception e) {
            Log.error("Could Not Read Image Content From PDF Document ", e);
            throw new FLException("Could Not Read Image Content From PDF Document " + e.getMessage());
        }
    }

    protected boolean verifySignatureMatchingInPDF(TestContext testContext, String path)  {
        String expectedImagePath = "";
        nu.pattern.OpenCV.loadLocally();
        String[] listImagePath = new String[]{"SignedMVC","SignedMVC1","SignedMVC2","SignedMVC3","SignedMVC4","SignedMVC5","SignedReact","SignedReact1","SignedReact2","SignedReact3"};

        PDFBoxExtractImages(EnumsCommon.RELATIVE_DOWNLOADFILES_PATH.getText() + path, path.replace(".pdf",""), testContext);

        // Source directory containing the images
        File sourceDir = new File(configProperties.get("imagesFolder.path") + testContext.getTestCaseID() +  "/" + path.replace(".pdf","") + "/");

        int counter = 0;

        for(String image : listImagePath) {
            // Iterate through the images in the source directory
            expectedImagePath = configProperties.get("signedImagesFolder.path") + "/" + image + ".png";
            Mat subImage = Imgcodecs.imread(expectedImagePath);
            for (File file : sourceDir.listFiles()) {
                if (file.isFile()) {
                    // Load the current image into memory
                    Mat mainImage = Imgcodecs.imread(file.getPath());
                    // Check if the sub-image is present in the current image
                    if (verifySubImagePresent(mainImage, subImage))
                        counter++;
                }
            }
        }

        if(counter > 0)
            return true;

        return false;
    }

    private boolean verifySubImagePresent(Mat mainImage, Mat subImage) {
        Mat result = new Mat();

        if (mainImage.height() < subImage.height() || mainImage.width() < subImage.width())
            return false;
        else{
            Imgproc.matchTemplate(mainImage, subImage, result, Imgproc.TM_CCOEFF_NORMED);
            Core.MinMaxLocResult mmr = Core.minMaxLoc(result);
            // Define a threshold for similarity
            double threshold = 0.7; // Adjust this as needed
            return mmr.maxVal > threshold;

        }
    }

    protected List<WebElement> getElements(WebDriver driver, By locator) {
        try
        {
            return driver.findElements(locator);
        }
        catch(Exception e)
        {
            Log.error("Could not find elements with locator " + locator, e);
            throw new FLException("Could not find elements with locator >>>> " + e.getMessage());
        }
    }

    protected WebElement getElement(WebDriver driver, By locator) {
        try
        {
            syncElement(driver, driver.findElement(locator),EnumsCommon.TOVISIBLE.getText());
            return driver.findElement(locator);
        }
        catch(Exception e)
        {
            Log.error("Could not find any element with locator " + locator, e);
            throw new FLException("Could not find any element with locator >>>> " + e.getMessage());
        }
    }

    public By getExistingLocator(WebDriver driver, By locator, By locator1, By locator2, By locator3) {
        try {
            if (getElements(driver, locator).size() > 0)
                return locator;
            else if (getElements(driver, locator1).size() > 0)
                return locator1;
            else if (getElements(driver, locator2).size() > 0)
                return locator2;
            else if (getElements(driver, locator3).size() > 0)
                return locator3;
        } catch (StaleElementReferenceException e) { }
        catch (Exception e) {}
        return null;
    }

    protected void checkBoxSelectYesNO(String userAction, WebElement element) {
        if (getCheckBoxAction(userAction)){
            if (!element.isSelected())
                element.click();
        }else {
            if (element.isSelected())
                element.click();
        }
    }

    private boolean getCheckBoxAction(String action) {
        return action.equalsIgnoreCase("select");
    }
    protected void scrollInBrowserTillEnd(WebDriver driver) {
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }

    protected void waitForAdminCacheTime(TestContext testContext) {
        sleepInMilliSeconds(Integer.parseInt(testContext.getAdminCacheTime()) * 60000);
    }
}
