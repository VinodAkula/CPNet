package Execute;

import java.io.File;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.connectpronetqa.AuthroizedPayment;
import com.connectpronetqa.EmailVerifications;
import com.connectpronetqa.EventRegistrationPage;
import com.connectpronetqa.GetScreenShot;
import com.connectpronetqa.LoginPage;
import com.connectpronetqa.MyEventsPage;
import com.connectpronetqa.PaymentGatewayPage;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Helper.Browser;

public class TM_002EventRegistrationTestCases{
	
	ExtentReports extent;
	ExtentTest logger;
	Browser browser;
	WebDriver driver;
	EventRegistrationPage ABR;
	//App login deatils
	String AppLoginEmailID="sasiakula99@yahoo.com";
	String AppLoginPwd="Admin@123";
	//Event To be register
	String EventToBeRegistered="nyc";
	//Attendee details
	String AttendeeEmailID="andrew74444@gmail.com";
	String AttendeeFirstName="Andrew";
	String AttendeelastName="Thomson";
	String AttendeeCompanyName="Pamten";
	String AttendeeGmailLoginID=AttendeeEmailID;
	String AttendeeGmailpwd="1237asdf";

	
	//Payer Details
	String PayerEmailID="andrew74444@gmail.com";
	String PayerFirstName="Andrew";
	String PayerlastName="Thomson";
	String PayerCompanyName="Pamten";
	//Promocodes
	String PromoCode1 ="3W1ZDSIWWX";
	String PromoCode2 ="4K9PFU3X1N";
	//Paypal login Credentails
	String PaypalLoginEmailID="andrew74444@gmail.com";
	String paypalLoginPwd="Admin@123";
	//Authorized Payment Deatils
	String AuthorizedPayerEmailId ="andrew74444@gmail.com"; 
	String CardNo="4242424242424242";
	String ExpDate=	"0333";
	String Cvv="333";
	String FirstName= "Andrew";
	String Lastname="thomson";
	String Zip="500081";
	String Address="Madhapur";
	String City="Hyderabad";
	String PhNo="7075637121";
	
	
	@BeforeTest
	public void startReport(){
		extent = new ExtentReports(System.getProperty("user.dir") +"/test-output/EventRegistrationTestReport.html", true);
		extent
                //.addSystemInfo("Host Name", "Hyderabad")
                .addSystemInfo("Environment", "QA")
                .addSystemInfo("User Name", "Sasi Vnod");
        extent.loadConfig(new File(System.getProperty("user.dir")+"\\extent-config.xml"));
	}
	@Test(priority = 1,groups=("EventRegistration"), enabled = false)
	public void EventRegistrationbyPayPalPayment() throws Exception
	{
		logger = extent.startTest("Event Registration by PayPal Gateway");
		driver = Browser.startBrowser("firefox","https://connectpronetqa.azurewebsites.net/Event/Details/NYC-Vegetarian-Food-Festival-2018/43");
    	//LoginPage Login_Page = PageFactory.initElements(driver, LoginPage.class);
    	//Login_Page.login(AppLoginEmailID, AppLoginPwd, logger);
    	EventRegistrationPage EventRegistration_Page=PageFactory.initElements(driver, EventRegistrationPage.class);
    	//EventRegistration_Page.OpenEventDetailspage(EventToBeRegistered, logger);
    	//EventRegistration_Page.GoToTab("2");
    	EventRegistration_Page.FillRegistrationDetails( AttendeeEmailID, AttendeeFirstName, AttendeelastName, AttendeeCompanyName, PayerEmailID,  PayerFirstName,  logger);
    	PaymentGatewayPage PaymentGateway_Page = PageFactory.initElements(driver, PaymentGatewayPage.class);
    	PaymentGateway_Page.PayPalpayment(PaypalLoginEmailID, paypalLoginPwd, logger);
    	EventRegistration_Page.PaymentSuccess(logger);
    		
	}
	@Test(priority = 2,groups=("EventRegistration"), enabled = true)
	public void EventRegistrationNotification() throws Exception
	{
		logger = extent.startTest("Event Registration Notification");
		driver = Browser.startBrowser("firefox","https://www.google.com/gmail/");
		EmailVerifications Email_Verifications = PageFactory.initElements(driver, EmailVerifications.class);
		Email_Verifications.EmailLogin(AttendeeGmailLoginID, AttendeeGmailpwd, logger);
		Email_Verifications.EmailNotification(logger);
	}
	@Test(priority = 3,groups=("EventRegistration"), enabled = true)
	public void EventTrasactionNotification() throws Exception
	{
		logger = extent.startTest("Event Trasaction Notification");
		driver = Browser.startBrowser("firefox","https://www.google.com/gmail/");
		EmailVerifications Email_Verifications = PageFactory.initElements(driver, EmailVerifications.class);
		Email_Verifications.EmailLogin(AttendeeGmailLoginID, AttendeeGmailpwd, logger);
		Email_Verifications.EmailNotification(logger);
	}
	@Test(priority = 4,groups=("EventRegistration"), enabled = false)
	public void ResendEventRegistrationconfirmation() throws Exception
	{
		logger = extent.startTest("Resend Event Registration confirmation");
		driver = Browser.startBrowser("firefox","https://connectpronetqa.azurewebsites.net/");
    	EventRegistrationPage EventRegistration_Page=PageFactory.initElements(driver, EventRegistrationPage.class);
    	EventRegistration_Page.OpenEventDetailspage("nyc", logger);
    	EventRegistration_Page.GoToTab("2");
    	EventRegistration_Page.ResendRegistrationEmailConfirmation("andrew74444@gmail.com", logger);
	}
	@Test(priority = 1,groups=("EventRegistration"), enabled = true)
	public void EventRegistrationbyAuthorizedPayment() throws Exception
	{
		logger = extent.startTest("Event Registration by Authorized Payment");
		driver = Browser.startBrowser("firefox","https://connectpronetqa.azurewebsites.net/");
    	EventRegistrationPage EventRegistration_Page=PageFactory.initElements(driver, EventRegistrationPage.class);
    	EventRegistration_Page.OpenEventDetailspage(EventToBeRegistered, logger);
    	EventRegistration_Page.GoToTab("2");
    	EventRegistration_Page.FillRegistrationDetails(AttendeeEmailID, AttendeeFirstName, AttendeelastName,AttendeeCompanyName, PayerEmailID, PayerFirstName, logger);
    	EventRegistration_Page.AuthorizedPayment(logger);
    	PaymentGatewayPage PaymentGateway_Page = PageFactory.initElements(driver, PaymentGatewayPage.class);     	
    	PaymentGateway_Page.AuthroizedGateway( AuthorizedPayerEmailId, CardNo, ExpDate, Cvv, FirstName, Lastname,Zip, Address, City, PhNo, logger);
    	EventRegistration_Page.PaymentSuccess(logger);
    	
	}
	@Test(priority = 6,groups=("EventRegistration"), enabled = false)
	public void GuestUserNotabletoBuyMemberandEMTickets() throws Exception
	{
		logger = extent.startTest("Verify Guest User able to Buy Member and EM Ticket");
		driver = Browser.startBrowser("firefox","https://connectpronetqa.azurewebsites.net/");
    	EventRegistrationPage EventRegistration_Page=PageFactory.initElements(driver, EventRegistrationPage.class);
    	EventRegistration_Page.OpenEventDetailspage("nyc", logger);
    	EventRegistration_Page.GoToTab("2");
    	EventRegistration_Page.GuestUserTickets(logger);
    	
	}
	@Test(priority = 7,groups=("EventRegistration"), enabled = false)
	public void MemberNotabletoBuyEMTicket() throws Exception
	{
		logger = extent.startTest("Verify Member able to Buy EM Ticket");
		driver = Browser.startBrowser("firefox","https://connectpronetqa.azurewebsites.net/");
    	LoginPage Login_Page = PageFactory.initElements(driver, LoginPage.class);
    	Login_Page.login(AppLoginEmailID, AppLoginPwd, logger);
    	EventRegistrationPage EventRegistration_Page=PageFactory.initElements(driver, EventRegistrationPage.class);
    	EventRegistration_Page.OpenEventDetailspage("nyc", logger);
    	EventRegistration_Page.GoToTab("2");
    	EventRegistration_Page.MemberTickets(logger);
	}
	
	
	@Test(priority = 8,groups=("EventRegistration"), enabled = false)
	public void AuthorizedPaymentwithPromocode() throws Exception
	{
		logger = extent.startTest("Authorized Payment with Promocode");
		driver = Browser.startBrowser("firefox","https://connectpronetqa.azurewebsites.net/");
    	LoginPage Login_Page = PageFactory.initElements(driver, LoginPage.class);
    	Login_Page.login(AppLoginEmailID, AppLoginPwd, logger);
    	EventRegistrationPage EventRegistration_Page=PageFactory.initElements(driver, EventRegistrationPage.class);
    	EventRegistration_Page.OpenEventDetailspage("nyc", logger);
    	EventRegistration_Page.GoToTab("2");
    	EventRegistration_Page.FillRegistrationDetails(AttendeeEmailID, AttendeeFirstName, AttendeelastName,AttendeeCompanyName, PayerEmailID, PayerFirstName, logger);
    	EventRegistration_Page.Promocode(PromoCode1, logger);
    	EventRegistration_Page.AuthorizedPayment(logger);
    	PaymentGatewayPage PaymentGateway_Page=PageFactory.initElements(driver, PaymentGatewayPage.class);
    	PaymentGateway_Page.AuthroizedGateway( AuthorizedPayerEmailId, CardNo, ExpDate, Cvv, FirstName, Lastname,Zip, Address, City, PhNo, logger);
    	EventRegistration_Page.PaymentSuccess(logger);
    	
	}
	
