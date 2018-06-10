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
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class EventRegistrationPage {
	
	WebDriver driver;
	JavascriptExecutor js = (JavascriptExecutor) driver;
	SoftAssert softAssertion= new SoftAssert();
	public EventRegistrationPage (WebDriver driver)
	{
		this.driver=driver;
	}

	 
	
	@FindBy(xpath = "//button[contains(.,' Resend Confirmation')]")
	WebElement ResendConfirmationBtn;
	@FindBy(xpath = "//button[contains(.,' Register ')]")
	WebElement RegisterBtn;
	@FindBy(xpath = "//span[contains(.,'Events')]")
	WebElement MenuEvents;
	@FindBy(xpath = "//a[contains(.,'Upcoming Events')]")
	WebElement UpcomingEvents;
	@FindBy(xpath = "//*[@id='EventTicketController']/div[1]/div[2]/div[1]/div/table/tbody/tr[1]/td[3]/div/h4/select")
	WebElement Ticket1;
	@FindBy(xpath = "//*[@id='EventTicketController']/div[1]/div[2]/div[1]/div/table/tbody/tr[2]/td[3]/div/h4/select")
	WebElement Ticket2;
	@FindBy(xpath = "//input[@name='EmailID[]']")
	WebElement AttendeeEmailID;
	@FindBy(xpath = "//input[@name='Phone[]']")
	WebElement AttendeePhone;
	@FindBy(xpath = "//button[contains(.,' Next ')]")
	WebElement NextBtn;
	@FindBy(xpath = "//input[@name='PayerEmailID']")
	WebElement PayerEmailID;
	@FindBy(xpath = "//input[@name='PayerPhone']")
	WebElement PayerPhone;
	@FindBy(xpath = "//button[contains(.,'Book Now ')]")
	WebElement BookNowBtn;
	@FindBy(xpath = "//input[@value='1']")
	WebElement PayPalRadioBtn;
	@FindBy(xpath = "//input[@value='2']")
	WebElement AuthorizedRadioBtn;
	@FindBy(xpath = "//*[@id='EventTicketController']/div[2]/div/fieldset[2]/div[4]/form/button")
	WebElement PayPalPaymentBtn;
	@FindBy(xpath = "//button[contains(.,' Pay through Checkout')]")
	WebElement AuthorizedPaythroughCheckoutBtn;
	@FindBy (xpath="//input[@id='eventNameSearch']")
	WebElement EventNameSearch;
	@FindBy (xpath="//strong[@ng-bind='Event.EventName']")
	WebElement Event;
	@FindBy(xpath="//button[contains(.,' Search')]")
	WebElement SearchBtn;
	@FindBy(xpath="//input[@name='login_email']")
	WebElement PayPalEmailID;
	@FindBy(xpath="//input[@name='login_password']")
	WebElement PayPalPWd;
	@FindBy(xpath="//input[@value='Log In']")
	WebElement LoginBtn;
	@FindBy(xpath="//input[@id='continue']")
	WebElement ContinueBtn;
	@FindBy(xpath="//input[@id='confirmationEmail']")
	WebElement Email;
	@FindBy(xpath="//button[contains(.,' Submit')]")
	WebElement SubmitBtn;
	@FindBy(xpath="//div[@class='bootstrap-dialog-title']")
	WebElement Error;
	@FindBy (xpath="//div[@class='bootbox-body']")
	WebElement ConfirmationEmailSuccessfull;
	@FindBy (xpath="//button[contains(.,'OK')]")
	WebElement OKBtn;
	@FindBy(xpath="//label[@for='IHavePromoCode']")
	WebElement IHavePromoCode;
	@FindBy(xpath="//input[@name='DiscountCoupon']")
	WebElement PromoCode;
	@FindBy(xpath="//button[contains(.,'APPLY')]")
	WebElement ApplyBtn;
	@FindBy (xpath="//a[contains(.,'View All')]")
	WebElement ViewAll;
	@FindBy (xpath="//a[contains(.,'Attendees')]")
	WebElement AttendeesMenu;
	@FindBy(xpath="//input[contains(@type,'search')]")
	WebElement AttendeesSearch;
	@FindBy(xpath="//a[contains(.,' Event Details')]")
	WebElement BacktoEventDetailsPage;

	
	
	public void OpenEventDetailspage(String EventName,ExtentTest logger) throws Exception
	{
		Actions action = new Actions(driver);
		WebElement EventsMenu = driver.findElement(By.xpath("//span[contains(.,'Events')]"));
		action.moveToElement(EventsMenu).build().perform();
		String screenShotPath = GetScreenShot.capture(driver, "ScreenShotName");
		logger.log(LogStatus.PASS, logger.addScreenCapture(screenShotPath),"Home page");
		Thread.sleep(100);			
		UpcomingEvents.click();
		WebDriverWait wait = new WebDriverWait(driver, 20);
		Thread.sleep(4000);
		wait.until(ExpectedConditions.elementToBeClickable(SearchBtn));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(.,' Search')]")));		
		EventNameSearch.sendKeys(EventName);
		String screenShotPath1 = GetScreenShot.capture(driver, "ScreenShotName");
		logger.log(LogStatus.PASS, logger.addScreenCapture(screenShotPath1),"To search for the event");
		Thread.sleep(2000);
		SearchBtn.click();		
		Thread.sleep(1000);
		String screenShotPath2 = GetScreenShot.capture(driver, "ScreenShotName");
		logger.log(LogStatus.PASS, logger.addScreenCapture(screenShotPath2),"After Search of the event");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//strong[@ng-bind='Event.EventName']")));
		action.contextClick(driver.findElement(By.xpath("//strong[@ng-bind='Event.EventName']"))).build().perform();
		action.sendKeys(Keys.ARROW_DOWN).build().perform();
		action.sendKeys(Keys.ENTER).build().perform();
	    Thread.sleep(5000);
	}
	public void GoToTab (String TabNo)
	{
		driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL +TabNo);
	    ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
	    driver.switchTo().window(tabs.get(0));
	}
	public void FillRegistrationDetails(String AEmailID,String AFirstName,String ALastName, String CompanyName,String PEmailID, String payerFirstName, ExtentTest logger) throws Exception
	{
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(.,' Register ')]")));
		Thread.sleep(2000);		
		RegisterBtn.click();
		String screenShotPath = GetScreenShot.capture(driver, "ScreenShotName");
		logger.log(LogStatus.PASS, logger.addScreenCapture(screenShotPath),"Event Registration page");
		Select Ticketdropdown = new Select(driver.findElement(By.xpath("//*[@id='EventTicketController']/div[1]/div[2]/div[1]/div/table/tbody/tr[1]/td[3]/div/h4/select")));
		Ticketdropdown.selectByVisibleText("1");
		Thread.sleep(2000);
		String screenShotPath1 = GetScreenShot.capture(driver, "ScreenShotName");
		logger.log(LogStatus.PASS, logger.addScreenCapture(screenShotPath1),"After Selecting the ticket Quantity");
		AttendeeEmailID.sendKeys(AEmailID);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement EmailIDView =     driver.findElement(By.xpath("//input[@name='EmailID[]']"));
		js.executeScript("arguments[0].scrollIntoView(true);",EmailIDView);
		AttendeePhone.click();
		/*Thread.sleep(4000);
				
		AttendeeFirstName.clear();
		AttendeeLastName.clear();
		AttendeeCompanyName.clear();		
		AttendeeFirstName.sendKeys(AFirstName);
		AttendeeLastName.sendKeys(ALastName);
		AttendeeCompanyName.sendKeys(CompanyName);*/
		Thread.sleep(2000);
		String screenShotPath2 = GetScreenShot.capture(driver, "ScreenShotName");
		logger.log(LogStatus.PASS, logger.addScreenCapture(screenShotPath2),"After entering the Attendee details");
		NextBtn.click();
		Thread.sleep(2000);
		String screenShotPath3 = GetScreenShot.capture(driver, "ScreenShotName");
		logger.log(LogStatus.PASS, logger.addScreenCapture(screenShotPath3),"Payer information form");
		PayerEmailID.clear();
		PayerEmailID.sendKeys(PEmailID);
		PayerPhone.click();
		Thread.sleep(3000);
		String screenShotPath4 = GetScreenShot.capture(driver, "ScreenShotName");
		logger.log(LogStatus.PASS, logger.addScreenCapture(screenShotPath4),"After filling the payer information");
			
	}
	public void AuthorizedPayment(ExtentTest logger) throws Exception
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement BookNowBtnView =     driver.findElement(By.xpath("//button[contains(.,'Book Now ')]"));
		js.executeScript("arguments[0].scrollIntoView(true);",BookNowBtnView);
		
		BookNowBtn.click();
		Thread.sleep(3000);
		String screenShotPath = GetScreenShot.capture(driver, "ScreenShotName");
		logger.log(LogStatus.PASS, logger.addScreenCapture(screenShotPath),"Make paymnet page");
		AuthorizedRadioBtn.click();
		Thread.sleep(2000);
		String screenShotPath1 = GetScreenShot.capture(driver, "ScreenShotName");
		logger.log(LogStatus.PASS, logger.addScreenCapture(screenShotPath1),"Make paymnet page");
		AuthorizedPaythroughCheckoutBtn.click();		
	}
	
	public void PaymentSuccess(ExtentTest logger) throws Exception
	{
		
		WebDriverWait wait = new WebDriverWait(driver, 50);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[contains(.,'Your booking processed successfully ')]")));		
		Thread.sleep(4000);
		String screenShotPath = GetScreenShot.capture(driver, "ScreenShotName");
		logger.log(LogStatus.PASS, logger.addScreenCapture(screenShotPath),"PayPal payment gateway Page");
		softAssertion.assertEquals(driver.findElement(By.xpath("//p[contains(.,'Your booking processed successfully ')]")).getText(),"Your booking processed successfully");
		Thread.sleep(4000);
	}
	
	public void ResendRegistrationEmailConfirmation(String EmailID,ExtentTest logger) throws Exception
	{
		String screenShotPath = GetScreenShot.capture(driver, "ScreenShotName");
		logger.log(LogStatus.PASS, logger.addScreenCapture(screenShotPath),"Event Deatils Page");
		ResendConfirmationBtn.click();
		String screenShotPath1 = GetScreenShot.capture(driver, "ScreenShotName");
		logger.log(LogStatus.PASS, logger.addScreenCapture(screenShotPath1),"Re-Send Event Registration Email pop up");
		Email.sendKeys(EmailID);
		String screenShotPath2 = GetScreenShot.capture(driver, "ScreenShotName");
		logger.log(LogStatus.PASS, logger.addScreenCapture(screenShotPath2),"Event Deatils Page");
		SubmitBtn.click();
		Thread.sleep(3000);
		String screenShotPath3 = GetScreenShot.capture(driver, "ScreenShotName");
		logger.log(LogStatus.PASS, logger.addScreenCapture(screenShotPath3),"Event Deatils Page");
		softAssertion.assertEquals(driver.findElement(By.xpath("//div[@class='bootbox-body']")).getText(),"Confirmation Email has been sent successfully");
		OKBtn.click();		
	}
	public void Promocode(String PCode, ExtentTest logger) throws Exception

	{
		String screenShotPath = GetScreenShot.capture(driver, "ScreenShotName");
		logger.log(LogStatus.PASS, logger.addScreenCapture(screenShotPath),"Before selecting the Promocode check box");
		IHavePromoCode.click();
		String screenShotPath1 = GetScreenShot.capture(driver, "ScreenShotName");
		logger.log(LogStatus.PASS, logger.addScreenCapture(screenShotPath1),"After selecting the Promocode check box");
		PromoCode.sendKeys(PCode);
		String screenShotPath2 = GetScreenShot.capture(driver, "ScreenShotName");
		logger.log(LogStatus.PASS, logger.addScreenCapture(screenShotPath2),"After entering the Promocode");
		ApplyBtn.click();
		String screenShotPath3 = GetScreenShot.capture(driver, "ScreenShotName");
		logger.log(LogStatus.PASS, logger.addScreenCapture(screenShotPath3),"After clicking on the Applybutton");
	}
	
	public void EventAttendees(String attendeeFirstName, String attendeelastName, String attendeeCompanyName,
			String webBrowser, ExtentTest logger) throws Exception
	{
		if(webBrowser.equals("chrome"))
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
	    		  }
	    	  }
	      }
		
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(.,'Attendees')]")));
		Thread.sleep(3000);
		AttendeesMenu.click();
		Thread.sleep(1000);
		ViewAll.click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type='search']")));
		String AttendeeName=attendeeFirstName+" "+attendeelastName;
		AttendeesSearch.clear();
		AttendeesSearch.sendKeys(AttendeeName);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement Scrolldown =     driver.findElement(By.xpath("//a[contains(.,'Previous')]"));
		js.executeScript("arguments[0].scrollIntoView(true);",Scrolldown);
		Thread.sleep(2000);
		String screenShotPath = GetScreenShot.capture(driver, "ScreenShotName");
		logger.log(LogStatus.PASS, logger.addScreenCapture(screenShotPath),"Event Attendee");
		
	}
	
	public int TABR() throws InterruptedException
	{
		
		
		List<WebElement> NoOfAttendees =  driver.findElements(By.xpath("//*[@id='AttendeesTable']/tbody/tr"));
		System.out.println("NoOfAttendees"+NoOfAttendees.size());
		Thread.sleep(4000);
		int NoOfAtt= NoOfAttendees.size();
		
		return NoOfAtt;
		
	}

		
		
		
		
		
	
	public void BackToEventDetailsPage() throws InterruptedException
	{
		BacktoEventDetailsPage.click();
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(.,' Register ')]")));
		Thread.sleep(2000);
		
		
	}
	public void RegisteredAttendee(String AFName, String AFname, String ExpectedCompanyName, ExtentTest logger) throws Exception
	{
		String AttendeeName="AFName"+" "+"AFname";
		String NameoftheAttendee =  driver.findElement(By.xpath("//*[@id='AttendeesTable']/tbody/tr[1]/td[2]")).getText();
        softAssertion.assertEquals(NameoftheAttendee, AttendeeName);
        String ActualCompanyName = driver.findElement(By.xpath("//*[@id='AttendeesTable']/tbody/tr[1]/td[3]")).getAttribute("");
        softAssertion.assertEquals(ActualCompanyName, ExpectedCompanyName);
        String screenShotPath = GetScreenShot.capture(driver, "ScreenShotName");
		logger.log(LogStatus.PASS, logger.addScreenCapture(screenShotPath),"After Event Registration");
		BacktoEventDetailsPage.click();
	}
	
	public void PaymentAbortedAttendee(String AFName, String AFname, String ExpectedCompanyName, ExtentTest logger) throws Exception
	{
		String AttendeeName="AFName"+" "+"AFname";
		String NameoftheAttendee =  driver.findElement(By.xpath("//*[@id='AttendeesTable']/tbody/tr[1]/td[2]")).getText();
        softAssertion.assertNotEquals(NameoftheAttendee, AttendeeName);
        String ActualCompanyName = driver.findElement(By.xpath("//*[@id='AttendeesTable']/tbody/tr[1]/td[3]")).getAttribute("");
        softAssertion.assertNotEquals(ActualCompanyName, ExpectedCompanyName);
        String screenShotPath = GetScreenShot.capture(driver, "ScreenShotName");
		logger.log(LogStatus.PASS, logger.addScreenCapture(screenShotPath),"After Event Registration");
		BacktoEventDetailsPage.click();
	}
	
	public void RegisterFreeEvent(ExtentTest logger) throws Exception
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement BookNowBtnView =     driver.findElement(By.xpath("//button[contains(.,'Book Now ')]"));
		js.executeScript("arguments[0].scrollIntoView(true);",BookNowBtnView);
		BookNowBtn.click();
		Thread.sleep(4000);		
		softAssertion.assertEquals(driver.findElement(By.xpath("//p[contains(.,'Your booking processed successfully ')]")).getText(),"Your booking processed successfully");
		String screenShotPath = GetScreenShot.capture(driver, "ScreenShotName");
		logger.log(LogStatus.PASS, logger.addScreenCapture(screenShotPath),"After Booking the Event Ticket");
	}
	
	
	public void GuestUserTickets(ExtentTest logger) throws Exception
	{
		RegisterBtn.click();
		Thread.sleep(3000);
		SoftAssert softAssertion= new SoftAssert();
       	boolean GuestTicket = driver.findElement(By.xpath("//*[@id='EventTicketController']/div[1]/div[2]/div[1]/div/table/tbody/tr[1]/td[3]/div/h4/select")).isDisplayed();
		softAssertion.assertTrue(GuestTicket);
			if(GuestTicket == true)
			{
				logger.log(LogStatus.PASS,"Ticket configured to All is  Available to Guest user");
			}
				
			
			boolean MemberTicket = driver.findElement(By.xpath("//*[@id='EventTicketController']/div[1]/div[2]/div[1]/div/table/tbody/tr[2]/td[3]/div/div/h4/span")).isDisplayed();
			softAssertion.assertTrue(MemberTicket);
			if(MemberTicket == true)
			{
				logger.log(LogStatus.PASS,"Ticket configured to Members not is Available to Guest user to buy ticket");
			}	
			
			
			boolean EMTicket = driver.findElement(By.xpath("//*[@id='EventTicketController']/div[1]/div[2]/div[1]/div/table/tbody/tr[3]/td[3]/div/div/h4/span")).isDisplayed();
			softAssertion.assertTrue(EMTicket);
			if(EMTicket == true)
			{
				logger.log(LogStatus.PASS,"Ticket configured to Event Manger is not Available to Guest user");
			}	
			
			String screenShotPath = GetScreenShot.capture(driver, "ScreenShotName");
			logger.log(LogStatus.INFO, logger.addScreenCapture(screenShotPath),"Event Details Page");
			softAssertion.assertAll();
	}
	
	public void MemberTickets(ExtentTest logger) throws Exception
	{
		RegisterBtn.click();
		Thread.sleep(3000);
		
		if(driver.findElement(By.xpath("//*[@id='EventTicketController']/div[1]/div[2]/div[1]/div/table/tbody/tr[1]/td[3]/div/h4/select")).isDisplayed())
		{
			logger.log(LogStatus.PASS,"Ticket configuerd to All is Available to Member");
		}
		if(driver.findElement(By.xpath("//*[@id='EventTicketController']/div[1]/div[2]/div[1]/div/table/tbody/tr[2]/td[3]/div/h4/select")).isDisplayed())
		{
			logger.log(LogStatus.PASS,"Ticket configuerd to Members is Available to Member");
		}
		if(driver.findElement(By.xpath("//*[@id='EventTicketController']/div[1]/div[2]/div[1]/div/table/tbody/tr[3]/td[3]/div/div/h4/span")).isDisplayed())
		{
			logger.log(LogStatus.PASS,"Ticket configuerd to Event Manger is Not Available to Member");
		}
		
		String screenShotPath = GetScreenShot.capture(driver, "ScreenShotName");
		logger.log(LogStatus.INFO, logger.addScreenCapture(screenShotPath),"Event Details Page");
		softAssertion.assertAll();
	}
	 {
		// TODO Auto-generated method stub
		
	}
	

}




