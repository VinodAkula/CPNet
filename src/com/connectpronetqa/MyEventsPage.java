package com.connectpronetqa;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.asserts.SoftAssert;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class MyEventsPage {
	
	SoftAssert softAssertion= new SoftAssert();
	WebDriver driver;
	public MyEventsPage (WebDriver driver)
	{
		this.driver=driver;
	}
	
	@FindBy (xpath="//a[@class='btn btn-primary btn-sm']")
	WebElement WelcomeMenu;
	@FindBy(xpath="//a[contains(.,' My Events')]")
	WebElement MenuMyEvents;
	@FindBy(xpath="//input[@id='eventDateRange']")
	WebElement EventDate;
	@FindBy(xpath="html/body/div[3]/div[2]/div[2]/table/thead/tr[1]/th[3]")
	WebElement NextMonth;
	@FindBy(xpath="html/body/div[3]/div[2]/div[2]/table/tbody/tr[1]/td[4]")
	WebElement Date;
	@FindBy(xpath="//button[contains(.,'Apply')]")
	WebElement ApplyBtn;
	@FindBy (xpath="//button[contains(.,' Search')]")
	WebElement SearchBtn;
	
	public void MyEvents (ExtentTest logger) throws Exception
	{
		WelcomeMenu.click();
		Thread.sleep(2000);
		MenuMyEvents.click();
		Thread.sleep(4000);
		String screenShotPath = GetScreenShot.capture(driver, "ScreenShotName");
		logger.log(LogStatus.PASS, logger.addScreenCapture(screenShotPath),"My Events page");
		EventDate.click();
		NextMonth.click();
		Thread.sleep(2000);
		NextMonth.click();
		Date.click();
		Thread.sleep(1000);
		Date.click();
		String screenShotPath1 = GetScreenShot.capture(driver, "ScreenShotName");
		logger.log(LogStatus.PASS, logger.addScreenCapture(screenShotPath1),"Event Date");
		ApplyBtn.click();
		Thread.sleep(1000);
		SearchBtn.click();
	}
	
	public void NoEvents(ExtentTest logger) throws Exception
	{
		
		softAssertion.assertEquals(driver.findElement(By.xpath("//p[contains(.,' No Events found ')]")).getText(), "No Events found");
		String screenShotPath = GetScreenShot.capture(driver, "ScreenShotName");
		logger.log(LogStatus.PASS, logger.addScreenCapture(screenShotPath),"My Events page");
	}
	
	public void RegisteredEvent(ExtentTest logger) throws Exception
	{
		String screenShotPath = GetScreenShot.capture(driver, "ScreenShotName");
		logger.log(LogStatus.PASS, logger.addScreenCapture(screenShotPath),"Registered Event");
	}

	

}
