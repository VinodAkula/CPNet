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
import com.connectpronetqa.MyProfilePage;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Helper.Browser;

public class TM_006MyProfileTestCases {
	
	ExtentReports extent;
	ExtentTest logger;
	Browser browser;
	WebDriver driver;
/*	//Primary Member Login
	String PrimaryMemberEmail="Sasiakula99@yahoo.com";
	String Pwd="Admin@123";
	//Add New Additional Member
	String AddadditionalMemberEmail = "Stevesmith2580@gmail.com";
	String FirstName ="Andrew";
	String LastName="Thomson";
	String JobTitle="QA";
	String Password="Admin@123";
	String COnfirmPassword="Admin@123";
	String EmailPassword="asdf1237";
	//Edit Member Details
	String EditMemberFirstName="Ellis";
	String EditMemberLastName="Watson";
	String EditMemberJobTitle="QA";
	//Business Directory
	String VerifyMemberName=EditMemberFirstName+" "+EditMemberLastName;
	String VerifyMemberJobtitle=EditMemberJobTitle;
	//ReActivated Member Details
	String ReActivateEmail="elliswatson12x@gmail.com";
	String ReActivatedEmailPassword="Admin@123";
	String ReActiavtedPassword="Admin@123";*/
	@BeforeTest
	public void startReport(){
		extent = new ExtentReports(System.getProperty("user.dir") +"/test-output/MyProfileReport.html", true);
		extent
                //.addSystemInfo("Host Name", "Hyderabad")
                .addSystemInfo("Environment", "QA")
                .addSystemInfo("User Name", "Sasi Vnod");
        extent.loadConfig(new File(System.getProperty("user.dir")+"\\extent-config.xml"));   
	}
	@Test(priority =1,groups=("MyProfile"), enabled = false)
	@Parameters({ "firefoxbrowser","AppUrl","PrimaryMemberEmail","PrimaryMemberPwd","PFName", "PLName","Pjtitle", "PPSummary", "PYtube", "PLUrl", "PFUrl","PTUrl","PGUrl"})
	public void ProfileUpdate(String WebBrowser, String AppUrl,String PrimaryMemberEmail, String PrimaryMemberPwd,String PFName,String PLName, String Pjtitle,String PPSummary, String PYtube, String PLUrl, String PFUrl,String PTUrl, String PGUrl) throws Exception
	{
		logger = extent.startTest("Member Profile Updating");
		driver = Browser.startBrowser(WebBrowser,AppUrl);
    	LoginPage Login_Page = PageFactory.initElements(driver, LoginPage.class);
    	Login_Page.login(PrimaryMemberEmail,PrimaryMemberPwd,logger);
    	Login_Page.wait(PrimaryMemberEmail, logger);
    	MyProfilePage MyProfile_Page = PageFactory.initElements(driver, MyProfilePage.class);
    	MyProfile_Page.Profileupdate(PFName, PLName,Pjtitle, PPSummary, PYtube, PLUrl, PFUrl,PTUrl,PGUrl,logger);
	}
	@Test(priority =2,groups=("MyProfile"), enabled = false)
	@Parameters({ "firefoxbrowser","AppUrl","PrimaryMemberEmail","PrimaryMemberPwd","AddProtfolioName","AddProtfolioUrl"})
	public void AddPortfolio(String WebBrowser, String AppUrl, String PrimaryMemberEmail, String PrimaryMemberPwd,String AddProtfolioName, String AddProtfolioUrl) throws Exception
	{
		logger = extent.startTest("Add Portfolio");
		driver = Browser.startBrowser(WebBrowser,AppUrl);
    	LoginPage Login_Page = PageFactory.initElements(driver, LoginPage.class);
    	Login_Page.login(PrimaryMemberEmail, PrimaryMemberPwd, logger);
    	Login_Page.wait(PrimaryMemberEmail, logger);
    	MyProfilePage MyProfile_Page = PageFactory.initElements(driver, MyProfilePage.class);
    	MyProfile_Page.AddProtfolio(AddProtfolioName, AddProtfolioUrl,logger);
    	Thread.sleep(4000);
	}
	@Test(priority = 3,groups=("MyProfile"), enabled = false)
	@Parameters({ "firefoxbrowser","AppUrl","PrimaryMemberEmail","PrimaryMemberPwd","UpdateProtfolioName","UpdateProtfolioUrl"})
	public void Updateportfolio(String WebBrowser, String AppUrl, String PrimaryMemberEmail, String PrimaryMemberPwd, String UpdateProtfolioName,String UpdateProtfolioUrl ) throws Exception
	{
		logger = extent.startTest("Update Portfolio");
		driver = Browser.startBrowser(WebBrowser,AppUrl);
    	LoginPage Login_Page = PageFactory.initElements(driver, LoginPage.class);
    	Login_Page.login(PrimaryMemberEmail, PrimaryMemberPwd, logger);
    	Login_Page.wait(PrimaryMemberEmail, logger);
    	MyProfilePage MyProfile_Page = PageFactory.initElements(driver, MyProfilePage.class);
    	MyProfile_Page.Updateportfolio(UpdateProtfolioName,UpdateProtfolioUrl,logger);
    	Thread.sleep(4000);
	}
	@Test(priority = 4,groups=("MyProfile"), enabled = false)
	@Parameters({ "firefoxbrowser","AppUrl","PrimaryMemberEmail","PrimaryMemberPwd"})
	public void Deleteportfolio(String WebBrowser, String AppUrl,String PrimaryMemberEmail,String PrimaryMemberPwd) throws Exception
	{
		logger = extent.startTest("Delete Portfolio");
		driver = Browser.startBrowser(WebBrowser,AppUrl);
    	LoginPage Login_Page = PageFactory.initElements(driver, LoginPage.class);
    	Login_Page.login(PrimaryMemberEmail, PrimaryMemberPwd, logger);
    	Login_Page.wait(PrimaryMemberEmail, logger);
    	MyProfilePage MyProfile_Page = PageFactory.initElements(driver, MyProfilePage.class);
    	MyProfile_Page.Deleteportfolio(logger);
    	
	}
	@Test(priority = 5,groups=("MyProfile"), enabled = false)
	@Parameters({ "firefoxbrowser","AppUrl","PrimaryMemberEmail","PrimaryMemberPwd","AddSkillsName"})
	public void AddSkills(String WebBrowser, String AppUrl,String PrimaryMemberEmail, String PrimaryMemberPwd,String AddSkillsName) throws Exception
	{
		logger = extent.startTest("Add Skils");
		driver = Browser.startBrowser(WebBrowser,AppUrl);
    	LoginPage Login_Page = PageFactory.initElements(driver, LoginPage.class);
    	Login_Page.login(PrimaryMemberEmail, PrimaryMemberPwd, logger);
    	Login_Page.wait(PrimaryMemberEmail, logger);
    	MyProfilePage MyProfile_Page = PageFactory.initElements(driver, MyProfilePage.class);
    	MyProfile_Page.AddSkills(AddSkillsName,logger);
    	Thread.sleep(4000);
	}
	@Test(priority = 6,groups=("MyProfile"), enabled = false)
	@Parameters({ "firefoxbrowser","AppUrl","PrimaryMemberEmail","PrimaryMemberPwd"})
	public void DeleteSkills(String WebBrowser, String AppUrl,String PrimaryMemberEmail,String PrimaryMemberPwd) throws Exception
	{
		logger = extent.startTest("Delete Skills");
		driver = Browser.startBrowser(WebBrowser,AppUrl);
    	LoginPage Login_Page = PageFactory.initElements(driver, LoginPage.class);
    	Login_Page.login(PrimaryMemberEmail, PrimaryMemberPwd, logger);
    	Login_Page.wait(PrimaryMemberEmail, logger);
    	MyProfilePage MyProfile_Page = PageFactory.initElements(driver, MyProfilePage.class);
    	MyProfile_Page.DeleteSkils(logger);
	}
	@Test(priority = 7,groups=("MyProfile"), enabled = false)
	@Parameters({ "firefoxbrowser","AppUrl","PrimaryMemberEmail","PrimaryMemberPwd","AddInterestsName"})
	public void AddInterests(String WebBrowser, String AppUrl, String PrimaryMemberEmail, String PrimaryMemberPwd, String AddInterestsName) throws Exception
	{
		logger = extent.startTest("Add Interests");
		driver = Browser.startBrowser(WebBrowser,AppUrl);
    	LoginPage Login_Page = PageFactory.initElements(driver, LoginPage.class);
    	Login_Page.login(PrimaryMemberEmail, PrimaryMemberPwd, logger);
    	Login_Page.wait(PrimaryMemberEmail, logger);
    	MyProfilePage MyProfile_Page = PageFactory.initElements(driver, MyProfilePage.class);
    	MyProfile_Page.AddInterests(AddInterestsName, logger);
    	Thread.sleep(4000);
	}
	@Test(priority = 8,groups=("MyProfile"), enabled = false)
	@Parameters({ "firefoxbrowser","AppUrl","PrimaryMemberEmail","PrimaryMemberPwd"})
	public void DeleteInterests(String WebBrowser, String AppUrl,String PrimaryMemberEmail, String PrimaryMemberPwd) throws Exception
	{
		logger = extent.startTest("Delete Interests");
		driver = Browser.startBrowser(WebBrowser,AppUrl);
    	LoginPage Login_Page = PageFactory.initElements(driver, LoginPage.class);
    	Login_Page.login(PrimaryMemberEmail, PrimaryMemberPwd, logger);
    	Login_Page.wait(PrimaryMemberEmail, logger);
    	MyProfilePage MyProfile_Page = PageFactory.initElements(driver, MyProfilePage.class);
    	MyProfile_Page.DeleteInterests(logger);
	}
	@Test(priority = 9,groups=("MyProfile"), enabled =false )
	@Parameters({ "firefoxbrowser","AppUrl","PrimaryMemberEmail","PrimaryMemberPwd"})
	public void ChangeProfilePicture(String WebBrowser, String AppUrl, String PrimaryMemberEmail,String PrimaryMemberPwd ) throws Exception
	{
		logger = extent.startTest("Change Profile Picture");
		driver = Browser.startBrowser(WebBrowser,AppUrl);
    	LoginPage Login_Page = PageFactory.initElements(driver, LoginPage.class);
    	Login_Page.login(PrimaryMemberEmail, PrimaryMemberPwd, logger);
    	Login_Page.wait(PrimaryMemberEmail, logger);
    	MyProfilePage MyProfile_Page = PageFactory.initElements(driver, MyProfilePage.class);
    	MyProfile_Page.ChangeProfilePicture(logger);
	}
	@Test(priority = 10,groups=("MyProfile"), enabled = false)
	@Parameters({ "firefoxbrowser","AppUrl","PrimaryMemberEmail","PrimaryMemberPwd"})
	public void ChangeCompanypicture(String WebBrowser, String AppUrl, String PrimaryMemberEmail, String PrimaryMemberPwd) throws Exception
	{
		logger = extent.startTest("Change Company Picture");
		driver = Browser.startBrowser(WebBrowser,AppUrl);
    	LoginPage Login_Page = PageFactory.initElements(driver, LoginPage.class);
    	Login_Page.login(PrimaryMemberEmail, PrimaryMemberPwd, logger);
    	Login_Page.wait(PrimaryMemberEmail, logger);
    	MyProfilePage MyProfile_Page = PageFactory.initElements(driver, MyProfilePage.class);
    	MyProfile_Page.ChangeCompanypicture(logger);
	}
	@Test(priority = 11,groups=("MyProfile"), enabled = false)
	@Parameters({ "firefoxbrowser","AppUrl","PrimaryMemberEmail","PrimaryMemberPwd","CEmail", "CDesc", "CLUrl", "CFUrl", "CTUrl","CGUrl"})
	public void CompanyProfile(String WebBrowser, String AppUrl, String PrimaryMemberEmail,String PrimaryMemberPwd, String CEmail, String CDesc, String CLUrl, String CFUrl, String CTUrl, String CGUrl) throws Exception
	{
		driver = Browser.startBrowser(WebBrowser,AppUrl);
    	LoginPage Login_Page = PageFactory.initElements(driver, LoginPage.class);
    	Login_Page.login(PrimaryMemberEmail, PrimaryMemberPwd, logger);
    	Login_Page.wait(PrimaryMemberEmail, logger);
    	MyProfilePage MyProfile_Page = PageFactory.initElements(driver, MyProfilePage.class);
    	MyProfile_Page.CompanyProfile(CEmail, CDesc, CLUrl, CFUrl, CTUrl,CGUrl,logger);
	}//======================================================================================================
	@Test(priority = 12,groups=("MyProfile"), enabled = true)
	@Parameters({ "firefoxbrowser","AppUrl","PrimaryMemberEmail","PrimaryMemberPwd","LocationName","LocationAddress"})
	public void EditLocation(String WebBrowser, String AppUrl,String PrimaryMemberEmail,String PrimaryMemberPwd,String LocationName, String LocationAddress) throws Exception
	{
		logger = extent.startTest("Edit Location");
		driver = Browser.startBrowser(WebBrowser,AppUrl);
    	LoginPage Login_Page = PageFactory.initElements(driver, LoginPage.class);
    	Login_Page.login(PrimaryMemberEmail, PrimaryMemberPwd, logger);
    	Login_Page.wait(PrimaryMemberEmail, logger);
    	MyProfilePage MyProfile_Page = PageFactory.initElements(driver, MyProfilePage.class);
    	MyProfile_Page.EditLocation(LocationName, LocationAddress, logger);
	}
	//=================================================================================================
	@Test(priority = 13,groups=("MyProfile"), enabled = false)
	@Parameters({ "firefoxbrowser","AppUrl","PrimaryMemberEmail","PrimaryMemberPwd","AddMemberFirstName", "AddMemberLastName", "AddMemberJobTitle", "AddMemberEmail", "AddMemberPassword"})
	public void Addmember(String WebBrowser, String AppUrl, String PrimaryMemberEmail, String PrimaryMemberPwd,String AddMemberFirstName, String AddMemberLastName, String AddMemberJobTitle, String AddMemberEmail,String AddMemberPassword) throws Exception
	{
		driver = Browser.startBrowser(WebBrowser,AppUrl);
    	LoginPage Login_Page = PageFactory.initElements(driver, LoginPage.class);
    	Login_Page.login(PrimaryMemberEmail, PrimaryMemberPwd, logger);
    	Login_Page.wait(PrimaryMemberEmail, logger);
    	MyProfilePage MyProfile_Page = PageFactory.initElements(driver, MyProfilePage.class);
    	MyProfile_Page.Additionalmember(AddMemberFirstName, AddMemberLastName, AddMemberJobTitle, AddMemberEmail, AddMemberPassword, AddMemberPassword, logger);
	}
	@Test(priority = 14,groups=("MyProfile"), enabled = false)
	@Parameters({ "firefoxbrowser","AddMemberFirstName", "AddMemberGmailPwd"})
	public void EmailnotificationToNewMember(String WebBrowser,String AddMemberFirstName, String AddMemberGmailPwd ) throws Exception
	{
		driver = Browser.startBrowser(WebBrowser,"https://www.google.com/gmail/");
		EmailVerifications Email_Verifications = PageFactory.initElements(driver, EmailVerifications.class);
		Email_Verifications.EmailLogin(AddMemberFirstName, AddMemberGmailPwd, logger);
		Email_Verifications.EmailNotification(logger);
	}
	@Test(priority = 15,groups=("MyProfile"), enabled = false)
	@Parameters({ "firefoxbrowser","AppUrl","PrimaryMemberEmail","PrimaryMemberPwd","EditMemberFirstName","EditMemberLastName","EditMemberJobTitle"})
	public void EditMember(String WebBrowser, String AppUrl, String PrimaryMemberEmail, String PrimaryMemberPwd, String EditMemberFirstName, String EditMemberLastName, String EditMemberJobTitle) throws Exception
	{
		logger = extent.startTest("Edit Member Deatils");
		driver = Browser.startBrowser(WebBrowser,AppUrl);
    	LoginPage Login_Page = PageFactory.initElements(driver, LoginPage.class);
    	Login_Page.login(PrimaryMemberEmail, PrimaryMemberPwd, logger);
    	Login_Page.wait(PrimaryMemberEmail, logger);
    	MyProfilePage MyProfile_Page = PageFactory.initElements(driver, MyProfilePage.class);
    	MyProfile_Page.EditMember(EditMemberFirstName, EditMemberLastName, EditMemberJobTitle, logger);
	}
	@Test(priority = 16,groups=("MyProfile"), enabled = false)
	@Parameters({ "firefoxbrowser","AppUrl","EditMemberFullName","EditMemberJobtitle"})
	public void VerifyingupdatedMemberDetailsInBusnessDirectory(String WebBrowser, String AppUrl,String EditMemberFullName, String EditMemberJobtitle ) throws Exception
	{
		logger = extent.startTest("Verifying updated Member Details In the Busness Directory");
		driver = Browser.startBrowser(WebBrowser,AppUrl);
		BusinessDirectory BusinessDirectory_Page = PageFactory.initElements(driver, BusinessDirectory.class);
		BusinessDirectory_Page.SearchMember(EditMemberFullName, logger);
		BusinessDirectory_Page.Memberupdatedetails(EditMemberFullName, EditMemberJobtitle, logger);
	}
	@Test(priority = 17,groups=("MyProfile"), enabled = false)
	@Parameters({ "firefoxbrowser","AppUrl","PrimaryMemberEmail","PrimaryMemberPwd"})
	public void SuspendMember(String WebBrowser, String AppUrl,String PrimaryMemberEmail,String PrimaryMemberPwd) throws Exception
	{
		logger = extent.startTest("Suspend Member");
		driver = Browser.startBrowser(WebBrowser,AppUrl);
    	LoginPage Login_Page = PageFactory.initElements(driver, LoginPage.class);
    	Login_Page.login(PrimaryMemberEmail, PrimaryMemberPwd, logger);
    	Login_Page.wait(PrimaryMemberEmail, logger);
    	MyProfilePage MyProfile_Page = PageFactory.initElements(driver, MyProfilePage.class);
    	MyProfile_Page.SuspendMember(logger);
	}
	@Test(priority = 18,groups=("MyProfile"), enabled = false)
	@Parameters({ "firefoxbrowser","AppUrl","PrimaryMemberEmail","PrimaryMemberPwd","ReActivateEmail","ReActiavtedNewPassword"})
	public void ActivateMember(String WebBrowser, String AppUrl, String PrimaryMemberEmail,String PrimaryMemberPwd,String ReActivateEmail,String ReActivatedEmailPassword,String ReActiavtedNewPassword ) throws Exception
	{
		logger = extent.startTest("Activate Member");
		driver = Browser.startBrowser(WebBrowser,AppUrl);
    	LoginPage Login_Page = PageFactory.initElements(driver, LoginPage.class);
    	Login_Page.login(PrimaryMemberEmail, PrimaryMemberPwd, logger);
    	Login_Page.wait(PrimaryMemberEmail, logger);
    	MyProfilePage MyProfile_Page = PageFactory.initElements(driver, MyProfilePage.class);
    	MyProfile_Page.ActivateMember(logger);
    	DashBoardPage dashBoard_Page=PageFactory.initElements(driver, DashBoardPage.class);
    	dashBoard_Page.logout();
    	EmailVerifications EmailVerification=PageFactory.initElements(driver, EmailVerifications.class);
    	EmailVerification.OpenGMailInnewTab();
    	EmailVerification.EmailLogin(ReActivateEmail,ReActivatedEmailPassword, logger);
    	EmailVerification.ReActivatedEmailNotofication(ReActiavtedNewPassword, ReActiavtedNewPassword, logger);
	}
	@Test(priority = 19,groups=("MyProfile"), enabled = false)
	@Parameters({ "firefoxbrowser","AppUrl","PrimaryMemberEmail","PrimaryMemberPwd"})
	public void ChangePrimarytoSecondaryConatct(String WebBrowser, String AppUrl,String PrimaryMemberEmail, String PrimaryMemberPwd) throws Exception
	{
		logger = extent.startTest("Change Primary to Secondary Conatct");
		driver = Browser.startBrowser(WebBrowser,AppUrl);
    	LoginPage Login_Page = PageFactory.initElements(driver, LoginPage.class);
    	Login_Page.login(PrimaryMemberEmail, PrimaryMemberPwd, logger);
    	Login_Page.wait(PrimaryMemberEmail, logger);
    	MyProfilePage MyProfile_Page = PageFactory.initElements(driver, MyProfilePage.class);
    	MyProfile_Page.ChangemembertoSecondary(logger);
	}
	@Test(priority = 20,groups=("MyProfile"), enabled = false)
	@Parameters({ "firefoxbrowser","AppUrl","PrimaryMemberEmail","PrimaryMemberPwd"})
	public void ChangeSecondarytoPrimaryConatct(String WebBrowser, String AppUrl,String PrimaryMemberEmail, String PrimaryMemberPwd) throws Exception
	{
		logger = extent.startTest("Change Secondary to Primary Conatct");
		driver = Browser.startBrowser(WebBrowser,AppUrl);
    	LoginPage Login_Page = PageFactory.initElements(driver, LoginPage.class);
    	Login_Page.login(PrimaryMemberEmail, PrimaryMemberPwd, logger);
    	Login_Page.wait(PrimaryMemberEmail, logger);
    	MyProfilePage MyProfile_Page = PageFactory.initElements(driver, MyProfilePage.class);
    	MyProfile_Page.Changemembertoprimary(logger);
	}
	@Test(priority = 21,groups=("MyProfile"), enabled = false)
	@Parameters({ "firefoxbrowser","AppUrl","PrimaryMemberEmail","PrimaryMemberPwd"})
	public void professionalservices(String WebBrowser, String AppUrl,String PrimaryMemberEmail,String PrimaryMemberPwd) throws Exception
	{
		logger = extent.startTest("Update Professional Services");
		driver = Browser.startBrowser(WebBrowser,AppUrl);
    	LoginPage Login_Page = PageFactory.initElements(driver, LoginPage.class);
    	Login_Page.login(PrimaryMemberEmail, PrimaryMemberPwd, logger);
    	Login_Page.wait(PrimaryMemberEmail, logger);
    	MyProfilePage MyProfile_Page = PageFactory.initElements(driver, MyProfilePage.class);
    	MyProfile_Page.updateProfessionalMatches(logger);
	}
	@AfterMethod
	public void getResult(ITestResult result) throws Exception
		{
			if(result.getStatus() == ITestResult.FAILURE)
			{
				logger.log(LogStatus.FAIL,result.getName()+ " Test Case is Failed");
				logger.log(LogStatus.FAIL, "Test Case Failed is "+result.getThrowable());
				String screenShotPath = GetScreenShot.capture(driver, "ScreenShotName");
				logger.log(LogStatus.FAIL, logger.addScreenCapture(screenShotPath));
				
			}
			else if(result.getStatus() == ITestResult.SUCCESS)
				{
				    logger.log(LogStatus.PASS, result.getName()+" Test Case is PASSED");

					String screenShotPath = GetScreenShot.capture(driver, "ScreenShotName");
					logger.log(LogStatus.PASS, logger.addScreenCapture(screenShotPath),  "Test Case is PASSED");

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
