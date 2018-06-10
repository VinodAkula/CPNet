
package com.connectpronetqa;

import java.io.File;
import java.nio.file.*;
import java.text.SimpleDateFormat;
import java.util.Date;

//import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import org.apache.commons.io.*;


public class GetScreenShot {
	
	WebDriver driver;
	public GetScreenShot (WebDriver driver)
	{
		this.driver=driver;
	}
 

	public static String capture(WebDriver driver, String screenshotName) throws Exception 
	{
		
		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String fileCopyDestination = System.getProperty("user.dir") + "\\test-output\\" + "\\" + screenshotName + dateName
				+ ".png";
		
		String destination = screenshotName + dateName
				+ ".png";
		File finalDestination = new File(fileCopyDestination);
		FileSystem system = FileSystems.getDefault();
		FileUtils.copyFile(source, finalDestination);
		// Returns the captured file path
		return destination;
	}
	
	}
    
    
    
    
    
    


