package com.connectpronetqa;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class MyProfilePage {

	
	
	//EditProfile
	@FindBy(xpath = "//button[@ng-click='profile.EditMyProfile()']")
	WebElement EditBtn;
	@FindBy(xpath = "//*[@name='FirstName']")
	WebElement FirstName;
	@FindBy(xpath = "//*[@name='LastName']")
	WebElement LastName;
	@FindBy(xpath = "//*[@name='JobTitle']")
	WebElement JobTitle;
	@FindBy(xpath = "//textarea[@name='Biography']")
	WebElement ProfessionalSummary;
	@FindBy(xpath = "//input[@name='YouTubeUrl']")
	WebElement YouTubeUrl;
	@FindBy(xpath = "//input[@name='LinkedInUrl']")
	WebElement LinkedInUrl;
	@FindBy(xpath = "//input[@name='FacebookUrl']")
	WebElement FacebookUrl;
	@FindBy(xpath = "//input[@name='TwitterUrl']")
	WebElement TwitterUrl;
	@FindBy(xpath = "//input[@name='GooglePlusUrl']")
	WebElement GooglePlusUrl;
	//Portfolio
	@FindBy(xpath = "//input[@name='PortfolioTitle']")
	WebElement PortfolioTitle;
	@FindBy(xpath = "//input[@name='PortfolioLink']")
	WebElement PortfolioLink;
	@FindBy(xpath = "//button[contains(@ng-click,'OIdata.ShowOtherInfoModel()')]")
	WebElement AddPortfolioBtn;
	@FindBy(xpath = "//*/div[2]/div/div/div/div[2]/div[2]/a[2]")
	WebElement EditPortfolioBtn;
	@FindBy(xpath = "//*/div[2]/div/div/div/div[2]/div[2]/a[1]")
	WebElement DeleteportfolioBtn;
	//Skills
	@FindBy(xpath = "//*/div[2]/div[2]/div[1]/a/i")
	WebElement UpdateSkillsBtn;
	@FindBy(xpath = "//input[@placeholder='Add Skills']")
	WebElement AddSkills;
	@FindBy(xpath = "//*/div[2]/div[1]/div/span/span/span")
	WebElement DeleteSkillsBtn;
	@FindBy(xpath="//*[@id='EditMySkillsForm']/div[3]/div/div[2]/button")
	WebElement SkillsSaveBtn;
	//Interests
	@FindBy(xpath = "//*/div[2]/div[2]/div[2]/a/i")
	WebElement UpdateInterestsBtn;
	@FindBy(xpath = "//input[@placeholder='Add Interest']")
	WebElement AddInterest;
	@FindBy(xpath = "//*/div[2]/div[1]/div/span/span/span")
	WebElement DeleteInterestBtn;
	@FindBy(xpath="//*[@id='EditMyInterestsForm']/div[3]/div/div[2]/button")
	WebElement InterestsSaveBtn;

	//Profile picture
	@FindBy(xpath = "//a[@id='changePictureLink']")
	WebElement changeProfilePictureLink;
	@FindBy(xpath = "//button[contains(.,'Browse')]")
	WebElement BrowseBtn;
	@FindBy(xpath = "//button[contains(.,'Upload')]")
	WebElement UploadBtn;
	@FindBy(xpath = "//button[contains(.,'Update')]")
	WebElement UpdateBtn;
	@FindBy(xpath = "//button[contains(.,'Save')]")
	WebElement SaveBtn;
	@FindBy(xpath = "//button[contains(.,'Cancel')]")
	WebElement CancelBtn;
	//*******************Company profile*************************
	@FindBy(xpath = "//a[@href='#company-profile']")
	WebElement CompanyProfileTab;
	//Change Company logo
	@FindBy(xpath = "//button[@ng-click='CPData.EditCompanyProfile()']")
	WebElement EditCompanyProfileBtn;
	@FindBy(xpath = "//a[@ng-click='CPData.ChangeCompanyLogo()']")
	WebElement ChangeCompanyLogoLink;
	@FindBy(xpath = "//*[@id='EditMyProfilePicForm']/div[2]/div[2]/div/button")
	WebElement CompanyBrowsebtn;
	@FindBy(xpath = "//*[@id='EditCompanyLogoForm']/div[3]/div/div[2]/button")
	WebElement uploadCompanyBtn;
	@FindBy(xpath = "//*[@id='EditCompanyProfileForm']/div[11]/div/button[2]")
	WebElement CompanyProfileSaveBtn;
	//Edit Company Profile
	@FindBy(xpath ="//input[@name='CompanyEmail']")
	WebElement CompanyEmail;
	@FindBy(xpath ="//select[@name='NoOfEmployees']")
	WebElement NoOfEmployees;
	@FindBy(xpath ="//input[@placeholder='Select Business Categories with max limit of 5']")
	WebElement BusinessCategories;
	@FindBy(xpath ="//textarea[@id='BusinessDescription']")
	WebElement BusinessDescription;
	//*******************Additional Information*************************
	//Edit Locations
	@FindBy(xpath="//a[contains(.,'Additional Information')]")
	WebElement AdditionalInformationtab;
	@FindBy(xpath ="//*[@id='AdditionalInfoCtrl']/div[2]/div/div[1]/div/div[1]/div/div[2]/button")
	WebElement EditLocationBtn;
	@FindBy(xpath ="//input[@name='LocationName']")
	WebElement LocationName;
	@FindBy(xpath ="//select[@name='LocationType']")
	WebElement LocationType;
	@FindBy(xpath ="//input[@name='LocationAddress']")
	WebElement LocationAddress;
	@FindBy(xpath ="//select[@name='LocationStatus']")
	WebElement LocationStatus;
	@FindBy(xpath ="//*[@id='LocationForm']/div[3]/div/div[2]/button")
	WebElement LocationUpdateBtn;
	//Add Member
	@FindBy(xpath ="//input[@name='EmailID']")
	WebElement MemberEmailID;
	@FindBy(xpath ="//input[@id='password']")
	WebElement password;
	@FindBy(xpath ="//input[@id='confirmpassword']")
	WebElement confirmpassword;
	@FindBy(xpath ="//select[@name='MemberContactTypeID']")
	WebElement MemberContactTypeID;
	@FindBy(xpath ="//select[@name='LocationDetailID']")
	WebElement LocationDetailID;
	
	//Edit Member
	@FindBy(xpath="//*[@id='AdditionalInfoCtrl']/div[5]/div[1]/div[4]/div/div[1]/div[1]/div[2]/button")
	WebElement MemberEditBtn;
	@FindBy(xpath="//*[@id='ContactForm']/div[2]/div[5]/div/div/select")
	WebElement MemberStatus;
	@FindBy(xpath="//*[@id='ContactForm']/div[3]/div/div[2]/button")
	WebElement MemberupdateBtn;
	@FindBy(xpath="//*[@id='ContactForm']/div[2]/div[4]/div[1]/div/select")
	WebElement ContactType;
	@FindBy(xpath = "//*[@id='FirstName']")
	WebElement EditFirstName;
	@FindBy(xpath = "//*[@id='LastName']")
	WebElement EditLastName;
	@FindBy(xpath = "//*[@id='JobTitle']")
	WebElement EditJobTitle;
	
	@FindBy(xpath="//a[@class='btn btn-primary btn-sm']")
	WebElement Welcomemenu;
	@FindBy(xpath="//a[contains(.,' My Profile')]")
	WebElement MyProfile;
	//Professional Matches
	@FindBy(xpath="//*[@id='body']/section/div/div[2]/ul/li[4]/a")
	WebElement ProfessionalMatchesTab;
	@FindBy(xpath="//a[contains(.,'Organization Services')]")
	WebElement OrganizationServicesBtn;
	@FindBy(xpath=".//*/div[1]/div[2]/div[3]/div[1]/select")
	WebElement FirstService;
	@FindBy(xpath=".//*/div[1]/div[2]/div[4]/div[1]/select")
	WebElement SecondService;
	@FindBy(xpath="//button[contains(.,' Submit')]")
	WebElement SubmitBtn;
	
	//********************************************************************
	WebDriver driver;
	public MyProfilePage (WebDriver Ldriver)
	{
		this.driver=Ldriver;
	}
	public void Profileupdate(String FName,String LName, String jtitle,String PSummary, String Ytube, String LUrl, String FUrl,String TUrl, String GUrl, ExtentTest logger ) throws Exception 
	{
		WebDriverWait wait = new WebDriverWait(driver, 20);
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='btn btn-primary btn-sm']")));
		Welcomemenu.click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(.,' My Profile')]")));
		MyProfile.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@ng-click='profile.EditMyProfile()']")));
		String screenShotPath = GetScreenShot.capture(driver, "ScreenShotName");
		logger.log(LogStatus.PASS, logger.addScreenCapture(screenShotPath),"My Profile page loaded");
		EditBtn.click();
		Thread.sleep(1000);
		String screenShotPath1 = GetScreenShot.capture(driver, "ScreenShotName");
		logger.log(LogStatus.PASS, logger.addScreenCapture(screenShotPath1),"Before clearing the details");
		JobTitle.clear();
		ProfessionalSummary.clear();
		YouTubeUrl.clear();
		LinkedInUrl.clear();
		FacebookUrl.clear();
		TwitterUrl.clear();
		GooglePlusUrl.clear();
		FirstName.clear();
		LastName.clear();
		String screenShotPath2 = GetScreenShot.capture(driver, "ScreenShotName");
		logger.log(LogStatus.PASS, logger.addScreenCapture(screenShotPath2),"After clearing the details");
		FirstName.sendKeys(FName);
		LastName.sendKeys(LName);
		JobTitle.sendKeys(jtitle);
		ProfessionalSummary.sendKeys(PSummary);
		YouTubeUrl.sendKeys(Ytube);
		LinkedInUrl.sendKeys(LUrl);
		FacebookUrl.sendKeys(FUrl);
		TwitterUrl.sendKeys(TUrl);
		GooglePlusUrl.sendKeys(GUrl);
		String screenShotPath3 = GetScreenShot.capture(driver, "ScreenShotName");
		logger.log(LogStatus.PASS, logger.addScreenCapture(screenShotPath3),"After entering the details");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement SaveBtnView =  driver.findElement(By.xpath("//*[@id='EditMyProfileForm']/div[6]/div/button[2]"));
		js.executeScript("arguments[0].scrollIntoView(true);",SaveBtnView);
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id='EditMyProfileForm']/div[6]/div/button[2]")).click();
		Thread.sleep(5000);
		String screenShotPath4 = GetScreenShot.capture(driver, "ScreenShotName");
		logger.log(LogStatus.PASS, logger.addScreenCapture(screenShotPath4),"After Clicked on Save Button");
	
	}
	public void AddProtfolio(String title,String url,ExtentTest logger) throws Exception
	{
		WebDriverWait wait = new WebDriverWait(driver, 20);
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='btn btn-primary btn-sm']")));
		Welcomemenu.click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(.,' My Profile')]")));
		MyProfile.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@ng-click='profile.EditMyProfile()']")));
		Thread.sleep(500);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement AddPortfolioBtnView = AddPortfolioBtn;
		js.executeScript("arguments[0].scrollIntoView(true);",AddPortfolioBtnView);
		String screenShotPath = GetScreenShot.capture(driver, "ScreenShotName");
		logger.log(LogStatus.PASS, logger.addScreenCapture(screenShotPath),"Before adding Portfiolio details");
		AddPortfolioBtn.click();
		Thread.sleep(2000);
		PortfolioTitle.sendKeys(title);
		PortfolioLink.sendKeys(url);
		String screenShotPath1 = GetScreenShot.capture(driver, "ScreenShotName");
		logger.log(LogStatus.PASS, logger.addScreenCapture(screenShotPath1),"After entering the Portfiolio details");
		SaveBtn.click();
		Thread.sleep(5000);
		String screenShotPath2 = GetScreenShot.capture(driver, "ScreenShotName");
		logger.log(LogStatus.PASS, logger.addScreenCapture(screenShotPath2),"After Saving Portfiolio details");
	
	}
	public void Updateportfolio(String title, String url,ExtentTest logger) throws Exception 
	{
		WebDriverWait wait = new WebDriverWait(driver, 20);
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='btn btn-primary btn-sm']")));
		Welcomemenu.click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(.,' My Profile')]")));
		MyProfile.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@ng-click='profile.EditMyProfile()']")));
		Thread.sleep(5000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement EditPortfolioBtnView = EditPortfolioBtn;
        js.executeScript("arguments[0].scrollIntoView(true);",EditPortfolioBtnView);
		Thread.sleep(1000);
		String screenShotPath = GetScreenShot.capture(driver, "ScreenShotName");
		logger.log(LogStatus.PASS, logger.addScreenCapture(screenShotPath),"Before Editing Portfiolio details");
		EditPortfolioBtn.click();
		Thread.sleep(1000);
		PortfolioTitle.clear();
		PortfolioLink.clear();
		String screenShotPath1 = GetScreenShot.capture(driver, "ScreenShotName");
		logger.log(LogStatus.PASS, logger.addScreenCapture(screenShotPath1),"After clearing Portfiolio details");
		PortfolioTitle.sendKeys(title);
		PortfolioLink.sendKeys(url);
		String screenShotPath3 = GetScreenShot.capture(driver, "ScreenShotName");
		logger.log(LogStatus.PASS, logger.addScreenCapture(screenShotPath3),"After Entering Portfiolio details");
		PortfolioTitle.click();
		UpdateBtn.click();
		Thread.sleep(2000);		
		String screenShotPath4 = GetScreenShot.capture(driver, "ScreenShotName");
		logger.log(LogStatus.PASS, logger.addScreenCapture(screenShotPath4),"After Saving Portfiolio details");
	
	}
	public void Deleteportfolio(ExtentTest logger) throws Exception 
	{
		WebDriverWait wait = new WebDriverWait(driver, 20);
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='btn btn-primary btn-sm']")));
		Welcomemenu.click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(.,' My Profile')]")));
		MyProfile.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@ng-click='profile.EditMyProfile()']")));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement DeleteportfolioBtnView =  DeleteportfolioBtn;
        js.executeScript("arguments[0].scrollIntoView(true);",DeleteportfolioBtnView);
		Thread.sleep(1000);
		String screenShotPath = GetScreenShot.capture(driver, "ScreenShotName");
		logger.log(LogStatus.PASS, logger.addScreenCapture(screenShotPath),"Before Deleting Portfiolio details");
		DeleteportfolioBtn.click();
		Thread.sleep(3000);
		String screenShotPath1 = GetScreenShot.capture(driver, "ScreenShotName");
		logger.log(LogStatus.PASS, logger.addScreenCapture(screenShotPath1),"After Deleting Portfiolio details");
	}
	public void AddSkills(String Skills,ExtentTest logger) throws Exception 
	{
		WebDriverWait wait = new WebDriverWait(driver, 20);
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='btn btn-primary btn-sm']")));
		Welcomemenu.click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(.,' My Profile')]")));
		MyProfile.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@ng-click='profile.EditMyProfile()']")));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement UpdateSkillsBtnView = UpdateSkillsBtn;
		js.executeScript("arguments[0].scrollIntoView(true);",UpdateSkillsBtnView);
		Thread.sleep(2000);
		String screenShotPath = GetScreenShot.capture(driver, "ScreenShotName");
		logger.log(LogStatus.PASS, logger.addScreenCapture(screenShotPath),"Before Adding Skills");
		UpdateSkillsBtn.click();
		Thread.sleep(2000);
		String screenShotPath3 = GetScreenShot.capture(driver, "ScreenShotName");
		logger.log(LogStatus.PASS, logger.addScreenCapture(screenShotPath3),"Before Entering the Skills");
		AddSkills.sendKeys(Skills);
		Thread.sleep(1000);
		AddSkills.sendKeys(Keys.ENTER);
		Thread.sleep(1000);
		String screenShotPath1 = GetScreenShot.capture(driver, "ScreenShotName");
		logger.log(LogStatus.PASS, logger.addScreenCapture(screenShotPath1),"After Entering the Skills");
		SkillsSaveBtn.click();
		Thread.sleep(4000);
		String screenShotPath2 = GetScreenShot.capture(driver, "ScreenShotName");
		logger.log(LogStatus.PASS, logger.addScreenCapture(screenShotPath2),"After Saving Skills");
	}
	public void DeleteSkils (ExtentTest logger) throws Exception 
	{
		WebDriverWait wait = new WebDriverWait(driver, 20);
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='btn btn-primary btn-sm']")));
		Welcomemenu.click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(.,' My Profile')]")));
		MyProfile.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@ng-click='profile.EditMyProfile()']")));	
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement UpdateSkillsBtnView = UpdateSkillsBtn;
		js.executeScript("arguments[0].scrollIntoView(true);",UpdateSkillsBtnView);
		String screenShotPath = GetScreenShot.capture(driver, "ScreenShotName");
		logger.log(LogStatus.PASS, logger.addScreenCapture(screenShotPath), "Before Deleting the Skills" );
		UpdateSkillsBtn.click();
		Thread.sleep(2000);
		String screenShotPath3 = GetScreenShot.capture(driver, "ScreenShotName");
		logger.log(LogStatus.PASS, logger.addScreenCapture(screenShotPath3),"Before Removing the Skills");
		DeleteSkillsBtn.click();
		String screenShotPath1 = GetScreenShot.capture(driver, "ScreenShotName");
		logger.log(LogStatus.PASS, logger.addScreenCapture(screenShotPath1),"After Removing the Skills");
		SkillsSaveBtn.click();
		Thread.sleep(4000);
		String screenShotPath2 = GetScreenShot.capture(driver, "ScreenShotName");
		logger.log(LogStatus.PASS, logger.addScreenCapture(screenShotPath2),"After Deleting the Skills");
	
	}
	public void AddInterests (String interests, ExtentTest logger) throws Exception
	{
		WebDriverWait wait = new WebDriverWait(driver, 20);
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='btn btn-primary btn-sm']")));
		Welcomemenu.click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(.,' My Profile')]")));
		MyProfile.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@ng-click='profile.EditMyProfile()']")));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement UpdateInterestsBtnView =  UpdateInterestsBtn;
		js.executeScript("arguments[0].scrollIntoView(true);",UpdateInterestsBtnView);
		Thread.sleep(2000);
		String screenShotPath = GetScreenShot.capture(driver, "ScreenShotName");
		logger.log(LogStatus.PASS, logger.addScreenCapture(screenShotPath),"Before Adding the Interests");
		UpdateInterestsBtn.click();
		Thread.sleep(2000);
		String screenShotPath3 = GetScreenShot.capture(driver, "ScreenShotName");
		logger.log(LogStatus.PASS, logger.addScreenCapture(screenShotPath3),"Before Entering the Interests");
		AddInterest.sendKeys(interests);
		Thread.sleep(1000);
		AddInterest.sendKeys(Keys.ENTER);
		Thread.sleep(1000);
		String screenShotPath1 = GetScreenShot.capture(driver, "ScreenShotName");
		logger.log(LogStatus.PASS, logger.addScreenCapture(screenShotPath1),"After entering the Interests");
		InterestsSaveBtn.click();
		Thread.sleep(4000);
		String screenShotPath2 = GetScreenShot.capture(driver, "ScreenShotName");
		logger.log(LogStatus.PASS, logger.addScreenCapture(screenShotPath2),"After Saving the Interests");
	}
	public void DeleteInterests (ExtentTest logger) throws Exception
	{
		WebDriverWait wait = new WebDriverWait(driver, 20);
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='btn btn-primary btn-sm']")));
		Welcomemenu.click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(.,' My Profile')]")));
		MyProfile.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@ng-click='profile.EditMyProfile()']")));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement UpdateInterestsBtnView = UpdateInterestsBtn;
		js.executeScript("arguments[0].scrollIntoView(true);",UpdateInterestsBtnView);
		String screenShotPath = GetScreenShot.capture(driver, "ScreenShotName");
		logger.log(LogStatus.PASS, logger.addScreenCapture(screenShotPath),"Before Deleting the Interests");
		UpdateInterestsBtn.click();
		Thread.sleep(2000);
		String screenShotPath3 = GetScreenShot.capture(driver, "ScreenShotName");
		logger.log(LogStatus.PASS, logger.addScreenCapture(screenShotPath3),"Before Removing the Interest");
		DeleteInterestBtn.click();
		String screenShotPath1 = GetScreenShot.capture(driver, "ScreenShotName");
		logger.log(LogStatus.PASS, logger.addScreenCapture(screenShotPath1),"After Removing the Interest");
		InterestsSaveBtn.click();
		Thread.sleep(4000);
		String screenShotPath2 = GetScreenShot.capture(driver, "ScreenShotName");
		logger.log(LogStatus.PASS, logger.addScreenCapture(screenShotPath2),"After Deleting the Interests");
	}
	public void ChangeProfilePicture (ExtentTest logger) throws Exception
	{
		WebDriverWait wait = new WebDriverWait(driver, 20);
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='btn btn-primary btn-sm']")));
		Welcomemenu.click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(.,' My Profile')]")));
		MyProfile.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@ng-click='profile.EditMyProfile()']")));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement changePictureLinkView = changeProfilePictureLink;
		js.executeScript("arguments[0].scrollIntoView(true);",changePictureLinkView);
		String screenShotPath = GetScreenShot.capture(driver, "ScreenShotName");
		logger.log(LogStatus.PASS, logger.addScreenCapture(screenShotPath),"Before Changing the profile picture");
		changeProfilePictureLink.click();
		Thread.sleep(1000);
		String screenShotPath1 = GetScreenShot.capture(driver, "ScreenShotName");
		logger.log(LogStatus.PASS, logger.addScreenCapture(screenShotPath1),"After clicking on the the change profile picture link");
		BrowseBtn.click();
		Thread.sleep(5000);
		String screenShotPath2 = GetScreenShot.capture(driver, "ScreenShotName");
		logger.log(LogStatus.PASS, logger.addScreenCapture(screenShotPath2),"After clicking on the broswe button");
		Runtime.getRuntime().exec("C:\\Users\\NTTeam\\Desktop\\Uploadfiles\\Image164.exe");
		Thread.sleep(4000);
		String screenShotPath3 = GetScreenShot.capture(driver, "ScreenShotName");
		logger.log(LogStatus.PASS, logger.addScreenCapture(screenShotPath3),"After browsing profile picture");
		UploadBtn.click();
		Thread.sleep(3000);
		String screenShotPath4 = GetScreenShot.capture(driver, "ScreenShotName");
		logger.log(LogStatus.PASS, logger.addScreenCapture(screenShotPath4),"After Uploading the profile picture");
	}
	public void ChangeCompanypicture(ExtentTest logger) throws InterruptedException, IOException
	{
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='btn btn-primary btn-sm']")));
		Welcomemenu.click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(.,' My Profile')]")));
		MyProfile.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@ng-click='profile.EditMyProfile()']")));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement CompanyProfileTabView =  driver.findElement(By.xpath("//a[@href='#company-profile']"));
		js.executeScript("arguments[0].scrollIntoView(true);",CompanyProfileTabView);
		CompanyProfileTab.click();
		changeProfilePictureLink.click();
		Thread.sleep(2000);
		CompanyBrowsebtn.click();
		Thread.sleep(5000);
		Runtime.getRuntime().exec("C:\\Users\\NTTeam\\Desktop\\Uploadfiles\\Image164.exe");
		Thread.sleep(4000);
		UploadBtn.click();		
	}
	public void CompanyProfile(String CEmail, String Desc, String LUrl, String FUrl, String TUrl, String GUrl, ExtentTest logger)
	{
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='btn btn-primary btn-sm']")));
		Welcomemenu.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(.,' My Profile')]")));
		MyProfile.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@ng-click='profile.EditMyProfile()']")));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement CompanyProfileTabView =  driver.findElement(By.xpath("//a[@href='#company-profile']"));
		js.executeScript("arguments[0].scrollIntoView(true);",CompanyProfileTabView);
		EditCompanyProfileBtn.click();
		CompanyEmail.sendKeys(CEmail);
		BusinessDescription.sendKeys(Desc);
		LinkedInUrl.sendKeys(LUrl);
		FacebookUrl.sendKeys(FUrl);
		TwitterUrl.sendKeys(TUrl);
		GooglePlusUrl.sendKeys(GUrl);
		SaveBtn.click();
		
	}
	public void EditLocation(String LName,String LAddress, ExtentTest logger) throws Exception
	{
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='btn btn-primary btn-sm']")));
		Welcomemenu.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(.,' My Profile')]")));
		MyProfile.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@ng-click='profile.EditMyProfile()']")));
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement AdditionalInformationTabView =  driver.findElement(By.xpath("//a[contains(.,'Additional Information')]"));
		js.executeScript("arguments[0].scrollIntoView(true);",AdditionalInformationTabView);
		AdditionalInformationtab.click();
		
		Thread.sleep(2000);
		String screenShotPath = GetScreenShot.capture(driver, "ScreenShotName");
		logger.log(LogStatus.PASS, logger.addScreenCapture(screenShotPath),"Additonal Information Page");
		EditLocationBtn.click();
		String screenShotPath1 = GetScreenShot.capture(driver, "ScreenShotName");
		logger.log(LogStatus.PASS, logger.addScreenCapture(screenShotPath1),"After clicking Edit location button");
		Thread.sleep(2000);
		LocationName.clear();
		Select LStatus = new Select(LocationStatus);
		LStatus.selectByVisibleText("Active");
		LocationAddress.clear();
		String screenShotPath2 = GetScreenShot.capture(driver, "ScreenShotName");
		logger.log(LogStatus.PASS, logger.addScreenCapture(screenShotPath2),"After Clearing location name and address");
		LocationAddress.sendKeys(LAddress);
		LocationAddress.sendKeys(Keys.ARROW_DOWN);
		LocationAddress.sendKeys(Keys.ENTER);
		Thread.sleep(5000);
		LocationName.sendKeys(LName);
		String screenShotPath3 = GetScreenShot.capture(driver, "ScreenShotName");
		logger.log(LogStatus.PASS, logger.addScreenCapture(screenShotPath3),"After Entering the location and address");
		LocationUpdateBtn.click();
		Thread.sleep(5000);
		String screenShotPath4 = GetScreenShot.capture(driver, "ScreenShotName");
		logger.log(LogStatus.PASS, logger.addScreenCapture(screenShotPath4),"After clicking on Update button");
	}
	public void Additionalmember(String FName,String LName,String Jtitle, String EMail,String Pwd, String CPwd,ExtentTest logger)
	{
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='btn btn-primary btn-sm']")));
		Welcomemenu.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(.,' My Profile')]")));
		MyProfile.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@ng-click='profile.EditMyProfile()']")));
		
		FirstName.sendKeys(FName);
		LastName.sendKeys(LName);
		JobTitle.sendKeys(Jtitle);
		MemberEmailID.sendKeys(EMail);
		password.sendKeys(Pwd);
		confirmpassword.sendKeys("CPwd");
		SaveBtn.click();
	}
	public void EditMember(String FName, String LName, String JTitle, ExtentTest logger) throws Exception
	{
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='btn btn-primary btn-sm']")));
		Welcomemenu.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(.,' My Profile')]")));
		MyProfile.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@ng-click='profile.EditMyProfile()']")));		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement AdditionalInformationTabView =  driver.findElement(By.xpath("//a[contains(.,'Additional Information')]"));
		js.executeScript("arguments[0].scrollIntoView(true);",AdditionalInformationTabView);
		String screenShotPath = GetScreenShot.capture(driver, "ScreenShotName");
		logger.log(LogStatus.PASS, logger.addScreenCapture(screenShotPath),"My profile page");
		AdditionalInformationtab.click();
		Thread.sleep(2000);
		String screenShotPath1 = GetScreenShot.capture(driver, "ScreenShotName");
		logger.log(LogStatus.PASS, logger.addScreenCapture(screenShotPath1),"After clicking on Addtional information tab ");
		MemberEditBtn.click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='FirstName']")));
		Thread.sleep(2000);
		String screenShotPath2 = GetScreenShot.capture(driver, "ScreenShotName");
		logger.log(LogStatus.PASS, logger.addScreenCapture(screenShotPath2),"After clicking Edit button of the member page");
		EditFirstName.clear();
		EditLastName.clear();
		EditJobTitle.clear();
		String screenShotPath3 = GetScreenShot.capture(driver, "ScreenShotName");
		logger.log(LogStatus.PASS, logger.addScreenCapture(screenShotPath3),"After clearing all the details of the member");
		EditFirstName.sendKeys(FName);
		EditLastName.sendKeys(LName);
		EditJobTitle.sendKeys(JTitle);
		MemberupdateBtn.click();
		Thread.sleep(3000);
		String screenShotPath4 = GetScreenShot.capture(driver, "ScreenShotName");
		logger.log(LogStatus.PASS, logger.addScreenCapture(screenShotPath4),"After entering all the details of the member");
		Thread.sleep(3000);
		
	}
	public void SuspendMember(ExtentTest logger) throws Exception
	{
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='btn btn-primary btn-sm']")));
		Welcomemenu.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(.,' My Profile')]")));
		MyProfile.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@ng-click='profile.EditMyProfile()']")));		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement AdditionalInformationTabView =  driver.findElement(By.xpath("//a[contains(.,'Additional Information')]"));
		js.executeScript("arguments[0].scrollIntoView(true);",AdditionalInformationTabView);
		String screenShotPath = GetScreenShot.capture(driver, "ScreenShotName");
		logger.log(LogStatus.PASS, logger.addScreenCapture(screenShotPath),"My profile page");
		AdditionalInformationtab.click();
		Thread.sleep(2000);
		String screenShotPath1 = GetScreenShot.capture(driver, "ScreenShotName");
		logger.log(LogStatus.PASS, logger.addScreenCapture(screenShotPath1),"After clicking on Addtional information tab ");
		MemberEditBtn.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='ContactForm']/div[2]/div[5]/div/div/select")));
		String screenShotPath2 = GetScreenShot.capture(driver, "ScreenShotName");
		logger.log(LogStatus.PASS, logger.addScreenCapture(screenShotPath2),"After clicking Edit button of the member page,i.e., Member Status with Active");
		Select Status = new Select(MemberStatus);
		Status.selectByVisibleText("InActive");
		Thread.sleep(2000);
		String screenShotPath3 = GetScreenShot.capture(driver, "ScreenShotName");
		logger.log(LogStatus.PASS, logger.addScreenCapture(screenShotPath3),"After selecting Member Status with InActive");
		MemberupdateBtn.click();
		String screenShotPath4 = GetScreenShot.capture(driver, "ScreenShotName");
		logger.log(LogStatus.PASS, logger.addScreenCapture(screenShotPath4),"After Suspending the Member");
		
	}
	public void ActivateMember(ExtentTest logger) throws Exception
	{
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='btn btn-primary btn-sm']")));
		Welcomemenu.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(.,' My Profile')]")));
		MyProfile.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@ng-click='profile.EditMyProfile()']")));		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement AdditionalInformationTabView =  driver.findElement(By.xpath("//a[contains(.,'Additional Information')]"));
		js.executeScript("arguments[0].scrollIntoView(true);",AdditionalInformationTabView);
		String screenShotPath = GetScreenShot.capture(driver, "ScreenShotName");
		logger.log(LogStatus.PASS, logger.addScreenCapture(screenShotPath),"My profile page");
		AdditionalInformationtab.click();
		Thread.sleep(2000);
		String screenShotPath1 = GetScreenShot.capture(driver, "ScreenShotName");
		logger.log(LogStatus.PASS, logger.addScreenCapture(screenShotPath1),"After clicking on Addtional information tab ");
		MemberEditBtn.click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='ContactForm']/div[2]/div[5]/div/div/select")));
		String screenShotPath2 = GetScreenShot.capture(driver, "ScreenShotName");
		logger.log(LogStatus.PASS, logger.addScreenCapture(screenShotPath2),"After clicking Edit button of the member page,i.e., Member Status with *");
		Select Status = new Select(MemberStatus);
		Status.selectByVisibleText("Active");
		String screenShotPath3 = GetScreenShot.capture(driver, "ScreenShotName");
		logger.log(LogStatus.PASS, logger.addScreenCapture(screenShotPath3),"After selecting Member Status with Active");
		js.executeScript("window.scrollBy(0,0)");
		MemberupdateBtn.click();
		Thread.sleep(4000);
		String screenShotPath4 = GetScreenShot.capture(driver, "ScreenShotName");
		logger.log(LogStatus.PASS, logger.addScreenCapture(screenShotPath4),"After Activating the Member");
		
	}
	public void Changemembertoprimary(ExtentTest logger) throws Exception
	{
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='btn btn-primary btn-sm']")));
		Welcomemenu.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(.,' My Profile')]")));
		MyProfile.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@ng-click='profile.EditMyProfile()']")));		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement AdditionalInformationTabView =  driver.findElement(By.xpath("//a[contains(.,'Additional Information')]"));
		js.executeScript("arguments[0].scrollIntoView(true);",AdditionalInformationTabView);
		String screenShotPath = GetScreenShot.capture(driver, "ScreenShotName");
		logger.log(LogStatus.PASS, logger.addScreenCapture(screenShotPath),"My profile page");
		AdditionalInformationtab.click();
		Thread.sleep(2000);
		String screenShotPath1 = GetScreenShot.capture(driver, "ScreenShotName");
		logger.log(LogStatus.PASS, logger.addScreenCapture(screenShotPath1),"After clicking on Addtional information tab ");
		MemberEditBtn.click();
		Thread.sleep(3000);
		String screenShotPath2 = GetScreenShot.capture(driver, "ScreenShotName");
		logger.log(LogStatus.PASS, logger.addScreenCapture(screenShotPath2),"After clicking Edit button of the member page,i.e., Member Contact type with *");
		Thread.sleep(1000);
		Select Contact = new Select(ContactType);
		Contact.selectByVisibleText("Primary Contact");
		String screenShotPath3 = GetScreenShot.capture(driver, "ScreenShotName");
		logger.log(LogStatus.PASS, logger.addScreenCapture(screenShotPath3),"After selecting Member Contact with Primary Contact");
		js.executeScript("window.scrollBy(0,0)");
		MemberupdateBtn.click();
		Thread.sleep(4000);
		String screenShotPath4 = GetScreenShot.capture(driver, "ScreenShotName");
		logger.log(LogStatus.PASS, logger.addScreenCapture(screenShotPath4),"After updating the Member with Primary Contact");
	}
	public void ChangemembertoSecondary(ExtentTest logger) throws Exception
	{
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='btn btn-primary btn-sm']")));
		Welcomemenu.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(.,' My Profile')]")));
		MyProfile.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@ng-click='profile.EditMyProfile()']")));		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement AdditionalInformationTabView =  driver.findElement(By.xpath("//a[contains(.,'Additional Information')]"));
		js.executeScript("arguments[0].scrollIntoView(true);",AdditionalInformationTabView);
		String screenShotPath = GetScreenShot.capture(driver, "ScreenShotName");
		logger.log(LogStatus.PASS, logger.addScreenCapture(screenShotPath),"My profile page");
		AdditionalInformationtab.click();
		Thread.sleep(2000);
		String screenShotPath1 = GetScreenShot.capture(driver, "ScreenShotName");
		logger.log(LogStatus.PASS, logger.addScreenCapture(screenShotPath1),"After clicking on Addtional information tab ");
		MemberEditBtn.click();
		Thread.sleep(3000);
		String screenShotPath2 = GetScreenShot.capture(driver, "ScreenShotName");
		logger.log(LogStatus.PASS, logger.addScreenCapture(screenShotPath2),"After clicking Edit button of the member page,i.e., Member Contact type with *");
		Thread.sleep(1000);
		Select Contact = new Select(ContactType);
		Contact.selectByVisibleText("Secondary Contact");
		String screenShotPath3 = GetScreenShot.capture(driver, "ScreenShotName");
		logger.log(LogStatus.PASS, logger.addScreenCapture(screenShotPath3),"After selecting Member Contact with Secondary Contact");
		js.executeScript("window.scrollBy(0,0)");
		MemberupdateBtn.click();
		Thread.sleep(4000);
		String screenShotPath4 = GetScreenShot.capture(driver, "ScreenShotName");
		logger.log(LogStatus.PASS, logger.addScreenCapture(screenShotPath4),"After updating the Member Contact with Secondary Contact");
	}
	public void updateProfessionalMatches(ExtentTest logger) throws Exception
	{
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='btn btn-primary btn-sm']")));
		Welcomemenu.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(.,' My Profile')]")));
		MyProfile.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@ng-click='profile.EditMyProfile()']")));		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement AdditionalInformationTabView =  driver.findElement(By.xpath("//a[contains(.,'Additional Information')]"));
		js.executeScript("arguments[0].scrollIntoView(true);",AdditionalInformationTabView);
		String screenShotPath = GetScreenShot.capture(driver, "ScreenShotName");
		logger.log(LogStatus.PASS, logger.addScreenCapture(screenShotPath),"My profile page");
		ProfessionalMatchesTab.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(.,'Organization Services')]")));
		String screenShotPath1 = GetScreenShot.capture(driver, "ScreenShotName");
		logger.log(LogStatus.PASS, logger.addScreenCapture(screenShotPath1),"Professional Matches page");
		OrganizationServicesBtn.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*/div[1]/div[2]/div[3]/div[1]/select")));
		Thread.sleep(1000);
		String screenShotPath2 = GetScreenShot.capture(driver, "ScreenShotName");
		logger.log(LogStatus.PASS, logger.addScreenCapture(screenShotPath2),"Update Organization Services page");
		Select servicesNEED1 = new Select(FirstService);
		servicesNEED1.selectByVisibleText("Administrative Services");
		Select servicesNEED2 = new Select(SecondService);
		servicesNEED2.selectByVisibleText("Business Services");
		/*Select servicesOffer1 = new Select(FirstService);
		servicesOffer1.selectByVisibleText("Administrative Services");
		Select servicesOffer2 = new Select(SecondService);
		servicesOffer2.selectByVisibleText("Business Services");*/		
		String screenShotPath3 = GetScreenShot.capture(driver, "ScreenShotName");
		logger.log(LogStatus.PASS, logger.addScreenCapture(screenShotPath3),"After Adding Organization  Services ");
		WebElement SubmitBtnView =  SubmitBtn;
		js.executeScript("arguments[0].scrollIntoView(true);",SubmitBtnView);
		Thread.sleep(2000);
		//WebElement EventsMenu = SubmitBtn;
		Actions action = new Actions(driver);
		action.moveToElement(SubmitBtnView).build().perform();
		
		SubmitBtn.click();
		action.sendKeys(Keys.ENTER).build().perform();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@ng-click='profile.EditMyProfile()']")));
	}
}


