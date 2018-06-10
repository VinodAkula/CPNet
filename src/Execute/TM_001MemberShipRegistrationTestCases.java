package Execute;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.connectpronetqa.AccountSignUp;
import com.connectpronetqa.EMDashboardPage;
import com.connectpronetqa.EMOrganizationPage;
import com.connectpronetqa.EmailVerifications;
import com.connectpronetqa.GetScreenShot;
import com.connectpronetqa.LoginPage;
import com.connectpronetqa.PaymentGatewayPage;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Helper.Browser;

public class TM_001MemberShipRegistrationTestCases{

	
	ExtentReports extent;
	ExtentTest logger;
	Browser browser;
	WebDriver driver;
	/*
	String EventName = "Nyc";
	String EmailID="cookalastair93@gmail.com";
	String AppPwd="Admin@123";
	String GmailPwd="Pamten@123";
	String OrganizationToReject="Pamten";
	String OrganizationToApprove="Pamten";*/
	
	
	@BeforeTest
	public void startReport(){
		extent = new ExtentReports(System.getProperty("user.dir") +"/test-output/MemberShipTestReport.html", true);
		extent
                //.addSystemInfo("Host Name", "Hyderabad")
                .addSystemInfo("Environment", "QA")
                .addSystemInfo("User Name", "Sasi Vnod");
        extent.loadConfig(new File(System.getProperty("user.dir")+"\\extent-config.xml")); 
	}
	

