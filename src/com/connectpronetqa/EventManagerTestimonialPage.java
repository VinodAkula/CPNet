package com.connectpronetqa;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;


public class EventManagerTestimonialPage {

	@FindBy (xpath = "//select[@aria-controls='dtTable']")
	WebElement dtTable;
	@FindBy (xpath = "//select[@id='StatusID']")
	WebElement Status;
	@FindBy (xpath = "//input[@id='Notes']")
	WebElement Notes;
	@FindBy (xpath = "//button[@name='btnSave']")
	WebElement SaveBtn;
	@FindBy (xpath="//a[@aria-expanded='false']")
	WebElement Menu;
	@FindBy (xpath = "//a[contains(.,' Log Out')]")
	WebElement LogOut;
	@FindBy (xpath = "//a[contains(.,'Testimonials')]")
	WebElement TestimonialMenu;
	
	WebDriver driver;
	 SoftAssert Assert = new SoftAssert();

	public EventManagerTestimonialPage (WebDriver Ldriver)
	{
		this.driver=Ldriver;
	}
	
	
	public void DisplayAllTestimonials(ExtentTest logger) throws Exception 
	{
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@aria-controls='dtTable']")));		
		
		Thread.sleep(1000);
		String screenShotPath = GetScreenShot.capture(driver, "ScreenShotName");
    	logger.log(LogStatus.PASS, logger.addScreenCapture(screenShotPath),"Testimonial Page");
		dtTable.sendKeys(Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ARROW_DOWN);
		dtTable.sendKeys(Keys.ENTER);
        Thread.sleep(4000);		
	}
	
	public void EditStatus(ExtentTest logger) throws Exception
	{
		List<WebElement> rows =  driver.findElements(By.xpath("//*[@id='dtTable']/tbody/tr"));
        //System.out.println("No. of rows = " + rows.size());
        String screenShotPath1 = GetScreenShot.capture(driver, "ScreenShotName");
    	logger.log(LogStatus.PASS, logger.addScreenCapture(screenShotPath1),"After Selecting Show No. of entries");
        driver.findElement(By.xpath("//a[contains(@onclick,'javascript:fnShowEditForm("+ (rows.size()) +")')]")).click();    
        Thread.sleep(3000);
        String screenShotPath2 = GetScreenShot.capture(driver, "ScreenShotName");
    	logger.log(LogStatus.PASS, logger.addScreenCapture(screenShotPath2),"Before updating the status of the submitted Testimonial");
    	Status.click();
        Thread.sleep(2000);
        String screenShotPath3 = GetScreenShot.capture(driver, "ScreenShotName");
    	logger.log(LogStatus.PASS, logger.addScreenCapture(screenShotPath3),"After After updating on Status");
    }


	public void TestimonialReject(ExtentTest logger) throws Exception
	{
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='Notes']")));		
		Thread.sleep(2000);
		Status.sendKeys(Keys.ARROW_DOWN, Keys.ARROW_DOWN);
    	Status.sendKeys(Keys.ENTER);
        String screenShotPath4 = GetScreenShot.capture(driver, "ScreenShotName");
    	logger.log(LogStatus.PASS, logger.addScreenCapture(screenShotPath4),"After selecting the status");
        //driver.findElement(By.xpath("//button[@type='button']")).click();
    	Thread.sleep(3000);
		Notes.sendKeys("Duplicate Testimonial");
        String screenShotPath6 = GetScreenShot.capture(driver, "ScreenShotName");
    	logger.log(LogStatus.PASS, logger.addScreenCapture(screenShotPath6),"After Entering the Notes");
    	SaveBtn.click();
        Thread.sleep(4000);
        String screenShotPath7 = GetScreenShot.capture(driver, "ScreenShotName");
    	logger.log(LogStatus.PASS, logger.addScreenCapture(screenShotPath7),"After updating the status of the Testimonial as Rejected");
    	Thread.sleep(2000);	
	}
	 {
		// TODO Auto-generated method stub
		
	}
	
	public void TestimonialApprove(ExtentTest logger) throws Exception
	{
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='Notes']")));
		Thread.sleep(2000);
		Status.sendKeys(Keys.ARROW_UP);
        Thread.sleep(1000);
        String screenShotPath = GetScreenShot.capture(driver, "ScreenShotName");
    	logger.log(LogStatus.PASS, logger.addScreenCapture(screenShotPath),"After Selecting the status of the submitted Testimonial as Approved");
        Status.sendKeys(Keys.ENTER);
        Thread.sleep(1000);
        SaveBtn.click();
        Thread.sleep(5000);
        String screenShotPath1 = GetScreenShot.capture(driver, "ScreenShotName");
    	logger.log(LogStatus.PASS, logger.addScreenCapture(screenShotPath1),"After updating the status of the submitted Testimonial as Approved");
    	Thread.sleep(1000);
	}
	
	
	public void RejectedTestmonialNotDisplayed(String ExpectedTestimonial, ExtentTest logger) throws Exception
	{
    int RowCount = 1;
    int ApprovedCount = 0;
    List<WebElement> rows1 = driver.findElements(By.xpath("//*[@id='dtTable']/tbody/tr"));
		for (int k = 0; k < rows1.size(); k++) 
        {
            String Status =  driver.findElement(By.xpath("//*[@id='row_" + (RowCount) + "']/td[6]")).getText();
            if(Status.contains("Approved"))
            {
                ApprovedCount = ApprovedCount+1;
            }
            RowCount = RowCount+1;                
        }
		Thread.sleep(2000);
        Menu.click();
        Thread.sleep(2000);
        LogOut.click();
        Thread.sleep(3000);
        TestimonialMenu.click();
        Thread.sleep(3000);
        String screenShotPath = GetScreenShot.capture(driver, "ScreenShotName");
    	logger.log(LogStatus.PASS, logger.addScreenCapture(screenShotPath),"After rejecting the Testimonial");
        //System.out.println("Before =  " + ApprovedCount);
        ApprovedCount = ApprovedCount+2 ;
        //System.out.println("After =  " + ApprovedCount);
        Thread.sleep(10000);
        for (int j=2; j<= ApprovedCount; j++)
        {
            //String ActualTestimonial = driver.findElement(By.xpath("//*[@id='removeinnercss']/div/div/div/div/div/div[2]/div["+(j)+"]/div/div[2]/div[1]")).getText();
            String ActualTestimonial = driver.findElement(By.xpath("//*/section/div/div/div/div/div["+(j)+"]/blockquote/p[2]")).getText();
            SoftAssert softAssertion= new SoftAssert();
            softAssertion.assertNotEquals(ActualTestimonial, ExpectedTestimonial);
            softAssertion.assertAll();
        }
	}
        
        public void ApprovedTestmonialDisplayed(String ExpectedTestimonial, ExtentTest logger) throws InterruptedException
    	{
        int RowCount = 1;
        int ApprovedCount = 0;
        List<WebElement> rows1 = driver.findElements(By.xpath("//*[@id='dtTable']/tbody/tr"));
    		for (int k = 0; k < rows1.size(); k++) 
            {
                String Status =  driver.findElement(By.xpath("//*[@id='row_" + (RowCount) + "']/td[6]")).getText();
                if(Status.contains("Approved"))
                {
                    ApprovedCount = ApprovedCount+1;
                }
                RowCount = RowCount+1;                
            }
    		
    		Thread.sleep(5000);
            Menu.click();
            Thread.sleep(5000);
            LogOut.click();
            Thread.sleep(5000);
            TestimonialMenu.click();
            //System.out.println("Before =  " + ApprovedCount);
            ApprovedCount = ApprovedCount+2 ;
            //System.out.println("After =  " + ApprovedCount);
            Thread.sleep(10000);
            for (int j=2; j<= ApprovedCount; j++)
            {
               // String ActualTestimonial = driver.findElement(By.xpath("//*[@id='removeinnercss']/div/div/div/div/div/div[2]/div["+(j)+"]/div/div[2]/div[1]")).getText();
            	String ActualTestimonial = driver.findElement(By.xpath("//*/section/div/div/div/div/div["+(j)+"]/blockquote/p[2]")).getText();
            	SoftAssert softAssertion= new SoftAssert();
                softAssertion.assertEquals(ActualTestimonial, ExpectedTestimonial);
                softAssertion.assertAll();
             }
	}


		
}
