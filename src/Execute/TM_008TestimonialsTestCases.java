package Execute;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.connectpronetqa.DashBoardPage;
import com.connectpronetqa.EMDashboardPage;
import com.connectpronetqa.EmailVerifications;
import com.connectpronetqa.EventManagerTestimonialPage;
import com.connectpronetqa.GetScreenShot;
import com.connectpronetqa.LoginPage;
import com.connectpronetqa.MemberTestimonialPage;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Helper.Browser;

public class TM_008TestimonialsTestCases {
	
	ExtentReports extent;
	ExtentTest logger;
	Browser browser;
	WebDriver driver;
	
/*	String AddtestimonialMemberEmailID = "nancycarton2@gmail.com";
	String AddtestimonialMemberEmailPwd ="Pamten@123";
	String Title="This is nice app....with good UI";
	String Testimonial="ConnectPro is a good application. very good technology have been used. s every one should have to implement the good technologies like ConnectPro";
	String EMEMailID="Connectproem@gmail.com";
	String EMPwd="Pamten@123";*/
	@BeforeTest
	public void startReport(){
		extent = new ExtentReports(System.getProperty("user.dir") +"/test-output/TestimonialsReport.html", true);
		extent
                //.addSystemInfo("Host Name", "Hyderabad")
                .addSystemInfo("Environment", "QA")
                .addSystemInfo("User Name", "Sasi Vnod");
        extent.loadConfig(new File(System.getProperty("user.dir")+"\\extent-config.xml"));
	}
	
		
	 @Test(priority = 1,groups=("Testimonials"), enabled = true)
	 @Parameters({ "firefoxbrowser","AppUrl","AddtestimonialMemberEmailID","AddtestimonialMemberEmailPwd","TestimonialTitle","TestimonialMessage"})
	 public void Addtestimonial(String WebBrowser, String AppUrl,String AddtestimonialMemberEmailID, String AddtestimonialMemberEmailPwd,String TestimonialTitle,String TestimonialMessage) throws Exception
	 {
		logger = extent.startTest("Add testimonial");
		driver = Browser.startBrowser(WebBrowser,AppUrl);
	    LoginPage Login_Page = PageFactory.initElements(driver, LoginPage.class);
	    Login_Page.login(AddtestimonialMemberEmailID,AddtestimonialMemberEmailPwd,logger);	    	
	    DashBoardPage DashBoard_Page = PageFactory.initElements(driver, DashBoardPage.class);
	    DashBoard_Page.Testimonial(logger);
	    MemberTestimonialPage MemberTestimonial_Page=PageFactory.initElements(driver, MemberTestimonialPage.class);
	    MemberTestimonial_Page.AddTestimonial(TestimonialTitle,TestimonialMessage, logger);
	 }
		 
	 @Test(priority = 2,dependsOnMethods={"Addtestimonial"},groups=("Testimonials"), enabled = true)
	 @Parameters({ "firefoxbrowser","AppUrl","AddtestimonialMemberEmailID", "AddtestimonialMemberGmailPwd"})
	 public void AddtestimonialEmailVerificaton(String WebBrowser,String AppUrl,String AddtestimonialMemberEmailID,String AddtestimonialMemberGmailPwd) throws Exception
	 {
			logger = extent.startTest("Add Testimonial Email Verificaton");
			driver = Browser.startBrowser("chrome","https://mail.google.com/mail/u/0/");
		    EmailVerifications Email_Verification = PageFactory.initElements(driver,EmailVerifications.class);
		    Email_Verification.EmailLogin(AddtestimonialMemberEmailID, AddtestimonialMemberGmailPwd, logger);
		    Email_Verification.EmailNotification3(logger);
		    }
	 @Test(priority = 3,dependsOnMethods={"Addtestimonial"},groups=("Testimonials"), enabled = true) 
	 @Parameters({ "firefoxbrowser","AppUrl","EMEMailID", "EMPwd"})
	 public void Rejecttestimonial(String WebBrowser,String AppUrl,String EMEMailID, String EMPwd) throws Exception
	 {
			logger = extent.startTest("Reject Testimonial");
			driver = Browser.startBrowser(WebBrowser,AppUrl);
		    LoginPage Login_Page = PageFactory.initElements(driver, LoginPage.class);
		    Login_Page.login(EMEMailID,EMPwd,logger);	
		    EMDashboardPage EMDashboard_Page = PageFactory.initElements(driver,EMDashboardPage.class);
		    EMDashboard_Page.Testmonials(logger);		    
		    EventManagerTestimonialPage EventManagerTestimonial_Page = PageFactory.initElements(driver,EventManagerTestimonialPage.class);
		    EventManagerTestimonial_Page.DisplayAllTestimonials(logger);
		    EventManagerTestimonial_Page.EditStatus(logger);
		    EventManagerTestimonial_Page.TestimonialReject(logger);
	 }
		
	 @Test(priority = 4,dependsOnMethods={"Rejecttestimonial"},groups=("Testimonials"), enabled = true)
	 @Parameters({ "firefoxbrowser","AddtestimonialMemberEmailID", "AddtestimonialMemberGmailPwd"})
	 public void RejectedtestimonialEmailNotification(String WebBrowser,String AddtestimonialMemberEmailID, String AddtestimonialMemberGmailPwd) throws Exception
	 {
		    logger = extent.startTest("Rejected testimonial Email Notification");
			driver = Browser.startBrowser(WebBrowser,"https://mail.google.com/mail/u/0/");
		    EmailVerifications Email_Verification = PageFactory.initElements(driver,EmailVerifications.class);
		    Email_Verification.EmailLogin(AddtestimonialMemberEmailID, AddtestimonialMemberGmailPwd, logger);
		    Email_Verification.EmailNotification3(logger); 
	 }
	
