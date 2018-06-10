package com.connectpronetqa;

import java.util.ArrayList;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;




public class MyGroupsPage {
	
	
	String UploadPDFPath = "C:\\Users\\sasi\\Desktop\\AutoIt\\PDFFile.exe";
	String UploadImagePath = "C:\\Users\\sasi\\Desktop\\AutoIt\\GroupShareImage.exe";
	
	@FindBy(xpath = "//*[@id='UserGroupsTable_filter']/label/input")
	WebElement JoinedGrpSearchField;
	@FindBy(css = "body")
	WebElement body;
	@FindBy(xpath = "//a[@ng-click='DescriptionDiv=true;FileUploadDiv=false;ImageUploadDiv=false;HyerlinkDiv=true;']")
	WebElement HyerlinkTab;
	@FindBy(xpath = "//a[@ng-click='DescriptionDiv=true;FileUploadDiv=true;ImageUploadDiv=false;HyerlinkDiv=false;']")
	WebElement FileUploadTab;
	@FindBy(xpath = "//a[@ng-click='DescriptionDiv=true;FileUploadDiv=false;ImageUploadDiv=true;HyerlinkDiv=false;']")
	WebElement ImageUploadTab;
	@FindBy(xpath = "//input[@id='HyperlinkURL']")
	WebElement HyperlinkURL;
	@FindBy(xpath = "//input[@id='HyperlinkName']")
	WebElement HyperlinkName;
	@FindBy(xpath = "//button[contains(.,'OK')]")
	WebElement OKBtn;
	@FindBy(xpath = "//*[@id='FileUploadLabel']")
	WebElement FileUploadBtn;
	@FindBy(xpath = "//button[contains(.,'Share')]")
	WebElement ShareBtn;
	@FindBy(xpath = "//*[@id='ImageUploadLabel']")
	WebElement ImageUploadBtn;
	@FindBy(xpath = "//button[@ng-click='data.memberViewAllFunction()']")
	WebElement MemberViewAllBtn;
	@FindBy(xpath = "//button[contains(.,' Invite Members')]")
	WebElement InviteMembersBtn;
	@FindBy(xpath = "//input[@type='search']")
	WebElement InviteMembersearch;
	@FindBy(xpath = "//button[@id='btnJoin']")
	WebElement Joinbtn;
	@FindBy(xpath = "//button[contains(.,' Yes,Proceed')]")
	WebElement YesProceedBtn;
	@FindBy(xpath = "//*[@id='DISCUSSION']/div/div[1]/div[6]/form/div/div[1]/div[3]/div/div[1]/span/span")
	WebElement Like;
	@FindBy(xpath = "//*[@id='DISCUSSION']/div/div[1]/div[6]/form/div/div[1]/div[4]/div[1]/div[2]/div")
	WebElement Comment;
	@FindBy(xpath = "//*[@id='DISCUSSION']/div/div[1]/div[6]/form/div/div[1]/div[4]/div[1]/div[3]/i")
	WebElement EnterBtn;
	@FindBy(xpath="html/body/div[4]/div/div/div[1]/button")
	WebElement Close;
	WebDriver driver;
	public MyGroupsPage (WebDriver Ldriver)
	{
		this.driver=Ldriver;
	}
	public void NavigateToGroup(String GroupName, ExtentTest logger) throws Exception
	{
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[contains(@src,'logo.png')]")));
        String screenShotPath = GetScreenShot.capture(driver, "ScreenShotName");
		logger.log(LogStatus.PASS, logger.addScreenCapture(screenShotPath),"Before Search for the Group name");
		JoinedGrpSearchField.sendKeys(GroupName);
		Thread.sleep(2000);
        String screenShotPath1 = GetScreenShot.capture(driver, "ScreenShotName");
		logger.log(LogStatus.PASS, logger.addScreenCapture(screenShotPath1),"After Search for the Group name");
		Actions myAction = new Actions(driver);
	    //driver.findElement(By.xpath("//a[contains(.,'["+GroupName+"]')]")).click();
		myAction.contextClick(driver.findElement(By.xpath("//a[contains(.,'"+(GroupName)+"')]"))).build().perform();
	    //myAction.contextClick(driver.findElement(By.xpath("//*[@id='UserGroupsTable']/tbody/tr["+ rows1.size()+"]/td[3]/a"))).build().perform();
	    myAction.sendKeys(Keys.ARROW_DOWN).build().perform();
	    myAction.sendKeys(Keys.ENTER).build().perform();
	    Thread.sleep(5000);
	    //driver.findElement(By.cssSelector("body")).
	    body.sendKeys(Keys.CONTROL +"2");
	    ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
	    driver.switchTo().window(tabs.get(0));
	    Thread.sleep(4000);
        String screenShotPath2 = GetScreenShot.capture(driver, "ScreenShotName");
		logger.log(LogStatus.PASS, logger.addScreenCapture(screenShotPath2),"After Opening Group");
	}
	
	
	public void ShareLink(String Title,String LinkUrl, ExtentTest logger) throws Exception
	{
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[contains(@src,'logo.png')]")));
		//driver.findElement(By.xpath("//*[@id='GroupInfoApplication']/section/div/div/div[1]/div[7]/div/div/div/div/div/div/ul/li[1]/a")).click();
	    //Actions action = new Actions(driver);
        //action.moveToElement(driver.findElement(By.xpath("//strong[contains(.,'Discussion')]"))).doubleClick().build().perform();
        JavascriptExecutor js = (JavascriptExecutor) driver; 
        js.executeScript("window.scrollBy(0,500)");
        HyerlinkTab.click();
        Thread.sleep(2000);
        String screenShotPath = GetScreenShot.capture(driver, "ScreenShotName");
		logger.log(LogStatus.PASS, logger.addScreenCapture(screenShotPath),"Before Entering the Shared Link");
        HyperlinkURL.sendKeys(LinkUrl);
        HyperlinkName.sendKeys(Title);
        String screenShotPath1 = GetScreenShot.capture(driver, "ScreenShotName");
		logger.log(LogStatus.PASS, logger.addScreenCapture(screenShotPath1),"After Entering the Shared Link");
        Thread.sleep(1000);
        WebElement OkBtnView = driver.findElement(By.xpath("//button[contains(.,'OK')]"));
        js.executeScript("arguments[0].scrollIntoView(true);",OkBtnView);
        OKBtn.click();
        Thread.sleep(1000);
        String screenShotPath2 = GetScreenShot.capture(driver, "ScreenShotName");
		logger.log(LogStatus.PASS, logger.addScreenCapture(screenShotPath2),"After Sharing Link");
		
	}
	
	
	