	@Test(priority = 9,groups=("EventRegistration"), enabled = false)
	public void PayPalPaymentwithPromocode() throws Exception
	{
		logger = extent.startTest("PayPal Payment with Promocode");
		driver = Browser.startBrowser("firefox","https://connectpronetqa.azurewebsites.net/");
    	LoginPage Login_Page = PageFactory.initElements(driver, LoginPage.class);
    	Login_Page.login(AppLoginEmailID, AppLoginPwd, logger);
    	EventRegistrationPage EventRegistration_Page=PageFactory.initElements(driver, EventRegistrationPage.class);
    	EventRegistration_Page.OpenEventDetailspage("nyc", logger);
    	EventRegistration_Page.GoToTab("2");
    	EventRegistration_Page.FillRegistrationDetails(AttendeeEmailID, AttendeeFirstName, AttendeelastName,AttendeeCompanyName, PayerEmailID, PayerFirstName, logger);
    	EventRegistration_Page.Promocode(PromoCode2, logger);
    	PaymentGatewayPage PaymentGateway_Page=PageFactory.initElements(driver, PaymentGatewayPage.class);
    	PaymentGateway_Page.PayPalpayment(PaypalLoginEmailID, paypalLoginPwd, logger);
    	EventRegistration_Page.PaymentSuccess(logger);
	}
	
