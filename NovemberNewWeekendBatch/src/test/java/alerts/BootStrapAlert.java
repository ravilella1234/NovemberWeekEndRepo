package alerts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BootStrapAlert 
{
	static WebDriver driver;
	
	public static void main(String[] args) 
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\DELL\\Desktop\\Drivers\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.get("https://www.hdfcbank.com/");
		
		
		driver.findElement(By.className("popupCloseButton")).click();
		
		//WebDriverWait wait=new WebDriverWait(driver, 30);
		//wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id("div-close")))).click();
		
	}

}
