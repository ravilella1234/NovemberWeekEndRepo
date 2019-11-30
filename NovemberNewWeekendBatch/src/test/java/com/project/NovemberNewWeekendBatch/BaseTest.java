package com.project.NovemberNewWeekendBatch;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;

import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class BaseTest 
{
	public static WebDriver driver;
	public static String projectPath=System.getProperty("user.dir");
	public static Properties p;
	public static Properties or;
	public static FileInputStream fis;
	public static ExtentReports reports = ExtentManager.getInstance();
	public static ExtentTest test;
	public static String screenshotFileName; 
	
	
	static
	{
		Date dt=new Date();
		screenshotFileName=dt.toString().replace(':', '_').replace(' ', '_')+".png";
		
	}
	
	public static void init() throws Exception
	{
			fis=new FileInputStream(projectPath+"//data.properties");
			p=new Properties();
			p.load(fis);
			
			fis=new FileInputStream(projectPath+"//or.properties");
			or=new Properties();
			or.load(fis);
			
			PropertyConfigurator.configure(projectPath+"//log4j.properties");
			
			
	}
	
	public static void launch(String browser)
	{
		if(browser.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\DELL\\Desktop\\Drivers\\chromedriver.exe");
			driver=new ChromeDriver();
		}
		else if(browser.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\DELL\\Desktop\\Drivers\\geckodriver.exe");
			driver=new FirefoxDriver();
		}
		else
		{
			System.out.println("Given browser was not matching...");
		}
	}
	
	public static void navigateUrl(String url)
	{
		//driver.get(p.getProperty(url));
		driver.navigate().to(p.getProperty(url));
		driver.manage().window().maximize();
	}
	
	
	public static void clickElement(String locatorKey) {
		getElement(locatorKey).click();
		//driver.findElement(By.xpath(locatorKey)).click();
	}

	public static WebElement getElement(String locatorKey) 
	{
		WebElement element = null;
		
		if(locatorKey.endsWith("_id")) {
			element=driver.findElement(By.id(or.getProperty(locatorKey)));
		}else if(locatorKey.endsWith("_name")) {
			element=driver.findElement(By.name(or.getProperty(locatorKey)));
		}else if(locatorKey.endsWith("_classname")) {
			element=driver.findElement(By.className(or.getProperty(locatorKey)));
		}else if(locatorKey.endsWith("_xpath")) {
			element=driver.findElement(By.xpath(or.getProperty(locatorKey)));
		}else if(locatorKey.endsWith("_css")) {
			element=driver.findElement(By.cssSelector(or.getProperty(locatorKey)));
		}else if(locatorKey.endsWith("_linktext")) {
			element=driver.findElement(By.linkText(or.getProperty(locatorKey)));
		}else if(locatorKey.endsWith("_partiallinktext")) {
			element=driver.findElement(By.partialLinkText(or.getProperty(locatorKey)));
		}
		return element;
		
	}

	public static void typeValue(String locatorKey, String value) {
		getElement(locatorKey).sendKeys(or.getProperty(value));
		//driver.findElement(By.name(locatorKey)).sendKeys(value);
	}

	public static void selectOption(String locatorKey, String option) {
		getElement(locatorKey).sendKeys(or.getProperty(option));
		//driver.findElement(By.id(locatorKey)).sendKeys(option);
	}
	
	public static boolean verifyElement(String expectedLink) 
	{
		String actualLink = driver.findElement(By.linkText("AmazonBasics")).getText();
		if(actualLink.equals(expectedLink))
			return true;
		else
			return false;
		
	}
	
	
	//*************** Reportings   **************************************
	
	public static void reportSuccess(String passMessage) 
	{
		test.log(LogStatus.PASS, passMessage);
	}

	public static void reportFailure(String failMessage) 
	{
		test.log(LogStatus.FAIL, failMessage);
		takeScreenShot();
	}

	public static void takeScreenShot() 
	{
		Date dt=new Date();
		screenshotFileName = dt.toString().replace(":", "_").replace(" ", "_")+".png";
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try 
		{
			FileHandler.copy(scrFile, new File(projectPath+"//failure//"+screenshotFileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//put screen shot file in extent reports
		test.log(LogStatus.INFO, "Screenshot --> "+ test.addScreenCapture(projectPath+"//failure//"+screenshotFileName));
	}
	
}








