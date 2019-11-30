package com.project;

import org.openqa.selenium.By;

import com.relevantcodes.extentreports.LogStatus;

public class TC_004 extends BaseTest
{

	public static void main(String[] args) throws Exception 
	{
		test=reports.startTest("TC_002");
		
		init();
		test.log(LogStatus.PASS, "Initializing properties files.....");
		
		launch("chromebrowser");
		test.log(LogStatus.PASS, "Opened the browser :- " + p.getProperty("chromebrowser"));
		
		
		navigateUrl("amazonurl");
		test.log(LogStatus.PASS, "Navigated to url :- " + p.getProperty("amazonurl"));
		
		String expectedLink="AmazonBasic";
		if(!verifyElement(expectedLink))
			reportFailure("Both Links are not Equal....");
		else
			reportSuccess("Both links are equal....");
			
		
		

		
		reports.endTest(test);
		reports.flush();

	}

	

	

}
