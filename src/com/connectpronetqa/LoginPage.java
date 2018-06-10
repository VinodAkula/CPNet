package com.connectpronetqa;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class LoginPage {
	
	String SuspendedMessage = "Your account is suspended now. Please contact the administrator.";
	String InvalidCredentials = "Invalid Credentials. Please try again";
	String VerifyEmail = "Your Email Address is not verified. Please click here to verify your email address.";
	String ExpiredMessage = "Invalid Membership License";
	String Advertisement = "Advertisements";
	String PendingforApproval="Your organization License is Pending for Approval. Please Contact Administrator.";
	String InActiveMessage="Your organization License status is not active in the system. Please Contact Administrator.";
	
	@FindBy(xpath = "//a[@href='/Account/Login']")
	WebElement LoginLink;
	@FindBy(xpath = "//input[@type='email']")
	WebElement Email;
	@FindBy(xpath = "//input[@name='Password']")
	WebElement Password;
	@FindBy(xpath = "//button[contains(.,'Log In')]")
	WebElement LogInBtn;
	@FindBy(xpath = "//*[@id='LoginController']/div[1]/div/div/div[2]/div")
	WebElement Message;
	@FindBy(xpath = "//a[contains(.,'Advertisements')]")
	WebElement Advertisements;
	@FindBy(xpath = "//h3[contains(.,'Invalid Membership License')]")
	WebElement ExpiredBtn;
	@FindBy(xpath="//a[contains(.,'click here')]")
	WebElement ClickHereLink;
	@FindBy(xpath="//a[contains(.,'Resend')]")
	WebElement ResendBtn;
	@FindBy(xpath="//*/div/div/div[1]/div/div[1]/button")
	WebElement ResendPopupClose;
	@FindBy(xpath="//*[@id='wrapper']/header/div/div[1]/div/div[2]/div/div/a[1]")
	WebElement Menu;
	SoftAssert softAssertion= new SoftAssert();
	JavascriptExecutor js;
/*	public LoginPage ()
	{
		PageFactory.initElements(driver, this);
	}*/
	WebDriver driver;
	public LoginPage (WebDriver driver)
	{
		this.driver=driver;
	}
	public void login(String email, String pwd, ExtentTest logger) throws Exception 
	{		
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[contains(@src,'logo.png')]")));
		Thread.sleep(2000);
		LoginLink.click();
		Thread.sleep(3000);
		Email.sendKeys(email);
		Password.sendKeys(pwd);
		Thread.sleep(400);
		String screenShotPath1 = GetScreenShot.capture(driver, "ScreenShotName");
		logger.log(LogStatus.PASS, logger.addScreenCapture(screenShotPath1),"User Credentials has beed entered");
		wait.until(ExpectedConditions.elementToBeClickable(LogInBtn));
		LogInBtn.click();
		
//		logger.log(LogStatus.PASS, "Test Case Passed");
		//Assert.assertTrue(driver.findElement(By.xpath("//button[contains(.,'Log In')]")).isDisplayed());
		String screenShotPath2 = GetScreenShot.capture(driver, "ScreenShotName");
		logger.log(LogStatus.INFO, logger.addScreenCapture(screenShotPath2), "User clicked in login button");
		Thread.sleep(3000);
		/*
		if(email.equalsIgnoreCase("connectproem@gmail.com"))
		{
			Thread.sleep(5000);
		}
		
		else
			if(Message.getText().equalsIgnoreCase(VerifyEmail))
			{
			
			}
			else
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='wrapper']/header/div/div[1]/div/div[2]/div/div/a[1]")));
			wait.until(ExpectedConditions.elementToBeClickable(Menu));
		}*/
	}
	
	
	public void wait(String email, ExtentTest logger) throws InterruptedException 
	{
		Thread.sleep(9000);
		
		
		
	}
	
	public void Invalidlogin(ExtentTest logger) throws Exception
	{
		Thread.sleep(3000);
		//String ActualMessage = Message.getText();
		softAssertion.assertTrue(Message.isDisplayed());
		String Actual = Message.getText();
		softAssertion.assertEquals(Actual, InvalidCredentials);
		softAssertion.assertAll();
		}
	public void ExpiredMessage(ExtentTest logger) throws InterruptedException
	{
		Thread.sleep(3000);
		//String ActualMessage = Message.getText();
		softAssertion.assertTrue(ExpiredBtn.isDisplayed());
		String Actual = ExpiredBtn.getText();
		softAssertion.assertEquals(Actual, ExpiredMessage);
		softAssertion.assertAll();
		}
	public void Pending(ExtentTest logger) throws InterruptedException
	{
		Thread.sleep(3000);
		//String ActualMessage = Message.getText();
		softAssertion.assertTrue(Message.isDisplayed());
		String Actual = Message.getText();
		softAssertion.assertEquals(Actual, VerifyEmail);
		softAssertion.assertAll();
		}
	public void ResendVerification(ExtentTest logger) throws InterruptedException
	{
		
		 
		ClickHereLink.click();
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(.,'Resend')]")));
		Thread.sleep(2000);
		ResendBtn.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*/div/div/div[1]/div/div[1]/button")));
		Thread.sleep(1000);
		ResendPopupClose.click();
		
	}
	public void PendingforApproval(ExtentTest logger) throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(driver, 20);
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='LoginController']/div[1]/div/div/div[2]/div")));
		Thread.sleep(4000);
		softAssertion.assertTrue(Message.isDisplayed());
		String Actual = Message.getText();
		softAssertion.assertEquals(Actual, PendingforApproval);
		softAssertion.assertAll();
		}
	public void Suspended(ExtentTest logger) throws InterruptedException
	{
		Thread.sleep(3000);
		//String ActualMessage = Message.getText();
		softAssertion.assertTrue(Message.isDisplayed());
		String Actual = Message.getText();
		softAssertion.assertEquals(Actual,SuspendedMessage);
		softAssertion.assertAll();
		}
	public void SuccessfulLogin(ExtentTest logger) throws InterruptedException
	{
		Thread.sleep(3000);
		//String ActualMessage = Message.getText();
		softAssertion.assertTrue(Advertisements.isDisplayed());
		String Actual = Advertisements.getText();
		softAssertion.assertEquals(Actual,"Advertisements");
		softAssertion.assertAll();
		}
	public void InActiveOrgeanization(ExtentTest logger) throws InterruptedException
	{
		Thread.sleep(3000);
		//String ActualMessage = Message.getText();
		softAssertion.assertTrue(Message.isDisplayed());
		String Actual = Message.getText();
		softAssertion.assertEquals(Actual,InActiveMessage);
		softAssertion.assertAll();
	}
}	