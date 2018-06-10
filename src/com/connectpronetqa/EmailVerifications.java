package com.connectpronetqa;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class EmailVerifications {
	
	String EmailAccount = "";
	String EmailPwd = "";
	String MyMailer = "ConnectPro Global";
	int j = 0;
	@FindBy(xpath = "//input[@type='email']")
	WebElement Email;
	@FindBy(xpath = "//span[contains(.,'Next')]")
	WebElement NextBtn;
	@FindBy(xpath = "//input[@type='password']")
	WebElement password;
	@FindBy(xpath = "//*[@class='zF']")
	WebElement UnreadMail;
	@FindBy(xpath = "//h2[@class='hP']")
	WebElement EmailSubject;
	@FindBy(xpath = "//input[@type='email']")
	WebElement emailfield;
	@FindBy(xpath = "//input[@name='Password']")
	WebElement passwordfield;
	@FindBy(xpath = "//button[contains(.,'Log In')]")
	WebElement LogInBtn;
	@FindBy(xpath = "//input[@id='oldpassword']")
	WebElement oldpassword;
	@FindBy(xpath = "//input[@id='newpassword']")
	WebElement Newpassword;
	@FindBy(xpath = "//input[@id='confirmpassword']")
	WebElement Confirmpassword;
	@FindBy(xpath="//button[contains(.,' Save')]")
	WebElement SaveBtn;
	@FindBy(xpath="//input[@id='VerificationCode']")
	WebElement VerificationCode;
	@FindBy(xpath="//button[contains(.,'Verify')]")
	WebElement VerifyBtn;
	@FindBy(xpath="//button[contains(.,'Ok')]")
	WebElement OkBtn;
	@FindBy(xpath="//div[@class='asf T-I-J3 J-J5-Ji']")
	WebElement RefreshBtn;
	WebDriver driver;
	

	
	public EmailVerifications (WebDriver Ldriver)
	{
		this.driver=Ldriver;
	}
	
	//System.out.println("launching firefox browser for Mail Verifications"); 
    //System.setProperty("webdriver.firefox.marionette", driverPath);
    //driver = new FirefoxDriver();
    //driver.get(GmailUrl);
	
	public void OpenGMailInnewTab()
	{
		driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL +"t");
	    ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
	    driver.switchTo().window(tabs.get(0));
    	driver.get("https://www.google.com/gmail/");
	}
	public void OpenNewTab(String webbrowser,ExtentTest logger) 
	{
		
		
		if(webbrowser.equalsIgnoreCase("chrome"))
		{
			{
				driver.get("https://mail.google.com/mail/u/0/");  
			}
		}else
			if(webbrowser.equalsIgnoreCase("firefox"))
		{
				driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL +"t");
		ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
		driver.switchTo().window(tabs.get(0));
		driver.get("https://mail.google.com/mail/u/0/");
		}
	}
	public void CloseTab() throws InterruptedException
	{
		driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL +"w");
	    Thread.sleep(1000);
		ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
	    driver.switchTo().window(tabs.get(0));
    }
	public void EmailLogin(String email, String Pwd, ExtentTest logger) throws Exception
	{
		WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type='email']")));
        Email.sendKeys(email);        
        NextBtn.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type='password']")));
        password.sendKeys(Pwd);
        String screenShotPath = GetScreenShot.capture(driver, "ScreenShotName");
		logger.log(LogStatus.PASS, logger.addScreenCapture(screenShotPath),"Email login Page");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(.,'Next')]")));
        NextBtn.click();
        Thread.sleep(8000);		 
        
	}
	public void EmailNotification (ExtentTest logger) throws Exception 
	{
		Thread.sleep(2000);
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='asf T-I-J3 J-J5-Ji']")));
		String screenShotPath = GetScreenShot.capture(driver, "ScreenShotName");
		logger.log(LogStatus.PASS, logger.addScreenCapture(screenShotPath),"User logged in to Email account");
		RefreshBtn.click();
        Thread.sleep(4000);
		List<WebElement> unreademeil = driver.findElements(By.xpath("//*[@class='zF']"));
		for(int i=0;i<unreademeil.size();i++){
		
		//while(driver.findElements(By.xpath("//*[@class='zF']")).get(i).getText() != "ConnectPro Global" )
		//{
			//if(driver.findElements(By.xpath("//*[@class='zF']")).get(1).isDisplayed()==true)
	        //{
	        if(driver.findElements(By.xpath("//*[@class='zF']")).get(i).getText().equals("ConnectPro Global"))
	        {
	        	System.out.println("You have got mail form " + MyMailer);
	            driver.findElements(By.xpath("//*[@class='zF']")).get(i).click();
	            String Subject = driver.findElement(By.xpath("//h2[@class='hP']")).getText();
	            System.out.println(" Subject of the Email is: "+ Subject );
	            String screenShotPath2 = GetScreenShot.capture(driver, "ScreenShotName");
	            logger.log(LogStatus.PASS,Subject);
	            logger.log(LogStatus.PASS, logger.addScreenCapture(screenShotPath2),Subject);
	            break;   
	        }else if (j==6)
	        
	        {
	        	SoftAssert softAssertion= new SoftAssert();
	            softAssertion.assertEquals("Email is not Recieved", "Email should be Recieved");
	            softAssertion.assertAll();
	            break;
	        } j++;
	        //}        	
	     //}
		}
    }
	public void EmailNotification1 (ExtentTest logger) throws InterruptedException 
	{
		 WebDriverWait wait = new WebDriverWait(driver, 20);
		 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='asf T-I-J3 J-J5-Ji']")));
		 while(driver.findElements(By.xpath("//*[@class='zF']")).get(2).getText() == "ConnectPro Global")
		 {
			 Thread.sleep(2000);
	         //driver.navigate().refresh();
			 RefreshBtn.click();
	         Thread.sleep(3000);
	         //if(driver.findElements(By.xpath("//*[@class='zF']")).get(1).isDisplayed()==true)
	         //{
	         if(driver.findElements(By.xpath("//*[@class='zF']")).get(1).getText().equals("ConnectPro Global"))
	         {
	        	 System.out.println("You have got mail form " + MyMailer);
	             driver.findElements(By.xpath("//*[@class='zF']")).get(1).click();
	             String Subject = driver.findElement(By.xpath("//h2[@class='hP']")).getText();
	             System.out.println(" Subject of the Email is: "+ Subject );
	             break;
	         }else 
	        	 if (j==5)
	        	 {
	        		 logger.log(LogStatus.FAIL,"Email is not Recieved");
	        		 break;
	             }j++;
	            //}        	
	      }
			 
    }
	public void EmailNotification2 (ExtentTest logger) throws InterruptedException 
	{
		 WebDriverWait wait = new WebDriverWait(driver, 20);
		 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='asf T-I-J3 J-J5-Ji']")));
		 while(driver.findElements(By.xpath("//*[@class='zF']")).get(1).getText() != "no-reply@connectprogloba.")
		 {
			 RefreshBtn.click();
			 Thread.sleep(4000);
	         //if(driver.findElements(By.xpath("//*[@class='zF']")).get(1).isDisplayed()==true)
	         if(driver.findElements(By.xpath("//*[@class='zF']")).get(1).getText().equals("no-reply@connectprogloba."))
	         {
	        	 driver.findElements(By.xpath("//*[@class='zF']")).get(1).click();
	        	 String Subject = driver.findElement(By.xpath("//h2[@class='hP']")).getText();
	             System.out.println(" Subject of the Email is: "+ Subject );
	             //if(Subject.equalsIgnoreCase(anotherString))
	             Actions myAction = new Actions(driver); 
	             myAction.contextClick(driver.findElement(By.xpath("//*/tbody/tr[3]/td/table/tbody/tr/td/div/div/p[4]/a"))).build().perform();
	             myAction.sendKeys(Keys.ARROW_DOWN).build().perform();
	             myAction.sendKeys(Keys.ENTER).build().perform();
	             driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL +"3");
	             ArrayList<String> tabs1 = new ArrayList<String> (driver.getWindowHandles());
	             driver.switchTo().window(tabs1.get(0));
	             break;
	           }else 
	        	   if (j==5)

	   	        {
	   	        	SoftAssert softAssertion= new SoftAssert();
	   	            softAssertion.assertEquals("Email is not Recieved", "Email should be Recieved");
	   	            softAssertion.assertAll();
	   	            break;
	   	        } j++;
	        //}        	
	       }
			 
    	}
	public void CodeVerification (ExtentTest logger) throws InterruptedException 
	   {
		 WebDriverWait wait = new WebDriverWait(driver, 20);
		 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='asf T-I-J3 J-J5-Ji']")));
		 System.out.println(driver.findElements(By.xpath("//*[@class='zF']")).get(1).getText());
		 while(driver.findElements(By.xpath("//*[@class='zF']")).get(1).getText() != "ConnectPro Global")
			 {
			    Thread.sleep(2000);
	            driver.findElement(By.xpath("//div[@class='asf T-I-J3 J-J5-Ji']")).click();
	            Thread.sleep(3000);
	            if(driver.findElements(By.xpath("//*[@class='zF']")).get(1).getText().equals("ConnectPro Global"))
	                {
	                    System.out.println("You have got mail form " + MyMailer);
	                    driver.findElements(By.xpath("//*[@class='zF']")).get(1).click();
	                    String Subject = driver.findElement(By.xpath("//h2[@class='hP']")).getText();
	                    System.out.println(" Subject of the Email is: "+ Subject );
	                    
	                    try
	                    {
	                    	String Code=driver.findElement(By.xpath("//*/tbody/tr[3]/td/table/tbody/tr/td/div/p[3]/strong")).getText();
		                    driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL +"w");
		                    ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
		            		driver.switchTo().window(tabs.get(0));
		                    VerificationCode.sendKeys(Code);
	                    
	                    }
	        			catch(Exception e)
	                    {
	        				System.out.println(" - ");
	                    }
	                    try
	                    {
		                    String Code=driver.findElement(By.xpath("//*/tbody/tr[3]/td/table/tbody/tr/td/div/p/strong")).getText();
		                    driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL +"w");
		                    ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
		            		driver.switchTo().window(tabs.get(0));
		                    VerificationCode.sendKeys(Code);
	                    }
	                    catch(Exception e)
	                    {
	                    	System.out.println(" - ");
	                    } 
	                    
	                    //VerifyBtn.click();
	                    Thread.sleep(2000);
	                    //OkBtn.click();   
	                    //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(.,'Log In')]")));
	                    Thread.sleep(2000);
	                break;
	                }
	            }
		 }
	public void ReActivatedEmailNotofication (String NewPwd, String CNewpwd,ExtentTest logger) throws Exception 
	{
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='asf T-I-J3 J-J5-Ji']")));
		String screenShotPath = GetScreenShot.capture(driver, "ScreenShotName");
		logger.log(LogStatus.PASS, logger.addScreenCapture(screenShotPath),"User logged in to Email account");
		while(driver.findElements(By.xpath("//*[@class='zF']")).get(1).getText() != "ConnectPro Global")
		{
			Thread.sleep(2000);
		    //driver.navigate().refresh();
			RefreshBtn.click();
		    Thread.sleep(3000);
		    //if(driver.findElements(By.xpath("//*[@class='zF']")).get(1).isDisplayed()==true)
		    //{
		    if(driver.findElements(By.xpath("//*[@class='zF']")).get(1).getText().equals("ConnectPro Global"))
		    {
		    	System.out.println("You have got mail form " + MyMailer);
		    	driver.findElements(By.xpath("//*[@class='zF']")).get(1).click();
		        Thread.sleep(2000);
		        String Subject = driver.findElement(By.xpath("//h2[@class='hP']")).getText();
		        System.out.println(" Subject of the Email is: "+ Subject );
		        String screenShotPath2 = GetScreenShot.capture(driver, "ScreenShotName");
		        logger.log(LogStatus.PASS,"Subject of the Recieved Mail is: " +Subject);
		        logger.log(LogStatus.PASS, logger.addScreenCapture(screenShotPath2),Subject);
		        String Email=driver.findElement(By.xpath("//*/tbody/tr[3]/td/table/tbody/tr/td/div/table/tbody/tr[1]/td[2]/span/a")).getText();
		        String password=driver.findElement(By.xpath("//*/tbody/tr[3]/td/table/tbody/tr/td/div/table/tbody/tr[2]/td[2]/span")).getText();
		        driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL +"w");
		        Thread.sleep(1000);
		        ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
		        driver.switchTo().window(tabs.get(0));
		        Thread.sleep(1000);
		        emailfield.sendKeys(Email);
		        passwordfield.sendKeys(password);
		        LogInBtn.click();
		        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='oldpassword']")));
		        Thread.sleep(3000);
		        oldpassword.sendKeys(password);
		        Newpassword.sendKeys(NewPwd);
		        Confirmpassword.sendKeys(CNewpwd);
		        SaveBtn.click();
		        Thread.sleep(4000);
		        passwordfield.sendKeys(NewPwd);
		        break;
		    }else 
		    	if (j==5)
		    	{
		    		logger.log(LogStatus.FAIL,"Email is not Recieved");
		            break;
		    	} j++;
		    //}        	
		}				 
	}
	public void ResetPasswordGmailNotification(ExtentTest logger) throws Exception 
	{
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='asf T-I-J3 J-J5-Ji']")));
		String screenShotPath = GetScreenShot.capture(driver, "ScreenShotName");
		logger.log(LogStatus.PASS, logger.addScreenCapture(screenShotPath),"User logged in to Email account");
		while(driver.findElements(By.xpath("//*[@class='zF']")).get(1).getText() != "no-reply@connectprogloba.")
		{
			
	        //driver.navigate().refresh();
			RefreshBtn.click();
	        Thread.sleep(7000);
	        //if(driver.findElements(By.xpath("//*[@class='zF']")).get(1).isDisplayed()==true)
	        //{
	        if(driver.findElements(By.xpath("//*[@class='zF']")).get(1).getText().equals("no-reply@connectprogloba."))
	        {
	        	driver.findElements(By.xpath("//*[@class='zF']")).get(1).click();
	            String Subject = driver.findElement(By.xpath("//h2[@class='hP']")).getText();
	            System.out.println(" Subject of the Email is: "+ driver.findElement(By.xpath("//h2[@class='hP']")).getText());
	            String screenShotPath2 = GetScreenShot.capture(driver, "ScreenShotName");
	            logger.log(LogStatus.PASS,Subject);
	            logger.log(LogStatus.PASS, logger.addScreenCapture(screenShotPath2),driver.findElement(By.xpath("//h2[@class='hP']")).getText());
	           Thread.sleep(5000);
	            Actions myAction = new Actions(driver); 
	            myAction.contextClick(driver.findElement(By.xpath("//*/tbody/tr[3]/td/table/tbody/tr/td/div/div/p[4]/a"))).build().perform();
	            myAction.sendKeys(Keys.ARROW_DOWN).build().perform();
	            myAction.sendKeys(Keys.ENTER).build().perform();
	            Thread.sleep(5000);
	            driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL +"2");
	            ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
	            driver.switchTo().window(tabs.get(0));
	            
	            break;
	        }else 
	        	if (j==9)
	        	{
	        		SoftAssert softAssertion= new SoftAssert();
	                softAssertion.assertEquals("Email is not Recieved", "Email should be Recieved");
	                softAssertion.assertAll();
	                break;	
	        	}j++;
	            //}        	
		}
	}
	public void ResetPasswordwithInvalidLink(ExtentTest logger) throws Exception 
	{
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='asf T-I-J3 J-J5-Ji']")));
		String screenShotPath = GetScreenShot.capture(driver, "ScreenShotName");
		logger.log(LogStatus.PASS, logger.addScreenCapture(screenShotPath),"User logged in to Email account");
		while(driver.findElements(By.xpath("//*[@class='yP']")).get(1).getText() != "no-reply@connectprogloba.")
		{
			
	        //driver.navigate().refresh();
			RefreshBtn.click();
	        Thread.sleep(7000);
	        //if(driver.findElements(By.xpath("//*[@class='zF']")).get(1).isDisplayed()==true)
	        //{
	        if(driver.findElements(By.xpath("//*[@class='yP']")).get(1).getText().equals("no-reply@connectprogloba."))
	        {
	        	driver.findElements(By.xpath("//*[@class='yP']")).get(1).click();
	            String Subject = driver.findElement(By.xpath("//h2[@class='hP']")).getText();
	            System.out.println(" Subject of the Email is: "+ driver.findElement(By.xpath("//h2[@class='hP']")).getText());
	            String screenShotPath2 = GetScreenShot.capture(driver, "ScreenShotName");
	            logger.log(LogStatus.PASS,Subject);
	            logger.log(LogStatus.PASS, logger.addScreenCapture(screenShotPath2),driver.findElement(By.xpath("//h2[@class='hP']")).getText());
	           Thread.sleep(5000);
	            Actions myAction = new Actions(driver); 
	            myAction.contextClick(driver.findElement(By.xpath("//*/tbody/tr[3]/td/table/tbody/tr/td/div/div/p[4]/a"))).build().perform();
	            myAction.sendKeys(Keys.ARROW_DOWN).build().perform();
	            myAction.sendKeys(Keys.ENTER).build().perform();
	            Thread.sleep(5000);
	            driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL +"2");
	            ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
	            driver.switchTo().window(tabs.get(0));
	            
	            break;
	        }
		}
	}
	public void ChangePasswordNotification(ExtentTest logger) throws Exception 
	{
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='asf T-I-J3 J-J5-Ji']")));
		String screenShotPath = GetScreenShot.capture(driver, "ScreenShotName");
		logger.log(LogStatus.PASS, logger.addScreenCapture(screenShotPath),"User logged in to Email account");
		while(driver.findElements(By.xpath("//*[@class='zF']")).get(1).getText() != "no-reply@connectprogloba.")
		{			
	        //driver.navigate().refresh();
			RefreshBtn.click();
	        Thread.sleep(7000);
	        //if(driver.findElements(By.xpath("//*[@class='zF']")).get(1).isDisplayed()==true)
	        //{
	        if(driver.findElements(By.xpath("//*[@class='zF']")).get(1).getText().equals("no-reply@connectprogloba."))
	        {
	        	driver.findElements(By.xpath("//*[@class='zF']")).get(1).click();
	            String Subject = driver.findElement(By.xpath("//h2[@class='hP']")).getText();
	            System.out.println(" Subject of the Email is: "+ driver.findElement(By.xpath("//h2[@class='hP']")).getText());
	            String screenShotPath2 = GetScreenShot.capture(driver, "ScreenShotName");
	            logger.log(LogStatus.PASS,Subject);
	            logger.log(LogStatus.PASS, logger.addScreenCapture(screenShotPath2),driver.findElement(By.xpath("//h2[@class='hP']")).getText());
	           Thread.sleep(5000);
	           break;
	        }else 
	        	if (j==9)
	        	{
	        		SoftAssert softAssertion= new SoftAssert();
	                softAssertion.assertEquals("Email is not Recieved", "Email should be Recieved");
	                softAssertion.assertAll();
	                break;	
	        	}j++;
	            //}        	
		}
	}
	public void EmailNotification3(ExtentTest logger) throws InterruptedException 
	{
		 WebDriverWait wait = new WebDriverWait(driver, 20);
		 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='asf T-I-J3 J-J5-Ji']")));
		 while(driver.findElements(By.xpath("//*[@class='zF']")).get(1).getText() != "no-reply@connectprogloba.")
		 {
			 RefreshBtn.click();
			 Thread.sleep(4000);
	         //if(driver.findElements(By.xpath("//*[@class='zF']")).get(1).isDisplayed()==true)
	         if(driver.findElements(By.xpath("//*[@class='zF']")).get(1).getText().equals("no-reply@connectprogloba."))
	         {
	        	 driver.findElements(By.xpath("//*[@class='zF']")).get(1).click();
	        	 Thread.sleep(1000);
	        	 String Subject = driver.findElement(By.xpath("//h2[@class='hP']")).getText();
	             System.out.println(" Subject of the Email is: "+ Subject );
	             //if(Subject.equalsIgnoreCase(anotherString))
	             break;
	           }else 
	        	   if (j==5)

	   	        {
	   	        	SoftAssert softAssertion= new SoftAssert();
	   	            softAssertion.assertEquals("Email is not Recieved", "Email should be Recieved");
	   	            softAssertion.assertAll();
	   	            break;
	   	        } j++;
	        //}        	
	       }
			 
    	}
	
	
	
}









//if(driver.findElements(By.xpath("//*[@class='zF']")).get(1).isDisplayed()==true)
//{
//}