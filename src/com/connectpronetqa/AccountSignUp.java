package com.connectpronetqa;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.asserts.SoftAssert;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class AccountSignUp {

	WebDriver driver;
	SoftAssert softAssertion= new SoftAssert();

	public AccountSignUp(WebDriver driver)
	{
		this.driver=driver;
	}
	@FindBy (xpath="//*[@id='msform']/fieldset[4]/div[2]/ng-repeat[2]/div/div/div/div[3]/a")
	WebElement MemberShipPlan;
	@FindBy(xpath="//*[@id='msform']/fieldset[4]/button[2]")
	WebElement NextBtn;
	@FindBy(xpath=".//*[@id='msform']/fieldset[5]/div[1]/div/div[2]/div/div[2]/div/ul/ng-repeat[2]/li/label/input")
	WebElement AuthroizeddotnetRdnBtn;
	@FindBy(xpath="//button[contains(.,' Pay through Checkout')]")
	WebElement PaythroughCheckoutBtn;
	@FindBy (xpath="//*[@id='body']/section/div/div/div[1]/div/span")
	WebElement Success;
	@FindBy(xpath="//input[@id='CompanyName']")
	WebElement CompanyName;
	@FindBy(xpath="//input[@type='search']")
	WebElement BusinessCategories;
	@FindBy(xpath="//select[@name='NoOfEmployees']")	
	WebElement NoOfEmployees;
	@FindBy(xpath="//input[@name='Website']")
	WebElement Website;
	@FindBy(xpath="//input[@id='CorporateAddress']")
	WebElement CorporateAddress;
	@FindBy(xpath="//textarea[@name='BusinessDescription']")
	WebElement BusinessDescription;
	@FindBy(xpath="//*[@id='CompanyInfoForm']/div[4]/button")
	WebElement CompanyInformationNextBtn;
	@FindBy(xpath="//input[@name='FirstName']")
	WebElement FirstName;
	@FindBy(xpath="//input[@name='LastName']")
	WebElement LastName;
	@FindBy(xpath="//input[@name='JobTitle']")
	WebElement JobTitle;
	@FindBy(xpath="//input[@data-fv-field='EmailAddress']")
	WebElement EmailID;
	@FindBy(xpath="//input[@name='Password']")
	WebElement Password;
	@FindBy(xpath="//input[@name='ConfirmPassword']")
	WebElement ConfirmPassword;
	@FindBy(xpath="//a[@href='/Account/Signup']")
	WebElement JoinNow;
	
	public void MemberRegistration(String CName, String WebSiteUrl, String Address, String Desc, String FName, String LName, String Jtitle,String Email, String Pwd, String CPwd, ExtentTest logger) throws Exception
	{
		Thread.sleep(4000);
		JoinNow.click();
		Thread.sleep(4000);
		String screenShotPath = GetScreenShot.capture(driver, "ScreenShotName");
		logger.log(LogStatus.PASS, logger.addScreenCapture(screenShotPath),"Company information page loaded");
		CompanyName.sendKeys(CName);
		Select TotalEmp = new Select(NoOfEmployees);
		TotalEmp.selectByVisibleText("101-150");
		BusinessCategories.sendKeys("boiler");
		BusinessCategories.sendKeys(Keys.ARROW_DOWN);
		BusinessCategories.sendKeys(Keys.ENTER);	
		Website.sendKeys(WebSiteUrl);
		CorporateAddress.sendKeys(Address);
		CorporateAddress.sendKeys(Keys.ARROW_DOWN);
		CorporateAddress.sendKeys(Keys.ENTER);	
		BusinessDescription.sendKeys(Desc);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement CompanyInformationNextBtnView =     driver.findElement(By.xpath("//*[@id='CompanyInfoForm']/div[4]/button"));
		js.executeScript("arguments[0].scrollIntoView(true);",CompanyInformationNextBtnView);
		CompanyInformationNextBtn.click();
		String screenShotPath1 = GetScreenShot.capture(driver, "ScreenShotName");
		logger.log(LogStatus.PASS, logger.addScreenCapture(screenShotPath1),"After entering the Company information");
		Thread.sleep(3000);
		String screenShotPath2 = GetScreenShot.capture(driver, "ScreenShotName");
		logger.log(LogStatus.PASS, logger.addScreenCapture(screenShotPath2),"Personal information page loaded");
		FirstName.sendKeys(FName);
		LastName.sendKeys(LName);
		EmailID.sendKeys(Email);
		Password.sendKeys(Pwd);
		ConfirmPassword.sendKeys(CPwd);		
		SoftAssert softAssertion= new SoftAssert();
		//System.out.println(driver.findElement(By.xpath("//small[contains(.,'Email address already exists. Please enter a new Email address')]")).getText());
		softAssertion.assertEquals(driver.findElement(By.xpath("//*[@id='PersonalInfoForm']/div[3]/div[1]/div/small[3]")).getText(), "Email address already exists. Please enter a new Email");
		softAssertion.assertAll();
		String screenShotPath3 = GetScreenShot.capture(driver, "ScreenShotName");
		logger.log(LogStatus.PASS, logger.addScreenCapture(screenShotPath3));
		
	}
	public void SelecetMemberShipPlan(ExtentTest logger ) throws Exception
	{
		String screenShotPath = GetScreenShot.capture(driver, "ScreenShotName");
		logger.log(LogStatus.PASS, logger.addScreenCapture(screenShotPath),"MemberShip Plans page");
		MemberShipPlan.click();
		NextBtn.click();
		String screenShotPath1 = GetScreenShot.capture(driver, "ScreenShotName");
		logger.log(LogStatus.PASS, logger.addScreenCapture(screenShotPath1),"Make PayMent Page");
		AuthroizeddotnetRdnBtn.click();
		Thread.sleep(2000);
		String screenShotPath3 = GetScreenShot.capture(driver, "ScreenShotName");
		logger.log(LogStatus.PASS, logger.addScreenCapture(screenShotPath3),"Payment Gateway Selected");
		PaythroughCheckoutBtn.click();
	}
	public void PaymentSuccess(ExtentTest logger) throws Exception
	{
		
		softAssertion.assertEquals(driver.findElement(By.xpath("//span[contains(.,'Your Payment processed successfully')]")).getText(), "Your Payment processed successfully");
		String screenShotPath = GetScreenShot.capture(driver, "ScreenShotName");
		logger.log(LogStatus.PASS, logger.addScreenCapture(screenShotPath),"Booking Summary Page");
	}

}
