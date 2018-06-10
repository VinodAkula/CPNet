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
import com.connectpronetqa.EmailVerifications;
import com.connectpronetqa.GetScreenShot;
import com.connectpronetqa.LoginPage;
import com.connectpronetqa.Password;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import Helper.Browser;

public class TM_004PasswordTestCases{
	
	ExtentReports extent;
	ExtentTest logger;
	Browser browser;
	WebDriver driver;
	
	/*String RequestNewPasswordEmailID="elliswatson12x@gmail.com";
	String GmailLoginID=RequestNewPasswordEmailID;
	String GmailPassword="Admin@123";
	String Newpassword="Admin@12311";
	String ConfirmNewpassword="Admin@12311";
	String GmailforExpiredpasswordlink="";
	String GmailpasswordforExpiredpasswordlink="";
	String ApploginID="elizabeth.evans003@gmail.com";
	String AppPwd="Pamten@12";
	String ChangePasswordGmailID=ApploginID;
	String ChangePwdEmailpwd="Pamten@123";
	String AppNewPwd="Pamten@112";
	String Appconfirmpassword=AppNewPwd;*/
	
	
	
	
	@BeforeTest
	public void startReport(){
		extent = new ExtentReports(System.getProperty("user.dir") +"/test-output/PaswordTestReport.html", true);
		extent
                //.addSystemInfo("Host Name", "Hyderabad")
                .addSystemInfo("Environment", "QA")
                .addSystemInfo("User Name", "Sasi Vnod");
        extent.loadConfig(new File(System.getProperty("user.dir")+"\\extent-config.xml"));
	}
	@Test(priority = 1,groups=("Password"), enabled = false)
	@Parameters({ "firefoxbrowser","AppUrl","RequestNewPasswordEmailID"})
	public void RequestResetPassword(String WebBrowser, String Appurl,String RequestNewPasswordEmailID) throws Exception
	{
		logger = extent.startTest("Request Reset Password Link");
    	driver = Browser.startBrowser(WebBrowser,Appurl);
    	//driver = new FirefoxDriver();
        //driver.get("https://connectpronetqa.azurewebsites.net/");
        Password Password_Page = PageFactory.initElements(driver, Password.class);
        Password_Page.forgotPassword(RequestNewPasswordEmailID, logger);
    }
	@Test(priority = 2,groups=("Password"), enabled = true)
	@Parameters({ "firefoxbrowser","RequestNewPasswordEmailID", "GmailPassword", "Newpassword"})
	public void SetNewPassword(String WebBrowser, String RequestNewPasswordEmailID,String GmailPassword, String Newpassword ) throws Exception
	{
		logger = extent.startTest("Set New Password");
		driver = Browser.startBrowser(WebBrowser,"https://www.google.com/gmail/");
		EmailVerifications Email_Verifications = PageFactory.initElements(driver, EmailVerifications.class);
		Email_Verifications.EmailLogin(RequestNewPasswordEmailID, GmailPassword, logger);
		Email_Verifications.ResetPasswordGmailNotification(logger);
		Password Password_Page = PageFactory.initElements(driver, Password.class);
		Password_Page.Resetpassword(Newpassword,Newpassword,logger);
	}
	@Test(priority = 3,groups=("Password"), enabled = false)
	@Parameters({ "firefoxbrowser","RequestNewPasswordEmailID", "GmailPassword"})
	public void InavalidPassowrdLink(String WebBrowser, String RequestNewPasswordEmailID, String GmailPassword) throws Exception
	{
		logger = extent.startTest("Inavalid Passowrd Link");
		driver = Browser.startBrowser(WebBrowser,"https://www.google.com/gmail/");
		EmailVerifications Email_Verifications = PageFactory.initElements(driver, EmailVerifications.class);
		Email_Verifications.EmailLogin(RequestNewPasswordEmailID, GmailPassword, logger);
		Email_Verifications.ResetPasswordwithInvalidLink(logger);
		Password Password_Page = PageFactory.initElements(driver, Password.class);
		Password_Page.Invalidlink(logger);;
	}
	/*@Test(priority = 4,groups=("Password"), enabled = false)
	public void ExpiredPasswordLink() throws Exception
	{
		logger = extent.startTest("Expired Passowrd Link");
		driver = Browser.startBrowser("firefox","https://www.google.com/gmail/");
		EmailVerifications Email_Verifications = PageFactory.initElements(driver, EmailVerifications.class);
		Email_Verifications.EmailLogin(GmailforExpiredpasswordlink,GmailpasswordforExpiredpasswordlink, logger);
		Email_Verifications.EmailNotification2(logger);
		Password Password_Page = PageFactory.initElements(driver, Password.class);
		Password_Page.Expiredlink(logger);
	}*/
	@Test(priority = 5,groups=("Password"), enabled = false)
	@Parameters({ "firefoxbrowser","AppUrl","ChangePwdApploginID", "ChangePwdAppPwd"})
	public void SameOldandNewPassword(String WebBrowser, String AppUrl, String ChangePwdApploginID, String ChangePwdAppPwd) throws Exception
	{
		logger = extent.startTest("Error message is displaying for Same Old and New Passwords");
		driver = Browser.startBrowser(WebBrowser,"https://connectpronetqa.azurewebsites.net/");
		LoginPage Login_Page = PageFactory.initElements(driver, LoginPage.class);
    	Login_Page.login(ChangePwdApploginID, ChangePwdAppPwd, logger);
    	Password Password_Page = PageFactory.initElements(driver, Password.class);
		Password_Page.SameOldandNewPassword("ChangePwdAppPwd", "ChangePwdAppPwd", logger);
	}	
	@Test(priority = 6,dependsOnMethods={"SameOldandNewPassword"}, enabled = false)
	@Parameters({ "firefoxbrowser","AppUrl","ChangePwdApploginID", "ChangePwdAppPwd","AppNewPwd"})
	public void ChangePassword(String WebBrowser, String AppUrl, String ChangePwdApploginID, String ChangePwdAppPwd, String AppNewPwd) throws Exception
	{
		logger = extent.startTest("Change Password");
		driver = Browser.startBrowser(WebBrowser,AppUrl);
		LoginPage Login_Page = PageFactory.initElements(driver, LoginPage.class);
    	Login_Page.login(ChangePwdApploginID, ChangePwdAppPwd, logger);
    	Password Password_Page = PageFactory.initElements(driver, Password.class);
		Password_Page.ChangePassword(ChangePwdAppPwd, AppNewPwd, AppNewPwd, logger);
		
	}
	@Test(priority = 7,groups=("Password"),dependsOnMethods={"ChangePassword"}, enabled = false)
	@Parameters({ "firefoxbrowser","ChangePwdApploginID", "ChangePwdGmailPwd"})
    public void ChangePasswordEmailNotification(String WebBrowser, String ChangePwdApploginID, String ChangePwdGmailPwd) throws Exception
    {
    	logger = extent.startTest("Change Password EmailNotification");
    	driver = Browser.startBrowser(WebBrowser,"https://www.google.com/gmail/");
    	//driver = new FirefoxDriver();
        //driver.get("https://connectpronetqa.azurewebsites.net/");
    	EmailVerifications Email_Verifications = PageFactory.initElements(driver, EmailVerifications.class);
		Email_Verifications.EmailLogin(ChangePwdApploginID, ChangePwdGmailPwd, logger);
		Email_Verifications.ChangePasswordNotification(logger);
    }
	@Test(priority = 8,groups=("Password"),dependsOnMethods={"ChangePassword"}, enabled = false)
	@Parameters({ "firefoxbrowser","AppUrl","ChangePwdApploginID", "ChangePwdAppPwd"})
	public void loginWithOldpasswprd(String WebBrowser,String AppUrl, String ChangePwdApploginID, String ChangePwdAppPwd ) throws Exception
    {
    	logger = extent.startTest("Verifying login with old password credentials");
    	driver = Browser.startBrowser(WebBrowser,AppUrl);
    	//driver = new FirefoxDriver();
        //driver.get("https://connectpronetqa.azurewebsites.net/");
        LoginPage Login_Page = PageFactory.initElements(driver, LoginPage.class);
    	Login_Page.login(ChangePwdApploginID, ChangePwdAppPwd, logger);
    	Login_Page.Invalidlogin(logger);
    }
	@Test(priority = 9,groups=("Password"),dependsOnMethods={"ChangePassword"}, enabled = false)
	@Parameters({ "firefoxbrowser","AppUrl","ChangePwdApploginID", "ChangePwdAppPwd"})
	public void LoginWithNewPassord(String WebBrowser,String AppUrl, String ChangePwdApploginID, String AppNewPwd) throws Exception
	{
		logger = extent.startTest("Verifying login with new password credentials");
		driver = Browser.startBrowser("firefox","https://connectpronetqa.azurewebsites.net/");
		LoginPage Login_Page = PageFactory.initElements(driver, LoginPage.class);
    	Login_Page.login(ChangePwdApploginID, AppNewPwd, logger);
    	Login_Page.SuccessfulLogin(logger);
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