	//=========================================================================================================================
@Test(priority = 10,groups=("EventRegistration"), enabled = false)
	
	public void RegisteredAttendeeInViewAttendees() throws Exception
	{
		logger = extent.startTest("Registered Attendee In View Attendees");
		driver = Browser.startBrowser("firefox","https://connectpronetqa.azurewebsites.net/");
    	LoginPage Login_Page = PageFactory.initElements(driver, LoginPage.class);
    	Login_Page.login(AppLoginEmailID, AppLoginPwd, logger);
    	EventRegistrationPage EventRegistration_Page=PageFactory.initElements(driver, EventRegistrationPage.class);
    	EventRegistration_Page.OpenEventDetailspage("nyc", logger);
    	EventRegistration_Page.GoToTab("2");
    	EventRegistration_Page.EventAttendees(AttendeeFirstName,AttendeelastName,AttendeeCompanyName, "firefox",logger);
    	ABR =new EventRegistrationPage(driver);
    	int EABR  = ABR.TABR();
		logger.log(LogStatus.INFO, "Total Attendees before event registration with the member name "+ AttendeeFirstName+" "+AttendeelastName+" ==== "+EABR);
		EventRegistration_Page.BackToEventDetailsPage();
		EventRegistration_Page.FillRegistrationDetails(AttendeeEmailID, AttendeeFirstName, AttendeelastName, AttendeeCompanyName, PayerEmailID, PayerFirstName, logger);
		PaymentGatewayPage PaymentGateway_Page = PageFactory.initElements(driver, PaymentGatewayPage.class);
    	PaymentGateway_Page.PayPalpayment(PaypalLoginEmailID, paypalLoginPwd, logger);
    	EventRegistration_Page.PaymentSuccess(logger);
    	driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL +"w");
		ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
		driver.switchTo().window(tabs.get(0));
		driver.get("https://connectpronetqa.azurewebsites.net/");
    	EventRegistration_Page.OpenEventDetailspage("nyc", logger);
    	EventRegistration_Page.GoToTab("2");
    	EventRegistration_Page.EventAttendees(AttendeeFirstName,AttendeelastName,AttendeeCompanyName, "firefox",logger);
    	ABR =new EventRegistrationPage(driver);
    	int EAFR  = ABR.TABR();
		logger.log(LogStatus.INFO, "Total Attendees After event registration with the member name "+ AttendeeFirstName+" "+AttendeelastName+ "==== "+EAFR);
		SoftAssert softAssertion= new SoftAssert();
		EABR++;
        softAssertion.assertEquals(EABR, EAFR);
        softAssertion.assertAll();

	}
	//Verify that member details are not listed in the registered attendees section if the payment is failed or payment aborted by the user
	@Test(priority = 11,groups=("EventRegistration"), enabled = false )
	public void RegisteredAttendeeInViewAttendeesforpaymentfailed() throws Exception
	{
		logger = extent.startTest("Registered Attendee In View Attendees");
		driver = Browser.startBrowser("firefox","https://connectpronetqa.azurewebsites.net/");
    	LoginPage Login_Page = PageFactory.initElements(driver, LoginPage.class);
    	Login_Page.login(AppLoginEmailID, AppLoginPwd, logger);
    	EventRegistrationPage EventRegistration_Page=PageFactory.initElements(driver, EventRegistrationPage.class);
    	EventRegistration_Page.OpenEventDetailspage("nyc", logger);
    	EventRegistration_Page.GoToTab("2");
    	EventRegistration_Page.EventAttendees(AttendeeFirstName,AttendeelastName,AttendeeCompanyName, "firefox",logger);
    	ABR =new EventRegistrationPage(driver);
    	int EABR  = ABR.TABR();
		logger.log(LogStatus.INFO, "Total Attendees before event registration with the member name "+ AttendeeFirstName+" "+AttendeelastName+" ==== "+EABR);
		EventRegistration_Page.BackToEventDetailsPage();
		EventRegistration_Page.FillRegistrationDetails(AttendeeEmailID, AttendeeFirstName, AttendeelastName, AttendeeCompanyName, PayerEmailID, PayerFirstName, logger);
		EventRegistration_Page.AuthorizedPayment(logger);
		PaymentGatewayPage PaymentGateway_Page = PageFactory.initElements(driver, PaymentGatewayPage.class);
		PaymentGateway_Page.CancelPayMentByAuthroizedGateway(logger);
    	EventRegistration_Page.EventAttendees(AttendeeFirstName,AttendeelastName,AttendeeCompanyName, "firefox",logger);
    	ABR =new EventRegistrationPage(driver);
    	int EAFR  = ABR.TABR();
		logger.log(LogStatus.INFO, "Total Attendees After event registration with the member name "+ AttendeeFirstName+" "+AttendeelastName+ "==== "+EAFR);
		SoftAssert softAssertion= new SoftAssert();
		softAssertion.assertEquals(EABR, EAFR);
        softAssertion.assertAll();
	}
	@Test(priority = 12,groups=("EventRegistration"), enabled = false)
	public void MemberIsAbletoRegisterTothefreeEvent() throws Exception
	{
		logger = extent.startTest("Is User Able to Register To the Free Event");
		driver = Browser.startBrowser("firefox","https://connectpronetqa.azurewebsites.net/");
    	LoginPage Login_Page = PageFactory.initElements(driver, LoginPage.class);
    	Login_Page.login(AppLoginEmailID, AppLoginPwd, logger);
    	EventRegistrationPage EventRegistration_Page=PageFactory.initElements(driver, EventRegistrationPage.class);
    	EventRegistration_Page.OpenEventDetailspage("nyc", logger);
    	EventRegistration_Page.GoToTab("2");
    	EventRegistration_Page.FillRegistrationDetails(AttendeeEmailID, AttendeeFirstName, AttendeelastName,AttendeeCompanyName, PayerEmailID, PayerFirstName, logger);
    	EventRegistration_Page.RegisterFreeEvent(logger);
	}
	//=========================================================
	@Test(priority = 13,groups=("EventRegistration"), enabled = false)
	public void RegisteredEventInMyEvents() throws Exception
	{
		logger = extent.startTest("Registered Event In MyEvents Page");
		driver = Browser.startBrowser("firefox","https://connectpronetqa.azurewebsites.net/");
    	LoginPage Login_Page = PageFactory.initElements(driver, LoginPage.class);
    	Login_Page.login("sasiakula99@yahoo.com", "Admin@123", logger);
    	MyEventsPage MyEvents_Page=PageFactory.initElements(driver,MyEventsPage.class);
    	MyEvents_Page.MyEvents(logger);
    	MyEvents_Page.NoEvents(logger);
    	EventRegistrationPage EventRegistration_Page=PageFactory.initElements(driver, EventRegistrationPage.class);
    	EventRegistration_Page.OpenEventDetailspage("nyc", logger);
    	EventRegistration_Page.GoToTab("2");
    	EventRegistration_Page.BackToEventDetailsPage();
    	EventRegistration_Page.FillRegistrationDetails(AttendeeEmailID, AttendeeFirstName, AttendeelastName,AttendeeCompanyName, PayerEmailID, PayerFirstName, logger);
    	PaymentGatewayPage PaymentGateway_Page = PageFactory.initElements(driver, PaymentGatewayPage.class);
    	PaymentGateway_Page.AuthroizedGateway( "", "", "", "", "", "", "", "", "", "7075637121", logger);   	
    	EventRegistration_Page.PaymentSuccess(logger);
    	MyEvents_Page.MyEvents(logger);
    	MyEvents_Page.RegisteredEvent(logger);
    
	}
	
	@AfterMethod
	public void getResult(ITestResult result) throws Exception
		{
			if(result.getStatus() == ITestResult.FAILURE)
			{
				logger.log(LogStatus.FAIL, "Test Case Failed is "+result.getName());
				logger.log(LogStatus.FAIL, "Test Case Failed is "+result.getThrowable());
				String screenShotPath = GetScreenShot.capture(driver, "ScreenShotName");
				logger.log(LogStatus.FAIL, logger.addScreenCapture(screenShotPath));
				
			}
			else if(result.getStatus() == ITestResult.SUCCESS)
				{
				    logger.log(LogStatus.PASS, "Test Case PASSED is "+result.getName());

					String screenShotPath = GetScreenShot.capture(driver, "ScreenShotName");
					logger.log(LogStatus.PASS, logger.addScreenCapture(screenShotPath));

				}
			else
				//if(result.getStatus() == ITestResult.SKIP)
				{
					logger.log(LogStatus.SKIP, "Test Case Skipped is "+result.getName());
					logger.log(LogStatus.FAIL, "Test Case Failed is "+result.getThrowable());
				}
			extent.endTest(logger);
			driver.close();
		}
	
	
			

	@AfterTest
	public void endReport()
	{
		extent.flush();
        extent.close();
    }

	

}
