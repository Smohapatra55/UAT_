package com.hexure.firelight.libraies;

import com.hexure.firelight.libraies.pages_react.CommonMethods_ReactPage;
import com.hexure.firelight.libraies.pages_react.CreateApplication_ReactPage;
import com.hexure.firelight.libraies.pages_react.DataEntry_ReactPage;
import com.hexure.firelight.pages.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

public class PageObjectManager extends BaseClass
{
    private WebDriver driver;
    private LoginPage onLoginPage;
    private HomePage onHomePage;
    private CreateApplicationPage onCreateApplicationPage;
    private DataEntryPage onDataEntryPage;
    private ReviewPage onReviewPage;
    private SignaturesPage onSignaturesPage;
    private SSNHomePage onSSNHomePage;
	private ExternalLoginPage onExternalLoginPage;
	private SignApplicationPage onSignApplicationPage;
	private FinalizePage onFinalizePage;
	private CommonMethodsPage onCommonMethodsPage;
	private CreateApplication_ReactPage onCreateApplication_reactPage;
	private CommonMethods_ReactPage onCommonMethods_reactPage;
	private DataEntry_ReactPage onDataEntryReactPage;

	private TabAppPage onTabAppPage;
	private EnrollmentPage onEnrollmentPage;

	private static final Logger Log = LogManager.getLogger(PageObjectManager.class);

	public PageObjectManager(WebDriver driver)
    {
        this.driver = driver;
    }

	public LoginPage getLoginPage()	{
		try{
			return (onLoginPage == null) ? onLoginPage = new LoginPage(driver) : onLoginPage;
		} catch (Exception e){
			Log.error("Instance creations of LoginPage Failed ", e);
			throw new FLException("Instance creations of LoginPage Failed " + e.getMessage());
		}
	}

	public HomePage getHomePage()	{
		try{
			return (onHomePage == null) ? onHomePage = new HomePage(driver) : onHomePage;
		} catch (Exception e){
			Log.error("Instance creations of HomePage Failed ", e);
			throw new FLException("Instance creations of HomePage Failed " + e.getMessage());
		}
	}

	public CreateApplicationPage getCreateApplicationPage()	{
		try{
			return (onCreateApplicationPage == null) ? onCreateApplicationPage = new CreateApplicationPage(driver) : onCreateApplicationPage;
		} catch (Exception e){
			Log.error("Instance creations of CreateApplicationPage Failed ", e);
			throw new FLException("Instance creations of CreateApplicationPage Failed " + e.getMessage());
		}
	}

	public DataEntryPage getDataEntryPage()	{
		try{
			return (onDataEntryPage == null) ? onDataEntryPage = new DataEntryPage(driver) : onDataEntryPage;
		} catch (Exception e){
			Log.error("Instance creations of DataEntryPage Failed ", e);
			throw new FLException("Instance creations of DataEntryPage Failed " + e.getMessage());
		}
	}

	public ReviewPage getReviewPage()	{
		try{
			return (onReviewPage == null) ? onReviewPage = new ReviewPage(driver) : onReviewPage;
		} catch (Exception e){
			Log.error("Instance creations of ReviewPage Failed ", e);
			throw new FLException("Instance creations of ReviewPage Failed " + e.getMessage());
		}
	}


	public SignaturesPage getOnSignaturesPage()	{
		try{
			return (onSignaturesPage == null) ? onSignaturesPage = new SignaturesPage(driver) : onSignaturesPage;
		} catch (Exception e){
			Log.error("Instance creations of SignaturesPage Failed ", e);
			throw new FLException("Instance creations of SignaturesPage Failed " + e.getMessage());
		}
	}






	public SSNHomePage getSSNHomePage()	{
		try{
			return (onSSNHomePage == null) ? onSSNHomePage = new SSNHomePage(driver) : onSSNHomePage;
		} catch (Exception e){
			Log.error("Instance creations of SSNHomePage Failed ", e);
			throw new FLException("Instance creations of SSNHomePage Failed " + e.getMessage());
		}
	}









