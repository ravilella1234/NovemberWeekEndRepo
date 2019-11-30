package com.project.NovemberNewWeekendBatch;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.AfterMethod;

public class TC_007 extends BaseTest
{
	
   @BeforeMethod(groups = {"regression","sanity"})
   @Parameters("browser")
   public void beforeMethod(String btype) throws Exception 
   {
	    test=reports.startTest("TC_007");
		
		init();
		test.log(LogStatus.PASS, "Initializing properties files.....");
		
		launch(btype);
		test.log(LogStatus.PASS, "Opened the browser :- " + p.getProperty("chromebrowser"));
		
		
		navigateUrl("amazonurl");
		test.log(LogStatus.PASS, "Navigated to url :- " + p.getProperty("amazonurl"));
   }
	
	
  @Test(groups = {"regression","sanity"})
  public void amazon() 
  {
	    selectOption("amazondropbox_id","amazondroptext");
		test.log(LogStatus.PASS, "Selected the option :- " + or.getProperty("amazondroptext") + "  by using the locator :- " + or.getProperty("amazondropbox_id"));
		
		typeValue("amazonsearchtext_id","amazonsearchtext");
		test.log(LogStatus.PASS, "Entered the text :- "+ or.getProperty("amazonsearchtext") + " by using the locator :- " + or.getProperty("amazonsearchtext_id"));
		
		clickElement("amazonsearchbutton_xpath");
		test.log(LogStatus.PASS, "Clicked on element by using locator :- " + or.getProperty("amazonsearchbutton_xpath"));
  }
  
  
  @AfterMethod(groups = {"regression","sanity"})
  public void afterMethod()
  {
	  driver.quit();
	  
	  reports.endTest(test);
	  reports.flush();
  }

}
