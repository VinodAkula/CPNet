package com.connectpronetqa;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class AuthroizedPayment {
	
	//Paymentgateways

	WebDriver driver;
	JavascriptExecutor js = (JavascriptExecutor) driver;
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
	@FindBy (xpath="input[@id='billingAddressID']")
	WebElement BillingAddress;
	@FindBy (xpath="//input[@id='cityID']")
	WebElement City;
	@FindBy (xpath="//input[@id='stateID']")
	WebElement State;
	@FindBy (xpath="//input[@id='phonenumberID']")
	WebElement PhoneNumber;
	@FindBy (xpath="//input[@id='email']")
	WebElement email;
	@FindBy (xpath="//button[@id='payBtn']")
	WebElement PayBtn;

	
	public AuthroizedPayment (WebDriver driver)
	{
		this.driver=driver;
	}

	
	public void AuthroizedGateway(String emailID, String card, String date, String cardCVV, String fName, String lName,
			String zip, String address, String cityName, String phNo, ExtentTest logger) throws Exception
	{
		Thread.sleep(10000);
		driver.switchTo().frame("load_payment");
		String screenShotPath = GetScreenShot.capture(driver, "ScreenShotName");
		logger.log(LogStatus.PASS, logger.addScreenCapture(screenShotPath),"Make paymnet page");
		
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
	    WebElement PayBtnBtnView = PayBtn;
	    js.executeScript("arguments[0].scrollIntoView(true);",PayBtnBtnView);
	    PayBtn.click();
	    Thread.sleep(10000);
	    driver.switchTo().defaultContent();
		
	}


	
}
