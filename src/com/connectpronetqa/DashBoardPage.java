package com.connectpronetqa;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class DashBoardPage {
	
	WebDriver driver;
	
	
	public DashBoardPage (WebDriver driver)
	{
		this.driver=driver;
	}
	//*************************************Testimonial**********************************
	@FindBy (xpath = "//a[@href='/Member/Testimonials']")
    WebElement TestimonialsLink;
	@FindBy (xpath = "//input[contains(@name,'Title')]")
    WebElement TestimonialTitle;	
	@FindBy (xpath = "//textarea[@id='Details']")
    WebElement TestimonialDetails;	
	@FindBy (xpath = "//button[contains(.,'Submit')]")
	WebElement Submit;	
	@FindBy (xpath = "//button[contains(.,'OK')]")
	WebElement OKBtn;
	@FindBy (xpath="//a[contains(.,'Testimonials')]")
	WebElement TestimonialsMenu;
	//*************************************Endorsements**********************************
	@FindBy (xpath = "//a[contains(.,'Endorsements')]")
    WebElement EndorsementsLink;
	@FindBy (xpath = "//button[contains(.,' Reject')]")
    WebElement Reject;
	@FindBy (xpath = "//button[contains(.,' Approve')]")
    WebElement Approve;
	//*************************************Groups****************************************
	@FindBy (xpath = "//a[contains(.,'Groups')]")
    WebElement GroupsLink;
	//*************************************Connections***********************************
	@FindBy (xpath="//a[contains(.,'Connections')]")
	WebElement ConnectionsLink;
	@FindBy(xpath=".//*[@id='body']/section/div/div[2]/div[2]/div/div/div[2]/div[1]/h1[2]")
	WebElement NewRequests;
	//************************************Messages***************************************
	@FindBy (xpath = "//a[contains(.,'Messages')]")
	WebElement MessagesLink;
	@FindBy (xpath="//button[contains(.,'New Message')]")
	WebElement NewMessage;
	//***********************************LogOut******************************************
	@FindBy(xpath="//a[@class='btn btn-primary btn-sm']")
	WebElement Menu;
	@FindBy(xpath="//a[contains(.,'  Logout')]")
	WebElement Logout;

	public void Testimonial(ExtentTest logger) throws Exception 
    {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[contains(@src,'logo.png')]")));
    	Thread.sleep(3000);
		TestimonialsLink.click();
    	
    }
	public void logout() throws InterruptedException
	{
		Thread.sleep(6000);
		Menu.click();
		Thread.sleep(500);
		Logout.click();
	}
    public void RejectEndorsement(ExtentTest logger) throws Exception
    {
    	WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(.,'Endorsements')]")));
    	Thread.sleep(1000);
    	JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement Endorsements =  EndorsementsLink;
        js.executeScript("arguments[0].scrollIntoView(true);",Endorsements);
        EndorsementsLink.click();
        String screenShotPath = GetScreenShot.capture(driver, "ScreenShotName");
		logger.log(LogStatus.PASS, logger.addScreenCapture(screenShotPath),"Before Rejecting the Endorsement");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(.,' Reject')]")));
    	Thread.sleep(1000);
    	WebElement RejectBtnView =  Reject;
        js.executeScript("arguments[0].scrollIntoView(true);",RejectBtnView);
        Reject.click();
        Thread.sleep(3000);
        String screenShotPath1 = GetScreenShot.capture(driver, "ScreenShotName");
		logger.log(LogStatus.PASS, logger.addScreenCapture(screenShotPath1),"After Rejecting the Endorsement");
        Thread.sleep(3000);
    }
    public void ApproveEndorsement(ExtentTest logger) throws Exception
    {
    	WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(.,'Endorsements')]")));
    	Thread.sleep(1000);
    	JavascriptExecutor js = (JavascriptExecutor) driver;
        	WebElement Endorsements =  EndorsementsLink;
        	js.executeScript("arguments[0].scrollIntoView(true);",Endorsements);
        	EndorsementsLink.click();
        	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(.,' Approve')]")));
        	WebElement ApproveBtnView =  Approve;
            js.executeScript("arguments[0].scrollIntoView(true);",ApproveBtnView);
        	String screenShotPath = GetScreenShot.capture(driver, "ScreenShotName");
    		logger.log(LogStatus.PASS, logger.addScreenCapture(screenShotPath),"Before Approving the Endorsement");
        	Approve.click();
        	Thread.sleep(3000);
        	String screenShotPath1 = GetScreenShot.capture(driver, "ScreenShotName");
    		logger.log(LogStatus.PASS, logger.addScreenCapture(screenShotPath1),"After Approving the Endorsement");
    		Thread.sleep(3000);
        }
    public void Groups(ExtentTest logger) throws InterruptedException
    {
    	JavascriptExecutor js = (JavascriptExecutor) driver;
    	WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(.,'Groups')]")));
		Thread.sleep(2000);
    	WebElement Grp = GroupsLink;
        js.executeScript("arguments[0].scrollIntoView(true);",Grp);
        GroupsLink.click();
    }
    public void AcceptConnectionRequest(ExtentTest logger)
        {
        	ConnectionsLink.click();
        	String TotalRequests = NewRequests.getText();
        	for(int i=0;i<TotalRequests.length();i++)
        	{  		                                                                                                          
        		String MemberName = driver.findElement(By.xpath("//*[@id='body']/section/div/div[2]/div[2]/div/div/div[2]/div[2]/div/div[1]/div["+i+"]/div/div[2]/strong/a")).getText();
        		if(MemberName.equalsIgnoreCase("Sasi Akula"))
        		{
        			driver.findElement(By.xpath("//*[@id='body']/section/div/div[2]/div[2]/div/div/div[2]/div[2]/div/div[1]/div["+i+"]/div/div[4]/button[1]")).click();
        		}
        	}       	
        }
    public void RejectConnectionRequest(ExtentTest logger)
    {
    	ConnectionsLink.click();
    	String TotalRequests = NewRequests.getText();
    	for(int i=0;i<TotalRequests.length();i++)
    	{  		                                                                                                          
    		String MemberName = driver.findElement(By.xpath("//*[@id='body']/section/div/div[2]/div[2]/div/div/div[2]/div[2]/div/div[1]/div["+i+"]/div/div[2]/strong/a")).getText();
    		if(MemberName.equalsIgnoreCase("Sasi Akula"))
    		{
    			driver.findElement(By.xpath("//*[@id='body']/section/div/div[2]/div[2]/div/div/div[2]/div[2]/div/div[1]/div["+i+"]/div/div[4]/button[2]")).click();
    		}
    	}       	
    }
    public void Messages(ExtentTest logger)
    {
    	MessagesLink.click();
    	NewMessage.click();
    	driver.findElement(By.xpath("//span[contains(.,'Sasi Akula')]")).click();
    	
    }
    
    public void TestimonialsPage()
    {
    	TestimonialsMenu.click();
    	
    }
    
    /*public void IsTestimonialDisplayed()
    {
    	for (int j=1; j<= ApprovedCount; j++)
        {
            String Testimonial1 = driver.findElement(By.xpath("//*[@id='removeinnercss']/div/div/div/div/div/div[2]/div["+(j)+"]/div/div[2]/div[1]")).getText();
            
            if(Testimonial1.equals(Testimonial))
            {
            System.out.println("Your Submitted Testimonial is " + " '' " + Testimonial1 + " '' ");
            }
       }
    }*/
    
}