package com.connectpronetqa;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class GroupsPage {
	
	@FindBy(xpath = "//a[contains(.,'My Groups')]")
	WebElement MyGrpsBtn;
	@FindBy(xpath = "//button[contains(.,'Create Group')]")
	WebElement CreateGrpBtn;
	@FindBy(xpath = "//button[contains(.,'Join Group(s) ')]")
	WebElement JoinGrpsBtn;	
	@FindBy(xpath = "//input[@type='search']")
	WebElement SearchField;
	@FindBy(xpath = "//input[@id='Name']")
	WebElement GrpNameFeild;
	@FindBy(xpath = "//textarea[@id='Description']")
	WebElement GrpDescription;
	@FindBy(xpath = "//*[@id='upload']")
	WebElement GrpImageUpload;
	@FindBy(xpath = "//select[@id='GroupTypeID']")
	WebElement GrpType;
	@FindBy(xpath = "//button[contains(.,' Save')]")
	WebElement SaveBtn;
	@FindBy(xpath = "")
	WebElement A;
	@FindBy(xpath = "")
	WebElement B;
	WebDriver driver;
	public GroupsPage (WebDriver Ldriver)
	{
		this.driver=Ldriver;
	}
	public void CreateGroup(String GroupName, String GroupDesc, ExtentTest logger) throws Exception 
	{
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(.,'Create Group')]")));
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement CreateGrpBtnView = CreateGrpBtn;
		js.executeScript("arguments[0].scrollIntoView(true);",CreateGrpBtnView);
		logger.log(LogStatus.INFO,"Groups Page");
		String screenShotPath = GetScreenShot.capture(driver, "ScreenShotName");
		logger.log(LogStatus.PASS, logger.addScreenCapture(screenShotPath));
		CreateGrpBtn.click();
		Thread.sleep(2000);
		logger.log(LogStatus.INFO,"Create Group form");
		String screenShotPath1 = GetScreenShot.capture(driver, "ScreenShotName");
		logger.log(LogStatus.PASS, logger.addScreenCapture(screenShotPath1));
		GrpNameFeild.sendKeys(GroupName);
		//"Each SOFKIN home will consist of a group of about 10 kids with one or two house mothers. The house mothers will assist the kids."
		GrpDescription.sendKeys(GroupDesc);
		Thread.sleep(1000);
		GrpImageUpload.click();
		Thread.sleep(3000);
		Runtime.getRuntime().exec("C:\\Users\\sasi\\Desktop\\AutoIt\\GroupShareImage.exe");
		Thread.sleep(5000);
		Select GroupType = new Select(driver.findElement(By.xpath("//select[@id='GroupTypeID']")));
		GroupType.selectByVisibleText("Public");
		WebElement SaveBtnVeiw =  SaveBtn;
		js.executeScript("arguments[0].scrollIntoView(true);",SaveBtnVeiw);
		logger.log(LogStatus.INFO,"After entering the Group Details");
		String screenShotPath2 = GetScreenShot.capture(driver, "ScreenShotName");
		logger.log(LogStatus.PASS, logger.addScreenCapture(screenShotPath2));
		SaveBtn.click();
		Thread.sleep(3000);
		logger.log(LogStatus.INFO,"Group Created with successfully with Success message");
		String screenShotPath3 = GetScreenShot.capture(driver, "ScreenShotName");
		logger.log(LogStatus.PASS, logger.addScreenCapture(screenShotPath3));
		
	}
	public void SearchGroup ()
	{
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type='search']")));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement SearchFieldView =     driver.findElement(By.xpath("//input[@type='search']"));
		js.executeScript("arguments[0].scrollIntoView(true);",SearchFieldView);
		SearchField.sendKeys("GroupName");
	}
	public void GoToMygroups () throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(.,'Create Group')]")));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(.,'My Groups')]")));
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement MyGrpsBtnView =  MyGrpsBtn;
		js.executeScript("arguments[0].scrollIntoView(true);",MyGrpsBtnView);
		MyGrpsBtn.click();
	}
}