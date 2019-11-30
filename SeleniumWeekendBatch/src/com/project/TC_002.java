package com.project;

import org.apache.log4j.Logger;

import com.relevantcodes.extentreports.LogStatus;

public class TC_002 extends BaseTest
{

	private static final Logger log=Logger.getLogger(TC_002.class.getName());
	
	public static void main(String[] args) throws Exception 
	{
		test=reports.startTest("TC_002");
		
		init();
		log.info("Initializing properties files.....");
		test.log(LogStatus.PASS, "Initializing properties files.....");
		
		launch("chromebrowser");
		log.info("Opened the browser :- " + p.getProperty("chromebrowser"));
		test.log(LogStatus.PASS, "Opened the browser :- " + p.getProperty("chromebrowser"));
		
		
		navigateUrl("amazonurl");
		log.info("Navigated to url :- " + p.getProperty("amazonurl"));
		test.log(LogStatus.PASS, "Navigated to url :- " + p.getProperty("amazonurl"));
		
		
		selectOption("amazondropbox_id","amazondroptext");
		log.info("Selected the option :- " + or.getProperty("amazondroptext") + "  by using the locator :- " + or.getProperty("amazondropbox_id"));
		test.log(LogStatus.PASS, "Selected the option :- " + or.getProperty("amazondroptext") + "  by using the locator :- " + or.getProperty("amazondropbox_id"));
		
		
		typeValue("amazonsearchtext_id","amazonsearchtext");
		log.info("Entered the text :- "+ or.getProperty("amazonsearchtext") + " by using the locator :- " + or.getProperty("amazonsearchtext_id"));
		test.log(LogStatus.PASS, "Entered the text :- "+ or.getProperty("amazonsearchtext") + " by using the locator :- " + or.getProperty("amazonsearchtext_id"));
		
		
		clickElement("amazonsearchbutton_xpath");
		log.info("Clicked on element by using locator :- " + or.getProperty("amazonsearchbutton_xpath"));
		test.log(LogStatus.PASS, "Clicked on element by using locator :- " + or.getProperty("amazonsearchbutton_xpath"));
		
		reports.endTest(test);
		reports.flush();
		
		/*driver.findElement(By.id("searchDropdownBox")).sendKeys("Books");
		
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Harry Potter");
		
		driver.findElement(By.xpath("//div[@class='nav-search-submit nav-sprite']//input[@class='nav-input']")).click();
*/
	}

	

}
