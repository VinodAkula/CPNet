package com.connectpronetqa;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Password {
	
	
	@FindBy(xpath = "//a[@href='/Account/Login']")
	WebElement LogInLink;
	@FindBy(xpath = "//input[@type='email']")
	WebElement Email;
	@FindBy(xpath = "//a[contains(.,'Forgot Password?')]")
	WebElement ForgotPasswordBtn;
	@FindBy(xpath = "//button[contains(.,'Submit')]")
	WebElement SubmitBtn;
	@FindBy(xpath = "//button[contains(.,'OK')]")
	WebElement OKBtn;
	@FindBy(xpath = "//input[@id='newpassword']")
	WebElement NewPassword;
	@FindBy(xpath = "//input[@id='confirmpassword']")
	WebElement ConfirmPassword;
	@FindBy(xpath = "//*[@id='oldpassword']")
	WebElement OldPassword;
	@FindBy (xpath = "//div[@class='col-xs-12 col-md-12 col-lg-12 text-capitalize text-center']")
	WebElement ExpiredMessage;
	@FindBy(xpath = "//a[@class='btn btn-primary btn-sm']")
	WebElement WelcomeMenu;
	@FindBy(xpath = "//a[contains(.,'  Change Password')]")
	WebElement MenuChangepassword;
	@FindBy(xpath="//small[contains(.,'Old password and new password cannot be the same')]")
	WebElement ErrorMessage;
	@FindBy (xpath="//button[contains(.,'Save')]")
	WebElement SaveBtn;
	@FindBy(xpath = "html/body/div[4]/div/div/div[1]/div")
	WebElement Changepasswordpopup;


	WebDriver driver;
	public Password (WebDriver driver)
	{
		this.driver=driver;
	}
	public void forgotPassword (String email, ExtentTest logger) throws Exception
	{
		LogInLink.click();
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type='email']")));
		Email.sendKeys(email);
		Thread.sleep(2000);
		ForgotPasswordBtn.click();
		String screenShotPath = GetScreenShot.capture(driver, "ScreenShotName");
		logger.log(LogStatus.PASS, logger.addScreenCapture(screenShotPath),"User Clicked on forgot password button" );
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(.,'Submit')]")));
		Email.sendKeys(email);
		Thread.sleep(2000);
		SubmitBtn.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(.,'OK')]")));
		String screenShotPath1 = GetScreenShot.capture(driver, "ScreenShotName");
		logger.log(LogStatus.PASS, logger.addScreenCapture(screenShotPath1),"After requesting Reset password link" );
		OKBtn.click();
		Thread.sleep(3000);
	}
	public void Resetpassword(String NewPwd, String CPwd, ExtentTest logger) throws Exception
	{
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(.,'Submit')]")));
		Thread.sleep(2000);
		String screenShotPath = GetScreenShot.capture(driver, "ScreenShotName");
		logger.log(LogStatus.PASS, logger.addScreenCapture(screenShotPath),"Reset New Password page" );
		NewPassword.sendKeys(NewPwd);
		ConfirmPassword.sendKeys(CPwd);
		String screenShotPath1 = GetScreenShot.capture(driver, "ScreenShotName");
		logger.log(LogStatus.PASS, logger.addScreenCapture(screenShotPath1),"After entering the Password Details" );
		SubmitBtn.click();
		Thread.sleep(1000);
		String screenShotPath2 = GetScreenShot.capture(driver, "ScreenShotName");
		logger.log(LogStatus.PASS, logger.addScreenCapture(screenShotPath2),"After clicking Submit button" );
		String PopupMessage = Changepasswordpopup.getText();
		String UnableToChangePwd = PopupMessage.substring(0,34);
		System.out.println(PopupMessage);
		if(UnableToChangePwd.equals("Unable to change the password now."))
		{
			logger.log(LogStatus.FAIL, logger.addScreenCapture(screenShotPath1));
			logger.log(LogStatus.FAIL, "You have used any of your recent 3 passwords as new password, unable to reset new password");
			SoftAssert softAssertion= new SoftAssert();
			softAssertion.assertEquals(UnableToChangePwd, "password changed successfully");
			 softAssertion.assertAll();

		}
		else
		{
			logger.log(LogStatus.PASS,"Password change successfully" );
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(.,'OK')]")));
			OKBtn.click();
		}
		Thread.sleep(10000);
			
		
	}
	public void Expiredlink (ExtentTest logger) throws Exception
	{		
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='col-xs-12 col-md-12 col-lg-12 text-capitalize text-center']")));
		String screenShotPath = GetScreenShot.capture(driver, "ScreenShotName");
		logger.log(LogStatus.PASS, logger.addScreenCapture(screenShotPath),"Reset New Password page with Expired Message" );
		String Expected = "The Link To Reset Your Password Is Not Valid. Please Request A New Link By Clicking On 'forgot Password' Or Contact Administrator.";
		Assert.assertEquals(Expected,ExpiredMessage.getText());
		Thread.sleep(3000);
	}
	public void Invalidlink (ExtentTest logger) throws Exception
	{		
		WebDriverWait wait = new WebDriverWait(driver, 20);
		Thread.sleep(10000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='col-xs-12 col-md-12 col-lg-12 text-capitalize text-center']")));
		String screenShotPath = GetScreenShot.capture(driver, "ScreenShotName");
		logger.log(LogStatus.PASS, logger.addScreenCapture(screenShotPath),"Reset New Password page with Invalid link Message" );
		String Expected = "The Link To Reset Your Password Is Not Valid. Please Request A New Link By Clicking On 'forgot Password' Or Contact Administrator.";
		Assert.assertEquals(ExpiredMessage.getText(),Expected);
		Thread.sleep(3000);
	}
	public void SameOldandNewPassword(String OldPwd, String NewPwd, ExtentTest logger) throws Exception
	{
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='btn btn-primary btn-sm']")));
		WelcomeMenu.click();
		Thread.sleep(500);
		MenuChangepassword.click();		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(.,'Save')]")));
		Thread.sleep(3000);
		String screenShotPath = GetScreenShot.capture(driver, "ScreenShotName");
		logger.log(LogStatus.PASS, logger.addScreenCapture(screenShotPath),"Change password page" );
		OldPassword.sendKeys(OldPwd);
		NewPassword.sendKeys(NewPwd);
		String Expected = "Old password and new password cannot be the same";
		Assert.assertEquals(ErrorMessage.getText(),Expected);
		String screenShotPath1 = GetScreenShot.capture(driver, "ScreenShotName");
		logger.log(LogStatus.PASS, logger.addScreenCapture(screenShotPath1),"Change password page with the error message" );
		Thread.sleep(3000);
	}
	public void ChangePassword(String OldPwd, String NewPwd, String CPwd, ExtentTest logger) throws Exception
	{
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='btn btn-primary btn-sm']")));
		WelcomeMenu.click();
		Thread.sleep(500);
		MenuChangepassword.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(.,'Save')]")));
		Thread.sleep(3000);
		String screenShotPath = GetScreenShot.capture(driver, "ScreenShotName");
		logger.log(LogStatus.PASS, logger.addScreenCapture(screenShotPath),"Change password page" );
		OldPassword.sendKeys(OldPwd);
		NewPassword.sendKeys(NewPwd);
		ConfirmPassword.sendKeys(CPwd);
		String screenShotPath1 = GetScreenShot.capture(driver, "ScreenShotName");
		logger.log(LogStatus.PASS, logger.addScreenCapture(screenShotPath1),"After entering the password details" );
		SaveBtn.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(.,'OK')]")));
		String screenShotPath2 = GetScreenShot.capture(driver, "ScreenShotName");
		logger.log(LogStatus.PASS, logger.addScreenCapture(screenShotPath2),"After changing the Password" );
		OKBtn.click();
		Thread.sleep(3000);
	}
	
}
