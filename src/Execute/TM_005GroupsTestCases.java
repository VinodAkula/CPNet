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
import com.connectpronetqa.DashBoardPage;
import com.connectpronetqa.GetScreenShot;
import com.connectpronetqa.GroupsPage;
import com.connectpronetqa.LoginPage;
import com.connectpronetqa.MyGroupsPage;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Helper.Browser;

public class TM_005GroupsTestCases {

	ExtentReports extent;
	ExtentTest logger;
	Browser browser;
	WebDriver driver;
	
	@BeforeTest
	public void startReport(){
		extent = new ExtentReports(System.getProperty("user.dir") +"/test-output/Groups.html", true);
		extent
                //.addSystemInfo("Host Name", "Hyderabad")
                .addSystemInfo("Environment", "QA")
                .addSystemInfo("User Name", "Sasi Vnod");
        extent.loadConfig(new File(System.getProperty("user.dir")+"\\extent-config.xml"));
	}

    
    @Test(priority = 1,groups=("Group"), enabled = false)
    @Parameters({ "firefoxbrowser","AppUrl","CreateGroupEMailloginID", "CreateGroupEMailPwd", "GroupName","GroupDesc"})
	public void CreateGroup(String WebBrowser, String AppUrl, String CreateGroupEMailloginID, String CreateGroupEMailPwd, String GroupName, String GroupDesc) throws Exception
	{
		logger = extent.startTest("Verifying Member able to Create Group");
    	driver = Browser.startBrowser(WebBrowser,AppUrl);
    	LoginPage Login_Page = PageFactory.initElements(driver, LoginPage.class);
    	Login_Page.login(CreateGroupEMailloginID, CreateGroupEMailPwd, logger);
    	DashBoardPage DashBoard_Page= PageFactory.initElements(driver, DashBoardPage.class);
    	DashBoard_Page.Groups(logger);
    	GroupsPage Groups_Page = PageFactory.initElements(driver, GroupsPage.class);
    	Groups_Page.CreateGroup(GroupName, GroupDesc, logger);

	}
    @Test(priority = 2,groups=("Group"), enabled = false)
    @Parameters({ "firefoxbrowser","AppUrl","CreateGroupEMailloginID", "CreateGroupEMailPwd", "GroupName","UrlName","UrlLink"})
	public void SharingPost(String WebBrowser, String AppUrl, String CreateGroupEMailloginID,String CreateGroupEMailPwd, String GroupName, String UrlName, String UrlLink) throws Exception
	{
    	logger = extent.startTest("Verifying Member able to Sharing Post");
    	driver = Browser.startBrowser(WebBrowser,AppUrl);
    	LoginPage Login_Page = PageFactory.initElements(driver, LoginPage.class);
    	Login_Page.login(CreateGroupEMailloginID, CreateGroupEMailPwd, logger);
    	DashBoardPage DashBoard_Page= PageFactory.initElements(driver, DashBoardPage.class);
    	DashBoard_Page.Groups(logger);
    	GroupsPage Groups_Page = PageFactory.initElements(driver, GroupsPage.class);
    	Groups_Page.GoToMygroups();
    	MyGroupsPage MyGroups_page= PageFactory.initElements(driver, MyGroupsPage.class);
    	MyGroups_page.NavigateToGroup(GroupName, logger);
    	MyGroups_page.ShareLink(UrlName,UrlLink, logger);
    	MyGroups_page.ShareFile(logger);
    	MyGroups_page.ShareLink(UrlName,UrlLink, logger);
    	MyGroups_page.ShareImage(logger);
	}
    @Test(priority = 3,groups=("Group"), enabled = false)
    @Parameters({ "firefoxbrowser","AppUrl","CreateGroupEMailloginID", "CreateGroupEMailPwd", "GroupName","InviteMemberEmail"})
	public void InviteMember(String WebBrowser, String AppUrl, String CreateGroupEMailloginID, String CreateGroupEMailPwd, String GroupName, String InviteMemberEMail) throws Exception
	{
    	logger = extent.startTest("Verifying Group Admin able to Invite Member");
    	driver = Browser.startBrowser(WebBrowser,AppUrl);
    	LoginPage Login_Page = PageFactory.initElements(driver, LoginPage.class);
    	Login_Page.login(CreateGroupEMailloginID, CreateGroupEMailPwd, logger);
    	DashBoardPage DashBoard_Page= PageFactory.initElements(driver, DashBoardPage.class);
    	DashBoard_Page.Groups(logger);
    	GroupsPage Groups_Page = PageFactory.initElements(driver, GroupsPage.class);
    	Groups_Page.GoToMygroups();    	
    	MyGroupsPage MyGroups_page= PageFactory.initElements(driver, MyGroupsPage.class);
    	MyGroups_page.NavigateToGroup(GroupName,logger);
    	MyGroupsPage GroupsMyGroups_Page=PageFactory.initElements(driver, MyGroupsPage.class);
    	GroupsMyGroups_Page.InviteMember(InviteMemberEMail, logger);
	}
    @Test(priority = 4,groups=("Group"), enabled = false)
    @Parameters({ "firefoxbrowser","AppUrl","InviteMemberEmail", "InviteMemberEmailPwd", "GroupName"})
	public void JoinGroup(String WebBrowser, String AppUrl, String InviteMemberEmail,String InviteMemberEmailPwd, String GroupName ) throws Exception
	{
    	logger = extent.startTest("Verifying Member able to Join Group");
    	driver = Browser.startBrowser(WebBrowser,AppUrl);
    	LoginPage Login_Page = PageFactory.initElements(driver, LoginPage.class);
    	Login_Page.login(InviteMemberEmail, InviteMemberEmailPwd, logger);
    	DashBoardPage DashBoard_Page= PageFactory.initElements(driver, DashBoardPage.class);
    	DashBoard_Page.Groups(logger);
    	GroupsPage Groups_Page = PageFactory.initElements(driver, GroupsPage.class);
    	Groups_Page.GoToMygroups();    	
    	MyGroupsPage MyGroups_page= PageFactory.initElements(driver, MyGroupsPage.class);
    	MyGroups_page.NavigateToGroup(GroupName,logger);
    	MyGroupsPage GroupsMyGroups_Page=PageFactory.initElements(driver, MyGroupsPage.class);
    	GroupsMyGroups_Page.JoinGroup(logger);
	}
    @Test(priority = 5,groups=("Group"), enabled = false)
    @Parameters({ "firefoxbrowser","AppUrl","InviteMemberEmail", "InviteMemberEmailPwd","GroupName"})
	public void LikePost(String WebBrowser, String AppUrl,String InviteMemberEmail, String InviteMemberEmailPwd, String GroupName) throws Exception
	{
    	logger = extent.startTest("Verifying Member able to Like Post");
    	driver = Browser.startBrowser(WebBrowser,AppUrl);
    	LoginPage Login_Page = PageFactory.initElements(driver, LoginPage.class);
    	Login_Page.login(InviteMemberEmail, InviteMemberEmailPwd, logger);
    	DashBoardPage DashBoard_Page= PageFactory.initElements(driver, DashBoardPage.class);
    	DashBoard_Page.Groups(logger);
    	GroupsPage Groups_Page = PageFactory.initElements(driver, GroupsPage.class);
    	Groups_Page.GoToMygroups();    	
    	MyGroupsPage MyGroups_page= PageFactory.initElements(driver, MyGroupsPage.class);
    	MyGroups_page.NavigateToGroup(GroupName,logger);
    	MyGroupsPage GroupsMyGroups_Page=PageFactory.initElements(driver, MyGroupsPage.class);
    	GroupsMyGroups_Page.LikePost(logger);
	}
    @Test(priority = 6,groups=("Group"), enabled = true)
    @Parameters({ "firefoxbrowser","AppUrl","InviteMemberEmail", "InviteMemberEmailPwd","GroupName","Comment"})
	public void CommentPost(String WebBrowser, String AppUrl,String InviteMemberEmail, String InviteMemberEmailPwd, String GroupName, String Comment) throws Exception
	{
    	logger = extent.startTest("Verifying Member able to comment Post");
    	driver = Browser.startBrowser(WebBrowser,AppUrl);
    	LoginPage Login_Page = PageFactory.initElements(driver, LoginPage.class);
    	Login_Page.login(InviteMemberEmail, InviteMemberEmailPwd, logger);
    	DashBoardPage DashBoard_Page= PageFactory.initElements(driver, DashBoardPage.class);
    	DashBoard_Page.Groups(logger);
    	GroupsPage Groups_Page = PageFactory.initElements(driver, GroupsPage.class);
    	Groups_Page.GoToMygroups();    	
    	MyGroupsPage MyGroups_page= PageFactory.initElements(driver, MyGroupsPage.class);
    	MyGroups_page.NavigateToGroup(GroupName,logger);
    	MyGroupsPage GroupsMyGroups_Page=PageFactory.initElements(driver, MyGroupsPage.class);
    	GroupsMyGroups_Page.CommentPost(Comment,logger);
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
