package com.project;

import org.apache.log4j.Logger;

public class TC_003 extends BaseTest
{

	private static final Logger log=Logger.getLogger(TC_003.class.getName());
	
	public static void main(String[] args) throws Exception
	{
		init();
		log.info("Initializing properties files.....");
		
		launch("firefoxbrowser");
		log.info("Opened the browser :- " + p.getProperty("firefoxbrowser"));
		
		navigateUrl("bestbuyurl");
		log.info("Navigated to url :- " + p.getProperty("bestbuyurl"));

	}

}