	@Test(priority = 1,groups=("MemberShipRegistration"), enabled = true)
	@Parameters({ "firefoxbrowser","AppUrl","EmailID", "AppPwd", "GmailPwd"})
	public void	EMailVerification(String webbrowser,String Appurl,String EmailID, String AppPwd,String GmailPwd) throws Exception
	{
		logger = extent.startTest("EMail Verification");
		driver = Browser.startBrowser(webbrowser,Appurl);
		LoginPage Login_Page = PageFactory.initElements(driver, LoginPage.class);
    	Login_Page.login(EmailID, AppPwd, logger);
    	Login_Page.Pending(logger);
    	Login_Page.ResendVerification(logger);
    	String Url=driver.getCurrentUrl();
    	EmailVerifications Email_Verifications=PageFactory.initElements(driver, EmailVerifications.class);
    	Email_Verifications.OpenNewTab(webbrowser,logger);
    	Email_Verifications.EmailLogin(EmailID, GmailPwd, logger);
    	Email_Verifications.CodeVerification(logger);
    	Thread.sleep(3000);
    	
	}
	@Test(priority = 2,groups=("MemberShipRegistration"), enabled = false)
	@Parameters({ "firefoxbrowser","AppUrl","EmailID", "AppPwd", "GmailPwd"})
	public void	Completetheregistrationwithpayment(String webbrowser,String Appurl,String EmailID, String AppPwd,String GmailPwd) throws Exception
	{
		logger = extent.startTest("complete the registration with payment");
		driver = Browser.startBrowser(webbrowser,Appurl);
    	LoginPage Login_Page = PageFactory.initElements(driver, LoginPage.class);
    	Login_Page.login(EmailID,AppPwd, logger);
    	Login_Page.wait(EmailID, logger);
    	AccountSignUp AccountSignUp_page = PageFactory.initElements(driver, AccountSignUp.class);
    	AccountSignUp_page.SelecetMemberShipPlan(logger);
    	PaymentGatewayPage PaymentGateway_Page = PageFactory.initElements(driver, PaymentGatewayPage.class);
    	PaymentGateway_Page.AuthroizedGateway(EmailID, "4242424242424242", "0333", "033", "Sasi", "Akula", "500081", "Madhapur", "Hyderabad", "7075637121", logger);
    	AccountSignUp_page.PaymentSuccess(logger);	
    	
	}
	@Test(priority = 3,groups=("MemberShipRegistration"), enabled = false)
	@Parameters({ "firefoxbrowser","EmailID","GmailPwd"})
	public void	PaymentNotification(String webbrowser,String EmailID,String GmailPwd) throws Exception
	{
		logger = extent.startTest("Payment Notification");
		driver = Browser.startBrowser(webbrowser,"https://mail.google.com/mail/u/0/");
    	EmailVerifications Gmail_Account = PageFactory.initElements(driver, EmailVerifications.class);
    	Gmail_Account.EmailLogin(EmailID, GmailPwd, logger);
    	Gmail_Account.EmailNotification(logger);
	}
	@Test(priority = 4, enabled = true)
	@Parameters({ "firefoxbrowser","AppUrl","EmailID", "AppPwd"})
	public void	MemberloginbeforeApproval(String webbrowser,String Appurl,String EmailID, String AppPwd) throws Exception
	{
		logger = extent.startTest("Member login before Approval");
		driver = Browser.startBrowser(webbrowser,Appurl);
    	LoginPage Login_Page = PageFactory.initElements(driver, LoginPage.class);
    	Login_Page.login(EmailID, AppPwd, logger);
    	Thread.sleep(5000);
    
	}
	@Test(priority = 5,groups=("MemberShipRegistration"), enabled = false)
	@Parameters({ "firefoxbrowser","AppUrl","OrganizationToReject","EmailID", "AppPwd"})
	public void	MemberLoginAfterEMReject(String webbrowser,String Appurl,String OrganizationToReject, String EmailID,String AppPwd) throws Exception
	{
		logger = extent.startTest("Member Login After EM Reject");
		driver = Browser.startBrowser(webbrowser,Appurl);
    	LoginPage Login_Page = PageFactory.initElements(driver, LoginPage.class);
    	Login_Page.login("connectproem@gmail.com", "Pamten@123", logger);
    	Login_Page.wait("connectproem@gmail.com", logger);
    	EMDashboardPage EMDashBoard_Page=PageFactory.initElements(driver, EMDashboardPage.class);
    	EMDashBoard_Page.OpenOrganizationPage(logger);
    	EMOrganizationPage EMOrganization_Page=PageFactory.initElements(driver, EMOrganizationPage.class);
    	EMOrganization_Page.SearchOrganization(OrganizationToReject, logger);
    	EMOrganization_Page.RejectMemberShip();
    	EMOrganization_Page.ReasonForRejection(logger);
    	EMDashBoard_Page.EMLogout();
    	Login_Page.login(EmailID, AppPwd, logger);
    	Login_Page.InActiveOrgeanization(logger);
	}
	@Test(priority = 6,groups=("MemberShipRegistration"), enabled = false)
	@Parameters({ "firefoxbrowser","EmailID", "GmailPwd"})
	public void	RejectNotification(String webbrowser,String EmailID, String AppPwd,String GmailPwd) throws Exception
	{
		logger = extent.startTest("Reject Notification");
		driver = Browser.startBrowser(webbrowser,"https://mail.google.com/mail/u/0/");
    	EmailVerifications Gmail_Account = PageFactory.initElements(driver, EmailVerifications.class);
    	Gmail_Account.EmailLogin(EmailID, GmailPwd, logger);
    	Gmail_Account.EmailNotification(logger);
	}
	@Test(priority = 7,groups=("MemberShipRegistration"), enabled = false)
	@Parameters({ "firefoxbrowser","AppUrl","OrganizationToApprove","EmailID", "AppPwd"})
	public void	MemberLoginAfterEMApproval(String webbrowser,String Appurl,String OrganizationToApprove,String EmailID, String AppPwd) throws Exception
	{
		logger = extent.startTest("Member Login After EM Approval");
		driver = Browser.startBrowser(webbrowser,Appurl);
    	LoginPage Login_Page = PageFactory.initElements(driver, LoginPage.class);
    	Login_Page.login("connectproem@gmail.com", "Pamten@123", logger);
    	Login_Page.wait("connectproem@gmail.com", logger);
    	EMDashboardPage EMDashBoard_Page=PageFactory.initElements(driver, EMDashboardPage.class);
    	EMDashBoard_Page.OpenOrganizationPage(logger);
    	EMOrganizationPage EMOrganization_Page=PageFactory.initElements(driver, EMOrganizationPage.class);
    	EMOrganization_Page.SearchOrganization(OrganizationToApprove, logger);
    	EMOrganization_Page.ApproveOrganization(logger);
    	Thread.sleep(10000);
    	EMDashBoard_Page.EMLogout();
    	Login_Page.login(EmailID, AppPwd, logger);
    	Login_Page.wait(EmailID, logger);
    	Login_Page.SuccessfulLogin(logger);
	}
	@Test(priority = 8,groups=("MemberShipRegistration"), enabled = false)
	@Parameters({ "firefoxbrowser","EmailID", "GmailPwd"})
	public void	ApprovalNotification(String webbrowser,String EmailID,String GmailPwd) throws Exception
	{
		logger = extent.startTest("Approval Notification");
		driver = Browser.startBrowser(webbrowser,"https://mail.google.com/mail/u/0/");
    	EmailVerifications Gmail_Account = PageFactory.initElements(driver, EmailVerifications.class);
    	Gmail_Account.EmailLogin(EmailID, GmailPwd, logger);
    	Gmail_Account.EmailNotification(logger);
	}
	@Test(priority = 9,groups=("MemberShipRegistration"), enabled = true)
	@Parameters({ "firefoxbrowser","AppUrl","EmailID"})
	public void ReRegisterwithSameEmailID(String webbrowser,String Appurl,String EmailID) throws Exception
	{
		logger = extent.startTest("Re Register with Same EmailID");
		driver = Browser.startBrowser(webbrowser,Appurl);
		AccountSignUp AccountSignUp_Page=PageFactory.initElements(driver, AccountSignUp.class);
		AccountSignUp_Page.MemberRegistration("Sasi", "www.pamten.com", "5 independance way priceton new jersy", "Please check back soon", "Sasi", "Vinod", "QA",EmailID, "Admin@123", "Admin@123", logger);
	}
	
	   @AfterMethod
	public void getResult(ITestResult result) throws Exception
			{
				if(result.getStatus() == ITestResult.FAILURE)
				{
					logger.log(LogStatus.FAIL, result.getName() +" Test Case is Failed  ");
					logger.log(LogStatus.FAIL, "Test Case Failed is "+result.getThrowable());
					String screenShotPath = GetScreenShot.capture(driver, "ScreenShotName");
					logger.log(LogStatus.FAIL, logger.addScreenCapture(screenShotPath));
					
				}
				else if(result.getStatus() == ITestResult.SUCCESS)
					{
					    logger.log(LogStatus.PASS, result.getName()+" Test Case is PASSED  ");

						String screenShotPath = GetScreenShot.capture(driver, "ScreenShotName");
						logger.log(LogStatus.PASS, logger.addScreenCapture(screenShotPath));

					}
				else
					//if(result.getStatus() == ITestResult.SKIP)
					{
						logger.log(LogStatus.SKIP, result.getName()+" Test Case is Skipped");
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
