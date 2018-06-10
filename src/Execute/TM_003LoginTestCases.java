package Execute;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.connectpronetqa.GetScreenShot;
import com.connectpronetqa.LoginPage;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Helper.Browser;


public class TM_003LoginTestCases{

	ExtentReports extent;
	ExtentTest logger;
	Browser browser;
	WebDriver driver;
	
	@BeforeTest
	public void startReport(){
		extent = new ExtentReports(System.getProperty("user.dir") +"/test-output/LoginReport.html", true);
		extent
                //.addSystemInfo("Host Name", "Hyderabad")
                .addSystemInfo("Environment", "QA")
                .addSystemInfo("User Name", "Sasi Vnod");
        extent.loadConfig(new File(System.getProperty("user.dir")+"\\extent-config.xml"));
	}

    
    @Test(priority = 1,groups=("Login"), enabled = true)
    @Parameters({ "chromebrowser","AppUrl","InvalidEmailID", "InvalidEmailPwd"})
    public void InvalidLogin(String WebBrowser, String AppUrl,String InvalidEmailID,String InvalidEmailPwd) throws Exception
    {
    	logger = extent.startTest("Verifying Invalid login credentials");
    	driver = Browser.startBrowser(WebBrowser,AppUrl);
    	//driver = new FirefoxDriver();
        //driver.get("https://connectpronetqa.azurewebsites.net/");
        LoginPage Login_Page = PageFactory.initElements(driver, LoginPage.class);
    	Login_Page.login(InvalidEmailID, InvalidEmailPwd, logger);
    	Login_Page.Invalidlogin(logger);
    }    
    @Test(priority = 2,groups=("Login"), enabled = true)
    @Parameters({ "chromebrowser","AppUrl","ExpiredEmailID", "ExpiredEmailPwd"})
    public void ExpiredLogin(String WebBrowser, String AppUrl,String ExpiredEmailID,String ExpiredEmailPwd) throws Exception
    {
    	logger = extent.startTest("Verifying license expired message is displayed after login to expired service tenure Organization member");
    	driver = Browser.startBrowser(WebBrowser,AppUrl);
    	//driver = new FirefoxDriver();
        //driver.get("https://connectpronetqa.azurewebsites.net/");
        LoginPage Login_Page = PageFactory.initElements(driver, LoginPage.class);
    	Login_Page.login(ExpiredEmailID, ExpiredEmailPwd, logger);
    	Login_Page.ExpiredMessage(logger);
	}
    @Test(priority = 3,groups=("Login"), enabled = true)
    @Parameters({ "chromebrowser","AppUrl","PendingEmailID", "PendingEmailPwd"})
    public void EmailPending(String WebBrowser, String AppUrl,String PendingEmailID,String PendingAppPwd) throws Exception
    {
    	logger = extent.startTest("Verifying login with email verification pending user that the alert message is displayed");
    	driver = Browser.startBrowser(WebBrowser,AppUrl);
    	//driver = new FirefoxDriver();
        //driver.get("https://connectpronetqa.azurewebsites.net/");
        LoginPage Login_Page = PageFactory.initElements(driver, LoginPage.class);
    	Login_Page.login(PendingEmailID, PendingAppPwd, logger);
    	Login_Page.Pending(logger);
	}
    @Test(priority = 4,groups=("Login"), enabled = true)
    @Parameters({ "chromebrowser","AppUrl","SuspendedEmailID", "SuspendedEmailPwd" })
    public void Suspended(String WebBrowser, String AppUrl,String SuspendedEmailID,String SuspendedAppPwd) throws Exception
    {
    	logger = extent.startTest("Verifying suspended member is able login");
    	driver = Browser.startBrowser(WebBrowser,AppUrl);
    	//driver = new FirefoxDriver();
        //driver.get("https://connectpronetqa.azurewebsites.net/");
        LoginPage Login_Page = PageFactory.initElements(driver, LoginPage.class);
    	Login_Page.login(SuspendedEmailID, SuspendedAppPwd, logger);
    	Login_Page.Suspended(logger);
	}
    @Test(priority = 5,groups=("Login"), enabled = true)
    @Parameters({ "chromebrowser","AppUrl","validEmailID", "validEmailPwd"})
    public void SuccessfulLogin(String WebBrowser, String AppUrl,String SuccessfulEmailID, String SuccessfulAppPwd) throws Exception
    {
    	logger = extent.startTest("Verifying Member able login successfully");
    	driver = Browser.startBrowser(WebBrowser,AppUrl);
    	//driver = new FirefoxDriver();
        //driver.get("https://connectpronetqa.azurewebsites.net/");
        LoginPage Login_Page = PageFactory.initElements(driver, LoginPage.class);
    	Login_Page.login(SuccessfulEmailID, SuccessfulAppPwd, logger);
    	Login_Page.wait(SuccessfulEmailID, logger);
    	Login_Page.SuccessfulLogin(logger);
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
