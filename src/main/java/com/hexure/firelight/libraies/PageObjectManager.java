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
    private ReviewQueuePage onReviewQueuePage;
    private HistoryPage onHistoryPage;
	private FinishPage onFinishPage;
    private LoginSSNPage onLoginSSNPage;
    private SSNHomePage onSSNHomePage;
    private HistoryPopupPage onHistoryPopupPage;
	private SelectDocumentsToPrintPage onSelectDocumentsToPrintPage;
	private PartyEntryPage onPartyEntryPage;
	private RCTCompleteFillingAndSigningPage onRCTCompleteFillingAndSigningPage;
	private RequestSentPage onRequestSentPage;
	private ExternalLoginPage onExternalLoginPage;
	private SignApplicationPage onSignApplicationPage;
	private FinalizePage onFinalizePage;
	private RCTCompleteFillingAppPage onRCTCompleteFillingAppPage;
	private EasySigningFormPage onEasySigningFormPage;
	private ExternalURLPage onExternalURLPage;
	private CommonMethodsPage onCommonMethodsPage;
	private CreateApplication_ReactPage onCreateApplication_reactPage;
	private CommonMethods_ReactPage onCommonMethods_reactPage;
	private DataEntry_ReactPage onDataEntryReactPage;
	private ReviewerDocumentsPage onReviewerDocumentsPage;
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

	public ReviewQueuePage getOnReviewQueuePage()	{
		try{
			return (onReviewQueuePage == null) ? onReviewQueuePage = new ReviewQueuePage(driver) : onReviewQueuePage;
		} catch (Exception e){
			Log.error("Instance creations of ReviewQueuePage Failed ", e);
			throw new FLException("Instance creations of ReviewQueuePage Failed " + e.getMessage());
		}
	}

	public HistoryPage getOnHistoryPage()	{
		try{
			return (onHistoryPage == null) ? onHistoryPage = new HistoryPage(driver) : onHistoryPage;
		} catch (Exception e){
			Log.error("Instance creations of HistoryPage Failed ", e);
			throw new FLException("Instance creations of HistoryPage Failed " + e.getMessage());
		}
	}

	public LoginSSNPage getLoginSSNPage()	{
		try{
			return (onLoginSSNPage == null) ? onLoginSSNPage = new LoginSSNPage(driver) : onLoginSSNPage;
		} catch (Exception e){
			Log.error("Instance creations of LoginSSNPage Failed ", e);
			throw new FLException("Instance creations of LoginSSNPage Failed " + e.getMessage());
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

	public FinishPage getFinishPage()	{
		try{
			return (onFinishPage == null) ? onFinishPage = new FinishPage(driver) : onFinishPage;
		} catch (Exception e){
			Log.error("Instance creations of FinishPage Failed ", e);
			throw new FLException("Instance creations of FinishPage Failed " + e.getMessage());
		}
	}

	public HistoryPopupPage getHistoryPopupPage()	{
		try{
			return (onHistoryPopupPage == null) ? onHistoryPopupPage = new HistoryPopupPage(driver) : onHistoryPopupPage;
		} catch (Exception e){
			Log.error("Instance creations of HistoryPopupPage Failed ", e);
			throw new FLException("Instance creations of HistoryPopupPage Failed " + e.getMessage());
		}
	}

	public PartyEntryPage getPartyEntryPage()	{
		try{
			return (onPartyEntryPage == null) ? onPartyEntryPage = new PartyEntryPage(driver) : onPartyEntryPage;
		} catch (Exception e){
			Log.error("Instance creations of PartyEntryPage Failed ", e);
			throw new FLException("Instance creations of PartyEntryPage Failed " + e.getMessage());
		}
	}

	public RCTCompleteFillingAndSigningPage getonRCTCompleteFillingAndSigningPage()	{
	try{
		return (onRCTCompleteFillingAndSigningPage == null) ? onRCTCompleteFillingAndSigningPage = new RCTCompleteFillingAndSigningPage(driver) : onRCTCompleteFillingAndSigningPage;
	} catch (Exception e){
		Log.error("Instance creations of RCT_Complete_Filling_and_SigningPage Failed ", e);
		throw new FLException("Instance creations of RCT_Complete_Filling_and_SigningPage Failed " + e.getMessage());
	}
}
	public RequestSentPage getOnRequestSentPage()	{
		try{
			return (onRequestSentPage == null) ? onRequestSentPage = new RequestSentPage(driver) : onRequestSentPage;
		} catch (Exception e){
			Log.error("Instance creations of RequestSentPage Failed ", e);
			throw new FLException("Instance creations of RequestSentPage Failed " + e.getMessage());
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

	public SelectDocumentsToPrintPage getSelectDocumentsToPrintPage()	{
		try{
			return (onSelectDocumentsToPrintPage == null) ? onSelectDocumentsToPrintPage = new SelectDocumentsToPrintPage(driver) : onSelectDocumentsToPrintPage;
		} catch (Exception e){
			Log.error("Instance creations of SelectDocumentsToPrintPage Failed ", e);
			throw new FLException("Instance creations of SelectDocumentsToPrintPage Failed " + e.getMessage());
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

	public ExternalURLPage getExternalURLPage()	{
		try{
			return (onExternalURLPage == null) ? onExternalURLPage = new ExternalURLPage(driver) : onExternalURLPage;
		} catch (Exception e){
			Log.error("Instance creations of ExternalURLPage Failed ", e);
			throw new FLException("Instance creations of ExternalURLPage Failed " + e.getMessage());
		}
	}
//************* React POJO

	public RCTCompleteFillingAppPage getRCTCompleteFillingAppPage()	{
		try{
			return (onRCTCompleteFillingAppPage == null) ? onRCTCompleteFillingAppPage = new RCTCompleteFillingAppPage(driver) : onRCTCompleteFillingAppPage;
		} catch (Exception e){
			Log.error("Instance creations of RCTCompleteFillingAppPage Failed ", e);
			throw new FLException("Instance creations of RCTCompleteFillingAppPage Failed " + e.getMessage());
		}
	}

	public EasySigningFormPage getEasySigningFormPage()	{
		try{
			return (onEasySigningFormPage == null) ? onEasySigningFormPage = new EasySigningFormPage(driver) : onEasySigningFormPage;
		} catch (Exception e){
			Log.error("Instance creations of EasySigningFormPage Failed ", e);
			throw new FLException("Instance creations of EasySigningFormPage Failed " + e.getMessage());
		}
	}

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

	public ReviewerDocumentsPage getReviewerDocumentsPage()	{
		try{
			return (onReviewerDocumentsPage == null) ? onReviewerDocumentsPage = new ReviewerDocumentsPage(driver) : onReviewerDocumentsPage;
		} catch (Exception e){
			Log.error("Instance creations of ReviewerDocumentsPage Failed ", e);
			throw new FLException("Instance creations of ReviewerDocumentsPage Failed " + e.getMessage());
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