	 @Test(priority = 5,dependsOnMethods={"Rejecttestimonial"},groups=("Testimonials"), enabled = true)
	 @Parameters({ "firefoxbrowser","AppUrl","EMEMailID","EMPwd", "TestimonialMessage"})
	 public void RejectedtestimonialisNotDisplayed(String WebBrowser, String Appurl,String EMEMailID, String EMPwd,String TestimonialMessage ) throws Exception
	 {
		 logger = extent.startTest("Verifying Rejected testimonial is not displayed");
		 driver = Browser.startBrowser(WebBrowser,Appurl);
		 LoginPage Login_Page = PageFactory.initElements(driver, LoginPage.class);
		 Login_Page.login(EMEMailID,EMPwd,logger);	
		 EMDashboardPage EMDashboard_Page = PageFactory.initElements(driver,EMDashboardPage.class);
		 EMDashboard_Page.Testmonials(logger);		    
		 EventManagerTestimonialPage EventManagerTestimonial_Page = PageFactory.initElements(driver,EventManagerTestimonialPage.class);
		 EventManagerTestimonial_Page.DisplayAllTestimonials(logger);
		 EventManagerTestimonial_Page.EditStatus(logger);
		 EventManagerTestimonial_Page.RejectedTestmonialNotDisplayed(TestimonialMessage, logger);
		    
	 }
	 @Test(priority = 6,dependsOnMethods={"Addtestimonial"},groups=("Testimonials"), enabled = true)
	 @Parameters({ "firefoxbrowser","AppUrl","EMEMailID","EMPwd", "TestimonialMessage"})
	 public void Approvetestimonial(String WebBrowser,String AppUrl,String EMEMailID,String EMPwd, String TestimonialMessage) throws Exception
	 {
		 logger = extent.startTest("Approve testimonial");
		 driver = Browser.startBrowser(WebBrowser,AppUrl);
		 LoginPage Login_Page = PageFactory.initElements(driver, LoginPage.class);
		 Login_Page.login(EMEMailID,EMPwd,logger);	
		 EMDashboardPage EMDashboard_Page = PageFactory.initElements(driver,EMDashboardPage.class);
		 EMDashboard_Page.Testmonials(logger);		    
		 EventManagerTestimonialPage EventManagerTestimonial_Page = PageFactory.initElements(driver,EventManagerTestimonialPage.class);
		 EventManagerTestimonial_Page.DisplayAllTestimonials(logger);
		 EventManagerTestimonial_Page.EditStatus(logger);
		 EventManagerTestimonial_Page.TestimonialApprove(logger);
		 }
	 
	@Test(priority = 7,dependsOnMethods={"Approvetestimonial"},groups=("Testimonials"), enabled = true)
	@Parameters({ "firefoxbrowser","AppUrl","AddtestimonialMemberEmailID", "AddtestimonialMemberGmailPwd"})
	public void ApprovetestimonialEmailNotification(String WebBrowser,String AddtestimonialMemberEmailID,String AddtestimonialMemberGmailPwd) throws Exception
	{
		logger = extent.startTest("Verifying for the Approved testimonial Email Notification");
		driver = Browser.startBrowser("chrome","https://mail.google.com/mail/u/0/");
		EmailVerifications Email_Verification = PageFactory.initElements(driver,EmailVerifications.class);
	    Email_Verification.EmailLogin(AddtestimonialMemberEmailID, AddtestimonialMemberGmailPwd, logger);
	    Email_Verification.EmailNotification3(logger);
	}
	@Test(priority = 8,dependsOnMethods={"Approvetestimonial"},groups=("Testimonials"), enabled = true)
	@Parameters({ "firefoxbrowser","AppUrl","EMEMailID","EMPwd", "TestimonialMessage"})
	public void ApprovetestimonialIsDisplayed(String WebBrowser, String AppUrl, String EMEMailID, String EMPwd, String TestimonialMessage) throws Exception
	{
		logger = extent.startTest("Verifying the Approved Testimonial Is Displayed");
		 driver = Browser.startBrowser("chrome","https://connectpronetqa.azurewebsites.net/");
		 LoginPage Login_Page = PageFactory.initElements(driver, LoginPage.class);
		 Login_Page.login(EMEMailID,EMPwd,logger);
		 EMDashboardPage EMDashboard_Page = PageFactory.initElements(driver,EMDashboardPage.class);
		 EMDashboard_Page.Testmonials(logger);		    
		 EventManagerTestimonialPage EventManagerTestimonial_Page = PageFactory.initElements(driver,EventManagerTestimonialPage.class);
		 EventManagerTestimonial_Page.DisplayAllTestimonials(logger);
		 EventManagerTestimonial_Page.ApprovedTestmonialDisplayed(TestimonialMessage, logger);
	}
	 
	/*@Test(priority =1, enabled = false)
	public void Test()
	{
		logger = extent.startTest("testimonials page");
		driver = Browser.startBrowser("chrome","https://connectpronetqa.azurewebsites.net/Testimonials");
		//driver.findElement(By.xpath("//a[@href='/Testimonials']")).click();
		MemberTestimonialPage MemberTestimonial_Page=PageFactory.initElements(driver, MemberTestimonialPage.class);
		MemberTestimonial_Page.GetAllElelments(Title, logger);
	}*/
	
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