	public void ShareFile (ExtentTest logger) throws Exception
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
        FileUploadTab.click();
        Thread.sleep(1000);
        String screenShotPath3 = GetScreenShot.capture(driver, "ScreenShotName");
		logger.log(LogStatus.PASS, logger.addScreenCapture(screenShotPath3),"Before Uploading the PDF FIle");
        FileUploadBtn.click();
        Thread.sleep(2000);
        String screenShotPath4 = GetScreenShot.capture(driver, "ScreenShotName");
		logger.log(LogStatus.PASS, logger.addScreenCapture(screenShotPath4),"After clicking Upload button");
        Runtime.getRuntime().exec(UploadPDFPath);
        Thread.sleep(5000);
        String screenShotPath5 = GetScreenShot.capture(driver, "ScreenShotName");
		logger.log(LogStatus.PASS, logger.addScreenCapture(screenShotPath5),"After Uploading the PDF FIle");
        //js.executeScript("window.scrollBy(0,500)");
        WebElement ShareBtnView = driver.findElement(By.xpath("//button[contains(.,'Share')]"));
        Thread.sleep(2000);
        js.executeScript("arguments[0].scrollIntoView(true);",ShareBtnView);
        ShareBtn.click();
        Thread.sleep(10000);
        String screenShotPath6 = GetScreenShot.capture(driver, "ScreenShotName");
		logger.log(LogStatus.PASS, logger.addScreenCapture(screenShotPath6),"Afte sharing the PDF FIle");
    }
	
	public void ShareImage(ExtentTest logger) throws Exception
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		Thread.sleep(2000);
        ImageUploadTab.click();
        String screenShotPath10 = GetScreenShot.capture(driver, "ScreenShotName");
		logger.log(LogStatus.PASS, logger.addScreenCapture(screenShotPath10),"Before uploading the Image");
        Thread.sleep(1000);
        ImageUploadBtn.click();
        String screenShotPath11 = GetScreenShot.capture(driver, "ScreenShotName");
		logger.log(LogStatus.PASS, logger.addScreenCapture(screenShotPath11),"After clicking on Upload Image button");
        Thread.sleep(2000);
        Runtime.getRuntime().exec(UploadImagePath);
        Thread.sleep(3000);
        String screenShotPath12 = GetScreenShot.capture(driver, "ScreenShotName");
		logger.log(LogStatus.PASS, logger.addScreenCapture(screenShotPath12),"After Uploading Image button");
		WebElement ShareBtnView = driver.findElement(By.xpath("//button[contains(.,'Share')]"));
		js.executeScript("arguments[0].scrollIntoView(true);",ShareBtnView);
        ShareBtn.click();
        Thread.sleep(2000);
        String screenShotPath13 = GetScreenShot.capture(driver, "ScreenShotName");
		logger.log(LogStatus.PASS, logger.addScreenCapture(screenShotPath13),"After Sharing Image");
	}
	public void InviteMember (String inviteMemberEMail, ExtentTest logger) throws Exception 
	{
		
		/*JoinedGrpSearchField.sendKeys("Automation");
		Actions myAction = new Actions(driver);
		//driver.findElement(By.xpath("//a[contains(.,'["+GroupName+"]')]")).click();
	    myAction.contextClick(driver.findElement(By.xpath("//a[contains(.,'Automation')]"))).build().perform();
        //myAction.contextClick(driver.findElement(By.xpath("//*[@id='UserGroupsTable']/tbody/tr["+ rows1.size()+"]/td[3]/a"))).build().perform();
        myAction.sendKeys(Keys.ARROW_DOWN).build().perform();
        myAction.sendKeys(Keys.ENTER).build().perform();
        Thread.sleep(5000);
        body.sendKeys(Keys.CONTROL +"2");
        ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
        driver.switchTo().window(tabs.get(0));
        Thread.sleep(3000);*/
        WebElement ViewAllMemberView = MemberViewAllBtn;
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);",ViewAllMemberView);
        MemberViewAllBtn.click();
        String screenShotPath = GetScreenShot.capture(driver, "ScreenShotName");
		logger.log(LogStatus.PASS, logger.addScreenCapture(screenShotPath),"Before clicking on Invite button");
        InviteMembersBtn.click();
        String screenShotPath1 = GetScreenShot.capture(driver, "ScreenShotName");
		logger.log(LogStatus.PASS, logger.addScreenCapture(screenShotPath1),"After clicking on Invite button");
        InviteMembersearch.sendKeys(inviteMemberEMail);
        String screenShotPath2 = GetScreenShot.capture(driver, "ScreenShotName");
		logger.log(LogStatus.PASS, logger.addScreenCapture(screenShotPath2),"After search for the member Email");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@tabindex='0']")).sendKeys(Keys.ENTER);
        String screenShotPath3 = GetScreenShot.capture(driver, "ScreenShotName");
		logger.log(LogStatus.PASS, logger.addScreenCapture(screenShotPath3),"After Selecting the member");
        driver.findElement(By.xpath("//button[@class='btn btn-primary pull-right']")).click();
        Thread.sleep(4000);
        String screenShotPath4 = GetScreenShot.capture(driver, "ScreenShotName");
		logger.log(LogStatus.PASS, logger.addScreenCapture(screenShotPath4),"After Inviting the Member");
		Thread.sleep(4000);
        driver.findElement(By.xpath("//*[@id='wrapper']/header/div/div[1]/div/div[2]/div/div/a[1]")).click();
        driver.findElement(By.xpath("//a[contains(.,'  Logout')]")).click();
        }
	public void JoinGroup(ExtentTest logger) throws Exception 
	{
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[contains(@src,'logo.png')]")));
		Thread.sleep(2000);
        String screenShotPath = GetScreenShot.capture(driver, "ScreenShotName");
		logger.log(LogStatus.PASS, logger.addScreenCapture(screenShotPath),"Before Joining the group");
        Joinbtn.click();
        Thread.sleep(2000);
        String screenShotPath1 = GetScreenShot.capture(driver, "ScreenShotName");
		logger.log(LogStatus.PASS, logger.addScreenCapture(screenShotPath1),"After clicking on Join button");
        YesProceedBtn.click();
        Thread.sleep(4000);
        String screenShotPath2 = GetScreenShot.capture(driver, "ScreenShotName");
		logger.log(LogStatus.PASS, logger.addScreenCapture(screenShotPath2),"After clicking on Yes,Proceed button");
		//Actions action = new Actions(driver);
		//action.moveToElement(OKBtn).build().perform();
		//action.sendKeys(Keys.ENTER).build().perform();
		Close.click();
        Thread.sleep(2000);
        String screenShotPath3 = GetScreenShot.capture(driver, "ScreenShotName");
		logger.log(LogStatus.PASS, logger.addScreenCapture(screenShotPath3),"After Joining the Group");
		Thread.sleep(2000);
	}
	public void LikePost(ExtentTest logger) throws Exception 

	{
        WebElement Like = driver.findElement(By.xpath("//*[@id='DISCUSSION']/div/div[1]/div[6]/form/div/div[1]/div[3]/div/div[1]/span/span"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);",Like);
        String screenShotPath = GetScreenShot.capture(driver, "ScreenShotName");
		logger.log(LogStatus.PASS, logger.addScreenCapture(screenShotPath),"Before liking to the post");
        Like.click();
        Thread.sleep(2000);
        String screenShotPath1 = GetScreenShot.capture(driver, "ScreenShotName");
		logger.log(LogStatus.PASS, logger.addScreenCapture(screenShotPath1),"After liking to the post");
		Thread.sleep(1000);
	}
	public void CommentPost (String TextComment,ExtentTest logger) throws Exception 
	{
		
        WebElement Comment = driver.findElement(By.xpath("//*[@id='DISCUSSION']/div/div[1]/div[6]/form/div/div[1]/div[4]/div[1]/div[2]/div"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);",Comment);
        Comment.click();
        String screenShotPath = GetScreenShot.capture(driver, "ScreenShotName");
		logger.log(LogStatus.PASS, logger.addScreenCapture(screenShotPath),"Before entering the comment");
        Thread.sleep(2000);
        //"PamTen Inc offers creative IT Professional Services, IT Staffing....etc"
        Comment.sendKeys(TextComment);
        Thread.sleep(2000);
        String screenShotPath1 = GetScreenShot.capture(driver, "ScreenShotName");
		logger.log(LogStatus.PASS, logger.addScreenCapture(screenShotPath1),"After entering the comment");
        WebElement Etr =     driver.findElement(By.xpath("//*[@id='DISCUSSION']/div/div[1]/div[6]/form/div/div[1]/div[4]/div[1]/div[3]/i"));
        js.executeScript("arguments[0].scrollIntoView(true);",Etr);
        EnterBtn.click();
        Thread.sleep(2000);
        String screenShotPath2 = GetScreenShot.capture(driver, "ScreenShotName");
		logger.log(LogStatus.PASS, logger.addScreenCapture(screenShotPath2),"After Commenting to the post");
		Thread.sleep(1000);
	}
	
	}
