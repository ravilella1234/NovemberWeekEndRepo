package autoit;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;

public class FileUpload {
 
WebDriver driver;	

  @BeforeMethod
  public void beforeMethod() 
  {
	  System.setProperty("webdriver.gecko.driver", "C:\\Users\\DELL\\Desktop\\Drivers\\geckodriver.exe");
	  driver=new FirefoxDriver();
	  driver.manage().window().maximize();
	  driver.get("file:///c:/Users/DELL/Desktop/fileupload.html");
	  driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
	  //driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }
  
  
  @Test
  public void fileupload() throws IOException, InterruptedException 
  {
	  WebDriverWait wait=new WebDriverWait(driver, 30);
	  wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//input[@id='1']"))));
	  
	  driver.findElement(By.xpath("//input[@id='1']")).click();
	  Thread.sleep(3000);
	  
	  
	  //Runtime.getRuntime().exec("D:\\uploadupdated.exe");
	  Runtime.getRuntime().exec("C:\\Users\\DELL\\Desktop\\upload.exe");
  }

  @AfterMethod
  public void afterMethod()
  {
	  //driver.quit();
  }

}
