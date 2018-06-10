package Execute;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.connectpronetqa.BusinessDirectory;
import com.connectpronetqa.DashBoardPage;
import com.connectpronetqa.EmailVerifications;
import com.connectpronetqa.GetScreenShot;
import com.connectpronetqa.LoginPage;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import Helper.Browser;

public class TM_007EndorsementsTestCases {
	
	ExtentReports extent;
	ExtentTest logger;
	Browser browser;
	WebDriver driver;
	
	/*String EndrosmentSumitterEmailID="jamescruze54@gmail.com";
	String EndrosmentSumitterAppPwd="Admin@123";
	String EndrosmentSumitterGmailPwd="Admin@123";
	String MemberNametoEndorse="nancy";
	//"I know first-hand that Nancy performs with aplomb in challenging situations. I was in the Weather Station one day while Nancy was conducting a tour for parents and their young daughters. The president of Mythic University happened to be in the group—an intimidating presence to most undergraduates—but Nancy handled herself with a polished confidence, attending to audience questions about meteorology in a clear, friendly, unaffected manner.";
	String Endoresment="HI...Excellent Services from Louis .....";
	String EndrosmentRecieverEmailID="nancycarton2@gmail.com";
	String EndrosmentRecieverAppPwd="Pamten@123";
	String EndrosmentRecieverGmailPwd="Pamten@123";
	String WebBrowser ="chrome";
	String AppUrl="https://connectpronetqa.azurewebsites.net/";
	String GmailUrl="https://mail.google.com/mail/u/0/";
	*/
	
	
	@BeforeTest
	public void startReport()
	{
		extent = new ExtentReports(System.getProperty("user.dir") +"/test-output/EndorsementsTestReport.html", true);
		extent
                //.addSystemInfo("Host Name", "Hyderabad")
                .addSystemInfo("Environment", "QA")
                .addSystemInfo("User Name", "Sasi Vnod");
        extent.loadConfig(new File(System.getProperty("user.dir")+"\\extent-config.xml"));
	}
	@Test(priority = 1,groups=("Endorsements"), enabled = true)
	@Parameters({ "firefoxbrowser","AppUrl","EndrosmentSumitterEmailID","EndrosmentSumitterAppPwd","MemberNametoEndorse","EndoresmentMessage",})
	public void AddEndorsment(String WebBrowser,String AppUrl,String EndrosmentSumitterEmailID,String EndrosmentSumitterAppPwd,String MemberNametoEndorse,String EndoresmentMessage) throws Exception
	{
		logger = extent.startTest("Add Endorsment");
		driver = Browser.startBrowser(WebBrowser,AppUrl);
    	LoginPage Login_Page = PageFactory.initElements(driver, LoginPage.class);
    	Login_Page.login(EndrosmentSumitterEmailID, EndrosmentSumitterAppPwd, logger);
    	BusinessDirectory BusinessDirectory_Page = PageFactory.initElements(driver, BusinessDirectory.class);
    	BusinessDirectory_Page.OpenMemberProfile(MemberNametoEndorse, WebBrowser, logger);
    	BusinessDirectory_Page.AddEndorsements(EndoresmentMessage, WebBrowser, logger);
	}
	@Test(priority = 2,dependsOnMethods={"AddEndorsment"},groups=("Endorsements"), enabled = true)
	@Parameters({ "firefoxbrowser","AppUrl","EndrosmentSumitterEmailID","EndrosmentSumitterGmailPwd"})
	public void EndorsmentSenderEmailNotification(String WebBrowser,String EndrosmentSumitterEmailID,String EndrosmentSumitterGmailPwd) throws Exception
	{
		logger = extent.startTest("Endorsment Sender Email Notification");
		driver = Browser.startBrowser(WebBrowser,"https://mail.google.com/mail/u/0/");
		EmailVerifications Email_Verifications = PageFactory.initElements(driver, EmailVerifications.class);
		Email_Verifications.EmailLogin(EndrosmentSumitterEmailID, EndrosmentSumitterGmailPwd, logger);
		Email_Verifications.EmailNotification(logger);
	}
	@Test(priority = 3,dependsOnMethods={"AddEndorsment"},groups=("Endorsements"), enabled = true)
	@Parameters({ "firefoxbrowser","AppUrl","EndrosmentRecieverEmailID","EndrosmentRecieverGmailPwd"})
	public void EndorsmentRecieverEmailNotification(String WebBrowser,String EndrosmentRecieverEmailID,String EndrosmentRecieverGmailPwd) throws Exception	
	{
		logger = extent.startTest("Endorsment Reciever Email Notification");
		driver = Browser.startBrowser(WebBrowser,"https://mail.google.com/mail/u/0/");
		EmailVerifications Email_Verifications = PageFactory.initElements(driver, EmailVerifications.class);
		Email_Verifications.EmailLogin(EndrosmentRecieverEmailID, EndrosmentRecieverGmailPwd, logger);
		Email_Verifications.EmailNotification(logger);		
	}
	@Test(priority = 4,dependsOnMethods={"AddEndorsment"},groups=("Endorsements"), enabled = true)
	@Parameters({ "firefoxbrowser","AppUrl","EndrosmentRecieverEmailID","EndrosmentRecieverAppPwd"})
	public void RejectEndorsment(String WebBrowser,String AppUrl,String EndrosmentRecieverEmailID,String EndrosmentRecieverAppPwd) throws Exception
	{
		logger = extent.startTest("Rejected Endorsment");
		driver = Browser.startBrowser(WebBrowser,AppUrl);
    	LoginPage Login_Page = PageFactory.initElements(driver, LoginPage.class);
    	Login_Page.login(EndrosmentRecieverEmailID, EndrosmentRecieverAppPwd, logger);
    	DashBoardPage DashBoard_Page = PageFactory.initElements(driver,DashBoardPage.class);
    	DashBoard_Page.RejectEndorsement(logger);
	}
	@Test(priority = 5,dependsOnMethods={"AddEndorsment"},groups=("Endorsements"), enabled = true)
	@Parameters({ "firefoxbrowser","AppUrl","EndrosmentSumitterEmailID","EndrosmentSumitterAppPwd"})
	public void RejectedEndorsmentdisplayed(String WebBrowser,String AppUrl, String EndrosmentSumitterEmailID, String EndrosmentSumitterAppPwd, String MemberNametoEndorse, String EndoresmentMessage) throws Exception
	{
		logger = extent.startTest("Verifying Rejected Endorsment displayed in member profile");
		driver = Browser.startBrowser(WebBrowser,AppUrl);
		LoginPage Login_Page = PageFactory.initElements(driver, LoginPage.class);
    	Login_Page.login(EndrosmentSumitterEmailID, EndrosmentSumitterAppPwd, logger);
    	BusinessDirectory BusinessDirectory_Page = PageFactory.initElements(driver, BusinessDirectory.class);
    	BusinessDirectory_Page.OpenMemberProfile(MemberNametoEndorse,WebBrowser, logger);
    	BusinessDirectory_Page.VerifyEndrsmntBeforeApprovalOrReject(EndoresmentMessage, WebBrowser, logger);
	}
	@Test(priority = 6,dependsOnMethods={"AddEndorsment"},groups=("Endorsements"), enabled = true)
	@Parameters({ "firefoxbrowser","AppUrl","EndrosmentSumitterEmailID","EndrosmentSumitterAppPwd","MemberNametoEndorse","EndoresmentMessage"})
	public void ReAddEndorsment(String WebBrowser,String AppUrl, String EndrosmentSumitterEmailID, String EndrosmentSumitterAppPwd, String MemberNametoEndorse, String EndoresmentMessage) throws Exception
	{
		logger = extent.startTest("Add Endorsment");
		driver = Browser.startBrowser(WebBrowser,AppUrl);
    	LoginPage Login_Page = PageFactory.initElements(driver, LoginPage.class);
    	Login_Page.login(EndrosmentSumitterEmailID, EndrosmentSumitterAppPwd, logger);
    	BusinessDirectory BusinessDirectory_Page = PageFactory.initElements(driver, BusinessDirectory.class);
    	BusinessDirectory_Page.OpenMemberProfile(MemberNametoEndorse, WebBrowser, logger);
    	BusinessDirectory_Page.AddEndorsements(EndoresmentMessage, WebBrowser, logger);
	}
	
