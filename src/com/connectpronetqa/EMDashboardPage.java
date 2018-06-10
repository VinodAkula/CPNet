package com.connectpronetqa;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;


public class EMDashboardPage {
	@FindBy (xpath ="//h4[contains(.,'Total Testimonials')]" )
	WebElement Testmonials;
	@FindBy (xpath="//h4[contains(.,'Total Memberships')]")
	WebElement Organizations;
	@FindBy (xpath="html/body/div[1]/div/div[2]/div/nav/ul/li/a")
	WebElement EMMenu;
	@FindBy (xpath="//a[@href='/Account/Logout']")
	WebElement Logout;
	WebDriver driver;

	public EMDashboardPage (WebDriver Ldriver)
	{
		this.driver=Ldriver;
	}
	public void Testmonials(ExtentTest logger ) throws Exception
	{
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(.,'ConnectPro Global')]")));
		Thread.sleep(2000);
		String screenShotPath = GetScreenShot.capture(driver, "ScreenShotName");
		logger.log(LogStatus.INFO, logger.addScreenCapture(screenShotPath),"Event Manager Dashboard Page");
		Testmonials.click();		
	}
	
	public void OpenOrganizationPage(ExtentTest logger) throws Exception
	{
		Organizations.click();
		String screenShotPath = GetScreenShot.capture(driver, "ScreenShotName");
		logger.log(LogStatus.INFO, logger.addScreenCapture(screenShotPath),"Event Manager Dashboard Page");
			
	}
	
	public void EMLogout() throws InterruptedException
	{
		
		EMMenu.click();
		Thread.sleep(2000);
		Logout.click();
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(.,'Log In')]")));
		
	}

}
