package com.connectpronetqa;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;


public class MemberTestimonialPage {

	@FindBy (xpath = "//input[@id='Title']")
	WebElement TestimonialTitle;
	@FindBy (xpath = "//textarea[@name='Details']")
	WebElement TestimonialDetails;
	@FindBy (xpath = "//button[contains(.,'Submit')]")
	WebElement SubmitBtn;
	@FindBy (xpath = "//button[contains(.,'OK')]")
	WebElement OKBtn;
	
	WebDriver driver;

	
	public MemberTestimonialPage (WebDriver Ldriver)
	{
		this.driver=Ldriver;
	}
		
	public void AddTestimonial(String Title, String TestimonialMessage, ExtentTest logger) throws Exception 
    {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[contains(@src,'logo.png')]")));
		Thread.sleep(1000);
    	String screenShotPath = GetScreenShot.capture(driver, "ScreenShotName");
    	logger.log(LogStatus.PASS, logger.addScreenCapture(screenShotPath),"Before Entering the Testimonial");
    	TestimonialTitle.sendKeys(Title);
    	TestimonialDetails.sendKeys(TestimonialMessage);
    	String screenShotPath1 = GetScreenShot.capture(driver, "ScreenShotName");
    	logger.log(LogStatus.PASS, logger.addScreenCapture(screenShotPath1),"After Entering the Testimonial");
    	Thread.sleep(1000);
    	SubmitBtn.click();
    	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(.,'OK')]")));
    	String screenShotPath2 = GetScreenShot.capture(driver, "ScreenShotName");
    	logger.log(LogStatus.PASS, logger.addScreenCapture(screenShotPath2),"After click on Submit button");
    	OKBtn.click();
    	String screenShotPath3 = GetScreenShot.capture(driver, "ScreenShotName");
    	logger.log(LogStatus.PASS, logger.addScreenCapture(screenShotPath3),"After click on OK  button");
    	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(.,'OK')]")));
    	Thread.sleep(2000);
    	OKBtn.click();
    	String screenShotPath4 = GetScreenShot.capture(driver, "ScreenShotName");
    	logger.log(LogStatus.PASS, logger.addScreenCapture(screenShotPath4),"After clicking on OK button");
	}
	
	
	public void BeforeApprovingTestimonial( ExtentTest logger) throws Exception 
	{
    	String screenShotPath = GetScreenShot.capture(driver, "ScreenShotName");
    	logger.log(LogStatus.PASS, logger.addScreenCapture(screenShotPath),"Before approving the Testimonial");    	
	}
	public void AfterApprovingTestimonial( ExtentTest logger) throws Exception 
	{
    	String screenShotPath = GetScreenShot.capture(driver, "ScreenShotName");
    	logger.log(LogStatus.PASS, logger.addScreenCapture(screenShotPath),"After approving the Testimonial");
    }
	public void AfterRejectingTestimonial( ExtentTest logger) throws Exception 
	{
    	String screenShotPath = GetScreenShot.capture(driver, "ScreenShotName");
    	logger.log(LogStatus.PASS, logger.addScreenCapture(screenShotPath),"After Rejecting the Testimonial");
    }
	
	public void GetAllElelments(String Title,ExtentTest logger)
	{
		List<WebElement> elements = driver.findElements(By.xpath("//*"));
		System.out.println(Integer.toString(elements.size()));
		for(WebElement el:elements)
		{
			String print = el.getTagName()+": "+el.getText();
			System.out.println(print);
			String TagName=el.getTagName();
			System.out.println(TagName);
			//System.out.println(el.getTagName()+": "+el.getText());
			if(Title.contains(print))
			{
				SoftAssert softAssertion= new SoftAssert();
				softAssertion.assertNotEquals(print, Title);
				
	   	        softAssertion.assertAll();
	   	        
			}
		}
	}

	

	
	
}