	@Test(priority = 7,dependsOnMethods={"ReAddEndorsment"},groups=("Endorsements"), enabled = true)
	@Parameters({ "firefoxbrowser","AppUrl","EndrosmentRecieverEmailID","EndrosmentRecieverAppPwd"})
	public void ApproveEndorsment(String WebBrowser,String AppUrl,String EndrosmentRecieverEmailID,String EndrosmentRecieverAppPwd) throws Exception
	{
		logger = extent.startTest("Approve Endorsment");
		driver = Browser.startBrowser(WebBrowser,AppUrl);
    	LoginPage Login_Page = PageFactory.initElements(driver, LoginPage.class);
    	Login_Page.login(EndrosmentRecieverEmailID, EndrosmentRecieverAppPwd, logger);
    	DashBoardPage DashBoard_Page = PageFactory.initElements(driver,DashBoardPage.class);
    	DashBoard_Page.ApproveEndorsement(logger);
	}
	
	@Test(priority = 8,dependsOnMethods={"ReAddEndorsment"},groups=("Endorsements"), enabled = true)
	@Parameters({ "firefoxbrowser","AppUrl","EndrosmentSumitterEmailID","EndrosmentSumitterAppPwd","EndoresmentMessage"})
	public void ApprovedEndorsmentdisplayed(String WebBrowser,String AppUrl, String EndrosmentSumitterEmailID,String EndrosmentSumitterAppPwd, String MemberNametoEndorse,String EndoresmentMessage) throws Exception
	{
		logger = extent.startTest("Verifying Approved Endorsment displayed in member profile");
		driver = Browser.startBrowser(WebBrowser,AppUrl);
		LoginPage Login_Page = PageFactory.initElements(driver, LoginPage.class);
    	Login_Page.login(EndrosmentSumitterEmailID, EndrosmentSumitterAppPwd, logger);
    	BusinessDirectory BusinessDirectory_Page = PageFactory.initElements(driver, BusinessDirectory.class);
    	BusinessDirectory_Page.OpenMemberProfile(MemberNametoEndorse,WebBrowser, logger);
    	BusinessDirectory_Page.VerifyEndrsmntAfterApproval(EndoresmentMessage, WebBrowser, logger);
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
