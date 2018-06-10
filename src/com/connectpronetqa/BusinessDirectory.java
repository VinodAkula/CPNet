package com.connectpronetqa;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class BusinessDirectory {
  
	WebDriver driver;
	
	public BusinessDirectory (WebDriver driver)
	{
		this.driver=driver;
	}
	
	
	
	@FindBy(xpath = "//a[contains(.,'Business Directory')]")
	WebElement BusinessDirectory;
	@FindBy(xpath = "//input[@id='membername']")
	WebElement membername;
	@FindBy(xpath = "//input[@id='companyname']")
	WebElement companyname;
	@FindBy(xpath = "//input[@id='memberlocation']")
	WebElement memberlocation;
	@FindBy(xpath = "//input[@placeholder='Select Categories (Limit 5)']")
	WebElement SelectCategories;
	@FindBy(xpath = "//input[@placeholder='Select Groups (Limit  3)']")
	WebElement SelectGroups;
	@FindBy(xpath = "//button[contains(.,' Search')]")
	WebElement Search;
	@FindBy(xpath = "//span[@ng-bind='member.MemberName']")
	WebElement MemberMemberName;
	@FindBy(xpath = "//button[contains(.,' Add Endorsement')]")
	WebElement AddEndrsmntBtn;
	@FindBy(xpath = "//textarea[@placeholder='Enter Content']")
	WebElement EnterContent;	
	@FindBy(xpath = "//button[contains(.,'  Send')]")
	WebElement SendBtn;	
	@FindBy(xpath = "//*[@id='home']/div[1]/div/div[1]/div[3]/div[2]/div/div/div[2]/h5/span")
	WebElement NoEdrsmnts;
	@FindBy(xpath = "//*[@id='home']/div[1]/div/div[1]/div[3]/div[2]/div/div/div[1]/div/div[2]/div[1]")
	WebElement FirstEdrsmnt;
	@FindBy(xpath = "//*[@id='home']/div[1]/div/div[1]/div[3]/div[2]/div/div/div[1]/div[2]/div[2]/div[1]")
	WebElement MorethanOneEdrsmnts;
	@FindBy (xpath= "//button[contains(.,'Send Connection Request')]")
	WebElement SendConnectionRequest;
	@FindBy(xpath="//span[@ng-bind='member.JobTitle']")
	WebElement JobTitle;
	@FindBy(xpath="//span[@ng-bind='member.MemberName']")
	WebElement MemberName;
	@FindBy(xpath="//*[@id='home']/div[1]/div/div[1]/div[3]/div[2]/div/div/div[1]/div[1]/div[2]/div[1]") 
	WebElement ActualEndorsement;

  public void OpenMemberProfile(String MemberName,String WebBrowser, ExtentTest logger) throws Exception
  {
	  Thread.sleep(5000);
	  BusinessDirectory.click();
      Thread.sleep(3000);
      membername.sendKeys(MemberName);
      Thread.sleep(500);
      Search.click();
      Thread.sleep(4000);
      if(WebBrowser.equals("chrome"))
      {
    	  driver.findElement(By.xpath("//span[@ng-bind='member.MemberName']")).click();
    	  String parent =driver.getWindowHandle();
    	  System.out.println("Parent window id is "+parent);
    	  Set<String> allwindows=driver.getWindowHandles();
    	  int count =allwindows.size();
    	  System.out.println("Total windows="+count);
    	  for(String child:allwindows)
    	  {
    		  if(!parent.equalsIgnoreCase(child))
    		  {
    			  driver.switchTo().window(child);
    		  }
    	  }
      }else
      {
      Actions myAction = new Actions(driver); 
      myAction.contextClick(driver.findElement(By.xpath("//span[@ng-bind='member.MemberName']"))).build().perform();
      myAction.sendKeys(Keys.ARROW_DOWN).build().perform();
      myAction.sendKeys(Keys.ENTER).build().perform();
      Thread.sleep(5000);
      driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL +"2");
      ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
      driver.switchTo().window(tabs.get(0));
      }
      Thread.sleep(1000);
      String screenShotPath = GetScreenShot.capture(driver, "ScreenShotName");
      logger.log(LogStatus.PASS, logger.addScreenCapture(screenShotPath),"Member Profile");
  }
  public void AddEndorsements(String Endsmnt,String WebBrowser, ExtentTest logger) throws Exception 
  {
	  WebDriverWait wait = new WebDriverWait(driver, 20);
	  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@ng-bind='profile.MemberInfo.EmailID']")));
	  Thread.sleep(1000);
	  	  JavascriptExecutor js = (JavascriptExecutor) driver;
	  WebElement AddEndrsmntBtnView = AddEndrsmntBtn;
      js.executeScript("arguments[0].scrollIntoView(true);",AddEndrsmntBtnView);
      String screenShotPath = GetScreenShot.capture(driver, "ScreenShotName");
      logger.log(LogStatus.PASS, logger.addScreenCapture(screenShotPath),"Add Endorsement pop up");

      AddEndrsmntBtn.click();
      EnterContent.sendKeys(Endsmnt);
      String screenShotPath1 = GetScreenShot.capture(driver, "ScreenShotName");
      logger.log(LogStatus.PASS, logger.addScreenCapture(screenShotPath1),"After entering the endorsement content");
      SendBtn.click();
      Thread.sleep(3000);
      String screenShotPath2 = GetScreenShot.capture(driver, "ScreenShotName");
      logger.log(LogStatus.PASS, logger.addScreenCapture(screenShotPath2),"After Submitting the endorsement content");
      
      if(WebBrowser.equals("chrome"))
      {
    	  String parent =driver.getWindowHandle();
    	  System.out.println("Parent window id is "+parent);
    	  Set<String> allwindows=driver.getWindowHandles();
    	  int count =allwindows.size();
    	  System.out.println("Total windows="+count);
    	  for(String child:allwindows)
    	  {
    		  if(!parent.equalsIgnoreCase(child))
    		  {
    			  driver.switchTo().window(child);
    			  Thread.sleep(3000);
    			  driver.close();
    		  
    		  }
    		  
    		  
    	  }
    	  driver.switchTo().window(parent);
    	  
      }
  }
  
  public void SendConnection(ExtentTest logger)
  {
	  SendConnectionRequest.click();
  }
  public void SearchMember (String MemberName, ExtentTest logger) throws Exception
  {	  
	  BusinessDirectory.click();
	  Thread.sleep(3000);
	  String screenShotPath = GetScreenShot.capture(driver, "ScreenShotName");
	  logger.log(LogStatus.PASS, logger.addScreenCapture(screenShotPath),"Business Directory Page");
	  membername.sendKeys(MemberName);
      Thread.sleep(500);
      Search.click();
      Thread.sleep(4000);
      String screenShotPath1 = GetScreenShot.capture(driver, "ScreenShotName");
	  logger.log(LogStatus.PASS, logger.addScreenCapture(screenShotPath1),"After Member search");
  } 
  public void Memberupdatedetails(String Mname, String Jtitle, ExtentTest logger) 
  {
	  SoftAssert softAssertion= new SoftAssert();
	  softAssertion.assertEquals(JobTitle.getText(), Jtitle);
	  softAssertion.assertEquals(MemberName.getText(), Mname);
	  softAssertion.assertAll();
	  
  }
  
  
  public void VerifyEndrsmntBeforeApprovalOrReject(String Endoresment, String WebBrowser,ExtentTest logger) throws Exception
  {
	  WebDriverWait wait = new WebDriverWait(driver, 20);
	  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@ng-bind='profile.MemberInfo.EmailID']")));
	  Thread.sleep(1000);
	  WebElement AddEndrsmntBtnView = AddEndrsmntBtn;
	  JavascriptExecutor js = (JavascriptExecutor) driver;
      js.executeScript("arguments[0].scrollIntoView(true);",AddEndrsmntBtnView);
      SoftAssert softAssertion= new SoftAssert();
	  Boolean IsDisplayed = NoEdrsmnts.isDisplayed();
	  softAssertion.assertNotEquals(ActualEndorsement.getText(), Endoresment);
	  System.out.println(ActualEndorsement.getText());
	  softAssertion.assertEquals(IsDisplayed, false);
	  softAssertion.assertAll();
	  String screenShotPath = GetScreenShot.capture(driver, "ScreenShotName");
      logger.log(LogStatus.PASS, logger.addScreenCapture(screenShotPath),"Member Profile before approval or Reject of the Endorsement");
	  
	  if(WebBrowser.equals("chrome"))
      {
    	  String parent =driver.getWindowHandle();
    	  System.out.println("Parent window id is "+parent);
    	  Set<String> allwindows=driver.getWindowHandles();
    	  int count =allwindows.size();
    	  System.out.println("Total windows="+count);
    	  for(String child:allwindows)
    	  {
    		  if(!parent.equalsIgnoreCase(child))
    		  {
    			  driver.switchTo().window(child);
    			  Thread.sleep(3000);
    			  driver.close();
    		  }	  
    	  }
    	  driver.switchTo().window(parent);  
      }
  }
  
  public void VerifyEndrsmntAfterApproval(String Endoresment, String WebBrowser, ExtentTest logger) throws Exception
  {
	  WebDriverWait wait = new WebDriverWait(driver, 20);
	  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@ng-bind='profile.MemberInfo.EmailID']")));
	  Thread.sleep(1000);
	  WebElement AddEndrsmntBtnView = AddEndrsmntBtn;
	  JavascriptExecutor js = (JavascriptExecutor) driver;
      js.executeScript("arguments[0].scrollIntoView(true);",AddEndrsmntBtnView);
      //wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//input[@id='text4']")));
	  SoftAssert softAssertion= new SoftAssert();
	  Boolean IsDisplayed = NoEdrsmnts.isDisplayed();
	  softAssertion.assertEquals(ActualEndorsement.getText(), Endoresment);
	  System.out.println(Endoresment);
	  softAssertion.assertEquals(IsDisplayed, false);
	  softAssertion.assertAll();
	  String screenShotPath = GetScreenShot.capture(driver, "ScreenShotName");
      logger.log(LogStatus.PASS, logger.addScreenCapture(screenShotPath),"Member Profile After approval of the Endorsement");
	  
	  if(WebBrowser.equals("chrome"))
      {
    	  String parent =driver.getWindowHandle();
    	  System.out.println("Parent window id is "+parent);
    	  Set<String> allwindows=driver.getWindowHandles();
    	  int count =allwindows.size();
    	  System.out.println("Total windows="+count);
    	  for(String child:allwindows)
    	  {
    		  if(!parent.equalsIgnoreCase(child))
    		  {
    			  driver.switchTo().window(child);
    			  Thread.sleep(3000);
    			  driver.close();
    		  }	  
    	  }
    	  driver.switchTo().window(parent);  
      }
  }
  
  
}	

	
  
  
