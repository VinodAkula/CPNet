package com.connectpronetqa;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.asserts.SoftAssert;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class EMOrganizationPage {

	WebDriver driver;
	SoftAssert softAssertion= new SoftAssert();

	public EMOrganizationPage(WebDriver driver)
	{
		this.driver=driver;
	}
	@FindBy (xpath="//input[@id='CompanyNameSearch']")
	WebElement CompanyNameSearch;
	@FindBy (xpath="//button[contains(.,'Search')]")
	WebElement SearchBtn;
	@FindBy (xpath="//span[@class='fa fa-close']")
	WebElement RejectMembership;
	@FindBy (xpath="//input[@id='rejectReason']")
	WebElement RejectReason;
	@FindBy (xpath="//button[contains(.,'Yes, Proceed')]")
	WebElement YesProceedBtn;
	@FindBy (xpath="//button[contains(.,'OK')]")
	WebElement OKBtn;
	@FindBy (xpath="//span[@class='fa fa-edit']")
	WebElement EditOrganizationBtn;
	@FindBy (xpath="//*[@id='btnSave']")
	WebElement SaveBtn;

	/*@FindBy (xpath="")
	WebElement ;

	@FindBy (xpath="")
	WebElement ;

	@FindBy (xpath="")
	WebElement ;

	@FindBy (xpath="")
	WebElement ;*/
	
	
	public void SearchOrganization (String CompanyName, ExtentTest logger) throws Exception
	{
		CompanyNameSearch.sendKeys(CompanyName);
		String screenShotPath = GetScreenShot.capture(driver, "ScreenShotName");
		logger.log(LogStatus.INFO, logger.addScreenCapture(screenShotPath),"Before search for the Organization");
		SearchBtn.click();
		Thread.sleep(4000);
		String screenShotPath1 = GetScreenShot.capture(driver, "ScreenShotName");
		logger.log(LogStatus.INFO, logger.addScreenCapture(screenShotPath1),"After search for the Organization");
	}
	public void RejectMemberShip()
	{
		RejectMembership.click();
	}
	public void ReasonForRejection(ExtentTest logger) throws Exception
	{
		
		Thread.sleep(3000);
		
		RejectReason.sendKeys("Invalid Membership");
		String screenShotPath = GetScreenShot.capture(driver, "ScreenShotName");
		logger.log(LogStatus.INFO, logger.addScreenCapture(screenShotPath),"Before Rejecting the Organization");
		YesProceedBtn.click();
		Thread.sleep(5000);
		String screenShotPath1 = GetScreenShot.capture(driver, "ScreenShotName");
		logger.log(LogStatus.INFO, logger.addScreenCapture(screenShotPath1),"After Rejecting the Organization");
		OKBtn.click();
		Thread.sleep(5000);
	}
	
	public void ApproveOrganization(ExtentTest logger) throws Exception
	{
		String screenShotPath = GetScreenShot.capture(driver, "ScreenShotName");
		logger.log(LogStatus.INFO, logger.addScreenCapture(screenShotPath),"before approving the Organization");
		EditOrganizationBtn.click();
		Thread.sleep(3000);
		
		Select Status = new Select(driver.findElement(By.xpath("//*[@id='EntityStatusID']")));
		Status.selectByVisibleText("Active");
		Thread.sleep(1000);
		SaveBtn.click();
		
		Thread.sleep(3000);
		String screenShotPath1 = GetScreenShot.capture(driver, "ScreenShotName");
		logger.log(LogStatus.INFO, logger.addScreenCapture(screenShotPath1),"After approving the Organization");
		
		
	}
	
}