	public ExternalLoginPage getOnExternalLoginPage() {
		try {
			return (onExternalLoginPage == null) ? onExternalLoginPage = new ExternalLoginPage(driver) : onExternalLoginPage;
		} catch (Exception e) {
			Log.error("Instance creations of ExternalLoginPage Failed ", e);
			throw new FLException("Instance creations of ExternalLoginPage Failed " + e.getMessage());
		}
	}

	public SignApplicationPage getOnSignApplicationPage()	{
		try{
			return (onSignApplicationPage == null) ? onSignApplicationPage = new SignApplicationPage(driver) : onSignApplicationPage;
		} catch (Exception e){
			Log.error("Instance creations of SignApplicationPage Failed ", e);
			throw new FLException("Instance creations of SignApplicationPage Failed " + e.getMessage());
		}
	}

	public FinalizePage getOnFinalizePage() {
		try {
			return (onFinalizePage == null) ? onFinalizePage = new FinalizePage(driver) : onFinalizePage;
		} catch (Exception e) {
			Log.error("Instance creations of FinalizePage Failed ", e);
			throw new FLException("Instance creations of FinalizePage Failed " + e.getMessage());
		}
	}



	public CommonMethodsPage getCommonMethodPage()	{
		try{
			return (onCommonMethodsPage == null) ? onCommonMethodsPage = new CommonMethodsPage(driver) : onCommonMethodsPage;
		} catch (Exception e){
			Log.error("Instance creations of CommonMethodsPage Failed ", e);
			throw new FLException("Instance creations of CommonMethodsPage Failed " + e.getMessage());
		}
	}


//************* React POJO





	public CreateApplication_ReactPage getCreateApplication_reactPage()	{
		try{
			return (onCreateApplication_reactPage == null) ? onCreateApplication_reactPage = new CreateApplication_ReactPage(driver) : onCreateApplication_reactPage;
		} catch (Exception e){
			Log.error("Instance creations of CreateApplication_ReactPage Failed ", e);
			throw new FLException("Instance creations of CreateApplication_ReactPage Failed " + e.getMessage());
		}
	}

	public CommonMethods_ReactPage getCommonMethods_reactPage()	{
		try{
			return (onCommonMethods_reactPage == null) ? onCommonMethods_reactPage = new CommonMethods_ReactPage(driver) : onCommonMethods_reactPage;
		} catch (Exception e){
			Log.error("Instance creations of CommonMethods_ReactPage Failed ", e);
			throw new FLException("Instance creations of CommonMethods_ReactPage Failed " + e.getMessage());
		}
	}

	public DataEntry_ReactPage getDataEntryReactPage()	{
		try{
			return (onDataEntryReactPage == null) ? onDataEntryReactPage = new DataEntry_ReactPage(driver) : onDataEntryReactPage;
		} catch (Exception e){
			Log.error("Instance creations of DataEntry_ReactPage Failed ", e);
			throw new FLException("Instance creations of DataEntry_ReactPage Failed " + e.getMessage());
		}
	}


	public TabAppPage getOnTabAppPage()	{
		try{
			return (onTabAppPage == null) ? onTabAppPage = new TabAppPage(driver) : onTabAppPage;
		} catch (Exception e){
			Log.error("Instance creations of TabAppPage Failed ", e);
			throw new FLException("Instance creations of TabAppPage Failed " + e.getMessage());
		}
	}

	public EnrollmentPage getOnEnrollmentPage(){
		try{
			return (onEnrollmentPage == null) ? onEnrollmentPage = new EnrollmentPage(driver) : onEnrollmentPage;
		} catch (Exception e){
			Log.error("Instance creations of EnrollmentPage Failed ", e);
			throw new FLException("Instance creations of EnrollmentPage Failed " + e.getMessage());
		}
	}
}
