package com.connectpronetqa;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class PaymentGatewayPage {
	
	//Paymentgateways

	WebDriver driver;
	public PaymentGatewayPage (WebDriver driver)
	{
		this.driver=driver;
	}

	
	@FindBy (xpath="//input[@id='cardNum']")
	WebElement cardNum;
	@FindBy (xpath="//input[@id='expiryDate']")
	WebElement ExpiryDate;
	@FindBy (xpath="//input[@id='cvv']")
	WebElement CVV;
	@FindBy (xpath="//input[@id='firstNameID']")
	WebElement FirstName;
	@FindBy (xpath="//input[@id='lastNameID']")
	WebElement LastName;
	@FindBy (xpath="//input[@id='zipID']")
	WebElement ZipCode;
	@FindBy (xpath="//*[@id='billingAddressID']")
	WebElement BillingAddress;
	@FindBy (xpath="//*[@id='cityID']")
	WebElement City;
	@FindBy (xpath="//input[@id='stateID']")
	WebElement State;
	@FindBy (xpath="//input[@id='phonenumberID']")
	WebElement PhoneNumber;
	@FindBy (xpath="//*[@id='email']")
	WebElement email;
	@FindBy (xpath="//*[@id='payBtn']")
	WebElement PayBtn;
	@FindBy (xpath="//*[@id='cancelBtn']")
	WebElement CancelBtn;
	
	@FindBy(xpath = "//button[contains(.,'Book Now ')]")
	WebElement BookNowBtn;
	@FindBy(xpath = "//*[@id='EventTicketController']/div[2]/div/fieldset[2]/div[4]/form/button")
	WebElement PayPalPaymentBtn;
	@FindBy(xpath="//input[@name='login_email']")
	WebElement PayPalEmailID;
	@FindBy(xpath="//input[@name='login_password']")
	WebElement PayPalPWd;
	@FindBy(xpath="//input[@value='Log In']")
	WebElement LoginBtn;
	@FindBy(xpath="//input[@id='continue']")
	WebElement ContinueBtn;
	@FindBy(xpath = "//input[@value='1']")
	WebElement PayPalRadioBtn;
	@FindBy(xpath = "//input[@value='2']")
	WebElement AuthorizedRadioBtn;
	@FindBy(xpath="//input[@id='privateDeviceCheckbox']")
	WebElement CheckBox;
	

	public void PayPalpayment(String PEmail, String PPwd,ExtentTest logger) throws Exception
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement BookNowBtnView =     driver.findElement(By.xpath("//button[contains(.,'Book Now ')]"));
		js.executeScript("arguments[0].scrollIntoView(true);",BookNowBtnView);
		BookNowBtn.click();
		Thread.sleep(3000);
		String screenShotPath = GetScreenShot.capture(driver, "ScreenShotName");
		logger.log(LogStatus.PASS, logger.addScreenCapture(screenShotPath),"Make Payment page");
		PayPalRadioBtn.click();
		String screenShotPath1 = GetScreenShot.capture(driver, "ScreenShotName");
		logger.log(LogStatus.PASS, logger.addScreenCapture(screenShotPath1),"After Selecting PayPal Payment Gateway");
		PayPalPaymentBtn.click();
		Thread.sleep(10000);
		WebDriverWait wait = new WebDriverWait(driver, 20);
		  try
		  {
			  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='login_email']")));
			  String screenShotPath2 = GetScreenShot.capture(driver, "ScreenShotName");
			  logger.log(LogStatus.PASS, logger.addScreenCapture(screenShotPath2),"PayPal payment gateway Page");
			  PayPalEmailID.sendKeys(PEmail);
			  PayPalPWd.sendKeys(PPwd);
			  LoginBtn.click();		 
			  String screenShotPath3 = GetScreenShot.capture(driver, "ScreenShotName");
			  logger.log(LogStatus.PASS, logger.addScreenCapture(screenShotPath3),"PayPal payment gateway Page");
			  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='continue']")));
			  WebElement ContinueBtnView =     driver.findElement(By.xpath("//input[@id='continue']"));
			  js.executeScript("arguments[0].scrollIntoView(true);",ContinueBtnView);
				ContinueBtn.click();
				Thread.sleep(10000);
		  }
			catch(Exception e)
		  {
			  System.out.println("New Form Displayed Completed");
		  }
		try{
		
		List <WebElement> list = driver.findElements(By.tagName("a"));
		 //System.out.println("Number of links: "+list.size());
		 
		 for(int i = 0; i < list.size(); i++)
		 {
			// System.out.println(list.get(i).getText());
			 //eligible purchases
			 //Thread.sleep(15000);
			 
		 if(list.get(i).getText().equals("Log In"))
		 {
			 //System.out.println(list.get(i).getText());
			 driver.findElement(By.className("baslLoginButtonContainer")).click();
			 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='login_email']")));
			 PayPalEmailID.sendKeys(PEmail);
			 driver.findElement(By.xpath("//button[@type='submit']")).click();
			 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='btnLogin']")));
			 Thread.sleep(5000);
			 PayPalPWd.sendKeys(PPwd);
			 driver.findElement(By.xpath("//button[@id='btnLogin']")).click();
			 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type='submit']")));
			 Thread.sleep(15000);
			 driver.findElement(By.xpath("//input[@type='submit']")).click();
			 Thread.sleep(5000);
			 break;
		 }
		  else 
			  if(list.get(i).getText().equals("Use phone number instead"))
			  {
				  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='login_email']")));
					 PayPalEmailID.sendKeys(PEmail);
					 driver.findElement(By.xpath("//button[@type='submit']")).click();
					 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='btnLogin']")));
					 Thread.sleep(5000);
					 PayPalPWd.sendKeys(PPwd);
					 driver.findElement(By.xpath("//button[@id='btnLogin']")).click();
					 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type='submit']")));
					 Thread.sleep(20000);
					 driver.findElement(By.xpath("//input[@type='submit']")).click();
					 Thread.sleep(10000);
					 break;	
			  }
		 }}catch(Exception e)
		 {
			 System.out.println("Old Form displayed");
		 }
		
		}
		 
		 
	
	public void AuthroizedGateway(String emailID, String card, String date, String cardCVV, String fName, String lName,
			String zip, String address, String cityName, String phNo, ExtentTest logger) throws Exception
	{
		
		Thread.sleep(5000);
		driver.switchTo().frame("load_payment");
		String screenShotPath = GetScreenShot.capture(driver, "ScreenShotName");
		logger.log(LogStatus.PASS, logger.addScreenCapture(screenShotPath),"Authroized Gateway paymnet Form");
		
		cardNum.sendKeys(card);
		ExpiryDate.sendKeys(date);
		CVV.sendKeys(cardCVV); 
	    FirstName.sendKeys(fName);
	    LastName.sendKeys(lName);
	        
	        //Select Country = new Select(driver.findElement(By.xpath("//button[@type='button']")));
	        //Country.selectByVisibleText("USA");
	    ZipCode.sendKeys(zip);
	    BillingAddress.sendKeys(address);
	    City.sendKeys(cityName);
	    State.sendKeys(String.valueOf(phNo));
	    email.clear();
	    email.sendKeys(emailID);
	    String screenShotPath1 = GetScreenShot.capture(driver, "ScreenShotName");
		logger.log(LogStatus.PASS, logger.addScreenCapture(screenShotPath1),"After Entering the Card and Bill information");
	    JavascriptExecutor js = (JavascriptExecutor) driver;
	    WebElement PayBtnBtnView =     driver.findElement(By.xpath("//*[@id='payBtn']"));
		js.executeScript("arguments[0].scrollIntoView(true);",PayBtnBtnView);
		PayBtn.click();
	    Thread.sleep(10000);
	    driver.switchTo().defaultContent();
		
	}


	public void CancelPayMentByAuthroizedGateway(ExtentTest logger) throws Exception{
		Thread.sleep(5000);
		driver.switchTo().frame("load_payment");
		String screenShotPath = GetScreenShot.capture(driver, "ScreenShotName");
		logger.log(LogStatus.PASS, logger.addScreenCapture(screenShotPath),"Authroized Gateway paymnet Form");
		JavascriptExecutor js = (JavascriptExecutor) driver;
	    WebElement CancelBtnView =  CancelBtn;
		js.executeScript("arguments[0].scrollIntoView(true);",CancelBtnView);
		CancelBtn.click();
		Thread.sleep(8000);
	    driver.switchTo().defaultContent();
	}
	
}
